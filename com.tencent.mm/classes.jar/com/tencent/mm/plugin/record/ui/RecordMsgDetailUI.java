package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.v;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;

public class RecordMsgDetailUI
  extends RecordMsgBaseUI
{
  private boolean cBz = true;
  private String cEB = null;
  private bi cmQ;
  private long cpO = -1L;
  private com.tencent.mm.ui.base.p ehb = null;
  private com.tencent.mm.protocal.b.a.c pZC = null;
  private boolean pZD = false;
  private String pZE = "";
  private String pZF = "";
  private boolean pZG;
  private i pZk;
  private String title = "";
  
  private String a(com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(24244);
    int i;
    com.tencent.mm.protocal.b.a.c localc;
    String str2;
    String str1;
    if (paramc != null)
    {
      Iterator localIterator = paramc.fjy.iterator();
      i = 0;
      localc = null;
      str2 = null;
      str1 = null;
      while (localIterator.hasNext())
      {
        paramc = (aca)localIterator.next();
        if (paramc.wTw.wUb.wUA != null)
        {
          str1 = getContext().getString(2131302353);
          i = 1;
        }
        else
        {
          if (paramc.wTw.wUb.czp == null) {
            break label225;
          }
          if (str2 == null)
          {
            str2 = paramc.wTy;
          }
          else
          {
            if (str2 == paramc.wTy) {
              break label225;
            }
            paramc = paramc.wTy;
            localc = paramc;
          }
        }
      }
      if ((str2 != null) && (localc == null) && (i == 0)) {
        paramc = getContext().getString(2131299790, new Object[] { str2 });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24244);
      return paramc;
      paramc = str1;
      if (str2 != null)
      {
        paramc = str1;
        if (localc != null)
        {
          paramc = str1;
          if (!str2.equals(localc))
          {
            paramc = str1;
            if (i == 0)
            {
              paramc = getContext().getString(2131299789, new Object[] { str2, localc });
              continue;
              label225:
              paramc = localc;
              break;
              paramc = null;
            }
          }
        }
      }
    }
  }
  
  private void bJ()
  {
    AppMethodBeat.i(24245);
    f localf = new f();
    localf.pZa = this.pZC.fjy;
    localf.cpO = this.cpO;
    localf.cEB = this.cEB;
    localf.pZb = new v();
    if ((this.cmQ != null) && (!this.pZG) && (this.cmQ.field_transContent != null)) {}
    try
    {
      localf.pZb.parseFrom(this.cmQ.field_transContent.getBytes(Charset.forName("UTF-8")));
      super.cfU();
      this.pZz.a(localf);
      this.pZk = new i(this, this.pZz, localf);
      this.pZz.pZk = this.pZk;
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((e)this.pZz);
      AppMethodBeat.o(24245);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.RecordMsgDetailUI", localException, "", new Object[0]);
      }
    }
  }
  
  protected final void cfU()
  {
    AppMethodBeat.i(24243);
    this.cpO = getIntent().getLongExtra("message_id", -1L);
    this.cEB = getIntent().getStringExtra("record_xml");
    this.cBz = getIntent().getBooleanExtra("record_show_share", true);
    this.pZD = getIntent().getBooleanExtra("big_appmsg", false);
    this.pZG = getIntent().getBooleanExtra("record_nest", false);
    this.pZC = n.XS(this.cEB);
    aw.aaz();
    this.cmQ = com.tencent.mm.model.c.YC().kB(this.cpO);
    if (this.pZC != null) {
      if (a(this.pZC) != null)
      {
        this.title = a(this.pZC);
        if (!bo.es(this.pZC.fjy))
        {
          this.pZE = ((aca)this.pZC.fjy.getFirst()).wTA;
          this.pZF = ((aca)this.pZC.fjy.getLast()).wTA;
        }
      }
    }
    for (;;)
    {
      if ((this.cEB != null) && (this.pZC != null)) {
        break label373;
      }
      cgc();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(24234);
          RecordMsgDetailUI.this.finish();
          AppMethodBeat.o(24234);
          return true;
        }
      });
      Object localObject;
      if ((this.pZD) && (com.tencent.mm.pluginsdk.model.app.al.aUJ().nw(this.cpO) != null))
      {
        aw.aaz();
        localObject = com.tencent.mm.model.c.YC().kB(this.cpO);
        localObject = new com.tencent.mm.plugin.record.b.e(this.cpO, ((dd)localObject).field_msgSvrId, new com.tencent.mm.ai.g()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, m paramAnonymousm)
          {
            AppMethodBeat.i(24235);
            if (paramAnonymousInt1 == paramAnonymousInt2)
            {
              if (RecordMsgDetailUI.a(RecordMsgDetailUI.this) != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this).dismiss();
                RecordMsgDetailUI.b(RecordMsgDetailUI.this);
              }
              aw.aaz();
              bi localbi = com.tencent.mm.model.c.YC().kB(RecordMsgDetailUI.c(RecordMsgDetailUI.this));
              paramAnonymousm = localbi.field_content;
              if (t.lA(localbi.field_talker)) {
                paramAnonymousm = bf.pv(localbi.field_content);
              }
              paramAnonymousm = j.b.mY(paramAnonymousm);
              if (paramAnonymousm != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousm.fhc);
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, n.XS(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
                if (RecordMsgDetailUI.e(RecordMsgDetailUI.this) != null)
                {
                  if (RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)) == null) {
                    break label242;
                  }
                  RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)));
                }
              }
            }
            for (;;)
            {
              RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((aca)RecordMsgDetailUI.e(RecordMsgDetailUI.this).fjy.getFirst()).wTA);
              RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((aca)RecordMsgDetailUI.e(RecordMsgDetailUI.this).fjy.getLast()).wTA);
              RecordMsgDetailUI.f(RecordMsgDetailUI.this);
              AppMethodBeat.o(24235);
              return;
              label242:
              RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
            }
          }
        });
        aw.Rc().a((m)localObject, 0);
      }
      AppMethodBeat.o(24243);
      return;
      this.title = this.pZC.title;
      break;
      if (this.cmQ != null)
      {
        localObject = j.b.ab(this.cmQ.field_content, this.cmQ.field_reserved);
        if (localObject != null)
        {
          this.title = ((j.b)localObject).title;
          this.ehb = com.tencent.mm.ui.base.p.b(this, getString(2131301086), true, null);
        }
      }
    }
    label373:
    bJ();
    AppMethodBeat.o(24243);
  }
  
  protected final h cfV()
  {
    AppMethodBeat.i(24246);
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    AppMethodBeat.o(24246);
    return locale;
  }
  
  protected final String cfW()
  {
    return this.title;
  }
  
  protected final String cfX()
  {
    return this.pZE;
  }
  
  protected final String cfY()
  {
    return this.pZF;
  }
  
  protected final void cfZ()
  {
    AppMethodBeat.i(24248);
    if (!this.cBz)
    {
      AppMethodBeat.o(24248);
      return;
    }
    addIconOptionMenu(0, 2130839668, new RecordMsgDetailUI.3(this));
    AppMethodBeat.o(24248);
  }
  
  protected final void d(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(24249);
    if (-1 != paramInt2)
    {
      ab.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(24249);
      return;
    }
    Object localObject;
    if (1001 == paramInt1)
    {
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label92;
        }
      }
      label92:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        if (!bo.isNullOrNil((String)localObject)) {
          break label103;
        }
        ab.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(24249);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label103:
      aw.aaz();
      final bi localbi = com.tencent.mm.model.c.YC().kB(this.cpO);
      if (localbi.field_msgId != this.cpO)
      {
        ab.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
        AppMethodBeat.o(24249);
        return;
      }
      final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131299734), false, null);
      aw.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24240);
          n.a(this.bZZ, paramIntent, localbi);
          com.tencent.mm.sdk.platformtools.al.d(new RecordMsgDetailUI.4.1(this));
          AppMethodBeat.o(24240);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(24241);
          String str = super.toString() + "|onActivityResult";
          AppMethodBeat.o(24241);
          return str;
        }
      });
      AppMethodBeat.o(24249);
      return;
    }
    if ((1002 == paramInt1) && (paramIntent.getBooleanExtra("kfavorite", false)))
    {
      localObject = new cm();
      com.tencent.mm.pluginsdk.model.e.a((cm)localObject, paramIntent);
      ((cm)localObject).cpR.activity = this;
      ((cm)localObject).cpR.cpY = 8;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    }
    AppMethodBeat.o(24249);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24242);
    super.onCreate(paramBundle);
    AppMethodBeat.o(24242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24247);
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((e)this.pZz);
    if (this.pZk != null)
    {
      byte[] arrayOfByte = this.pZk.cgg();
      if ((!this.pZG) && (this.cmQ != null) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.cmQ.km(new String(arrayOfByte, Charset.forName("UTF-8")));
        aw.aaz();
        com.tencent.mm.model.c.YC().a(this.cpO, this.cmQ);
      }
    }
    AppMethodBeat.o(24247);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI
 * JD-Core Version:    0.7.0.1
 */