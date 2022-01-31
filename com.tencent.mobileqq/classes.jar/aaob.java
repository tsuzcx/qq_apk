import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper.IMECommandListener.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public class aaob
  implements bfwr
{
  private anws jdField_a_of_type_Anws;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public aaob(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anws != null) {
      this.jdField_a_of_type_Anws.a();
    }
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), action:" + paramString);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
    XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null) && (bfmr.a((Context)localObject1)))
    {
      if ((!"com.sogou.inputmethod.expression".equals(paramString)) && (!"com.tencent.qqpinyin.expression".equals(paramString))) {
        break label194;
      }
      if (!"com.sogou.inputmethod.expression".equals(paramString)) {
        break label180;
      }
      paramString = paramBundle.getString("SOGOU_EXP_PATH");
      i = 1034;
      if (QLog.isColorLevel()) {
        QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), path:" + paramString + ", busiType = " + i);
      }
      if (!TextUtils.isEmpty(paramString)) {
        aaod.a((QQAppInterface)localObject2, (Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, i);
      }
    }
    label180:
    label194:
    do
    {
      do
      {
        return true;
        paramString = paramBundle.getString("QQINPUT_EXP_PATH");
        i = 1038;
        break;
        if ("com.sogou.inputmethod.appid".equals(paramString))
        {
          localObject3 = paramBundle.getString("SOGOU_APP_ID");
          String str = ((QQAppInterface)localObject2).getCurrentAccountUin();
          paramString = bdem.a(((QQAppInterface)localObject2).getApp(), str, (String)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), appId:" + (String)localObject3 + "selfUin:" + str + "openId:" + paramString);
          }
          localObject1 = (InputMethodManager)((Context)localObject1).getSystemService("input_method");
          if (localObject1 != null)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("SOGOU_OPENID", paramString);
            ((InputMethodManager)localObject1).sendAppPrivateCommand(localXEditTextEx, "com.tencent.mobileqq.sogou.openid", (Bundle)localObject2);
          }
          paramString = paramBundle.getStringArrayList("EXP_ALL_PACKID");
          if (this.jdField_a_of_type_Anws == null) {
            this.jdField_a_of_type_Anws = new anws(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          }
          this.jdField_a_of_type_Anws.a(paramString);
          return true;
        }
        if (("com.sogou.inputmethod.qqexp".equals(paramString)) || ("com.tencent.qqpinyin.qqexp".equals(paramString)))
        {
          i = paramBundle.getInt("PACKAGE_ID");
          paramString = paramBundle.getString("EXP_ID");
          paramBundle = paramBundle.getString("EXP_PATH");
          if (QLog.isColorLevel()) {
            QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), packId:" + i + ",exprId:" + paramString + ",ePath:" + paramBundle);
          }
          if (this.jdField_a_of_type_Anws == null) {
            this.jdField_a_of_type_Anws = new anws(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          }
          this.jdField_a_of_type_Anws.a(i, paramString);
          return true;
        }
      } while (!"com.tencent.mobileqq_audioArgs".equals(paramString));
      paramString = paramBundle.getString("PCMFilePath");
      i = paramBundle.getInt("SampleRate");
      int j = paramBundle.getInt("Channels");
      Object localObject3 = (QQRecorder.RecorderParam)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a;
      paramBundle = paramBundle.getString("InputMethodName");
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "recv args from sogou, pcmPath = " + paramString + " sampleRate = " + i + " channels = " + j + " inputName = " + paramBundle + " my sampleRate = " + ((QQRecorder.RecorderParam)localObject3).a);
      }
      if ((i == ((QQRecorder.RecorderParam)localObject3).a) && (!bbjw.a(paramString))) {
        break label644;
      }
    } while (!QLog.isColorLevel());
    QLog.d("sougouptt", 2, "invalid datas from sougou ");
    return true;
    label644:
    ThreadManager.getSubThreadHandler().post(new BaseChatpieHelper.IMECommandListener.1(this, (QQAppInterface)localObject2, paramString, i, paramBundle, (Context)localObject1, localXEditTextEx));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaob
 * JD-Core Version:    0.7.0.1
 */