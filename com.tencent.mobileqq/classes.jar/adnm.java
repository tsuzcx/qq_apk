import android.content.Context;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.BubbleImageView;

final class adnm
  implements adnt
{
  adnm(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord) {}
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString)
  {
    if ((paramMessageRecord2 != null) && (adni.b(paramMessageRecord2)))
    {
      if (((paramMessageRecord1 instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord1).getSourceMessage() == null)) {
        ((MessageForReplyText)paramMessageRecord1).setSourceMessageRecord(paramMessageRecord2);
      }
      adni.a(paramMessageRecord2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramContext, paramQQAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnm
 * JD-Core Version:    0.7.0.1
 */