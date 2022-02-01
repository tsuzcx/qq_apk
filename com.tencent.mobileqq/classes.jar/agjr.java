import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agjr
  implements agin
{
  private int jdField_a_of_type_Int;
  private akqe jdField_a_of_type_Akqe;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView c;
  
  public agjr(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
    this.jdField_a_of_type_Akqe = ((akqe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = anvx.a(2131710623);
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return anvx.a(2131720096);
      }
    } while (paramInt != 2);
    return anvx.a(2131720098);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView != null)) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getFirstVisiblePosition();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramString1 = a(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    if (this.c != null)
    {
      this.c.setVisibility(0);
      if (paramInt != 0) {
        break label231;
      }
      this.c.setText(anvx.a(2131720101));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        ((arqk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(19)).a();
      }
      return;
      label231:
      if (paramInt == 1) {
        this.c.setText(anvx.a(2131720095));
      } else if (paramInt == 2) {
        this.c.setText(anvx.a(2131720097));
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.getFirstVisiblePosition();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString3);
    }
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidWidgetTextView);
      if (!paramBoolean) {
        break label205;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      ((arqk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(19)).a();
      return;
      label205:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 2);
    }
  }
  
  private Object[] a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (!nty.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
        for (arrayOfObject = this.jdField_a_of_type_Akqe.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString, paramInt); (arrayOfObject != null) && (((Integer)arrayOfObject[0]).intValue() == 1); arrayOfObject = this.jdField_a_of_type_Akqe.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt))
        {
          this.jdField_a_of_type_JavaLangString = "";
          this.jdField_b_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().sendEmptyMessage(12);
          if (!QLog.isColorLevel()) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString.charAt(0));
          localStringBuilder.append("|");
          localStringBuilder.append(paramString.length());
          QLog.d("PasswdRedBagManager", 2, "passwdredbags result[0]=" + arrayOfObject[0] + ",result[1]=" + arrayOfObject[1] + ",send str=" + localStringBuilder.toString());
          return arrayOfObject;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont search passwdredbags");
    return null;
    return arrayOfObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: bipush 8
    //   3: if_icmpne +430 -> 433
    //   6: aload_0
    //   7: getfield 66	agjr:jdField_a_of_type_Akqe	Lakqe;
    //   10: ifnull +48 -> 58
    //   13: aload_0
    //   14: getfield 66	agjr:jdField_a_of_type_Akqe	Lakqe;
    //   17: getfield 251	akqe:a	Z
    //   20: ifeq +38 -> 58
    //   23: aload_0
    //   24: getfield 51	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   27: getfield 254	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   30: iconst_1
    //   31: if_icmpeq +16 -> 47
    //   34: aload_0
    //   35: getfield 51	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   38: getfield 254	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   41: sipush 1004
    //   44: if_icmpne +14 -> 58
    //   47: aload_0
    //   48: getfield 66	agjr:jdField_a_of_type_Akqe	Lakqe;
    //   51: aload_0
    //   52: getfield 51	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   55: invokevirtual 257	akqe:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   63: getfield 261	com/tencent/mobileqq/activity/aio/core/BaseChatPie:mAIORootView	Landroid/view/ViewGroup;
    //   66: ldc_w 262
    //   69: invokevirtual 268	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   72: checkcast 110	android/widget/TextView
    //   75: putfield 108	agjr:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   78: aload_0
    //   79: new 110	android/widget/TextView
    //   82: dup
    //   83: aload_0
    //   84: getfield 40	agjr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   87: invokespecial 271	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   90: putfield 119	agjr:c	Landroid/widget/TextView;
    //   93: aload_0
    //   94: getfield 119	agjr:c	Landroid/widget/TextView;
    //   97: ldc_w 272
    //   100: invokevirtual 275	android/widget/TextView:setTextColor	(I)V
    //   103: aload_0
    //   104: getfield 119	agjr:c	Landroid/widget/TextView;
    //   107: iconst_1
    //   108: ldc_w 276
    //   111: invokevirtual 280	android/widget/TextView:setTextSize	(IF)V
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   119: getfield 261	com/tencent/mobileqq/activity/aio/core/BaseChatPie:mAIORootView	Landroid/view/ViewGroup;
    //   122: ldc_w 281
    //   125: invokevirtual 268	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   128: checkcast 110	android/widget/TextView
    //   131: putfield 116	agjr:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   134: aload_0
    //   135: getfield 108	agjr:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   138: invokevirtual 285	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   141: ldc_w 286
    //   144: invokestatic 78	anvx:a	(I)Ljava/lang/String;
    //   147: invokevirtual 292	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   150: fstore_2
    //   151: aload_0
    //   152: getfield 108	agjr:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   155: fload_2
    //   156: ldc_w 293
    //   159: fmul
    //   160: ldc_w 294
    //   163: fadd
    //   164: f2i
    //   165: invokevirtual 297	android/widget/TextView:setMaxWidth	(I)V
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   173: getfield 261	com/tencent/mobileqq/activity/aio/core/BaseChatPie:mAIORootView	Landroid/view/ViewGroup;
    //   176: ldc_w 298
    //   179: invokevirtual 268	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   182: putfield 100	agjr:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   185: aload_0
    //   186: aload_0
    //   187: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   190: getfield 261	com/tencent/mobileqq/activity/aio/core/BaseChatPie:mAIORootView	Landroid/view/ViewGroup;
    //   193: ldc_w 299
    //   196: invokevirtual 268	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   199: checkcast 125	android/widget/LinearLayout
    //   202: putfield 123	agjr:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   205: aload_0
    //   206: getfield 123	agjr:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   209: aload_0
    //   210: getfield 119	agjr:c	Landroid/widget/TextView;
    //   213: invokevirtual 301	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   216: aload_0
    //   217: getfield 119	agjr:c	Landroid/widget/TextView;
    //   220: invokevirtual 305	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   223: bipush 254
    //   225: putfield 310	android/view/ViewGroup$LayoutParams:width	I
    //   228: aload_0
    //   229: getfield 119	agjr:c	Landroid/widget/TextView;
    //   232: invokevirtual 305	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   235: bipush 254
    //   237: putfield 313	android/view/ViewGroup$LayoutParams:height	I
    //   240: aload_0
    //   241: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   244: instanceof 315
    //   247: ifeq +31 -> 278
    //   250: ldc_w 317
    //   253: aload_0
    //   254: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   257: getfield 49	com/tencent/mobileqq/activity/aio/core/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   260: getfield 172	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   263: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +75 -> 341
    //   269: invokestatic 327	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   272: iconst_0
    //   273: bipush 54
    //   275: invokestatic 332	biwn:a	(Landroid/content/Context;ZI)V
    //   278: return
    //   279: astore_3
    //   280: ldc_w 334
    //   283: iconst_1
    //   284: new 201	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 336
    //   294: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_3
    //   298: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: goto -249 -> 58
    //   310: astore_3
    //   311: ldc_w 334
    //   314: iconst_1
    //   315: new 201	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 341
    //   325: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_3
    //   329: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: goto -98 -> 240
    //   341: ldc_w 343
    //   344: aload_0
    //   345: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   348: getfield 49	com/tencent/mobileqq/activity/aio/core/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   351: getfield 172	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   354: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   357: ifeq -79 -> 278
    //   360: aload_0
    //   361: getfield 35	agjr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   364: getstatic 346	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_GDT_AD_MANAGER	I
    //   367: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   370: checkcast 348	akrc
    //   373: aload_0
    //   374: getfield 46	agjr:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   377: checkcast 350	com/tencent/mobileqq/app/BaseActivity
    //   380: aload_0
    //   381: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   384: invokevirtual 353	akrc:a	(Lcom/tencent/mobileqq/app/BaseActivity;Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V
    //   387: aload_0
    //   388: getfield 35	agjr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   391: ldc_w 355
    //   394: ldc_w 357
    //   397: ldc 73
    //   399: ldc_w 359
    //   402: ldc_w 361
    //   405: iconst_0
    //   406: iconst_0
    //   407: ldc 73
    //   409: ldc 73
    //   411: ldc 73
    //   413: ldc 73
    //   415: invokestatic 366	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   418: return
    //   419: astore_3
    //   420: ldc_w 334
    //   423: iconst_1
    //   424: aload_3
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   432: return
    //   433: iload_1
    //   434: bipush 14
    //   436: if_icmpne +140 -> 576
    //   439: invokestatic 372	avek:a	()V
    //   442: aload_0
    //   443: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   446: instanceof 315
    //   449: ifeq +31 -> 480
    //   452: ldc_w 317
    //   455: aload_0
    //   456: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   459: getfield 49	com/tencent/mobileqq/activity/aio/core/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   462: getfield 172	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   465: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifeq +56 -> 524
    //   471: invokestatic 327	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   474: iconst_1
    //   475: bipush 54
    //   477: invokestatic 332	biwn:a	(Landroid/content/Context;ZI)V
    //   480: aload_0
    //   481: getfield 123	agjr:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   484: ifnull -206 -> 278
    //   487: aload_0
    //   488: getfield 119	agjr:c	Landroid/widget/TextView;
    //   491: ifnull -213 -> 278
    //   494: aload_0
    //   495: getfield 123	agjr:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   498: aload_0
    //   499: getfield 119	agjr:c	Landroid/widget/TextView;
    //   502: invokevirtual 129	android/widget/LinearLayout:removeView	(Landroid/view/View;)V
    //   505: aload_0
    //   506: aconst_null
    //   507: putfield 119	agjr:c	Landroid/widget/TextView;
    //   510: return
    //   511: astore_3
    //   512: ldc_w 334
    //   515: iconst_1
    //   516: aload_3
    //   517: invokestatic 376	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   520: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: return
    //   524: aload_0
    //   525: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   528: getfield 49	com/tencent/mobileqq/activity/aio/core/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   531: invokestatic 381	uuc:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   534: ifeq -54 -> 480
    //   537: aload_0
    //   538: getfield 35	agjr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   541: getstatic 346	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_GDT_AD_MANAGER	I
    //   544: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   547: checkcast 348	akrc
    //   550: aload_0
    //   551: getfield 46	agjr:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   554: invokevirtual 383	akrc:a	(Landroid/content/Context;)V
    //   557: goto -77 -> 480
    //   560: astore_3
    //   561: ldc_w 334
    //   564: iconst_1
    //   565: aload_3
    //   566: iconst_0
    //   567: anewarray 4	java/lang/Object
    //   570: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   573: goto -93 -> 480
    //   576: iload_1
    //   577: bipush 6
    //   579: if_icmpne +33 -> 612
    //   582: aload_0
    //   583: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   586: getfield 49	com/tencent/mobileqq/activity/aio/core/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   589: invokestatic 381	uuc:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   592: ifeq -314 -> 278
    //   595: aload_0
    //   596: getfield 35	agjr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   599: getstatic 346	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_GDT_AD_MANAGER	I
    //   602: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   605: checkcast 348	akrc
    //   608: invokevirtual 384	akrc:a	()V
    //   611: return
    //   612: iload_1
    //   613: bipush 10
    //   615: if_icmpne +33 -> 648
    //   618: aload_0
    //   619: getfield 28	agjr:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   622: getfield 49	com/tencent/mobileqq/activity/aio/core/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   625: invokestatic 381	uuc:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   628: ifeq -350 -> 278
    //   631: aload_0
    //   632: getfield 35	agjr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   635: getstatic 346	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_GDT_AD_MANAGER	I
    //   638: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   641: checkcast 348	akrc
    //   644: invokevirtual 386	akrc:b	()V
    //   647: return
    //   648: iload_1
    //   649: bipush 12
    //   651: if_icmpne -373 -> 278
    //   654: aload_0
    //   655: invokevirtual 387	agjr:a	()V
    //   658: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	agjr
    //   0	659	1	paramInt	int
    //   150	6	2	f	float
    //   279	19	3	localThrowable1	java.lang.Throwable
    //   310	19	3	localThrowable2	java.lang.Throwable
    //   419	6	3	localThrowable3	java.lang.Throwable
    //   511	6	3	localThrowable4	java.lang.Throwable
    //   560	6	3	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   6	47	279	java/lang/Throwable
    //   47	58	279	java/lang/Throwable
    //   58	240	310	java/lang/Throwable
    //   240	278	419	java/lang/Throwable
    //   341	418	419	java/lang/Throwable
    //   480	510	511	java/lang/Throwable
    //   442	480	560	java/lang/Throwable
    //   524	557	560	java/lang/Throwable
  }
  
  public void a(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.toString().equals(this.jdField_b_of_type_JavaLangString))) {
      a();
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      a();
    }
  }
  
  public void a(String paramString, admo paramadmo, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.length == 4))
    {
      paramadmo.f = ((Integer)paramString[0]).intValue();
      paramadmo.jdField_d_of_type_Long = ((Long)paramString[1]).longValue();
      if ((paramString[2] != null) && (akqe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)))
      {
        paramadmo.c = ((String)paramString[2]);
        paramadmo.jdField_d_of_type_JavaLangString = ((String)paramString[3]);
        this.jdField_a_of_type_Akqe = ((akqe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
        paramadmo.e = this.jdField_a_of_type_Akqe.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramadmo.c, paramadmo.jdField_d_of_type_JavaLangString).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, Long.valueOf(paramadmo.jdField_d_of_type_Long), Integer.valueOf(paramadmo.f), Boolean.valueOf(paramadmo.e), paramadmo.c, paramadmo.jdField_d_of_type_JavaLangString }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    agjt localagjt = new agjt(this);
    if (paramInt == 3)
    {
      a(paramString1, akqe.b(paramString2), "回复下一句参与接龙", localagjt, true);
      return;
    }
    a(paramString1, akqe.a(paramString2), paramInt, localagjt);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, new agjs(this, paramString1, paramString2), false);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0);
  }
  
  public int[] a()
  {
    return new int[] { 8, 14, 6, 10 };
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("0"))) {
      a();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Int - paramInt > 5)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjr
 * JD-Core Version:    0.7.0.1
 */