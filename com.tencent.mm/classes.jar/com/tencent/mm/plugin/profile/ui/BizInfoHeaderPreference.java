package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.g;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class BizInfoHeaderPreference
  extends Preference
  implements e.a, MStorageEx.IOnStorageChange
{
  private ImageView Bdg;
  private ImageView Bdh;
  private View Bdi;
  private String Bdj;
  private com.tencent.mm.api.c Bdk;
  private com.tencent.mm.plugin.profile.ui.b.a Bdl;
  private com.tencent.mm.plugin.profile.ui.b.b Bdm;
  private as contact;
  private MMActivity gte;
  private boolean rFe;
  private TextView rMV;
  private TextView ykC;
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26927);
    this.rFe = false;
    this.Bdl = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.Bdm = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(26927);
  }
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26928);
    this.rFe = false;
    this.Bdl = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.Bdm = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(26928);
  }
  
  private boolean UL()
  {
    AppMethodBeat.i(26935);
    if (this.Bdk == null)
    {
      AppMethodBeat.o(26935);
      return true;
    }
    boolean bool = this.Bdk.UL();
    AppMethodBeat.o(26935);
    return bool;
  }
  
  private boolean eEa()
  {
    return (this.rFe) && (this.contact != null);
  }
  
  private void initView()
  {
    AppMethodBeat.i(26930);
    if (!eEa())
    {
      Log.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.rFe + "contact = " + this.contact);
      AppMethodBeat.o(26930);
      return;
    }
    this.rMV.setText(l.b(this.gte, Util.nullAsNil(this.contact.arI()) + " ", this.rMV.getTextSize()));
    if (this.Bdk == null) {
      this.Bdk = g.fJ(this.contact.field_username);
    }
    if (this.Bdk != null) {
      this.Bdj = this.Bdk.field_brandIconURL;
    }
    d.a(this.Bdg, this.contact, this.Bdj, false);
    this.Bdg.setTag(this.contact.field_username);
    this.Bdi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26926);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = BizInfoHeaderPreference.a(BizInfoHeaderPreference.this).field_username;
        paramAnonymousView = new Intent(BizInfoHeaderPreference.b(BizInfoHeaderPreference.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", BizInfoHeaderPreference.c(BizInfoHeaderPreference.this));
        localObject = BizInfoHeaderPreference.b(BizInfoHeaderPreference.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26926);
      }
    });
    if ((com.tencent.mm.contact.c.oR(this.contact.field_type)) && (UL())) {
      if (!Util.isNullOrNil(this.contact.ajx()))
      {
        this.ykC.setVisibility(0);
        this.ykC.setText(com.tencent.mm.plugin.profile.c.br(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, this.contact.ajx()));
      }
    }
    while (this.contact.arA())
    {
      this.Bdh.setVisibility(0);
      AppMethodBeat.o(26930);
      return;
      if ((!as.bjx(this.contact.field_username)) && (!ab.IR(this.contact.field_username)))
      {
        String str = Util.nullAsNil(this.contact.arK());
        this.ykC.setText(com.tencent.mm.plugin.profile.c.br(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, str));
        this.ykC.setVisibility(0);
      }
      else
      {
        this.ykC.setVisibility(8);
        continue;
        this.ykC.setVisibility(8);
      }
    }
    this.Bdh.setVisibility(8);
    AppMethodBeat.o(26930);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(26933);
    if (!eEa())
    {
      Log.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.rFe + "contact = " + this.contact);
      AppMethodBeat.o(26933);
      return;
    }
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      Log.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(26933);
      return;
    }
    if (paramString.equals(this.contact.field_username)) {
      initView();
    }
    AppMethodBeat.o(26933);
  }
  
  public final void a(as paramas, String paramString, com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(26931);
    this.Bdj = paramString;
    this.Bdk = paramc;
    onDetach();
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.Bdm);
    p.aYn().d(this.Bdl);
    this.contact = paramas;
    if (Util.nullAsNil(paramas.field_username).length() > 0) {}
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
    Log.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
    this.rMV = ((TextView)paramView.findViewById(2131299068));
    this.ykC = ((TextView)paramView.findViewById(2131299099));
    this.Bdh = ((ImageView)paramView.findViewById(2131297443));
    this.Bdg = ((ImageView)paramView.findViewById(2131299034));
    this.Bdi = paramView.findViewById(2131299035);
    this.rFe = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(26929);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(26932);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this.Bdm);
    p.aYn().e(this.Bdl);
    AppMethodBeat.o(26932);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(26934);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(26934);
      return;
    }
    if (!eEa())
    {
      Log.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.rFe + "contact = " + this.contact);
      AppMethodBeat.o(26934);
      return;
    }
    paramMStorageEx = (String)paramObject;
    if (Util.nullAsNil(paramMStorageEx).length() <= 0)
    {
      AppMethodBeat.o(26934);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramMStorageEx)))
    {
      bg.aVF();
      this.contact = com.tencent.mm.model.c.aSN().Kn(paramMStorageEx);
    }
    AppMethodBeat.o(26934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */