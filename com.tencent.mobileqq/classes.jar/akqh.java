import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.lightGame.CmGameSocketConnection;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.apollo.CmGameMsgTunnel.TunnelMsgStream;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class akqh
  implements akqr, Handler.Callback, INetInfoHandler
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private akqi jdField_a_of_type_Akqi;
  private bhow jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  private CmGameSocketConnection jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public akqh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("CmGameConnManager", 1, "parse uin exception=", paramQQAppInterface);
    }
  }
  
  private void a(CmGameMsgTunnel.TunnelMsgStream paramTunnelMsgStream)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnManager", 2, "[handleCmGameMsgRsp]");
    }
  }
  
  private byte[] a(short paramShort, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Akqi == null)
    {
      QLog.w("CmGameConnManager", 1, "[encodeMsgStream] no conn info");
      return null;
    }
    Object localObject = new CmGameMsgTunnel.TunnelMsgStream();
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).platform.set(109L);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).osver.set(Build.VERSION.RELEASE);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).mqqver.set("8.3.3");
    if (!TextUtils.isEmpty(paramString)) {
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).cmd.set(paramString);
    }
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).seq.set(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).distribute_ts.set(this.jdField_a_of_type_Akqi.jdField_a_of_type_Long);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).src_uid.set(this.jdField_a_of_type_Long);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).dst_uid.set(paramLong);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).sign.set(this.jdField_a_of_type_Akqi.b);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).busi_buff.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramString = ((CmGameMsgTunnel.TunnelMsgStream)localObject).toByteArray();
    try
    {
      paramString = akro.a(paramString, this.jdField_a_of_type_Akqi.jdField_a_of_type_JavaLangString);
      paramArrayOfByte = ByteBuffer.allocate(23);
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
      paramArrayOfByte.putInt(439041101);
      paramArrayOfByte.put((byte)1);
      paramArrayOfByte.putShort(paramShort);
      paramArrayOfByte.putInt(paramString.length);
      paramArrayOfByte.putInt(2);
      paramArrayOfByte.putLong(this.jdField_a_of_type_Long);
      paramArrayOfByte = paramArrayOfByte.array();
      localObject = new byte[paramString.length + 23];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
      System.arraycopy(paramString, 0, localObject, 23, paramString.length);
      return localObject;
    }
    catch (Exception paramString)
    {
      QLog.w("CmGameConnManager", 1, "[encodeMsgStream] encrypt exception");
    }
    return null;
  }
  
  private byte[] a(short paramShort, String paramString, byte[] paramArrayOfByte)
  {
    return a(paramShort, paramString, 0L, paramArrayOfByte);
  }
  
  private void b(CmGameMsgTunnel.TunnelMsgStream paramTunnelMsgStream)
  {
    ((akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(paramTunnelMsgStream);
  }
  
  private boolean b()
  {
    QLog.d("CmGameConnManager", 1, "[createConnection]");
    if (this.jdField_a_of_type_Akqi == null)
    {
      QLog.e("CmGameConnManager", 1, "[createConnection] no connection info");
      return false;
    }
    if ((this.jdField_a_of_type_Akqi.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Akqi.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      QLog.e("CmGameConnManager", 1, "[createConnection] no connection host");
      return false;
    }
    akqt localakqt = new akqt();
    localakqt.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Akqi.jdField_a_of_type_JavaUtilList;
    localakqt.jdField_a_of_type_Int = this.jdField_a_of_type_Akqi.jdField_a_of_type_Int;
    localakqt.b = 10000;
    localakqt.c = 3000;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection = new CmGameSocketConnection(localakqt);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a(localakqt);
    }
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        QLog.d("CmGameConnManager", 1, "[openConnection]");
        this.jdField_a_of_type_Boolean = true;
        if ((a()) || (this.b))
        {
          QLog.d("CmGameConnManager", 1, new Object[] { "[openConnection] already connected or connecting, mIsConnecting=", Boolean.valueOf(this.b) });
          return;
        }
        this.b = true;
        if (!bdee.e(BaseApplicationImpl.getApplication().getApplicationContext()))
        {
          QLog.d("CmGameConnManager", 1, "[openConnection] network unavailable");
          this.b = false;
        }
        else
        {
          ((bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).e();
        }
      }
      finally {}
    }
  }
  
  private void g()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      QLog.d("CmGameConnManager", 1, "[closeConnection]");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.e();
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a(false);
    }
  }
  
  private void i()
  {
    try
    {
      QLog.d("CmGameConnManager", 1, new Object[] { "[reconnect] mShouldKeepConnect=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      h();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        f();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    QLog.d("CmGameConnManager", 1, "[wakeup]");
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.b();
    }
  }
  
  public void a(akqi paramakqi)
  {
    QLog.d("CmGameConnManager", 1, "[onGetConnInfoSuccess]");
    if (paramakqi == null) {
      QLog.e("CmGameConnManager", 1, "[onGetConnInfoSuccess] gameConnInfo null");
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Akqi = paramakqi;
      }
      for (boolean bool = b(); !bool; bool = false)
      {
        this.b = false;
        return;
      }
    }
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    if (paramMsfSocketInputBuffer == null)
    {
      QLog.e("CmGameConnManager", 1, "[receive] buffer null");
      return;
    }
    int i = paramMsfSocketInputBuffer.getBufferlen();
    if (i <= 23)
    {
      QLog.e("CmGameConnManager", 1, "[receive] invalid buffer length");
      return;
    }
    Object localObject = ByteBuffer.wrap(paramMsfSocketInputBuffer.getBuffer(), 0, 23);
    int j = ((ByteBuffer)localObject).getInt();
    if (j != 439041101)
    {
      QLog.e("CmGameConnManager", 1, "[receive] invalid magic");
      return;
    }
    byte b1 = ((ByteBuffer)localObject).get();
    short s = ((ByteBuffer)localObject).getShort();
    int k = ((ByteBuffer)localObject).getInt();
    int m = ((ByteBuffer)localObject).getInt();
    long l = ((ByteBuffer)localObject).getLong();
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnManager", 2, new Object[] { "[receive] header, magic=", Integer.valueOf(j), ", protocolVersion=", Byte.valueOf(b1), ", type=", Short.valueOf(s), ", appid=", Integer.valueOf(m), ", bodyLength=", Integer.valueOf(k), ", srcUin=", Long.valueOf(l) });
    }
    if (s == 6)
    {
      QLog.e("CmGameConnManager", 1, "[receive] invalid key");
      this.jdField_a_of_type_Bhow.removeMessages(5);
      paramMsfSocketInputBuffer = this.jdField_a_of_type_Bhow.obtainMessage(5);
      paramMsfSocketInputBuffer.obj = Boolean.valueOf(true);
      this.jdField_a_of_type_Bhow.sendMessage(paramMsfSocketInputBuffer);
      return;
    }
    localObject = new byte[i - 23];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 23, localObject, 0, i - 23);
    try
    {
      paramMsfSocketInputBuffer = akro.b((byte[])localObject, this.jdField_a_of_type_Akqi.jdField_a_of_type_JavaLangString);
      localObject = new CmGameMsgTunnel.TunnelMsgStream();
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).mergeFrom(paramMsfSocketInputBuffer);
      if (s == 3)
      {
        a((CmGameMsgTunnel.TunnelMsgStream)localObject);
        return;
      }
    }
    catch (Exception paramMsfSocketInputBuffer)
    {
      QLog.e("CmGameConnManager", 1, "[receive] get pb failed, e=", paramMsfSocketInputBuffer);
      return;
    }
    if (s == 4)
    {
      b((CmGameMsgTunnel.TunnelMsgStream)localObject);
      return;
    }
    if (s == 2)
    {
      QLog.d("CmGameConnManager", 1, new Object[] { "[receive] error, code=", Integer.valueOf(((CmGameMsgTunnel.TunnelMsgStream)localObject).ret.get()) });
      return;
    }
    QLog.e("CmGameConnManager", 1, new Object[] { "[receive] stream type not support yet, streamType=", Short.valueOf(s) });
  }
  
  public void a(String paramString)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      QLog.d("CmGameConnManager", 1, new Object[] { "[onCmGamePageEnter] tag=", paramString, ", size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      this.jdField_a_of_type_Bhow.removeMessages(2);
      if (!a())
      {
        this.jdField_a_of_type_Bhow.removeMessages(1);
        this.jdField_a_of_type_Bhow.sendEmptyMessage(1);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = bdee.e(BaseApplicationImpl.getApplication().getApplicationContext());
    QLog.d("CmGameConnManager", 1, new Object[] { "[onDisconnect] shouldReconnect=", Boolean.valueOf(paramBoolean), ", networkAvailable=", Boolean.valueOf(bool) });
    if ((paramBoolean) && (bool)) {
      i();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnManager", 2, new Object[] { "[updateMatchWebPageStatus] isAlive=", Boolean.valueOf(paramBoolean1), ", wakeup=", Boolean.valueOf(paramBoolean2) });
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Bhow.removeMessages(7);
      this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(7, 130000L);
      a("page_tag_match");
      if ((a()) && (paramBoolean2)) {
        a();
      }
      return;
    }
    b("page_tag_match");
    this.jdField_a_of_type_Bhow.removeMessages(7);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a());
  }
  
  public byte[] a()
  {
    return a((short)1, "heartbeat", null);
  }
  
  public void b()
  {
    QLog.d("CmGameConnManager", 1, new Object[] { "[onGetConnInfoFailed] mShouldKeepConnect=", Boolean.valueOf(this.jdField_a_of_type_Boolean), ", mConnInfo=", this.jdField_a_of_type_Akqi });
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Akqi != null)) {}
    for (boolean bool = b();; bool = false)
    {
      if (!bool) {
        this.b = false;
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramString);
      QLog.d("CmGameConnManager", 1, new Object[] { "[onCmGamePageLeave] tag=", paramString, ", size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_a_of_type_Bhow.removeMessages(1);
        this.jdField_a_of_type_Bhow.removeMessages(2);
        this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(2, 2000L);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c()
  {
    QLog.d("CmGameConnManager", 1, "[onConnectSuccess]");
    this.b = false;
  }
  
  public void d()
  {
    QLog.d("CmGameConnManager", 1, new Object[] { "[onConnectFailed] mRetryCounter=", Integer.valueOf(this.jdField_a_of_type_Int), ", mShouldKeepConnect=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    this.b = false;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int <= 2))
    {
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Bhow.removeMessages(1);
      this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(1, 10000L);
    }
  }
  
  public void e()
  {
    QLog.d("CmGameConnManager", 1, "[onDestroy]");
    this.jdField_a_of_type_Bhow.removeCallbacksAndMessages(null);
    g();
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_OPEN_CONNECTION");
      f();
      return false;
    case 2: 
      QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_CLOSE_CONNECTION");
      g();
      return false;
    case 4: 
      QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_DISCONNECT");
      h();
      return false;
    case 5: 
      QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_RECONNECT");
      if ((paramMessage.obj != null) && (((Boolean)paramMessage.obj).booleanValue()))
      {
        QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_RECONNECT, reset conn info");
        this.jdField_a_of_type_Akqi = null;
      }
      i();
      return false;
    case 7: 
      QLog.w("CmGameConnManager", 1, "[handleMessage] MSG_CHECK_MATCH_PAGE_REPORT_TIMEOUT");
      b("page_tag_match");
      return false;
    }
    QQToast.a(BaseApplicationImpl.getContext(), (String)paramMessage.obj, 0).a();
    return false;
  }
  
  public void onNetMobile2None()
  {
    QLog.d("CmGameConnManager", 1, "[onNetMobile2None]");
    this.jdField_a_of_type_Bhow.removeMessages(4);
    this.jdField_a_of_type_Bhow.sendEmptyMessage(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.d("CmGameConnManager", 1, "[onNetMobile2Wifi]");
    this.jdField_a_of_type_Bhow.removeMessages(5);
    this.jdField_a_of_type_Bhow.sendEmptyMessage(5);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.d("CmGameConnManager", 1, "[onNetNone2Mobile]");
    this.jdField_a_of_type_Bhow.removeMessages(5);
    this.jdField_a_of_type_Bhow.sendEmptyMessage(5);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.d("CmGameConnManager", 1, "[onNetNone2Wifi]");
    this.jdField_a_of_type_Bhow.removeMessages(5);
    this.jdField_a_of_type_Bhow.sendEmptyMessage(5);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.d("CmGameConnManager", 1, "[onNetWifi2Mobile]");
    this.jdField_a_of_type_Bhow.removeMessages(5);
    this.jdField_a_of_type_Bhow.sendEmptyMessage(5);
  }
  
  public void onNetWifi2None()
  {
    QLog.d("CmGameConnManager", 1, "[onNetWifi2None]");
    this.jdField_a_of_type_Bhow.removeMessages(4);
    this.jdField_a_of_type_Bhow.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqh
 * JD-Core Version:    0.7.0.1
 */