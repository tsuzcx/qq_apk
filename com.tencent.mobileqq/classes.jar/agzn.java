import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class agzn
  implements Handler.Callback
{
  public int a;
  private alox jdField_a_of_type_Alox = new agzo(this);
  amab jdField_a_of_type_Amab = new agzp(this);
  public bepp a;
  private final bhow jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  public WeakReference<BaseActivity> a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public agzn(BaseActivity paramBaseActivity, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_Int = paramInt;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
    }
    paramBaseActivity = paramBaseActivity.getIntent();
    this.jdField_b_of_type_Int = paramBaseActivity.getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = paramBaseActivity.getStringExtra("uin");
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
  }
  
  public void a(Intent paramIntent)
  {
    if (azqu.a(paramIntent.getByteArrayExtra("stuctmsg_bytes")) == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", 0);
    localSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    localSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    paramIntent = aukx.a();
    paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramIntent.a);
  }
  
  public void a(List<ChatMessage> paramList)
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject == null)
    {
      QLog.e("SeparateForward", 1, "sendMultiMsg, activity recyled");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = aule.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramList);
    aukx.a().b(paramList);
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    }
    this.jdField_a_of_type_Bepp.c(2131698772);
    this.jdField_a_of_type_Bepp.show();
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
      if (!localArrayList.contains(localChatMessage.senderuin)) {
        localArrayList.add(localChatMessage.senderuin);
      }
    }
    aukx.a().a.clear();
    aukx.a().a.addAll(paramList);
    if (this.jdField_b_of_type_Int == 1) {
      ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_JavaLangString, localArrayList, false, null);
    }
    for (;;)
    {
      paramList = this.jdField_a_of_type_Bhow.obtainMessage(1);
      paramList.arg1 = localArrayList.size();
      this.jdField_a_of_type_Bhow.sendMessageDelayed(paramList, 30000L);
      return;
      if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 3000)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(localArrayList);
      }
    }
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localBaseActivity == null)
    {
      QLog.e("SeparateForward", 1, "sendMultiMsg, activity recyled");
      return;
    }
    String str = " ";
    if (this.jdField_b_of_type_Int == 0) {}
    for (str = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);; str = this.jdField_b_of_type_JavaLangString) {
      do
      {
        paramMap = acex.a(localBaseActivity, str, paramArrayList, paramMap, true);
        if (paramMap == null) {
          break;
        }
        paramMap.mMsg_A_ActionData = null;
        paramArrayList = new Intent();
        paramArrayList.putExtra("forward_type", -3);
        paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
        paramArrayList.putExtra("is_need_show_sources", false);
        paramArrayList.putExtra("forward_msg_from_together", 1);
        paramArrayList.putExtra("forwardDirect", true);
        arum.a(localBaseActivity, paramArrayList, this.jdField_a_of_type_Int);
        return;
      } while ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 3000));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      paramMessage = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while ((this.jdField_a_of_type_Bepp == null) || (paramMessage == null));
    this.jdField_a_of_type_Bepp.dismiss();
    QQToast.a(paramMessage, 2131698774, 0).b(paramMessage.getResources().getDimensionPixelSize(2131298914));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzn
 * JD-Core Version:    0.7.0.1
 */