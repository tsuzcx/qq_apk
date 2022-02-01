package com.tencent.mm.ui.chatting.l;

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
import com.tencent.mm.aj.z;
import com.tencent.mm.aj.z.a;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.jh;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.f.a.a;
import com.tencent.mm.ui.chatting.f.a.b;
import com.tencent.mm.ui.chatting.gallery.f;
import com.tencent.mm.ui.chatting.gallery.l.a;
import com.tencent.mm.ui.chatting.gallery.l.b;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e
  implements e.a, x.a, a.a, l.b
{
  static int count = 0;
  private long WFI;
  private int WZh;
  private a.b WZl;
  b WZm;
  private int WZn;
  private boolean WZo;
  private String jkq;
  private Context mContext;
  private ArrayList<b.c> mDataList;
  private MMHandler mHandler;
  private IListener tNl;
  private GridLayoutManager tNm;
  boolean wRu;
  private int wRv;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(36516);
    this.mDataList = null;
    this.tNl = new IListener() {};
    this.wRu = false;
    this.WZn = 0;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.WZo = false;
    this.WZh = 0;
    this.wRv = 0;
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
    AppMethodBeat.o(36516);
  }
  
  private void c(dd paramdd)
  {
    AppMethodBeat.i(36537);
    paramdd.fyI.fyP = 45;
    paramdd.fyI.activity = ((Activity)this.mContext);
    EventCenter.instance.publish(paramdd);
    if ((paramdd.fyJ.ret == -2) || (paramdd.fyJ.ret > 0))
    {
      AppMethodBeat.o(36537);
      return;
    }
    if (paramdd.fyJ.ret <= 0)
    {
      if (14 != paramdd.fyI.type)
      {
        Log.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
        AppMethodBeat.o(36537);
        return;
      }
      if (paramdd.fyI.fyL == null)
      {
        Log.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
        AppMethodBeat.o(36537);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11142, new Object[] { Integer.valueOf(paramdd.fyI.fyL.SAQ), Integer.valueOf(paramdd.fyI.fyL.JCD), Integer.valueOf(paramdd.fyI.fyL.SAR), Integer.valueOf(paramdd.fyI.fyL.xzT), Integer.valueOf(paramdd.fyI.fyL.SAS), Integer.valueOf(paramdd.fyI.fyL.SAT), Integer.valueOf(paramdd.fyI.fyL.SAU), Integer.valueOf(paramdd.fyI.fyL.fileCount), Integer.valueOf(paramdd.fyI.fyL.SAV), Integer.valueOf(paramdd.fyI.fyL.SAW), Integer.valueOf(paramdd.fyI.fyL.SAX), Integer.valueOf(paramdd.fyI.fyL.SAY), Integer.valueOf(paramdd.fyI.fyL.SAZ), Integer.valueOf(paramdd.fyI.fyL.SBa), Integer.valueOf(paramdd.fyI.fyL.SBb) });
    }
    AppMethodBeat.o(36537);
  }
  
  private static String e(ca paramca, com.tencent.mm.modelvideo.w paramw)
  {
    AppMethodBeat.i(36533);
    Object localObject;
    if (paramw.mhX == -1)
    {
      paramw = paramw.bqN();
      localObject = paramw;
      if (!u.agG(paramw))
      {
        s.bqB();
        localObject = x.XT(paramca.field_imgPath);
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
          s.bqB();
          str = x.XT(paramca.field_imgPath);
          localObject = str;
        } while (paramca.field_isSend != 1);
        localObject = str;
      } while (paramw.mia == null);
      localObject = str;
    } while (!paramw.mia.TCA);
    for (;;)
    {
      try
      {
        paramw = u.bBT(str);
        paramca = paramw;
        if (!paramw.endsWith("/")) {
          paramca = paramw + "/";
        }
        paramw = u.bBW(str);
        paramca = paramca + paramw + "_hd.mp4";
        boolean bool = u.agG(paramca);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", new Object[] { paramca, Boolean.valueOf(bool) });
        if (!bool) {
          break label228;
        }
        localObject = paramca;
      }
      catch (Exception paramca)
      {
        Log.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", new Object[] { paramca.getMessage() });
        localObject = str;
      }
      break;
      label228:
      paramca = str;
    }
  }
  
  private boolean hTm()
  {
    return this.WZn == 0;
  }
  
  private static void ko(List<ca> paramList)
  {
    AppMethodBeat.i(36536);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      a.a(a.c.Wwh, a.d.Wwm, localca, 0);
    }
    AppMethodBeat.o(36536);
  }
  
  public final void K(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(36538);
    if ((!paramBoolean) && (this.wRv + this.WZh == this.mDataList.size()))
    {
      Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", new Object[] { Integer.valueOf(this.wRv), Integer.valueOf(paramInt) });
      AppMethodBeat.o(36538);
      return;
    }
    this.WZm.tMZ = true;
    this.WZl.lR(paramBoolean);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 33
        //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 25	com/tencent/mm/ui/chatting/l/e$8:tNh	Z
        //   9: ifeq +48 -> 57
        //   12: aload_0
        //   13: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   16: invokestatic 42	com/tencent/mm/ui/chatting/l/e:i	(Lcom/tencent/mm/ui/chatting/l/e;)J
        //   19: ldc2_w 43
        //   22: lcmp
        //   23: ifne +181 -> 204
        //   26: aload_0
        //   27: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   30: astore 6
        //   32: invokestatic 50	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
        //   35: pop
        //   36: aload 6
        //   38: invokestatic 56	com/tencent/mm/model/c:bbO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   41: aload_0
        //   42: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   45: invokestatic 60	com/tencent/mm/ui/chatting/l/e:j	(Lcom/tencent/mm/ui/chatting/l/e;)Ljava/lang/String;
        //   48: invokeinterface 66 2 0
        //   53: invokestatic 70	com/tencent/mm/ui/chatting/l/e:b	(Lcom/tencent/mm/ui/chatting/l/e;I)I
        //   56: pop
        //   57: aload_0
        //   58: getfield 27	com/tencent/mm/ui/chatting/l/e$8:lIG	I
        //   61: iflt +182 -> 243
        //   64: aload_0
        //   65: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   68: invokestatic 74	com/tencent/mm/ui/chatting/l/e:k	(Lcom/tencent/mm/ui/chatting/l/e;)I
        //   71: aload_0
        //   72: getfield 27	com/tencent/mm/ui/chatting/l/e$8:lIG	I
        //   75: isub
        //   76: sipush 200
        //   79: if_icmple +164 -> 243
        //   82: aload_0
        //   83: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   86: invokestatic 74	com/tencent/mm/ui/chatting/l/e:k	(Lcom/tencent/mm/ui/chatting/l/e;)I
        //   89: aload_0
        //   90: getfield 27	com/tencent/mm/ui/chatting/l/e$8:lIG	I
        //   93: isub
        //   94: istore_1
        //   95: ldc 76
        //   97: ldc 78
        //   99: iconst_2
        //   100: anewarray 4	java/lang/Object
        //   103: dup
        //   104: iconst_0
        //   105: aload_0
        //   106: getfield 27	com/tencent/mm/ui/chatting/l/e$8:lIG	I
        //   109: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   112: aastore
        //   113: dup
        //   114: iconst_1
        //   115: iload_1
        //   116: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   119: aastore
        //   120: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   123: new 91	java/util/LinkedList
        //   126: dup
        //   127: invokespecial 92	java/util/LinkedList:<init>	()V
        //   130: astore 7
        //   132: aload_0
        //   133: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   136: invokestatic 42	com/tencent/mm/ui/chatting/l/e:i	(Lcom/tencent/mm/ui/chatting/l/e;)J
        //   139: ldc2_w 43
        //   142: lcmp
        //   143: ifne +107 -> 250
        //   146: invokestatic 50	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
        //   149: pop
        //   150: invokestatic 56	com/tencent/mm/model/c:bbO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   153: aload_0
        //   154: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   157: invokestatic 60	com/tencent/mm/ui/chatting/l/e:j	(Lcom/tencent/mm/ui/chatting/l/e;)Ljava/lang/String;
        //   160: aload_0
        //   161: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   164: invokestatic 96	com/tencent/mm/ui/chatting/l/e:a	(Lcom/tencent/mm/ui/chatting/l/e;)Ljava/util/ArrayList;
        //   167: invokevirtual 102	java/util/ArrayList:size	()I
        //   170: aload_0
        //   171: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   174: invokestatic 105	com/tencent/mm/ui/chatting/l/e:l	(Lcom/tencent/mm/ui/chatting/l/e;)I
        //   177: isub
        //   178: iload_1
        //   179: invokeinterface 109 4 0
        //   184: astore 6
        //   186: aload 6
        //   188: ifnonnull +110 -> 298
        //   191: ldc 76
        //   193: ldc 111
        //   195: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   198: ldc 33
        //   200: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   203: return
        //   204: aload_0
        //   205: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   208: astore 6
        //   210: invokestatic 50	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
        //   213: pop
        //   214: aload 6
        //   216: invokestatic 122	com/tencent/mm/model/c:bbP	()Lcom/tencent/mm/storage/t;
        //   219: aload_0
        //   220: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   223: invokestatic 60	com/tencent/mm/ui/chatting/l/e:j	(Lcom/tencent/mm/ui/chatting/l/e;)Ljava/lang/String;
        //   226: aload_0
        //   227: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   230: invokestatic 42	com/tencent/mm/ui/chatting/l/e:i	(Lcom/tencent/mm/ui/chatting/l/e;)J
        //   233: invokevirtual 128	com/tencent/mm/storage/t:ck	(Ljava/lang/String;J)I
        //   236: invokestatic 70	com/tencent/mm/ui/chatting/l/e:b	(Lcom/tencent/mm/ui/chatting/l/e;I)I
        //   239: pop
        //   240: goto -183 -> 57
        //   243: sipush 200
        //   246: istore_1
        //   247: goto -152 -> 95
        //   250: invokestatic 50	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
        //   253: pop
        //   254: invokestatic 122	com/tencent/mm/model/c:bbP	()Lcom/tencent/mm/storage/t;
        //   257: aload_0
        //   258: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   261: invokestatic 60	com/tencent/mm/ui/chatting/l/e:j	(Lcom/tencent/mm/ui/chatting/l/e;)Ljava/lang/String;
        //   264: aload_0
        //   265: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   268: invokestatic 42	com/tencent/mm/ui/chatting/l/e:i	(Lcom/tencent/mm/ui/chatting/l/e;)J
        //   271: aload_0
        //   272: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   275: invokestatic 96	com/tencent/mm/ui/chatting/l/e:a	(Lcom/tencent/mm/ui/chatting/l/e;)Ljava/util/ArrayList;
        //   278: invokevirtual 102	java/util/ArrayList:size	()I
        //   281: aload_0
        //   282: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   285: invokestatic 105	com/tencent/mm/ui/chatting/l/e:l	(Lcom/tencent/mm/ui/chatting/l/e;)I
        //   288: isub
        //   289: iload_1
        //   290: invokevirtual 131	com/tencent/mm/storage/t:b	(Ljava/lang/String;JII)Landroid/database/Cursor;
        //   293: astore 6
        //   295: goto -109 -> 186
        //   298: lconst_0
        //   299: lstore_2
        //   300: aload 6
        //   302: invokeinterface 137 1 0
        //   307: ifeq +97 -> 404
        //   310: new 139	com/tencent/mm/storage/ca
        //   313: dup
        //   314: invokespecial 140	com/tencent/mm/storage/ca:<init>	()V
        //   317: astore 8
        //   319: aload 8
        //   321: aload 6
        //   323: invokevirtual 144	com/tencent/mm/storage/ca:convertFrom	(Landroid/database/Cursor;)V
        //   326: new 146	java/util/Date
        //   329: dup
        //   330: aload 8
        //   332: getfield 152	com/tencent/mm/f/c/et:field_createTime	J
        //   335: invokespecial 155	java/util/Date:<init>	(J)V
        //   338: astore 9
        //   340: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:hWZ	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   343: aload 9
        //   345: invokevirtual 164	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   348: lstore 4
        //   350: lload_2
        //   351: lload 4
        //   353: lcmp
        //   354: ifeq +29 -> 383
        //   357: aload 7
        //   359: new 166	com/tencent/mm/ui/chatting/a/b$c
        //   362: dup
        //   363: aload 8
        //   365: getfield 152	com/tencent/mm/f/c/et:field_createTime	J
        //   368: invokespecial 167	com/tencent/mm/ui/chatting/a/b$c:<init>	(J)V
        //   371: invokevirtual 171	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   374: pop
        //   375: aload_0
        //   376: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   379: invokestatic 174	com/tencent/mm/ui/chatting/l/e:m	(Lcom/tencent/mm/ui/chatting/l/e;)I
        //   382: pop
        //   383: aload 7
        //   385: new 166	com/tencent/mm/ui/chatting/a/b$c
        //   388: dup
        //   389: aload 8
        //   391: invokespecial 177	com/tencent/mm/ui/chatting/a/b$c:<init>	(Lcom/tencent/mm/storage/ca;)V
        //   394: invokevirtual 171	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   397: pop
        //   398: lload 4
        //   400: lstore_2
        //   401: goto -101 -> 300
        //   404: aload 6
        //   406: invokeinterface 180 1 0
        //   411: new 91	java/util/LinkedList
        //   414: dup
        //   415: invokespecial 92	java/util/LinkedList:<init>	()V
        //   418: astore 8
        //   420: aload 7
        //   422: invokevirtual 181	java/util/LinkedList:size	()I
        //   425: aload_0
        //   426: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   429: invokestatic 105	com/tencent/mm/ui/chatting/l/e:l	(Lcom/tencent/mm/ui/chatting/l/e;)I
        //   432: isub
        //   433: iload_1
        //   434: if_icmpne +335 -> 769
        //   437: aload 7
        //   439: iconst_0
        //   440: invokevirtual 185	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   443: checkcast 166	com/tencent/mm/ui/chatting/a/b$c
        //   446: getfield 188	com/tencent/mm/ui/chatting/a/b$c:timeStamp	J
        //   449: lstore_2
        //   450: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:hWZ	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   453: pop
        //   454: lload_2
        //   455: invokestatic 192	com/tencent/mm/ui/gridviewheaders/a:Wk	(J)J
        //   458: lstore 4
        //   460: ldc 76
        //   462: ldc 194
        //   464: iconst_3
        //   465: anewarray 4	java/lang/Object
        //   468: dup
        //   469: iconst_0
        //   470: aload 7
        //   472: invokevirtual 181	java/util/LinkedList:size	()I
        //   475: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   478: aastore
        //   479: dup
        //   480: iconst_1
        //   481: lload 4
        //   483: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   486: aastore
        //   487: dup
        //   488: iconst_2
        //   489: lload_2
        //   490: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   493: aastore
        //   494: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   497: aload_0
        //   498: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   501: invokestatic 42	com/tencent/mm/ui/chatting/l/e:i	(Lcom/tencent/mm/ui/chatting/l/e;)J
        //   504: ldc2_w 43
        //   507: lcmp
        //   508: ifne +186 -> 694
        //   511: invokestatic 50	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
        //   514: pop
        //   515: invokestatic 56	com/tencent/mm/model/c:bbO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
        //   518: aload_0
        //   519: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   522: invokestatic 60	com/tencent/mm/ui/chatting/l/e:j	(Lcom/tencent/mm/ui/chatting/l/e;)Ljava/lang/String;
        //   525: lload 4
        //   527: lload_2
        //   528: invokeinterface 203 6 0
        //   533: astore 6
        //   535: new 146	java/util/Date
        //   538: dup
        //   539: lload_2
        //   540: invokespecial 155	java/util/Date:<init>	(J)V
        //   543: astore 9
        //   545: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:hWZ	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   548: aload 9
        //   550: invokevirtual 164	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   553: lstore_2
        //   554: aload 6
        //   556: ifnull +201 -> 757
        //   559: aload 6
        //   561: invokeinterface 137 1 0
        //   566: ifeq +191 -> 757
        //   569: new 139	com/tencent/mm/storage/ca
        //   572: dup
        //   573: invokespecial 140	com/tencent/mm/storage/ca:<init>	()V
        //   576: astore 10
        //   578: aload 10
        //   580: aload 6
        //   582: invokevirtual 144	com/tencent/mm/storage/ca:convertFrom	(Landroid/database/Cursor;)V
        //   585: new 146	java/util/Date
        //   588: dup
        //   589: aload 10
        //   591: getfield 152	com/tencent/mm/f/c/et:field_createTime	J
        //   594: invokespecial 155	java/util/Date:<init>	(J)V
        //   597: astore 11
        //   599: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:hWZ	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   602: aload 11
        //   604: invokevirtual 164	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   607: lstore 4
        //   609: lload_2
        //   610: lload 4
        //   612: lcmp
        //   613: ifeq +113 -> 726
        //   616: invokestatic 161	com/tencent/mm/ui/gridviewheaders/a:hWZ	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   619: aload 9
        //   621: invokevirtual 164	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   624: lload 4
        //   626: lcmp
        //   627: ifeq +99 -> 726
        //   630: aload 8
        //   632: new 166	com/tencent/mm/ui/chatting/a/b$c
        //   635: dup
        //   636: aload 10
        //   638: getfield 152	com/tencent/mm/f/c/et:field_createTime	J
        //   641: invokespecial 167	com/tencent/mm/ui/chatting/a/b$c:<init>	(J)V
        //   644: invokevirtual 171	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   647: pop
        //   648: aload_0
        //   649: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   652: invokestatic 174	com/tencent/mm/ui/chatting/l/e:m	(Lcom/tencent/mm/ui/chatting/l/e;)I
        //   655: pop
        //   656: lload 4
        //   658: lstore_2
        //   659: aload 8
        //   661: new 166	com/tencent/mm/ui/chatting/a/b$c
        //   664: dup
        //   665: aload 10
        //   667: invokespecial 177	com/tencent/mm/ui/chatting/a/b$c:<init>	(Lcom/tencent/mm/storage/ca;)V
        //   670: invokevirtual 171	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   673: pop
        //   674: goto -120 -> 554
        //   677: astore 7
        //   679: aload 6
        //   681: invokeinterface 180 1 0
        //   686: ldc 33
        //   688: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   691: aload 7
        //   693: athrow
        //   694: invokestatic 50	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
        //   697: pop
        //   698: invokestatic 122	com/tencent/mm/model/c:bbP	()Lcom/tencent/mm/storage/t;
        //   701: aload_0
        //   702: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   705: invokestatic 60	com/tencent/mm/ui/chatting/l/e:j	(Lcom/tencent/mm/ui/chatting/l/e;)Ljava/lang/String;
        //   708: aload_0
        //   709: getfield 23	com/tencent/mm/ui/chatting/l/e$8:WZp	Lcom/tencent/mm/ui/chatting/l/e;
        //   712: invokestatic 42	com/tencent/mm/ui/chatting/l/e:i	(Lcom/tencent/mm/ui/chatting/l/e;)J
        //   715: lload 4
        //   717: lload_2
        //   718: invokevirtual 207	com/tencent/mm/storage/t:d	(Ljava/lang/String;JJJ)Landroid/database/Cursor;
        //   721: astore 6
        //   723: goto -188 -> 535
        //   726: aload 7
        //   728: invokevirtual 181	java/util/LinkedList:size	()I
        //   731: ifle +23 -> 754
        //   734: aload 8
        //   736: invokevirtual 181	java/util/LinkedList:size	()I
        //   739: ifne +15 -> 754
        //   742: aload 8
        //   744: iconst_0
        //   745: aload 7
        //   747: iconst_0
        //   748: invokevirtual 210	java/util/LinkedList:remove	(I)Ljava/lang/Object;
        //   751: invokevirtual 213	java/util/LinkedList:add	(ILjava/lang/Object;)V
        //   754: goto -95 -> 659
        //   757: aload 6
        //   759: ifnull +10 -> 769
        //   762: aload 6
        //   764: invokeinterface 180 1 0
        //   769: new 91	java/util/LinkedList
        //   772: dup
        //   773: invokespecial 92	java/util/LinkedList:<init>	()V
        //   776: astore 6
        //   778: aload 6
        //   780: aload 8
        //   782: invokevirtual 217	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   785: pop
        //   786: aload 6
        //   788: aload 7
        //   790: invokevirtual 217	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   793: pop
        //   794: ldc 76
        //   796: ldc 219
        //   798: iconst_3
        //   799: anewarray 4	java/lang/Object
        //   802: dup
        //   803: iconst_0
        //   804: aload 7
        //   806: invokevirtual 181	java/util/LinkedList:size	()I
        //   809: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   812: aastore
        //   813: dup
        //   814: iconst_1
        //   815: aload 8
        //   817: invokevirtual 181	java/util/LinkedList:size	()I
        //   820: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   823: aastore
        //   824: dup
        //   825: iconst_2
        //   826: aload 6
        //   828: invokevirtual 181	java/util/LinkedList:size	()I
        //   831: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   834: aastore
        //   835: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   838: new 13	com/tencent/mm/ui/chatting/l/e$8$1
        //   841: dup
        //   842: aload_0
        //   843: aload 6
        //   845: invokespecial 222	com/tencent/mm/ui/chatting/l/e$8$1:<init>	(Lcom/tencent/mm/ui/chatting/l/e$8;Ljava/util/LinkedList;)V
        //   848: invokestatic 228	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   851: ldc 33
        //   853: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   856: return
        //   857: astore 7
        //   859: aload 6
        //   861: ifnull +10 -> 871
        //   864: aload 6
        //   866: invokeinterface 180 1 0
        //   871: ldc 33
        //   873: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   876: aload 7
        //   878: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	879	0	this	8
        //   94	341	1	i	int
        //   299	419	2	l1	long
        //   348	368	4	l2	long
        //   30	835	6	localObject1	Object
        //   130	341	7	localLinkedList	LinkedList
        //   677	128	7	localCollection	java.util.Collection
        //   857	20	7	localObject2	Object
        //   317	499	8	localObject3	Object
        //   338	282	9	localDate1	java.util.Date
        //   576	90	10	localca	ca
        //   597	6	11	localDate2	java.util.Date
        // Exception table:
        //   from	to	target	type
        //   300	350	677	finally
        //   357	383	677	finally
        //   383	398	677	finally
        //   559	609	857	finally
        //   616	656	857	finally
        //   659	674	857	finally
        //   726	754	857	finally
      }
    });
    AppMethodBeat.o(36538);
  }
  
  public final void LQ(int paramInt)
  {
    AppMethodBeat.i(36522);
    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    final ArrayList localArrayList = l.a.hRO().wQK;
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
          AppMethodBeat.i(227947);
          final List localList = e.kp(localArrayList);
          if (localList.size() != localArrayList.size())
          {
            com.tencent.mm.ui.base.h.a(e.b(e.this), R.l.eFY, R.l.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(266284);
                if (localList.size() == 0)
                {
                  Log.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSave size = 0");
                  e.c(e.this).hRo();
                  AppMethodBeat.o(266284);
                  return;
                }
                e.a(e.this, localList);
                AppMethodBeat.o(266284);
              }
            }, null);
            AppMethodBeat.o(227947);
            return;
          }
          e.a(e.this, localList);
          AppMethodBeat.o(227947);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36498);
          Toast.makeText(e.b(e.this), e.b(e.this).getString(R.l.eRu), 1).show();
          AppMethodBeat.o(36498);
        }
      });
      AppMethodBeat.o(36522);
      return;
      Object localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (!ac.bW((ca)((Iterator)localObject1).next()))
        {
          com.tencent.mm.ui.base.w.makeText(this.mContext, R.l.favorite_fail_open_im_withdown_download, 0).show();
          AppMethodBeat.o(36522);
          return;
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 18L, 1L, true);
      final dd localdd = new dd();
      if (com.tencent.mm.pluginsdk.model.l.a(this.mContext, localdd, this.jkq, localArrayList, false))
      {
        c(localdd);
        ko(localArrayList);
      }
      for (;;)
      {
        this.WZl.dlQ();
        AppMethodBeat.o(36522);
        return;
        if (localArrayList.size() > 1)
        {
          Context localContext = this.mContext;
          if (localdd.fyI.fyO >= 0)
          {
            localObject1 = this.mContext.getString(R.l.favorite_fail_recordtype_error);
            label264:
            if (localdd.fyI.fyO < 0) {
              break label339;
            }
          }
          label339:
          for (localObject2 = this.mContext.getString(R.l.confirm_dialog_ok);; localObject2 = this.mContext.getString(R.l.plugin_favorite_opt))
          {
            com.tencent.mm.ui.base.h.c(localContext, (String)localObject1, "", (String)localObject2, this.mContext.getString(R.l.confirm_dialog_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(36505);
                if ((localdd.fyI.type == 14) && (localdd.fyI.fyK.syG.size() == 0))
                {
                  AppMethodBeat.o(36505);
                  return;
                }
                e.a(e.this, localdd);
                e.kr(localArrayList);
                AppMethodBeat.o(36505);
              }
            }, null);
            break;
            localObject1 = this.mContext.getString(R.l.favorite_fail_record_expired_bigfile);
            break label264;
          }
        }
        com.tencent.mm.ui.base.h.p(this.mContext, localdd.fyI.fyO, 0);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 19L, 1L, true);
      boolean bool = ab.Lj(this.jkq);
      com.tencent.mm.ui.chatting.l.a(this.mContext, localArrayList, bool, this.jkq, new z()
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
      this.WZl.dlQ();
      AppMethodBeat.o(36522);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(11627, new Object[] { Integer.valueOf(5) });
      localObject1 = new TreeSet();
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Set)localObject1).add(Long.valueOf(((ca)((Iterator)localObject2).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(R.l.exL), "", this.mContext.getString(R.l.eBd), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214395);
          Log.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
          j.a(e.b(e.this), this.WSm, new z()
          {
            public final void H(Bundle paramAnonymous2Bundle) {}
            
            public final void a(z.a paramAnonymous2a) {}
            
            public final void b(z.a paramAnonymous2a)
            {
              AppMethodBeat.i(272517);
              if (paramAnonymous2a == z.a.lqr) {
                e.a(e.this).removeAll(e.6.this.pzd);
              }
              AppMethodBeat.o(272517);
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
              AppMethodBeat.i(272518);
              Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", new Object[] { Thread.currentThread(), Integer.valueOf(e.6.this.pzd.size()), paramAnonymous2a });
              if ((paramAnonymous2a == z.a.lqr) && (e.c(e.this) != null)) {
                e.c(e.this).dlQ();
              }
              AppMethodBeat.o(272518);
            }
          });
          AppMethodBeat.o(214395);
        }
      }, null);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(36528);
    Log.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(36528);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(36529);
    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Integer.valueOf(this.WZn), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
    if (!this.WZl.hRr())
    {
      AppMethodBeat.o(36529);
      return;
    }
    this.WZn -= 1;
    bh.beI();
    paramObject = c.bbO().Oq(paramLong2);
    if (!f.d(this.mContext, paramObject, false)) {
      this.WZo = true;
    }
    if (hTm())
    {
      if (!this.WZo)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36511);
            if (e.c(e.this) != null) {
              e.c(e.this).hRq();
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
            e.c(e.this).avM(R.l.eGa);
          }
          AppMethodBeat.o(36512);
        }
      });
    }
    AppMethodBeat.o(36529);
  }
  
  public final void a(x.a.a parama)
  {
    AppMethodBeat.i(36531);
    if ((this.WZl == null) || (!this.WZl.hRr()))
    {
      AppMethodBeat.o(36531);
      return;
    }
    com.tencent.mm.modelvideo.w localw = y.Yk(parama.fileName);
    Log.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", new Object[] { Integer.valueOf(this.WZn), parama.mil, parama.fileName });
    if (localw != null) {
      if (localw.bqS())
      {
        this.WZn -= 1;
        bh.beI();
        parama = c.bbO().Oq(localw.mhR);
        f.b(this.mContext, parama, false);
      }
    }
    while (hTm()) {
      if (this.WZo)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36513);
            if (e.c(e.this) != null) {
              e.c(e.this).avM(R.l.eGa);
            }
            AppMethodBeat.o(36513);
          }
        });
        AppMethodBeat.o(36531);
        return;
        Log.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
        hRo();
        this.WZl.avM(0);
      }
      else
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36514);
            if (e.c(e.this) != null) {
              e.c(e.this).hRq();
            }
            AppMethodBeat.o(36514);
          }
        });
      }
    }
    AppMethodBeat.o(36531);
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(36521);
    String str = this.mContext.getString(R.l.eom);
    AppMethodBeat.o(36521);
    return str;
  }
  
  public final void clear() {}
  
  public final b co(String paramString, long paramLong)
  {
    AppMethodBeat.i(273208);
    this.jkq = paramString;
    this.WFI = paramLong;
    if (paramLong == -1L) {}
    for (this.WZm = new b(this.mContext, this.mDataList, paramString);; this.WZm = new b(this.mContext, this.mDataList, paramString, paramLong))
    {
      this.WZm.WFJ = new b.b()
      {
        public final void a(boolean paramAnonymousBoolean, b.c paramAnonymousc, int paramAnonymousInt)
        {
          AppMethodBeat.i(36510);
          Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
          if ((paramAnonymousBoolean) && (l.a.hRO().wQK.size() >= 9))
          {
            Toast.makeText(e.b(e.this), e.b(e.this).getResources().getString(R.l.gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
            e.this.WZm.cL(paramAnonymousInt);
            AppMethodBeat.o(36510);
            return;
          }
          if (paramAnonymousBoolean) {
            l.a.hRO().cY(paramAnonymousc.fNz);
          }
          for (;;)
          {
            e.c(e.this).LO(l.a.hRO().wQK.size());
            AppMethodBeat.o(36510);
            return;
            l.a.hRO().cZ(paramAnonymousc.fNz);
          }
        }
      };
      paramString = this.WZm;
      AppMethodBeat.o(273208);
      return paramString;
    }
  }
  
  public final boolean dlO()
  {
    AppMethodBeat.i(36526);
    boolean bool = l.a.hRO().wQL;
    AppMethodBeat.o(36526);
    return bool;
  }
  
  public final void dlP()
  {
    AppMethodBeat.i(36524);
    this.WZm.wQS = true;
    l.a.hRO().wQL = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)eW(this.mContext);
    int i = localGridLayoutManager.kJ();
    int j = localGridLayoutManager.kL();
    this.WZm.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(36524);
  }
  
  public final void dlQ()
  {
    AppMethodBeat.i(36525);
    this.WZm.wQS = false;
    l.a.hRO().clear();
    l.a.hRO().wQL = false;
    this.WZm.alc.notifyChanged();
    AppMethodBeat.o(36525);
  }
  
  public final <T extends RecyclerView.LayoutManager> T eW(Context paramContext)
  {
    AppMethodBeat.i(273206);
    if (this.tNm == null)
    {
      this.tNm = new GridLayoutManager(4);
      this.tNm.ahK = new GridLayoutManager.b()
      {
        public final int cx(int paramAnonymousInt)
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
    paramContext = this.tNm;
    AppMethodBeat.o(273206);
    return paramContext;
  }
  
  public final RecyclerView.h fn(final Context paramContext)
  {
    AppMethodBeat.i(273207);
    paramContext = new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(283148);
        int i = (int)paramContext.getResources().getDimension(R.f.OneDPPadding);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
        AppMethodBeat.o(283148);
      }
    };
    AppMethodBeat.o(273207);
    return paramContext;
  }
  
  public final void hRL()
  {
    this.wRu = true;
  }
  
  public final int hRn()
  {
    AppMethodBeat.i(36523);
    int i = l.a.hRO().wQK.size();
    AppMethodBeat.o(36523);
    return i;
  }
  
  public final void hRo()
  {
    AppMethodBeat.i(36530);
    com.tencent.mm.ay.q.bmi().a(this);
    s.bqB().a(this);
    this.WZl.hRo();
    AppMethodBeat.o(36530);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(36517);
    this.tNl.dead();
    this.WZl.a(null);
    this.WZl = null;
    com.tencent.mm.ay.q.bmi().a(this);
    s.bqB().a(this);
    l.a.hRO().detach();
    com.tencent.mm.ui.chatting.l.hMH();
    AppMethodBeat.o(36517);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(36527);
    if ((this.wRu) && (l.a.hRO().wQL))
    {
      this.WZl.LO(l.a.hRO().wQK.size());
      this.WZm.alc.notifyChanged();
    }
    AppMethodBeat.o(36527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.e
 * JD-Core Version:    0.7.0.1
 */