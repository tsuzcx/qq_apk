import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.1;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.3;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.5;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.6;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class aclt
{
  private static String jdField_a_of_type_JavaLangString;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new aclu(this);
  private baie jdField_a_of_type_Baie;
  private bbms jdField_a_of_type_Bbms;
  private bbsh jdField_a_of_type_Bbsh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private List<bahx>[] jdField_a_of_type_ArrayOfJavaUtilList;
  private Bitmap b;
  private Bitmap c;
  private Bitmap d;
  
  public aclt(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, IntimateInfo paramIntimateInfo, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.c = paramBitmap1;
    this.d = paramBitmap2;
    this.b = paramBitmap3;
    if ((this.c == null) || (this.c.isRecycled())) {
      this.c = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130845310);
    }
    if ((this.d == null) || (this.d.isRecycled())) {
      this.d = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130845310);
    }
    jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131628018) + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131628019) + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131628020);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    float f1 = paramInt1 / j;
    float f2 = paramInt2 / i;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, j, i, localMatrix, false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new IntimateInfoShareHelper.6(this, paramInt1, paramInt2));
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    if (this.jdField_a_of_type_Bbsh == null)
    {
      this.jdField_a_of_type_Bbsh = new aclv(this);
      WXShareHelper.a().a(this.jdField_a_of_type_Bbsh);
    }
    String str = a(paramBitmap);
    e();
    if (TextUtils.isEmpty(str)) {
      a(1, 2131628004);
    }
    do
    {
      return;
      if (paramInt == 3)
      {
        WXShareHelper.a().a(str, paramBitmap, 0);
        return;
      }
    } while (paramInt != 4);
    WXShareHelper.a().a(str, paramBitmap, 1);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, String paramString)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - paramPaint.getFontMetrics().top, paramPaint);
  }
  
  private void b(Bitmap paramBitmap)
  {
    paramBitmap = a(paramBitmap);
    e();
    if (TextUtils.isEmpty(paramBitmap))
    {
      a(1, 2131628004);
      return;
    }
    bfpy localbfpy = bfpy.a();
    localbfpy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    bfpr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localbfpy, paramBitmap, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131628022), "", 20001);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Baie = new baie(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ArrayOfJavaUtilList = a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Baie.a(this.jdField_a_of_type_ArrayOfJavaUtilList);
    this.jdField_a_of_type_Baie.a(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
  }
  
  private void c(Bitmap paramBitmap)
  {
    try
    {
      Object localObject = a(paramBitmap);
      e();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(1, 2131628004);
        return;
      }
      paramBitmap = new Bundle();
      paramBitmap.putInt("forward_type", 1);
      paramBitmap.putString("forward_filepath", (String)localObject);
      paramBitmap.putString("forward_thumb", (String)localObject);
      paramBitmap.putString("forward_urldrawable_big_url", (String)localObject);
      paramBitmap.putString("forward_extra", "intimate_share");
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBitmap);
      aphp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Intent)localObject, 21);
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      a(1, 2131628009);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bbms == null)
    {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bbms.c(true);
    }
    this.jdField_a_of_type_Bbms.c(2131628457);
    if ((this.jdField_a_of_type_Bbms != null) && (!this.jdField_a_of_type_Bbms.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_Bbms.show();
    }
  }
  
  private void d(Bitmap paramBitmap)
  {
    paramBitmap = a(paramBitmap);
    e();
    if (TextUtils.isEmpty(paramBitmap)) {
      a(1, 2131628004);
    }
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.getContext().getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
        if (QLog.isColorLevel()) {
          QLog.d("IntimateInfoShareHelper", 2, "shareMsgToSina installSinaWeibo:true");
        }
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setFlags(268435456);
        localIntent.setType("image/*");
        localIntent.putExtra("android.intent.extra.TEXT", jdField_a_of_type_JavaLangString);
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramBitmap)));
        FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getContext(), localIntent);
        localIntent.setPackage(((ApplicationInfo)localObject).packageName);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
        if (QLog.isColorLevel())
        {
          QLog.d("IntimateInfoShareHelper", 2, "shareMsgToSina start weibo!");
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramBitmap)
      {
        a(0, 2131628014);
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bbms.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public Bitmap a()
  {
    Object localObject1 = "https://ti.qq.com/open_qq/newIndex.html?url=mqqapi%3A%2F%2Fuserprofile%2Ffriend_profile_card%3Fsrc_type%3Dweb%26version%3D1.0%26source%3D1%26uin%3D" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    Object localObject2 = new Hashtable();
    ((Hashtable)localObject2).put(EncodeHintType.MARGIN, Integer.valueOf(0));
    ((Hashtable)localObject2).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    int m;
    int i;
    int j;
    try
    {
      localObject2 = new gu().a((String)localObject1, 100, 100, (Map)localObject2);
      k = ((gq)localObject2).a();
      m = ((gq)localObject2).b();
      localObject1 = new int[k * m];
      i = 0;
    }
    catch (WriterException localWriterException)
    {
      int k;
      if (!QLog.isColorLevel()) {
        break label183;
      }
      QLog.d("IntimateInfoShareHelper", 2, "Create QRCode fail");
      label183:
      return null;
    }
    if (j < k) {
      if (((gq)localObject2).a(j, i)) {
        localObject1[(i * k + j)] = -16777216;
      }
    }
    label208:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, k, 0, 0, k, m);
      return localObject2;
      for (;;)
      {
        if (i >= m) {
          break label208;
        }
        j = 0;
        break;
        j += 1;
        break;
        i += 1;
      }
    }
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Object localObject = Bitmap.createBitmap(a(this.b, 750, 1272), 0, 1100, 750, 172);
    Canvas localCanvas = new Canvas(paramBitmap);
    localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 1100.0F, null);
    localCanvas.drawBitmap(a(), 40.0F, 1125.0F, null);
    localObject = new TextPaint(1);
    ((TextPaint)localObject).setTextSize(24.0F);
    ((TextPaint)localObject).setTextAlign(Paint.Align.LEFT);
    ((TextPaint)localObject).setColor(Color.parseColor("#878B99"));
    localObject = new StaticLayout(jdField_a_of_type_JavaLangString.replace("，", "，\r\n"), (TextPaint)localObject, 350, Layout.Alignment.ALIGN_NORMAL, 1.2F, 0.0F, true);
    localCanvas.save();
    localCanvas.translate(152.0F, 1125.0F);
    ((StaticLayout)localObject).draw(localCanvas);
    localCanvas.restore();
    localCanvas.drawBitmap(a(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840107), 194, 40), 512.0F, 1185.0F, null);
    return paramBitmap;
  }
  
  public Bitmap a(IntimateInfo paramIntimateInfo)
  {
    Bitmap localBitmap2 = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    localCanvas.drawBitmap(a(this.b, 750, 1272), 0.0F, 0.0F, null);
    Object localObject = a(this.c, 140, 140);
    Bitmap localBitmap1 = a(this.d, 140, 140);
    localCanvas.drawBitmap((Bitmap)localObject, 248.0F, 180.0F, null);
    localObject = new Paint(1);
    ((Paint)localObject).setColor(-1);
    localCanvas.drawCircle(223.0F, 250.0F, 75.0F, (Paint)localObject);
    localCanvas.drawBitmap(localBitmap1, 153.0F, 180.0F, null);
    int j;
    int i;
    TextPaint localTextPaint;
    StringBuilder localStringBuilder;
    switch (paramIntimateInfo.maskType)
    {
    default: 
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131628010);
      j = Color.parseColor("#03081A");
      i = Color.parseColor("#878B99");
      localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840103);
      localTextPaint = new TextPaint(1);
      localTextPaint.setColor(j);
      localTextPaint.setTextSize(80.0F);
      localTextPaint.setTextAlign(Paint.Align.LEFT);
      a(localCanvas, localTextPaint, 146.0F, 364.0F, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays));
      float f = Layout.getDesiredWidth(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays), localTextPaint);
      localTextPaint.setTextSize(34.0F);
      a(localCanvas, localTextPaint, 8.0F + (f + 146.0F), 410.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131627960, new Object[] { "" }));
      a(localCanvas, localTextPaint, 152.0F, 468.0F, (String)localObject);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Resources)localObject).getString(2131628005));
      localStringBuilder.append("\r\n");
      localStringBuilder.append(((Resources)localObject).getString(2131628006));
      localStringBuilder.append("\r\n");
      j = 2;
      if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
      {
        localStringBuilder.append(((Resources)localObject).getString(2131627981));
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList.size());
        localStringBuilder.append(((Resources)localObject).getString(2131627969));
        localStringBuilder.append("\r\n");
        label493:
        if (paramIntimateInfo.dnaInfoList.size() >= j) {
          break label856;
        }
        j = paramIntimateInfo.dnaInfoList.size();
      }
      break;
    }
    label856:
    for (;;)
    {
      int k = 0;
      for (;;)
      {
        if (k < j)
        {
          localStringBuilder.append(((IntimateInfo.DNAInfo)paramIntimateInfo.dnaInfoList.get(k)).wording.replaceAll("，", "，\r\n"));
          localStringBuilder.append("\r\n");
          k += 1;
          continue;
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131628013);
          j = Color.parseColor("#FF6FA3");
          i = Color.parseColor("#FF8AB5");
          localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840106);
          break;
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131628011);
          j = Color.parseColor("#FF8A2D");
          i = Color.parseColor("#FF9F40");
          localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840104);
          break;
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131628012);
          j = Color.parseColor("#2493FF");
          i = Color.parseColor("#4DA7FF");
          localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840105);
          break;
          j = 3;
          break label493;
        }
      }
      localStringBuilder.append(((Resources)localObject).getString(2131628007));
      localStringBuilder.append("\r\n");
      localStringBuilder.append(((Resources)localObject).getString(2131628008));
      localTextPaint.setColor(i);
      localTextPaint.setTextSize(24.0F);
      paramIntimateInfo = new StaticLayout(localStringBuilder, localTextPaint, 300, Layout.Alignment.ALIGN_NORMAL, 1.7F, 0.0F, true);
      localCanvas.save();
      localCanvas.translate(152.0F, 560.0F);
      paramIntimateInfo.draw(localCanvas);
      localCanvas.restore();
      localCanvas.drawBitmap(a(localBitmap1, 254, 40), 248.0F, 1163.0F, null);
      return localBitmap2;
    }
  }
  
  /* Error */
  public String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 64	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 657
    //   10: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 663	java/lang/System:currentTimeMillis	()J
    //   16: invokevirtual 666	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 35	aclt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 669	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   26: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 671
    //   32: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 4
    //   40: new 353	java/io/File
    //   43: dup
    //   44: getstatic 676	ajed:aU	Ljava/lang/String;
    //   47: ldc_w 678
    //   50: invokespecial 680	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 683	java/io/File:mkdirs	()Z
    //   58: pop
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: ifnonnull +11 -> 73
    //   65: aload_0
    //   66: getfield 33	aclt:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   69: invokevirtual 687	android/support/v4/app/FragmentActivity:getCacheDir	()Ljava/io/File;
    //   72: astore_2
    //   73: aload_2
    //   74: ifnull +163 -> 237
    //   77: aload_2
    //   78: invokevirtual 690	java/io/File:canWrite	()Z
    //   81: ifeq +156 -> 237
    //   84: new 64	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   91: aload_2
    //   92: invokevirtual 693	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: getstatic 696	java/io/File:separator	Ljava/lang/String;
    //   101: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 4
    //   106: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore 4
    //   114: new 353	java/io/File
    //   117: dup
    //   118: aload 4
    //   120: invokespecial 354	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore_2
    //   124: aload_2
    //   125: invokevirtual 699	java/io/File:exists	()Z
    //   128: ifeq +8 -> 136
    //   131: aload_2
    //   132: invokevirtual 702	java/io/File:delete	()Z
    //   135: pop
    //   136: new 704	java/io/BufferedOutputStream
    //   139: dup
    //   140: new 706	java/io/FileOutputStream
    //   143: dup
    //   144: aload_2
    //   145: invokespecial 709	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: invokespecial 712	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   151: astore_3
    //   152: aload_3
    //   153: astore_2
    //   154: aload_1
    //   155: getstatic 718	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   158: bipush 100
    //   160: aload_3
    //   161: invokevirtual 722	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   164: pop
    //   165: aload_3
    //   166: astore_2
    //   167: aload_3
    //   168: invokevirtual 725	java/io/BufferedOutputStream:flush	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 728	java/io/BufferedOutputStream:close	()V
    //   179: aload 4
    //   181: areturn
    //   182: astore_1
    //   183: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq -7 -> 179
    //   189: ldc_w 322
    //   192: iconst_2
    //   193: aload_1
    //   194: invokevirtual 731	java/io/IOException:getMessage	()Ljava/lang/String;
    //   197: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload 4
    //   202: areturn
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_1
    //   208: astore_2
    //   209: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +17 -> 229
    //   215: aload_1
    //   216: astore_2
    //   217: ldc_w 322
    //   220: iconst_2
    //   221: aload 4
    //   223: invokevirtual 732	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   226: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 728	java/io/BufferedOutputStream:close	()V
    //   237: aconst_null
    //   238: areturn
    //   239: astore_1
    //   240: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq -6 -> 237
    //   246: ldc_w 322
    //   249: iconst_2
    //   250: aload_1
    //   251: invokevirtual 731	java/io/IOException:getMessage	()Ljava/lang/String;
    //   254: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto -20 -> 237
    //   260: astore_1
    //   261: aconst_null
    //   262: astore_2
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 728	java/io/BufferedOutputStream:close	()V
    //   271: aload_1
    //   272: athrow
    //   273: astore_2
    //   274: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -6 -> 271
    //   280: ldc_w 322
    //   283: iconst_2
    //   284: aload_2
    //   285: invokevirtual 731	java/io/IOException:getMessage	()Ljava/lang/String;
    //   288: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: goto -20 -> 271
    //   294: astore_1
    //   295: goto -32 -> 263
    //   298: astore 4
    //   300: aload_3
    //   301: astore_1
    //   302: goto -95 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	aclt
    //   0	305	1	paramBitmap	Bitmap
    //   60	208	2	localObject1	Object
    //   273	12	2	localIOException	java.io.IOException
    //   53	248	3	localObject2	Object
    //   38	163	4	str	String
    //   203	19	4	localException1	Exception
    //   298	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   175	179	182	java/io/IOException
    //   136	152	203	java/lang/Exception
    //   233	237	239	java/io/IOException
    //   136	152	260	finally
    //   267	271	273	java/io/IOException
    //   154	165	294	finally
    //   167	171	294	finally
    //   209	215	294	finally
    //   217	229	294	finally
    //   154	165	298	java/lang/Exception
    //   167	171	298	java/lang/Exception
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Baie == null) {
      c();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.1(this));
      return;
    }
    this.jdField_a_of_type_Baie.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Baie.a();
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    if ((paramInt == 3) || (paramInt == 4))
    {
      if (WXShareHelper.a().a()) {
        break label70;
      }
      bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131628015), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    for (;;)
    {
      d();
      ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.3(this, paramBitmap, paramInt));
      return;
      label70:
      if (!WXShareHelper.a().b()) {
        bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131628023), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.executeOnFileThread(new IntimateInfoShareHelper.5(this, paramBitmap));
  }
  
  public List<bahx>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630983);
    localbahx.jdField_b_of_type_Int = 2130838732;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 1;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630996);
    localbahx.jdField_b_of_type_Int = 2130838733;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 2;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131631003);
    localbahx.jdField_b_of_type_Int = 2130838736;
    localbahx.c = 3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630986);
    localbahx.jdField_b_of_type_Int = 2130838730;
    localbahx.c = 4;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131628025);
    localbahx.jdField_b_of_type_Int = 2130839599;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 0;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    return new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbsh != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_Bbsh);
      this.jdField_a_of_type_Bbsh = null;
    }
    if (this.jdField_a_of_type_Baie != null) {
      this.jdField_a_of_type_Baie.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aclt
 * JD-Core Version:    0.7.0.1
 */