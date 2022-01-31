package com.tencent.mm.ui.chatting.h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.f;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.aj.a;
import com.tencent.mm.ui.chatting.d.b.b;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class b
  implements c.f, com.tencent.mm.ui.chatting.d.b.a
{
  protected String drJ;
  private LinearLayoutManager hDw;
  protected ArrayList<c.b> hka = null;
  private boolean khG = false;
  protected Context mContext;
  private long vuK = 0L;
  protected b.b vyD;
  com.tencent.mm.ui.chatting.a.c vyE;
  protected ArrayList<c.b> vyF = null;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.hka = new ArrayList();
  }
  
  protected static String j(bi parambi, boolean paramBoolean)
  {
    String str1 = null;
    String str2 = null;
    if (parambi == null) {}
    do
    {
      return str2;
      if (parambi.field_isSend == 1) {
        return q.Gj();
      }
      if (paramBoolean) {
        str1 = bd.iI(parambi.field_content);
      }
      str2 = str1;
    } while (!bk.bl(str1));
    return parambi.field_talker;
  }
  
  public final c.b Ha(int paramInt)
  {
    if ((this.hka == null) || (this.hka.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.hka.get(paramInt);
  }
  
  public final RecyclerView.a adA(String paramString)
  {
    this.drJ = paramString;
    this.vyE = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.voq = cFO();
    return this.vyE;
  }
  
  public final RecyclerView.h cFM()
  {
    return new b.1(this);
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a cFP()
  {
    return new b.2(this);
  }
  
  protected final boolean cGO()
  {
    long l1 = this.vuK;
    long l2 = System.currentTimeMillis();
    this.vuK = l2;
    if (l1 + 30000L < l2)
    {
      au.Hx();
      this.khG = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.khG;
  }
  
  public final void d(int paramInt, final bi parambi)
  {
    y.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
    case 1: 
      do
      {
        return;
        localObject = new cj();
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(parambi);
        if (!g.a(this.mContext, (cj)localObject, this.drJ, localArrayList, false, false)) {
          break;
        }
        ((cj)localObject).bIw.bID = 45;
        ((cj)localObject).bIw.activity = ((Activity)this.mContext);
        a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      } while ((((cj)localObject).bIx.ret == -2) || (((cj)localObject).bIx.ret > 0) || (((cj)localObject).bIx.ret > 0));
      if (14 != ((cj)localObject).bIw.type)
      {
        y.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
        return;
      }
      if (((cj)localObject).bIw.bIz == null)
      {
        y.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11142, new Object[] { Integer.valueOf(((cj)localObject).bIw.bIz.sXr), Integer.valueOf(((cj)localObject).bIw.bIz.sXs), Integer.valueOf(((cj)localObject).bIw.bIz.sXt), Integer.valueOf(((cj)localObject).bIw.bIz.sXu), Integer.valueOf(((cj)localObject).bIw.bIz.sXv), Integer.valueOf(((cj)localObject).bIw.bIz.sXw), Integer.valueOf(((cj)localObject).bIw.bIz.sXx), Integer.valueOf(((cj)localObject).bIw.bIz.sXy), Integer.valueOf(((cj)localObject).bIw.bIz.sXz), Integer.valueOf(((cj)localObject).bIw.bIz.sXA), Integer.valueOf(((cj)localObject).bIw.bIz.sXB), Integer.valueOf(((cj)localObject).bIw.bIz.sXC), Integer.valueOf(((cj)localObject).bIw.bIz.sXD), Integer.valueOf(((cj)localObject).bIw.bIz.sXE), Integer.valueOf(((cj)localObject).bIw.bIz.sXF) });
      return;
      y.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
      return;
    case 0: 
      com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 19L, 1L, true);
      boolean bool = this.drJ.toLowerCase().endsWith("@chatroom");
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(parambi);
      l.a(this.mContext, (List)localObject, bool, this.drJ, new b.3(this));
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11627, new Object[] { Integer.valueOf(5) });
    Object localObject = new TreeSet();
    ((Set)localObject).add(Long.valueOf(parambi.field_msgId));
    com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.confirm_delete), "", this.mContext.getString(R.l.delete_message), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        y.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        j.a(b.this.mContext, this.vuY, new aj()
        {
          public final void a(aj.a paramAnonymous2a)
          {
            if (paramAnonymous2a == aj.a.vmw)
            {
              paramAnonymous2a = new b.4.1.1(this);
              paramAnonymous2a.bIt = b.4.this.dUH.field_msgId;
              b.this.hka.remove(paramAnonymous2a);
              b.this.vyF.remove(paramAnonymous2a);
            }
          }
          
          public final void b(aj.a paramAnonymous2a)
          {
            y.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), paramAnonymous2a });
            if (paramAnonymous2a == aj.a.vmw) {
              b.this.vyE.agL.notifyChanged();
            }
          }
          
          public final void cDe() {}
          
          public final boolean cDf()
          {
            return true;
          }
        });
      }
    }, null);
  }
  
  public final int getCount()
  {
    if (this.hka == null) {
      return 0;
    }
    return this.hka.size();
  }
  
  public final void onDetach()
  {
    this.vyD.a(null);
    this.vyD = null;
    if (this.vyE != null)
    {
      com.tencent.mm.ui.chatting.a.c.voq = null;
      com.tencent.mm.ui.chatting.a.c.vor = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b
 * JD-Core Version:    0.7.0.1
 */