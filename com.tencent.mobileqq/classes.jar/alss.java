import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Point;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.util.WeakReference;

public class alss
{
  private static alss jdField_a_of_type_Alss;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static final byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new alst(this);
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private WeakReference<alry> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private WeakReference<alur> jdField_b_of_type_MqqUtilWeakReference;
  private boolean jdField_b_of_type_Boolean = true;
  
  public static alss a()
  {
    if (jdField_a_of_type_Alss == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Alss == null) {
        jdField_a_of_type_Alss = new alss();
      }
      return jdField_a_of_type_Alss;
    }
  }
  
  public Point a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("key_float_window_position");
    localIntentFilter.addAction("key_delete_item_call");
    localIntentFilter.addAction("key_after_sync_msg");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteQIPCModule", 1, "register broadcast");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteQIPCModule", 2, "register failed", localException);
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    paramString = paramInt + paramString;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.remove(paramString);
  }
  
  public void a(alry paramalry)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramalry);
  }
  
  public void a(alur paramalur)
  {
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramalur);
  }
  
  public void a(Point paramPoint)
  {
    if ((paramPoint != null) && (paramPoint.x != 0) && (paramPoint.y != 0)) {
      this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    alsb.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    alsb.a(paramBoolean);
  }
  
  public boolean a()
  {
    return alsb.a();
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramInt + paramString);
  }
  
  public void b()
  {
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteQIPCModule", 1, "unregister broadcast");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteQIPCModule", 2, "unregister failed", localException);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alss
 * JD-Core Version:    0.7.0.1
 */