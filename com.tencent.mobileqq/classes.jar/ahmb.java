import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.8;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

public abstract class ahmb
  extends BaseBubbleBuilder
{
  public static String a;
  public static List<MessageForTroopGift> a;
  private static int c = 101;
  private static int d = 102;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  Handler b;
  public Map<String, ArrayList<Runnable>> b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new LinkedList();
    jdField_a_of_type_JavaLangString = "TroopGiftMsgItemBuilder";
  }
  
  public ahmb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new ahmc(this);
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  @NotNull
  private Bitmap a(Bitmap paramBitmap, BubbleImageView paramBubbleImageView, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics();
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).postScale(1.0F, 1.0F);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramBitmap = Bitmap.createBitmap(paramBitmap, (int)(i * 0.357D), (int)(j * 0.357D), (int)((i - 1) * 0.642D), (int)((j - 1) * 0.642D), (Matrix)localObject2, true);
    i = paramBubbleImageView.getLayoutParams().width;
    j = (int)(150.0F * ((DisplayMetrics)localObject1).density);
    paramBubbleImageView = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
    localObject2 = new Canvas(paramBubbleImageView);
    localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    ((Canvas)localObject2).drawRect(0.0F, 0.0F, i, j, (Paint)localObject1);
    if (paramInt != 0)
    {
      localObject2 = new Canvas(paramBubbleImageView);
      ((Canvas)localObject2).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, i, j), (Paint)localObject1);
      ((Paint)localObject1).setColor(paramInt);
      ((Canvas)localObject2).drawRect(0.0F, 0.0F, paramBubbleImageView.getWidth(), paramBubbleImageView.getHeight(), (Paint)localObject1);
      bgsn.a(paramBubbleImageView, 60);
    }
    return paramBubbleImageView;
  }
  
  @NotNull
  private MessageForTroopGift a(MessageForTroopGift paramMessageForTroopGift, ahmi paramahmi)
  {
    boolean bool = njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (paramMessageForTroopGift.senderUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
    {
      if (paramMessageForTroopGift.receiverUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label306;
      }
      paramahmi.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      paramahmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramahmi.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    for (;;)
    {
      if ((paramMessageForTroopGift.btFlag == 0) || (bool))
      {
        paramahmi.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        paramahmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (paramMessageForTroopGift.btFlag == 1) {
        paramahmi.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (paramMessageForTroopGift.btFlag == 2) {
        paramahmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (((paramMessageForTroopGift.receiverUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) || (paramMessageForTroopGift.senderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) || ((paramMessageForTroopGift.receiverUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) && (paramMessageForTroopGift.btFlag == 0))) && (paramMessageForTroopGift.is_activity_gift == 1) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_text)) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_text_color)) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_url)))
      {
        paramahmi.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        paramahmi.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        paramahmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        paramahmi.jdField_b_of_type_AndroidWidgetButton.setText(paramMessageForTroopGift.activity_text);
        paramahmi.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor(paramMessageForTroopGift.activity_text_color));
      }
      return paramMessageForTroopGift;
      paramahmi.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      paramahmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      paramahmi.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      continue;
      label306:
      paramahmi.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      paramahmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      paramahmi.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  private void a(ahmi paramahmi)
  {
    if (((paramahmi.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 8) && (paramahmi.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) && (paramahmi.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8)) || (this.jdField_b_of_type_Boolean)) {}
    for (paramahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().height = ((int)(100.0F * this.jdField_a_of_type_Float));; paramahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().height = ((int)(142.0F * this.jdField_a_of_type_Float)))
    {
      if (this.jdField_b_of_type_Boolean)
      {
        paramahmi.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        paramahmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        paramahmi.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      return;
    }
  }
  
  private void a(ahmi paramahmi, MessageForTroopGift paramMessageForTroopGift)
  {
    if ((AppSetting.c) && (!TextUtils.isEmpty(paramMessageForTroopGift.title)))
    {
      String str = paramMessageForTroopGift.title;
      paramMessageForTroopGift = str;
      if (paramahmi.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramMessageForTroopGift = str;
        if (!TextUtils.isEmpty(paramahmi.jdField_b_of_type_AndroidWidgetTextView.getText())) {
          paramMessageForTroopGift = str + paramahmi.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
        }
      }
      paramahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramMessageForTroopGift);
    }
  }
  
  private void a(ahmi paramahmi, MessageForTroopGift paramMessageForTroopGift, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 2)) {
      paramURLDrawable.restartDownload();
    }
    label140:
    label141:
    for (;;)
    {
      return;
      if (paramURLDrawable != null)
      {
        int i;
        if ((paramURLDrawable.getCurrDrawable() instanceof RegionDrawable))
        {
          i = paramMessageForTroopGift.objColor;
          if (i != 0) {
            break label140;
          }
          i = -2138570752;
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramMessageForTroopGift.interactId)) {
            break label141;
          }
          a(((RegionDrawable)paramURLDrawable.getCurrDrawable()).getBitmap(), i, paramahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramMessageForTroopGift.giftPicId + "");
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("TroopGiftMsgItemBuilder", 2, "drawable.getCurrDrawable() instanceof  RegionDrawable = " + (paramURLDrawable.getCurrDrawable() instanceof RegionDrawable));
          return;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty()) {
      ThreadManager.post(new TroopGiftMsgItemBuilder.8(paramQQAppInterface.a().createEntityManager()), 5, null, true);
    }
  }
  
  private void a(MessageForTroopGift paramMessageForTroopGift)
  {
    int i;
    if (!paramMessageForTroopGift.isReported)
    {
      paramMessageForTroopGift.isReported = true;
      jdField_a_of_type_JavaUtilList.add(paramMessageForTroopGift);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramMessageForTroopGift.senderuin)) {
        break label85;
      }
      i = 0;
    }
    for (;;)
    {
      if (paramMessageForTroopGift.istroop == 0) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "exp_obj", 0, 0, "", "", "", "");
      }
      label85:
      do
      {
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(Long.valueOf(paramMessageForTroopGift.receiverUin))) {
          break label489;
        }
        i = 1;
        break;
        if (paramMessageForTroopGift.istroop == 3000)
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "exp_obj", 0, 0, "", "", "", "");
          return;
        }
        if ((paramMessageForTroopGift.istroop == 1000) || (paramMessageForTroopGift.istroop == 1004))
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "exp_obj", 0, 0, "", "", "", "");
          return;
        }
        if (!paramMessageForTroopGift.isFromNearby) {
          break label313;
        }
        anqt.a("gift_aio", "exp_obj", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", "", "");
      } while (!bftg.a(paramMessageForTroopGift));
      anqt.a("gift_aio", "exp_play", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", "", "");
      return;
      label313:
      if (njo.a(paramMessageForTroopGift)) {}
      for (int j = 2;; j = 1)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_obj", j, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", paramMessageForTroopGift.giftPicId + "", "");
        if (!bftg.a(paramMessageForTroopGift)) {
          break;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_play", j, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", paramMessageForTroopGift.giftPicId + "", "");
        return;
      }
      label489:
      i = 2;
    }
  }
  
  private void a(BubbleImageView paramBubbleImageView, int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(paramInt);
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(paramInt);
    paramBubbleImageView.setImageDrawable(URLDrawable.getDrawable(new File(a(paramString, paramInt)), localURLDrawableOptions));
  }
  
  private void a(BubbleImageView paramBubbleImageView, String paramString, int paramInt)
  {
    if (paramBubbleImageView.getTag(2131373737).equals(paramString)) {
      a(paramBubbleImageView, paramInt, paramString);
    }
  }
  
  private void a(String paramString1, int paramInt, Bitmap paramBitmap, BubbleImageView paramBubbleImageView, String paramString2, SharedPreferences paramSharedPreferences, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("arendgx_createGiftBg", 2, "path:" + a(paramString1, paramInt));
      }
      if (a(a(paramBitmap, paramBubbleImageView, paramInt), paramString1, paramInt, paramString2))
      {
        paramSharedPreferences.edit().putLong(paramString2, paramLong);
        paramSharedPreferences.edit().commit();
      }
      jdField_a_of_type_AndroidOsHandler.post(new TroopGiftMsgItemBuilder.4(this, paramString2, paramBubbleImageView, paramString1, paramInt));
      return;
    }
    catch (Exception paramString1)
    {
      paramSharedPreferences.edit().putLong(paramString2, 0L);
      paramSharedPreferences.edit().commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, paramString1.getMessage());
      }
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      paramSharedPreferences.edit().putLong(paramString2, 0L);
      paramSharedPreferences.edit().commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, paramString1.getMessage());
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString2, Boolean.valueOf(false));
    }
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 473	java/io/File
    //   3: dup
    //   4: new 295	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 566	anhk:ba	Ljava/lang/String;
    //   14: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 568
    //   20: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 573	bhgg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokespecial 479	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 576	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: new 473	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: aload_2
    //   42: iload_3
    //   43: invokevirtual 476	ahmb:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   46: invokespecial 479	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 9
    //   51: aload 9
    //   53: invokevirtual 579	java/io/File:exists	()Z
    //   56: ifne +9 -> 65
    //   59: aload 9
    //   61: invokevirtual 582	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aconst_null
    //   66: astore 7
    //   68: aconst_null
    //   69: astore 8
    //   71: new 584	java/io/BufferedOutputStream
    //   74: dup
    //   75: new 586	java/io/FileOutputStream
    //   78: dup
    //   79: aload 9
    //   81: invokespecial 589	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   84: sipush 8192
    //   87: invokespecial 592	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   90: astore_2
    //   91: aload_2
    //   92: astore 7
    //   94: aload_1
    //   95: getstatic 598	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   98: bipush 100
    //   100: aload_2
    //   101: invokevirtual 602	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   104: istore 6
    //   106: aload_0
    //   107: getfield 59	ahmb:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   110: aload 4
    //   112: iconst_0
    //   113: invokestatic 545	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: invokeinterface 551 3 0
    //   121: pop
    //   122: iload 6
    //   124: istore 5
    //   126: aload_2
    //   127: ifnull +11 -> 138
    //   130: aload_2
    //   131: invokevirtual 605	java/io/BufferedOutputStream:close	()V
    //   134: iload 6
    //   136: istore 5
    //   138: iload 5
    //   140: ifne +56 -> 196
    //   143: aload 9
    //   145: invokevirtual 579	java/io/File:exists	()Z
    //   148: ifeq +48 -> 196
    //   151: aload 9
    //   153: invokevirtual 608	java/io/File:delete	()Z
    //   156: pop
    //   157: aload_0
    //   158: getfield 611	ahmb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   161: getstatic 31	ahmb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   164: iconst_0
    //   165: invokevirtual 617	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   168: astore_1
    //   169: aload_1
    //   170: invokeinterface 519 1 0
    //   175: aload 4
    //   177: lconst_0
    //   178: invokeinterface 525 4 0
    //   183: pop
    //   184: aload_1
    //   185: invokeinterface 519 1 0
    //   190: invokeinterface 528 1 0
    //   195: pop
    //   196: iload 5
    //   198: ireturn
    //   199: astore_2
    //   200: aload_2
    //   201: invokevirtual 620	java/io/IOException:printStackTrace	()V
    //   204: goto -139 -> 65
    //   207: astore_1
    //   208: iload 6
    //   210: istore 5
    //   212: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq -77 -> 138
    //   218: ldc_w 553
    //   221: iconst_2
    //   222: aload_1
    //   223: invokevirtual 621	java/io/IOException:getMessage	()Ljava/lang/String;
    //   226: invokestatic 558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iload 6
    //   231: istore 5
    //   233: goto -95 -> 138
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_2
    //   240: astore 7
    //   242: aload_0
    //   243: getfield 611	ahmb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   246: getstatic 31	ahmb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   249: iconst_0
    //   250: invokevirtual 617	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   253: astore 8
    //   255: aload_2
    //   256: astore 7
    //   258: aload 8
    //   260: invokeinterface 519 1 0
    //   265: aload 4
    //   267: lconst_0
    //   268: invokeinterface 525 4 0
    //   273: pop
    //   274: aload_2
    //   275: astore 7
    //   277: aload 8
    //   279: invokeinterface 519 1 0
    //   284: invokeinterface 528 1 0
    //   289: pop
    //   290: aload_2
    //   291: astore 7
    //   293: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +17 -> 313
    //   299: aload_2
    //   300: astore 7
    //   302: ldc_w 553
    //   305: iconst_2
    //   306: aload_1
    //   307: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   310: invokestatic 558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: getfield 59	ahmb:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   317: aload 4
    //   319: iconst_0
    //   320: invokestatic 545	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   323: invokeinterface 551 3 0
    //   328: pop
    //   329: aload_2
    //   330: ifnull +237 -> 567
    //   333: aload_2
    //   334: invokevirtual 605	java/io/BufferedOutputStream:close	()V
    //   337: iconst_0
    //   338: istore 5
    //   340: goto -202 -> 138
    //   343: astore_1
    //   344: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +14 -> 361
    //   350: ldc_w 553
    //   353: iconst_2
    //   354: aload_1
    //   355: invokevirtual 621	java/io/IOException:getMessage	()Ljava/lang/String;
    //   358: invokestatic 558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: iconst_0
    //   362: istore 5
    //   364: goto -226 -> 138
    //   367: astore_2
    //   368: aload 8
    //   370: astore_1
    //   371: aload_1
    //   372: astore 7
    //   374: aload_0
    //   375: getfield 611	ahmb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   378: getstatic 31	ahmb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   381: iconst_0
    //   382: invokevirtual 617	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   385: astore 8
    //   387: aload_1
    //   388: astore 7
    //   390: aload 8
    //   392: invokeinterface 519 1 0
    //   397: aload 4
    //   399: lconst_0
    //   400: invokeinterface 525 4 0
    //   405: pop
    //   406: aload_1
    //   407: astore 7
    //   409: aload 8
    //   411: invokeinterface 519 1 0
    //   416: invokeinterface 528 1 0
    //   421: pop
    //   422: aload_1
    //   423: astore 7
    //   425: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +17 -> 445
    //   431: aload_1
    //   432: astore 7
    //   434: ldc_w 553
    //   437: iconst_2
    //   438: aload_2
    //   439: invokevirtual 559	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   442: invokestatic 558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_0
    //   446: getfield 59	ahmb:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   449: aload 4
    //   451: iconst_0
    //   452: invokestatic 545	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   455: invokeinterface 551 3 0
    //   460: pop
    //   461: aload_1
    //   462: ifnull +105 -> 567
    //   465: aload_1
    //   466: invokevirtual 605	java/io/BufferedOutputStream:close	()V
    //   469: iconst_0
    //   470: istore 5
    //   472: goto -334 -> 138
    //   475: astore_1
    //   476: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +14 -> 493
    //   482: ldc_w 553
    //   485: iconst_2
    //   486: aload_1
    //   487: invokevirtual 621	java/io/IOException:getMessage	()Ljava/lang/String;
    //   490: invokestatic 558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: iconst_0
    //   494: istore 5
    //   496: goto -358 -> 138
    //   499: astore_1
    //   500: aload_0
    //   501: getfield 59	ahmb:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   504: aload 4
    //   506: iconst_0
    //   507: invokestatic 545	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   510: invokeinterface 551 3 0
    //   515: pop
    //   516: aload 7
    //   518: ifnull +8 -> 526
    //   521: aload 7
    //   523: invokevirtual 605	java/io/BufferedOutputStream:close	()V
    //   526: aload_1
    //   527: athrow
    //   528: astore_2
    //   529: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq -6 -> 526
    //   535: ldc_w 553
    //   538: iconst_2
    //   539: aload_2
    //   540: invokevirtual 621	java/io/IOException:getMessage	()Ljava/lang/String;
    //   543: invokestatic 558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: goto -20 -> 526
    //   549: astore_1
    //   550: goto -50 -> 500
    //   553: astore 7
    //   555: aload_2
    //   556: astore_1
    //   557: aload 7
    //   559: astore_2
    //   560: goto -189 -> 371
    //   563: astore_1
    //   564: goto -325 -> 239
    //   567: iconst_0
    //   568: istore 5
    //   570: goto -432 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	ahmb
    //   0	573	1	paramBitmap	Bitmap
    //   0	573	2	paramString1	String
    //   0	573	3	paramInt	int
    //   0	573	4	paramString2	String
    //   124	445	5	bool1	boolean
    //   104	126	6	bool2	boolean
    //   66	456	7	localObject	Object
    //   553	5	7	localOutOfMemoryError	OutOfMemoryError
    //   69	341	8	localSharedPreferences	SharedPreferences
    //   49	103	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   59	65	199	java/io/IOException
    //   130	134	207	java/io/IOException
    //   71	91	236	java/lang/Exception
    //   333	337	343	java/io/IOException
    //   71	91	367	java/lang/OutOfMemoryError
    //   465	469	475	java/io/IOException
    //   71	91	499	finally
    //   374	387	499	finally
    //   390	406	499	finally
    //   409	422	499	finally
    //   425	431	499	finally
    //   434	445	499	finally
    //   521	526	528	java/io/IOException
    //   94	106	549	finally
    //   242	255	549	finally
    //   258	274	549	finally
    //   277	290	549	finally
    //   293	299	549	finally
    //   302	313	549	finally
    //   94	106	553	java/lang/OutOfMemoryError
    //   94	106	563	java/lang/Exception
  }
  
  private void b(ahmi paramahmi, MessageForTroopGift paramMessageForTroopGift)
  {
    if (paramahmi.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_tks").a(0).a(new String[] { paramMessageForTroopGift.frienduin + "", "" }).a();
      new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_return").a(0).a(new String[] { paramMessageForTroopGift.frienduin + "", "" }).a();
    }
    if (paramahmi.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_ask").a(0).a(new String[] { paramMessageForTroopGift.frienduin + "", "" }).a();
    }
  }
  
  private void c(ahmi paramahmi, MessageForTroopGift paramMessageForTroopGift)
  {
    if (TextUtils.isEmpty(paramMessageForTroopGift.charmHeroism)) {}
    String[] arrayOfString1;
    String[] arrayOfString2;
    do
    {
      do
      {
        do
        {
          return;
          paramahmi.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          localObject = paramMessageForTroopGift.charmHeroism.replace("<", "").replace(">", "").split("\\$s");
        } while ((localObject == null) || (localObject.length != 2));
        arrayOfString1 = localObject[0].split("\\#");
      } while ((arrayOfString1 == null) || (arrayOfString1.length != 3));
      arrayOfString2 = localObject[1].split("\\#");
    } while ((arrayOfString2 == null) || (arrayOfString2.length != 3));
    Object localObject = "";
    if (paramMessageForTroopGift.senderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
    {
      if (paramMessageForTroopGift.sendScore >= 0) {
        localObject = "+";
      }
      localObject = anni.a(2131714084) + arrayOfString1[0] + (String)localObject + paramMessageForTroopGift.sendScore + "" + arrayOfString2[0];
      if (paramMessageForTroopGift.sendScore == 0) {
        localObject = "";
      }
    }
    for (;;)
    {
      paramahmi.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
      if (paramMessageForTroopGift.receiverUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
      {
        if (paramMessageForTroopGift.recvScore >= 0) {
          localObject = "+";
        }
        localObject = anni.a(2131714068) + arrayOfString1[1] + (String)localObject + paramMessageForTroopGift.recvScore + "" + arrayOfString2[1];
        if (paramMessageForTroopGift.recvScore == 0) {
          localObject = "";
        }
      }
      else
      {
        if (paramMessageForTroopGift.recvScore >= 0) {
          localObject = "+";
        }
        localObject = anni.a(2131714083) + arrayOfString1[2] + (String)localObject + paramMessageForTroopGift.recvScore + "" + arrayOfString2[2];
        if (paramMessageForTroopGift.recvScore == 0) {
          localObject = "";
        }
      }
    }
  }
  
  private void e()
  {
    Object localObject = anni.a(2131714100);
    String str = bgsg.i(this.jdField_a_of_type_AndroidContentContext, "thxWord");
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.length());
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aiay)) {
        ((aiay)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bz();
      }
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public abstract View a(BaseChatItemLayout paramBaseChatItemLayout);
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    ahmi localahmi = (ahmi)paramafwr;
    if (paramView == null)
    {
      paramView = a(paramBaseChatItemLayout);
      localahmi.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView);
      localahmi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379238));
      localahmi.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379237));
      localahmi.jdField_a_of_type_AndroidWidgetButton = ((Button)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379235));
      localahmi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367511));
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363382));
      localahmi.jdField_c_of_type_AndroidViewView = localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368835);
      localahmi.jdField_d_of_type_AndroidViewView = localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379236);
      localahmi.jdField_c_of_type_AndroidWidgetButton = ((Button)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367502));
      localahmi.jdField_d_of_type_AndroidWidgetButton = ((Button)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367501));
      localahmi.e = ((Button)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367497));
      localahmi.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367503));
      localahmi.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367498));
      localahmi.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367500));
      localahmi.jdField_b_of_type_AndroidWidgetButton = ((Button)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367499));
      int i = (int)(220.0F * this.jdField_a_of_type_Float);
      int j = (int)(i - 10.0F * this.jdField_a_of_type_Float);
      paramafwr = (RelativeLayout.LayoutParams)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367503).getLayoutParams();
      paramafwr.width = j;
      localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367503).setLayoutParams(paramafwr);
      paramafwr = (LinearLayout.LayoutParams)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367502).getLayoutParams();
      paramafwr.width = ((int)(j / 2 - 1.0F * this.jdField_a_of_type_Float));
      localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367502).setLayoutParams(paramafwr);
      paramafwr = (LinearLayout.LayoutParams)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367501).getLayoutParams();
      paramafwr.width = (j / 2);
      localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367501).setLayoutParams(paramafwr);
      paramafwr = (RelativeLayout.LayoutParams)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367498).getLayoutParams();
      paramafwr.width = j;
      localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367498).setLayoutParams(paramafwr);
      paramafwr = (LinearLayout.LayoutParams)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367497).getLayoutParams();
      paramafwr.width = j;
      localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367497).setLayoutParams(paramafwr);
      paramafwr = (RelativeLayout.LayoutParams)localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363382).getLayoutParams();
      paramafwr.width = i;
      localahmi.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363382).setLayoutParams(paramafwr);
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
    }
    for (;;)
    {
      localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = a(paramChatMessage);
      MessageForTroopGift localMessageForTroopGift = a((MessageForTroopGift)paramChatMessage, localahmi);
      b(localahmi, localMessageForTroopGift);
      a(localahmi);
      localahmi.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = localMessageForTroopGift;
      if (!localMessageForTroopGift.isInteract())
      {
        paramChatMessage = new bdnf(localMessageForTroopGift.title + localMessageForTroopGift.subtitle, 16).a();
        localahmi.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        localahmi.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localahmi.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        c(localahmi, localMessageForTroopGift);
        localahmi.jdField_a_of_type_AndroidWidgetButton.setText(localMessageForTroopGift.comefrom);
        localahmi.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localMessageForTroopGift.comefrom);
        localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(2131373737, localMessageForTroopGift.giftPicId + "");
        if (localMessageForTroopGift.isInteract()) {
          break label1219;
        }
        localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new ColorDrawable(localMessageForTroopGift.objColor));
        localahmi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      for (;;)
      {
        try
        {
          paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
          paramChatMessage.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850693);
          paramChatMessage.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850693);
          paramChatMessage = URLDrawable.getDrawable(localMessageForTroopGift.makeGiftIconUrl(), paramChatMessage);
        }
        catch (OutOfMemoryError paramBaseChatItemLayout)
        {
          paramafwr = null;
          paramChatMessage = paramafwr;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ChatItemBuilder", 2, paramBaseChatItemLayout.getMessage());
          paramChatMessage = paramafwr;
          continue;
        }
        catch (Exception paramBaseChatItemLayout)
        {
          label1219:
          paramafwr = null;
          paramChatMessage = paramafwr;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ChatItemBuilder", 2, paramBaseChatItemLayout.getMessage());
          paramChatMessage = paramafwr;
          continue;
          localahmi.jdField_d_of_type_AndroidViewView.setVisibility(8);
          paramChatMessage.b(localahmi);
          continue;
        }
        try
        {
          paramChatMessage.setDownloadListener(new ahmd(this, paramChatMessage, localMessageForTroopGift, localahmi));
          a(localahmi, localMessageForTroopGift, paramChatMessage);
          localahmi.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramChatMessage);
          paramChatMessage = new ahmg(this, localMessageForTroopGift, localahmi);
          localahmi.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
          localahmi.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
          localahmi.e.setOnClickListener(paramChatMessage);
          localahmi.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(paramChatMessage);
          localahmi.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
          localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(paramChatMessage);
          localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramafzq);
          localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(new ahme(this, paramafzq));
          localahmi.jdField_c_of_type_AndroidViewView.setOnClickListener(paramChatMessage);
          localahmi.jdField_c_of_type_AndroidViewView.setOnLongClickListener(paramafzq);
          localahmi.jdField_c_of_type_AndroidViewView.setOnTouchListener(new ahmf(this, paramafzq));
          paramChatMessage = (bfos)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
          if ((!localMessageForTroopGift.isLoading) || (!paramChatMessage.b(bftg.b(localMessageForTroopGift)))) {
            continue;
          }
          paramChatMessage.a(localahmi);
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + localMessageForTroopGift.uniseq);
          }
          localahmi.jdField_d_of_type_AndroidViewView.setVisibility(0);
          a(localMessageForTroopGift);
          a(localahmi, localMessageForTroopGift);
          return paramView;
        }
        catch (Exception paramBaseChatItemLayout)
        {
          paramafwr = paramChatMessage;
          continue;
        }
        catch (OutOfMemoryError paramBaseChatItemLayout)
        {
          paramafwr = paramChatMessage;
          continue;
        }
        localahmi.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.title);
        localahmi.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localahmi.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.subtitle);
        localahmi.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        break;
        localahmi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130850694);
        localahmi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopGift)paramChatMessage).title;
  }
  
  public String a(String paramString, int paramInt)
  {
    return bhgg.a(anhk.ba + ".gift/" + "troopGift_" + paramString + "_" + paramInt + ".png");
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(Bitmap paramBitmap, int paramInt, BubbleImageView paramBubbleImageView, String paramString)
  {
    if ((paramBitmap == null) || (paramBubbleImageView == null) || (paramString == null)) {
      return;
    }
    Object localObject = new File(a(paramString, paramInt));
    String str = "troopGift_" + paramString + "_" + paramInt + ".png";
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    long l1 = localSharedPreferences.getLong(str, 0L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if ((l1 != 0L) && (l2 - l1 < 259200000L)) {}
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_JavaUtilMap.get(str) != null) {}
      for (boolean bool = ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(str)).booleanValue();; bool = false)
      {
        if ((localObject != null) && (((File)localObject).exists()) && (i != 0))
        {
          a(paramBubbleImageView, paramInt, paramString);
          return;
        }
        if (bool)
        {
          localObject = (ArrayList)this.jdField_b_of_type_JavaUtilMap.get(str);
          paramBitmap = (Bitmap)localObject;
          if (localObject == null)
          {
            paramBitmap = new ArrayList();
            this.jdField_b_of_type_JavaUtilMap.put(str, paramBitmap);
          }
          paramBitmap.add(new TroopGiftMsgItemBuilder.2(this, paramBubbleImageView, paramString, paramInt));
          return;
        }
        this.jdField_a_of_type_JavaUtilMap.put(str, Boolean.valueOf(true));
        paramBubbleImageView.setImageDrawable(new ColorDrawable(paramInt));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.post(new TroopGiftMsgItemBuilder.3(this, paramString, paramInt, paramBitmap, paramBubbleImageView, str, localSharedPreferences, l2), 8, null, false);
        return;
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, BaseChatItemLayout.i);
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.isSend();
  }
  
  public bguj[] a(View paramView)
  {
    bguh localbguh = new bguh();
    paramView = afur.a(paramView);
    a(paramView, localbguh);
    adrm.a(localbguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbguh);
    super.e(localbguh, this.jdField_a_of_type_AndroidContentContext);
    return localbguh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmb
 * JD-Core Version:    0.7.0.1
 */