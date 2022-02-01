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
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class BizInfoHeaderPreference
  extends Preference
  implements e.a, n.b
{
  private ai contact;
  private MMActivity iMV;
  private boolean pDN;
  private TextView tDD;
  private TextView tqQ;
  private ImageView vIC;
  private ImageView vID;
  private View vIE;
  private String vIF;
  private com.tencent.mm.api.c vIG;
  private com.tencent.mm.plugin.profile.ui.b.a vIH;
  private com.tencent.mm.plugin.profile.ui.b.b vII;
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26927);
    this.pDN = false;
    this.vIH = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.vII = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(26927);
  }
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26928);
    this.pDN = false;
    this.vIH = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.vII = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(26928);
  }
  
  private boolean IT()
  {
    AppMethodBeat.i(26935);
    if (this.vIG == null)
    {
      AppMethodBeat.o(26935);
      return true;
    }
    boolean bool = this.vIG.IT();
    AppMethodBeat.o(26935);
    return bool;
  }
  
  private boolean dpP()
  {
    return (this.pDN) && (this.contact != null);
  }
  
  private void initView()
  {
    AppMethodBeat.i(26930);
    if (!dpP())
    {
      ac.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.pDN + "contact = " + this.contact);
      AppMethodBeat.o(26930);
      return;
    }
    this.tqQ.setText(k.b(this.iMV, bs.nullAsNil(this.contact.aaR()) + " ", this.tqQ.getTextSize()));
    if (this.vIG == null) {
      this.vIG = f.dX(this.contact.field_username);
    }
    if (this.vIG != null) {
      this.vIF = this.vIG.field_brandIconURL;
    }
    d.a(this.vIC, this.contact, this.vIF, false);
    this.vIC.setTag(this.contact.field_username);
    this.vIE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26926);
        Object localObject = BizInfoHeaderPreference.a(BizInfoHeaderPreference.this).field_username;
        paramAnonymousView = new Intent(BizInfoHeaderPreference.b(BizInfoHeaderPreference.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", BizInfoHeaderPreference.c(BizInfoHeaderPreference.this));
        localObject = BizInfoHeaderPreference.b(BizInfoHeaderPreference.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26926);
      }
    });
    if ((com.tencent.mm.n.b.ln(this.contact.field_type)) && (IT())) {
      if (!bs.isNullOrNil(this.contact.Tl()))
      {
        this.tDD.setVisibility(0);
        this.tDD.setText(this.mContext.getString(2131755760) + this.contact.Tl());
      }
    }
    while (this.contact.aaJ())
    {
      this.vID.setVisibility(0);
      AppMethodBeat.o(26930);
      return;
      if ((!ai.aNf(this.contact.field_username)) && (!w.wF(this.contact.field_username)))
      {
        String str = bs.nullAsNil(this.contact.aaT());
        this.tDD.setText(this.mContext.getString(2131755760) + str);
        this.tDD.setVisibility(0);
      }
      else
      {
        this.tDD.setVisibility(8);
        continue;
        this.tDD.setVisibility(8);
      }
    }
    this.vID.setVisibility(8);
    AppMethodBeat.o(26930);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(26933);
    if (!dpP())
    {
      ac.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.pDN + "contact = " + this.contact);
      AppMethodBeat.o(26933);
      return;
    }
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      ac.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = ".concat(String.valueOf(paramString)));
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
      ac.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26934);
      return;
    }
    if (!dpP())
    {
      ac.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.pDN + "contact = " + this.contact);
      AppMethodBeat.o(26934);
      return;
    }
    paramn = (String)paramObject;
    if (bs.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(26934);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      az.ayM();
      this.contact = com.tencent.mm.model.c.awB().aNt(paramn);
    }
    AppMethodBeat.o(26934);
  }
  
  public final void a(ai paramai, String paramString, com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(26931);
    this.vIF = paramString;
    this.vIG = paramc;
    onDetach();
    az.ayM();
    com.tencent.mm.model.c.awB().a(this.vII);
    p.aBh().d(this.vIH);
    this.contact = paramai;
    if (bs.nullAsNil(paramai.field_username).length() > 0) {}
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
    ac.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
    this.tqQ = ((TextView)paramView.findViewById(2131298631));
    this.tDD = ((TextView)paramView.findViewById(2131298662));
    this.vID = ((ImageView)paramView.findViewById(2131297286));
    this.vIC = ((ImageView)paramView.findViewById(2131298597));
    this.vIE = paramView.findViewById(2131298598);
    this.pDN = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(26929);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(26932);
    az.ayM();
    com.tencent.mm.model.c.awB().b(this.vII);
    p.aBh().e(this.vIH);
    AppMethodBeat.o(26932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */