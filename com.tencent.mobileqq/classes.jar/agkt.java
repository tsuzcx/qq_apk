import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie.7;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class agkt
  extends BaseChatPie
{
  agvb jdField_a_of_type_Agvb;
  alkl jdField_a_of_type_Alkl = new agkx(this);
  private almw jdField_a_of_type_Almw = new agkw(this);
  protected alsi a;
  public bhpy a;
  private Observer jdField_a_of_type_JavaUtilObserver = new agkz(this);
  private Dialog g;
  private TextView l;
  
  public agkt(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Alsi = new agla(this);
  }
  
  private void bs()
  {
    almv localalmv = (almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    DiscussionInfo localDiscussionInfo = localalmv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localDiscussionInfo.discussionName;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localDiscussionInfo.uin, this.jdField_e_of_type_AndroidWidgetTextView);
    }
    if (localalmv.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bt();
    }
  }
  
  private void bt()
  {
    if ((this.g != null) && (this.g.isShowing())) {}
    almv localalmv;
    Object localObject1;
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          return;
          localalmv = (almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localalmv.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DiscussionManager's discToTroopCache doesn't contain discussionUIN :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
        localObject1 = (String[])localalmv.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((localObject1 == null) || (localObject1.length < 2));
      str1 = localObject1[0];
      str2 = localObject1[1];
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    for (;;)
    {
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130842097);
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = bdda.b((Bitmap)localObject1, 10.0F, 140, 140);
          this.g = bdcd.a(this.jdField_a_of_type_AndroidContentContext, (Bitmap)localObject2, bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2) + alpo.a(2131703717), alpo.a(2131703716) + str1, this.jdField_a_of_type_AndroidContentContext.getString(2131720083), null, new agkv(this, str1), null);
          if ((this.g != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
            this.g.show();
          }
          localalmv.a.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject2;
          break label308;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject1 = null;
      }
      label308:
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(localOutOfMemoryError1));
        localObject2 = localObject1;
      }
    }
  }
  
  private void bu()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
  
  private void bv()
  {
    Intent localIntent = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
    localIntent.putExtra("param_is_pop_up_style", true);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 6001);
    if (super.f() == 21) {
      localIntent.putExtra("param_troop_send_apollo_msg", true);
    }
  }
  
  private void f(String paramString)
  {
    Intent localIntent = aekt.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
  }
  
  public void H()
  {
    if ((this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing())) {
      this.jdField_a_of_type_Bhpy.dismiss();
    }
    this.jdField_a_of_type_Bhpy = null;
    if (this.jdField_a_of_type_Bblx != null) {
      this.jdField_a_of_type_Bblx.a();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      abot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    super.H();
  }
  
  public void L()
  {
    if (!this.N)
    {
      aubr localaubr = (aubr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localaubr != null) {
        localaubr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
    super.L();
  }
  
  public void P()
  {
    super.P();
    bs();
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.u();
    return bdic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "DiscussChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    String str1;
    Object localObject;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
      case 6001: 
        do
        {
          return;
          str1 = paramIntent.getExtras().getString("member_uin");
          localObject = paramIntent.getExtras().getString("member_display_name");
          if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_Alhk == null)) {
            break;
          }
        } while ("0".equals(str1));
        paramIntent = bdbt.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str1);
        if (TextUtils.isEmpty(paramIntent)) {
          paramIntent = (Intent)localObject;
        }
        break;
      }
    }
    for (;;)
    {
      paramIntent = new StringBuilder("@").append(paramIntent);
      this.jdField_a_of_type_Alhk.a.peerUin = str1;
      this.jdField_a_of_type_Alhk.a.atNickName = paramIntent.toString();
      this.jdField_a_of_type_Alhk.a.inputText = baiy.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      a(this.jdField_a_of_type_Alhk);
      paramInt1 = 0;
      String str2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Alhk.a.inputText))
      {
        paramInt2 = 2;
        paramInt1 = paramInt2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Alhk.b))
        {
          if (this.jdField_a_of_type_Alhk.d == 0) {
            paramInt1 = 6;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          paramInt2 = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          str2 = "" + this.jdField_a_of_type_Alhk.a.actionId;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Alhk.b)) {
            break label463;
          }
        }
      }
      label463:
      for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_Alhk.b)
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, paramInt1, paramInt2, new String[] { str2, paramIntent, this.jdField_a_of_type_Alhk.a.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Alhk.d != 1) {
          break;
        }
        paramInt1 = 7;
        break;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Alhk.b))
        {
          paramInt1 = 3;
          break;
        }
        if (this.jdField_a_of_type_Alhk.d == 0)
        {
          paramInt1 = 4;
          break;
        }
        if (this.jdField_a_of_type_Alhk.d != 1) {
          break;
        }
        paramInt1 = 5;
        break;
      }
      a(str1, (String)localObject, true);
      return;
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringExtra("result"); (paramIntent != null) && (!paramIntent.equals("")); paramIntent = "")
      {
        if (bdee.d(a()))
        {
          ((almt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), paramIntent);
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131694829), 0).b(a());
        return;
        if (this.jdField_a_of_type_Yqf == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Yqf.a();
        if (localObject == null) {
          break;
        }
        ((TroopGiftPanel)localObject).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
        return;
        if (paramInt2 != 0) {
          break;
        }
        switch (paramInt1)
        {
        default: 
          return;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean) {
          break;
        }
        BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
        return;
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_AndroidWidgetTextView);
    }
    super.a(paramConfiguration);
  }
  
  public void a(View paramView)
  {
    bu();
  }
  
  public void a(SessionInfo paramSessionInfo, atvk paramatvk, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 3000)
    {
      paramCharSequence = new ArrayList();
      paramCharSequence = bceh.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramCharSequence);
    }
    for (;;)
    {
      super.a(paramSessionInfo, paramatvk, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "genDiscussTitle, name == null");
      }
    }
    int i;
    do
    {
      return;
      i = ((almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString1 = new baig(paramString1, 1);
      if (i > 0) {
        break;
      }
      paramTextView.setText(paramString1);
    } while (!AppSetting.c);
    paramTextView.setContentDescription(paramTextView.getText().toString());
    a().setTitle(paramTextView.getText());
    return;
    if (this.jdField_l_of_type_AndroidWidgetTextView == null) {
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365318));
    }
    this.jdField_l_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    if (this.jdField_l_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.jdField_l_of_type_Boolean) {
          break label235;
        }
      }
    }
    label235:
    for (boolean bool = true;; bool = false)
    {
      paramString2.a(bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramTextView.setText(paramString1);
      if (!AppSetting.c) {
        break;
      }
      paramTextView.setContentDescription(paramTextView.getText().toString());
      a().setTitle(paramTextView.getText());
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean) {
        BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_At_Me_DISC", 2, "memUin:" + paramString1 + " displayName:" + bdal.a(paramString2) + " isRemoveOldAtFlag:" + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean)
    {
      if ("0".equals(paramString1))
      {
        BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.i = paramString1;
      this.jdField_e_of_type_Int = 131077;
      e(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(alpo.a(2131703713));
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new DiscussChatPie.6(this), 200L);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new DiscussChatPie.7(this, paramBoolean, paramString1, paramString2), 300L);
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.I) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_Aelz.getCount() > 0)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((aemc)this.jdField_a_of_type_Abpd.a).a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Bblx != null)
      {
        if (this.jdField_a_of_type_Bblx.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Abpd.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Bblx.jdField_a_of_type_Long, this.jdField_a_of_type_Bblx.jdField_b_of_type_Long, this.jdField_a_of_type_Bblx.c, this.jdField_a_of_type_Abpd);
          this.jdField_a_of_type_Bblx.j();
          return true;
        }
        this.jdField_a_of_type_Abpd.e = false;
        this.jdField_a_of_type_Abpd.f = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Abpd);
        return true;
      }
      this.jdField_a_of_type_Abpd.e = false;
      this.jdField_a_of_type_Abpd.f = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Abpd);
      return true;
    }
    g(false);
    return true;
  }
  
  public void aY()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  public void ai()
  {
    br();
    super.ai();
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Alsi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Almw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
    ((askw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Almw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    ((askw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bdbt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
  }
  
  public void bq()
  {
    super.bq();
    this.jdField_a_of_type_Afag.a(this);
  }
  
  protected void br()
  {
    if (this.jdField_a_of_type_Bblx == null) {
      this.jdField_a_of_type_Bblx = new bblx();
    }
    this.jdField_a_of_type_Bblx.h();
    this.jdField_a_of_type_Bblx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aelz, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Bblx != null) && (this.jdField_a_of_type_Agwa.a() != 9)) {
      this.jdField_a_of_type_Bblx.e();
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    aY();
  }
  
  public void j()
  {
    super.j();
    aguu localaguu = new aguu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agwa, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aelz);
    aguw localaguw = new aguw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agwa, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aelz);
    this.jdField_a_of_type_Agvb = new agvb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agwa, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Agwa.a(localaguu);
    this.jdField_a_of_type_Agwa.a(localaguw);
    this.jdField_a_of_type_Agwa.a(this.jdField_a_of_type_Agvb);
  }
  
  public void n(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "disscuss Uin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    lpq locallpq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
    if (locallpq != null)
    {
      if (!locallpq.a) {
        break label139;
      }
      azmj.b(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
      super.n(paramInt);
      return;
      label139:
      azmj.b(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bblx != null) && (this.jdField_a_of_type_Bblx.d()) && (this.jdField_a_of_type_Aelz != null)) {
      this.jdField_a_of_type_Bblx.b(0);
    }
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean = true;
      bv();
    }
    boolean bool;
    do
    {
      return;
      DiscussionInfo localDiscussionInfo = ((almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bool = false;
      if (localDiscussionInfo != null) {
        bool = localDiscussionInfo.isDiscussHrMeeting();
      }
    } while ((bool) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() == 0) || (paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '@') && (paramCharSequence.charAt(paramInt1) != 65312)) || (this.s) || (((afbe)a(27)).a));
    bv();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131369509) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void r()
  {
    this.d.setOnClickListener(new agku(this));
    if (mdj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.d.setVisibility(0);
      this.d.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698866));
    }
    for (;;)
    {
      aY();
      return;
      this.d.setVisibility(8);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {}
    label173:
    for (;;)
    {
      return;
      if ((paramObject instanceof bbla))
      {
        paramObservable = (bbla)paramObject;
        if (paramObservable != null)
        {
          if (paramObservable.jdField_a_of_type_Int != bbkz.jdField_a_of_type_Int) {
            break label127;
          }
          a(paramObservable.c, paramObservable.a(), paramObservable.d, null);
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label173;
        }
        paramObservable = (MessageForText)paramObject;
        if (!paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in DiscussChatPie.update()");
        }
        bdvp.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
        return;
        label127:
        if ((paramObservable.jdField_a_of_type_Int == bbkz.b) && (this.f != null))
        {
          ((RelativeLayout.LayoutParams)this.f.getLayoutParams()).addRule(2, paramObservable.b);
          continue;
          if (!(paramObject instanceof Integer)) {}
        }
      }
    }
  }
  
  public void v()
  {
    bk();
  }
  
  public void x()
  {
    bu();
  }
  
  public void z()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849497, 2130849498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkt
 * JD-Core Version:    0.7.0.1
 */