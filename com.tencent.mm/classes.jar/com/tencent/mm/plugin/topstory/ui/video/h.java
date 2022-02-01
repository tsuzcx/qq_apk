package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.w;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class h
  extends RecyclerView.w
  implements a
{
  public dod Brz;
  public b Bun;
  private boolean Buo;
  protected View.OnClickListener km = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(126072);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      h.this.fE(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(126072);
    }
  };
  
  public h(View paramView, b paramb)
  {
    super(paramView);
    this.Bun = paramb;
    fD(paramView);
  }
  
  protected final void a(final b paramb, final Context paramContext, final f paramf, final int paramInt)
  {
    final dod localdod = paramb.epL().Tg(paramInt);
    ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.epz(), localdod, paramInt, 5, "");
    if (localdod != null)
    {
      if (this.Bun.epB().eqE())
      {
        this.Bun.epB().cxw();
        this.Buo = true;
      }
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      locale.KJy = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(126073);
          paramAnonymousl.aL(0, 2131764701, 2131689831);
          paramAnonymousl.aL(1, 2131764702, 2131689817);
          AppMethodBeat.o(126073);
        }
      };
      locale.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(126074);
          if (h.a(h.this))
          {
            h.this.Bun.epB().eaq();
            h.b(h.this);
          }
          h.this.Bun.epJ();
          Context localContext;
          Object localObject2;
          Object localObject3;
          Object localObject1;
          LinkedList localLinkedList;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            paramf.bSC();
            paramAnonymousMenuItem = p.BvQ;
            localContext = paramContext;
            localObject2 = localdod;
            localObject3 = paramb.epz();
            if ((localObject2 != null) && (localObject3 != null))
            {
              paramAnonymousMenuItem.BvR = ((dod)localObject2);
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((dod)localObject2).qeR);
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ((dod)localObject2).DBL);
              ((Intent)localObject1).putExtra("Ksnsupload_link", ((dod)localObject2).qeQ);
              if (!bt.isNullOrNil(((dod)localObject2).uaw)) {
                break label555;
              }
              paramAnonymousMenuItem = localContext.getString(2131762231);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("KContentObjDesc", paramAnonymousMenuItem);
              ((Intent)localObject1).putExtra("KlinkThumb_url", ((dod)localObject2).DBL);
              ((Intent)localObject1).putExtra("Ksnsupload_source", 1);
              ((Intent)localObject1).putExtra("Ksnsupload_type", 16);
              ((Intent)localObject1).putExtra("need_result", true);
              paramAnonymousMenuItem = new eeq();
              paramAnonymousMenuItem.DBG = ((dod)localObject2).tSk;
              paramAnonymousMenuItem.DBH = ((dod)localObject2).HCw;
              paramAnonymousMenuItem.DBI = ((doa)localObject3).keN;
              paramAnonymousMenuItem.DBJ = ((dod)localObject2).HCv;
              paramAnonymousMenuItem.DBK = 100201L;
              paramAnonymousMenuItem.qeQ = ((dod)localObject2).qeQ;
              paramAnonymousMenuItem.qeR = ((dod)localObject2).qeR;
              paramAnonymousMenuItem.uaw = ((dod)localObject2).uaw;
              paramAnonymousMenuItem.DBL = ((dod)localObject2).DBL;
              paramAnonymousMenuItem.DBM = ((dod)localObject2).DBM;
              paramAnonymousMenuItem.DBN = ((dod)localObject2).DBN;
              paramAnonymousMenuItem.source = ((dod)localObject2).source;
              paramAnonymousMenuItem.lox = ((dod)localObject2).lox;
              paramAnonymousMenuItem.DBO = ((dod)localObject2).DBO;
              paramAnonymousMenuItem.DBP = ((dod)localObject2).DBP;
              localLinkedList = new LinkedList();
              localLinkedList.addAll(((doa)localObject3).DBj);
              localLinkedList.addAll(((dod)localObject2).DBj);
              paramAnonymousMenuItem.DBQ = p.gA(localLinkedList).toString();
              paramAnonymousMenuItem.DBR = com.tencent.mm.plugin.topstory.a.h.gz(((dod)localObject2).tSj).toString();
              paramAnonymousMenuItem.DBS = ((dod)localObject2).HCE;
              paramAnonymousMenuItem.thumbUrl = ((dod)localObject2).HCt;
              if ((p.k((dod)localObject2)) && (((doa)localObject3).HCh != null)) {
                paramAnonymousMenuItem.DBT = ((doa)localObject3).HCh.title;
              }
              try
              {
                paramAnonymousMenuItem = paramAnonymousMenuItem.toByteArray();
                if (paramAnonymousMenuItem != null) {
                  ((Intent)localObject1).putExtra("KWebSearchInfo", paramAnonymousMenuItem);
                }
                d.b(localContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1, 1024);
                ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.epz(), localdod, paramInt, 7, "");
                AppMethodBeat.o(126074);
                return;
                label555:
                paramAnonymousMenuItem = ((dod)localObject2).uaw;
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
            paramf.bSC();
            paramAnonymousMenuItem = p.BvQ;
            localContext = paramContext;
            localObject1 = localdod;
            localObject2 = paramb.epz();
            paramAnonymousMenuItem.BvR = ((dod)localObject1);
            localObject3 = new k.b();
            ((k.b)localObject3).type = 5;
            ((k.b)localObject3).title = ((dod)localObject1).qeR;
            if (!bt.isNullOrNil(((dod)localObject1).uaw)) {
              break label1082;
            }
          }
          label1082:
          for (paramAnonymousMenuItem = localContext.getString(2131762231);; paramAnonymousMenuItem = ((dod)localObject1).uaw)
          {
            ((k.b)localObject3).description = paramAnonymousMenuItem;
            ((k.b)localObject3).url = ((dod)localObject1).qeQ;
            ((k.b)localObject3).thumburl = ((dod)localObject1).DBL;
            paramAnonymousMenuItem = new ae();
            paramAnonymousMenuItem.DBG = ((dod)localObject1).tSk;
            paramAnonymousMenuItem.DBH = ((dod)localObject1).HCw;
            paramAnonymousMenuItem.DBI = ((doa)localObject2).keN;
            paramAnonymousMenuItem.DBJ = ((dod)localObject1).HCv;
            paramAnonymousMenuItem.DBK = 100201L;
            paramAnonymousMenuItem.qeQ = ((dod)localObject1).qeQ;
            paramAnonymousMenuItem.qeR = ((dod)localObject1).qeR;
            paramAnonymousMenuItem.uaw = ((dod)localObject1).uaw;
            paramAnonymousMenuItem.DBL = ((dod)localObject1).DBL;
            paramAnonymousMenuItem.DBM = ((dod)localObject1).DBM;
            paramAnonymousMenuItem.DBN = ((dod)localObject1).DBN;
            paramAnonymousMenuItem.source = ((dod)localObject1).source;
            paramAnonymousMenuItem.lox = ((dod)localObject1).lox;
            paramAnonymousMenuItem.DBO = ((dod)localObject1).DBO;
            paramAnonymousMenuItem.DBP = ((dod)localObject1).DBP;
            localLinkedList = new LinkedList();
            localLinkedList.addAll(((doa)localObject2).DBj);
            localLinkedList.addAll(((dod)localObject1).DBj);
            paramAnonymousMenuItem.DBQ = p.gA(localLinkedList).toString();
            paramAnonymousMenuItem.DBR = com.tencent.mm.plugin.topstory.a.h.gz(((dod)localObject1).tSj).toString();
            paramAnonymousMenuItem.DBS = ((dod)localObject1).HCE;
            paramAnonymousMenuItem.thumbUrl = ((dod)localObject1).HCt;
            if ((p.k((dod)localObject1)) && (((doa)localObject2).HCh != null)) {
              paramAnonymousMenuItem.DBT = ((doa)localObject2).HCh.title;
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
            ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(paramb.epz(), localdod, paramInt, 6, "");
            AppMethodBeat.o(126074);
            return;
          }
        }
      };
      locale.JXC = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(126075);
          if (h.a(h.this))
          {
            h.this.Bun.epB().eaq();
            h.b(h.this);
          }
          h.this.Bun.epJ();
          AppMethodBeat.o(126075);
        }
      };
      locale.cMW();
    }
  }
  
  public final void d(dod paramdod)
  {
    this.Brz = paramdod;
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", new Object[] { paramdod.title });
    eqg();
  }
  
  public void ept()
  {
    this.Bun.ept();
  }
  
  public void epu()
  {
    this.Bun.epu();
  }
  
  public int epv()
  {
    return lN() - this.Bun.epH().getHeadersCount();
  }
  
  public boolean eqf()
  {
    return false;
  }
  
  public abstract void eqg();
  
  public abstract f eqh();
  
  public void fD(View paramView) {}
  
  protected void fE(View paramView)
  {
    if (this.Bun.epE() != epv())
    {
      this.Bun.epx().BvN = 2;
      this.Bun.SX(epv());
      com.tencent.mm.plugin.websearch.api.a.a.ma(4);
      this.Bun.epx().j(this.Brz);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Bun.epz(), this.Brz, epv(), 2, "");
    }
    do
    {
      return;
      fF(paramView);
    } while (!eqf());
    epu();
    this.Bun.epu();
    ept();
    this.Bun.ept();
  }
  
  public void fF(View paramView) {}
  
  public abstract View getWowView();
  
  public void sJ(boolean paramBoolean)
  {
    this.Bun.a(this.Brz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h
 * JD-Core Version:    0.7.0.1
 */