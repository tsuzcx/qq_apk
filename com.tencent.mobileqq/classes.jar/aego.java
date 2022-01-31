import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.Observable;
import mqq.app.MobileQQ;

public class aego
  extends BaseChatPie
{
  public boolean T = true;
  protected boolean U;
  protected boolean V;
  boolean W = false;
  boolean X = false;
  boolean Y = false;
  protected boolean Z = true;
  ajjh jdField_a_of_type_Ajjh = new aegx(this);
  protected ajmm a;
  ajry jdField_a_of_type_Ajry = new aegp(this);
  ajuc jdField_a_of_type_Ajuc = new aegr(this);
  asez jdField_a_of_type_Asez = new aegs(this);
  protected asii a;
  protected TroopGiftPanelForNearby a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  String g;
  String h = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("from_where_to_aio");
  protected String i;
  int q = 0;
  public int r = -1;
  
  public aego(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Ajmm = new aegq(this);
  }
  
  private void bm()
  {
    if (a().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", this.X);
      localIntent.putExtra("uin", a().getIntent().getStringExtra("tinyId"));
      a().setResult(-1, localIntent);
    }
  }
  
  public void A()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = babh.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void G()
  {
    super.G();
  }
  
  public void K()
  {
    super.K();
  }
  
  public void P()
  {
    super.P();
    this.U = false;
  }
  
  public void Q()
  {
    super.Q();
  }
  
  public void V()
  {
    super.V();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "NearbyChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 2000) && (paramIntent != null)) {
      this.Z = paramIntent.getBooleanExtra("follow_flag", false);
    }
    if ((paramInt1 == 12007) && (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.a(null);
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    super.a(paramIntent, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = (InputMethodManager)a().getSystemService("input_method");
    Object localObject2 = a().getWindow().peekDecorView();
    if ((localObject2 != null) && (((View)localObject2).getWindowToken() != null)) {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject2).getWindowToken(), 0);
    }
    boolean bool;
    if (this.jdField_a_of_type_Asii == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = a();
      aegt localaegt = new aegt(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby((QQAppInterface)localObject1, (Context)localObject2, localaegt, true, false, bool, this);
        this.jdField_a_of_type_Asii = new asii(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.c, false, true);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_Asii;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) {
        break label189;
      }
    }
    label189:
    for (paramInt = 8;; paramInt = 6)
    {
      ((asii)localObject1).a(paramBoolean, true, paramInt);
      ap();
      return;
      bool = false;
      break;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((akbm.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (akbm.c(paramMessageRecord.istroop))));
  }
  
  public void aF()
  {
    if (this.V) {
      return;
    }
    super.aF();
  }
  
  public void aS()
  {
    if (this.jdField_a_of_type_Asii != null) {
      this.jdField_a_of_type_Asii.a();
    }
  }
  
  public void ae()
  {
    super.ae();
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
        break label168;
      }
      j = 2131632832;
      localObject = ((Context)localObject).getString(j);
      c(true);
      this.f.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.f.setText((CharSequence)localObject);
      if (S) {
        this.f.setContentDescription((CharSequence)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().k(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null)) {
        break label175;
      }
      j = 1;
    }
    for (;;)
    {
      if (j != -1) {
        asfl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, j);
      }
      return;
      label168:
      j = 2131628752;
      break;
      label175:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().m(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null)) {
        j = 0;
      } else {
        j = -1;
      }
    }
  }
  
  public void ag()
  {
    super.ag();
    ThreadManager.post(new NearbyChatPie.14(this), 8, null, true);
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajry);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asez);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajry);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asez);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = babh.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new NearbyChatPie.3(this));
    if (QLog.isDevelopLevel()) {
      amvy.a(this.jdField_a_of_type_JavaLangString, new Object[] { "updateSession_updateTitle", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {}
    for (String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();; str = null)
    {
      super.c();
      if ((this.g != null) && (this.g.length() > 0) && (this.g.equals(str))) {
        ThreadManager.post(new NearbyChatPie.7(this, str), 5, null, false);
      }
      this.g = null;
      if ((this.h != null) && (this.h.equals("nearby_recommend_people")) && (this.T)) {
        ThreadManager.post(new NearbyChatPie.8(this), 1, null, false);
      }
      this.X = true;
      return;
    }
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    baio.a(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
    {
      paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "From chatActivity : sameState Sig--->" + bach.a(paramIntent));
      }
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      }
    }
    for (;;)
    {
      this.v = this.V;
      if (-1 == this.r) {
        ThreadManager.post(new NearbyChatPie.2(this), 8, null, false);
      }
      baio.a("AIO_updateSession_business", null);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
      {
        this.r = paramIntent.getIntExtra("gender", -1);
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "From chatActivity : accost Sig--->" + bach.a(arrayOfByte));
        }
        if (arrayOfByte != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
          aael.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        } else {
          ThreadManager.post(new NearbyChatPie.1(this), 5, null, false);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010)
      {
        this.r = paramIntent.getIntExtra("gender", -1);
        this.q = paramIntent.getIntExtra("dating_from_id", 0);
        paramIntent = paramIntent.getByteArrayExtra("rich_date_sig");
        if (paramIntent != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().l(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
        }
      }
    }
  }
  
  public boolean e()
  {
    arip localarip = (arip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
    return (!this.Z) && (!localarip.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!A());
  }
  
  public void f(boolean paramBoolean)
  {
    bm();
    super.f(paramBoolean);
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1010);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    }
    this.U = false;
    paramMessage = (String)paramMessage.obj;
    aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessage);
    return true;
  }
  
  public boolean i()
  {
    bm();
    if ((this.jdField_a_of_type_Asii != null) && (this.jdField_a_of_type_Asii.a()))
    {
      this.jdField_a_of_type_Asii.a();
      super.i();
      return true;
    }
    return super.i();
  }
  
  public void j()
  {
    if (this.V) {
      return;
    }
    super.j();
    aenr localaenr = new aenr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aeob);
    localaenr.a(this.r);
    this.jdField_a_of_type_Aeob.a(localaenr);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showAddFriendAndShield() ==== called.");
    }
    Object localObject2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
    {
      localObject2 = new aegu(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494170, null));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131296874);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131166284));
      localLayoutParams.addRule(3, 2131309578);
      if (this.I)
      {
        localLayoutParams.topMargin -= aciy.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        this.k = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131306877));
        TextView localTextView = this.k;
        if (!this.Z) {
          break label587;
        }
        localObject1 = ajjy.a(2131641331);
        label181:
        localTextView.setText((CharSequence)localObject1);
        this.k.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165289));
        this.k.setContentDescription(this.k.getText());
        this.k.setGravity(17);
        this.k.setOnClickListener((View.OnClickListener)localObject2);
        this.k.setTag(Integer.valueOf(1));
        this.j = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131306878));
        this.j.setText(ajjy.a(2131641333));
        this.j.setTag(Integer.valueOf(2));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals("")))) {
          break label597;
        }
        this.j.setEnabled(false);
        this.j.setClickable(false);
        label348:
        this.j.setGravity(17);
        this.j.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131165289));
        this.j.setOnClickListener((View.OnClickListener)localObject2);
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131296874);
        this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = this.c.findViewById(2131307242);
      if (localObject1 != null)
      {
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        int k = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131166284) + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131167766);
        int j = k;
        if (this.I) {
          j = k - aciy.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = j;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
        break label616;
      }
    }
    label587:
    label597:
    label616:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      awqx.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_float", 0, 0, (String)localObject1, "", "", "");
      return;
      localLayoutParams.topMargin = 0;
      break;
      localObject1 = ajjy.a(2131641330);
      break label181;
      this.j.setEnabled(true);
      this.j.setClickable(true);
      break label348;
    }
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
    ((ariq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public void n(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001))
    {
      super.s();
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new aegw(this));
    if (lqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131632821));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 0) && (!this.Y))
      {
        this.Y = true;
        a().runOnUiThread(new NearbyChatPie.6(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && ((this.q == 2) || (this.q == 3)) && (paramObservable.isSendFromLocal()) && (azzz.a(paramObservable.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        if (this.q != 2) {
          break label334;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004946", "0X8004946", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.q = 0;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((akbm.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (akbm.c(paramObservable.istroop)))) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramObservable.action);
        }
      }
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
        o(false);
      }
      return;
      label334:
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004945", "0X8004945", 0, 0, "", "", "", "");
    }
  }
  
  public void x()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
    localIntent.putExtra("follow_flag", this.Z);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aego
 * JD-Core Version:    0.7.0.1
 */