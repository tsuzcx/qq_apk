import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.TroopLinkHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajwr
  implements INetEngine.INetEngineListener
{
  private long jdField_a_of_type_Long;
  @NonNull
  private ajwq jdField_a_of_type_Ajwq;
  private final ChatHistoryTroopLinkFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  
  public ajwr(QQAppInterface paramQQAppInterface, ChatHistoryTroopLinkFragment paramChatHistoryTroopLinkFragment, @NonNull ajwq paramajwq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment = paramChatHistoryTroopLinkFragment;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = ((NetEngineFactory)paramQQAppInterface.getManager(QQManagerFactory.MGR_NET_ENGINE)).getEngineInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_Ajwq = paramajwq;
  }
  
  private ArrayList<TroopLinkElement> a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("url_list");
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      localArrayList.add(TroopLinkElement.mergeFromJson(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment.a(), localJSONObject));
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(NetResp paramNetResp)
  {
    try
    {
      paramNetResp = new JSONObject(new String(paramNetResp.mRespData));
      if (QLog.isColorLevel()) {
        QLog.i("TroopLinkHandler", 2, "resolveResponse: invoked.  json: " + paramNetResp);
      }
      a(true, a(paramNetResp));
      a(paramNetResp);
      return;
    }
    catch (Exception paramNetResp)
    {
      QLog.e("TroopLinkHandler", 1, "resolveResponse: failed. ", paramNetResp);
      a(false, new ArrayList());
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = "https://qun.qq.com/cgi-bin/groupchat_url_collect/get_url_collect";
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mCallback = this;
    String str = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    paramString = String.format("bkn=%s&gc=%s&seq=%s&n=%s&noui=1", new Object[] { Integer.valueOf(TroopUtils.getBknBySkey(str)), paramString, Long.valueOf(paramLong), Integer.valueOf(200) });
    if (QLog.isColorLevel()) {
      QLog.i("TroopLinkHandler", 2, "send: invoked.  postData: " + paramString);
    }
    str = "uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + ";skey=" + str;
    localHttpNetReq.mSendData = paramString.getBytes();
    localHttpNetReq.mReqProperties = new HashMap();
    localHttpNetReq.mReqProperties.put("Cookie", str);
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.sendReq(localHttpNetReq);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Long = paramJSONObject.optLong("seq");
    long l = paramJSONObject.optLong("n_all", -1L);
    if ((this.jdField_a_of_type_Long == 0L) || (l == 0L)) {
      this.jdField_a_of_type_Ajwq.r();
    }
  }
  
  @UiThread
  private void a(boolean paramBoolean, @NonNull List<TroopLinkElement> paramList)
  {
    paramList = new TroopLinkHandler.1(this, paramBoolean, paramList);
    ThreadManager.getUIHandler().post(paramList);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramString, this.jdField_a_of_type_Long);
      return;
    }
    a(paramString, 0L);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mHttpCode == 200)
    {
      a(paramNetResp);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopLinkHandler", 2, "onResp: invoked.  resp: " + paramNetResp);
    }
    a(false, new ArrayList());
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwr
 * JD-Core Version:    0.7.0.1
 */