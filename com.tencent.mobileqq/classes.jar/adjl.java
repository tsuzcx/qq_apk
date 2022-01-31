import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

final class adjl
  implements DialogInterface.OnClickListener
{
  adjl(Emoticon paramEmoticon, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4)
    {
      bool = true;
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, false, bool);
      if (adje.a != null)
      {
        if (7 != this.jdField_a_of_type_Int) {
          break label80;
        }
        adje.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, adje.a.frienduin, "ep_mall", "Clk_pkg_forward", 0);
      }
    }
    label80:
    while (6 != this.jdField_a_of_type_Int)
    {
      return;
      bool = false;
      break;
    }
    adje.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, adje.a.frienduin, "ep_mall", "Clk_collect_more", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjl
 * JD-Core Version:    0.7.0.1
 */