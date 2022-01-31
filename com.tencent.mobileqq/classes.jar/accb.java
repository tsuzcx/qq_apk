import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;

public class accb
  implements DialogInterface.OnClickListener
{
  public accb(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo, ConfessChatPie paramConfessChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a(0, "正在屏蔽...", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accb
 * JD-Core Version:    0.7.0.1
 */