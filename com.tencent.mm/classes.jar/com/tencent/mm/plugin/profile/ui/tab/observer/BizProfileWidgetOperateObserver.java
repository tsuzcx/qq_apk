package com.tencent.mm.plugin.profile.ui.tab.observer;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.f;

public class BizProfileWidgetOperateObserver
  extends BaseBizProfileOperateObserver
{
  private qm NcO;
  private ContactInfoUI NdH;
  private boolean NdJ = true;
  
  public BizProfileWidgetOperateObserver(ContactInfoUI paramContactInfoUI)
  {
    this.NdH = paramContactInfoUI;
  }
  
  public final boolean a(f paramf, au paramau)
  {
    AppMethodBeat.i(306212);
    if (this.NdJ)
    {
      this.NdJ = false;
      this.NcO = b.aSd(paramau.field_username);
      c localc = g.hU(paramau.field_username);
      this.hcB = null;
      this.hcC = null;
      this.MWX = null;
      if (localc != null)
      {
        paramf = localc;
        if (localc.dO(false) != null) {}
      }
      else
      {
        paramf = localc;
        if (this.MWY != null)
        {
          paramf = new c();
          paramf.field_username = paramau.field_username;
          paramf.field_brandFlag = this.MWY.pSt;
          paramf.field_brandIconURL = this.MWY.pSw;
          paramf.field_brandInfo = this.MWY.pSv;
          paramf.field_extInfo = this.MWY.pSu;
          paramf.field_type = paramf.dO(false).getServiceType();
        }
      }
      if ((paramf != null) && (paramf.field_brandInfo == null) && (paramf.field_extInfo == null) && (this.MWY != null))
      {
        paramf.field_username = paramau.field_username;
        paramf.field_brandFlag = this.MWY.pSt;
        paramf.field_brandIconURL = this.MWY.pSw;
        paramf.field_brandInfo = this.MWY.pSv;
        paramf.field_extInfo = this.MWY.pSu;
        paramf.field_type = paramf.dO(false).getServiceType();
      }
      if (paramf != null)
      {
        this.MVg = paramf;
        this.hcB = paramf.aAY();
        this.hcC = paramf.dO(false);
        this.MWX = this.hcC.getWxaEntryInfoList();
        if ((this.hcC.aBc() != null) && (this.hcC.aBc().length() > 0)) {
          this.hcL = this.hcC.aBc();
        }
      }
      paramf = this.NdH.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!Util.isNullOrNil(paramf))
      {
        this.NdH.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        k.a(this.NdH, paramf, "", this.NdH.getString(R.l.app_ok), null);
      }
    }
    AppMethodBeat.o(306212);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver
 * JD-Core Version:    0.7.0.1
 */