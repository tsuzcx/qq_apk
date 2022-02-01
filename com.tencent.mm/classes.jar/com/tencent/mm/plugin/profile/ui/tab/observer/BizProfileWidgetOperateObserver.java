package com.tencent.mm.plugin.profile.ui.tab.observer;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.a;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;

public class BizProfileWidgetOperateObserver
  extends BaseBizProfileOperateObserver
{
  private ContactInfoUI Hdt;
  private pd Hdu;
  private boolean Hdz = true;
  
  public BizProfileWidgetOperateObserver(ContactInfoUI paramContactInfoUI)
  {
    this.Hdt = paramContactInfoUI;
  }
  
  public final boolean a(f paramf, as paramas)
  {
    AppMethodBeat.i(291757);
    if (this.Hdz)
    {
      this.Hdz = false;
      this.Hdu = a.aUW(paramas.field_username);
      c localc = g.gu(paramas.field_username);
      this.eZb = null;
      this.eZc = null;
      this.GYU = null;
      if (localc != null)
      {
        paramf = localc;
        if (localc.dc(false) != null) {}
      }
      else
      {
        paramf = localc;
        if (this.GYV != null)
        {
          paramf = new c();
          paramf.field_username = paramas.field_username;
          paramf.field_brandFlag = this.GYV.mVM;
          paramf.field_brandIconURL = this.GYV.mVP;
          paramf.field_brandInfo = this.GYV.mVO;
          paramf.field_extInfo = this.GYV.mVN;
          paramf.field_type = paramf.dc(false).getServiceType();
        }
      }
      if ((paramf != null) && (paramf.field_brandInfo == null) && (paramf.field_extInfo == null) && (this.GYV != null))
      {
        paramf.field_username = paramas.field_username;
        paramf.field_brandFlag = this.GYV.mVM;
        paramf.field_brandIconURL = this.GYV.mVP;
        paramf.field_brandInfo = this.GYV.mVO;
        paramf.field_extInfo = this.GYV.mVN;
        paramf.field_type = paramf.dc(false).getServiceType();
      }
      if (paramf != null)
      {
        this.GXj = paramf;
        this.eZb = paramf.Zg();
        this.eZc = paramf.dc(false);
        this.GYU = this.eZc.getWxaEntryInfoList();
        if ((this.eZc.Zk() != null) && (this.eZc.Zk().length() > 0)) {
          this.eZl = this.eZc.Zk();
        }
      }
      paramf = this.Hdt.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!Util.isNullOrNil(paramf))
      {
        this.Hdt.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        h.a(this.Hdt, paramf, "", this.Hdt.getString(R.l.app_ok), null);
      }
    }
    AppMethodBeat.o(291757);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver
 * JD-Core Version:    0.7.0.1
 */