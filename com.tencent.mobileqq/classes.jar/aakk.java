import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

class aakk
  implements Runnable
{
  aakk(aakj paramaakj) {}
  
  public void run()
  {
    int j = 1;
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == null)
      {
        ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
        return;
      }
      ArkAppMessage localArkAppMessage = new ArkAppMessage();
      localArkAppMessage.appMinVersion = "0.0.0.1";
      localArkAppMessage.appName = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.getAppName();
      if (!TextUtils.isEmpty(localArkAppMessage.appName)) {
        break label157;
      }
      ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
      return;
    }
    catch (Exception localException)
    {
      ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
      if (!QLog.isColorLevel()) {
        break label828;
      }
    }
    QLog.d("ArkAdapterItemForTextMsg", 2, "setSendClick parse ark app exception=" + localException);
    return;
    label157:
    Object localObject1 = ArkAppCenter.a(localException.appName, localException.appMinVersion);
    if (localObject1 != null)
    {
      localException.appDesc = ((String)((Map)localObject1).get("desc"));
      localException.appMinVersion = ((String)((Map)localObject1).get("version"));
    }
    if (TextUtils.isEmpty(localException.appDesc)) {
      localException.appDesc = localException.appName;
    }
    localException.promptText = String.format("[应用]%s", new Object[] { localException.appDesc });
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("forward", 1);
    ((JSONObject)localObject1).put("autosize", 1);
    ((JSONObject)localObject1).put("type", "card");
    localException.config = ((JSONObject)localObject1).toString();
    localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.getViewShare();
    Object localObject2;
    int i;
    label679:
    String str2;
    String str3;
    String str1;
    String str4;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
      localObject2 = ((Document)localObject1).getElementsByTagName("View").item(0);
      if ((localObject2 != null) && (((Node)localObject2).getChildNodes().getLength() > 0) && ((((Node)localObject2).getFirstChild() instanceof Text)))
      {
        localObject2 = ((Node)localObject2).getFirstChild().getNodeValue();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localException.appView = ((String)localObject2);
          if (!TextUtils.isEmpty(localException.appView))
          {
            localObject1 = ((Document)localObject1).getElementsByTagName("Metadata").item(0);
            if ((localObject1 != null) && (((Node)localObject1).getChildNodes().getLength() > 0))
            {
              localObject2 = new JSONObject();
              if (ArkRecommendController.a(((Node)localObject1).getFirstChild(), (JSONObject)localObject2))
              {
                localException.metaList = ((JSONObject)localObject2).toString();
                i = 1;
                if (i == 0)
                {
                  if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView)) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta)))
                  {
                    localException.appView = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView;
                    localException.metaList = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta;
                  }
                }
                else
                {
                  localObject1 = ((FragmentActivity)this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a).getChatFragment().a();
                  if (localObject1 == null) {
                    break label802;
                  }
                  localObject2 = ((BaseChatPie)localObject1).a();
                  if ((localObject2 == null) || (((BaseChatPie)localObject1).a == null)) {
                    break label802;
                  }
                  ChatActivityFacade.b(((BaseChatPie)localObject1).a, (SessionInfo)localObject2, localException);
                  ArkAppDataReport.e(((BaseChatPie)localObject1).a, localException.appName);
                  localObject1 = (ArkAppHandler)((BaseChatPie)localObject1).a.a(95);
                  if (!this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.isFromArkServer) {
                    break label829;
                  }
                  i = 2;
                  localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerExtraInfo;
                  str2 = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerMsgId;
                  str3 = localException.appName;
                  str1 = localException.appView;
                  str4 = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.msg;
                  if (!"1".equals(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
                    break label835;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((ArkAppHandler)localObject1).a(i, 5, 2, (String)localObject2, str2, str3, str1, str4, j, 0);
      return;
      ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
      return;
      label802:
      ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
      return;
      i = 0;
      break;
      label828:
      return;
      label829:
      i = 100;
      break label679;
      label835:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakk
 * JD-Core Version:    0.7.0.1
 */