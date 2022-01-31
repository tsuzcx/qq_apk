import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public final class aihj
  implements ActionSheet.OnButtonClickListener
{
  public aihj(String paramString, Context paramContext) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      StructMsgClickHandler.a().dismiss();
      return;
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      continue;
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihj
 * JD-Core Version:    0.7.0.1
 */