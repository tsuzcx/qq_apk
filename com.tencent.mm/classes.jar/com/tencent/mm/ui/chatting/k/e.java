package com.tencent.mm.ui.chatting.k;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.f.a.a;
import com.tencent.mm.ui.chatting.f.a.b;
import com.tencent.mm.ui.chatting.gallery.d;
import com.tencent.mm.ui.chatting.gallery.h.a;
import com.tencent.mm.ui.chatting.gallery.h.b;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e
  implements e.a, t.a, a.a, h.b
{
  static int count = 0;
  private long KaB;
  private int Ksh;
  private a.b Ksl;
  com.tencent.mm.ui.chatting.a.b Ksm;
  private int Ksn;
  private boolean Kso;
  private String fVg;
  private Context mContext;
  private ArrayList<b.c> mDataList;
  private aq mHandler;
  private com.tencent.mm.sdk.b.c oZE;
  private GridLayoutManager oZF;
  boolean rLk;
  private int rLl;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(36516);
    this.mDataList = null;
    this.oZE = new com.tencent.mm.sdk.b.c() {};
    this.rLk = false;
    this.Ksn = 0;
    this.mHandler = new aq(Looper.getMainLooper());
    this.Kso = false;
    this.Ksh = 0;
    this.rLl = 0;
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
    AppMethodBeat.o(36516);
  }
  
  private void c(cw paramcw)
  {
    AppMethodBeat.i(36537);
    paramcw.doL.doR = 45;
    paramcw.doL.activity = ((Activity)this.mContext);
    com.tencent.mm.sdk.b.a.IvT.l(paramcw);
    if ((paramcw.doM.ret == -2) || (paramcw.doM.ret > 0))
    {
      AppMethodBeat.o(36537);
      return;
    }
    if (paramcw.doM.ret <= 0)
    {
      if (14 != paramcw.doL.type)
      {
        ae.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
        AppMethodBeat.o(36537);
        return;
      }
      if (paramcw.doL.doO == null)
      {
        ae.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
        AppMethodBeat.o(36537);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11142, new Object[] { Integer.valueOf(paramcw.doL.doO.GCt), Integer.valueOf(paramcw.doL.doO.GCu), Integer.valueOf(paramcw.doL.doO.GCv), Integer.valueOf(paramcw.doL.doO.tRD), Integer.valueOf(paramcw.doL.doO.GCw), Integer.valueOf(paramcw.doL.doO.GCx), Integer.valueOf(paramcw.doL.doO.GCy), Integer.valueOf(paramcw.doL.doO.fileCount), Integer.valueOf(paramcw.doL.doO.GCz), Integer.valueOf(paramcw.doL.doO.GCA), Integer.valueOf(paramcw.doL.doO.GCB), Integer.valueOf(paramcw.doL.doO.GCC), Integer.valueOf(paramcw.doL.doO.GCD), Integer.valueOf(paramcw.doL.doO.GCE), Integer.valueOf(paramcw.doL.doO.GCF) });
    }
    AppMethodBeat.o(36537);
  }
  
  private static String d(bv parambv, s params)
  {
    AppMethodBeat.i(36533);
    Object localObject;
    if (params.ixf == -1)
    {
      params = params.aNs();
      localObject = params;
      if (!com.tencent.mm.vfs.o.fB(params))
      {
        com.tencent.mm.modelvideo.o.aNh();
        localObject = com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath);
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(36533);
          return localObject;
          com.tencent.mm.modelvideo.o.aNh();
          str = com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath);
          localObject = str;
        } while (parambv.field_isSend != 1);
        localObject = str;
      } while (params.ixi == null);
      localObject = str;
    } while (!params.ixi.Hlb);
    for (;;)
    {
      try
      {
        params = com.tencent.mm.vfs.o.aZU(str);
        parambv = params;
        if (!params.endsWith("/")) {
          parambv = params + "/";
        }
        params = com.tencent.mm.vfs.o.aZW(str);
        parambv = parambv + params + "_hd.mp4";
        boolean bool = com.tencent.mm.vfs.o.fB(parambv);
        ae.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", new Object[] { parambv, Boolean.valueOf(bool) });
        if (!bool) {
          break label228;
        }
        localObject = parambv;
      }
      catch (Exception parambv)
      {
        ae.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", new Object[] { parambv.getMessage() });
        localObject = str;
      }
      break;
      label228:
      parambv = str;
    }
  }
  
  private boolean fLl()
  {
    return this.Ksn == 0;
  }
  
  private static void it(List<bv> paramList)
  {
    AppMethodBeat.i(36536);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bv localbv = (bv)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.JRS, a.d.JRX, localbv, 0);
    }
    AppMethodBeat.o(36536);
  }
  
  public final void Ev(int paramInt)
  {
    AppMethodBeat.i(36522);
    ae.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    final ArrayList localArrayList = h.a.fKb().rKI;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36522);
      return;
      p.a(this.mContext, new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(187630);
          final List localList = e.iu(localArrayList);
          if (localList.size() != localArrayList.size())
          {
            com.tencent.mm.ui.base.h.a(e.b(e.this), 2131759799, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(187629);
                if (localList.size() == 0)
                {
                  ae.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSave size = 0");
                  e.c(e.this).fJG();
                  AppMethodBeat.o(187629);
                  return;
                }
                e.a(e.this, localList);
                AppMethodBeat.o(187629);
              }
            }, null);
            AppMethodBeat.o(187630);
            return;
          }
          e.a(e.this, localList);
          AppMethodBeat.o(187630);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36498);
          Toast.makeText(e.b(e.this), e.b(e.this).getString(2131762780), 1).show();
          AppMethodBeat.o(36498);
        }
      });
      AppMethodBeat.o(36522);
      return;
      Object localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (!ac.bn((bv)((Iterator)localObject1).next()))
        {
          com.tencent.mm.ui.base.t.makeText(this.mContext, 2131758894, 0).show();
          AppMethodBeat.o(36522);
          return;
        }
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 18L, 1L, true);
      final cw localcw = new cw();
      if (com.tencent.mm.pluginsdk.model.i.a(this.mContext, localcw, this.fVg, localArrayList, false))
      {
        c(localcw);
        it(localArrayList);
      }
      for (;;)
      {
        this.Ksl.cyF();
        AppMethodBeat.o(36522);
        return;
        if (localArrayList.size() > 1)
        {
          Context localContext = this.mContext;
          if (localcw.doL.doQ >= 0)
          {
            localObject1 = this.mContext.getString(2131758899);
            label264:
            if (localcw.doL.doQ < 0) {
              break label339;
            }
          }
          label339:
          for (localObject2 = this.mContext.getString(2131757560);; localObject2 = this.mContext.getString(2131761941))
          {
            com.tencent.mm.ui.base.h.e(localContext, (String)localObject1, "", (String)localObject2, this.mContext.getString(2131757558), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(36505);
                if ((localcw.doL.type == 14) && (localcw.doL.doN.oeJ.size() == 0))
                {
                  AppMethodBeat.o(36505);
                  return;
                }
                e.a(e.this, localcw);
                e.iw(localArrayList);
                AppMethodBeat.o(36505);
              }
            }, null);
            break;
            localObject1 = this.mContext.getString(2131758898);
            break label264;
          }
        }
        com.tencent.mm.ui.base.h.l(this.mContext, localcw.doL.doQ, 0);
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 19L, 1L, true);
      boolean bool = x.wb(this.fVg);
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
      this.Ksl.cyF();
      AppMethodBeat.o(36522);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.f(11627, new Object[] { Integer.valueOf(5) });
      localObject1 = new TreeSet();
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Set)localObject1).add(Long.valueOf(((bv)((Iterator)localObject2).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.e(this.mContext, this.mContext.getString(2131757553), "", this.mContext.getString(2131758038), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187626);
          ae.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
          j.a(e.b(e.this), this.KlP, new z()
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
              AppMethodBeat.i(187624);
              if (paramAnonymous2a == z.a.hGK) {
                e.a(e.this).removeAll(e.6.this.gww);
              }
              AppMethodBeat.o(187624);
            }
            
            public final void c(z.a paramAnonymous2a)
            {
              AppMethodBeat.i(187625);
              ae.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", new Object[] { Thread.currentThread(), Integer.valueOf(e.6.this.gww.size()), paramAnonymous2a });
              if ((paramAnonymous2a == z.a.hGK) && (e.c(e.this) != null)) {
                e.c(e.this).cyF();
              }
              AppMethodBeat.o(187625);
            }
            
            public final void v(Bundle paramAnonymous2Bundle) {}
          });
          AppMethodBeat.o(187626);
        }
      }, null);
    }
  }
  
  public final void F(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(36538);
    if ((!paramBoolean) && (this.rLl + this.Ksh == this.mDataList.size()))
    {
      ae.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", new Object[] { Integer.valueOf(this.rLl), Integer.valueOf(paramInt) });
      AppMethodBeat.o(36538);
      return;
    }
    this.Ksm.oZt = true;
    this.Ksl.jC(paramBoolean);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 33
        //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 25	com/tencent/mm/ui/chatting/k/e$8:oZA	Z
        //   9: ifeq +48 -> 57
        //   12: aload_0
        //   13: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   16: invokestatic 42	com/tencent/mm/ui/chatting/k/e:i	(Lcom/tencent/mm/ui/chatting/k/e;)J
        //   19: ldc2_w 43
        //   22: lcmp
        //   23: ifne +181 -> 204
        //   26: aload_0
        //   27: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   30: astore 7
        //   32: invokestatic 50	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
        //   35: pop
        //   36: aload 7
        //   38: invokestatic 56	com/tencent/mm/model/c:azI	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   41: aload_0
        //   42: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   45: invokestatic 60	com/tencent/mm/ui/chatting/k/e:j	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/lang/String;
        //   48: invokeinterface 66 2 0
        //   53: invokestatic 70	com/tencent/mm/ui/chatting/k/e:b	(Lcom/tencent/mm/ui/chatting/k/e;I)I
        //   56: pop
        //   57: aload_0
        //   58: getfield 27	com/tencent/mm/ui/chatting/k/e$8:hXr	I
        //   61: iflt +182 -> 243
        //   64: aload_0
        //   65: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   68: invokestatic 74	com/tencent/mm/ui/chatting/k/e:k	(Lcom/tencent/mm/ui/chatting/k/e;)I
        //   71: aload_0
        //   72: getfield 27	com/tencent/mm/ui/chatting/k/e$8:hXr	I
        //   75: isub
        //   76: sipush 200
        //   79: if_icmple +164 -> 243
        //   82: aload_0
        //   83: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   86: invokestatic 74	com/tencent/mm/ui/chatting/k/e:k	(Lcom/tencent/mm/ui/chatting/k/e;)I
        //   89: aload_0
        //   90: getfield 27	com/tencent/mm/ui/chatting/k/e$8:hXr	I
        //   93: isub
        //   94: istore_1
        //   95: ldc 76
        //   97: ldc 78
        //   99: iconst_2
        //   100: anewarray 4	java/lang/Object
        //   103: dup
        //   104: iconst_0
        //   105: aload_0
        //   106: getfield 27	com/tencent/mm/ui/chatting/k/e$8:hXr	I
        //   109: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   112: aastore
        //   113: dup
        //   114: iconst_1
        //   115: iload_1
        //   116: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   119: aastore
        //   120: invokestatic 89	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   123: new 91	java/util/LinkedList
        //   126: dup
        //   127: invokespecial 92	java/util/LinkedList:<init>	()V
        //   130: astore 8
        //   132: aload_0
        //   133: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   136: invokestatic 42	com/tencent/mm/ui/chatting/k/e:i	(Lcom/tencent/mm/ui/chatting/k/e;)J
        //   139: ldc2_w 43
        //   142: lcmp
        //   143: ifne +107 -> 250
        //   146: invokestatic 50	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
        //   149: pop
        //   150: invokestatic 56	com/tencent/mm/model/c:azI	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   153: aload_0
        //   154: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   157: invokestatic 60	com/tencent/mm/ui/chatting/k/e:j	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/lang/String;
        //   160: aload_0
        //   161: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   164: invokestatic 96	com/tencent/mm/ui/chatting/k/e:a	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/util/ArrayList;
        //   167: invokevirtual 102	java/util/ArrayList:size	()I
        //   170: aload_0
        //   171: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   174: invokestatic 105	com/tencent/mm/ui/chatting/k/e:l	(Lcom/tencent/mm/ui/chatting/k/e;)I
        //   177: isub
        //   178: iload_1
        //   179: invokeinterface 109 4 0
        //   184: astore 7
        //   186: aload 7
        //   188: ifnonnull +110 -> 298
        //   191: ldc 76
        //   193: ldc 111
        //   195: invokestatic 115	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   198: ldc 33
        //   200: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   203: return
        //   204: aload_0
        //   205: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   208: astore 7
        //   210: invokestatic 50	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
        //   213: pop
        //   214: aload 7
        //   216: invokestatic 122	com/tencent/mm/model/c:azJ	()Lcom/tencent/mm/storage/r;
        //   219: aload_0
        //   220: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   223: invokestatic 60	com/tencent/mm/ui/chatting/k/e:j	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/lang/String;
        //   226: aload_0
        //   227: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   230: invokestatic 42	com/tencent/mm/ui/chatting/k/e:i	(Lcom/tencent/mm/ui/chatting/k/e;)J
        //   233: invokevirtual 128	com/tencent/mm/storage/r:ch	(Ljava/lang/String;J)I
        //   236: invokestatic 70	com/tencent/mm/ui/chatting/k/e:b	(Lcom/tencent/mm/ui/chatting/k/e;I)I
        //   239: pop
        //   240: goto -183 -> 57
        //   243: sipush 200
        //   246: istore_1
        //   247: goto -152 -> 95
        //   250: invokestatic 50	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
        //   253: pop
        //   254: invokestatic 122	com/tencent/mm/model/c:azJ	()Lcom/tencent/mm/storage/r;
        //   257: aload_0
        //   258: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   261: invokestatic 60	com/tencent/mm/ui/chatting/k/e:j	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/lang/String;
        //   264: aload_0
        //   265: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   268: invokestatic 42	com/tencent/mm/ui/chatting/k/e:i	(Lcom/tencent/mm/ui/chatting/k/e;)J
        //   271: aload_0
        //   272: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   275: invokestatic 96	com/tencent/mm/ui/chatting/k/e:a	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/util/ArrayList;
        //   278: invokevirtual 102	java/util/ArrayList:size	()I
        //   281: aload_0
        //   282: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   285: invokestatic 105	com/tencent/mm/ui/chatting/k/e:l	(Lcom/tencent/mm/ui/chatting/k/e;)I
        //   288: isub
        //   289: iload_1
        //   290: invokevirtual 131	com/tencent/mm/storage/r:b	(Ljava/lang/String;JII)Landroid/database/Cursor;
        //   293: astore 7
        //   295: goto -109 -> 186
        //   298: lconst_0
        //   299: lstore_3
        //   300: aload 7
        //   302: invokeinterface 137 1 0
        //   307: ifeq +97 -> 404
        //   310: new 139	com/tencent/mm/storage/bv
        //   313: dup
        //   314: invokespecial 140	com/tencent/mm/storage/bv:<init>	()V
        //   317: astore 9
        //   319: aload 9
        //   321: aload 7
        //   323: invokevirtual 144	com/tencent/mm/storage/bv:convertFrom	(Landroid/database/Cursor;)V
        //   326: new 146	java/util/Date
        //   329: dup
        //   330: aload 9
        //   332: getfield 152	com/tencent/mm/g/c/ei:field_createTime	J
        //   335: invokespecial 155	java/util/Date:<init>	(J)V
        //   338: astore 10
        //   340: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:fNX	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   343: aload 10
        //   345: invokevirtual 164	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   348: lstore 5
        //   350: lload_3
        //   351: lload 5
        //   353: lcmp
        //   354: ifeq +29 -> 383
        //   357: aload 8
        //   359: new 166	com/tencent/mm/ui/chatting/a/b$c
        //   362: dup
        //   363: aload 9
        //   365: getfield 152	com/tencent/mm/g/c/ei:field_createTime	J
        //   368: invokespecial 167	com/tencent/mm/ui/chatting/a/b$c:<init>	(J)V
        //   371: invokevirtual 171	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   374: pop
        //   375: aload_0
        //   376: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   379: invokestatic 174	com/tencent/mm/ui/chatting/k/e:m	(Lcom/tencent/mm/ui/chatting/k/e;)I
        //   382: pop
        //   383: aload 8
        //   385: new 166	com/tencent/mm/ui/chatting/a/b$c
        //   388: dup
        //   389: aload 9
        //   391: invokespecial 177	com/tencent/mm/ui/chatting/a/b$c:<init>	(Lcom/tencent/mm/storage/bv;)V
        //   394: invokevirtual 171	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   397: pop
        //   398: lload 5
        //   400: lstore_3
        //   401: goto -101 -> 300
        //   404: aload 7
        //   406: invokeinterface 180 1 0
        //   411: new 91	java/util/LinkedList
        //   414: dup
        //   415: invokespecial 92	java/util/LinkedList:<init>	()V
        //   418: astore 9
        //   420: aload 8
        //   422: invokevirtual 181	java/util/LinkedList:size	()I
        //   425: aload_0
        //   426: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   429: invokestatic 105	com/tencent/mm/ui/chatting/k/e:l	(Lcom/tencent/mm/ui/chatting/k/e;)I
        //   432: isub
        //   433: iload_1
        //   434: if_icmpne +335 -> 769
        //   437: aload 8
        //   439: iconst_0
        //   440: invokevirtual 185	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   443: checkcast 166	com/tencent/mm/ui/chatting/a/b$c
        //   446: getfield 188	com/tencent/mm/ui/chatting/a/b$c:timeStamp	J
        //   449: lstore_3
        //   450: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:fNX	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   453: pop
        //   454: lload_3
        //   455: invokestatic 192	com/tencent/mm/ui/gridviewheaders/a:ES	(J)J
        //   458: lstore 5
        //   460: ldc 76
        //   462: ldc 194
        //   464: iconst_3
        //   465: anewarray 4	java/lang/Object
        //   468: dup
        //   469: iconst_0
        //   470: aload 8
        //   472: invokevirtual 181	java/util/LinkedList:size	()I
        //   475: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   478: aastore
        //   479: dup
        //   480: iconst_1
        //   481: lload 5
        //   483: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   486: aastore
        //   487: dup
        //   488: iconst_2
        //   489: lload_3
        //   490: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   493: aastore
        //   494: invokestatic 89	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   497: aload_0
        //   498: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   501: invokestatic 42	com/tencent/mm/ui/chatting/k/e:i	(Lcom/tencent/mm/ui/chatting/k/e;)J
        //   504: ldc2_w 43
        //   507: lcmp
        //   508: ifne +186 -> 694
        //   511: invokestatic 50	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
        //   514: pop
        //   515: invokestatic 56	com/tencent/mm/model/c:azI	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   518: aload_0
        //   519: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   522: invokestatic 60	com/tencent/mm/ui/chatting/k/e:j	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/lang/String;
        //   525: lload 5
        //   527: lload_3
        //   528: invokeinterface 203 6 0
        //   533: astore 7
        //   535: new 146	java/util/Date
        //   538: dup
        //   539: lload_3
        //   540: invokespecial 155	java/util/Date:<init>	(J)V
        //   543: astore 10
        //   545: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:fNX	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   548: aload 10
        //   550: invokevirtual 164	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   553: lstore_3
        //   554: aload 7
        //   556: ifnull +201 -> 757
        //   559: aload 7
        //   561: invokeinterface 137 1 0
        //   566: ifeq +191 -> 757
        //   569: new 139	com/tencent/mm/storage/bv
        //   572: dup
        //   573: invokespecial 140	com/tencent/mm/storage/bv:<init>	()V
        //   576: astore 11
        //   578: aload 11
        //   580: aload 7
        //   582: invokevirtual 144	com/tencent/mm/storage/bv:convertFrom	(Landroid/database/Cursor;)V
        //   585: new 146	java/util/Date
        //   588: dup
        //   589: aload 11
        //   591: getfield 152	com/tencent/mm/g/c/ei:field_createTime	J
        //   594: invokespecial 155	java/util/Date:<init>	(J)V
        //   597: astore 12
        //   599: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:fNX	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   602: aload 12
        //   604: invokevirtual 164	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   607: lstore 5
        //   609: lload_3
        //   610: lload 5
        //   612: lcmp
        //   613: ifeq +113 -> 726
        //   616: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:fNX	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   619: aload 10
        //   621: invokevirtual 164	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   624: lload 5
        //   626: lcmp
        //   627: ifeq +99 -> 726
        //   630: aload 9
        //   632: new 166	com/tencent/mm/ui/chatting/a/b$c
        //   635: dup
        //   636: aload 11
        //   638: getfield 152	com/tencent/mm/g/c/ei:field_createTime	J
        //   641: invokespecial 167	com/tencent/mm/ui/chatting/a/b$c:<init>	(J)V
        //   644: invokevirtual 171	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   647: pop
        //   648: aload_0
        //   649: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   652: invokestatic 174	com/tencent/mm/ui/chatting/k/e:m	(Lcom/tencent/mm/ui/chatting/k/e;)I
        //   655: pop
        //   656: lload 5
        //   658: lstore_3
        //   659: aload 9
        //   661: new 166	com/tencent/mm/ui/chatting/a/b$c
        //   664: dup
        //   665: aload 11
        //   667: invokespecial 177	com/tencent/mm/ui/chatting/a/b$c:<init>	(Lcom/tencent/mm/storage/bv;)V
        //   670: invokevirtual 171	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   673: pop
        //   674: goto -120 -> 554
        //   677: astore 8
        //   679: aload 7
        //   681: invokeinterface 180 1 0
        //   686: ldc 33
        //   688: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   691: aload 8
        //   693: athrow
        //   694: invokestatic 50	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
        //   697: pop
        //   698: invokestatic 122	com/tencent/mm/model/c:azJ	()Lcom/tencent/mm/storage/r;
        //   701: aload_0
        //   702: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   705: invokestatic 60	com/tencent/mm/ui/chatting/k/e:j	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/lang/String;
        //   708: aload_0
        //   709: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   712: invokestatic 42	com/tencent/mm/ui/chatting/k/e:i	(Lcom/tencent/mm/ui/chatting/k/e;)J
        //   715: lload 5
        //   717: lload_3
        //   718: invokevirtual 207	com/tencent/mm/storage/r:d	(Ljava/lang/String;JJJ)Landroid/database/Cursor;
        //   721: astore 7
        //   723: goto -188 -> 535
        //   726: aload 8
        //   728: invokevirtual 181	java/util/LinkedList:size	()I
        //   731: ifle +23 -> 754
        //   734: aload 9
        //   736: invokevirtual 181	java/util/LinkedList:size	()I
        //   739: ifne +15 -> 754
        //   742: aload 9
        //   744: iconst_0
        //   745: aload 8
        //   747: iconst_0
        //   748: invokevirtual 210	java/util/LinkedList:remove	(I)Ljava/lang/Object;
        //   751: invokevirtual 213	java/util/LinkedList:add	(ILjava/lang/Object;)V
        //   754: goto -95 -> 659
        //   757: aload 7
        //   759: ifnull +10 -> 769
        //   762: aload 7
        //   764: invokeinterface 180 1 0
        //   769: aload 8
        //   771: invokevirtual 181	java/util/LinkedList:size	()I
        //   774: istore_1
        //   775: aload 9
        //   777: invokevirtual 181	java/util/LinkedList:size	()I
        //   780: istore_2
        //   781: aload_0
        //   782: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   785: invokestatic 96	com/tencent/mm/ui/chatting/k/e:a	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/util/ArrayList;
        //   788: iconst_0
        //   789: aload 9
        //   791: invokevirtual 217	java/util/ArrayList:addAll	(ILjava/util/Collection;)Z
        //   794: pop
        //   795: aload_0
        //   796: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   799: invokestatic 96	com/tencent/mm/ui/chatting/k/e:a	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/util/ArrayList;
        //   802: aload 9
        //   804: invokevirtual 181	java/util/LinkedList:size	()I
        //   807: aload 8
        //   809: invokevirtual 217	java/util/ArrayList:addAll	(ILjava/util/Collection;)Z
        //   812: pop
        //   813: aload 8
        //   815: invokevirtual 220	java/util/LinkedList:clear	()V
        //   818: aload 9
        //   820: invokevirtual 220	java/util/LinkedList:clear	()V
        //   823: aload_0
        //   824: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   827: invokestatic 223	com/tencent/mm/ui/chatting/k/e:n	(Lcom/tencent/mm/ui/chatting/k/e;)I
        //   830: pop
        //   831: ldc 76
        //   833: ldc 225
        //   835: iconst_1
        //   836: anewarray 4	java/lang/Object
        //   839: dup
        //   840: iconst_0
        //   841: aload_0
        //   842: getfield 23	com/tencent/mm/ui/chatting/k/e$8:Ksp	Lcom/tencent/mm/ui/chatting/k/e;
        //   845: invokestatic 96	com/tencent/mm/ui/chatting/k/e:a	(Lcom/tencent/mm/ui/chatting/k/e;)Ljava/util/ArrayList;
        //   848: invokevirtual 102	java/util/ArrayList:size	()I
        //   851: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   854: aastore
        //   855: invokestatic 89	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   858: new 13	com/tencent/mm/ui/chatting/k/e$8$1
        //   861: dup
        //   862: aload_0
        //   863: iload_1
        //   864: iload_2
        //   865: iadd
        //   866: invokespecial 228	com/tencent/mm/ui/chatting/k/e$8$1:<init>	(Lcom/tencent/mm/ui/chatting/k/e$8;I)V
        //   869: invokestatic 234	com/tencent/mm/sdk/platformtools/ar:f	(Ljava/lang/Runnable;)V
        //   872: ldc 33
        //   874: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   877: return
        //   878: astore 8
        //   880: aload 7
        //   882: ifnull +10 -> 892
        //   885: aload 7
        //   887: invokeinterface 180 1 0
        //   892: ldc 33
        //   894: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   897: aload 8
        //   899: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	900	0	this	8
        //   94	772	1	i	int
        //   780	86	2	j	int
        //   299	419	3	l1	long
        //   348	368	5	l2	long
        //   30	856	7	localObject1	Object
        //   130	341	8	localLinkedList	LinkedList
        //   677	137	8	localCollection	java.util.Collection
        //   878	20	8	localObject2	Object
        //   317	502	9	localObject3	Object
        //   338	282	10	localDate1	java.util.Date
        //   576	90	11	localbv	bv
        //   597	6	12	localDate2	java.util.Date
        // Exception table:
        //   from	to	target	type
        //   300	350	677	finally
        //   357	383	677	finally
        //   383	398	677	finally
        //   559	609	878	finally
        //   616	656	878	finally
        //   659	674	878	finally
        //   726	754	878	finally
      }
    });
    AppMethodBeat.o(36538);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn)
  {
    AppMethodBeat.i(36528);
    ae.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(36528);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(36529);
    ae.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Integer.valueOf(this.Ksn), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
    if (!this.Ksl.fJJ())
    {
      AppMethodBeat.o(36529);
      return;
    }
    this.Ksn -= 1;
    bc.aCg();
    paramObject = com.tencent.mm.model.c.azI().ys(paramLong2);
    if (!com.tencent.mm.ui.chatting.gallery.b.d(this.mContext, paramObject, false)) {
      this.Kso = true;
    }
    if (fLl())
    {
      if (!this.Kso)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36511);
            if (e.c(e.this) != null) {
              e.c(e.this).fJI();
            }
            AppMethodBeat.o(36511);
          }
        });
        AppMethodBeat.o(36529);
        return;
      }
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36512);
          if (e.c(e.this) != null) {
            e.c(e.this).aea(2131759813);
          }
          AppMethodBeat.o(36512);
        }
      });
    }
    AppMethodBeat.o(36529);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36531);
    if ((this.Ksl == null) || (!this.Ksl.fJJ()))
    {
      AppMethodBeat.o(36531);
      return;
    }
    s locals = u.Ia(parama.fileName);
    ae.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", new Object[] { Integer.valueOf(this.Ksn), parama.ixt, parama.fileName });
    if (locals != null) {
      if (locals.aNw())
      {
        this.Ksn -= 1;
        bc.aCg();
        parama = com.tencent.mm.model.c.azI().ys(locals.iwZ);
        com.tencent.mm.ui.chatting.gallery.b.b(this.mContext, parama, false);
      }
    }
    while (fLl()) {
      if (this.Kso)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36513);
            if (e.c(e.this) != null) {
              e.c(e.this).aea(2131759813);
            }
            AppMethodBeat.o(36513);
          }
        });
        AppMethodBeat.o(36531);
        return;
        ae.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
        fJG();
        this.Ksl.aea(0);
      }
      else
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36514);
            if (e.c(e.this) != null) {
              e.c(e.this).fJI();
            }
            AppMethodBeat.o(36514);
          }
        });
      }
    }
    AppMethodBeat.o(36531);
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(36521);
    String str = this.mContext.getString(2131755259);
    AppMethodBeat.o(36521);
    return str;
  }
  
  public final <T extends RecyclerView.i> T caQ()
  {
    AppMethodBeat.i(36518);
    if (this.oZF == null)
    {
      this.oZF = new GridLayoutManager(4);
      this.oZF.apF = new GridLayoutManager.b()
      {
        public final int bW(int paramAnonymousInt)
        {
          AppMethodBeat.i(36493);
          if (((b.c)e.a(e.this).get(paramAnonymousInt)).type == 2147483647)
          {
            AppMethodBeat.o(36493);
            return 4;
          }
          AppMethodBeat.o(36493);
          return 1;
        }
      };
    }
    GridLayoutManager localGridLayoutManager = this.oZF;
    AppMethodBeat.o(36518);
    return localGridLayoutManager;
  }
  
  public final void clear() {}
  
  public final RecyclerView.a cm(String paramString, long paramLong)
  {
    AppMethodBeat.i(36520);
    this.fVg = paramString;
    this.KaB = paramLong;
    if (paramLong == -1L) {}
    for (this.Ksm = new com.tencent.mm.ui.chatting.a.b(this.mContext, this.mDataList, paramString);; this.Ksm = new com.tencent.mm.ui.chatting.a.b(this.mContext, this.mDataList, paramString, paramLong))
    {
      this.Ksm.KaC = new b.b()
      {
        public final void a(boolean paramAnonymousBoolean, b.c paramAnonymousc, int paramAnonymousInt)
        {
          AppMethodBeat.i(36510);
          ae.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
          if ((paramAnonymousBoolean) && (h.a.fKb().rKI.size() >= 9))
          {
            Toast.makeText(e.b(e.this), e.b(e.this).getResources().getString(2131759803, new Object[] { Integer.valueOf(9) }), 1).show();
            e.this.Ksm.cj(paramAnonymousInt);
            AppMethodBeat.o(36510);
            return;
          }
          if (paramAnonymousBoolean) {
            h.a.fKb().cm(paramAnonymousc.dCi);
          }
          for (;;)
          {
            e.c(e.this).Et(h.a.fKb().rKI.size());
            AppMethodBeat.o(36510);
            return;
            h.a.fKb().cn(paramAnonymousc.dCi);
          }
        }
      };
      paramString = this.Ksm;
      AppMethodBeat.o(36520);
      return paramString;
    }
  }
  
  public final boolean cyD()
  {
    AppMethodBeat.i(36526);
    boolean bool = h.a.fKb().rKJ;
    AppMethodBeat.o(36526);
    return bool;
  }
  
  public final void cyE()
  {
    AppMethodBeat.i(36524);
    this.Ksm.rKP = true;
    h.a.fKb().rKJ = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)caQ();
    int i = localGridLayoutManager.km();
    int j = localGridLayoutManager.ko();
    this.Ksm.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(36524);
  }
  
  public final void cyF()
  {
    AppMethodBeat.i(36525);
    this.Ksm.rKP = false;
    h.a.fKb().clear();
    h.a.fKb().rKJ = false;
    this.Ksm.asY.notifyChanged();
    AppMethodBeat.o(36525);
  }
  
  public final RecyclerView.h eO(final Context paramContext)
  {
    AppMethodBeat.i(36519);
    paramContext = new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
      {
        AppMethodBeat.i(36508);
        int i = (int)paramContext.getResources().getDimension(2131165519);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
        AppMethodBeat.o(36508);
      }
    };
    AppMethodBeat.o(36519);
    return paramContext;
  }
  
  public final int fJF()
  {
    AppMethodBeat.i(36523);
    int i = h.a.fKb().rKI.size();
    AppMethodBeat.o(36523);
    return i;
  }
  
  public final void fJG()
  {
    AppMethodBeat.i(36530);
    q.aIY().a(this);
    com.tencent.mm.modelvideo.o.aNh().a(this);
    this.Ksl.fJG();
    AppMethodBeat.o(36530);
  }
  
  public final void fJY()
  {
    this.rLk = true;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(36517);
    this.oZE.dead();
    this.Ksl.a(null);
    this.Ksl = null;
    q.aIY().a(this);
    com.tencent.mm.modelvideo.o.aNh().a(this);
    h.a.fKb().detach();
    l.fFq();
    AppMethodBeat.o(36517);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(36527);
    if ((this.rLk) && (h.a.fKb().rKJ))
    {
      this.Ksl.Et(h.a.fKb().rKI.size());
      this.Ksm.asY.notifyChanged();
    }
    AppMethodBeat.o(36527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.e
 * JD-Core Version:    0.7.0.1
 */