package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoHeaderPreference
  extends Preference
  implements d.a, m.b
{
  private MMActivity bER;
  ad dnp;
  private ImageView dpY;
  private TextView eXr;
  private TextView gaI;
  private boolean jAt;
  String mVx;
  com.tencent.mm.ai.d mVy;
  private ImageView mZH;
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public NewBizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      return;
      paramm = (String)paramObject;
    } while ((bk.pm(paramm).length() <= 0) || (this.dnp == null) || (!this.dnp.field_username.equals(paramm)));
    au.Hx();
    this.dnp = c.Fw().abl(paramm);
  }
  
  final void initView()
  {
    boolean bool = true;
    if ((!this.jAt) || (this.dnp == null))
    {
      y.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
      return;
    }
    this.eXr.setText(j.a(this.bER, bk.pm(this.dnp.Bp()), this.eXr.getTextSize()));
    if (this.mVy == null) {
      this.mVy = f.kX(this.dnp.field_username);
    }
    if (this.mVy != null) {
      this.mVx = this.mVy.field_brandIconURL;
    }
    com.tencent.mm.plugin.brandservice.b.a.a(this.dpY, this.dnp, this.mVx);
    this.dpY.setOnClickListener(new NewBizInfoHeaderPreference.1(this));
    if (bk.pm(this.dnp.signature).trim().length() <= 0)
    {
      this.gaI.setVisibility(8);
      if ((s.ctL()) && (com.tencent.mm.n.a.gR(this.dnp.field_type)) && (this.dnp.Bl()) && (f.kZ(this.dnp.field_username)))
      {
        this.mZH.setVisibility(0);
        localObject = this.mZH.getLayoutParams();
        int i = (int)this.eXr.getTextSize();
        ((ViewGroup.LayoutParams)localObject).height = i;
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.mZH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.gaI.setText(j.b(this.bER, this.dnp.signature));
      this.gaI.setVisibility(0);
      if (am.a.dVA != null)
      {
        localObject = BackwardSupportUtil.b.e(am.a.dVA.hL(this.dnp.field_verifyFlag), 2.0F);
        label293:
        if (localObject != null) {
          break label354;
        }
        label297:
        y.i("MicroMsg.NewBizInfoHeaderPreference", "verify bmp is null ? %B", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label368;
        }
      }
    }
    label354:
    label368:
    for (Object localObject = new BitmapDrawable(this.bER.getResources(), (Bitmap)localObject);; localObject = null)
    {
      this.gaI.setCompoundDrawables((Drawable)localObject, null, null, null);
      break;
      localObject = null;
      break label293;
      bool = false;
      break label297;
      this.mZH.setVisibility(4);
      return;
    }
  }
  
  public final void kk(String paramString)
  {
    y.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", new Object[] { paramString });
    if (bk.bl(paramString)) {
      y.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
    }
    while ((this.dnp == null) || (!paramString.equals(this.dnp.field_username))) {
      return;
    }
    initView();
  }
  
  public final void onBindView(View paramView)
  {
    this.dpY = ((ImageView)paramView.findViewById(R.h.bizinfo_avatar));
    this.eXr = ((TextView)paramView.findViewById(R.h.bizinfo_title));
    this.gaI = ((TextView)paramView.findViewById(R.h.bizinfo_desc));
    this.mZH = ((ImageView)paramView.findViewById(R.h.bizinfo_star));
    this.jAt = true;
    initView();
    super.onBindView(paramView);
  }
  
  public final void onDetach()
  {
    au.Hx();
    c.Fw().b(this);
    o.JQ().e(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */