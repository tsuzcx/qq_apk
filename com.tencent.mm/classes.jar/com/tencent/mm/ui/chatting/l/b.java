package com.tencent.mm.ui.chatting.l;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.z.a;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.protocal.protobuf.aoq;
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
import com.tencent.mm.ui.chatting.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class b
  implements c.f, com.tencent.mm.ui.chatting.f.b.a
{
  private long DlT = 0L;
  protected b.b WYZ;
  com.tencent.mm.ui.chatting.a.c WZa;
  protected ArrayList<c.b> WZb = null;
  protected String jkq;
  protected Context mContext;
  protected ArrayList<c.b> mDataList = null;
  private LinearLayoutManager rFD;
  private boolean tMW = false;
  
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
        return com.tencent.mm.model.z.bcZ();
      }
      if (paramBoolean) {
        str1 = bq.RL(paramca.field_content);
      }
      str2 = str1;
    } while (!Util.isNullOrNil(str1));
    return paramca.field_talker;
  }
  
  private void c(dd paramdd)
  {
    paramdd.fyI.fyP = 45;
    paramdd.fyI.activity = ((Activity)this.mContext);
    EventCenter.instance.publish(paramdd);
    if ((paramdd.fyJ.ret == -2) || (paramdd.fyJ.ret > 0)) {}
    while (paramdd.fyJ.ret > 0) {
      return;
    }
    if (14 != paramdd.fyI.type)
    {
      Log.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
      return;
    }
    if (paramdd.fyI.fyL == null)
    {
      Log.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11142, new Object[] { Integer.valueOf(paramdd.fyI.fyL.SAQ), Integer.valueOf(paramdd.fyI.fyL.JCD), Integer.valueOf(paramdd.fyI.fyL.SAR), Integer.valueOf(paramdd.fyI.fyL.xzT), Integer.valueOf(paramdd.fyI.fyL.SAS), Integer.valueOf(paramdd.fyI.fyL.SAT), Integer.valueOf(paramdd.fyI.fyL.SAU), Integer.valueOf(paramdd.fyI.fyL.fileCount), Integer.valueOf(paramdd.fyI.fyL.SAV), Integer.valueOf(paramdd.fyI.fyL.SAW), Integer.valueOf(paramdd.fyI.fyL.SAX), Integer.valueOf(paramdd.fyI.fyL.SAY), Integer.valueOf(paramdd.fyI.fyL.SAZ), Integer.valueOf(paramdd.fyI.fyL.SBa), Integer.valueOf(paramdd.fyI.fyL.SBb) });
  }
  
  private void db(ca paramca)
  {
    dd localdd = new dd();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramca);
    if (com.tencent.mm.pluginsdk.model.l.a(this.mContext, localdd, this.jkq, localArrayList, false))
    {
      c(localdd);
      return;
    }
    Log.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
  }
  
  private void dc(ca paramca)
  {
    Object localObject = k.b.OQ(paramca.field_content);
    if ((localObject != null) && (51 == ((k.b)localObject).type) && (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(this.mContext))) {
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 19L, 1L, true);
    boolean bool = this.jkq.toLowerCase().endsWith("@chatroom");
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramca);
    com.tencent.mm.ui.chatting.l.a(this.mContext, (List)localObject, bool, this.jkq, new com.tencent.mm.aj.z()
    {
      public final void H(Bundle paramAnonymousBundle) {}
      
      public final void a(z.a paramAnonymousa) {}
      
      public final void b(z.a paramAnonymousa) {}
      
      public final boolean bbA()
      {
        return true;
      }
      
      public final boolean bbB()
      {
        return false;
      }
      
      public final boolean bbC()
      {
        return false;
      }
      
      public final void c(z.a paramAnonymousa) {}
    });
  }
  
  private void dd(final ca paramca)
  {
    com.tencent.mm.plugin.report.service.h.IzE.a(11627, new Object[] { Integer.valueOf(5) });
    final TreeSet localTreeSet = new TreeSet();
    localTreeSet.add(Long.valueOf(paramca.field_msgId));
    com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(R.l.exL), "", this.mContext.getString(R.l.eBd), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(36477);
        Log.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        j.a(b.this.mContext, localTreeSet, new com.tencent.mm.aj.z()
        {
          public final void H(Bundle paramAnonymous2Bundle) {}
          
          public final void a(z.a paramAnonymous2a) {}
          
          public final void b(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36475);
            if (paramAnonymous2a == z.a.lqr)
            {
              paramAnonymous2a = new c.b()
              {
                public final int getType()
                {
                  return -1;
                }
              };
              paramAnonymous2a.msgId = b.4.this.lru.field_msgId;
              b.this.mDataList.remove(paramAnonymous2a);
              b.this.WZb.remove(paramAnonymous2a);
            }
            AppMethodBeat.o(36475);
          }
          
          public final boolean bbA()
          {
            return true;
          }
          
          public final boolean bbB()
          {
            return false;
          }
          
          public final boolean bbC()
          {
            return false;
          }
          
          public final void c(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36476);
            Log.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), paramAnonymous2a });
            if (paramAnonymous2a == z.a.lqr) {
              b.this.WZa.alc.notifyChanged();
            }
            AppMethodBeat.o(36476);
          }
        });
        AppMethodBeat.o(36477);
      }
    }, null);
  }
  
  public final c.b avy(int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.mDataList.get(paramInt);
  }
  
  public final RecyclerView.a bzt(String paramString)
  {
    this.jkq = paramString;
    this.WZa = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.WFP = hRv();
    return this.WZa;
  }
  
  public final void e(int paramInt, ca paramca)
  {
    Log.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      db(paramca);
      return;
    case 0: 
      dc(paramca);
      return;
    }
    dd(paramca);
  }
  
  public final int getCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  protected final boolean hRJ()
  {
    long l1 = this.DlT;
    long l2 = System.currentTimeMillis();
    this.DlT = l2;
    if (l1 + 30000L < l2)
    {
      bh.beI();
      this.tMW = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.tMW;
  }
  
  public final RecyclerView.h hRt()
  {
    new RecyclerView.h()
    {
      int mBx;
      int mSize;
      ColorDrawable tNj;
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(222308);
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
            Object localObject = b.this.avy(((Integer)paramAnonymouss.getTag()).intValue() + 1);
            if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
            {
              localObject = (RecyclerView.LayoutParams)paramAnonymouss.getLayoutParams();
              int i1 = paramAnonymouss.getBottom();
              i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
              int i2 = this.mSize;
              this.tNj.setBounds(j, i1, k - m, i2 + i1);
              this.tNj.draw(paramAnonymousCanvas);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(222308);
      }
    };
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a hRw()
  {
    new com.tencent.mm.modelvoiceaddr.ui.b.a()
    {
      String WFR;
      private MTimerHandler jkK;
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt) {}
      
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(36473);
        if (!this.WFR.equals(paramAnonymousString))
        {
          this.WFR = paramAnonymousString;
          this.jkK.stopTimer();
          this.jkK.startTimer(500L);
        }
        AppMethodBeat.o(36473);
      }
      
      public final void bsk() {}
      
      public final void bxH()
      {
        AppMethodBeat.i(36472);
        Log.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
        if (b.this.WYZ != null) {
          b.this.WYZ.onFinish();
        }
        AppMethodBeat.o(36472);
      }
      
      public final void bxI() {}
      
      public final void bxJ() {}
      
      public final void bxK()
      {
        AppMethodBeat.i(36474);
        Log.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
        AppMethodBeat.o(36474);
      }
    };
  }
  
  public final void onDetach()
  {
    this.WYZ.a(null);
    this.WYZ = null;
    if (this.WZa != null)
    {
      com.tencent.mm.ui.chatting.a.c.WFP = null;
      com.tencent.mm.ui.chatting.a.c.WFQ = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b
 * JD-Core Version:    0.7.0.1
 */