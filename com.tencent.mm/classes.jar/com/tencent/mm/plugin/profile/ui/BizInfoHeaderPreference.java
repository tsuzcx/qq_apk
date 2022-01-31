package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class BizInfoHeaderPreference
  extends Preference
  implements d.a, m.b
{
  private MMActivity bER;
  ad dnp;
  private boolean jAt = false;
  private TextView lbC;
  private TextView lkM;
  private ImageView mVu;
  private ImageView mVv;
  private View mVw;
  String mVx;
  com.tencent.mm.ai.d mVy;
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public BizInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  private boolean bsu()
  {
    return (this.jAt) && (this.dnp != null);
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      return;
      if (!bsu())
      {
        y.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.jAt + "contact = " + this.dnp);
        return;
      }
      paramm = (String)paramObject;
    } while ((bk.pm(paramm).length() <= 0) || (this.dnp == null) || (!this.dnp.field_username.equals(paramm)));
    au.Hx();
    this.dnp = c.Fw().abl(paramm);
  }
  
  final void initView()
  {
    if (!bsu())
    {
      y.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.jAt + "contact = " + this.dnp);
      return;
    }
    this.lbC.setText(j.a(this.bER, bk.pm(this.dnp.Bp()) + " ", this.lbC.getTextSize()));
    if (this.mVy == null) {
      this.mVy = f.kX(this.dnp.field_username);
    }
    if (this.mVy != null) {
      this.mVx = this.mVy.field_brandIconURL;
    }
    com.tencent.mm.plugin.brandservice.b.a.a(this.mVu, this.dnp, this.mVx);
    this.mVu.setTag(this.dnp.field_username);
    this.mVw.setOnClickListener(new BizInfoHeaderPreference.1(this));
    boolean bool;
    if (com.tencent.mm.n.a.gR(this.dnp.field_type)) {
      if (this.mVy == null)
      {
        bool = true;
        if (!bool) {
          break label387;
        }
        if (bk.bl(this.dnp.vk())) {
          break label293;
        }
        this.lkM.setVisibility(0);
        this.lkM.setText(this.mContext.getString(R.l.app_field_username) + this.dnp.vk());
      }
    }
    label387:
    for (;;)
    {
      if (!this.dnp.Bi()) {
        break label399;
      }
      this.mVv.setVisibility(0);
      return;
      bool = this.mVy.LE();
      break;
      label293:
      if ((!ad.aaX(this.dnp.field_username)) && (!s.hj(this.dnp.field_username)))
      {
        String str = bk.pm(this.dnp.Br());
        this.lkM.setText(this.mContext.getString(R.l.app_field_username) + str);
        this.lkM.setVisibility(0);
      }
      else
      {
        this.lkM.setVisibility(8);
        continue;
        this.lkM.setVisibility(8);
      }
    }
    label399:
    this.mVv.setVisibility(8);
  }
  
  public final void kk(String paramString)
  {
    if (!bsu()) {
      y.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.jAt + "contact = " + this.dnp);
    }
    do
    {
      return;
      if (bk.pm(paramString).length() <= 0)
      {
        y.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = " + paramString);
        return;
      }
    } while (!paramString.equals(this.dnp.field_username));
    initView();
  }
  
  public final void onBindView(View paramView)
  {
    y.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
    this.lbC = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.lkM = ((TextView)paramView.findViewById(R.h.contact_info_username_tv));
    this.mVv = ((ImageView)paramView.findViewById(R.h.biz_favor));
    this.mVu = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.mVw = paramView.findViewById(R.h.contact_info_avatar_iv_mask);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference
 * JD-Core Version:    0.7.0.1
 */