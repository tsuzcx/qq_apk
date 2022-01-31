import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter.1;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter.2;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter.3;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter.4;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter.5;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter.6;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter.7;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afze
  extends BaseAdapter
{
  static final ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-2141891243);
  static final String jdField_a_of_type_JavaLangString;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  static final String[] jdField_d_of_type_ArrayOfJavaLangString;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public afzz a;
  public Activity a;
  Resources jdField_a_of_type_AndroidContentResResources;
  Drawable.ConstantState jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  public List<QQAlbumInfo> a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private List<String> jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 100;
  boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "_size>0 and ( _size < " + baaf.jdField_a_of_type_Int + " )  and (" + "width" + ">= 240 or " + "width" + " IS NULL) and (" + "height" + ">= 240 or " + "height" + " IS NULL )  and " + "height" + "  * 1.0 / " + "width" + ">= 0.45 and " + "height" + "  * 1.0 / " + "width" + "<= 2.2 and (" + "mime_type" + "='" + "image/jpeg" + "' or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpeg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.bmp%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.png%' )  or " + "mime_type" + " LIKE'%" + "bmp" + "%' or " + "mime_type" + " LIKE'%" + "bitmap" + "%' or " + "mime_type" + "='" + "image/png" + "'";
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };; jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" })
    {
      jdField_c_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
      jdField_d_of_type_ArrayOfJavaLangString = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
      return;
    }
  }
  
  public afze(Activity paramActivity, afzz paramafzz, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = paramActivity.getResources();
    this.jdField_a_of_type_Afzz = paramafzz;
    if (paramList != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838739).getConstantState();
      this.jdField_b_of_type_JavaUtilList = paramList;
      this.jdField_e_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131165303);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ThreadManager.getFileThreadHandler().post(new AlbumListAdapter.1(this));
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838988).getConstantState();
    }
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
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Afzz == afzz.a.get(5)) || (this.jdField_a_of_type_Afzz == afzz.a.get(4)) || (this.jdField_a_of_type_Afzz == afzz.a.get(6)) || (this.jdField_a_of_type_Afzz == afzz.a.get(7));
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
    //   2: new 260	com/tencent/mobileqq/data/QQAlbumInfo
    //   5: dup
    //   6: invokespecial 264	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 266
    //   16: putfield 268	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   19: aload 4
    //   21: getstatic 273	baae:n	Ljava/lang/String;
    //   24: putfield 276	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   27: aload 4
    //   29: iconst_0
    //   30: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   33: getstatic 285	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 291	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload_2
    //   42: getstatic 144	afze:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   45: ldc_w 293
    //   48: aconst_null
    //   49: ldc_w 295
    //   52: invokevirtual 301	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: getstatic 248	afzz:a	Landroid/util/SparseArray;
    //   61: iconst_2
    //   62: invokevirtual 254	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   65: checkcast 245	afzz
    //   68: astore 5
    //   70: aload 5
    //   72: ifnull +14 -> 86
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: aload_2
    //   79: iconst_m1
    //   80: aload 5
    //   82: invokevirtual 304	afze:a	(Landroid/database/Cursor;ILafzz;)Ljava/util/List;
    //   85: astore_3
    //   86: aload_2
    //   87: astore_1
    //   88: invokestatic 310	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   91: invokestatic 315	agak:a	(Landroid/content/Context;)Lagak;
    //   94: iconst_0
    //   95: iconst_m1
    //   96: invokevirtual 318	agak:a	(ZI)Ljava/util/ArrayList;
    //   99: astore 5
    //   101: aload_3
    //   102: ifnull +50 -> 152
    //   105: aload_2
    //   106: astore_1
    //   107: aload_3
    //   108: invokeinterface 321 1 0
    //   113: ifne +39 -> 152
    //   116: aload_2
    //   117: astore_1
    //   118: aload 4
    //   120: aload 4
    //   122: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   125: aload_3
    //   126: invokeinterface 325 1 0
    //   131: iadd
    //   132: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   135: aload_2
    //   136: astore_1
    //   137: aload 4
    //   139: aload_3
    //   140: iconst_0
    //   141: invokeinterface 258 2 0
    //   146: checkcast 327	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   149: putfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   152: aload 5
    //   154: ifnull +181 -> 335
    //   157: aload_2
    //   158: astore_1
    //   159: aload 5
    //   161: invokevirtual 332	java/util/ArrayList:isEmpty	()Z
    //   164: ifne +171 -> 335
    //   167: aload_2
    //   168: astore_1
    //   169: aload 4
    //   171: aload 4
    //   173: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   176: aload 5
    //   178: invokevirtual 333	java/util/ArrayList:size	()I
    //   181: iadd
    //   182: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   185: aload_2
    //   186: astore_1
    //   187: aload 5
    //   189: iconst_0
    //   190: invokevirtual 334	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   193: checkcast 336	agap
    //   196: astore_3
    //   197: aload_2
    //   198: astore_1
    //   199: aload 4
    //   201: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   204: ifnull +21 -> 225
    //   207: aload_2
    //   208: astore_1
    //   209: aload 4
    //   211: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   214: getfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   217: aload_3
    //   218: getfield 341	agap:b	J
    //   221: lcmp
    //   222: ifge +113 -> 335
    //   225: aload_2
    //   226: astore_1
    //   227: aload 4
    //   229: new 327	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   232: dup
    //   233: invokespecial 342	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   236: putfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   239: aload_2
    //   240: astore_1
    //   241: aload 4
    //   243: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   246: aload_3
    //   247: getfield 343	agap:jdField_a_of_type_Int	I
    //   250: i2l
    //   251: putfield 345	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   254: aload_2
    //   255: astore_1
    //   256: aload 4
    //   258: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   261: aload_3
    //   262: getfield 347	agap:jdField_c_of_type_Long	J
    //   265: putfield 350	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   268: aload_2
    //   269: astore_1
    //   270: aload 4
    //   272: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   275: aload_3
    //   276: getfield 352	agap:jdField_a_of_type_Long	J
    //   279: putfield 355	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   282: aload_2
    //   283: astore_1
    //   284: aload 4
    //   286: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   289: aload_3
    //   290: getfield 357	agap:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   293: putfield 360	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   296: aload_2
    //   297: astore_1
    //   298: aload 4
    //   300: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   303: aload_3
    //   304: getfield 341	agap:b	J
    //   307: putfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   310: aload_2
    //   311: astore_1
    //   312: aload 4
    //   314: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   317: aload_3
    //   318: getfield 362	agap:d	Ljava/lang/String;
    //   321: putfield 365	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   324: aload_2
    //   325: astore_1
    //   326: aload 4
    //   328: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   331: iconst_0
    //   332: putfield 368	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   335: aload_2
    //   336: ifnull +9 -> 345
    //   339: aload_2
    //   340: invokeinterface 373 1 0
    //   345: aload 4
    //   347: areturn
    //   348: astore_3
    //   349: aconst_null
    //   350: astore_2
    //   351: aload_2
    //   352: astore_1
    //   353: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +17 -> 373
    //   359: aload_2
    //   360: astore_1
    //   361: ldc_w 380
    //   364: iconst_2
    //   365: aload_3
    //   366: invokevirtual 383	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   369: aload_3
    //   370: invokestatic 386	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: aload_2
    //   374: ifnull -29 -> 345
    //   377: aload_2
    //   378: invokeinterface 373 1 0
    //   383: aload 4
    //   385: areturn
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_1
    //   389: aload_1
    //   390: ifnull +9 -> 399
    //   393: aload_1
    //   394: invokeinterface 373 1 0
    //   399: aload_2
    //   400: athrow
    //   401: astore_2
    //   402: goto -13 -> 389
    //   405: astore_3
    //   406: goto -55 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	afze
    //   0	409	1	paramContext	Context
    //   36	342	2	localObject1	Object
    //   386	14	2	localObject2	Object
    //   401	1	2	localObject3	Object
    //   1	317	3	localObject4	Object
    //   348	22	3	localException1	java.lang.Exception
    //   405	1	3	localException2	java.lang.Exception
    //   9	375	4	localQQAlbumInfo	QQAlbumInfo
    //   68	120	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	56	348	java/lang/Exception
    //   33	56	386	finally
    //   58	70	401	finally
    //   77	86	401	finally
    //   88	101	401	finally
    //   107	116	401	finally
    //   118	135	401	finally
    //   137	152	401	finally
    //   159	167	401	finally
    //   169	185	401	finally
    //   187	197	401	finally
    //   199	207	401	finally
    //   209	225	401	finally
    //   227	239	401	finally
    //   241	254	401	finally
    //   256	268	401	finally
    //   270	282	401	finally
    //   284	296	401	finally
    //   298	310	401	finally
    //   312	324	401	finally
    //   326	335	401	finally
    //   353	359	401	finally
    //   361	373	401	finally
    //   58	70	405	java/lang/Exception
    //   77	86	405	java/lang/Exception
    //   88	101	405	java/lang/Exception
    //   107	116	405	java/lang/Exception
    //   118	135	405	java/lang/Exception
    //   137	152	405	java/lang/Exception
    //   159	167	405	java/lang/Exception
    //   169	185	405	java/lang/Exception
    //   187	197	405	java/lang/Exception
    //   199	207	405	java/lang/Exception
    //   209	225	405	java/lang/Exception
    //   227	239	405	java/lang/Exception
    //   241	254	405	java/lang/Exception
    //   256	268	405	java/lang/Exception
    //   270	282	405	java/lang/Exception
    //   284	296	405	java/lang/Exception
    //   298	310	405	java/lang/Exception
    //   312	324	405	java/lang/Exception
    //   326	335	405	java/lang/Exception
  }
  
  /* Error */
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, afzz paramafzz)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iload_3
    //   7: ifgt +14 -> 21
    //   10: new 389	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 391
    //   17: invokespecial 394	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 260	com/tencent/mobileqq/data/QQAlbumInfo
    //   24: dup
    //   25: invokespecial 264	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   28: astore 8
    //   30: aload 8
    //   32: ldc_w 396
    //   35: putfield 268	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   38: aload 8
    //   40: getstatic 399	baae:l	Ljava/lang/String;
    //   43: putfield 276	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   46: iload_3
    //   47: ifle +143 -> 190
    //   50: getstatic 285	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 405	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore 5
    //   58: aload 5
    //   60: ldc_w 407
    //   63: iload_3
    //   64: invokestatic 411	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 417	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload 5
    //   73: invokevirtual 421	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   76: astore 5
    //   78: aload_1
    //   79: invokevirtual 291	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   82: aload 5
    //   84: getstatic 144	afze:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   87: ldc_w 293
    //   90: aconst_null
    //   91: ldc_w 295
    //   94: invokevirtual 301	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore_1
    //   98: aload 4
    //   100: ifnull +16 -> 116
    //   103: aload_1
    //   104: astore 5
    //   106: aload_0
    //   107: aload_1
    //   108: iload_3
    //   109: aload 4
    //   111: invokevirtual 304	afze:a	(Landroid/database/Cursor;ILafzz;)Ljava/util/List;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +59 -> 177
    //   121: aload_1
    //   122: astore 5
    //   124: aload 6
    //   126: invokeinterface 321 1 0
    //   131: ifne +46 -> 177
    //   134: aload_1
    //   135: astore 5
    //   137: aload 6
    //   139: invokeinterface 325 1 0
    //   144: istore_2
    //   145: aload_1
    //   146: astore 5
    //   148: aload 8
    //   150: iload_2
    //   151: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   154: iload_2
    //   155: ifle +22 -> 177
    //   158: aload_1
    //   159: astore 5
    //   161: aload 8
    //   163: aload 6
    //   165: iconst_0
    //   166: invokeinterface 258 2 0
    //   171: checkcast 327	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   174: putfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   177: aload_1
    //   178: ifnull +9 -> 187
    //   181: aload_1
    //   182: invokeinterface 373 1 0
    //   187: aload 8
    //   189: areturn
    //   190: getstatic 285	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   193: astore 5
    //   195: goto -117 -> 78
    //   198: astore 4
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: astore 5
    //   205: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +20 -> 228
    //   211: aload_1
    //   212: astore 5
    //   214: ldc_w 380
    //   217: iconst_2
    //   218: aload 4
    //   220: invokevirtual 383	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   223: aload 4
    //   225: invokestatic 386	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: ifnull -42 -> 187
    //   232: aload_1
    //   233: invokeinterface 373 1 0
    //   238: aload 8
    //   240: areturn
    //   241: astore_1
    //   242: aload 7
    //   244: astore 4
    //   246: aload 4
    //   248: ifnull +10 -> 258
    //   251: aload 4
    //   253: invokeinterface 373 1 0
    //   258: aload_1
    //   259: athrow
    //   260: astore_1
    //   261: aload 5
    //   263: astore 4
    //   265: goto -19 -> 246
    //   268: astore 4
    //   270: goto -68 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	afze
    //   0	273	1	paramContext	Context
    //   0	273	2	paramInt1	int
    //   0	273	3	paramInt2	int
    //   0	273	4	paramafzz	afzz
    //   56	206	5	localObject1	Object
    //   4	160	6	localList	List
    //   1	242	7	localObject2	Object
    //   28	211	8	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   50	78	198	java/lang/Exception
    //   78	98	198	java/lang/Exception
    //   190	195	198	java/lang/Exception
    //   50	78	241	finally
    //   78	98	241	finally
    //   190	195	241	finally
    //   106	116	260	finally
    //   124	134	260	finally
    //   137	145	260	finally
    //   148	154	260	finally
    //   161	177	260	finally
    //   205	211	260	finally
    //   214	228	260	finally
    //   106	116	268	java/lang/Exception
    //   124	134	268	java/lang/Exception
    //   137	145	268	java/lang/Exception
    //   148	154	268	java/lang/Exception
    //   161	177	268	java/lang/Exception
  }
  
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, afzz paramafzz, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "$RecentAlbumId";
    localQQAlbumInfo.name = baae.l;
    if (((AlbumListActivity)this.jdField_a_of_type_AndroidAppActivity).b()) {}
    for (paramArrayList = baaf.a(paramContext, null, null, paramInt2, paramafzz, paramInt1, 240, true, paramArrayList, false);; paramArrayList = baaf.a(paramContext, paramInt3, paramInt2, paramafzz, paramBoolean, paramInt1, paramArrayList, false))
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramArrayList.get(0));
        localQQAlbumInfo.mMediaFileCount = paramArrayList.size();
      }
      if (localQQAlbumInfo.mMediaFileCount < paramInt2) {
        break;
      }
      return localQQAlbumInfo;
    }
    paramContext = baaf.a(paramContext, 0, paramInt2, paramafzz, -1L);
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
  public List<QQAlbumInfo> a(Context paramContext, int paramInt, afzz paramafzz)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +118 -> 119
    //   4: getstatic 442	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 14
    //   9: aload_0
    //   10: invokespecial 443	afze:b	()Z
    //   13: ifeq +641 -> 654
    //   16: ldc_w 445
    //   19: astore 13
    //   21: aload_0
    //   22: getfield 165	afze:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   25: checkcast 424	com/tencent/mobileqq/activity/photo/AlbumListActivity
    //   28: invokevirtual 426	com/tencent/mobileqq/activity/photo/AlbumListActivity:b	()Z
    //   31: ifeq +119 -> 150
    //   34: new 58	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   41: getstatic 129	afze:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   44: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload 13
    //   49: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 447
    //   55: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 13
    //   63: aload_3
    //   64: instanceof 449
    //   67: ifeq +8 -> 75
    //   70: ldc_w 451
    //   73: astore 13
    //   75: aload_1
    //   76: invokevirtual 291	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   79: aload 14
    //   81: getstatic 56	afze:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   84: aload 13
    //   86: aconst_null
    //   87: ldc_w 453
    //   90: invokevirtual 301	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore_3
    //   94: aload_3
    //   95: ifnonnull +87 -> 182
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: astore 13
    //   103: aload_3
    //   104: ifnull +12 -> 116
    //   107: aload_3
    //   108: invokeinterface 373 1 0
    //   113: aload_1
    //   114: astore 13
    //   116: aload 13
    //   118: areturn
    //   119: getstatic 442	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   122: invokevirtual 405	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   125: astore 13
    //   127: aload 13
    //   129: ldc_w 407
    //   132: iload_2
    //   133: invokestatic 411	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: invokevirtual 417	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   139: pop
    //   140: aload 13
    //   142: invokevirtual 421	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   145: astore 14
    //   147: goto -138 -> 9
    //   150: new 58	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 455
    //   160: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 13
    //   165: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 447
    //   171: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 13
    //   179: goto -116 -> 63
    //   182: aload_3
    //   183: astore 13
    //   185: new 457	java/util/LinkedList
    //   188: dup
    //   189: invokespecial 458	java/util/LinkedList:<init>	()V
    //   192: astore_1
    //   193: aload_3
    //   194: astore 13
    //   196: aload_3
    //   197: ldc 40
    //   199: invokeinterface 462 2 0
    //   204: istore_2
    //   205: aload_3
    //   206: astore 13
    //   208: aload_3
    //   209: ldc 42
    //   211: invokeinterface 462 2 0
    //   216: istore 4
    //   218: aload_3
    //   219: astore 13
    //   221: aload_3
    //   222: ldc 48
    //   224: invokeinterface 462 2 0
    //   229: istore 5
    //   231: aload_3
    //   232: astore 13
    //   234: aload_3
    //   235: ldc 46
    //   237: invokeinterface 462 2 0
    //   242: istore 6
    //   244: aload_3
    //   245: astore 13
    //   247: aload_3
    //   248: ldc 136
    //   250: invokeinterface 462 2 0
    //   255: istore 7
    //   257: aload_3
    //   258: astore 13
    //   260: aload_3
    //   261: ldc 50
    //   263: invokeinterface 462 2 0
    //   268: istore 8
    //   270: aload_3
    //   271: astore 13
    //   273: aload_3
    //   274: ldc 52
    //   276: invokeinterface 462 2 0
    //   281: istore 9
    //   283: aload_3
    //   284: astore 13
    //   286: aload_3
    //   287: ldc_w 464
    //   290: invokeinterface 462 2 0
    //   295: istore 10
    //   297: aload_3
    //   298: astore 13
    //   300: aload_3
    //   301: invokeinterface 467 1 0
    //   306: ifeq +295 -> 601
    //   309: aload_3
    //   310: astore 13
    //   312: aload_3
    //   313: iload_2
    //   314: invokeinterface 470 2 0
    //   319: astore 16
    //   321: aload_3
    //   322: astore 13
    //   324: aload_3
    //   325: iload 4
    //   327: invokeinterface 470 2 0
    //   332: astore 17
    //   334: aload_3
    //   335: astore 13
    //   337: aload 16
    //   339: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   342: ifne -45 -> 297
    //   345: aload_3
    //   346: astore 13
    //   348: aload 17
    //   350: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   353: ifne -56 -> 297
    //   356: aload_3
    //   357: astore 13
    //   359: aload_3
    //   360: iload 5
    //   362: invokeinterface 470 2 0
    //   367: astore 14
    //   369: aload_3
    //   370: astore 13
    //   372: aload_3
    //   373: iload 6
    //   375: invokeinterface 479 2 0
    //   380: lstore 11
    //   382: aload_3
    //   383: astore 13
    //   385: new 260	com/tencent/mobileqq/data/QQAlbumInfo
    //   388: dup
    //   389: invokespecial 264	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   392: astore 15
    //   394: aload_3
    //   395: astore 13
    //   397: aload 15
    //   399: aload 17
    //   401: putfield 276	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   404: aload_3
    //   405: astore 13
    //   407: aload 15
    //   409: aload 16
    //   411: putfield 268	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   414: aload_3
    //   415: astore 13
    //   417: aload 15
    //   419: lload 11
    //   421: putfield 482	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   424: aload_3
    //   425: astore 13
    //   427: aload 15
    //   429: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   432: astore 16
    //   434: aload_3
    //   435: astore 13
    //   437: aload 16
    //   439: aload 14
    //   441: putfield 360	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   444: aload_3
    //   445: astore 13
    //   447: aload 16
    //   449: aload_3
    //   450: iload 7
    //   452: invokeinterface 479 2 0
    //   457: putfield 345	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   460: aload_3
    //   461: astore 13
    //   463: aload 16
    //   465: lload 11
    //   467: putfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   470: aload_3
    //   471: astore 13
    //   473: aload 16
    //   475: aload_3
    //   476: iload 8
    //   478: invokeinterface 485 2 0
    //   483: putfield 487	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   486: aload_3
    //   487: astore 13
    //   489: aload 16
    //   491: aload_3
    //   492: iload 9
    //   494: invokeinterface 470 2 0
    //   499: putfield 365	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   502: aload_3
    //   503: astore 13
    //   505: ldc 99
    //   507: aload 16
    //   509: getfield 365	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   512: invokevirtual 491	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   515: ifeq +14 -> 529
    //   518: aload_3
    //   519: astore 13
    //   521: aload 16
    //   523: ldc_w 493
    //   526: putfield 365	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   529: aload_3
    //   530: astore 13
    //   532: aload 15
    //   534: aload_3
    //   535: iload 10
    //   537: invokeinterface 485 2 0
    //   542: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   545: aload_3
    //   546: astore 13
    //   548: aload_1
    //   549: aload 15
    //   551: invokeinterface 496 2 0
    //   556: pop
    //   557: goto -260 -> 297
    //   560: astore 14
    //   562: aload_3
    //   563: astore 13
    //   565: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +18 -> 586
    //   571: aload_3
    //   572: astore 13
    //   574: ldc_w 498
    //   577: iconst_2
    //   578: ldc_w 500
    //   581: aload 14
    //   583: invokestatic 502	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   586: aload_1
    //   587: astore 13
    //   589: aload_3
    //   590: ifnull -474 -> 116
    //   593: aload_3
    //   594: invokeinterface 373 1 0
    //   599: aload_1
    //   600: areturn
    //   601: aload_1
    //   602: astore 13
    //   604: aload_3
    //   605: ifnull -489 -> 116
    //   608: aload_3
    //   609: invokeinterface 373 1 0
    //   614: aload_1
    //   615: areturn
    //   616: astore_1
    //   617: aconst_null
    //   618: astore 13
    //   620: aload 13
    //   622: ifnull +10 -> 632
    //   625: aload 13
    //   627: invokeinterface 373 1 0
    //   632: aload_1
    //   633: athrow
    //   634: astore_1
    //   635: goto -15 -> 620
    //   638: astore 14
    //   640: aconst_null
    //   641: astore_3
    //   642: aconst_null
    //   643: astore_1
    //   644: goto -82 -> 562
    //   647: astore 14
    //   649: aconst_null
    //   650: astore_1
    //   651: goto -89 -> 562
    //   654: ldc_w 504
    //   657: astore 13
    //   659: goto -638 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	afze
    //   0	662	1	paramContext	Context
    //   0	662	2	paramInt	int
    //   0	662	3	paramafzz	afzz
    //   216	110	4	i	int
    //   229	132	5	j	int
    //   242	132	6	k	int
    //   255	196	7	m	int
    //   268	209	8	n	int
    //   281	212	9	i1	int
    //   295	241	10	i2	int
    //   380	86	11	l	long
    //   19	639	13	localObject1	Object
    //   7	433	14	localObject2	Object
    //   560	22	14	localException1	java.lang.Exception
    //   638	1	14	localException2	java.lang.Exception
    //   647	1	14	localException3	java.lang.Exception
    //   392	158	15	localQQAlbumInfo	QQAlbumInfo
    //   319	203	16	localObject3	Object
    //   332	68	17	str	String
    // Exception table:
    //   from	to	target	type
    //   196	205	560	java/lang/Exception
    //   208	218	560	java/lang/Exception
    //   221	231	560	java/lang/Exception
    //   234	244	560	java/lang/Exception
    //   247	257	560	java/lang/Exception
    //   260	270	560	java/lang/Exception
    //   273	283	560	java/lang/Exception
    //   286	297	560	java/lang/Exception
    //   300	309	560	java/lang/Exception
    //   312	321	560	java/lang/Exception
    //   324	334	560	java/lang/Exception
    //   337	345	560	java/lang/Exception
    //   348	356	560	java/lang/Exception
    //   359	369	560	java/lang/Exception
    //   372	382	560	java/lang/Exception
    //   385	394	560	java/lang/Exception
    //   397	404	560	java/lang/Exception
    //   407	414	560	java/lang/Exception
    //   417	424	560	java/lang/Exception
    //   427	434	560	java/lang/Exception
    //   437	444	560	java/lang/Exception
    //   447	460	560	java/lang/Exception
    //   463	470	560	java/lang/Exception
    //   473	486	560	java/lang/Exception
    //   489	502	560	java/lang/Exception
    //   505	518	560	java/lang/Exception
    //   521	529	560	java/lang/Exception
    //   532	545	560	java/lang/Exception
    //   548	557	560	java/lang/Exception
    //   4	9	616	finally
    //   9	16	616	finally
    //   21	63	616	finally
    //   63	70	616	finally
    //   75	94	616	finally
    //   119	147	616	finally
    //   150	179	616	finally
    //   185	193	634	finally
    //   196	205	634	finally
    //   208	218	634	finally
    //   221	231	634	finally
    //   234	244	634	finally
    //   247	257	634	finally
    //   260	270	634	finally
    //   273	283	634	finally
    //   286	297	634	finally
    //   300	309	634	finally
    //   312	321	634	finally
    //   324	334	634	finally
    //   337	345	634	finally
    //   348	356	634	finally
    //   359	369	634	finally
    //   372	382	634	finally
    //   385	394	634	finally
    //   397	404	634	finally
    //   407	414	634	finally
    //   417	424	634	finally
    //   427	434	634	finally
    //   437	444	634	finally
    //   447	460	634	finally
    //   463	470	634	finally
    //   473	486	634	finally
    //   489	502	634	finally
    //   505	518	634	finally
    //   521	529	634	finally
    //   532	545	634	finally
    //   548	557	634	finally
    //   565	571	634	finally
    //   574	586	634	finally
    //   4	9	638	java/lang/Exception
    //   9	16	638	java/lang/Exception
    //   21	63	638	java/lang/Exception
    //   63	70	638	java/lang/Exception
    //   75	94	638	java/lang/Exception
    //   119	147	638	java/lang/Exception
    //   150	179	638	java/lang/Exception
    //   185	193	647	java/lang/Exception
  }
  
  List<LocalMediaInfo> a(Cursor paramCursor, int paramInt, afzz paramafzz)
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
            if ((paramafzz == null) || (!paramafzz.a(str1))) {
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
  
  List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    Object localObject;
    if ((paramList1 == null) && (paramList2 == null)) {
      localObject = null;
    }
    int j;
    int i;
    do
    {
      for (;;)
      {
        badi.a();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label562;
        }
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (a(paramList1.name)))
          {
            ((List)localObject).remove(paramList1);
            ((List)localObject).add(0, paramList1);
          }
          i += 1;
        }
        if ((paramList1 != null) || (paramList2 == null)) {
          break;
        }
        localObject = paramList2;
      }
      if (paramList1 == null) {
        break;
      }
      localObject = paramList1;
    } while (paramList2 == null);
    paramList2 = paramList2.iterator();
    label562:
    label704:
    label710:
    for (;;)
    {
      localObject = paramList1;
      if (!paramList2.hasNext()) {
        break;
      }
      localObject = (QQAlbumInfo)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      QQAlbumInfo localQQAlbumInfo;
      while (localIterator.hasNext())
      {
        localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
        if (localQQAlbumInfo._id.equals(((QQAlbumInfo)localObject)._id)) {
          localQQAlbumInfo.mMediaFileCount += ((QQAlbumInfo)localObject).mMediaFileCount;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label710;
        }
        localIterator = paramList1.iterator();
        i = 0;
        label239:
        if (localIterator.hasNext())
        {
          localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
          if (((QQAlbumInfo)localObject).coverDate > localQQAlbumInfo.coverDate)
          {
            j = 1;
            paramList1.add(i, localObject);
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label704;
          }
          paramList1.add(localObject);
          break;
          i += 1;
          break label239;
          if (!this.jdField_e_of_type_Boolean)
          {
            if (paramInt != -1) {
              break label595;
            }
            if (this.jdField_d_of_type_Boolean)
            {
              paramList1 = b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Afzz, this.jdField_e_of_type_Int, true, this.jdField_a_of_type_JavaUtilArrayList);
              ((List)localObject).add(0, paramList1);
            }
          }
          else if ((this.jdField_a_of_type_Afzz != null) && (this.jdField_a_of_type_Afzz.b()) && (!this.jdField_e_of_type_Boolean))
          {
            paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            paramList1 = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
            i = 0;
            if (paramList1 != null)
            {
              i = paramList1.getCount();
              paramList1.close();
            }
            if (i <= 0) {
              break label631;
            }
            this.jdField_a_of_type_Boolean = true;
            label461:
            if (this.jdField_a_of_type_Boolean)
            {
              if (paramInt != -1) {
                break label664;
              }
              paramList1 = a(this.jdField_a_of_type_AndroidAppActivity);
            }
          }
          for (;;)
          {
            ((List)localObject).add(1, paramList1);
            if ((!this.jdField_e_of_type_Boolean) && (paramInt == -1) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long > 0L))
            {
              paramList1 = new QQAlbumInfo();
              paramList1._id = "qzone_album";
              paramList1.name = ajjy.a(2131634411);
              paramList1.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
              ((List)localObject).add(0, paramList1);
            }
            badi.a("PEAK", "compact.queryRecentBucket");
            return localObject;
            paramList1 = b(this.jdField_a_of_type_AndroidAppActivity, 210, 100, this.jdField_a_of_type_Afzz);
            break;
            label595:
            paramList1 = new QQAlbumInfo();
            paramList1._id = "$RecentAlbumId";
            paramList1.name = baae.l;
            paramList1.mCoverInfo = new LocalMediaInfo();
            break;
            label631:
            paramList1 = agak.a(BaseApplicationImpl.getContext());
            i = 0;
            if (paramList1 != null) {
              i = paramList1.a();
            }
            if (i <= 0) {
              break label461;
            }
            this.jdField_a_of_type_Boolean = true;
            break label461;
            paramList1 = new QQAlbumInfo();
            paramList1._id = "$VideoAlbumId";
            paramList1.name = baae.n;
            paramList1.mCoverInfo = new LocalMediaInfo();
          }
        }
        break;
      }
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Long == 0L)) {}
    while (!a()) {
      return;
    }
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "qzone_album";
    localQQAlbumInfo.name = ajjy.a(2131634396);
    localQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
    this.jdField_a_of_type_JavaUtilList.add(0, localQQAlbumInfo);
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListAdapter", 1, "resetQzoneAlbum");
    }
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    int k = 1;
    int n = 0;
    Object localObject = this.jdField_a_of_type_Afzz;
    List localList;
    int i;
    if ((localObject != null) && (((afzz)localObject).a()))
    {
      badi.a();
      localList = a(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_Afzz);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt))
      {
        i = 1;
        badi.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      int j;
      if ((localObject != null) && (((afzz)localObject).b()) && (!this.jdField_e_of_type_Boolean))
      {
        badi.a();
        localObject = b(this.jdField_a_of_type_AndroidAppActivity, paramInt, (afzz)localObject);
        j = i;
        if (paramInt != -1)
        {
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((List)localObject).size() == paramInt) {
              j = 1;
            }
          }
        }
        badi.a("PEAK", "queryVideoBuckets");
      }
      for (;;)
      {
        badi.a();
        localList = a(localList, (List)localObject, paramInt);
        if (localList != null) {
          for (i = 0;; i = m + i)
          {
            m = i;
            if (k >= localList.size()) {
              break;
            }
            m = ((QQAlbumInfo)localList.get(k)).mMediaFileCount;
            k += 1;
          }
        }
        int m = 0;
        localObject = new StringBuilder().append("compact(");
        if (localList == null) {}
        for (i = n;; i = localList.size() - 1)
        {
          badi.a("PEAK", i + "," + m + ")");
          b(localList);
          if (paramInt != -1)
          {
            if ((j == 0) && (!this.jdField_e_of_type_Boolean)) {
              break;
            }
            ThreadManager.getFileThreadHandler().post(new AlbumListAdapter.6(this));
          }
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AlbumListAdapter.7(this));
        return;
        localObject = null;
        j = i;
      }
      i = 0;
      break;
      localList = null;
      i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
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
        paramQQAlbumInfo.name = ajjy.a(2131634400);
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
        localObject = vhg.a().b();
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
      if (((QQAlbumInfo)localObject)._id.equals("$RecentAlbumId"))
      {
        this.jdField_a_of_type_JavaUtilList.set(0, paramQQAlbumInfo);
      }
      else if (((QQAlbumInfo)localObject)._id.equals("qzone_album"))
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i))._id.equals("$RecentAlbumId")) {
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
      }
      else
      {
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
    ThreadManager.post(new AlbumListAdapter.2(this), 2, null, false);
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
  
  public QQAlbumInfo b(Context paramContext, int paramInt1, int paramInt2, afzz paramafzz)
  {
    return b(paramContext, paramInt1, paramInt2, paramafzz, -1, false, null);
  }
  
  public QQAlbumInfo b(Context paramContext, int paramInt1, int paramInt2, afzz paramafzz, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (paramafzz == null) {
      return null;
    }
    if (paramafzz.a()) {
      return a(paramContext, paramInt1, paramInt2, paramafzz, paramInt3, paramBoolean, paramArrayList);
    }
    return a(paramContext, paramInt1, paramInt2, paramafzz);
  }
  
  /* Error */
  public List<QQAlbumInfo> b(Context paramContext, int paramInt, afzz paramafzz)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +51 -> 52
    //   4: getstatic 285	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 291	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 146	afze:jdField_d_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   16: ldc_w 668
    //   19: aconst_null
    //   20: ldc_w 453
    //   23: invokevirtual 301	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   41: invokeinterface 373 1 0
    //   46: aload_1
    //   47: astore 12
    //   49: aload 12
    //   51: areturn
    //   52: getstatic 285	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   55: invokevirtual 405	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 407
    //   63: iload_2
    //   64: invokestatic 411	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 417	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual 421	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   75: astore_3
    //   76: goto -68 -> 8
    //   79: aload_3
    //   80: astore 12
    //   82: new 457	java/util/LinkedList
    //   85: dup
    //   86: invokespecial 458	java/util/LinkedList:<init>	()V
    //   89: astore_1
    //   90: aload_3
    //   91: astore 12
    //   93: aload_3
    //   94: ldc 40
    //   96: invokeinterface 462 2 0
    //   101: istore_2
    //   102: aload_3
    //   103: astore 12
    //   105: aload_3
    //   106: ldc 136
    //   108: invokeinterface 462 2 0
    //   113: istore 4
    //   115: aload_3
    //   116: astore 12
    //   118: aload_3
    //   119: ldc 42
    //   121: invokeinterface 462 2 0
    //   126: istore 5
    //   128: aload_3
    //   129: astore 12
    //   131: aload_3
    //   132: ldc 48
    //   134: invokeinterface 462 2 0
    //   139: istore 6
    //   141: aload_3
    //   142: astore 12
    //   144: aload_3
    //   145: ldc 46
    //   147: invokeinterface 462 2 0
    //   152: istore 7
    //   154: aload_3
    //   155: astore 12
    //   157: aload_3
    //   158: ldc 52
    //   160: invokeinterface 462 2 0
    //   165: istore 8
    //   167: aload_3
    //   168: astore 12
    //   170: aload_3
    //   171: ldc_w 464
    //   174: invokeinterface 462 2 0
    //   179: istore 9
    //   181: aload_3
    //   182: astore 12
    //   184: aload_3
    //   185: invokeinterface 467 1 0
    //   190: ifeq +245 -> 435
    //   193: aload_3
    //   194: astore 12
    //   196: aload_3
    //   197: iload_2
    //   198: invokeinterface 470 2 0
    //   203: astore 14
    //   205: aload_3
    //   206: astore 12
    //   208: aload_3
    //   209: iload 5
    //   211: invokeinterface 470 2 0
    //   216: astore 15
    //   218: aload_3
    //   219: astore 12
    //   221: aload 14
    //   223: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne -45 -> 181
    //   229: aload_3
    //   230: astore 12
    //   232: aload 15
    //   234: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne -56 -> 181
    //   240: aload_3
    //   241: astore 12
    //   243: aload_3
    //   244: iload 7
    //   246: invokeinterface 479 2 0
    //   251: lstore 10
    //   253: aload_3
    //   254: astore 12
    //   256: new 260	com/tencent/mobileqq/data/QQAlbumInfo
    //   259: dup
    //   260: invokespecial 264	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   263: astore 13
    //   265: aload_3
    //   266: astore 12
    //   268: aload 13
    //   270: aload 15
    //   272: putfield 276	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   275: aload_3
    //   276: astore 12
    //   278: aload 13
    //   280: aload 14
    //   282: putfield 268	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   285: aload_3
    //   286: astore 12
    //   288: aload 13
    //   290: lload 10
    //   292: putfield 482	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   295: aload_3
    //   296: astore 12
    //   298: aload 13
    //   300: getfield 331	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   303: astore 14
    //   305: aload_3
    //   306: astore 12
    //   308: aload 14
    //   310: aload_3
    //   311: iload 6
    //   313: invokeinterface 470 2 0
    //   318: putfield 360	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   321: aload_3
    //   322: astore 12
    //   324: aload 14
    //   326: aload_3
    //   327: iload 4
    //   329: invokeinterface 479 2 0
    //   334: putfield 345	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   337: aload_3
    //   338: astore 12
    //   340: aload 14
    //   342: lload 10
    //   344: putfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   347: aload_3
    //   348: astore 12
    //   350: aload 14
    //   352: aload_3
    //   353: iload 8
    //   355: invokeinterface 470 2 0
    //   360: putfield 365	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   363: aload_3
    //   364: astore 12
    //   366: aload 13
    //   368: aload_3
    //   369: iload 9
    //   371: invokeinterface 485 2 0
    //   376: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   379: aload_3
    //   380: astore 12
    //   382: aload_1
    //   383: aload 13
    //   385: invokeinterface 496 2 0
    //   390: pop
    //   391: goto -210 -> 181
    //   394: astore 13
    //   396: aload_3
    //   397: astore 12
    //   399: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +18 -> 420
    //   405: aload_3
    //   406: astore 12
    //   408: ldc_w 498
    //   411: iconst_2
    //   412: ldc_w 670
    //   415: aload 13
    //   417: invokestatic 502	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: aload_1
    //   421: astore 12
    //   423: aload_3
    //   424: ifnull -375 -> 49
    //   427: aload_3
    //   428: invokeinterface 373 1 0
    //   433: aload_1
    //   434: areturn
    //   435: aload_1
    //   436: astore 12
    //   438: aload_3
    //   439: ifnull -390 -> 49
    //   442: aload_3
    //   443: invokeinterface 373 1 0
    //   448: aload_1
    //   449: areturn
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 12
    //   454: aload 12
    //   456: ifnull +10 -> 466
    //   459: aload 12
    //   461: invokeinterface 373 1 0
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
    //   0	488	0	this	afze
    //   0	488	1	paramContext	Context
    //   0	488	2	paramInt	int
    //   0	488	3	paramafzz	afzz
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
  
  public void b()
  {
    a(-1);
  }
  
  public void b(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AlbumListAdapter.4(this, paramQQAlbumInfo));
  }
  
  void b(List<QQAlbumInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AlbumListAdapter.3(this, paramList));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
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
            break label132;
          }
          if (paramQQAlbumInfo.mMediaFileCount <= 0) {
            break label118;
          }
          this.jdField_a_of_type_JavaUtilList.set(i, paramQQAlbumInfo);
          break;
        }
        i += 1;
      }
      label118:
      this.jdField_a_of_type_JavaUtilList.remove(i);
      continue;
      label132:
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
    this.jdField_a_of_type_AndroidOsHandler.post(new AlbumListAdapter.5(this, paramQQAlbumInfo));
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
    return baaf.a(((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    TextView localTextView;
    QQAlbumInfo localQQAlbumInfo;
    label103:
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131495066, null);
      localTextView = (TextView)localView;
      localQQAlbumInfo = a(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + ajjy.a(2131634405));
      paramView = localQQAlbumInfo.name;
      if (!this.jdField_e_of_type_Boolean) {
        break label413;
      }
      localTextView.setText(localQQAlbumInfo.name);
      paramViewGroup = localTextView.getCompoundDrawables()[0];
      if (localQQAlbumInfo._id.equals("qzone_album")) {
        break label546;
      }
      if (getItemViewType(paramInt) != 1) {
        break label488;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label473;
      }
      paramView = baaf.a(localQQAlbumInfo.mCoverInfo, "VIDEO");
      label157:
      localObject = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      ((LocalMediaInfo)localObject).thumbWidth = 200;
      if ((paramViewGroup == null) || (!URLDrawable.class.isInstance(paramViewGroup))) {
        break label609;
      }
      paramViewGroup = (URLDrawable)paramViewGroup;
      if (!paramView.equals(paramViewGroup.getURL())) {
        break label609;
      }
    }
    for (;;)
    {
      localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        if (befo.d())
        {
          paramView = axwd.a(paramView, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
          label237:
          paramView.setTag(localQQAlbumInfo.mCoverInfo);
          paramView.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(this.jdField_a_of_type_AndroidContentResResources);
          paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
          localTextView.setCompoundDrawables(paramView, null, paramViewGroup, null);
          localObject = paramView;
        }
      }
      else if (this.jdField_b_of_type_JavaUtilList != null)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(localQQAlbumInfo._id)) {
          break label521;
        }
        paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840158);
        localTextView.setContentDescription(ajjy.a(2131634404));
        label344:
        paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
        localTextView.setCompoundDrawables((Drawable)localObject, null, paramView, null);
      }
      for (;;)
      {
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
        {
          localView.setBackgroundColor(-16777216);
          localTextView.setTextColor(-9211021);
        }
        return localView;
        localTextView = (TextView)paramView;
        localView = paramView;
        break;
        label413:
        if (localQQAlbumInfo.mMediaFileCount > 0) {
          paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
        }
        localTextView.setText(paramView);
        break label103;
        label473:
        paramView = baaf.a(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label157;
        label488:
        paramView = baaf.a(localQQAlbumInfo.mCoverInfo);
        break label157;
        paramViewGroup = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130842768);
        paramView = axwd.a(paramView, paramViewGroup, paramViewGroup);
        break label237;
        label521:
        paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840159);
        localTextView.setContentDescription(ajjy.a(2131634407));
        break label344;
        label546:
        paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130846556);
        paramView.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(this.jdField_a_of_type_AndroidContentResResources);
        paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
        localTextView.setCompoundDrawables(paramView, null, paramViewGroup, null);
      }
      label609:
      paramViewGroup = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return baaf.d.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afze
 * JD-Core Version:    0.7.0.1
 */