import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;

public class aipm
  extends BaseChatPie
{
  boolean S = false;
  private boolean T;
  private boolean U;
  private boolean V;
  protected aocj a;
  private aohi jdField_a_of_type_Aohi = new aipp(this);
  bkgt jdField_a_of_type_Bkgt;
  private bkia jdField_a_of_type_Bkia = new aipr(this);
  private String g;
  
  public aipm(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Aocj = new aipq(this);
  }
  
  private void A(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1600: 
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691890), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    case 1601: 
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691890), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691889), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void B(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697070);
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (CharSequence)localObject, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void C(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691597), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void D(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719348), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    case 55: 
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719347), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public static Serializable a(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerChatPie", 2, String.format(Locale.getDefault(), "hasWzryInfo [%d, %b, %b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getIntent();
      localObject1 = localObject2;
      if (paramContext != null)
      {
        localObject1 = localObject2;
        if (!paramBoolean1)
        {
          localObject1 = localObject2;
          if (!paramBoolean2)
          {
            localObject1 = localObject2;
            if (paramInt == 1022)
            {
              localObject1 = localObject2;
              if (paramContext.hasExtra("param_wzry_data")) {
                localObject1 = paramContext.getSerializableExtra("param_wzry_data");
              }
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "" + paramInt;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, anzj.a(2131713370), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong + " errorCode " + paramInt2);
    }
    if (paramInt1 == 1005) {
      D(paramInt2);
    }
    for (;;)
    {
      f(196608);
      return;
      if (paramInt1 == 1004) {
        C(paramInt2);
      } else if (paramInt1 == 1000) {
        a(paramString1, paramInt2, paramString2);
      } else if (paramInt1 == 1020) {
        B(paramInt2);
      } else if (paramInt1 == 1006) {
        A(paramInt2);
      } else if (paramInt1 == 1022) {
        z(paramInt2);
      } else if (paramInt1 == 1023) {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "errorCode" + paramInt2, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      } else if (paramInt1 == 1025) {
        a(paramInt2, paramString2);
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131692823), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    }
    switch (paramInt)
    {
    default: 
      if (paramInt > 100) {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      return;
    case 102: 
    case 103: 
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "Grp_data", "forbid_temp", 0, 0, paramString1, "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void bp()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a();
    if (localRespondQueryQQBindingStat != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = (localRespondQueryQQBindingStat.nationCode + localRespondQueryQQBindingStat.mobileNo);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = bhlg.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "contactUin == null");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void bq()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localObject == null) {}
    do
    {
      String str;
      do
      {
        return;
        str = ((Intent)localObject).getStringExtra("gid");
      } while (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str));
      localObject = bdow.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
    } while (localObject == null);
    bhse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (AbsStructMsg)localObject, null);
    if (((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
      return;
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
  }
  
  private void h(Intent paramIntent)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "From chatActivity : accost Sig--->" + bhml.a(arrayOfByte));
    }
    if (arrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
    }
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
      aean.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    do
    {
      do
      {
        return;
        paramIntent = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          break;
        }
      } while (!bhsr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
      return;
    } while ((paramIntent == null) || (paramIntent.strCertificationInfo == null) || (paramIntent.strCertificationInfo.equals("")));
    aean.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void i(Intent paramIntent)
  {
    paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "From chatActivity : sameState Sig--->" + bhml.a(paramIntent));
    }
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
    }
  }
  
  private void j(Intent paramIntent)
  {
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
      aean.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    do
    {
      do
      {
        return;
        paramIntent = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          break;
        }
      } while (!bhsr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
      return;
    } while ((paramIntent == null) || (paramIntent.strCertificationInfo == null) || (paramIntent.strCertificationInfo.equals("")));
    aean.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void k(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramIntent.getStringExtra("troop_code");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c.trim().length() == 0))
    {
      paramIntent = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramIntent.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == null)
      {
        paramIntent = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
    }
  }
  
  private void z(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    aean.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void A()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
      localObject = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ((String)localObject);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
          localObject = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        String str = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005) {
          if (str != null)
          {
            localObject = str;
            if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = str;
          }
        }
      }
    }
  }
  
  public void D()
  {
    if ((this.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) || (!a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006))
    {
      Object localObject = ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (bhlg.a(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) {
        break label126;
      }
      localObject = bhlg.a((PhoneContact)localObject);
      c(true);
      this.f.setText((CharSequence)localObject);
      if (R) {
        this.f.setContentDescription((CharSequence)localObject);
      }
    }
    label126:
    do
    {
      do
      {
        return;
      } while (this.f.getVisibility() != 0);
      c(false);
    } while (this.jdField_a_of_type_Aiwh.a() != 5);
    aivb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aiwh.a();
  }
  
  public void H()
  {
    if (this.d != null) {
      this.d.setOnClickListener(null);
    }
    if ((this.jdField_a_of_type_Bkgt != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025)) {
      this.jdField_a_of_type_Bkgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Bkgt != null) && (this.jdField_a_of_type_Bkgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((bkib)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    if (nmd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_Bkgt != null) {
        break label210;
      }
    }
    label210:
    for (String str = "";; str = this.jdField_a_of_type_Bkgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.4.5", "");
      if (KplRoleInfo.isKplPie(this))
      {
        ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "kpl global has been remove, because StrangerChatPie close");
        }
      }
      super.H();
      return;
    }
  }
  
  public void P()
  {
    super.P();
    anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (KplRoleInfo.isKplPie(this))
    {
      localanyw.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "open kpl session, mark global flag");
      }
    }
    do
    {
      return;
      localanyw.jdField_a_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.d("KplMessage", 2, "not open kpl session, reset global flag");
  }
  
  public bkgt a()
  {
    if (this.jdField_a_of_type_Bkgt == null) {
      this.jdField_a_of_type_Bkgt = ((bkgt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    }
    return this.jdField_a_of_type_Bkgt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "StrangerChatPie";
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.H) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((adak.v(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((adak.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (adak.d(paramMessageRecord.istroop))));
  }
  
  public void ah()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
    {
      if (!TextUtils.isEmpty(this.g)) {
        break label132;
      }
      this.g = akyd.a("", "strangerchat_ext", "");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.g))
      {
        aivr localaivr = new aivr(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_Aiwh.a(localaivr, new Object[] { this.g });
      }
      super.ah();
      return;
      label132:
      akyd.a("", "strangerchat_ext", this.g);
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aohi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bkia);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aohi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bkia);
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1020) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004)) {
        break label124;
      }
      paramIntent = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
      this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      this.e.setOnClickListener(new aipn(this));
      return;
      label124:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        paramIntent = ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          paramIntent = paramIntent.name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
          paramIntent = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        } else {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        str = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        if (str != null)
        {
          paramIntent = str;
          if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1005) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10004))
        {
          paramIntent = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10010) {}
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramIntent = str;
        }
      }
    }
  }
  
  public void bn()
  {
    super.bn();
    this.jdField_a_of_type_Aguw.a(this);
  }
  
  public void bo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      Intent localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, 3006, 12, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, null, null, null, null);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.S)
    {
      this.S = false;
      bq();
    }
    if (this.T)
    {
      aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.T);
      this.T = false;
    }
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025)
    {
      paramIntent = paramIntent.getByteArrayExtra("sigt");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 4, "updateSession()--AIO 已保存 sigt");
        }
      }
      if (a().a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      if (a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) && (QLog.isColorLevel())) {
      QLog.i("addFriendTag", 4, String.format(Locale.getDefault(), "BaseChatPie addFriend uin: %s troopuin: %s sourceId: %d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int) }));
    }
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    bhsq.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020)) {
      k(paramIntent);
    }
    for (;;)
    {
      this.S = paramIntent.getBooleanExtra("fromSencondhandCommunity", false);
      this.U = paramIntent.getBooleanExtra("from3rdApp", false);
      this.V = paramIntent.getBooleanExtra("from_wpa_for_crm", false);
      this.T = aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      bhsq.a("AIO_updateSession_business", null);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        bp();
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003)
      {
        j(paramIntent);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
      {
        i(paramIntent);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
      {
        h(paramIntent);
      }
      else
      {
        byte[] arrayOfByte;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_movie_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().j(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
          }
          this.g = paramIntent.getStringExtra("strangerchat_ext");
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().l(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10008)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), arrayOfByte);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10010)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().p(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10009)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), arrayOfByte);
          }
        }
      }
    }
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if ((paramIntent.hasExtra("key_sub_title_from")) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) || (!a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))))
    {
      paramIntent = paramIntent.getStringExtra("key_sub_title_from");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.f.getVisibility() == 8) {
          c(true);
        }
        this.f.setText(paramIntent);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public boolean e()
  {
    if (A()) {
      return false;
    }
    if (this.K) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      PhoneContact localPhoneContact = ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      String str2;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str2 = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("StrangerChatPie.showorhideAddFriend curFriendUin=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append(" contact=");
        if (localPhoneContact != null) {
          break label126;
        }
      }
      label126:
      for (String str1 = "null";; str1 = "real")
      {
        QLog.d(str2, 2, str1);
        if (localPhoneContact == null) {
          break;
        }
        return false;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) {
      return false;
    }
    return !((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.U) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    super.f(paramBoolean);
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10008);
  }
  
  public boolean i()
  {
    if ((this.U) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    return super.i();
  }
  
  public void o(int paramInt)
  {
    super.o(paramInt);
    if (nmd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      aI();
      if (this.jdField_a_of_type_Bkgt != null) {
        break label93;
      }
    }
    label93:
    for (String str = "";; str = this.jdField_a_of_type_Bkgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.4.5", "");
      ((axae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      return;
    }
  }
  
  public void p()
  {
    if (this.jdField_b_of_type_Boolean) {
      D();
    }
  }
  
  public void q()
  {
    super.q();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(8, 8);
    }
  }
  
  public void r()
  {
    this.d.setOnClickListener(new aipo(this));
    if ((ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (nok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      if (mbh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.d.setVisibility(0);
        this.d.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131697828));
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025)) {
        this.d.setVisibility(8);
      }
      return;
      this.d.setVisibility(8);
      continue;
      if ((this.e.getText() != null) && (this.e.getText().length() < 6)) {
        this.d.setVisibility(4);
      } else {
        this.d.setVisibility(8);
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((adak.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (adak.d(paramObservable.istroop)))) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if ((paramObservable != null) && ((paramObservable.istroop == 1001) || (paramObservable.istroop == 10002)) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramObservable.action);
        }
      }
    }
  }
  
  public void x()
  {
    if ((bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (bhjx.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    boolean bool;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals("")))
      {
        bool = true;
        localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
      }
    }
    else
    {
      if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
      localIntent.putExtra("real_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
      localObject = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, false);
      if (localObject == null) {
        break label265;
      }
      localIntent.putExtra("param_wzry_data", (Serializable)localObject);
      localIntent.putExtra("uinname", ((KplRoleInfo.WZRYUIinfo)localObject).nick);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
      return;
      bool = false;
      break;
      label265:
      if (KplRoleInfo.isKplPie(this))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        String str = KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, KplRoleInfo.getGameNickByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject));
        localIntent.putExtra("param_wzry_data", KplRoleInfo.WZRYUIinfo.createInfo((String)localObject, str, KplRoleInfo.getKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0));
        localIntent.putExtra("uinname", str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipm
 * JD-Core Version:    0.7.0.1
 */