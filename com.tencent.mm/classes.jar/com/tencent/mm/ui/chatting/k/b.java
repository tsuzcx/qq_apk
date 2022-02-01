package com.tencent.mm.ui.chatting.k;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.f;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public abstract class b
  implements c.f, com.tencent.mm.ui.chatting.f.b.a
{
  private long Kks = 0L;
  protected b.b KrZ;
  com.tencent.mm.ui.chatting.a.c Ksa;
  protected ArrayList<c.b> Ksb = null;
  protected String fVg;
  protected Context mContext;
  protected ArrayList<c.b> mDataList = null;
  private LinearLayoutManager ntR;
  private boolean oZq = false;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
  }
  
  protected static String b(bv parambv, boolean paramBoolean)
  {
    String str1 = null;
    String str2 = null;
    if (parambv == null) {}
    do
    {
      return str2;
      if (parambv.field_isSend == 1) {
        return v.aAC();
      }
      if (paramBoolean) {
        str1 = bl.BM(parambv.field_content);
      }
      str2 = str1;
    } while (!bu.isNullOrNil(str1));
    return parambv.field_talker;
  }
  
  private void c(cw paramcw)
  {
    paramcw.doL.doR = 45;
    paramcw.doL.activity = ((Activity)this.mContext);
    a.IvT.l(paramcw);
    if ((paramcw.doM.ret == -2) || (paramcw.doM.ret > 0)) {}
    while (paramcw.doM.ret > 0) {
      return;
    }
    if (14 != paramcw.doL.type)
    {
      ae.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
      return;
    }
    if (paramcw.doL.doO == null)
    {
      ae.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
      return;
    }
    g.yxI.f(11142, new Object[] { Integer.valueOf(paramcw.doL.doO.GCt), Integer.valueOf(paramcw.doL.doO.GCu), Integer.valueOf(paramcw.doL.doO.GCv), Integer.valueOf(paramcw.doL.doO.tRD), Integer.valueOf(paramcw.doL.doO.GCw), Integer.valueOf(paramcw.doL.doO.GCx), Integer.valueOf(paramcw.doL.doO.GCy), Integer.valueOf(paramcw.doL.doO.fileCount), Integer.valueOf(paramcw.doL.doO.GCz), Integer.valueOf(paramcw.doL.doO.GCA), Integer.valueOf(paramcw.doL.doO.GCB), Integer.valueOf(paramcw.doL.doO.GCC), Integer.valueOf(paramcw.doL.doO.GCD), Integer.valueOf(paramcw.doL.doO.GCE), Integer.valueOf(paramcw.doL.doO.GCF) });
  }
  
  private void cs(bv parambv)
  {
    cw localcw = new cw();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambv);
    if (i.a(this.mContext, localcw, this.fVg, localArrayList, false))
    {
      c(localcw);
      return;
    }
    ae.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
  }
  
  private void ct(bv parambv)
  {
    g.yxI.idkeyStat(219L, 19L, 1L, true);
    boolean bool = this.fVg.toLowerCase().endsWith("@chatroom");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambv);
    l.a(this.mContext, localArrayList, bool, this.fVg, new z()
    {
      public final void a(z.a paramAnonymousa) {}
      
      public final boolean azv()
      {
        return true;
      }
      
      public final boolean azw()
      {
        return false;
      }
      
      public final boolean azx()
      {
        return false;
      }
      
      public final void b(z.a paramAnonymousa) {}
      
      public final void c(z.a paramAnonymousa) {}
      
      public final void v(Bundle paramAnonymousBundle) {}
    });
  }
  
  private void cu(final bv parambv)
  {
    g.yxI.f(11627, new Object[] { Integer.valueOf(5) });
    final TreeSet localTreeSet = new TreeSet();
    localTreeSet.add(Long.valueOf(parambv.field_msgId));
    h.e(this.mContext, this.mContext.getString(2131757553), "", this.mContext.getString(2131758038), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(36477);
        ae.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        j.a(b.this.mContext, localTreeSet, new z()
        {
          public final void a(z.a paramAnonymous2a) {}
          
          public final boolean azv()
          {
            return true;
          }
          
          public final boolean azw()
          {
            return false;
          }
          
          public final boolean azx()
          {
            return false;
          }
          
          public final void b(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36475);
            if (paramAnonymous2a == z.a.hGK)
            {
              paramAnonymous2a = new c.b()
              {
                public final int getType()
                {
                  return -1;
                }
              };
              paramAnonymous2a.msgId = b.4.this.hHF.field_msgId;
              b.this.mDataList.remove(paramAnonymous2a);
              b.this.Ksb.remove(paramAnonymous2a);
            }
            AppMethodBeat.o(36475);
          }
          
          public final void c(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36476);
            ae.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), paramAnonymous2a });
            if (paramAnonymous2a == z.a.hGK) {
              b.this.Ksa.asY.notifyChanged();
            }
            AppMethodBeat.o(36476);
          }
          
          public final void v(Bundle paramAnonymous2Bundle) {}
        });
        AppMethodBeat.o(36477);
      }
    }, null);
  }
  
  public final RecyclerView.a aXN(String paramString)
  {
    this.fVg = paramString;
    this.Ksa = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.KaI = fJM();
    return this.Ksa;
  }
  
  public final c.b adN(int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.mDataList.get(paramInt);
  }
  
  public final void d(int paramInt, bv parambv)
  {
    ae.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      cs(parambv);
      return;
    case 0: 
      ct(parambv);
      return;
    }
    cu(parambv);
  }
  
  public final RecyclerView.h fJK()
  {
    new RecyclerView.h()
    {
      int iNG;
      int mSize;
      ColorDrawable oZC;
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
      {
        AppMethodBeat.i(36467);
        int j = paramAnonymousRecyclerView.getPaddingLeft();
        int k = paramAnonymousRecyclerView.getWidth();
        int m = paramAnonymousRecyclerView.getPaddingRight();
        int n = paramAnonymousRecyclerView.getChildCount();
        int i = 0;
        while (i < n)
        {
          paramAnonymoust = paramAnonymousRecyclerView.getChildAt(i);
          if (paramAnonymoust.getTag() != null)
          {
            Object localObject = b.this.adN(((Integer)paramAnonymoust.getTag()).intValue() + 1);
            if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
            {
              localObject = (RecyclerView.LayoutParams)paramAnonymoust.getLayoutParams();
              int i1 = paramAnonymoust.getBottom();
              i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
              int i2 = this.mSize;
              this.oZC.setBounds(j, i1, k - m, i2 + i1);
              this.oZC.draw(paramAnonymousCanvas);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(36467);
      }
    };
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a fJN()
  {
    new com.tencent.mm.modelvoiceaddr.ui.b.a()
    {
      String KaK;
      private aw fVy;
      
      public final boolean JO(String paramAnonymousString)
      {
        return false;
      }
      
      public final void JP(String paramAnonymousString)
      {
        AppMethodBeat.i(36473);
        if (!this.KaK.equals(paramAnonymousString))
        {
          this.KaK = paramAnonymousString;
          this.fVy.stopTimer();
          this.fVy.ay(500L, 500L);
        }
        AppMethodBeat.o(36473);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt) {}
      
      public final void aOF() {}
      
      public final void aSL()
      {
        AppMethodBeat.i(36472);
        ae.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
        if (b.this.KrZ != null) {
          b.this.KrZ.onFinish();
        }
        AppMethodBeat.o(36472);
      }
      
      public final void aSM() {}
      
      public final void aSN() {}
      
      public final void aSO()
      {
        AppMethodBeat.i(36474);
        ae.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
        AppMethodBeat.o(36474);
      }
    };
  }
  
  protected final boolean fJW()
  {
    long l1 = this.Kks;
    long l2 = System.currentTimeMillis();
    this.Kks = l2;
    if (l1 + 30000L < l2)
    {
      bc.aCg();
      this.oZq = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.oZq;
  }
  
  public final int getCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  public final void onDetach()
  {
    this.KrZ.a(null);
    this.KrZ = null;
    if (this.Ksa != null)
    {
      com.tencent.mm.ui.chatting.a.c.KaI = null;
      com.tencent.mm.ui.chatting.a.c.KaJ = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b
 * JD-Core Version:    0.7.0.1
 */