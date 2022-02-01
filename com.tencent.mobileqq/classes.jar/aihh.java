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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class aihh
  extends aijm
{
  private boolean X;
  private boolean Y;
  private boolean Z;
  public Handler a;
  private anuw jdField_a_of_type_Anuw = new aiho(this);
  public anxa a;
  anyw jdField_a_of_type_Anyw;
  protected aocj a;
  private aoeg jdField_a_of_type_Aoeg = new aiht(this);
  private aohi jdField_a_of_type_Aohi = new aihu(this);
  bkgt jdField_a_of_type_Bkgt;
  public bkia a;
  protected CustomMenuBar a;
  public PublicAccountInfo a;
  protected NewIntent a;
  protected LinearLayout b;
  protected aocj b;
  List<StructMsg.ButtonInfo> b;
  protected LinearLayout c;
  long e = 0L;
  protected ImageView l;
  protected TextView l;
  protected ImageView m;
  protected TextView m;
  protected View n;
  protected ImageView n;
  public View o;
  protected ImageView o;
  private int r;
  
  public aihh(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new aihi(this);
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Aocj = new aihw(this);
    this.jdField_a_of_type_Anxa = new aihl(this);
    this.jdField_b_of_type_Aocj = new aihn(this);
    this.jdField_a_of_type_Bkia = new aihp(this);
  }
  
  private void B(int paramInt)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)bcry.a(2024);
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 26);
    ((Bundle)localObject1).putString("key_action_DATA", "" + paramInt);
    String str = ((Resources)localObject2).getString(2131693477);
    localObject2 = ((Resources)localObject2).getString(2131693478);
    localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str, NetConnInfoCenter.getServerTime(), -2064, 0, 0L);
    paramInt = str.indexOf((String)localObject2);
    localMessageForGrayTips.addHightlightItem(paramInt, ((String)localObject2).length() + paramInt, (Bundle)localObject1);
    localObject1 = new ArrayList();
    ((List)localObject1).add(localMessageForGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void a(EqqDetail paramEqqDetail)
  {
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1)) {
      bq();
    }
  }
  
  private void bA()
  {
    if (this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        agej.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130849843);
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
        localLayoutParams.leftMargin = agej.a(8.0F, (Resources)localObject);
        localLayoutParams.gravity = 80;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        agej.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130849984);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167139));
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
      i = agej.a(8.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom() != i) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), i);
    }
  }
  
  private void bC()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131558633, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_o_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372201);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366204));
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366203);
    ((View)localObject).setOnClickListener(new aihx(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new aihj(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new aihk(this));
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("crm_ivr_aio_video_action_sheet", false)) {
      nok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373139));
      localObject = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
      this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131366205));
      this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (CustomMenuBar.a())
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167139));
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(agej.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
      }
      this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372811));
      this.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131365923));
      this.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130847906);
        this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130838028);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        agej.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130849984);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167139));
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
    while (this.Y) {
      return;
    }
    this.Y = true;
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    PubAccountNavigationMenu localPubAccountNavigationMenu = ((bkid)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    bkib localbkib = (bkib)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    if (localPubAccountNavigationMenu != null) {}
    for (int i = localPubAccountNavigationMenu.version;; i = 0)
    {
      localbkib.a(l1, l2, i, this.r, false);
      return;
    }
  }
  
  void A(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
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
  
  protected boolean E()
  {
    aody localaody;
    long l1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!nmd.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      boolean bool = this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "showOrHideFollow isQidianMasterInCache: " + bool);
      }
      if (bool) {
        return !this.jdField_a_of_type_Anyw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      localaody = (aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
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
    if (!localaody.a(Long.valueOf(l1))) {
      return true;
    }
    return false;
  }
  
  public void H()
  {
    super.H();
    if ((this.jdField_m_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.jdField_m_of_type_AndroidWidgetImageView);
      this.jdField_m_of_type_AndroidWidgetImageView = null;
    }
    if ((this.jdField_a_of_type_Bkgt != null) && (this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((bkib)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), 0);
    }
  }
  
  public void N()
  {
    super.N();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int j = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299011);
    int i = j;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      i = j;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        i = j + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297021);
      }
    }
    j = i;
    if (this.H) {
      j = i - agej.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
    }
    localLayoutParams.topMargin = j;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void Q()
  {
    super.Q();
    if ((this.jdField_m_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.jdField_m_of_type_AndroidWidgetImageView);
      this.jdField_m_of_type_AndroidWidgetImageView = null;
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
  
  public void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if ((paramPubAccountNavigationMenu != null) && (paramPubAccountNavigationMenu.xml != null) && (paramPubAccountNavigationMenu.xml.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramPubAccountNavigationMenu.puin)))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramPubAccountNavigationMenu = bdow.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramPubAccountNavigationMenu.xml.getBytes(), 0);
        if (paramPubAccountNavigationMenu != null)
        {
          long l1 = bcpt.jdField_a_of_type_Int;
          paramPubAccountNavigationMenu = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1, paramPubAccountNavigationMenu);
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
    this.F = false;
    this.jdField_a_of_type_Bkgt = ((bkgt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    this.jdField_a_of_type_Anyw = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    super.a(paramBoolean);
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      bC();
      if (!this.jdField_a_of_type_Bkgt.f(a()))
      {
        bt();
        asuw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), false);
      }
    }
    this.X = this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    bv();
    Object localObject;
    if (!this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
      localObject = new aihq(this);
      nok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (BusinessObserver)localObject);
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
      this.jdField_a_of_type_Bkgt.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (BmqqAccountType)localObject);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (!bkgt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      e(paramEditable);
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoeg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aohi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bkia);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoeg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aohi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bkia);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008AAA", "C_Master_PTT", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, b(paramInt1), paramInt2);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.jdField_a_of_type_Boolean = true;
    paramIntent = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
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
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      int j = paramList.size();
      int i = 0;
      while ((i < j) && (i <= 2))
      {
        Object localObject = (StructMsg.ButtonInfo)paramList.get(i);
        aayp localaayp = new aayp(((StructMsg.ButtonInfo)localObject).key.get(), ((StructMsg.ButtonInfo)localObject).name.get(), null, ((StructMsg.ButtonInfo)localObject).id.get());
        if (((StructMsg.ButtonInfo)localObject).sub_button.get().size() > 0)
        {
          localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)((Iterator)localObject).next();
            localaayp.a(new aayp(localButtonInfo.key.get(), localButtonInfo.name.get(), null, localButtonInfo.id.get()));
          }
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localaayp, a());
        i += 1;
      }
    }
  }
  
  protected void bo()
  {
    if (!this.jdField_a_of_type_Bkgt.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView don't request qidian master, so wait request show");
      }
      return;
    }
    if (E())
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
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
    {
      aihr localaihr = new aihr(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131362535);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131297021));
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      this.jdField_n_of_type_AndroidViewView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131559987, null);
      this.jdField_n_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838288));
      this.jdField_n_of_type_AndroidViewView.findViewById(2131370757).setVisibility(8);
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_n_of_type_AndroidViewView.findViewById(2131370760));
      this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167066));
      ((ImageView)this.jdField_n_of_type_AndroidViewView.findViewById(2131370748)).setImageResource(2130841726);
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(localaihr);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_n_of_type_AndroidViewView, localLayoutParams1);
      View localView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131559987, null);
      localView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838288));
      this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370760));
      this.jdField_m_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167066));
      this.jdField_m_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131691643));
      ((ImageView)localView.findViewById(2131370748)).setImageResource(2130841625);
      localView.setTag(Integer.valueOf(3));
      localView.setOnClickListener(localaihr);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams1);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131362535);
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011);
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    }
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      this.jdField_l_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689943));
      this.jdField_n_of_type_AndroidViewView.setTag(Integer.valueOf(1));
    }
    for (;;)
    {
      if ((this.jdField_m_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_m_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689831));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_m_of_type_AndroidViewView);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          int j = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297021) + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299011);
          int i = j;
          if (this.H) {
            i = j - agej.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
          }
          ((RelativeLayout.LayoutParams)localObject).topMargin = i;
          this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        this.jdField_l_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131691645));
        this.jdField_n_of_type_AndroidViewView.setTag(Integer.valueOf(2));
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
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_m_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        int i = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299011);
        if (this.H)
        {
          i -= agej.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
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
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), ocj.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(2);
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new aihs(this);
    this.jdField_a_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow exit");
    }
  }
  
  @TargetApi(11)
  protected void bs()
  {
    if (this.jdField_n_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.f != 1) {
        break;
      }
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130844846);
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.isHoneycomb());
    this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.f == 2)
    {
      this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.isHoneycomb()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130849881);
        }
        for (;;)
        {
          this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697747));
          return;
          this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850313);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130849880);
      }
      for (;;)
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697746));
        return;
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850314);
      }
    }
    this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130849881);
      }
      for (;;)
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697747));
        label246:
        if (!VersionUtils.isHoneycomb()) {
          break;
        }
        this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850313);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130849880);
    }
    for (;;)
    {
      this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697746));
      break label246;
      break;
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850314);
    }
  }
  
  public void bt()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList = asuw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      v(true);
    }
    for (;;)
    {
      b(this.jdField_b_of_type_JavaUtilList);
      return;
      v(false);
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
      localObject = (aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((aody)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
      localObject = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), nkl.class);
      ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(1);
      localGetEqqDetailInfoRequest.seqno.set(0);
      try
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        label160:
        ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new aihm(this));
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
      catch (Exception localException)
      {
        break label160;
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
    this.r = d();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      long l1;
      do
      {
        return;
        l1 = System.currentTimeMillis();
      } while (Math.abs(l1 - this.e) < 1000L);
      this.e = l1;
      this.Y = false;
    } while (!this.jdField_a_of_type_Bkgt.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false));
    bD();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    bs();
    if (paramInt2 == 8) {
      if (this.jdField_o_of_type_AndroidWidgetImageView != null)
      {
        if (!CustomMenuBar.a()) {
          break label40;
        }
        this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130849930);
      }
    }
    label40:
    while (this.jdField_o_of_type_AndroidWidgetImageView == null)
    {
      return;
      this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130849852);
      return;
    }
    if (CustomMenuBar.a())
    {
      this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130849929);
      return;
    }
    this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130849851);
  }
  
  public void c(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.c(paramIntent);
    if (!this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
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
    bhsq.a(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "From chatActivity : buinessCrm Sigt--->" + bhml.a(paramIntent));
    }
    if (paramIntent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("BusinessChatPie", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    bhsq.a("AIO_updateSession_business", null);
  }
  
  void e(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1))
    {
      A(80);
      return;
    }
    A(16);
  }
  
  public void g(String paramString)
  {
    PubAccountNavigationMenu localPubAccountNavigationMenu;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      localPubAccountNavigationMenu = ((bkid)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (!"1".equals(paramString)) {
        break label108;
      }
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString = (bkib)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
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
    if (this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bq();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bo();
    }
  }
  
  public void o(int paramInt)
  {
    super.o(paramInt);
    bB();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366205) {
      v(true);
    }
    if ((paramView.getId() == 2131365923) && (this.f != 1))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
    }
    else if (paramView.getId() == 2131372811)
    {
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 8) {
        break label238;
      }
      if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
        this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689914));
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
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      label238:
      aj();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
        this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689839));
      }
      p(0);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_Bkgt.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new aihv(this));
      if (mbh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131697828));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void v(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
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
    this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void x()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bkgt.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (this.jdField_a_of_type_Anyw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
      for (;;)
      {
        localIntent.putExtra("uintype", i);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      }
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    nok.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
  }
  
  public void z()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850139, 2130850140);
  }
  
  public void z(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihh
 * JD-Core Version:    0.7.0.1
 */