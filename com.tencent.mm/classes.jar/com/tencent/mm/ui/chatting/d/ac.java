package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.b;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.z;
import com.tencent.mm.ui.chatting.view.b.2;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=z.class)
public class ac
  extends a
  implements z
{
  public static final Long PqN;
  private View GEr;
  private View PqO;
  private LinearLayout PqP;
  private NestedScrollView PqQ;
  private LinearLayout PqR;
  private LinearLayout PqS;
  private RelativeLayout PqT;
  private com.tencent.mm.ui.chatting.view.b PqU;
  private GridLayoutManager PqV;
  private d PqW;
  private GridLayoutManager PqX;
  private d PqY;
  protected Thread PqZ;
  private ArrayList<GroupToolItem> Pra;
  private boolean Prb;
  private a Prc;
  private a Prd;
  private IListener<nu> Pre;
  private View.OnClickListener Prf;
  private Runnable Prg;
  private boolean dEF;
  private LinearLayout gvA;
  private RecyclerView gvB;
  private e gvI;
  private LinearLayout gvy;
  private RecyclerView gvz;
  private long nJh;
  private ImageView qoh;
  private com.tencent.mm.ui.base.q tipDialog;
  
  static
  {
    AppMethodBeat.i(179908);
    PqN = Long.valueOf(604800000L);
    AppMethodBeat.o(179908);
  }
  
  public ac()
  {
    AppMethodBeat.i(179883);
    this.tipDialog = null;
    this.gvI = null;
    this.Pra = new ArrayList();
    this.Prb = false;
    this.nJh = 0L;
    this.dEF = false;
    this.Prc = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179854);
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "iStickToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.amm()) {
            break label78;
          }
          ac.a(ac.this);
        }
        for (;;)
        {
          ac.a(ac.this, paramAnonymousView, true);
          if (ac.c(ac.this) != null) {
            ac.c(ac.this).bMo();
          }
          AppMethodBeat.o(179854);
          return;
          label78:
          if (paramAnonymousView.amn()) {
            ac.b(ac.this);
          } else {
            ac.a(ac.this, paramAnonymousView, "1", true);
          }
        }
      }
    };
    this.Prd = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179864);
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "iRecentUseToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.amm()) {
            break label78;
          }
          ac.a(ac.this);
        }
        for (;;)
        {
          ac.a(ac.this, paramAnonymousView, false);
          if (ac.c(ac.this) != null) {
            ac.c(ac.this).bMo();
          }
          AppMethodBeat.o(179864);
          return;
          label78:
          if (paramAnonymousView.amn()) {
            ac.b(ac.this);
          } else {
            ac.a(ac.this, paramAnonymousView, "2", false);
          }
        }
      }
    };
    this.Pre = new IListener() {};
    this.Prf = new ac.11(this);
    this.Prg = new Runnable()
    {
      private ArrayList<GroupToolItem> Pri;
      
      private boolean b(GroupToolItem paramAnonymousGroupToolItem)
      {
        AppMethodBeat.i(185885);
        if (paramAnonymousGroupToolItem == null)
        {
          AppMethodBeat.o(185885);
          return false;
        }
        if (this.Pri.contains(paramAnonymousGroupToolItem))
        {
          AppMethodBeat.o(185885);
          return false;
        }
        this.Pri.add(paramAnonymousGroupToolItem);
        AppMethodBeat.o(185885);
        return true;
      }
      
      private boolean gQj()
      {
        AppMethodBeat.i(185886);
        if (this.Pri.size() >= 20)
        {
          AppMethodBeat.o(185886);
          return true;
        }
        AppMethodBeat.o(185886);
        return false;
      }
      
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 61
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 67	com/tencent/mm/model/cl:aWz	()J
        //   8: lstore_3
        //   9: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   12: lload_3
        //   13: lcmp
        //   14: ifle +780 -> 794
        //   17: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   20: lstore_3
        //   21: invokestatic 67	com/tencent/mm/model/cl:aWz	()J
        //   24: lstore 5
        //   26: ldc 74
        //   28: invokestatic 80	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   31: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   34: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/f;
        //   37: aload_0
        //   38: getfield 21	com/tencent/mm/ui/chatting/d/ac$5:Prh	Lcom/tencent/mm/ui/chatting/d/ac;
        //   41: getfield 88	com/tencent/mm/ui/chatting/d/ac:dom	Lcom/tencent/mm/ui/chatting/e/a;
        //   44: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   47: invokevirtual 100	com/tencent/mm/chatroom/storage/f:DE	(Ljava/lang/String;)Lcom/tencent/mm/chatroom/storage/e;
        //   50: astore 10
        //   52: aload_0
        //   53: getfield 36	com/tencent/mm/ui/chatting/d/ac$5:Pri	Ljava/util/ArrayList;
        //   56: invokevirtual 103	java/util/ArrayList:clear	()V
        //   59: iconst_0
        //   60: istore 7
        //   62: iconst_0
        //   63: istore_1
        //   64: invokestatic 108	java/lang/Thread:interrupted	()Z
        //   67: ifne +474 -> 541
        //   70: aload_0
        //   71: invokespecial 110	com/tencent/mm/ui/chatting/d/ac$5:gQj	()Z
        //   74: ifne +467 -> 541
        //   77: iload 7
        //   79: ifne +462 -> 541
        //   82: iload_1
        //   83: bipush 26
        //   85: if_icmpge +456 -> 541
        //   88: ldc 112
        //   90: invokestatic 116	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   93: checkcast 112	com/tencent/mm/plugin/messenger/foundation/a/l
        //   96: invokeinterface 120 1 0
        //   101: aload_0
        //   102: getfield 21	com/tencent/mm/ui/chatting/d/ac$5:Prh	Lcom/tencent/mm/ui/chatting/d/ac;
        //   105: getfield 88	com/tencent/mm/ui/chatting/d/ac:dom	Lcom/tencent/mm/ui/chatting/e/a;
        //   108: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   111: lload_3
        //   112: iload_1
        //   113: iconst_1
        //   114: iadd
        //   115: i2l
        //   116: getstatic 124	com/tencent/mm/ui/chatting/d/ac:PqN	Ljava/lang/Long;
        //   119: invokevirtual 129	java/lang/Long:longValue	()J
        //   122: lmul
        //   123: lsub
        //   124: lload_3
        //   125: iload_1
        //   126: i2l
        //   127: getstatic 124	com/tencent/mm/ui/chatting/d/ac:PqN	Ljava/lang/Long;
        //   130: invokevirtual 129	java/lang/Long:longValue	()J
        //   133: lmul
        //   134: lsub
        //   135: invokeinterface 135 6 0
        //   140: astore 11
        //   142: aload 11
        //   144: ifnull +663 -> 807
        //   147: aload 11
        //   149: invokeinterface 138 1 0
        //   154: istore_2
        //   155: ldc 140
        //   157: ldc 142
        //   159: iconst_2
        //   160: anewarray 4	java/lang/Object
        //   163: dup
        //   164: iconst_0
        //   165: iload_1
        //   166: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   169: aastore
        //   170: dup
        //   171: iconst_1
        //   172: iload_2
        //   173: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   176: aastore
        //   177: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   180: aload 11
        //   182: ifnull +615 -> 797
        //   185: aload 11
        //   187: invokeinterface 138 1 0
        //   192: ifne +6 -> 198
        //   195: goto +602 -> 797
        //   198: aload 11
        //   200: invokeinterface 157 1 0
        //   205: astore 11
        //   207: aload 11
        //   209: invokeinterface 162 1 0
        //   214: ifeq +577 -> 791
        //   217: aload 11
        //   219: invokeinterface 166 1 0
        //   224: checkcast 168	com/tencent/mm/storage/ca
        //   227: astore 12
        //   229: aload 12
        //   231: getfield 174	com/tencent/mm/g/c/eo:fqJ	I
        //   234: iconst_4
        //   235: iand
        //   236: iconst_4
        //   237: if_icmpeq -30 -> 207
        //   240: aload 12
        //   242: invokevirtual 177	com/tencent/mm/storage/ca:getType	()I
        //   245: sipush 10000
        //   248: if_icmpeq -41 -> 207
        //   251: aload 12
        //   253: getfield 181	com/tencent/mm/g/c/eo:field_content	Ljava/lang/String;
        //   256: invokestatic 187	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
        //   259: astore 13
        //   261: aload 13
        //   263: ifnonnull +144 -> 407
        //   266: ldc 140
        //   268: ldc 189
        //   270: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   273: goto -66 -> 207
        //   276: astore 11
        //   278: ldc 140
        //   280: ldc 195
        //   282: iconst_2
        //   283: anewarray 4	java/lang/Object
        //   286: dup
        //   287: iconst_0
        //   288: aload 11
        //   290: invokevirtual 199	java/lang/Object:getClass	()Ljava/lang/Class;
        //   293: invokevirtual 204	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   296: aastore
        //   297: dup
        //   298: iconst_1
        //   299: aload 11
        //   301: invokevirtual 207	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   304: aastore
        //   305: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   308: invokestatic 67	com/tencent/mm/model/cl:aWz	()J
        //   311: lstore_3
        //   312: ldc 140
        //   314: ldc 212
        //   316: iconst_2
        //   317: anewarray 4	java/lang/Object
        //   320: dup
        //   321: iconst_0
        //   322: aload_0
        //   323: getfield 21	com/tencent/mm/ui/chatting/d/ac$5:Prh	Lcom/tencent/mm/ui/chatting/d/ac;
        //   326: getfield 88	com/tencent/mm/ui/chatting/d/ac:dom	Lcom/tencent/mm/ui/chatting/e/a;
        //   329: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   332: aastore
        //   333: dup
        //   334: iconst_1
        //   335: lload_3
        //   336: lload 5
        //   338: lsub
        //   339: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   342: aastore
        //   343: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   346: aload_0
        //   347: getfield 21	com/tencent/mm/ui/chatting/d/ac$5:Prh	Lcom/tencent/mm/ui/chatting/d/ac;
        //   350: invokestatic 218	com/tencent/mm/ui/chatting/d/ac:e	(Lcom/tencent/mm/ui/chatting/d/ac;)Ljava/util/ArrayList;
        //   353: invokevirtual 103	java/util/ArrayList:clear	()V
        //   356: aload_0
        //   357: getfield 21	com/tencent/mm/ui/chatting/d/ac$5:Prh	Lcom/tencent/mm/ui/chatting/d/ac;
        //   360: invokestatic 218	com/tencent/mm/ui/chatting/d/ac:e	(Lcom/tencent/mm/ui/chatting/d/ac;)Ljava/util/ArrayList;
        //   363: aload 10
        //   365: getfield 224	com/tencent/mm/chatroom/storage/e:gtx	Ljava/util/LinkedList;
        //   368: invokevirtual 228	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   371: pop
        //   372: aload_0
        //   373: getfield 21	com/tencent/mm/ui/chatting/d/ac$5:Prh	Lcom/tencent/mm/ui/chatting/d/ac;
        //   376: invokestatic 218	com/tencent/mm/ui/chatting/d/ac:e	(Lcom/tencent/mm/ui/chatting/d/ac;)Ljava/util/ArrayList;
        //   379: new 10	com/tencent/mm/ui/chatting/d/ac$5$1
        //   382: dup
        //   383: aload_0
        //   384: invokespecial 231	com/tencent/mm/ui/chatting/d/ac$5$1:<init>	(Lcom/tencent/mm/ui/chatting/d/ac$5;)V
        //   387: invokestatic 237	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
        //   390: new 12	com/tencent/mm/ui/chatting/d/ac$5$2
        //   393: dup
        //   394: aload_0
        //   395: invokespecial 238	com/tencent/mm/ui/chatting/d/ac$5$2:<init>	(Lcom/tencent/mm/ui/chatting/d/ac$5;)V
        //   398: invokestatic 244	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   401: ldc 61
        //   403: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   406: return
        //   407: aload 13
        //   409: invokestatic 249	com/tencent/mm/modelappbrand/a:b	(Lcom/tencent/mm/ag/k$b;)Z
        //   412: ifne +11 -> 423
        //   415: aload 13
        //   417: invokestatic 252	com/tencent/mm/modelappbrand/a:c	(Lcom/tencent/mm/ag/k$b;)Z
        //   420: ifeq +67 -> 487
        //   423: aload 12
        //   425: invokestatic 258	com/tencent/mm/chatroom/d/aa:g	(Lcom/tencent/mm/storage/ca;)Lcom/tencent/mm/chatroom/storage/GroupToolItem;
        //   428: astore 13
        //   430: aload 13
        //   432: ifnull +55 -> 487
        //   435: ldc 140
        //   437: ldc_w 260
        //   440: iconst_1
        //   441: anewarray 4	java/lang/Object
        //   444: dup
        //   445: iconst_0
        //   446: aload 13
        //   448: invokevirtual 265	com/tencent/mm/chatroom/storage/GroupToolItem:toString	()Ljava/lang/String;
        //   451: aastore
        //   452: invokestatic 267	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   455: aload_0
        //   456: aload 13
        //   458: invokespecial 269	com/tencent/mm/ui/chatting/d/ac$5:b	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   461: ifeq +26 -> 487
        //   464: aload_0
        //   465: invokespecial 110	com/tencent/mm/ui/chatting/d/ac$5:gQj	()Z
        //   468: ifeq +19 -> 487
        //   471: iconst_1
        //   472: istore 7
        //   474: aload_0
        //   475: invokespecial 110	com/tencent/mm/ui/chatting/d/ac$5:gQj	()Z
        //   478: ifeq +322 -> 800
        //   481: iconst_1
        //   482: istore 7
        //   484: goto +316 -> 800
        //   487: aload 12
        //   489: invokestatic 273	com/tencent/mm/chatroom/d/aa:h	(Lcom/tencent/mm/storage/ca;)Z
        //   492: ifeq -285 -> 207
        //   495: ldc 140
        //   497: ldc_w 275
        //   500: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   503: aload_0
        //   504: new 262	com/tencent/mm/chatroom/storage/GroupToolItem
        //   507: dup
        //   508: ldc_w 277
        //   511: ldc_w 279
        //   514: aload 12
        //   516: getfield 282	com/tencent/mm/g/c/eo:field_createTime	J
        //   519: invokespecial 285	com/tencent/mm/chatroom/storage/GroupToolItem:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
        //   522: invokespecial 269	com/tencent/mm/ui/chatting/d/ac$5:b	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   525: ifeq -318 -> 207
        //   528: aload_0
        //   529: invokespecial 110	com/tencent/mm/ui/chatting/d/ac$5:gQj	()Z
        //   532: ifeq -325 -> 207
        //   535: iconst_1
        //   536: istore 7
        //   538: goto -64 -> 474
        //   541: ldc 140
        //   543: ldc_w 287
        //   546: iconst_2
        //   547: anewarray 4	java/lang/Object
        //   550: dup
        //   551: iconst_0
        //   552: aload_0
        //   553: getfield 36	com/tencent/mm/ui/chatting/d/ac$5:Pri	Ljava/util/ArrayList;
        //   556: invokevirtual 57	java/util/ArrayList:size	()I
        //   559: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   562: aastore
        //   563: dup
        //   564: iconst_1
        //   565: aload_0
        //   566: getfield 36	com/tencent/mm/ui/chatting/d/ac$5:Pri	Ljava/util/ArrayList;
        //   569: invokestatic 291	com/tencent/mm/ui/chatting/d/ac:jr	(Ljava/util/List;)Ljava/lang/String;
        //   572: aastore
        //   573: invokestatic 267	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   576: aload 10
        //   578: ifnonnull +207 -> 785
        //   581: iconst_0
        //   582: istore 8
        //   584: new 220	com/tencent/mm/chatroom/storage/e
        //   587: dup
        //   588: invokespecial 292	com/tencent/mm/chatroom/storage/e:<init>	()V
        //   591: astore 11
        //   593: aload 11
        //   595: aload_0
        //   596: getfield 21	com/tencent/mm/ui/chatting/d/ac$5:Prh	Lcom/tencent/mm/ui/chatting/d/ac;
        //   599: getfield 88	com/tencent/mm/ui/chatting/d/ac:dom	Lcom/tencent/mm/ui/chatting/e/a;
        //   602: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   605: putfield 295	com/tencent/mm/chatroom/storage/e:field_chatroomname	Ljava/lang/String;
        //   608: aload 11
        //   610: astore 10
        //   612: aload 10
        //   614: iconst_1
        //   615: putfield 298	com/tencent/mm/chatroom/storage/e:field_queryState	I
        //   618: aload 10
        //   620: getfield 224	com/tencent/mm/chatroom/storage/e:gtx	Ljava/util/LinkedList;
        //   623: invokevirtual 301	java/util/LinkedList:size	()I
        //   626: istore_1
        //   627: aload 10
        //   629: getfield 224	com/tencent/mm/chatroom/storage/e:gtx	Ljava/util/LinkedList;
        //   632: invokevirtual 302	java/util/LinkedList:clear	()V
        //   635: aload 10
        //   637: getfield 224	com/tencent/mm/chatroom/storage/e:gtx	Ljava/util/LinkedList;
        //   640: aload_0
        //   641: getfield 36	com/tencent/mm/ui/chatting/d/ac$5:Pri	Ljava/util/ArrayList;
        //   644: invokevirtual 303	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   647: pop
        //   648: aload 10
        //   650: aload_0
        //   651: getfield 36	com/tencent/mm/ui/chatting/d/ac$5:Pri	Ljava/util/ArrayList;
        //   654: invokestatic 306	com/tencent/mm/chatroom/storage/e:W	(Ljava/util/List;)Ljava/lang/String;
        //   657: putfield 309	com/tencent/mm/chatroom/storage/e:field_recentUseToolList	Ljava/lang/String;
        //   660: iload 8
        //   662: ifeq +84 -> 746
        //   665: ldc 74
        //   667: invokestatic 80	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   670: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   673: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/f;
        //   676: aload 10
        //   678: iconst_0
        //   679: anewarray 311	java/lang/String
        //   682: invokevirtual 315	com/tencent/mm/chatroom/storage/f:a	(Lcom/tencent/mm/chatroom/storage/e;[Ljava/lang/String;)Z
        //   685: istore 9
        //   687: ldc 140
        //   689: ldc_w 317
        //   692: iconst_5
        //   693: anewarray 4	java/lang/Object
        //   696: dup
        //   697: iconst_0
        //   698: iload_1
        //   699: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   702: aastore
        //   703: dup
        //   704: iconst_1
        //   705: aload_0
        //   706: getfield 36	com/tencent/mm/ui/chatting/d/ac$5:Pri	Ljava/util/ArrayList;
        //   709: invokevirtual 57	java/util/ArrayList:size	()I
        //   712: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   715: aastore
        //   716: dup
        //   717: iconst_2
        //   718: iload 8
        //   720: invokestatic 322	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   723: aastore
        //   724: dup
        //   725: iconst_3
        //   726: iload 7
        //   728: invokestatic 322	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   731: aastore
        //   732: dup
        //   733: iconst_4
        //   734: iload 9
        //   736: invokestatic 322	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   739: aastore
        //   740: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   743: goto -435 -> 308
        //   746: ldc 74
        //   748: invokestatic 80	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   751: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   754: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/f;
        //   757: aload 10
        //   759: invokevirtual 325	com/tencent/mm/chatroom/storage/f:a	(Lcom/tencent/mm/chatroom/storage/e;)Z
        //   762: istore 9
        //   764: goto -77 -> 687
        //   767: astore 12
        //   769: aload 11
        //   771: astore 10
        //   773: aload 12
        //   775: astore 11
        //   777: goto -499 -> 278
        //   780: astore 11
        //   782: goto -504 -> 278
        //   785: iconst_1
        //   786: istore 8
        //   788: goto -176 -> 612
        //   791: goto -317 -> 474
        //   794: goto -773 -> 21
        //   797: iconst_1
        //   798: istore 7
        //   800: iload_1
        //   801: iconst_1
        //   802: iadd
        //   803: istore_1
        //   804: goto -740 -> 64
        //   807: iconst_0
        //   808: istore_2
        //   809: goto -654 -> 155
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	812	0	this	5
        //   63	741	1	i	int
        //   154	655	2	j	int
        //   8	328	3	l1	long
        //   24	313	5	l2	long
        //   60	739	7	bool1	boolean
        //   582	205	8	bool2	boolean
        //   685	78	9	bool3	boolean
        //   50	722	10	localObject1	Object
        //   140	78	11	localObject2	Object
        //   276	24	11	localException1	java.lang.Exception
        //   591	185	11	localObject3	Object
        //   780	1	11	localException2	java.lang.Exception
        //   227	288	12	localca	com.tencent.mm.storage.ca
        //   767	7	12	localException3	java.lang.Exception
        //   259	198	13	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   52	59	276	java/lang/Exception
        //   64	77	276	java/lang/Exception
        //   88	142	276	java/lang/Exception
        //   147	155	276	java/lang/Exception
        //   155	180	276	java/lang/Exception
        //   185	195	276	java/lang/Exception
        //   198	207	276	java/lang/Exception
        //   207	261	276	java/lang/Exception
        //   266	273	276	java/lang/Exception
        //   407	423	276	java/lang/Exception
        //   423	430	276	java/lang/Exception
        //   435	471	276	java/lang/Exception
        //   474	481	276	java/lang/Exception
        //   487	535	276	java/lang/Exception
        //   541	576	276	java/lang/Exception
        //   584	593	276	java/lang/Exception
        //   593	608	767	java/lang/Exception
        //   612	660	780	java/lang/Exception
        //   665	687	780	java/lang/Exception
        //   687	743	780	java/lang/Exception
        //   746	764	780	java/lang/Exception
      }
    };
    AppMethodBeat.o(179883);
  }
  
  private void gQh()
  {
    int k = 0;
    AppMethodBeat.i(179894);
    this.PqO = this.dom.Pwc.getContext().getLayoutInflater().inflate(2131493500, null);
    this.PqQ = ((NestedScrollView)this.PqO.findViewById(2131307173));
    this.PqT = ((RelativeLayout)this.PqO.findViewById(2131302215));
    this.PqP = ((LinearLayout)this.PqO.findViewById(2131302216));
    this.gvy = ((LinearLayout)this.PqO.findViewById(2131302221));
    this.PqR = ((LinearLayout)this.PqO.findViewById(2131302222));
    this.gvz = ((RecyclerView)this.PqO.findViewById(2131302223));
    this.gvA = ((LinearLayout)this.PqO.findViewById(2131302218));
    this.PqS = ((LinearLayout)this.PqO.findViewById(2131302219));
    this.gvB = ((RecyclerView)this.PqO.findViewById(2131302220));
    this.qoh = ((ImageView)this.PqO.findViewById(2131302217));
    this.GEr = this.PqO.findViewById(2131302213);
    this.PqT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179868);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupToolsComponet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "downArrowRl click");
        if (ac.c(ac.this) != null) {
          ac.c(ac.this).bMo();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179868);
      }
    });
    this.PqR.setOnClickListener(this.Prf);
    this.PqS.setOnClickListener(this.Prf);
    label313:
    int j;
    label333:
    label358:
    Object localObject2;
    if (this.Prb) {
      if (this.gvI.gtw.size() > 0)
      {
        this.PqR.setVisibility(0);
        this.PqS.setVisibility(8);
        if (this.gvI.gtw.size() <= 0) {
          break label1230;
        }
        this.gvy.setVisibility(0);
        i = 1;
        if (this.Pra.size() <= 0) {
          break label1244;
        }
        this.gvA.setVisibility(0);
        j = 1;
        if ((j != 0) || (i != 0)) {
          break label1258;
        }
        this.PqP.setVisibility(0);
        this.GEr.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.PqQ.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject1).height;
        if (this.gvI.gtw.size() + this.Pra.size() <= 8) {
          break label1278;
        }
        i = com.tencent.mm.cb.a.fromDPToPix(this.dom.Pwc.getContext(), 344);
        label416:
        if (j != i)
        {
          ((RelativeLayout.LayoutParams)localObject1).height = i;
          this.PqQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.qoh.setVisibility(8);
        this.dom.Pwc.getContext();
        this.PqV = new GridLayoutManager(4);
        this.gvz.setLayoutManager(this.PqV);
        this.gvz.setNestedScrollingEnabled(false);
        this.dom.Pwc.getContext();
        this.PqX = new GridLayoutManager(4);
        this.gvB.setLayoutManager(this.PqX);
        this.gvB.setNestedScrollingEnabled(false);
        i = (this.dom.Pwc.getContext().getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cb.a.aH(this.dom.Pwc.getContext(), 2131165306) * 2 - com.tencent.mm.cb.a.aH(this.dom.Pwc.getContext(), 2131165312) * 4) / 12;
        this.PqW = new d(this.dom.Pwc.getContext(), this.gvI.gtw, this.Prc);
        this.gvz.setAdapter(this.PqW);
        localObject1 = new ac.c(i);
        this.gvz.a((RecyclerView.h)localObject1);
        this.PqW.atj.notifyChanged();
        this.PqY = new d(this.dom.Pwc.getContext(), this.Pra, this.Prd);
        this.gvB.setAdapter(this.PqY);
        localObject1 = new ac.c(i);
        this.gvB.a((RecyclerView.h)localObject1);
        this.PqY.atj.notifyChanged();
        this.PqQ.setOnScrollChangeListener(new NestedScrollView.b()
        {
          public final void a(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt)
          {
            AppMethodBeat.i(179869);
            if (paramAnonymousInt == 0)
            {
              Log.d("MicroMsg.roomtools.GroupToolsComponet", "TOP SCROLL");
              ac.g(ac.this).setVisibility(8);
              AppMethodBeat.o(179869);
              return;
            }
            Log.d("MicroMsg.roomtools.GroupToolsComponet", "no TOP SCROLL");
            ac.g(ac.this).setVisibility(0);
            AppMethodBeat.o(179869);
          }
        });
        this.PqQ.setFocusable(false);
        this.PqU = new com.tencent.mm.ui.chatting.view.b(this.dom.Pwc.getContext(), this.PqO);
        this.PqU.PGl = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(185888);
            if (ac.h(ac.this) != null) {
              ac.h(ac.this).fullScroll(33);
            }
            AppMethodBeat.o(185888);
          }
        };
        localObject1 = this.PqU;
        ((com.tencent.mm.ui.chatting.view.b)localObject1).PGm = false;
        ((com.tencent.mm.ui.chatting.view.b)localObject1).mLL = ((com.tencent.mm.ui.chatting.view.b)localObject1).isLandscape();
        ((com.tencent.mm.ui.chatting.view.b)localObject1).mLM = ((com.tencent.mm.ui.chatting.view.b)localObject1).getRotation();
        if (((com.tencent.mm.ui.chatting.view.b)localObject1).mLH != null)
        {
          localObject2 = (FrameLayout.LayoutParams)((com.tencent.mm.ui.chatting.view.b)localObject1).lJI.getLayoutParams();
          if ((((com.tencent.mm.ui.chatting.view.b)localObject1).mLL) && (((com.tencent.mm.ui.chatting.view.b)localObject1).qK != null))
          {
            localObject3 = new Rect();
            ((com.tencent.mm.ui.chatting.view.b)localObject1).qK.getWindowVisibleDisplayFrame((Rect)localObject3);
            ((FrameLayout.LayoutParams)localObject2).width = ((Rect)localObject3).right;
          }
          ((com.tencent.mm.ui.chatting.view.b)localObject1).lJI.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (Build.VERSION.SDK_INT >= 21) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.getWindow().addFlags(-2147483648);
          }
          if (!((com.tencent.mm.ui.chatting.view.b)localObject1).mLO) {
            break label1298;
          }
          ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.getWindow().setFlags(8, 8);
          ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.getWindow().addFlags(131200);
          ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.getWindow().getDecorView().setSystemUiVisibility(6);
          label977:
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).mLK != null) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).mLK.ob = false;
          }
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).PGl != null) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.setOnDismissListener(new b.2((com.tencent.mm.ui.chatting.view.b)localObject1));
          }
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).qK != null) {
            if (((com.tencent.mm.ui.chatting.view.b)localObject1).afI != null) {
              break label1357;
            }
          }
        }
      }
    }
    label1298:
    label1357:
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.ui.chatting.view.b)localObject1).afI = ((com.tencent.mm.ui.chatting.view.b)localObject1).qK.getViewTreeObserver();
      if (i != 0) {
        ((com.tencent.mm.ui.chatting.view.b)localObject1).afI.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject1);
      }
      if (((((com.tencent.mm.ui.chatting.view.b)localObject1).mContext instanceof Activity)) && (!((Activity)((com.tencent.mm.ui.chatting.view.b)localObject1).mContext).isFinishing())) {
        ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.show();
      }
      if (this.PqQ != null) {
        this.PqQ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185889);
            ac.h(ac.this).fullScroll(33);
            AppMethodBeat.o(185889);
          }
        });
      }
      localObject2 = new StringBuilder();
      localObject1 = this.gvI.gtw.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
      }
      if (this.Pra.size() > 0)
      {
        this.PqR.setVisibility(8);
        this.PqS.setVisibility(0);
        break;
      }
      this.PqR.setVisibility(8);
      this.PqS.setVisibility(8);
      break;
      label1230:
      this.gvy.setVisibility(8);
      i = 0;
      break label313;
      label1244:
      this.gvA.setVisibility(8);
      j = 0;
      break label333;
      label1258:
      this.PqP.setVisibility(8);
      this.GEr.setVisibility(0);
      break label358;
      label1278:
      i = com.tencent.mm.cb.a.fromDPToPix(this.dom.Pwc.getContext(), 264);
      break label416;
      ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.getWindow().clearFlags(8);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.getWindow().clearFlags(131072);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.getWindow().clearFlags(128);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).mLH.getWindow().getDecorView().setSystemUiVisibility(0);
      break label977;
    }
    Object localObject3 = new StringBuilder();
    Object localObject1 = this.Pra.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject3).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
    }
    localObject1 = this.dom.getTalkerUserName();
    int m;
    if (this.gvI == null)
    {
      j = 0;
      m = this.Pra.size();
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!ab.JO((String)localObject1)) {
        break label1575;
      }
      i = 2;
    }
    for (;;)
    {
      af localaf = new af();
      localaf.ik((String)localObject1);
      localaf.ejW = 2L;
      localaf.enP = j;
      localaf.enQ = m;
      localaf.enM = i;
      localaf.enU = localaf.x("topAppList", (String)localObject2, true);
      localaf.enV = localaf.x("usedAppList", (String)localObject3, true);
      localaf.bfK();
      AppMethodBeat.o(179894);
      return;
      j = this.gvI.gtw.size();
      break;
      label1575:
      i = k;
      if (ab.JN((String)localObject1)) {
        i = 1;
      }
    }
  }
  
  private void gQi()
  {
    AppMethodBeat.i(233119);
    this.gvI = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(this.dom.getTalkerUserName());
    if (this.gvI == null)
    {
      e locale = new e();
      locale.field_chatroomname = this.dom.getTalkerUserName();
      boolean bool = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(locale);
      if (bool) {
        this.gvI = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(this.dom.getTalkerUserName());
      }
      Log.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools insert GroupTools: result(%s)", new Object[] { Boolean.valueOf(bool) });
    }
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools start:%s queryRecentUse:%s state:%s", new Object[] { this.dom.getTalkerUserName(), Boolean.TRUE, Integer.valueOf(this.gvI.field_queryState) });
    if (this.gvI.field_queryState == 1)
    {
      this.Pra.clear();
      this.Pra.addAll(this.gvI.gtx);
      Collections.sort(this.Pra, new Comparator() {});
      gQh();
      AppMethodBeat.o(233119);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179856);
        if (ac.this.PqZ != null) {}
        for (Object localObject = Boolean.valueOf(ac.this.PqZ.isAlive());; localObject = "null")
        {
          Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentToolsThread interrupt() %s", new Object[] { localObject });
          if ((ac.this.PqZ != null) && (ac.this.PqZ.isAlive())) {
            ac.this.PqZ.interrupt();
          }
          AppMethodBeat.o(179856);
          return;
        }
      }
    }, 5000L);
    this.PqZ = new Thread(this.Prg);
    this.PqZ.start();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179860);
        if ((ac.this.PqZ != null) && (ac.this.PqZ.isAlive())) {
          ac.i(ac.this);
        }
        AppMethodBeat.o(179860);
      }
    }, 200L);
    AppMethodBeat.o(233119);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(179889);
    super.cFx();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingResume");
    this.Pre.dead();
    AppMethodBeat.o(179889);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(179890);
    super.cFy();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingPause");
    AppMethodBeat.o(179890);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(179884);
    super.gIl();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179884);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(179885);
    super.gIm();
    String str = this.dom.getTalkerUserName();
    if ((!Util.isNullOrNil(str)) && (ab.Ix(str)) && (ab.JN(str)))
    {
      this.Prb = true;
      AppMethodBeat.o(179885);
      return;
    }
    this.Prb = false;
    AppMethodBeat.o(179885);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(179886);
    super.gIn();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingExitAnimStart");
    this.Pre.dead();
    AppMethodBeat.o(179886);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(179887);
    super.gOK();
    this.dEF = false;
    if (this.PqO != null) {
      this.PqO.setVisibility(8);
    }
    AppMethodBeat.o(179887);
  }
  
  public final void gQg()
  {
    AppMethodBeat.i(179888);
    if (!aa.ame())
    {
      AppMethodBeat.o(179888);
      return;
    }
    gQi();
    AppMethodBeat.o(179888);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
  
  public static final class b
    extends RecyclerView.v
  {
    static final c gvY;
    TextView PqE;
    LinearLayout Prk;
    ImageView gBZ;
    View gvQ;
    
    static
    {
      AppMethodBeat.i(179874);
      c.a locala1 = new c.a();
      locala1.jbq = 2131689602;
      c.a locala2 = locala1.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20));
      locala2.iaT = true;
      locala2.jbf = true;
      locala2.jbd = true;
      gvY = locala1.bdv();
      AppMethodBeat.o(179874);
    }
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(179873);
      this.gvQ = paramView;
      this.Prk = ((LinearLayout)paramView.findViewById(2131309283));
      this.gBZ = ((ImageView)paramView.findViewById(2131309287));
      this.PqE = ((TextView)paramView.findViewById(2131309289));
      AppMethodBeat.o(179873);
    }
  }
  
  public static final class d
    extends RecyclerView.a
  {
    private ac.a Prl;
    private Context context;
    private List<GroupToolItem> gwb;
    
    public d(Context paramContext, List<GroupToolItem> paramList, ac.a parama)
    {
      this.context = paramContext;
      this.gwb = paramList;
      this.Prl = parama;
    }
    
    private static void a(ac.b paramb, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(179880);
      com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.bcV();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramb.gBZ, ac.b.gvY);
        localObject = paramb.PqE;
        if (paramWxaAttributes == null) {
          break label61;
        }
      }
      label61:
      for (paramb = paramWxaAttributes.field_nickname;; paramb = "")
      {
        ((TextView)localObject).setText(paramb);
        AppMethodBeat.o(179880);
        return;
        localObject = "";
        break;
      }
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(179878);
      paramViewGroup = new ac.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493499, paramViewGroup, false));
      AppMethodBeat.o(179878);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(179879);
      GroupToolItem localGroupToolItem;
      if ((this.gwb != null) && (paramInt >= 0) && (paramInt < this.gwb.size()))
      {
        paramv = (ac.b)paramv;
        localGroupToolItem = (GroupToolItem)this.gwb.get(paramInt);
        paramv.gvQ.setVisibility(0);
        if (!localGroupToolItem.amm()) {
          break label110;
        }
        paramv.gBZ.setImageResource(2131233016);
        paramv.PqE.setText(2131761509);
      }
      for (;;)
      {
        paramv.gvQ.setTag(localGroupToolItem);
        paramv.gvQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179877);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (ac.d.a(ac.d.this) != null) {
              ac.d.a(ac.d.this).onClick(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179877);
          }
        });
        AppMethodBeat.o(179879);
        return;
        label110:
        if (localGroupToolItem.amn())
        {
          paramv.gBZ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131233017));
          paramv.PqE.setText(2131755819);
        }
        else
        {
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(localGroupToolItem.username);
          if (localWxaAttributes == null) {
            ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(localGroupToolItem.username, new q.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(179876);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179875);
                    ac.d.b(ac.d.1.this.Prm, paramAnonymousWxaAttributes);
                    AppMethodBeat.o(179875);
                  }
                });
                AppMethodBeat.o(179876);
              }
            });
          } else {
            a(paramv, localWxaAttributes);
          }
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(179881);
      int i = this.gwb.size();
      AppMethodBeat.o(179881);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ac
 * JD-Core Version:    0.7.0.1
 */