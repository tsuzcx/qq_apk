import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

class agkn
  implements DialogInterface.OnClickListener
{
  agkn(agkk paramagkk, bejv parambejv, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bejv.a("video_tab", "clk_joinframe_join", 0, agkk.a(this.jdField_a_of_type_Agkk).getCurFriendUin());
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_Bejv.a(2, 1, agkk.a(this.jdField_a_of_type_Agkk).getCurFriendUin());
    if ((paramDialogInterface == null) || (paramDialogInterface.h == 3))
    {
      QQToast.a(agkk.a(this.jdField_a_of_type_Agkk), 0, this.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    agkk.b(this.jdField_a_of_type_Agkk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkn
 * JD-Core Version:    0.7.0.1
 */