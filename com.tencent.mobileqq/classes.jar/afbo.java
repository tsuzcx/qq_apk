import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class afbo
  extends AsyncTask<Void, Void, Void>
{
  WeakReference<RegisterVerifyCodeActivity> a = null;
  
  public afbo(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity)
  {
    this.a = new WeakReference(paramRegisterVerifyCodeActivity);
  }
  
  protected Void a(Void... paramVarArgs)
  {
    boolean bool3 = true;
    File localFile = new File(BaseApplication.getContext().getFilesDir(), "RegDevLockCfg.xml");
    if (!HttpDownloadUtil.a(null, "https://dldir1.qq.com/qqfile/qd/RegDevLockCfg.xml?mType=ConfigCheck", localFile))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "download cfg file failed.");
      }
      return null;
    }
    paramVarArgs = DocumentBuilderFactory.newInstance();
    label524:
    label530:
    label536:
    label542:
    label547:
    label553:
    label558:
    label563:
    for (;;)
    {
      try
      {
        localObject3 = paramVarArgs.newDocumentBuilder().parse(localFile).getDocumentElement();
        paramVarArgs = ((Element)localObject3).getElementsByTagName("Enable");
        if (paramVarArgs.getLength() <= 0) {
          break label553;
        }
        if (Integer.parseInt(((Text)((Element)paramVarArgs.item(0)).getChildNodes().item(0)).getNodeValue()) == 1)
        {
          bool1 = true;
          break label558;
          paramVarArgs = ((Element)localObject3).getElementsByTagName("EnableVersion");
          if (paramVarArgs.getLength() <= 0) {
            break label547;
          }
          paramVarArgs = ((Text)((Element)paramVarArgs.item(0)).getChildNodes().item(0)).getNodeValue();
          localObject1 = ((Element)localObject3).getElementsByTagName("CheckBoxDefStatus");
          if (((NodeList)localObject1).getLength() <= 0) {
            break label542;
          }
          if (Integer.parseInt(((Text)((Element)((NodeList)localObject1).item(0)).getChildNodes().item(0)).getNodeValue()) == 1)
          {
            bool1 = bool3;
            break label563;
            localObject1 = ((Element)localObject3).getElementsByTagName("CheckBoxWording");
            if (((NodeList)localObject1).getLength() <= 0) {
              break label536;
            }
            localObject1 = ((Text)((Element)((NodeList)localObject1).item(0)).getChildNodes().item(0)).getNodeValue();
            localObject2 = ((Element)localObject3).getElementsByTagName("CheckBoxHighlightWording");
            if (((NodeList)localObject2).getLength() <= 0) {
              break label530;
            }
            localObject2 = ((Text)((Element)((NodeList)localObject2).item(0)).getChildNodes().item(0)).getNodeValue();
            localObject3 = ((Element)localObject3).getElementsByTagName("IntroductionURL");
            if (((NodeList)localObject3).getLength() <= 0) {
              break label524;
            }
            localObject3 = ((Text)((Element)((NodeList)localObject3).item(0)).getChildNodes().item(0)).getNodeValue();
            Bundle localBundle = new Bundle();
            localBundle.putBoolean("visibility", bool2);
            localBundle.putString("enableVersion", paramVarArgs);
            localBundle.putBoolean("checked", bool1);
            localBundle.putString("openDevLockText", (String)localObject1);
            localBundle.putString("openDevLockHelpText", (String)localObject2);
            localBundle.putString("openDevLockHelpURL", (String)localObject3);
            paramVarArgs = (RegisterVerifyCodeActivity)this.a.get();
            return null;
          }
        }
        else
        {
          bool1 = false;
          break label558;
        }
        bool1 = false;
      }
      catch (Exception paramVarArgs)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RegisterVerifyCodeActivity", 2, "parse cfg file failed.");
        }
        paramVarArgs.printStackTrace();
        return null;
      }
      finally
      {
        localFile.delete();
      }
      Object localObject3 = null;
      continue;
      Object localObject2 = null;
      continue;
      Object localObject1 = null;
      continue;
      boolean bool1 = false;
      continue;
      paramVarArgs = "";
      continue;
      boolean bool2 = false;
      continue;
      bool2 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbo
 * JD-Core Version:    0.7.0.1
 */