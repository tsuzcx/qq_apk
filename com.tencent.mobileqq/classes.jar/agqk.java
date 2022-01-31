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
import com.tencent.widget.XEditTextEx;
import java.util.List;

public class agqk
  extends BaseChatPie
{
  public static final String g;
  public static String h = "285982074";
  private agqp jdField_a_of_type_Agqp;
  protected alwx a;
  private asmt jdField_a_of_type_Asmt;
  private asmu jdField_a_of_type_Asmu;
  private asne jdField_a_of_type_Asne;
  private asnf jdField_a_of_type_Asnf = new agql(this);
  private agqp jdField_b_of_type_Agqp;
  private asmt jdField_b_of_type_Asmt;
  
  static
  {
    jdField_g_of_type_JavaLangString = asne.jdField_a_of_type_JavaLangString + "GameMsgChatPie";
  }
  
  public agqk(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Alwx = new agqo(this);
  }
  
  private boolean E()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[showStartGame]");
    }
    if (a() == null) {
      return false;
    }
    asmw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, a());
    return true;
  }
  
  private boolean F()
  {
    if (this.jdField_a_of_type_Asmt == null)
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "friendGameInfo is null.");
      return false;
    }
    String str = this.jdField_a_of_type_Asmt.i;
    if (TextUtils.isEmpty(str))
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "[showDialogIfBlocked], gameName is null.");
      return false;
    }
    str = String.format(alud.a(2131693023), new Object[] { str });
    bdgm.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, alud.a(2131693024), str, alud.a(2131690648), alud.a(2131693022), new agqm(this), new agqn(this)).show();
    return true;
  }
  
  private String a(asmt paramasmt)
  {
    if (paramasmt == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append(paramasmt.i).append(paramasmt.k).append("-").append(paramasmt.f);
    return localStringBuilder.toString();
  }
  
  private void a(asmt paramasmt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[setTitleInfo]");
    }
    if (paramasmt == null) {}
    try
    {
      QLog.w(jdField_g_of_type_JavaLangString, 1, "detail info is null.");
      this.d.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(alud.a(2131693015));
      return;
    }
    catch (Throwable paramasmt)
    {
      Object localObject;
      QLog.e(jdField_g_of_type_JavaLangString, 1, paramasmt.getMessage());
      return;
    }
    paramasmt.a();
    if (!TextUtils.isEmpty(paramasmt.jdField_e_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramasmt.jdField_e_of_type_JavaLangString);
      localObject = a(paramasmt);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (paramasmt.jdField_a_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setEarIconVisible(false);
        }
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        if (paramasmt.jdField_a_of_type_Int != 1) {
          break label321;
        }
      }
    }
    label321:
    for (int i = 2130839752;; i = 2130839751)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(a().getResources().getDrawable(i));
      if (!TextUtils.isEmpty(paramasmt.jdField_g_of_type_JavaLangString))
      {
        this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetImageView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).width = aepi.a(18.0F, BaseApplication.getContext().getResources());
        ((LinearLayout.LayoutParams)localObject).height = aepi.a(18.0F, BaseApplication.getContext().getResources());
        localObject = URLDrawable.getDrawable(paramasmt.jdField_g_of_type_JavaLangString);
        this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      if (TextUtils.isEmpty(paramasmt.j)) {
        return;
      }
      this.d.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramasmt = URLDrawable.getDrawable(paramasmt.j);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(paramasmt);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(alud.a(2131693015));
      break;
    }
  }
  
  private void br()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    localObject = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    QLog.i(jdField_g_of_type_JavaLangString, 1, "friRoleId:" + str1 + ",myRoleId:" + (String)localObject);
    this.jdField_a_of_type_Agqp = new agqp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, true);
    this.jdField_b_of_type_Agqp = new agqp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(str1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b((String)localObject);
    this.jdField_a_of_type_Asmt = this.jdField_a_of_type_Asmu.a(str1);
    this.jdField_b_of_type_Asmt = this.jdField_a_of_type_Asmu.a((String)localObject);
    String str2;
    if (this.jdField_a_of_type_Asmt != null)
    {
      localObject = bkjb.a();
      str2 = this.jdField_a_of_type_Asmt.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Asmt.jdField_c_of_type_Int != 0) {
        break label198;
      }
    }
    label198:
    for (str1 = "1";; str1 = "0")
    {
      ((bkjb)localObject).a(str2, "1", "145", "920", "92005", "206350", "", str1, "8", "0");
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
    afeu localafeu = (afeu)a(56);
    if (localafeu != null) {
      localafeu.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void P()
  {
    super.P();
    afeu localafeu = (afeu)a(56);
    if (localafeu != null) {
      localafeu.a(a());
    }
    if (this.jdField_a_of_type_Asmu != null) {
      this.jdField_a_of_type_Asmu.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    a(this.jdField_a_of_type_Asmt);
  }
  
  public agqp a()
  {
    return this.jdField_a_of_type_Agqp;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559056, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b = this.K;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.f = this.K;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c = this.K;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setOnlySysEmotionEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setSysEmotionOrder(asmw.a);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_e_of_type_JavaLangString, this.o, this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setEmoSettingVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    return super.a(paramInt);
  }
  
  public asmt a()
  {
    return this.jdField_a_of_type_Asmt;
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
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    afeu localafeu = (afeu)a(56);
    if (localafeu != null) {
      localafeu.d();
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    a(this.jdField_a_of_type_Asmt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
  }
  
  public boolean a()
  {
    return this.I;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Asmu = ((asmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358));
    this.jdField_a_of_type_Asne = ((asne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(175));
    br();
    QLog.i(jdField_g_of_type_JavaLangString, 1, "[doOnCreate]");
    return super.a(paramBoolean);
  }
  
  public void aC()
  {
    super.aC();
    afeu localafeu = (afeu)a(56);
    if (localafeu != null) {
      localafeu.c();
    }
  }
  
  public void aa()
  {
    super.aa();
    afeu localafeu = (afeu)a(56);
    if (localafeu != null) {
      localafeu.a(a());
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asnf);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Alwx);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asnf);
  }
  
  public agqp b()
  {
    return this.jdField_b_of_type_Agqp;
  }
  
  public void b(Intent paramIntent)
  {
    a(this.jdField_a_of_type_Asmt);
  }
  
  public void bq()
  {
    super.bq();
    this.jdField_a_of_type_Afev.a(this);
  }
  
  public int c()
  {
    return super.c();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    afeu localafeu = (afeu)a(56);
    if (localafeu != null) {
      localafeu.a(paramInt1, paramInt2);
    }
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if (this.jdField_a_of_type_Asmt != null)
      {
        if (this.jdField_a_of_type_Asmt != null) {
          bkjb.a().a(this.jdField_a_of_type_Asmt.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206356", "", "", "20", "0");
        }
        if (this.jdField_a_of_type_Asmt.jdField_c_of_type_Int == 0)
        {
          if (!F()) {}
        }
        else
        {
          try
          {
            if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().getBytes().length <= this.jdField_a_of_type_Asmt.d) {
              continue;
            }
            ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131693019, 1);
            return;
          }
          catch (Throwable localThrowable) {}
          continue;
          if (this.jdField_a_of_type_Asmt != null) {
            bkjb.a().a(this.jdField_a_of_type_Asmt.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "", "", "20", "0");
          }
          if (E())
          {
            return;
            if (this.jdField_a_of_type_Asmt != null) {
              bkjb.a().a(this.jdField_a_of_type_Asmt.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206355", "", "", "20", "0");
            }
          }
        }
      }
    }
  }
  
  public void p()
  {
    a(this.jdField_a_of_type_Asmt);
  }
  
  public void z()
  {
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqk
 * JD-Core Version:    0.7.0.1
 */