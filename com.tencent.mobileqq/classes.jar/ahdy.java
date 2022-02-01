import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
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
import org.jetbrains.annotations.NotNull;

class ahdy
  implements View.OnClickListener
{
  private ahdy(ahdk paramahdk) {}
  
  @NotNull
  private CustomFrameAnimationDrawable a(ahdx paramahdx, MessageForPoke paramMessageForPoke, String paramString1, int paramInt, String paramString2)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inScaled = true;
    ((BitmapFactory.Options)localObject1).inSampleSize = 1;
    ((BitmapFactory.Options)localObject1).inMutable = true;
    try
    {
      localObject1 = bhmq.a(paramString1 + "01.png", (BitmapFactory.Options)localObject1);
      paramString2 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, ahnp.a().a(), paramMessageForPoke.mFrameState, paramString2, ahnt.a(this.a.b));
      paramString2.i();
      i = 40;
      if (paramMessageForPoke.interactType == 2) {
        i = 30;
      }
      if ((paramMessageForPoke.interactType == 4) && (paramahdx.jdField_a_of_type_Float == 2.0F))
      {
        j = 0;
        for (;;)
        {
          if (j >= 20) {
            break label265;
          }
          if (j + 1 >= 10) {
            break;
          }
          paramString2.a(j, i, paramString1 + "0" + (j + 1) + ".png");
          j += 1;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      int i;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, localOutOfMemoryError.toString());
        }
        Object localObject2 = null;
        continue;
        paramString2.a(j, i, paramString1 + (j + 1) + ".png");
      }
      label265:
      int j = 20;
      while (j < paramInt)
      {
        paramString2.a(j, i, paramString1 + 21 + ".png");
        j += 1;
        continue;
        j = 0;
        if (j < paramInt)
        {
          if (j + 1 < 10) {
            paramString2.a(j, i, paramString1 + "0" + (j + 1) + ".png");
          }
          for (;;)
          {
            j += 1;
            break;
            paramString2.a(j, i, paramString1 + (j + 1) + ".png");
          }
        }
      }
    }
    return paramString2;
  }
  
  private void a(ahdx paramahdx, MessageForPoke paramMessageForPoke)
  {
    boolean bool2 = true;
    UnlimitedBladeWorks localUnlimitedBladeWorks;
    if ((PokeBigResHandler.a) && (!paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a()))
    {
      localUnlimitedBladeWorks = paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      Context localContext = this.a.jdField_a_of_type_AndroidContentContext;
      if (!paramMessageForPoke.isSend())
      {
        bool1 = true;
        localUnlimitedBladeWorks.a(localContext, bool1, ahnt.a(this.a.b), paramahdx.jdField_a_of_type_Float);
      }
    }
    else
    {
      localUnlimitedBladeWorks = paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (paramMessageForPoke.isSend()) {
        break label219;
      }
      bool1 = true;
      label80:
      localUnlimitedBladeWorks.setParams(bool1);
      localUnlimitedBladeWorks = paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (paramMessageForPoke.isSend()) {
        break label224;
      }
    }
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localUnlimitedBladeWorks.setMirror(bool1);
      paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
      paramahdx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      paramahdx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramahdx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramahdx.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new ahdz(this, paramahdx, paramMessageForPoke));
      if (!paramMessageForPoke.mUnlimitedState.a)
      {
        if (QLog.isColorLevel()) {
          QLog.i("fangdazhao", 2, "[click]start to play");
        }
        paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.c();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  private void a(ahdx paramahdx, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    boolean bool1 = true;
    if (a(paramahdx, paramMessageForPoke)) {}
    do
    {
      return;
      paramahdx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramCustomFrameAnimationDrawable);
      paramahdx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      paramahdx.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      paramahdx.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if (!paramMessageForPoke.mFrameState.a) {
        break;
      }
      paramCustomFrameAnimationDrawable.d();
    } while (!QLog.isColorLevel());
    QLog.d("GivingHeart", 2, "[click]resume to play");
    return;
    paramCustomFrameAnimationDrawable.c();
    label141:
    Activity localActivity;
    boolean bool2;
    if (paramahdx.jdField_a_of_type_Float == 2.0F)
    {
      if (paramMessageForPoke.interactType == 2)
      {
        ahnp.a().a(1);
        ahnp.a().a(2, 1500L, paramMessageForPoke.isSend());
      }
    }
    else if ((paramMessageForPoke.interactType == 1) || (paramMessageForPoke.interactType == 0))
    {
      paramCustomFrameAnimationDrawable = this.a;
      localActivity = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
      bool2 = paramMessageForPoke.isSend();
      if (paramahdx.jdField_a_of_type_Float != 2.0F) {
        break label271;
      }
    }
    for (;;)
    {
      ahdk.a(paramCustomFrameAnimationDrawable, localActivity, bool2, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GivingHeart", 2, "[click]start to play");
      return;
      if (paramMessageForPoke.interactType == 3)
      {
        ahnp.a().a(4);
        ahnp.a().a(5, 700L);
        break label141;
      }
      if (paramMessageForPoke.interactType != 4) {
        break label141;
      }
      ahnp.a().a(13);
      ahnp.a().a(14, 800L);
      break label141;
      label271:
      bool1 = false;
    }
  }
  
  private boolean a(ahdx paramahdx, MessageForPoke paramMessageForPoke)
  {
    if ((paramMessageForPoke.interactType == 5) && (paramahdx.jdField_a_of_type_Float == 2.0F))
    {
      paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramahdx.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramMessageForPoke = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362291)).a();
      paramahdx.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramMessageForPoke.a(paramahdx, ahnt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      paramMessageForPoke.setListener(this.a);
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, ahdx paramahdx, MessageForPoke paramMessageForPoke)
  {
    if (126 == paramMessageForPoke.interactType)
    {
      if (b(paramView, paramahdx, paramMessageForPoke)) {
        return true;
      }
      return c(paramahdx, paramMessageForPoke);
    }
    return false;
  }
  
  private void b(ahdx paramahdx, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    paramCustomFrameAnimationDrawable.a(1);
    if (!paramMessageForPoke.isSend())
    {
      if (paramMessageForPoke.interactType == 5) {
        break label43;
      }
      paramCustomFrameAnimationDrawable.b();
    }
    for (;;)
    {
      paramCustomFrameAnimationDrawable.h();
      paramCustomFrameAnimationDrawable.a(new ahea(this, paramahdx, paramMessageForPoke));
      return;
      label43:
      paramCustomFrameAnimationDrawable.a(2);
    }
  }
  
  private boolean b(ahdx paramahdx, MessageForPoke paramMessageForPoke)
  {
    boolean bool = false;
    if (!PokeBigResHandler.a)
    {
      paramahdx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      paramahdx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, anzj.a(2131704169), 0).a();
      paramahdx = (PokeBigResHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(117);
      if (paramahdx != null) {
        paramahdx.a(true);
      }
      if (paramMessageForPoke.isSend()) {
        paramMessageForPoke.setPlayed(this.a.b);
      }
      bool = true;
    }
    return bool;
  }
  
  private boolean b(View paramView, ahdx paramahdx, MessageForPoke paramMessageForPoke)
  {
    boolean bool = false;
    int i;
    if (paramView.findViewById(2131378405).getVisibility() == 0)
    {
      i = 1;
      if (i == 0) {
        break label237;
      }
      if (!ahnt.c.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        ahnt.c.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      if (!ahnt.d.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        ahnt.d.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      if (!ahnt.b.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        ahnt.b.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      paramahdx.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramahdx.b.setVisibility(8);
      paramView = (VasQuickUpdateManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
      paramView.downloadItem(21L, "poke.item.effect." + paramMessageForPoke.subId, "getbubbleview");
      paramView.downloadItem(21L, "poke.item.res." + paramMessageForPoke.subId, "getbubbleview");
      paramView.addCallBacker(this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      bool = true;
    }
    label237:
    while (ahnt.a("bubble", paramMessageForPoke.subId))
    {
      return bool;
      i = 0;
      break;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, anzj.a(2131704176), 0).a();
    return true;
  }
  
  private boolean c(ahdx paramahdx, MessageForPoke paramMessageForPoke)
  {
    if (angi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d == 1) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        anfz.a(this.a.b, "vas_poke", true);
        if (QLog.isColorLevel()) {
          QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in click.");
        }
      }
      ahnt.a(this.a.b, this.a.jdField_a_of_type_AndroidContentContext, paramahdx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramahdx, paramMessageForPoke.subId, "bubble");
      return true;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getContext() instanceof ChatHistoryActivity)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      agej.n = true;
      if (!this.a.a())
      {
        ahdx localahdx = (ahdx)agej.a(paramView);
        MessageForPoke localMessageForPoke = (MessageForPoke)localahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "poke onClick() is called, type:" + localMessageForPoke.interactType);
        }
        if ((!a(paramView, localahdx, localMessageForPoke)) && (!b(localahdx, localMessageForPoke)))
        {
          Object localObject2 = this.a.a(localMessageForPoke);
          Object localObject1 = ((ahdw)localObject2).jdField_a_of_type_JavaLangString;
          int i = ((ahdw)localObject2).jdField_a_of_type_Int;
          localObject2 = ahdk.a(localMessageForPoke.interactType);
          if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {}
          for (localObject1 = ahdk.a(this.a, localahdx, localMessageForPoke, (String)localObject2);; localObject1 = a(localahdx, localMessageForPoke, (String)localObject1, i, (String)localObject2))
          {
            b(localahdx, localMessageForPoke, (CustomFrameAnimationDrawable)localObject1);
            if (localMessageForPoke.interactType == 6) {
              break label231;
            }
            a(localahdx, localMessageForPoke, (CustomFrameAnimationDrawable)localObject1);
            break;
          }
          label231:
          a(localahdx, localMessageForPoke);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdy
 * JD-Core Version:    0.7.0.1
 */