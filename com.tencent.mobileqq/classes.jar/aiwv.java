import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aiwv
  implements agvc, Handler.Callback
{
  private long jdField_a_of_type_Long = -1L;
  private aixc jdField_a_of_type_Aixc;
  private aixj jdField_a_of_type_Aixj;
  private aocj jdField_a_of_type_Aocj = new aiww(this);
  private aqrf jdField_a_of_type_Aqrf;
  private aqrh jdField_a_of_type_Aqrh = new aiwz(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private MessageRecord b;
  
  public aiwv(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramString);
      localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
      localMessage.what = 2;
      if (localObject == null) {
        break label121;
      }
      if (((HotChatInfo)localObject).state != 6) {
        break label90;
      }
      localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131689971);
    }
    for (;;)
    {
      if (localMessage.obj != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
      return;
      label90:
      if (((HotChatInfo)localObject).state == 7)
      {
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131689977);
        continue;
        label121:
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject != null)
        {
          paramString = ((TroopManager)localObject).a(paramString + "", true);
          if (paramString != null)
          {
            if ((paramString.isKicked()) || (paramString.isExited())) {
              localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131689971);
            } else if (paramString.isDisband()) {
              localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131689977);
            }
          }
          else {
            localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131689971);
          }
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(aiwv.class);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
  }
  
  private void c()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent();
    if (localIntent != null) {
      this.jdField_a_of_type_Long = localIntent.getLongExtra("key_uniseq", -1L);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1, 2131689960, 0).a();
      return;
    }
    a(paramList, paramLong, paramInt);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Long != -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false, false, true);
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = -1L;
      ThreadManager.getSubThreadHandler().postAtTime(new AIOUpComingMsgHelper.1(this, l), aiwv.class, 0L);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Aixj == null) {
      this.jdField_a_of_type_Aixj = new aixj(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Aqrf == null)
    {
      this.jdField_a_of_type_Aqrf = new aqrf();
      this.jdField_a_of_type_Aqrf.a(this.jdField_a_of_type_Aqrh);
    }
  }
  
  private void g()
  {
    if ((this.b != null) && (this.jdField_a_of_type_Boolean))
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aijm)) {
        break label65;
      }
      ((aijm)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(22, this.b.msgUid, this.b.time, this.b);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = null;
      return;
      label65:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j())
      {
        QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(22, this.b.shmsgseq, (int)(localMessage.shmsgseq - this.b.shmsgseq), null);
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
      if (this.jdField_a_of_type_Aixc == null) {
        this.jdField_a_of_type_Aixc = new aixc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aixc.a(paramList, paramLong, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if (this.jdField_a_of_type_Aixc == null) {
      this.jdField_a_of_type_Aixc = new aixc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Aixc.a(paramList, paramLong, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      c();
      return;
    case 5: 
      d();
      return;
    case 7: 
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
    this.jdField_a_of_type_Aixj.a(1);
    this.jdField_a_of_type_Aixj.a(new aiwx(this, localArrayList));
    int i = aixg.a(paramChatMessage);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE7D", "0X800AE7D", i, 0, "", "", "", "");
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (!bhnv.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131691989, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = axpm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramList);
      } while ((localObject1 == null) || (((ArrayList)localObject1).size() == 0));
      axpf.a().b((List)localObject1);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + ((ArrayList)localObject1).size());
      }
    } while (((ArrayList)localObject1).size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(2131697754);
    paramList = new ArrayList();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = adak.c((ChatMessage)((Iterator)localObject2).next());
      if (!paramList.contains(str)) {
        paramList.add(str);
      }
    }
    axpf.a().jdField_a_of_type_JavaUtilArrayList.clear();
    axpf.a().jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
    axpf.a().jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList, false, null);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
      ((Message)localObject2).arg1 = paramList.size();
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 30000L);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramList);
      }
    }
  }
  
  public void a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    f();
    this.jdField_a_of_type_Aqrf.a(0, "update_process_state", false);
    if (!this.jdField_a_of_type_Aqrf.a()) {
      aqsd.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
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
            this.jdField_a_of_type_Aqrf.a(paramList);
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
    return new int[] { 3, 13, 5, 7 };
  }
  
  public void b(List<ChatMessage> paramList, long paramLong, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    e();
    this.jdField_a_of_type_Aixj.a(2);
    this.jdField_a_of_type_Aixj.a(new aiwy(this, localArrayList, paramList));
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE7E", "0X800AE7E", paramList.size(), 0, "", "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(aiwv.class);
      this.b = ((MessageRecord)paramMessage.obj);
      if (this.b == null)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 2131697020, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight());
      }
      else
      {
        g();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRightRootVisibility(4);
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (String)paramMessage.obj, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwv
 * JD-Core Version:    0.7.0.1
 */