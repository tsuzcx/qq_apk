import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.6;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.troop.TroopFileProxyActivity;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class adsh
  extends BaseBubbleBuilder
  implements acjx
{
  public static LruCache<String, Drawable> a;
  public static HashMap<String, Long> a;
  static int c;
  static int d;
  public static int e;
  public View.OnClickListener a;
  protected View a;
  private aodn a;
  public Handler b;
  private boolean f;
  private boolean g;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131165219);
    c = (int)(localDisplayMetrics.widthPixels - bacc.a(localBaseApplication, 40.0F) * 2.0F - BaseChatItemLayout.s - BaseChatItemLayout.t - i * 2 - bacc.a(localBaseApplication, 10.0F));
    if (c > 640) {
      c = 640;
    }
    jdField_d_of_type_Int = c * 9 / 16;
    jdField_e_of_type_Int = 100;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static Drawable a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return new amyk(BaseApplicationImpl.getApplication().getResources(), null, paramInt2, paramInt3, -921103);
    }
    Object localObject;
    if (paramInt1 == 1) {
      localObject = axwd.b();
    }
    for (;;)
    {
      if ((localObject instanceof SkinnableBitmapDrawable))
      {
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
        return new amyk(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        if (paramInt1 == 2) {
          localObject = axwd.a();
        }
      }
      else
      {
        if ((localObject instanceof BitmapDrawable))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          return new amyk(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        }
        return null;
      }
      localObject = null;
    }
  }
  
  /* Error */
  public static Drawable a(Context paramContext, ayqd paramayqd, MessageForTroopFile paramMessageForTroopFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 127	ayqd:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4: astore 8
    //   6: aload_1
    //   7: getfield 129	ayqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: ifnull +80 -> 90
    //   13: aload_1
    //   14: getfield 129	ayqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: astore_2
    //   18: aload_2
    //   19: invokestatic 134	apdh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_0
    //   24: invokevirtual 45	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: astore 10
    //   29: aload 10
    //   31: invokevirtual 51	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   34: getfield 137	android/util/DisplayMetrics:densityDpi	I
    //   37: istore 6
    //   39: ldc 138
    //   41: iload 6
    //   43: i2f
    //   44: ldc 139
    //   46: fdiv
    //   47: fmul
    //   48: fstore_3
    //   49: aload_2
    //   50: ifnull +742 -> 792
    //   53: aload_2
    //   54: invokevirtual 145	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   57: ldc 147
    //   59: invokestatic 153	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   62: ifeq +730 -> 792
    //   65: getstatic 33	adsh:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   68: aload 8
    //   70: invokevirtual 157	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 159	android/graphics/drawable/Drawable
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: instanceof 161
    //   85: ifeq +11 -> 96
    //   88: aload_0
    //   89: areturn
    //   90: aload 8
    //   92: astore_2
    //   93: goto -75 -> 18
    //   96: aload_1
    //   97: getfield 129	ayqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   100: ifnull +692 -> 792
    //   103: new 163	java/io/File
    //   106: dup
    //   107: aload_1
    //   108: getfield 129	ayqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore_1
    //   115: aload_1
    //   116: iconst_0
    //   117: invokestatic 172	com/tencent/image/NativeGifImage:getImageSize	(Ljava/io/File;Z)Landroid/graphics/Rect;
    //   120: astore_0
    //   121: aload_0
    //   122: getfield 177	android/graphics/Rect:right	I
    //   125: aload_0
    //   126: getfield 180	android/graphics/Rect:bottom	I
    //   129: invokestatic 183	adsh:a	(II)[I
    //   132: astore_2
    //   133: aload_0
    //   134: aload_2
    //   135: iconst_0
    //   136: iaload
    //   137: iload 6
    //   139: sipush 160
    //   142: idiv
    //   143: idiv
    //   144: putfield 177	android/graphics/Rect:right	I
    //   147: aload_0
    //   148: aload_2
    //   149: iconst_1
    //   150: iaload
    //   151: iload 6
    //   153: sipush 160
    //   156: idiv
    //   157: idiv
    //   158: putfield 180	android/graphics/Rect:bottom	I
    //   161: aload_1
    //   162: iconst_0
    //   163: iconst_0
    //   164: aload_0
    //   165: invokevirtual 187	android/graphics/Rect:width	()I
    //   168: aload_0
    //   169: invokevirtual 190	android/graphics/Rect:height	()I
    //   172: ldc 138
    //   174: invokestatic 196	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +388 -> 567
    //   182: new 161	com/tencent/image/GifDrawable
    //   185: dup
    //   186: aload_1
    //   187: aload 10
    //   189: invokespecial 199	com/tencent/image/GifDrawable:<init>	(Lcom/tencent/image/AbstractGifImage;Landroid/content/res/Resources;)V
    //   192: astore_0
    //   193: getstatic 33	adsh:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   196: aload 8
    //   198: aload_0
    //   199: invokevirtual 203	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   202: pop
    //   203: aload_0
    //   204: areturn
    //   205: astore_0
    //   206: ldc 138
    //   208: fstore_3
    //   209: aload_0
    //   210: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   213: new 163	java/io/File
    //   216: dup
    //   217: aload 8
    //   219: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore_2
    //   223: getstatic 33	adsh:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   226: aload 8
    //   228: invokevirtual 157	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 159	android/graphics/drawable/Drawable
    //   234: astore_1
    //   235: aload_1
    //   236: astore_0
    //   237: aload_1
    //   238: ifnonnull -150 -> 88
    //   241: aload_1
    //   242: astore_0
    //   243: aload_2
    //   244: invokevirtual 210	java/io/File:exists	()Z
    //   247: ifeq -159 -> 88
    //   250: new 212	android/graphics/BitmapFactory$Options
    //   253: dup
    //   254: invokespecial 213	android/graphics/BitmapFactory$Options:<init>	()V
    //   257: astore_0
    //   258: aload_0
    //   259: iconst_1
    //   260: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   263: aload_2
    //   264: invokevirtual 219	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   267: aload_0
    //   268: invokestatic 224	bacm:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   271: pop
    //   272: aload_0
    //   273: getfield 227	android/graphics/BitmapFactory$Options:outWidth	I
    //   276: istore 5
    //   278: aload_0
    //   279: getfield 230	android/graphics/BitmapFactory$Options:outHeight	I
    //   282: istore 4
    //   284: aload_2
    //   285: invokevirtual 219	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   288: invokestatic 233	axwd:a	(Ljava/lang/String;)I
    //   291: istore 7
    //   293: iload 7
    //   295: bipush 90
    //   297: if_icmpeq +11 -> 308
    //   300: iload 7
    //   302: sipush 270
    //   305: if_icmpne +15 -> 320
    //   308: aload_0
    //   309: getfield 230	android/graphics/BitmapFactory$Options:outHeight	I
    //   312: istore 5
    //   314: aload_0
    //   315: getfield 227	android/graphics/BitmapFactory$Options:outWidth	I
    //   318: istore 4
    //   320: iload 5
    //   322: iload 4
    //   324: invokestatic 183	adsh:a	(II)[I
    //   327: astore_0
    //   328: aload_0
    //   329: iconst_0
    //   330: iaload
    //   331: istore 4
    //   333: aload_0
    //   334: iconst_1
    //   335: iaload
    //   336: istore 5
    //   338: new 235	java/io/BufferedInputStream
    //   341: dup
    //   342: new 237	java/io/FileInputStream
    //   345: dup
    //   346: aload_2
    //   347: invokespecial 240	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   350: invokespecial 243	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   353: astore_1
    //   354: aload_1
    //   355: astore_0
    //   356: aload_1
    //   357: invokestatic 249	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   360: astore_2
    //   361: aload_1
    //   362: astore_0
    //   363: aload_2
    //   364: iload 6
    //   366: invokevirtual 254	android/graphics/Bitmap:setDensity	(I)V
    //   369: aload_1
    //   370: astore_0
    //   371: aload_2
    //   372: invokevirtual 257	android/graphics/Bitmap:getWidth	()I
    //   375: iload 4
    //   377: if_icmpne +14 -> 391
    //   380: aload_1
    //   381: astore_0
    //   382: aload_2
    //   383: invokevirtual 260	android/graphics/Bitmap:getHeight	()I
    //   386: iload 5
    //   388: if_icmpeq +401 -> 789
    //   391: aload_1
    //   392: astore_0
    //   393: aload_2
    //   394: invokevirtual 257	android/graphics/Bitmap:getWidth	()I
    //   397: ifeq +392 -> 789
    //   400: aload_1
    //   401: astore_0
    //   402: aload_2
    //   403: invokevirtual 260	android/graphics/Bitmap:getHeight	()I
    //   406: ifeq +383 -> 789
    //   409: aload_1
    //   410: astore_0
    //   411: new 262	android/graphics/Matrix
    //   414: dup
    //   415: invokespecial 263	android/graphics/Matrix:<init>	()V
    //   418: astore 9
    //   420: aload_1
    //   421: astore_0
    //   422: aload 9
    //   424: iload 4
    //   426: i2f
    //   427: aload_2
    //   428: invokevirtual 257	android/graphics/Bitmap:getWidth	()I
    //   431: i2f
    //   432: fdiv
    //   433: iload 5
    //   435: i2f
    //   436: aload_2
    //   437: invokevirtual 260	android/graphics/Bitmap:getHeight	()I
    //   440: i2f
    //   441: fdiv
    //   442: invokevirtual 267	android/graphics/Matrix:setScale	(FF)V
    //   445: aload_1
    //   446: astore_0
    //   447: aload_2
    //   448: iconst_0
    //   449: iconst_0
    //   450: aload_2
    //   451: invokevirtual 257	android/graphics/Bitmap:getWidth	()I
    //   454: aload_2
    //   455: invokevirtual 260	android/graphics/Bitmap:getHeight	()I
    //   458: aload 9
    //   460: iconst_0
    //   461: invokestatic 271	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   464: astore 9
    //   466: aload_1
    //   467: astore_0
    //   468: aload 9
    //   470: iload 6
    //   472: invokevirtual 254	android/graphics/Bitmap:setDensity	(I)V
    //   475: aload_1
    //   476: astore_0
    //   477: aload_2
    //   478: invokevirtual 274	android/graphics/Bitmap:recycle	()V
    //   481: aload 9
    //   483: astore_2
    //   484: aload_1
    //   485: astore_0
    //   486: new 116	android/graphics/drawable/BitmapDrawable
    //   489: dup
    //   490: aload 10
    //   492: aload_2
    //   493: fload_3
    //   494: iload 4
    //   496: iload 5
    //   498: invokestatic 277	bacm:b	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   501: invokespecial 280	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   504: astore 9
    //   506: aload_1
    //   507: astore_0
    //   508: aload_2
    //   509: invokevirtual 274	android/graphics/Bitmap:recycle	()V
    //   512: aload_1
    //   513: astore_0
    //   514: getstatic 33	adsh:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   517: aload 8
    //   519: aload 9
    //   521: invokevirtual 203	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: pop
    //   525: aload 9
    //   527: astore_0
    //   528: aload_1
    //   529: ifnull -441 -> 88
    //   532: aload_1
    //   533: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   536: aload 9
    //   538: areturn
    //   539: astore_1
    //   540: aload_1
    //   541: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   544: aload 9
    //   546: astore_0
    //   547: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq -462 -> 88
    //   553: ldc_w 290
    //   556: iconst_2
    //   557: ldc_w 292
    //   560: aload_1
    //   561: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: aload 9
    //   566: areturn
    //   567: iconst_1
    //   568: aload_0
    //   569: invokevirtual 187	android/graphics/Rect:width	()I
    //   572: aload_0
    //   573: invokevirtual 190	android/graphics/Rect:height	()I
    //   576: invokestatic 297	adsh:a	(III)Landroid/graphics/drawable/Drawable;
    //   579: astore_0
    //   580: aload_0
    //   581: areturn
    //   582: astore_0
    //   583: aconst_null
    //   584: astore_1
    //   585: iconst_1
    //   586: iload 4
    //   588: iload 5
    //   590: invokestatic 297	adsh:a	(III)Landroid/graphics/drawable/Drawable;
    //   593: astore_2
    //   594: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +14 -> 611
    //   600: ldc_w 290
    //   603: iconst_2
    //   604: ldc_w 299
    //   607: aload_0
    //   608: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   611: aload_2
    //   612: astore_0
    //   613: aload_1
    //   614: ifnull -526 -> 88
    //   617: aload_1
    //   618: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   621: aload_2
    //   622: areturn
    //   623: astore_1
    //   624: aload_1
    //   625: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   628: aload_2
    //   629: astore_0
    //   630: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq -545 -> 88
    //   636: ldc_w 290
    //   639: iconst_2
    //   640: ldc_w 292
    //   643: aload_1
    //   644: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   647: aload_2
    //   648: areturn
    //   649: astore_2
    //   650: aconst_null
    //   651: astore_1
    //   652: aload_1
    //   653: astore_0
    //   654: iconst_1
    //   655: iload 4
    //   657: iload 5
    //   659: invokestatic 297	adsh:a	(III)Landroid/graphics/drawable/Drawable;
    //   662: astore 8
    //   664: aload_1
    //   665: astore_0
    //   666: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +16 -> 685
    //   672: aload_1
    //   673: astore_0
    //   674: ldc_w 290
    //   677: iconst_2
    //   678: ldc_w 301
    //   681: aload_2
    //   682: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   685: aload 8
    //   687: astore_0
    //   688: aload_1
    //   689: ifnull -601 -> 88
    //   692: aload_1
    //   693: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   696: aload 8
    //   698: areturn
    //   699: astore_1
    //   700: aload_1
    //   701: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   704: aload 8
    //   706: astore_0
    //   707: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq -622 -> 88
    //   713: ldc_w 290
    //   716: iconst_2
    //   717: ldc_w 292
    //   720: aload_1
    //   721: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   724: aload 8
    //   726: areturn
    //   727: astore_1
    //   728: aconst_null
    //   729: astore_0
    //   730: aload_0
    //   731: ifnull +7 -> 738
    //   734: aload_0
    //   735: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   738: aload_1
    //   739: athrow
    //   740: astore_0
    //   741: aload_0
    //   742: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   745: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq -10 -> 738
    //   751: ldc_w 290
    //   754: iconst_2
    //   755: ldc_w 292
    //   758: aload_0
    //   759: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   762: goto -24 -> 738
    //   765: astore_1
    //   766: goto -36 -> 730
    //   769: astore_2
    //   770: aload_1
    //   771: astore_0
    //   772: aload_2
    //   773: astore_1
    //   774: goto -44 -> 730
    //   777: astore_2
    //   778: goto -126 -> 652
    //   781: astore_0
    //   782: goto -197 -> 585
    //   785: astore_0
    //   786: goto -577 -> 209
    //   789: goto -305 -> 484
    //   792: goto -579 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	795	0	paramContext	Context
    //   0	795	1	paramayqd	ayqd
    //   0	795	2	paramMessageForTroopFile	MessageForTroopFile
    //   48	446	3	f1	float
    //   282	374	4	i	int
    //   276	382	5	j	int
    //   37	434	6	k	int
    //   291	15	7	m	int
    //   4	721	8	localObject1	Object
    //   418	147	9	localObject2	Object
    //   27	464	10	localResources	Resources
    // Exception table:
    //   from	to	target	type
    //   161	178	205	java/lang/Exception
    //   182	203	205	java/lang/Exception
    //   567	580	205	java/lang/Exception
    //   532	536	539	java/lang/Exception
    //   338	354	582	java/lang/OutOfMemoryError
    //   617	621	623	java/lang/Exception
    //   338	354	649	java/lang/Exception
    //   692	696	699	java/lang/Exception
    //   338	354	727	finally
    //   734	738	740	java/lang/Exception
    //   356	361	765	finally
    //   363	369	765	finally
    //   371	380	765	finally
    //   382	391	765	finally
    //   393	400	765	finally
    //   402	409	765	finally
    //   411	420	765	finally
    //   422	445	765	finally
    //   447	466	765	finally
    //   468	475	765	finally
    //   477	481	765	finally
    //   486	506	765	finally
    //   508	512	765	finally
    //   514	525	765	finally
    //   654	664	765	finally
    //   666	672	765	finally
    //   674	685	765	finally
    //   585	611	769	finally
    //   356	361	777	java/lang/Exception
    //   363	369	777	java/lang/Exception
    //   371	380	777	java/lang/Exception
    //   382	391	777	java/lang/Exception
    //   393	400	777	java/lang/Exception
    //   402	409	777	java/lang/Exception
    //   411	420	777	java/lang/Exception
    //   422	445	777	java/lang/Exception
    //   447	466	777	java/lang/Exception
    //   468	475	777	java/lang/Exception
    //   477	481	777	java/lang/Exception
    //   486	506	777	java/lang/Exception
    //   508	512	777	java/lang/Exception
    //   514	525	777	java/lang/Exception
    //   356	361	781	java/lang/OutOfMemoryError
    //   363	369	781	java/lang/OutOfMemoryError
    //   371	380	781	java/lang/OutOfMemoryError
    //   382	391	781	java/lang/OutOfMemoryError
    //   393	400	781	java/lang/OutOfMemoryError
    //   402	409	781	java/lang/OutOfMemoryError
    //   411	420	781	java/lang/OutOfMemoryError
    //   422	445	781	java/lang/OutOfMemoryError
    //   447	466	781	java/lang/OutOfMemoryError
    //   468	475	781	java/lang/OutOfMemoryError
    //   477	481	781	java/lang/OutOfMemoryError
    //   486	506	781	java/lang/OutOfMemoryError
    //   508	512	781	java/lang/OutOfMemoryError
    //   514	525	781	java/lang/OutOfMemoryError
    //   115	161	785	java/lang/Exception
  }
  
  private void a(ayqd paramayqd, MessageForTroopFile paramMessageForTroopFile)
  {
    if (paramayqd != null)
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = paramayqd.jdField_a_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramayqd.g;
      localTeamWorkFileImportInfo.j = apck.a(paramayqd.g);
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = 1;
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramMessageForTroopFile.fileSize;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramayqd.e;
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramayqd.h;
      localTeamWorkFileImportInfo.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (paramayqd.jdField_b_of_type_Int != 12) {
        localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = 1;
      axea.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
    }
  }
  
  private void a(bakh parambakh, ayqd paramayqd, boolean paramBoolean)
  {
    if (this.f)
    {
      this.g = amlh.a().c();
      this.f = false;
    }
    long l1 = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramayqd.g);
    String str2 = amlu.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = axfs.jdField_a_of_type_JavaLangString;
    }
    long l2 = apck.a(paramayqd.e);
    if ((this.g) && (axfs.a(paramayqd.e, paramayqd.g, str1)) && (l2 <= l1))
    {
      int j = 1;
      i = j;
      if (paramBoolean)
      {
        if (TextUtils.isEmpty(paramayqd.e)) {
          break label217;
        }
        paramayqd = new File(paramayqd.e);
        i = j;
        if (paramayqd == null)
        {
          i = j;
          if (paramayqd.exists()) {}
        }
      }
    }
    label217:
    for (int i = 0;; i = 0)
    {
      if (i != 0)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        parambakh.a(2131307011, this.jdField_a_of_type_AndroidContentContext.getString(2131654231), 2130838610);
      }
      return;
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if (paramInt1 <= 383)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt2 <= 383) {}
    }
    else
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt1 != 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt2 != 0) {
          if (paramInt1 <= paramInt2) {
            break label105;
          }
        }
      }
    }
    int[] arrayOfInt;
    label105:
    for (float f1 = 383 / paramInt1;; f1 = 383 / paramInt2)
    {
      j = (int)(paramInt1 * f1);
      i = (int)(f1 * paramInt2);
      arrayOfInt = new int[2];
      if ((j != 0) && (i != 0)) {
        break;
      }
      arrayOfInt[0] = c;
      arrayOfInt[1] = (c * 9 / 16);
      return arrayOfInt;
    }
    if ((j < jdField_d_of_type_Int) || (i < jdField_d_of_type_Int)) {
      if (j < i)
      {
        f1 = jdField_d_of_type_Int / j;
        j = jdField_d_of_type_Int;
        i = (int)(f1 * i + 0.5F);
        paramInt1 = i;
        paramInt2 = j;
        if (i > c)
        {
          paramInt1 = c;
          paramInt2 = j;
        }
      }
    }
    for (;;)
    {
      arrayOfInt[0] = paramInt2;
      arrayOfInt[1] = paramInt1;
      return arrayOfInt;
      paramInt2 = (int)(jdField_d_of_type_Int / i * j + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > c) {
        paramInt1 = c;
      }
      i = jdField_d_of_type_Int;
      paramInt2 = paramInt1;
      paramInt1 = i;
      continue;
      if ((j < c) && (i < c))
      {
        paramInt2 = j;
        paramInt1 = i;
      }
      else
      {
        if (j > i)
        {
          f1 = c / j;
          label284:
          if (j <= i) {
            break label402;
          }
        }
        label402:
        for (float f2 = jdField_d_of_type_Int / i;; f2 = jdField_d_of_type_Int / j)
        {
          f1 = Math.max(f1, f2);
          paramInt1 = (int)(j * f1 + 0.5F);
          i = (int)(f1 * i + 0.5F);
          paramInt2 = paramInt1;
          if (paramInt1 < jdField_d_of_type_Int) {
            paramInt2 = jdField_d_of_type_Int;
          }
          paramInt1 = paramInt2;
          if (paramInt2 > c) {
            paramInt1 = c;
          }
          paramInt2 = i;
          if (i < jdField_d_of_type_Int) {
            paramInt2 = jdField_d_of_type_Int;
          }
          if (paramInt2 <= c) {
            break label414;
          }
          i = c;
          paramInt2 = paramInt1;
          paramInt1 = i;
          break;
          f1 = c / i;
          break label284;
        }
        label414:
        i = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
    }
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    return apck.a(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    return apck.a(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean d(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    return ((paramChatMessage.width == 0) || (paramChatMessage.height != 0)) || (apck.a(paramChatMessage.fileName) == 2);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return new adsl(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    boolean bool1 = b(paramChatMessage);
    boolean bool2 = d(paramChatMessage);
    if (bool1) {}
    while (bool2) {
      return paramView;
    }
    paramView = a(paramView, paramChatMessage);
    paramViewGroup = (acju)aciy.a(paramView);
    this.jdField_a_of_type_Aodn.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    adsl localadsl = (adsl)paramViewGroup.getTag();
    if (localadsl.jdField_c_of_type_AndroidViewView != null) {
      localadsl.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (localadsl.jdField_d_of_type_AndroidViewView != null) {
      localadsl.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (localadsl.jdField_a_of_type_AndroidViewView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localadsl.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = BaseChatItemLayout.y;
      localLayoutParams.height = -2;
      localadsl.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      a(localadsl, paramViewGroup, paramChatMessage);
      a(localadsl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, localadsl);
      if (jdField_e_of_type_Boolean) {}
      try
      {
        localadsl.jdField_b_of_type_JavaLangStringBuilder.append(localadsl.jdField_a_of_type_AndroidWidgetTextView.getText()).append(" ");
        localadsl.jdField_b_of_type_JavaLangStringBuilder.append(localadsl.jdField_b_of_type_AndroidWidgetTextView.getText());
        localadsl.jdField_b_of_type_JavaLangStringBuilder.append(localadsl.jdField_c_of_type_AndroidWidgetTextView.getText());
        localadsl.jdField_b_of_type_JavaLangStringBuilder.append("按钮");
        paramViewGroup.setContentDescription(localadsl.jdField_b_of_type_JavaLangStringBuilder.toString());
        return paramViewGroup;
      }
      catch (Exception paramChatMessage) {}
      QLog.w("TroopFileItemBuilder", 1, "set LayoutParams, but holder.mContent is null!");
    }
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramacju = (adsl)paramacju;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = admc.a(this.jdField_a_of_type_AndroidContentContext);
      paramacju.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131298523));
      paramacju.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131298520));
      paramacju.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131298525));
      paramacju.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramChatMessage.findViewById(2131298521));
      paramacju.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramChatMessage.findViewById(2131298524));
      paramacju.jdField_c_of_type_AndroidViewView = paramChatMessage;
      paramacju.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      super.a(paramacju.jdField_c_of_type_AndroidViewView, paramacmv);
    }
    paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramChatMessage.setOnTouchListener(paramacmv);
    super.b(paramChatMessage, paramacmv);
    paramChatMessage.setOnClickListener(this);
    return paramChatMessage;
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    paramackl = (MessageForTroopFile)paramChatMessage;
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramackl);
    long l = -1L;
    if (localayqd != null) {
      l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayqd.g);
    }
    if (localayqd == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return parambakh;
              if (((apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (apdh.b(localayqd.jdField_a_of_type_JavaLangString))) && (localayqd != null) && (localayqd.jdField_b_of_type_Int != 12) && (d(paramChatMessage))) {
                b(parambakh, this.jdField_a_of_type_AndroidContentContext);
              }
              switch (localayqd.jdField_b_of_type_Int)
              {
              case 0: 
              case 1: 
              case 2: 
              case 3: 
              case 4: 
              case 5: 
              case 10: 
              case 12: 
              default: 
                return parambakh;
              case 6: 
                parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
                if ((paramackl != null) && (paramackl.fileSize <= l)) {
                  a(parambakh, localayqd, false);
                }
                break;
              }
            } while (aciy.a(5) != 1);
            parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
            return parambakh;
            parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
          } while (aciy.a(5) != 1);
          parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
          return parambakh;
          parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
        } while (aciy.a(5) != 1);
        parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
        return parambakh;
        if (!apdh.a(localayqd.jdField_a_of_type_JavaLangString))
        {
          TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin)).b();
          return parambakh;
        }
        parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
        if ((paramackl != null) && (paramackl.fileSize <= l)) {
          a(parambakh, localayqd, false);
        }
      } while (aciy.a(5) != 1);
      parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
      return parambakh;
      parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
      if ((paramackl != null) && (paramackl.fileSize <= l)) {
        a(parambakh, localayqd, false);
      }
    } while (aciy.a(5) != 1);
    parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
    return parambakh;
  }
  
  protected MessageForTroopFile a(View paramView)
  {
    paramView = (ackl)aciy.a(paramView);
    if (paramView.a.isMultiMsg) {
      return (MessageForTroopFile)apck.a(paramView.a);
    }
    return (MessageForTroopFile)paramView.a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return ajjy.a(2131649525);
    }
    return ajjy.a(2131649529);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject3 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
    if (localObject3 == null) {}
    Object localObject1;
    Object localObject2;
    Object localObject4;
    label1518:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                int i;
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              localObject1 = (MessageForTroopFile)paramChatMessage;
                              localObject2 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
                            } while (localObject2 == null);
                            i = badq.a((Activity)paramContext);
                            localObject4 = new aypd(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramContext);
                            switch (paramInt)
                            {
                            default: 
                              super.a(paramInt, paramContext, paramChatMessage);
                              return;
                            case 2131307001: 
                              if (i == 0)
                              {
                                azic.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
                                return;
                              }
                              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", paramChatMessage.frienduin, "", "");
                            }
                          } while (((ayqd)localObject2).jdField_b_of_type_Int != 8);
                          ((TroopFileTransferManager)localObject3).d(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
                          return;
                          if (i == 0)
                          {
                            azic.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
                            return;
                          }
                          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", paramChatMessage.frienduin, "", "");
                        } while ((((ayqd)localObject2).jdField_b_of_type_Int != 0) && (((ayqd)localObject2).jdField_b_of_type_Int != 1));
                        ((TroopFileTransferManager)localObject3).a(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
                        return;
                      } while (((ayqd)localObject2).jdField_b_of_type_Int != 9);
                      ((aypd)localObject4).b(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
                      return;
                    } while (((ayqd)localObject2).jdField_b_of_type_Int != 2);
                    ((aypd)localObject4).a(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
                    return;
                  } while ((((ayqd)localObject2).jdField_b_of_type_Int != 8) && (((ayqd)localObject2).jdField_b_of_type_Int != 9) && (((ayqd)localObject2).jdField_b_of_type_Int != 10));
                  ((TroopFileTransferManager)localObject3).d(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
                  a(((ayqd)localObject2).jdField_b_of_type_Long, (Activity)paramContext, ((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
                  return;
                  if (i == 0)
                  {
                    azic.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
                    return;
                  }
                } while ((((ayqd)localObject2).jdField_b_of_type_Int != 1) && (((ayqd)localObject2).jdField_b_of_type_Int != 0) && (((ayqd)localObject2).jdField_b_of_type_Int != 2) && (((ayqd)localObject2).jdField_b_of_type_Int != 3));
                ((TroopFileTransferManager)localObject3).a(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
                a(((ayqd)localObject2).jdField_b_of_type_Long, (Activity)paramContext, ((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID, paramChatMessage);
                return;
                if (i == 0)
                {
                  azic.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
                  return;
                }
                paramContext = new Bundle();
                paramContext.putInt("forward_type", 0);
                localObject3 = apck.a((ayqd)localObject2);
                ((FileManagerEntity)localObject3).status = 2;
                ((FileManagerEntity)localObject3).nOpType = 24;
                localObject4 = new ForwardFileInfo();
                ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject3).nSessionId);
                ((ForwardFileInfo)localObject4).b(10006);
                if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).getFilePath())) {
                  ((ForwardFileInfo)localObject4).a(((ayqd)localObject2).jdField_a_of_type_JavaLangString);
                }
                ((ForwardFileInfo)localObject4).d(((ayqd)localObject2).g);
                ((ForwardFileInfo)localObject4).d(((ayqd)localObject2).jdField_c_of_type_Long);
                ((ForwardFileInfo)localObject4).a(Long.parseLong(paramChatMessage.frienduin));
                if (((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID != null) {
                  ((ForwardFileInfo)localObject4).e(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID.toString());
                }
                if (!TextUtils.isEmpty(((ayqd)localObject2).jdField_c_of_type_JavaLangString)) {
                  ((ForwardFileInfo)localObject4).f(((ayqd)localObject2).jdField_c_of_type_JavaLangString);
                }
                for (;;)
                {
                  ((ForwardFileInfo)localObject4).d(1);
                  ((ForwardFileInfo)localObject4).a(1);
                  paramContext.putParcelable("fileinfo", (Parcelable)localObject4);
                  paramContext.putBoolean("not_forward", true);
                  paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
                  paramChatMessage = new Intent();
                  paramChatMessage.putExtras(paramContext);
                  paramChatMessage.putExtra("forward_text", ((ayqd)localObject2).g);
                  paramChatMessage.putExtra("forward_from_troop_file", true);
                  paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
                  paramChatMessage.putExtra("forward _key_nojump", true);
                  paramChatMessage.putExtra("sender_uin", ((MessageForTroopFile)localObject1).senderuin);
                  paramChatMessage.putExtra("last_time", ((MessageForTroopFile)localObject1).lastTime);
                  aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
                  if (((MessageForTroopFile)localObject1).isMultiMsg) {
                    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
                  }
                  awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
                  return;
                  if (!TextUtils.isEmpty(((ayqd)localObject2).jdField_d_of_type_JavaLangString)) {
                    ((ForwardFileInfo)localObject4).f(((ayqd)localObject2).jdField_d_of_type_JavaLangString);
                  }
                }
                azjg.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                return;
                apck.a((Activity)paramContext, ((ayqd)localObject2).jdField_a_of_type_JavaLangString);
                return;
              } while (((ayqd)localObject2).jdField_b_of_type_Int != 3);
              ((aypd)localObject4).a(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
              return;
            } while (((ayqd)localObject2).jdField_b_of_type_Int != 10);
            ((aypd)localObject4).b(((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID);
            return;
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", paramChatMessage.frienduin, "", "");
          } while ((localObject2 != null) && (((ayqd)localObject2).jdField_b_of_type_Int != 7));
          ((aypd)localObject4).a(((ayqd)localObject2).e, ((ayqd)localObject2).g, ((ayqd)localObject2).jdField_c_of_type_Long, ((ayqd)localObject2).h);
          return;
          awqx.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
          azjg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
          paramContext = apck.a((ayqd)localObject2);
          localObject2 = azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ayqd)localObject2).jdField_b_of_type_Long).a(paramContext.strTroopFilePath);
          if (localObject2 != null)
          {
            paramContext.lastTime = ((ayoq)localObject2).c;
            paramContext.selfUin = String.valueOf(((ayoq)localObject2).jdField_b_of_type_Long);
          }
          new bfhl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage, false);
        } while (!((MessageForTroopFile)localObject1).isMultiMsg);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
        return;
        super.d(paramChatMessage);
        return;
        localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localObject1 = "2";
        paramContext = (Context)localObject1;
        if (localObject2 != null)
        {
          if ((((TroopInfo)localObject2).troopowneruin != null) && (((TroopInfo)localObject2).troopowneruin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            paramContext = "1";
          }
        }
        else
        {
          if (!c(paramChatMessage)) {
            break label1518;
          }
          localObject1 = "1";
        }
        for (;;)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", paramContext, (String)localObject1);
          a(paramChatMessage);
          return;
          paramContext = (Context)localObject1;
          if (((TroopInfo)localObject2).Administrator == null) {
            break;
          }
          paramContext = (Context)localObject1;
          if (!((TroopInfo)localObject2).Administrator.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break;
          }
          paramContext = "2";
          break;
          if (d(paramChatMessage)) {
            localObject1 = "2";
          } else {
            localObject1 = "3";
          }
        }
      } while (localObject2 == null);
      a((ayqd)localObject2, (MessageForTroopFile)localObject1);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!((MessageForTroopFile)localObject1).isMultiMsg);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    ApolloUtil.a(((ayqd)localObject2).g, ((ayqd)localObject2).jdField_a_of_type_JavaLangString, new adsk(this, (ayqd)localObject2, (aypd)localObject4));
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new adsi(this, paramLong, paramUUID, paramActivity);
    babr.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131631827), this.jdField_a_of_type_AndroidContentContext.getString(2131631847), 2131631825, 2131631836, paramUUID, paramUUID).show();
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new adsj(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    babr.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131631831), this.jdField_a_of_type_AndroidContentContext.getString(2131631848), 2131631829, 2131631838, paramUUID, paramUUID).show();
  }
  
  public void a(adsl paramadsl, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    if (paramadsl.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramadsl.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130841999);
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101537));
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setText(2131631766);
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setPadding(azvv.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, azvv.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131298552);
      this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165219);
      azvv.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramViewGroup.addView(paramadsl.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    paramadsl.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramChatMessage.isSend())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramadsl.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      paramViewGroup.addRule(7, 2131298552);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165219) + azvv.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramadsl.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramadsl.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    paramViewGroup.addRule(5, 2131298552);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165219) + azvv.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramadsl.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a((View)paramView.getParent(), true);
  }
  
  void a(View paramView, boolean paramBoolean)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    paramView = a(paramView);
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramView;
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, paramView.frienduin + "", "", "", "");
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localayqd.jdField_b_of_type_Int == 12) {
      azic.a(localActivity, String.format(localActivity.getString(2131631866), new Object[] { azjg.a(localayqd.g) }), 1);
    }
    do
    {
      return;
      switch (localayqd.jdField_b_of_type_Int)
      {
      case 4: 
      case 5: 
      default: 
        return;
      }
    } while (!paramBoolean);
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramView.frienduin);
    TroopFileProxyActivity.b(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return;
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramView.frienduin);
    TroopFileProxyActivity.b(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return;
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
    apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, l, localayqd, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ChatMessage paramChatMessage, adsl paramadsl)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    localMessageForTroopFile.doParse();
    if (!localMessageForTroopFile.bReported)
    {
      localMessageForTroopFile.bReported = true;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_appear_AIO", 0, 0, "", paramChatMessage.frienduin, "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileItemBuilder", 4, "Build TroopFileItem");
      }
    }
    Object localObject = localMessageForTroopFile.fileName + localMessageForTroopFile.url;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      awqx.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localayqd == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileItemBuilder", 4, "get fileStatusInfo fail ");
      }
      return;
    }
    paramadsl.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    paramadsl.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
    paramadsl.jdField_a_of_type_AndroidWidgetTextView.setText(localayqd.g);
    boolean bool2 = false;
    int m = 0;
    int n = 0;
    int i1 = 0;
    localObject = "";
    boolean bool1;
    int k;
    int j;
    int i;
    switch (localayqd.jdField_b_of_type_Int)
    {
    default: 
      bool1 = bool2;
      k = m;
      j = n;
      i = i1;
      label332:
      if (paramChatMessage.fakeSenderType != 0) {
        i = 0;
      }
      if (k != 0)
      {
        paramadsl.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(j);
        paramadsl.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label364:
        if (i == 0) {
          break label1098;
        }
        paramadsl.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramadsl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        label386:
        paramadsl.jdField_b_of_type_AndroidWidgetTextView.setText(apdh.a(localayqd.jdField_c_of_type_Long));
        paramBaseChatItemLayout.setFailedIconVisable(bool1, this);
        paramBaseChatItemLayout = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
        if (localayqd.jdField_b_of_type_JavaLangString != null) {
          break label1136;
        }
        apck.a(paramadsl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localayqd.g);
        if (localayqd.jdField_a_of_type_JavaUtilUUID == null) {
          break label1110;
        }
        paramBaseChatItemLayout.a(localayqd.jdField_a_of_type_JavaUtilUUID, 128);
      }
      break;
    }
    while (ajia.a() > 17.0F)
    {
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramadsl.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramadsl.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label1200;
      }
      paramadsl.jdField_b_of_type_AndroidWidgetTextView.setGravity(5);
      paramBaseChatItemLayout.addRule(3, 2131298523);
      paramBaseChatItemLayout.addRule(2, 2131298525);
      paramBaseChatItemLayout.addRule(7, 2131298523);
      return;
      k = 1;
      j = 0;
      localObject = ajjy.a(2131649530);
      i = 1;
      bool1 = bool2;
      break label332;
      String str = ajjy.a(2131649578);
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (localMessageForTroopFile.msgtype != -2017) {
        break label332;
      }
      if (localMessageForTroopFile.extraflag != 32772)
      {
        localObject = str;
        i = i1;
        j = n;
        k = m;
        bool1 = bool2;
        if (localMessageForTroopFile.extraflag != 32768) {
          break label332;
        }
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!localMessageForTroopFile.isSendFromLocal()) {
        break label332;
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!TextUtils.isEmpty(localMessageForTroopFile.FromUin)) {
        break label332;
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!TextUtils.isEmpty(localayqd.e)) {
        break label332;
      }
      g(paramChatMessage);
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = ajjy.a(2131649559);
      g(paramChatMessage);
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = ajjy.a(2131649552);
      i = 1;
      k = 1;
      j = azjg.a(localayqd.jdField_d_of_type_Long, localayqd.jdField_c_of_type_Long);
      bool1 = bool2;
      break label332;
      localObject = ajjy.a(2131649563);
      k = 1;
      j = azjg.a(localayqd.jdField_d_of_type_Long, localayqd.jdField_c_of_type_Long);
      i = i1;
      bool1 = bool2;
      break label332;
      i = 1;
      localObject = ajjy.a(2131649541);
      k = 1;
      j = azjg.a(localayqd.jdField_d_of_type_Long, localayqd.jdField_c_of_type_Long);
      bool1 = bool2;
      break label332;
      i = 1;
      localObject = ajjy.a(2131649586);
      k = 1;
      j = azjg.a(localayqd.jdField_d_of_type_Long, localayqd.jdField_c_of_type_Long);
      bool1 = bool2;
      break label332;
      localObject = ajjy.a(2131649569);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = ajjy.a(2131649585);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = ajjy.a(2131649558);
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break label332;
      localObject = ajjy.a(2131649537);
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break label332;
      localObject = ajjy.a(2131649565);
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = ajjy.a(2131649536);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      paramadsl.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label364;
      label1098:
      paramadsl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label386;
      label1110:
      paramBaseChatItemLayout.a(localayqd.e, localayqd.g, localayqd.h, 128);
      continue;
      label1136:
      if ((TextUtils.isEmpty(localayqd.jdField_b_of_type_JavaLangString)) || (!bace.a(localayqd.jdField_b_of_type_JavaLangString)))
      {
        apck.a(paramadsl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localayqd.g);
      }
      else
      {
        apck.a(paramadsl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localayqd.g);
        paramadsl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localayqd.jdField_b_of_type_JavaLangString);
      }
    }
    label1200:
    paramadsl.jdField_b_of_type_AndroidWidgetTextView.setGravity(3);
    paramBaseChatItemLayout.addRule(3, -1);
    paramBaseChatItemLayout.addRule(2, -1);
    paramBaseChatItemLayout.addRule(12);
    paramBaseChatItemLayout.addRule(5, 2131298523);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    boolean bool1 = b(paramChatMessage);
    boolean bool2 = d(paramChatMessage);
    if ((!bool1) && (!bool2) && (paramacju.jdField_a_of_type_AndroidViewView != null))
    {
      if (paramChatMessage.isSend()) {
        paramacju.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848708);
      }
    }
    else {
      return;
    }
    paramacju.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848515);
  }
  
  public bakj[] a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    bakh localbakh = new bakh();
    paramView = a(paramView);
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label43;
      }
      a(localbakh, paramView, null);
    }
    for (;;)
    {
      return localbakh.a();
      label43:
      b(localbakh, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localayqd == null) {
      return parambakh;
    }
    long l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayqd.g);
    if (((apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (apdh.b(localayqd.jdField_a_of_type_JavaLangString))) && (localayqd != null) && (localayqd.jdField_b_of_type_Int != 12) && (d(paramChatMessage))) {
      b(parambakh, this.jdField_a_of_type_AndroidContentContext);
    }
    if (localayqd == null)
    {
      parambakh.a(2131306999, this.jdField_a_of_type_AndroidContentContext.getString(2131631883), 2130838595);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", paramChatMessage.frienduin, "", "");
      super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
      return parambakh;
    }
    paramackl = Boolean.valueOf(false);
    int i = 0;
    int k = 0;
    int m = 0;
    int j = 0;
    switch (localayqd.jdField_b_of_type_Int)
    {
    default: 
      label252:
      k = 0;
      j = i;
      i = k;
      label263:
      ApolloUtil.a(parambakh, localayqd.g);
      if (paramackl.booleanValue()) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", paramChatMessage.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
      if (i != 0) {
        parambakh.a(2131301048, this.jdField_a_of_type_AndroidContentContext.getString(2131628271), 2130838607);
      }
      if ((j == 0) || (c(localMessageForTroopFile)) || (d(localMessageForTroopFile))) {
        break;
      }
      parambakh.a(2131307006, this.jdField_a_of_type_AndroidContentContext.getString(2131631889), 2130838599);
      return parambakh;
      parambakh.a(2131307002, this.jdField_a_of_type_AndroidContentContext.getString(2131631885), 2130838602);
      parambakh.a(2131306996, this.jdField_a_of_type_AndroidContentContext.getString(2131631881));
      i = 0;
      j = 0;
      paramackl = Boolean.valueOf(true);
      break label263;
      parambakh.a(2131306998, this.jdField_a_of_type_AndroidContentContext.getString(2131631887), 2130838604);
      parambakh.a(2131306996, this.jdField_a_of_type_AndroidContentContext.getString(2131631881), 2130838586);
      i = 0;
      j = 0;
      paramackl = Boolean.valueOf(true);
      break label263;
      parambakh.a(2131307004, this.jdField_a_of_type_AndroidContentContext.getString(2131631887), 2130838611);
      parambakh.a(2131306996, this.jdField_a_of_type_AndroidContentContext.getString(2131631881), 2130838586);
      i = 0;
      j = 0;
      paramackl = Boolean.valueOf(true);
      break label263;
      parambakh.a(2131307001, this.jdField_a_of_type_AndroidContentContext.getString(2131631885), 2130838602);
      parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
      a(paramChatMessage, parambakh);
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      i = 1;
      parambakh.a(2131304871, this.jdField_a_of_type_AndroidContentContext.getString(2131628806), 2130838607);
      if (aciy.a(5) != 1) {
        break label252;
      }
      parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
      i = 0;
      j = 1;
      break label263;
      parambakh.a(2131306997, this.jdField_a_of_type_AndroidContentContext.getString(2131631882), 2130838595);
      parambakh.a(2131306995, this.jdField_a_of_type_AndroidContentContext.getString(2131631880), 2130838586);
      parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
      a(paramChatMessage, parambakh);
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      i = 1;
      parambakh.a(2131304871, this.jdField_a_of_type_AndroidContentContext.getString(2131628806), 2130838607);
      if (aciy.a(5) != 1) {
        break label252;
      }
      parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
      i = 0;
      j = 1;
      break label263;
      parambakh.a(2131307003, this.jdField_a_of_type_AndroidContentContext.getString(2131631886), 2130838604);
      parambakh.a(2131306995, this.jdField_a_of_type_AndroidContentContext.getString(2131631880), 2130838586);
      a(paramChatMessage, parambakh);
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      b(paramChatMessage, parambakh);
      parambakh.a(2131304871, this.jdField_a_of_type_AndroidContentContext.getString(2131628806), 2130838607);
      i = 0;
      j = 0;
      break label263;
      parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
      if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l)) {
        a(parambakh, localayqd, false);
      }
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      a(paramChatMessage, parambakh);
      i = j;
      if (!c(localMessageForTroopFile))
      {
        i = j;
        if (!d(localMessageForTroopFile)) {
          i = 1;
        }
      }
      parambakh.a(2131304871, this.jdField_a_of_type_AndroidContentContext.getString(2131628806), 2130838607);
      if (aciy.a(5) == 1) {
        parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
      }
      b(paramChatMessage, parambakh);
      j = 1;
      paramackl = Boolean.valueOf(true);
      break label263;
      if (!apdh.a(localayqd.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin)).b();
        i = 0;
        j = 0;
        break label263;
      }
      if ((!TextUtils.isEmpty(localayqd.jdField_a_of_type_JavaLangString)) && (bace.e(localayqd.jdField_a_of_type_JavaLangString))) {
        parambakh.a(2131307005, this.jdField_a_of_type_AndroidContentContext.getString(2131631888));
      }
      parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
      a(paramChatMessage, parambakh);
      if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l)) {
        a(parambakh, localayqd, false);
      }
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      i = k;
      if (!c(localMessageForTroopFile))
      {
        i = k;
        if (!d(localMessageForTroopFile)) {
          i = 1;
        }
      }
      parambakh.a(2131304871, this.jdField_a_of_type_AndroidContentContext.getString(2131628806), 2130838607);
      if (aciy.a(5) == 1) {
        parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
      }
      b(paramChatMessage, parambakh);
      j = 1;
      break label263;
      parambakh.a(2131306999, this.jdField_a_of_type_AndroidContentContext.getString(2131631883), 2130838595);
      parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131631890), 2130838599);
      a(paramChatMessage, parambakh);
      if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l)) {
        a(parambakh, localayqd, false);
      }
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      i = m;
      if (!c(localMessageForTroopFile))
      {
        i = m;
        if (!d(localMessageForTroopFile)) {
          i = 1;
        }
      }
      parambakh.a(2131304871, this.jdField_a_of_type_AndroidContentContext.getString(2131628806), 2130838607);
      if (aciy.a(5) == 1) {
        parambakh.a(2131307000, this.jdField_a_of_type_AndroidContentContext.getString(2131631884), 2130838598);
      }
      b(paramChatMessage, parambakh);
      j = 1;
      break label263;
      parambakh.a(2131304871, this.jdField_a_of_type_AndroidContentContext.getString(2131628806), 2130838607);
      i = 0;
      j = 0;
      break label263;
      i = 0;
      j = 0;
      break label263;
      parambakh.a(2131304871, this.jdField_a_of_type_AndroidContentContext.getString(2131628806), 2130838607);
      i = 0;
      j = 0;
      break label263;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", paramChatMessage.frienduin, "", "");
    }
  }
  
  public void g(ChatMessage paramChatMessage)
  {
    ThreadManager.post(new TroopFileItemBuilder.6(this, paramChatMessage), 8, null, true);
  }
  
  public void h(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      return;
      localObject = aciy.a(paramView);
      if (localObject == null)
      {
        QLog.w("TroopFileItemBuilder", 1, "item click holder tag is null");
        return;
      }
      if (!adsl.class.isInstance(localObject))
      {
        QLog.e("TroopFileItemBuilder", 1, "item click holder tag class[" + localObject.getClass().getName() + "] is not Holder");
        return;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", 0, 0, "4", "", "", "");
      localObject = (adsl)localObject;
      localObject = a(paramView);
    } while ((b((ChatMessage)localObject)) || (d((ChatMessage)localObject)) || ((((MessageForTroopFile)localObject).isMultiMsg) && (!apck.a((ChatMessage)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))));
    a(paramView, false);
    aciy.n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsh
 * JD-Core Version:    0.7.0.1
 */