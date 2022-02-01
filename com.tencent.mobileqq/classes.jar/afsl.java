import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttUploadProcessor;
import com.tencent.mobileqq.transfile.LightVideoUploadProcessor;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.ScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.manager.Manager;

public class afsl
  implements Manager
{
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new afsm(this, Looper.getMainLooper());
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<afso> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public afsl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPicDownloadProcessor.class, GroupPicDownloadProcessor.class, ForwardImageProcessor.class, ShortVideoUploadProcessor.class, ShortVideoDownloadProcessor.class, ShortVideoForwardProcessor.class, PAAudioPttDownloadProcessor.class, ScribblePicDownloadProcessor.class, ScribblePicUploadProcessor.class, ForwardSdkShareProcessor.class, LightVideoUploadProcessor.class, GroupPttUploadProcessor.class, PttSliceUploadProcessor.class });
    a(paramQQAppInterface);
  }
  
  public static afsl a(QQAppInterface paramQQAppInterface)
  {
    return (afsl)paramQQAppInterface.getManager(QQManagerFactory.MGR_FILE_TRANS);
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
    paramQQAppInterface.getTransFileController().addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getTransFileController().removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager().onDestroy();
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
        QLog.d("FileTransferManager", 2, "handleMessage" + ((FileMsg)paramMessage.obj).uniseq + " status " + paramMessage.what + "retCode " + paramMessage.arg1);
      }
      finally {}
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject2 = (afso)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localObject2 != null)
        {
          Object localObject1 = ((afso)localObject2).a();
          localObject2 = ((afso)localObject2).a();
          if ((localObject1 != null) && (localObject2 != null))
          {
            ((afsn)localObject2).a((View)localObject1, (FileMsg)paramMessage.obj, paramMessage.what, paramMessage.arg1);
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
        OpenApiManager.getInstance().onFileTransStatusChanged((FileMsg)paramMessage.obj, paramMessage.what, paramMessage.arg1);
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
  public void a(View paramView, afsn paramafsn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	afsl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 227	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface 232 1 0
    //   16: ifeq +39 -> 55
    //   19: aload_3
    //   20: invokeinterface 235 1 0
    //   25: checkcast 198	afso
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 201	afso:a	()Landroid/view/View;
    //   35: aload_1
    //   36: if_acmpne -26 -> 10
    //   39: aload 4
    //   41: new 101	java/lang/ref/WeakReference
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 110	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   49: putfield 238	afso:b	Ljava/lang/ref/WeakReference;
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield 35	afsl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   59: new 198	afso
    //   62: dup
    //   63: aload_0
    //   64: aload_1
    //   65: aload_2
    //   66: invokespecial 241	afso:<init>	(Lafsl;Landroid/view/View;Lafsn;)V
    //   69: invokevirtual 245	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: goto -21 -> 52
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	afsl
    //   0	81	1	paramView	View
    //   0	81	2	paramafsn	afsn
    //   9	11	3	localIterator	java.util.Iterator
    //   28	12	4	localafso	afso
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
 * Qualified Name:     afsl
 * JD-Core Version:    0.7.0.1
 */