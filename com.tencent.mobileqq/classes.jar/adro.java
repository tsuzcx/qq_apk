import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;

class adro
  implements View.OnClickListener
{
  adro(adqw paramadqw, MessageRecord paramMessageRecord, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = muc.a(this.jdField_a_of_type_Adqw.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
    axqy.b(null, "CliOper", "", "", "0X800A8D8", "0X800A8D8", this.jdField_a_of_type_Int, 0, "", "", "", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + (String)localObject));
      paramView.getContext().startActivity((Intent)localObject);
      return;
    }
    bcql.a(BaseApplicationImpl.getContext(), 2131696013, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adro
 * JD-Core Version:    0.7.0.1
 */