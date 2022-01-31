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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class afau
  implements afal
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  public aufi a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public afau(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void a(List<ChatMessage> paramList)
  {
    aukx.a().b(paramList);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "multiForwardSperate|checklist.size = " + paramList.size());
    }
    if (paramList.size() == 0) {
      return;
    }
    aukx.a().jdField_a_of_type_JavaUtilArrayList.clear();
    aukx.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    aukx.a().b.clear();
    aukx.a().b.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    a(aukx.a().b, aukx.a().jdField_a_of_type_JavaUtilArrayList, 1);
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      paramList = "0X80078B8";
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
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
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localbhpy.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694628));
    localbhpy.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694629));
    localbhpy.c(2131690648);
    localbhpy.a(new afav(this, paramList, localbhpy));
    localbhpy.show();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aufi == null) {
      this.jdField_a_of_type_Aufi = new aufi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    this.jdField_a_of_type_Aufi.b();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Aufi == null);
    this.jdField_a_of_type_Aufi.c();
    this.jdField_a_of_type_Aufi = null;
  }
  
  public void a(aelz paramaelz, boolean paramBoolean)
  {
    if (!bdee.d(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692397, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    do
    {
      return;
      paramaelz = aukx.a().a();
      paramaelz = aule.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramaelz);
    } while ((paramaelz == null) || (paramaelz.size() == 0));
    if (paramBoolean)
    {
      a(paramaelz, 2);
      return;
    }
    b(paramaelz);
  }
  
  public void a(List<ChatMessage> paramList, int paramInt)
  {
    if (!bdee.d(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692397, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    do
    {
      return;
      aukx.a().b(paramList);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(2131698772);
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = abot.c((ChatMessage)((Iterator)localObject).next());
      if (!localArrayList.contains(str)) {
        localArrayList.add(str);
      }
    }
    aukx.a().jdField_a_of_type_JavaUtilArrayList.clear();
    aukx.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    aukx.a().jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, false, null);
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
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
      if (this.jdField_a_of_type_Aufi != null) {
        this.jdField_a_of_type_Aufi.b(paramMap, paramArrayList);
      }
    }
    do
    {
      return;
      if (paramInt != 3) {
        break;
      }
    } while (this.jdField_a_of_type_Aufi == null);
    this.jdField_a_of_type_Aufi.a(paramMap, paramArrayList);
    return;
    String str = " ";
    label78:
    Context localContext;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      str = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localContext = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt == 1) {
        break label182;
      }
    }
    for (;;)
    {
      paramMap = acex.a(localContext, str, paramArrayList, paramMap, bool);
      if (paramMap == null) {
        break;
      }
      if (paramInt != 2) {
        break label188;
      }
      aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, paramMap, 0L, false, paramInt);
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
    arum.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayList, 21);
  }
  
  public int[] a()
  {
    return new int[] { 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afau
 * JD-Core Version:    0.7.0.1
 */