import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.QLog;

public class aghs
  extends bbri
{
  public aghs(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void handlePendantAuth(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    long l = paramObject.getLong("pendantId");
    paramObject.getInt("seriesId");
    Object localObject = paramObject.getString("uin");
    int i = paramObject.getInt("result");
    if ((l == -1L) || (localObject == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label472;
      }
      if (l != 0L) {
        break;
      }
      this.a.b.setVisibility(4);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.a.jdField_a_of_type_Bbod != null) {
        this.a.jdField_a_of_type_Bbod.c = -1;
      }
      axqy.b(this.a.app, "CliOper", "", "", "0X8005FD4", "0X8005FD4", 0, 0, "", "", "", "");
      if ((this.a.jdField_a_of_type_Ailf != null) && (this.a.jdField_a_of_type_JavaUtilList != null))
      {
        paramObject = ((AvatarPendantManager)this.a.app.getManager(46)).a();
        this.a.jdField_a_of_type_Ailf.a(paramObject, this.a.jdField_a_of_type_JavaUtilList);
      }
    } while ((this.a.jdField_a_of_type_Bboc == null) || (!this.a.jdField_a_of_type_Bboc.jdField_a_of_type_Boolean));
    localObject = bbqd.a("linkPendantSet");
    paramObject = localObject;
    if (localObject != null) {
      paramObject = ((String)localObject).replace("[id]", String.valueOf(this.a.jdField_a_of_type_Bboc.jdField_a_of_type_Int));
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantActivity", 2, "handlePendantAuth, mPendantInfo.isLink == true, jump to url =" + paramObject);
    }
    localObject = new Intent(this.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramObject);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("webStyle", "noBottomBar");
    this.a.startActivity((Intent)localObject);
    axqy.b(this.a.app, "CliOper", "", "", "0X8006517", "0X8006517", 0, 0, "", "", "", "");
    return;
    this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131719368);
    this.a.b.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    localObject = this.a.app;
    if (this.a.d) {}
    for (paramObject = "1";; paramObject = "0")
    {
      axqy.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005FD6", "0X8005FD6", 0, 0, paramObject, "", "", "");
      if (!this.a.d) {
        break;
      }
      this.a.d = false;
      break;
    }
    label472:
    paramObject = (PendantTipsInfo)paramObject.getSerializable("tipsInfo");
    if (paramObject != null)
    {
      this.a.a(paramObject, l, i);
      return;
    }
    QLog.e("AvatarPendantActivity", 1, "handlePendantAuth, tipsInfo == null, pendantId = " + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghs
 * JD-Core Version:    0.7.0.1
 */