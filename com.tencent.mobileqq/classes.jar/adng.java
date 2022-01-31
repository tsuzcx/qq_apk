import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import java.util.HashMap;
import mqq.app.NewIntent;

class adng
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = this.jdField_b_of_type_Int;
  boolean jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
  
  adng(adnd paramadnd, boolean paramBoolean, int paramInt1, adnh paramadnh, String paramString, int paramInt2, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    boolean bool;
    label53:
    int i;
    label71:
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label316;
      }
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Adnh.i.setText(adnd.a(this.jdField_a_of_type_Int));
      paramView = this.jdField_a_of_type_Adnh.d;
      if (!this.jdField_a_of_type_Boolean) {
        break label347;
      }
      i = 2130846418;
      paramView.setImageResource(i);
      long l = this.jdField_a_of_type_Adnd.a.getLongAccountUin();
      paramView = this.jdField_a_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_JavaLangString;
      i = j;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      }
      paramView = new bfun(Long.valueOf(l), paramView, (String)localObject, i, this.c);
      paramView.a(100);
      localObject = new QzoneCommonIntent(this.jdField_a_of_type_Adnd.a.getApplication(), amtm.class);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("like_key", this.jdField_a_of_type_Boolean);
      ((QzoneCommonIntent)localObject).putExtras(localBundle);
      ((QzoneCommonIntent)localObject).setRequest(paramView);
      this.jdField_a_of_type_Adnd.a.startServlet((NewIntent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.ulikeNum = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt = new HashMap();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt;
      if (!this.jdField_a_of_type_Boolean) {
        break label353;
      }
    }
    label316:
    label347:
    label353:
    for (paramView = "1";; paramView = "0")
    {
      ((HashMap)localObject).put("isliked", paramView);
      this.jdField_a_of_type_Adnd.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed, false);
      this.jdField_a_of_type_Adnd.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.selfuin);
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Int -= 1;
      this.jdField_a_of_type_Adnh.i.setText(adnd.a(this.jdField_a_of_type_Int));
      break label53;
      i = 2130846417;
      break label71;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adng
 * JD-Core Version:    0.7.0.1
 */