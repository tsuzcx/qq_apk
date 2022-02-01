package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
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
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.v;

public class AccountInfoPreference
  extends Preference
{
  public View.OnClickListener LOO;
  private boolean MVC;
  private boolean MVD;
  private boolean MVE;
  public g MYL;
  private View.OnLayoutChangeListener MYo;
  private final String TAG;
  public SpannableString YlM;
  public String YlN;
  private RelativeLayout YlO;
  private View YlP;
  private View YlQ;
  public View YlR;
  public View YlS;
  private boolean YlT;
  private int YlU;
  private NoMeasuredTextView YlV;
  public ImageView YlW;
  private RelativeLayout YlX;
  private FrameLayout YlY;
  private LinearLayout YlZ;
  public boolean Yma;
  public boolean Ymb;
  public View.OnClickListener Ymc;
  private View.OnClickListener Ymd;
  private View.OnClickListener Yme;
  public View rootView;
  public String userName;
  public boolean yxr;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31806);
    this.TAG = "MicroMsg.AccountInfoPreference";
    this.MYL = null;
    this.MVE = false;
    this.MVD = false;
    this.MVC = false;
    this.YlT = true;
    this.YlV = null;
    this.YlW = null;
    this.YlX = null;
    this.YlY = null;
    this.YlZ = null;
    this.Yma = false;
    this.Ymb = true;
    this.yxr = false;
    this.MYo = null;
    this.LOO = null;
    this.Ymc = null;
    this.Ymd = null;
    this.Yme = new AccountInfoPreference.1(this);
    AppMethodBeat.o(31806);
  }
  
  public final void a(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(245133);
    this.MYo = paramOnLayoutChangeListener;
    if ((this.rootView != null) && (this.MYo != null)) {
      this.rootView.addOnLayoutChangeListener(this.MYo);
    }
    AppMethodBeat.o(245133);
  }
  
  public final void iNw()
  {
    AppMethodBeat.i(169793);
    Log.i("MicroMsg.AccountInfoPreference", "forceStopBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.yxr) });
    if (!this.yxr)
    {
      AppMethodBeat.o(169793);
      return;
    }
    this.YlX.setVisibility(8);
    if (((PluginStory)h.az(PluginStory.class)).getStoryNewFeatureConfig().huS())
    {
      this.YlZ.setVisibility(8);
      AppMethodBeat.o(169793);
      return;
    }
    this.YlW.setVisibility(8);
    this.YlY.setVisibility(8);
    ((e)h.az(e.class)).getStoryUIFactory().ke(this.YlW);
    AppMethodBeat.o(169793);
  }
  
  public final void iNx()
  {
    AppMethodBeat.i(169794);
    Log.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip hasUnreadComment:%s, isListVisible:%s", new Object[] { Boolean.valueOf(this.Yma), Boolean.valueOf(this.Ymb) });
    if ((this.Yma) && (this.Ymb))
    {
      Log.i("MicroMsg.AccountInfoPreference", "activeBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.yxr) });
      if (this.yxr)
      {
        this.YlX.setVisibility(0);
        if (!((e)h.az(e.class)).getStoryNewFeatureConfig().huS()) {
          break label186;
        }
        this.YlW.setVisibility(8);
        this.YlY.setVisibility(4);
        this.YlZ.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.yxr) {
        Log.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip mBubbleContentNewGroup.visible:%s, mStoryBubbleTipViews.visible:%s", new Object[] { Integer.valueOf(this.YlZ.getVisibility()), Integer.valueOf(this.YlW.getVisibility()) });
      }
      AppMethodBeat.o(169794);
      return;
      label186:
      this.YlW.setVisibility(0);
      this.YlY.setVisibility(0);
      this.YlZ.setVisibility(8);
      ((e)h.az(e.class)).getStoryUIFactory().kd(this.YlW);
      continue;
      iNw();
    }
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(31807);
    super.onBindView(paramView);
    this.rootView = paramView;
    a(this.MYo);
    Object localObject1 = (ImageView)paramView.findViewById(R.h.avatar_iv);
    if ((this.userName != null) && (localObject1 != null) && (h.baz())) {
      a.b.g((ImageView)localObject1, this.userName);
    }
    ((ImageView)localObject1).setOnClickListener(this.Yme);
    this.YlV = ((NoMeasuredTextView)paramView.findViewById(R.h.nick_name_tv));
    Object localObject2;
    if ((this.userName != null) && (this.YlV != null))
    {
      this.YlV.setShouldEllipsize(true);
      this.YlV.setTextSize(0, com.tencent.mm.cd.a.br(this.mContext, R.f.HugeTextSize));
      if (!this.MVE)
      {
        if (!this.MVC) {
          break label657;
        }
        this.YlV.setTextColor(com.tencent.mm.cd.a.l(this.mContext, R.e.white_text_color));
      }
      localObject2 = this.YlV;
      if (this.YlM != null) {
        break label680;
      }
      localObject1 = this.userName;
      label172:
      ((NoMeasuredTextView)localObject2).setText((CharSequence)localObject1);
      if (this.YlV.getPaint() != null) {
        this.YlV.getPaint().setFakeBoldText(true);
      }
    }
    localObject1 = (TextView)paramView.findViewById(R.h.user_name_tv);
    label246:
    int i;
    if ((this.YlN != null) && (localObject1 != null))
    {
      ((TextView)localObject1).setText(paramView.getResources().getString(R.l.app_account, new Object[] { this.YlN }));
      ((TextView)localObject1).setOnClickListener(this.Yme);
      localObject1 = (TextView)paramView.findViewById(R.h.right_prospect);
      if (localObject1 != null)
      {
        if (this.YlU <= 99) {
          break label701;
        }
        ((TextView)localObject1).setText(this.mContext.getString(R.l.tab_msg_tip_over));
        ((TextView)localObject1).setBackgroundResource(v.nH(this.mContext));
        ((TextView)localObject1).setVisibility(0);
      }
      label308:
      this.YlO = ((RelativeLayout)paramView.findViewById(R.h.qr_arrow_layout));
      this.YlO.setOnClickListener(this.Yme);
      this.YlP = paramView.findViewById(R.h.head_bg_for_status);
      this.YlQ = paramView.findViewById(R.h.head_corner_bg);
      this.YlR = paramView.findViewById(R.h.head_root);
      this.YlS = paramView.findViewById(R.h.v_intercept_head_root_click);
      if (this.YlR != null)
      {
        if ((this.MVC) || (!this.YlT)) {
          break label761;
        }
        i = com.tencent.mm.cd.a.bs(this.mContext, R.f.flU);
        label409:
        if (this.MVE) {
          i = com.tencent.mm.cd.a.bs(this.mContext, R.f.flU);
        }
        this.YlR.setPadding(this.YlR.getPaddingLeft(), i, this.YlR.getPaddingRight(), this.YlR.getPaddingBottom());
        if (!this.MVE) {
          break label775;
        }
        this.YlR.setOnClickListener(this.Yme);
      }
    }
    for (;;)
    {
      localObject2 = this.YlR;
      if (this.MYL != null)
      {
        if (this.MYL.v(paramView, (View)localObject2)) {
          this.MYL.hFv();
        }
      }
      else if ((ac.hFS()) && ((paramView instanceof RelativeLayout)))
      {
        localObject1 = (RelativeLayout)paramView;
        localObject2 = ((f)h.az(f.class)).getMoreTabCardView(this.mContext, (RelativeLayout)paramView, (LinearLayout)localObject2);
        ((RelativeLayout)localObject1).addView(((g)localObject2).getView());
        localObject1 = (RelativeLayout.LayoutParams)((g)localObject2).getView().getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = -2;
        ((RelativeLayout.LayoutParams)localObject1).height = -2;
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, R.h.head_root);
        ((g)localObject2).Ds(this.userName);
        this.MYL = ((g)localObject2);
      }
      p(this.MVC, this.YlT, this.MVD);
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
          for (int i = com.tencent.mm.cd.a.bs(AccountInfoPreference.this.mContext, R.f.flT) - com.tencent.mm.cd.a.bs(AccountInfoPreference.this.mContext, R.f.flU);; i = 0)
          {
            Log.d("MicroMsg.AccountInfoPreference", "root.width:%s, root.height:%s, tip.width:%s, tip.height:%s, offsetY:%s", new Object[] { Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getHeight()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getHeight()), Integer.valueOf(i) });
            ((e)h.az(e.class)).getStoryUIFactory().c(AccountInfoPreference.d(AccountInfoPreference.this), AccountInfoPreference.e(AccountInfoPreference.this), i);
            AccountInfoPreference localAccountInfoPreference = AccountInfoPreference.this;
            boolean bool1 = bool2;
            if (((e)h.az(e.class)).isShowStoryCheck())
            {
              bool1 = bool2;
              if (c.aYo().dV(352279, 266241)) {
                bool1 = true;
              }
            }
            localAccountInfoPreference.Yma = bool1;
            AccountInfoPreference.this.iNx();
            AppMethodBeat.o(169792);
            return;
          }
        }
      });
      AppMethodBeat.o(31807);
      return;
      label657:
      this.YlV.setTextColor(this.mContext.getResources().getColor(R.e.FG_0));
      break;
      label680:
      localObject1 = this.YlM;
      break label172;
      if (localObject1 == null) {
        break label246;
      }
      ((TextView)localObject1).setVisibility(8);
      break label246;
      label701:
      if (this.YlU > 0)
      {
        ((TextView)localObject1).setText(this.YlU);
        ((TextView)localObject1).setBackgroundResource(v.bC(this.mContext, this.YlU));
        ((TextView)localObject1).setVisibility(0);
        break label308;
      }
      ((TextView)localObject1).setVisibility(8);
      break label308;
      label761:
      i = com.tencent.mm.cd.a.bs(this.mContext, R.f.flT);
      break label409;
      label775:
      this.YlR.setOnClickListener(this.Ymc);
    }
  }
  
  public final void p(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(245139);
    this.MVC = paramBoolean1;
    this.YlT = paramBoolean2;
    this.MVD = paramBoolean3;
    this.MVE = ac.hFS();
    if (this.YlV != null)
    {
      if (!this.MVE)
      {
        if (paramBoolean1) {
          this.YlV.setTextColor(com.tencent.mm.cd.a.l(this.mContext, R.e.white_text_color));
        }
      }
      else
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.YlO.getLayoutParams();
        localLayoutParams.gravity = 8388693;
        this.YlO.setGravity(16);
        this.YlO.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      if ((!this.MVE) || (!paramBoolean3)) {
        break label285;
      }
      if (this.YlQ != null) {
        this.YlQ.setVisibility(8);
      }
      label128:
      if ((!this.MVE) || (paramBoolean3)) {
        break label303;
      }
      if (this.YlP != null) {
        this.YlP.setVisibility(0);
      }
      label154:
      if ((this.MVE) && (this.YlR != null)) {
        this.YlR.setOnClickListener(this.Yme);
      }
      if (this.YlR != null) {
        if ((paramBoolean1) || (!paramBoolean2)) {
          break label322;
        }
      }
    }
    label285:
    label303:
    label322:
    for (int i = com.tencent.mm.cd.a.bs(this.mContext, R.f.flU);; i = com.tencent.mm.cd.a.bs(this.mContext, R.f.flT))
    {
      if (this.MVE) {
        i = com.tencent.mm.cd.a.bs(this.mContext, R.f.flU);
      }
      this.YlR.setPadding(this.YlR.getPaddingLeft(), i, this.YlR.getPaddingRight(), this.YlR.getPaddingBottom());
      AppMethodBeat.o(245139);
      return;
      this.YlV.setTextColor(this.mContext.getResources().getColor(R.e.FG_0));
      break;
      if (this.YlQ == null) {
        break label128;
      }
      this.YlQ.setVisibility(0);
      break label128;
      if (this.YlP == null) {
        break label154;
      }
      this.YlP.setVisibility(8);
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference
 * JD-Core Version:    0.7.0.1
 */