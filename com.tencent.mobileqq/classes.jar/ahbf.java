import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.1;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.12;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.13;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.2;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.6;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.7;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.8;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.9;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituRequest;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituResponse;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg.ReqBody;
import com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.zhitu.gate.ZhituSafeGate.ReqBody;

public class ahbf
  implements ahcf, Handler.Callback, Manager
{
  private static int jdField_a_of_type_Int;
  private static volatile boolean h;
  private static volatile boolean i;
  private long jdField_a_of_type_Long;
  private ahbl jdField_a_of_type_Ahbl;
  private ahbn jdField_a_of_type_Ahbn;
  private ahbo jdField_a_of_type_Ahbo;
  public ahbr a;
  public ahbu a;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public LinearLayout a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ZhituPanelView a;
  public DoutuEmotionHorizonListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private List<baub> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private BlockingDeque<ahbx> jdField_a_of_type_JavaUtilConcurrentBlockingDeque = new LinkedBlockingDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler = new ahbk(this, Looper.getMainLooper());
  private volatile String jdField_b_of_type_JavaLangString = "";
  private List<String> jdField_b_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  private Map<String, ZhituResponse> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private Map<File, Boolean> jdField_d_of_type_JavaUtilMap;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  private final int jdField_f_of_type_Int = 180;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 180;
  private boolean jdField_g_of_type_Boolean;
  
  public ahbf(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    f();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    }
    return 5;
  }
  
  private int a(String paramString)
  {
    try
    {
      int j = Integer.parseInt(paramString);
      switch (j)
      {
      }
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ZhituManager", 2, "img response has invalid style");
    }
    return 2;
    return 0;
    return 1;
    return 2;
  }
  
  public static ahbf a(AppInterface paramAppInterface)
  {
    return (ahbf)paramAppInterface.getManager(258);
  }
  
  @Nullable
  static Bitmap a(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a(localOutOfMemoryError);
    }
    return null;
  }
  
  @Nullable
  private Rect a(String paramString, ZhituImgResponse paramZhituImgResponse)
  {
    Rect localRect = new Rect();
    String[] arrayOfString = paramZhituImgResponse.coord.split("\\|");
    try
    {
      localRect.left = Integer.parseInt(arrayOfString[0]);
      localRect.top = Integer.parseInt(arrayOfString[1]);
      localRect.right = (localRect.left + Integer.parseInt(arrayOfString[2]));
      int j = localRect.top;
      localRect.bottom = (Integer.parseInt(arrayOfString[3]) + j);
      return localRect;
    }
    catch (Exception localException)
    {
      QLog.d("ZhituManager", 1, a(paramString, "startImgGenerate", "unknown rect format: " + paramZhituImgResponse.coord));
    }
    return null;
  }
  
  static AbstractGifImage a(String paramString)
  {
    paramString = BaseApplicationImpl.sImageCache.get(paramString);
    if ((paramString instanceof Pair)) {
      return (AbstractGifImage)((Pair)paramString).first;
    }
    return null;
  }
  
  private File a()
  {
    return new File(b(), "font");
  }
  
  private File a(ZhituImgResponse paramZhituImgResponse)
  {
    return a(c(), paramZhituImgResponse);
  }
  
  private File a(File paramFile, ZhituImgResponse paramZhituImgResponse)
  {
    return new File(paramFile, a(paramZhituImgResponse));
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 0: 
      return "c2c";
    case 3000: 
      return "discussion";
    case 1: 
      return "troop";
    }
    return "kandian";
  }
  
  @NonNull
  private String a(ZhituImgResponse paramZhituImgResponse)
  {
    return bhqh.a(paramZhituImgResponse.url) + "_" + paramZhituImgResponse.md5;
  }
  
  static String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return a(paramString1, paramString2, "[" + paramInt + "]" + paramString3);
  }
  
  static String a(String paramString1, String paramString2, String paramString3)
  {
    return String.format("[%s][%s]: %s", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  private void a(int paramInt1, ZhituResponse paramZhituResponse, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "onResponse", "error code: " + paramInt1 + " / " + paramZhituResponse + " startIdx: " + paramInt2));
    }
    if (paramInt1 != 0) {
      return;
    }
    a(paramString1, paramZhituResponse);
    a(paramZhituResponse, paramString1, paramInt2, paramString2);
  }
  
  private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    if (!paramString1.equals(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ahbw localahbw = new ahbw();
    localahbw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources(), paramBitmap2);
    if (paramBitmap1 != null)
    {
      paramBitmap1 = new BitmapDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources(), paramBitmap1);
      localahbw.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramBitmap1;
      localahbw.jdField_b_of_type_Boolean = false;
      if (paramInt != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      localahbw.jdField_d_of_type_Boolean = bool;
      localahbw.jdField_e_of_type_Boolean = paramBoolean;
      a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, localahbw);
      h(localahbw);
      return;
      paramBitmap1 = null;
      break;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("ReqUniqueKey");
    if (!a().equals(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "reqKey is outdated, skip."));
      }
    }
    int j;
    int k;
    do
    {
      return;
      j = paramBundle.getInt("RetryCount", 0);
      k = paramBundle.getInt("IdxInRes");
      str1 = paramBundle.getString("ReqUniqueKey");
      if (j < 3) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "max retry limitation is reached."));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "current retry count is " + j));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "retry img download"));
    }
    paramBundle.putInt("RetryCount", j + 1);
    ZhituResponse localZhituResponse = (ZhituResponse)paramBundle.getParcelable("ZhituRespose");
    ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)paramBundle.getParcelable("ImgResponse");
    String str2 = paramBundle.getString("QueryText");
    paramBundle.remove("ErrorCode");
    a(localZhituResponse, str1, this.jdField_a_of_type_ComTencentCommonAppAppInterface, k, localZhituImgResponse, str2, paramBundle);
  }
  
  private void a(Message paramMessage)
  {
    Object localObject = (Bundle)paramMessage.obj;
    paramMessage = ((Bundle)localObject).getString("ReqUniqueKey");
    if (!a().equals(paramMessage)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "reqKey is outdated, skip."));
      }
    }
    ZhituResponse localZhituResponse;
    ZhituImgResponse localZhituImgResponse;
    int k;
    do
    {
      return;
      localZhituResponse = (ZhituResponse)((Bundle)localObject).getParcelable("ZhituRespose");
      localZhituImgResponse = (ZhituImgResponse)((Bundle)localObject).getParcelable("ImgResponse");
      k = ((Bundle)localObject).getInt("IdxInRes");
      localObject = ((Bundle)localObject).getString("QueryText");
      if ((localZhituResponse != null) && (localZhituImgResponse != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "originResponse or originImgResponse is null, skip."));
    return;
    int m = a(localZhituImgResponse.style);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", k, "style is " + m));
    }
    if (b() == 1) {}
    for (int j = 1; m != 2; j = 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new ZhituManager.6(this, paramMessage, k, localZhituResponse, localZhituImgResponse, m, (String)localObject));
      return;
    }
    if (j != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "zhitutest handleImgDownloadSucc key = " + paramMessage + " |idxinRes = " + k + " | originQueryText = " + (String)localObject);
      }
      if (a(paramMessage, localZhituImgResponse) != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new ZhituManager.7(this, paramMessage, k, localZhituResponse, localZhituImgResponse, m, (String)localObject));
        return;
      }
      a(paramMessage, k, localZhituImgResponse);
      return;
    }
    a(paramMessage, k, localZhituImgResponse);
  }
  
  private void a(MessageQueue paramMessageQueue)
  {
    paramMessageQueue.addIdleHandler(new ahbi(this));
    b(paramMessageQueue);
  }
  
  private void a(AbstractGifImage paramAbstractGifImage, ahcd paramahcd, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (!paramString3.equals(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString3, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ahbw localahbw = new ahbw();
    localahbw.jdField_a_of_type_Ahcd = paramahcd;
    localahbw.jdField_b_of_type_Boolean = true;
    localahbw.c = paramString1;
    localahbw.jdField_b_of_type_JavaLangString = paramString2;
    localahbw.jdField_a_of_type_Boolean = true;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localahbw.jdField_d_of_type_Boolean = bool;
      a(paramString3, paramInt, paramString4, paramString5, paramString6, paramString7, localahbw);
      paramahcd = b(localahbw);
      a(paramahcd, paramAbstractGifImage);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(new ZhituManager.8(this, paramahcd));
      }
      h(localahbw);
      return;
    }
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = paramZhituResponse.list;
    if (localObject == null)
    {
      QLog.d("ZhituManager", 1, a(paramString1, "handleZhituResponse", "the list is null"));
      if (paramInt == 0) {
        a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources().getString(2131721509));
      }
    }
    int j;
    do
    {
      return;
      this.jdField_c_of_type_JavaUtilMap.put(paramString1, paramZhituResponse);
      if ((paramInt == 0) && (((List)localObject).isEmpty()))
      {
        a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources().getString(2131721509));
        return;
      }
      j = Math.min(((List)localObject).size(), d() + paramInt);
      if (!a(paramZhituResponse, (List)localObject, paramInt, j, paramString1, paramString2))
      {
        QLog.d("ZhituManager", 1, a(paramString1, "handleZhituResponse", "fail to start download"));
        return;
      }
      localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(6);
      ((Message)localObject).arg1 = (j - paramInt);
      if (paramInt == 0) {
        ((Message)localObject).arg1 += 1;
      }
      ((Message)localObject).arg2 = paramZhituResponse.hasMore;
      ((Message)localObject).obj = paramString1;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    } while (paramInt != 0);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new ZhituManager.9(this, paramZhituResponse, paramString1, j, paramString2));
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, AppInterface paramAppInterface, int paramInt, ZhituImgResponse paramZhituImgResponse, String paramString2, Bundle paramBundle)
  {
    int j = 1;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putParcelable("ZhituRespose", paramZhituResponse);
    localBundle.putParcelable("ImgResponse", paramZhituImgResponse);
    localBundle.putString("ReqUniqueKey", paramString1);
    localBundle.putInt("IdxInRes", paramInt);
    localBundle.putString("QueryText", paramString2);
    localBundle.putLong("StartTs", System.currentTimeMillis());
    paramZhituResponse = a(paramZhituImgResponse);
    if (paramZhituResponse.exists())
    {
      b(paramZhituResponse.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, "md5 matched, the origin img is downloaded and just skip download."));
      }
      if (this.jdField_e_of_type_Int != 2)
      {
        boolean bool = paramZhituResponse.setLastModified(System.currentTimeMillis());
        if ((this.jdField_e_of_type_Int == 0) && (QLog.isColorLevel())) {
          QLog.d("ZhituManager", 2, "set last modified time is supported? " + bool);
        }
        if (!bool) {
          break label223;
        }
      }
      label223:
      for (paramInt = j;; paramInt = 2)
      {
        this.jdField_e_of_type_Int = paramInt;
        paramZhituResponse = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
        paramZhituResponse.obj = localBundle;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramZhituResponse);
        return;
      }
    }
    if (this.jdField_a_of_type_Ahbl == null) {
      this.jdField_a_of_type_Ahbl = new ahbl(this.jdField_a_of_type_AndroidOsHandler);
    }
    paramZhituImgResponse = paramZhituImgResponse.url;
    paramAppInterface = paramAppInterface.getNetEngine(0);
    paramString2 = new baub();
    paramString2.jdField_a_of_type_Boolean = true;
    paramString2.jdField_e_of_type_Boolean = true;
    paramString2.jdField_a_of_type_Baug = this.jdField_a_of_type_Ahbl;
    paramString2.jdField_a_of_type_Int = 0;
    paramString2.jdField_a_of_type_JavaLangString = paramZhituImgResponse;
    paramString2.c = paramZhituResponse.getAbsolutePath();
    paramString2.jdField_e_of_type_Int = 0;
    paramString2.a(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, "start send img download request, " + paramZhituImgResponse));
    }
    this.jdField_a_of_type_JavaUtilList.add(paramString2);
    paramAppInterface.a(paramString2);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, ZhituRequest paramZhituRequest, int paramInt, Handler paramHandler)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), ahca.class);
    String str = bdcs.a(paramZhituRequest).toString();
    localNewIntent.putExtra("ZhituCMD", "AIMessage.Text2Image");
    localNewIntent.putExtra("ZhituRequestBytes", str.getBytes());
    a(localNewIntent, paramHandler);
    localNewIntent.putExtra("ZhituReqKey", paramString);
    localNewIntent.putExtra("StartIdx", paramInt);
    localNewIntent.putExtra("QueryText", paramZhituRequest.text);
    paramQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "realSendZhituRequest", "send request: " + paramZhituRequest));
    }
    azqs.b(paramQQAppInterface, "dc00898", "", "", "0X800ADCB", "0X800ADCB", 0, 0, "", "", paramZhituRequest.text, "");
  }
  
  private void a(File paramFile)
  {
    try
    {
      if (this.jdField_d_of_type_JavaUtilMap == null) {
        this.jdField_d_of_type_JavaUtilMap = new HashMap();
      }
      if (!this.jdField_d_of_type_JavaUtilMap.containsKey(paramFile))
      {
        File localFile = new File(paramFile, ".nomedia");
        if ((!localFile.exists()) && (localFile.createNewFile())) {
          this.jdField_d_of_type_JavaUtilMap.put(paramFile, Boolean.valueOf(true));
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(OutOfMemoryError paramOutOfMemoryError)
  {
    azpo.a(paramOutOfMemoryError, "ZhituCreateBitmapCatchedExceptionOOM when create bitmap with count: " + jdField_a_of_type_Int);
    QLog.d("ZhituManager", 1, "create bitmap but oom, " + jdField_a_of_type_Int);
  }
  
  private void a(String paramString)
  {
    paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(11, paramString);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  private void a(String paramString, int paramInt, ZhituImgResponse paramZhituImgResponse)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "passThroughOriginImg", paramInt, "start"));
    }
    String str = paramZhituImgResponse.url;
    if (".gif".equalsIgnoreCase(str.substring(str.lastIndexOf(".")))) {
      try
      {
        str = a(paramZhituImgResponse).getAbsolutePath();
        a(new NativeGifImage(new File(str), false), null, str, str, paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
        return;
      }
      catch (IOException paramZhituImgResponse)
      {
        QLog.e("ZhituManager", 1, a(paramString, "passThroughOriginImg", "convert to gif drawable fail"));
        return;
      }
    }
    a(null, BitmapFactory.decodeFile(a(paramZhituImgResponse).getAbsolutePath()), paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass, false);
  }
  
  private void a(String paramString1, int paramInt1, ZhituResponse paramZhituResponse, ZhituImgResponse paramZhituImgResponse, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "startImgGenerate", paramInt1, "start"));
    }
    jdField_a_of_type_Int += 1;
    String str = paramZhituImgResponse.url;
    Object localObject = str.substring(str.lastIndexOf("."));
    Rect localRect = a(paramString1, paramZhituImgResponse);
    if (localRect == null) {
      return;
    }
    str = a(paramZhituImgResponse).getAbsolutePath();
    long l = System.currentTimeMillis();
    if (".gif".equalsIgnoreCase((String)localObject)) {}
    for (;;)
    {
      int j;
      try
      {
        if (b() != 1) {
          continue;
        }
        j = 1;
      }
      catch (IOException paramZhituResponse)
      {
        QLog.e("ZhituManager", 1, a(paramString1, "startImgGenerate", paramInt1, "open gif file fail, " + paramZhituResponse));
        return;
        j = 0;
        break label602;
        localObject = new NativeGifImage(new File(str), false);
        a((AbstractGifImage)localObject, ahcb.a().a(((NativeGifImage)localObject).getWidth(), ((NativeGifImage)localObject).getHeight(), paramString2, paramZhituResponse.tokens, paramZhituImgResponse.textColor, localRect, paramInt2, paramString1, paramInt1, this.jdField_a_of_type_AndroidGraphicsTypeface), str, null, paramString1, paramInt1, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
        return;
      }
      catch (OutOfMemoryError paramString1)
      {
        a(paramString1);
        return;
      }
      localObject = new ahbd(new File(str), false, 0.0F);
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "get width: " + paramInt1 + " / " + ((ahbd)localObject).getWidth() + " / " + ((ahbd)localObject).d());
      }
      paramZhituResponse = ahcb.a().a(((ahbd)localObject).getWidth(), ((ahbd)localObject).getHeight(), paramString2, paramZhituResponse.tokens, paramZhituImgResponse.textColor, localRect, paramInt2, paramString1, paramInt1, this.jdField_a_of_type_AndroidGraphicsTypeface);
      ((ahbd)localObject).a(paramZhituResponse);
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "generateGifImage", paramInt1, "take time " + Long.toString(System.currentTimeMillis() - l)));
      }
      a((AbstractGifImage)localObject, paramZhituResponse, str, null, paramString1, paramInt1, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
      return;
      try
      {
        localObject = BitmapFactory.decodeFile(str);
        if (localObject == null)
        {
          QLog.e("ZhituManager", 1, a(paramString1, "generateZhitu", paramInt1, "decode bitmap fail"));
          return;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        QLog.e("ZhituManager", 1, "decode origin file but oom");
        return;
      }
      paramZhituResponse = ahcb.a().a(str, paramString2, paramZhituResponse.tokens, paramZhituImgResponse.textColor, localRect, paramInt2, paramString1, paramInt1, this.jdField_a_of_type_AndroidGraphicsTypeface);
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "generateBitmap", paramInt1, "take time " + Long.toString(System.currentTimeMillis() - l)));
      }
      if (paramZhituResponse == null) {
        break;
      }
      a((Bitmap)localObject, paramZhituResponse, paramString1, paramInt1, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass, false);
      return;
      label602:
      if (paramInt1 != 0) {
        if (j == 0) {}
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, ahbw paramahbw)
  {
    paramahbw.jdField_d_of_type_JavaLangString = paramString1;
    paramahbw.jdField_a_of_type_Int = paramInt;
    paramahbw.jdField_a_of_type_JavaLangString = paramString2;
    paramahbw.jdField_e_of_type_JavaLangString = paramString3;
    paramString1 = new ahbx();
    paramString1.jdField_b_of_type_JavaLangString = paramString3;
    paramString1.c = paramString4;
    paramString1.jdField_a_of_type_JavaLangString = paramString5;
    paramString1.jdField_d_of_type_JavaLangString = b(this.jdField_c_of_type_Int);
    paramString1.jdField_e_of_type_JavaLangString = b();
    paramahbw.jdField_a_of_type_Ahbx = paramString1;
  }
  
  private void a(String paramString, AbstractGifImage paramAbstractGifImage)
  {
    paramAbstractGifImage = new Pair(paramAbstractGifImage, Integer.valueOf(paramAbstractGifImage.getByteSize()));
    BaseApplicationImpl.sImageCache.put(paramString, paramAbstractGifImage);
  }
  
  private void a(String paramString, ZhituResponse paramZhituResponse)
  {
    List localList = paramZhituResponse.list;
    if (localList == null)
    {
      QLog.d("ZhituManager", 1, a(paramString, "removeDuplicateImg", "the list is null"));
      return;
    }
    HashSet localHashSet = new HashSet(localList.size());
    ArrayList localArrayList = new ArrayList(localList.size());
    int j = 0;
    if (j < localList.size())
    {
      if (!localHashSet.add(localList.get(j))) {
        if (QLog.isColorLevel()) {
          QLog.e("ZhituManager", 2, a(paramString, "removeDuplicateImg", "find duplication res: " + localList.get(j)));
        }
      }
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(localList.get(j));
      }
    }
    paramZhituResponse.list = localArrayList;
  }
  
  private void a(List<baub> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cancel all pending net req: " + paramList.size());
    }
    baue localbaue = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localbaue.b((baub)paramList.next());
    }
  }
  
  private void a(NewIntent paramNewIntent, Handler paramHandler)
  {
    if (this.jdField_a_of_type_Ahbo == null) {
      this.jdField_a_of_type_Ahbo = new ahbo(paramHandler);
    }
    paramNewIntent.setObserver(this.jdField_a_of_type_Ahbo);
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(ZhituResponse paramZhituResponse, List<ZhituImgResponse> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "startImgDownload", "start / end idx: " + paramInt1 + " / " + paramInt2));
    }
    Object localObject = c();
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      QLog.d("ZhituManager", 1, a(paramString1, "startImgDownload", "can not create dir."));
      return false;
    }
    try
    {
      a((File)localObject);
      label98:
      int j;
      if (paramInt1 == 0) {
        j = 0;
      }
      while (paramInt1 < paramInt2)
      {
        localObject = (ZhituImgResponse)paramList.get(paramInt1 + j);
        a(paramZhituResponse, paramString1, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt1, (ZhituImgResponse)localObject, paramString2, null);
        paramInt1 += 1;
        continue;
        j = -1;
      }
      return true;
    }
    catch (IOException localIOException)
    {
      break label98;
    }
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    boolean bool3 = false;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {}
    for (boolean bool1 = a((QQAppInterface)localAppRuntime).b();; bool1 = false)
    {
      boolean bool2 = bool3;
      if (b(paramMessageForPic))
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      return 1;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    }
    return 4;
  }
  
  private File b()
  {
    return d();
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "tempchat";
    case 0: 
      return "c2c";
    case 3000: 
      return "discuss";
    case 1: 
      return "group";
    }
    return "kandian";
  }
  
  private static String b(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = bhpp.a(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, new Object[] { "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l) });
    }
    return paramString;
  }
  
  private void b(Message paramMessage)
  {
    int j = paramMessage.arg1;
    paramMessage = (String)paramMessage.obj;
    if (TextUtils.isEmpty(paramMessage)) {}
    ZhituResponse localZhituResponse;
    do
    {
      do
      {
        return;
        if (paramMessage.equals(a())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_REQUEST_MORE_IMG", "more img key is not the last req key, stop."));
      return;
      localZhituResponse = (ZhituResponse)this.jdField_c_of_type_JavaUtilMap.get(paramMessage);
    } while (localZhituResponse == null);
    a(localZhituResponse, paramMessage, j, b());
  }
  
  private void b(MessageQueue paramMessageQueue)
  {
    paramMessageQueue.addIdleHandler(new ahbj(this));
  }
  
  private void b(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "generateFullTextZhitu", paramInt, ""));
    }
    Bitmap localBitmap = a(200, 200);
    if (localBitmap == null) {}
    do
    {
      return;
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setColor(-1);
      Rect localRect = new Rect(0, 0, 200, 200);
      localCanvas.drawRect(localRect, localPaint);
      paramZhituResponse = ahcb.a().a(localBitmap, paramString2, paramZhituResponse.tokens, "#000000", localRect, 3, paramString1, paramInt, this.jdField_a_of_type_AndroidGraphicsTypeface);
      if (paramZhituResponse != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, "generate full text zhitu fail");
    return;
    a(null, paramZhituResponse, paramString1, paramInt, "http://img.qq.com/zhitu/fulltext.jpg", "mario" + System.currentTimeMillis(), "WhiteBack", null, true);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "realSendZhituSafeGateRequest start");
    }
    ZhituSafeGate.ReqBody localReqBody = new ZhituSafeGate.ReqBody();
    localReqBody.uint64_src_uin.set(Long.parseLong(paramQQAppInterface.c()));
    localReqBody.uint32_src_term.set(3);
    paramQQAppInterface = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ahca.class);
    paramQQAppInterface.putExtra("ZhituCMD", "ZhituGate.Check");
    paramQQAppInterface.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramQQAppInterface);
  }
  
  public static boolean b(MessageForPic paramMessageForPic)
  {
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isZhitu());
  }
  
  private File c()
  {
    return new File(bdzf.a(alof.aX + "zhitu" + File.separator + "origin/"));
  }
  
  private int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private File d()
  {
    return new File(bdzf.a(alof.aX + "zhitu"));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "cancelAllRequestMessage");
      }
      int j = 1;
      while (j < 10)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
        j += 1;
      }
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    if (h == paramBoolean) {
      return;
    }
    try
    {
      h = paramBoolean;
      return;
    }
    finally {}
  }
  
  private File e()
  {
    return new File(bdzf.a(alof.aX + "zhitu" + File.separator + "sent/"));
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      BaseApplicationImpl.sImageCache.remove(str);
    }
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public static void e(boolean paramBoolean)
  {
    if (i == paramBoolean) {
      return;
    }
    try
    {
      i = paramBoolean;
      return;
    }
    finally {}
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = bdne.w(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_b_of_type_Boolean = bdne.s(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_b_of_type_Int = bdne.aB(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_f_of_type_Boolean = bdne.x(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_g_of_type_Boolean = bdne.y(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Long = bdne.j(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_g_of_type_Int = bdne.aC(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.size() == 0) {}
    long l;
    LinkedList localLinkedList;
    do
    {
      return;
      l = System.currentTimeMillis();
      localLinkedList = new LinkedList();
      while ((!this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.isEmpty()) && ((localLinkedList.size() <= 100) || (!paramBoolean))) {
        localLinkedList.add(this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.poll());
      }
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        ZhituReportMsg.ReqBody localReqBody = ((ahbx)localIterator.next()).a();
        if (localReqBody != null)
        {
          NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ahca.class);
          localNewIntent.putExtra("ZhituCMD", "MQInference.ZhituReport");
          localNewIntent.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, "send " + localLinkedList.size() + " reports, take " + Long.toString(System.currentTimeMillis() - l));
  }
  
  public static boolean f()
  {
    try
    {
      boolean bool = i;
      return bool;
    }
    finally {}
  }
  
  private void g(ahbw paramahbw)
  {
    int j = 1;
    if (paramahbw == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "handleRequestDecodeGif font fail, picData is null.");
      }
    }
    for (;;)
    {
      return;
      if (b() == 1) {}
      String str;
      for (;;)
      {
        str = b(paramahbw);
        if (a(str) == null) {
          break;
        }
        h(paramahbw);
        return;
        j = 0;
      }
      try
      {
        if ((paramahbw.jdField_a_of_type_Ahcd != null) && ((paramahbw.jdField_d_of_type_Boolean) || (j != 0)))
        {
          localObject = new ahbd(new File(paramahbw.c), false, 0.0F);
          ((ahbd)localObject).a(paramahbw.jdField_a_of_type_Ahcd);
          a(str, (AbstractGifImage)localObject);
          this.jdField_b_of_type_JavaUtilList.add(str);
          h(paramahbw);
          return;
        }
        if (paramahbw.c == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ZhituManager", 2, "decode gif picData.originPath is null: " + paramahbw.toString());
        }
      }
      catch (IOException paramahbw)
      {
        Object localObject;
        while (QLog.isColorLevel())
        {
          QLog.d("ZhituManager", 2, "decode gif fail: " + paramahbw);
          return;
          localObject = new NativeGifImage(new File(paramahbw.c), false);
        }
      }
      catch (OutOfMemoryError paramahbw)
      {
        a(paramahbw);
      }
    }
  }
  
  public static boolean g()
  {
    try
    {
      boolean bool = h;
      return bool;
    }
    finally {}
  }
  
  private void h(ahbw paramahbw)
  {
    paramahbw = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, paramahbw);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramahbw);
  }
  
  private boolean h()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "getZhituSafeGateRequestTime = " + this.jdField_a_of_type_Long);
    }
    return this.jdField_a_of_type_Long;
  }
  
  public File a(@NonNull String paramString)
  {
    paramString = new File(paramString).getName() + "_" + System.currentTimeMillis();
    return new File(e(), paramString);
  }
  
  public File a(@NonNull String paramString1, @Nullable String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      return a(paramString2);
    }
    int j = paramString1.lastIndexOf("/") + 1;
    int k = paramString1.lastIndexOf(".");
    if (j < k) {}
    for (paramString1 = paramString1.substring(j, k);; paramString1 = "fakeFileName")
    {
      paramString1 = paramString1 + "_" + System.currentTimeMillis();
      return new File(e(), paramString1);
    }
  }
  
  public String a()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  public String a(ahbw paramahbw)
  {
    if ((!paramahbw.jdField_a_of_type_Boolean) || (paramahbw.jdField_a_of_type_Ahcd == null)) {
      return null;
    }
    return ahcb.a().a(paramahbw.c, paramahbw.jdField_a_of_type_Ahcd, paramahbw.jdField_d_of_type_JavaLangString, paramahbw.jdField_a_of_type_Int, this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getVisibility() == 0) && (this.jdField_a_of_type_Ahbr != null)) {
      this.jdField_a_of_type_Ahbr.b();
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
    {
      this.jdField_a_of_type_Ahbu = ((ahbu)this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.getAdapter());
      if (this.jdField_a_of_type_Ahbu != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Ahbu.a();
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.resetCurrentX(0);
    this.jdField_a_of_type_Ahbu.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituSafeGateRequestInterval: " + paramInt);
    }
    this.jdField_g_of_type_Int = paramInt;
    bdne.X(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "requestDownloadMoreImg", paramInt, ""));
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
    localMessage.obj = paramString;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; paramString = null)
    {
      azqs.b(paramString, "dc00898", "", "", "0X8008C73", "0X8008C73", a(this.jdField_c_of_type_Int), 0, "", "", "", "");
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituSafeGateRequestTime: " + paramLong);
    }
    this.jdField_a_of_type_Long = paramLong;
    bdne.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramLong);
  }
  
  public void a(ahbn paramahbn)
  {
    this.jdField_a_of_type_Ahbn = paramahbn;
  }
  
  public void a(ahbw paramahbw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "onSend:" + paramahbw);
    }
    this.jdField_b_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), b());
    this.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramahbw.jdField_e_of_type_JavaLangString);
    Object localObject = paramahbw.jdField_a_of_type_Ahbx;
    ((ahbx)localObject).jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.add(localObject);
    localObject = null;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    }
    azqs.b((QQAppInterface)localObject, "dc00898", "", "", "0X800ADCD", "0X800ADCD", 0, 0, "", "", paramahbw.jdField_e_of_type_JavaLangString, "");
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, boolean paramBoolean, MqqHandler paramMqqHandler)
  {
    if (paramViewGroup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : parentView is null.");
      }
      return;
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    Object localObject = (LinearLayout)paramViewGroup.findViewById(2131380398);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout != null.");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = ((DoutuEmotionHorizonListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380402));
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahbu = ((ahbu)this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.getAdapter());
      if ((this.jdField_a_of_type_Ahbu == null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
      {
        this.jdField_a_of_type_Ahbu = new ahbu(paramContext, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBaseActivity, paramSessionInfo, paramMqqHandler);
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setAdapter(this.jdField_a_of_type_Ahbu);
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setRecycleListener(this.jdField_a_of_type_Ahbu);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (paramMqqHandler == null) {
        break;
      }
      paramMqqHandler.removeMessages(84);
      paramMqqHandler.sendEmptyMessageDelayed(84, 10000L);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout == null.");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(paramContext, 2131558631, null));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = ((DoutuEmotionHorizonListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380402));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setOnScrollStateChangedListener(new ahbg(this));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setTouchListener(new ahbh(this, paramMqqHandler));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368344);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest start");
    }
    if (!arwq.a(paramQQAppInterface).a(paramQQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest isZhituLegalOpen is fales return");
      }
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis() - a();
      if (l >= c() * 60000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest time is short return time = " + l);
    return;
    b(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Editable paramEditable, List<ChatMessage> paramList, int paramInt, boolean paramBoolean)
  {
    e(true);
    paramList = paramEditable.toString();
    if (TextUtils.isEmpty(paramList)) {
      break label16;
    }
    label16:
    while ((paramList.length() > 24) || (!a(paramEditable))) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a().setEnabled(false);
    }
    a();
    d();
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ZhituThread", 8);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      if (Build.VERSION.SDK_INT >= 23)
      {
        a(this.jdField_a_of_type_AndroidOsHandler.getLooper().getQueue());
        label137:
        paramEditable = new ThreadPoolParams();
        paramEditable.corePoolsize = 1;
        paramEditable.maxPooolSize = 1;
        paramEditable.priority = 8;
        paramEditable.poolThreadName = "ZhituImgGenerateThreadPool";
        this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(paramEditable);
      }
    }
    else
    {
      paramEditable = bhqh.a(paramList) + "_" + System.currentTimeMillis();
      a(paramEditable, paramList);
      paramQQAppInterface = new ZhituManager.2(this, paramInt, paramQQAppInterface, paramEditable, paramList);
      paramQQAppInterface = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramQQAppInterface);
      paramList = this.jdField_a_of_type_AndroidOsHandler;
      if (!paramBoolean) {
        break label300;
      }
    }
    label300:
    for (long l = 500L;; l = 0L)
    {
      paramList.sendMessageDelayed(paramQQAppInterface, l);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ZhituManager", 2, a(paramEditable, "pending request", ""));
      return;
      this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(new ZhituManager.1(this));
      break label137;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, List<String> paramList, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "sendZhituRequest", "start sending request"));
    }
    ZhituRequest localZhituRequest = new ZhituRequest();
    localZhituRequest.uin = paramQQAppInterface.c();
    localZhituRequest.os = "android";
    localZhituRequest.text = paramString2;
    localZhituRequest.styles = 3;
    localZhituRequest.chat = a(paramInt1);
    localZhituRequest.version = "8.3.5";
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramQQAppInterface.c()))
    {
      paramString2 = new ahby();
      paramString2.jdField_a_of_type_JavaUtilList = paramList;
      paramString2.jdField_b_of_type_JavaLangString = ((String)this.jdField_b_of_type_JavaUtilMap.get(paramQQAppInterface.c()));
      paramString2.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.c()));
      paramString2.jdField_a_of_type_Int = b(paramInt1);
      localZhituRequest.report = paramString2;
    }
    a(paramQQAppInterface, paramString1, localZhituRequest, 0, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituConfigOpen: " + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    bdne.n(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "isZhituConfigOpen.zhituSwitch = " + this.jdField_b_of_type_Boolean);
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(Editable paramEditable)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (banh.a(paramEditable.toString()) <= -1)
    {
      if (!banh.a(paramEditable.toString())) {
        break label77;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "isLegal: " + bool1 + " / " + bhqh.a(paramEditable.toString()));
      }
      return bool1;
      label77:
      ArrayList localArrayList = new ArrayList();
      bciq.a(paramEditable, localArrayList);
      bool1 = bool2;
      if (localArrayList.size() <= 0) {
        bool1 = true;
      }
    }
  }
  
  public int b()
  {
    int k = 0;
    int j = k;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      j = k;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        j = arwq.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
      }
    }
    return j;
  }
  
  public String b()
  {
    try
    {
      String str = this.jdField_b_of_type_JavaLangString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NonNull
  String b(ahbw paramahbw)
  {
    int j = 1;
    if (b() == 1)
    {
      if (j == 0) {
        break label80;
      }
      localStringBuilder = new StringBuilder().append("Zhitu_").append(paramahbw.c).append("_");
      if (paramahbw.jdField_a_of_type_Ahcd != null) {
        break label66;
      }
    }
    label66:
    for (paramahbw = "origin";; paramahbw = Integer.valueOf(paramahbw.jdField_a_of_type_Ahcd.hashCode()))
    {
      return paramahbw;
      j = 0;
      break;
    }
    label80:
    StringBuilder localStringBuilder = new StringBuilder().append("Zhitu_").append(paramahbw.c).append("_");
    if (paramahbw.jdField_a_of_type_Ahcd == null) {
      paramahbw = "origin";
    }
    for (;;)
    {
      return paramahbw;
      if (paramahbw.jdField_d_of_type_Boolean) {
        paramahbw = Integer.valueOf(paramahbw.jdField_a_of_type_Ahcd.hashCode());
      } else {
        paramahbw = "origin";
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      localFile = b();
    } while ((!localFile.exists()) && (!localFile.mkdirs()));
    File localFile = new File(localFile, "font");
    if ((localFile.exists()) && ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(b(localFile.getAbsolutePath()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "startDownload Font but file is exist and correct");
      }
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(localFile);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    baue localbaue = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.jdField_e_of_type_Boolean = true;
    localbaub.jdField_a_of_type_Baug = new ahbm(this.jdField_a_of_type_AndroidOsHandler);
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/qq_desk/qqrm/smartgif/lantingyuan.ttf";
    localbaub.c = localFile.getAbsolutePath();
    localbaub.jdField_e_of_type_Int = 0;
    localbaue.a(localbaub);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setPageLen: " + paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    bdne.W(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt);
  }
  
  public void b(ahbw paramahbw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "onShow:" + paramahbw);
    }
    Object localObject = paramahbw.jdField_a_of_type_Ahbx;
    ((ahbx)localObject).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.add(localObject);
    localObject = null;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    }
    azqs.b((QQAppInterface)localObject, "dc00898", "", "", "0X800ADCC", "0X800ADCC", 0, 0, "", "", paramahbw.jdField_e_of_type_JavaLangString, "");
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituSaveAndShareSwitch: " + paramBoolean);
    }
    this.jdField_f_of_type_Boolean = paramBoolean;
    bdne.o(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public int c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "getZhituSafeGateRequestInterval = " + this.jdField_g_of_type_Int);
    }
    return this.jdField_g_of_type_Int;
  }
  
  public String c()
  {
    File localFile = e();
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return null;
    }
    try
    {
      a(localFile);
      label26:
      return localFile.getAbsolutePath();
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "hideZhituEmotionLayout.");
    }
    if ((h()) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      alaz.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "zhitu", false);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      a();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = null;
      this.jdField_a_of_type_Ahbu = null;
    }
    d();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ZhituManager.12(this));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 10000L);
    }
  }
  
  public void c(ahbw paramahbw)
  {
    paramahbw = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10, paramahbw);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramahbw);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituSafeGateSwitch: " + paramBoolean);
    }
    this.jdField_g_of_type_Boolean = paramBoolean;
    bdne.p(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "isZhituSafeGateSwitch = " + this.jdField_g_of_type_Boolean);
    }
    return this.jdField_g_of_type_Boolean;
  }
  
  public void d(ahbw paramahbw)
  {
    c(paramahbw);
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void e(ahbw paramahbw)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_Ahbu.a(paramahbw);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getVisibility() == 0)) {
      this.jdField_a_of_type_Ahbr.a(paramahbw);
    }
  }
  
  public boolean e()
  {
    if (g()) {}
    while ((!a()) || (!d())) {
      return false;
    }
    return true;
  }
  
  public void f(ahbw paramahbw)
  {
    if (this.jdField_a_of_type_Ahbn != null) {
      this.jdField_a_of_type_Ahbn.a(paramahbw);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 9: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 7: 
    case 100: 
    case 8: 
    case 101: 
      do
      {
        do
        {
          return true;
          ((Runnable)paramMessage.obj).run();
          return true;
          paramMessage = (Bundle)paramMessage.obj;
          ZhituResponse localZhituResponse = (ZhituResponse)paramMessage.getParcelable("Response");
          a(paramMessage.getInt("ErrorCode"), localZhituResponse, paramMessage.getString("UniqueKey"), paramMessage.getInt("StartIdx", 0), paramMessage.getString("QueryText"));
          return true;
          a(paramMessage);
          return true;
          a((Bundle)paramMessage.obj);
          return true;
          b(paramMessage);
          return true;
          paramMessage = a();
          if (paramMessage.exists()) {}
          for (paramMessage = Typeface.createFromFile(paramMessage);; paramMessage = null)
          {
            this.jdField_a_of_type_AndroidGraphicsTypeface = paramMessage;
            this.jdField_a_of_type_Boolean = true;
            return true;
          }
        } while (!(paramMessage.obj instanceof baub));
        this.jdField_a_of_type_JavaUtilList.remove(paramMessage.obj);
        return true;
        this.jdField_d_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, "download font fail, retry count: " + this.jdField_d_of_type_Int);
        }
      } while (this.jdField_d_of_type_Int > 3);
      b(Looper.myQueue());
      return true;
    }
    g((ahbw)paramMessage.obj);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = null;
      this.jdField_a_of_type_Ahbu = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
      this.jdField_a_of_type_Ahbr = null;
    }
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      d();
      this.jdField_a_of_type_AndroidOsHandler.post(new ZhituManager.13(this));
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutor instanceof ExecutorService)) {
      ((ExecutorService)this.jdField_a_of_type_JavaUtilConcurrentExecutor).shutdown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbf
 * JD-Core Version:    0.7.0.1
 */