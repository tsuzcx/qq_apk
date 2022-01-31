import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntrySplashView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;

public class ahgt
  implements bfnt
{
  private int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean = false;
  
  ahgt(ahgs paramahgs) {}
  
  public void a()
  {
    try
    {
      QLog.i("springHb_SpringHbConversationEntry", 1, "onActivePendantClick, mActiveState:" + ahgs.a(this.jdField_a_of_type_Ahgs));
      if (ahgs.a(this.jdField_a_of_type_Ahgs) == 2) {
        this.jdField_a_of_type_Ahgs.b(1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "onActivePendantClick", localThrowable);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Int != 0) && (paramInt2 == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringHbConversationEntry", 2, "onOverScroll scrollY=0, mResume:" + this.jdField_a_of_type_Ahgs.jdField_a_of_type_Boolean + "  mTitleIsVisible:" + this.jdField_a_of_type_Ahgs.f);
          }
          if (this.jdField_a_of_type_Ahgs.f) {
            continue;
          }
          paramInt1 = 1;
          if (paramInt1 != 0)
          {
            if (!this.jdField_a_of_type_Ahgs.jdField_a_of_type_Boolean) {
              continue;
            }
            a(false);
          }
          if (ahgs.a(this.jdField_a_of_type_Ahgs) != null) {
            ahgs.a(this.jdField_a_of_type_Ahgs).c();
          }
        }
        this.jdField_a_of_type_Int = paramInt2;
        paramInt1 = -paramInt2;
        if (paramInt1 > 0)
        {
          if (2 == ahgs.a(this.jdField_a_of_type_Ahgs))
          {
            if (ahgs.a(this.jdField_a_of_type_Ahgs) != null) {
              ahgs.a(this.jdField_a_of_type_Ahgs).setDragWordingOffset(paramInt1);
            }
            ahgl.a().a(this.jdField_a_of_type_Ahgs.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
          }
          if ((!ahgs.a(this.jdField_a_of_type_Ahgs)) || (paramInt1 < this.jdField_a_of_type_Ahgs.jdField_a_of_type_Int - 10) || (!this.jdField_a_of_type_Ahgs.jdField_a_of_type_AndroidOsHandler.hasMessages(2004))) {
            break label378;
          }
          this.jdField_a_of_type_Ahgs.jdField_a_of_type_AndroidOsHandler.removeMessages(2004);
          this.jdField_a_of_type_Ahgs.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2004, 0L);
          return;
          if ((this.jdField_a_of_type_Ahgs.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null) || (this.jdField_a_of_type_Ahgs.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) || (this.jdField_a_of_type_Ahgs.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {
            break label373;
          }
          View localView = this.jdField_a_of_type_Ahgs.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
          if ((localView == null) || (((RelativeLayout.LayoutParams)localView.getLayoutParams()).topMargin == 0)) {
            break label373;
          }
          if (!QLog.isColorLevel()) {
            break label379;
          }
          QLog.i("springHb_SpringHbConversationEntry", 2, "onOverScroll showTitle catch a display exception");
          break label379;
          a(true);
          continue;
        }
        if (2 != ahgs.a(this.jdField_a_of_type_Ahgs)) {
          break label378;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbConversationEntry", 1, "onOverScroll", localThrowable);
        return;
      }
      if (ahgs.a(this.jdField_a_of_type_Ahgs) != null)
      {
        ahgs.a(this.jdField_a_of_type_Ahgs).a();
        return;
        label373:
        paramInt1 = 0;
      }
      else
      {
        label378:
        return;
        label379:
        paramInt1 = 1;
      }
    }
  }
  
  public void a(HongBaoListView paramHongBaoListView)
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      if ((ahgs.a(this.jdField_a_of_type_Ahgs) == 2) && (-paramHongBaoListView.getScrollY() >= 0) && (ahgs.a(this.jdField_a_of_type_Ahgs) != null) && (this.jdField_a_of_type_Ahgs.a())) {
        ahgs.a(this.jdField_a_of_type_Ahgs).c();
      }
      return;
    }
    catch (Throwable paramHongBaoListView)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "onTouchDown", paramHongBaoListView);
    }
  }
  
  public void a(HongBaoListView paramHongBaoListView, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Ahgs.h();
      this.jdField_a_of_type_Ahgs.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Ahgs.jdField_a_of_type_JavaLangRunnable);
      int i = -paramHongBaoListView.getScrollY();
      if ((paramBoolean) && (ahgs.a(this.jdField_a_of_type_Ahgs) == 2))
      {
        if ((i >= 0) && (ahgs.a(this.jdField_a_of_type_Ahgs) != null) && (this.jdField_a_of_type_Ahgs.a())) {
          ahgs.a(this.jdField_a_of_type_Ahgs).c();
        }
        if (i > bbkx.b(1.0F)) {
          ahgs.a(this.jdField_a_of_type_Ahgs);
        }
        if (i > ahgs.b(this.jdField_a_of_type_Ahgs))
        {
          if (this.jdField_a_of_type_Ahgs.f) {
            b(false);
          }
          ahgs.b(this.jdField_a_of_type_Ahgs);
        }
      }
      return;
    }
    catch (Throwable paramHongBaoListView)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "onTouchMoving", paramHongBaoListView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Ahgs.c(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "showTitle", localThrowable);
    }
  }
  
  /* Error */
  public void b(HongBaoListView paramHongBaoListView)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: aload_1
    //   3: invokevirtual 165	com/tencent/widget/HongBaoListView:getScrollY	()I
    //   6: ineg
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 19	ahgt:jdField_a_of_type_Boolean	Z
    //   12: ifeq +446 -> 458
    //   15: iload_3
    //   16: ifle +418 -> 434
    //   19: iload_3
    //   20: aload_0
    //   21: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   24: invokestatic 203	ahgs:c	(Lahgs;)I
    //   27: if_icmpge +191 -> 218
    //   30: aload_0
    //   31: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   34: iconst_0
    //   35: invokevirtual 205	ahgs:c	(I)V
    //   38: aload_0
    //   39: iconst_0
    //   40: invokevirtual 82	ahgt:a	(Z)V
    //   43: aload_0
    //   44: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   47: getfield 117	ahgs:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   50: new 207	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbConversationEntry$1$1
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 210	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbConversationEntry$1$1:<init>	(Lahgt;)V
    //   58: ldc2_w 211
    //   61: invokevirtual 216	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   64: pop
    //   65: iconst_1
    //   66: istore 4
    //   68: iconst_1
    //   69: istore_2
    //   70: aload_0
    //   71: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   74: invokevirtual 173	ahgs:h	()V
    //   77: aload_0
    //   78: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   81: getfield 117	ahgs:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   84: aload_0
    //   85: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   88: getfield 176	ahgs:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   91: invokevirtual 180	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   94: aload_0
    //   95: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   98: getfield 117	ahgs:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   101: aload_0
    //   102: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   105: getfield 176	ahgs:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   108: ldc2_w 217
    //   111: invokevirtual 216	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   119: getfield 102	ahgs:jdField_a_of_type_ComTencentMobileqqActivityConversation	Lcom/tencent/mobileqq/activity/Conversation;
    //   122: getfield 107	com/tencent/mobileqq/activity/Conversation:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   125: sipush 342
    //   128: invokevirtual 224	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   131: checkcast 226	ahfz
    //   134: invokevirtual 227	ahfz:c	()V
    //   137: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +326 -> 466
    //   143: ldc 24
    //   145: iconst_2
    //   146: new 26	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   153: ldc 229
    //   155: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   162: invokestatic 38	ahgs:a	(Lahgs;)I
    //   165: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc 231
    //   170: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_2
    //   174: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: ldc 233
    //   179: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 4
    //   184: invokevirtual 74	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: ldc 235
    //   189: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_0
    //   193: getfield 19	ahgt:jdField_a_of_type_Boolean	Z
    //   196: invokevirtual 74	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   199: ldc 237
    //   201: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_1
    //   205: getfield 240	com/tencent/widget/HongBaoListView:j	Z
    //   208: invokevirtual 74	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   211: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: return
    //   218: iload_3
    //   219: aload_0
    //   220: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   223: invokestatic 203	ahgs:c	(Lahgs;)I
    //   226: if_icmplt +224 -> 450
    //   229: iload_3
    //   230: aload_0
    //   231: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   234: invokestatic 189	ahgs:b	(Lahgs;)I
    //   237: if_icmpgt +213 -> 450
    //   240: aload_1
    //   241: getfield 240	com/tencent/widget/HongBaoListView:j	Z
    //   244: istore 4
    //   246: iload 4
    //   248: ifne +202 -> 450
    //   251: aload_0
    //   252: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   255: getfield 102	ahgs:jdField_a_of_type_ComTencentMobileqqActivityConversation	Lcom/tencent/mobileqq/activity/Conversation;
    //   258: getfield 107	com/tencent/mobileqq/activity/Conversation:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   261: sipush 342
    //   264: invokevirtual 224	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   267: checkcast 226	ahfz
    //   270: invokevirtual 242	ahfz:c	()Z
    //   273: istore 5
    //   275: iload 5
    //   277: ifeq +108 -> 385
    //   280: aload_0
    //   281: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   284: getfield 117	ahgs:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   287: sipush 2005
    //   290: invokevirtual 126	android/os/Handler:removeMessages	(I)V
    //   293: aload_0
    //   294: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   297: getfield 102	ahgs:jdField_a_of_type_ComTencentMobileqqActivityConversation	Lcom/tencent/mobileqq/activity/Conversation;
    //   300: ifnull +23 -> 323
    //   303: aload_0
    //   304: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   307: getfield 102	ahgs:jdField_a_of_type_ComTencentMobileqqActivityConversation	Lcom/tencent/mobileqq/activity/Conversation;
    //   310: iconst_0
    //   311: aconst_null
    //   312: aload_0
    //   313: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   316: getfield 245	ahgs:jdField_a_of_type_ComTencentWidgetARMapHongBaoListView	Lcom/tencent/widget/ARMapHongBaoListView;
    //   319: invokevirtual 248	com/tencent/mobileqq/activity/Conversation:a	(ILandroid/view/View;Lcom/tencent/widget/ListView;)Z
    //   322: pop
    //   323: iload 5
    //   325: istore 4
    //   327: aload_0
    //   328: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   331: invokestatic 85	ahgs:a	(Lahgs;)Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbEntrySplashView;
    //   334: ifnull +17 -> 351
    //   337: aload_0
    //   338: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   341: invokestatic 85	ahgs:a	(Lahgs;)Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbEntrySplashView;
    //   344: invokevirtual 250	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbEntrySplashView:b	()V
    //   347: iload 5
    //   349: istore 4
    //   351: aload_0
    //   352: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   355: aload_0
    //   356: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   359: invokestatic 203	ahgs:c	(Lahgs;)I
    //   362: ineg
    //   363: invokevirtual 205	ahgs:c	(I)V
    //   366: aload_0
    //   367: iconst_0
    //   368: invokevirtual 82	ahgt:a	(Z)V
    //   371: goto -301 -> 70
    //   374: astore_1
    //   375: ldc 24
    //   377: iconst_1
    //   378: ldc 252
    //   380: aload_1
    //   381: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   384: return
    //   385: aload_0
    //   386: getfield 14	ahgt:jdField_a_of_type_Ahgs	Lahgs;
    //   389: getfield 117	ahgs:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   392: sipush 2005
    //   395: ldc2_w 217
    //   398: invokevirtual 130	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   401: pop
    //   402: goto -79 -> 323
    //   405: astore 6
    //   407: iload 5
    //   409: istore 4
    //   411: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq -63 -> 351
    //   417: ldc 24
    //   419: iconst_2
    //   420: ldc 254
    //   422: aload 6
    //   424: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   427: iload 5
    //   429: istore 4
    //   431: goto -80 -> 351
    //   434: iconst_1
    //   435: istore 4
    //   437: iconst_3
    //   438: istore_2
    //   439: goto -369 -> 70
    //   442: astore 6
    //   444: iconst_1
    //   445: istore 5
    //   447: goto -40 -> 407
    //   450: iconst_1
    //   451: istore 4
    //   453: iconst_0
    //   454: istore_2
    //   455: goto -385 -> 70
    //   458: iconst_0
    //   459: istore_2
    //   460: iconst_1
    //   461: istore 4
    //   463: goto -326 -> 137
    //   466: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	ahgt
    //   0	467	1	paramHongBaoListView	HongBaoListView
    //   1	459	2	i	int
    //   7	231	3	j	int
    //   66	396	4	bool1	boolean
    //   273	173	5	bool2	boolean
    //   405	18	6	localException1	java.lang.Exception
    //   442	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	15	374	java/lang/Throwable
    //   19	65	374	java/lang/Throwable
    //   70	137	374	java/lang/Throwable
    //   137	217	374	java/lang/Throwable
    //   218	246	374	java/lang/Throwable
    //   251	275	374	java/lang/Throwable
    //   280	323	374	java/lang/Throwable
    //   327	347	374	java/lang/Throwable
    //   351	371	374	java/lang/Throwable
    //   385	402	374	java/lang/Throwable
    //   411	427	374	java/lang/Throwable
    //   280	323	405	java/lang/Exception
    //   327	347	405	java/lang/Exception
    //   385	402	405	java/lang/Exception
    //   251	275	442	java/lang/Exception
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Ahgs.d(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbConversationEntry", 1, "hideTitle", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgt
 * JD-Core Version:    0.7.0.1
 */