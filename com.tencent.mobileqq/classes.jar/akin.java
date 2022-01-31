import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class akin
  extends ajtb
{
  private volatile int jdField_a_of_type_Int = 0;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new akip(this);
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  SparseArray<akis> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final ArrayList<akir> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedBlockingQueue<Integer> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue();
  private volatile boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public Messenger b;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public akin(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_b_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_AndroidOsHandler = new akio(this, Looper.getMainLooper(), paramQQAppInterface);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.w("UploadPhoto", 2, "TroopQZoneUploadAlbumHandler 已经被销毁，不能sumbmit");
    }
    b();
    if (!this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.contains(Integer.valueOf(paramInt))) {
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.offer(Integer.valueOf(paramInt));
    }
  }
  
  private void a(int paramInt1, akis paramakis, int paramInt2, int paramInt3)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), paramakis, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) };
    localMessage.sendToTarget();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1)) {}
    do
    {
      return;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("UploadPhoto", 2, "TroopQZoneUploadAlbumHandler 已经被销毁，不能doBindService");
    return;
    this.jdField_a_of_type_Int = 1;
    bgyp.a(this.app, this.jdField_a_of_type_AndroidContentServiceConnection);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      a();
    }
    while (this.jdField_a_of_type_AndroidOsMessenger == null) {
      return;
    }
    Message localMessage = Message.obtain(null, 999, paramInt, 0);
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("UploadPhoto", 5);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new TroopQZoneUploadAlbumHandler.2(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 3) {
      return;
    }
    BaseApplication.getContext().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
    this.jdField_a_of_type_Int = 3;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    akis localakis = (akis)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2, null);
    if (localakis == null) {
      return;
    }
    a(paramInt2, localakis, paramInt1, paramInt3);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, new akis(this, paramString, paramLong));
    }
    a(paramInt);
  }
  
  void a(long paramLong, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (akir)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((akir)localObject).a();
      localObject = ((akir)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((akiq)localObject).a(localView, paramLong, paramInt1, paramInt2);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
    }
  }
  
  public void a(View paramView, akiq paramakiq)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      akir localakir = (akir)localIterator.next();
      if (localakir.a() == paramView)
      {
        localakir.b = new WeakReference(paramakiq);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new akir(this, paramView, paramakiq));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject1 = paramQQAppInterface.a().a(paramString, 1, paramLong);
    if (localObject1 == null)
    {
      b(paramInt1);
      return;
    }
    if (((MessageRecord)localObject1).msgtype == -2011)
    {
      localObject2 = ((MessageForStructing)localObject1).structingMsg;
      if (!(localObject2 instanceof StructMsgForGeneralShare)) {}
    }
    for (Object localObject2 = (StructMsgForGeneralShare)localObject2;; localObject2 = null)
    {
      if ((localObject2 == null) || (((StructMsgForGeneralShare)localObject2).getProgress() < 0))
      {
        b(paramInt1);
        return;
      }
      if ((paramInt2 == 1001) && (((MessageRecord)localObject1).extraflag != 32768))
      {
        ((StructMsgForGeneralShare)localObject2).setSummary(BaseApplication.getContext().getResources().getString(2131690774));
        ((StructMsgForGeneralShare)localObject2).setProgress(paramInt3);
        return;
      }
      paramInt1 = 32772;
      localObject1 = BaseApplication.getContext().getResources().getString(2131690775);
      if ((paramInt2 == 1000) || (paramInt2 == 1004))
      {
        localObject1 = BaseApplication.getContext().getResources().getString(2131690775);
        paramInt1 = 32772;
      }
      for (;;)
      {
        ((StructMsgForGeneralShare)localObject2).setProgress(100);
        ((StructMsgForGeneralShare)localObject2).setSummary((String)localObject1);
        ((StructMsgForGeneralShare)localObject2).mMsgBrief = (ajya.a(2131715729) + (String)localObject1);
        paramQQAppInterface.a().a(paramString, 1, paramLong);
        paramQQAppInterface.a().a(paramString, 1, paramLong, paramInt1, 0);
        paramQQAppInterface.a().a(paramString, 1, paramLong, ((StructMsgForGeneralShare)localObject2).getBytes());
        notifyUI(999, true, paramString);
        return;
        if (paramInt2 == 1003)
        {
          localObject1 = BaseApplication.getContext().getResources().getString(2131690773);
          paramInt1 = 32768;
        }
        else if (paramInt2 == 1005)
        {
          localObject1 = BaseApplication.getContext().getResources().getString(2131690772);
          paramInt1 = 32770;
          ((StructMsgForGeneralShare)localObject2).mMsgActionData = "";
          ((StructMsgForGeneralShare)localObject2).mMsg_A_ActionData = "";
        }
      }
    }
  }
  
  public boolean a()
  {
    a();
    try
    {
      bgyp.a(this.app.getApp());
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      return true;
    }
    catch (Exception localException)
    {
      QLog.i("UploadPhoto", 1, "", localException);
    }
    return false;
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return akit.class;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("UploadPhoto", 2, "onDestroy");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
    }
    a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akin
 * JD-Core Version:    0.7.0.1
 */