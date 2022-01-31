import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class adiq
  implements adih
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  public asoh a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public adiq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void a(List<ChatMessage> paramList)
  {
    asty.a().b(paramList);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "multiForwardSperate|checklist.size = " + paramList.size());
    }
    if (paramList.size() == 0) {
      return;
    }
    asty.a().jdField_a_of_type_JavaUtilArrayList.clear();
    asty.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    asty.a().b.clear();
    asty.a().b.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    a(asty.a().b, asty.a().jdField_a_of_type_JavaUtilArrayList, 1);
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      paramList = "0X80078B8";
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      paramList = "0X80078B8";
      continue;
      paramList = "0X80078B9";
      continue;
      paramList = "0X80078BA";
    }
  }
  
  private void b(List<ChatMessage> paramList)
  {
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localbfol.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694470));
    localbfol.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694471));
    localbfol.c(2131690596);
    localbfol.a(new adir(this, paramList, localbfol));
    localbfol.show();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asoh == null) {
      this.jdField_a_of_type_Asoh = new asoh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    this.jdField_a_of_type_Asoh.b();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Asoh == null);
    this.jdField_a_of_type_Asoh.c();
    this.jdField_a_of_type_Asoh = null;
  }
  
  public void a(acut paramacut, boolean paramBoolean)
  {
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext)) {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692321, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    do
    {
      return;
      paramacut = asty.a().a();
      paramacut = asuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramacut);
    } while ((paramacut == null) || (paramacut.size() == 0));
    if (paramBoolean)
    {
      a(paramacut, 2);
      return;
    }
    b(paramacut);
  }
  
  public void a(List<ChatMessage> paramList, int paramInt)
  {
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext)) {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692321, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    do
    {
      return;
      asty.a().b(paramList);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(2131698467);
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = akpy.c((ChatMessage)((Iterator)localObject).next());
      if (!localArrayList.contains(str)) {
        localArrayList.add(str);
      }
    }
    asty.a().jdField_a_of_type_JavaUtilArrayList.clear();
    asty.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    asty.a().jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      ((akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, false, null);
      paramList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      localObject = paramList.obtainMessage(24);
      ((Message)localObject).arg1 = localArrayList.size();
      paramList.sendMessageDelayed((Message)localObject, 30000L);
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        paramList = "0X80078BB";
      }
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004)) {
        break;
      }
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(localArrayList);
      break;
      paramList = "0X80078BB";
      continue;
      paramList = "0X80078BC";
      continue;
      paramList = "0X80078BD";
    }
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 4) {
      if (this.jdField_a_of_type_Asoh != null) {
        this.jdField_a_of_type_Asoh.b(paramMap, paramArrayList);
      }
    }
    do
    {
      return;
      if (paramInt != 3) {
        break;
      }
    } while (this.jdField_a_of_type_Asoh == null);
    this.jdField_a_of_type_Asoh.a(paramMap, paramArrayList);
    return;
    String str = " ";
    label78:
    Context localContext;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      str = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localContext = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt == 1) {
        break label182;
      }
    }
    for (;;)
    {
      paramMap = aaod.a(localContext, str, paramArrayList, paramMap, bool);
      if (paramMap == null) {
        break;
      }
      if (paramInt != 2) {
        break label188;
      }
      asty.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, paramMap, 0L, false, paramInt);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label78;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      break label78;
      label182:
      bool = false;
    }
    label188:
    paramMap.mMsg_A_ActionData = null;
    paramArrayList = new Intent();
    paramArrayList.putExtra("forward_type", -3);
    paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
    paramArrayList.putExtra("is_need_show_sources", false);
    paramArrayList.putExtra("forward_msg_from_together", paramInt);
    aqbc.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayList, 21);
  }
  
  public int[] a()
  {
    return new int[] { 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adiq
 * JD-Core Version:    0.7.0.1
 */