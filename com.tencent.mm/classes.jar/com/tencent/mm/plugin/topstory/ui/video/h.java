package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.w;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class h
  extends RecyclerView.w
  implements a
{
  public b AcC;
  private boolean AcD;
  protected View.OnClickListener iu = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(126072);
      h.this.fr(paramAnonymousView);
      AppMethodBeat.o(126072);
    }
  };
  public dio zZN;
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.AcC = paramb;
    fq(paramView);
  }
  
  protected final void a(final b paramb, final Context paramContext, final f paramf, final int paramInt)
  {
    final dio localdio = paramb.edt().Rw(paramInt);
    ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.edh(), localdio, paramInt, 5, "");
    if (localdio != null)
    {
      if (this.AcC.edj().een())
      {
        this.AcC.edj().crK();
        this.AcD = true;
      }
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      locale.ISu = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(126073);
          paramAnonymousl.aJ(0, 2131764701, 2131689831);
          paramAnonymousl.aJ(1, 2131764702, 2131689817);
          AppMethodBeat.o(126073);
        }
      };
      locale.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(126074);
          if (h.a(h.this))
          {
            h.this.AcC.edj().dOc();
            h.b(h.this);
          }
          h.this.AcC.edr();
          Context localContext;
          Object localObject2;
          Object localObject3;
          Object localObject1;
          LinkedList localLinkedList;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            paramf.bOb();
            paramAnonymousMenuItem = p.Aee;
            localContext = paramContext;
            localObject2 = localdio;
            localObject3 = paramb.edh();
            if ((localObject2 != null) && (localObject3 != null))
            {
              paramAnonymousMenuItem.Aef = ((dio)localObject2);
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((dio)localObject2).pBm);
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ((dio)localObject2).BYP);
              ((Intent)localObject1).putExtra("Ksnsupload_link", ((dio)localObject2).pBl);
              if (!bs.isNullOrNil(((dio)localObject2).tcG)) {
                break label555;
              }
              paramAnonymousMenuItem = localContext.getString(2131762231);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("KContentObjDesc", paramAnonymousMenuItem);
              ((Intent)localObject1).putExtra("KlinkThumb_url", ((dio)localObject2).BYP);
              ((Intent)localObject1).putExtra("Ksnsupload_source", 1);
              ((Intent)localObject1).putExtra("Ksnsupload_type", 16);
              ((Intent)localObject1).putExtra("need_result", true);
              paramAnonymousMenuItem = new dyo();
              paramAnonymousMenuItem.BYK = ((dio)localObject2).sVF;
              paramAnonymousMenuItem.BYL = ((dio)localObject2).FRQ;
              paramAnonymousMenuItem.BYM = ((dil)localObject3).jKB;
              paramAnonymousMenuItem.BYN = ((dio)localObject2).FRP;
              paramAnonymousMenuItem.BYO = 100201L;
              paramAnonymousMenuItem.pBl = ((dio)localObject2).pBl;
              paramAnonymousMenuItem.pBm = ((dio)localObject2).pBm;
              paramAnonymousMenuItem.tcG = ((dio)localObject2).tcG;
              paramAnonymousMenuItem.BYP = ((dio)localObject2).BYP;
              paramAnonymousMenuItem.BYQ = ((dio)localObject2).BYQ;
              paramAnonymousMenuItem.BYR = ((dio)localObject2).BYR;
              paramAnonymousMenuItem.source = ((dio)localObject2).source;
              paramAnonymousMenuItem.kRU = ((dio)localObject2).kRU;
              paramAnonymousMenuItem.BYS = ((dio)localObject2).BYS;
              paramAnonymousMenuItem.BYT = ((dio)localObject2).BYT;
              localLinkedList = new LinkedList();
              localLinkedList.addAll(((dil)localObject3).BYq);
              localLinkedList.addAll(((dio)localObject2).BYq);
              paramAnonymousMenuItem.BYU = p.gp(localLinkedList).toString();
              paramAnonymousMenuItem.BYV = com.tencent.mm.plugin.topstory.a.h.go(((dio)localObject2).sVE).toString();
              paramAnonymousMenuItem.BYW = ((dio)localObject2).FRY;
              paramAnonymousMenuItem.thumbUrl = ((dio)localObject2).FRN;
              if ((p.k((dio)localObject2)) && (((dil)localObject3).FRB != null)) {
                paramAnonymousMenuItem.BYX = ((dil)localObject3).FRB.title;
              }
              try
              {
                paramAnonymousMenuItem = paramAnonymousMenuItem.toByteArray();
                if (paramAnonymousMenuItem != null) {
                  ((Intent)localObject1).putExtra("KWebSearchInfo", paramAnonymousMenuItem);
                }
                d.b(localContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1, 1024);
                ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.edh(), localdio, paramInt, 7, "");
                AppMethodBeat.o(126074);
                return;
                label555:
                paramAnonymousMenuItem = ((dio)localObject2).tcG;
              }
              catch (IOException paramAnonymousMenuItem)
              {
                for (;;)
                {
                  ac.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", paramAnonymousMenuItem, "", new Object[0]);
                  paramAnonymousMenuItem = null;
                }
              }
            }
          }
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            paramf.bOb();
            paramAnonymousMenuItem = p.Aee;
            localContext = paramContext;
            localObject1 = localdio;
            localObject2 = paramb.edh();
            paramAnonymousMenuItem.Aef = ((dio)localObject1);
            localObject3 = new k.b();
            ((k.b)localObject3).type = 5;
            ((k.b)localObject3).title = ((dio)localObject1).pBm;
            if (!bs.isNullOrNil(((dio)localObject1).tcG)) {
              break label1082;
            }
          }
          label1082:
          for (paramAnonymousMenuItem = localContext.getString(2131762231);; paramAnonymousMenuItem = ((dio)localObject1).tcG)
          {
            ((k.b)localObject3).description = paramAnonymousMenuItem;
            ((k.b)localObject3).url = ((dio)localObject1).pBl;
            ((k.b)localObject3).thumburl = ((dio)localObject1).BYP;
            paramAnonymousMenuItem = new aa();
            paramAnonymousMenuItem.BYK = ((dio)localObject1).sVF;
            paramAnonymousMenuItem.BYL = ((dio)localObject1).FRQ;
            paramAnonymousMenuItem.BYM = ((dil)localObject2).jKB;
            paramAnonymousMenuItem.BYN = ((dio)localObject1).FRP;
            paramAnonymousMenuItem.BYO = 100201L;
            paramAnonymousMenuItem.pBl = ((dio)localObject1).pBl;
            paramAnonymousMenuItem.pBm = ((dio)localObject1).pBm;
            paramAnonymousMenuItem.tcG = ((dio)localObject1).tcG;
            paramAnonymousMenuItem.BYP = ((dio)localObject1).BYP;
            paramAnonymousMenuItem.BYQ = ((dio)localObject1).BYQ;
            paramAnonymousMenuItem.BYR = ((dio)localObject1).BYR;
            paramAnonymousMenuItem.source = ((dio)localObject1).source;
            paramAnonymousMenuItem.kRU = ((dio)localObject1).kRU;
            paramAnonymousMenuItem.BYS = ((dio)localObject1).BYS;
            paramAnonymousMenuItem.BYT = ((dio)localObject1).BYT;
            localLinkedList = new LinkedList();
            localLinkedList.addAll(((dil)localObject2).BYq);
            localLinkedList.addAll(((dio)localObject1).BYq);
            paramAnonymousMenuItem.BYU = p.gp(localLinkedList).toString();
            paramAnonymousMenuItem.BYV = com.tencent.mm.plugin.topstory.a.h.go(((dio)localObject1).sVE).toString();
            paramAnonymousMenuItem.BYW = ((dio)localObject1).FRY;
            paramAnonymousMenuItem.thumbUrl = ((dio)localObject1).FRN;
            if ((p.k((dio)localObject1)) && (((dil)localObject2).FRB != null)) {
              paramAnonymousMenuItem.BYX = ((dil)localObject2).FRB.title;
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
            ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.edh(), localdio, paramInt, 6, "");
            AppMethodBeat.o(126074);
            return;
          }
        }
      };
      locale.Ihj = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(126075);
          if (h.a(h.this))
          {
            h.this.AcC.edj().dOc();
            h.b(h.this);
          }
          h.this.AcC.edr();
          AppMethodBeat.o(126075);
        }
      };
      locale.cED();
    }
  }
  
  public final void d(dio paramdio)
  {
    this.zZN = paramdio;
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { paramdio.title });
    edO();
  }
  
  public boolean edN()
  {
    return false;
  }
  
  public abstract void edO();
  
  public abstract f edP();
  
  public void edb()
  {
    this.AcC.edb();
  }
  
  public void edc()
  {
    this.AcC.edc();
  }
  
  public int edd()
  {
    return lv() - this.AcC.edp().getHeadersCount();
  }
  
  public void fq(View paramView) {}
  
  protected void fr(View paramView)
  {
    if (this.AcC.edm() != edd())
    {
      this.AcC.edf().Aeb = 2;
      this.AcC.Rn(edd());
      com.tencent.mm.plugin.websearch.api.a.a.lA(4);
      this.AcC.edf().j(this.zZN);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.AcC.edh(), this.zZN, edd(), 2, "");
    }
    do
    {
      return;
      fs(paramView);
    } while (!edN());
    edc();
    this.AcC.edc();
    edb();
    this.AcC.edb();
  }
  
  public void fs(View paramView) {}
  
  public abstract View getWowView();
  
  public void sd(boolean paramBoolean)
  {
    this.AcC.a(this.zZN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */