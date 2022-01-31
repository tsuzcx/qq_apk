package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.b;
import com.tencent.mm.ui.widget.b.d;
import java.util.Map;

final class a$2$1
  implements n.c
{
  a$2$1(a.2 param2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(24337);
    paraml.clear();
    this.qaj.qag.mAF.setFooterView(null);
    if (a.2.a(this.qaj).wTK == 0)
    {
      if (a.2.b(this.qaj).bwl()) {
        paraml.e(2, a.2.c(this.qaj).getString(2131299826));
      }
      if (a.2.b(this.qaj).bwm()) {
        paraml.e(1, a.2.c(this.qaj).getString(2131299779));
      }
      paraml.e(3, a.2.c(this.qaj).getString(2131299819));
      a.a locala = (a.a)this.qaj.qag.mwr.get(a.2.d(this.qaj));
      if ((locala != null) && (locala.mwA != null))
      {
        if (!bo.isNullOrNil(locala.mwA.cEy.result))
        {
          d locald = this.qaj.qag.mAF;
          Object localObject2 = this.qaj.qag;
          Context localContext = a.2.c(this.qaj);
          Object localObject1 = locala.mwA;
          if (!com.tencent.mm.plugin.scanner.a.CB(((ny)localObject1).cEy.cpE)) {
            if (com.tencent.mm.plugin.scanner.a.ba(((ny)localObject1).cEy.cpE, ((ny)localObject1).cEy.result))
            {
              paraml = localContext.getString(2131302341);
              localObject2 = new a.3((a)localObject2, (ny)localObject1, localContext);
              if (!com.tencent.mm.plugin.scanner.a.ba(((ny)localObject1).cEy.cpE, ((ny)localObject1).cEy.result)) {
                break label411;
              }
              localObject1 = new b(localContext);
              if (!bo.isNullOrNil(locala.mwB)) {
                break label402;
              }
              label305:
              ((b)localObject1).setTitle(paraml);
              ((b)localObject1).setSubtitle(localContext.getString(2131302340));
              if (!bo.isNullOrNil(locala.mwC)) {
                com.tencent.mm.at.a.a.ahM().a(locala.mwC, ((b)localObject1).getIcon());
              }
              ((b)localObject1).setOnClickListener((View.OnClickListener)localObject2);
            }
          }
          for (paraml = (l)localObject1;; paraml = (l)localObject1)
          {
            locald.setFooterView(paraml);
            AppMethodBeat.o(24337);
            return;
            if (com.tencent.mm.plugin.scanner.a.CA(((ny)localObject1).cEy.cpE))
            {
              paraml = localContext.getString(2131302335);
              break;
            }
            paraml = localContext.getString(2131302336);
            break;
            label402:
            paraml = locala.mwB;
            break label305;
            label411:
            localObject1 = new com.tencent.mm.ui.widget.a.a(localContext);
            ((com.tencent.mm.ui.widget.a.a)localObject1).setTitle(paraml);
            ((com.tencent.mm.ui.widget.a.a)localObject1).setOnClickListener((View.OnClickListener)localObject2);
          }
        }
      }
      else
      {
        paraml = new nw();
        paraml.cEv.filePath = a.2.d(this.qaj);
        com.tencent.mm.sdk.b.a.ymk.l(paraml);
      }
    }
    AppMethodBeat.o(24337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.2.1
 * JD-Core Version:    0.7.0.1
 */