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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.z.c;

public class AccountInfoPreference
  extends Preference
{
  public View.OnClickListener FfA;
  public View.OnClickListener FfB;
  private View.OnClickListener FfC;
  private View.OnClickListener FfD;
  public SpannableString Ffn;
  public String Ffo;
  private RelativeLayout Ffp;
  private View Ffq;
  private boolean Ffr;
  private int Ffs;
  private NoMeasuredTextView Fft;
  public ImageView Ffu;
  private RelativeLayout Ffv;
  private FrameLayout Ffw;
  private LinearLayout Ffx;
  public boolean Ffy;
  public boolean Ffz;
  private final String TAG;
  public boolean qhs;
  public String userName;
  private boolean wQj;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31806);
    this.TAG = "MicroMsg.AccountInfoPreference";
    this.wQj = false;
    this.Ffr = true;
    this.Fft = null;
    this.Ffu = null;
    this.Ffv = null;
    this.Ffw = null;
    this.Ffx = null;
    this.Ffy = false;
    this.Ffz = true;
    this.qhs = false;
    this.FfA = null;
    this.FfB = null;
    this.FfC = null;
    this.FfD = new AccountInfoPreference.1(this);
    AppMethodBeat.o(31806);
  }
  
  public final void aO(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31808);
    this.wQj = paramBoolean1;
    this.Ffr = paramBoolean2;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.Fft != null)
    {
      if (paramBoolean1)
      {
        this.Fft.setTextColor(com.tencent.mm.cc.a.m(this.mContext, 2131101182));
        localLayoutParams = (LinearLayout.LayoutParams)this.Ffp.getLayoutParams();
        localLayoutParams.gravity = 8388693;
        this.Ffp.setLayoutParams(localLayoutParams);
        this.Ffp.setGravity(16);
      }
    }
    else if (this.Ffq != null) {
      if ((paramBoolean1) || (!paramBoolean2)) {
        break label200;
      }
    }
    label200:
    for (int i = com.tencent.mm.cc.a.ay(this.mContext, 2131166722);; i = com.tencent.mm.cc.a.ay(this.mContext, 2131166721))
    {
      this.Ffq.setPadding(this.Ffq.getPaddingLeft(), i, this.Ffq.getPaddingRight(), this.Ffq.getPaddingBottom());
      AppMethodBeat.o(31808);
      return;
      this.Fft.setTextColor(this.mContext.getResources().getColor(2131099732));
      localLayoutParams = (LinearLayout.LayoutParams)this.Ffp.getLayoutParams();
      localLayoutParams.gravity = 8388693;
      this.Ffp.setGravity(16);
      this.Ffp.setLayoutParams(localLayoutParams);
      break;
    }
  }
  
  public final void feD()
  {
    AppMethodBeat.i(169793);
    ad.i("MicroMsg.AccountInfoPreference", "forceStopBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.qhs) });
    if (!this.qhs)
    {
      AppMethodBeat.o(169793);
      return;
    }
    this.Ffv.setVisibility(8);
    if (((PluginStory)g.ad(PluginStory.class)).getStoryNewFeatureConfig().egX())
    {
      this.Ffx.setVisibility(8);
      AppMethodBeat.o(169793);
      return;
    }
    this.Ffu.setVisibility(8);
    this.Ffw.setVisibility(8);
    ((e)g.ad(e.class)).getStoryUIFactory().fB(this.Ffu);
    AppMethodBeat.o(169793);
  }
  
  public final void feE()
  {
    AppMethodBeat.i(169794);
    ad.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip hasUnreadComment:%s, isListVisible:%s", new Object[] { Boolean.valueOf(this.Ffy), Boolean.valueOf(this.Ffz) });
    if ((this.Ffy) && (this.Ffz))
    {
      ad.i("MicroMsg.AccountInfoPreference", "activeBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.qhs) });
      if (this.qhs)
      {
        this.Ffv.setVisibility(0);
        if (!((e)g.ad(e.class)).getStoryNewFeatureConfig().egX()) {
          break label186;
        }
        this.Ffu.setVisibility(8);
        this.Ffw.setVisibility(4);
        this.Ffx.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.qhs) {
        ad.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip mBubbleContentNewGroup.visible:%s, mStoryBubbleTipViews.visible:%s", new Object[] { Integer.valueOf(this.Ffx.getVisibility()), Integer.valueOf(this.Ffu.getVisibility()) });
      }
      AppMethodBeat.o(169794);
      return;
      label186:
      this.Ffu.setVisibility(0);
      this.Ffw.setVisibility(0);
      this.Ffx.setVisibility(8);
      ((e)g.ad(e.class)).getStoryUIFactory().fA(this.Ffu);
      continue;
      feD();
    }
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(31807);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297008);
    if ((this.userName != null) && (localObject != null) && (g.ajx())) {
      a.b.c((ImageView)localObject, this.userName);
    }
    ((ImageView)localObject).setOnClickListener(this.FfD);
    this.Fft = ((NoMeasuredTextView)paramView.findViewById(2131302860));
    if ((this.userName != null) && (this.Fft != null))
    {
      this.Fft.setShouldEllipsize(true);
      this.Fft.setTextSize(0, com.tencent.mm.cc.a.ax(this.mContext, 2131165467));
      if (!this.wQj) {
        break label427;
      }
      this.Fft.setTextColor(com.tencent.mm.cc.a.m(this.mContext, 2131101182));
      NoMeasuredTextView localNoMeasuredTextView = this.Fft;
      if (this.Ffn != null) {
        break label449;
      }
      localObject = this.userName;
      label151:
      localNoMeasuredTextView.setText((CharSequence)localObject);
      if (this.Fft.getPaint() != null) {
        this.Fft.getPaint().setFakeBoldText(true);
      }
    }
    localObject = (TextView)paramView.findViewById(2131306244);
    if ((this.Ffo != null) && (localObject != null))
    {
      ((TextView)localObject).setText(paramView.getResources().getString(2131755271, new Object[] { this.Ffo }));
      label225:
      ((TextView)localObject).setOnClickListener(this.FfD);
      localObject = (TextView)paramView.findViewById(2131304190);
      if (localObject != null)
      {
        if (this.Ffs <= 99) {
          break label470;
        }
        ((TextView)localObject).setText(this.mContext.getString(2131764343));
        ((TextView)localObject).setBackgroundResource(u.kE(this.mContext));
        ((TextView)localObject).setVisibility(0);
      }
      label287:
      this.Ffp = ((RelativeLayout)paramView.findViewById(2131303604));
      this.Ffp.setOnClickListener(this.FfD);
      this.Ffq = paramView.findViewById(2131300699);
      if (this.Ffq != null) {
        if ((this.wQj) || (!this.Ffr)) {
          break label530;
        }
      }
    }
    label530:
    for (int i = com.tencent.mm.cc.a.ay(this.mContext, 2131166722);; i = com.tencent.mm.cc.a.ay(this.mContext, 2131166721))
    {
      this.Ffq.setPadding(this.Ffq.getPaddingLeft(), i, this.Ffq.getPaddingRight(), this.Ffq.getPaddingBottom());
      this.Ffq.setOnClickListener(this.FfB);
      aO(this.wQj, this.Ffr);
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
          for (int i = com.tencent.mm.cc.a.ay(AccountInfoPreference.this.mContext, 2131166721) - com.tencent.mm.cc.a.ay(AccountInfoPreference.this.mContext, 2131166722);; i = 0)
          {
            ad.d("MicroMsg.AccountInfoPreference", "root.width:%s, root.height:%s, tip.width:%s, tip.height:%s, offsetY:%s", new Object[] { Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getHeight()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getHeight()), Integer.valueOf(i) });
            ((e)g.ad(e.class)).getStoryUIFactory().b(AccountInfoPreference.d(AccountInfoPreference.this), AccountInfoPreference.e(AccountInfoPreference.this), i);
            AccountInfoPreference localAccountInfoPreference = AccountInfoPreference.this;
            boolean bool1 = bool2;
            if (((e)g.ad(e.class)).isShowStoryCheck())
            {
              bool1 = bool2;
              if (c.aht().cI(352279, 266241)) {
                bool1 = true;
              }
            }
            localAccountInfoPreference.Ffy = bool1;
            AccountInfoPreference.this.feE();
            AppMethodBeat.o(169792);
            return;
          }
        }
      });
      AppMethodBeat.o(31807);
      return;
      label427:
      this.Fft.setTextColor(this.mContext.getResources().getColor(2131099732));
      break;
      label449:
      localObject = this.Ffn;
      break label151;
      if (localObject == null) {
        break label225;
      }
      ((TextView)localObject).setVisibility(8);
      break label225;
      label470:
      if (this.Ffs > 0)
      {
        ((TextView)localObject).setText(this.Ffs);
        ((TextView)localObject).setBackgroundResource(u.aP(this.mContext, this.Ffs));
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