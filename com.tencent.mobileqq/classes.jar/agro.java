import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1;
import com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.2;
import com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.3;
import com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class agro
  extends BaseAdapter
{
  static final ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-2141891243);
  static final String jdField_a_of_type_JavaLangString;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  static final String[] d;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Resources jdField_a_of_type_AndroidContentResResources;
  Drawable.ConstantState jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public List<QQAlbumInfo> a;
  WeakReference<AlbumListFragment> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "_size>0 and ( _size < " + bbbj.jdField_a_of_type_Int + " )  and (" + "width" + ">= 240 or " + "width" + " IS NULL) and (" + "height" + ">= 240 or " + "height" + " IS NULL )  and " + "height" + "  * 1.0 / " + "width" + ">= 0.45 and " + "height" + "  * 1.0 / " + "width" + "<= 2.2 and (" + "mime_type" + "='" + "image/jpeg" + "' or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpeg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.bmp%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.png%' )  or " + "mime_type" + " LIKE'%" + "bmp" + "%' or " + "mime_type" + " LIKE'%" + "bitmap" + "%' or " + "mime_type" + "='" + "image/png" + "'";
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };; jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" })
    {
      jdField_c_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
      d = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
      return;
    }
  }
  
  public agro(AlbumListFragment paramAlbumListFragment)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAlbumListFragment);
    this.jdField_a_of_type_AndroidContentResResources = paramAlbumListFragment.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839021).getConstantState();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131296375);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if (paramString.equalsIgnoreCase("camera")) {
        return true;
      }
    } while (!paramString.equalsIgnoreCase("100media"));
    return true;
  }
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  /* Error */
  public QQAlbumInfo a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 213	com/tencent/mobileqq/data/QQAlbumInfo
    //   5: dup
    //   6: invokespecial 217	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc 219
    //   15: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   18: aload 4
    //   20: getstatic 226	bbbi:n	Ljava/lang/String;
    //   23: putfield 229	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   26: aload 4
    //   28: iconst_0
    //   29: putfield 232	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   32: getstatic 238	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 244	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: aload_2
    //   41: getstatic 140	agro:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   44: ldc 246
    //   46: aconst_null
    //   47: ldc 248
    //   49: invokevirtual 254	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: iconst_2
    //   56: invokestatic 259	aglx:a	(I)Laglx;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +14 -> 77
    //   66: aload_2
    //   67: astore_1
    //   68: aload_0
    //   69: aload_2
    //   70: iconst_m1
    //   71: aload 5
    //   73: invokevirtual 262	agro:a	(Landroid/database/Cursor;ILaglx;)Ljava/util/List;
    //   76: astore_3
    //   77: aload_2
    //   78: astore_1
    //   79: invokestatic 268	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   82: invokestatic 273	agmi:a	(Landroid/content/Context;)Lagmi;
    //   85: iconst_0
    //   86: iconst_m1
    //   87: invokevirtual 276	agmi:a	(ZI)Ljava/util/ArrayList;
    //   90: astore 5
    //   92: aload_3
    //   93: ifnull +50 -> 143
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: invokeinterface 280 1 0
    //   104: ifne +39 -> 143
    //   107: aload_2
    //   108: astore_1
    //   109: aload 4
    //   111: aload 4
    //   113: getfield 232	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   116: aload_3
    //   117: invokeinterface 284 1 0
    //   122: iadd
    //   123: putfield 232	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   126: aload_2
    //   127: astore_1
    //   128: aload 4
    //   130: aload_3
    //   131: iconst_0
    //   132: invokeinterface 211 2 0
    //   137: checkcast 286	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   140: putfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   143: aload 5
    //   145: ifnull +181 -> 326
    //   148: aload_2
    //   149: astore_1
    //   150: aload 5
    //   152: invokevirtual 291	java/util/ArrayList:isEmpty	()Z
    //   155: ifne +171 -> 326
    //   158: aload_2
    //   159: astore_1
    //   160: aload 4
    //   162: aload 4
    //   164: getfield 232	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   167: aload 5
    //   169: invokevirtual 292	java/util/ArrayList:size	()I
    //   172: iadd
    //   173: putfield 232	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   176: aload_2
    //   177: astore_1
    //   178: aload 5
    //   180: iconst_0
    //   181: invokevirtual 293	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   184: checkcast 295	agmn
    //   187: astore_3
    //   188: aload_2
    //   189: astore_1
    //   190: aload 4
    //   192: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   195: ifnull +21 -> 216
    //   198: aload_2
    //   199: astore_1
    //   200: aload 4
    //   202: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   205: getfield 298	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   208: aload_3
    //   209: getfield 300	agmn:b	J
    //   212: lcmp
    //   213: ifge +113 -> 326
    //   216: aload_2
    //   217: astore_1
    //   218: aload 4
    //   220: new 286	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   223: dup
    //   224: invokespecial 301	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   227: putfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   230: aload_2
    //   231: astore_1
    //   232: aload 4
    //   234: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   237: aload_3
    //   238: getfield 302	agmn:jdField_a_of_type_Int	I
    //   241: i2l
    //   242: putfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   245: aload_2
    //   246: astore_1
    //   247: aload 4
    //   249: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   252: aload_3
    //   253: getfield 306	agmn:jdField_c_of_type_Long	J
    //   256: putfield 309	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   259: aload_2
    //   260: astore_1
    //   261: aload 4
    //   263: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   266: aload_3
    //   267: getfield 311	agmn:jdField_a_of_type_Long	J
    //   270: putfield 314	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   273: aload_2
    //   274: astore_1
    //   275: aload 4
    //   277: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   280: aload_3
    //   281: getfield 316	agmn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   284: putfield 319	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   287: aload_2
    //   288: astore_1
    //   289: aload 4
    //   291: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   294: aload_3
    //   295: getfield 300	agmn:b	J
    //   298: putfield 298	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   301: aload_2
    //   302: astore_1
    //   303: aload 4
    //   305: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   308: aload_3
    //   309: getfield 321	agmn:d	Ljava/lang/String;
    //   312: putfield 324	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   315: aload_2
    //   316: astore_1
    //   317: aload 4
    //   319: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   322: iconst_0
    //   323: putfield 327	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   326: aload_2
    //   327: ifnull +9 -> 336
    //   330: aload_2
    //   331: invokeinterface 332 1 0
    //   336: aload 4
    //   338: areturn
    //   339: astore_3
    //   340: aconst_null
    //   341: astore_2
    //   342: aload_2
    //   343: astore_1
    //   344: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +17 -> 364
    //   350: aload_2
    //   351: astore_1
    //   352: ldc_w 339
    //   355: iconst_2
    //   356: aload_3
    //   357: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   360: aload_3
    //   361: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   364: aload_2
    //   365: ifnull -29 -> 336
    //   368: aload_2
    //   369: invokeinterface 332 1 0
    //   374: aload 4
    //   376: areturn
    //   377: astore_2
    //   378: aconst_null
    //   379: astore_1
    //   380: aload_1
    //   381: ifnull +9 -> 390
    //   384: aload_1
    //   385: invokeinterface 332 1 0
    //   390: aload_2
    //   391: athrow
    //   392: astore_2
    //   393: goto -13 -> 380
    //   396: astore_3
    //   397: goto -55 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	agro
    //   0	400	1	paramContext	Context
    //   35	334	2	localObject1	Object
    //   377	14	2	localObject2	Object
    //   392	1	2	localObject3	Object
    //   1	308	3	localObject4	Object
    //   339	22	3	localException1	java.lang.Exception
    //   396	1	3	localException2	java.lang.Exception
    //   9	366	4	localQQAlbumInfo	QQAlbumInfo
    //   59	120	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   32	53	339	java/lang/Exception
    //   32	53	377	finally
    //   55	61	392	finally
    //   68	77	392	finally
    //   79	92	392	finally
    //   98	107	392	finally
    //   109	126	392	finally
    //   128	143	392	finally
    //   150	158	392	finally
    //   160	176	392	finally
    //   178	188	392	finally
    //   190	198	392	finally
    //   200	216	392	finally
    //   218	230	392	finally
    //   232	245	392	finally
    //   247	259	392	finally
    //   261	273	392	finally
    //   275	287	392	finally
    //   289	301	392	finally
    //   303	315	392	finally
    //   317	326	392	finally
    //   344	350	392	finally
    //   352	364	392	finally
    //   55	61	396	java/lang/Exception
    //   68	77	396	java/lang/Exception
    //   79	92	396	java/lang/Exception
    //   98	107	396	java/lang/Exception
    //   109	126	396	java/lang/Exception
    //   128	143	396	java/lang/Exception
    //   150	158	396	java/lang/Exception
    //   160	176	396	java/lang/Exception
    //   178	188	396	java/lang/Exception
    //   190	198	396	java/lang/Exception
    //   200	216	396	java/lang/Exception
    //   218	230	396	java/lang/Exception
    //   232	245	396	java/lang/Exception
    //   247	259	396	java/lang/Exception
    //   261	273	396	java/lang/Exception
    //   275	287	396	java/lang/Exception
    //   289	301	396	java/lang/Exception
    //   303	315	396	java/lang/Exception
    //   317	326	396	java/lang/Exception
  }
  
  /* Error */
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, aglx paramaglx)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iload_3
    //   7: ifgt +14 -> 21
    //   10: new 349	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 351
    //   17: invokespecial 354	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 213	com/tencent/mobileqq/data/QQAlbumInfo
    //   24: dup
    //   25: invokespecial 217	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   28: astore 8
    //   30: aload 8
    //   32: ldc_w 356
    //   35: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   38: aload 8
    //   40: getstatic 359	bbbi:l	Ljava/lang/String;
    //   43: putfield 229	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   46: iload_3
    //   47: ifle +141 -> 188
    //   50: getstatic 238	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 365	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore 5
    //   58: aload 5
    //   60: ldc_w 367
    //   63: iload_3
    //   64: invokestatic 371	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 377	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload 5
    //   73: invokevirtual 381	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   76: astore 5
    //   78: aload_1
    //   79: invokevirtual 244	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   82: aload 5
    //   84: getstatic 140	agro:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   87: ldc 246
    //   89: aconst_null
    //   90: ldc 248
    //   92: invokevirtual 254	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore_1
    //   96: aload 4
    //   98: ifnull +16 -> 114
    //   101: aload_1
    //   102: astore 5
    //   104: aload_0
    //   105: aload_1
    //   106: iload_3
    //   107: aload 4
    //   109: invokevirtual 262	agro:a	(Landroid/database/Cursor;ILaglx;)Ljava/util/List;
    //   112: astore 6
    //   114: aload 6
    //   116: ifnull +59 -> 175
    //   119: aload_1
    //   120: astore 5
    //   122: aload 6
    //   124: invokeinterface 280 1 0
    //   129: ifne +46 -> 175
    //   132: aload_1
    //   133: astore 5
    //   135: aload 6
    //   137: invokeinterface 284 1 0
    //   142: istore_2
    //   143: aload_1
    //   144: astore 5
    //   146: aload 8
    //   148: iload_2
    //   149: putfield 232	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   152: iload_2
    //   153: ifle +22 -> 175
    //   156: aload_1
    //   157: astore 5
    //   159: aload 8
    //   161: aload 6
    //   163: iconst_0
    //   164: invokeinterface 211 2 0
    //   169: checkcast 286	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   172: putfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   175: aload_1
    //   176: ifnull +9 -> 185
    //   179: aload_1
    //   180: invokeinterface 332 1 0
    //   185: aload 8
    //   187: areturn
    //   188: getstatic 238	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   191: astore 5
    //   193: goto -115 -> 78
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: astore 5
    //   203: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +20 -> 226
    //   209: aload_1
    //   210: astore 5
    //   212: ldc_w 339
    //   215: iconst_2
    //   216: aload 4
    //   218: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: aload 4
    //   223: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_1
    //   227: ifnull -42 -> 185
    //   230: aload_1
    //   231: invokeinterface 332 1 0
    //   236: aload 8
    //   238: areturn
    //   239: astore_1
    //   240: aload 7
    //   242: astore 4
    //   244: aload 4
    //   246: ifnull +10 -> 256
    //   249: aload 4
    //   251: invokeinterface 332 1 0
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload 5
    //   261: astore 4
    //   263: goto -19 -> 244
    //   266: astore 4
    //   268: goto -68 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	agro
    //   0	271	1	paramContext	Context
    //   0	271	2	paramInt1	int
    //   0	271	3	paramInt2	int
    //   0	271	4	paramaglx	aglx
    //   56	204	5	localObject1	Object
    //   4	158	6	localList	List
    //   1	240	7	localObject2	Object
    //   28	209	8	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   50	78	196	java/lang/Exception
    //   78	96	196	java/lang/Exception
    //   188	193	196	java/lang/Exception
    //   50	78	239	finally
    //   78	96	239	finally
    //   188	193	239	finally
    //   104	114	258	finally
    //   122	132	258	finally
    //   135	143	258	finally
    //   146	152	258	finally
    //   159	175	258	finally
    //   203	209	258	finally
    //   212	226	258	finally
    //   104	114	266	java/lang/Exception
    //   122	132	266	java/lang/Exception
    //   135	143	266	java/lang/Exception
    //   146	152	266	java/lang/Exception
    //   159	175	266	java/lang/Exception
  }
  
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, aglx paramaglx, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "$RecentAlbumId";
    localQQAlbumInfo.name = bbbi.l;
    paramArrayList = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a.a(paramContext, paramInt1, paramInt2, paramaglx, paramInt3, paramBoolean, paramArrayList);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramArrayList.get(0));
      localQQAlbumInfo.mMediaFileCount = paramArrayList.size();
    }
    if (localQQAlbumInfo.mMediaFileCount >= paramInt2) {
      return localQQAlbumInfo;
    }
    paramContext = bbbj.a(paramContext, 0, paramInt2, paramaglx, -1L);
    if (paramContext == null) {
      return localQQAlbumInfo;
    }
    if ((localQQAlbumInfo.mMediaFileCount == 0) && (paramContext.size() > 0)) {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramContext.get(0));
    }
    if (localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2) {}
    for (localQQAlbumInfo.mMediaFileCount += paramContext.size();; localQQAlbumInfo.mMediaFileCount = paramInt2) {
      return localQQAlbumInfo;
    }
  }
  
  /* Error */
  public List<QQAlbumInfo> a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +75 -> 76
    //   4: getstatic 409	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 12
    //   9: aload_1
    //   10: invokevirtual 244	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload 12
    //   15: getstatic 52	agro:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 162	agro:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   22: invokevirtual 385	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   25: checkcast 164	com/tencent/mobileqq/activity/photo/album/AlbumListFragment
    //   28: getfield 388	com/tencent/mobileqq/activity/photo/album/AlbumListFragment:a	Lagrj;
    //   31: getfield 393	agrj:a	Lagrk;
    //   34: invokeinterface 411 1 0
    //   39: aconst_null
    //   40: ldc_w 413
    //   43: invokevirtual 254	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore 12
    //   48: aload 12
    //   50: ifnonnull +57 -> 107
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: astore 13
    //   58: aload 12
    //   60: ifnull +13 -> 73
    //   63: aload 12
    //   65: invokeinterface 332 1 0
    //   70: aload_1
    //   71: astore 13
    //   73: aload 13
    //   75: areturn
    //   76: getstatic 409	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   79: invokevirtual 365	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   82: astore 12
    //   84: aload 12
    //   86: ldc_w 367
    //   89: iload_2
    //   90: invokestatic 371	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   93: invokevirtual 377	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   96: pop
    //   97: aload 12
    //   99: invokevirtual 381	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   102: astore 12
    //   104: goto -95 -> 9
    //   107: aload 12
    //   109: astore 13
    //   111: new 415	java/util/LinkedList
    //   114: dup
    //   115: invokespecial 416	java/util/LinkedList:<init>	()V
    //   118: astore_1
    //   119: aload 12
    //   121: astore 13
    //   123: aload 12
    //   125: ldc 36
    //   127: invokeinterface 420 2 0
    //   132: istore_2
    //   133: aload 12
    //   135: astore 13
    //   137: aload 12
    //   139: ldc 38
    //   141: invokeinterface 420 2 0
    //   146: istore_3
    //   147: aload 12
    //   149: astore 13
    //   151: aload 12
    //   153: ldc 44
    //   155: invokeinterface 420 2 0
    //   160: istore 4
    //   162: aload 12
    //   164: astore 13
    //   166: aload 12
    //   168: ldc 42
    //   170: invokeinterface 420 2 0
    //   175: istore 5
    //   177: aload 12
    //   179: astore 13
    //   181: aload 12
    //   183: ldc 132
    //   185: invokeinterface 420 2 0
    //   190: istore 6
    //   192: aload 12
    //   194: astore 13
    //   196: aload 12
    //   198: ldc 46
    //   200: invokeinterface 420 2 0
    //   205: istore 7
    //   207: aload 12
    //   209: astore 13
    //   211: aload 12
    //   213: ldc 48
    //   215: invokeinterface 420 2 0
    //   220: istore 8
    //   222: aload 12
    //   224: astore 13
    //   226: aload 12
    //   228: ldc_w 422
    //   231: invokeinterface 420 2 0
    //   236: istore 9
    //   238: aload 12
    //   240: astore 13
    //   242: aload 12
    //   244: invokeinterface 425 1 0
    //   249: ifeq +326 -> 575
    //   252: aload 12
    //   254: astore 13
    //   256: aload 12
    //   258: iload_2
    //   259: invokeinterface 428 2 0
    //   264: astore 16
    //   266: aload 12
    //   268: astore 13
    //   270: aload 12
    //   272: iload_3
    //   273: invokeinterface 428 2 0
    //   278: astore 17
    //   280: aload 12
    //   282: astore 13
    //   284: aload 16
    //   286: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne -51 -> 238
    //   292: aload 12
    //   294: astore 13
    //   296: aload 17
    //   298: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   301: ifne -63 -> 238
    //   304: aload 12
    //   306: astore 13
    //   308: aload 12
    //   310: iload 4
    //   312: invokeinterface 428 2 0
    //   317: astore 14
    //   319: aload 12
    //   321: astore 13
    //   323: aload 12
    //   325: iload 5
    //   327: invokeinterface 437 2 0
    //   332: lstore 10
    //   334: aload 12
    //   336: astore 13
    //   338: new 213	com/tencent/mobileqq/data/QQAlbumInfo
    //   341: dup
    //   342: invokespecial 217	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   345: astore 15
    //   347: aload 12
    //   349: astore 13
    //   351: aload 15
    //   353: aload 17
    //   355: putfield 229	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   358: aload 12
    //   360: astore 13
    //   362: aload 15
    //   364: aload 16
    //   366: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   369: aload 12
    //   371: astore 13
    //   373: aload 15
    //   375: lload 10
    //   377: putfield 440	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   380: aload 12
    //   382: astore 13
    //   384: aload 15
    //   386: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   389: astore 16
    //   391: aload 12
    //   393: astore 13
    //   395: aload 16
    //   397: aload 14
    //   399: putfield 319	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   402: aload 12
    //   404: astore 13
    //   406: aload 16
    //   408: aload 12
    //   410: iload 6
    //   412: invokeinterface 437 2 0
    //   417: putfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   420: aload 12
    //   422: astore 13
    //   424: aload 16
    //   426: lload 10
    //   428: putfield 298	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   431: aload 12
    //   433: astore 13
    //   435: aload 16
    //   437: aload 12
    //   439: iload 7
    //   441: invokeinterface 443 2 0
    //   446: putfield 445	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   449: aload 12
    //   451: astore 13
    //   453: aload 16
    //   455: aload 12
    //   457: iload 8
    //   459: invokeinterface 428 2 0
    //   464: putfield 324	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   467: aload 12
    //   469: astore 13
    //   471: ldc 95
    //   473: aload 16
    //   475: getfield 324	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   478: invokevirtual 449	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   481: ifeq +15 -> 496
    //   484: aload 12
    //   486: astore 13
    //   488: aload 16
    //   490: ldc_w 451
    //   493: putfield 324	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   496: aload 12
    //   498: astore 13
    //   500: aload 15
    //   502: aload 12
    //   504: iload 9
    //   506: invokeinterface 443 2 0
    //   511: putfield 232	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   514: aload 12
    //   516: astore 13
    //   518: aload_1
    //   519: aload 15
    //   521: invokeinterface 454 2 0
    //   526: pop
    //   527: goto -289 -> 238
    //   530: astore 14
    //   532: aload 12
    //   534: astore 13
    //   536: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +19 -> 558
    //   542: aload 12
    //   544: astore 13
    //   546: ldc_w 456
    //   549: iconst_2
    //   550: ldc_w 458
    //   553: aload 14
    //   555: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   558: aload_1
    //   559: astore 13
    //   561: aload 12
    //   563: ifnull -490 -> 73
    //   566: aload 12
    //   568: invokeinterface 332 1 0
    //   573: aload_1
    //   574: areturn
    //   575: aload_1
    //   576: astore 13
    //   578: aload 12
    //   580: ifnull -507 -> 73
    //   583: aload 12
    //   585: invokeinterface 332 1 0
    //   590: aload_1
    //   591: areturn
    //   592: astore_1
    //   593: aconst_null
    //   594: astore 13
    //   596: aload 13
    //   598: ifnull +10 -> 608
    //   601: aload 13
    //   603: invokeinterface 332 1 0
    //   608: aload_1
    //   609: athrow
    //   610: astore_1
    //   611: goto -15 -> 596
    //   614: astore 14
    //   616: aconst_null
    //   617: astore 12
    //   619: aconst_null
    //   620: astore_1
    //   621: goto -89 -> 532
    //   624: astore 14
    //   626: aconst_null
    //   627: astore_1
    //   628: goto -96 -> 532
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	agro
    //   0	631	1	paramContext	Context
    //   0	631	2	paramInt	int
    //   146	127	3	i	int
    //   160	151	4	j	int
    //   175	151	5	k	int
    //   190	221	6	m	int
    //   205	235	7	n	int
    //   220	238	8	i1	int
    //   236	269	9	i2	int
    //   332	95	10	l	long
    //   7	611	12	localObject1	Object
    //   56	546	13	localObject2	Object
    //   317	81	14	str1	String
    //   530	24	14	localException1	java.lang.Exception
    //   614	1	14	localException2	java.lang.Exception
    //   624	1	14	localException3	java.lang.Exception
    //   345	175	15	localQQAlbumInfo	QQAlbumInfo
    //   264	225	16	localObject3	Object
    //   278	76	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   123	133	530	java/lang/Exception
    //   137	147	530	java/lang/Exception
    //   151	162	530	java/lang/Exception
    //   166	177	530	java/lang/Exception
    //   181	192	530	java/lang/Exception
    //   196	207	530	java/lang/Exception
    //   211	222	530	java/lang/Exception
    //   226	238	530	java/lang/Exception
    //   242	252	530	java/lang/Exception
    //   256	266	530	java/lang/Exception
    //   270	280	530	java/lang/Exception
    //   284	292	530	java/lang/Exception
    //   296	304	530	java/lang/Exception
    //   308	319	530	java/lang/Exception
    //   323	334	530	java/lang/Exception
    //   338	347	530	java/lang/Exception
    //   351	358	530	java/lang/Exception
    //   362	369	530	java/lang/Exception
    //   373	380	530	java/lang/Exception
    //   384	391	530	java/lang/Exception
    //   395	402	530	java/lang/Exception
    //   406	420	530	java/lang/Exception
    //   424	431	530	java/lang/Exception
    //   435	449	530	java/lang/Exception
    //   453	467	530	java/lang/Exception
    //   471	484	530	java/lang/Exception
    //   488	496	530	java/lang/Exception
    //   500	514	530	java/lang/Exception
    //   518	527	530	java/lang/Exception
    //   4	9	592	finally
    //   9	48	592	finally
    //   76	104	592	finally
    //   111	119	610	finally
    //   123	133	610	finally
    //   137	147	610	finally
    //   151	162	610	finally
    //   166	177	610	finally
    //   181	192	610	finally
    //   196	207	610	finally
    //   211	222	610	finally
    //   226	238	610	finally
    //   242	252	610	finally
    //   256	266	610	finally
    //   270	280	610	finally
    //   284	292	610	finally
    //   296	304	610	finally
    //   308	319	610	finally
    //   323	334	610	finally
    //   338	347	610	finally
    //   351	358	610	finally
    //   362	369	610	finally
    //   373	380	610	finally
    //   384	391	610	finally
    //   395	402	610	finally
    //   406	420	610	finally
    //   424	431	610	finally
    //   435	449	610	finally
    //   453	467	610	finally
    //   471	484	610	finally
    //   488	496	610	finally
    //   500	514	610	finally
    //   518	527	610	finally
    //   536	542	610	finally
    //   546	558	610	finally
    //   4	9	614	java/lang/Exception
    //   9	48	614	java/lang/Exception
    //   76	104	614	java/lang/Exception
    //   111	119	624	java/lang/Exception
  }
  
  /* Error */
  public List<QQAlbumInfo> a(Context paramContext, int paramInt, aglx paramaglx)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +51 -> 52
    //   4: getstatic 238	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 244	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 142	agro:d	[Ljava/lang/String;
    //   16: ldc_w 464
    //   19: aconst_null
    //   20: ldc_w 413
    //   23: invokevirtual 254	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnonnull +51 -> 79
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: astore 12
    //   36: aload_3
    //   37: ifnull +12 -> 49
    //   40: aload_3
    //   41: invokeinterface 332 1 0
    //   46: aload_1
    //   47: astore 12
    //   49: aload 12
    //   51: areturn
    //   52: getstatic 238	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   55: invokevirtual 365	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 367
    //   63: iload_2
    //   64: invokestatic 371	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 377	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual 381	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   75: astore_3
    //   76: goto -68 -> 8
    //   79: aload_3
    //   80: astore 12
    //   82: new 415	java/util/LinkedList
    //   85: dup
    //   86: invokespecial 416	java/util/LinkedList:<init>	()V
    //   89: astore_1
    //   90: aload_3
    //   91: astore 12
    //   93: aload_3
    //   94: ldc 36
    //   96: invokeinterface 420 2 0
    //   101: istore_2
    //   102: aload_3
    //   103: astore 12
    //   105: aload_3
    //   106: ldc 132
    //   108: invokeinterface 420 2 0
    //   113: istore 4
    //   115: aload_3
    //   116: astore 12
    //   118: aload_3
    //   119: ldc 38
    //   121: invokeinterface 420 2 0
    //   126: istore 5
    //   128: aload_3
    //   129: astore 12
    //   131: aload_3
    //   132: ldc 44
    //   134: invokeinterface 420 2 0
    //   139: istore 6
    //   141: aload_3
    //   142: astore 12
    //   144: aload_3
    //   145: ldc 42
    //   147: invokeinterface 420 2 0
    //   152: istore 7
    //   154: aload_3
    //   155: astore 12
    //   157: aload_3
    //   158: ldc 48
    //   160: invokeinterface 420 2 0
    //   165: istore 8
    //   167: aload_3
    //   168: astore 12
    //   170: aload_3
    //   171: ldc_w 422
    //   174: invokeinterface 420 2 0
    //   179: istore 9
    //   181: aload_3
    //   182: astore 12
    //   184: aload_3
    //   185: invokeinterface 425 1 0
    //   190: ifeq +245 -> 435
    //   193: aload_3
    //   194: astore 12
    //   196: aload_3
    //   197: iload_2
    //   198: invokeinterface 428 2 0
    //   203: astore 14
    //   205: aload_3
    //   206: astore 12
    //   208: aload_3
    //   209: iload 5
    //   211: invokeinterface 428 2 0
    //   216: astore 15
    //   218: aload_3
    //   219: astore 12
    //   221: aload 14
    //   223: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne -45 -> 181
    //   229: aload_3
    //   230: astore 12
    //   232: aload 15
    //   234: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne -56 -> 181
    //   240: aload_3
    //   241: astore 12
    //   243: aload_3
    //   244: iload 7
    //   246: invokeinterface 437 2 0
    //   251: lstore 10
    //   253: aload_3
    //   254: astore 12
    //   256: new 213	com/tencent/mobileqq/data/QQAlbumInfo
    //   259: dup
    //   260: invokespecial 217	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   263: astore 13
    //   265: aload_3
    //   266: astore 12
    //   268: aload 13
    //   270: aload 15
    //   272: putfield 229	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   275: aload_3
    //   276: astore 12
    //   278: aload 13
    //   280: aload 14
    //   282: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   285: aload_3
    //   286: astore 12
    //   288: aload 13
    //   290: lload 10
    //   292: putfield 440	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   295: aload_3
    //   296: astore 12
    //   298: aload 13
    //   300: getfield 290	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   303: astore 14
    //   305: aload_3
    //   306: astore 12
    //   308: aload 14
    //   310: aload_3
    //   311: iload 6
    //   313: invokeinterface 428 2 0
    //   318: putfield 319	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   321: aload_3
    //   322: astore 12
    //   324: aload 14
    //   326: aload_3
    //   327: iload 4
    //   329: invokeinterface 437 2 0
    //   334: putfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   337: aload_3
    //   338: astore 12
    //   340: aload 14
    //   342: lload 10
    //   344: putfield 298	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   347: aload_3
    //   348: astore 12
    //   350: aload 14
    //   352: aload_3
    //   353: iload 8
    //   355: invokeinterface 428 2 0
    //   360: putfield 324	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   363: aload_3
    //   364: astore 12
    //   366: aload 13
    //   368: aload_3
    //   369: iload 9
    //   371: invokeinterface 443 2 0
    //   376: putfield 232	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   379: aload_3
    //   380: astore 12
    //   382: aload_1
    //   383: aload 13
    //   385: invokeinterface 454 2 0
    //   390: pop
    //   391: goto -210 -> 181
    //   394: astore 13
    //   396: aload_3
    //   397: astore 12
    //   399: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +18 -> 420
    //   405: aload_3
    //   406: astore 12
    //   408: ldc_w 456
    //   411: iconst_2
    //   412: ldc_w 466
    //   415: aload 13
    //   417: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: aload_1
    //   421: astore 12
    //   423: aload_3
    //   424: ifnull -375 -> 49
    //   427: aload_3
    //   428: invokeinterface 332 1 0
    //   433: aload_1
    //   434: areturn
    //   435: aload_1
    //   436: astore 12
    //   438: aload_3
    //   439: ifnull -390 -> 49
    //   442: aload_3
    //   443: invokeinterface 332 1 0
    //   448: aload_1
    //   449: areturn
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 12
    //   454: aload 12
    //   456: ifnull +10 -> 466
    //   459: aload 12
    //   461: invokeinterface 332 1 0
    //   466: aload_1
    //   467: athrow
    //   468: astore_1
    //   469: goto -15 -> 454
    //   472: astore 13
    //   474: aconst_null
    //   475: astore_3
    //   476: aconst_null
    //   477: astore_1
    //   478: goto -82 -> 396
    //   481: astore 13
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -89 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	agro
    //   0	488	1	paramContext	Context
    //   0	488	2	paramInt	int
    //   0	488	3	paramaglx	aglx
    //   113	215	4	i	int
    //   126	84	5	j	int
    //   139	173	6	k	int
    //   152	93	7	m	int
    //   165	189	8	n	int
    //   179	191	9	i1	int
    //   251	92	10	l	long
    //   34	426	12	localObject1	Object
    //   263	121	13	localQQAlbumInfo	QQAlbumInfo
    //   394	22	13	localException1	java.lang.Exception
    //   472	1	13	localException2	java.lang.Exception
    //   481	1	13	localException3	java.lang.Exception
    //   203	148	14	localObject2	Object
    //   216	55	15	str	String
    // Exception table:
    //   from	to	target	type
    //   93	102	394	java/lang/Exception
    //   105	115	394	java/lang/Exception
    //   118	128	394	java/lang/Exception
    //   131	141	394	java/lang/Exception
    //   144	154	394	java/lang/Exception
    //   157	167	394	java/lang/Exception
    //   170	181	394	java/lang/Exception
    //   184	193	394	java/lang/Exception
    //   196	205	394	java/lang/Exception
    //   208	218	394	java/lang/Exception
    //   221	229	394	java/lang/Exception
    //   232	240	394	java/lang/Exception
    //   243	253	394	java/lang/Exception
    //   256	265	394	java/lang/Exception
    //   268	275	394	java/lang/Exception
    //   278	285	394	java/lang/Exception
    //   288	295	394	java/lang/Exception
    //   298	305	394	java/lang/Exception
    //   308	321	394	java/lang/Exception
    //   324	337	394	java/lang/Exception
    //   340	347	394	java/lang/Exception
    //   350	363	394	java/lang/Exception
    //   366	379	394	java/lang/Exception
    //   382	391	394	java/lang/Exception
    //   4	8	450	finally
    //   8	27	450	finally
    //   52	76	450	finally
    //   82	90	468	finally
    //   93	102	468	finally
    //   105	115	468	finally
    //   118	128	468	finally
    //   131	141	468	finally
    //   144	154	468	finally
    //   157	167	468	finally
    //   170	181	468	finally
    //   184	193	468	finally
    //   196	205	468	finally
    //   208	218	468	finally
    //   221	229	468	finally
    //   232	240	468	finally
    //   243	253	468	finally
    //   256	265	468	finally
    //   268	275	468	finally
    //   278	285	468	finally
    //   288	295	468	finally
    //   298	305	468	finally
    //   308	321	468	finally
    //   324	337	468	finally
    //   340	347	468	finally
    //   350	363	468	finally
    //   366	379	468	finally
    //   382	391	468	finally
    //   399	405	468	finally
    //   408	420	468	finally
    //   4	8	472	java/lang/Exception
    //   8	27	472	java/lang/Exception
    //   52	76	472	java/lang/Exception
    //   82	90	481	java/lang/Exception
  }
  
  List<LocalMediaInfo> a(Cursor paramCursor, int paramInt, aglx paramaglx)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("date_modified");
    int i1 = paramCursor.getColumnIndexOrThrow("duration");
    int i2 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i3 = paramCursor.getColumnIndexOrThrow("_size");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          for (;;)
          {
            if (!paramCursor.moveToNext()) {
              break label298;
            }
            str1 = paramCursor.getString(i2);
            if ((paramaglx == null) || (!paramaglx.a(str1))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("AlbumListAdapter", 2, "Filter mime type:" + str1);
            }
          }
          str2 = paramCursor.getString(m);
        } while ((TextUtils.isEmpty(str2)) || (!new File(str2).exists()));
        long l = paramCursor.getLong(n);
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo._id = paramCursor.getLong(k);
        localLocalMediaInfo.path = str2;
        localLocalMediaInfo.mMimeType = str1;
        localLocalMediaInfo.modifiedDate = l;
        localLocalMediaInfo.mDuration = paramCursor.getLong(i1);
        localLocalMediaInfo.fileSize = paramCursor.getLong(i3);
        localArrayList.add(localLocalMediaInfo);
        j = i + 1;
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (j < paramInt);
    label298:
    return localArrayList;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Long == 0L)) {}
    while (!a()) {
      return;
    }
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "qzone_album";
    localQQAlbumInfo.name = "空间相册";
    localQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
    this.jdField_a_of_type_JavaUtilList.add(0, localQQAlbumInfo);
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListAdapter", 1, "resetQzoneAlbum");
    }
    notifyDataSetChanged();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long > 0L) && (a()))
      {
        paramQQAlbumInfo = new QQAlbumInfo();
        paramQQAlbumInfo._id = "qzone_album";
        paramQQAlbumInfo.name = "空间相册";
        paramQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
        if (QLog.isColorLevel()) {
          QLog.d("AlbumListAdapter", 1, "addRecentAlbum");
        }
      }
      if (this.jdField_c_of_type_Boolean)
      {
        paramQQAlbumInfo = new QQAlbumInfo();
        paramQQAlbumInfo._id = "$CustomAlbumId";
        localObject = vuc.a().b();
        if (((List)localObject).size() > 0)
        {
          paramQQAlbumInfo.name = ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName;
          paramQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)((List)localObject).get(0));
        }
        paramQQAlbumInfo.mMediaFileCount = ((List)localObject).size();
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
      }
      notifyDataSetChanged();
      return;
      Object localObject = (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      if (((QQAlbumInfo)localObject)._id.equals("$RecentAlbumId")) {
        this.jdField_a_of_type_JavaUtilList.set(0, paramQQAlbumInfo);
      } else if (((QQAlbumInfo)localObject)._id.equals("qzone_album")) {
        this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
      } else {
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
      }
    }
  }
  
  public void a(List<QQAlbumInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
    ThreadManager.post(new NewAlbumListAdapter.1(this), 2, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i))._id.equals("qzone_album")) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public QQAlbumInfo b(Context paramContext, int paramInt1, int paramInt2, aglx paramaglx, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (paramaglx == null) {
      return null;
    }
    if (paramaglx.a()) {
      return a(paramContext, paramInt1, paramInt2, paramaglx, paramInt3, paramBoolean, paramArrayList);
    }
    return a(paramContext, paramInt1, paramInt2, paramaglx);
  }
  
  public void b()
  {
    ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a.a(-1);
  }
  
  public void b(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new NewAlbumListAdapter.3(this, paramQQAlbumInfo));
  }
  
  void b(List<QQAlbumInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new NewAlbumListAdapter.2(this, paramList));
  }
  
  public void c(QQAlbumInfo paramQQAlbumInfo)
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() < 2) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i))._id.equals("$VideoAlbumId")) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label131;
          }
          if (paramQQAlbumInfo.mMediaFileCount <= 0) {
            break label117;
          }
          this.jdField_a_of_type_JavaUtilList.set(i, paramQQAlbumInfo);
          break;
        }
        i += 1;
      }
      label117:
      this.jdField_a_of_type_JavaUtilList.remove(i);
      continue;
      label131:
      if (paramQQAlbumInfo.mMediaFileCount > 0) {
        this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
      }
    }
  }
  
  public void d(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      c(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new NewAlbumListAdapter.4(this, paramQQAlbumInfo));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return bbbj.a(((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a.a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return bbbj.d.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agro
 * JD-Core Version:    0.7.0.1
 */