package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.at.e;
import com.tencent.mm.at.g;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.b.d;
import java.util.Iterator;
import java.util.List;

final class m$4
  implements n.d
{
  m$4(List paramList, Context paramContext, a parama, ad paramad, com.tencent.mm.ui.chatting.c.j paramj) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(30603);
    if (paramMenuItem.getItemId() == 1193046)
    {
      if (j.fa(this.zym))
      {
        h.a(this.val$context, this.val$context.getString(2131298859), "", this.val$context.getString(2131296332), new m.4.1(this));
        AppMethodBeat.o(30603);
        return;
      }
      if (j.fb(this.zym))
      {
        h.a(this.val$context, this.val$context.getString(2131298860), "", this.val$context.getString(2131296332), new m.4.2(this));
        AppMethodBeat.o(30603);
        return;
      }
      if (j.eZ(this.zym))
      {
        h.a(this.val$context, this.val$context.getString(2131298861), "", new m.4.3(this), null);
        AppMethodBeat.o(30603);
        return;
      }
      if ((n.a(this.zyx, this.zym, this.zyy)) && (this.zyz != null)) {
        this.zyz.dHU();
      }
      AppMethodBeat.o(30603);
      return;
    }
    if (j.fa(this.zym))
    {
      h.a(this.val$context, this.val$context.getString(2131298859), "", this.val$context.getString(2131296332), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(30603);
      return;
    }
    if (j.fb(this.zym))
    {
      h.a(this.val$context, this.val$context.getString(2131298860), "", this.val$context.getString(2131296332), new m.4.5(this));
      AppMethodBeat.o(30603);
      return;
    }
    Object localObject = this.zym;
    if (localObject == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
      break label388;
      break label388;
    }
    label331:
    bi localbi;
    label388:
    do
    {
      Iterator localIterator;
      do
      {
        paramInt = 0;
        if ((paramInt == 0) && (!j.eZ(this.zym))) {
          break;
        }
        h.a(this.val$context, this.val$context.getString(2131298861), "", new m.4.6(this), null);
        AppMethodBeat.o(30603);
        return;
        localIterator = ((List)localObject).iterator();
      } while (!localIterator.hasNext());
      localbi = (bi)localIterator.next();
    } while (localbi.field_isSend == 1);
    if (localbi.dvX()) {
      if (localbi.field_msgId <= 0L) {
        break label894;
      }
    }
    label892:
    label894:
    for (localObject = com.tencent.mm.at.o.ahC().gT(localbi.field_msgId);; localObject = null)
    {
      if (((localObject == null) || (((e)localObject).fDL <= 0L)) && (localbi.field_msgSvrId > 0L)) {
        localObject = com.tencent.mm.at.o.ahC().gS(localbi.field_msgSvrId);
      }
      for (;;)
      {
        if ((localObject == null) || ((((e)localObject).offset >= ((e)localObject).fsd) && (((e)localObject).fsd != 0))) {
          break label892;
        }
        paramInt = 1;
        break label331;
        if (localbi.byj())
        {
          localObject = com.tencent.mm.modelvideo.o.alE().vd(localbi.field_imgPath);
          if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
            break;
          }
          paramInt = 1;
          break label331;
        }
        if (localbi.byk())
        {
          localObject = u.vr(localbi.field_imgPath);
          if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
            break;
          }
          paramInt = 1;
          break label331;
        }
        if (!localbi.dxT()) {
          break;
        }
        if (!j.ax(localbi))
        {
          paramInt = 1;
          break label331;
        }
        paramInt = 0;
        break label331;
        localObject = (String)paramMenuItem.getTitle();
        if (f.rV((String)localObject))
        {
          if (this.zym.size() <= 1)
          {
            m.dGo().zyC = true;
            m.a((String)localObject, this.zyx, this.zym);
            AppMethodBeat.o(30603);
            return;
          }
          paramMenuItem = new d(this.val$context, 1, false);
          paramMenuItem.sao = new m.4.7(this);
          paramMenuItem.sap = new m.4.8(this, (String)localObject);
          paramMenuItem.crd();
          AppMethodBeat.o(30603);
          return;
        }
        if (j.eX(this.zym))
        {
          localObject = this.val$context.getString(2131300747);
          h.a(this.val$context, (String)localObject, "", new m.4.9(this, paramMenuItem), null);
          AppMethodBeat.o(30603);
          return;
        }
        localObject = this.val$context;
        this.val$context.getString(2131297087);
        m.a(h.b((Context)localObject, this.val$context.getString(2131303124), false, null));
        com.tencent.mm.ui.chatting.c.j.zEQ.e(new m.b(this.zyx, this.val$context, paramMenuItem.getTitle(), -1L, m.dGo()));
        if (this.zyz != null) {
          this.zyz.dHU();
        }
        AppMethodBeat.o(30603);
        return;
      }
      break label388;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.4
 * JD-Core Version:    0.7.0.1
 */