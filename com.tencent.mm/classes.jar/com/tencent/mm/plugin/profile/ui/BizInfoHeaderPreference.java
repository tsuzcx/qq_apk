package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class BizInfoHeaderPreference
  extends Preference
  implements e.a, n.b
{
  private af contact;
  private MMActivity imP;
  private boolean paC;
  private TextView siX;
  private TextView svO;
  private ImageView uzJ;
  private ImageView uzK;
  private View uzL;
  private String uzM;
  private com.tencent.mm.api.c uzN;
  private com.tencent.mm.plugin.profile.ui.b.a uzO;
  private com.tencent.mm.plugin.profile.ui.b.b uzP;
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26927);
    this.paC = false;
    this.uzO = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.uzP = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(26927);
  }
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26928);
    this.paC = false;
    this.uzO = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.uzP = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(26928);
  }
  
  private boolean Jk()
  {
    AppMethodBeat.i(26935);
    if (this.uzN == null)
    {
      AppMethodBeat.o(26935);
      return true;
    }
    boolean bool = this.uzN.Jk();
    AppMethodBeat.o(26935);
    return bool;
  }
  
  private boolean dch()
  {
    return (this.paC) && (this.contact != null);
  }
  
  private void initView()
  {
    AppMethodBeat.i(26930);
    if (!dch())
    {
      ad.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.paC + "contact = " + this.contact);
      AppMethodBeat.o(26930);
      return;
    }
    this.siX.setText(k.b(this.imP, bt.nullAsNil(this.contact.ZW()) + " ", this.siX.getTextSize()));
    if (this.uzN == null) {
      this.uzN = f.ei(this.contact.field_username);
    }
    if (this.uzN != null) {
      this.uzM = this.uzN.field_brandIconURL;
    }
    com.tencent.mm.plugin.brandservice.b.e.a(this.uzJ, this.contact, this.uzM, false);
    this.uzJ.setTag(this.contact.field_username);
    this.uzL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26926);
        Object localObject = BizInfoHeaderPreference.a(BizInfoHeaderPreference.this).field_username;
        paramAnonymousView = new Intent(BizInfoHeaderPreference.b(BizInfoHeaderPreference.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", BizInfoHeaderPreference.c(BizInfoHeaderPreference.this));
        localObject = BizInfoHeaderPreference.b(BizInfoHeaderPreference.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26926);
      }
    });
    if ((com.tencent.mm.n.b.ls(this.contact.field_type)) && (Jk())) {
      if (!bt.isNullOrNil(this.contact.Ss()))
      {
        this.svO.setVisibility(0);
        this.svO.setText(this.mContext.getString(2131755760) + this.contact.Ss());
      }
    }
    while (this.contact.ZO())
    {
      this.uzK.setVisibility(0);
      AppMethodBeat.o(26930);
      return;
      if ((!af.aHK(this.contact.field_username)) && (!w.sC(this.contact.field_username)))
      {
        String str = bt.nullAsNil(this.contact.ZY());
        this.svO.setText(this.mContext.getString(2131755760) + str);
        this.svO.setVisibility(0);
      }
      else
      {
        this.svO.setVisibility(8);
        continue;
        this.svO.setVisibility(8);
      }
    }
    this.uzK.setVisibility(8);
    AppMethodBeat.o(26930);
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
    if (!dch())
    {
      ad.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.paC + "contact = " + this.contact);
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
      az.arV();
      this.contact = com.tencent.mm.model.c.apM().aHY(paramn);
    }
    AppMethodBeat.o(26934);
  }
  
  public final void a(af paramaf, String paramString, com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(26931);
    this.uzM = paramString;
    this.uzN = paramc;
    onDetach();
    az.arV();
    com.tencent.mm.model.c.apM().a(this.uzP);
    p.auq().d(this.uzO);
    this.contact = paramaf;
    if (bt.nullAsNil(paramaf.field_username).length() > 0) {}
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
    this.siX = ((TextView)paramView.findViewById(2131298631));
    this.svO = ((TextView)paramView.findViewById(2131298662));
    this.uzK = ((ImageView)paramView.findViewById(2131297286));
    this.uzJ = ((ImageView)paramView.findViewById(2131298597));
    this.uzL = paramView.findViewById(2131298598);
    this.paC = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(26929);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(26932);
    az.arV();
    com.tencent.mm.model.c.apM().b(this.uzP);
    p.auq().e(this.uzO);
    AppMethodBeat.o(26932);
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(26933);
    if (!dch())
    {
      ad.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.paC + "contact = " + this.contact);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */