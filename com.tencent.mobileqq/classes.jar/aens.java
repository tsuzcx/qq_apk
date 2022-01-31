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
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class aens
{
  private static String jdField_a_of_type_JavaLangString;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new aent(this);
  private bdit jdField_a_of_type_Bdit;
  private bepp jdField_a_of_type_Bepp;
  private bevy jdField_a_of_type_Bevy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private List<ShareActionSheetBuilder.ActionSheetItem>[] jdField_a_of_type_ArrayOfJavaUtilList;
  private Bitmap b;
  private Bitmap c;
  private Bitmap d;
  
  public aens(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, IntimateInfo paramIntimateInfo, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.c = paramBitmap1;
    this.d = paramBitmap2;
    this.b = paramBitmap3;
    if ((this.c == null) || (this.c.isRecycled())) {
      this.c = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130845879);
    }
    if ((this.d == null) || (this.d.isRecycled())) {
      this.d = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130845879);
    }
    jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693764) + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693765) + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693766);
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
    if (this.jdField_a_of_type_Bevy == null)
    {
      this.jdField_a_of_type_Bevy = new aenu(this);
      WXShareHelper.a().a(this.jdField_a_of_type_Bevy);
    }
    String str = a(paramBitmap);
    e();
    if (TextUtils.isEmpty(str)) {
      a(1, 2131693750);
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
      a(1, 2131693750);
      return;
    }
    bizt localbizt = bizt.a();
    localbizt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    bizm.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localbizt, paramBitmap, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693768), "", 20001);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Bdit = new bdit(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ArrayOfJavaUtilList = a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Bdit.setActionSheetItems(this.jdField_a_of_type_ArrayOfJavaUtilList);
    this.jdField_a_of_type_Bdit.setItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
  }
  
  private void c(Bitmap paramBitmap)
  {
    try
    {
      Object localObject = a(paramBitmap);
      e();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(1, 2131693750);
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
      arum.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Intent)localObject, 21);
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      a(1, 2131693755);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bepp == null)
    {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bepp.c(true);
    }
    this.jdField_a_of_type_Bepp.c(2131694217);
    if ((this.jdField_a_of_type_Bepp != null) && (!this.jdField_a_of_type_Bepp.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_Bepp.show();
    }
  }
  
  private void d(Bitmap paramBitmap)
  {
    paramBitmap = a(paramBitmap);
    e();
    if (TextUtils.isEmpty(paramBitmap)) {
      a(1, 2131693750);
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
        a(0, 2131693760);
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bepp.dismiss();
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
      localObject2 = new gw().a((String)localObject1, 100, 100, (Map)localObject2);
      k = ((gs)localObject2).a();
      m = ((gs)localObject2).b();
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
      if (((gs)localObject2).a(j, i)) {
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
    localCanvas.drawBitmap(a(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840256), 194, 40), 512.0F, 1185.0F, null);
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
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693756);
      j = Color.parseColor("#03081A");
      i = Color.parseColor("#878B99");
      localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840252);
      localTextPaint = new TextPaint(1);
      localTextPaint.setColor(j);
      localTextPaint.setTextSize(80.0F);
      localTextPaint.setTextAlign(Paint.Align.LEFT);
      a(localCanvas, localTextPaint, 146.0F, 364.0F, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays));
      float f = Layout.getDesiredWidth(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays), localTextPaint);
      localTextPaint.setTextSize(34.0F);
      a(localCanvas, localTextPaint, 8.0F + (f + 146.0F), 410.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693703, new Object[] { "" }));
      a(localCanvas, localTextPaint, 152.0F, 468.0F, (String)localObject);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Resources)localObject).getString(2131693751));
      localStringBuilder.append("\r\n");
      localStringBuilder.append(((Resources)localObject).getString(2131693752));
      localStringBuilder.append("\r\n");
      j = 2;
      if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
      {
        localStringBuilder.append(((Resources)localObject).getString(2131693727));
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList.size());
        localStringBuilder.append(((Resources)localObject).getString(2131693714));
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
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693759);
          j = Color.parseColor("#FF6FA3");
          i = Color.parseColor("#FF8AB5");
          localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840255);
          break;
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693757);
          j = Color.parseColor("#FF8A2D");
          i = Color.parseColor("#FF9F40");
          localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840253);
          break;
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693758);
          j = Color.parseColor("#2493FF");
          i = Color.parseColor("#4DA7FF");
          localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), 2130840254);
          break;
          j = 3;
          break label493;
        }
      }
      localStringBuilder.append(((Resources)localObject).getString(2131693753));
      localStringBuilder.append("\r\n");
      localStringBuilder.append(((Resources)localObject).getString(2131693754));
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
    //   7: ldc_w 659
    //   10: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 665	java/lang/System:currentTimeMillis	()J
    //   16: invokevirtual 668	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 35	aens:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   26: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 673
    //   32: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 4
    //   40: new 355	java/io/File
    //   43: dup
    //   44: new 355	java/io/File
    //   47: dup
    //   48: getstatic 678	aljq:aX	Ljava/lang/String;
    //   51: ldc_w 680
    //   54: invokespecial 682	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: invokevirtual 685	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: invokestatic 690	bduw:a	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokespecial 356	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 693	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: aload_3
    //   73: astore_2
    //   74: aload_3
    //   75: ifnonnull +11 -> 86
    //   78: aload_0
    //   79: getfield 33	aens:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   82: invokevirtual 697	android/support/v4/app/FragmentActivity:getCacheDir	()Ljava/io/File;
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +143 -> 230
    //   90: aload_2
    //   91: invokevirtual 700	java/io/File:canWrite	()Z
    //   94: ifeq +136 -> 230
    //   97: new 355	java/io/File
    //   100: dup
    //   101: aload_2
    //   102: invokevirtual 685	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   105: aload 4
    //   107: invokespecial 682	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: astore_2
    //   111: aload_2
    //   112: invokevirtual 685	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   115: astore 4
    //   117: aload_2
    //   118: invokevirtual 703	java/io/File:exists	()Z
    //   121: ifeq +8 -> 129
    //   124: aload_2
    //   125: invokevirtual 706	java/io/File:delete	()Z
    //   128: pop
    //   129: new 708	java/io/BufferedOutputStream
    //   132: dup
    //   133: new 710	java/io/FileOutputStream
    //   136: dup
    //   137: aload_2
    //   138: invokespecial 713	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   141: invokespecial 716	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   144: astore_3
    //   145: aload_3
    //   146: astore_2
    //   147: aload_1
    //   148: getstatic 722	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   151: bipush 100
    //   153: aload_3
    //   154: invokevirtual 726	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   157: pop
    //   158: aload_3
    //   159: astore_2
    //   160: aload_3
    //   161: invokevirtual 729	java/io/BufferedOutputStream:flush	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 732	java/io/BufferedOutputStream:close	()V
    //   172: aload 4
    //   174: areturn
    //   175: astore_1
    //   176: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq -7 -> 172
    //   182: ldc_w 324
    //   185: iconst_2
    //   186: aload_1
    //   187: invokevirtual 735	java/io/IOException:getMessage	()Ljava/lang/String;
    //   190: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 4
    //   195: areturn
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: astore_2
    //   202: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +17 -> 222
    //   208: aload_1
    //   209: astore_2
    //   210: ldc_w 324
    //   213: iconst_2
    //   214: aload 4
    //   216: invokevirtual 736	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 732	java/io/BufferedOutputStream:close	()V
    //   230: aconst_null
    //   231: areturn
    //   232: astore_1
    //   233: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -6 -> 230
    //   239: ldc_w 324
    //   242: iconst_2
    //   243: aload_1
    //   244: invokevirtual 735	java/io/IOException:getMessage	()Ljava/lang/String;
    //   247: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: goto -20 -> 230
    //   253: astore_1
    //   254: aconst_null
    //   255: astore_2
    //   256: aload_2
    //   257: ifnull +7 -> 264
    //   260: aload_2
    //   261: invokevirtual 732	java/io/BufferedOutputStream:close	()V
    //   264: aload_1
    //   265: athrow
    //   266: astore_2
    //   267: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -6 -> 264
    //   273: ldc_w 324
    //   276: iconst_2
    //   277: aload_2
    //   278: invokevirtual 735	java/io/IOException:getMessage	()Ljava/lang/String;
    //   281: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: goto -20 -> 264
    //   287: astore_1
    //   288: goto -32 -> 256
    //   291: astore 4
    //   293: aload_3
    //   294: astore_1
    //   295: goto -95 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	aens
    //   0	298	1	paramBitmap	Bitmap
    //   73	188	2	localObject1	Object
    //   266	12	2	localIOException	java.io.IOException
    //   66	228	3	localObject2	Object
    //   38	156	4	str	String
    //   196	19	4	localException1	Exception
    //   291	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   168	172	175	java/io/IOException
    //   129	145	196	java/lang/Exception
    //   226	230	232	java/io/IOException
    //   129	145	253	finally
    //   260	264	266	java/io/IOException
    //   147	158	287	finally
    //   160	164	287	finally
    //   202	208	287	finally
    //   210	222	287	finally
    //   147	158	291	java/lang/Exception
    //   160	164	291	java/lang/Exception
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdit == null) {
      c();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.1(this));
      return;
    }
    this.jdField_a_of_type_Bdit.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Bdit.show();
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    if ((paramInt == 3) || (paramInt == 4))
    {
      if (WXShareHelper.a().a()) {
        break label70;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131693761), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    for (;;)
    {
      d();
      ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.3(this, paramBitmap, paramInt));
      return;
      label70:
      if (!WXShareHelper.a().b()) {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131693769), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.executeOnFileThread(new IntimateInfoShareHelper.5(this, paramBitmap));
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696871);
    localActionSheetItem.icon = 2130838916;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696884);
    localActionSheetItem.icon = 2130838917;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696891);
    localActionSheetItem.icon = 2130838920;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696874);
    localActionSheetItem.icon = 2130838914;
    localActionSheetItem.action = 4;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131693771);
    localActionSheetItem.icon = 2130839744;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bevy != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_Bevy);
      this.jdField_a_of_type_Bevy = null;
    }
    if (this.jdField_a_of_type_Bdit != null) {
      this.jdField_a_of_type_Bdit.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aens
 * JD-Core Version:    0.7.0.1
 */