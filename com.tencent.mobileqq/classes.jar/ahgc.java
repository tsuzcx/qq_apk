import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.15;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.werewolves.GameView;
import com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class ahgc
  extends ahgz
  implements awla
{
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ahgq(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahgu(this);
  public View a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected awkz a;
  bhab jdField_a_of_type_Bhab;
  bhap jdField_a_of_type_Bhap = new ahgj(this);
  public bhar a;
  bhht jdField_a_of_type_Bhht;
  GameQuickWordsPanel jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
  public WereWolvesLoadingView a;
  int jdField_b_of_type_Int;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new ahgr(this);
  View jdField_b_of_type_AndroidViewView;
  protected ImageView b;
  protected TextView b;
  private final int c = Color.parseColor("#00000000");
  protected boolean i;
  protected boolean j;
  protected boolean k = true;
  boolean l = false;
  boolean m = true;
  
  public ahgc(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  protected View a()
  {
    GameView localGameView = new GameView(this.mContext, this);
    localGameView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.jdField_a_of_type_AndroidViewView = localGameView;
    return localGameView;
  }
  
  public HashMap<String, Integer> a()
  {
    bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
    if (localbhaq == null) {
      return new HashMap();
    }
    return localbhaq.a();
  }
  
  public void a(String paramString)
  {
    this.j = true;
    this.k = false;
    QQCustomDialog localQQCustomDialog = bfur.a(this.mActivity, 230);
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setPositiveButton(2131694201, new ahgk(this));
    localQQCustomDialog.setOnDismissListener(new ahgm(this));
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onKickOut! isStopped = " + this.r);
    }
    if (!this.r)
    {
      localQQCustomDialog.show();
      return;
    }
    this.k = true;
    finish(1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    Object localObject;
    if (!paramBoolean)
    {
      hideAllPanels();
      this.jdField_a_of_type_Awkz.c();
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      this.input.setEnabled(false);
      bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = new View(this.mContext);
        if (this.mInputBar.getMeasuredWidth() != 0)
        {
          localObject = new RelativeLayout.LayoutParams(this.mInputBar.getMeasuredWidth(), this.mInputBar.getMeasuredHeight());
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.mContent.addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
          this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#77FFFFFF"));
          if (localbhaq != null)
          {
            localObject = localbhaq.a();
            this.jdField_b_of_type_AndroidViewView.setBackgroundColor(((Integer)((HashMap)localObject).get("bottomBarMask")).intValue());
          }
          label177:
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((localbhaq == null) || (!localbhaq.c())) {
            break label292;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704249));
          label209:
          if (!this.e) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
        }
      }
    }
    label292:
    do
    {
      return;
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(this.mContext, 50.0F));
      break;
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.mInputBar.getMeasuredWidth();
      ((RelativeLayout.LayoutParams)localObject).height = this.mInputBar.getMeasuredHeight();
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label177;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704202));
      break label209;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704225));
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
      this.input.setEnabled(true);
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = paramBoolean1;
    this.jdField_a_of_type_Bhab.jdField_a_of_type_Boolean = paramBoolean1;
    setSystemBarColor(0, true);
    getActivity().setImmersiveStatus(0);
    bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
    if (localbhaq == null) {}
    label651:
    label661:
    for (;;)
    {
      return;
      HashMap localHashMap1 = localbhaq.b();
      HashMap localHashMap2 = localbhaq.a();
      if ((localHashMap1 != null) && (localHashMap2 != null))
      {
        this.mCustomTitleView.setBackgroundColor(0);
        this.titleBgView.setVisibility(8);
        this.titleBgView.setScaleX(0.0F);
        Drawable localDrawable = (Drawable)localHashMap1.get("aioBg");
        View localView = (View)this.afRoot.getParent();
        this.afRoot.setBackgroundColor(0);
        localView.setBackgroundDrawable(localDrawable);
        setSystemBarColor(0, true);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localHashMap1.get("inputBg"));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap2.get("pressTipsColor")).intValue());
        this.mFunBtn.setBackgroundDrawable((Drawable)localHashMap1.get("sendBtnBg"));
        this.mFunBtn.setTextColor(((Integer)localHashMap2.get("sendBtnColor")).intValue());
        if (this.root.a() == 3)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIconOn"));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(((Integer)localHashMap2.get("bottomBarColor")).intValue());
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)localHashMap2.get("quickWordBgColor")).intValue());
          }
          if (this.input.getVisibility() == 0) {
            break label599;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("textIcon"));
          label317:
          this.input.setBackgroundResource(2130839661);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a();
          }
          this.mTitleText.setTextColor(((Integer)localHashMap2.get("titleColor")).intValue());
          this.mSubTilteText.setVisibility(8);
          this.mTitleBtnLeft.setTextColor(((Integer)localHashMap2.get("leftTextColor")).intValue());
          this.mTitleBtnLeft.setBackgroundDrawable((Drawable)localHashMap1.get("backIcon"));
          this.mTitleBtnRight.setImageDrawable((Drawable)localHashMap1.get("rightMenu"));
          if (!paramBoolean1) {
            break label620;
          }
          this.listView.setAlpha(0.2F);
          this.listView.setEnabled(false);
          label450:
          if (!paramBoolean1) {
            break label651;
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if ((!paramBoolean2) || (localbhaq.c())) {
            break label639;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(((Integer)localHashMap2.get("wolfBtnBg")).intValue());
          this.jdField_b_of_type_Int = ((Integer)localHashMap2.get("wolfBtnTextPress")).intValue();
          this.jdField_a_of_type_Int = ((Integer)localHashMap2.get("wolfBtnText")).intValue();
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
        }
        for (;;)
        {
          if (this.jdField_b_of_type_AndroidViewView == null) {
            break label661;
          }
          this.jdField_b_of_type_AndroidViewView.setBackgroundColor(((Integer)localHashMap2.get("bottomBarMask")).intValue());
          return;
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIcon"));
          break;
          label599:
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("audioIcon"));
          break label317;
          label620:
          this.listView.setAlpha(1.0F);
          this.listView.setEnabled(true);
          break label450;
          label639:
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    Intent localIntent = new Intent(this.mContext, HalfScreenBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://nearby.qq.com/werewolf/gift.html").append("?_bid=2652&from=").append(this.app.getCurrentAccountUin()).append("&gc=").append(this.sessionInfo.curFriendUin).append("&toUin=").append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    if (!(this.mContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.mContext.startActivity(localIntent);
    awkz.a().d = true;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.j = paramIntent.getExtras().getBoolean("isNeedFinish");
      if (this.j) {
        this.jdField_a_of_type_Awkz.a(this.mContext);
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    Object localObject = this.mActivity.getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Awkz = awkz.a();
    this.jdField_a_of_type_Bhab = ((bhab)this.app.getBusinessHandler(107));
    this.jdField_a_of_type_Bhar = this.jdField_a_of_type_Bhab.a((String)localObject);
    super.doOnCreate(paramBoolean);
    int n;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = this.mActivity;
      if (!Settings.canDrawOverlays((Context)localObject))
      {
        n = 0;
        ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
      }
    }
    for (;;)
    {
      if (n == 0)
      {
        finish(1);
        return true;
      }
      this.sessionInfo.curFriendUin = this.mActivity.getIntent().getStringExtra("uin");
      this.l = true;
      this.app.addObserver(this.jdField_a_of_type_Bhap);
      this.jdField_a_of_type_Awkz.a(this.mContext);
      localObject = new IntentFilter("tencent.av.v2q.StartVideoChat");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.werewoves.plugin");
      try
      {
        this.mActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.mActivity.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return true;
      }
      n = 1;
    }
  }
  
  public void doOnCreate_initUI()
  {
    int i1 = 0;
    super.doOnCreate_initUI();
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.app);
    int n;
    if ((localObject == null) || (((String)localObject).equals("1000")))
    {
      n = 1;
      setSystemBarColor(-1, true);
      setSystemBarColor(0, true);
      getActivity().setImmersiveStatus(0);
      localObject = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.mContext, 295.0F);
      this.listView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.panelicons.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)this.mInputBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.dip2px(this.mContext, 50.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.mInputBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mInputBar.setGravity(16);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.mContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131369975);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
      new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(this.mContext, 50.0F)).addRule(12);
      this.mInputBar.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0);
      this.mInputBar.setPadding(0, 0, 0, DisplayUtil.dip2px(this.mContext, 0.0F));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      if (n != 0)
      {
        this.mInputBar.setBackgroundColor(-1);
        this.input.setBackgroundResource(2130838101);
      }
      this.input.setVisibility(4);
      localObject = (FrameLayout.LayoutParams)this.input.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      this.input.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mFunBtn.setVisibility(4);
      localObject = (LinearLayout.LayoutParams)this.mFunBtn.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.mFunBtn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((this.mFunBtn.getParent() instanceof LinearLayout))
      {
        localObject = (LinearLayout)this.mFunBtn.getParent();
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.gravity = 16;
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
      int i2 = DisplayUtil.dip2px(this.mContext, 5.0F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.mContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(i2, i2, i2, i2);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.mContext);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838146);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, i2, 0, i2);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.mContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      if (n == 0) {
        break label1045;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a1a2a3"));
      label588:
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849760);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704252));
      this.jdField_a_of_type_AndroidWidgetTextView.setMinHeight(DisplayUtil.dip2px(this.mContext, 35.0F));
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.mContext, 86.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(this.mContext, 10.0F);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.dip2px(this.mContext, 7.0F);
      this.mContent.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new ahgd(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.mContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new ahgl(this));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.mContext, 295.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.c);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.mContent.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.mContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131704266));
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(this.mContext, 50.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new ahgt(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(this.mContext, 245.0F));
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.mContext, 50.0F);
      n = i1;
      label982:
      if (n >= this.mContent.getChildCount()) {
        break label1091;
      }
      if (this.mContent.getChildAt(n) != this.mInputBar) {
        break label1068;
      }
    }
    for (;;)
    {
      if (n >= 0) {
        this.mContent.addView(a(), n, (ViewGroup.LayoutParams)localObject);
      }
      for (;;)
      {
        this.mSubTilteText.setVisibility(8);
        i();
        return;
        n = 0;
        break;
        label1045:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.mContext.getResources().getColor(2131167112));
        break label588;
        label1068:
        n += 1;
        break label982;
        this.mContent.addView(a(), (ViewGroup.LayoutParams)localObject);
      }
      label1091:
      n = -1;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Bhar != null) {
      this.jdField_a_of_type_Bhar.a(this);
    }
    if ((this.hasDestory) || (!this.l))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "hasDestory = true return");
      }
      return;
    }
    super.doOnDestroy();
    this.l = false;
    if (this.j) {
      this.jdField_a_of_type_Bhab.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new ahgv(this));
    }
    this.app.removeObserver(this.jdField_a_of_type_Bhap);
    ((View)this.afRoot.getParent()).setBackgroundColor(0);
    setSystemBarColor(this.mContext.getResources().getColor(2131167070), true);
    try
    {
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing()))
      {
        this.jdField_a_of_type_Bhht.dismiss();
        this.jdField_a_of_type_Bhht = null;
      }
      this.mActivity.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.mActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.sessionInfo.curFriendUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label19:
      bhaq localbhaq;
      break label19;
    }
    localbhaq = this.jdField_a_of_type_Bhar.a();
    if ((localbhaq != null) && (HotChatManager.jdField_a_of_type_Boolean)) {
      localbhaq.c();
    }
    HotChatManager.jdField_a_of_type_Boolean = true;
    if (((this.jdField_a_of_type_Bhar.b()) || (!this.i)) && (!this.j) && (this.m))
    {
      this.jdField_a_of_type_Awkz.a(1, null, l1, this.sessionInfo.curFriendNick);
      if ((localbhaq != null) && (localbhaq.b())) {
        bcef.b(this.app, "dc00899", "Grp_wolf", "", "in_game", "mini_ball", 0, 0, "", "", "", "");
      }
    }
    this.m = true;
    this.jdField_a_of_type_Awkz.jdField_a_of_type_Boolean = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Awkz.d();
    this.jdField_a_of_type_Awkz.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Awkz.d = false;
    if (!this.jdField_a_of_type_Awkz.a()) {
      this.jdField_a_of_type_Awkz.a(this);
    }
    bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
    if (localbhaq != null) {
      localbhaq.d();
    }
  }
  
  public void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    if (this.input.getVisibility() != 0) {
      this.mFunBtn.setVisibility(4);
    }
  }
  
  public void g()
  {
    if ((this.j) || (a())) {}
    do
    {
      return;
      try
      {
        long l1 = Long.parseLong(this.sessionInfo.curFriendUin);
        this.jdField_a_of_type_Awkz.a(l1, this.sessionInfo.curFriendNick);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e(this.tag, 2, "the sessionInfo.curFriendUin is null");
  }
  
  public void h() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 60) {
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void hideAllPanels()
  {
    super.hideAllPanels();
    Object localObject = this.jdField_a_of_type_Bhar.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((bhaq)localObject).b();
    } while ((this.input.getVisibility() != 0) || (localObject == null));
    this.input.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("textIcon"));
    this.input.setVisibility(4);
    this.mFunBtn.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = new WereWolvesLoadingView(getActivity());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable((Drawable)localObject);
    if (getActivity().getIntent().getBooleanExtra("isNeedShowLoading", true))
    {
      this.mContent.addView(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
    }
    if (this.jdField_a_of_type_Bhar.a())
    {
      j();
      return;
    }
    ThreadManager.post(new GameRoomChatPie.15(this), 8, null, true);
  }
  
  public boolean ifApolloFunAvailThenInit()
  {
    return false;
  }
  
  public void j()
  {
    ThreadManager.post(new GameRoomChatPie.16(this), 8, null, true);
  }
  
  public void k()
  {
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    this.m = false;
    localIntent.putExtra("url", "https://nearby.qq.com/werewolf/game-rules.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0");
    HotChatManager.jdField_a_of_type_Boolean = false;
    getActivity().startActivity(localIntent);
  }
  
  public void l()
  {
    bjnw localbjnw = (bjnw)bjon.a(getActivity(), null);
    localbjnw.a(amtj.a(2131704217));
    localbjnw.a(amtj.a(2131704204), 3);
    localbjnw.c(2131690620);
    localbjnw.a(new ahgo(this, localbjnw));
    localbjnw.show();
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
    if (localbhaq == null)
    {
      super.leftBackEvent(paramBoolean);
      return;
    }
    if (!this.jdField_a_of_type_Bhar.b())
    {
      super.leftBackEvent(paramBoolean);
      this.i = true;
      this.j = true;
      return;
    }
    if ((localbhaq.b()) && (localbhaq.c()))
    {
      super.leftBackEvent(paramBoolean);
      this.i = true;
      return;
    }
    if ((localbhaq.b()) && (!localbhaq.c()))
    {
      bfur.a(this.mContext, 230, null, amtj.a(2131704253), amtj.a(2131704199), amtj.a(2131704232), new ahgf(this, paramBoolean), new ahgg(this)).show();
      return;
    }
    bfur.a(this.mContext, 230, null, amtj.a(2131704229), amtj.a(2131704186), amtj.a(2131704240), new ahgh(this, paramBoolean, localbhaq), new ahgi(this)).show();
  }
  
  public void m()
  {
    Object localObject = this.jdField_a_of_type_Bhar.a();
    if (localObject == null) {
      return;
    }
    localObject = ((bhaq)localObject).b();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("audioIcon"));
    this.input.setVisibility(0);
    this.mFunBtn.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void n()
  {
    HotChatInfo localHotChatInfo = this.app.getHotChatMng(true).a(this.sessionInfo.curFriendUin);
    bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
    if (localbhaq == null) {
      return;
    }
    int n = localbhaq.b();
    int i1 = localbhaq.a();
    this.jdField_a_of_type_Bhab.a(localHotChatInfo, n, i1, new ahgs(this));
    bcef.b(this.app, "dc00899", "grp_lbs", "", "wolf", "die_newgame", 0, 0, "" + n, "" + i1, "", "");
  }
  
  public boolean onBackEvent()
  {
    bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
    if (localbhaq == null) {
      return super.onBackEvent();
    }
    if (this.root.a() != 0) {
      return super.onBackEvent();
    }
    if ((this.jdField_a_of_type_Awng != null) && (this.jdField_a_of_type_Awng.a()))
    {
      hideGiftPanel();
      return true;
    }
    if (!this.jdField_a_of_type_Bhar.b())
    {
      this.i = true;
      this.j = true;
      return super.onBackEvent();
    }
    if ((localbhaq.b()) && (localbhaq.c()))
    {
      this.i = true;
      return super.onBackEvent();
    }
    if ((localbhaq.b()) && (!localbhaq.c()))
    {
      bfur.a(this.mContext, 230, null, amtj.a(2131704224), amtj.a(2131704250), amtj.a(2131704234), new ahgw(this), new ahgx(this)).show();
      return true;
    }
    bfur.a(this.mContext, 230, null, amtj.a(2131704258), amtj.a(2131704214), amtj.a(2131704192), new ahgy(this, localbhaq), new ahge(this)).show();
    return true;
  }
  
  public View onCreatePanel(int paramInt)
  {
    View localView = super.onCreatePanel(paramInt);
    Object localObject = localView;
    if (localView == null)
    {
      localObject = localView;
      if (paramInt == 25)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel = ((GameQuickWordsPanel)View.inflate(getActivity(), 2131558609, null));
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a(this.app, this.sessionInfo, this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
      }
    }
    return localObject;
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    QQToast.a(this.mContext, 1, 2131694065, 0).a();
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    QQToast.a(this.mContext, 1, 2131694065, 0).a();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    super.onPanelChanged(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_Bhar.a();
    if (localObject != null)
    {
      localObject = ((bhaq)localObject).b();
      if (localObject == null) {
        QLog.e(this.tag, 1, "onPanelChanged: drawables == null");
      }
    }
    else
    {
      return;
    }
    if (this.root.a() == 3)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIconOn"));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIcon"));
  }
  
  public void onPhoneStateChange(int paramInt)
  {
    super.onPhoneStateChange(paramInt);
    this.jdField_a_of_type_Awkz.a(paramInt);
    bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
    if (localbhaq != null) {
      localbhaq.a(paramInt);
    }
  }
  
  public void openOptionActivity()
  {
    bjnw localbjnw = (bjnw)bjon.a(getActivity(), null);
    bhaq localbhaq = this.jdField_a_of_type_Bhar.a();
    boolean bool;
    if (localbhaq != null)
    {
      bool = localbhaq.c();
      if (bool) {
        localbjnw.a(amtj.a(2131704183), 3);
      }
      if (!bool) {
        break label102;
      }
      localbjnw.c(amtj.a(2131704247));
    }
    for (;;)
    {
      localbjnw.c(amtj.a(2131704254));
      localbjnw.d(amtj.a(2131704208));
      localbjnw.a(new ahgn(this, bool, localbjnw));
      localbjnw.show();
      return;
      bool = false;
      break;
      label102:
      localbjnw.a(amtj.a(2131704205), 3);
    }
  }
  
  public void setList(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l1 = ((Long)awka.a(this.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(0L))).longValue();
    if (paramList.size() != 0)
    {
      int n = paramList.size() - 1;
      if (n >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(n);
        if (localChatMessage.time < l1) {
          paramList.remove(n);
        }
        for (;;)
        {
          n -= 1;
          break;
          if ((((localChatMessage instanceof MessageForGrayTips)) || ((localChatMessage instanceof MessageForNewGrayTips))) && (!(localChatMessage instanceof MessageForTroopGift))) {
            paramList.remove(n);
          }
        }
      }
    }
    super.setList(paramList, paramCharSequence, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramCharSequence = (ChatMessage)paramList.next();
      if ((this.jdField_a_of_type_Bhab.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Bhab.jdField_a_of_type_JavaLangString.equals(paramCharSequence.senderuin))) {
        paramCharSequence.isFlowMessage = false;
      }
    }
  }
  
  public void setTag()
  {
    this.tag = "Q.werewolf.GameRoomChatPie";
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageForGrayTips)) && (!(paramObject instanceof MessageForTroopGift))) {
      return;
    }
    super.update(paramObservable, paramObject);
  }
  
  public void updateSession_updateSubTitle()
  {
    this.mSubTilteText.setVisibility(8);
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    this.mTitleBtnLeft.setText(2131690424);
    this.mTitleBtnLeft.setContentDescription(amtj.a(2131704245));
    this.mDefaultLeftBack.setVisibility(4);
    this.mTitleShowUnread = false;
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    super.updateSession_updateUI(paramIntent);
    this.mFunBtn.setVisibility(4);
  }
  
  public void updateUI_titleBarForTheme() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgc
 * JD-Core Version:    0.7.0.1
 */