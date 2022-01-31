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
import com.tencent.mobileqq.utils.VipUtils;
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

public class aeoc
  extends BaseChatPie
{
  aexw jdField_a_of_type_Aexw;
  ajsy jdField_a_of_type_Ajsy = new aeog(this);
  private ajvj jdField_a_of_type_Ajvj = new aeof(this);
  protected akat a;
  public bfpc a;
  private Observer jdField_a_of_type_JavaUtilObserver = new aeoi(this);
  private Dialog g;
  private TextView l;
  
  public aeoc(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Akat = new aeoj(this);
  }
  
  private void bp()
  {
    ajvi localajvi = (ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    DiscussionInfo localDiscussionInfo = localajvi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localDiscussionInfo.discussionName;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localDiscussionInfo.uin, this.jdField_e_of_type_AndroidWidgetTextView);
    }
    if (localajvi.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bq();
    }
  }
  
  private void bq()
  {
    if ((this.g != null) && (this.g.isShowing())) {}
    ajvi localajvi;
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
          localajvi = (ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localajvi.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DiscussionManager's discToTroopCache doesn't contain discussionUIN :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
        localObject1 = (String[])localajvi.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((localObject1 == null) || (localObject1.length < 2));
      str1 = localObject1[0];
      str2 = localObject1[1];
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    for (;;)
    {
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130841945);
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = bbef.b((Bitmap)localObject1, 10.0F, 140, 140);
          this.g = bbdj.a(this.jdField_a_of_type_AndroidContentContext, (Bitmap)localObject2, bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2) + ajya.a(2131703345), ajya.a(2131703344) + str1, this.jdField_a_of_type_AndroidContentContext.getString(2131719551), null, new aeoe(this, str1), null);
          if ((this.g != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
            this.g.show();
          }
          localajvi.a.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  private void br()
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
  
  private void bs()
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
    Intent localIntent = actj.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
  }
  
  public void G()
  {
    if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
      this.jdField_a_of_type_Bfpc.dismiss();
    }
    this.jdField_a_of_type_Bfpc = null;
    if (this.jdField_a_of_type_Azno != null) {
      this.jdField_a_of_type_Azno.a();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      akpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    super.G();
  }
  
  public void K()
  {
    if (!this.N)
    {
      asks localasks = (asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localasks != null) {
        localasks.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
    super.K();
  }
  
  public void O()
  {
    super.O();
    bp();
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.u();
    return bbjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
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
          if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_Ajpx == null)) {
            break;
          }
        } while ("0".equals(str1));
        paramIntent = bbcz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str1);
        if (TextUtils.isEmpty(paramIntent)) {
          paramIntent = (Intent)localObject;
        }
        break;
      }
    }
    for (;;)
    {
      paramIntent = new StringBuilder("@").append(paramIntent);
      this.jdField_a_of_type_Ajpx.a.peerUin = str1;
      this.jdField_a_of_type_Ajpx.a.atNickName = paramIntent.toString();
      this.jdField_a_of_type_Ajpx.a.inputText = aylc.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      a(this.jdField_a_of_type_Ajpx);
      paramInt1 = 0;
      String str2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Ajpx.a.inputText))
      {
        paramInt2 = 2;
        paramInt1 = paramInt2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajpx.b))
        {
          if (this.jdField_a_of_type_Ajpx.d == 0) {
            paramInt1 = 6;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          paramInt2 = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          str2 = "" + this.jdField_a_of_type_Ajpx.a.actionId;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajpx.b)) {
            break label463;
          }
        }
      }
      label463:
      for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_Ajpx.b)
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, paramInt1, paramInt2, new String[] { str2, paramIntent, this.jdField_a_of_type_Ajpx.a.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Ajpx.d != 1) {
          break;
        }
        paramInt1 = 7;
        break;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Ajpx.b))
        {
          paramInt1 = 3;
          break;
        }
        if (this.jdField_a_of_type_Ajpx.d == 0)
        {
          paramInt1 = 4;
          break;
        }
        if (this.jdField_a_of_type_Ajpx.d != 1) {
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
        if (bbfj.d(a()))
        {
          ((ajvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), paramIntent);
          return;
        }
        bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131694673), 0).b(a());
        return;
        if (this.jdField_a_of_type_Xbm == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Xbm.a();
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
    br();
  }
  
  public void a(SessionInfo paramSessionInfo, asek paramasek, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 3000)
    {
      paramCharSequence = new ArrayList();
      paramCharSequence = bafv.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramCharSequence);
    }
    for (;;)
    {
      super.a(paramSessionInfo, paramasek, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo);
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
      i = ((ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString1 = new aykk(paramString1, 1);
      if (i > 0) {
        break;
      }
      paramTextView.setText(paramString1);
    } while (!AppSetting.d);
    paramTextView.setContentDescription(paramTextView.getText().toString());
    a().setTitle(paramTextView.getText());
    return;
    if (this.jdField_l_of_type_AndroidWidgetTextView == null) {
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365233));
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
      if (!AppSetting.d) {
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
      QLog.d("_At_Me_DISC", 2, "memUin:" + paramString1 + " displayName:" + bbbr.a(paramString2) + " isRemoveOldAtFlag:" + paramBoolean);
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
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(ajya.a(2131703341));
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
    if (this.jdField_a_of_type_Acup.getCount() > 0)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((acus)this.jdField_a_of_type_Akqr.a).a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Azno != null)
      {
        if (this.jdField_a_of_type_Azno.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Akqr.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Azno.jdField_a_of_type_Long, this.jdField_a_of_type_Azno.jdField_b_of_type_Long, this.jdField_a_of_type_Azno.c, this.jdField_a_of_type_Akqr);
          this.jdField_a_of_type_Azno.j();
          return true;
        }
        this.jdField_a_of_type_Akqr.e = false;
        this.jdField_a_of_type_Akqr.f = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Akqr);
        return true;
      }
      this.jdField_a_of_type_Akqr.e = false;
      this.jdField_a_of_type_Akqr.f = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Akqr);
      return true;
    }
    g(false);
    return true;
  }
  
  public void aW()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  public void ag()
  {
    bo();
    super.ag();
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
    ((aqui)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    ((aqui)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bbcz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
  }
  
  protected void bo()
  {
    if (this.jdField_a_of_type_Azno == null) {
      this.jdField_a_of_type_Azno = new azno();
    }
    this.jdField_a_of_type_Azno.h();
    this.jdField_a_of_type_Azno.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acup, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Azno != null) && (this.jdField_a_of_type_Aeyv.a() != 9)) {
      this.jdField_a_of_type_Azno.e();
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    aW();
  }
  
  public void j()
  {
    super.j();
    aexp localaexp = new aexp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeyv, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Acup);
    aexr localaexr = new aexr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeyv, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Acup);
    this.jdField_a_of_type_Aexw = new aexw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeyv, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aeyv.a(localaexp);
    this.jdField_a_of_type_Aeyv.a(localaexr);
    this.jdField_a_of_type_Aeyv.a(this.jdField_a_of_type_Aexw);
  }
  
  public void n(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "disscuss Uin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    lnn locallnn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
    if (locallnn != null)
    {
      if (!locallnn.a) {
        break label139;
      }
      axqy.b(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
      super.n(paramInt);
      return;
      label139:
      axqy.b(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Azno != null) && (this.jdField_a_of_type_Azno.d()) && (this.jdField_a_of_type_Acup != null)) {
      this.jdField_a_of_type_Azno.b(0);
    }
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean = true;
      bs();
    }
    boolean bool;
    do
    {
      return;
      DiscussionInfo localDiscussionInfo = ((ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bool = false;
      if (localDiscussionInfo != null) {
        bool = localDiscussionInfo.isDiscussHrMeeting();
      }
    } while ((bool) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() == 0) || (paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '@') && (paramCharSequence.charAt(paramInt1) != 65312)) || (this.s) || (((adiw)a(27)).a));
    bs();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131369274) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void s()
  {
    this.d.setOnClickListener(new aeod(this));
    if (mau.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.d.setVisibility(0);
      this.d.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698570));
    }
    for (;;)
    {
      aW();
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
      if ((paramObject instanceof azmr))
      {
        paramObservable = (azmr)paramObject;
        if (paramObservable != null)
        {
          if (paramObservable.jdField_a_of_type_Int != azmq.jdField_a_of_type_Int) {
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
        bbwo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
        return;
        label127:
        if ((paramObservable.jdField_a_of_type_Int == azmq.b) && (this.f != null))
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
    bi();
  }
  
  public void x()
  {
    br();
  }
  
  public void z()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849066, 2130849067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeoc
 * JD-Core Version:    0.7.0.1
 */