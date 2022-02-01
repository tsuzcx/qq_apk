package com.tencent.mm.ui.chatting.presenter;

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
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.z.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.f;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class b
  implements c.f, com.tencent.mm.ui.chatting.e.b.a
{
  private long Jfc = 0L;
  com.tencent.mm.ui.chatting.a.c aeIA;
  protected ArrayList<c.b> aeIB = null;
  protected b.b aeIz;
  protected String lMU;
  protected Context mContext;
  protected ArrayList<c.b> mDataList = null;
  private LinearLayoutManager uQP;
  private boolean wQm = false;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
  }
  
  protected static String b(cc paramcc, boolean paramBoolean)
  {
    String str1 = null;
    String str2 = null;
    if (paramcc == null) {}
    do
    {
      return str2;
      if (paramcc.field_isSend == 1) {
        return com.tencent.mm.model.z.bAM();
      }
      if (paramBoolean) {
        str1 = br.JJ(paramcc.field_content);
      }
      str2 = str1;
    } while (!Util.isNullOrNil(str1));
    return paramcc.field_talker;
  }
  
  private void c(dn paramdn)
  {
    paramdn.hDr.hDy = 45;
    paramdn.hDr.activity = ((Activity)this.mContext);
    paramdn.publish();
    if ((paramdn.hDs.ret == -2) || (paramdn.hDs.ret > 0)) {}
    while (paramdn.hDs.ret > 0) {
      return;
    }
    if (14 != paramdn.hDr.type)
    {
      Log.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
      return;
    }
    if (paramdn.hDr.hDu == null)
    {
      Log.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
      return;
    }
    h.OAn.b(11142, new Object[] { Integer.valueOf(paramdn.hDr.hDu.ZBI), Integer.valueOf(paramdn.hDr.hDu.PTe), Integer.valueOf(paramdn.hDr.hDu.ZBJ), Integer.valueOf(paramdn.hDr.hDu.AXs), Integer.valueOf(paramdn.hDr.hDu.ZBK), Integer.valueOf(paramdn.hDr.hDu.ZBL), Integer.valueOf(paramdn.hDr.hDu.ZBM), Integer.valueOf(paramdn.hDr.hDu.ZBN), Integer.valueOf(paramdn.hDr.hDu.ZBO), Integer.valueOf(paramdn.hDr.hDu.ZBP), Integer.valueOf(paramdn.hDr.hDu.ZBQ), Integer.valueOf(paramdn.hDr.hDu.ZBR), Integer.valueOf(paramdn.hDr.hDu.ZBS), Integer.valueOf(paramdn.hDr.hDu.ZBT), Integer.valueOf(paramdn.hDr.hDu.ZBU) });
  }
  
  private void dA(cc paramcc)
  {
    Object localObject = k.b.Hf(paramcc.field_content);
    if ((localObject != null) && (51 == ((k.b)localObject).type) && (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(this.mContext))) {
      return;
    }
    h.OAn.idkeyStat(219L, 19L, 1L, true);
    boolean bool = this.lMU.toLowerCase().endsWith("@chatroom");
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramcc);
    com.tencent.mm.ui.chatting.n.a(this.mContext, (List)localObject, bool, this.lMU, new com.tencent.mm.message.z()
    {
      public final void O(Bundle paramAnonymousBundle) {}
      
      public final void a(z.a paramAnonymousa) {}
      
      public final void b(z.a paramAnonymousa) {}
      
      public final boolean bws()
      {
        return true;
      }
      
      public final boolean bwt()
      {
        return false;
      }
      
      public final boolean bwu()
      {
        return false;
      }
      
      public final void c(z.a paramAnonymousa) {}
    });
  }
  
  private void dB(final cc paramcc)
  {
    h.OAn.b(11627, new Object[] { Integer.valueOf(5) });
    final TreeSet localTreeSet = new TreeSet();
    localTreeSet.add(Long.valueOf(paramcc.field_msgId));
    k.b(this.mContext, this.mContext.getString(R.l.gAv), "", this.mContext.getString(R.l.gEg), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(36477);
        Log.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        l.a(b.this.mContext, localTreeSet, new com.tencent.mm.message.z()
        {
          public final void O(Bundle paramAnonymous2Bundle) {}
          
          public final void a(z.a paramAnonymous2a) {}
          
          public final void b(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36475);
            if (paramAnonymous2a == z.a.nVu)
            {
              paramAnonymous2a = new c.b()
              {
                public final int getType()
                {
                  return -1;
                }
              };
              paramAnonymous2a.msgId = b.4.this.oiV.field_msgId;
              b.this.mDataList.remove(paramAnonymous2a);
              b.this.aeIB.remove(paramAnonymous2a);
            }
            AppMethodBeat.o(36475);
          }
          
          public final boolean bws()
          {
            return true;
          }
          
          public final boolean bwt()
          {
            return false;
          }
          
          public final boolean bwu()
          {
            return false;
          }
          
          public final void c(z.a paramAnonymous2a)
          {
            AppMethodBeat.i(36476);
            Log.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), paramAnonymous2a });
            if (paramAnonymous2a == z.a.nVu) {
              b.this.aeIA.bZE.notifyChanged();
            }
            AppMethodBeat.o(36476);
          }
        });
        AppMethodBeat.o(36477);
      }
    }, null);
  }
  
  private void dz(cc paramcc)
  {
    dn localdn = new dn();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramcc);
    if (com.tencent.mm.pluginsdk.model.n.a(this.mContext, localdn, this.lMU, localArrayList, false))
    {
      c(localdn);
      return;
    }
    Log.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
  }
  
  public final c.b aCa(int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.mDataList.get(paramInt);
  }
  
  public final RecyclerView.a bBf(String paramString)
  {
    this.lMU = paramString;
    this.aeIA = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.aens = juS();
    return this.aeIA;
  }
  
  public final void f(int paramInt, cc paramcc)
  {
    Log.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      dz(paramcc);
      return;
    case 0: 
      dA(paramcc);
      return;
    }
    dB(paramcc);
  }
  
  public final int getCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  public final RecyclerView.h juQ()
  {
    new RecyclerView.h()
    {
      int mSize;
      int pyf;
      ColorDrawable wQz;
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(254354);
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
            Object localObject = b.this.aCa(((Integer)paramAnonymouss.getTag()).intValue() + 1);
            if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
            {
              localObject = (RecyclerView.LayoutParams)paramAnonymouss.getLayoutParams();
              int i1 = paramAnonymouss.getBottom();
              i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
              int i2 = this.mSize;
              this.wQz.setBounds(j, i1, k - m, i2 + i1);
              this.wQz.draw(paramAnonymousCanvas);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(254354);
      }
    };
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a juT()
  {
    new com.tencent.mm.modelvoiceaddr.ui.b.a()
    {
      String aenu;
      private MTimerHandler lNo;
      
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(36473);
        if (!this.aenu.equals(paramAnonymousString))
        {
          this.aenu = paramAnonymousString;
          this.lNo.stopTimer();
          this.lNo.startTimer(500L);
        }
        AppMethodBeat.o(36473);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt) {}
      
      public final void bPQ() {}
      
      public final void bWw()
      {
        AppMethodBeat.i(36472);
        Log.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
        if (b.this.aeIz != null) {
          b.this.aeIz.onFinish();
        }
        AppMethodBeat.o(36472);
      }
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz()
      {
        AppMethodBeat.i(36474);
        Log.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
        AppMethodBeat.o(36474);
      }
    };
  }
  
  protected final boolean jvh()
  {
    long l1 = this.Jfc;
    long l2 = System.currentTimeMillis();
    this.Jfc = l2;
    if (l1 + 30000L < l2)
    {
      bh.bCz();
      this.wQm = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.wQm;
  }
  
  public final void onDetach()
  {
    this.aeIz.a(null);
    this.aeIz = null;
    if (this.aeIA != null)
    {
      com.tencent.mm.ui.chatting.a.c.aens = null;
      com.tencent.mm.ui.chatting.a.c.aent = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.presenter.b
 * JD-Core Version:    0.7.0.1
 */