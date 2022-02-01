package com.tencent.mm.ui.chatting.j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.f;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public abstract class b
  implements c.f, com.tencent.mm.ui.chatting.e.b.a
{
  protected ArrayList<c.b> GFA = null;
  protected b.b GFy;
  com.tencent.mm.ui.chatting.a.c GFz;
  private long GzW = 0L;
  protected String fwd;
  protected ArrayList<c.b> hIH = null;
  protected Context mContext;
  private LinearLayoutManager mmj;
  private boolean nMt = false;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.hIH = new ArrayList();
  }
  
  protected static String b(bl parambl, boolean paramBoolean)
  {
    String str1 = null;
    String str2 = null;
    if (parambl == null) {}
    do
    {
      return str2;
      if (parambl.field_isSend == 1) {
        return u.aqG();
      }
      if (paramBoolean) {
        str1 = bi.uf(parambl.field_content);
      }
      str2 = str1;
    } while (!bt.isNullOrNil(str1));
    return parambl.field_talker;
  }
  
  private void c(cs paramcs)
  {
    paramcs.deQ.deW = 45;
    paramcs.deQ.activity = ((Activity)this.mContext);
    a.ESL.l(paramcs);
    if ((paramcs.deR.ret == -2) || (paramcs.deR.ret > 0)) {}
    while (paramcs.deR.ret > 0) {
      return;
    }
    if (14 != paramcs.deQ.type)
    {
      ad.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
      return;
    }
    if (paramcs.deQ.deT == null)
    {
      ad.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(11142, new Object[] { Integer.valueOf(paramcs.deQ.deT.DiS), Integer.valueOf(paramcs.deQ.deT.DiT), Integer.valueOf(paramcs.deQ.deT.DiU), Integer.valueOf(paramcs.deQ.deT.rBj), Integer.valueOf(paramcs.deQ.deT.DiV), Integer.valueOf(paramcs.deQ.deT.DiW), Integer.valueOf(paramcs.deQ.deT.DiX), Integer.valueOf(paramcs.deQ.deT.fileCount), Integer.valueOf(paramcs.deQ.deT.DiY), Integer.valueOf(paramcs.deQ.deT.DiZ), Integer.valueOf(paramcs.deQ.deT.Dja), Integer.valueOf(paramcs.deQ.deT.Djb), Integer.valueOf(paramcs.deQ.deT.Djc), Integer.valueOf(paramcs.deQ.deT.Djd), Integer.valueOf(paramcs.deQ.deT.Dje) });
  }
  
  private void ck(bl parambl)
  {
    cs localcs = new cs();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambl);
    if (com.tencent.mm.pluginsdk.model.i.a(this.mContext, localcs, this.fwd, localArrayList, false))
    {
      c(localcs);
      return;
    }
    ad.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
  }
  
  private void cl(bl parambl)
  {
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 19L, 1L, true);
    boolean bool = this.fwd.toLowerCase().endsWith("@chatroom");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambl);
    k.a(this.mContext, localArrayList, bool, this.fwd, new z()
    {
      public final void a(z.a paramAnonymousa) {}
      
      public final boolean apE()
      {
        return true;
      }
      
      public final void b(z.a paramAnonymousa) {}
      
      public final void c(z.a paramAnonymousa) {}
    });
  }
  
  private void cm(final bl parambl)
  {
    com.tencent.mm.plugin.report.service.h.vKh.f(11627, new Object[] { Integer.valueOf(5) });
    final TreeSet localTreeSet = new TreeSet();
    localTreeSet.add(Long.valueOf(parambl.field_msgId));
    com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(2131757553), "", this.mContext.getString(2131758038), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(36477);
        ad.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        com.tencent.mm.ui.chatting.i.a(b.this.mContext, localTreeSet, new z()
        {
          public final void a(z.a paramAnonymous2a) {}
          
          public final boolean apE()
          {
            return true;
          }
          
          public final void b(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36475);
            if (paramAnonymous2a == z.a.gLi)
            {
              paramAnonymous2a = new c.b()
              {
                public final int getType()
                {
                  return -1;
                }
              };
              paramAnonymous2a.msgId = b.4.this.gMa.field_msgId;
              b.this.hIH.remove(paramAnonymous2a);
              b.this.GFA.remove(paramAnonymous2a);
            }
            AppMethodBeat.o(36475);
          }
          
          public final void c(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36476);
            ad.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), paramAnonymous2a });
            if (paramAnonymous2a == z.a.gLi) {
              b.this.GFz.aql.notifyChanged();
            }
            AppMethodBeat.o(36476);
          }
        });
        AppMethodBeat.o(36477);
      }
    }, null);
  }
  
  public final c.b YJ(int paramInt)
  {
    if ((this.hIH == null) || (this.hIH.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.hIH.get(paramInt);
  }
  
  public final RecyclerView.a aKQ(String paramString)
  {
    this.fwd = paramString;
    this.GFz = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.Gsh = eZl();
    return this.GFz;
  }
  
  public final void d(int paramInt, bl parambl)
  {
    ad.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ck(parambl);
      return;
    case 0: 
      cl(parambl);
      return;
    }
    cm(parambl);
  }
  
  public final RecyclerView.h eZj()
  {
    new RecyclerView.h()
    {
      int hRF;
      int mSize;
      ColorDrawable nMF;
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(36467);
        int j = paramAnonymousRecyclerView.getPaddingLeft();
        int k = paramAnonymousRecyclerView.getWidth();
        int m = paramAnonymousRecyclerView.getPaddingRight();
        int n = paramAnonymousRecyclerView.getChildCount();
        int i = 0;
        while (i < n)
        {
          paramAnonymouss = paramAnonymousRecyclerView.getChildAt(i);
          if (paramAnonymouss.getTag() != null)
          {
            Object localObject = b.this.YJ(((Integer)paramAnonymouss.getTag()).intValue() + 1);
            if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
            {
              localObject = (RecyclerView.LayoutParams)paramAnonymouss.getLayoutParams();
              int i1 = paramAnonymouss.getBottom();
              i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
              int i2 = this.mSize;
              this.nMF.setBounds(j, i1, k - m, i2 + i1);
              this.nMF.draw(paramAnonymousCanvas);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(36467);
      }
    };
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a eZm()
  {
    new com.tencent.mm.modelvoiceaddr.ui.b.a()
    {
      String Gsj;
      private av fwv;
      
      public final boolean BX(String paramAnonymousString)
      {
        return false;
      }
      
      public final void BY(String paramAnonymousString)
      {
        AppMethodBeat.i(36473);
        if (!this.Gsj.equals(paramAnonymousString))
        {
          this.Gsj = paramAnonymousString;
          this.fwv.stopTimer();
          this.fwv.av(500L, 500L);
        }
        AppMethodBeat.o(36473);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt) {}
      
      public final void aEh() {}
      
      public final void aIj()
      {
        AppMethodBeat.i(36472);
        ad.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
        if (b.this.GFy != null) {
          b.this.GFy.onFinish();
        }
        AppMethodBeat.o(36472);
      }
      
      public final void aIk() {}
      
      public final void aIl() {}
      
      public final void aIm()
      {
        AppMethodBeat.i(36474);
        ad.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
        AppMethodBeat.o(36474);
      }
    };
  }
  
  protected final boolean eZv()
  {
    long l1 = this.GzW;
    long l2 = System.currentTimeMillis();
    this.GzW = l2;
    if (l1 + 30000L < l2)
    {
      az.arV();
      this.nMt = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.nMt;
  }
  
  public final int getCount()
  {
    if (this.hIH == null) {
      return 0;
    }
    return this.hIH.size();
  }
  
  public final void onDetach()
  {
    this.GFy.a(null);
    this.GFy = null;
    if (this.GFz != null)
    {
      com.tencent.mm.ui.chatting.a.c.Gsh = null;
      com.tencent.mm.ui.chatting.a.c.Gsi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.b
 * JD-Core Version:    0.7.0.1
 */