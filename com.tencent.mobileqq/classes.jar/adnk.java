import android.content.Context;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

final class adnk
  implements adnt
{
  adnk(ETTextView paramETTextView1, ETTextView paramETTextView2, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, int paramInt, String paramString, MessageRecord paramMessageRecord, Context paramContext) {}
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString)
  {
    if ((paramView instanceof ChatThumbView))
    {
      if (paramMessageRecord2 == null) {
        break label154;
      }
      if ((!(paramMessageRecord2 instanceof MessageForText)) || (((MessageForText)paramMessageRecord2).msg == null)) {
        break label84;
      }
      adni.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.b, 1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText, paramMessageRecord2);
      QLog.e("ReplyTextItemBuilder", 1, "returned text msg error!" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText);
    }
    label84:
    do
    {
      return;
      if (((paramMessageRecord1 instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord1).getSourceMessage() != null)) {
        ((MessageForReplyText)paramMessageRecord1).setSourceMessageRecord(paramMessageRecord2);
      }
      adni.a(paramMessageRecord2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface, paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "processReplyMsg:source msg has been deleted.");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView == null);
    label154:
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    adni.a(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null);
    adni.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.b, 1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnk
 * JD-Core Version:    0.7.0.1
 */