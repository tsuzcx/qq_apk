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

public class ahzq
  implements bapx
{
  private long jdField_a_of_type_Long;
  @NonNull
  private ahzp jdField_a_of_type_Ahzp;
  private bapv jdField_a_of_type_Bapv;
  private final ChatHistoryTroopLinkFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ahzq(QQAppInterface paramQQAppInterface, ChatHistoryTroopLinkFragment paramChatHistoryTroopLinkFragment, @NonNull ahzp paramahzp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment = paramChatHistoryTroopLinkFragment;
    this.jdField_a_of_type_Bapv = ((baqu)paramQQAppInterface.getManager(21)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_Ahzp = paramahzp;
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
  
  private void a(baqw parambaqw)
  {
    try
    {
      parambaqw = new JSONObject(new String(parambaqw.jdField_a_of_type_ArrayOfByte));
      if (QLog.isColorLevel()) {
        QLog.i("TroopLinkHandler", 2, "resolveResponse: invoked.  json: " + parambaqw);
      }
      a(true, a(parambaqw));
      a(parambaqw);
      return;
    }
    catch (Exception parambaqw)
    {
      QLog.e("TroopLinkHandler", 1, "resolveResponse: failed. ", parambaqw);
      a(false, new ArrayList());
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_JavaLangString = "http://qun.qq.com/cgi-bin/groupchat_url_collect/get_url_collect";
    localbaps.jdField_a_of_type_Int = 1;
    localbaps.e = 0;
    localbaps.jdField_a_of_type_Bapx = this;
    String str = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    paramString = String.format("bkn=%s&gc=%s&seq=%s&n=%s&noui=1", new Object[] { Integer.valueOf(bclo.b(str)), paramString, Long.valueOf(paramLong), Integer.valueOf(200) });
    if (QLog.isColorLevel()) {
      QLog.i("TroopLinkHandler", 2, "send: invoked.  postData: " + paramString);
    }
    str = "uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + ";skey=" + str;
    localbaps.jdField_a_of_type_ArrayOfByte = paramString.getBytes();
    localbaps.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    localbaps.jdField_a_of_type_JavaUtilHashMap.put("Cookie", str);
    this.jdField_a_of_type_Bapv.a(localbaps);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Long = paramJSONObject.optLong("seq");
    long l = paramJSONObject.optLong("n_all", -1L);
    if ((this.jdField_a_of_type_Long == 0L) || (l == 0L)) {
      this.jdField_a_of_type_Ahzp.q();
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
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.c == 200)
    {
      a(parambaqw);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopLinkHandler", 2, "onResp: invoked.  resp: " + parambaqw);
    }
    a(false, new ArrayList());
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzq
 * JD-Core Version:    0.7.0.1
 */