import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class aemh
  extends aeom
{
  private boolean Y;
  private boolean Z;
  private ajto jdField_a_of_type_Ajto = new aemo(this);
  public ajvq a;
  ajxl jdField_a_of_type_Ajxl;
  protected akat a;
  private akdn jdField_a_of_type_Akdn = new aemt(this);
  private akgh jdField_a_of_type_Akgh = new aemu(this);
  public Handler a;
  bduf jdField_a_of_type_Bduf;
  public bdvm a;
  protected CustomMenuBar a;
  public PublicAccountInfo a;
  protected NewIntent a;
  private boolean aa;
  protected akat b;
  List<StructMsg.ButtonInfo> b;
  protected LinearLayout c;
  protected LinearLayout d;
  long g;
  public final String g;
  protected TextView l;
  protected TextView m;
  protected View o;
  public View p;
  protected ImageView p;
  protected ImageView q;
  private int r;
  protected ImageView r;
  protected ImageView s;
  
  public aemh(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_g_of_type_JavaLangString = "BusinessChatPie";
    this.jdField_g_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new aemi(this);
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Akat = new aemw(this);
    this.jdField_a_of_type_Ajvq = new aeml(this);
    this.jdField_b_of_type_Akat = new aemn(this);
    this.jdField_a_of_type_Bdvm = new aemp(this);
  }
  
  private void C(int paramInt)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)axas.a(2024);
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 26);
    ((Bundle)localObject1).putString("key_action_DATA", "" + paramInt);
    String str = ((Resources)localObject2).getString(2131694081);
    localObject2 = ((Resources)localObject2).getString(2131694082);
    localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str, NetConnInfoCenter.getServerTime(), -2064, 0, 0L);
    paramInt = str.indexOf((String)localObject2);
    localMessageForGrayTips.addHightlightItem(paramInt, ((String)localObject2).length() + paramInt, (Bundle)localObject1);
    localObject1 = new ArrayList();
    ((List)localObject1).add(localMessageForGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void a(EqqDetail paramEqqDetail)
  {
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1)) {
      bq();
    }
  }
  
  private void bA()
  {
    if (this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        actj.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130848777);
        n();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.b);
        bB();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
      }
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        localLayoutParams.topMargin = 1;
        localLayoutParams.leftMargin = actj.a(8.0F, (Resources)localObject);
        localLayoutParams.gravity = 80;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      return;
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        actj.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130848918);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166992));
        }
        bt();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        bB();
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    Object localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 1;
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void bB()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getVisibility() != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.jdField_a_of_type_Int <= 0)) {
      i = actj.a(8.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom() != i) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), i);
    }
  }
  
  private void bC()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131558573, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_p_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371185);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365815));
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365814);
    ((View)localObject).setOnClickListener(new aemx(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new aemj(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new aemk(this));
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("crm_ivr_aio_video_action_sheet", false)) {
      naz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131372099));
      localObject = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      ((LinearLayout.LayoutParams)localObject).topMargin = 1;
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = 1;
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131365816));
      this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (CustomMenuBar.a())
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166992));
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(actj.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
      }
      this.s = ((ImageView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131371783));
      this.s.setOnClickListener(this);
      this.jdField_r_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131365560));
      this.jdField_r_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130846988);
        this.s.setImageResource(2130837728);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        actj.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130848918);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166992));
        }
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "We needn't show video action sheet, because isShowVideoActionSheet is false");
      }
    }
  }
  
  private void bD()
  {
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "checkNavigationMenuUpdate msg shielded");
      }
    }
    while (this.Z) {
      return;
    }
    this.Z = true;
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    PubAccountNavigationMenu localPubAccountNavigationMenu = ((bdvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    bdvn localbdvn = (bdvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    if (localPubAccountNavigationMenu != null) {}
    for (int i = localPubAccountNavigationMenu.version;; i = 0)
    {
      localbdvn.a(l1, l2, i, this.jdField_r_of_type_Int, false);
      return;
    }
  }
  
  public void A(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  void B(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    } while (localLayoutParams.gravity == paramInt);
    localLayoutParams.gravity = paramInt;
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams(localLayoutParams);
  }
  
  protected boolean D()
  {
    akdh localakdh;
    long l1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!myv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      boolean bool = this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "showOrHideFollow isQidianMasterInCache: " + bool);
      }
      if (bool) {
        return !this.jdField_a_of_type_Ajxl.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      localakdh = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label134:
      break label134;
    }
    if (!localakdh.a(Long.valueOf(l1))) {
      return true;
    }
    return false;
  }
  
  public void G()
  {
    super.G();
    if ((this.q != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.q);
      this.q = null;
    }
    if ((this.jdField_a_of_type_Bduf != null) && (this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((bdvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), 0);
    }
  }
  
  public void M()
  {
    super.M();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int j = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131298865);
    int i = j;
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null)
    {
      i = j;
      if (this.jdField_c_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        i = j + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131296940);
      }
    }
    j = i;
    if (this.I) {
      j = i - actj.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
    }
    localLayoutParams.topMargin = j;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void P()
  {
    super.P();
    if ((this.q != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.q);
      this.q = null;
    }
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    }
  }
  
  public StructMsg.ButtonInfo a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
        break label156;
      }
      StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)this.jdField_b_of_type_JavaUtilList.get(i);
      localObject = localButtonInfo;
      if (localButtonInfo.id.get() == paramInt) {
        break;
      }
      localObject = localButtonInfo.sub_button.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int j = 0;
        while (j < ((List)localObject).size())
        {
          if (((StructMsg.ButtonInfo)((List)localObject).get(j)).id.get() == paramInt) {
            return (StructMsg.ButtonInfo)((List)localObject).get(j);
          }
          j += 1;
        }
      }
      i += 1;
    }
    label156:
    return null;
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    bo();
  }
  
  void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1))
    {
      B(80);
      return;
    }
    B(16);
  }
  
  public void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if ((paramPubAccountNavigationMenu != null) && (paramPubAccountNavigationMenu.xml != null) && (paramPubAccountNavigationMenu.xml.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramPubAccountNavigationMenu.puin)))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramPubAccountNavigationMenu = axva.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramPubAccountNavigationMenu.xml.getBytes(), 0);
        if (paramPubAccountNavigationMenu != null)
        {
          long l1 = awyn.jdField_a_of_type_Int;
          paramPubAccountNavigationMenu = axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1, paramPubAccountNavigationMenu);
          if (paramPubAccountNavigationMenu != null)
          {
            paramPubAccountNavigationMenu.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
            localQQMessageFacade.a(paramPubAccountNavigationMenu, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          }
        }
        return;
      }
      catch (Exception paramPubAccountNavigationMenu)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("BusinessChatPie", 2, "Add message error: " + paramPubAccountNavigationMenu.getMessage());
        return;
      }
    }
    QLog.d("BusinessChatPie", 2, "showNavigationMenu not current uin or xml is null");
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.G = false;
    this.jdField_a_of_type_Bduf = ((bduf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    this.jdField_a_of_type_Ajxl = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    super.a(paramBoolean);
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      bC();
      if (!this.jdField_a_of_type_Bduf.f(a()))
      {
        bt();
        aoej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), false);
      }
    }
    this.Y = this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    bv();
    Object localObject;
    if (!this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
      localObject = new aemq(this);
      naz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (BusinessObserver)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        bB();
      }
    }
    for (;;)
    {
      bA();
      bw();
      return true;
      localObject = new BmqqAccountType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 6);
      this.jdField_a_of_type_Bduf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (BmqqAccountType)localObject);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (!bduf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      a(paramEditable);
    }
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akdn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akgh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdvm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajto);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akdn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akgh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdvm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajto);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    aeft.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008AAA", "C_Master_PTT", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a(paramInt1), paramInt2);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.jdField_a_of_type_Boolean = true;
    paramIntent = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bbcz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && ((paramIntent == null) || (paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(List<StructMsg.ButtonInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
      int j = paramList.size();
      int i = 0;
      while ((i < j) && (i <= 2))
      {
        Object localObject = (StructMsg.ButtonInfo)paramList.get(i);
        xeb localxeb = new xeb(((StructMsg.ButtonInfo)localObject).key.get(), ((StructMsg.ButtonInfo)localObject).name.get(), null, ((StructMsg.ButtonInfo)localObject).id.get());
        if (((StructMsg.ButtonInfo)localObject).sub_button.get().size() > 0)
        {
          localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)((Iterator)localObject).next();
            localxeb.a(new xeb(localButtonInfo.key.get(), localButtonInfo.name.get(), null, localButtonInfo.id.get()));
          }
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localxeb, a());
        i += 1;
      }
    }
  }
  
  protected void bo()
  {
    if (!this.jdField_a_of_type_Bduf.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView don't request qidian master, so wait request show");
      }
      return;
    }
    if (D())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView true");
      }
      bp();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateFollowAndShieldView false");
    }
    bq();
  }
  
  protected void bp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showFollowAndShield() ==== called.");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null)
    {
      aemr localaemr = new aemr(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setId(2131362414);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131296940));
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      this.o = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131559780, null);
      this.o.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838108));
      this.o.findViewById(2131369929).setVisibility(8);
      this.l = ((TextView)this.o.findViewById(2131369932));
      this.l.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131166924));
      ((ImageView)this.o.findViewById(2131369919)).setImageResource(2130841290);
      this.o.setOnClickListener(localaemr);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.o, localLayoutParams1);
      View localView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131559780, null);
      localView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838108));
      this.m = ((TextView)localView.findViewById(2131369932));
      this.m.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131166924));
      this.m.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131691903));
      ((ImageView)localView.findViewById(2131369919)).setImageResource(2130841190);
      localView.setTag(Integer.valueOf(3));
      localView.setOnClickListener(localaemr);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams1);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131362414);
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865);
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    }
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      this.l.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131690007));
      this.o.setTag(Integer.valueOf(1));
    }
    for (;;)
    {
      if ((this.m != null) && (this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.m.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689875));
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.n);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          int j = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131296940) + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131298865);
          int i = j;
          if (this.I) {
            i = j - actj.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
          }
          ((RelativeLayout.LayoutParams)localObject).topMargin = i;
          this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        this.l.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131691906));
        this.o.setTag(Integer.valueOf(2));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "removeHeaderView err");
          }
        }
      }
    }
  }
  
  protected void bq()
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.n);
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        int i = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131298865);
        if (this.I)
        {
          i -= actj.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.topMargin = i;
          this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "addHeaderView err");
        }
      }
    }
  }
  
  void br()
  {
    ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow");
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), nor.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(2);
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new aems(this);
    this.jdField_a_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow exit");
    }
  }
  
  @TargetApi(11)
  protected void bs()
  {
    if (this.jdField_r_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.f != 1) {
        break;
      }
      this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130844023);
      this.jdField_r_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_r_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!bfnz.e());
    this.jdField_r_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.f == 2)
    {
      this.jdField_r_of_type_AndroidWidgetImageView.setEnabled(false);
      if (bfnz.e()) {
        this.jdField_r_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130848815);
        }
        for (;;)
        {
          this.jdField_r_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698470));
          return;
          this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130849211);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130848814);
      }
      for (;;)
      {
        this.jdField_r_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698469));
        return;
        this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130849212);
      }
    }
    this.jdField_r_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130848815);
      }
      for (;;)
      {
        this.jdField_r_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698470));
        label246:
        if (!bfnz.e()) {
          break;
        }
        this.jdField_r_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130849211);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130848814);
    }
    for (;;)
    {
      this.jdField_r_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698469));
      break label246;
      break;
      this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(2130849212);
    }
  }
  
  public void bt()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList = aoej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      t(true);
    }
    for (;;)
    {
      b(this.jdField_b_of_type_JavaUtilList);
      return;
      t(false);
    }
  }
  
  public void bu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject;
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((akdh)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
      localObject = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), mxe.class);
      ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(1);
      localGetEqqDetailInfoRequest.seqno.set(0);
      try
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        label158:
        ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new aemm(this));
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
      catch (Exception localException)
      {
        break label158;
      }
    }
  }
  
  public void bv()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 0);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018) || (localMessageRecord.msgtype == -2019) || (localMessageRecord.msgtype == -7006)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 0, localMessageRecord.uniseq);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bw()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessChatPie", 2, "checkNavigationMenuUpdate");
    }
    this.jdField_r_of_type_Int = c();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      long l1;
      do
      {
        return;
        l1 = System.currentTimeMillis();
      } while (Math.abs(l1 - this.jdField_g_of_type_Long) < 1000L);
      this.jdField_g_of_type_Long = l1;
      this.Z = false;
    } while (!this.jdField_a_of_type_Bduf.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false));
    bD();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    bs();
    if (paramInt2 == 8) {
      if (this.s != null)
      {
        if (!CustomMenuBar.a()) {
          break label40;
        }
        this.s.setImageResource(2130848864);
      }
    }
    label40:
    while (this.s == null)
    {
      return;
      this.s.setImageResource(2130848786);
      return;
    }
    if (CustomMenuBar.a())
    {
      this.s.setImageResource(2130848863);
      return;
    }
    this.s.setImageResource(2130848785);
  }
  
  public void c(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.c(paramIntent);
    if (!this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      bu();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        bB();
      }
    }
  }
  
  public void d(Intent paramIntent)
  {
    bbkj.a(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "From chatActivity : buinessCrm Sigt--->" + bbea.a(paramIntent));
    }
    if (paramIntent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("BusinessChatPie", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    bbkj.a("AIO_updateSession_business", null);
  }
  
  public void f(String paramString)
  {
    PubAccountNavigationMenu localPubAccountNavigationMenu;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      localPubAccountNavigationMenu = ((bdvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (!"1".equals(paramString)) {
        break label108;
      }
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString = (bdvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
      l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
      if (localPubAccountNavigationMenu == null) {
        break label103;
      }
      i = localPubAccountNavigationMenu.version;
      paramString.a(l1, l2, i, 0, true);
    }
    label103:
    label108:
    while (localPubAccountNavigationMenu == null) {
      for (;;)
      {
        long l1;
        long l2;
        return;
        int i = 0;
      }
    }
    a(localPubAccountNavigationMenu);
  }
  
  public boolean g()
  {
    return true;
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.c();
    }
    return super.i();
  }
  
  public void l()
  {
    super.l();
    if (this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bq();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bo();
    }
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
    bB();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365816) {
      t(true);
    }
    if ((paramView.getId() == 2131365560) && (this.f != 1))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
    }
    else if (paramView.getId() == 2131371783)
    {
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 8) {
        break label231;
      }
      if (this.s != null) {
        this.s.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689970));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "BaseCHatPie onClick keybordicon removeFastImage");
        }
        b(true);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      label231:
      ah();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      if (this.s != null) {
        this.s.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689884));
      }
      o(0);
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Bduf.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new aemv(this));
      if (mau.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698567));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void t(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void x()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bduf.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (this.jdField_a_of_type_Ajxl.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
      for (;;)
      {
        localIntent.putExtra("uintype", i);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      }
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    naz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
  }
  
  public void z()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849072, 2130849073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemh
 * JD-Core Version:    0.7.0.1
 */