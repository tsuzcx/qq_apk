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
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.f;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public abstract class b
  implements c.f, com.tencent.mm.ui.chatting.f.b.a
{
  private long JPg = 0L;
  protected b.b JVH;
  com.tencent.mm.ui.chatting.a.c JVI;
  protected ArrayList<c.b> JVJ = null;
  protected String fTa;
  protected Context mContext;
  protected ArrayList<c.b> mDataList = null;
  private LinearLayoutManager noH;
  private boolean oSO = false;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
  }
  
  protected static String b(bu parambu, boolean paramBoolean)
  {
    String str1 = null;
    String str2 = null;
    if (parambu == null) {}
    do
    {
      return str2;
      if (parambu.field_isSend == 1) {
        return u.aAm();
      }
      if (paramBoolean) {
        str1 = bj.Bk(parambu.field_content);
      }
      str2 = str1;
    } while (!bt.isNullOrNil(str1));
    return parambu.field_talker;
  }
  
  private void c(cv paramcv)
  {
    paramcv.dnG.dnM = 45;
    paramcv.dnG.activity = ((Activity)this.mContext);
    a.IbL.l(paramcv);
    if ((paramcv.dnH.ret == -2) || (paramcv.dnH.ret > 0)) {}
    while (paramcv.dnH.ret > 0) {
      return;
    }
    if (14 != paramcv.dnG.type)
    {
      ad.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
      return;
    }
    if (paramcv.dnG.dnJ == null)
    {
      ad.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
      return;
    }
    g.yhR.f(11142, new Object[] { Integer.valueOf(paramcv.dnG.dnJ.GjK), Integer.valueOf(paramcv.dnG.dnJ.GjL), Integer.valueOf(paramcv.dnG.dnJ.GjM), Integer.valueOf(paramcv.dnG.dnJ.tGM), Integer.valueOf(paramcv.dnG.dnJ.GjN), Integer.valueOf(paramcv.dnG.dnJ.GjO), Integer.valueOf(paramcv.dnG.dnJ.GjP), Integer.valueOf(paramcv.dnG.dnJ.fileCount), Integer.valueOf(paramcv.dnG.dnJ.GjQ), Integer.valueOf(paramcv.dnG.dnJ.GjR), Integer.valueOf(paramcv.dnG.dnJ.GjS), Integer.valueOf(paramcv.dnG.dnJ.GjT), Integer.valueOf(paramcv.dnG.dnJ.GjU), Integer.valueOf(paramcv.dnG.dnJ.GjV), Integer.valueOf(paramcv.dnG.dnJ.GjW) });
  }
  
  private void ct(bu parambu)
  {
    cv localcv = new cv();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambu);
    if (com.tencent.mm.pluginsdk.model.i.a(this.mContext, localcv, this.fTa, localArrayList, false))
    {
      c(localcv);
      return;
    }
    ad.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
  }
  
  private void cu(bu parambu)
  {
    g.yhR.idkeyStat(219L, 19L, 1L, true);
    boolean bool = this.fTa.toLowerCase().endsWith("@chatroom");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambu);
    k.a(this.mContext, localArrayList, bool, this.fTa, new z()
    {
      public final void a(z.a paramAnonymousa) {}
      
      public final boolean azg()
      {
        return true;
      }
      
      public final boolean azh()
      {
        return false;
      }
      
      public final void b(z.a paramAnonymousa) {}
      
      public final void c(z.a paramAnonymousa) {}
      
      public final void u(Bundle paramAnonymousBundle) {}
    });
  }
  
  private void cv(final bu parambu)
  {
    g.yhR.f(11627, new Object[] { Integer.valueOf(5) });
    final TreeSet localTreeSet = new TreeSet();
    localTreeSet.add(Long.valueOf(parambu.field_msgId));
    h.e(this.mContext, this.mContext.getString(2131757553), "", this.mContext.getString(2131758038), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(36477);
        ad.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        com.tencent.mm.ui.chatting.i.a(b.this.mContext, localTreeSet, new z()
        {
          public final void a(z.a paramAnonymous2a) {}
          
          public final boolean azg()
          {
            return true;
          }
          
          public final boolean azh()
          {
            return false;
          }
          
          public final void b(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36475);
            if (paramAnonymous2a == z.a.hDS)
            {
              paramAnonymous2a = new c.b()
              {
                public final int getType()
                {
                  return -1;
                }
              };
              paramAnonymous2a.msgId = b.4.this.hEN.field_msgId;
              b.this.mDataList.remove(paramAnonymous2a);
              b.this.JVJ.remove(paramAnonymous2a);
            }
            AppMethodBeat.o(36475);
          }
          
          public final void c(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36476);
            ad.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), paramAnonymous2a });
            if (paramAnonymous2a == z.a.hDS) {
              b.this.JVI.asY.notifyChanged();
            }
            AppMethodBeat.o(36476);
          }
          
          public final void u(Bundle paramAnonymous2Bundle) {}
        });
        AppMethodBeat.o(36477);
      }
    }, null);
  }
  
  public final RecyclerView.a aWm(String paramString)
  {
    this.fTa = paramString;
    this.JVI = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.JFR = fFF();
    return this.JVI;
  }
  
  public final c.b adg(int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.mDataList.get(paramInt);
  }
  
  public final void d(int paramInt, bu parambu)
  {
    ad.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ct(parambu);
      return;
    case 0: 
      cu(parambu);
      return;
    }
    cv(parambu);
  }
  
  public final RecyclerView.h fFD()
  {
    new RecyclerView.h()
    {
      int iKN;
      int mSize;
      ColorDrawable oTa;
      
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
            Object localObject = b.this.adg(((Integer)paramAnonymoust.getTag()).intValue() + 1);
            if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
            {
              localObject = (RecyclerView.LayoutParams)paramAnonymoust.getLayoutParams();
              int i1 = paramAnonymoust.getBottom();
              i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
              int i2 = this.mSize;
              this.oTa.setBounds(j, i1, k - m, i2 + i1);
              this.oTa.draw(paramAnonymousCanvas);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(36467);
      }
    };
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a fFG()
  {
    new com.tencent.mm.modelvoiceaddr.ui.b.a()
    {
      String JFT;
      private av fTs;
      
      public final boolean Jp(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(36473);
        if (!this.JFT.equals(paramAnonymousString))
        {
          this.JFT = paramAnonymousString;
          this.fTs.stopTimer();
          this.fTs.az(500L, 500L);
        }
        AppMethodBeat.o(36473);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt) {}
      
      public final void aOh() {}
      
      public final void aSm()
      {
        AppMethodBeat.i(36472);
        ad.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
        if (b.this.JVH != null) {
          b.this.JVH.onFinish();
        }
        AppMethodBeat.o(36472);
      }
      
      public final void aSn() {}
      
      public final void aSo() {}
      
      public final void aSp()
      {
        AppMethodBeat.i(36474);
        ad.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
        AppMethodBeat.o(36474);
      }
    };
  }
  
  protected final boolean fFP()
  {
    long l1 = this.JPg;
    long l2 = System.currentTimeMillis();
    this.JPg = l2;
    if (l1 + 30000L < l2)
    {
      ba.aBQ();
      this.oSO = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.oSO;
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
    this.JVH.a(null);
    this.JVH = null;
    if (this.JVI != null)
    {
      com.tencent.mm.ui.chatting.a.c.JFR = null;
      com.tencent.mm.ui.chatting.a.c.JFS = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b
 * JD-Core Version:    0.7.0.1
 */