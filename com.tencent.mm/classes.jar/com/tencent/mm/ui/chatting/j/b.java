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
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
  private long HZR = 0L;
  protected b.b Ifu;
  com.tencent.mm.ui.chatting.a.c Ifv;
  protected ArrayList<c.b> Ifw = null;
  protected String fzK;
  protected ArrayList<c.b> ijj = null;
  protected Context mContext;
  private LinearLayoutManager mOk;
  private boolean opt = false;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.ijj = new ArrayList();
  }
  
  protected static String b(bo parambo, boolean paramBoolean)
  {
    String str1 = null;
    String str2 = null;
    if (parambo == null) {}
    do
    {
      return str2;
      if (parambo.field_isSend == 1) {
        return u.axw();
      }
      if (paramBoolean) {
        str1 = bi.yl(parambo.field_content);
      }
      str2 = str1;
    } while (!bs.isNullOrNil(str1));
    return parambo.field_talker;
  }
  
  private void c(cs paramcs)
  {
    paramcs.dck.dcq = 45;
    paramcs.dck.activity = ((Activity)this.mContext);
    a.GpY.l(paramcs);
    if ((paramcs.dcl.ret == -2) || (paramcs.dcl.ret > 0)) {}
    while (paramcs.dcl.ret > 0) {
      return;
    }
    if (14 != paramcs.dck.type)
    {
      ac.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
      return;
    }
    if (paramcs.dck.dcn == null)
    {
      ac.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(11142, new Object[] { Integer.valueOf(paramcs.dck.dcn.EBY), Integer.valueOf(paramcs.dck.dcn.EBZ), Integer.valueOf(paramcs.dck.dcn.ECa), Integer.valueOf(paramcs.dck.dcn.sKb), Integer.valueOf(paramcs.dck.dcn.ECb), Integer.valueOf(paramcs.dck.dcn.ECc), Integer.valueOf(paramcs.dck.dcn.ECd), Integer.valueOf(paramcs.dck.dcn.fileCount), Integer.valueOf(paramcs.dck.dcn.ECe), Integer.valueOf(paramcs.dck.dcn.ECf), Integer.valueOf(paramcs.dck.dcn.ECg), Integer.valueOf(paramcs.dck.dcn.ECh), Integer.valueOf(paramcs.dck.dcn.ECi), Integer.valueOf(paramcs.dck.dcn.ECj), Integer.valueOf(paramcs.dck.dcn.ECk) });
  }
  
  private void cn(bo parambo)
  {
    cs localcs = new cs();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambo);
    if (com.tencent.mm.pluginsdk.model.i.a(this.mContext, localcs, this.fzK, localArrayList, false))
    {
      c(localcs);
      return;
    }
    ac.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
  }
  
  private void co(bo parambo)
  {
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 19L, 1L, true);
    boolean bool = this.fzK.toLowerCase().endsWith("@chatroom");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambo);
    k.a(this.mContext, localArrayList, bool, this.fzK, new z()
    {
      public final void a(z.a paramAnonymousa) {}
      
      public final boolean awt()
      {
        return true;
      }
      
      public final void b(z.a paramAnonymousa) {}
      
      public final void c(z.a paramAnonymousa) {}
    });
  }
  
  private void cp(final bo parambo)
  {
    com.tencent.mm.plugin.report.service.h.wUl.f(11627, new Object[] { Integer.valueOf(5) });
    final TreeSet localTreeSet = new TreeSet();
    localTreeSet.add(Long.valueOf(parambo.field_msgId));
    com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(2131757553), "", this.mContext.getString(2131758038), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(36477);
        ac.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        com.tencent.mm.ui.chatting.i.a(b.this.mContext, localTreeSet, new z()
        {
          public final void a(z.a paramAnonymous2a) {}
          
          public final boolean awt()
          {
            return true;
          }
          
          public final void b(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36475);
            if (paramAnonymous2a == z.a.hlI)
            {
              paramAnonymous2a = new c.b()
              {
                public final int getType()
                {
                  return -1;
                }
              };
              paramAnonymous2a.msgId = b.4.this.hmA.field_msgId;
              b.this.ijj.remove(paramAnonymous2a);
              b.this.Ifw.remove(paramAnonymous2a);
            }
            AppMethodBeat.o(36475);
          }
          
          public final void c(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36476);
            ac.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), paramAnonymous2a });
            if (paramAnonymous2a == z.a.hlI) {
              b.this.Ifv.arg.notifyChanged();
            }
            AppMethodBeat.o(36476);
          }
        });
        AppMethodBeat.o(36477);
      }
    }, null);
  }
  
  public final RecyclerView.a aQt(String paramString)
  {
    this.fzK = paramString;
    this.Ifv = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.HRZ = fpa();
    return this.Ifv;
  }
  
  public final c.b aaU(int paramInt)
  {
    if ((this.ijj == null) || (this.ijj.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.ijj.get(paramInt);
  }
  
  public final void d(int paramInt, bo parambo)
  {
    ac.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      cn(parambo);
      return;
    case 0: 
      co(parambo);
      return;
    }
    cp(parambo);
  }
  
  public final RecyclerView.h foY()
  {
    new RecyclerView.h()
    {
      int irK;
      int mSize;
      ColorDrawable opF;
      
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
            Object localObject = b.this.aaU(((Integer)paramAnonymoust.getTag()).intValue() + 1);
            if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
            {
              localObject = (RecyclerView.LayoutParams)paramAnonymoust.getLayoutParams();
              int i1 = paramAnonymoust.getBottom();
              i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
              int i2 = this.mSize;
              this.opF.setBounds(j, i1, k - m, i2 + i1);
              this.opF.draw(paramAnonymousCanvas);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(36467);
      }
    };
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a fpb()
  {
    new com.tencent.mm.modelvoiceaddr.ui.b.a()
    {
      String HSb;
      private au fAc;
      
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(36473);
        if (!this.HSb.equals(paramAnonymousString))
        {
          this.HSb = paramAnonymousString;
          this.fAc.stopTimer();
          this.fAc.au(500L, 500L);
        }
        AppMethodBeat.o(36473);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt) {}
      
      public final void aKY() {}
      
      public final void aPa()
      {
        AppMethodBeat.i(36472);
        ac.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
        if (b.this.Ifu != null) {
          b.this.Ifu.onFinish();
        }
        AppMethodBeat.o(36472);
      }
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd()
      {
        AppMethodBeat.i(36474);
        ac.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
        AppMethodBeat.o(36474);
      }
    };
  }
  
  protected final boolean fpk()
  {
    long l1 = this.HZR;
    long l2 = System.currentTimeMillis();
    this.HZR = l2;
    if (l1 + 30000L < l2)
    {
      az.ayM();
      this.opt = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.opt;
  }
  
  public final int getCount()
  {
    if (this.ijj == null) {
      return 0;
    }
    return this.ijj.size();
  }
  
  public final void onDetach()
  {
    this.Ifu.a(null);
    this.Ifu = null;
    if (this.Ifv != null)
    {
      com.tencent.mm.ui.chatting.a.c.HRZ = null;
      com.tencent.mm.ui.chatting.a.c.HSa = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.b
 * JD-Core Version:    0.7.0.1
 */