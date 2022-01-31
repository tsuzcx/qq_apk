package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class s$3
  implements n.d
{
  s$3(s params, n paramn, awd paramawd, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = paramMenuItem.getItemId();
    y.d("MicroMsg.GalleryTitleManager", "showAlertWithDel " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 4: 
    default: 
    case 6: 
    case 8: 
    case 5: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.oPF == null) || (this.oPF.bGe().tNr == null));
          s.a(this.oPE, this.oPF, this.opu);
          return;
          s.a(this.oPE, this.oPF, this.opu, this.kX);
          return;
          paramMenuItem = this.oPE;
          Object localObject = new r(this.oPF.field_snsId, 3);
          g.DQ();
          g.DO().dJT.a((m)localObject, 0);
          Context localContext = paramMenuItem.context;
          paramMenuItem.context.getString(i.j.app_tip);
          paramMenuItem.tipDialog = h.b(localContext, paramMenuItem.context.getString(i.j.sns_setPrivateing_sns), true, new s.9(paramMenuItem, (r)localObject));
          return;
          paramMenuItem = this.oPE;
          localObject = this.oPF;
          if ((((n)localObject).bGF()) || (((n)localObject).bGG()))
          {
            af.bDF().yu(((n)localObject).oLk);
            return;
          }
          localObject = new r(((n)localObject).field_snsId, 2);
          g.DQ();
          g.DO().dJT.a((m)localObject, 0);
          localContext = paramMenuItem.context;
          paramMenuItem.context.getString(i.j.app_tip);
          paramMenuItem.tipDialog = h.b(localContext, paramMenuItem.context.getString(i.j.sns_setPrivateing_sns), true, new s.8(paramMenuItem, (r)localObject));
          return;
        } while ((this.oPF == null) || (this.oPF.bGe().tNr == null));
        if (this.oPF.field_type != 15)
        {
          l.i(an.eJ(af.getAccSnsPath(), this.opu.lsK) + i.l(this.opu), this.oPE.context);
          return;
        }
        s.Pf(this.oPF.bGE());
        return;
      } while ((this.oPF == null) || (this.oPF.bGe().tNr == null));
      if (this.oPF.bGe().tNr.sPI == 1)
      {
        paramMenuItem = an.eJ(af.getAccSnsPath(), this.opu.lsK) + i.l(this.opu);
        this.oPE.Pe(paramMenuItem);
        return;
      }
      s.Pg(this.oPF.bGE());
      return;
    case 7: 
      paramMenuItem = new Bundle();
      paramMenuItem.putString("stat_msg_id", "sns_" + i.fN(this.oPF.field_snsId));
      paramMenuItem.putString("stat_send_msg_user", this.oPF.field_userName);
      paramMenuItem.putInt("stat_scene", 3);
      s.a(this.oPE, paramMenuItem);
      return;
    }
    if (this.oPF.bGe().tNr.sPJ.size() > 1)
    {
      h.a(this.oPE.context, this.oPE.context.getString(i.j.sns_photos_del), "", new s.3.1(this), null);
      return;
    }
    h.a(this.oPE.context, this.oPE.context.getString(i.j.sns_photo_del), "", new s.3.2(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.3
 * JD-Core Version:    0.7.0.1
 */