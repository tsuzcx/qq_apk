import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.impls.memory.MemoryDumpHelper.5;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class adcw
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private bgpa jdField_a_of_type_Bgpa;
  protected biau a;
  
  public static Activity a()
  {
    Object localObject;
    if (2 == BaseApplicationImpl.sProcessId) {
      localObject = bmja.a();
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
      if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing()))
      {
        this.jdField_a_of_type_Bgpa.dismiss();
        this.jdField_a_of_type_Bgpa = null;
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
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, boolean paramBoolean2)
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
    jdField_a_of_type_AndroidOsHandler.postDelayed(new MemoryDumpHelper.5(this, paramBoolean1, paramString1, paramString2, paramBoolean2), 100L);
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
    //   5: getfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   8: ifnull +25 -> 33
    //   11: aload_0
    //   12: getfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   15: invokevirtual 50	bgpa:isShowing	()Z
    //   18: ifeq +15 -> 33
    //   21: aload_0
    //   22: getfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   25: invokevirtual 53	bgpa:dismiss	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   33: invokestatic 148	adcw:a	()Landroid/app/Activity;
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
    //   64: new 47	bgpa
    //   67: dup
    //   68: aload_3
    //   69: ldc 154
    //   71: invokespecial 157	bgpa:<init>	(Landroid/content/Context;I)V
    //   74: putfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   77: aload_0
    //   78: getfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   81: ldc 158
    //   83: invokevirtual 161	bgpa:setContentView	(I)V
    //   86: aload_0
    //   87: getfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   90: aconst_null
    //   91: invokevirtual 165	bgpa:setTitle	(Ljava/lang/String;)Lbgpa;
    //   94: pop
    //   95: aload_0
    //   96: getfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   99: ldc 166
    //   101: new 168	adcy
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 170	adcy:<init>	(Ladcw;)V
    //   109: invokevirtual 174	bgpa:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lbgpa;
    //   112: pop
    //   113: aload_0
    //   114: getfield 42	adcw:jdField_a_of_type_Bgpa	Lbgpa;
    //   117: iconst_0
    //   118: invokevirtual 178	bgpa:setCanceledOnTouchOutside	(Z)V
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
    //   0	131	0	this	adcw
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
      if (this.jdField_a_of_type_Biau == null)
      {
        this.jdField_a_of_type_Biau = new biau(a(), BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298998));
        this.jdField_a_of_type_Biau.a(anni.a(2131705329));
        this.jdField_a_of_type_Biau.c(false);
        this.jdField_a_of_type_Biau.setOnDismissListener(new addb(this));
      }
      this.jdField_a_of_type_Biau.show();
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
      if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing()))
      {
        this.jdField_a_of_type_Biau.dismiss();
        this.jdField_a_of_type_Biau = null;
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
 * Qualified Name:     adcw
 * JD-Core Version:    0.7.0.1
 */