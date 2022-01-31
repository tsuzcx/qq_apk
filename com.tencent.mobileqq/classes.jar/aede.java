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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
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

public class aede
  extends BaseChatPie
{
  aend jdField_a_of_type_Aend;
  ajey jdField_a_of_type_Ajey = new aedi(this);
  private ajhi jdField_a_of_type_Ajhi = new aedh(this);
  protected ajmm a;
  public begr a;
  private Observer jdField_a_of_type_JavaUtilObserver = new aedk(this);
  private Dialog g;
  private TextView l;
  
  public aede(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Ajmm = new aedl(this);
  }
  
  private void bn()
  {
    ajhh localajhh = (ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    DiscussionInfo localDiscussionInfo = localajhh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localDiscussionInfo.discussionName;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localDiscussionInfo.uin, this.jdField_e_of_type_AndroidWidgetTextView);
    }
    if (localajhh.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bo();
    }
  }
  
  private void bo()
  {
    if ((this.g != null) && (this.g.isShowing())) {}
    ajhh localajhh;
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
          localajhh = (ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localajhh.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DiscussionManager's discToTroopCache doesn't contain discussionUIN :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
        localObject1 = (String[])localajhh.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((localObject1 == null) || (localObject1.length < 2));
      str1 = localObject1[0];
      str2 = localObject1[1];
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    for (;;)
    {
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130841851);
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = bacm.b((Bitmap)localObject1, 10.0F, 140, 140);
          this.g = babr.a(this.jdField_a_of_type_AndroidContentContext, (Bitmap)localObject2, babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2) + ajjy.a(2131637549), ajjy.a(2131637548) + str1, this.jdField_a_of_type_AndroidContentContext.getString(2131653656), null, new aedg(this, str1), null);
          if ((this.g != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
            this.g.show();
          }
          localajhh.a.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  private void bp()
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
  
  private void bq()
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
    Intent localIntent = aciy.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
  }
  
  public void G()
  {
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
      this.jdField_a_of_type_Begr.dismiss();
    }
    this.jdField_a_of_type_Begr = null;
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.a();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      akbm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    super.G();
  }
  
  public void K()
  {
    if (!this.N)
    {
      arom localarom = (arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localarom != null) {
        localarom.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
    super.K();
  }
  
  public void O()
  {
    super.O();
    bn();
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.u();
    return bahn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
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
          if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_Ajbx == null)) {
            break;
          }
        } while ("0".equals(str1));
        paramIntent = babh.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str1);
        if (TextUtils.isEmpty(paramIntent)) {
          paramIntent = (Intent)localObject;
        }
        break;
      }
    }
    for (;;)
    {
      paramIntent = new StringBuilder("@").append(paramIntent);
      this.jdField_a_of_type_Ajbx.a.peerUin = str1;
      this.jdField_a_of_type_Ajbx.a.atNickName = paramIntent.toString();
      this.jdField_a_of_type_Ajbx.a.inputText = axku.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      a(this.jdField_a_of_type_Ajbx);
      paramInt1 = 0;
      String str2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Ajbx.a.inputText))
      {
        paramInt2 = 2;
        paramInt1 = paramInt2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajbx.b))
        {
          if (this.jdField_a_of_type_Ajbx.d == 0) {
            paramInt1 = 6;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          paramInt2 = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          str2 = "" + this.jdField_a_of_type_Ajbx.a.actionId;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajbx.b)) {
            break label463;
          }
        }
      }
      label463:
      for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_Ajbx.b)
      {
        bajr.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, paramInt1, paramInt2, new String[] { str2, paramIntent, this.jdField_a_of_type_Ajbx.a.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Ajbx.d != 1) {
          break;
        }
        paramInt1 = 7;
        break;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Ajbx.b))
        {
          paramInt1 = 3;
          break;
        }
        if (this.jdField_a_of_type_Ajbx.d == 0)
        {
          paramInt1 = 4;
          break;
        }
        if (this.jdField_a_of_type_Ajbx.d != 1) {
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
        if (badq.d(a()))
        {
          ((ajhf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), paramIntent);
          return;
        }
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131629008), 0).b(a());
        return;
        if (this.jdField_a_of_type_Wmm == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Wmm.a();
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
    bp();
  }
  
  public void a(SessionInfo paramSessionInfo, arig paramarig, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 3000)
    {
      paramCharSequence = new ArrayList();
      paramCharSequence = azef.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramCharSequence);
    }
    for (;;)
    {
      super.a(paramSessionInfo, paramarig, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo);
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
      i = ((ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString1 = new axkd(paramString1, 1);
      if (i > 0) {
        break;
      }
      paramTextView.setText(paramString1);
    } while (!AppSetting.c);
    paramTextView.setContentDescription(paramTextView.getText().toString());
    a().setTitle(paramTextView.getText());
    return;
    if (this.jdField_l_of_type_AndroidWidgetTextView == null) {
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299666));
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
      QLog.d("_At_Me_DISC", 2, "memUin:" + paramString1 + " displayName:" + azzz.a(paramString2) + " isRemoveOldAtFlag:" + paramBoolean);
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
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(ajjy.a(2131637545));
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
    if (this.jdField_a_of_type_Acka.getCount() > 0)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ackd)this.jdField_a_of_type_Akcg.a).a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Aymw != null)
      {
        if (this.jdField_a_of_type_Aymw.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Akcg.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aymw.jdField_a_of_type_Long, this.jdField_a_of_type_Aymw.jdField_b_of_type_Long, this.jdField_a_of_type_Aymw.c, this.jdField_a_of_type_Akcg);
          this.jdField_a_of_type_Aymw.j();
          return true;
        }
        this.jdField_a_of_type_Akcg.e = false;
        this.jdField_a_of_type_Akcg.f = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Akcg);
        return true;
      }
      this.jdField_a_of_type_Akcg.e = false;
      this.jdField_a_of_type_Akcg.f = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Akcg);
      return true;
    }
    g(false);
    return true;
  }
  
  public void aU()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  public void ag()
  {
    bm();
    super.ag();
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajhi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajey);
    ((aqae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajhi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajey);
    ((aqae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, babh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
  }
  
  protected void bm()
  {
    if (this.jdField_a_of_type_Aymw == null) {
      this.jdField_a_of_type_Aymw = new aymw();
    }
    this.jdField_a_of_type_Aymw.h();
    this.jdField_a_of_type_Aymw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acka, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Aymw != null) && (this.jdField_a_of_type_Aeob.a() != 9)) {
      this.jdField_a_of_type_Aymw.e();
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    aU();
  }
  
  public void j()
  {
    super.j();
    aemw localaemw = new aemw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Acka);
    aemy localaemy = new aemy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Acka);
    this.jdField_a_of_type_Aend = new aend(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aeob.a(localaemw);
    this.jdField_a_of_type_Aeob.a(localaemy);
    this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aend);
  }
  
  public void n(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "disscuss Uin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    ldb localldb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
    if (localldb != null)
    {
      if (!localldb.a) {
        break label139;
      }
      awqx.b(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
      super.n(paramInt);
      return;
      label139:
      awqx.b(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Aymw != null) && (this.jdField_a_of_type_Aymw.d()) && (this.jdField_a_of_type_Acka != null)) {
      this.jdField_a_of_type_Aymw.b(0);
    }
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean = true;
      bq();
    }
    boolean bool;
    do
    {
      return;
      DiscussionInfo localDiscussionInfo = ((ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bool = false;
      if (localDiscussionInfo != null) {
        bool = localDiscussionInfo.isDiscussHrMeeting();
      }
    } while ((bool) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() == 0) || (paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '@') && (paramCharSequence.charAt(paramInt1) != 65312)) || (this.s) || (((acxx)a(27)).a));
    bq();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131303604) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void s()
  {
    this.d.setOnClickListener(new aedf(this));
    if (lqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.d.setVisibility(0);
      this.d.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131632824));
    }
    for (;;)
    {
      aU();
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
      if ((paramObject instanceof aylz))
      {
        paramObservable = (aylz)paramObject;
        if (paramObservable != null)
        {
          if (paramObservable.jdField_a_of_type_Int != ayly.jdField_a_of_type_Int) {
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
        batg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
        return;
        label127:
        if ((paramObservable.jdField_a_of_type_Int == ayly.b) && (this.f != null))
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
    bg();
  }
  
  public void x()
  {
    bp();
  }
  
  public void z()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130848835, 2130848836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aede
 * JD-Core Version:    0.7.0.1
 */