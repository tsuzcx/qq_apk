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

public class agqq
  extends agrn
  implements auxq
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new agre(this);
  protected auxp a;
  bema jdField_a_of_type_Bema;
  bemo jdField_a_of_type_Bemo = new agqx(this);
  public bemq a;
  GameQuickWordsPanel jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
  public WereWolvesLoadingView a;
  protected boolean aa;
  protected boolean ab;
  protected boolean ac = true;
  boolean ad = false;
  boolean ae = true;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new agrf(this);
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new agri(this);
  protected LinearLayout c;
  bety d;
  protected RelativeLayout f;
  protected TextView l;
  protected TextView m;
  public View o;
  View p;
  protected ImageView p;
  int q;
  protected ImageView q;
  int r;
  private final int s = Color.parseColor("#00000000");
  
  public agqq(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_Bemq != null) {
      this.jdField_a_of_type_Bemq.a(this);
    }
    if ((this.N) || (!this.ad))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    super.H();
    this.ad = false;
    if (this.ab) {
      this.jdField_a_of_type_Bema.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new agrj(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bemo);
    ((View)this.jdField_d_of_type_AndroidViewViewGroup.getParent()).setBackgroundColor(0);
    a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166959), true);
    try
    {
      if ((this.jdField_d_of_type_Bety != null) && (this.jdField_d_of_type_Bety.isShowing()))
      {
        this.jdField_d_of_type_Bety.dismiss();
        this.jdField_d_of_type_Bety = null;
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
      bemp localbemp;
      break label19;
    }
    localbemp = this.jdField_a_of_type_Bemq.a();
    if ((localbemp != null) && (HotChatManager.jdField_a_of_type_Boolean)) {
      localbemp.c();
    }
    HotChatManager.jdField_a_of_type_Boolean = true;
    if (((this.jdField_a_of_type_Bemq.b()) || (!this.aa)) && (!this.ab) && (this.ae))
    {
      this.jdField_a_of_type_Auxp.a(1, null, l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if ((localbemp != null) && (localbemp.b())) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "mini_ball", 0, 0, "", "", "", "");
      }
    }
    this.ae = true;
    this.jdField_a_of_type_Auxp.jdField_a_of_type_Boolean = false;
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
    this.jdField_a_of_type_Auxp.d();
    this.jdField_a_of_type_Auxp.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Auxp.d = false;
    if (!this.jdField_a_of_type_Auxp.a()) {
      this.jdField_a_of_type_Auxp.a(this);
    }
    bemp localbemp = this.jdField_a_of_type_Bemq.a();
    if (localbemp != null) {
      localbemp.d();
    }
  }
  
  protected View a()
  {
    GameView localGameView = new GameView(this.jdField_a_of_type_AndroidContentContext, this);
    localGameView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.jdField_o_of_type_AndroidViewView = localGameView;
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel = ((GameQuickWordsPanel)View.inflate(a(), 2131558577, null));
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
      }
    }
    return localObject;
  }
  
  public HashMap<String, Integer> a()
  {
    bemp localbemp = this.jdField_a_of_type_Bemq.a();
    if (localbemp == null) {
      return new HashMap();
    }
    return localbemp.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "Q.werewolf.GameRoomChatPie";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_Bemq.a();
    if (localObject != null)
    {
      localObject = ((bemp)localObject).b();
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
      this.jdField_q_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIconOn"));
      return;
    }
    this.jdField_q_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIcon"));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.ab = paramIntent.getExtras().getBoolean("isNeedFinish");
      if (this.ab) {
        this.jdField_a_of_type_Auxp.a(this.jdField_a_of_type_AndroidContentContext);
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
    long l1 = ((Long)auwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(0L))).longValue();
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
      if ((this.jdField_a_of_type_Bema.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Bema.jdField_a_of_type_JavaLangString.equals(paramCharSequence.senderuin))) {
        paramCharSequence.isFlowMessage = false;
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Auxp = auxp.a();
    this.jdField_a_of_type_Bema = ((bema)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107));
    this.jdField_a_of_type_Bemq = this.jdField_a_of_type_Bema.a((String)localObject);
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
      this.ad = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bemo);
      this.jdField_a_of_type_Auxp.a(this.jdField_a_of_type_AndroidContentContext);
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
  
  public void aM()
  {
    super.aM();
    Object localObject = this.jdField_a_of_type_Bemq.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((bemp)localObject).b();
    } while ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) || (localObject == null));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_p_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("textIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    this.l.setVisibility(0);
  }
  
  public void aZ() {}
  
  public void bA()
  {
    Intent localIntent = new Intent(a(), QQBrowserActivity.class);
    this.ae = false;
    localIntent.putExtra("url", "http://nearby.qq.com/werewolf/game-rules.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0");
    HotChatManager.jdField_a_of_type_Boolean = false;
    a().startActivity(localIntent);
  }
  
  public void bB()
  {
    bhuf localbhuf = (bhuf)bhus.a(a(), null);
    localbhuf.a(alud.a(2131705485));
    localbhuf.a(alud.a(2131705472), 3);
    localbhuf.c(2131690648);
    localbhuf.a(new agrc(this, localbhuf));
    localbhuf.show();
  }
  
  public void bC()
  {
    Object localObject = this.jdField_a_of_type_Bemq.a();
    if (localObject == null) {
      return;
    }
    localObject = ((bemp)localObject).b();
    this.jdField_p_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("audioIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.l.setVisibility(4);
  }
  
  public void bD()
  {
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    bemp localbemp = this.jdField_a_of_type_Bemq.a();
    if (localbemp == null) {
      return;
    }
    int i = localbemp.b();
    int j = localbemp.a();
    this.jdField_a_of_type_Bema.a(localHotChatInfo, i, j, new agrg(this));
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "wolf", "die_newgame", 0, 0, "" + i, "" + j, "", "");
  }
  
  public void bw()
  {
    if ((this.ab) || (E())) {}
    do
    {
      return;
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Auxp.a(l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is null");
  }
  
  public void bx() {}
  
  public void by()
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = new WereWolvesLoadingView(a());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable((Drawable)localObject);
    if (a().getIntent().getBooleanExtra("isNeedShowLoading", true))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
    }
    if (this.jdField_a_of_type_Bemq.a())
    {
      bz();
      return;
    }
    ThreadManager.post(new GameRoomChatPie.15(this), 8, null, true);
  }
  
  public void bz()
  {
    ThreadManager.post(new GameRoomChatPie.16(this), 8, null, true);
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    this.jdField_a_of_type_Auxp.a(paramInt);
    bemp localbemp = this.jdField_a_of_type_Bemq.a();
    if (localbemp != null) {
      localbemp.a(paramInt);
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690382);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131705513));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.W = paramBoolean1;
    this.jdField_a_of_type_Bema.jdField_a_of_type_Boolean = paramBoolean1;
    a(0, true);
    a().setImmersiveStatus(0);
    bemp localbemp = this.jdField_a_of_type_Bemq.a();
    if (localbemp == null) {}
    label651:
    label661:
    for (;;)
    {
      return;
      HashMap localHashMap1 = localbemp.b();
      HashMap localHashMap2 = localbemp.a();
      if ((localHashMap1 != null) && (localHashMap2 != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(0);
        this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_o_of_type_AndroidWidgetImageView.setScaleX(0.0F);
        Drawable localDrawable = (Drawable)localHashMap1.get("aioBg");
        View localView = (View)this.jdField_d_of_type_AndroidViewViewGroup.getParent();
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundColor(0);
        localView.setBackgroundDrawable(localDrawable);
        a(0, true);
        this.l.setBackgroundDrawable((Drawable)localHashMap1.get("inputBg"));
        this.l.setTextColor(((Integer)localHashMap2.get("pressTipsColor")).intValue());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable((Drawable)localHashMap1.get("sendBtnBg"));
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setTextColor(((Integer)localHashMap2.get("sendBtnColor")).intValue());
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
        {
          this.jdField_q_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIconOn"));
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundColor(((Integer)localHashMap2.get("bottomBarColor")).intValue());
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)localHashMap2.get("quickWordBgColor")).intValue());
          }
          if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
            break label599;
          }
          this.jdField_p_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("textIcon"));
          label317:
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130839441);
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
          if ((!paramBoolean2) || (localbemp.c())) {
            break label639;
          }
          this.m.setVisibility(0);
          this.m.setBackgroundColor(((Integer)localHashMap2.get("wolfBtnBg")).intValue());
          this.r = ((Integer)localHashMap2.get("wolfBtnTextPress")).intValue();
          this.jdField_q_of_type_Int = ((Integer)localHashMap2.get("wolfBtnText")).intValue();
          this.m.setTextColor(this.jdField_q_of_type_Int);
        }
        for (;;)
        {
          if (this.jdField_p_of_type_AndroidViewView == null) {
            break label661;
          }
          this.jdField_p_of_type_AndroidViewView.setBackgroundColor(((Integer)localHashMap2.get("bottomBarMask")).intValue());
          return;
          this.jdField_q_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIcon"));
          break;
          label599:
          this.jdField_p_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("audioIcon"));
          break label317;
          label620:
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(1.0F);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(true);
          break label450;
          label639:
          this.m.setVisibility(8);
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
      ((RelativeLayout.LayoutParams)localObject).topMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 295.0F);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setGravity(16);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setId(2131369490);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setGravity(16);
      new RelativeLayout.LayoutParams(-1, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F)).addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 0.0F));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setClickable(true);
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(-1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130837972);
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
      int k = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      this.jdField_p_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_p_of_type_AndroidWidgetImageView.setPadding(k, k, k, k);
      this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.jdField_p_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.jdField_q_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_q_of_type_AndroidWidgetImageView.setImageResource(2130838017);
      this.jdField_q_of_type_AndroidWidgetImageView.setPadding(0, k, 0, k);
      this.jdField_q_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.jdField_q_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.l = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.l.setGravity(17);
      if (i == 0) {
        break label1045;
      }
      this.l.setTextColor(Color.parseColor("#a1a2a3"));
      label588:
      this.l.setBackgroundResource(2130849281);
      this.l.setTextSize(16.0F);
      this.l.setText(alud.a(2131705520));
      this.l.setMinHeight(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
      this.l.setEnabled(false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 86.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.l, (ViewGroup.LayoutParams)localObject);
      this.l.setOnTouchListener(new agqr(this));
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new agqz(this));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 295.0F);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.s);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_f_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.m = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.m.setGravity(17);
      this.m.setTextSize(18.0F);
      this.m.setText(alud.a(2131705534));
      this.m.setEnabled(true);
      this.m.setVisibility(0);
      localObject = new RelativeLayout.LayoutParams(-1, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.m.setOnTouchListener(new agrh(this));
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(this.m, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 245.0F));
      ((RelativeLayout.LayoutParams)localObject).topMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
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
        by();
        return;
        i = 0;
        break;
        label1045:
        this.l.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166997));
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
  
  public void f(String paramString)
  {
    this.ab = true;
    this.ac = false;
    bdjz localbdjz = bdgm.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
    localbdjz.setMessage(paramString);
    localbdjz.setPositiveButton(2131694953, new agqy(this));
    localbdjz.setOnDismissListener(new agra(this));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onKickOut! isStopped = " + this.aj);
    }
    if (!this.aj)
    {
      localbdjz.show();
      return;
    }
    this.ac = true;
    b(1);
  }
  
  public void f(boolean paramBoolean)
  {
    bemp localbemp = this.jdField_a_of_type_Bemq.a();
    if (localbemp == null)
    {
      super.f(paramBoolean);
      return;
    }
    if (!this.jdField_a_of_type_Bemq.b())
    {
      super.f(paramBoolean);
      this.aa = true;
      this.ab = true;
      return;
    }
    if ((localbemp.b()) && (localbemp.c()))
    {
      super.f(paramBoolean);
      this.aa = true;
      return;
    }
    if ((localbemp.b()) && (!localbemp.c()))
    {
      bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, null, alud.a(2131705521), alud.a(2131705467), alud.a(2131705500), new agqt(this, paramBoolean), new agqu(this)).show();
      return;
    }
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, null, alud.a(2131705497), alud.a(2131705454), alud.a(2131705508), new agqv(this, paramBoolean, localbemp), new agqw(this)).show();
  }
  
  public void g(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HalfScreenBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://nearby.qq.com/werewolf/gift.html").append("?_bid=2652&from=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&gc=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append("&toUin=").append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    auxp.a().d = true;
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
    bemp localbemp = this.jdField_a_of_type_Bemq.a();
    if (localbemp == null) {
      return super.i();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
      return super.i();
    }
    if ((this.jdField_a_of_type_Auzw != null) && (this.jdField_a_of_type_Auzw.a()))
    {
      aW();
      return true;
    }
    if (!this.jdField_a_of_type_Bemq.b())
    {
      this.aa = true;
      this.ab = true;
      return super.i();
    }
    if ((localbemp.b()) && (localbemp.c()))
    {
      this.aa = true;
      return super.i();
    }
    if ((localbemp.b()) && (!localbemp.c()))
    {
      bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, null, alud.a(2131705492), alud.a(2131705518), alud.a(2131705502), new agrk(this), new agrl(this)).show();
      return true;
    }
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, null, alud.a(2131705526), alud.a(2131705482), alud.a(2131705460), new agrm(this, localbemp), new agqs(this)).show();
    return true;
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694769, 0).a();
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694769, 0).a();
  }
  
  public void p()
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void t(boolean paramBoolean)
  {
    this.l.setEnabled(paramBoolean);
    Object localObject;
    if (!paramBoolean)
    {
      aM();
      this.jdField_a_of_type_Auxp.c();
      this.l.setEnabled(false);
      this.jdField_p_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_q_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
      bemp localbemp = this.jdField_a_of_type_Bemq.a();
      if (this.jdField_p_of_type_AndroidViewView == null)
      {
        this.jdField_p_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth() != 0)
        {
          localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight());
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_p_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
          this.jdField_p_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#77FFFFFF"));
          if (localbemp != null)
          {
            localObject = localbemp.a();
            this.jdField_p_of_type_AndroidViewView.setBackgroundColor(((Integer)((HashMap)localObject).get("bottomBarMask")).intValue());
          }
          label177:
          this.jdField_p_of_type_AndroidViewView.setVisibility(0);
          if ((localbemp == null) || (!localbemp.c())) {
            break label292;
          }
          this.l.setText(alud.a(2131705517));
          label209:
          if (!this.W) {
            this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
        }
      }
    }
    label292:
    do
    {
      return;
      localObject = new RelativeLayout.LayoutParams(-1, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      break;
      localObject = (RelativeLayout.LayoutParams)this.jdField_p_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth();
      ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight();
      this.jdField_p_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label177;
      this.l.setText(alud.a(2131705470));
      break label209;
      this.l.setText(alud.a(2131705493));
      this.l.setEnabled(true);
      this.jdField_p_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_q_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    } while (this.jdField_p_of_type_AndroidViewView == null);
    this.jdField_p_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageForGrayTips)) && (!(paramObject instanceof MessageForTroopGift))) {
      return;
    }
    super.update(paramObservable, paramObject);
  }
  
  public void x()
  {
    bhuf localbhuf = (bhuf)bhus.a(a(), null);
    bemp localbemp = this.jdField_a_of_type_Bemq.a();
    boolean bool;
    if (localbemp != null)
    {
      bool = localbemp.c();
      if (bool) {
        localbhuf.a(alud.a(2131705451), 3);
      }
      if (!bool) {
        break label102;
      }
      localbhuf.c(alud.a(2131705515));
    }
    for (;;)
    {
      localbhuf.c(alud.a(2131705522));
      localbhuf.d(alud.a(2131705476));
      localbhuf.a(new agrb(this, bool, localbhuf));
      localbhuf.show();
      return;
      bool = false;
      break;
      label102:
      localbhuf.a(alud.a(2131705473), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqq
 * JD-Core Version:    0.7.0.1
 */