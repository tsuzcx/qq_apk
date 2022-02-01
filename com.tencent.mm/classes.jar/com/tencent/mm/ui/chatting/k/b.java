package com.tencent.mm.ui.chatting.k;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.z.a;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.f;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class b
  implements c.f, com.tencent.mm.ui.chatting.f.b.a
{
  protected b.b PEm;
  com.tencent.mm.ui.chatting.a.c PEn;
  protected ArrayList<c.b> PEo = null;
  private long Pwr = 0L;
  protected String gAn;
  protected Context mContext;
  protected ArrayList<c.b> mDataList = null;
  private LinearLayoutManager oDV;
  private boolean qoo = false;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
  }
  
  protected static String b(ca paramca, boolean paramBoolean)
  {
    String str1 = null;
    String str2 = null;
    if (paramca == null) {}
    do
    {
      return str2;
      if (paramca.field_isSend == 1) {
        return com.tencent.mm.model.z.aTY();
      }
      if (paramBoolean) {
        str1 = bp.Ks(paramca.field_content);
      }
      str2 = str1;
    } while (!Util.isNullOrNil(str1));
    return paramca.field_talker;
  }
  
  private void c(cz paramcz)
  {
    paramcz.dFZ.dGf = 45;
    paramcz.dFZ.activity = ((Activity)this.mContext);
    EventCenter.instance.publish(paramcz);
    if ((paramcz.dGa.ret == -2) || (paramcz.dGa.ret > 0)) {}
    while (paramcz.dGa.ret > 0) {
      return;
    }
    if (14 != paramcz.dFZ.type)
    {
      Log.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
      return;
    }
    if (paramcz.dFZ.dGc == null)
    {
      Log.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11142, new Object[] { Integer.valueOf(paramcz.dFZ.dGc.Lyp), Integer.valueOf(paramcz.dFZ.dGc.Lyq), Integer.valueOf(paramcz.dFZ.dGc.Lyr), Integer.valueOf(paramcz.dFZ.dGc.xiP), Integer.valueOf(paramcz.dFZ.dGc.Lys), Integer.valueOf(paramcz.dFZ.dGc.Lyt), Integer.valueOf(paramcz.dFZ.dGc.Lyu), Integer.valueOf(paramcz.dFZ.dGc.fileCount), Integer.valueOf(paramcz.dFZ.dGc.Lyv), Integer.valueOf(paramcz.dFZ.dGc.Lyw), Integer.valueOf(paramcz.dFZ.dGc.Lyx), Integer.valueOf(paramcz.dFZ.dGc.Lyy), Integer.valueOf(paramcz.dFZ.dGc.Lyz), Integer.valueOf(paramcz.dFZ.dGc.LyA), Integer.valueOf(paramcz.dFZ.dGc.LyB) });
  }
  
  private void cI(ca paramca)
  {
    cz localcz = new cz();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramca);
    if (com.tencent.mm.pluginsdk.model.j.a(this.mContext, localcz, this.gAn, localArrayList, false))
    {
      c(localcz);
      return;
    }
    Log.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
  }
  
  private void cJ(ca paramca)
  {
    Object localObject = k.b.HD(paramca.field_content);
    if ((localObject != null) && (51 == ((k.b)localObject).type) && (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(this.mContext))) {
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 19L, 1L, true);
    boolean bool = this.gAn.toLowerCase().endsWith("@chatroom");
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramca);
    l.a(this.mContext, (List)localObject, bool, this.gAn, new com.tencent.mm.ag.z()
    {
      public final void B(Bundle paramAnonymousBundle) {}
      
      public final void a(z.a paramAnonymousa) {}
      
      public final boolean aSC()
      {
        return true;
      }
      
      public final boolean aSD()
      {
        return false;
      }
      
      public final boolean aSE()
      {
        return false;
      }
      
      public final void b(z.a paramAnonymousa) {}
      
      public final void c(z.a paramAnonymousa) {}
    });
  }
  
  private void cK(final ca paramca)
  {
    com.tencent.mm.plugin.report.service.h.CyF.a(11627, new Object[] { Integer.valueOf(5) });
    final TreeSet localTreeSet = new TreeSet();
    localTreeSet.add(Long.valueOf(paramca.field_msgId));
    com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(2131757780), "", this.mContext.getString(2131758290), this.mContext.getString(2131755761), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(36477);
        Log.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        com.tencent.mm.ui.chatting.j.a(b.this.mContext, localTreeSet, new com.tencent.mm.ag.z()
        {
          public final void B(Bundle paramAnonymous2Bundle) {}
          
          public final void a(z.a paramAnonymous2a) {}
          
          public final boolean aSC()
          {
            return true;
          }
          
          public final boolean aSD()
          {
            return false;
          }
          
          public final boolean aSE()
          {
            return false;
          }
          
          public final void b(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36475);
            if (paramAnonymous2a == z.a.iAT)
            {
              paramAnonymous2a = new c.b()
              {
                public final int getType()
                {
                  return -1;
                }
              };
              paramAnonymous2a.msgId = b.4.this.iBP.field_msgId;
              b.this.mDataList.remove(paramAnonymous2a);
              b.this.PEo.remove(paramAnonymous2a);
            }
            AppMethodBeat.o(36475);
          }
          
          public final void c(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36476);
            Log.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), paramAnonymous2a });
            if (paramAnonymous2a == z.a.iAT) {
              b.this.PEn.atj.notifyChanged();
            }
            AppMethodBeat.o(36476);
          }
        });
        AppMethodBeat.o(36477);
      }
    }, null);
  }
  
  public final c.b amy(int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.mDataList.get(paramInt);
  }
  
  public final RecyclerView.a bmS(String paramString)
  {
    this.gAn = paramString;
    this.PEn = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.Pme = gRZ();
    return this.PEn;
  }
  
  public final void d(int paramInt, ca paramca)
  {
    Log.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      cI(paramca);
      return;
    case 0: 
      cJ(paramca);
      return;
    }
    cK(paramca);
  }
  
  public final RecyclerView.h gRX()
  {
    new RecyclerView.h()
    {
      int jKu;
      int mSize;
      ColorDrawable qoA;
      
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
            Object localObject = b.this.amy(((Integer)paramAnonymouss.getTag()).intValue() + 1);
            if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
            {
              localObject = (RecyclerView.LayoutParams)paramAnonymouss.getLayoutParams();
              int i1 = paramAnonymouss.getBottom();
              i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
              int i2 = this.mSize;
              this.qoA.setBounds(j, i1, k - m, i2 + i1);
              this.qoA.draw(paramAnonymousCanvas);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(36467);
      }
    };
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a gSa()
  {
    new com.tencent.mm.modelvoiceaddr.ui.b.a()
    {
      String Pmg;
      private MTimerHandler gAF;
      
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(36473);
        if (!this.Pmg.equals(paramAnonymousString))
        {
          this.Pmg = paramAnonymousString;
          this.gAF.stopTimer();
          this.gAF.startTimer(500L);
        }
        AppMethodBeat.o(36473);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt) {}
      
      public final void biM() {}
      
      public final void bnA() {}
      
      public final void bnB()
      {
        AppMethodBeat.i(36474);
        Log.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
        AppMethodBeat.o(36474);
      }
      
      public final void bny()
      {
        AppMethodBeat.i(36472);
        Log.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
        if (b.this.PEm != null) {
          b.this.PEm.onFinish();
        }
        AppMethodBeat.o(36472);
      }
      
      public final void bnz() {}
    };
  }
  
  protected final boolean gSk()
  {
    long l1 = this.Pwr;
    long l2 = System.currentTimeMillis();
    this.Pwr = l2;
    if (l1 + 30000L < l2)
    {
      bg.aVF();
      this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.qoo;
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
    this.PEm.a(null);
    this.PEm = null;
    if (this.PEn != null)
    {
      com.tencent.mm.ui.chatting.a.c.Pme = null;
      com.tencent.mm.ui.chatting.a.c.Pmf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b
 * JD-Core Version:    0.7.0.1
 */