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
import com.tencent.mobileqq.activity.QQBrowserActivity;
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

public class aikg
  extends BaseChatPie
{
  public static final String g;
  public static String h = "285982074";
  private aikp jdField_a_of_type_Aikp;
  protected aocj a;
  private avlc jdField_a_of_type_Avlc;
  private avld jdField_a_of_type_Avld;
  private avln jdField_a_of_type_Avln;
  private avlo jdField_a_of_type_Avlo = new aikh(this);
  private aikp jdField_b_of_type_Aikp;
  private avlc jdField_b_of_type_Avlc;
  private bhpc c;
  
  static
  {
    jdField_g_of_type_JavaLangString = avln.jdField_a_of_type_JavaLangString + "GameMsgChatPie";
  }
  
  public aikg(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Aocj = new aikn(this);
  }
  
  private boolean E()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[showStartGame]");
    }
    if (a() == null) {
      return false;
    }
    avlf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, a());
    return true;
  }
  
  private boolean F()
  {
    if (this.jdField_a_of_type_Avlc == null)
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "friendGameInfo is null.");
      return false;
    }
    String str = this.jdField_a_of_type_Avlc.i;
    if (TextUtils.isEmpty(str))
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "[showDialogIfBlocked], gameName is null.");
      return false;
    }
    str = String.format(anzj.a(2131692550), new Object[] { str });
    bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, anzj.a(2131692551), str, anzj.a(2131690580), anzj.a(2131692549), new aikl(this), new aikm(this)).show();
    return true;
  }
  
  private String a(avlc paramavlc)
  {
    if (paramavlc == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append(paramavlc.i).append(paramavlc.k).append("-").append(paramavlc.f);
    return localStringBuilder.toString();
  }
  
  private void a(aiko paramaiko)
  {
    if (paramaiko == null) {
      QLog.i(jdField_g_of_type_JavaLangString, 1, "[doOnButtonClick] buttonInfo is null.");
    }
    for (;;)
    {
      return;
      if (paramaiko.jdField_a_of_type_Int == 1)
      {
        paramaiko = paramaiko.jdField_a_of_type_JavaLangString;
        Intent localIntent = new Intent(a(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramaiko);
        a().startActivity(localIntent);
      }
      while ((this.c != null) && (this.c.isShowing()))
      {
        this.c.dismiss();
        return;
        if ((paramaiko.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
        }
      }
    }
  }
  
  private void a(avlc paramavlc)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[setTitleInfo]");
    }
    if (paramavlc == null) {}
    try
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "detail info is null.");
      this.d.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(anzj.a(2131692544));
      return;
    }
    catch (Throwable paramavlc)
    {
      Object localObject;
      QLog.e(jdField_g_of_type_JavaLangString, 1, paramavlc.getMessage());
      return;
    }
    paramavlc.a();
    if (!TextUtils.isEmpty(paramavlc.jdField_e_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramavlc.jdField_e_of_type_JavaLangString);
      localObject = a(paramavlc);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (paramavlc.jdField_a_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setEarIconVisible(false);
        }
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        if (paramavlc.jdField_a_of_type_Int != 1) {
          break label324;
        }
      }
    }
    label324:
    for (int i = 2130840167;; i = 2130840166)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(a().getResources().getDrawable(i));
      if (!TextUtils.isEmpty(paramavlc.jdField_g_of_type_JavaLangString))
      {
        this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetImageView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).width = agej.a(18.0F, BaseApplication.getContext().getResources());
        ((LinearLayout.LayoutParams)localObject).height = agej.a(18.0F, BaseApplication.getContext().getResources());
        localObject = URLDrawable.getDrawable(paramavlc.jdField_g_of_type_JavaLangString);
        this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      if (TextUtils.isEmpty(paramavlc.j)) {
        return;
      }
      this.d.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramavlc = URLDrawable.getDrawable(paramavlc.j);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(paramavlc);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(anzj.a(2131692544));
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, aiko paramaiko1, aiko paramaiko2)
  {
    if ((paramaiko1 == null) && (paramaiko2 == null)) {}
    while ((this.c != null) && (this.c.isShowing())) {
      return;
    }
    if ((paramaiko1 != null) && (paramaiko2 != null)) {
      this.c = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, paramString1, paramString2, paramaiko1.b, paramaiko2.b, new aiki(this, paramaiko2), new aikj(this, paramaiko1));
    }
    for (;;)
    {
      this.c.show();
      return;
      if (paramaiko1 != null) {
        this.c = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, paramString1, paramString2, paramaiko1.b, "", null, new aikk(this, paramaiko1));
      }
    }
  }
  
  private void bo()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    String str2 = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    QLog.i(jdField_g_of_type_JavaLangString, 1, "friRoleId:" + str1 + ",myRoleId:" + str2);
    this.jdField_a_of_type_Aikp = new aikp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, true, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_b_of_type_Aikp = new aikp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(str1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(str2);
    this.jdField_a_of_type_Avlc = this.jdField_a_of_type_Avld.a(str1);
    this.jdField_b_of_type_Avlc = this.jdField_a_of_type_Avld.a(str2);
    String str3;
    if (this.jdField_a_of_type_Avlc != null)
    {
      str3 = this.jdField_a_of_type_Avlc.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Avlc.jdField_c_of_type_Int != 0) {
        break label221;
      }
    }
    label221:
    for (localObject = "1";; localObject = "0")
    {
      avlf.a(str3, "1", "145", "920", "92005", "206350", "", (String)localObject, "8", "0");
      ((avln)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(175)).a(str2, str1);
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
    aguu localaguu = (aguu)a(56);
    if (localaguu != null) {
      localaguu.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void P()
  {
    super.P();
    aguu localaguu = (aguu)a(56);
    if (localaguu != null) {
      localaguu.a(a());
    }
    if (this.jdField_a_of_type_Avld != null) {
      this.jdField_a_of_type_Avld.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    a(this.jdField_a_of_type_Avlc);
  }
  
  public aikp a()
  {
    return this.jdField_a_of_type_Aikp;
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
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setSysEmotionOrder(avlf.a);
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
  
  public avlc a()
  {
    return this.jdField_a_of_type_Avlc;
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
    a(this.jdField_a_of_type_Avlc);
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
    this.jdField_a_of_type_Avld = ((avld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358));
    this.jdField_a_of_type_Avln = ((avln)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(175));
    bo();
    QLog.i(jdField_g_of_type_JavaLangString, 1, "[doOnCreate]");
    return super.a(paramBoolean);
  }
  
  public void aa()
  {
    super.aa();
    aguu localaguu = (aguu)a(56);
    if (localaguu != null) {
      localaguu.a(a());
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Avlo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Aocj);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avlo);
  }
  
  public void az()
  {
    super.az();
    aguu localaguu = (aguu)a(56);
    if (localaguu != null) {
      localaguu.c();
    }
  }
  
  public aikp b()
  {
    return this.jdField_b_of_type_Aikp;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    aguu localaguu = (aguu)a(56);
    if (localaguu != null) {
      localaguu.d();
    }
  }
  
  public void b(Intent paramIntent)
  {
    a(this.jdField_a_of_type_Avlc);
  }
  
  public void bn()
  {
    super.bn();
    this.jdField_a_of_type_Aguw.a(this);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    aguu localaguu = (aguu)a(56);
    if (localaguu != null) {
      localaguu.a(paramInt1, paramInt2);
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
          if (this.jdField_a_of_type_Avlc == null) {
            break;
          }
          if (this.jdField_a_of_type_Avlc != null) {
            avlf.a(this.jdField_a_of_type_Avlc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206356", "", "", "20", "0");
          }
          if (this.jdField_a_of_type_Avlc.jdField_c_of_type_Int == 0)
          {
            if (!F()) {
              break;
            }
            continue;
          }
          try
          {
            if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().getBytes().length <= this.jdField_a_of_type_Avlc.d) {
              break;
            }
            ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131692546, 1);
          }
          catch (Throwable localThrowable) {}
        }
        break;
        if (this.jdField_a_of_type_Avlc != null) {
          avlf.a(this.jdField_a_of_type_Avlc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "", "", "20", "0");
        }
        if (!E()) {
          break;
        }
      }
      if (this.jdField_a_of_type_Avlc != null) {
        avlf.a(this.jdField_a_of_type_Avlc.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206355", "", "", "20", "0");
      }
    }
  }
  
  public void p()
  {
    a(this.jdField_a_of_type_Avlc);
  }
  
  public void z()
  {
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikg
 * JD-Core Version:    0.7.0.1
 */