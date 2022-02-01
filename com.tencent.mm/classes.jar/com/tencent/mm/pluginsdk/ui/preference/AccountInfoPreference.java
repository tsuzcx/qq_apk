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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.PluginStory;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.v;

public class AccountInfoPreference
  extends Preference
{
  public View.OnClickListener AmH;
  private boolean BdH;
  private boolean BdI;
  private boolean BdJ;
  public d BgU;
  public SpannableString KoG;
  public String KoH;
  private RelativeLayout KoI;
  private View KoJ;
  private View KoK;
  public View KoL;
  private boolean KoM;
  private int KoN;
  private NoMeasuredTextView KoO;
  public ImageView KoP;
  private RelativeLayout KoQ;
  private FrameLayout KoR;
  private LinearLayout KoS;
  public boolean KoT;
  public boolean KoU;
  public View.OnClickListener KoV;
  private View.OnClickListener KoW;
  private View.OnClickListener KoX;
  private final String TAG;
  public boolean rFe;
  public String userName;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31806);
    this.TAG = "MicroMsg.AccountInfoPreference";
    this.BgU = null;
    this.BdJ = false;
    this.BdI = false;
    this.BdH = false;
    this.KoM = true;
    this.KoO = null;
    this.KoP = null;
    this.KoQ = null;
    this.KoR = null;
    this.KoS = null;
    this.KoT = false;
    this.KoU = true;
    this.rFe = false;
    this.AmH = null;
    this.KoV = null;
    this.KoW = null;
    this.KoX = new AccountInfoPreference.1(this);
    AppMethodBeat.o(31806);
  }
  
  public final void grF()
  {
    AppMethodBeat.i(169793);
    Log.i("MicroMsg.AccountInfoPreference", "forceStopBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.rFe) });
    if (!this.rFe)
    {
      AppMethodBeat.o(169793);
      return;
    }
    this.KoQ.setVisibility(8);
    if (((PluginStory)g.ah(PluginStory.class)).getStoryNewFeatureConfig().fng())
    {
      this.KoS.setVisibility(8);
      AppMethodBeat.o(169793);
      return;
    }
    this.KoP.setVisibility(8);
    this.KoR.setVisibility(8);
    ((e)g.ah(e.class)).getStoryUIFactory().fR(this.KoP);
    AppMethodBeat.o(169793);
  }
  
  public final void grG()
  {
    AppMethodBeat.i(169794);
    Log.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip hasUnreadComment:%s, isListVisible:%s", new Object[] { Boolean.valueOf(this.KoT), Boolean.valueOf(this.KoU) });
    if ((this.KoT) && (this.KoU))
    {
      Log.i("MicroMsg.AccountInfoPreference", "activeBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.rFe) });
      if (this.rFe)
      {
        this.KoQ.setVisibility(0);
        if (!((e)g.ah(e.class)).getStoryNewFeatureConfig().fng()) {
          break label186;
        }
        this.KoP.setVisibility(8);
        this.KoR.setVisibility(4);
        this.KoS.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.rFe) {
        Log.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip mBubbleContentNewGroup.visible:%s, mStoryBubbleTipViews.visible:%s", new Object[] { Integer.valueOf(this.KoS.getVisibility()), Integer.valueOf(this.KoP.getVisibility()) });
      }
      AppMethodBeat.o(169794);
      return;
      label186:
      this.KoP.setVisibility(0);
      this.KoR.setVisibility(0);
      this.KoS.setVisibility(8);
      ((e)g.ah(e.class)).getStoryUIFactory().fQ(this.KoP);
      continue;
      grF();
    }
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(31807);
    super.onBindView(paramView);
    Object localObject1 = (ImageView)paramView.findViewById(2131297134);
    if ((this.userName != null) && (localObject1 != null) && (g.aAc())) {
      a.b.c((ImageView)localObject1, this.userName);
    }
    ((ImageView)localObject1).setOnClickListener(this.KoX);
    this.KoO = ((NoMeasuredTextView)paramView.findViewById(2131305433));
    Object localObject2;
    if ((this.userName != null) && (this.KoO != null))
    {
      this.KoO.setShouldEllipsize(true);
      this.KoO.setTextSize(0, com.tencent.mm.cb.a.aG(this.mContext, 2131165483));
      if (!this.BdJ)
      {
        if (!this.BdH) {
          break label605;
        }
        this.KoO.setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131101427));
      }
      localObject2 = this.KoO;
      if (this.KoG != null) {
        break label628;
      }
      localObject1 = this.userName;
      label155:
      ((NoMeasuredTextView)localObject2).setText((CharSequence)localObject1);
      if (this.KoO.getPaint() != null) {
        this.KoO.getPaint().setFakeBoldText(true);
      }
    }
    localObject1 = (TextView)paramView.findViewById(2131309643);
    label229:
    int i;
    if ((this.KoH != null) && (localObject1 != null))
    {
      ((TextView)localObject1).setText(paramView.getResources().getString(2131755306, new Object[] { this.KoH }));
      ((TextView)localObject1).setOnClickListener(this.KoX);
      localObject1 = (TextView)paramView.findViewById(2131307102);
      if (localObject1 != null)
      {
        if (this.KoN <= 99) {
          break label649;
        }
        ((TextView)localObject1).setText(this.mContext.getString(2131766602));
        ((TextView)localObject1).setBackgroundResource(v.kH(this.mContext));
        ((TextView)localObject1).setVisibility(0);
      }
      label291:
      this.KoI = ((RelativeLayout)paramView.findViewById(2131306382));
      this.KoI.setOnClickListener(this.KoX);
      this.KoJ = paramView.findViewById(2131302265);
      this.KoK = paramView.findViewById(2131302267);
      this.KoL = paramView.findViewById(2131302270);
      if (this.KoL != null)
      {
        if ((this.BdH) || (!this.KoM)) {
          break label709;
        }
        i = com.tencent.mm.cb.a.aH(this.mContext, 2131166842);
        label381:
        if (this.BdJ) {
          i = com.tencent.mm.cb.a.aH(this.mContext, 2131166842);
        }
        this.KoL.setPadding(this.KoL.getPaddingLeft(), i, this.KoL.getPaddingRight(), this.KoL.getPaddingBottom());
        if (!this.BdJ) {
          break label723;
        }
        this.KoL.setOnClickListener(this.KoX);
      }
    }
    for (;;)
    {
      localObject2 = this.KoL;
      if ((this.BgU == null) && (p.fvC()) && ((paramView instanceof RelativeLayout)))
      {
        localObject1 = (RelativeLayout)paramView;
        localObject2 = ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getMoreTabCardView(this.mContext, (RelativeLayout)paramView, (LinearLayout)localObject2);
        ((RelativeLayout)localObject1).addView(((d)localObject2).getView());
        localObject1 = (RelativeLayout.LayoutParams)((d)localObject2).getView().getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = -2;
        ((RelativeLayout.LayoutParams)localObject1).height = -2;
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131302270);
        ((d)localObject2).DV(this.userName);
        this.BgU = ((d)localObject2);
      }
      p(this.BdH, this.KoM, this.BdI);
      paramView.post(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(169792);
          if (!AccountInfoPreference.a(AccountInfoPreference.this))
          {
            AccountInfoPreference.a(AccountInfoPreference.this, (ImageView)paramView.findViewById(2131299088));
            AccountInfoPreference.a(AccountInfoPreference.this, (RelativeLayout)paramView.findViewById(2131299086));
            AccountInfoPreference.a(AccountInfoPreference.this, (FrameLayout)paramView.findViewById(2131299085));
            AccountInfoPreference.a(AccountInfoPreference.this, (LinearLayout)paramView.findViewById(2131299098));
            AccountInfoPreference.b(AccountInfoPreference.this);
            if (AccountInfoPreference.c(AccountInfoPreference.this)) {
              break label316;
            }
          }
          label316:
          for (int i = com.tencent.mm.cb.a.aH(AccountInfoPreference.this.mContext, 2131166841) - com.tencent.mm.cb.a.aH(AccountInfoPreference.this.mContext, 2131166842);; i = 0)
          {
            Log.d("MicroMsg.AccountInfoPreference", "root.width:%s, root.height:%s, tip.width:%s, tip.height:%s, offsetY:%s", new Object[] { Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getHeight()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getHeight()), Integer.valueOf(i) });
            ((e)g.ah(e.class)).getStoryUIFactory().b(AccountInfoPreference.d(AccountInfoPreference.this), AccountInfoPreference.e(AccountInfoPreference.this), i);
            AccountInfoPreference localAccountInfoPreference = AccountInfoPreference.this;
            boolean bool1 = bool2;
            if (((e)g.ah(e.class)).isShowStoryCheck())
            {
              bool1 = bool2;
              if (com.tencent.mm.y.c.axV().cO(352279, 266241)) {
                bool1 = true;
              }
            }
            localAccountInfoPreference.KoT = bool1;
            AccountInfoPreference.this.grG();
            AppMethodBeat.o(169792);
            return;
          }
        }
      });
      AppMethodBeat.o(31807);
      return;
      label605:
      this.KoO.setTextColor(this.mContext.getResources().getColor(2131099746));
      break;
      label628:
      localObject1 = this.KoG;
      break label155;
      if (localObject1 == null) {
        break label229;
      }
      ((TextView)localObject1).setVisibility(8);
      break label229;
      label649:
      if (this.KoN > 0)
      {
        ((TextView)localObject1).setText(this.KoN);
        ((TextView)localObject1).setBackgroundResource(v.aQ(this.mContext, this.KoN));
        ((TextView)localObject1).setVisibility(0);
        break label291;
      }
      ((TextView)localObject1).setVisibility(8);
      break label291;
      label709:
      i = com.tencent.mm.cb.a.aH(this.mContext, 2131166841);
      break label381;
      label723:
      this.KoL.setOnClickListener(this.KoV);
    }
  }
  
  public final void p(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(232332);
    this.BdH = paramBoolean1;
    this.KoM = paramBoolean2;
    this.BdI = paramBoolean3;
    this.BdJ = p.fvC();
    if (this.KoO != null)
    {
      if (!this.BdJ)
      {
        if (paramBoolean1) {
          this.KoO.setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131101427));
        }
      }
      else
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.KoI.getLayoutParams();
        localLayoutParams.gravity = 8388693;
        this.KoI.setGravity(16);
        this.KoI.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      if ((!this.BdJ) || (!paramBoolean3)) {
        break label284;
      }
      if (this.KoK != null) {
        this.KoK.setVisibility(8);
      }
      label127:
      if ((!this.BdJ) || (paramBoolean3)) {
        break label302;
      }
      if (this.KoJ != null) {
        this.KoJ.setVisibility(0);
      }
      label153:
      if ((this.BdJ) && (this.KoL != null)) {
        this.KoL.setOnClickListener(this.KoX);
      }
      if (this.KoL != null) {
        if ((paramBoolean1) || (!paramBoolean2)) {
          break label321;
        }
      }
    }
    label284:
    label302:
    label321:
    for (int i = com.tencent.mm.cb.a.aH(this.mContext, 2131166842);; i = com.tencent.mm.cb.a.aH(this.mContext, 2131166841))
    {
      if (this.BdJ) {
        i = com.tencent.mm.cb.a.aH(this.mContext, 2131166842);
      }
      this.KoL.setPadding(this.KoL.getPaddingLeft(), i, this.KoL.getPaddingRight(), this.KoL.getPaddingBottom());
      AppMethodBeat.o(232332);
      return;
      this.KoO.setTextColor(this.mContext.getResources().getColor(2131099746));
      break;
      if (this.KoK == null) {
        break label127;
      }
      this.KoK.setVisibility(0);
      break label127;
      if (this.KoJ == null) {
        break label153;
      }
      this.KoJ.setVisibility(8);
      break label153;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference
 * JD-Core Version:    0.7.0.1
 */