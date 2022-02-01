import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic.1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aghu
{
  private static aghu jdField_a_of_type_Aghu;
  private static String jdField_a_of_type_JavaLangString = "PlayLastLogic";
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private WeakReference<DoodleMsgLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<Integer, aghv> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = -1L;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private int d;
  private int e;
  private int f = 0;
  private int g;
  private int h;
  
  private aghu()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkPlayable: bRealPlay:" + paramBoolean);
    }
    aghv localaghv = (aghv)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localaghv != null)
    {
      Object localObject = localaghv.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (DoodleMsgLayout)((WeakReference)localObject).get();
        if (localObject != null)
        {
          Rect localRect = new Rect();
          if ((((DoodleMsgLayout)localObject).getGlobalVisibleRect(localRect)) && (localRect.height() > ((DoodleMsgLayout)localObject).getHeight() * 0.9D))
          {
            if ((!((DoodleMsgLayout)localObject).b()) && (this.jdField_a_of_type_Long != localaghv.jdField_b_of_type_Long) && (((DoodleMsgLayout)localObject).a()))
            {
              if (paramBoolean)
              {
                a((DoodleMsgLayout)localObject, false);
                if (localaghv.jdField_b_of_type_Long == this.jdField_c_of_type_Long) {
                  this.jdField_a_of_type_Boolean = true;
                }
              }
              if (!QLog.isColorLevel()) {
                break label367;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkPlayable: lastID:" + this.jdField_b_of_type_Long + "lasUniID" + this.jdField_c_of_type_Long + " lastMsgPlayed:" + this.jdField_a_of_type_Boolean + " playedID:" + this.jdField_a_of_type_Long);
              return 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkPlayable: can not play:" + localaghv.jdField_a_of_type_Long + "uniID:" + localaghv.jdField_b_of_type_Long + " mPlayedID:" + this.jdField_a_of_type_Long);
            }
            if (!((DoodleMsgLayout)localObject).b()) {
              break label365;
            }
            return 3;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkPlayable: invisible MsgID:" + localaghv.jdField_a_of_type_Long + "uniID:" + localaghv.jdField_b_of_type_Long);
          }
        }
      }
    }
    return 0;
    label365:
    return 2;
    label367:
    return 1;
  }
  
  public static long a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
      return paramChatMessage.shmsgseq;
    }
    return paramChatMessage.time;
  }
  
  public static aghu a()
  {
    try
    {
      if (jdField_a_of_type_Aghu == null) {
        jdField_a_of_type_Aghu = new aghu();
      }
      return jdField_a_of_type_Aghu;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        aghv localaghv = (aghv)((Map.Entry)localIterator.next()).getValue();
        if ((localaghv == null) || (localaghv.jdField_a_of_type_Int < paramInt1) || (localaghv.jdField_a_of_type_Int > paramInt2)) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (aghv)localIterator.next();
        if ((localObject != null) && (((aghv)localObject).jdField_a_of_type_Int >= this.d) && (((aghv)localObject).jdField_a_of_type_Int <= this.e))
        {
          localObject = ((aghv)localObject).jdField_a_of_type_JavaLangRefWeakReference;
          if (localObject != null)
          {
            localObject = (DoodleMsgLayout)((WeakReference)localObject).get();
            if (localObject != null) {
              ((DoodleMsgLayout)localObject).b(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Long < 0L)) {
        return;
      }
      do
      {
        do
        {
          do
          {
            this.jdField_a_of_type_Boolean = true;
            localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
          } while (!((Iterator)localObject).hasNext());
          aghv localaghv = (aghv)((Iterator)localObject).next();
          if (localaghv.jdField_b_of_type_Long != this.jdField_c_of_type_Long) {
            break;
          }
          localObject = localaghv.jdField_a_of_type_JavaLangRefWeakReference;
        } while (localObject == null);
        localObject = (DoodleMsgLayout)((WeakReference)localObject).get();
      } while (localObject == null);
      ((DoodleMsgLayout)localObject).d();
      return;
    }
    int i = this.e;
    label115:
    if (i >= this.d) {
      if (i != paramInt) {
        break label135;
      }
    }
    for (;;)
    {
      i -= 1;
      break label115;
      break;
      label135:
      localObject = (aghv)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if ((localObject != null) && ((((aghv)localObject).jdField_a_of_type_Long > this.jdField_b_of_type_Long) || (((aghv)localObject).jdField_b_of_type_Long == this.jdField_c_of_type_Long)))
      {
        localObject = ((aghv)localObject).jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject != null)
        {
          localObject = (DoodleMsgLayout)((WeakReference)localObject).get();
          if (localObject != null) {
            ((DoodleMsgLayout)localObject).d();
          }
        }
      }
    }
  }
  
  public static long b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.uniseq;
  }
  
  public static void b()
  {
    try
    {
      if (jdField_a_of_type_Aghu != null)
      {
        jdField_a_of_type_Aghu.a();
        jdField_a_of_type_Aghu = null;
      }
      return;
    }
    finally {}
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "restartPlayTimer:" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramInt < 0) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new PlayLastLogic.1(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "strategy2 :" + paramBoolean + " StartPos:" + this.d + "EndPos:" + this.e);
    }
    int k;
    int i;
    if (this.f == 0)
    {
      j = this.e;
      while (j >= this.d)
      {
        k = a(j, paramBoolean);
        if (k > 0)
        {
          i = j;
          if (k != 1)
          {
            if (k != 3) {
              break;
            }
            i = j;
          }
          a(false, i);
          return;
        }
        j -= 1;
      }
    }
    int j = this.d;
    for (;;)
    {
      if (j <= this.e)
      {
        k = a(j, paramBoolean);
        if (k <= 0) {
          break label168;
        }
        i = j;
        if (k == 1) {
          break;
        }
        i = j;
        if (k == 3) {
          break;
        }
      }
      i = -1;
      break;
      label168:
      j += 1;
    }
  }
  
  public void a()
  {
    this.jdField_c_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      new Handler(Looper.getMainLooper()).removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0)
    {
      b(1000);
      a(this.d, this.e);
      a(false);
      b(false);
      return;
    }
    b(-1);
    a(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int k = 0;
    int j = 0;
    if ((paramInt1 == 0) && (paramInt3 > 0)) {
      paramInt2 -= 1;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt1 + paramInt2 == paramInt5)
      {
        i = paramInt2;
        if (paramInt4 > 0) {
          i = paramInt2 - 1;
        }
      }
      paramInt1 -= paramInt3;
      if ((this.h != paramInt8) || (this.g != paramInt7))
      {
        this.h = paramInt8;
        this.g = paramInt7;
        this.f = 0;
        this.jdField_c_of_type_Int = paramInt6;
        this.jdField_b_of_type_Int = paramInt1;
        if (paramInt1 < 0) {
          paramInt1 = j;
        }
        for (;;)
        {
          this.d = paramInt1;
          this.e = (i + this.d - 1);
          if (this.e < this.d) {
            this.e = this.d;
          }
          return;
        }
      }
      if (paramInt1 > this.jdField_b_of_type_Int)
      {
        this.f = 0;
        label153:
        this.jdField_c_of_type_Int = paramInt6;
        this.jdField_b_of_type_Int = paramInt1;
        if (paramInt1 >= 0) {
          break label259;
        }
        paramInt1 = k;
      }
      label259:
      for (;;)
      {
        this.d = paramInt1;
        this.e = (i + this.d - 1);
        if (this.e >= this.d) {
          break;
        }
        this.e = this.d;
        return;
        if (paramInt1 < this.jdField_b_of_type_Int)
        {
          this.f = 1;
          break label153;
        }
        if (paramInt6 < this.jdField_c_of_type_Int)
        {
          this.f = 0;
          break label153;
        }
        if (paramInt6 <= this.jdField_c_of_type_Int) {
          break label153;
        }
        this.f = 1;
        break label153;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, DoodleMsgLayout paramDoodleMsgLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "registLayout:" + paramLong2 + " pos:" + paramInt + " uniid:" + paramLong1);
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new aghv(this, paramLong1, paramLong2, paramInt, paramDoodleMsgLayout));
    boolean bool;
    if (this.jdField_a_of_type_Int != 0)
    {
      bool = true;
      paramDoodleMsgLayout.b(bool);
      if (!a(paramLong1, paramLong2)) {
        break label182;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "registLayout: is new msg, lastID:" + this.jdField_b_of_type_Long + " uniID:" + paramLong1);
      }
      if (this.jdField_a_of_type_Int != 0) {
        break label176;
      }
      b(1000);
    }
    label176:
    label182:
    while (!QLog.isColorLevel())
    {
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "registLayout: is old msg, lastID:" + this.jdField_b_of_type_Long + " uniID:" + paramLong1 + " lastMsgPlayed:" + this.jdField_a_of_type_Boolean + " playedID:" + this.jdField_a_of_type_Long);
  }
  
  public void a(DoodleMsgLayout paramDoodleMsgLayout, boolean paramBoolean)
  {
    if (paramDoodleMsgLayout == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          localObject = (DoodleMsgLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localObject != null) && (((DoodleMsgLayout)localObject).b()))
          {
            if ((paramBoolean) && (localObject == paramDoodleMsgLayout))
            {
              ((DoodleMsgLayout)localObject).d();
              return;
            }
            if ((!paramBoolean) && (localObject == paramDoodleMsgLayout)) {
              break;
            }
            ((DoodleMsgLayout)localObject).d();
          }
        }
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleMsgLayout);
        paramDoodleMsgLayout.c();
        Object localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          aghv localaghv = (aghv)((Iterator)localObject).next();
          if ((localaghv.jdField_a_of_type_JavaLangRefWeakReference != null) && (localaghv.jdField_a_of_type_JavaLangRefWeakReference.get() == paramDoodleMsgLayout))
          {
            this.jdField_a_of_type_Long = localaghv.jdField_b_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "playLayout: lastPlayedID:" + this.jdField_a_of_type_Long);
            }
          }
        }
      } while (!paramBoolean);
      b(-1);
      return;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "playLayout: same layout, ans is playing, return:");
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    long l1 = a((ChatMessage)paramList.get(paramList.size() - 1));
    long l2 = b((ChatMessage)paramList.get(paramList.size() - 1));
    if ((l1 > this.jdField_b_of_type_Long) && (this.jdField_c_of_type_Long != l2))
    {
      a(true, -1);
      if (this.jdField_b_of_type_Long >= 0L) {
        break label192;
      }
    }
    label192:
    for (this.jdField_a_of_type_Boolean = ((ChatMessage)paramList.get(paramList.size() - 1)).isread;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Long = l1;
      this.jdField_c_of_type_Long = l2;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setLastMsgID: a new msg");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setLastMsgID:" + this.jdField_b_of_type_Long + " :" + this.jdField_c_of_type_Long);
      return;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong2 > this.jdField_b_of_type_Long) && (paramLong1 != this.jdField_c_of_type_Long)) {}
    while ((this.jdField_c_of_type_Long == paramLong1) && (!this.jdField_a_of_type_Boolean)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghu
 * JD-Core Version:    0.7.0.1
 */