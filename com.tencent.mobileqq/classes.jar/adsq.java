import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.lang.ref.WeakReference;

class adsq
  extends ClickableSpan
{
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  adsq(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (Context)this.b.get();
    if ((paramView == null) || (localObject == null)) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          axqw.b(paramView, "dc00898", "", "", "0X800906D", "0X800906D", 0, 0, "", "", "", "");
        } while (!(localObject instanceof Activity));
        if (!bbev.d((Context)localObject))
        {
          bcpw.a((Context)localObject, 2131692321, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298865));
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (this.b.get() == null));
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_team_work_ext_info_new_url");
      bool = Boolean.parseBoolean(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("team_work_is_message_convert"));
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Bundle localBundle = new Bundle();
    localBundle.putString("url", (String)localObject);
    localBundle.putString("tdsourcetag", "s_qq_aio_grey");
    TeamWorkDocEditBrowserActivity.a((Context)this.b.get(), localBundle, false);
    if (!bool)
    {
      axqw.b(paramView, "CliOper", "", "", "0X8008A35", "0X8008A35", 0, 0, "", "", "", "");
      return;
    }
    axqw.b(paramView, "CliOper", "", "", "0X8009075", "0X8009075", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsq
 * JD-Core Version:    0.7.0.1
 */