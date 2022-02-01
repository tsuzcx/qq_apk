package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class h
  extends RecyclerView.v
  implements a
{
  protected View.OnClickListener hs = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(126072);
      h.this.fe(paramAnonymousView);
      AppMethodBeat.o(126072);
    }
  };
  public ddb yLU;
  public b yOL;
  private boolean yOM;
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.yOL = paramb;
    fd(paramView);
  }
  
  protected final void a(final b paramb, final Context paramContext, final f paramf, final int paramInt)
  {
    final ddb localddb = paramb.dOT().Pq(paramInt);
    ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.dOH(), localddb, paramInt, 5, "");
    if (localddb != null)
    {
      if (this.yOL.dOJ().dPO())
      {
        this.yOL.dOJ().ckd();
        this.yOM = true;
      }
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      locale.HrX = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(126073);
          paramAnonymousl.aI(0, 2131764701, 2131689831);
          paramAnonymousl.aI(1, 2131764702, 2131689817);
          AppMethodBeat.o(126073);
        }
      };
      locale.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(126074);
          if (h.a(h.this))
          {
            h.this.yOL.dOJ().dzF();
            h.b(h.this);
          }
          h.this.yOL.dOR();
          Context localContext;
          Object localObject2;
          Object localObject3;
          Object localObject1;
          LinkedList localLinkedList;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            paramf.bGO();
            paramAnonymousMenuItem = p.yQo;
            localContext = paramContext;
            localObject2 = localddb;
            localObject3 = paramb.dOH();
            if ((localObject2 != null) && (localObject3 != null))
            {
              paramAnonymousMenuItem.yQp = ((ddb)localObject2);
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((ddb)localObject2).oYb);
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ((ddb)localObject2).AGx);
              ((Intent)localObject1).putExtra("Ksnsupload_link", ((ddb)localObject2).oYa);
              if (!bt.isNullOrNil(((ddb)localObject2).rUO)) {
                break label555;
              }
              paramAnonymousMenuItem = localContext.getString(2131762231);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("KContentObjDesc", paramAnonymousMenuItem);
              ((Intent)localObject1).putExtra("KlinkThumb_url", ((ddb)localObject2).AGx);
              ((Intent)localObject1).putExtra("Ksnsupload_source", 1);
              ((Intent)localObject1).putExtra("Ksnsupload_type", 16);
              ((Intent)localObject1).putExtra("need_result", true);
              paramAnonymousMenuItem = new dsx();
              paramAnonymousMenuItem.AGs = ((ddb)localObject2).rNP;
              paramAnonymousMenuItem.AGt = ((ddb)localObject2).EuP;
              paramAnonymousMenuItem.AGu = ((dcy)localObject3).jko;
              paramAnonymousMenuItem.AGv = ((ddb)localObject2).EuO;
              paramAnonymousMenuItem.AGw = 100201L;
              paramAnonymousMenuItem.oYa = ((ddb)localObject2).oYa;
              paramAnonymousMenuItem.oYb = ((ddb)localObject2).oYb;
              paramAnonymousMenuItem.rUO = ((ddb)localObject2).rUO;
              paramAnonymousMenuItem.AGx = ((ddb)localObject2).AGx;
              paramAnonymousMenuItem.AGy = ((ddb)localObject2).AGy;
              paramAnonymousMenuItem.AGz = ((ddb)localObject2).AGz;
              paramAnonymousMenuItem.source = ((ddb)localObject2).source;
              paramAnonymousMenuItem.kqB = ((ddb)localObject2).kqB;
              paramAnonymousMenuItem.AGA = ((ddb)localObject2).AGA;
              paramAnonymousMenuItem.AGB = ((ddb)localObject2).AGB;
              localLinkedList = new LinkedList();
              localLinkedList.addAll(((dcy)localObject3).AFX);
              localLinkedList.addAll(((ddb)localObject2).AFX);
              paramAnonymousMenuItem.AGC = p.gi(localLinkedList).toString();
              paramAnonymousMenuItem.AGD = com.tencent.mm.plugin.topstory.a.h.gh(((ddb)localObject2).rNO).toString();
              paramAnonymousMenuItem.AGE = ((ddb)localObject2).EuX;
              paramAnonymousMenuItem.thumbUrl = ((ddb)localObject2).EuM;
              if ((p.k((ddb)localObject2)) && (((dcy)localObject3).EuA != null)) {
                paramAnonymousMenuItem.AGF = ((dcy)localObject3).EuA.title;
              }
              try
              {
                paramAnonymousMenuItem = paramAnonymousMenuItem.toByteArray();
                if (paramAnonymousMenuItem != null) {
                  ((Intent)localObject1).putExtra("KWebSearchInfo", paramAnonymousMenuItem);
                }
                d.b(localContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1, 1024);
                ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.dOH(), localddb, paramInt, 7, "");
                AppMethodBeat.o(126074);
                return;
                label555:
                paramAnonymousMenuItem = ((ddb)localObject2).rUO;
              }
              catch (IOException paramAnonymousMenuItem)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", paramAnonymousMenuItem, "", new Object[0]);
                  paramAnonymousMenuItem = null;
                }
              }
            }
          }
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            paramf.bGO();
            paramAnonymousMenuItem = p.yQo;
            localContext = paramContext;
            localObject1 = localddb;
            localObject2 = paramb.dOH();
            paramAnonymousMenuItem.yQp = ((ddb)localObject1);
            localObject3 = new k.b();
            ((k.b)localObject3).type = 5;
            ((k.b)localObject3).title = ((ddb)localObject1).oYb;
            if (!bt.isNullOrNil(((ddb)localObject1).rUO)) {
              break label1082;
            }
          }
          label1082:
          for (paramAnonymousMenuItem = localContext.getString(2131762231);; paramAnonymousMenuItem = ((ddb)localObject1).rUO)
          {
            ((k.b)localObject3).description = paramAnonymousMenuItem;
            ((k.b)localObject3).url = ((ddb)localObject1).oYa;
            ((k.b)localObject3).thumburl = ((ddb)localObject1).AGx;
            paramAnonymousMenuItem = new ab();
            paramAnonymousMenuItem.AGs = ((ddb)localObject1).rNP;
            paramAnonymousMenuItem.AGt = ((ddb)localObject1).EuP;
            paramAnonymousMenuItem.AGu = ((dcy)localObject2).jko;
            paramAnonymousMenuItem.AGv = ((ddb)localObject1).EuO;
            paramAnonymousMenuItem.AGw = 100201L;
            paramAnonymousMenuItem.oYa = ((ddb)localObject1).oYa;
            paramAnonymousMenuItem.oYb = ((ddb)localObject1).oYb;
            paramAnonymousMenuItem.rUO = ((ddb)localObject1).rUO;
            paramAnonymousMenuItem.AGx = ((ddb)localObject1).AGx;
            paramAnonymousMenuItem.AGy = ((ddb)localObject1).AGy;
            paramAnonymousMenuItem.AGz = ((ddb)localObject1).AGz;
            paramAnonymousMenuItem.source = ((ddb)localObject1).source;
            paramAnonymousMenuItem.kqB = ((ddb)localObject1).kqB;
            paramAnonymousMenuItem.AGA = ((ddb)localObject1).AGA;
            paramAnonymousMenuItem.AGB = ((ddb)localObject1).AGB;
            localLinkedList = new LinkedList();
            localLinkedList.addAll(((dcy)localObject2).AFX);
            localLinkedList.addAll(((ddb)localObject1).AFX);
            paramAnonymousMenuItem.AGC = p.gi(localLinkedList).toString();
            paramAnonymousMenuItem.AGD = com.tencent.mm.plugin.topstory.a.h.gh(((ddb)localObject1).rNO).toString();
            paramAnonymousMenuItem.AGE = ((ddb)localObject1).EuX;
            paramAnonymousMenuItem.thumbUrl = ((ddb)localObject1).EuM;
            if ((p.k((ddb)localObject1)) && (((dcy)localObject2).EuA != null)) {
              paramAnonymousMenuItem.AGF = ((dcy)localObject2).EuA.title;
            }
            ((k.b)localObject3).a(paramAnonymousMenuItem);
            paramAnonymousMenuItem = k.b.a((k.b)localObject3, null, null);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
            ((Intent)localObject1).putExtra("Retr_Msg_content", paramAnonymousMenuItem);
            ((Intent)localObject1).putExtra("Multi_Retr", true);
            ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
            ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
            d.c(localContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1, 2048);
            ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.dOH(), localddb, paramInt, 6, "");
            AppMethodBeat.o(126074);
            return;
          }
        }
      };
      locale.GHn = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(126075);
          if (h.a(h.this))
          {
            h.this.yOL.dOJ().dzF();
            h.b(h.this);
          }
          h.this.yOL.dOR();
          AppMethodBeat.o(126075);
        }
      };
      locale.csG();
    }
  }
  
  public final void d(ddb paramddb)
  {
    this.yLU = paramddb;
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { paramddb.title });
    dPo();
  }
  
  public void dOB()
  {
    this.yOL.dOB();
  }
  
  public void dOC()
  {
    this.yOL.dOC();
  }
  
  public int dOD()
  {
    return ln() - this.yOL.dOP().getHeadersCount();
  }
  
  public boolean dPn()
  {
    return false;
  }
  
  public abstract void dPo();
  
  public abstract f dPp();
  
  public void fd(View paramView) {}
  
  protected void fe(View paramView)
  {
    if (this.yOL.dOM() != dOD())
    {
      this.yOL.dOF().yQl = 2;
      this.yOL.Ph(dOD());
      com.tencent.mm.plugin.websearch.api.a.a.lI(4);
      this.yOL.dOF().j(this.yLU);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.yOL.dOH(), this.yLU, dOD(), 2, "");
    }
    do
    {
      return;
      ff(paramView);
    } while (!dPn());
    dOC();
    this.yOL.dOC();
    dOB();
    this.yOL.dOB();
  }
  
  public void ff(View paramView) {}
  
  public abstract View getWowView();
  
  public void rf(boolean paramBoolean)
  {
    this.yOL.a(this.yLU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */