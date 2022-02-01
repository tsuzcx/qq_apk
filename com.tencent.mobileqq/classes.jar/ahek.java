import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahek
  implements View.OnClickListener
{
  ahek(ahed paramahed, MessageRecord paramMessageRecord, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = mvd.a(this.jdField_a_of_type_Ahed.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
    bdll.b(null, "CliOper", "", "", "0X800A8D8", "0X800A8D8", this.jdField_a_of_type_Int, 0, "", "", "", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + (String)localObject));
      paramView.getContext().startActivity((Intent)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2131695099, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahek
 * JD-Core Version:    0.7.0.1
 */