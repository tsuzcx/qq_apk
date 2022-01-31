package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.profile.ui.b.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class BizInfoHeaderPreference
  extends Preference
  implements d.a, n.b
{
  private MMActivity cmc;
  private ad contact;
  private boolean lJS;
  private TextView nIh;
  private TextView nzx;
  private ImageView pxZ;
  private ImageView pya;
  private View pyb;
  private String pyc;
  private com.tencent.mm.aj.d pyd;
  private com.tencent.mm.plugin.profile.ui.b.a pye;
  private b pyf;
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23307);
    this.lJS = false;
    this.pye = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.pyf = new b(this);
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23307);
  }
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23308);
    this.lJS = false;
    this.pye = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.pyf = new b(this);
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23308);
  }
  
  private boolean aem()
  {
    AppMethodBeat.i(23315);
    if (this.pyd == null)
    {
      AppMethodBeat.o(23315);
      return true;
    }
    boolean bool = this.pyd.aem();
    AppMethodBeat.o(23315);
    return bool;
  }
  
  private boolean cbQ()
  {
    return (this.lJS) && (this.contact != null);
  }
  
  private void initView()
  {
    AppMethodBeat.i(23310);
    if (!cbQ())
    {
      ab.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lJS + "contact = " + this.contact);
      AppMethodBeat.o(23310);
      return;
    }
    this.nzx.setText(j.b(this.cmc, bo.nullAsNil(this.contact.Oe()) + " ", this.nzx.getTextSize()));
    if (this.pyd == null) {
      this.pyd = f.rS(this.contact.field_username);
    }
    if (this.pyd != null) {
      this.pyc = this.pyd.field_brandIconURL;
    }
    com.tencent.mm.plugin.brandservice.b.a.a(this.pxZ, this.contact, this.pyc, false);
    this.pxZ.setTag(this.contact.field_username);
    this.pyb.setOnClickListener(new BizInfoHeaderPreference.1(this));
    if ((com.tencent.mm.n.a.je(this.contact.field_type)) && (aem())) {
      if (!bo.isNullOrNil(this.contact.Hq()))
      {
        this.nIh.setVisibility(0);
        this.nIh.setText(this.mContext.getString(2131296950) + this.contact.Hq());
      }
    }
    while (this.contact.NY())
    {
      this.pya.setVisibility(0);
      AppMethodBeat.o(23310);
      return;
      if ((!ad.ari(this.contact.field_username)) && (!t.nS(this.contact.field_username)))
      {
        String str = bo.nullAsNil(this.contact.Og());
        this.nIh.setText(this.mContext.getString(2131296950) + str);
        this.nIh.setVisibility(0);
      }
      else
      {
        this.nIh.setVisibility(8);
        continue;
        this.nIh.setVisibility(8);
      }
    }
    this.pya.setVisibility(8);
    AppMethodBeat.o(23310);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(23314);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(23314);
      return;
    }
    if (!cbQ())
    {
      ab.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lJS + "contact = " + this.contact);
      AppMethodBeat.o(23314);
      return;
    }
    paramn = (String)paramObject;
    if (bo.nullAsNil(paramn).length() <= 0)
    {
      AppMethodBeat.o(23314);
      return;
    }
    if ((this.contact != null) && (this.contact.field_username.equals(paramn)))
    {
      aw.aaz();
      this.contact = c.YA().arw(paramn);
    }
    AppMethodBeat.o(23314);
  }
  
  public final void a(ad paramad, String paramString, com.tencent.mm.aj.d paramd)
  {
    AppMethodBeat.i(23311);
    this.pyc = paramString;
    this.pyd = paramd;
    onDetach();
    aw.aaz();
    c.YA().a(this.pyf);
    o.acQ().d(this.pye);
    this.contact = paramad;
    if (bo.nullAsNil(paramad.field_username).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("initView: contact username is null", bool);
      initView();
      AppMethodBeat.o(23311);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23309);
    ab.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
    this.nzx = ((TextView)paramView.findViewById(2131821498));
    this.nIh = ((TextView)paramView.findViewById(2131823100));
    this.pya = ((ImageView)paramView.findViewById(2131823101));
    this.pxZ = ((ImageView)paramView.findViewById(2131821497));
    this.pyb = paramView.findViewById(2131823099);
    this.lJS = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(23309);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(23312);
    aw.aaz();
    c.YA().b(this.pyf);
    o.acQ().e(this.pye);
    AppMethodBeat.o(23312);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(23313);
    if (!cbQ())
    {
      ab.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lJS + "contact = " + this.contact);
      AppMethodBeat.o(23313);
      return;
    }
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      ab.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(23313);
      return;
    }
    if (paramString.equals(this.contact.field_username)) {
      initView();
    }
    AppMethodBeat.o(23313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */