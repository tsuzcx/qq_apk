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

public class aikq
  extends ailn
  implements axxs
{
  protected boolean Z;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aile(this);
  protected axxr a;
  bitz jdField_a_of_type_Bitz;
  biun jdField_a_of_type_Biun = new aikx(this);
  public biup a;
  GameQuickWordsPanel jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
  public WereWolvesLoadingView a;
  protected boolean aa;
  protected boolean ab = true;
  boolean ac = false;
  boolean ad = true;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new ailf(this);
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aili(this);
  protected LinearLayout b;
  bjbs d;
  protected RelativeLayout f;
  protected ImageView l;
  protected TextView l;
  protected ImageView m;
  protected TextView m;
  public View n;
  View o;
  int q;
  int r;
  private final int s = Color.parseColor("#00000000");
  
  public aikq(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_Biup != null) {
      this.jdField_a_of_type_Biup.a(this);
    }
    if ((this.M) || (!this.ac))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    super.H();
    this.ac = false;
    if (this.aa) {
      this.jdField_a_of_type_Bitz.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new ailj(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Biun);
    ((View)this.jdField_d_of_type_AndroidViewViewGroup.getParent()).setBackgroundColor(0);
    a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167048), true);
    try
    {
      if ((this.jdField_d_of_type_Bjbs != null) && (this.jdField_d_of_type_Bjbs.isShowing()))
      {
        this.jdField_d_of_type_Bjbs.dismiss();
        this.jdField_d_of_type_Bjbs = null;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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
  
  public void M()
  {
    super.M();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label19:
      biuo localbiuo;
      break label19;
    }
    localbiuo = this.jdField_a_of_type_Biup.a();
    if ((localbiuo != null) && (HotChatManager.jdField_a_of_type_Boolean)) {
      localbiuo.c();
    }
    HotChatManager.jdField_a_of_type_Boolean = true;
    if (((this.jdField_a_of_type_Biup.b()) || (!this.Z)) && (!this.aa) && (this.ad))
    {
      this.jdField_a_of_type_Axxr.a(1, null, l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if ((localbiuo != null) && (localbiuo.b())) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "mini_ball", 0, 0, "", "", "", "");
      }
    }
    this.ad = true;
    this.jdField_a_of_type_Axxr.jdField_a_of_type_Boolean = false;
  }
  
  public void N()
  {
    super.N();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    }
  }
  
  public void P()
  {
    super.P();
    this.jdField_a_of_type_Axxr.d();
    this.jdField_a_of_type_Axxr.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Axxr.d = false;
    if (!this.jdField_a_of_type_Axxr.a()) {
      this.jdField_a_of_type_Axxr.a(this);
    }
    biuo localbiuo = this.jdField_a_of_type_Biup.a();
    if (localbiuo != null) {
      localbiuo.d();
    }
  }
  
  protected View a()
  {
    GameView localGameView = new GameView(this.jdField_a_of_type_AndroidContentContext, this);
    localGameView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.n = localGameView;
    return localGameView;
  }
  
  public View a(int paramInt)
  {
    View localView = super.a(paramInt);
    Object localObject = localView;
    if (localView == null)
    {
      localObject = localView;
      if (paramInt == 25)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel = ((GameQuickWordsPanel)View.inflate(a(), 2131558606, null));
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
      }
    }
    return localObject;
  }
  
  public HashMap<String, Integer> a()
  {
    biuo localbiuo = this.jdField_a_of_type_Biup.a();
    if (localbiuo == null) {
      return new HashMap();
    }
    return localbiuo.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "Q.werewolf.GameRoomChatPie";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_Biup.a();
    if (localObject != null)
    {
      localObject = ((biuo)localObject).b();
      if (localObject == null) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "onPanelChanged: drawables == null");
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      this.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIconOn"));
      return;
    }
    this.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIcon"));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.aa = paramIntent.getExtras().getBoolean("isNeedFinish");
      if (this.aa) {
        this.jdField_a_of_type_Axxr.a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l1 = ((Long)axws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(0L))).longValue();
    if (paramList.size() != 0)
    {
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage.time < l1) {
          paramList.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          if ((((localChatMessage instanceof MessageForGrayTips)) || ((localChatMessage instanceof MessageForNewGrayTips))) && (!(localChatMessage instanceof MessageForTroopGift))) {
            paramList.remove(i);
          }
        }
      }
    }
    super.a(paramList, paramCharSequence, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramCharSequence = (ChatMessage)paramList.next();
      if ((this.jdField_a_of_type_Bitz.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Bitz.jdField_a_of_type_JavaLangString.equals(paramCharSequence.senderuin))) {
        paramCharSequence.isFlowMessage = false;
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Axxr = axxr.a();
    this.jdField_a_of_type_Bitz = ((bitz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107));
    this.jdField_a_of_type_Biup = this.jdField_a_of_type_Bitz.a((String)localObject);
    super.a(paramBoolean);
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (!Settings.canDrawOverlays((Context)localObject))
      {
        i = 0;
        ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        b(1);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
      this.ac = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Biun);
      this.jdField_a_of_type_Axxr.a(this.jdField_a_of_type_AndroidContentContext);
      localObject = new IntentFilter("tencent.av.v2q.StartVideoChat");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.werewoves.plugin");
      try
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return true;
      }
      i = 1;
    }
  }
  
  public void aJ()
  {
    super.aJ();
    Object localObject = this.jdField_a_of_type_Biup.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((biuo)localObject).b();
    } while ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) || (localObject == null));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("textIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void aV() {}
  
  public void bA()
  {
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    biuo localbiuo = this.jdField_a_of_type_Biup.a();
    if (localbiuo == null) {
      return;
    }
    int i = localbiuo.b();
    int j = localbiuo.a();
    this.jdField_a_of_type_Bitz.a(localHotChatInfo, i, j, new ailg(this));
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "wolf", "die_newgame", 0, 0, "" + i, "" + j, "", "");
  }
  
  public void bt()
  {
    if ((this.aa) || (E())) {}
    do
    {
      return;
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Axxr.a(l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is null");
  }
  
  public void bu() {}
  
  public void bv()
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = new WereWolvesLoadingView(a());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable((Drawable)localObject);
    if (a().getIntent().getBooleanExtra("isNeedShowLoading", true))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
    }
    if (this.jdField_a_of_type_Biup.a())
    {
      bw();
      return;
    }
    ThreadManager.post(new GameRoomChatPie.15(this), 8, null, true);
  }
  
  public void bw()
  {
    ThreadManager.post(new GameRoomChatPie.16(this), 8, null, true);
  }
  
  public void bx()
  {
    Intent localIntent = new Intent(a(), QQBrowserActivity.class);
    this.ad = false;
    localIntent.putExtra("url", "https://nearby.qq.com/werewolf/game-rules.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0");
    HotChatManager.jdField_a_of_type_Boolean = false;
    a().startActivity(localIntent);
  }
  
  public void by()
  {
    blir localblir = (blir)blji.a(a(), null);
    localblir.a(anzj.a(2131703988));
    localblir.a(anzj.a(2131703975), 3);
    localblir.c(2131690580);
    localblir.a(new ailc(this, localblir));
    localblir.show();
  }
  
  public void bz()
  {
    Object localObject = this.jdField_a_of_type_Biup.a();
    if (localObject == null) {
      return;
    }
    localObject = ((biuo)localObject).b();
    this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("audioIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e(int paramInt)
  {
    super.e(paramInt);
    this.jdField_a_of_type_Axxr.a(paramInt);
    biuo localbiuo = this.jdField_a_of_type_Biup.a();
    if (localbiuo != null) {
      localbiuo.a(paramInt);
    }
  }
  
  public void e(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690384);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131704016));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.c = false;
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.V = paramBoolean1;
    this.jdField_a_of_type_Bitz.jdField_a_of_type_Boolean = paramBoolean1;
    a(0, true);
    a().setImmersiveStatus(0);
    biuo localbiuo = this.jdField_a_of_type_Biup.a();
    if (localbiuo == null) {}
    label651:
    label661:
    for (;;)
    {
      return;
      HashMap localHashMap1 = localbiuo.b();
      HashMap localHashMap2 = localbiuo.a();
      if ((localHashMap1 != null) && (localHashMap2 != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(0);
        this.k.setVisibility(8);
        this.k.setScaleX(0.0F);
        Drawable localDrawable = (Drawable)localHashMap1.get("aioBg");
        View localView = (View)this.jdField_d_of_type_AndroidViewViewGroup.getParent();
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundColor(0);
        localView.setBackgroundDrawable(localDrawable);
        a(0, true);
        this.jdField_l_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localHashMap1.get("inputBg"));
        this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap2.get("pressTipsColor")).intValue());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable((Drawable)localHashMap1.get("sendBtnBg"));
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setTextColor(((Integer)localHashMap2.get("sendBtnColor")).intValue());
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
        {
          this.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIconOn"));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(((Integer)localHashMap2.get("bottomBarColor")).intValue());
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)localHashMap2.get("quickWordBgColor")).intValue());
          }
          if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
            break label599;
          }
          this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("textIcon"));
          label317:
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130839624);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a();
          }
          this.e.setTextColor(((Integer)localHashMap2.get("titleColor")).intValue());
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap2.get("leftTextColor")).intValue());
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localHashMap1.get("backIcon"));
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("rightMenu"));
          if (!paramBoolean1) {
            break label620;
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(0.2F);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(false);
          label450:
          if (!paramBoolean1) {
            break label651;
          }
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if ((!paramBoolean2) || (localbiuo.c())) {
            break label639;
          }
          this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_m_of_type_AndroidWidgetTextView.setBackgroundColor(((Integer)localHashMap2.get("wolfBtnBg")).intValue());
          this.r = ((Integer)localHashMap2.get("wolfBtnTextPress")).intValue();
          this.q = ((Integer)localHashMap2.get("wolfBtnText")).intValue();
          this.jdField_m_of_type_AndroidWidgetTextView.setTextColor(this.q);
        }
        for (;;)
        {
          if (this.o == null) {
            break label661;
          }
          this.o.setBackgroundColor(((Integer)localHashMap2.get("bottomBarMask")).intValue());
          return;
          this.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIcon"));
          break;
          label599:
          this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("audioIcon"));
          break label317;
          label620:
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(1.0F);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(true);
          break label450;
          label639:
          this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
    }
  }
  
  public void f()
  {
    int j = 0;
    super.f();
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i;
    if ((localObject == null) || (((String)localObject).equals("1000")))
    {
      i = 1;
      a(-1, true);
      a(0, true);
      a().setImmersiveStatus(0);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 295.0F);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setGravity(16);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131369982);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(16);
      new RelativeLayout.LayoutParams(-1, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 50.0F)).addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 0.0F));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(true);
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(-1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130838076);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((this.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent() instanceof LinearLayout))
      {
        localObject = (LinearLayout)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.gravity = 16;
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
      int k = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_l_of_type_AndroidWidgetImageView.setPadding(k, k, k, k);
      this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_l_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.jdField_m_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130838121);
      this.jdField_m_of_type_AndroidWidgetImageView.setPadding(0, k, 0, k);
      this.jdField_m_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_m_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.jdField_l_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_l_of_type_AndroidWidgetTextView.setGravity(17);
      if (i == 0) {
        break label1045;
      }
      this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a1a2a3"));
      label588:
      this.jdField_l_of_type_AndroidWidgetTextView.setBackgroundResource(2130849843);
      this.jdField_l_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_l_of_type_AndroidWidgetTextView.setText(anzj.a(2131704023));
      this.jdField_l_of_type_AndroidWidgetTextView.setMinHeight(bhgr.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
      this.jdField_l_of_type_AndroidWidgetTextView.setEnabled(false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 86.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_l_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_l_of_type_AndroidWidgetTextView.setOnTouchListener(new aikr(this));
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aikz(this));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 295.0F);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.s);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_f_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_m_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_m_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_m_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_m_of_type_AndroidWidgetTextView.setText(anzj.a(2131704037));
      this.jdField_m_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = new RelativeLayout.LayoutParams(-1, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_m_of_type_AndroidWidgetTextView.setOnTouchListener(new ailh(this));
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_m_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 245.0F));
      ((RelativeLayout.LayoutParams)localObject).topMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      i = j;
      label982:
      if (i >= this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount()) {
        break label1091;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i) != this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout) {
        break label1068;
      }
    }
    for (;;)
    {
      if (i >= 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(a(), i, (ViewGroup.LayoutParams)localObject);
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        bv();
        return;
        i = 0;
        break;
        label1045:
        this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167090));
        break label588;
        label1068:
        i += 1;
        break label982;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(a(), (ViewGroup.LayoutParams)localObject);
      }
      label1091:
      i = -1;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    biuo localbiuo = this.jdField_a_of_type_Biup.a();
    if (localbiuo == null)
    {
      super.f(paramBoolean);
      return;
    }
    if (!this.jdField_a_of_type_Biup.b())
    {
      super.f(paramBoolean);
      this.Z = true;
      this.aa = true;
      return;
    }
    if ((localbiuo.b()) && (localbiuo.c()))
    {
      super.f(paramBoolean);
      this.Z = true;
      return;
    }
    if ((localbiuo.b()) && (!localbiuo.c()))
    {
      bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, null, anzj.a(2131704024), anzj.a(2131703970), anzj.a(2131704003), new aikt(this, paramBoolean), new aiku(this)).show();
      return;
    }
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, null, anzj.a(2131704000), anzj.a(2131703957), anzj.a(2131704011), new aikv(this, paramBoolean, localbiuo), new aikw(this)).show();
  }
  
  public void g(String paramString)
  {
    this.aa = true;
    this.ab = false;
    bhpc localbhpc = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
    localbhpc.setMessage(paramString);
    localbhpc.setPositiveButton(2131694098, new aiky(this));
    localbhpc.setOnDismissListener(new aila(this));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onKickOut! isStopped = " + this.ai);
    }
    if (!this.ai)
    {
      localbhpc.show();
      return;
    }
    this.ab = true;
    b(1);
  }
  
  public void h(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HalfScreenBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://nearby.qq.com/werewolf/gift.html").append("?_bid=2652&from=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&gc=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append("&toUin=").append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    axxr.a().d = true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 60) {
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public boolean i()
  {
    biuo localbiuo = this.jdField_a_of_type_Biup.a();
    if (localbiuo == null) {
      return super.i();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
      return super.i();
    }
    if ((this.jdField_a_of_type_Axzy != null) && (this.jdField_a_of_type_Axzy.a()))
    {
      aS();
      return true;
    }
    if (!this.jdField_a_of_type_Biup.b())
    {
      this.Z = true;
      this.aa = true;
      return super.i();
    }
    if ((localbiuo.b()) && (localbiuo.c()))
    {
      this.Z = true;
      return super.i();
    }
    if ((localbiuo.b()) && (!localbiuo.c()))
    {
      bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, null, anzj.a(2131703995), anzj.a(2131704021), anzj.a(2131704005), new ailk(this), new aill(this)).show();
      return true;
    }
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, null, anzj.a(2131704029), anzj.a(2131703985), anzj.a(2131703963), new ailm(this, localbiuo), new aiks(this)).show();
    return true;
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131693966, 0).a();
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131693966, 0).a();
  }
  
  public void p()
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageForGrayTips)) && (!(paramObject instanceof MessageForTroopGift))) {
      return;
    }
    super.update(paramObservable, paramObject);
  }
  
  public void v(boolean paramBoolean)
  {
    this.jdField_l_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    Object localObject;
    if (!paramBoolean)
    {
      aJ();
      this.jdField_a_of_type_Axxr.c();
      this.jdField_l_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_m_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
      biuo localbiuo = this.jdField_a_of_type_Biup.a();
      if (this.o == null)
      {
        this.o = new View(this.jdField_a_of_type_AndroidContentContext);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth() != 0)
        {
          localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight());
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.o, (ViewGroup.LayoutParams)localObject);
          this.o.setBackgroundColor(Color.parseColor("#77FFFFFF"));
          if (localbiuo != null)
          {
            localObject = localbiuo.a();
            this.o.setBackgroundColor(((Integer)((HashMap)localObject).get("bottomBarMask")).intValue());
          }
          label177:
          this.o.setVisibility(0);
          if ((localbiuo == null) || (!localbiuo.c())) {
            break label292;
          }
          this.jdField_l_of_type_AndroidWidgetTextView.setText(anzj.a(2131704020));
          label209:
          if (!this.V) {
            this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
        }
      }
    }
    label292:
    do
    {
      return;
      localObject = new RelativeLayout.LayoutParams(-1, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      break;
      localObject = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth();
      ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight();
      this.o.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label177;
      this.jdField_l_of_type_AndroidWidgetTextView.setText(anzj.a(2131703973));
      break label209;
      this.jdField_l_of_type_AndroidWidgetTextView.setText(anzj.a(2131703996));
      this.jdField_l_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_m_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    } while (this.o == null);
    this.o.setVisibility(8);
  }
  
  public void x()
  {
    blir localblir = (blir)blji.a(a(), null);
    biuo localbiuo = this.jdField_a_of_type_Biup.a();
    boolean bool;
    if (localbiuo != null)
    {
      bool = localbiuo.c();
      if (bool) {
        localblir.a(anzj.a(2131703954), 3);
      }
      if (!bool) {
        break label102;
      }
      localblir.c(anzj.a(2131704018));
    }
    for (;;)
    {
      localblir.c(anzj.a(2131704025));
      localblir.d(anzj.a(2131703979));
      localblir.a(new ailb(this, bool, localblir));
      localblir.show();
      return;
      bool = false;
      break;
      label102:
      localblir.a(anzj.a(2131703976), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikq
 * JD-Core Version:    0.7.0.1
 */