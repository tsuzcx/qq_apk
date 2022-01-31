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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.6;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
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

public class ageh
  extends BaseBubbleBuilder
  implements aeql
{
  public static LruCache<String, Drawable> a;
  public static HashMap<String, Long> a;
  static int c;
  static int d;
  public static int e;
  public View.OnClickListener a;
  protected View a;
  private aqrs a;
  public Handler b;
  private boolean f;
  private boolean g;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131296297);
    c = (int)(localDisplayMetrics.widthPixels - bdgz.a(localBaseApplication, 40.0F) * 2.0F - BaseChatItemLayout.s - BaseChatItemLayout.t - i * 2 - bdgz.a(localBaseApplication, 10.0F));
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
      return new apkn(BaseApplicationImpl.getApplication().getResources(), null, paramInt2, paramInt3, -921103);
    }
    Object localObject;
    if (paramInt1 == 1) {
      localObject = bayu.b();
    }
    for (;;)
    {
      if ((localObject instanceof SkinnableBitmapDrawable))
      {
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
        return new apkn(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        if (paramInt1 == 2) {
          localObject = bayu.a();
        }
      }
      else
      {
        if ((localObject instanceof BitmapDrawable))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          return new apkn(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        }
        return null;
      }
      localObject = null;
    }
  }
  
  /* Error */
  public static Drawable a(Context paramContext, bbtn parambbtn, MessageForTroopFile paramMessageForTroopFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 127	bbtn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4: astore 8
    //   6: aload_1
    //   7: getfield 129	bbtn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: ifnull +80 -> 90
    //   13: aload_1
    //   14: getfield 129	bbtn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: astore_2
    //   18: aload_2
    //   19: invokestatic 134	arso:a	(Ljava/lang/String;)Ljava/lang/String;
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
    //   65: getstatic 33	ageh:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
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
    //   97: getfield 129	bbtn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   100: ifnull +692 -> 792
    //   103: new 163	java/io/File
    //   106: dup
    //   107: aload_1
    //   108: getfield 129	bbtn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   129: invokestatic 183	ageh:a	(II)[I
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
    //   193: getstatic 33	ageh:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
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
    //   223: getstatic 33	ageh:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
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
    //   268: invokestatic 224	bdhj:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   271: pop
    //   272: aload_0
    //   273: getfield 227	android/graphics/BitmapFactory$Options:outWidth	I
    //   276: istore 5
    //   278: aload_0
    //   279: getfield 230	android/graphics/BitmapFactory$Options:outHeight	I
    //   282: istore 4
    //   284: aload_2
    //   285: invokevirtual 219	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   288: invokestatic 233	bayu:a	(Ljava/lang/String;)I
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
    //   324: invokestatic 183	ageh:a	(II)[I
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
    //   498: invokestatic 277	bdhj:b	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   501: invokespecial 280	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   504: astore 9
    //   506: aload_1
    //   507: astore_0
    //   508: aload_2
    //   509: invokevirtual 274	android/graphics/Bitmap:recycle	()V
    //   512: aload_1
    //   513: astore_0
    //   514: getstatic 33	ageh:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
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
    //   576: invokestatic 297	ageh:a	(III)Landroid/graphics/drawable/Drawable;
    //   579: astore_0
    //   580: aload_0
    //   581: areturn
    //   582: astore_0
    //   583: aconst_null
    //   584: astore_1
    //   585: iconst_1
    //   586: iload 4
    //   588: iload 5
    //   590: invokestatic 297	ageh:a	(III)Landroid/graphics/drawable/Drawable;
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
    //   659: invokestatic 297	ageh:a	(III)Landroid/graphics/drawable/Drawable;
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
    //   0	795	1	parambbtn	bbtn
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
  
  private void a(bbtn parambbtn, MessageForTroopFile paramMessageForTroopFile)
  {
    if (parambbtn != null)
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = parambbtn.jdField_a_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = parambbtn.g;
      localTeamWorkFileImportInfo.j = arrr.a(parambbtn.g);
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = 1;
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramMessageForTroopFile.fileSize;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = parambbtn.e;
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = parambbtn.h;
      localTeamWorkFileImportInfo.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (parambbtn.jdField_b_of_type_Int != 12) {
        localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = 1;
      bagk.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
    }
  }
  
  private void a(bdpi parambdpi, bbtn parambbtn, boolean paramBoolean)
  {
    if (this.f)
    {
      this.g = aoxg.a().c();
      this.f = false;
    }
    long l1 = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambbtn.g);
    String str2 = aoxw.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = baic.jdField_a_of_type_JavaLangString;
    }
    long l2 = arrr.a(parambbtn.e);
    if ((this.g) && (baic.a(parambbtn.e, parambbtn.g, str1)) && (l2 <= l1))
    {
      int j = 1;
      i = j;
      if (paramBoolean)
      {
        if (TextUtils.isEmpty(parambbtn.e)) {
          break label217;
        }
        parambbtn = new File(parambbtn.e);
        i = j;
        if (parambbtn == null)
        {
          i = j;
          if (parambbtn.exists()) {}
        }
      }
    }
    label217:
    for (int i = 0;; i = 0)
    {
      if (i != 0)
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        parambdpi.a(2131373107, this.jdField_a_of_type_AndroidContentContext.getString(2131720680), 2130838689);
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
    return arrr.a(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    return arrr.a(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean d(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    return ((paramChatMessage.width == 0) || (paramChatMessage.height != 0)) || (arrr.a(paramChatMessage.fileName) == 2);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqi a()
  {
    return new agel(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    boolean bool1 = b(paramChatMessage);
    boolean bool2 = d(paramChatMessage);
    if (bool1) {}
    while (bool2) {
      return paramView;
    }
    paramView = a(paramView, paramChatMessage);
    paramViewGroup = (aeqi)aepi.a(paramView);
    this.jdField_a_of_type_Aqrs.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    agel localagel = (agel)paramViewGroup.getTag();
    if (localagel.jdField_c_of_type_AndroidViewView != null) {
      localagel.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (localagel.jdField_d_of_type_AndroidViewView != null) {
      localagel.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (localagel.jdField_a_of_type_AndroidViewView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localagel.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = BaseChatItemLayout.y;
      localLayoutParams.height = -2;
      localagel.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      a(localagel, paramViewGroup, paramChatMessage);
      a(localagel.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, localagel);
      if (jdField_e_of_type_Boolean) {}
      try
      {
        localagel.jdField_b_of_type_JavaLangStringBuilder.append(localagel.jdField_a_of_type_AndroidWidgetTextView.getText()).append(" ");
        localagel.jdField_b_of_type_JavaLangStringBuilder.append(localagel.jdField_b_of_type_AndroidWidgetTextView.getText());
        localagel.jdField_b_of_type_JavaLangStringBuilder.append(localagel.jdField_c_of_type_AndroidWidgetTextView.getText());
        localagel.jdField_b_of_type_JavaLangStringBuilder.append("按钮");
        paramViewGroup.setContentDescription(localagel.jdField_b_of_type_JavaLangStringBuilder.toString());
        return paramViewGroup;
      }
      catch (Exception paramChatMessage) {}
      QLog.w("TroopFileItemBuilder", 1, "set LayoutParams, but holder.mContent is null!");
    }
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    paramChatMessage = (agel)paramaeqi;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    }
    return paramChatMessage;
  }
  
  public bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    paramaeqz = (MessageForTroopFile)paramChatMessage;
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaeqz);
    long l = -1L;
    if (localbbtn != null) {
      l = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbtn.g);
    }
    if (localbbtn == null) {}
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
              return parambdpi;
              if (((arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (arso.b(localbbtn.jdField_a_of_type_JavaLangString))) && (localbbtn != null) && (localbbtn.jdField_b_of_type_Int != 12) && (d(paramChatMessage))) {
                b(parambdpi, this.jdField_a_of_type_AndroidContentContext);
              }
              switch (localbbtn.jdField_b_of_type_Int)
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
                return parambdpi;
              case 6: 
                parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
                if ((paramaeqz != null) && (paramaeqz.fileSize <= l)) {
                  a(parambdpi, localbbtn, false);
                }
                break;
              }
            } while (aepi.a(5) != 1);
            parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
            return parambdpi;
            parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
          } while (aepi.a(5) != 1);
          parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
          return parambdpi;
          parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
        } while (aepi.a(5) != 1);
        parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
        return parambdpi;
        if (!arso.a(localbbtn.jdField_a_of_type_JavaLangString))
        {
          TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin)).b();
          return parambdpi;
        }
        parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
        if ((paramaeqz != null) && (paramaeqz.fileSize <= l)) {
          a(parambdpi, localbbtn, false);
        }
      } while (aepi.a(5) != 1);
      parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
      return parambdpi;
      parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
      if ((paramaeqz != null) && (paramaeqz.fileSize <= l)) {
        a(parambdpi, localbbtn, false);
      }
    } while (aepi.a(5) != 1);
    parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
    return parambdpi;
  }
  
  protected MessageForTroopFile a(View paramView)
  {
    paramView = (aeqz)aepi.a(paramView);
    if (paramView.a.isMultiMsg) {
      return (MessageForTroopFile)arrr.a(paramView.a);
    }
    return (MessageForTroopFile)paramView.a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bdil.a(paramChatMessage.issend)) {
      return alud.a(2131715710);
    }
    return alud.a(2131715714);
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
                              localObject2 = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
                            } while (localObject2 == null);
                            i = bdin.a((Activity)paramContext);
                            localObject4 = new bbsn(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramContext);
                            switch (paramInt)
                            {
                            default: 
                              super.a(paramInt, paramContext, paramChatMessage);
                              return;
                            case 2131373097: 
                              if (i == 0)
                              {
                                bcmp.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
                                return;
                              }
                              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", paramChatMessage.frienduin, "", "");
                            }
                          } while (((bbtn)localObject2).jdField_b_of_type_Int != 8);
                          ((TroopFileTransferManager)localObject3).d(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
                          return;
                          if (i == 0)
                          {
                            bcmp.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
                            return;
                          }
                          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", paramChatMessage.frienduin, "", "");
                        } while ((((bbtn)localObject2).jdField_b_of_type_Int != 0) && (((bbtn)localObject2).jdField_b_of_type_Int != 1));
                        ((TroopFileTransferManager)localObject3).a(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
                        return;
                      } while (((bbtn)localObject2).jdField_b_of_type_Int != 9);
                      ((bbsn)localObject4).b(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
                      return;
                    } while (((bbtn)localObject2).jdField_b_of_type_Int != 2);
                    ((bbsn)localObject4).a(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
                    return;
                  } while ((((bbtn)localObject2).jdField_b_of_type_Int != 8) && (((bbtn)localObject2).jdField_b_of_type_Int != 9) && (((bbtn)localObject2).jdField_b_of_type_Int != 10));
                  ((TroopFileTransferManager)localObject3).d(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
                  a(((bbtn)localObject2).jdField_b_of_type_Long, (Activity)paramContext, ((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
                  return;
                  if (i == 0)
                  {
                    bcmp.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
                    return;
                  }
                } while ((((bbtn)localObject2).jdField_b_of_type_Int != 1) && (((bbtn)localObject2).jdField_b_of_type_Int != 0) && (((bbtn)localObject2).jdField_b_of_type_Int != 2) && (((bbtn)localObject2).jdField_b_of_type_Int != 3));
                ((TroopFileTransferManager)localObject3).a(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
                a(((bbtn)localObject2).jdField_b_of_type_Long, (Activity)paramContext, ((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID, paramChatMessage);
                return;
                if (i == 0)
                {
                  bcmp.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
                  return;
                }
                paramContext = new Bundle();
                paramContext.putInt("forward_type", 0);
                localObject3 = arrr.a((bbtn)localObject2);
                ((FileManagerEntity)localObject3).status = 2;
                ((FileManagerEntity)localObject3).nOpType = 24;
                localObject4 = new ForwardFileInfo();
                ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject3).nSessionId);
                ((ForwardFileInfo)localObject4).b(10006);
                if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).getFilePath())) {
                  ((ForwardFileInfo)localObject4).a(((bbtn)localObject2).jdField_a_of_type_JavaLangString);
                }
                ((ForwardFileInfo)localObject4).d(((bbtn)localObject2).g);
                ((ForwardFileInfo)localObject4).d(((bbtn)localObject2).jdField_c_of_type_Long);
                ((ForwardFileInfo)localObject4).a(Long.parseLong(paramChatMessage.frienduin));
                if (((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID != null) {
                  ((ForwardFileInfo)localObject4).e(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID.toString());
                }
                if (!TextUtils.isEmpty(((bbtn)localObject2).jdField_c_of_type_JavaLangString)) {
                  ((ForwardFileInfo)localObject4).f(((bbtn)localObject2).jdField_c_of_type_JavaLangString);
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
                  paramChatMessage.putExtra("forward_text", ((bbtn)localObject2).g);
                  paramChatMessage.putExtra("forward_from_troop_file", true);
                  paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
                  paramChatMessage.putExtra("forward _key_nojump", true);
                  paramChatMessage.putExtra("sender_uin", ((MessageForTroopFile)localObject1).senderuin);
                  paramChatMessage.putExtra("last_time", ((MessageForTroopFile)localObject1).lastTime);
                  aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
                  if (((MessageForTroopFile)localObject1).isMultiMsg) {
                    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
                  }
                  azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
                  return;
                  if (!TextUtils.isEmpty(((bbtn)localObject2).jdField_d_of_type_JavaLangString)) {
                    ((ForwardFileInfo)localObject4).f(((bbtn)localObject2).jdField_d_of_type_JavaLangString);
                  }
                }
                bcnt.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                return;
                arrr.a((Activity)paramContext, ((bbtn)localObject2).jdField_a_of_type_JavaLangString);
                return;
              } while (((bbtn)localObject2).jdField_b_of_type_Int != 3);
              ((bbsn)localObject4).a(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
              return;
            } while (((bbtn)localObject2).jdField_b_of_type_Int != 10);
            ((bbsn)localObject4).b(((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID);
            return;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", paramChatMessage.frienduin, "", "");
          } while ((localObject2 != null) && (((bbtn)localObject2).jdField_b_of_type_Int != 7));
          ((bbsn)localObject4).a(((bbtn)localObject2).e, ((bbtn)localObject2).g, ((bbtn)localObject2).jdField_c_of_type_Long, ((bbtn)localObject2).h);
          return;
          azqs.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
          bcnt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
          paramContext = arrr.a((bbtn)localObject2);
          localObject2 = bcmu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((bbtn)localObject2).jdField_b_of_type_Long).a(paramContext.strTroopFilePath);
          if (localObject2 != null)
          {
            paramContext.lastTime = ((bbsa)localObject2).c;
            paramContext.selfUin = String.valueOf(((bbsa)localObject2).jdField_b_of_type_Long);
          }
          new biva(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage, false);
        } while (!((MessageForTroopFile)localObject1).isMultiMsg);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
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
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", paramContext, (String)localObject1);
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
      a((bbtn)localObject2, (MessageForTroopFile)localObject1);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!((MessageForTroopFile)localObject1).isMultiMsg);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    ApolloUtil.a(((bbtn)localObject2).g, ((bbtn)localObject2).jdField_a_of_type_JavaLangString, new agek(this, (bbtn)localObject2, (bbsn)localObject4));
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new agei(this, paramLong, paramUUID, paramActivity);
    bdgm.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697717), this.jdField_a_of_type_AndroidContentContext.getString(2131697739), 2131697715, 2131697726, paramUUID, paramUUID).show();
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new agej(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    bdgm.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697721), this.jdField_a_of_type_AndroidContentContext.getString(2131697740), 2131697719, 2131697728, paramUUID, paramUUID).show();
  }
  
  public void a(agel paramagel, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    if (paramagel.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramagel.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130842258);
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167194));
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setText(2131697656);
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setPadding(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364173);
      this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296297);
      bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramViewGroup.addView(paramagel.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    paramagel.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramChatMessage.isSend())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramagel.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      paramViewGroup.addRule(7, 2131364173);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296297) + bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramagel.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramagel.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    paramViewGroup.addRule(5, 2131364173);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296297) + bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramagel.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
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
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, paramView.frienduin + "", "", "", "");
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localbbtn.jdField_b_of_type_Int == 12) {
      bcmp.a(localActivity, String.format(localActivity.getString(2131697758), new Object[] { bcnt.a(localbbtn.g) }), 1);
    }
    do
    {
      return;
      switch (localbbtn.jdField_b_of_type_Int)
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
    arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, l, localbbtn, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ChatMessage paramChatMessage, agel paramagel)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    localMessageForTroopFile.doParse();
    if (!localMessageForTroopFile.bReported)
    {
      localMessageForTroopFile.bReported = true;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_appear_AIO", 0, 0, "", paramChatMessage.frienduin, "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileItemBuilder", 4, "Build TroopFileItem");
      }
    }
    Object localObject = localMessageForTroopFile.fileName + localMessageForTroopFile.url;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      azqs.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localbbtn == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileItemBuilder", 4, "get fileStatusInfo fail ");
      }
      return;
    }
    paramagel.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    paramagel.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
    paramagel.jdField_a_of_type_AndroidWidgetTextView.setText(localbbtn.g);
    boolean bool2 = false;
    int m = 0;
    int n = 0;
    int i1 = 0;
    localObject = "";
    boolean bool1;
    int k;
    int j;
    int i;
    switch (localbbtn.jdField_b_of_type_Int)
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
        paramagel.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(j);
        paramagel.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label364:
        if (i == 0) {
          break label1098;
        }
        paramagel.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramagel.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        label386:
        paramagel.jdField_b_of_type_AndroidWidgetTextView.setText(arso.a(localbbtn.jdField_c_of_type_Long));
        paramBaseChatItemLayout.setFailedIconVisable(bool1, this);
        paramBaseChatItemLayout = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
        if (localbbtn.jdField_b_of_type_JavaLangString != null) {
          break label1136;
        }
        arrr.a(paramagel.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localbbtn.g);
        if (localbbtn.jdField_a_of_type_JavaUtilUUID == null) {
          break label1110;
        }
        paramBaseChatItemLayout.a(localbbtn.jdField_a_of_type_JavaUtilUUID, 128);
      }
      break;
    }
    while (alsf.a() > 17.0F)
    {
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramagel.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramagel.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label1200;
      }
      paramagel.jdField_b_of_type_AndroidWidgetTextView.setGravity(5);
      paramBaseChatItemLayout.addRule(3, 2131364144);
      paramBaseChatItemLayout.addRule(2, 2131364146);
      paramBaseChatItemLayout.addRule(7, 2131364144);
      return;
      k = 1;
      j = 0;
      localObject = alud.a(2131715715);
      i = 1;
      bool1 = bool2;
      break label332;
      String str = alud.a(2131715763);
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
      if (!TextUtils.isEmpty(localbbtn.e)) {
        break label332;
      }
      g(paramChatMessage);
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = alud.a(2131715744);
      g(paramChatMessage);
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = alud.a(2131715737);
      i = 1;
      k = 1;
      j = bcnt.a(localbbtn.jdField_d_of_type_Long, localbbtn.jdField_c_of_type_Long);
      bool1 = bool2;
      break label332;
      localObject = alud.a(2131715748);
      k = 1;
      j = bcnt.a(localbbtn.jdField_d_of_type_Long, localbbtn.jdField_c_of_type_Long);
      i = i1;
      bool1 = bool2;
      break label332;
      i = 1;
      localObject = alud.a(2131715726);
      k = 1;
      j = bcnt.a(localbbtn.jdField_d_of_type_Long, localbbtn.jdField_c_of_type_Long);
      bool1 = bool2;
      break label332;
      i = 1;
      localObject = alud.a(2131715771);
      k = 1;
      j = bcnt.a(localbbtn.jdField_d_of_type_Long, localbbtn.jdField_c_of_type_Long);
      bool1 = bool2;
      break label332;
      localObject = alud.a(2131715754);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = alud.a(2131715770);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = alud.a(2131715743);
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break label332;
      localObject = alud.a(2131715722);
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break label332;
      localObject = alud.a(2131715750);
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      localObject = alud.a(2131715721);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label332;
      paramagel.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label364;
      label1098:
      paramagel.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label386;
      label1110:
      paramBaseChatItemLayout.a(localbbtn.e, localbbtn.g, localbbtn.h, 128);
      continue;
      label1136:
      if ((TextUtils.isEmpty(localbbtn.jdField_b_of_type_JavaLangString)) || (!bdhb.a(localbbtn.jdField_b_of_type_JavaLangString)))
      {
        arrr.a(paramagel.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localbbtn.g);
      }
      else
      {
        arrr.a(paramagel.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localbbtn.g);
        paramagel.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localbbtn.jdField_b_of_type_JavaLangString);
      }
    }
    label1200:
    paramagel.jdField_b_of_type_AndroidWidgetTextView.setGravity(3);
    paramBaseChatItemLayout.addRule(3, -1);
    paramBaseChatItemLayout.addRule(2, -1);
    paramBaseChatItemLayout.addRule(12);
    paramBaseChatItemLayout.addRule(5, 2131364144);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aeqi paramaeqi, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaeqi, paramInt1, paramInt2);
    boolean bool1 = b(paramChatMessage);
    boolean bool2 = d(paramChatMessage);
    if ((!bool1) && (!bool2) && (paramaeqi.jdField_a_of_type_AndroidViewView != null))
    {
      if (paramChatMessage.isSend()) {
        paramaeqi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849444);
      }
    }
    else {
      return;
    }
    paramaeqi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849268);
  }
  
  public bdpk[] a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    bdpi localbdpi = new bdpi();
    paramView = a(paramView);
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label43;
      }
      a(localbdpi, paramView, null);
    }
    for (;;)
    {
      return localbdpi.a();
      label43:
      b(localbdpi, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public bdpi b(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localbbtn == null) {
      return parambdpi;
    }
    long l = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbtn.g);
    if (((arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (arso.b(localbbtn.jdField_a_of_type_JavaLangString))) && (localbbtn != null) && (localbbtn.jdField_b_of_type_Int != 12) && (d(paramChatMessage))) {
      b(parambdpi, this.jdField_a_of_type_AndroidContentContext);
    }
    if (localbbtn == null)
    {
      parambdpi.a(2131373095, this.jdField_a_of_type_AndroidContentContext.getString(2131697775), 2130838674);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", paramChatMessage.frienduin, "", "");
      super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      return parambdpi;
    }
    paramaeqz = Boolean.valueOf(false);
    int i = 0;
    int k = 0;
    int m = 0;
    int j = 0;
    switch (localbbtn.jdField_b_of_type_Int)
    {
    default: 
      label252:
      k = 0;
      j = i;
      i = k;
      label263:
      ApolloUtil.a(parambdpi, localbbtn.g);
      if (paramaeqz.booleanValue()) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", paramChatMessage.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      if (i != 0) {
        parambdpi.a(2131366787, this.jdField_a_of_type_AndroidContentContext.getString(2131694031), 2130838686);
      }
      if ((j == 0) || (c(localMessageForTroopFile)) || (d(localMessageForTroopFile))) {
        break;
      }
      parambdpi.a(2131373102, this.jdField_a_of_type_AndroidContentContext.getString(2131697781), 2130838678);
      return parambdpi;
      parambdpi.a(2131373098, this.jdField_a_of_type_AndroidContentContext.getString(2131697777), 2130838681);
      parambdpi.a(2131373092, this.jdField_a_of_type_AndroidContentContext.getString(2131697773));
      i = 0;
      j = 0;
      paramaeqz = Boolean.valueOf(true);
      break label263;
      parambdpi.a(2131373094, this.jdField_a_of_type_AndroidContentContext.getString(2131697779), 2130838683);
      parambdpi.a(2131373092, this.jdField_a_of_type_AndroidContentContext.getString(2131697773), 2130838665);
      i = 0;
      j = 0;
      paramaeqz = Boolean.valueOf(true);
      break label263;
      parambdpi.a(2131373100, this.jdField_a_of_type_AndroidContentContext.getString(2131697779), 2130838690);
      parambdpi.a(2131373092, this.jdField_a_of_type_AndroidContentContext.getString(2131697773), 2130838665);
      i = 0;
      j = 0;
      paramaeqz = Boolean.valueOf(true);
      break label263;
      parambdpi.a(2131373097, this.jdField_a_of_type_AndroidContentContext.getString(2131697777), 2130838681);
      parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
      a(paramChatMessage, parambdpi);
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      i = 1;
      parambdpi.a(2131370861, this.jdField_a_of_type_AndroidContentContext.getString(2131694627), 2130838686);
      if (aepi.a(5) != 1) {
        break label252;
      }
      parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
      i = 0;
      j = 1;
      break label263;
      parambdpi.a(2131373093, this.jdField_a_of_type_AndroidContentContext.getString(2131697774), 2130838674);
      parambdpi.a(2131373091, this.jdField_a_of_type_AndroidContentContext.getString(2131697772), 2130838665);
      parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
      a(paramChatMessage, parambdpi);
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      i = 1;
      parambdpi.a(2131370861, this.jdField_a_of_type_AndroidContentContext.getString(2131694627), 2130838686);
      if (aepi.a(5) != 1) {
        break label252;
      }
      parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
      i = 0;
      j = 1;
      break label263;
      parambdpi.a(2131373099, this.jdField_a_of_type_AndroidContentContext.getString(2131697778), 2130838683);
      parambdpi.a(2131373091, this.jdField_a_of_type_AndroidContentContext.getString(2131697772), 2130838665);
      a(paramChatMessage, parambdpi);
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      b(paramChatMessage, parambdpi);
      parambdpi.a(2131370861, this.jdField_a_of_type_AndroidContentContext.getString(2131694627), 2130838686);
      i = 0;
      j = 0;
      break label263;
      parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
      if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l)) {
        a(parambdpi, localbbtn, false);
      }
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      a(paramChatMessage, parambdpi);
      i = j;
      if (!c(localMessageForTroopFile))
      {
        i = j;
        if (!d(localMessageForTroopFile)) {
          i = 1;
        }
      }
      parambdpi.a(2131370861, this.jdField_a_of_type_AndroidContentContext.getString(2131694627), 2130838686);
      if (aepi.a(5) == 1) {
        parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
      }
      b(paramChatMessage, parambdpi);
      j = 1;
      paramaeqz = Boolean.valueOf(true);
      break label263;
      if (!arso.a(localbbtn.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin)).b();
        i = 0;
        j = 0;
        break label263;
      }
      if ((!TextUtils.isEmpty(localbbtn.jdField_a_of_type_JavaLangString)) && (bdhb.e(localbbtn.jdField_a_of_type_JavaLangString))) {
        parambdpi.a(2131373101, this.jdField_a_of_type_AndroidContentContext.getString(2131697780));
      }
      parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
      a(paramChatMessage, parambdpi);
      if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l)) {
        a(parambdpi, localbbtn, false);
      }
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      i = k;
      if (!c(localMessageForTroopFile))
      {
        i = k;
        if (!d(localMessageForTroopFile)) {
          i = 1;
        }
      }
      parambdpi.a(2131370861, this.jdField_a_of_type_AndroidContentContext.getString(2131694627), 2130838686);
      if (aepi.a(5) == 1) {
        parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
      }
      b(paramChatMessage, parambdpi);
      j = 1;
      break label263;
      parambdpi.a(2131373095, this.jdField_a_of_type_AndroidContentContext.getString(2131697775), 2130838674);
      parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131697782), 2130838678);
      a(paramChatMessage, parambdpi);
      if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l)) {
        a(parambdpi, localbbtn, false);
      }
      if ((paramChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
        a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      i = m;
      if (!c(localMessageForTroopFile))
      {
        i = m;
        if (!d(localMessageForTroopFile)) {
          i = 1;
        }
      }
      parambdpi.a(2131370861, this.jdField_a_of_type_AndroidContentContext.getString(2131694627), 2130838686);
      if (aepi.a(5) == 1) {
        parambdpi.a(2131373096, this.jdField_a_of_type_AndroidContentContext.getString(2131697776), 2130838677);
      }
      b(paramChatMessage, parambdpi);
      j = 1;
      break label263;
      parambdpi.a(2131370861, this.jdField_a_of_type_AndroidContentContext.getString(2131694627), 2130838686);
      i = 0;
      j = 0;
      break label263;
      i = 0;
      j = 0;
      break label263;
      parambdpi.a(2131370861, this.jdField_a_of_type_AndroidContentContext.getString(2131694627), 2130838686);
      i = 0;
      j = 0;
      break label263;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", paramChatMessage.frienduin, "", "");
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
      localObject = aepi.a(paramView);
      if (localObject == null)
      {
        QLog.w("TroopFileItemBuilder", 1, "item click holder tag is null");
        return;
      }
      if (!agel.class.isInstance(localObject))
      {
        QLog.e("TroopFileItemBuilder", 1, "item click holder tag class[" + localObject.getClass().getName() + "] is not Holder");
        return;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", 0, 0, "4", "", "", "");
      localObject = (agel)localObject;
      localObject = a(paramView);
    } while ((b((ChatMessage)localObject)) || (d((ChatMessage)localObject)) || ((((MessageForTroopFile)localObject).isMultiMsg) && (!arrr.a((ChatMessage)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))));
    a(paramView, false);
    aepi.n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ageh
 * JD-Core Version:    0.7.0.1
 */