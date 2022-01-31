import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

class aars
  implements Runnable
{
  aars(aarr paramaarr) {}
  
  public void run()
  {
    try
    {
      if ((ArkAiAppPanel.a(this.a.a) != null) && (ArkAiAppPanel.a(this.a.a).size() > 0) && (ArkAiAppPanel.a(this.a.a) < ArkAiAppPanel.a(this.a.a).size()))
      {
        if (ArkAiAppPanel.a(this.a.a).get(ArkAiAppPanel.a(this.a.a)) == null) {
          return;
        }
        Object localObject1 = ((ArkAioContainerWrapper)ArkAiAppPanel.a(this.a.a).get(ArkAiAppPanel.a(this.a.a))).getViewShare();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
          Object localObject2 = ((Document)localObject1).getElementsByTagName("View").item(0);
          if ((localObject2 != null) && (((Node)localObject2).getChildNodes().getLength() > 0) && ((((Node)localObject2).getFirstChild() instanceof Text)))
          {
            localObject2 = ((Node)localObject2).getFirstChild().getNodeValue();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = ((Document)localObject1).getElementsByTagName("Metadata").item(0);
              if ((localObject1 != null) && (((Node)localObject1).getChildNodes().getLength() > 0))
              {
                JSONObject localJSONObject = new JSONObject();
                if (ArkRecommendController.a(((Node)localObject1).getFirstChild(), localJSONObject))
                {
                  localObject1 = new ArkAppMessage();
                  ((ArkAppMessage)localObject1).appMinVersion = "0.0.0.1";
                  ((ArkAppMessage)localObject1).appName = ((ArkAioContainerWrapper)ArkAiAppPanel.a(this.a.a).get(ArkAiAppPanel.a(this.a.a))).getAppName();
                  if (!TextUtils.isEmpty(((ArkAppMessage)localObject1).appName))
                  {
                    ((ArkAppMessage)localObject1).appView = ((String)localObject2);
                    if (!TextUtils.isEmpty(((ArkAppMessage)localObject1).appView))
                    {
                      localObject2 = ArkAppCenter.a(((ArkAppMessage)localObject1).appName, ((ArkAppMessage)localObject1).appMinVersion);
                      if (localObject2 != null)
                      {
                        ((ArkAppMessage)localObject1).appDesc = ((String)((Map)localObject2).get("desc"));
                        ((ArkAppMessage)localObject1).appMinVersion = ((String)((Map)localObject2).get("version"));
                      }
                      if (TextUtils.isEmpty(((ArkAppMessage)localObject1).appDesc)) {
                        ((ArkAppMessage)localObject1).appDesc = ((ArkAppMessage)localObject1).appName;
                      }
                      ((ArkAppMessage)localObject1).promptText = String.format("[应用]%s", new Object[] { ((ArkAppMessage)localObject1).appDesc });
                      ((ArkAppMessage)localObject1).metaList = localJSONObject.toString();
                      localObject2 = new JSONObject();
                      ((JSONObject)localObject2).put("forward", 1);
                      ((JSONObject)localObject2).put("autosize", 1);
                      ((JSONObject)localObject2).put("type", "card");
                      ((ArkAppMessage)localObject1).config = ((JSONObject)localObject2).toString();
                      if (ArkAiAppPanel.a(this.a.a) != null)
                      {
                        localObject2 = ArkAiAppPanel.a(this.a.a).a();
                        if (localObject2 != null) {
                          ChatActivityFacade.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject2, (ArkAppMessage)localObject1);
                        }
                      }
                      ArkAppDataReport.a(null, ((ArkAppMessage)localObject1).appName);
                      return;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 1, "ArkAIAppPanel send message parameter error: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aars
 * JD-Core Version:    0.7.0.1
 */