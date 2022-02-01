package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.PluginStory;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.z.c;

public class AccountInfoPreference
  extends Preference
{
  public SpannableString ChP;
  public String ChQ;
  private RelativeLayout ChR;
  private View ChS;
  private boolean ChT;
  private int ChU;
  private NoMeasuredTextView ChV;
  public ImageView ChW;
  private RelativeLayout ChX;
  private FrameLayout ChY;
  private LinearLayout ChZ;
  public boolean Cia;
  public boolean Cib;
  public View.OnClickListener Cic;
  public View.OnClickListener Cid;
  private View.OnClickListener Cie;
  private View.OnClickListener Cif;
  private final String TAG;
  public boolean paC;
  private boolean uAj;
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
    this.uAj = false;
    this.ChT = true;
    this.ChV = null;
    this.ChW = null;
    this.ChX = null;
    this.ChY = null;
    this.ChZ = null;
    this.Cia = false;
    this.Cib = true;
    this.paC = false;
    this.Cic = null;
    this.Cid = null;
    this.Cie = null;
    this.Cif = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31805);
        paramAnonymousView = new Intent();
        d.b(AccountInfoPreference.this.mContext, "setting", ".ui.setting.SettingsPersonalInfoUI", paramAnonymousView);
        AppMethodBeat.o(31805);
      }
    };
    AppMethodBeat.o(31806);
  }
  
  public final void aD(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31808);
    this.uAj = paramBoolean1;
    this.ChT = paramBoolean2;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.ChV != null)
    {
      if (paramBoolean1)
      {
        this.ChV.setTextColor(com.tencent.mm.cd.a.m(this.mContext, 2131101182));
        localLayoutParams = (LinearLayout.LayoutParams)this.ChR.getLayoutParams();
        localLayoutParams.gravity = 8388693;
        this.ChR.setLayoutParams(localLayoutParams);
        this.ChR.setGravity(16);
      }
    }
    else if (this.ChS != null) {
      if ((paramBoolean1) || (!paramBoolean2)) {
        break label197;
      }
    }
    label197:
    for (int i = com.tencent.mm.cd.a.ap(this.mContext, 2131166722);; i = com.tencent.mm.cd.a.ap(this.mContext, 2131166721))
    {
      this.ChS.setPadding(this.ChS.getPaddingLeft(), i, this.ChS.getPaddingRight(), this.ChS.getPaddingBottom());
      AppMethodBeat.o(31808);
      return;
      this.ChV.setTextColor(ao.aD(this.mContext, 2130968584));
      localLayoutParams = (LinearLayout.LayoutParams)this.ChR.getLayoutParams();
      localLayoutParams.gravity = 8388693;
      this.ChR.setGravity(16);
      this.ChR.setLayoutParams(localLayoutParams);
      break;
    }
  }
  
  public final void eAh()
  {
    AppMethodBeat.i(169793);
    ad.i("MicroMsg.AccountInfoPreference", "forceStopBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.paC) });
    if (!this.paC)
    {
      AppMethodBeat.o(169793);
      return;
    }
    this.ChX.setVisibility(8);
    if (((PluginStory)g.ad(PluginStory.class)).getStoryNewFeatureConfig().dGh())
    {
      this.ChZ.setVisibility(8);
      AppMethodBeat.o(169793);
      return;
    }
    this.ChW.setVisibility(8);
    this.ChY.setVisibility(8);
    ((e)g.ad(e.class)).getStoryUIFactory().fb(this.ChW);
    AppMethodBeat.o(169793);
  }
  
  public final void eAi()
  {
    AppMethodBeat.i(169794);
    ad.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip hasUnreadComment:%s, isListVisible:%s", new Object[] { Boolean.valueOf(this.Cia), Boolean.valueOf(this.Cib) });
    if ((this.Cia) && (this.Cib))
    {
      ad.i("MicroMsg.AccountInfoPreference", "activeBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.paC) });
      if (this.paC)
      {
        this.ChX.setVisibility(0);
        if (!((e)g.ad(e.class)).getStoryNewFeatureConfig().dGh()) {
          break label186;
        }
        this.ChW.setVisibility(8);
        this.ChY.setVisibility(4);
        this.ChZ.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.paC) {
        ad.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip mBubbleContentNewGroup.visible:%s, mStoryBubbleTipViews.visible:%s", new Object[] { Integer.valueOf(this.ChZ.getVisibility()), Integer.valueOf(this.ChW.getVisibility()) });
      }
      AppMethodBeat.o(169794);
      return;
      label186:
      this.ChW.setVisibility(0);
      this.ChY.setVisibility(0);
      this.ChZ.setVisibility(8);
      ((e)g.ad(e.class)).getStoryUIFactory().fa(this.ChW);
      continue;
      eAh();
    }
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(31807);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297008);
    if ((this.userName != null) && (localObject != null) && (g.afw())) {
      a.b.c((ImageView)localObject, this.userName);
    }
    ((ImageView)localObject).setOnClickListener(this.Cif);
    this.ChV = ((NoMeasuredTextView)paramView.findViewById(2131302860));
    if ((this.userName != null) && (this.ChV != null))
    {
      this.ChV.setShouldEllipsize(true);
      this.ChV.setTextSize(0, com.tencent.mm.cd.a.ao(this.mContext, 2131165467));
      if (!this.uAj) {
        break label427;
      }
      this.ChV.setTextColor(com.tencent.mm.cd.a.m(this.mContext, 2131101182));
      NoMeasuredTextView localNoMeasuredTextView = this.ChV;
      if (this.ChP != null) {
        break label446;
      }
      localObject = this.userName;
      label151:
      localNoMeasuredTextView.setText((CharSequence)localObject);
      if (this.ChV.getPaint() != null) {
        this.ChV.getPaint().setFakeBoldText(true);
      }
    }
    localObject = (TextView)paramView.findViewById(2131306244);
    if ((this.ChQ != null) && (localObject != null))
    {
      ((TextView)localObject).setText(paramView.getResources().getString(2131755271, new Object[] { this.ChQ }));
      label225:
      ((TextView)localObject).setOnClickListener(this.Cif);
      localObject = (TextView)paramView.findViewById(2131304190);
      if (localObject != null)
      {
        if (this.ChU <= 99) {
          break label467;
        }
        ((TextView)localObject).setText(this.mContext.getString(2131764343));
        ((TextView)localObject).setBackgroundResource(u.kh(this.mContext));
        ((TextView)localObject).setVisibility(0);
      }
      label287:
      this.ChR = ((RelativeLayout)paramView.findViewById(2131303604));
      this.ChR.setOnClickListener(this.Cif);
      this.ChS = paramView.findViewById(2131300699);
      if (this.ChS != null) {
        if ((this.uAj) || (!this.ChT)) {
          break label527;
        }
      }
    }
    label527:
    for (int i = com.tencent.mm.cd.a.ap(this.mContext, 2131166722);; i = com.tencent.mm.cd.a.ap(this.mContext, 2131166721))
    {
      this.ChS.setPadding(this.ChS.getPaddingLeft(), i, this.ChS.getPaddingRight(), this.ChS.getPaddingBottom());
      this.ChS.setOnClickListener(this.Cid);
      aD(this.uAj, this.ChT);
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
          for (int i = com.tencent.mm.cd.a.ap(AccountInfoPreference.this.mContext, 2131166721) - com.tencent.mm.cd.a.ap(AccountInfoPreference.this.mContext, 2131166722);; i = 0)
          {
            ad.d("MicroMsg.AccountInfoPreference", "root.width:%s, root.height:%s, tip.width:%s, tip.height:%s, offsetY:%s", new Object[] { Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getHeight()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getHeight()), Integer.valueOf(i) });
            ((e)g.ad(e.class)).getStoryUIFactory().a(AccountInfoPreference.d(AccountInfoPreference.this), AccountInfoPreference.e(AccountInfoPreference.this), i);
            AccountInfoPreference localAccountInfoPreference = AccountInfoPreference.this;
            boolean bool1 = bool2;
            if (((e)g.ad(e.class)).isShowStoryCheck())
            {
              bool1 = bool2;
              if (c.adr().cI(352279, 266241)) {
                bool1 = true;
              }
            }
            localAccountInfoPreference.Cia = bool1;
            AccountInfoPreference.this.eAi();
            AppMethodBeat.o(169792);
            return;
          }
        }
      });
      AppMethodBeat.o(31807);
      return;
      label427:
      this.ChV.setTextColor(ao.aD(this.mContext, 2130968584));
      break;
      label446:
      localObject = this.ChP;
      break label151;
      if (localObject == null) {
        break label225;
      }
      ((TextView)localObject).setVisibility(8);
      break label225;
      label467:
      if (this.ChU > 0)
      {
        ((TextView)localObject).setText(this.ChU);
        ((TextView)localObject).setBackgroundResource(u.aG(this.mContext, this.ChU));
        ((TextView)localObject).setVisibility(0);
        break label287;
      }
      ((TextView)localObject).setVisibility(8);
      break label287;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference
 * JD-Core Version:    0.7.0.1
 */