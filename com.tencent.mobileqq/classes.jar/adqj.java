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

public class adqj
  implements bemm
{
  public adqj(StructingMsgItemBuilder paramStructingMsgItemBuilder, Activity paramActivity, ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, String paramString, ArrayList paramArrayList) {}
  
  public void a(beml parambeml)
  {
    Object localObject = new Dialog(this.jdField_a_of_type_AndroidAppActivity);
    ((Dialog)localObject).requestWindowFeature(1);
    ((Dialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((Dialog)localObject).setContentView(2131493890);
    ((Dialog)localObject).show();
    new Handler(this.jdField_a_of_type_AndroidAppActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.17.1(this, (Dialog)localObject), 1500L);
    aael.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    int i;
    if ((((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment() != null) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment().a() != null))
    {
      ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if (((StructLongMessageDownloadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (StructLongMessageDownloadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
      {
        localObject = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForStructing)localObject).uniseq);
      }
      i = parambeml.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
        break label534;
      }
    }
    label534:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId;; l = 0L)
    {
      i = parambeml.jdField_a_of_type_Int;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8006320", "0X8006320", 0, 0, "" + l, "", "" + (i + 1), parambeml.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= parambeml.jdField_a_of_type_Int)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
        return;
      }
      localObject = (rsd)this.jdField_a_of_type_JavaUtilArrayList.get(parambeml.jdField_a_of_type_Int);
      parambeml = new JSONObject();
      try
      {
        parambeml.put("puin", ((rsd)localObject).jdField_a_of_type_JavaLangString);
        parambeml.put("type", ((rsd)localObject).b);
        parambeml.put("index", ((rsd)localObject).c);
        parambeml.put("name", ((rsd)localObject).d);
        parambeml.put("net", ((rsd)localObject).e);
        parambeml.put("mobile_imei", babp.a());
        parambeml.put("obj", "");
        parambeml.put("gdt_cli_data", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("gdt_msgClick"));
        parambeml.put("view_id", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("gdt_view_id"));
        rsa.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.selfuin, parambeml.toString(), "" + l);
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
 * Qualified Name:     adqj
 * JD-Core Version:    0.7.0.1
 */