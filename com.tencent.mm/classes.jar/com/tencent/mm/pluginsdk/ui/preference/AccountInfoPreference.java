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
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.PluginStory;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.y.c;

public class AccountInfoPreference
  extends Preference
{
  public SpannableString DAg;
  public String DAh;
  private RelativeLayout DAi;
  private View DAj;
  private boolean DAk;
  private int DAl;
  private NoMeasuredTextView DAm;
  public ImageView DAn;
  private RelativeLayout DAo;
  private FrameLayout DAp;
  private LinearLayout DAq;
  public boolean DAr;
  public boolean DAs;
  public View.OnClickListener DAt;
  public View.OnClickListener DAu;
  private View.OnClickListener DAv;
  private View.OnClickListener DAw;
  private final String TAG;
  public boolean pDN;
  public String userName;
  private boolean vJc;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31806);
    this.TAG = "MicroMsg.AccountInfoPreference";
    this.vJc = false;
    this.DAk = true;
    this.DAm = null;
    this.DAn = null;
    this.DAo = null;
    this.DAp = null;
    this.DAq = null;
    this.DAr = false;
    this.DAs = true;
    this.pDN = false;
    this.DAt = null;
    this.DAu = null;
    this.DAv = null;
    this.DAw = new View.OnClickListener()
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
  
  public final void aH(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31808);
    this.vJc = paramBoolean1;
    this.DAk = paramBoolean2;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.DAm != null)
    {
      if (paramBoolean1)
      {
        this.DAm.setTextColor(com.tencent.mm.cc.a.m(this.mContext, 2131101182));
        localLayoutParams = (LinearLayout.LayoutParams)this.DAi.getLayoutParams();
        localLayoutParams.gravity = 8388693;
        this.DAi.setLayoutParams(localLayoutParams);
        this.DAi.setGravity(16);
      }
    }
    else if (this.DAj != null) {
      if ((paramBoolean1) || (!paramBoolean2)) {
        break label197;
      }
    }
    label197:
    for (int i = com.tencent.mm.cc.a.av(this.mContext, 2131166722);; i = com.tencent.mm.cc.a.av(this.mContext, 2131166721))
    {
      this.DAj.setPadding(this.DAj.getPaddingLeft(), i, this.DAj.getPaddingRight(), this.DAj.getPaddingBottom());
      AppMethodBeat.o(31808);
      return;
      this.DAm.setTextColor(ao.aJ(this.mContext, 2130968584));
      localLayoutParams = (LinearLayout.LayoutParams)this.DAi.getLayoutParams();
      localLayoutParams.gravity = 8388693;
      this.DAi.setGravity(16);
      this.DAi.setLayoutParams(localLayoutParams);
      break;
    }
  }
  
  public final void ePB()
  {
    AppMethodBeat.i(169793);
    ac.i("MicroMsg.AccountInfoPreference", "forceStopBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.pDN) });
    if (!this.pDN)
    {
      AppMethodBeat.o(169793);
      return;
    }
    this.DAo.setVisibility(8);
    if (((PluginStory)g.ad(PluginStory.class)).getStoryNewFeatureConfig().dUI())
    {
      this.DAq.setVisibility(8);
      AppMethodBeat.o(169793);
      return;
    }
    this.DAn.setVisibility(8);
    this.DAp.setVisibility(8);
    ((e)g.ad(e.class)).getStoryUIFactory().fo(this.DAn);
    AppMethodBeat.o(169793);
  }
  
  public final void ePC()
  {
    AppMethodBeat.i(169794);
    ac.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip hasUnreadComment:%s, isListVisible:%s", new Object[] { Boolean.valueOf(this.DAr), Boolean.valueOf(this.DAs) });
    if ((this.DAr) && (this.DAs))
    {
      ac.i("MicroMsg.AccountInfoPreference", "activeBubbleTip this:%s, bindView:%s", new Object[] { this, Boolean.valueOf(this.pDN) });
      if (this.pDN)
      {
        this.DAo.setVisibility(0);
        if (!((e)g.ad(e.class)).getStoryNewFeatureConfig().dUI()) {
          break label186;
        }
        this.DAn.setVisibility(8);
        this.DAp.setVisibility(4);
        this.DAq.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.pDN) {
        ac.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip mBubbleContentNewGroup.visible:%s, mStoryBubbleTipViews.visible:%s", new Object[] { Integer.valueOf(this.DAq.getVisibility()), Integer.valueOf(this.DAn.getVisibility()) });
      }
      AppMethodBeat.o(169794);
      return;
      label186:
      this.DAn.setVisibility(0);
      this.DAp.setVisibility(0);
      this.DAq.setVisibility(8);
      ((e)g.ad(e.class)).getStoryUIFactory().fn(this.DAn);
      continue;
      ePB();
    }
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(31807);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297008);
    if ((this.userName != null) && (localObject != null) && (g.agM())) {
      a.b.c((ImageView)localObject, this.userName);
    }
    ((ImageView)localObject).setOnClickListener(this.DAw);
    this.DAm = ((NoMeasuredTextView)paramView.findViewById(2131302860));
    if ((this.userName != null) && (this.DAm != null))
    {
      this.DAm.setShouldEllipsize(true);
      this.DAm.setTextSize(0, com.tencent.mm.cc.a.au(this.mContext, 2131165467));
      if (!this.vJc) {
        break label427;
      }
      this.DAm.setTextColor(com.tencent.mm.cc.a.m(this.mContext, 2131101182));
      NoMeasuredTextView localNoMeasuredTextView = this.DAm;
      if (this.DAg != null) {
        break label446;
      }
      localObject = this.userName;
      label151:
      localNoMeasuredTextView.setText((CharSequence)localObject);
      if (this.DAm.getPaint() != null) {
        this.DAm.getPaint().setFakeBoldText(true);
      }
    }
    localObject = (TextView)paramView.findViewById(2131306244);
    if ((this.DAh != null) && (localObject != null))
    {
      ((TextView)localObject).setText(paramView.getResources().getString(2131755271, new Object[] { this.DAh }));
      label225:
      ((TextView)localObject).setOnClickListener(this.DAw);
      localObject = (TextView)paramView.findViewById(2131304190);
      if (localObject != null)
      {
        if (this.DAl <= 99) {
          break label467;
        }
        ((TextView)localObject).setText(this.mContext.getString(2131764343));
        ((TextView)localObject).setBackgroundResource(u.ks(this.mContext));
        ((TextView)localObject).setVisibility(0);
      }
      label287:
      this.DAi = ((RelativeLayout)paramView.findViewById(2131303604));
      this.DAi.setOnClickListener(this.DAw);
      this.DAj = paramView.findViewById(2131300699);
      if (this.DAj != null) {
        if ((this.vJc) || (!this.DAk)) {
          break label527;
        }
      }
    }
    label527:
    for (int i = com.tencent.mm.cc.a.av(this.mContext, 2131166722);; i = com.tencent.mm.cc.a.av(this.mContext, 2131166721))
    {
      this.DAj.setPadding(this.DAj.getPaddingLeft(), i, this.DAj.getPaddingRight(), this.DAj.getPaddingBottom());
      this.DAj.setOnClickListener(this.DAu);
      aH(this.vJc, this.DAk);
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
          for (int i = com.tencent.mm.cc.a.av(AccountInfoPreference.this.mContext, 2131166721) - com.tencent.mm.cc.a.av(AccountInfoPreference.this.mContext, 2131166722);; i = 0)
          {
            ac.d("MicroMsg.AccountInfoPreference", "root.width:%s, root.height:%s, tip.width:%s, tip.height:%s, offsetY:%s", new Object[] { Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.d(AccountInfoPreference.this).getHeight()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getWidth()), Integer.valueOf(AccountInfoPreference.e(AccountInfoPreference.this).getHeight()), Integer.valueOf(i) });
            ((e)g.ad(e.class)).getStoryUIFactory().d(AccountInfoPreference.d(AccountInfoPreference.this), AccountInfoPreference.e(AccountInfoPreference.this), i);
            AccountInfoPreference localAccountInfoPreference = AccountInfoPreference.this;
            boolean bool1 = bool2;
            if (((e)g.ad(e.class)).isShowStoryCheck())
            {
              bool1 = bool2;
              if (c.aeH().cG(352279, 266241)) {
                bool1 = true;
              }
            }
            localAccountInfoPreference.DAr = bool1;
            AccountInfoPreference.this.ePC();
            AppMethodBeat.o(169792);
            return;
          }
        }
      });
      AppMethodBeat.o(31807);
      return;
      label427:
      this.DAm.setTextColor(ao.aJ(this.mContext, 2130968584));
      break;
      label446:
      localObject = this.DAg;
      break label151;
      if (localObject == null) {
        break label225;
      }
      ((TextView)localObject).setVisibility(8);
      break label225;
      label467:
      if (this.DAl > 0)
      {
        ((TextView)localObject).setText(this.DAl);
        ((TextView)localObject).setBackgroundResource(u.aM(this.mContext, this.DAl));
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