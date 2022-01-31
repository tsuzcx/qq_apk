import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JDHongbaoActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.1;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.2;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActInfo;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActRsp;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActShowInfo;

public class ajrq
  extends bbqu
  implements aczj, aive, View.OnClickListener
{
  public PopupWindow a;
  private Runnable a;
  public WeakReference<BaseChatPie> a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public ajrq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ChatApolloViewListener.3(this);
    if (((paramBaseChatPie instanceof aeoo)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof aeoe)) || ((paramBaseChatPie instanceof aeqd))) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[doJDRedPackReport], key:" + paramInt + ",app:" + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    ((nri)paramQQAppInterface.a(88)).a(paramInt, "", "", "", "", 0L, false);
  }
  
  private void a(Activity paramActivity, qqshop_act.SQQSHPActShowInfo paramSQQSHPActShowInfo, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramSQQSHPActShowInfo == null)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, JDHongbaoActivity.class);
    localIntent.putExtra("jd_hb_is_check_delay", paramBoolean);
    localIntent.putExtra("jd_hb_title", paramSQQSHPActShowInfo.title.get());
    localIntent.putExtra("jd_hb_subtitle", paramSQQSHPActShowInfo.subtext.get());
    localIntent.putExtra("jd_hb_detail_text", paramSQQSHPActShowInfo.gift_text.get());
    localIntent.putExtra("jd_hongbao_tips", paramSQQSHPActShowInfo.act_text.get());
    localIntent.putExtra("jd_hb_btn_text", paramSQQSHPActShowInfo.btn_text.get());
    localIntent.putExtra("jd_hb_detail_url", paramSQQSHPActShowInfo.detail_url.get());
    localIntent.putExtra("jd_hb_btn_url", paramSQQSHPActShowInfo.btn_url.get());
    localIntent.putExtra("jd_hb_logo_url", paramSQQSHPActShowInfo.logo.get());
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[initJDRedPackEntry],mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      return;
      localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localObject == null) || (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_Boolean) || (((BaseChatPie)localObject).a() == null));
    ((BaseChatPie)localObject).a().a(this);
    nri localnri = (nri)((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
    String str = Integer.toString(nqq.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
    if ((((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {}
    for (Object localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject = "")
    {
      localnri.a(134247330, "", str, (String)localObject, "", 0L, false);
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onEggAnimStart], mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((this.jdField_a_of_type_Boolean) || (localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = true;
    nqq localnqq = (nqq)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
    ((bbqp)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(localnqq.b);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[addJDEndView],imgUrl:" + paramString);
    }
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(BaseApplicationImpl.getContext(), 2131558616, null);
    if (localLinearLayout == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "errInfo->inflate err.");
      }
    }
    do
    {
      do
      {
        return;
        Object localObject = (ImageView)localLinearLayout.findViewById(2131368745);
        TextView localTextView = (TextView)localLinearLayout.findViewById(2131368606);
        ((ImageView)localObject).setOnClickListener(this);
        localTextView.setOnClickListener(this);
        localObject = (URLImageView)localLinearLayout.findViewById(2131368492);
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
          if ((localObject != null) && (paramString != null)) {
            ((URLImageView)localObject).setImageDrawable(paramString);
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
          this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localLinearLayout, -1, -1, false);
        }
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      paramString = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString == null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(paramString.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO);
    a(134247341, paramString.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      this.b = true;
      if (paramInt == 1) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.c = paramBoolean;
        return;
      }
    }
    this.b = false;
    this.c = false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onEggAnimEnd], mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    nqq localnqq = (nqq)((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "currentDelay:" + localnqq.c);
    }
    Object localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    if (localnqq.c > 0)
    {
      ((MqqHandler)localObject).postDelayed(this.jdField_a_of_type_JavaLangRunnable, localnqq.c * 1000);
      return;
    }
    c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[removeJDRedPackEntry]");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.a() == null));
    localBaseChatPie.a().d();
  }
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new ChatApolloViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  protected void onChangeUserApolloStatus(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "TROOP, [onChangeUserApolloStatus], result:" + paramBoolean + ",data:" + paramObject);
    }
    if ((!paramBoolean) || (paramObject == null)) {}
    label50:
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          break label50;
          do
          {
            return;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
        if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) {
          localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(paramBoolean, paramObject);
        }
        MqqHandler localMqqHandler = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localMqqHandler != null) {
          localMqqHandler.obtainMessage(51).sendToTarget();
        }
        paramObject = (Pair)paramObject;
      } while (!((String)paramObject.first).equals(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      QLog.i("ChatApolloViewListener", 1, "my cmshow status has changed, status:" + paramObject.second);
      if ((2 == ((Integer)paramObject.second).intValue()) || (((Integer)paramObject.second).intValue() == 0))
      {
        ajfa.a(localBaseChatPie.a(), "cmshow_status", true);
        return;
      }
    } while (1 != ((Integer)paramObject.second).intValue());
    ajfa.a(localBaseChatPie.a(), "cmshow_status", false);
    ApolloGameUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "request user game list");
    }
    ((airv)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211)).e();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131367587: 
            if (localBaseChatPie.c == null)
            {
              int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865);
              localBaseChatPie.c = new bcpq(localBaseChatPie.jdField_a_of_type_AndroidContentContext, i);
            }
            localBaseChatPie.c.a(ajyc.a(2131701570));
            localBaseChatPie.c.show();
            c();
            paramView = (nqq)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
            localObject = (bbqp)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
          }
        } while ((paramView == null) || (localObject == null));
        ((bbqp)localObject).a(paramView.b, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        Object localObject = (nri)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
        String str = Integer.toString(nqq.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
        if ((localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {}
        for (paramView = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; paramView = "")
        {
          ((nri)localObject).a(134247331, "", str, paramView, Integer.toString(nqq.b()), 0L, false);
          return;
        }
      } while (this.jdField_a_of_type_AndroidWidgetPopupWindow == null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      a(134247343, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    } while (this.jdField_a_of_type_AndroidWidgetPopupWindow == null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    a(134247343, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void onJDCheckRsp(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onJDCheckRsp],result:" + paramBoolean + ",mIsAIOFinish:" + this.b + ",mChatPieRef:" + this.jdField_a_of_type_JavaLangRefWeakReference);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      do
      {
        return;
        paramObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!paramBoolean) {
          break;
        }
      } while (this.b);
      d();
      return;
    } while ((paramObject == null) || (this.b));
    a(134247332, paramObject.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void onJDHongbaoRsp(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onJDHongbaoRsp],result:" + paramBoolean + ",data:" + paramObject + ",mIsAIOFinish:" + this.b);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      Object localObject;
      BaseChatPie localBaseChatPie;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  if ((localObject != null) && (((BaseChatPie)localObject).c != null)) {
                    ((BaseChatPie)localObject).c.dismiss();
                  }
                  if ((!paramBoolean) && (!this.b))
                  {
                    bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131701572), 1).a();
                    return;
                  }
                } while (paramObject == null);
                if ((paramObject instanceof qqshop_act.SQQSHPActRsp)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("ChatApolloViewListener", 2, "errInfo->Wrong data object.");
              return;
              paramObject = (qqshop_act.SQQSHPActRsp)paramObject;
              localObject = paramObject.act_show_info;
            } while ((localObject == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
            localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            int i = paramObject.code.get();
            if (QLog.isColorLevel()) {
              QLog.d("ChatApolloViewListener", 2, "errCode:" + i);
            }
            switch (i)
            {
            }
          } while (this.b);
          bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131701571), 1).a();
          return;
        } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.b));
        a(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (qqshop_act.SQQSHPActShowInfo)localObject, false);
        return;
      } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.b));
      a(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (qqshop_act.SQQSHPActShowInfo)localObject, true);
      return;
    } while ((this.b) || (paramObject.act_info == null));
    a(paramObject.act_info.fail_pic.get());
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!bahh.b(paramString))) {
      QLog.w("ChatApolloViewListener", 1, "longTouch uin = null");
    }
    label23:
    BaseChatPie localBaseChatPie;
    Object localObject;
    do
    {
      do
      {
        do
        {
          break label23;
          do
          {
            return;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localBaseChatPie.jdField_a_of_type_Aitz == null) || (!localBaseChatPie.jdField_a_of_type_Aitz.a()) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
        if (!bbev.g(localBaseChatPie.jdField_a_of_type_AndroidContentContext))
        {
          ApolloItemBuilder.a(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690064), 1, localBaseChatPie.jdField_a_of_type_AndroidContentContext);
          return;
        }
        localObject = ajfj.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject == null) {
          break;
        }
        localObject = ((ajfg)localObject).a();
      } while ((localObject != null) && (((ajfh)localObject).a()));
      localObject = (airz)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_avatar", localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      if (((airz)localObject).b(paramString) != 1)
      {
        ApolloItemBuilder.a(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690119), 1, localBaseChatPie.jdField_a_of_type_AndroidContentContext);
        return;
      }
    } while (airz.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString) == 2);
    if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      localObject = bbcl.m(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onLoncClick uin = " + paramString + " ,nickName =" + (String)localObject);
      }
      localBaseChatPie.jdField_a_of_type_Aitz.b();
      Intent localIntent = new Intent(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ApolloGuestsStateActivity.class);
      localIntent.putExtra("extra_guest_uin", paramString);
      localIntent.putExtra("extra_guest_nick", (String)localObject);
      localIntent.putExtra("extra_guest_from", ApolloUtil.b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
      localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
      return;
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        localObject = bbcl.e(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString);
      } else if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        localObject = bbcl.b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, true);
      } else {
        localObject = "";
      }
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    int i;
    do
    {
      boolean bool;
      int j;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localBaseChatPie.jdField_a_of_type_Aitz == null) || (!localBaseChatPie.jdField_a_of_type_Aitz.a()) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
            if (paramInt == 7)
            {
              localObject = (airv)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
              if (((airv)localObject).jdField_a_of_type_Int != -1)
              {
                ApolloGameUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((airv)localObject).jdField_a_of_type_Int, 0L, 0, "", 321, null);
                return;
              }
            }
            Object localObject = ajfj.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (localObject != null) {
              ((ajes)localObject).a(ajfj.a(paramInt), null, paramString);
            }
            paramString = (ajfg)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
          } while (paramString == null);
          paramString = paramString.a();
        } while (paramString == null);
        i = paramString.a();
        paramString = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp", 0);
        bool = paramString.getBoolean("is_add_new_game" + localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        j = paramString.getInt("new_added_game_id" + localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
        if (9 == paramInt) {
          VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "click_action_hotspot", ApolloUtil.b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
        }
        if (i != 1) {
          break;
        }
      } while ((!bool) || (-1 == j));
      VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "avatar_clk_togame", ApolloUtil.b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 1, new String[] { String.valueOf(j) });
      paramString.edit().remove("is_add_new_game" + localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).commit();
      return;
    } while ((i != 2) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null));
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.i();
  }
  
  protected void onQueryUserApolloAction(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      airz.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onQueryUserApolloAction mChatPieRef == null return");
      }
    }
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null));
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b(paramBoolean, paramObject);
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[TraceReport onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseChatPie == null) {
      return;
    }
    ajfg localajfg = (ajfg)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
    if (localajfg.a() != null) {
      ajlq.a(ajfj.b(localajfg.a().e), 100, 0, new Object[] { "onSurfaceReady" });
    }
    if (!localBaseChatPie.jdField_a_of_type_Aitz.jdField_a_of_type_Boolean)
    {
      ajou.a("TraceReport_initApolloSurfaceView_PreLoadJS");
      ThreadManager.excute(new ChatApolloViewListener.1(this), 192, null, true);
      return;
    }
    QLog.i("ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady mPreloadEngine:true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajrq
 * JD-Core Version:    0.7.0.1
 */