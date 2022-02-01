import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agmv
  implements agma
{
  private int jdField_a_of_type_Int;
  private aklj jdField_a_of_type_Aklj;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView c;
  
  public agmv(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Aklj = ((aklj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125));
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = anni.a(2131709935);
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return anni.a(2131719155);
      }
    } while (paramInt != 2);
    return anni.a(2131719157);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
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
      this.c.setText(anni.a(2131719160));
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        ((ardm)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(19)).a();
      }
      return;
      label231:
      if (paramInt == 1) {
        this.c.setText(anni.a(2131719154));
      } else if (paramInt == 2) {
        this.c.setText(anni.a(2131719156));
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
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
      ((ardm)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(19)).a();
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
      if (!njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
        for (arrayOfObject = this.jdField_a_of_type_Aklj.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString, paramInt); (arrayOfObject != null) && (((Integer)arrayOfObject[0]).intValue() == 1); arrayOfObject = this.jdField_a_of_type_Aklj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt))
        {
          this.jdField_a_of_type_JavaLangString = "";
          this.jdField_b_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().sendEmptyMessage(12);
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
    //   1: bipush 7
    //   3: if_icmpne +428 -> 431
    //   6: aload_0
    //   7: getfield 54	agmv:jdField_a_of_type_Aklj	Laklj;
    //   10: ifnull +48 -> 58
    //   13: aload_0
    //   14: getfield 54	agmv:jdField_a_of_type_Aklj	Laklj;
    //   17: getfield 234	aklj:a	Z
    //   20: ifeq +38 -> 58
    //   23: aload_0
    //   24: getfield 44	agmv:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   27: getfield 235	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   30: iconst_1
    //   31: if_icmpeq +16 -> 47
    //   34: aload_0
    //   35: getfield 44	agmv:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   38: getfield 235	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   41: sipush 1004
    //   44: if_icmpne +14 -> 58
    //   47: aload_0
    //   48: getfield 54	agmv:jdField_a_of_type_Aklj	Laklj;
    //   51: aload_0
    //   52: getfield 44	agmv:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   55: invokevirtual 238	aklj:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   63: getfield 241	com/tencent/mobileqq/activity/BaseChatPie:c	Landroid/view/ViewGroup;
    //   66: ldc 242
    //   68: invokevirtual 248	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   71: checkcast 97	android/widget/TextView
    //   74: putfield 95	agmv:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   77: aload_0
    //   78: new 97	android/widget/TextView
    //   81: dup
    //   82: aload_0
    //   83: getfield 36	agmv:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   86: invokespecial 251	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   89: putfield 106	agmv:c	Landroid/widget/TextView;
    //   92: aload_0
    //   93: getfield 106	agmv:c	Landroid/widget/TextView;
    //   96: ldc 252
    //   98: invokevirtual 255	android/widget/TextView:setTextColor	(I)V
    //   101: aload_0
    //   102: getfield 106	agmv:c	Landroid/widget/TextView;
    //   105: iconst_1
    //   106: ldc_w 256
    //   109: invokevirtual 260	android/widget/TextView:setTextSize	(IF)V
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   117: getfield 241	com/tencent/mobileqq/activity/BaseChatPie:c	Landroid/view/ViewGroup;
    //   120: ldc_w 261
    //   123: invokevirtual 248	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   126: checkcast 97	android/widget/TextView
    //   129: putfield 103	agmv:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   132: aload_0
    //   133: getfield 95	agmv:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   136: invokevirtual 265	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   139: ldc_w 266
    //   142: invokestatic 66	anni:a	(I)Ljava/lang/String;
    //   145: invokevirtual 272	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   148: fstore_2
    //   149: aload_0
    //   150: getfield 95	agmv:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   153: fload_2
    //   154: ldc_w 273
    //   157: fmul
    //   158: ldc_w 274
    //   161: fadd
    //   162: f2i
    //   163: invokevirtual 277	android/widget/TextView:setMaxWidth	(I)V
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   171: getfield 241	com/tencent/mobileqq/activity/BaseChatPie:c	Landroid/view/ViewGroup;
    //   174: ldc_w 278
    //   177: invokevirtual 248	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   180: putfield 87	agmv:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   188: getfield 241	com/tencent/mobileqq/activity/BaseChatPie:c	Landroid/view/ViewGroup;
    //   191: ldc_w 279
    //   194: invokevirtual 248	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   197: checkcast 112	android/widget/LinearLayout
    //   200: putfield 110	agmv:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   203: aload_0
    //   204: getfield 110	agmv:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   207: aload_0
    //   208: getfield 106	agmv:c	Landroid/widget/TextView;
    //   211: invokevirtual 281	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   214: aload_0
    //   215: getfield 106	agmv:c	Landroid/widget/TextView;
    //   218: invokevirtual 285	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   221: bipush 254
    //   223: putfield 290	android/view/ViewGroup$LayoutParams:width	I
    //   226: aload_0
    //   227: getfield 106	agmv:c	Landroid/widget/TextView;
    //   230: invokevirtual 285	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   233: bipush 254
    //   235: putfield 293	android/view/ViewGroup$LayoutParams:height	I
    //   238: aload_0
    //   239: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   242: instanceof 295
    //   245: ifeq +31 -> 276
    //   248: ldc_w 297
    //   251: aload_0
    //   252: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   255: getfield 43	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   258: getfield 156	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   261: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   264: ifeq +75 -> 339
    //   267: invokestatic 307	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   270: iconst_0
    //   271: bipush 54
    //   273: invokestatic 312	bies:a	(Landroid/content/Context;ZI)V
    //   276: return
    //   277: astore_3
    //   278: ldc_w 314
    //   281: iconst_1
    //   282: new 184	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 316
    //   292: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_3
    //   296: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: goto -247 -> 58
    //   308: astore_3
    //   309: ldc_w 314
    //   312: iconst_1
    //   313: new 184	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 321
    //   323: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_3
    //   327: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: goto -98 -> 238
    //   339: ldc_w 323
    //   342: aload_0
    //   343: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   346: getfield 43	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   349: getfield 156	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq -79 -> 276
    //   358: aload_0
    //   359: getfield 33	agmv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: sipush 341
    //   365: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   368: checkcast 325	akmh
    //   371: aload_0
    //   372: getfield 41	agmv:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   375: checkcast 327	com/tencent/mobileqq/app/BaseActivity
    //   378: aload_0
    //   379: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   382: invokevirtual 330	akmh:a	(Lcom/tencent/mobileqq/app/BaseActivity;Lcom/tencent/mobileqq/activity/BaseChatPie;)V
    //   385: aload_0
    //   386: getfield 33	agmv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   389: ldc_w 332
    //   392: ldc_w 334
    //   395: ldc 61
    //   397: ldc_w 336
    //   400: ldc_w 338
    //   403: iconst_0
    //   404: iconst_0
    //   405: ldc 61
    //   407: ldc 61
    //   409: ldc 61
    //   411: ldc 61
    //   413: invokestatic 343	bcst:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   416: return
    //   417: astore_3
    //   418: ldc_w 314
    //   421: iconst_1
    //   422: aload_3
    //   423: iconst_0
    //   424: anewarray 4	java/lang/Object
    //   427: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   430: return
    //   431: iload_1
    //   432: bipush 13
    //   434: if_icmpne +140 -> 574
    //   437: invokestatic 349	autv:a	()V
    //   440: aload_0
    //   441: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   444: instanceof 295
    //   447: ifeq +31 -> 478
    //   450: ldc_w 297
    //   453: aload_0
    //   454: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   457: getfield 43	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   460: getfield 156	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   463: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +56 -> 522
    //   469: invokestatic 307	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   472: iconst_1
    //   473: bipush 54
    //   475: invokestatic 312	bies:a	(Landroid/content/Context;ZI)V
    //   478: aload_0
    //   479: getfield 110	agmv:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   482: ifnull -206 -> 276
    //   485: aload_0
    //   486: getfield 106	agmv:c	Landroid/widget/TextView;
    //   489: ifnull -213 -> 276
    //   492: aload_0
    //   493: getfield 110	agmv:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   496: aload_0
    //   497: getfield 106	agmv:c	Landroid/widget/TextView;
    //   500: invokevirtual 116	android/widget/LinearLayout:removeView	(Landroid/view/View;)V
    //   503: aload_0
    //   504: aconst_null
    //   505: putfield 106	agmv:c	Landroid/widget/TextView;
    //   508: return
    //   509: astore_3
    //   510: ldc_w 314
    //   513: iconst_1
    //   514: aload_3
    //   515: invokestatic 353	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   518: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: return
    //   522: aload_0
    //   523: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   526: getfield 43	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   529: invokestatic 358	tzo:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   532: ifeq -54 -> 478
    //   535: aload_0
    //   536: getfield 33	agmv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   539: sipush 341
    //   542: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   545: checkcast 325	akmh
    //   548: aload_0
    //   549: getfield 41	agmv:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   552: invokevirtual 360	akmh:a	(Landroid/content/Context;)V
    //   555: goto -77 -> 478
    //   558: astore_3
    //   559: ldc_w 314
    //   562: iconst_1
    //   563: aload_3
    //   564: iconst_0
    //   565: anewarray 4	java/lang/Object
    //   568: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   571: goto -93 -> 478
    //   574: iload_1
    //   575: iconst_5
    //   576: if_icmpne +33 -> 609
    //   579: aload_0
    //   580: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   583: getfield 43	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   586: invokestatic 358	tzo:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   589: ifeq -313 -> 276
    //   592: aload_0
    //   593: getfield 33	agmv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   596: sipush 341
    //   599: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   602: checkcast 325	akmh
    //   605: invokevirtual 361	akmh:a	()V
    //   608: return
    //   609: iload_1
    //   610: bipush 9
    //   612: if_icmpne +33 -> 645
    //   615: aload_0
    //   616: getfield 28	agmv:jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   619: getfield 43	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   622: invokestatic 358	tzo:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   625: ifeq -349 -> 276
    //   628: aload_0
    //   629: getfield 33	agmv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   632: sipush 341
    //   635: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   638: checkcast 325	akmh
    //   641: invokevirtual 363	akmh:b	()V
    //   644: return
    //   645: iload_1
    //   646: bipush 11
    //   648: if_icmpne -372 -> 276
    //   651: aload_0
    //   652: invokevirtual 364	agmv:a	()V
    //   655: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	this	agmv
    //   0	656	1	paramInt	int
    //   148	6	2	f	float
    //   277	19	3	localThrowable1	java.lang.Throwable
    //   308	19	3	localThrowable2	java.lang.Throwable
    //   417	6	3	localThrowable3	java.lang.Throwable
    //   509	6	3	localThrowable4	java.lang.Throwable
    //   558	6	3	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   6	47	277	java/lang/Throwable
    //   47	58	277	java/lang/Throwable
    //   58	238	308	java/lang/Throwable
    //   238	276	417	java/lang/Throwable
    //   339	416	417	java/lang/Throwable
    //   478	508	509	java/lang/Throwable
    //   440	478	558	java/lang/Throwable
    //   522	555	558	java/lang/Throwable
  }
  
  public void a(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.toString().equals(this.jdField_b_of_type_JavaLangString))) {
      a();
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!bgsp.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      a();
    }
  }
  
  public void a(String paramString, adrt paramadrt, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.length == 4))
    {
      paramadrt.f = ((Integer)paramString[0]).intValue();
      paramadrt.jdField_d_of_type_Long = ((Long)paramString[1]).longValue();
      if ((paramString[2] != null) && (aklj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramadrt.c = ((String)paramString[2]);
        paramadrt.jdField_d_of_type_JavaLangString = ((String)paramString[3]);
        this.jdField_a_of_type_Aklj = ((aklj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125));
        paramadrt.e = this.jdField_a_of_type_Aklj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramadrt.c, paramadrt.jdField_d_of_type_JavaLangString).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(paramadrt.jdField_d_of_type_Long), Integer.valueOf(paramadrt.f), Boolean.valueOf(paramadrt.e), paramadrt.c, paramadrt.jdField_d_of_type_JavaLangString }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!bgsp.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    agmx localagmx = new agmx(this);
    if (paramInt == 3)
    {
      a(paramString1, aklj.b(paramString2), "回复下一句参与接龙", localagmx, true);
      return;
    }
    a(paramString1, aklj.a(paramString2), paramInt, localagmx);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, new agmw(this, paramString1, paramString2), false);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0);
  }
  
  public int[] a()
  {
    return new int[] { 7, 13, 5, 9 };
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
 * Qualified Name:     agmv
 * JD-Core Version:    0.7.0.1
 */