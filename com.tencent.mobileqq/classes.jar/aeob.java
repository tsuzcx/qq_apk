import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager.1;
import com.tencent.mobileqq.activity.aio.tips.TipsManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.os.MqqHandler;

public class aeob
  implements aeoa, Handler.Callback
{
  int jdField_a_of_type_Int = vct.a(BaseApplicationImpl.getContext(), 50.0F);
  private acis jdField_a_of_type_Acis;
  private aenz jdField_a_of_type_Aenz;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aeoc(this);
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  private ArrayList<aeod> jdField_a_of_type_JavaUtilArrayList;
  public List<QQOperationViopTipTask> a;
  private Observer jdField_a_of_type_JavaUtilObserver;
  protected final MqqHandler a;
  int jdField_b_of_type_Int = vct.a(BaseApplicationImpl.getContext(), 30.0F);
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  Animation c;
  
  public aeob(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, acis paramacis, XPanelContainer paramXPanelContainer, List<QQOperationViopTipTask> paramList)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Acis = paramacis;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  /* Error */
  private RelativeLayout a()
  {
    // Byte code:
    //   0: invokestatic 52	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc 94
    //   5: aconst_null
    //   6: invokestatic 100	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   9: checkcast 102	android/widget/RelativeLayout
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: ldc 103
    //   17: invokevirtual 107	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   20: checkcast 109	com/tencent/image/URLImageView
    //   23: putfield 111	aeob:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   26: aload_1
    //   27: astore_2
    //   28: new 113	java/io/File
    //   31: dup
    //   32: getstatic 119	nfp:h	Ljava/lang/String;
    //   35: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 126	java/io/File:exists	()Z
    //   41: ifeq +62 -> 103
    //   44: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +11 -> 58
    //   50: ldc 133
    //   52: iconst_2
    //   53: ldc 135
    //   55: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: new 141	java/net/URL
    //   61: dup
    //   62: new 143	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   69: ldc 146
    //   71: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: getstatic 119	nfp:h	Ljava/lang/String;
    //   77: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokespecial 155	java/net/URL:<init>	(Ljava/lang/String;)V
    //   86: invokestatic 161	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   89: invokestatic 167	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   92: astore_2
    //   93: aload_0
    //   94: getfield 111	aeob:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   97: aload_2
    //   98: invokevirtual 171	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   101: aload_1
    //   102: astore_2
    //   103: aload_2
    //   104: areturn
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_1
    //   108: aload_3
    //   109: invokevirtual 174	java/net/MalformedURLException:printStackTrace	()V
    //   112: aload_1
    //   113: astore_2
    //   114: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq -14 -> 103
    //   120: ldc 133
    //   122: iconst_2
    //   123: new 143	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   130: ldc 176
    //   132: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 179	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aload_1
    //   149: areturn
    //   150: astore_1
    //   151: aconst_null
    //   152: areturn
    //   153: astore_2
    //   154: aload_1
    //   155: areturn
    //   156: astore_3
    //   157: goto -49 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	aeob
    //   12	137	1	localRelativeLayout	RelativeLayout
    //   150	5	1	localThrowable1	Throwable
    //   27	87	2	localObject	Object
    //   153	1	2	localThrowable2	Throwable
    //   105	31	3	localMalformedURLException1	java.net.MalformedURLException
    //   156	1	3	localMalformedURLException2	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   0	13	105	java/net/MalformedURLException
    //   0	13	150	java/lang/Throwable
    //   13	26	153	java/lang/Throwable
    //   28	58	153	java/lang/Throwable
    //   58	101	153	java/lang/Throwable
    //   13	26	156	java/net/MalformedURLException
    //   28	58	156	java/net/MalformedURLException
    //   58	101	156	java/net/MalformedURLException
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " [Unknow] ";
    case 4: 
      return " [TIPS_BAR_TYPE_DISC_FREQ_CALL] ";
    case 0: 
      return " [TIPS_BAR_TYPE_FRAUD] ";
    case 5: 
      return " [TIPS_BAR_TYPE_HOT_FRIEND_CALL] ";
    case 2: 
      return " [TIPS_BAR_TYPE_VIDEO_STATUS] ";
    case 3: 
      return " [TIPS_BAR_TYPE_TROOP_ASSIST] ";
    case 6: 
      return "[TIPS_QQ_OPERATE] ";
    case 7: 
      return " [TIPS_BAR_TYPE_PUB_ACCOUNT_ASSIT] ";
    case 1: 
      return " [TIPS_BAR_TYPE_READER] ";
    case 1001: 
      return " [GRAY_TIPS_DISC_FREQ_PTT] ";
    case 1000: 
      return " [GRAY_TIPS_FRIEND_FREQ] ";
    case 1002: 
      return " [GRAY_TIPS_SOUGOU_INPUT] ";
    case 1003: 
      return " [GRAY_TIPS_GATHER_CONTACTS] ";
    case 9: 
      return " [TIPS_TYPE_RED_PACKET] ";
    case 10: 
      return " [TIPS_BAR_TYPE_FUN_CALL]";
    case 12: 
      return "[TIPS_TYPE_BAR_LIGHTALK]";
    case 1004: 
      return " [TIPS_TYPE_GRAY_HONGBAO_KEYWORDS] ";
    case 2001: 
      return " [TIPS_TYPE_GRAY_SPECIALCARE]";
    case 15: 
      return " [TIPS_TYPE_BAR_APOLLO_GAME_PARTY]";
    case 17: 
      return " [TIPS_TYPE_MOVIE_TICKET]";
    case 19: 
      return " [TIPS_TYPE_BAR_HW_TROOP]";
    case 20: 
      return "[TIPS_TYPE_BAR_HW_TROOP_SURVEY]";
    case 22: 
      return "[TIPS_TYPE_C2B]";
    }
    return "[TIPS_TYPE_TOGETHER_BUSINESS_TIPS]";
  }
  
  private boolean a(aeod paramaeod)
  {
    boolean bool3 = false;
    Object localObject1 = a(paramaeod.b());
    int i = -1;
    int[] arrayOfInt = paramaeod.a();
    boolean bool1;
    if (arrayOfInt != null)
    {
      if (this.jdField_a_of_type_Aenz != null) {
        i = this.jdField_a_of_type_Aenz.b();
      }
      boolean bool2 = true;
      int j = 0;
      Object localObject2 = localObject1;
      if (j < arrayOfInt.length)
      {
        switch (arrayOfInt[j])
        {
        default: 
          bool1 = bool2;
          localObject1 = localObject2;
        }
        for (;;)
        {
          j += 1;
          localObject2 = localObject1;
          bool2 = bool1;
          break;
          localObject1 = localObject2;
          bool1 = bool2;
          if (i == arrayOfInt[j])
          {
            localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_DISC_ACTIVE ";
            bool1 = false;
            continue;
            localObject1 = localObject2;
            bool1 = bool2;
            if (i == arrayOfInt[j])
            {
              localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_FRAUD ";
              bool1 = false;
              continue;
              localObject1 = localObject2;
              bool1 = bool2;
              if (i == arrayOfInt[j])
              {
                localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_FRIEND_HOT ";
                bool1 = false;
                continue;
                localObject1 = localObject2;
                bool1 = bool2;
                if (i == arrayOfInt[j])
                {
                  localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_READER ";
                  bool1 = false;
                  continue;
                  localObject1 = localObject2;
                  bool1 = bool2;
                  if (i == arrayOfInt[j])
                  {
                    localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_TROOP_ASSIST ";
                    bool1 = false;
                    continue;
                    localObject1 = localObject2;
                    bool1 = bool2;
                    if (i == arrayOfInt[j])
                    {
                      localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_VIDEO_STATUS ";
                      bool1 = false;
                      continue;
                      localObject1 = localObject2;
                      bool1 = bool2;
                      if (i == arrayOfInt[j])
                      {
                        localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_QQ_OPERATE ";
                        bool1 = false;
                        continue;
                        localObject1 = localObject2;
                        bool1 = bool2;
                        if (i == arrayOfInt[j])
                        {
                          localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_PUB_ACCOUNT_ASSIST ";
                          bool1 = false;
                          continue;
                          localObject1 = localObject2;
                          bool1 = bool2;
                          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
                          {
                            localObject1 = localObject2;
                            bool1 = bool2;
                            if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
                            {
                              localObject1 = localObject2 + ", not allowed by excludeType: EXCLUDE_TYPE_EXT_PANEL ";
                              bool1 = false;
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
        }
      }
      bool1 = bool2;
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((bool1) && ((paramaeod instanceof aenz)) && (this.jdField_a_of_type_Aenz != null) && (this.jdField_a_of_type_Aenz.a() > ((aenz)paramaeod).a()))
      {
        localObject1 = (String)localObject1 + ", not allowed: priority is low ";
        bool1 = bool3;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "allowShow(): result = " + bool1 + " | " + (String)localObject1 + "|curTipsBarType" + i);
        }
        return bool1;
      }
      bool1 = true;
      i = -1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aenz != null) {
      return this.jdField_a_of_type_Aenz.b();
    }
    return -1;
  }
  
  public aenz a()
  {
    return this.jdField_a_of_type_Aenz;
  }
  
  public void a()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_Acis != null) {
        this.jdField_a_of_type_Acis.a(this.jdField_a_of_type_Aenz);
      }
      this.jdField_a_of_type_Aenz = null;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
    TipsManager.2 local2 = new TipsManager.2(this);
    this.jdField_a_of_type_MqqOsMqqHandler.post(local2);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((aeod)localIterator.next()).a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(aeod paramaeod)
  {
    if (paramaeod == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramaeod));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaeod);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, -(this.jdField_b_of_type_Int + this.jdField_a_of_type_Int), 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(208L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 10.0F, -10.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(150L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
    }
    if (this.c == null)
    {
      this.c = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(this.jdField_b_of_type_Int + this.jdField_a_of_type_Int));
      this.c.setDuration(208L);
      this.c.setFillAfter(true);
      this.c.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = a();
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setId(2131301970);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.findViewById(2131298518));
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301970) == null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    c();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void a(Observer paramObserver)
  {
    this.jdField_a_of_type_JavaUtilObserver = paramObserver;
  }
  
  public boolean a(aeng paramaeng, Object... paramVarArgs)
  {
    if (paramaeng != null)
    {
      if (a(paramaeng)) {
        break label29;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TipsManager", 2, "showGrayTips() failure: mTipsMgr not allow");
      }
    }
    label29:
    do
    {
      return false;
      paramVarArgs = paramaeng.a(paramVarArgs);
      if (paramVarArgs != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs, paramVarArgs.selfuin);
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showGrayTips() success: from " + a(paramaeng.b()));
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TipsManager", 2, "showGrayTips() failure: MessageRecord null, from " + a(paramaeng.b()));
    return false;
  }
  
  public boolean a(aenz paramaenz, Object... paramVarArgs)
  {
    if (aciy.l) {}
    label136:
    do
    {
      do
      {
        return false;
        if (paramaenz == null) {
          break label136;
        }
        if (a(paramaenz)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TipsManager", 2, "showTipsBar() failure: mTipsMgr not allow");
      return false;
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        paramVarArgs = paramaenz.a(paramVarArgs);
        this.jdField_a_of_type_Acis.a(paramVarArgs, paramaenz);
        this.jdField_a_of_type_Aenz = paramaenz;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showTipsBar() success: from " + a(paramaenz.b()));
        }
        return true;
        paramVarArgs = new TipsManager.1(this, paramaenz, paramVarArgs);
        this.jdField_a_of_type_MqqOsMqqHandler.post(paramVarArgs);
      }
    } while (!QLog.isColorLevel());
    QLog.d("TipsManager", 2, "showTipsBar() failure: tipsBar == null");
    return false;
  }
  
  public void b()
  {
    a(1004, new Object[0]);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    a();
    if (this.jdField_a_of_type_Acis != null) {
      this.jdField_a_of_type_Acis.a();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_AndroidWidgetRelativeLayout) != -1))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
  }
  
  public void c()
  {
    int i = 2131311899;
    int j = 2131311893;
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    localLayoutParams.addRule(11);
    View localView1 = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131311899);
    View localView2 = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131311893);
    if ((localView1 != null) && (localView1.getVisibility() == 0)) {}
    for (;;)
    {
      if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        i = j;
      }
      for (;;)
      {
        j = this.jdField_b_of_type_Int;
        int k = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131167766);
        if (i == -1) {
          localLayoutParams.addRule(10);
        }
        for (i = j + k;; i = j)
        {
          localLayoutParams.topMargin = i;
          localLayoutParams.rightMargin = vct.a(BaseApplicationImpl.getContext(), 40.0F);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
          return;
          localLayoutParams.addRule(3, i);
        }
      }
      i = -1;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "[removeJdEntry]");
    }
    try
    {
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301970) != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300886));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300887));
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        }
        if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
          this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.c);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TipsManager", 2, localThrowable.getMessage());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeob
 * JD-Core Version:    0.7.0.1
 */