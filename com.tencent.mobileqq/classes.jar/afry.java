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

public class afry
  implements afrc, Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private volatile bcnc jdField_a_of_type_Bcnc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<agkp, MessageForPtt> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private ConcurrentHashMap<Long, bcnc> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public afry(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private void a(bcnc parambcnc)
  {
    if (parambcnc == null)
    {
      QLog.e("Q.stt_AIOHelper", 1, "startSttAnimator animator is null!");
      return;
    }
    this.jdField_a_of_type_Bcnc = parambcnc;
    c();
  }
  
  private boolean a(bcnc parambcnc)
  {
    if ((parambcnc == null) || (!parambcnc.b())) {
      return false;
    }
    if (this.jdField_a_of_type_Bcnc != null)
    {
      parambcnc.a(false);
      return false;
    }
    parambcnc.a(true);
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
      paramMessageForPtt = (bcnc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
      if ((paramMessageForPtt != null) && (paramMessageForPtt.equals(this.jdField_a_of_type_Bcnc)))
      {
        paramMessageForPtt.a(false);
        this.jdField_a_of_type_Bcnc = null;
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
    }
  }
  
  @Nullable
  protected bcnc a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessageForPtt)) {
      return (bcnc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageForPtt);
    }
    return null;
  }
  
  public CharSequence a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessageForPtt))
    {
      paramMessageForPtt = (bcnc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageForPtt);
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
    if (this.jdField_a_of_type_Bcnc == null) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == this.jdField_a_of_type_Bcnc) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEntry.getKey());
      }
    }
    this.jdField_a_of_type_Bcnc.e();
    this.jdField_a_of_type_Bcnc = null;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return;
    case 13: 
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    case 9: 
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(agkp paramagkp, MessageForPtt paramMessageForPtt, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramagkp)) {
          break label200;
        }
        MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramagkp);
        localObject = localMessageForPtt;
        if (localMessageForPtt == paramMessageForPtt) {
          localObject = null;
        }
        if (localObject != null)
        {
          localObject = (bcnc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(((MessageForPtt)localObject).uniseq));
          if (localObject != null) {
            ((bcnc)localObject).a();
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramagkp, paramMessageForPtt);
        localObject = (bcnc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForPtt.uniseq));
        if (localObject != null) {
          break label197;
        }
        if (bcnc.b(paramMessageForPtt)) {
          return;
        }
        localObject = new bcnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, paramInt);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForPtt.uniseq), localObject);
        ((bcnc)localObject).a(paramagkp);
        if ((a((bcnc)localObject)) && (bcnc.a(paramMessageForPtt)))
        {
          paramInt = 1;
          if (paramInt != 0) {
            a((bcnc)localObject);
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
    bcnc localbcnc;
    do
    {
      do
      {
        do
        {
          return;
          localbcnc = (bcnc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForPtt.uniseq));
        } while (this.jdField_a_of_type_Bcnc == localbcnc);
        boolean bool1 = a(localbcnc);
        boolean bool2 = bcnc.a(paramMessageForPtt);
        if ((bool1) && (bool2))
        {
          a(localbcnc);
          return;
        }
      } while ((paramMessageForPtt.getSttResult().a() != 3) || (localbcnc == null));
      localbcnc.b();
    } while (this.jdField_a_of_type_Boolean);
    localbcnc.a(this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public int[] a()
  {
    return new int[] { 13, 7, 9, 5 };
  }
  
  public void b()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718619, 0).a();
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
      if (this.jdField_a_of_type_Bcnc == null) {
        break label72;
      }
      this.jdField_a_of_type_Bcnc.b();
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bcnc.a(this.jdField_a_of_type_AndroidOsHandler);
      }
    }
    label72:
    for (boolean bool = this.jdField_a_of_type_Bcnc.a();; bool = false)
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
 * Qualified Name:     afry
 * JD-Core Version:    0.7.0.1
 */