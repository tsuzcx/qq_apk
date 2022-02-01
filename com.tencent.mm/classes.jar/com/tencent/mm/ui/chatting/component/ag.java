package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.b;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.qb;
import com.tencent.mm.autogen.mmdata.rpt.at;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ac;
import com.tencent.mm.ui.chatting.view.b.2;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ac.class)
public class ag
  extends a
  implements ac
{
  public static final Long aetm;
  private View UfQ;
  private boolean aetA;
  private a aetB;
  private a aetC;
  private IListener<qb> aetD;
  private View.OnClickListener aetE;
  private Runnable aetF;
  private View aetn;
  private LinearLayout aeto;
  private NestedScrollView aetp;
  private LinearLayout aetq;
  private LinearLayout aetr;
  private RelativeLayout aets;
  private com.tencent.mm.ui.chatting.view.b aett;
  private GridLayoutManager aetu;
  private d aetv;
  private GridLayoutManager aetw;
  private d aetx;
  protected Thread aety;
  private ArrayList<GroupToolItem> aetz;
  private boolean hBY;
  private LinearLayout lBF;
  private RecyclerView lBG;
  private LinearLayout lBH;
  private RecyclerView lBI;
  private e lBP;
  private long tQb;
  private w tipDialog;
  private ImageView wQf;
  
  static
  {
    AppMethodBeat.i(179908);
    aetm = Long.valueOf(604800000L);
    AppMethodBeat.o(179908);
  }
  
  public ag()
  {
    AppMethodBeat.i(179883);
    this.tipDialog = null;
    this.lBP = null;
    this.aetz = new ArrayList();
    this.aetA = false;
    this.tQb = 0L;
    this.hBY = false;
    this.aetB = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179854);
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "iStickToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.aMh()) {
            break label78;
          }
          ag.a(ag.this);
        }
        for (;;)
        {
          ag.a(ag.this, paramAnonymousView, true);
          if (ag.c(ag.this) != null) {
            ag.c(ag.this).cyW();
          }
          AppMethodBeat.o(179854);
          return;
          label78:
          if (paramAnonymousView.aMi()) {
            ag.b(ag.this);
          } else {
            ag.a(ag.this, paramAnonymousView, "1", true);
          }
        }
      }
    };
    this.aetC = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179864);
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "iRecentUseToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.aMh()) {
            break label78;
          }
          ag.a(ag.this);
        }
        for (;;)
        {
          ag.a(ag.this, paramAnonymousView, false);
          if (ag.c(ag.this) != null) {
            ag.c(ag.this).cyW();
          }
          AppMethodBeat.o(179864);
          return;
          label78:
          if (paramAnonymousView.aMi()) {
            ag.b(ag.this);
          } else {
            ag.a(ag.this, paramAnonymousView, "2", false);
          }
        }
      }
    };
    this.aetD = new GroupToolsComponet.3(this, com.tencent.mm.app.f.hfK);
    this.aetE = new ag.10(this);
    this.aetF = new Runnable()
    {
      private ArrayList<GroupToolItem> aetH;
      
      private boolean b(GroupToolItem paramAnonymousGroupToolItem)
      {
        AppMethodBeat.i(185885);
        if (paramAnonymousGroupToolItem == null)
        {
          AppMethodBeat.o(185885);
          return false;
        }
        if (this.aetH.contains(paramAnonymousGroupToolItem))
        {
          AppMethodBeat.o(185885);
          return false;
        }
        this.aetH.add(paramAnonymousGroupToolItem);
        AppMethodBeat.o(185885);
        return true;
      }
      
      private boolean jsA()
      {
        AppMethodBeat.i(185886);
        if (this.aetH.size() >= 20)
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
        //   5: invokestatic 67	com/tencent/mm/model/cn:bDv	()J
        //   8: lstore_3
        //   9: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   12: lload_3
        //   13: lcmp
        //   14: ifle +780 -> 794
        //   17: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   20: lstore_3
        //   21: invokestatic 67	com/tencent/mm/model/cn:bDv	()J
        //   24: lstore 5
        //   26: ldc 74
        //   28: invokestatic 80	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   31: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   34: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/f;
        //   37: aload_0
        //   38: getfield 21	com/tencent/mm/ui/chatting/component/ag$5:aetG	Lcom/tencent/mm/ui/chatting/component/ag;
        //   41: getfield 88	com/tencent/mm/ui/chatting/component/ag:hlc	Lcom/tencent/mm/ui/chatting/d/a;
        //   44: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   47: invokevirtual 100	com/tencent/mm/chatroom/storage/f:Db	(Ljava/lang/String;)Lcom/tencent/mm/chatroom/storage/e;
        //   50: astore 10
        //   52: aload_0
        //   53: getfield 36	com/tencent/mm/ui/chatting/component/ag$5:aetH	Ljava/util/ArrayList;
        //   56: invokevirtual 103	java/util/ArrayList:clear	()V
        //   59: iconst_0
        //   60: istore 7
        //   62: iconst_0
        //   63: istore_1
        //   64: invokestatic 108	java/lang/Thread:interrupted	()Z
        //   67: ifne +474 -> 541
        //   70: aload_0
        //   71: invokespecial 110	com/tencent/mm/ui/chatting/component/ag$5:jsA	()Z
        //   74: ifne +467 -> 541
        //   77: iload 7
        //   79: ifne +462 -> 541
        //   82: iload_1
        //   83: bipush 26
        //   85: if_icmpge +456 -> 541
        //   88: ldc 112
        //   90: invokestatic 116	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   93: checkcast 112	com/tencent/mm/plugin/messenger/foundation/a/n
        //   96: invokeinterface 120 1 0
        //   101: aload_0
        //   102: getfield 21	com/tencent/mm/ui/chatting/component/ag$5:aetG	Lcom/tencent/mm/ui/chatting/component/ag;
        //   105: getfield 88	com/tencent/mm/ui/chatting/component/ag:hlc	Lcom/tencent/mm/ui/chatting/d/a;
        //   108: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   111: lload_3
        //   112: iload_1
        //   113: iconst_1
        //   114: iadd
        //   115: i2l
        //   116: getstatic 124	com/tencent/mm/ui/chatting/component/ag:aetm	Ljava/lang/Long;
        //   119: invokevirtual 129	java/lang/Long:longValue	()J
        //   122: lmul
        //   123: lsub
        //   124: lload_3
        //   125: iload_1
        //   126: i2l
        //   127: getstatic 124	com/tencent/mm/ui/chatting/component/ag:aetm	Ljava/lang/Long;
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
        //   224: checkcast 168	com/tencent/mm/storage/cc
        //   227: astore 12
        //   229: aload 12
        //   231: getfield 174	com/tencent/mm/autogen/b/fi:jUq	I
        //   234: iconst_4
        //   235: iand
        //   236: iconst_4
        //   237: if_icmpeq -30 -> 207
        //   240: aload 12
        //   242: invokevirtual 177	com/tencent/mm/storage/cc:getType	()I
        //   245: sipush 10000
        //   248: if_icmpeq -41 -> 207
        //   251: aload 12
        //   253: getfield 181	com/tencent/mm/autogen/b/fi:field_content	Ljava/lang/String;
        //   256: invokestatic 187	com/tencent/mm/message/k$b:Hf	(Ljava/lang/String;)Lcom/tencent/mm/message/k$b;
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
        //   308: invokestatic 67	com/tencent/mm/model/cn:bDv	()J
        //   311: lstore_3
        //   312: ldc 140
        //   314: ldc 212
        //   316: iconst_2
        //   317: anewarray 4	java/lang/Object
        //   320: dup
        //   321: iconst_0
        //   322: aload_0
        //   323: getfield 21	com/tencent/mm/ui/chatting/component/ag$5:aetG	Lcom/tencent/mm/ui/chatting/component/ag;
        //   326: getfield 88	com/tencent/mm/ui/chatting/component/ag:hlc	Lcom/tencent/mm/ui/chatting/d/a;
        //   329: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
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
        //   347: getfield 21	com/tencent/mm/ui/chatting/component/ag$5:aetG	Lcom/tencent/mm/ui/chatting/component/ag;
        //   350: invokestatic 218	com/tencent/mm/ui/chatting/component/ag:e	(Lcom/tencent/mm/ui/chatting/component/ag;)Ljava/util/ArrayList;
        //   353: invokevirtual 103	java/util/ArrayList:clear	()V
        //   356: aload_0
        //   357: getfield 21	com/tencent/mm/ui/chatting/component/ag$5:aetG	Lcom/tencent/mm/ui/chatting/component/ag;
        //   360: invokestatic 218	com/tencent/mm/ui/chatting/component/ag:e	(Lcom/tencent/mm/ui/chatting/component/ag;)Ljava/util/ArrayList;
        //   363: aload 10
        //   365: getfield 224	com/tencent/mm/chatroom/storage/e:lzF	Ljava/util/LinkedList;
        //   368: invokevirtual 228	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   371: pop
        //   372: aload_0
        //   373: getfield 21	com/tencent/mm/ui/chatting/component/ag$5:aetG	Lcom/tencent/mm/ui/chatting/component/ag;
        //   376: invokestatic 218	com/tencent/mm/ui/chatting/component/ag:e	(Lcom/tencent/mm/ui/chatting/component/ag;)Ljava/util/ArrayList;
        //   379: new 10	com/tencent/mm/ui/chatting/component/ag$5$1
        //   382: dup
        //   383: aload_0
        //   384: invokespecial 231	com/tencent/mm/ui/chatting/component/ag$5$1:<init>	(Lcom/tencent/mm/ui/chatting/component/ag$5;)V
        //   387: invokestatic 237	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
        //   390: new 12	com/tencent/mm/ui/chatting/component/ag$5$2
        //   393: dup
        //   394: aload_0
        //   395: invokespecial 238	com/tencent/mm/ui/chatting/component/ag$5$2:<init>	(Lcom/tencent/mm/ui/chatting/component/ag$5;)V
        //   398: invokestatic 244	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   401: ldc 61
        //   403: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   406: return
        //   407: aload 13
        //   409: invokestatic 249	com/tencent/mm/modelappbrand/b:b	(Lcom/tencent/mm/message/k$b;)Z
        //   412: ifne +11 -> 423
        //   415: aload 13
        //   417: invokestatic 252	com/tencent/mm/modelappbrand/b:c	(Lcom/tencent/mm/message/k$b;)Z
        //   420: ifeq +67 -> 487
        //   423: aload 12
        //   425: invokestatic 258	com/tencent/mm/chatroom/d/ad:g	(Lcom/tencent/mm/storage/cc;)Lcom/tencent/mm/chatroom/storage/GroupToolItem;
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
        //   458: invokespecial 269	com/tencent/mm/ui/chatting/component/ag$5:b	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   461: ifeq +26 -> 487
        //   464: aload_0
        //   465: invokespecial 110	com/tencent/mm/ui/chatting/component/ag$5:jsA	()Z
        //   468: ifeq +19 -> 487
        //   471: iconst_1
        //   472: istore 7
        //   474: aload_0
        //   475: invokespecial 110	com/tencent/mm/ui/chatting/component/ag$5:jsA	()Z
        //   478: ifeq +322 -> 800
        //   481: iconst_1
        //   482: istore 7
        //   484: goto +316 -> 800
        //   487: aload 12
        //   489: invokestatic 273	com/tencent/mm/chatroom/d/ad:h	(Lcom/tencent/mm/storage/cc;)Z
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
        //   516: invokevirtual 282	com/tencent/mm/storage/cc:getCreateTime	()J
        //   519: invokespecial 285	com/tencent/mm/chatroom/storage/GroupToolItem:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
        //   522: invokespecial 269	com/tencent/mm/ui/chatting/component/ag$5:b	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   525: ifeq -318 -> 207
        //   528: aload_0
        //   529: invokespecial 110	com/tencent/mm/ui/chatting/component/ag$5:jsA	()Z
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
        //   553: getfield 36	com/tencent/mm/ui/chatting/component/ag$5:aetH	Ljava/util/ArrayList;
        //   556: invokevirtual 57	java/util/ArrayList:size	()I
        //   559: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   562: aastore
        //   563: dup
        //   564: iconst_1
        //   565: aload_0
        //   566: getfield 36	com/tencent/mm/ui/chatting/component/ag$5:aetH	Ljava/util/ArrayList;
        //   569: invokestatic 291	com/tencent/mm/ui/chatting/component/ag:nz	(Ljava/util/List;)Ljava/lang/String;
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
        //   596: getfield 21	com/tencent/mm/ui/chatting/component/ag$5:aetG	Lcom/tencent/mm/ui/chatting/component/ag;
        //   599: getfield 88	com/tencent/mm/ui/chatting/component/ag:hlc	Lcom/tencent/mm/ui/chatting/d/a;
        //   602: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   605: putfield 295	com/tencent/mm/chatroom/storage/e:field_chatroomname	Ljava/lang/String;
        //   608: aload 11
        //   610: astore 10
        //   612: aload 10
        //   614: iconst_1
        //   615: putfield 298	com/tencent/mm/chatroom/storage/e:field_queryState	I
        //   618: aload 10
        //   620: getfield 224	com/tencent/mm/chatroom/storage/e:lzF	Ljava/util/LinkedList;
        //   623: invokevirtual 301	java/util/LinkedList:size	()I
        //   626: istore_1
        //   627: aload 10
        //   629: getfield 224	com/tencent/mm/chatroom/storage/e:lzF	Ljava/util/LinkedList;
        //   632: invokevirtual 302	java/util/LinkedList:clear	()V
        //   635: aload 10
        //   637: getfield 224	com/tencent/mm/chatroom/storage/e:lzF	Ljava/util/LinkedList;
        //   640: aload_0
        //   641: getfield 36	com/tencent/mm/ui/chatting/component/ag$5:aetH	Ljava/util/ArrayList;
        //   644: invokevirtual 303	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   647: pop
        //   648: aload 10
        //   650: aload_0
        //   651: getfield 36	com/tencent/mm/ui/chatting/component/ag$5:aetH	Ljava/util/ArrayList;
        //   654: invokestatic 306	com/tencent/mm/chatroom/storage/e:bt	(Ljava/util/List;)Ljava/lang/String;
        //   657: putfield 309	com/tencent/mm/chatroom/storage/e:field_recentUseToolList	Ljava/lang/String;
        //   660: iload 8
        //   662: ifeq +84 -> 746
        //   665: ldc 74
        //   667: invokestatic 80	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
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
        //   706: getfield 36	com/tencent/mm/ui/chatting/component/ag$5:aetH	Ljava/util/ArrayList;
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
        //   748: invokestatic 80	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
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
        //   227	288	12	localcc	com.tencent.mm.storage.cc
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
  
  private void jsy()
  {
    int k = 0;
    AppMethodBeat.i(179894);
    this.aetn = this.hlc.aezO.getContext().getLayoutInflater().inflate(R.i.gfe, null);
    this.aetp = ((NestedScrollView)this.aetn.findViewById(R.h.root_view));
    this.aets = ((RelativeLayout)this.aetn.findViewById(R.h.fJt));
    this.aeto = ((LinearLayout)this.aetn.findViewById(R.h.fJu));
    this.lBF = ((LinearLayout)this.aetn.findViewById(R.h.fJz));
    this.aetq = ((LinearLayout)this.aetn.findViewById(R.h.fJA));
    this.lBG = ((RecyclerView)this.aetn.findViewById(R.h.fJB));
    this.lBH = ((LinearLayout)this.aetn.findViewById(R.h.fJw));
    this.aetr = ((LinearLayout)this.aetn.findViewById(R.h.fJx));
    this.lBI = ((RecyclerView)this.aetn.findViewById(R.h.fJy));
    this.wQf = ((ImageView)this.aetn.findViewById(R.h.fJv));
    this.UfQ = this.aetn.findViewById(R.h.fJs);
    this.aets.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179868);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupToolsComponet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "downArrowRl click");
        if (ag.c(ag.this) != null) {
          ag.c(ag.this).cyW();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179868);
      }
    });
    this.aetq.setOnClickListener(this.aetE);
    this.aetr.setOnClickListener(this.aetE);
    label313:
    int j;
    label333:
    label358:
    Object localObject2;
    if (this.aetA) {
      if (this.lBP.lzE.size() > 0)
      {
        this.aetq.setVisibility(0);
        this.aetr.setVisibility(8);
        if (this.lBP.lzE.size() <= 0) {
          break label1238;
        }
        this.lBF.setVisibility(0);
        i = 1;
        if (this.aetz.size() <= 0) {
          break label1252;
        }
        this.lBH.setVisibility(0);
        j = 1;
        if ((j != 0) || (i != 0)) {
          break label1266;
        }
        this.aeto.setVisibility(0);
        this.UfQ.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.aetp.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject1).height;
        if (this.lBP.lzE.size() + this.aetz.size() <= 8) {
          break label1286;
        }
        i = com.tencent.mm.cd.a.fromDPToPix(this.hlc.aezO.getContext(), 344);
        label416:
        if (j != i)
        {
          ((RelativeLayout.LayoutParams)localObject1).height = i;
          this.aetp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.wQf.setVisibility(8);
        this.hlc.aezO.getContext();
        this.aetu = new GridLayoutManager(4);
        this.lBG.setLayoutManager(this.aetu);
        this.lBG.setNestedScrollingEnabled(false);
        this.hlc.aezO.getContext();
        this.aetw = new GridLayoutManager(4);
        this.lBI.setLayoutManager(this.aetw);
        this.lBI.setNestedScrollingEnabled(false);
        localObject1 = aw.bf(this.hlc.aezO.getContext());
        if (localObject1 == null) {
          break label1306;
        }
        i = ((Point)localObject1).x;
        label555:
        i = (i - com.tencent.mm.cd.a.bs(this.hlc.aezO.getContext(), R.f.Edge_5A) * 2 - com.tencent.mm.cd.a.bs(this.hlc.aezO.getContext(), R.f.Edge_8A) * 4) / 12;
        this.aetv = new d(this.hlc.aezO.getContext(), this.lBP.lzE, this.aetB);
        this.lBG.setAdapter(this.aetv);
        localObject1 = new ag.c(i);
        this.lBG.a((RecyclerView.h)localObject1);
        this.aetv.bZE.notifyChanged();
        this.aetx = new d(this.hlc.aezO.getContext(), this.aetz, this.aetC);
        this.lBI.setAdapter(this.aetx);
        localObject1 = new ag.c(i);
        this.lBI.a((RecyclerView.h)localObject1);
        this.aetx.bZE.notifyChanged();
        this.aetp.setOnScrollChangeListener(new NestedScrollView.b()
        {
          public final void onScrollChange(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
          {
            AppMethodBeat.i(256287);
            if (paramAnonymousInt2 == 0)
            {
              Log.d("MicroMsg.roomtools.GroupToolsComponet", "TOP SCROLL");
              ag.g(ag.this).setVisibility(8);
              AppMethodBeat.o(256287);
              return;
            }
            Log.d("MicroMsg.roomtools.GroupToolsComponet", "no TOP SCROLL");
            ag.g(ag.this).setVisibility(0);
            AppMethodBeat.o(256287);
          }
        });
        this.aetp.setFocusable(false);
        this.aett = new com.tencent.mm.ui.chatting.view.b(this.hlc.aezO.getContext(), this.aetn);
        this.aett.aeLi = new f.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(185888);
            if (ag.h(ag.this) != null) {
              ag.h(ag.this).eG(33);
            }
            AppMethodBeat.o(185888);
          }
        };
        localObject1 = this.aett;
        ((com.tencent.mm.ui.chatting.view.b)localObject1).aeLj = false;
        ((com.tencent.mm.ui.chatting.view.b)localObject1).sRw = ((com.tencent.mm.ui.chatting.view.b)localObject1).isLandscape();
        ((com.tencent.mm.ui.chatting.view.b)localObject1).sRx = ((com.tencent.mm.ui.chatting.view.b)localObject1).getRotation();
        if (((com.tencent.mm.ui.chatting.view.b)localObject1).sRs != null)
        {
          localObject2 = (FrameLayout.LayoutParams)((com.tencent.mm.ui.chatting.view.b)localObject1).rootView.getLayoutParams();
          if ((((com.tencent.mm.ui.chatting.view.b)localObject1).sRw) && (((com.tencent.mm.ui.chatting.view.b)localObject1).mF != null))
          {
            localObject3 = new Rect();
            ((com.tencent.mm.ui.chatting.view.b)localObject1).mF.getWindowVisibleDisplayFrame((Rect)localObject3);
            ((FrameLayout.LayoutParams)localObject2).width = ((Rect)localObject3).right;
          }
          ((com.tencent.mm.ui.chatting.view.b)localObject1).rootView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (Build.VERSION.SDK_INT >= 21) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.getWindow().addFlags(-2147483648);
          }
          if (!((com.tencent.mm.ui.chatting.view.b)localObject1).sRz) {
            break label1329;
          }
          ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.getWindow().setFlags(8, 8);
          ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.getWindow().addFlags(131200);
          ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.getWindow().getDecorView().setSystemUiVisibility(6);
          label985:
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).sRv != null) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).sRv.dqC = false;
          }
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).aeLi != null) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.setOnDismissListener(new b.2((com.tencent.mm.ui.chatting.view.b)localObject1));
          }
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).mF != null) {
            if (((com.tencent.mm.ui.chatting.view.b)localObject1).mP != null) {
              break label1388;
            }
          }
        }
      }
    }
    label1238:
    label1252:
    label1388:
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.ui.chatting.view.b)localObject1).mP = ((com.tencent.mm.ui.chatting.view.b)localObject1).mF.getViewTreeObserver();
      if (i != 0) {
        ((com.tencent.mm.ui.chatting.view.b)localObject1).mP.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject1);
      }
      if (((((com.tencent.mm.ui.chatting.view.b)localObject1).mContext instanceof Activity)) && (!((Activity)((com.tencent.mm.ui.chatting.view.b)localObject1).mContext).isFinishing())) {
        ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.show();
      }
      if (this.aetp != null) {
        this.aetp.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185889);
            ag.h(ag.this).eG(33);
            AppMethodBeat.o(185889);
          }
        });
      }
      localObject2 = new StringBuilder();
      localObject1 = this.lBP.lzE.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
      }
      if (this.aetz.size() > 0)
      {
        this.aetq.setVisibility(8);
        this.aetr.setVisibility(0);
        break;
      }
      this.aetq.setVisibility(8);
      this.aetr.setVisibility(8);
      break;
      this.lBF.setVisibility(8);
      i = 0;
      break label313;
      this.lBH.setVisibility(8);
      j = 0;
      break label333;
      label1266:
      this.aeto.setVisibility(8);
      this.UfQ.setVisibility(0);
      break label358;
      i = com.tencent.mm.cd.a.fromDPToPix(this.hlc.aezO.getContext(), 264);
      break label416;
      i = this.hlc.aezO.getContext().getResources().getDisplayMetrics().widthPixels;
      break label555;
      ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.getWindow().clearFlags(8);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.getWindow().clearFlags(131072);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.getWindow().clearFlags(128);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).sRs.getWindow().getDecorView().setSystemUiVisibility(0);
      break label985;
    }
    label1286:
    label1306:
    label1329:
    Object localObject3 = new StringBuilder();
    Object localObject1 = this.aetz.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject3).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
    }
    localObject1 = this.hlc.getTalkerUserName();
    int m;
    if (this.lBP == null)
    {
      j = 0;
      m = this.aetz.size();
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!ab.Jf((String)localObject1)) {
        break label1606;
      }
      i = 2;
    }
    for (;;)
    {
      at localat = new at();
      localat.kH((String)localObject1);
      localat.ila = 2L;
      localat.ipv = j;
      localat.ipw = m;
      localat.ips = i;
      localat.ipz = localat.F("topAppList", (String)localObject2, true);
      localat.ipA = localat.F("usedAppList", (String)localObject3, true);
      localat.bMH();
      AppMethodBeat.o(179894);
      return;
      j = this.lBP.lzE.size();
      break;
      label1606:
      i = k;
      if (ab.Je((String)localObject1)) {
        i = 1;
      }
    }
  }
  
  private void jsz()
  {
    AppMethodBeat.i(255897);
    this.lBP = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().Db(this.hlc.getTalkerUserName());
    if (this.lBP == null)
    {
      e locale = new e();
      locale.field_chatroomname = this.hlc.getTalkerUserName();
      boolean bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(locale);
      if (bool) {
        this.lBP = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().Db(this.hlc.getTalkerUserName());
      }
      Log.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools insert GroupTools: result(%s)", new Object[] { Boolean.valueOf(bool) });
    }
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools start:%s queryRecentUse:%s state:%s", new Object[] { this.hlc.getTalkerUserName(), Boolean.TRUE, Integer.valueOf(this.lBP.field_queryState) });
    if (this.lBP.field_queryState == 1)
    {
      this.aetz.clear();
      this.aetz.addAll(this.lBP.lzF);
      Collections.sort(this.aetz, new Comparator() {});
      jsy();
      AppMethodBeat.o(255897);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179856);
        if (ag.this.aety != null) {}
        for (Object localObject = Boolean.valueOf(ag.this.aety.isAlive());; localObject = "null")
        {
          Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentToolsThread interrupt() %s", new Object[] { localObject });
          if ((ag.this.aety != null) && (ag.this.aety.isAlive())) {
            ag.this.aety.interrupt();
          }
          AppMethodBeat.o(179856);
          return;
        }
      }
    }, 5000L);
    this.aety = new Thread(this.aetF);
    this.aety.start();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179860);
        if ((ag.this.aety != null) && (ag.this.aety.isAlive())) {
          ag.i(ag.this);
        }
        AppMethodBeat.o(179860);
      }
    }, 200L);
    AppMethodBeat.o(255897);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(179884);
    super.jjg();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179884);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(179885);
    super.jjh();
    String str = this.hlc.getTalkerUserName();
    if ((!Util.isNullOrNil(str)) && (au.bwG(str)) && (ab.Je(str)))
    {
      this.aetA = true;
      AppMethodBeat.o(179885);
      return;
    }
    this.aetA = false;
    AppMethodBeat.o(179885);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(179889);
    super.jji();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingResume");
    this.aetD.dead();
    AppMethodBeat.o(179889);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(179890);
    super.jjj();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingPause");
    AppMethodBeat.o(179890);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(179886);
    super.jjk();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingExitAnimStart");
    this.aetD.dead();
    AppMethodBeat.o(179886);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(179887);
    super.jqF();
    this.hBY = false;
    if (this.aetn != null) {
      this.aetn.setVisibility(8);
    }
    AppMethodBeat.o(179887);
  }
  
  public final void jsx()
  {
    AppMethodBeat.i(179888);
    jsz();
    AppMethodBeat.o(179888);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
  
  public static final class d
    extends RecyclerView.a
  {
    private ag.a aetK;
    private Context context;
    private List<GroupToolItem> lCi;
    
    public d(Context paramContext, List<GroupToolItem> paramList, ag.a parama)
    {
      this.context = paramContext;
      this.lCi = paramList;
      this.aetK = parama;
    }
    
    private static void a(ag.b paramb, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(179880);
      com.tencent.mm.modelimage.loader.a locala = r.bKe();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramb.lPb, ag.b.lCf);
        localObject = paramb.aetd;
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
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(256289);
      paramViewGroup = new ag.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gfd, paramViewGroup, false));
      AppMethodBeat.o(256289);
      return paramViewGroup;
    }
    
    public final void d(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(256293);
      GroupToolItem localGroupToolItem;
      if ((this.lCi != null) && (paramInt >= 0) && (paramInt < this.lCi.size()))
      {
        paramv = (ag.b)paramv;
        localGroupToolItem = (GroupToolItem)this.lCi.get(paramInt);
        paramv.lBX.setVisibility(0);
        if (!localGroupToolItem.aMh()) {
          break label112;
        }
        paramv.lPb.setImageResource(R.g.group_tool_aa_pay);
        paramv.aetd.setText(R.l.gJn);
      }
      for (;;)
      {
        paramv.lBX.setTag(localGroupToolItem);
        paramv.lBX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179877);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (ag.d.a(ag.d.this) != null) {
              ag.d.a(ag.d.this).onClick(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179877);
          }
        });
        AppMethodBeat.o(256293);
        return;
        label112:
        if (localGroupToolItem.aMi())
        {
          paramv.lPb.setImageDrawable(com.tencent.mm.cd.a.m(this.context, R.g.group_tool_live));
          paramv.aetd.setText(R.l.app_field_live);
        }
        else
        {
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(localGroupToolItem.username);
          if (localWxaAttributes == null) {
            ((com.tencent.mm.plugin.appbrand.service.s)h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).a(localGroupToolItem.username, new s.a()
            {
              public final void onGetWeAppInfo(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(179876);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179875);
                    ag.d.b(ag.d.1.this.aetL, paramAnonymousWxaAttributes);
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
      int i = this.lCi.size();
      AppMethodBeat.o(179881);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ag
 * JD-Core Version:    0.7.0.1
 */