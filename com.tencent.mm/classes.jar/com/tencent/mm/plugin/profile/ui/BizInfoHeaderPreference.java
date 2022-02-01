package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.brandservice.model.e;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class BizInfoHeaderPreference
  extends Preference
  implements AvatarStorage.a, MStorageEx.IOnStorageChange
{
  private TextView JBA;
  private ImageView MVc;
  private ImageView MVd;
  private View MVe;
  private String MVf;
  private com.tencent.mm.api.c MVg;
  private com.tencent.mm.plugin.profile.ui.c.a MVh;
  private com.tencent.mm.plugin.profile.ui.c.b MVi;
  private au contact;
  private MMActivity lzt;
  private TextView yEQ;
  private boolean yxr;
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26927);
    this.yxr = false;
    this.MVh = new com.tencent.mm.plugin.profile.ui.c.a(this);
    this.MVi = new com.tencent.mm.plugin.profile.ui.c.b(this);
    this.lzt = ((MMActivity)paramContext);
    this.yxr = false;
    AppMethodBeat.o(26927);
  }
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26928);
    this.yxr = false;
    this.MVh = new com.tencent.mm.plugin.profile.ui.c.a(this);
    this.MVi = new com.tencent.mm.plugin.profile.ui.c.b(this);
    this.lzt = ((MMActivity)paramContext);
    this.yxr = false;
    AppMethodBeat.o(26928);
  }
  
  private boolean aAV()
  {
    AppMethodBeat.i(26935);
    if (this.MVg == null)
    {
      AppMethodBeat.o(26935);
      return true;
    }
    boolean bool = this.MVg.aAV();
    AppMethodBeat.o(26935);
    return bool;
  }
  
  private boolean gBh()
  {
    return (this.yxr) && (this.contact != null);
  }
  
  private void initView()
  {
    AppMethodBeat.i(26930);
    if (!gBh())
    {
      Log.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.yxr + "contact = " + this.contact);
      AppMethodBeat.o(26930);
      return;
    }
    Object localObject = p.b(this.lzt, Util.nullAsNil(this.contact.aSU()) + " ", this.yEQ.getTextSize());
    this.yEQ.setText(com.tencent.mm.plugin.profile.c.a(this.lzt, this.contact.field_username, (SpannableString)localObject));
    if (this.MVg == null) {
      this.MVg = g.hU(this.contact.field_username);
    }
    if (this.MVg != null) {
      this.MVf = this.MVg.field_brandIconURL;
    }
    e.a(this.MVc, this.contact, this.MVf, false);
    this.MVc.setTag(this.contact.field_username);
    this.MVe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26926);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = BizInfoHeaderPreference.a(BizInfoHeaderPreference.this).field_username;
        paramAnonymousView = new Intent(BizInfoHeaderPreference.b(BizInfoHeaderPreference.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", BizInfoHeaderPreference.c(BizInfoHeaderPreference.this));
        localObject = BizInfoHeaderPreference.b(BizInfoHeaderPreference.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26926);
      }
    });
    if ((d.rs(this.contact.field_type)) && (aAV())) {
      if (!Util.isNullOrNil(this.contact.aJs()))
      {
        this.JBA.setVisibility(0);
        this.JBA.setText(com.tencent.mm.plugin.profile.c.bG(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.la(this.contact.field_username, this.contact.aJs()));
      }
    }
    while (this.contact.aSK())
    {
      this.MVd.setVisibility(0);
      AppMethodBeat.o(26930);
      return;
      if ((!au.bxb(this.contact.field_username)) && (!au.bxa(this.contact.field_username)))
      {
        localObject = Util.nullAsNil(this.contact.aSW());
        this.JBA.setText(com.tencent.mm.plugin.profile.c.bG(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.la(this.contact.field_username, (String)localObject));
        this.JBA.setVisibility(0);
      }
      else
      {
        this.JBA.setVisibility(8);
        continue;
        this.JBA.setVisibility(8);
      }
    }
    this.MVd.setVisibility(8);
    AppMethodBeat.o(26930);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(26933);
    if (!gBh())
    {
      Log.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.yxr + "contact = " + this.contact);
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
  
  public final void a(au paramau, String paramString, com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(26931);
    this.MVf = paramString;
    this.MVg = paramc;
    onDetach();
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this.MVi);
    q.bFp().d(this.MVh);
    this.contact = paramau;
    if (Util.nullAsNil(paramau.field_username).length() > 0) {}
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
    this.yEQ = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.JBA = ((TextView)paramView.findViewById(R.h.fCU));
    this.MVd = ((ImageView)paramView.findViewById(R.h.ftA));
    this.MVc = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.MVe = paramView.findViewById(R.h.fBL);
    this.yxr = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(26929);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(26932);
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this.MVi);
    q.bFp().e(this.MVh);
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
    if (!gBh())
    {
      Log.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.yxr + "contact = " + this.contact);
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
      bh.bCz();
      this.contact = com.tencent.mm.model.c.bzA().JE(paramMStorageEx);
    }
    AppMethodBeat.o(26934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */