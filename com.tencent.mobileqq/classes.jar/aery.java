import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.manager.Manager;

public class aery
  implements Manager
{
  private final bayj jdField_a_of_type_Bayj = new aerz(this, Looper.getMainLooper());
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<aesb> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public aery(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Bayj.addFilter(new Class[] { barl.class, barp.class, C2CPttDownloadProcessor.class, bart.class, batj.class, GroupPttDownloadProcessor.class, baro.class, bati.class, basv.class, ShortVideoUploadProcessor.class, baxb.class, baxe.class, bavj.class, bawu.class, bawv.class, basx.class, bauo.class, batn.class, bavu.class });
    a(paramQQAppInterface);
  }
  
  public static aery a(QQAppInterface paramQQAppInterface)
  {
    return (aery)paramQQAppInterface.getManager(23);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == paramQQAppInterface)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      a();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    paramQQAppInterface.a().a(this.jdField_a_of_type_Bayj);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().b(this.jdField_a_of_type_Bayj);
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager().a();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  void a(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label203;
        }
        QLog.d("FileTransferManager", 2, "handleMessage" + ((bass)paramMessage.obj).b + " status " + paramMessage.what + "retCode " + paramMessage.arg1);
      }
      finally {}
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject2 = (aesb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localObject2 != null)
        {
          Object localObject1 = ((aesb)localObject2).a();
          localObject2 = ((aesb)localObject2).a();
          if ((localObject1 != null) && (localObject2 != null))
          {
            ((aesa)localObject2).a((View)localObject1, (bass)paramMessage.obj, paramMessage.what, paramMessage.arg1);
            break label208;
          }
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
          int j = i - 1;
          ((ArrayList)localObject1).remove(i);
          i = j;
          break label208;
        }
      }
      else
      {
        OpenApiManager.getInstance().onFileTransStatusChanged((bass)paramMessage.obj, paramMessage.what, paramMessage.arg1);
        return;
      }
      break label208;
      label203:
      int i = 0;
      continue;
      label208:
      i += 1;
    }
  }
  
  /* Error */
  public void a(View paramView, aesa paramaesa)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	aery:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 217	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface 222 1 0
    //   16: ifeq +39 -> 55
    //   19: aload_3
    //   20: invokeinterface 225 1 0
    //   25: checkcast 188	aesb
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 191	aesb:a	()Landroid/view/View;
    //   35: aload_1
    //   36: if_acmpne -26 -> 10
    //   39: aload 4
    //   41: new 95	java/lang/ref/WeakReference
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 104	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   49: putfield 227	aesb:b	Ljava/lang/ref/WeakReference;
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield 35	aery:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   59: new 188	aesb
    //   62: dup
    //   63: aload_0
    //   64: aload_1
    //   65: aload_2
    //   66: invokespecial 230	aesb:<init>	(Laery;Landroid/view/View;Laesa;)V
    //   69: invokevirtual 234	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: goto -21 -> 52
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	aery
    //   0	81	1	paramView	View
    //   0	81	2	paramaesa	aesa
    //   9	11	3	localIterator	java.util.Iterator
    //   28	12	4	localaesb	aesb
    // Exception table:
    //   from	to	target	type
    //   2	10	76	finally
    //   10	52	76	finally
    //   55	73	76	finally
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aery
 * JD-Core Version:    0.7.0.1
 */