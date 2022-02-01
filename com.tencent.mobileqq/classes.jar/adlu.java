import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.impls.memory.MemoryDumpHelper.5;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qphone.base.util.QLog;

public class adlu
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private bhpc jdField_a_of_type_Bhpc;
  protected bjbs a;
  
  public static Activity a()
  {
    Object localObject;
    if (2 == BaseApplicationImpl.sProcessId) {
      localObject = bnkd.a();
    }
    for (;;)
    {
      if ((localObject != null) && (((Activity)localObject).isFinishing()))
      {
        return null;
        if (BaseActivity.sTopActivity != null) {
          localObject = BaseActivity.sTopActivity;
        }
      }
      else
      {
        return localObject;
      }
      localObject = null;
    }
  }
  
  private void a()
  {
    try
    {
      if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing()))
      {
        this.jdField_a_of_type_Bhpc.dismiss();
        this.jdField_a_of_type_Bhpc = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void a(boolean paramBoolean1, InspectUUID paramInspectUUID, String paramString, long paramLong, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("ReportDump dump mem.").append("fromLeak=").append(paramBoolean1);
    localStringBuilder.append(". Threshold=").append((100 - MagnifierSDK.a().a().a) * Runtime.getRuntime().maxMemory() / 100L / 1024L);
    localStringBuilder.append(" KB HeapMax=");
    localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
    localStringBuilder.append(" KB HeapSize=");
    localStringBuilder.append((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L);
    localStringBuilder.append(" KB HeapSizeBeforeTrim=").append(paramLong);
    QLog.d("QAPM_MemoryDumpHelper", 2, localStringBuilder.toString());
    jdField_a_of_type_AndroidOsHandler.postDelayed(new MemoryDumpHelper.5(this, paramBoolean1, paramInspectUUID, paramString, paramBoolean2), 100L);
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   8: ifnull +25 -> 33
    //   11: aload_0
    //   12: getfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   15: invokevirtual 50	bhpc:isShowing	()Z
    //   18: ifeq +15 -> 33
    //   21: aload_0
    //   22: getfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   25: invokevirtual 53	bhpc:dismiss	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   33: invokestatic 148	adlu:a	()Landroid/app/Activity;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnonnull +25 -> 63
    //   41: iload_2
    //   42: istore_1
    //   43: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +13 -> 59
    //   49: ldc 126
    //   51: iconst_2
    //   52: ldc 153
    //   54: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload_2
    //   58: istore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: aload_0
    //   64: new 47	bhpc
    //   67: dup
    //   68: aload_3
    //   69: ldc 154
    //   71: invokespecial 157	bhpc:<init>	(Landroid/content/Context;I)V
    //   74: putfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   77: aload_0
    //   78: getfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   81: ldc 158
    //   83: invokevirtual 161	bhpc:setContentView	(I)V
    //   86: aload_0
    //   87: getfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   90: aconst_null
    //   91: invokevirtual 165	bhpc:setTitle	(Ljava/lang/String;)Lbhpc;
    //   94: pop
    //   95: aload_0
    //   96: getfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   99: ldc 166
    //   101: new 168	adlw
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 170	adlw:<init>	(Ladlu;)V
    //   109: invokevirtual 174	bhpc:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lbhpc;
    //   112: pop
    //   113: aload_0
    //   114: getfield 42	adlu:jdField_a_of_type_Bhpc	Lbhpc;
    //   117: iconst_0
    //   118: invokevirtual 178	bhpc:setCanceledOnTouchOutside	(Z)V
    //   121: iconst_1
    //   122: istore_1
    //   123: goto -64 -> 59
    //   126: astore_3
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_3
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	adlu
    //   42	81	1	bool1	boolean
    //   1	57	2	bool2	boolean
    //   36	33	3	localActivity	Activity
    //   126	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	33	126	finally
    //   33	37	126	finally
    //   43	57	126	finally
    //   63	121	126	finally
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_Bjbs == null)
      {
        this.jdField_a_of_type_Bjbs = new bjbs(a(), BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299011));
        this.jdField_a_of_type_Bjbs.a(anzj.a(2131705436));
        this.jdField_a_of_type_Bjbs.c(false);
        this.jdField_a_of_type_Bjbs.setOnDismissListener(new adlz(this));
      }
      this.jdField_a_of_type_Bjbs.show();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "show juhua exception", localException);
        }
      }
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing()))
      {
        this.jdField_a_of_type_Bjbs.dismiss();
        this.jdField_a_of_type_Bjbs = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlu
 * JD-Core Version:    0.7.0.1
 */