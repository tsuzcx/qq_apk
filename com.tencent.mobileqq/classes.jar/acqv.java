import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator.1;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import common.config.service.QzoneConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class acqv
{
  public static int a;
  private static acqv jdField_a_of_type_Acqv;
  static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(bbft.d.pattern());
  public static boolean a;
  public static boolean b;
  private long jdField_a_of_type_Long = 86400000L;
  private DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  private Map<String, Long> jdField_a_of_type_JavaUtilMap;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int b = 15;
  private int jdField_c_of_type_Int = 10;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = -1;
  }
  
  public acqv()
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    ayvn.a().b();
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerator", 2, "DPC:" + str);
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length <= 5) {}
    }
    for (;;)
    {
      try
      {
        this.d = Integer.parseInt(arrayOfString[4]);
        this.jdField_a_of_type_Long = (Integer.parseInt(arrayOfString[5]) * 1000 * 60 * 60);
        if (arrayOfString.length > 6) {
          this.jdField_c_of_type_Int = Integer.parseInt(arrayOfString[6]);
        }
        i = j;
        if (this.jdField_c_of_type_Int > 30)
        {
          this.jdField_c_of_type_Int = 10;
          i = j;
        }
        if ((i == 0) && (QLog.isColorLevel())) {
          QLog.d("WebAccelerator", 2, "DPC not catch success[" + str + "]");
        }
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        try
        {
          this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open(((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getApp().getCacheDir(), 1, 1, 1048576L);
          return;
        }
        catch (Exception localException1)
        {
          this.jdField_c_of_type_Boolean = false;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
        return;
      }
      catch (Exception localException2)
      {
        this.jdField_c_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
        }
      }
      int i = 0;
    }
  }
  
  public static acqv a()
  {
    try
    {
      if (jdField_a_of_type_Acqv == null) {
        jdField_a_of_type_Acqv = new acqv();
      }
      acqv localacqv = jdField_a_of_type_Acqv;
      return localacqv;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      ThreadManager.post(new WebAccelerator.1(paramString, paramIntent, paramContext), 8, null, false);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqzone://arouse/qqexplaunchlive").append("?ec_title=" + paramString1).append("&ec_room_init_type=" + paramInt1).append("&ec_room_from_type=" + paramInt2).append("&ec_room_owner_id = " + paramString2);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqzone://arouse/qqexplivevideo").append("?ec_title=" + paramString3).append("&ec_room_id=" + paramString1).append("&ec_content=" + paramString4).append("&ec_room_init_type=3").append("&ec_room_from_type=" + paramInt).append("&ec_room_owner_id=" + paramString2);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    paramContext.startActivity(localIntent);
  }
  
  private final boolean a()
  {
    boolean bool = false;
    try
    {
      Object localObject1 = a();
      int j = ((SharedPreferences)localObject1).getInt("bankSize", 0);
      int i = j;
      if (j < this.b)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        i = j + 1;
        ((SharedPreferences.Editor)localObject1).putInt("bankSize", i);
        ((SharedPreferences.Editor)localObject1).commit();
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "shouldUseAccelerator:" + bool + "   " + i);
      }
      return bool;
    }
    finally {}
  }
  
  private final boolean a(int paramInt)
  {
    return (this.d & paramInt) == paramInt;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (amwu)ampl.a().a(158);
    if (paramContext != null) {}
    for (int i = paramContext.jdField_a_of_type_Int;; i = 0)
    {
      QLog.d("WebAccelerator", 1, "hasUrlSsoCheckSwitchOn isSSOCheckValidate = " + i);
      if (i != 1) {
        break;
      }
      return true;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent)
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZVideo", "qzone_eclive_livehost", "https://h5.qzone.qq.com/v2/audio-live/live/");
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.contains(str1))) {
      try
      {
        Object localObject = Uri.parse(paramString);
        paramString = ((Uri)localObject).getQueryParameter("hostuin");
        str1 = ((Uri)localObject).getQueryParameter("roomid");
        String str2 = ((Uri)localObject).getQueryParameter("feedid");
        localObject = ((Uri)localObject).getQueryParameter("roomstatus");
        if (!d(str1))
        {
          QLog.d("WebAccelerator", 2, "room_id not number!");
          return false;
        }
        localStringBuilder.append("mqqzone://arouse/qqexplivevideo").append("?ec_room_id=" + str1).append("&ec_room_owner_id=" + paramString).append("&ec_room_from_type2").append("&ec_room_init_type=3");
        localIntent.setData(Uri.parse(localStringBuilder.toString()));
        paramContext.startActivity(localIntent);
        paramContext = new axqt();
        paramContext.d = "kuolie_party";
        paramContext.e = "party_clk";
        paramContext.h = str2;
        paramContext.i = str1;
        paramContext.j = paramIntent.getStringExtra("title");
        paramContext.l = ((String)localObject);
        paramContext.m = paramString;
        paramContext.n = paramIntent.getStringExtra("friendUin");
        paramContext.o = "4";
        axqs.a(null, paramContext);
        return true;
      }
      catch (Exception paramContext)
      {
        QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
      }
    }
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramChatMessage.isSend())
    {
      if (!(paramChatMessage instanceof MessageForStructing)) {
        break label54;
      }
      AbsStructMsg localAbsStructMsg2 = ((MessageForStructing)paramChatMessage).structingMsg;
      AbsStructMsg localAbsStructMsg1 = localAbsStructMsg2;
      if (localAbsStructMsg2 == null) {
        localAbsStructMsg1 = axva.a(paramChatMessage.msgData);
      }
      if (!a(localAbsStructMsg1)) {
        break label106;
      }
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      label54:
      bool1 = bool2;
      if ((paramChatMessage instanceof MessageForText))
      {
        paramChatMessage = (MessageForText)paramChatMessage;
        bool1 = bool2;
        if (paramChatMessage.msg != null)
        {
          bool1 = bool2;
          if (!paramChatMessage.msg.equals(""))
          {
            bool1 = bool2;
            if (c(paramChatMessage.msg) != null)
            {
              return true;
              label106:
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public static final boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (paramAbsStructMsg != null) && ("web".equals(paramAbsStructMsg.mMsgAction)) && ((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!axut.a((AbsShareMsg)paramAbsStructMsg));
  }
  
  public static String c(@NonNull String paramString)
  {
    if (!paramString.contains("http")) {}
    Matcher localMatcher;
    do
    {
      return null;
      localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    } while (!localMatcher.find());
    return paramString.substring(localMatcher.start(), localMatcher.end());
  }
  
  private static boolean c(Context paramContext, String paramString, Intent paramIntent)
  {
    Object localObject1 = QzoneConfig.getInstance().getConfig("QZVideo", "qzone_eclive_livehost", "https://h5.qzone.qq.com/v2/audio-live/live/");
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith((String)localObject1))) {
      return a(paramContext, paramString, paramIntent);
    }
    Object localObject2 = QzoneConfig.getInstance().getConfig("QZVideo", "qzonelivevideo_livehost", "h5.qzone.qq.com/live/video/qzone/");
    int i = QzoneConfig.getInstance().getConfig("QZVideo", "module_jump_native", 1);
    Object localObject3 = QzoneConfig.getInstance().getConfig("Plato", "PlatoShareUrlPrefix", "plato.tswjs.org/share");
    int j = QzoneConfig.getInstance().getConfig("Plato", "qzoneplato_jump_native", 1);
    localObject1 = new Intent("android.intent.action.VIEW");
    ((Intent)localObject1).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject1).setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.contains((CharSequence)localObject2)))
    {
      try
      {
        localObject3 = Uri.parse(paramString);
        String str = ((Uri)localObject3).getQueryParameter("stayin");
        if ((i != 1) || ((str != null) && (TextUtils.equals(str, "1"))))
        {
          QLog.d("WebAccelerator", 1, "is_native not available, jump to H5, " + paramString);
          paramString = new Intent(paramContext, QQBrowserActivity.class);
          paramString.putExtra("url", ((Uri)localObject3).toString());
          paramString.setData((Uri)localObject3);
          paramContext.startActivity(paramString);
          return true;
        }
        localObject3 = paramIntent.getStringExtra("self_uin");
        i = paramString.lastIndexOf((String)localObject2);
        localObject2 = paramString.substring(localObject2.length() + i, paramString.length()).split("/")[0];
        if ((localObject3 == null) || (localObject2 == null) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break label734;
        }
        if (!d((String)localObject2))
        {
          QLog.d("WebAccelerator", 2, "room_id not number!");
          return false;
        }
        localObject2 = localStringBuilder.append("mqqzone://arouse/livevideo").append("?room=" + (String)localObject2).append("&uin=" + (String)localObject3).append("&video_play_source=12").append("&backup=" + URLEncoder.encode(paramString));
        localObject3 = new StringBuilder().append("&isEcLive=");
        if (paramIntent.getBooleanExtra("isEcLive", false)) {}
        for (paramString = "1";; paramString = "0")
        {
          ((StringBuilder)localObject2).append(paramString);
          ((Intent)localObject1).setData(Uri.parse(localStringBuilder.toString()));
          paramContext.startActivity((Intent)localObject1);
          return true;
        }
        if (TextUtils.isEmpty(paramString)) {
          break label732;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
        return false;
      }
    }
    else if (paramString.contains((CharSequence)localObject3))
    {
      if (j != 1) {
        return false;
      }
      try
      {
        paramIntent = bfnx.b(paramString.substring(paramString.lastIndexOf((String)localObject3) + ((String)localObject3).length() + 1));
        localStringBuilder.append("mqqzone://arouse/plato").append("?id=" + URLEncoder.encode((String)paramIntent.get("id")));
        if (!TextUtils.isEmpty((CharSequence)paramIntent.get("data"))) {
          localStringBuilder.append("&data=" + URLEncoder.encode((String)paramIntent.get("data")));
        }
        localStringBuilder.append("&url=" + URLEncoder.encode(paramString));
        ((Intent)localObject1).setData(Uri.parse(localStringBuilder.toString()));
        paramContext.startActivity((Intent)localObject1);
        return true;
      }
      catch (Exception paramContext)
      {
        QLog.d("WebAccelerator", 1, "arouse plato  parse url error!");
        return false;
      }
    }
    label732:
    return false;
    label734:
    return false;
  }
  
  public static final boolean c(String paramString)
  {
    return (paramString.startsWith("http://url.cn/")) || (paramString.startsWith("http%3A%2F%2Furl.cn%2F"));
  }
  
  private final String d(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      str1 = str2;
      localHttpURLConnection.setInstanceFollowRedirects(false);
      str1 = str2;
      localHttpURLConnection.connect();
      str1 = str2;
      paramString = localHttpURLConnection.getHeaderField("Location");
      str1 = paramString;
      QLog.d("WebAccelerator", 2, "code:" + localHttpURLConnection.getResponseCode());
    }
    catch (Exception localException)
    {
      do
      {
        paramString = str1;
      } while (!QLog.isColorLevel());
      QLog.e("WebAccelerator", 2, "doRedirect", localException);
    }
    return paramString;
    return str1;
  }
  
  public static boolean d(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  /* Error */
  public final SharedPreferences a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 630	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: ldc 91
    //   7: iconst_0
    //   8: invokevirtual 634	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: astore 5
    //   13: aload 5
    //   15: ldc_w 636
    //   18: lconst_0
    //   19: invokeinterface 640 4 0
    //   24: lstore_3
    //   25: lload_3
    //   26: lconst_0
    //   27: lcmp
    //   28: ifne +39 -> 67
    //   31: aload 5
    //   33: invokeinterface 277 1 0
    //   38: astore 6
    //   40: aload 6
    //   42: ldc_w 636
    //   45: invokestatic 646	java/lang/System:currentTimeMillis	()J
    //   48: invokeinterface 650 4 0
    //   53: pop
    //   54: aload 6
    //   56: invokeinterface 286 1 0
    //   61: pop
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: areturn
    //   67: invokestatic 646	java/lang/System:currentTimeMillis	()J
    //   70: lload_3
    //   71: lsub
    //   72: ldc2_w 54
    //   75: lcmp
    //   76: ifle -14 -> 62
    //   79: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +12 -> 94
    //   85: ldc 91
    //   87: iconst_2
    //   88: ldc_w 652
    //   91: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload 5
    //   96: invokeinterface 277 1 0
    //   101: astore 6
    //   103: aload 6
    //   105: ldc_w 636
    //   108: invokestatic 646	java/lang/System:currentTimeMillis	()J
    //   111: invokeinterface 650 4 0
    //   116: pop
    //   117: aload 6
    //   119: ldc_w 267
    //   122: iconst_0
    //   123: invokeinterface 283 3 0
    //   128: pop
    //   129: aload 6
    //   131: ldc_w 654
    //   134: iconst_0
    //   135: invokeinterface 283 3 0
    //   140: pop
    //   141: aload_0
    //   142: getfield 147	acqv:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   145: invokeinterface 657 1 0
    //   150: aload 5
    //   152: ldc_w 659
    //   155: iconst_0
    //   156: invokeinterface 273 3 0
    //   161: istore_1
    //   162: aload 6
    //   164: ldc_w 659
    //   167: iconst_0
    //   168: invokeinterface 283 3 0
    //   173: pop
    //   174: aload 5
    //   176: ldc_w 661
    //   179: iconst_0
    //   180: invokeinterface 273 3 0
    //   185: istore_2
    //   186: aload 6
    //   188: ldc_w 661
    //   191: iconst_0
    //   192: invokeinterface 283 3 0
    //   197: pop
    //   198: iload_1
    //   199: ifgt +7 -> 206
    //   202: iload_2
    //   203: ifle +93 -> 296
    //   206: new 144	java/util/HashMap
    //   209: dup
    //   210: iconst_4
    //   211: invokespecial 664	java/util/HashMap:<init>	(I)V
    //   214: astore 7
    //   216: aload 7
    //   218: ldc_w 666
    //   221: new 93	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   228: iload_1
    //   229: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc_w 428
    //   235: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokevirtual 670	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: aload 7
    //   247: ldc_w 672
    //   250: new 93	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   257: iload_2
    //   258: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: ldc_w 428
    //   264: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokevirtual 670	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: pop
    //   274: invokestatic 678	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   277: invokestatic 683	axrn:a	(Landroid/content/Context;)Laxrn;
    //   280: aconst_null
    //   281: ldc_w 685
    //   284: iconst_0
    //   285: lconst_0
    //   286: lconst_0
    //   287: aload 7
    //   289: ldc_w 428
    //   292: iconst_0
    //   293: invokevirtual 688	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   296: aload 5
    //   298: ldc_w 690
    //   301: iconst_0
    //   302: invokeinterface 273 3 0
    //   307: istore_1
    //   308: aload 6
    //   310: ldc_w 690
    //   313: iconst_0
    //   314: invokeinterface 283 3 0
    //   319: pop
    //   320: aload 5
    //   322: ldc_w 692
    //   325: iconst_0
    //   326: invokeinterface 273 3 0
    //   331: istore_2
    //   332: aload 6
    //   334: ldc_w 692
    //   337: iconst_0
    //   338: invokeinterface 283 3 0
    //   343: pop
    //   344: iload_1
    //   345: ifgt +7 -> 352
    //   348: iload_2
    //   349: ifle +93 -> 442
    //   352: new 144	java/util/HashMap
    //   355: dup
    //   356: iconst_4
    //   357: invokespecial 664	java/util/HashMap:<init>	(I)V
    //   360: astore 7
    //   362: aload 7
    //   364: ldc_w 666
    //   367: new 93	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   374: iload_1
    //   375: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: ldc_w 428
    //   381: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokevirtual 670	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   390: pop
    //   391: aload 7
    //   393: ldc_w 672
    //   396: new 93	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   403: iload_2
    //   404: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: ldc_w 428
    //   410: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokevirtual 670	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   419: pop
    //   420: invokestatic 678	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   423: invokestatic 683	axrn:a	(Landroid/content/Context;)Laxrn;
    //   426: aconst_null
    //   427: ldc_w 694
    //   430: iconst_0
    //   431: lconst_0
    //   432: lconst_0
    //   433: aload 7
    //   435: ldc_w 428
    //   438: iconst_0
    //   439: invokevirtual 688	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   442: aload 6
    //   444: invokeinterface 286 1 0
    //   449: pop
    //   450: goto -388 -> 62
    //   453: astore 5
    //   455: aload_0
    //   456: monitorexit
    //   457: aload 5
    //   459: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	acqv
    //   161	214	1	i	int
    //   185	219	2	j	int
    //   24	47	3	l	long
    //   11	310	5	localSharedPreferences	SharedPreferences
    //   453	5	5	localObject	Object
    //   38	405	6	localEditor	SharedPreferences.Editor
    //   214	220	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   2	25	453	finally
    //   31	62	453	finally
    //   67	94	453	finally
    //   94	198	453	finally
    //   206	296	453	finally
    //   296	344	453	finally
    //   352	442	453	finally
    //   442	450	453	finally
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_1
    //   12: ifnull +13 -> 25
    //   15: aload_1
    //   16: ldc_w 428
    //   19: invokevirtual 432	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +7 -> 29
    //   25: aload_1
    //   26: astore_2
    //   27: aload_2
    //   28: areturn
    //   29: aload 4
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 59	acqv:jdField_c_of_type_Boolean	Z
    //   36: ifeq -9 -> 27
    //   39: aload 4
    //   41: astore_2
    //   42: getstatic 39	acqv:jdField_a_of_type_Boolean	Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: invokestatic 701	com/tencent/smtt/utils/Md5Utils:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 179	acqv:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   57: aload_2
    //   58: invokevirtual 704	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +17 -> 82
    //   68: aload 4
    //   70: astore_2
    //   71: aload 6
    //   73: astore 5
    //   75: aload 4
    //   77: iconst_0
    //   78: invokevirtual 709	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   81: astore_3
    //   82: aload 4
    //   84: astore_2
    //   85: aload_3
    //   86: astore 5
    //   88: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +41 -> 132
    //   94: aload 4
    //   96: astore_2
    //   97: aload_3
    //   98: astore 5
    //   100: ldc 91
    //   102: iconst_2
    //   103: invokestatic 133	actj:a	()Ljava/lang/StringBuilder;
    //   106: ldc_w 711
    //   109: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 293
    //   119: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_3
    //   133: astore_2
    //   134: aload 4
    //   136: ifnull -109 -> 27
    //   139: aload 4
    //   141: invokevirtual 714	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   144: aload_3
    //   145: areturn
    //   146: astore_3
    //   147: aconst_null
    //   148: astore 4
    //   150: aload 5
    //   152: astore_1
    //   153: aload 4
    //   155: astore_2
    //   156: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +16 -> 175
    //   162: aload 4
    //   164: astore_2
    //   165: ldc 91
    //   167: iconst_2
    //   168: ldc_w 716
    //   171: aload_3
    //   172: invokestatic 619	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload_1
    //   176: astore_2
    //   177: aload 4
    //   179: ifnull -152 -> 27
    //   182: aload 4
    //   184: invokevirtual 714	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   187: aload_1
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 714	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: goto -11 -> 192
    //   206: astore_3
    //   207: aload 5
    //   209: astore_1
    //   210: goto -57 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	acqv
    //   0	213	1	paramString	String
    //   26	171	2	localObject1	Object
    //   1	144	3	str	String
    //   146	26	3	localIOException1	IOException
    //   206	1	3	localIOException2	IOException
    //   9	174	4	localSnapshot	DiskLruCache.Snapshot
    //   3	205	5	localObject2	Object
    //   6	66	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   53	63	146	java/io/IOException
    //   53	63	189	finally
    //   75	82	202	finally
    //   88	94	202	finally
    //   100	132	202	finally
    //   156	162	202	finally
    //   165	175	202	finally
    //   75	82	206	java/io/IOException
    //   88	94	206	java/io/IOException
    //   100	132	206	java/io/IOException
  }
  
  public final void a(String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("WebAccelerator", 0);
      int i = localSharedPreferences.getInt(paramString, 0);
      if (i > 0) {
        localSharedPreferences.edit().putInt(paramString, i - 1).commit();
      }
      return;
    }
    finally {}
  }
  
  public final void a(String arg1, int paramInt, String paramString2, String paramString3)
  {
    int i = 2;
    if ((TextUtils.isEmpty(???)) || (!jdField_a_of_type_Boolean)) {}
    String str;
    do
    {
      return;
      str = ???.trim();
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilSet.add(str);
      switch (naj.a())
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "unknown network type , not use accelerator");
    return;
    i = 4;
    if ((a(i)) && (a())) {
      if (!a(16)) {
        break label225;
      }
    }
    label225:
    for (??? = b(str);; ??? = str)
    {
      if (a(32)) {
        a(???, paramInt, paramString2, paramString3);
      }
      if (a(64)) {
        b(???);
      }
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilSet.remove(str);
        return;
      }
      i = 8;
      break;
      i = 1;
      break;
    }
  }
  
  public final boolean a(String paramString)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (!paramString.equals("")) {
        break label28;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      label28:
      bool2 = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        continue;
      }
      bool2 = bool1;
      if (!jdField_a_of_type_Boolean) {
        continue;
      }
      Object localObject3 = null;
      Object localObject1 = null;
      String str = Md5Utils.getMD5(paramString);
      boolean bool3 = bool5;
      try
      {
        DiskLruCache.Snapshot localSnapshot = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.get(str);
        bool1 = bool4;
        if (localSnapshot != null)
        {
          bool3 = bool5;
          localObject1 = localSnapshot;
          localObject3 = localSnapshot;
        }
        try
        {
          l = Long.parseLong(localSnapshot.getString(0));
          bool3 = bool5;
          localObject1 = localSnapshot;
          localObject3 = localSnapshot;
          if (SystemClock.uptimeMillis() - l < this.jdField_a_of_type_Long)
          {
            bool1 = true;
            bool3 = bool1;
            localObject1 = localSnapshot;
            localObject3 = localSnapshot;
            if (QLog.isColorLevel())
            {
              bool3 = bool1;
              localObject1 = localSnapshot;
              localObject3 = localSnapshot;
              QLog.d("WebAccelerator", 2, "isSafeCheck:" + paramString + "   " + bool1);
            }
            bool2 = bool1;
            return bool1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            long l = 0L;
            continue;
            bool3 = bool5;
            localObject2 = localSnapshot;
            localObject3 = localSnapshot;
            this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.remove(str);
            bool1 = bool4;
          }
        }
      }
      catch (IOException paramString)
      {
        Object localObject2;
        localObject3 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject3 = localObject2;
          QLog.e("WebAccelerator", 2, "isSafeCheck fail", paramString);
        }
        bool2 = bool3;
        return bool3;
      }
      finally
      {
        if (localObject3 != null) {
          localObject3.close();
        }
      }
    }
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramString1 != null)
    {
      if (!paramString1.equals("")) {
        break label31;
      }
      bool2 = bool3;
    }
    label31:
    do
    {
      return bool2;
      if ((this.jdField_c_of_type_Boolean) && (jdField_a_of_type_Boolean) && (!paramString1.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) && (!paramString1.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) && (!a(paramString1))) {
        break;
      }
      bool2 = bool3;
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "no need doSafeCheck");
    return false;
    for (;;)
    {
      Object localObject2;
      try
      {
        i = (int)SystemClock.uptimeMillis() % 2;
        localObject1 = xmy.a;
        if (i > -1)
        {
          localObject2 = localObject1[i];
          String str = ayvn.a().a(0, false);
          localObject1 = localObject2;
          if (str != null)
          {
            localObject1 = localObject2;
            if (str.length() > 0) {
              localObject1 = ((String)localObject2).replaceFirst("http://[^/\\s]*/", str);
            }
          }
          localObject2 = actj.a();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("&u=");
          ((StringBuilder)localObject2).append(URLEncoder.encode(paramString1, "UTF-8"));
          ((StringBuilder)localObject2).append("&wap=3");
          switch (paramInt)
          {
          case 0: 
            ((StringBuilder)localObject2).append("&qq-pf-to=mqq.temporaryc2c");
            if (!TextUtils.isEmpty(paramString2)) {
              ((StringBuilder)localObject2).append("&uin=").append(paramString2);
            }
            if (!TextUtils.isEmpty(paramString3)) {
              ((StringBuilder)localObject2).append("&originuin=").append(paramString3);
            }
            localObject1 = ((StringBuilder)localObject2).toString();
            paramString2 = d((String)localObject1);
            paramString3 = a();
            paramInt = paramString3.getInt("load_safeCheck", 0);
            paramString3.edit().putInt("load_safeCheck", paramInt + 1).commit();
            if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(paramString1))) {
              break label696;
            }
            paramString2 = null;
            paramString3 = null;
            localObject2 = Md5Utils.getMD5(paramString1);
            paramString1 = paramString3;
          }
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        int i;
        Object localObject1;
        bool2 = bool3;
      }
      try
      {
        paramString3 = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.edit((String)localObject2);
        if (paramString3 == null) {
          break label556;
        }
        paramString1 = paramString3;
        paramString2 = paramString3;
        paramString3.set(0, SystemClock.uptimeMillis() + "");
        paramString1 = paramString3;
        paramString2 = paramString3;
        paramString3.commit();
        bool1 = true;
      }
      catch (IOException paramString2)
      {
        if (!QLog.isColorLevel()) {
          break label611;
        }
        QLog.d("WebAccelerator", 2, "doSafeCheck", paramString2);
        bool1 = bool4;
        if (paramString1 == null) {
          continue;
        }
        try
        {
          paramString1.abort();
          bool1 = bool4;
        }
        catch (IOException paramString1)
        {
          bool1 = bool4;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("WebAccelerator", 2, "doSafeCheck", paramString1);
        bool1 = bool4;
        continue;
      }
      catch (Exception paramString1)
      {
        bool2 = bool3;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebAccelerator", 2, "doSafeCheck:" + (String)localObject1 + "   " + bool1);
      return bool1;
      i = 0;
      continue;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.c2c");
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("WebAccelerator", 2, "buildUrl fail", paramString1);
      return false;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.group");
      continue;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.discussion");
      continue;
      label556:
      boolean bool1 = bool4;
      paramString1 = paramString3;
      paramString2 = paramString3;
      if (QLog.isColorLevel())
      {
        paramString1 = paramString3;
        paramString2 = paramString3;
        QLog.e("WebAccelerator", 2, "fail to open cache.editor");
        bool1 = bool4;
        continue;
        label611:
        if (paramString2 == null) {
          break;
        }
        try
        {
          paramString2.abort();
          return false;
        }
        catch (IOException paramString1)
        {
          bool2 = bool3;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("WebAccelerator", 2, "doSafeCheck", paramString1);
        return false;
        label696:
        bool1 = bool4;
        if (QLog.isColorLevel())
        {
          QLog.d("WebAccelerator", 2, "doRedirect get fail url");
          bool1 = bool4;
        }
      }
    }
  }
  
  public final String b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    Object localObject2;
    do
    {
      DiskLruCache.Editor localEditor1;
      for (;;)
      {
        return paramString;
        if ((this.jdField_c_of_type_Boolean) && (jdField_a_of_type_Boolean) && (c(paramString)))
        {
          Object localObject1 = a(paramString);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label372;
          }
          String str1 = d(paramString);
          if ((str1 != null) && (!str1.equals("")))
          {
            localObject1 = a();
            int i = ((SharedPreferences)localObject1).getInt("load_shortLink", 0);
            ((SharedPreferences)localObject1).edit().putInt("load_shortLink", i + 1).commit();
            DiskLruCache.Editor localEditor2 = null;
            localObject2 = null;
            localObject1 = localObject2;
            localEditor1 = localEditor2;
            try
            {
              String str2 = Md5Utils.getMD5(paramString);
              localObject1 = localObject2;
              localEditor1 = localEditor2;
              localEditor2 = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.edit(str2);
              if (localEditor2 != null)
              {
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localEditor2.set(0, str1);
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localEditor2.commit();
              }
              for (;;)
              {
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localObject2 = str1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                QLog.d("WebAccelerator", 2, "doShortLink:" + paramString + "   " + str1);
                localObject2 = str1;
                break;
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                if (QLog.isColorLevel())
                {
                  localObject1 = localEditor2;
                  localEditor1 = localEditor2;
                  QLog.d("WebAccelerator", 2, "fail to open cache.Editor");
                }
              }
              if (localEditor1 == null) {}
            }
            catch (IOException paramString)
            {
              if (QLog.isColorLevel()) {
                QLog.e("WebAccelerator", 2, "doShortLink", paramString);
              }
              localObject2 = str1;
              if (localObject1 == null) {
                break label372;
              }
              try
              {
                ((DiskLruCache.Editor)localObject1).abort();
                localObject2 = str1;
              }
              catch (IOException paramString)
              {
                localObject2 = str1;
                if (!QLog.isColorLevel()) {
                  break label372;
                }
              }
              QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", paramString);
              localObject2 = str1;
            }
            catch (Exception localException) {}
          }
        }
      }
      try
      {
        localEditor1.abort();
        return paramString;
      }
      catch (IOException localIOException) {}
    } while (!QLog.isColorLevel());
    QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", localIOException);
    return paramString;
    label372:
    return localObject2;
  }
  
  public final boolean b(String paramString)
  {
    bool3 = false;
    bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (!paramString.equals("")) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    do
    {
      do
      {
        return bool2;
        bool2 = bool1;
      } while (!jdField_a_of_type_Boolean);
      String str = axut.a(paramString);
      try
      {
        InetAddress.getByName(str);
        bool1 = true;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        for (;;)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.e("WebAccelerator", 2, "doDNS", localUnknownHostException);
            bool1 = bool3;
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.e("WebAccelerator", 2, "doDNS", localSecurityException);
            bool1 = bool3;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "doDNS:" + paramString + "   " + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acqv
 * JD-Core Version:    0.7.0.1
 */