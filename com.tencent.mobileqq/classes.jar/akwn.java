import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class akwn
  extends ContentObserver
{
  private static long jdField_a_of_type_Long;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_id", "address", "body", "date" };
  akwl jdField_a_of_type_Akwl;
  Context jdField_a_of_type_AndroidContentContext;
  
  public akwn(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public akwn(Handler paramHandler, long paramLong)
  {
    super(paramHandler);
    jdField_a_of_type_Long = paramLong;
  }
  
  private void b(Context paramContext, akwl paramakwl)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Akwl = paramakwl;
    try
    {
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidContentContext.getContentResolver().unregisterContentObserver(this);
      if (QLog.isColorLevel()) {
        QLog.d("sms.content", 2, "unregister...");
      }
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    this.jdField_a_of_type_Akwl = null;
  }
  
  public void a(Context paramContext, akwl paramakwl)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
      } while ((!(paramContext instanceof BaseActivity)) || (!a((BaseActivity)paramContext, paramakwl)));
      b(paramContext, paramakwl);
    } while (!QLog.isColorLevel());
    QLog.d("sms.content", 2, "register...");
  }
  
  @TargetApi(23)
  public boolean a(BaseActivity paramBaseActivity, akwl paramakwl)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (paramBaseActivity.checkSelfPermission("android.permission.READ_SMS") != 0))
    {
      paramBaseActivity.requestPermissions(new akwo(this, paramBaseActivity, paramakwl), 1, new String[] { "android.permission.READ_SMS" });
      return false;
    }
    return true;
  }
  
  /* Error */
  public void onChange(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 119	android/database/ContentObserver:onChange	(Z)V
    //   5: aload_0
    //   6: getfield 40	akwn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9: ifnonnull +18 -> 27
    //   12: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 77
    //   20: iconst_2
    //   21: ldc 121
    //   23: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 40	akwn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   31: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: ldc 123
    //   36: invokestatic 56	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: getstatic 23	akwn:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   42: aconst_null
    //   43: aconst_null
    //   44: ldc 125
    //   46: invokevirtual 129	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +216 -> 269
    //   56: aload 5
    //   58: astore 4
    //   60: aload 5
    //   62: invokeinterface 134 1 0
    //   67: ifne +202 -> 269
    //   70: aload 5
    //   72: astore 4
    //   74: aload 5
    //   76: invokeinterface 137 1 0
    //   81: ifeq +188 -> 269
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: aload 5
    //   92: ldc 17
    //   94: invokeinterface 140 2 0
    //   99: invokeinterface 144 2 0
    //   104: astore 6
    //   106: aload 5
    //   108: astore 4
    //   110: aload 5
    //   112: aload 5
    //   114: ldc 19
    //   116: invokeinterface 140 2 0
    //   121: invokeinterface 144 2 0
    //   126: astore 7
    //   128: aload 5
    //   130: astore 4
    //   132: aload 5
    //   134: aload 5
    //   136: ldc 21
    //   138: invokeinterface 140 2 0
    //   143: invokeinterface 148 2 0
    //   148: lstore_2
    //   149: aload 5
    //   151: astore 4
    //   153: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +63 -> 219
    //   159: aload 5
    //   161: astore 4
    //   163: ldc 77
    //   165: iconst_2
    //   166: new 150	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   173: ldc 154
    //   175: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 6
    //   180: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 160
    //   185: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 7
    //   190: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 162
    //   195: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: lload_2
    //   199: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: ldc 167
    //   204: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: getstatic 31	akwn:jdField_a_of_type_Long	J
    //   210: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload 5
    //   221: astore 4
    //   223: lload_2
    //   224: getstatic 31	akwn:jdField_a_of_type_Long	J
    //   227: lcmp
    //   228: iflt +41 -> 269
    //   231: aload 5
    //   233: astore 4
    //   235: aload_0
    //   236: getfield 42	akwn:jdField_a_of_type_Akwl	Lakwl;
    //   239: ifnull +30 -> 269
    //   242: aload 5
    //   244: astore 4
    //   246: aload_0
    //   247: getfield 42	akwn:jdField_a_of_type_Akwl	Lakwl;
    //   250: aload 6
    //   252: aload 7
    //   254: invokeinterface 177 3 0
    //   259: aload 5
    //   261: astore 4
    //   263: lconst_1
    //   264: lload_2
    //   265: ladd
    //   266: putstatic 31	akwn:jdField_a_of_type_Long	J
    //   269: aload 5
    //   271: ifnull -245 -> 26
    //   274: aload 5
    //   276: invokeinterface 180 1 0
    //   281: return
    //   282: astore 6
    //   284: aconst_null
    //   285: astore 5
    //   287: aload 5
    //   289: astore 4
    //   291: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +17 -> 311
    //   297: aload 5
    //   299: astore 4
    //   301: ldc 77
    //   303: iconst_2
    //   304: ldc 181
    //   306: aload 6
    //   308: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: aload 5
    //   313: ifnull -287 -> 26
    //   316: aload 5
    //   318: invokeinterface 180 1 0
    //   323: return
    //   324: astore 5
    //   326: aconst_null
    //   327: astore 4
    //   329: aload 4
    //   331: ifnull +10 -> 341
    //   334: aload 4
    //   336: invokeinterface 180 1 0
    //   341: aload 5
    //   343: athrow
    //   344: astore 5
    //   346: goto -17 -> 329
    //   349: astore 6
    //   351: goto -64 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	akwn
    //   0	354	1	paramBoolean	boolean
    //   148	117	2	l	long
    //   58	277	4	localCursor1	android.database.Cursor
    //   49	268	5	localCursor2	android.database.Cursor
    //   324	18	5	localObject1	java.lang.Object
    //   344	1	5	localObject2	java.lang.Object
    //   104	147	6	str1	String
    //   282	25	6	localException1	Exception
    //   349	1	6	localException2	Exception
    //   126	127	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   27	51	282	java/lang/Exception
    //   27	51	324	finally
    //   60	70	344	finally
    //   74	84	344	finally
    //   88	106	344	finally
    //   110	128	344	finally
    //   132	149	344	finally
    //   153	159	344	finally
    //   163	219	344	finally
    //   223	231	344	finally
    //   235	242	344	finally
    //   246	259	344	finally
    //   263	269	344	finally
    //   291	297	344	finally
    //   301	311	344	finally
    //   60	70	349	java/lang/Exception
    //   74	84	349	java/lang/Exception
    //   88	106	349	java/lang/Exception
    //   110	128	349	java/lang/Exception
    //   132	149	349	java/lang/Exception
    //   153	159	349	java/lang/Exception
    //   163	219	349	java/lang/Exception
    //   223	231	349	java/lang/Exception
    //   235	242	349	java/lang/Exception
    //   246	259	349	java/lang/Exception
    //   263	269	349	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akwn
 * JD-Core Version:    0.7.0.1
 */