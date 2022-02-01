package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.am.g;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class BizInfoHeaderPreference
  extends Preference
  implements e.a, n.b
{
  private am contact;
  private MMActivity fLP;
  private boolean qhs;
  private TextView uGm;
  private TextView upn;
  private ImageView wPJ;
  private ImageView wPK;
  private View wPL;
  private String wPM;
  private com.tencent.mm.api.c wPN;
  private com.tencent.mm.plugin.profile.ui.b.a wPO;
  private com.tencent.mm.plugin.profile.ui.b.b wPP;
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26927);
    this.qhs = false;
    this.wPO = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.wPP = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(26927);
  }
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26928);
    this.qhs = false;
    this.wPO = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.wPP = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(26928);
  }
  
  private boolean Kt()
  {
    AppMethodBeat.i(26935);
    if (this.wPN == null)
    {
      AppMethodBeat.o(26935);
      return true;
    }
    boolean bool = this.wPN.Kt();
    AppMethodBeat.o(26935);
    return bool;
  }
  
  private boolean dAs()
  {
    return (this.qhs) && (this.contact != null);
  }
  
  private void initView()
  {
    AppMethodBeat.i(26930);
    if (!dAs())
    {
      ad.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.qhs + "contact = " + this.contact);
      AppMethodBeat.o(26930);
      return;
    }
    this.upn.setText(k.b(this.fLP, bt.nullAsNil(this.contact.adu()) + " ", this.upn.getTextSize()));
    if (this.wPN == null) {
      this.wPN = g.eS(this.contact.field_username);
    }
    if (this.wPN != null) {
      this.wPM = this.wPN.field_brandIconURL;
    }
    d.a(this.wPJ, this.contact, this.wPM, false);
    this.wPJ.setTag(this.contact.field_username);
    this.wPL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26926);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = BizInfoHeaderPreference.a(BizInfoHeaderPreference.this).field_username;
        paramAnonymousView = new Intent(BizInfoHeaderPreference.b(BizInfoHeaderPreference.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", BizInfoHeaderPreference.c(BizInfoHeaderPreference.this));
        localObject = BizInfoHeaderPreference.b(BizInfoHeaderPreference.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26926);
      }
    });
    if ((com.tencent.mm.o.b.lM(this.contact.field_type)) && (Kt())) {
      if (!bt.isNullOrNil(this.contact.VA()))
      {
        this.uGm.setVisibility(0);
        this.uGm.setText(this.mContext.getString(2131755760) + this.contact.VA());
      }
    }
    while (this.contact.adm())
    {
      this.wPK.setVisibility(0);
      AppMethodBeat.o(26930);
      return;
      if ((!am.aSX(this.contact.field_username)) && (!w.zC(this.contact.field_username)))
      {
        String str = bt.nullAsNil(this.contact.adw());
        this.uGm.setText(this.mContext.getString(2131755760) + str);
        this.uGm.setVisibility(0);
      }
      else
      {
        this.uGm.setVisibility(8);
        continue;
        this.uGm.setVisibility(8);
      }
    }
    this.wPK.setVisibility(8);
    AppMethodBeat.o(26930);
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(26933);
    if (!dAs())
    {
      ad.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.qhs + "contact = " + this.contact);
      AppMethodBeat.o(26933);
      return;
    }
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      ad.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(26933);
      return;
    }
    if (paramString.equals(this.contact.field_username)) {
      initView();
    }
    AppMethodBeat.o(26933);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(26934);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26934);
      return;
    }
    if (!dAs())
    {
      ad.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.qhs + "contact = " + this.contact);
      AppMethodBeat.o(26934);
      return;
    }
    paramn = (String)paramObject;
    if (bt.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(26934);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      ba.aBQ();
      this.contact = com.tencent.mm.model.c.azp().Bf(paramn);
    }
    AppMethodBeat.o(26934);
  }
  
  public final void a(am paramam, String paramString, com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(26931);
    this.wPM = paramString;
    this.wPN = paramc;
    onDetach();
    ba.aBQ();
    com.tencent.mm.model.c.azp().a(this.wPP);
    p.aEk().d(this.wPO);
    this.contact = paramam;
    if (bt.nullAsNil(paramam.field_username).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("initView: contact username is null", bool);
      initView();
      AppMethodBeat.o(26931);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26929);
    ad.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
    this.upn = ((TextView)paramView.findViewById(2131298631));
    this.uGm = ((TextView)paramView.findViewById(2131298662));
    this.wPK = ((ImageView)paramView.findViewById(2131297286));
    this.wPJ = ((ImageView)paramView.findViewById(2131298597));
    this.wPL = paramView.findViewById(2131298598);
    this.qhs = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(26929);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(26932);
    ba.aBQ();
    com.tencent.mm.model.c.azp().b(this.wPP);
    p.aEk().e(this.wPO);
    AppMethodBeat.o(26932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */