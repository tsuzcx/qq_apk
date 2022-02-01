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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
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

public class ahdt
  extends afiw
{
  long jdField_a_of_type_Long = 0L;
  public amrj a;
  amsw jdField_a_of_type_Amsw;
  private amyh jdField_a_of_type_Amyh = new ahef(this);
  private anax jdField_a_of_type_Anax = new aheg(this);
  public Handler a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  public binf a;
  protected CustomMenuBar a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ahea(this);
  public PublicAccountInfo a;
  List<StructMsg.ButtonInfo> jdField_a_of_type_JavaUtilList = null;
  protected NewIntent a;
  private int jdField_b_of_type_Int;
  protected amwl b;
  protected View b;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  bily jdField_b_of_type_Bily;
  protected amwl c;
  public View c;
  protected ImageView c;
  protected ImageView d;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public ahdt(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new ahdu(this);
    this.jdField_b_of_type_Amwl = new ahei(this);
    this.jdField_a_of_type_Amrj = new ahdx(this);
    this.jdField_c_of_type_Amwl = new ahdz(this);
    this.jdField_a_of_type_Binf = new aheb(this);
  }
  
  private void a(EqqDetail paramEqqDetail)
  {
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1)) {
      e();
    }
  }
  
  private void c(int paramInt)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)bbli.a(2024);
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 26);
    ((Bundle)localObject1).putString("key_action_DATA", "" + paramInt);
    String str = ((Resources)localObject2).getString(2131693572);
    localObject2 = ((Resources)localObject2).getString(2131693573);
    localMessageForGrayTips.init(this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, this.app.getCurrentAccountUin(), str, NetConnInfoCenter.getServerTime(), -2064, 0, 0L);
    paramInt = str.indexOf((String)localObject2);
    localMessageForGrayTips.addHightlightItem(paramInt, ((String)localObject2).length() + paramInt, (Bundle)localObject1);
    localObject1 = new ArrayList();
    ((List)localObject1).add(localMessageForGrayTips);
    this.app.getMessageFacade().addMessageCacheOnly((List)localObject1, this.app.getCurrentAccountUin());
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.input != null)
      {
        AIOUtils.setViewDrawalbe(this.input, 2130849760);
        updateInputBarBg();
      }
      if (this.panelicons != null)
      {
        this.panelicons.setCustomHeight(PanelIconLinearLayout.jdField_b_of_type_Int);
        m();
      }
      if (this.mInputBar != null) {
        this.mInputBar.setBackgroundColor(Color.parseColor("#00000000"));
      }
      localObject = this.mActivity.getResources();
      if (this.input != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.input.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        localLayoutParams.topMargin = 1;
        localLayoutParams.leftMargin = AIOUtils.dp2px(8.0F, (Resources)localObject);
        localLayoutParams.gravity = 80;
        this.input.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.input != null)
      {
        AIOUtils.setViewDrawalbe(this.input, 2130849901);
        if (CustomMenuBar.a()) {
          this.mInputBar.setBackgroundColor(this.mActivity.getResources().getColor(2131167162));
        }
        h();
      }
      if (this.panelicons != null)
      {
        this.panelicons.setCustomHeight(0);
        m();
      }
    } while (this.input == null);
    Object localObject = (FrameLayout.LayoutParams)this.input.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 1;
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.input.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void m()
  {
    int j = 0;
    if ((this.panelicons == null) || (this.panelicons.getVisibility() != 0) || (this.panelicons.a <= 0)) {
      j = AIOUtils.dp2px(8.0F, this.mActivity.getResources());
    }
    if (this.mInputBar.getPaddingBottom() != j) {
      this.mInputBar.setPadding(this.mInputBar.getPaddingLeft(), this.mInputBar.getPaddingTop(), this.mInputBar.getPaddingRight(), j);
    }
  }
  
  private void n()
  {
    this.mActivity.getLayoutInflater().inflate(2131558636, this.mContent);
    this.jdField_c_of_type_AndroidViewView = this.mContent.findViewById(2131372166);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.mContent.findViewById(2131366232));
    Object localObject = this.mContent.findViewById(2131366231);
    ((View)localObject).setOnClickListener(new ahej(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new ahdv(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new ahdw(this));
    if (this.mActivity.getIntent().getBooleanExtra("crm_ivr_aio_video_action_sheet", false)) {
      npt.a(this.app, this.mActivity, this.sessionInfo);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mAIORootView.findViewById(2131373109));
      localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.mFunBtn.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      ((LinearLayout.LayoutParams)localObject).topMargin = 1;
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.mFunBtn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.input.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = 1;
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      this.input.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366233));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (CustomMenuBar.a())
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.mActivity.getResources().getColor(2131167162));
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.dp2px(48.0F, this.mActivity.getResources()));
      }
      this.d = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131372779));
      this.d.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131365953));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847816);
        this.d.setImageResource(2130838053);
      }
      if (this.input != null)
      {
        AIOUtils.setViewDrawalbe(this.input, 2130849901);
        if (CustomMenuBar.a()) {
          this.mInputBar.setBackgroundColor(this.mActivity.getResources().getColor(2131167162));
        }
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "We needn't show video action sheet, because isShowVideoActionSheet is false");
      }
    }
  }
  
  private void o()
  {
    if (ChatActivityUtils.a(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin, this.sessionInfo.phoneNum)) {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "checkNavigationMenuUpdate msg shielded");
      }
    }
    while (this.h) {
      return;
    }
    this.h = true;
    long l1 = Long.parseLong(this.sessionInfo.curFriendUin);
    PubAccountNavigationMenu localPubAccountNavigationMenu = ((bini)this.app.getBusinessHandler(105)).a(this.sessionInfo.curFriendUin);
    bing localbing = (bing)this.app.getBusinessHandler(85);
    long l2 = this.app.getLongAccountUin();
    if (localPubAccountNavigationMenu != null) {}
    for (int j = localPubAccountNavigationMenu.version;; j = 0)
    {
      localbing.a(l1, l2, j, this.jdField_b_of_type_Int, false);
      return;
    }
  }
  
  public StructMsg.ButtonInfo a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int j = 0;
    for (;;)
    {
      if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label156;
      }
      StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)this.jdField_a_of_type_JavaUtilList.get(j);
      localObject = localButtonInfo;
      if (localButtonInfo.id.get() == paramInt) {
        break;
      }
      localObject = localButtonInfo.sub_button.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int k = 0;
        while (k < ((List)localObject).size())
        {
          if (((StructMsg.ButtonInfo)((List)localObject).get(k)).id.get() == paramInt) {
            return (StructMsg.ButtonInfo)((List)localObject).get(k);
          }
          k += 1;
        }
      }
      j += 1;
    }
    label156:
    return null;
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(this.mActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.input.getLineCount() > 1))
    {
      b(80);
      return;
    }
    b(16);
  }
  
  public void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if ((paramPubAccountNavigationMenu != null) && (paramPubAccountNavigationMenu.xml != null) && (paramPubAccountNavigationMenu.xml.length() > 0) && (this.sessionInfo != null) && (this.sessionInfo.curFriendUin != null) && (this.sessionInfo.curFriendUin.equals(String.valueOf(paramPubAccountNavigationMenu.puin)))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQMessageFacade localQQMessageFacade = this.app.getMessageFacade();
        paramPubAccountNavigationMenu = bchh.a(this.app, this.sessionInfo.curType, Long.parseLong(this.sessionInfo.curFriendUin), paramPubAccountNavigationMenu.xml.getBytes(), 0);
        if (paramPubAccountNavigationMenu != null)
        {
          long l = bbjb.a;
          paramPubAccountNavigationMenu = bbli.a(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curFriendUin, this.sessionInfo.curFriendUin, this.sessionInfo.curType, l, paramPubAccountNavigationMenu);
          if (paramPubAccountNavigationMenu != null)
          {
            paramPubAccountNavigationMenu.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
            localQQMessageFacade.addMessage(paramPubAccountNavigationMenu, this.app.getCurrentAccountUin());
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
  
  public void a(String paramString)
  {
    PubAccountNavigationMenu localPubAccountNavigationMenu;
    if ((this.app != null) && (this.sessionInfo != null))
    {
      localPubAccountNavigationMenu = ((bini)this.app.getBusinessHandler(105)).a(this.sessionInfo.curFriendUin);
      if (!"1".equals(paramString)) {
        break label108;
      }
      l1 = Long.parseLong(this.sessionInfo.curFriendUin);
      paramString = (bing)this.app.getBusinessHandler(85);
      l2 = this.app.getLongAccountUin();
      if (localPubAccountNavigationMenu == null) {
        break label103;
      }
      j = localPubAccountNavigationMenu.version;
      paramString.a(l1, l2, j, 0, true);
    }
    label103:
    label108:
    while (localPubAccountNavigationMenu == null) {
      for (;;)
      {
        long l1;
        long l2;
        return;
        int j = 0;
      }
    }
    a(localPubAccountNavigationMenu);
  }
  
  public void a(List<StructMsg.ButtonInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      this.mInputBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      int k = paramList.size();
      int j = 0;
      while ((j < k) && (j <= 2))
      {
        Object localObject = (StructMsg.ButtonInfo)paramList.get(j);
        zvc localzvc = new zvc(((StructMsg.ButtonInfo)localObject).key.get(), ((StructMsg.ButtonInfo)localObject).name.get(), null, ((StructMsg.ButtonInfo)localObject).id.get());
        if (((StructMsg.ButtonInfo)localObject).sub_button.get().size() > 0)
        {
          localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)((Iterator)localObject).next();
            localzvc.a(new zvc(localButtonInfo.key.get(), localButtonInfo.name.get(), null, localButtonInfo.id.get()));
          }
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localzvc, getCurFriendUin());
        j += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin))
    {
      if (paramBoolean)
      {
        this.root.a();
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
        this.mInputBar.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addObserver(this.jdField_b_of_type_Amwl);
    this.app.addObserver(this.jdField_a_of_type_Amrj);
    this.app.addObserver(this.jdField_c_of_type_Amwl);
    this.app.addObserver(this.jdField_a_of_type_Amyh);
    this.app.addObserver(this.jdField_a_of_type_Anax);
    this.app.addObserver(this.jdField_a_of_type_Binf);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (!bily.b(this.app, this.sessionInfo.curFriendUin)) {
      a(paramEditable);
    }
  }
  
  void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.input.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.input.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.mFunBtn.getLayoutParams();
    } while (localLayoutParams.gravity == paramInt);
    localLayoutParams.gravity = paramInt;
    this.mFunBtn.setLayoutParams(localLayoutParams);
  }
  
  protected boolean b()
  {
    amxz localamxz;
    long l1;
    if ((this.sessionInfo.curType == 1024) && (!nns.b(this.mContext, this.sessionInfo.curFriendUin)))
    {
      boolean bool = this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "showOrHideFollow isQidianMasterInCache: " + bool);
      }
      if (bool) {
        return !this.jdField_a_of_type_Amsw.b(this.sessionInfo.curFriendUin);
      }
      localamxz = (amxz)this.app.getManager(56);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.sessionInfo.curFriendUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label134:
      break label134;
    }
    if (!localamxz.a(Long.valueOf(l1))) {
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    if (!this.jdField_b_of_type_Bily.g(this.sessionInfo.curFriendUin))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView don't request qidian master, so wait request show");
      }
      return;
    }
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView true");
      }
      d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateFollowAndShieldView false");
    }
    e();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showFollowAndShield() ==== called.");
    }
    Object localObject = this.sessionInfo.curFriendUin;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      ahed localahed = new ahed(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.mContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362539);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.app.getApplication().getResources().getDimension(2131297076));
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131299076);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      this.jdField_b_of_type_AndroidViewView = this.mActivity.getLayoutInflater().inflate(2131559991, null);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.app.getApplication().getResources().getDrawable(2130838313));
      this.jdField_b_of_type_AndroidViewView.findViewById(2131370725).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370728));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.app.getApplication().getResources().getColorStateList(2131167088));
      ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370716)).setImageResource(2130841768);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(localahed);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams1);
      View localView = this.mActivity.getLayoutInflater().inflate(2131559991, null);
      localView.setBackgroundDrawable(this.app.getApplication().getResources().getDrawable(2130838313));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370728));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.app.getApplication().getResources().getColorStateList(2131167088));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.mContext.getString(2131691687));
      ((ImageView)localView.findViewById(2131370716)).setImageResource(2130841661);
      localView.setTag(Integer.valueOf(3));
      localView.setOnClickListener(localahed);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams1);
      ((RelativeLayout.LayoutParams)this.listView.getLayoutParams()).addRule(3, 2131362539);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131299076);
      this.afRoot.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    }
    if (ChatActivityUtils.a(this.app, this.sessionInfo.curType, (String)localObject, this.sessionInfo.phoneNum))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.mContext.getString(2131689957));
      this.jdField_b_of_type_AndroidViewView.setTag(Integer.valueOf(1));
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.mContext.getString(2131689843));
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      try
      {
        this.listView.removeHeaderView(this.headView);
        if (this.mTipRoot != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.mTipRoot.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.mActivity.getResources().getDimension(2131297076) + (int)this.mActivity.getResources().getDimension(2131299076));
          this.mTipRoot.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.mContext.getString(2131691689));
        this.jdField_b_of_type_AndroidViewView.setTag(Integer.valueOf(2));
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
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.needAutoInput = false;
    this.jdField_b_of_type_Bily = ((bily)this.app.getManager(165));
    this.jdField_a_of_type_Amsw = ((amsw)this.app.getManager(51));
    super.doOnCreate(paramBoolean);
    if (!this.mActivity.isFinishing())
    {
      n();
      if (!this.jdField_b_of_type_Bily.f(getCurFriendUin()))
      {
        h();
        argw.a(this.app).a(this.app, getCurFriendUin(), false);
      }
    }
    this.g = this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin);
    j();
    Object localObject;
    if (!this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin))
    {
      this.mActivity.sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
      localObject = new ahec(this);
      npt.a(this.app, this.mActivity, this.sessionInfo.curFriendUin, this.sessionInfo.curType, (BusinessObserver)localObject);
      if (this.panelicons != null)
      {
        this.panelicons.setCustomHeight(0);
        m();
      }
    }
    for (;;)
    {
      l();
      k();
      return true;
      localObject = new BmqqAccountType(this.sessionInfo.curFriendUin, 6);
      this.jdField_b_of_type_Bily.a(this.mActivity, (BmqqAccountType)localObject);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.mInputBar != null))
    {
      this.mInputBar.removeView(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_b_of_type_AndroidWidgetImageView = null;
    }
    if ((this.jdField_b_of_type_Bily != null) && (this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin))) {
      ((bing)this.app.getBusinessHandler(85)).a(this.sessionInfo.curFriendUin, null, true);
    }
    if (this.mInputBar != null) {
      this.mInputBar.setPadding(this.mInputBar.getPaddingLeft(), this.mInputBar.getPaddingTop(), this.mInputBar.getPaddingRight(), 0);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    k();
  }
  
  public void doOnNewIntent_clearBusinessData()
  {
    super.doOnNewIntent_clearBusinessData();
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.mInputBar != null))
    {
      this.mInputBar.removeView(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_b_of_type_AndroidWidgetImageView = null;
    }
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    }
  }
  
  public void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTipRoot.getLayoutParams();
    int k = (int)this.mActivity.getResources().getDimension(2131299076);
    int j = k;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      j = k;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        j = k + (int)this.mActivity.getResources().getDimension(2131297076);
      }
    }
    localLayoutParams.topMargin = j;
    this.mTipRoot.setLayoutParams(localLayoutParams);
  }
  
  public void doPanelChanged(int paramInt1, int paramInt2)
  {
    super.doPanelChanged(paramInt1, paramInt2);
    g();
    if (paramInt2 == 8) {
      if (this.d != null)
      {
        if (!CustomMenuBar.a()) {
          break label40;
        }
        this.d.setImageResource(2130849847);
      }
    }
    label40:
    while (this.d == null)
    {
      return;
      this.d.setImageResource(2130849769);
      return;
    }
    if (CustomMenuBar.a())
    {
      this.d.setImageResource(2130849846);
      return;
    }
    this.d.setImageResource(2130849768);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    try
    {
      if (this.listView.getHeaderViewsCount() == 0) {
        this.listView.addHeaderView(this.headView);
      }
      if (this.mTipRoot != null)
      {
        int j = (int)this.mActivity.getResources().getDimension(2131299076);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTipRoot.getLayoutParams();
        localLayoutParams.topMargin = j;
        this.mTipRoot.setLayoutParams(localLayoutParams);
      }
      return;
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
  
  void f()
  {
    ChatActivityUtils.a(this.mActivity);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow");
    }
    ((FriendListHandler)this.app.getBusinessHandler(1)).getFriendInfo(this.sessionInfo.curFriendUin);
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.mActivity.getApplicationContext(), odw.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(2);
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.sessionInfo.curFriendUin));
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new ahee(this);
    this.jdField_a_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.app.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow exit");
    }
  }
  
  @TargetApi(11)
  protected void g()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.mInputStat != 1) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844722);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.isHoneycomb());
    this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.mInputStat == 2)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.isHoneycomb()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.root.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849798);
        }
        for (;;)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getString(2131697893));
          return;
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850234);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849797);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getString(2131697892));
        return;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850235);
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.root.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849798);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getString(2131697893));
        label246:
        if (!VersionUtils.isHoneycomb()) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850234);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849797);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getString(2131697892));
      break label246;
      break;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850235);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    List localList = argw.a(this.app).a(this.app, getCurFriendUin());
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(localList);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      a(true);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilList);
      return;
      a(false);
    }
  }
  
  public void hideAddFriendAndShield()
  {
    super.hideAddFriendAndShield();
    if (this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin)) {
      e();
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject;
    if (!this.mActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (amxz)this.app.getManager(56);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((amxz)localObject).c(this.sessionInfo.curFriendUin);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
      localObject = new NewIntent(this.mActivity.getApplicationContext(), nma.class);
      ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(1);
      localGetEqqDetailInfoRequest.seqno.set(0);
      try
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.sessionInfo.curFriendUin));
        label160:
        ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new ahdy(this));
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail");
        }
        this.app.startServlet((NewIntent)localObject);
      }
      catch (Exception localException)
      {
        break label160;
      }
    }
  }
  
  public void j()
  {
    try
    {
      String str = this.sessionInfo.curFriendUin;
      Object localObject = this.app.getMessageFacade().getMsgList(str, 0);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018) || (localMessageRecord.msgtype == -2019) || (localMessageRecord.msgtype == -7006)) {
            this.app.getMessageFacade().removeMsgByUniseq(str, 0, localMessageRecord.uniseq);
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
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessChatPie", 2, "checkNavigationMenuUpdate");
    }
    this.jdField_b_of_type_Int = initHaveUnRead();
    if (TextUtils.isEmpty(this.sessionInfo.curFriendUin)) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (Math.abs(l - this.jdField_a_of_type_Long) < 1000L);
      this.jdField_a_of_type_Long = l;
      this.h = false;
    } while (!this.jdField_b_of_type_Bily.c(this.sessionInfo.curFriendUin, false));
    o();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.c();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366233) {
      a(true);
    }
    afqg localafqg;
    if ((paramView.getId() == 2131365953) && (this.mInputStat != 1))
    {
      if (this.root.a() == 3)
      {
        this.root.a(1);
        bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
    }
    else if (paramView.getId() == 2131372779)
    {
      ShortVideoUtils.loadShortVideoSo(this.app);
      localafqg = (afqg)getHelper(83);
      if (this.root.a() != 8) {
        break label215;
      }
      if (this.d != null) {
        this.d.setContentDescription(this.app.getApplication().getString(2131689928));
      }
      localafqg.b(true);
      this.root.a(1);
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.root.a(3);
      bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      label215:
      localafqg.b();
      this.root.a(8);
      if (this.d != null) {
        this.d.setContentDescription(this.app.getApplication().getString(2131689851));
      }
      setInputStat(0);
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
    m();
  }
  
  public void openOptionActivity()
  {
    int j = 0;
    if (this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin))
    {
      Intent localIntent = new Intent(this.mContext, ChatSettingActivity.class);
      localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
      localIntent.putExtra("uinname", this.sessionInfo.curFriendNick);
      if (this.jdField_a_of_type_Amsw.b(this.sessionInfo.curFriendUin)) {}
      for (;;)
      {
        localIntent.putExtra("uintype", j);
        this.mActivity.startActivityForResult(localIntent, 2000);
        return;
        j = this.sessionInfo.curType;
      }
    }
    bcef.b(this.app, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.sessionInfo.curFriendUin, "", "", "");
    npt.a(this.mActivity, null, this.sessionInfo.curFriendUin, true, -1, true, 2000);
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_b_of_type_Amwl);
    this.app.removeObserver(this.jdField_a_of_type_Amrj);
    this.app.removeObserver(this.jdField_c_of_type_Amwl);
    this.app.removeObserver(this.jdField_a_of_type_Amyh);
    this.app.removeObserver(this.jdField_a_of_type_Anax);
    this.app.removeObserver(this.jdField_a_of_type_Binf);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void reportSendPttEvent(int paramInt1, int paramInt2)
  {
    super.reportSendPttEvent(paramInt1, paramInt2);
    agwt.a(this.app, "0X8008AAA", "C_Master_PTT", this.sessionInfo, getAudioPanelType(paramInt1), paramInt2);
  }
  
  public void updateAddFriendAndShieldView()
  {
    if (this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin)) {
      c();
    }
  }
  
  public void updateSession(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.updateSession(paramIntent);
    if (!this.jdField_b_of_type_Bily.f(this.sessionInfo.curFriendUin))
    {
      i();
      if (this.panelicons != null)
      {
        this.panelicons.setCustomHeight(0);
        m();
      }
    }
  }
  
  public void updateSession_business(Intent paramIntent)
  {
    bfzg.a(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "From chatActivity : buinessCrm Sigt--->" + HexUtil.bytes2HexStr(paramIntent));
    }
    if (paramIntent != null)
    {
      this.app.getMsgCache().d(this.sessionInfo.curFriendUin, paramIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("BusinessChatPie", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    bfzg.a("AIO_updateSession_business", null);
  }
  
  public boolean updateSession_updateSimpleBar()
  {
    return true;
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    super.updateSession_updateTitle(paramIntent);
    this.mSingleTitle = true;
    paramIntent = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
    if ((this.sessionInfo.curType == 1024) && ((paramIntent == null) || (paramIntent.equals(this.sessionInfo.curFriendUin)))) {
      this.friendListHandler.getFriendInfo(this.sessionInfo.curFriendUin);
    }
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    if (this.jdField_b_of_type_Bily.c(this.sessionInfo.curFriendUin))
    {
      this.mTitleBtnCall.setOnClickListener(new aheh(this));
      if (maq.a().a(this.app.getCurrentAccountUin()))
      {
        this.mTitleBtnCall.setVisibility(0);
        this.mTitleBtnCall.setContentDescription(this.mActivity.getResources().getString(2131697974));
        return;
      }
      this.mTitleBtnCall.setVisibility(8);
      return;
    }
    this.mTitleBtnCall.setVisibility(8);
  }
  
  public void updateSession_updateTitleRightView()
  {
    updateViewForTheme(this.mTitleBtnRight, 2130850056, 2130850057);
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    super.updateSession_updateUI(paramIntent);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdt
 * JD-Core Version:    0.7.0.1
 */