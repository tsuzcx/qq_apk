import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.List;

public class aias
  extends BaseChatPie
{
  public static final String g;
  public static String h = "285982074";
  private aiax jdField_a_of_type_Aiax;
  protected anqd a;
  private autc jdField_a_of_type_Autc;
  private autd jdField_a_of_type_Autd;
  private autn jdField_a_of_type_Autn;
  private auto jdField_a_of_type_Auto = new aiat(this);
  private aiax jdField_b_of_type_Aiax;
  private autc jdField_b_of_type_Autc;
  
  static
  {
    jdField_g_of_type_JavaLangString = autn.jdField_a_of_type_JavaLangString + "GameMsgChatPie";
  }
  
  public aias(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Anqd = new aiaw(this);
  }
  
  private boolean E()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[showStartGame]");
    }
    if (a() == null) {
      return false;
    }
    autf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, a());
    return true;
  }
  
  private boolean F()
  {
    if (this.jdField_a_of_type_Autc == null)
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "friendGameInfo is null.");
      return false;
    }
    String str = this.jdField_a_of_type_Autc.i;
    if (TextUtils.isEmpty(str))
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "[showDialogIfBlocked], gameName is null.");
      return false;
    }
    str = String.format(anni.a(2131692544), new Object[] { str });
    bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, anni.a(2131692545), str, anni.a(2131690582), anni.a(2131692543), new aiau(this), new aiav(this)).show();
    return true;
  }
  
  private String a(autc paramautc)
  {
    if (paramautc == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append(paramautc.i).append(paramautc.k).append("-").append(paramautc.f);
    return localStringBuilder.toString();
  }
  
  private void a(autc paramautc)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[setTitleInfo]");
    }
    if (paramautc == null) {}
    try
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "detail info is null.");
      this.d.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(anni.a(2131692538));
      return;
    }
    catch (Throwable paramautc)
    {
      Object localObject;
      QLog.e(jdField_g_of_type_JavaLangString, 1, paramautc.getMessage());
      return;
    }
    paramautc.a();
    if (!TextUtils.isEmpty(paramautc.jdField_e_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramautc.jdField_e_of_type_JavaLangString);
      localObject = a(paramautc);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (paramautc.jdField_a_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setEarIconVisible(false);
        }
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        if (paramautc.jdField_a_of_type_Int != 1) {
          break label321;
        }
      }
    }
    label321:
    for (int i = 2130840158;; i = 2130840157)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(a().getResources().getDrawable(i));
      if (!TextUtils.isEmpty(paramautc.jdField_g_of_type_JavaLangString))
      {
        this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetImageView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).width = afur.a(18.0F, BaseApplication.getContext().getResources());
        ((LinearLayout.LayoutParams)localObject).height = afur.a(18.0F, BaseApplication.getContext().getResources());
        localObject = URLDrawable.getDrawable(paramautc.jdField_g_of_type_JavaLangString);
        this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      if (TextUtils.isEmpty(paramautc.j)) {
        return;
      }
      this.d.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramautc = URLDrawable.getDrawable(paramautc.j);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(paramautc);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(anni.a(2131692538));
      break;
    }
  }
  
  private void bo()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    localObject = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    QLog.i(jdField_g_of_type_JavaLangString, 1, "friRoleId:" + str1 + ",myRoleId:" + (String)localObject);
    this.jdField_a_of_type_Aiax = new aiax(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, true, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_b_of_type_Aiax = new aiax(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(str1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b((String)localObject);
    this.jdField_a_of_type_Autc = this.jdField_a_of_type_Autd.a(str1);
    this.jdField_b_of_type_Autc = this.jdField_a_of_type_Autd.a((String)localObject);
    String str2;
    if (this.jdField_a_of_type_Autc != null)
    {
      localObject = bmxq.a();
      str2 = this.jdField_a_of_type_Autc.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Autc.jdField_c_of_type_Int != 0) {
        break label206;
      }
    }
    label206:
    for (str1 = "1";; str1 = "0")
    {
      ((bmxq)localObject).a(str2, "1", "145", "920", "92005", "206350", "", str1, "8", "0");
      return;
    }
  }
  
  public void H()
  {
    super.H();
  }
  
  public void M()
  {
    super.M();
  }
  
  public void N()
  {
    super.N();
    aglt localaglt = (aglt)a(56);
    if (localaglt != null) {
      localaglt.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void P()
  {
    super.P();
    aglt localaglt = (aglt)a(56);
    if (localaglt != null) {
      localaglt.a(a());
    }
    if (this.jdField_a_of_type_Autd != null) {
      this.jdField_a_of_type_Autd.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void U()
  {
    super.U();
  }
  
  public void V()
  {
    super.V();
  }
  
  public void W()
  {
    super.W();
    a(this.jdField_a_of_type_Autc);
  }
  
  public aiax a()
  {
    return this.jdField_a_of_type_Aiax;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559123, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      EmoticonMainPanel localEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      if ((A()) || (this.J)) {}
      for (boolean bool = true;; bool = false)
      {
        localEmoticonMainPanel.b = bool;
        if (A()) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setHideAllSettingTabs(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.f = this.J;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c = this.J;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setOnlySysEmotionEnable(true);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setSysEmotionOrder(autf.a);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_e_of_type_JavaLangString, this.o, this);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setEmoSettingVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
        }
        return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      }
    }
    return super.a(paramInt);
  }
  
  public autc a()
  {
    return this.jdField_a_of_type_Autc;
  }
  
  public List<ChatMessage> a()
  {
    return super.a();
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return super.a(paramQQAppInterface, paramBoolean);
  }
  
  public List<ChatMessage> a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    a(this.jdField_a_of_type_Autc);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
  }
  
  public boolean a()
  {
    return this.H;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Autd = ((autd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358));
    this.jdField_a_of_type_Autn = ((autn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(175));
    bo();
    QLog.i(jdField_g_of_type_JavaLangString, 1, "[doOnCreate]");
    return super.a(paramBoolean);
  }
  
  public void aa()
  {
    super.aa();
    aglt localaglt = (aglt)a(56);
    if (localaglt != null) {
      localaglt.a(a());
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Auto);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Anqd);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Auto);
  }
  
  public void az()
  {
    super.az();
    aglt localaglt = (aglt)a(56);
    if (localaglt != null) {
      localaglt.c();
    }
  }
  
  public aiax b()
  {
    return this.jdField_b_of_type_Aiax;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    aglt localaglt = (aglt)a(56);
    if (localaglt != null) {
      localaglt.d();
    }
  }
  
  public void b(Intent paramIntent)
  {
    a(this.jdField_a_of_type_Autc);
  }
  
  public void bn()
  {
    super.bn();
    this.jdField_a_of_type_Aglu.a(this);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    aglt localaglt = (aglt)a(56);
    if (localaglt != null) {
      localaglt.a(paramInt1, paramInt2);
    }
  }
  
  public int d()
  {
    return super.d();
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
  }
  
  public void o(int paramInt)
  {
    super.o(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      for (;;)
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Autc == null) {
            break;
          }
          if (this.jdField_a_of_type_Autc != null) {
            bmxq.a().a(this.jdField_a_of_type_Autc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206356", "", "", "20", "0");
          }
          if (this.jdField_a_of_type_Autc.jdField_c_of_type_Int == 0)
          {
            if (!F()) {
              break;
            }
            continue;
          }
          try
          {
            if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().getBytes().length <= this.jdField_a_of_type_Autc.d) {
              break;
            }
            ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131692540, 1);
          }
          catch (Throwable localThrowable) {}
        }
        break;
        if (this.jdField_a_of_type_Autc != null) {
          bmxq.a().a(this.jdField_a_of_type_Autc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "", "", "20", "0");
        }
        if (!E()) {
          break;
        }
      }
      if (this.jdField_a_of_type_Autc != null) {
        bmxq.a().a(this.jdField_a_of_type_Autc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206355", "", "", "20", "0");
      }
    }
  }
  
  public void p()
  {
    a(this.jdField_a_of_type_Autc);
  }
  
  public void z()
  {
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aias
 * JD-Core Version:    0.7.0.1
 */