import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5;
import java.lang.ref.WeakReference;

public final class acpw
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -2147483648L;
  private acpv jdField_a_of_type_Acpv;
  private ArkAppMgr.IGetAppPathByNameCallback jdField_a_of_type_ComTencentArkOpenArkAppMgr$IGetAppPathByNameCallback = new acpx(this);
  private WeakReference<acpy> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public acpw(WeakReference<acpy> paramWeakReference, acpv paramacpv, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_Acpv = paramacpv;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private String a()
  {
    String str = null;
    if (a()) {
      str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.jdField_a_of_type_Acpv.a, "", null, false);
    }
    acvc.b("GdtArkPreDownloadTask", String.format("getPath %s", new Object[] { str }));
    return str;
  }
  
  private void a()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.1(this), 4);
  }
  
  private void a(int paramInt)
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.4(this, paramInt), 0);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    AdThreadManager.INSTANCE.postDelayed(new GdtArkPreDownloadTask.3(this, paramInt1, paramInt2), 0, paramLong);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Acpv != null) && (this.jdField_a_of_type_Acpv.a());
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if ((paramInt2 != 1) && (paramInt2 != 1)) {}
    }
    else {
      do
      {
        return true;
        if (paramInt1 != 1) {
          break;
        }
      } while ((paramInt2 == 2) || (paramInt2 == 3));
    }
    do
    {
      do
      {
        acvc.d("GdtArkPreDownloadTask", String.format("checkStatus result:false oldStatus:%d newStatus:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        return false;
      } while (paramInt1 != 2);
      if (paramInt2 == 3) {
        break;
      }
    } while (paramInt2 != 4);
    return true;
  }
  
  private void b()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.2(this), 0);
  }
  
  /* Error */
  private void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	acpw:jdField_a_of_type_Int	I
    //   4: istore_2
    //   5: iload_2
    //   6: iload_1
    //   7: if_icmpeq +30 -> 37
    //   10: aload_0
    //   11: monitorenter
    //   12: iload_2
    //   13: iload_1
    //   14: if_icmpeq +21 -> 35
    //   17: iload_2
    //   18: iload_1
    //   19: invokestatic 143	acpw:a	(II)Z
    //   22: ifeq +54 -> 76
    //   25: aload_0
    //   26: iload_1
    //   27: putfield 23	acpw:jdField_a_of_type_Int	I
    //   30: aload_0
    //   31: iload_1
    //   32: invokespecial 145	acpw:a	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: ldc 66
    //   39: ldc 147
    //   41: iconst_3
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload_2
    //   48: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: iload_1
    //   55: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: aload_0
    //   62: getfield 23	acpw:jdField_a_of_type_Int	I
    //   65: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: invokestatic 74	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   72: invokestatic 80	acvc:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: return
    //   76: aload_0
    //   77: iconst_1
    //   78: ldc 148
    //   80: lconst_0
    //   81: invokespecial 121	acpw:a	(IIJ)V
    //   84: goto -49 -> 35
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	acpw
    //   0	92	1	paramInt	int
    //   4	44	2	i	int
    //   87	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	35	87	finally
    //   35	37	87	finally
    //   76	84	87	finally
    //   88	90	87	finally
  }
  
  private void c()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.5(this), 4);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpw
 * JD-Core Version:    0.7.0.1
 */