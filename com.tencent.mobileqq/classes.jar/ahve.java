import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment;
import com.tencent.mobileqq.data.MessageRecord;

class ahve
  implements View.OnClickListener
{
  ahve(ahvc paramahvc, String paramString, ahvh paramahvh, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!this.jdField_a_of_type_Ahvc.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.c) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramView = null;
        int i = this.jdField_a_of_type_JavaLangString.lastIndexOf("#");
        if (i > 0) {
          paramView = this.jdField_a_of_type_JavaLangString.substring(i);
        }
        localObject = URLUtil.guessUrl(this.jdField_a_of_type_JavaLangString);
        if (paramView == null) {
          break label171;
        }
      }
    }
    label171:
    for (paramView = (String)localObject + paramView;; paramView = (View)localObject)
    {
      localObject = new Intent(this.jdField_a_of_type_Ahvc.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Ahvc.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
      boolean bool = ahvh.a(this.jdField_a_of_type_Ahvh).isChecked();
      ahvc.a(this.jdField_a_of_type_Ahvc).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramView = ahvh.a(this.jdField_a_of_type_Ahvh);
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahve
 * JD-Core Version:    0.7.0.1
 */