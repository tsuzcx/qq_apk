import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.17.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aebi
  implements bfug
{
  public aebi(StructingMsgItemBuilder paramStructingMsgItemBuilder, Activity paramActivity, ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, String paramString, ArrayList paramArrayList) {}
  
  public void a(bfuf parambfuf)
  {
    Object localObject = new Dialog(this.jdField_a_of_type_AndroidAppActivity);
    ((Dialog)localObject).requestWindowFeature(1);
    ((Dialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((Dialog)localObject).setContentView(2131559458);
    ((Dialog)localObject).show();
    new Handler(this.jdField_a_of_type_AndroidAppActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.17.1(this, (Dialog)localObject), 1500L);
    aaod.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    int i;
    if ((((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment() != null) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment().a() != null))
    {
      ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if (((StructLongMessageDownloadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (StructLongMessageDownloadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
      {
        localObject = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForStructing)localObject).uniseq);
      }
      i = parambfuf.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
        break label534;
      }
    }
    label534:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId;; l = 0L)
    {
      i = parambfuf.jdField_a_of_type_Int;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8006320", "0X8006320", 0, 0, "" + l, "", "" + (i + 1), parambfuf.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= parambfuf.jdField_a_of_type_Int)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
        return;
      }
      localObject = (sev)this.jdField_a_of_type_JavaUtilArrayList.get(parambfuf.jdField_a_of_type_Int);
      parambfuf = new JSONObject();
      try
      {
        parambfuf.put("puin", ((sev)localObject).jdField_a_of_type_JavaLangString);
        parambfuf.put("type", ((sev)localObject).b);
        parambfuf.put("index", ((sev)localObject).c);
        parambfuf.put("name", ((sev)localObject).d);
        parambfuf.put("net", ((sev)localObject).e);
        parambfuf.put("mobile_imei", bbct.a());
        parambfuf.put("obj", "");
        parambfuf.put("gdt_cli_data", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("gdt_msgClick"));
        parambfuf.put("view_id", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("gdt_view_id"));
        ses.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.selfuin, parambfuf.toString(), "" + l);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aebi
 * JD-Core Version:    0.7.0.1
 */