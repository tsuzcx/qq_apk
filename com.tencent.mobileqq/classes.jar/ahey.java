import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.contentbox.model.QZoneLikeReq;
import java.util.HashMap;
import mqq.app.NewIntent;

class ahey
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = this.jdField_b_of_type_Int;
  boolean jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
  
  ahey(ahev paramahev, boolean paramBoolean, int paramInt1, ahez paramahez, String paramString, int paramInt2, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    boolean bool;
    label53:
    int i;
    label72:
    Object localObject2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label332;
      }
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Ahez.i.setText(ahev.a(this.jdField_a_of_type_Int));
      localObject1 = this.jdField_a_of_type_Ahez.d;
      if (!this.jdField_a_of_type_Boolean) {
        break label363;
      }
      i = 2130847530;
      ((ImageView)localObject1).setImageResource(i);
      long l = this.jdField_a_of_type_Ahev.a.getLongAccountUin();
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      i = j;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      }
      localObject1 = new QZoneLikeReq(Long.valueOf(l), (String)localObject1, (String)localObject2, i, this.c);
      ((QZoneLikeReq)localObject1).setType(100);
      localObject2 = new QzoneCommonIntent(this.jdField_a_of_type_Ahev.a.getApplication(), arvg.class);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("like_key", this.jdField_a_of_type_Boolean);
      ((QzoneCommonIntent)localObject2).putExtras(localBundle);
      ((QzoneCommonIntent)localObject2).setRequest((QZoneCommonRequest)localObject1);
      this.jdField_a_of_type_Ahev.a.startServlet((NewIntent)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.ulikeNum = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt = new HashMap();
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt;
      if (!this.jdField_a_of_type_Boolean) {
        break label369;
      }
    }
    label332:
    label363:
    label369:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ((HashMap)localObject2).put("isliked", localObject1);
      this.jdField_a_of_type_Ahev.a.getMessageFacade().removeMsgByMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed, false);
      this.jdField_a_of_type_Ahev.a.getMessageFacade().addMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.selfuin);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Int -= 1;
      this.jdField_a_of_type_Ahez.i.setText(ahev.a(this.jdField_a_of_type_Int));
      break label53;
      i = 2130847529;
      break label72;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahey
 * JD-Core Version:    0.7.0.1
 */