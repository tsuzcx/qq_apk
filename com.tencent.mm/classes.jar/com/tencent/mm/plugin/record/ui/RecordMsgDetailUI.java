package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public class RecordMsgDetailUI
  extends RecordMsgBaseUI
{
  private long bIt = -1L;
  private boolean bTT = true;
  private String bWL = null;
  private com.tencent.mm.ui.base.p dpF = null;
  private com.tencent.mm.protocal.b.a.c ntV = null;
  private boolean ntW = false;
  private String ntX = "";
  private String ntY = "";
  private String title = "";
  
  private String a(com.tencent.mm.protocal.b.a.c paramc)
  {
    if (paramc != null)
    {
      Object localObject = paramc.dTx.iterator();
      int i = 0;
      String str1 = null;
      String str2 = null;
      paramc = null;
      while (((Iterator)localObject).hasNext())
      {
        xv localxv = (xv)((Iterator)localObject).next();
        if (localxv.sVA.sWd.sWB != null)
        {
          paramc = this.mController.uMN.getString(R.l.record_chatroom_title);
          i = 1;
        }
        else
        {
          if (localxv.sVA.sWd.bRO == null) {
            break label226;
          }
          if (str2 == null)
          {
            str2 = localxv.sVC;
          }
          else
          {
            if (str2 == localxv.sVC) {
              break label226;
            }
            str1 = localxv.sVC;
          }
        }
      }
      label226:
      for (;;)
      {
        break;
        if ((str2 != null) && (str1 == null) && (i == 0)) {
          localObject = this.mController.uMN.getString(R.l.favorite_record_chatroom_title, new Object[] { str2 });
        }
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject;
                localObject = paramc;
              } while (str2 == null);
              localObject = paramc;
            } while (str1 == null);
            localObject = paramc;
          } while (str2.equals(str1));
          localObject = paramc;
        } while (i != 0);
        return this.mController.uMN.getString(R.l.favorite_record_chat_title, new Object[] { str2, str1 });
      }
    }
    return null;
  }
  
  private void aZ()
  {
    f localf = new f();
    localf.ntu = this.ntV.dTx;
    localf.bIt = this.bIt;
    localf.bWL = this.bWL;
    super.bvD();
    this.ntS.a(localf);
    n.getRecordMsgCDNStorage().a((e)this.ntS);
  }
  
  protected final void bvD()
  {
    this.bIt = getIntent().getLongExtra("message_id", -1L);
    this.bWL = getIntent().getStringExtra("record_xml");
    this.bTT = getIntent().getBooleanExtra("record_show_share", true);
    this.ntW = getIntent().getBooleanExtra("big_appmsg", false);
    this.ntV = com.tencent.mm.plugin.record.b.h.LH(this.bWL);
    if (this.ntV != null) {
      if (a(this.ntV) != null)
      {
        this.title = a(this.ntV);
        if (!bk.dk(this.ntV.dTx))
        {
          this.ntX = ((xv)this.ntV.dTx.getFirst()).sVE;
          this.ntY = ((xv)this.ntV.dTx.getLast()).sVE;
        }
      }
    }
    for (;;)
    {
      if ((this.bWL != null) && (this.ntV != null)) {
        break label328;
      }
      bvL();
      setBackBtn(new RecordMsgDetailUI.1(this));
      if ((this.ntW) && (ap.avh().gY(this.bIt) != null))
      {
        au.Hx();
        localObject = com.tencent.mm.model.c.Fy().fd(this.bIt);
        localObject = new ac(this.bIt, ((cs)localObject).field_msgSvrId, new com.tencent.mm.ah.g()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, m paramAnonymousm)
          {
            if (paramAnonymousInt1 == paramAnonymousInt2)
            {
              if (RecordMsgDetailUI.a(RecordMsgDetailUI.this) != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this).dismiss();
                RecordMsgDetailUI.b(RecordMsgDetailUI.this);
              }
              au.Hx();
              bi localbi = com.tencent.mm.model.c.Fy().fd(RecordMsgDetailUI.c(RecordMsgDetailUI.this));
              paramAnonymousm = localbi.field_content;
              if (com.tencent.mm.model.s.fn(localbi.field_talker)) {
                paramAnonymousm = bd.iJ(localbi.field_content);
              }
              paramAnonymousm = g.a.gp(paramAnonymousm);
              if (paramAnonymousm != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousm.dRd);
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, com.tencent.mm.plugin.record.b.h.LH(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
                if (RecordMsgDetailUI.e(RecordMsgDetailUI.this) != null)
                {
                  if (RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)) == null) {
                    break label230;
                  }
                  RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)));
                }
              }
            }
            for (;;)
            {
              RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((xv)RecordMsgDetailUI.e(RecordMsgDetailUI.this).dTx.getFirst()).sVE);
              RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((xv)RecordMsgDetailUI.e(RecordMsgDetailUI.this).dTx.getLast()).sVE);
              RecordMsgDetailUI.f(RecordMsgDetailUI.this);
              return;
              label230:
              RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
            }
          }
        });
        au.Dk().a((m)localObject, 0);
      }
      return;
      this.title = this.ntV.title;
      break;
      au.Hx();
      Object localObject = com.tencent.mm.model.c.Fy().fd(this.bIt);
      localObject = g.a.M(((cs)localObject).field_content, ((cs)localObject).field_reserved);
      if (localObject != null)
      {
        this.title = ((g.a)localObject).title;
        this.dpF = com.tencent.mm.ui.base.p.b(this, getString(R.l.loading_tips), true, 0, null);
      }
    }
    label328:
    aZ();
  }
  
  protected final h bvE()
  {
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    return locale;
  }
  
  protected final String bvF()
  {
    return this.title;
  }
  
  protected final String bvG()
  {
    return this.ntX;
  }
  
  protected final String bvH()
  {
    return this.ntY;
  }
  
  protected final void bvI()
  {
    if (!this.bTT) {
      return;
    }
    addIconOptionMenu(0, R.g.mm_title_btn_menu, new RecordMsgDetailUI.3(this));
  }
  
  protected final void d(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    if (-1 != paramInt2) {
      y.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    label76:
    label87:
    do
    {
      return;
      if (1001 == paramInt1)
      {
        if (paramIntent == null)
        {
          localObject = null;
          if (paramIntent != null) {
            break label76;
          }
        }
        for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
        {
          if (!bk.bl((String)localObject)) {
            break label87;
          }
          y.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
          return;
          localObject = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        au.Hx();
        final bi localbi = com.tencent.mm.model.c.Fy().fd(this.bIt);
        if (localbi.field_msgId != this.bIt)
        {
          y.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
          return;
        }
        final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.favorite_forward_tips), false, null);
        au.DS().O(new Runnable()
        {
          public final void run()
          {
            com.tencent.mm.plugin.record.b.h.a(this.bxX, paramIntent, localbi);
            ai.d(new RecordMsgDetailUI.4.1(this));
          }
          
          public final String toString()
          {
            return super.toString() + "|onActivityResult";
          }
        });
        return;
      }
    } while ((1002 != paramInt1) || (!paramIntent.getBooleanExtra("kfavorite", false)));
    Object localObject = new cj();
    com.tencent.mm.pluginsdk.model.e.a((cj)localObject, paramIntent);
    ((cj)localObject).bIw.activity = this;
    ((cj)localObject).bIw.bID = 8;
    a.udP.m((b)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    n.getRecordMsgCDNStorage().b((e)this.ntS);
    com.tencent.mm.plugin.fav.ui.c.aYx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI
 * JD-Core Version:    0.7.0.1
 */