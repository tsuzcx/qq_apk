import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

class afsz
  implements DialogInterface.OnClickListener
{
  afsz(afsw paramafsw, bdct parambdct, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bdct.a("video_tab", "clk_joinframe_join", 0, afsw.a(this.jdField_a_of_type_Afsw).getCurFriendUin());
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_Bdct.a(2, 1, afsw.a(this.jdField_a_of_type_Afsw).getCurFriendUin());
    if ((paramDialogInterface == null) || (paramDialogInterface.g == 3))
    {
      QQToast.a(afsw.a(this.jdField_a_of_type_Afsw), 0, this.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    afsw.b(this.jdField_a_of_type_Afsw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsz
 * JD-Core Version:    0.7.0.1
 */