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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.9;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class aimx
  extends BaseChatPie
{
  public boolean S = true;
  public boolean T;
  protected boolean U;
  boolean V = false;
  boolean W = false;
  boolean X = false;
  protected boolean Y = true;
  anyu jdField_a_of_type_Anyu = new aimy(this);
  protected aocj a;
  aohi jdField_a_of_type_Aohi = new aimz(this);
  aojs jdField_a_of_type_Aojs = new aina(this);
  axwp jdField_a_of_type_Axwp = new ainb(this);
  protected axzy a;
  protected TroopGiftPanelForNearby a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  String g;
  String h = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("from_where_to_aio");
  public String i;
  int q = 0;
  public int r = -1;
  
  public aimx(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Aocj = new aing(this);
  }
  
  private void a(Integer paramInteger, String paramString)
  {
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 1: 
      ((axup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)).d.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
      {
        paramInteger = "2";
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
        aodb.a(paramString, (String)localObject, paramInteger, "1", 2, new aine(this));
        paramString = (axad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
          break label198;
        }
        paramInteger = "0";
        label152:
        if (!paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label204;
        }
      }
      label198:
      label204:
      for (paramString = "1";; paramString = "0")
      {
        bdll.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "c2c_tmp", "follow_aio", 0, 0, paramInteger, "0", paramString, "");
        return;
        paramInteger = "1";
        break;
        paramInteger = "1";
        break label152;
      }
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
    {
      paramInteger = "0";
      if (!this.Y) {
        break label342;
      }
    }
    label342:
    for (paramString = "0";; paramString = "1")
    {
      bdll.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "c2c_tmp", "block_aio", 0, 0, paramInteger, "0", paramString, "");
      return;
      paramInteger = "1";
      break;
    }
  }
  
  private void bo()
  {
    if (a().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", this.W);
      localIntent.putExtra("uin", a().getIntent().getStringExtra("tinyId"));
      a().setResult(-1, localIntent);
    }
  }
  
  public void A()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = bhlg.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void H()
  {
    super.H();
  }
  
  public void L()
  {
    super.L();
  }
  
  public void Q()
  {
    super.Q();
    this.T = false;
  }
  
  public void R()
  {
    super.R();
  }
  
  public void W()
  {
    super.W();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "NearbyChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 2000) && (paramIntent != null)) {
      this.Y = paramIntent.getBooleanExtra("follow_flag", false);
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
    if (this.jdField_a_of_type_Axzy == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = a();
      ainc localainc = new ainc(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby((QQAppInterface)localObject1, (Context)localObject2, localainc, true, false, bool, this);
        this.jdField_a_of_type_Axzy = new axzy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.c, false, true);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_Axzy;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) {
        break label190;
      }
    }
    label190:
    for (paramInt = 8;; paramInt = 6)
    {
      ((axzy)localObject1).a(paramBoolean, true, paramInt);
      ar();
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
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((adak.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (adak.d(paramMessageRecord.istroop))));
  }
  
  public void aG()
  {
    if (this.U) {
      return;
    }
    super.aG();
  }
  
  public void aS()
  {
    if (this.jdField_a_of_type_Axzy != null) {
      this.jdField_a_of_type_Axzy.a();
    }
  }
  
  public void ag()
  {
    super.ag();
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
        break label168;
      }
      j = 2131697839;
      localObject = ((Context)localObject).getString(j);
      c(true);
      this.f.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.b.setOnClickListener(null);
      this.f.setText((CharSequence)localObject);
      if (R) {
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
        axxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, j);
      }
      return;
      label168:
      j = 2131693848;
      break;
      label175:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().n(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null)) {
        j = 0;
      } else {
        j = -1;
      }
    }
  }
  
  public void ai()
  {
    super.ai();
    ThreadManager.post(new NearbyChatPie.14(this), 8, null, true);
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aohi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axwp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aohi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axwp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = bhlg.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new NearbyChatPie.3(this));
    if (QLog.isDevelopLevel()) {
      asam.a(this.jdField_a_of_type_JavaLangString, new Object[] { "updateSession_updateTitle", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  public void bn()
  {
    super.bn();
    this.jdField_a_of_type_Aguw.a(this);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {}
    for (String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();; str = null)
    {
      super.c();
      if ((this.g != null) && (this.g.length() > 0) && (this.g.equals(str))) {
        ThreadManager.post(new NearbyChatPie.8(this, str), 5, null, false);
      }
      this.g = null;
      if ((this.h != null) && (this.h.equals("nearby_recommend_people")) && (this.S)) {
        ThreadManager.post(new NearbyChatPie.9(this), 1, null, false);
      }
      this.W = true;
      return;
    }
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    bhsq.a(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
    {
      paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "From chatActivity : sameState Sig--->" + bhml.a(paramIntent));
      }
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      }
    }
    for (;;)
    {
      this.u = this.U;
      if (-1 == this.r) {
        ThreadManager.post(new NearbyChatPie.2(this), 8, null, false);
      }
      bhsq.a("AIO_updateSession_business", null);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
      {
        this.r = paramIntent.getIntExtra("gender", -1);
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "From chatActivity : accost Sig--->" + bhml.a(arrayOfByte));
        }
        if (arrayOfByte != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
          aean.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
    axad localaxad = (axad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
    return (!this.Y) && (!localaxad.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!A());
  }
  
  public void f(boolean paramBoolean)
  {
    bo();
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
    this.T = false;
    paramMessage = (String)paramMessage.obj;
    aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessage);
    return true;
  }
  
  public boolean i()
  {
    bo();
    if ((this.jdField_a_of_type_Axzy != null) && (this.jdField_a_of_type_Axzy.a()))
    {
      this.jdField_a_of_type_Axzy.a();
      super.i();
      return true;
    }
    return super.i();
  }
  
  public void j()
  {
    if (this.U) {
      return;
    }
    super.j();
    aivt localaivt = new aivt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aiwh);
    localaivt.a(this.r);
    this.jdField_a_of_type_Aiwh.a(localaivt);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showAddFriendAndShield() ==== called.");
    }
    Object localObject2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      localObject2 = new aind(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559945, null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362535);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131297475));
      localLayoutParams.addRule(3, 2131376731);
      if (this.H)
      {
        localLayoutParams.topMargin -= agej.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        this.k = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373716));
        TextView localTextView = this.k;
        if (!this.Y) {
          break label578;
        }
        localObject1 = anzj.a(2131706009);
        label181:
        localTextView.setText((CharSequence)localObject1);
        this.k.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296405));
        this.k.setContentDescription(this.k.getText());
        this.k.setGravity(17);
        this.k.setOnClickListener((View.OnClickListener)localObject2);
        this.k.setTag(Integer.valueOf(1));
        this.j = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373717));
        this.j.setText(anzj.a(2131706011));
        this.j.setTag(Integer.valueOf(2));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals("")))) {
          break label588;
        }
        this.j.setEnabled(false);
        this.j.setClickable(false);
        label347:
        this.j.setGravity(17);
        this.j.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131296405));
        this.j.setOnClickListener((View.OnClickListener)localObject2);
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131362535);
        this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = this.c.findViewById(2131374287);
      if (localObject1 != null)
      {
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        int k = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297475) + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299011);
        int j = k;
        if (this.H) {
          j = k - agej.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = j;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
        break label607;
      }
    }
    label578:
    label588:
    label607:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      bdll.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_float", 0, 0, (String)localObject1, "", "", "");
      return;
      localLayoutParams.topMargin = 0;
      break;
      localObject1 = anzj.a(2131706008);
      break label181;
      this.j.setEnabled(true);
      this.j.setClickable(true);
      break label347;
    }
  }
  
  public void o(int paramInt)
  {
    super.o(paramInt);
    ((axae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public void o(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001))
    {
      super.r();
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new ainf(this));
    if (mbh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131697828));
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
      if ((paramObservable.istroop == 0) && (!this.X))
      {
        this.X = true;
        a().runOnUiThread(new NearbyChatPie.7(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && ((this.q == 2) || (this.q == 3)) && (paramObservable.isSendFromLocal()) && (bhjx.a(paramObservable.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        if (this.q != 2) {
          break label328;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004946", "0X8004946", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.q = 0;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((adak.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (adak.d(paramObservable.istroop)))) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramObservable.action);
        }
      }
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
        p(false);
      }
      return;
      label328:
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004945", "0X8004945", 0, 0, "", "", "", "");
    }
  }
  
  public void x()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
    localIntent.putExtra("follow_flag", this.Y);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimx
 * JD-Core Version:    0.7.0.1
 */