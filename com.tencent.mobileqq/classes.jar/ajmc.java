import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.utils.TroopAioADManager;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ajmc
  implements Animation.AnimationListener
{
  public ajmc(TroopFeedsCenterLogic paramTroopFeedsCenterLogic) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.i = false;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
    if (this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {}
        TroopFeedsCenterLogic.a(this.a);
        this.a.notifyObservers(Integer.valueOf(123322));
        this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.d(true);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if ((!this.a.k) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null))
      {
        if (this.a.j) {
          this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841243);
        }
      }
      else if (this.a.e)
      {
        if (NetworkUtil.d(BaseApplication.getContext())) {
          break label328;
        }
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 1, ((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429899), 1).b(((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 5.0F));
      }
    }
    label328:
    label875:
    for (;;)
    {
      return;
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841229);
        break;
      }
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841228);
      break;
      TroopAioADManager localTroopAioADManager = (TroopAioADManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if (!TextUtils.isEmpty(str))
      {
        TroopAioTopADInfo localTroopAioTopADInfo = localTroopAioADManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        Object localObject;
        if (localTroopAioTopADInfo != null)
        {
          if (!TextUtils.isEmpty(localTroopAioTopADInfo.jumpUrl)) {
            break label511;
          }
          paramAnimation = localTroopAioTopADInfo.backgroundUrl;
          localObject = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), paramAnimation);
          if (localObject == null) {
            break label520;
          }
          ((JumpAction)localObject).b();
        }
        for (;;)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_Promote", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localTroopAioTopADInfo.adId + "", "", "");
          localTroopAioADManager.a(str);
          this.a.d = false;
          return;
          label511:
          paramAnimation = localTroopAioTopADInfo.jumpUrl;
          break;
          if (paramAnimation.startsWith("http"))
          {
            localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramAnimation));
            ((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
          }
        }
        if (this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
        {
          if ((this.a.jdField_a_of_type_AndroidViewView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null))
          {
            this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
            TroopFeedsCenterLogic.b(this.a);
            this.a.notifyObservers(Integer.valueOf(123322));
            if ((this.a.c) && (this.a.jdField_a_of_type_AndroidViewView != null) && ((this.a.jdField_a_of_type_AndroidViewView instanceof TroopAioFeedsCenterView)))
            {
              if (!this.a.d) {
                break label777;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b();
            }
          }
          if ((!this.a.k) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null))
          {
            if (!this.a.j) {
              break label836;
            }
            this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841244);
          }
          for (;;)
          {
            if (this.a.jdField_a_of_type_AndroidViewView == null) {
              break label875;
            }
            this.a.jdField_a_of_type_AndroidViewView.requestFocus();
            return;
            if (this.a.f)
            {
              ((TroopAioFeedsCenterView)this.a.jdField_a_of_type_AndroidViewView).a();
              this.a.f = false;
              break;
            }
            this.a.c = false;
            ((TroopAioFeedsCenterView)this.a.jdField_a_of_type_AndroidViewView).a(true);
            break;
            if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
              this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841231);
            } else {
              this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841230);
            }
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.i = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmc
 * JD-Core Version:    0.7.0.1
 */