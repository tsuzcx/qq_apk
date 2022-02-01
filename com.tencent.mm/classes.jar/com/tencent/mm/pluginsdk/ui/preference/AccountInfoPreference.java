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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.PluginStory;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.y.c;

public class AccountInfoPreference
  extends Preference
{
  public SpannableString FxL;
  public String FxM;
  private RelativeLayout FxN;
  private View FxO;
  private boolean FxP;
  private int FxQ;
  private NoMeasuredTextView FxR;
  public ImageView FxS;
  private RelativeLayout FxT;
  private FrameLayout FxU;
  private LinearLayout FxV;
  public boolean FxW;
  public boolean FxX;
  public View.OnClickListener FxY;
  public View.OnClickListener FxZ;
  private View.OnClickListener Fya;
  private View.OnClickListener Fyb;
  private final String TAG;
  public boolean qnX;
  public String userName;
  private boolean xga;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31806);
    this.TAG = "MicroMsg.AccountInfoPreference";
    this.xga = false;
    this.FxP = true;
    this.FxR = null;
    this.FxS = null;
    this.FxT = null;
    this.FxU = null;
    this.FxV = null;
    this.FxW = false;
    this.FxX = true;
    this.qnX = false;
    this.FxY = null;
    this.FxZ = null;
    this.Fya = null;
    this.Fyb = new AccountInfoPreference.1(this);
    AppMethodBeat.o(31806);
  }
  
  public final void aN(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31808);
    this.xga = paramBoolean1;
    this.FxP = paramBoolean2;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.FxR != null)
    {
      if (paramBoolean1)
      {
        this.FxR.setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131101182));
        localLayoutParams = (LinearLayout.LayoutParams)this.FxN.getLayoutParams();
        localLayoutParams.gravity = 8388693;
        this.FxN.setLayoutParams(localLayoutParams);
        this.FxN.setGravity(16);
      }
    }
    else if (this.FxO != null) {
      if ((paramBoolean1) || (!paramBoolean2)) {
        break label200;
      }
    }
    label200:
    for (int i = com.tencent.mm.cb.a.ay(this.mContext, 2131166722);; i = com.tencent.mm.cb.a.ay(this.mContext, 2131166721))
    {
      this.FxO.setPadding(this.FxO.getPaddingLeft(), i, this.FxO.getPaddingRight(), this.FxO.getPaddingBottom());
      AppMethodBeat.o(31808);
      return;
      this.FxR.setTextColor(this.mContext.getResources().getColor(2131099732));
      localLayoutParams = (LinearLayout.LayoutParams)this.FxN.getLayoutParams();
      localLayoutParams.gravity = 8388693;
      this.FxN.setGravity(16);
      this.FxN.setLayoutParams(localLayoutParams);
      break;
    }
  }
  
  public final void fit()
  {
    AppMethodBeat.i(169793);
    ae.i("MicroMsg.AccountInfoPreference", "forceStopBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.qnX) });
    if (!this.qnX)
    {
      AppMethodBeat.o(169793);
      return;
    }
    this.FxT.setVisibility(8);
    if (((PluginStory)g.ad(PluginStory.class)).getStoryNewFeatureConfig().ekF())
    {
      this.FxV.setVisibility(8);
      AppMethodBeat.o(169793);
      return;
    }
    this.FxS.setVisibility(8);
    this.FxU.setVisibility(8);
    ((e)g.ad(e.class)).getStoryUIFactory().fA(this.FxS);
    AppMethodBeat.o(169793);
  }
  
  public final void fiu()
  {
    AppMethodBeat.i(169794);
    ae.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip hasUnreadComment:%s, isListVisible:%s", new Object[] { Boolean.valueOf(this.FxW), Boolean.valueOf(this.FxX) });
    if ((this.FxW) && (this.FxX))
    {
      ae.i("MicroMsg.AccountInfoPreference", "activeBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.qnX) });
      if (this.qnX)
      {
        this.FxT.setVisibility(0);
        if (!((e)g.ad(e.class)).getStoryNewFeatureConfig().ekF()) {
          break label186;
        }
        this.FxS.setVisibility(8);
        this.FxU.setVisibility(4);
        this.FxV.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.qnX) {
        ae.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip mBubbleContentNewGroup.visible:%s, mStoryBubbleTipViews.visible:%s", new Object[] { Integer.valueOf(this.FxV.getVisibility()), Integer.valueOf(this.FxS.getVisibility()) });
      }
      AppMethodBeat.o(169794);
      return;
      label186:
      this.FxS.setVisibility(0);
      this.FxU.setVisibility(0);
      this.FxV.setVisibility(8);
      ((e)g.ad(e.class)).getStoryUIFactory().fz(this.FxS);
      continue;
      fit();
    }
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(31807);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297008);
    if ((this.userName != null) && (localObject != null) && (g.ajM())) {
      a.b.c((ImageView)localObject, this.userName);
    }
    ((ImageView)localObject).setOnClickListener(this.Fyb);
    this.FxR = ((NoMeasuredTextView)paramView.findViewById(2131302860));
    if ((this.userName != null) && (this.FxR != null))
    {
      this.FxR.setShouldEllipsize(true);
      this.FxR.setTextSize(0, com.tencent.mm.cb.a.ax(this.mContext, 2131165467));
      if (!this.xga) {
        break label427;
      }
      this.FxR.setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131101182));
      NoMeasuredTextView localNoMeasuredTextView = this.FxR;
      if (this.FxL != null) {
        break label449;
      }
      localObject = this.userName;
      label151:
      localNoMeasuredTextView.setText((CharSequence)localObject);
      if (this.FxR.getPaint() != null) {
        this.FxR.getPaint().setFakeBoldText(true);
      }
    }
    localObject = (TextView)paramView.findViewById(2131306244);
    if ((this.FxM != null) && (localObject != null))
    {
      ((TextView)localObject).setText(paramView.getResources().getString(2131755271, new Object[] { this.FxM }));
      label225:
      ((TextView)localObject).setOnClickListener(this.Fyb);
      localObject = (TextView)paramView.findViewById(2131304190);
      if (localObject != null)
      {
        if (this.FxQ <= 99) {
          break label470;
        }
        ((TextView)localObject).setText(this.mContext.getString(2131764343));
        ((TextView)localObject).setBackgroundResource(u.kL(this.mContext));
        ((TextView)localObject).setVisibility(0);
      }
      label287:
      this.FxN = ((RelativeLayout)paramView.findViewById(2131303604));
      this.FxN.setOnClickListener(this.Fyb);
      this.FxO = paramView.findViewById(2131300699);
      if (this.FxO != null) {
        if ((this.xga) || (!this.FxP)) {
          break label530;
        }
      }
    }
    label530:
    for (int i = com.tencent.mm.cb.a.ay(this.mContext, 2131166722);; i = com.tencent.mm.cb.a.ay(this.mContext, 2131166721))
    {
      this.FxO.setPadding(this.FxO.getPaddingLeft(), i, this.FxO.getPaddingRight(), this.FxO.getPaddingBottom());
      this.FxO.setOnClickListener(this.FxZ);
      aN(this.xga, this.FxP);
      paramView.post(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(169792);
          if (!AccountInfoPreference.a(AccountInfoPreference.this))
          {
            AccountInfoPreference.a(AccountInfoPreference.this, (ImageView)paramView.findViewById(2131298651));
            AccountInfoPreference.a(AccountInfoPreference.this, (RelativeLayout)paramView.findViewById(2131298649));
            AccountInfoPreference.a(AccountInfoPreference.this, (FrameLayout)paramView.findViewById(2131298648));
            AccountInfoPreference.a(AccountInfoPreference.this, (LinearLayout)paramView.findViewById(2131298661));
            AccountInfoPreference.b(AccountInfoPreference.this);
            if (AccountInfoPreference.c(AccountInfoPreference.this)) {
              break label316;
            }
          }
          label316:
          for (int i = com.tencent.mm.cb.a.ay(AccountInfoPreference.this.mContext, 2131166721) - com.tencent.mm.cb.a.ay(AccountInfoPreference.this.mContext, 2131166722);; i = 0)
          {
            ae.d("MicroMsg.AccountInfoPreference", "root.width:%s, root.height:%s, tip.width:%s, tip.height:%s, offsetY:%s", new Object[] { Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getHeight()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getHeight()), Integer.valueOf(i) });
            ((e)g.ad(e.class)).getStoryUIFactory().b(AccountInfoPreference.d(AccountInfoPreference.this), AccountInfoPreference.e(AccountInfoPreference.this), i);
            AccountInfoPreference localAccountInfoPreference = AccountInfoPreference.this;
            boolean bool1 = bool2;
            if (((e)g.ad(e.class)).isShowStoryCheck())
            {
              bool1 = bool2;
              if (c.ahI().cI(352279, 266241)) {
                bool1 = true;
              }
            }
            localAccountInfoPreference.FxW = bool1;
            AccountInfoPreference.this.fiu();
            AppMethodBeat.o(169792);
            return;
          }
        }
      });
      AppMethodBeat.o(31807);
      return;
      label427:
      this.FxR.setTextColor(this.mContext.getResources().getColor(2131099732));
      break;
      label449:
      localObject = this.FxL;
      break label151;
      if (localObject == null) {
        break label225;
      }
      ((TextView)localObject).setVisibility(8);
      break label225;
      label470:
      if (this.FxQ > 0)
      {
        ((TextView)localObject).setText(this.FxQ);
        ((TextView)localObject).setBackgroundResource(u.aP(this.mContext, this.FxQ));
        ((TextView)localObject).setVisibility(0);
        break label287;
      }
      ((TextView)localObject).setVisibility(8);
      break label287;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference
 * JD-Core Version:    0.7.0.1
 */