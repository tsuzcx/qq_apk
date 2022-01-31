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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.util.Vector;

class adfr
  implements View.OnClickListener
{
  private adfr(adfe paramadfe) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getContext() instanceof ChatHistoryActivity)) {}
    adfq localadfq;
    MessageForPoke localMessageForPoke;
    Object localObject2;
    label1551:
    label1661:
    do
    {
      do
      {
        do
        {
          return;
          aciy.n = true;
        } while (this.a.a());
        localadfq = (adfq)aciy.a(paramView);
        localMessageForPoke = (MessageForPoke)localadfq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "poke onClick() is called, type:" + localMessageForPoke.interactType);
        }
        if (126 == localMessageForPoke.interactType)
        {
          if (paramView.findViewById(2131311040).getVisibility() == 0) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!adll.c.contains(Integer.valueOf(localMessageForPoke.subId))) {
              adll.c.add(Integer.valueOf(localMessageForPoke.subId));
            }
            if (!adll.d.contains(Integer.valueOf(localMessageForPoke.subId))) {
              adll.d.add(Integer.valueOf(localMessageForPoke.subId));
            }
            if (!adll.b.contains(Integer.valueOf(localMessageForPoke.subId))) {
              adll.b.add(Integer.valueOf(localMessageForPoke.subId));
            }
            localadfq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            localadfq.b.setVisibility(8);
            paramView = (VasQuickUpdateManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
            paramView.downloadItem(21L, "poke.item.effect." + localMessageForPoke.subId, "getbubbleview");
            paramView.downloadItem(21L, "poke.item.res." + localMessageForPoke.subId, "getbubbleview");
            paramView.addCallBacker(this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
            return;
          }
          if (!adll.a("bubble", localMessageForPoke.subId))
          {
            bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 0, ajjy.a(2131639494), 0).a();
            return;
          }
          if (aisl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d == 1) {}
          for (i = 0;; i = 1)
          {
            if (i != 0)
            {
              aisc.a(this.a.b, "vas_poke", true);
              if (QLog.isColorLevel()) {
                QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in click.");
              }
            }
            adll.a(this.a.b, this.a.jdField_a_of_type_AndroidContentContext, localadfq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localadfq, localMessageForPoke.subId, "bubble");
            return;
          }
        }
        if (PokeBigResHandler.a) {
          break;
        }
        localadfq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        localadfq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        localadfq.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 0, ajjy.a(2131639487), 0).a();
        paramView = (PokeBigResHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(117);
        if (paramView != null) {
          paramView.a(true);
        }
      } while (!localMessageForPoke.isSend());
      localMessageForPoke.setPlayed(this.a.b);
      return;
      int i = 0;
      Object localObject3;
      switch (localMessageForPoke.interactType)
      {
      default: 
        paramView = adlh.a + "/chuo_icon/chuo_icon_";
        localObject3 = adfe.a(localMessageForPoke.interactType);
        if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {
          if (localadfq.jdField_a_of_type_Float == 2.0F)
          {
            paramView = new BitmapFactory.Options();
            paramView.inSampleSize = 1;
            paramView.inMutable = true;
          }
        }
        break;
      }
      for (;;)
      {
        try
        {
          paramView = bacm.a(PokeBigResHandler.b + "/chuo_caidan/chuo_caidan_" + "01.png", paramView);
          localObject1 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), paramView, adlh.a().a(), localMessageForPoke.mFrameState, (String)localObject3, adll.a(this.a.b));
          adfe.a(this.a, (CustomFrameAnimationDrawable)localObject1);
          ((CustomFrameAnimationDrawable)localObject1).a(1);
          if (!localMessageForPoke.isSend())
          {
            if (localMessageForPoke.interactType == 5) {
              break label1661;
            }
            ((CustomFrameAnimationDrawable)localObject1).b();
          }
          ((CustomFrameAnimationDrawable)localObject1).h();
          ((CustomFrameAnimationDrawable)localObject1).a(new adfs(this, localadfq, localMessageForPoke));
          if (localMessageForPoke.interactType == 6) {
            break label1959;
          }
          if ((localMessageForPoke.interactType != 5) || (localadfq.jdField_a_of_type_Float != 2.0F)) {
            break label1670;
          }
          localadfq.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localadfq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131296648)).a();
          localadfq.jdField_c_of_type_AndroidViewView.setVisibility(0);
          paramView.a(localadfq, adll.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          paramView.setListener(this.a);
          return;
          paramView = PokeBigResHandler.c + "/chuo_motion/chuo_motion_";
          i = 35;
          break;
          paramView = PokeBigResHandler.c + "/bixin_motion/bixin_motion_";
          i = 67;
          break;
          paramView = PokeBigResHandler.c + "/zan_motion/zan_motion_";
          i = 20;
          break;
          paramView = PokeBigResHandler.c + "/xinsui_motion/xinsui_motion_";
          i = 50;
          break;
          if (localMessageForPoke.isSend())
          {
            paramView = PokeBigResHandler.c + "/666send_motion/666send_motion_";
            i = 57;
            break;
          }
          paramView = PokeBigResHandler.c + "/666receive_motion/666receive_motion_";
          continue;
          paramView = adlh.a + "/dazhao_icon/dazhao_icon_";
        }
        catch (OutOfMemoryError paramView)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, paramView.toString());
          }
          paramView = null;
          continue;
        }
        paramView = bacm.a(this.a.jdField_a_of_type_AndroidContentContext.getResources(), 2130838528);
        Object localObject1 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), paramView, adlh.a().a(), localMessageForPoke.mFrameState, (String)localObject3, adll.a(this.a.b));
        adfe.a((CustomFrameAnimationDrawable)localObject1);
        continue;
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inScaled = true;
        ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        int j;
        for (;;)
        {
          try
          {
            localObject1 = bacm.a(paramView + "01.png", (BitmapFactory.Options)localObject1);
            localObject3 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, adlh.a().a(), localMessageForPoke.mFrameState, (String)localObject3, adll.a(this.a.b));
            ((CustomFrameAnimationDrawable)localObject3).i();
            j = 40;
            if (localMessageForPoke.interactType == 2) {
              j = 30;
            }
            if ((localMessageForPoke.interactType != 4) || (localadfq.jdField_a_of_type_Float != 2.0F)) {
              break label1551;
            }
            k = 0;
            if (k < 20) {
              if (k + 1 < 10)
              {
                ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + "0" + (k + 1) + ".png");
                k += 1;
                continue;
              }
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GivingHeart", 2, localOutOfMemoryError.toString());
            }
            localObject2 = null;
            continue;
            ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + (k + 1) + ".png");
            continue;
            k = 20;
            localObject2 = localObject3;
          }
          if (k >= i) {
            break;
          }
          ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + 21 + ".png");
          k += 1;
        }
        int k = 0;
        localObject2 = localObject3;
        if (k < i)
        {
          if (k + 1 < 10) {
            ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + "0" + (k + 1) + ".png");
          }
          for (;;)
          {
            k += 1;
            break;
            ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + (k + 1) + ".png");
          }
          ((CustomFrameAnimationDrawable)localObject2).a(2);
        }
      }
      localadfq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable((Drawable)localObject2);
      localadfq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      localadfq.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localadfq.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      localadfq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if (!localMessageForPoke.mFrameState.a) {
        break;
      }
      ((CustomFrameAnimationDrawable)localObject2).d();
    } while (!QLog.isColorLevel());
    label1670:
    QLog.d("GivingHeart", 2, "[click]resume to play");
    return;
    ((CustomFrameAnimationDrawable)localObject2).c();
    label1813:
    boolean bool2;
    if (localadfq.jdField_a_of_type_Float == 2.0F)
    {
      if (localMessageForPoke.interactType == 2)
      {
        adlh.a().a(1);
        adlh.a().a(2, 1500L, localMessageForPoke.isSend());
      }
    }
    else if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType == 0))
    {
      paramView = this.a;
      localObject2 = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
      bool2 = localMessageForPoke.isSend();
      if (localadfq.jdField_a_of_type_Float != 2.0F) {
        break label1953;
      }
    }
    label1953:
    for (boolean bool1 = true;; bool1 = false)
    {
      adfe.a(paramView, (Activity)localObject2, bool2, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GivingHeart", 2, "[click]start to play");
      return;
      if (localMessageForPoke.interactType == 3)
      {
        adlh.a().a(4);
        adlh.a().a(5, 700L);
        break label1813;
      }
      if (localMessageForPoke.interactType != 4) {
        break label1813;
      }
      adlh.a().a(13);
      adlh.a().a(14, 800L);
      break label1813;
    }
    label1959:
    if ((PokeBigResHandler.a) && (!localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a()))
    {
      paramView = localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      localObject2 = this.a.jdField_a_of_type_AndroidContentContext;
      if (!localMessageForPoke.isSend())
      {
        bool1 = true;
        label2002:
        paramView.a((Context)localObject2, bool1, adll.a(this.a.b), localadfq.jdField_a_of_type_Float);
      }
    }
    else
    {
      paramView = localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (localMessageForPoke.isSend()) {
        break label2197;
      }
      bool1 = true;
      label2042:
      paramView.setParams(bool1);
      paramView = localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (localMessageForPoke.isSend()) {
        break label2203;
      }
    }
    label2197:
    label2203:
    for (bool1 = true;; bool1 = false)
    {
      paramView.setMirror(bool1);
      localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
      localadfq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      localadfq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      localadfq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      localadfq.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localadfq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localadfq.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new adft(this, localadfq, localMessageForPoke));
      if (localMessageForPoke.mUnlimitedState.a) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("fangdazhao", 2, "[click]start to play");
      }
      localadfq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.c();
      return;
      bool1 = false;
      break label2002;
      bool1 = false;
      break label2042;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adfr
 * JD-Core Version:    0.7.0.1
 */