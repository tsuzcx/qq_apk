package com.tencent.mm.ui.chatting.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.z.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.e.a.a;
import com.tencent.mm.ui.chatting.e.a.b;
import com.tencent.mm.ui.chatting.gallery.j;
import com.tencent.mm.ui.chatting.gallery.n.b;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e
  implements f.a, aa.a, a.a, n.b
{
  static int count = 0;
  boolean AnX;
  private int AnY;
  private int aeIH;
  private a.b aeIL;
  b aeIM;
  private int aeIN;
  private boolean aeIO;
  private long aenl;
  private String lMU;
  private Context mContext;
  private ArrayList<b.c> mDataList;
  private MMHandler mHandler;
  private IListener wQB;
  private GridLayoutManager wQC;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(36516);
    this.mDataList = null;
    this.wQB = new MediaHistoryGalleryPresenter.3(this, com.tencent.mm.app.f.hfK);
    this.AnX = false;
    this.aeIN = 0;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.aeIO = false;
    this.aeIH = 0;
    this.AnY = 0;
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
    AppMethodBeat.o(36516);
  }
  
  private void c(dn paramdn)
  {
    AppMethodBeat.i(36537);
    paramdn.hDr.hDy = 45;
    paramdn.hDr.activity = ((Activity)this.mContext);
    paramdn.publish();
    if ((paramdn.hDs.ret == -2) || (paramdn.hDs.ret > 0))
    {
      AppMethodBeat.o(36537);
      return;
    }
    if (paramdn.hDs.ret <= 0)
    {
      if (14 != paramdn.hDr.type)
      {
        Log.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
        AppMethodBeat.o(36537);
        return;
      }
      if (paramdn.hDr.hDu == null)
      {
        Log.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
        AppMethodBeat.o(36537);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11142, new Object[] { Integer.valueOf(paramdn.hDr.hDu.ZBI), Integer.valueOf(paramdn.hDr.hDu.PTe), Integer.valueOf(paramdn.hDr.hDu.ZBJ), Integer.valueOf(paramdn.hDr.hDu.AXs), Integer.valueOf(paramdn.hDr.hDu.ZBK), Integer.valueOf(paramdn.hDr.hDu.ZBL), Integer.valueOf(paramdn.hDr.hDu.ZBM), Integer.valueOf(paramdn.hDr.hDu.ZBN), Integer.valueOf(paramdn.hDr.hDu.ZBO), Integer.valueOf(paramdn.hDr.hDu.ZBP), Integer.valueOf(paramdn.hDr.hDu.ZBQ), Integer.valueOf(paramdn.hDr.hDu.ZBR), Integer.valueOf(paramdn.hDr.hDu.ZBS), Integer.valueOf(paramdn.hDr.hDu.ZBT), Integer.valueOf(paramdn.hDr.hDu.ZBU) });
    }
    AppMethodBeat.o(36537);
  }
  
  private static String f(cc paramcc, com.tencent.mm.modelvideo.z paramz)
  {
    AppMethodBeat.i(36533);
    Object localObject;
    if (paramz.pbi == -1)
    {
      paramz = paramz.bOt();
      localObject = paramz;
      if (!y.ZC(paramz))
      {
        v.bOh();
        localObject = com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath);
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
          v.bOh();
          str = com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath);
          localObject = str;
        } while (paramcc.field_isSend != 1);
        localObject = str;
      } while (paramz.pbl == null);
      localObject = str;
    } while (!paramz.pbl.aaSg);
    for (;;)
    {
      try
      {
        paramz = y.bEo(str);
        paramcc = paramz;
        if (!paramz.endsWith("/")) {
          paramcc = paramz + "/";
        }
        paramz = y.bEq(str);
        paramcc = paramcc + paramz + "_hd.mp4";
        boolean bool = y.ZC(paramcc);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", new Object[] { paramcc, Boolean.valueOf(bool) });
        if (!bool) {
          break label228;
        }
        localObject = paramcc;
      }
      catch (Exception paramcc)
      {
        Log.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", new Object[] { paramcc.getMessage() });
        localObject = str;
      }
      break;
      label228:
      paramcc = str;
    }
  }
  
  private boolean jwN()
  {
    return this.aeIN == 0;
  }
  
  private static void nE(List<cc> paramList)
  {
    AppMethodBeat.i(36536);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cc localcc = (cc)paramList.next();
      a.a(a.c.aedy, a.d.aedD, localcc, 0);
    }
    AppMethodBeat.o(36536);
  }
  
  public final void I(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(36538);
    if ((!paramBoolean) && (this.AnY + this.aeIH == this.mDataList.size()))
    {
      Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", new Object[] { Integer.valueOf(this.AnY), Integer.valueOf(paramInt) });
      AppMethodBeat.o(36538);
      return;
    }
    this.aeIM.wQp = true;
    this.aeIL.nm(paramBoolean);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 32
        //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 24	com/tencent/mm/ui/chatting/presenter/e$8:wQx	Z
        //   9: ifeq +48 -> 57
        //   12: aload_0
        //   13: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   16: invokestatic 41	com/tencent/mm/ui/chatting/presenter/e:i	(Lcom/tencent/mm/ui/chatting/presenter/e;)J
        //   19: ldc2_w 42
        //   22: lcmp
        //   23: ifne +181 -> 204
        //   26: aload_0
        //   27: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   30: astore 6
        //   32: invokestatic 49	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
        //   35: pop
        //   36: aload 6
        //   38: invokestatic 55	com/tencent/mm/model/c:bzD	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   41: aload_0
        //   42: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   45: invokestatic 59	com/tencent/mm/ui/chatting/presenter/e:j	(Lcom/tencent/mm/ui/chatting/presenter/e;)Ljava/lang/String;
        //   48: invokeinterface 65 2 0
        //   53: invokestatic 69	com/tencent/mm/ui/chatting/presenter/e:b	(Lcom/tencent/mm/ui/chatting/presenter/e;I)I
        //   56: pop
        //   57: aload_0
        //   58: getfield 26	com/tencent/mm/ui/chatting/presenter/e$8:oBg	I
        //   61: iflt +182 -> 243
        //   64: aload_0
        //   65: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   68: invokestatic 73	com/tencent/mm/ui/chatting/presenter/e:k	(Lcom/tencent/mm/ui/chatting/presenter/e;)I
        //   71: aload_0
        //   72: getfield 26	com/tencent/mm/ui/chatting/presenter/e$8:oBg	I
        //   75: isub
        //   76: sipush 200
        //   79: if_icmple +164 -> 243
        //   82: aload_0
        //   83: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   86: invokestatic 73	com/tencent/mm/ui/chatting/presenter/e:k	(Lcom/tencent/mm/ui/chatting/presenter/e;)I
        //   89: aload_0
        //   90: getfield 26	com/tencent/mm/ui/chatting/presenter/e$8:oBg	I
        //   93: isub
        //   94: istore_1
        //   95: ldc 75
        //   97: ldc 77
        //   99: iconst_2
        //   100: anewarray 4	java/lang/Object
        //   103: dup
        //   104: iconst_0
        //   105: aload_0
        //   106: getfield 26	com/tencent/mm/ui/chatting/presenter/e$8:oBg	I
        //   109: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   112: aastore
        //   113: dup
        //   114: iconst_1
        //   115: iload_1
        //   116: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   119: aastore
        //   120: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   123: new 90	java/util/LinkedList
        //   126: dup
        //   127: invokespecial 91	java/util/LinkedList:<init>	()V
        //   130: astore 7
        //   132: aload_0
        //   133: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   136: invokestatic 41	com/tencent/mm/ui/chatting/presenter/e:i	(Lcom/tencent/mm/ui/chatting/presenter/e;)J
        //   139: ldc2_w 42
        //   142: lcmp
        //   143: ifne +107 -> 250
        //   146: invokestatic 49	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
        //   149: pop
        //   150: invokestatic 55	com/tencent/mm/model/c:bzD	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   153: aload_0
        //   154: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   157: invokestatic 59	com/tencent/mm/ui/chatting/presenter/e:j	(Lcom/tencent/mm/ui/chatting/presenter/e;)Ljava/lang/String;
        //   160: aload_0
        //   161: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   164: invokestatic 95	com/tencent/mm/ui/chatting/presenter/e:a	(Lcom/tencent/mm/ui/chatting/presenter/e;)Ljava/util/ArrayList;
        //   167: invokevirtual 101	java/util/ArrayList:size	()I
        //   170: aload_0
        //   171: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   174: invokestatic 104	com/tencent/mm/ui/chatting/presenter/e:l	(Lcom/tencent/mm/ui/chatting/presenter/e;)I
        //   177: isub
        //   178: iload_1
        //   179: invokeinterface 108 4 0
        //   184: astore 6
        //   186: aload 6
        //   188: ifnonnull +110 -> 298
        //   191: ldc 75
        //   193: ldc 110
        //   195: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   198: ldc 32
        //   200: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   203: return
        //   204: aload_0
        //   205: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   208: astore 6
        //   210: invokestatic 49	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
        //   213: pop
        //   214: aload 6
        //   216: invokestatic 121	com/tencent/mm/model/c:bzE	()Lcom/tencent/mm/storage/t;
        //   219: aload_0
        //   220: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   223: invokestatic 59	com/tencent/mm/ui/chatting/presenter/e:j	(Lcom/tencent/mm/ui/chatting/presenter/e;)Ljava/lang/String;
        //   226: aload_0
        //   227: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   230: invokestatic 41	com/tencent/mm/ui/chatting/presenter/e:i	(Lcom/tencent/mm/ui/chatting/presenter/e;)J
        //   233: invokevirtual 127	com/tencent/mm/storage/t:cw	(Ljava/lang/String;J)I
        //   236: invokestatic 69	com/tencent/mm/ui/chatting/presenter/e:b	(Lcom/tencent/mm/ui/chatting/presenter/e;I)I
        //   239: pop
        //   240: goto -183 -> 57
        //   243: sipush 200
        //   246: istore_1
        //   247: goto -152 -> 95
        //   250: invokestatic 49	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
        //   253: pop
        //   254: invokestatic 121	com/tencent/mm/model/c:bzE	()Lcom/tencent/mm/storage/t;
        //   257: aload_0
        //   258: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   261: invokestatic 59	com/tencent/mm/ui/chatting/presenter/e:j	(Lcom/tencent/mm/ui/chatting/presenter/e;)Ljava/lang/String;
        //   264: aload_0
        //   265: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   268: invokestatic 41	com/tencent/mm/ui/chatting/presenter/e:i	(Lcom/tencent/mm/ui/chatting/presenter/e;)J
        //   271: aload_0
        //   272: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   275: invokestatic 95	com/tencent/mm/ui/chatting/presenter/e:a	(Lcom/tencent/mm/ui/chatting/presenter/e;)Ljava/util/ArrayList;
        //   278: invokevirtual 101	java/util/ArrayList:size	()I
        //   281: aload_0
        //   282: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   285: invokestatic 104	com/tencent/mm/ui/chatting/presenter/e:l	(Lcom/tencent/mm/ui/chatting/presenter/e;)I
        //   288: isub
        //   289: iload_1
        //   290: invokevirtual 131	com/tencent/mm/storage/t:c	(Ljava/lang/String;JII)Landroid/database/Cursor;
        //   293: astore 6
        //   295: goto -109 -> 186
        //   298: lconst_0
        //   299: lstore_2
        //   300: aload 6
        //   302: invokeinterface 137 1 0
        //   307: ifeq +97 -> 404
        //   310: new 139	com/tencent/mm/storage/cc
        //   313: dup
        //   314: invokespecial 140	com/tencent/mm/storage/cc:<init>	()V
        //   317: astore 8
        //   319: aload 8
        //   321: aload 6
        //   323: invokevirtual 144	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
        //   326: new 146	java/util/Date
        //   329: dup
        //   330: aload 8
        //   332: invokevirtual 150	com/tencent/mm/storage/cc:getCreateTime	()J
        //   335: invokespecial 153	java/util/Date:<init>	(J)V
        //   338: astore 9
        //   340: invokestatic 159	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   343: aload 9
        //   345: invokevirtual 162	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   348: lstore 4
        //   350: lload_2
        //   351: lload 4
        //   353: lcmp
        //   354: ifeq +29 -> 383
        //   357: aload 7
        //   359: new 164	com/tencent/mm/ui/chatting/a/b$c
        //   362: dup
        //   363: aload 8
        //   365: invokevirtual 150	com/tencent/mm/storage/cc:getCreateTime	()J
        //   368: invokespecial 165	com/tencent/mm/ui/chatting/a/b$c:<init>	(J)V
        //   371: invokevirtual 169	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   374: pop
        //   375: aload_0
        //   376: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   379: invokestatic 172	com/tencent/mm/ui/chatting/presenter/e:m	(Lcom/tencent/mm/ui/chatting/presenter/e;)I
        //   382: pop
        //   383: aload 7
        //   385: new 164	com/tencent/mm/ui/chatting/a/b$c
        //   388: dup
        //   389: aload 8
        //   391: invokespecial 175	com/tencent/mm/ui/chatting/a/b$c:<init>	(Lcom/tencent/mm/storage/cc;)V
        //   394: invokevirtual 169	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   397: pop
        //   398: lload 4
        //   400: lstore_2
        //   401: goto -101 -> 300
        //   404: aload 6
        //   406: invokeinterface 178 1 0
        //   411: new 90	java/util/LinkedList
        //   414: dup
        //   415: invokespecial 91	java/util/LinkedList:<init>	()V
        //   418: astore 8
        //   420: aload 7
        //   422: invokevirtual 179	java/util/LinkedList:size	()I
        //   425: aload_0
        //   426: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   429: invokestatic 104	com/tencent/mm/ui/chatting/presenter/e:l	(Lcom/tencent/mm/ui/chatting/presenter/e;)I
        //   432: isub
        //   433: iload_1
        //   434: if_icmpne +338 -> 772
        //   437: aload 7
        //   439: iconst_0
        //   440: invokevirtual 183	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   443: checkcast 164	com/tencent/mm/ui/chatting/a/b$c
        //   446: getfield 187	com/tencent/mm/ui/chatting/a/b$c:timeStamp	J
        //   449: lstore_2
        //   450: invokestatic 159	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   453: pop
        //   454: lload_2
        //   455: invokestatic 191	com/tencent/mm/ui/gridviewheaders/a:Aw	(J)J
        //   458: lstore 4
        //   460: ldc 75
        //   462: ldc 193
        //   464: iconst_3
        //   465: anewarray 4	java/lang/Object
        //   468: dup
        //   469: iconst_0
        //   470: aload 7
        //   472: invokevirtual 179	java/util/LinkedList:size	()I
        //   475: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   478: aastore
        //   479: dup
        //   480: iconst_1
        //   481: lload 4
        //   483: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   486: aastore
        //   487: dup
        //   488: iconst_2
        //   489: lload_2
        //   490: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   493: aastore
        //   494: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   497: aload_0
        //   498: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   501: invokestatic 41	com/tencent/mm/ui/chatting/presenter/e:i	(Lcom/tencent/mm/ui/chatting/presenter/e;)J
        //   504: ldc2_w 42
        //   507: lcmp
        //   508: ifne +186 -> 694
        //   511: invokestatic 49	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
        //   514: pop
        //   515: invokestatic 55	com/tencent/mm/model/c:bzD	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   518: aload_0
        //   519: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   522: invokestatic 59	com/tencent/mm/ui/chatting/presenter/e:j	(Lcom/tencent/mm/ui/chatting/presenter/e;)Ljava/lang/String;
        //   525: lload 4
        //   527: lload_2
        //   528: invokeinterface 202 6 0
        //   533: astore 6
        //   535: new 146	java/util/Date
        //   538: dup
        //   539: lload_2
        //   540: invokespecial 153	java/util/Date:<init>	(J)V
        //   543: astore 9
        //   545: invokestatic 159	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   548: aload 9
        //   550: invokevirtual 162	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   553: lstore_2
        //   554: aload 6
        //   556: ifnull +204 -> 760
        //   559: aload 6
        //   561: invokeinterface 137 1 0
        //   566: ifeq +194 -> 760
        //   569: new 139	com/tencent/mm/storage/cc
        //   572: dup
        //   573: invokespecial 140	com/tencent/mm/storage/cc:<init>	()V
        //   576: astore 10
        //   578: aload 10
        //   580: aload 6
        //   582: invokevirtual 144	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
        //   585: new 146	java/util/Date
        //   588: dup
        //   589: aload 10
        //   591: invokevirtual 150	com/tencent/mm/storage/cc:getCreateTime	()J
        //   594: invokespecial 153	java/util/Date:<init>	(J)V
        //   597: astore 11
        //   599: invokestatic 159	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   602: aload 11
        //   604: invokevirtual 162	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   607: lstore 4
        //   609: lload_2
        //   610: lload 4
        //   612: lcmp
        //   613: ifeq +113 -> 726
        //   616: invokestatic 159	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   619: aload 9
        //   621: invokevirtual 162	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   624: lload 4
        //   626: lcmp
        //   627: ifeq +99 -> 726
        //   630: aload 8
        //   632: new 164	com/tencent/mm/ui/chatting/a/b$c
        //   635: dup
        //   636: aload 10
        //   638: invokevirtual 150	com/tencent/mm/storage/cc:getCreateTime	()J
        //   641: invokespecial 165	com/tencent/mm/ui/chatting/a/b$c:<init>	(J)V
        //   644: invokevirtual 169	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   647: pop
        //   648: aload_0
        //   649: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   652: invokestatic 172	com/tencent/mm/ui/chatting/presenter/e:m	(Lcom/tencent/mm/ui/chatting/presenter/e;)I
        //   655: pop
        //   656: lload 4
        //   658: lstore_2
        //   659: aload 8
        //   661: new 164	com/tencent/mm/ui/chatting/a/b$c
        //   664: dup
        //   665: aload 10
        //   667: invokespecial 175	com/tencent/mm/ui/chatting/a/b$c:<init>	(Lcom/tencent/mm/storage/cc;)V
        //   670: invokevirtual 169	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   673: pop
        //   674: goto -120 -> 554
        //   677: astore 7
        //   679: aload 6
        //   681: invokeinterface 178 1 0
        //   686: ldc 32
        //   688: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   691: aload 7
        //   693: athrow
        //   694: invokestatic 49	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
        //   697: pop
        //   698: invokestatic 121	com/tencent/mm/model/c:bzE	()Lcom/tencent/mm/storage/t;
        //   701: aload_0
        //   702: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   705: invokestatic 59	com/tencent/mm/ui/chatting/presenter/e:j	(Lcom/tencent/mm/ui/chatting/presenter/e;)Ljava/lang/String;
        //   708: aload_0
        //   709: getfield 22	com/tencent/mm/ui/chatting/presenter/e$8:aeIP	Lcom/tencent/mm/ui/chatting/presenter/e;
        //   712: invokestatic 41	com/tencent/mm/ui/chatting/presenter/e:i	(Lcom/tencent/mm/ui/chatting/presenter/e;)J
        //   715: lload 4
        //   717: lload_2
        //   718: invokevirtual 205	com/tencent/mm/storage/t:e	(Ljava/lang/String;JJJ)Landroid/database/Cursor;
        //   721: astore 6
        //   723: goto -188 -> 535
        //   726: aload 7
        //   728: invokevirtual 179	java/util/LinkedList:size	()I
        //   731: ifle +26 -> 757
        //   734: aload 8
        //   736: invokevirtual 179	java/util/LinkedList:size	()I
        //   739: ifne +18 -> 757
        //   742: aload 8
        //   744: iconst_0
        //   745: aload 7
        //   747: iconst_0
        //   748: invokevirtual 208	java/util/LinkedList:remove	(I)Ljava/lang/Object;
        //   751: checkcast 164	com/tencent/mm/ui/chatting/a/b$c
        //   754: invokevirtual 211	java/util/LinkedList:add	(ILjava/lang/Object;)V
        //   757: goto -98 -> 659
        //   760: aload 6
        //   762: ifnull +10 -> 772
        //   765: aload 6
        //   767: invokeinterface 178 1 0
        //   772: new 90	java/util/LinkedList
        //   775: dup
        //   776: invokespecial 91	java/util/LinkedList:<init>	()V
        //   779: astore 6
        //   781: aload 6
        //   783: aload 8
        //   785: invokevirtual 215	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   788: pop
        //   789: aload 6
        //   791: aload 7
        //   793: invokevirtual 215	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   796: pop
        //   797: ldc 75
        //   799: ldc 217
        //   801: iconst_3
        //   802: anewarray 4	java/lang/Object
        //   805: dup
        //   806: iconst_0
        //   807: aload 7
        //   809: invokevirtual 179	java/util/LinkedList:size	()I
        //   812: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   815: aastore
        //   816: dup
        //   817: iconst_1
        //   818: aload 8
        //   820: invokevirtual 179	java/util/LinkedList:size	()I
        //   823: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   826: aastore
        //   827: dup
        //   828: iconst_2
        //   829: aload 6
        //   831: invokevirtual 179	java/util/LinkedList:size	()I
        //   834: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   837: aastore
        //   838: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   841: new 13	com/tencent/mm/ui/chatting/presenter/e$8$1
        //   844: dup
        //   845: aload_0
        //   846: aload 6
        //   848: invokespecial 220	com/tencent/mm/ui/chatting/presenter/e$8$1:<init>	(Lcom/tencent/mm/ui/chatting/presenter/e$8;Ljava/util/LinkedList;)V
        //   851: invokestatic 226	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   854: ldc 32
        //   856: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   859: return
        //   860: astore 7
        //   862: aload 6
        //   864: ifnull +10 -> 874
        //   867: aload 6
        //   869: invokeinterface 178 1 0
        //   874: ldc 32
        //   876: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   879: aload 7
        //   881: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	882	0	this	8
        //   94	341	1	i	int
        //   299	419	2	l1	long
        //   348	368	4	l2	long
        //   30	838	6	localObject1	Object
        //   130	341	7	localLinkedList	LinkedList
        //   677	131	7	localCollection	java.util.Collection
        //   860	20	7	localObject2	Object
        //   317	502	8	localObject3	Object
        //   338	282	9	localDate1	java.util.Date
        //   576	90	10	localcc	cc
        //   597	6	11	localDate2	java.util.Date
        // Exception table:
        //   from	to	target	type
        //   300	350	677	finally
        //   357	383	677	finally
        //   383	398	677	finally
        //   559	609	860	finally
        //   616	656	860	finally
        //   659	674	860	finally
        //   726	757	860	finally
      }
    });
    AppMethodBeat.o(36538);
  }
  
  public final void MN(int paramInt)
  {
    AppMethodBeat.i(36522);
    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    final ArrayList localArrayList = com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ann;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36522);
      return;
      ExportFileUtil.a(this.mContext, new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(254333);
          final List localList = e.nF(localArrayList);
          if (localList.size() != localArrayList.size())
          {
            k.a(e.b(e.this), R.l.gIT, R.l.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(254342);
                if (localList.size() == 0)
                {
                  Log.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSave size = 0");
                  e.c(e.this).juL();
                  AppMethodBeat.o(254342);
                  return;
                }
                e.a(e.this, localList);
                AppMethodBeat.o(254342);
              }
            }, null);
            AppMethodBeat.o(254333);
            return;
          }
          e.a(e.this, localList);
          AppMethodBeat.o(254333);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36498);
          Toast.makeText(e.b(e.this), e.b(e.this).getString(R.l.gUa), 1).show();
          AppMethodBeat.o(36498);
        }
      });
      AppMethodBeat.o(36522);
      return;
      Object localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (!ae.ck((cc)((Iterator)localObject1).next()))
        {
          com.tencent.mm.ui.base.aa.makeText(this.mContext, R.l.favorite_fail_open_im_withdown_download, 0).show();
          AppMethodBeat.o(36522);
          return;
        }
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 18L, 1L, true);
      final dn localdn = new dn();
      if (com.tencent.mm.pluginsdk.model.n.a(this.mContext, localdn, this.lMU, localArrayList, false))
      {
        c(localdn);
        nE(localArrayList);
      }
      for (;;)
      {
        this.aeIL.dSG();
        AppMethodBeat.o(36522);
        return;
        if (localArrayList.size() > 1)
        {
          Context localContext = this.mContext;
          if (localdn.hDr.hDx >= 0)
          {
            localObject1 = this.mContext.getString(R.l.favorite_fail_recordtype_error);
            label264:
            if (localdn.hDr.hDx < 0) {
              break label339;
            }
          }
          label339:
          for (localObject2 = this.mContext.getString(R.l.confirm_dialog_ok);; localObject2 = this.mContext.getString(R.l.plugin_favorite_opt))
          {
            k.b(localContext, (String)localObject1, "", (String)localObject2, this.mContext.getString(R.l.confirm_dialog_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(36505);
                if ((localdn.hDr.type == 14) && (localdn.hDr.hDt.vEn.size() == 0))
                {
                  AppMethodBeat.o(36505);
                  return;
                }
                e.a(e.this, localdn);
                e.nH(localArrayList);
                AppMethodBeat.o(36505);
              }
            }, null);
            break;
            localObject1 = this.mContext.getString(R.l.favorite_fail_record_expired_bigfile);
            break label264;
          }
        }
        k.s(this.mContext, localdn.hDr.hDx, 0);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 19L, 1L, true);
      boolean bool = au.bwE(this.lMU);
      com.tencent.mm.ui.chatting.n.a(this.mContext, localArrayList, bool, this.lMU, new com.tencent.mm.message.z()
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
      this.aeIL.dSG();
      AppMethodBeat.o(36522);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11627, new Object[] { Integer.valueOf(5) });
      localObject1 = new TreeSet();
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Set)localObject1).add(Long.valueOf(((cc)((Iterator)localObject2).next()).field_msgId));
      }
      k.b(this.mContext, this.mContext.getString(R.l.gAv), "", this.mContext.getString(R.l.gEg), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(254337);
          Log.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
          l.a(e.b(e.this), this.aeBR, new com.tencent.mm.message.z()
          {
            public final void O(Bundle paramAnonymous2Bundle) {}
            
            public final void a(z.a paramAnonymous2a) {}
            
            public final void b(z.a paramAnonymous2a)
            {
              AppMethodBeat.i(254312);
              if (paramAnonymous2a == z.a.nVu) {
                e.a(e.this).removeAll(e.6.this.sEi);
              }
              AppMethodBeat.o(254312);
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
              AppMethodBeat.i(254314);
              Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", new Object[] { Thread.currentThread(), Integer.valueOf(e.6.this.sEi.size()), paramAnonymous2a });
              if ((paramAnonymous2a == z.a.nVu) && (e.c(e.this) != null)) {
                e.c(e.this).dSG();
              }
              AppMethodBeat.o(254314);
            }
          });
          AppMethodBeat.o(254337);
        }
      }, null);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, p paramp)
  {
    AppMethodBeat.i(36528);
    Log.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(36528);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, p paramp)
  {
    AppMethodBeat.i(36529);
    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Integer.valueOf(this.aeIN), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
    if (!this.aeIL.juO())
    {
      AppMethodBeat.o(36529);
      return;
    }
    this.aeIN -= 1;
    bh.bCz();
    paramObject = c.bzD().sl(paramLong2);
    if (!com.tencent.mm.ui.chatting.gallery.h.c(this.mContext, paramObject, false)) {
      this.aeIO = true;
    }
    if (jwN())
    {
      if (!this.aeIO)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36511);
            if (e.c(e.this) != null) {
              e.c(e.this).juN();
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
            e.c(e.this).aCs(R.l.gIV);
          }
          AppMethodBeat.o(36512);
        }
      });
    }
    AppMethodBeat.o(36529);
  }
  
  public final void a(aa.a.a parama)
  {
    AppMethodBeat.i(36531);
    if ((this.aeIL == null) || (!this.aeIL.juO()))
    {
      AppMethodBeat.o(36531);
      return;
    }
    com.tencent.mm.modelvideo.z localz = ab.Qo(parama.fileName);
    Log.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", new Object[] { Integer.valueOf(this.aeIN), parama.pbB, parama.fileName });
    if (localz != null) {
      if (localz.bOx())
      {
        this.aeIN -= 1;
        bh.bCz();
        parama = c.bzD().sl(localz.pbc);
        if (parama != null) {
          com.tencent.mm.ui.chatting.gallery.h.a(this.mContext, parama, false);
        }
      }
    }
    while (jwN()) {
      if (this.aeIO)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36513);
            if (e.c(e.this) != null) {
              e.c(e.this).aCs(R.l.gIV);
            }
            AppMethodBeat.o(36513);
          }
        });
        AppMethodBeat.o(36531);
        return;
        Log.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
        juL();
        this.aeIL.aCs(0);
      }
      else
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36514);
            if (e.c(e.this) != null) {
              e.c(e.this).juN();
            }
            AppMethodBeat.o(36514);
          }
        });
      }
    }
    AppMethodBeat.o(36531);
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(36521);
    String str = this.mContext.getString(R.l.grk);
    AppMethodBeat.o(36521);
    return str;
  }
  
  public final b cA(String paramString, long paramLong)
  {
    AppMethodBeat.i(254385);
    this.lMU = paramString;
    this.aenl = paramLong;
    if (paramLong == -1L) {}
    for (this.aeIM = new b(this.mContext, this.mDataList, paramString);; this.aeIM = new b(this.mContext, this.mDataList, paramString, paramLong))
    {
      this.aeIM.aenm = new b.b()
      {
        public final void a(boolean paramAnonymousBoolean, b.c paramAnonymousc, int paramAnonymousInt)
        {
          AppMethodBeat.i(36510);
          Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
          if ((paramAnonymousBoolean) && (com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ann.size() >= 9))
          {
            Toast.makeText(e.b(e.this), e.b(e.this).getResources().getString(R.l.gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
            e.this.aeIM.fV(paramAnonymousInt);
            AppMethodBeat.o(36510);
            return;
          }
          if (paramAnonymousBoolean) {
            com.tencent.mm.ui.chatting.gallery.n.a.jvm().dv(paramAnonymousc.hTm);
          }
          for (;;)
          {
            e.c(e.this).ML(com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ann.size());
            AppMethodBeat.o(36510);
            return;
            com.tencent.mm.ui.chatting.gallery.n.a.jvm().dw(paramAnonymousc.hTm);
          }
        }
      };
      paramString = this.aeIM;
      AppMethodBeat.o(254385);
      return paramString;
    }
  }
  
  public final void clear() {}
  
  public final boolean dSE()
  {
    AppMethodBeat.i(36526);
    boolean bool = com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ano;
    AppMethodBeat.o(36526);
    return bool;
  }
  
  public final void dSF()
  {
    AppMethodBeat.i(36524);
    this.aeIM.Anw = true;
    com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ano = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)fT(this.mContext);
    int i = localGridLayoutManager.Ju();
    int j = localGridLayoutManager.Jw();
    this.aeIM.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(36524);
  }
  
  public final void dSG()
  {
    AppMethodBeat.i(36525);
    this.aeIM.Anw = false;
    com.tencent.mm.ui.chatting.gallery.n.a.jvm().clear();
    com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ano = false;
    this.aeIM.bZE.notifyChanged();
    AppMethodBeat.o(36525);
  }
  
  public final <T extends RecyclerView.LayoutManager> T fT(Context paramContext)
  {
    AppMethodBeat.i(254379);
    if (this.wQC == null)
    {
      this.wQC = new GridLayoutManager(4);
      this.wQC.bWq = new GridLayoutManager.b()
      {
        public final int fJ(int paramAnonymousInt)
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
    paramContext = this.wQC;
    AppMethodBeat.o(254379);
    return paramContext;
  }
  
  public final RecyclerView.h gl(final Context paramContext)
  {
    AppMethodBeat.i(254382);
    paramContext = new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(254319);
        int i = (int)paramContext.getResources().getDimension(R.f.OneDPPadding);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
        AppMethodBeat.o(254319);
      }
    };
    AppMethodBeat.o(254382);
    return paramContext;
  }
  
  public final int juK()
  {
    AppMethodBeat.i(36523);
    int i = com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ann.size();
    AppMethodBeat.o(36523);
    return i;
  }
  
  public final void juL()
  {
    AppMethodBeat.i(36530);
    r.bKb().a(this);
    v.bOh().a(this);
    this.aeIL.juL();
    AppMethodBeat.o(36530);
  }
  
  public final void jvj()
  {
    this.AnX = true;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(36517);
    this.wQB.dead();
    this.aeIL.a(null);
    this.aeIL = null;
    r.bKb().a(this);
    v.bOh().a(this);
    com.tencent.mm.ui.chatting.gallery.n.a.jvm().detach();
    com.tencent.mm.ui.chatting.n.jpj();
    AppMethodBeat.o(36517);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(36527);
    if ((this.AnX) && (com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ano))
    {
      this.aeIL.ML(com.tencent.mm.ui.chatting.gallery.n.a.jvm().Ann.size());
      this.aeIM.bZE.notifyChanged();
    }
    AppMethodBeat.o(36527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.presenter.e
 * JD-Core Version:    0.7.0.1
 */