package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.story.PluginStory;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.w;

public class AccountInfoPreference
  extends Preference
{
  public View.OnClickListener FTO;
  private boolean GXF;
  private boolean GXG;
  private boolean GXH;
  public com.tencent.mm.plugin.textstatus.a.e HaE;
  private View RpA;
  public View RpB;
  public View RpC;
  private boolean RpD;
  private int RpE;
  private NoMeasuredTextView RpF;
  public ImageView RpG;
  private RelativeLayout RpH;
  private FrameLayout RpI;
  private LinearLayout RpJ;
  public boolean RpK;
  public boolean RpL;
  public View.OnClickListener RpM;
  private View.OnClickListener RpN;
  private View.OnClickListener RpO;
  public SpannableString Rpw;
  public String Rpx;
  private RelativeLayout Rpy;
  private View Rpz;
  private final String TAG;
  public String userName;
  public boolean vkO;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31806);
    this.TAG = "MicroMsg.AccountInfoPreference";
    this.HaE = null;
    this.GXH = false;
    this.GXG = false;
    this.GXF = false;
    this.RpD = true;
    this.RpF = null;
    this.RpG = null;
    this.RpH = null;
    this.RpI = null;
    this.RpJ = null;
    this.RpK = false;
    this.RpL = true;
    this.vkO = false;
    this.FTO = null;
    this.RpM = null;
    this.RpN = null;
    this.RpO = new AccountInfoPreference.1(this);
    AppMethodBeat.o(31806);
  }
  
  public final void hmG()
  {
    AppMethodBeat.i(273379);
    if (this.HaE != null)
    {
      this.HaE.gkI();
      this.HaE = null;
    }
    AppMethodBeat.o(273379);
  }
  
  public final void hmH()
  {
    AppMethodBeat.i(169793);
    Log.i("MicroMsg.AccountInfoPreference", "forceStopBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.vkO) });
    if (!this.vkO)
    {
      AppMethodBeat.o(169793);
      return;
    }
    this.RpH.setVisibility(8);
    if (((PluginStory)h.ag(PluginStory.class)).getStoryNewFeatureConfig().gbz())
    {
      this.RpJ.setVisibility(8);
      AppMethodBeat.o(169793);
      return;
    }
    this.RpG.setVisibility(8);
    this.RpI.setVisibility(8);
    ((com.tencent.mm.plugin.story.api.e)h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gY(this.RpG);
    AppMethodBeat.o(169793);
  }
  
  public final void hmI()
  {
    AppMethodBeat.i(169794);
    Log.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip hasUnreadComment:%s, isListVisible:%s", new Object[] { Boolean.valueOf(this.RpK), Boolean.valueOf(this.RpL) });
    if ((this.RpK) && (this.RpL))
    {
      Log.i("MicroMsg.AccountInfoPreference", "activeBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.vkO) });
      if (this.vkO)
      {
        this.RpH.setVisibility(0);
        if (!((com.tencent.mm.plugin.story.api.e)h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryNewFeatureConfig().gbz()) {
          break label186;
        }
        this.RpG.setVisibility(8);
        this.RpI.setVisibility(4);
        this.RpJ.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.vkO) {
        Log.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip mBubbleContentNewGroup.visible:%s, mStoryBubbleTipViews.visible:%s", new Object[] { Integer.valueOf(this.RpJ.getVisibility()), Integer.valueOf(this.RpG.getVisibility()) });
      }
      AppMethodBeat.o(169794);
      return;
      label186:
      this.RpG.setVisibility(0);
      this.RpI.setVisibility(0);
      this.RpJ.setVisibility(8);
      ((com.tencent.mm.plugin.story.api.e)h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gX(this.RpG);
      continue;
      hmH();
    }
  }
  
  public final void n(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(273380);
    this.GXF = paramBoolean1;
    this.RpD = paramBoolean2;
    this.GXG = paramBoolean3;
    this.GXH = t.gkZ();
    if (this.RpF != null)
    {
      if (!this.GXH)
      {
        if (paramBoolean1) {
          this.RpF.setTextColor(com.tencent.mm.ci.a.l(this.mContext, R.e.white_text_color));
        }
      }
      else
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Rpy.getLayoutParams();
        localLayoutParams.gravity = 8388693;
        this.Rpy.setGravity(16);
        this.Rpy.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      if ((!this.GXH) || (!paramBoolean3)) {
        break label282;
      }
      if (this.RpA != null) {
        this.RpA.setVisibility(8);
      }
      label126:
      if ((!this.GXH) || (paramBoolean3)) {
        break label300;
      }
      if (this.Rpz != null) {
        this.Rpz.setVisibility(0);
      }
      label152:
      if ((this.GXH) && (this.RpB != null)) {
        this.RpB.setOnClickListener(this.RpO);
      }
      if (this.RpB != null) {
        if ((paramBoolean1) || (!paramBoolean2)) {
          break label319;
        }
      }
    }
    label282:
    label300:
    label319:
    for (int i = com.tencent.mm.ci.a.aZ(this.mContext, R.f.dlC);; i = com.tencent.mm.ci.a.aZ(this.mContext, R.f.dlB))
    {
      if (this.GXH) {
        i = com.tencent.mm.ci.a.aZ(this.mContext, R.f.dlC);
      }
      this.RpB.setPadding(this.RpB.getPaddingLeft(), i, this.RpB.getPaddingRight(), this.RpB.getPaddingBottom());
      AppMethodBeat.o(273380);
      return;
      this.RpF.setTextColor(this.mContext.getResources().getColor(R.e.FG_0));
      break;
      if (this.RpA == null) {
        break label126;
      }
      this.RpA.setVisibility(0);
      break label126;
      if (this.Rpz == null) {
        break label152;
      }
      this.Rpz.setVisibility(8);
      break label152;
    }
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(31807);
    super.onBindView(paramView);
    Object localObject1 = (ImageView)paramView.findViewById(R.h.avatar_iv);
    if ((this.userName != null) && (localObject1 != null) && (h.aHB())) {
      a.b.c((ImageView)localObject1, this.userName);
    }
    ((ImageView)localObject1).setOnClickListener(this.RpO);
    this.RpF = ((NoMeasuredTextView)paramView.findViewById(R.h.nick_name_tv));
    Object localObject2;
    if ((this.userName != null) && (this.RpF != null))
    {
      this.RpF.setShouldEllipsize(true);
      this.RpF.setTextSize(0, com.tencent.mm.ci.a.aY(this.mContext, R.f.HugeTextSize));
      if (!this.GXH)
      {
        if (!this.GXF) {
          break label620;
        }
        this.RpF.setTextColor(com.tencent.mm.ci.a.l(this.mContext, R.e.white_text_color));
      }
      localObject2 = this.RpF;
      if (this.Rpw != null) {
        break label643;
      }
      localObject1 = this.userName;
      label159:
      ((NoMeasuredTextView)localObject2).setText((CharSequence)localObject1);
      if (this.RpF.getPaint() != null) {
        this.RpF.getPaint().setFakeBoldText(true);
      }
    }
    localObject1 = (TextView)paramView.findViewById(R.h.user_name_tv);
    label233:
    int i;
    if ((this.Rpx != null) && (localObject1 != null))
    {
      ((TextView)localObject1).setText(paramView.getResources().getString(R.l.app_account, new Object[] { this.Rpx }));
      ((TextView)localObject1).setOnClickListener(this.RpO);
      localObject1 = (TextView)paramView.findViewById(R.h.right_prospect);
      if (localObject1 != null)
      {
        if (this.RpE <= 99) {
          break label664;
        }
        ((TextView)localObject1).setText(this.mContext.getString(R.l.tab_msg_tip_over));
        ((TextView)localObject1).setBackgroundResource(w.lE(this.mContext));
        ((TextView)localObject1).setVisibility(0);
      }
      label295:
      this.Rpy = ((RelativeLayout)paramView.findViewById(R.h.qr_arrow_layout));
      this.Rpy.setOnClickListener(this.RpO);
      this.Rpz = paramView.findViewById(R.h.head_bg_for_status);
      this.RpA = paramView.findViewById(R.h.head_corner_bg);
      this.RpB = paramView.findViewById(R.h.head_root);
      this.RpC = paramView.findViewById(R.h.v_intercept_head_root_click);
      if (this.RpB != null)
      {
        if ((this.GXF) || (!this.RpD)) {
          break label724;
        }
        i = com.tencent.mm.ci.a.aZ(this.mContext, R.f.dlC);
        label396:
        if (this.GXH) {
          i = com.tencent.mm.ci.a.aZ(this.mContext, R.f.dlC);
        }
        this.RpB.setPadding(this.RpB.getPaddingLeft(), i, this.RpB.getPaddingRight(), this.RpB.getPaddingBottom());
        if (!this.GXH) {
          break label738;
        }
        this.RpB.setOnClickListener(this.RpO);
      }
    }
    for (;;)
    {
      localObject2 = this.RpB;
      if ((this.HaE == null) && (t.gkZ()) && ((paramView instanceof RelativeLayout)))
      {
        localObject1 = (RelativeLayout)paramView;
        localObject2 = ((d)h.ag(d.class)).getMoreTabCardView(this.mContext, (RelativeLayout)paramView, (LinearLayout)localObject2);
        ((RelativeLayout)localObject1).addView(((com.tencent.mm.plugin.textstatus.a.e)localObject2).getView());
        localObject1 = (RelativeLayout.LayoutParams)((com.tencent.mm.plugin.textstatus.a.e)localObject2).getView().getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = -2;
        ((RelativeLayout.LayoutParams)localObject1).height = -2;
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, R.h.head_root);
        ((com.tencent.mm.plugin.textstatus.a.e)localObject2).KN(this.userName);
        this.HaE = ((com.tencent.mm.plugin.textstatus.a.e)localObject2);
      }
      n(this.GXF, this.RpD, this.GXG);
      paramView.post(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(169792);
          if (!AccountInfoPreference.a(AccountInfoPreference.this))
          {
            AccountInfoPreference.a(AccountInfoPreference.this, (ImageView)paramView.findViewById(R.h.contact_info_story_bubble_tips_old));
            AccountInfoPreference.a(AccountInfoPreference.this, (RelativeLayout)paramView.findViewById(R.h.contact_info_story_bubble_layout));
            AccountInfoPreference.a(AccountInfoPreference.this, (FrameLayout)paramView.findViewById(R.h.contact_info_story_bubble_confetti_root));
            AccountInfoPreference.a(AccountInfoPreference.this, (LinearLayout)paramView.findViewById(R.h.contact_info_story_tip_new));
            AccountInfoPreference.b(AccountInfoPreference.this);
            if (AccountInfoPreference.c(AccountInfoPreference.this)) {
              break label322;
            }
          }
          label322:
          for (int i = com.tencent.mm.ci.a.aZ(AccountInfoPreference.this.mContext, R.f.dlB) - com.tencent.mm.ci.a.aZ(AccountInfoPreference.this.mContext, R.f.dlC);; i = 0)
          {
            Log.d("MicroMsg.AccountInfoPreference", "root.width:%s, root.height:%s, tip.width:%s, tip.height:%s, offsetY:%s", new Object[] { Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getHeight()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getHeight()), Integer.valueOf(i) });
            ((com.tencent.mm.plugin.story.api.e)h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().c(AccountInfoPreference.d(AccountInfoPreference.this), AccountInfoPreference.e(AccountInfoPreference.this), i);
            AccountInfoPreference localAccountInfoPreference = AccountInfoPreference.this;
            boolean bool1 = bool2;
            if (((com.tencent.mm.plugin.story.api.e)h.ag(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck())
            {
              bool1 = bool2;
              if (c.aFn().dj(352279, 266241)) {
                bool1 = true;
              }
            }
            localAccountInfoPreference.RpK = bool1;
            AccountInfoPreference.this.hmI();
            AppMethodBeat.o(169792);
            return;
          }
        }
      });
      AppMethodBeat.o(31807);
      return;
      label620:
      this.RpF.setTextColor(this.mContext.getResources().getColor(R.e.FG_0));
      break;
      label643:
      localObject1 = this.Rpw;
      break label159;
      if (localObject1 == null) {
        break label233;
      }
      ((TextView)localObject1).setVisibility(8);
      break label233;
      label664:
      if (this.RpE > 0)
      {
        ((TextView)localObject1).setText(this.RpE);
        ((TextView)localObject1).setBackgroundResource(w.bj(this.mContext, this.RpE));
        ((TextView)localObject1).setVisibility(0);
        break label295;
      }
      ((TextView)localObject1).setVisibility(8);
      break label295;
      label724:
      i = com.tencent.mm.ci.a.aZ(this.mContext, R.f.dlB);
      break label396;
      label738:
      this.RpB.setOnClickListener(this.RpM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference
 * JD-Core Version:    0.7.0.1
 */