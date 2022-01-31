import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.1;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;

public class adeg
  extends BaseBubbleBuilder
{
  private aodf jdField_a_of_type_Aodf;
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  public float b;
  public Handler b;
  public int c;
  public int d;
  int e;
  int f;
  public boolean f;
  
  private URLDrawable a(FileManagerEntity paramFileManagerEntity, MessageForFile paramMessageForFile, Context paramContext, URL paramURL, aden paramaden)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilePicItemBuilder<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] picFile entity size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
    }
    int k = this.c;
    int m = this.d;
    paramMessageForFile = apdc.a(paramFileManagerEntity.imgWidth, paramFileManagerEntity.imgHeight, paramFileManagerEntity.strMiddleThumPath);
    int j = k;
    int i = m;
    if (paramMessageForFile.jdField_a_of_type_Int > 0)
    {
      j = k;
      i = m;
      if (paramMessageForFile.jdField_b_of_type_Int > 0)
      {
        j = paramMessageForFile.jdField_a_of_type_Int;
        i = paramMessageForFile.jdField_b_of_type_Int;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FilePicItemBuilder<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] show AIOFilePicItem use size(wh)[" + j + ":" + i + "]");
    }
    paramaden.e = j;
    paramaden.jdField_f_of_type_Int = i;
    if (paramURL != null)
    {
      paramMessageForFile = paramURL.toString();
      if ((BaseApplicationImpl.sImageCache != null) && (BaseApplicationImpl.sImageCache.get(paramMessageForFile) != null))
      {
        paramContext = axwd.a(paramURL, 0, 0, null, null, true, 0.0F);
        paramaden.jdField_a_of_type_Boolean = true;
        return paramContext;
      }
    }
    paramMessageForFile = null;
    if ((axwd.b() instanceof SkinnableBitmapDrawable))
    {
      paramMessageForFile = ((SkinnableBitmapDrawable)axwd.b()).getBitmap();
      label277:
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mRequestWidth = j;
      paramContext.mRequestHeight = i;
      paramContext.mLoadingDrawable = axwd.b();
      paramContext.mFailedDrawable = axwd.a();
      paramContext.mGifRoundCorner = 12.0F;
      if (paramMessageForFile != null) {
        paramContext.mLoadingDrawable = new amyk(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageForFile, j, i, -921103);
      }
      if (paramURL == null) {
        break label414;
      }
      paramMessageForFile = URLDrawable.getDrawable(paramURL, paramContext);
      paramMessageForFile.setAutoDownload(true);
      paramaden.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      paramContext = paramMessageForFile;
      if (paramFileManagerEntity.imgWidth > 0) {
        break;
      }
      paramContext = paramMessageForFile;
      if (paramFileManagerEntity.imgHeight > 0) {
        break;
      }
      apck.e(paramFileManagerEntity);
      return paramMessageForFile;
      if (!(axwd.b() instanceof BitmapDrawable)) {
        break label277;
      }
      paramMessageForFile = ((BitmapDrawable)axwd.b()).getBitmap();
      break label277;
      label414:
      paramContext.mPlayGifImage = false;
      if (apdh.b(paramFileManagerEntity.getFilePath())) {
        ThreadManager.executeOnSubThread(new FilePicItemBuilder.1(this, paramFileManagerEntity));
      }
      if (apdc.b(paramFileManagerEntity)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, 7);
      }
      for (;;)
      {
        paramMessageForFile = AsyncImageView.a(ajed.aT, j, i, null, false, false, true);
        if (paramMessageForFile != null) {
          break;
        }
        return null;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, 5);
      }
      paramMessageForFile = URLDrawable.getDrawable(paramMessageForFile, paramContext);
      paramMessageForFile.setProgressDrawable(new bblb(axwd.a(), 0, false));
      if (apdc.a(paramFileManagerEntity)) {
        paramMessageForFile.setAutoDownload(true);
      } else {
        paramMessageForFile.setAutoDownload(false);
      }
    }
  }
  
  @TargetApi(16)
  private void a(aden paramaden)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    float f1 = this.jdField_a_of_type_Float;
    Object localObject = new aczj(Color.parseColor("#D8DAE0"), 255, f1 * 14.0F);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground((Drawable)localObject);
    }
    for (;;)
    {
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(2131627731);
      ((TextView)localObject).setCompoundDrawablePadding(aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130848457, 0, 0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localFrameLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramaden.e, paramaden.jdField_f_of_type_Int);
      ((RelativeLayout)paramaden.jdField_a_of_type_AndroidViewView).addView(localFrameLayout, (ViewGroup.LayoutParams)localObject);
      paramaden.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
      return;
      localFrameLayout.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  private void a(aden paramaden, FileManagerEntity paramFileManagerEntity)
  {
    int j = 1;
    if (paramFileManagerEntity != null) {}
    int i;
    switch (paramFileManagerEntity.status)
    {
    default: 
      i = 0;
      j = 0;
      label65:
      if (j != 0) {
        if (paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          paramFileManagerEntity = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          paramFileManagerEntity.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
          paramFileManagerEntity.setSharpCornerCor(BubbleImageView.a);
          paramFileManagerEntity.setShowCorner(false);
          paramFileManagerEntity.setProgressBackgroudColor(2130706432);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131305912);
          localLayoutParams.addRule(8, 2131305912);
          localLayoutParams.addRule(5, 2131305912);
          localLayoutParams.addRule(7, 2131305912);
          ((RelativeLayout)paramaden.jdField_a_of_type_AndroidViewView).addView(paramFileManagerEntity, localLayoutParams);
          paramFileManagerEntity.setProgress(0);
          paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramFileManagerEntity;
          paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramaden.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaden.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          label233:
          paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        }
      }
      break;
    }
    for (;;)
    {
      if ((i != 0) && (paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null))
      {
        if (paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramaden.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaden.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
          break label447;
        }
        ((RelativeLayout)paramaden.jdField_a_of_type_AndroidViewView).removeView(paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
        paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      }
      return;
      i = 0;
      j = 0;
      break label65;
      i = 0;
      break label65;
      if (9 != paramFileManagerEntity.nOpType) {
        break;
      }
      i = 0;
      break label65;
      i = 1;
      j = 0;
      break label65;
      paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress((int)(paramFileManagerEntity.fProgress * 100.0F));
      break label233;
      if (paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
        if (!paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramaden.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaden.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
        {
          ((RelativeLayout)paramaden.jdField_a_of_type_AndroidViewView).removeView(paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        else
        {
          paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
        }
      }
    }
    label447:
    paramaden.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  /* Error */
  public static void a(Context paramContext, Rect paramRect, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, com.tencent.mobileqq.data.MessageForReplyText paramMessageForReplyText)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: new 416	android/os/Bundle
    //   6: dup
    //   7: invokespecial 417	android/os/Bundle:<init>	()V
    //   10: astore 10
    //   12: aload_0
    //   13: instanceof 419
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: instanceof 421
    //   23: ifeq +65 -> 88
    //   26: aload_0
    //   27: instanceof 423
    //   30: ifne +58 -> 88
    //   33: aload_0
    //   34: checkcast 425	android/support/v4/app/FragmentActivity
    //   37: invokevirtual 429	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   40: invokevirtual 434	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   43: invokevirtual 439	com/tencent/mobileqq/activity/BaseChatPie:f	()I
    //   46: istore 9
    //   48: aload 10
    //   50: ldc_w 441
    //   53: iload 9
    //   55: invokevirtual 445	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   58: iload 9
    //   60: iconst_1
    //   61: if_icmpne +27 -> 88
    //   64: aload_0
    //   65: ldc_w 447
    //   68: invokevirtual 451	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   71: checkcast 453	android/view/inputmethod/InputMethodManager
    //   74: astore 11
    //   76: aload 11
    //   78: ifnull +10 -> 88
    //   81: aload 11
    //   83: iconst_1
    //   84: iconst_0
    //   85: invokevirtual 456	android/view/inputmethod/InputMethodManager:toggleSoftInput	(II)V
    //   88: aload_1
    //   89: ifnull +12 -> 101
    //   92: aload 10
    //   94: ldc_w 458
    //   97: aload_1
    //   98: invokevirtual 462	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   101: aload 10
    //   103: ldc_w 464
    //   106: iload 4
    //   108: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   111: aload 10
    //   113: ldc_w 470
    //   116: iload 5
    //   118: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   121: aload 10
    //   123: getstatic 474	bfcq:b	Ljava/lang/String;
    //   126: iload 6
    //   128: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   131: aload_3
    //   132: getfield 477	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   135: iconst_1
    //   136: if_icmpne +36 -> 172
    //   139: aload 10
    //   141: ldc_w 479
    //   144: iconst_1
    //   145: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   148: aload 10
    //   150: ldc_w 481
    //   153: aload_3
    //   154: getfield 483	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   157: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload 10
    //   162: ldc_w 489
    //   165: aload_3
    //   166: getfield 490	com/tencent/mobileqq/activity/aio/SessionInfo:b	Ljava/lang/String;
    //   169: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_3
    //   173: getfield 477	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   176: iconst_1
    //   177: if_icmpeq +13 -> 190
    //   180: aload_3
    //   181: getfield 477	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   184: sipush 3000
    //   187: if_icmpne +259 -> 446
    //   190: aload 10
    //   192: ldc_w 492
    //   195: iconst_2
    //   196: invokevirtual 445	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   199: aload 7
    //   201: ifnull +257 -> 458
    //   204: aload 10
    //   206: ldc_w 494
    //   209: aload 7
    //   211: getfield 499	com/tencent/mobileqq/data/MessageForReplyText:isMultiMsg	Z
    //   214: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   217: aload 10
    //   219: ldc_w 501
    //   222: invokestatic 506	android/os/Process:myPid	()I
    //   225: invokevirtual 445	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   228: aload_2
    //   229: getfield 509	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   232: astore_1
    //   233: aload_2
    //   234: getfield 510	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   237: ifne +10 -> 247
    //   240: aload_2
    //   241: getfield 513	com/tencent/mobileqq/data/ChatMessage:isReplySource	Z
    //   244: ifeq +350 -> 594
    //   247: getstatic 519	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   250: aconst_null
    //   251: invokevirtual 523	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   254: astore 11
    //   256: aload_1
    //   257: astore 7
    //   259: aload 11
    //   261: instanceof 215
    //   264: ifeq +10 -> 274
    //   267: aload 11
    //   269: invokevirtual 528	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   272: astore 7
    //   274: aload 7
    //   276: astore_1
    //   277: getstatic 532	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   280: invokevirtual 536	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   283: invokevirtual 528	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   286: iconst_1
    //   287: invokestatic 541	atdp:a	(Ljava/lang/String;I)Z
    //   290: istore 4
    //   292: aload 10
    //   294: ldc_w 543
    //   297: iload 4
    //   299: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   302: iload 4
    //   304: ifeq +35 -> 339
    //   307: getstatic 532	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   310: invokevirtual 536	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   313: invokevirtual 528	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   316: invokestatic 546	atdp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   319: astore 7
    //   321: aload 7
    //   323: invokestatic 552	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   326: ifne +13 -> 339
    //   329: aload 10
    //   331: ldc_w 554
    //   334: aload 7
    //   336: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload 10
    //   341: ldc_w 556
    //   344: aload_3
    //   345: getfield 477	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   348: invokevirtual 445	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   351: aload 10
    //   353: ldc_w 558
    //   356: aload_2
    //   357: getfield 386	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   360: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: getstatic 532	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   366: aload_1
    //   367: invokevirtual 562	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   370: checkcast 215	com/tencent/mobileqq/app/QQAppInterface
    //   373: astore 7
    //   375: aload_2
    //   376: instanceof 564
    //   379: ifeq +155 -> 534
    //   382: aload_0
    //   383: instanceof 421
    //   386: ifeq +92 -> 478
    //   389: aload 10
    //   391: ldc_w 566
    //   394: iconst_1
    //   395: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   398: aload_0
    //   399: aload 10
    //   401: new 568	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService
    //   404: dup
    //   405: aload_1
    //   406: aload_2
    //   407: getfield 386	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   410: aload_2
    //   411: getfield 571	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   414: aload_2
    //   415: invokespecial 574	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:<init>	(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/data/ChatMessage;)V
    //   418: aload_2
    //   419: aload 7
    //   421: invokestatic 579	adwz:a	(Lcom/tencent/mobileqq/data/ChatMessage;Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   424: iconst_m1
    //   425: iload 8
    //   427: invokestatic 582	bfcq:a	(Landroid/content/Context;Landroid/os/Bundle;Ladye;Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;II)V
    //   430: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +12 -> 445
    //   436: ldc 25
    //   438: iconst_2
    //   439: ldc_w 584
    //   442: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: return
    //   446: aload 10
    //   448: ldc_w 492
    //   451: iconst_1
    //   452: invokevirtual 445	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   455: goto -256 -> 199
    //   458: aload 10
    //   460: ldc_w 494
    //   463: aload_2
    //   464: getfield 510	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   467: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   470: goto -253 -> 217
    //   473: astore 7
    //   475: goto -198 -> 277
    //   478: aload_0
    //   479: instanceof 586
    //   482: ifne +115 -> 597
    //   485: aload_0
    //   486: instanceof 588
    //   489: ifeq +6 -> 495
    //   492: goto +105 -> 597
    //   495: aload_0
    //   496: instanceof 590
    //   499: ifeq +22 -> 521
    //   502: aload_0
    //   503: checkcast 590	com/tencent/mobileqq/activity/PublicFragmentActivity
    //   506: invokevirtual 593	com/tencent/mobileqq/activity/PublicFragmentActivity:a	()Lcom/tencent/mobileqq/fragment/PublicBaseFragment;
    //   509: instanceof 595
    //   512: ifeq +76 -> 588
    //   515: iconst_2
    //   516: istore 8
    //   518: goto -129 -> 389
    //   521: aload_0
    //   522: instanceof 423
    //   525: ifeq +63 -> 588
    //   528: iconst_5
    //   529: istore 8
    //   531: goto -142 -> 389
    //   534: aload 10
    //   536: ldc_w 566
    //   539: iconst_1
    //   540: invokevirtual 468	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   543: aload_0
    //   544: aload 10
    //   546: new 568	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService
    //   549: dup
    //   550: aload_1
    //   551: aload_2
    //   552: getfield 386	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   555: aload_2
    //   556: getfield 571	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   559: aload_2
    //   560: invokespecial 574	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:<init>	(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/data/ChatMessage;)V
    //   563: aload_2
    //   564: aload 7
    //   566: invokestatic 579	adwz:a	(Lcom/tencent/mobileqq/data/ChatMessage;Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   569: iconst_m1
    //   570: aload_3
    //   571: getfield 596	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   574: invokestatic 582	bfcq:a	(Landroid/content/Context;Landroid/os/Bundle;Ladye;Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;II)V
    //   577: goto -147 -> 430
    //   580: astore_0
    //   581: aload_0
    //   582: invokevirtual 599	mqq/app/AccountNotMatchException:printStackTrace	()V
    //   585: goto -155 -> 430
    //   588: iconst_m1
    //   589: istore 8
    //   591: goto -202 -> 389
    //   594: goto -317 -> 277
    //   597: iconst_2
    //   598: istore 8
    //   600: goto -211 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	paramContext	Context
    //   0	603	1	paramRect	Rect
    //   0	603	2	paramChatMessage	ChatMessage
    //   0	603	3	paramSessionInfo	SessionInfo
    //   0	603	4	paramBoolean1	boolean
    //   0	603	5	paramBoolean2	boolean
    //   0	603	6	paramBoolean3	boolean
    //   0	603	7	paramMessageForReplyText	com.tencent.mobileqq.data.MessageForReplyText
    //   1	598	8	i	int
    //   46	16	9	j	int
    //   10	535	10	localBundle	Bundle
    //   74	194	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   247	256	473	java/lang/Exception
    //   259	274	473	java/lang/Exception
    //   363	389	580	mqq/app/AccountNotMatchException
    //   389	430	580	mqq/app/AccountNotMatchException
    //   478	492	580	mqq/app/AccountNotMatchException
    //   495	515	580	mqq/app/AccountNotMatchException
    //   521	528	580	mqq/app/AccountNotMatchException
    //   534	577	580	mqq/app/AccountNotMatchException
  }
  
  private void a(String paramString1, String paramString2, aden paramaden)
  {
    if (paramaden.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramaden.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramaden.jdField_a_of_type_AndroidViewView).removeView(paramaden.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131300633);
    localRelativeLayout.setBackgroundResource(2130838764);
    paramaden.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, aciy.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout)paramaden.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131305912);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131305912);
    int i = apdq.a(paramaden.e, paramaden.jdField_f_of_type_Int);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131298520);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131298523);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131298520);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = apdq.a(this.jdField_a_of_type_AndroidContentContext, i, paramaden.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
      switch (i)
      {
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramString1);
      ((TextView)localObject1).setText(paramString2);
      return;
      localLayoutParams.addRule(12);
      break;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject1).setGravity(5);
    }
  }
  
  private boolean a(aden paramaden, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    int i;
    if ((paramaden.jdField_a_of_type_Boolean) && ((paramFileManagerEntity.status == -1) || (paramFileManagerEntity.status == 1) || (paramFileManagerEntity.status == 0) || (paramFileManagerEntity.status == 3) || (paramFileManagerEntity.status == 13)))
    {
      i = 1;
      if (paramFileManagerEntity.status != 16) {
        break label84;
      }
    }
    label84:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {
      return false;
    }
    switch (paramFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    case 4: 
    case 9: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((paramFileManagerEntity.status != 0) || (paramFileManagerEntity.isSend() != true)) {
        break;
      }
      continue;
      if ((paramFileManagerEntity.isSend() != true) || (paramFileManagerEntity.bOnceSuccess)) {
        break;
      }
      continue;
      if (13 != paramFileManagerEntity.nOpType) {
        break;
      }
      continue;
      if (10 == paramFileManagerEntity.nOpType)
      {
        bool = false;
      }
      else
      {
        bool = false;
        continue;
        if (13 != paramFileManagerEntity.nOpType) {
          break;
        }
        continue;
        if (paramFileManagerEntity.isSend() != true) {
          break;
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acjt a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (aden.class.isInstance(paramView))) {
        return ((aden)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public acju a()
  {
    return new aden(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    paramViewGroup = (acju)aciy.a(paramView);
    this.jdField_a_of_type_Aodf.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    paramChatMessage = null;
    if (aden.class.isInstance(paramacju))
    {
      paramacju = (aden)paramacju;
      paramChatMessage = paramView;
      if (paramChatMessage != null) {
        break label352;
      }
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      int i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        paramView.e = true;
      }
      paramView.setId(2131305912);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setShowEdge(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(15);
      paramChatMessage.addView(paramView, localLayoutParams);
      paramChatMessage.setOnClickListener(this);
      super.a(paramChatMessage, paramacmv);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
    }
    label352:
    for (;;)
    {
      paramView = paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      this.e = BaseChatItemLayout.e;
      this.jdField_f_of_type_Int = ((int)(BaseChatItemLayout.e * this.jdField_b_of_type_Float));
      this.d = this.e;
      this.c = this.jdField_f_of_type_Int;
      paramView.setMinimumWidth(this.jdField_f_of_type_Int);
      paramView.setMinimumHeight(this.jdField_f_of_type_Int);
      paramView.setMaxWidth(this.e);
      paramView.setMaxHeight(this.e);
      paramView = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
      paramacju.jdField_a_of_type_AndroidViewView = paramChatMessage;
      a(paramBaseChatItemLayout, localMessageForFile, paramacju, paramView, false);
      return paramChatMessage;
      paramView = new aden(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramacju.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacju.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramacju.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Almt = paramacju.jdField_a_of_type_Almt;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramacju.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramacju.jdField_b_of_type_Int;
      paramView.c = paramacju.c;
      paramView.d = paramacju.d;
      paramView.jdField_a_of_type_JavaLangString = paramacju.jdField_a_of_type_JavaLangString;
      paramacju = paramView;
      break;
    }
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    paramackl = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    int j = 0;
    if ((paramChatMessage.isSendFromLocal()) && (paramackl.status == 2)) {
      parambakh.a(2131298310, this.jdField_a_of_type_AndroidContentContext.getString(2131625146), 2130838588);
    }
    for (;;)
    {
      super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
      return parambakh;
      int i = j;
      if (!apdc.a(paramackl))
      {
        a(paramChatMessage, parambakh);
        i = j;
        if (paramackl.getCloudType() != 0)
        {
          i = j;
          if (!a(paramackl))
          {
            if (!paramackl.sendCloudUnsuccessful()) {
              parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131626819), 2130838599);
            }
            i = 1;
          }
        }
      }
      if ((paramackl.status == 1) || (paramackl.status == -1) || ((paramackl.status == 3) && (paramackl.nOpType == 1))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
      }
      a(parambakh, paramChatMessage);
      if (i != 0) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626815), 2130838598);
      }
      if (!apdc.a(paramackl)) {
        b(paramChatMessage, parambakh);
      }
      if ((paramackl.getCloudType() != 1) || (paramackl.status != 2)) {
        super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  public MessageForFile a(View paramView)
  {
    paramView = (ackl)aciy.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg) {
      return (MessageForFile)apck.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    return (MessageForFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return ajjy.a(2131638775);
    }
    return ajjy.a(2131638774);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      return;
      long l1 = awao.a();
      long l2 = paramChatMessage.time;
      if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
      {
        apcb.a(ajjy.a(2131638773));
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
        return;
      }
      a(paramChatMessage);
      apci.a("0X8005E4B");
      continue;
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
      continue;
      super.d(paramChatMessage);
      continue;
      if (localFileManagerEntity.status == 16)
      {
        apcb.a(2131627218);
      }
      else
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
        if (apbf.a(localFileManagerEntity).a(false))
        {
          if (bbrm.a((Activity)paramContext, 5, new adej(this, localMessageForFile, paramContext))) {
            apbx.a(paramContext, 2131627035, 2131627038, new adek(this, localMessageForFile, paramContext));
          }
        }
        else
        {
          apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, paramContext);
          continue;
          if (localFileManagerEntity.status == 16)
          {
            apcb.a(2131627218);
          }
          else
          {
            paramContext = new apcj();
            paramContext.b = "file_forward";
            paramContext.jdField_a_of_type_Int = 9;
            paramContext.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
            paramContext.c = apdh.a(localFileManagerEntity.fileName);
            paramContext.d = apck.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
            apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramContext);
            paramContext = new Bundle();
            paramContext.putInt("forward_type", 0);
            paramContext.putBoolean("not_forward", true);
            paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
            paramContext.putParcelable("fileinfo", apir.a(localFileManagerEntity, paramChatMessage));
            paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            paramChatMessage = new Intent();
            paramChatMessage.putExtras(paramContext);
            paramChatMessage.putExtra("forward_text", ajjy.a(2131638777) + apck.d(localFileManagerEntity.fileName) + ajjy.a(2131638776) + apdh.a(localFileManagerEntity.fileSize) + "。");
            paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
            paramChatMessage.putExtra("forward _key_nojump", true);
            paramChatMessage.putExtra("isPic", true);
            paramChatMessage.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
            if (!badq.d(BaseApplication.getContext())) {
              bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131629008, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
            }
            for (;;)
            {
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
              if (!localMessageForFile.isMultiMsg) {
                break;
              }
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
              break;
              aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
            }
            if (localFileManagerEntity.status == 16)
            {
              apcb.a(2131627218);
            }
            else
            {
              apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, paramContext);
              continue;
              if (localFileManagerEntity.status == 16)
              {
                apcb.a(2131627218);
              }
              else
              {
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
                apci.a("0X8005080");
                if (!badq.d(paramContext))
                {
                  apcb.a(2131627028);
                  return;
                }
                apbf.a(localFileManagerEntity).a(false, paramContext, new adel(this, localFileManagerEntity));
                this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
                continue;
                apci.a("0X8005081");
                if (localFileManagerEntity.getCloudType() == 0)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
                }
                else
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
                  this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
                  continue;
                  apci.a("0X8005082");
                  if (!badq.d(paramContext))
                  {
                    apcb.a(2131627028);
                    return;
                  }
                  boolean bool = localFileManagerEntity.isSend();
                  apbf.a(localFileManagerEntity).a(bool, paramContext, new adem(this, localFileManagerEntity));
                  this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
                  continue;
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
                  b();
                  continue;
                  if (localFileManagerEntity.status == 16)
                  {
                    apcb.a(2131627218);
                  }
                  else
                  {
                    new bfhl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, paramChatMessage, false);
                    if (localMessageForFile.isMultiMsg) {
                      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    aden localaden = (aden)aciy.a(paramView);
    MessageForFile localMessageForFile = a(paramView);
    BaseChatItemLayout localBaseChatItemLayout = localaden.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    if (paramView.getCloudType() == 5)
    {
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getString(2131624443);
    this.jdField_a_of_type_AndroidContentContext.getString(2131624444);
    String str;
    switch (paramView.nOpType)
    {
    case 6: 
    case 7: 
    default: 
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131626845);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131626844); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131626842))
    {
      begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbegr.c(str);
      localbegr.d(this.jdField_a_of_type_AndroidContentContext.getString(2131625035));
      localbegr.a(paramView);
      localbegr.a(new adeh(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L), localMessageForFile, localbegr, localBaseChatItemLayout, localaden));
      localbegr.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131626843);
    }
    paramView = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131626843));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131625035));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131626842));
    paramView.a(new adei(this, localMessageForFile, paramView, localBaseChatItemLayout, localaden));
    paramView.show();
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, aden paramaden, FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    Object localObject = paramFileManagerEntity.fileName + paramFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      awqx.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    apck.c(paramFileManagerEntity);
    apck.b(paramFileManagerEntity);
    paramMessageForFile.fileName = paramFileManagerEntity.fileName;
    paramMessageForFile.fileSize = paramFileManagerEntity.fileSize;
    paramMessageForFile.status = paramFileManagerEntity.status;
    paramMessageForFile.urlAtServer = paramFileManagerEntity.strServerPath;
    paramMessageForFile.url = paramFileManagerEntity.getFilePath();
    paramMessageForFile.fileSizeString = apdh.a(paramFileManagerEntity.fileSize);
    if (paramaden.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      paramaden.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      ((RelativeLayout)paramaden.jdField_a_of_type_AndroidViewView).removeView(paramaden.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
    if ((paramFileManagerEntity.status == 16) && (!apck.e(paramFileManagerEntity)))
    {
      paramMessageForFile = apdc.a(paramFileManagerEntity);
      if ((paramMessageForFile.jdField_a_of_type_Int > 0) && (paramMessageForFile.jdField_b_of_type_Int > 0))
      {
        paramaden.e = paramMessageForFile.jdField_a_of_type_Int;
        paramaden.jdField_f_of_type_Int = paramMessageForFile.jdField_b_of_type_Int;
        paramaden.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
        paramaden.jdField_a_of_type_ComTencentImageURLDrawable = null;
        a(paramaden);
        if (!a(paramaden, paramFileManagerEntity)) {
          break label457;
        }
        a(paramFileManagerEntity.fileName, bace.a(paramFileManagerEntity.fileSize), paramaden);
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.setFailedIconVisable(b(paramFileManagerEntity), this);
      a(paramaden, paramFileManagerEntity);
      return;
      paramaden.e = this.c;
      paramaden.jdField_f_of_type_Int = this.d;
      break;
      localObject = paramFileManagerEntity.strLargeThumPath;
      if ((paramMessageForFile.isMultiMsg) && (TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(apck.a(paramMessageForFile)))) {}
      URL localURL;
      for (localObject = apck.a(paramMessageForFile);; localURL = apdc.b(paramFileManagerEntity)) {
        try
        {
          localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
          if ((paramaden.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramaden.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localObject))) {
            break;
          }
          paramMessageForFile = a(paramFileManagerEntity, paramMessageForFile, this.jdField_a_of_type_AndroidContentContext, (URL)localObject, paramaden);
          paramaden.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramMessageForFile);
          paramaden.jdField_a_of_type_ComTencentImageURLDrawable = paramMessageForFile;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localURL = null;
          }
        }
      }
      label457:
      if (paramaden.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout)paramaden.jdField_a_of_type_AndroidViewView).removeView(paramaden.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFileManagerEntity != null) {
      if (paramFileManagerEntity.nOpType != 24)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.nOpType != 25) {}
      }
      else if (paramFileManagerEntity.status != 2)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.status != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public bakj[] a(View paramView)
  {
    paramView = a(paramView);
    bakh localbakh = new bakh();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbakh, paramView, null);
    }
    for (;;)
    {
      return localbakh.a();
      label38:
      a(localbakh, paramView, null);
    }
  }
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    paramackl = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    int j = 0;
    if ((paramChatMessage.isSendFromLocal()) && (paramackl.status == 2)) {
      parambakh.a(2131298310, this.jdField_a_of_type_AndroidContentContext.getString(2131625146), 2130838588);
    }
    do
    {
      return parambakh;
      int i = j;
      if (!apdc.a(paramackl))
      {
        a(paramChatMessage, parambakh);
        i = j;
        if (paramackl.getCloudType() != 0)
        {
          i = j;
          if (!a(paramackl))
          {
            if (!paramackl.sendCloudUnsuccessful()) {
              parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131626819), 2130838599);
            }
            i = 1;
          }
        }
      }
      if (i != 0) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626815), 2130838598);
      }
    } while (apdc.a(paramackl));
    b(paramChatMessage, parambakh);
    return parambakh;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_f_of_type_Boolean) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_f_of_type_Boolean = true;
          new Handler().postDelayed(new FilePicItemBuilder.2(this), 1000L);
          aciy.n = true;
        } while (super.a());
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
        if (paramView.getId() != 2131298552) {
          break;
        }
        localObject = aciy.a(paramView);
        if (localObject == null)
        {
          QLog.w("FilePicItemBuilder<FileAssistant>", 1, "holder tag is null");
          return;
        }
        if (!aden.class.isInstance(localObject))
        {
          QLog.w("FilePicItemBuilder<FileAssistant>", 1, "holder tag class[" + localObject.getClass().getName() + "] is not Holder");
          return;
        }
        localObject = (aden)localObject;
        paramView = a(paramView);
      } while ((paramView.isMultiMsg) && (!apck.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext)));
      localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    } while ((localFileManagerEntity.status == 16) && (!apck.e(localFileManagerEntity)));
    Object localObject = xgx.a(((aden)localObject).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
    a(this.jdField_a_of_type_AndroidContentContext, (Rect)localObject, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, false, true, null);
    return;
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adeg
 * JD-Core Version:    0.7.0.1
 */