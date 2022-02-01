package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.ao.g;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.brandservice.b.e;
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
  implements f.a, MStorageEx.IOnStorageChange
{
  private TextView DKE;
  private ImageView GXf;
  private ImageView GXg;
  private View GXh;
  private String GXi;
  private com.tencent.mm.api.c GXj;
  private com.tencent.mm.plugin.profile.ui.b.a GXk;
  private com.tencent.mm.plugin.profile.ui.b.b GXl;
  private as contact;
  private MMActivity iXq;
  private boolean vkO;
  private TextView vsF;
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26927);
    this.vkO = false;
    this.GXk = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.GXl = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(26927);
  }
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26928);
    this.vkO = false;
    this.GXk = new com.tencent.mm.plugin.profile.ui.b.a(this);
    this.GXl = new com.tencent.mm.plugin.profile.ui.b.b(this);
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(26928);
  }
  
  private boolean Zd()
  {
    AppMethodBeat.i(26935);
    if (this.GXj == null)
    {
      AppMethodBeat.o(26935);
      return true;
    }
    boolean bool = this.GXj.Zd();
    AppMethodBeat.o(26935);
    return bool;
  }
  
  private boolean fpT()
  {
    return (this.vkO) && (this.contact != null);
  }
  
  private void initView()
  {
    AppMethodBeat.i(26930);
    if (!fpT())
    {
      Log.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.vkO + "contact = " + this.contact);
      AppMethodBeat.o(26930);
      return;
    }
    this.vsF.setText(l.b(this.iXq, Util.nullAsNil(this.contact.ayr()) + " ", this.vsF.getTextSize()));
    if (this.GXj == null) {
      this.GXj = g.gu(this.contact.field_username);
    }
    if (this.GXj != null) {
      this.GXi = this.GXj.field_brandIconURL;
    }
    e.a(this.GXf, this.contact, this.GXi, false);
    this.GXf.setTag(this.contact.field_username);
    this.GXh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26926);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = BizInfoHeaderPreference.a(BizInfoHeaderPreference.this).field_username;
        paramAnonymousView = new Intent(BizInfoHeaderPreference.b(BizInfoHeaderPreference.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", BizInfoHeaderPreference.c(BizInfoHeaderPreference.this));
        localObject = BizInfoHeaderPreference.b(BizInfoHeaderPreference.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26926);
      }
    });
    if ((d.rk(this.contact.field_type)) && (Zd())) {
      if (!Util.isNullOrNil(this.contact.apf()))
      {
        this.DKE.setVisibility(0);
        this.DKE.setText(com.tencent.mm.plugin.profile.c.bE(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.jG(this.contact.field_username, this.contact.apf()));
      }
    }
    while (this.contact.ayh())
    {
      this.GXg.setVisibility(0);
      AppMethodBeat.o(26930);
      return;
      if ((!as.bvU(this.contact.field_username)) && (!ab.Qk(this.contact.field_username)))
      {
        String str = Util.nullAsNil(this.contact.ayt());
        this.DKE.setText(com.tencent.mm.plugin.profile.c.bE(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.jG(this.contact.field_username, str));
        this.DKE.setVisibility(0);
      }
      else
      {
        this.DKE.setVisibility(8);
        continue;
        this.DKE.setVisibility(8);
      }
    }
    this.GXg.setVisibility(8);
    AppMethodBeat.o(26930);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(26933);
    if (!fpT())
    {
      Log.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.vkO + "contact = " + this.contact);
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
    this.GXi = paramString;
    this.GXj = paramc;
    onDetach();
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.GXl);
    q.bhz().d(this.GXk);
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
    this.vsF = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.DKE = ((TextView)paramView.findViewById(R.h.dBG));
    this.GXg = ((ImageView)paramView.findViewById(R.h.dtl));
    this.GXf = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.GXh = paramView.findViewById(R.h.dAL);
    this.vkO = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(26929);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(26932);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this.GXl);
    q.bhz().e(this.GXk);
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
    if (!fpT())
    {
      Log.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.vkO + "contact = " + this.contact);
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
      bh.beI();
      this.contact = com.tencent.mm.model.c.bbL().RG(paramMStorageEx);
    }
    AppMethodBeat.o(26934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */