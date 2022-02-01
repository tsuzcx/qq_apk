import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.util.Vector;

class aguk
  implements View.OnClickListener
{
  private aguk(agtx paramagtx) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getContext() instanceof ChatHistoryActivity)) {}
    aguj localaguj;
    MessageForPoke localMessageForPoke;
    label336:
    label636:
    Object localObject2;
    Object localObject4;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      afur.n = true;
      if (!this.a.a())
      {
        localaguj = (aguj)afur.a(paramView);
        localMessageForPoke = (MessageForPoke)localaguj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "poke onClick() is called, type:" + localMessageForPoke.interactType);
        }
        int i;
        Object localObject1;
        if (126 == localMessageForPoke.interactType)
        {
          if (paramView.findViewById(2131378248).getVisibility() == 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label336;
            }
            if (!aheh.c.contains(Integer.valueOf(localMessageForPoke.subId))) {
              aheh.c.add(Integer.valueOf(localMessageForPoke.subId));
            }
            if (!aheh.d.contains(Integer.valueOf(localMessageForPoke.subId))) {
              aheh.d.add(Integer.valueOf(localMessageForPoke.subId));
            }
            if (!aheh.b.contains(Integer.valueOf(localMessageForPoke.subId))) {
              aheh.b.add(Integer.valueOf(localMessageForPoke.subId));
            }
            localaguj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            localaguj.b.setVisibility(8);
            localObject1 = (VasQuickUpdateManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
            ((VasQuickUpdateManager)localObject1).downloadItem(21L, "poke.item.effect." + localMessageForPoke.subId, "getbubbleview");
            ((VasQuickUpdateManager)localObject1).downloadItem(21L, "poke.item.res." + localMessageForPoke.subId, "getbubbleview");
            ((VasQuickUpdateManager)localObject1).addCallBacker(this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
            break;
          }
          if (!aheh.a("bubble", localMessageForPoke.subId))
          {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, anni.a(2131704069), 0).a();
          }
          else
          {
            if (amuo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d == 1) {}
            for (i = 0;; i = 1)
            {
              if (i != 0)
              {
                amuf.a(this.a.b, "vas_poke", true);
                if (QLog.isColorLevel()) {
                  QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in click.");
                }
              }
              aheh.a(this.a.b, this.a.jdField_a_of_type_AndroidContentContext, localaguj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localaguj, localMessageForPoke.subId, "bubble");
              break;
            }
          }
        }
        else if (!PokeBigResHandler.a)
        {
          localaguj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
          localaguj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
          localaguj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, anni.a(2131704062), 0).a();
          localObject1 = (PokeBigResHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(117);
          if (localObject1 != null) {
            ((PokeBigResHandler)localObject1).a(true);
          }
          if (localMessageForPoke.isSend()) {
            localMessageForPoke.setPlayed(this.a.b);
          }
        }
        else
        {
          i = 0;
          Object localObject5;
          switch (localMessageForPoke.interactType)
          {
          default: 
            localObject1 = ahed.a + "/chuo_icon/chuo_icon_";
            localObject5 = agtx.a(localMessageForPoke.interactType);
            if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {
              if (localaguj.jdField_a_of_type_Float == 2.0F)
              {
                localObject1 = new BitmapFactory.Options();
                ((BitmapFactory.Options)localObject1).inSampleSize = 1;
                ((BitmapFactory.Options)localObject1).inMutable = true;
              }
            }
            break;
          }
          for (;;)
          {
            try
            {
              localObject1 = bgmo.a(PokeBigResHandler.b + "/chuo_caidan/chuo_caidan_" + "01.png", (BitmapFactory.Options)localObject1);
              localObject3 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, ahed.a().a(), localMessageForPoke.mFrameState, (String)localObject5, aheh.a(this.a.b));
              agtx.a(this.a, (CustomFrameAnimationDrawable)localObject3);
              ((CustomFrameAnimationDrawable)localObject3).a(1);
              if (!localMessageForPoke.isSend())
              {
                if (localMessageForPoke.interactType == 5) {
                  break label1715;
                }
                ((CustomFrameAnimationDrawable)localObject3).b();
              }
              ((CustomFrameAnimationDrawable)localObject3).h();
              ((CustomFrameAnimationDrawable)localObject3).a(new agul(this, localaguj, localMessageForPoke));
              if (localMessageForPoke.interactType == 6) {
                break label2019;
              }
              if ((localMessageForPoke.interactType != 5) || (localaguj.jdField_a_of_type_Float != 2.0F)) {
                break label1724;
              }
              localaguj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              localaguj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
              localObject1 = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362279)).a();
              localaguj.jdField_c_of_type_AndroidViewView.setVisibility(0);
              ((SixCombolEffectView)localObject1).a(localaguj, aheh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
              ((SixCombolEffectView)localObject1).setListener(this.a);
              break;
              localObject1 = PokeBigResHandler.c + "/chuo_motion/chuo_motion_";
              i = 35;
              break label636;
              localObject1 = PokeBigResHandler.c + "/bixin_motion/bixin_motion_";
              i = 67;
              break label636;
              localObject1 = PokeBigResHandler.c + "/zan_motion/zan_motion_";
              i = 20;
              break label636;
              localObject1 = PokeBigResHandler.c + "/xinsui_motion/xinsui_motion_";
              i = 50;
              break label636;
              if (localMessageForPoke.isSend())
              {
                localObject1 = PokeBigResHandler.c + "/666send_motion/666send_motion_";
                i = 57;
                break label636;
              }
              localObject1 = PokeBigResHandler.c + "/666receive_motion/666receive_motion_";
              continue;
              localObject1 = ahed.a + "/dazhao_icon/dazhao_icon_";
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GivingHeart", 2, localOutOfMemoryError1.toString());
              }
              localObject2 = null;
              continue;
            }
            localObject2 = bgmo.a(this.a.jdField_a_of_type_AndroidContentContext.getResources(), 2130838528);
            Object localObject3 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2, ahed.a().a(), localMessageForPoke.mFrameState, (String)localObject5, aheh.a(this.a.b));
            agtx.a((CustomFrameAnimationDrawable)localObject3);
            continue;
            localObject3 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject3).inScaled = true;
            ((BitmapFactory.Options)localObject3).inSampleSize = 1;
            ((BitmapFactory.Options)localObject3).inMutable = true;
            int j;
            for (;;)
            {
              try
              {
                localObject3 = bgmo.a((String)localObject2 + "01.png", (BitmapFactory.Options)localObject3);
                localObject5 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject3, ahed.a().a(), localMessageForPoke.mFrameState, (String)localObject5, aheh.a(this.a.b));
                ((CustomFrameAnimationDrawable)localObject5).i();
                j = 40;
                if (localMessageForPoke.interactType == 2) {
                  j = 30;
                }
                if ((localMessageForPoke.interactType != 4) || (localaguj.jdField_a_of_type_Float != 2.0F)) {
                  break label1603;
                }
                k = 0;
                if (k < 20) {
                  if (k + 1 < 10)
                  {
                    ((CustomFrameAnimationDrawable)localObject5).a(k, j, (String)localObject2 + "0" + (k + 1) + ".png");
                    k += 1;
                    continue;
                  }
                }
              }
              catch (OutOfMemoryError localOutOfMemoryError2)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("GivingHeart", 2, localOutOfMemoryError2.toString());
                }
                localObject4 = null;
                continue;
                ((CustomFrameAnimationDrawable)localObject5).a(k, j, (String)localObject2 + (k + 1) + ".png");
                continue;
                k = 20;
                localObject4 = localObject5;
              }
              if (k >= i) {
                break;
              }
              ((CustomFrameAnimationDrawable)localObject5).a(k, j, (String)localObject2 + 21 + ".png");
              k += 1;
            }
            label1603:
            int k = 0;
            localObject4 = localObject5;
            if (k < i)
            {
              if (k + 1 < 10) {
                ((CustomFrameAnimationDrawable)localObject5).a(k, j, (String)localObject2 + "0" + (k + 1) + ".png");
              }
              for (;;)
              {
                k += 1;
                break;
                ((CustomFrameAnimationDrawable)localObject5).a(k, j, (String)localObject2 + (k + 1) + ".png");
              }
              label1715:
              ((CustomFrameAnimationDrawable)localObject4).a(2);
            }
          }
          label1724:
          localaguj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable((Drawable)localObject4);
          localaguj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
          localaguj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localaguj.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
          localaguj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          if (!localMessageForPoke.mFrameState.a) {
            break;
          }
          ((CustomFrameAnimationDrawable)localObject4).d();
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, "[click]resume to play");
          }
        }
      }
    }
    ((CustomFrameAnimationDrawable)localObject4).c();
    label1869:
    boolean bool2;
    if (localaguj.jdField_a_of_type_Float == 2.0F)
    {
      if (localMessageForPoke.interactType == 2)
      {
        ahed.a().a(1);
        ahed.a().a(2, 1500L, localMessageForPoke.isSend());
      }
    }
    else if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType == 0))
    {
      localObject2 = this.a;
      localObject4 = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
      bool2 = localMessageForPoke.isSend();
      if (localaguj.jdField_a_of_type_Float != 2.0F) {
        break label2013;
      }
    }
    label2013:
    for (boolean bool1 = true;; bool1 = false)
    {
      agtx.a((agtx)localObject2, (Activity)localObject4, bool2, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GivingHeart", 2, "[click]start to play");
      break;
      if (localMessageForPoke.interactType == 3)
      {
        ahed.a().a(4);
        ahed.a().a(5, 700L);
        break label1869;
      }
      if (localMessageForPoke.interactType != 4) {
        break label1869;
      }
      ahed.a().a(13);
      ahed.a().a(14, 800L);
      break label1869;
    }
    label2019:
    if ((PokeBigResHandler.a) && (!localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a()))
    {
      localObject2 = localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      localObject4 = this.a.jdField_a_of_type_AndroidContentContext;
      if (!localMessageForPoke.isSend())
      {
        bool1 = true;
        ((UnlimitedBladeWorks)localObject2).a((Context)localObject4, bool1, aheh.a(this.a.b), localaguj.jdField_a_of_type_Float);
      }
    }
    else
    {
      localObject2 = localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (localMessageForPoke.isSend()) {
        break label2265;
      }
      bool1 = true;
      ((UnlimitedBladeWorks)localObject2).setParams(bool1);
      localObject2 = localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (localMessageForPoke.isSend()) {
        break label2271;
      }
    }
    label2063:
    label2105:
    label2265:
    label2271:
    for (bool1 = true;; bool1 = false)
    {
      ((UnlimitedBladeWorks)localObject2).setMirror(bool1);
      localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
      localaguj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      localaguj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      localaguj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      localaguj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localaguj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localaguj.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new agum(this, localaguj, localMessageForPoke));
      if (localMessageForPoke.mUnlimitedState.a) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("fangdazhao", 2, "[click]start to play");
      }
      localaguj.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.c();
      break;
      bool1 = false;
      break label2063;
      bool1 = false;
      break label2105;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguk
 * JD-Core Version:    0.7.0.1
 */