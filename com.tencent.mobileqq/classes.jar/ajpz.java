import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import cooperation.zebra.ZebraPluginProxy;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortraitInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.GroupPicListInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody;

public class ajpz
{
  public static int a(int paramInt)
  {
    return (int)(0.5653333F * paramInt);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int i = paramInt4;
    paramInt4 = paramInt3;
    paramInt3 = j;
    if ((paramInt4 > paramInt2) || (i > paramInt1))
    {
      j = Math.round(paramInt4 / paramInt2);
      int k = Math.round(i / paramInt1);
      if (j > k) {}
      for (;;)
      {
        if (j < 2) {
          return paramInt3;
        }
        i /= 2;
        paramInt4 /= 2;
        paramInt3 *= 2;
        break;
        j = k;
      }
    }
    return paramInt3;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      paramInt1 = 1;
    }
    do
    {
      return paramInt1;
      paramInt2 = a(paramInt1, paramInt2, paramOptions.outHeight, paramOptions.outWidth);
      paramInt1 = paramInt2;
    } while (!com.tencent.TMG.utils.QLog.isColorLevel());
    com.tencent.TMG.utils.QLog.i("TroopPhotoUtil", 0, String.format("calculateInSampleSize [%d,%d,%d]", new Object[] { Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight), Integer.valueOf(paramInt2) }));
    return paramInt2;
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iconst_0
    //   7: istore_2
    //   8: new 60	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: new 66	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: sipush 8192
    //   30: newarray byte
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 73	java/io/InputStream:read	([B)I
    //   38: istore_3
    //   39: iload_3
    //   40: ifle +44 -> 84
    //   43: aload 4
    //   45: aload_1
    //   46: iconst_0
    //   47: iload_3
    //   48: invokevirtual 79	java/io/OutputStream:write	([BII)V
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_0
    //   56: astore_1
    //   57: aload 4
    //   59: astore_0
    //   60: iconst_m1
    //   61: istore_3
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 83	java/io/InputStream:close	()V
    //   70: iload_3
    //   71: istore_2
    //   72: aload_0
    //   73: ifnull +9 -> 82
    //   76: aload_0
    //   77: invokevirtual 84	java/io/OutputStream:close	()V
    //   80: iload_3
    //   81: istore_2
    //   82: iload_2
    //   83: ireturn
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 83	java/io/InputStream:close	()V
    //   92: aload 4
    //   94: ifnull -12 -> 82
    //   97: aload 4
    //   99: invokevirtual 84	java/io/OutputStream:close	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   116: goto -24 -> 92
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   124: goto -54 -> 70
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   132: iconst_m1
    //   133: ireturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_0
    //   137: aload 5
    //   139: astore 4
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 83	java/io/InputStream:close	()V
    //   149: aload 4
    //   151: ifnull +8 -> 159
    //   154: aload 4
    //   156: invokevirtual 84	java/io/OutputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   166: goto -17 -> 149
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   174: goto -15 -> 159
    //   177: astore_1
    //   178: aload 5
    //   180: astore 4
    //   182: goto -41 -> 141
    //   185: astore_1
    //   186: goto -45 -> 141
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_0
    //   192: aload 4
    //   194: astore_1
    //   195: goto -135 -> 60
    //   198: astore_1
    //   199: aconst_null
    //   200: astore 4
    //   202: aload_0
    //   203: astore_1
    //   204: aload 4
    //   206: astore_0
    //   207: goto -147 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString1	String
    //   0	210	1	paramString2	String
    //   7	76	2	i	int
    //   38	43	3	j	int
    //   4	201	4	localObject1	Object
    //   1	178	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	54	java/lang/Exception
    //   33	39	54	java/lang/Exception
    //   43	51	54	java/lang/Exception
    //   97	102	104	java/io/IOException
    //   88	92	111	java/io/IOException
    //   66	70	119	java/io/IOException
    //   76	80	127	java/io/IOException
    //   8	17	134	finally
    //   145	149	161	java/io/IOException
    //   154	159	169	java/io/IOException
    //   17	27	177	finally
    //   27	33	185	finally
    //   33	39	185	finally
    //   43	51	185	finally
    //   8	17	189	java/lang/Exception
    //   17	27	198	java/lang/Exception
  }
  
  public static int a(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait, List<TroopClipPic> paramList)
  {
    int n = paramGroupHeadPortrait.uint32_default_id.get();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_info.get().iterator();
    if (paramGroupHeadPortrait.hasNext())
    {
      oidb_0x88d.GroupHeadPortraitInfo localGroupHeadPortraitInfo = (oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next();
      TroopClipPic localTroopClipPic = new TroopClipPic();
      localTroopClipPic.id = String.valueOf(localGroupHeadPortraitInfo.rpt_uint32_pic_id.get());
      int i;
      label87:
      int j;
      label107:
      int k;
      if (localGroupHeadPortraitInfo.uint32_left_x.has())
      {
        i = localGroupHeadPortraitInfo.uint32_left_x.get();
        if (!localGroupHeadPortraitInfo.uint32_left_y.has()) {
          break label217;
        }
        j = localGroupHeadPortraitInfo.uint32_left_y.get();
        if (!localGroupHeadPortraitInfo.uint32_right_x.has()) {
          break label222;
        }
        k = localGroupHeadPortraitInfo.uint32_right_x.get();
        label128:
        if (!localGroupHeadPortraitInfo.uint32_right_y.has()) {
          break label228;
        }
      }
      label217:
      label222:
      label228:
      for (int m = localGroupHeadPortraitInfo.uint32_right_y.get();; m = 0)
      {
        if ((i >= 0) && (j >= 0) && (k >= 0) && (m >= 0)) {
          localTroopClipPic.clipInfo = a(i, j, k, m);
        }
        if (n == localGroupHeadPortraitInfo.rpt_uint32_pic_id.get()) {
          localTroopClipPic.type = 1;
        }
        paramList.add(localTroopClipPic);
        break;
        i = 0;
        break label87;
        j = 0;
        break label107;
        k = 0;
        break label128;
      }
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("TroopPhotoUtil", 0, String.format("getPicsFrom88d avatarId=%d %s", new Object[] { Integer.valueOf(n), Arrays.toString(paramList.toArray()) }));
    }
    return n;
  }
  
  public static int a(oidb_0x8b8.RspBody paramRspBody, List<TroopClipPic> paramList)
  {
    int n = paramRspBody.uint32_default_id.get();
    if ((paramRspBody.rpt_msg_pic_list_info.has()) && (paramRspBody.rpt_msg_pic_list_info.get().size() > 0))
    {
      paramRspBody = paramRspBody.rpt_msg_pic_list_info.get().iterator();
      while (paramRspBody.hasNext())
      {
        oidb_0x8b8.GroupPicListInfo localGroupPicListInfo = (oidb_0x8b8.GroupPicListInfo)paramRspBody.next();
        if (localGroupPicListInfo.uint32_pic_id.get() > 0)
        {
          TroopClipPic localTroopClipPic = new TroopClipPic();
          localTroopClipPic.id = String.valueOf(localGroupPicListInfo.uint32_pic_id.get());
          int i;
          label123:
          int j;
          label143:
          int k;
          if (localGroupPicListInfo.uint32_left_x.has())
          {
            i = localGroupPicListInfo.uint32_left_x.get();
            if (!localGroupPicListInfo.uint32_left_y.has()) {
              break label253;
            }
            j = localGroupPicListInfo.uint32_left_y.get();
            if (!localGroupPicListInfo.uint32_right_x.has()) {
              break label258;
            }
            k = localGroupPicListInfo.uint32_right_x.get();
            label164:
            if (!localGroupPicListInfo.uint32_right_y.has()) {
              break label264;
            }
          }
          label258:
          label264:
          for (int m = localGroupPicListInfo.uint32_right_y.get();; m = 0)
          {
            if ((i >= 0) && (j >= 0) && (k >= 0) && (m >= 0)) {
              localTroopClipPic.clipInfo = a(i, j, k, m);
            }
            if (n == localGroupPicListInfo.uint32_pic_id.get()) {
              localTroopClipPic.type = 1;
            }
            paramList.add(localTroopClipPic);
            break;
            i = 0;
            break label123;
            label253:
            j = 0;
            break label143;
            k = 0;
            break label164;
          }
        }
      }
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("TroopPhotoUtil", 0, String.format("getPicsFrom8b8 avatarId=%d %s", new Object[] { Integer.valueOf(n), Arrays.toString(paramList.toArray()) }));
    }
    return n;
  }
  
  public static final Point a(Activity paramActivity, int paramInt)
  {
    Point localPoint = new Point();
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels) {}
    for (int i = localDisplayMetrics.widthPixels;; i = localDisplayMetrics.heightPixels) {
      switch (paramInt)
      {
      default: 
        paramInt = i - AIOUtils.dp2px(65.0F, paramActivity.getResources());
        localPoint.set(paramInt, paramInt);
        return localPoint;
      }
    }
    localPoint.set(i, a(i));
    return localPoint;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (SystemUtil.isExistSDCard())
    {
      localStringBuilder.append(AppConstants.SDCARD_PATH_TROOPPHOTO).append("tmp/").append(System.currentTimeMillis()).append("_photo.tmp");
      return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    }
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir()).append("/tmp/").append(System.currentTimeMillis()).append("_photo.tmp");
    return localStringBuilder.toString();
  }
  
  public static final String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return "" + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return paramContext.getString(2131718158);
    }
    if (paramInt == 1) {
      return paramContext.getString(2131695571);
    }
    if (paramInt == 2) {
      return paramContext.getString(2131695570);
    }
    if (paramInt == 3) {
      return paramContext.getString(2131695572);
    }
    if (paramInt == 5) {
      return paramContext.getString(2131695569);
    }
    if (paramInt == 100) {
      return paramContext.getString(2131695553);
    }
    if (paramInt == 101) {
      return paramContext.getString(2131695554);
    }
    if (paramInt == 102) {
      return paramContext.getString(2131695551);
    }
    if (paramInt == 103) {
      return paramContext.getString(2131695555);
    }
    if (paramInt == 1793) {
      return paramContext.getString(2131693083);
    }
    return paramContext.getString(2131695568);
  }
  
  public static String a(List<ajnr> paramList, TroopInfo paramTroopInfo)
  {
    String str = ajnr.a;
    if (paramTroopInfo == null) {
      return str;
    }
    Iterator localIterator = paramTroopInfo.mTroopPicList.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.type == 1) {
        str = localTroopClipPic.id;
      } else {
        paramList.add(ajnr.a(localTroopClipPic, paramTroopInfo.mTroopVerifyingPics));
      }
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("TroopPhotoController", 0, String.format("getCoverFromDb infs=%s", new Object[] { Arrays.toString(paramList.toArray()) }));
    }
    return str;
  }
  
  public static URL a(String paramString)
  {
    String str = Uri.parse(paramString).getScheme();
    Object localObject = null;
    if ((TextUtils.isEmpty(str)) || ((!str.equals("http")) && (!str.equals("https")))) {}
    do
    {
      try
      {
        paramString = new File(paramString).toURL();
        return paramString;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        do
        {
          paramString = localObject;
        } while (!com.tencent.qphone.base.util.QLog.isColorLevel());
        com.tencent.qphone.base.util.QLog.i("Q.troopinfo", 2, localMalformedURLException1.toString());
        return null;
      }
      try
      {
        paramString = NearbyImgDownloader.convertURL(paramString);
        return paramString;
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        paramString = localObject;
      }
    } while (!com.tencent.qphone.base.util.QLog.isColorLevel());
    com.tencent.qphone.base.util.QLog.i("Q.troopinfo", 2, localMalformedURLException2.toString());
    return null;
  }
  
  public static Set<String> a(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait)
  {
    int i = paramGroupHeadPortrait.uint32_verifying_pic_cnt.get();
    int j = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.size();
    if ((i != j) && (com.tencent.TMG.utils.QLog.isColorLevel())) {
      com.tencent.TMG.utils.QLog.d("TroopInfo", 0, String.format("wrong data from server! uint32_verifying_pic_cnt = %d not equals rpt_msg_verifyingpic_info's size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    HashSet localHashSet = new HashSet();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.get().iterator();
    while (paramGroupHeadPortrait.hasNext()) {
      localHashSet.add(String.valueOf(((oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next()).rpt_uint32_pic_id.get()));
    }
    return localHashSet;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    String str = String.valueOf(paramInt);
    URL localURL = a(beyx.b(beyx.a(str, paramString2, 1)));
    if (localURL != null)
    {
      paramInt = a(paramString1, AbsDownloader.getFilePath(localURL.toString()));
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("TroopPhotoUtil", 0, "cacheFileFromLocal origin photo,result:" + paramInt);
      }
    }
    paramString2 = a(beyx.a(beyx.a(str, paramString2, 1)));
    if (paramString2 != null)
    {
      paramInt = b(paramString1, AbsDownloader.getFilePath(paramString2.toString()));
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("TroopPhotoUtil", 0, "cacheFileFromLocal thumb photo,result:" + paramInt);
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
    localBundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
      localBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localBundle.putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramActivity.overridePendingTransition(2130771979, 2130771977);
      ZebraPluginProxy.startPhotoList(paramActivity, localBundle);
      return;
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString, int paramInt)
  {
    Point localPoint = a(paramActivity, paramInt);
    paramIntent.putExtra("Business_Origin", paramInt);
    paramIntent.putExtra("BUSINESS_ORIGIN_NEW", paramInt);
    paramIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
    paramIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1024);
    paramIntent.putExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", a(paramInt));
    paramIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
    PhotoUtils.startPhotoEdit(paramIntent, paramActivity, paramActivity.getClass().getName(), localPoint.x, localPoint.y, 640, 640, paramString, a());
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    a(paramActivity, new Intent(), paramString, paramInt);
  }
  
  public static final void a(Rect paramRect, String paramString)
  {
    paramRect.set(0, 0, 0, 0);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("_");
      if ((paramString.length == 4) && (ayja.a(paramString[0])) && (ayja.a(paramString[1])) && (ayja.a(paramString[2])) && (ayja.a(paramString[3])))
      {
        int i = Integer.valueOf(paramString[0]).intValue();
        int j = Integer.valueOf(paramString[1]).intValue();
        int k = Integer.valueOf(paramString[2]).intValue();
        int m = Integer.valueOf(paramString[3]).intValue();
        if ((i >= 0) && (j >= 0) && (k > i) && (m > j)) {
          paramRect.set(i, j, k, m);
        }
      }
    }
  }
  
  public static final boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static final int b(int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    return -1;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return -1;
      Object localObject = new File(paramString1);
      BitmapFactory.Options localOptions = bfvo.a(((File)localObject).getPath(), 100);
      try
      {
        localObject = bfvo.a(((File)localObject).getPath(), localOptions);
        paramString2 = new File(paramString2);
        if (paramString2.exists()) {
          return 0;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        return -1;
      }
      try
      {
        int i = TroopUtils.readPictureDegree(paramString1);
        paramString1 = (String)localObject;
        if (i != 0) {
          paramString1 = bfvo.b((Bitmap)localObject, i);
        }
        if (paramString1 != null)
        {
          bfvo.a(paramString1, paramString2);
          return 0;
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return -1;
  }
  
  public static String b(List<TroopClipPic> paramList, TroopInfo paramTroopInfo)
  {
    String str = ajnr.a;
    if (paramTroopInfo == null) {}
    do
    {
      return str;
      paramList.addAll(paramTroopInfo.mTroopPicList);
    } while (!com.tencent.TMG.utils.QLog.isColorLevel());
    com.tencent.TMG.utils.QLog.i("TroopPhotoController", 0, String.format("getAllPicFromDb infs=%s", new Object[] { Arrays.toString(paramList.toArray()) }));
    return str;
  }
  
  public static void b(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent();
    Point localPoint = a(paramActivity, paramInt);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", paramInt);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", paramInt);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1024);
    localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
    localIntent.putExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", a(paramInt));
    PhotoUtils.startPhotoListEdit(localIntent, paramActivity, paramActivity.getClass().getName(), localPoint.x, localPoint.y, 640, 640, a());
  }
  
  public static final int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    }
    return 1;
  }
  
  public static final int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 102;
    }
    return 103;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpz
 * JD-Core Version:    0.7.0.1
 */