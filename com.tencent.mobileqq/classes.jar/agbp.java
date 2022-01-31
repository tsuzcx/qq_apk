import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.TroopLinkHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class agbp
  implements aysa
{
  private long jdField_a_of_type_Long;
  @NonNull
  private agbo jdField_a_of_type_Agbo;
  private ayry jdField_a_of_type_Ayry;
  private final ChatHistoryTroopLinkFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agbp(QQAppInterface paramQQAppInterface, ChatHistoryTroopLinkFragment paramChatHistoryTroopLinkFragment, @NonNull agbo paramagbo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment = paramChatHistoryTroopLinkFragment;
    this.jdField_a_of_type_Ayry = ((aysv)paramQQAppInterface.getManager(21)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_Agbo = paramagbo;
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
  
  private void a(aysx paramaysx)
  {
    try
    {
      paramaysx = new JSONObject(new String(paramaysx.jdField_a_of_type_ArrayOfByte));
      if (QLog.isColorLevel()) {
        QLog.i("TroopLinkHandler", 2, "resolveResponse: invoked.  json: " + paramaysx);
      }
      a(true, a(paramaysx));
      a(paramaysx);
      return;
    }
    catch (Exception paramaysx)
    {
      QLog.e("TroopLinkHandler", 1, "resolveResponse: failed. ", paramaysx);
      a(false, new ArrayList());
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_JavaLangString = "http://qun.qq.com/cgi-bin/groupchat_url_collect/get_url_collect";
    localayrv.jdField_a_of_type_Int = 1;
    localayrv.e = 0;
    localayrv.jdField_a_of_type_Aysa = this;
    String str = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    paramString = String.format("bkn=%s&gc=%s&seq=%s&n=%s&noui=1", new Object[] { Integer.valueOf(bamn.b(str)), paramString, Long.valueOf(paramLong), Integer.valueOf(200) });
    if (QLog.isColorLevel()) {
      QLog.i("TroopLinkHandler", 2, "send: invoked.  postData: " + paramString);
    }
    str = "uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + ";skey=" + str;
    localayrv.jdField_a_of_type_ArrayOfByte = paramString.getBytes();
    localayrv.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    localayrv.jdField_a_of_type_JavaUtilHashMap.put("Cookie", str);
    this.jdField_a_of_type_Ayry.a(localayrv);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Long = paramJSONObject.optLong("seq");
    long l = paramJSONObject.optLong("n_all", -1L);
    if ((this.jdField_a_of_type_Long == 0L) || (l == 0L)) {
      this.jdField_a_of_type_Agbo.q();
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
  
  public void onResp(aysx paramaysx)
  {
    if (paramaysx.c == 200)
    {
      a(paramaysx);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopLinkHandler", 2, "onResp: invoked.  resp: " + paramaysx);
    }
    a(false, new ArrayList());
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbp
 * JD-Core Version:    0.7.0.1
 */