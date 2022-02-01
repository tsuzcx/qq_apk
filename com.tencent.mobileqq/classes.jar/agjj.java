import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

public class agjj
  implements agin, Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private volatile bduc jdField_a_of_type_Bduc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<ahdf, MessageForPtt> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private ConcurrentHashMap<Long, bduc> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public agjj(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private void a(bduc parambduc)
  {
    if (parambduc == null)
    {
      QLog.e("Q.stt_AIOHelper", 1, "startSttAnimator animator is null!");
      return;
    }
    this.jdField_a_of_type_Bduc = parambduc;
    c();
  }
  
  private boolean a(bduc parambduc)
  {
    if ((parambduc == null) || (!parambduc.b())) {
      return false;
    }
    if (this.jdField_a_of_type_Bduc != null)
    {
      parambduc.a(false);
      return false;
    }
    parambduc.a(true);
    return true;
  }
  
  private boolean a(MessageForPtt paramMessageForPtt)
  {
    return (paramMessageForPtt.getSttResult() != null) && (paramMessageForPtt.getSttResult().a());
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt_AIOHelper", 2, "timer tick 100ms start");
      }
    }
  }
  
  private void f(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = a(paramMessageForPtt);
    if (paramMessageForPtt != null) {
      paramMessageForPtt.c();
    }
  }
  
  private void g(MessageForPtt paramMessageForPtt)
  {
    long l = paramMessageForPtt.uniseq;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l)))
    {
      paramMessageForPtt = (bduc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
      if ((paramMessageForPtt != null) && (paramMessageForPtt.equals(this.jdField_a_of_type_Bduc)))
      {
        paramMessageForPtt.a(false);
        this.jdField_a_of_type_Bduc = null;
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
    }
  }
  
  @Nullable
  protected bduc a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessageForPtt)) {
      return (bduc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageForPtt);
    }
    return null;
  }
  
  public CharSequence a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessageForPtt))
    {
      paramMessageForPtt = (bduc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageForPtt);
      if (paramMessageForPtt != null) {
        return paramMessageForPtt.a();
      }
    }
    return "";
  }
  
  public String a(MessageForPtt paramMessageForPtt)
  {
    return a(paramMessageForPtt).toString();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Bduc == null) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == this.jdField_a_of_type_Bduc) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEntry.getKey());
      }
    }
    this.jdField_a_of_type_Bduc.e();
    this.jdField_a_of_type_Bduc = null;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return;
    case 14: 
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    case 10: 
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramahdf)) {
          break label200;
        }
        MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramahdf);
        localObject = localMessageForPtt;
        if (localMessageForPtt == paramMessageForPtt) {
          localObject = null;
        }
        if (localObject != null)
        {
          localObject = (bduc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(((MessageForPtt)localObject).uniseq));
          if (localObject != null) {
            ((bduc)localObject).a();
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramahdf, paramMessageForPtt);
        localObject = (bduc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForPtt.uniseq));
        if (localObject != null) {
          break label197;
        }
        if (bduc.b(paramMessageForPtt)) {
          return;
        }
        localObject = new bduc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, paramInt);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForPtt.uniseq), localObject);
        ((bduc)localObject).a(paramahdf);
        if ((a((bduc)localObject)) && (bduc.a(paramMessageForPtt)))
        {
          paramInt = 1;
          if (paramInt != 0) {
            a((bduc)localObject);
          }
          return;
        }
      }
      finally {}
      paramInt = 0;
      continue;
      label197:
      continue;
      label200:
      Object localObject = null;
    }
  }
  
  public void a(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {}
    bduc localbduc;
    do
    {
      do
      {
        do
        {
          return;
          localbduc = (bduc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForPtt.uniseq));
        } while (this.jdField_a_of_type_Bduc == localbduc);
        boolean bool1 = a(localbduc);
        boolean bool2 = bduc.a(paramMessageForPtt);
        if ((bool1) && (bool2))
        {
          a(localbduc);
          return;
        }
      } while ((paramMessageForPtt.getSttResult().a() != 3) || (localbduc == null));
      localbduc.b();
    } while (this.jdField_a_of_type_Boolean);
    localbduc.a(this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public int[] a()
  {
    return new int[] { 14, 8, 10, 6 };
  }
  
  public void b()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719008, 0).a();
  }
  
  public void b(MessageForPtt paramMessageForPtt)
  {
    if (a(paramMessageForPtt)) {
      f(paramMessageForPtt);
    }
    g(paramMessageForPtt);
    b();
  }
  
  public void c(MessageForPtt paramMessageForPtt)
  {
    if (a(paramMessageForPtt)) {
      d(paramMessageForPtt);
    }
  }
  
  protected void d(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = a(paramMessageForPtt);
    if (paramMessageForPtt != null)
    {
      paramMessageForPtt.c();
      paramMessageForPtt.d();
    }
  }
  
  public void e(MessageForPtt paramMessageForPtt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (this.jdField_a_of_type_Bduc == null) {
        break label72;
      }
      this.jdField_a_of_type_Bduc.b();
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bduc.a(this.jdField_a_of_type_AndroidOsHandler);
      }
    }
    label72:
    for (boolean bool = this.jdField_a_of_type_Bduc.a();; bool = false)
    {
      if (!bool)
      {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
        return false;
      }
      a();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjj
 * JD-Core Version:    0.7.0.1
 */