import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aimf
  implements agin, Handler.Callback
{
  private long jdField_a_of_type_Long = -1L;
  private aimm jdField_a_of_type_Aimm;
  private aimt jdField_a_of_type_Aimt;
  private anyz jdField_a_of_type_Anyz = new aimg(this);
  private aqns jdField_a_of_type_Aqns;
  private aqnu jdField_a_of_type_Aqnu = new aimj(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private MessageRecord b;
  
  public aimf(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = true;
    g();
  }
  
  private void a(String paramString)
  {
    Object localObject;
    Message localMessage;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
    {
      localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
      localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
      localMessage.what = 2;
      if (localObject == null) {
        break label122;
      }
      if (((HotChatInfo)localObject).state != 6) {
        break label91;
      }
      localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getResources().getString(2131690018);
    }
    for (;;)
    {
      if (localMessage.obj != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
      return;
      label91:
      if (((HotChatInfo)localObject).state == 7)
      {
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getResources().getString(2131690024);
        continue;
        label122:
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          paramString = ((TroopManager)localObject).a(paramString + "", true);
          if (paramString != null)
          {
            if ((paramString.isKicked()) || (paramString.isExited())) {
              localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getResources().getString(2131690018);
            } else if (paramString.isDisband()) {
              localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getResources().getString(2131690024);
            }
          }
          else {
            localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getResources().getString(2131690018);
          }
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(aimf.class);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyz);
  }
  
  private void c()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getIntent();
    if (localIntent != null) {
      this.jdField_a_of_type_Long = localIntent.getLongExtra("key_uniseq", -1L);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyz);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  private void c(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      ArrayList localArrayList = new ArrayList();
      if (1 == paramInt) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != ((MessageRecord)paramList.get(0)).uniseq) {
          localArrayList.add(paramList.get(0));
        }
      }
      while (!localArrayList.isEmpty())
      {
        a(paramList, paramLong, paramInt);
        return;
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != localMessageRecord.uniseq) {
            localArrayList.add(paramList.get(0));
          }
        }
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), 1, 2131690003, 0).a();
      return;
    }
    a(paramList, paramLong, paramInt);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Long != -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setLeftCheckBoxVisible(false, null, false, false, true);
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = -1L;
      ThreadManager.getSubThreadHandler().postAtTime(new AIOUpComingMsgHelper.1(this, l), aimf.class, 0L);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Aimt == null) {
      this.jdField_a_of_type_Aimt = new aimt(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Aqns == null)
    {
      this.jdField_a_of_type_Aqns = new aqns();
      this.jdField_a_of_type_Aqns.a(this.jdField_a_of_type_Aqnu);
    }
  }
  
  private void g()
  {
    if ((this.b != null) && (this.jdField_a_of_type_Boolean))
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof agab)) {
        break label65;
      }
      ((agab)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a(22, this.b.msgUid, this.b.time, this.b);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = null;
      return;
      label65:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.supportRefreshHeadMessage())
      {
        QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.refreshHeadMessage(22, this.b.shmsgseq, (int)(localMessage.shmsgseq - this.b.shmsgseq), null);
      }
    }
  }
  
  ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if (this.jdField_a_of_type_Aimm == null) {
        this.jdField_a_of_type_Aimm = new aimm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aimm.a(paramList, paramLong, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if (this.jdField_a_of_type_Aimm == null) {
      this.jdField_a_of_type_Aimm = new aimm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Aimm.a(paramList, paramLong, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      c();
      return;
    case 6: 
      d();
      return;
    case 8: 
      a();
      return;
    }
    b();
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    QLog.d("UpComingMsgLogic.AIOUpComingMsgHelper", 4, paramChatMessage.toString());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramChatMessage);
    e();
    this.jdField_a_of_type_Aimt.a(1);
    this.jdField_a_of_type_Aimt.a(new aimh(this, localArrayList));
    int i = aimq.a(paramChatMessage);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE7D", "0X800AE7D", i, 0, "", "", "", "");
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692125, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
    }
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = axiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramList);
      } while ((localObject1 == null) || (((ArrayList)localObject1).size() == 0));
      axio.a().b((List)localObject1);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + ((ArrayList)localObject1).size());
      }
    } while (((ArrayList)localObject1).size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showProgressDialog(2131698183);
    paramList = new ArrayList();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = acnh.c((ChatMessage)((Iterator)localObject2).next());
      if (!paramList.contains(str)) {
        paramList.add(str);
      }
    }
    axio.a().jdField_a_of_type_JavaUtilArrayList.clear();
    axio.a().jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
    axio.a().jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
      ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramList, false, null);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler();
      localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
      ((Message)localObject2).arg1 = paramList.size();
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 30000L);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1004)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(paramList);
      }
    }
  }
  
  public void a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    f();
    this.jdField_a_of_type_Aqns.a(0, "update_process_state", false);
    if (!this.jdField_a_of_type_Aqns.a()) {
      aqoq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
    }
    for (;;)
    {
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        f();
        try
        {
          paramList = a(paramList, paramLong, paramInt);
          if (paramList != null)
          {
            paramList = paramList.parseBundle();
            this.jdField_a_of_type_Aqns.a(paramList);
            return;
          }
        }
        catch (IllegalAccessException paramList)
        {
          QLog.e("UpComingMsgLogic.AIOUpComingMsgHelper", 1, "addColorNote occur error.", paramList);
        }
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 14, 6, 8 };
  }
  
  public void b(List<ChatMessage> paramList, long paramLong, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    e();
    this.jdField_a_of_type_Aimt.a(2);
    this.jdField_a_of_type_Aimt.a(new aimi(this, localArrayList, paramList));
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE7E", "0X800AE7E", paramList.size(), 0, "", "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(aimf.class);
      this.b = ((MessageRecord)paramMessage.obj);
      if (this.b == null)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), 2131697439, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getTitleBarHeight());
      }
      else
      {
        g();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.setRightRootVisibility(4);
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), (String)paramMessage.obj, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimf
 * JD-Core Version:    0.7.0.1
 */