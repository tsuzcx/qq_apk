package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.ui.GroupToolsManagereUI;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.b.a.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.view.b;
import com.tencent.mm.ui.chatting.view.b.2;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=v.class)
public class y
  extends a
  implements v
{
  public static final Long HVC;
  private View HVD;
  private LinearLayout HVE;
  private NestedScrollView HVF;
  private LinearLayout HVG;
  private LinearLayout HVH;
  private RelativeLayout HVI;
  private b HVJ;
  private GridLayoutManager HVK;
  private d HVL;
  private GridLayoutManager HVM;
  private d HVN;
  protected Thread HVO;
  private ArrayList<GroupToolItem> HVP;
  private boolean HVQ;
  private a HVR;
  private a HVS;
  private com.tencent.mm.sdk.b.c<mu> HVT;
  private View.OnClickListener HVU;
  private Runnable HVV;
  private View HiH;
  private boolean daU;
  private LinearLayout fvb;
  private RecyclerView fvc;
  private LinearLayout fvd;
  private RecyclerView fve;
  private com.tencent.mm.chatroom.storage.c fvl;
  private long lTu;
  private ImageView opm;
  private p tipDialog;
  
  static
  {
    AppMethodBeat.i(179908);
    HVC = Long.valueOf(604800000L);
    AppMethodBeat.o(179908);
  }
  
  public y()
  {
    AppMethodBeat.i(179883);
    this.tipDialog = null;
    this.fvl = null;
    this.HVP = new ArrayList();
    this.HVQ = false;
    this.lTu = 0L;
    this.daU = false;
    this.HVR = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179854);
        ac.i("MicroMsg.roomtools.GroupToolsComponet", "iStickToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.VW()) {
            break label78;
          }
          y.a(y.this);
        }
        for (;;)
        {
          y.a(y.this, paramAnonymousView, true);
          if (y.c(y.this) != null) {
            y.c(y.this).bmi();
          }
          AppMethodBeat.o(179854);
          return;
          label78:
          if (paramAnonymousView.VX()) {
            y.b(y.this);
          } else {
            y.a(y.this, paramAnonymousView, "1", true);
          }
        }
      }
    };
    this.HVS = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179864);
        ac.i("MicroMsg.roomtools.GroupToolsComponet", "iRecentUseToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.VW()) {
            break label78;
          }
          y.a(y.this);
        }
        for (;;)
        {
          y.a(y.this, paramAnonymousView, false);
          if (y.c(y.this) != null) {
            y.c(y.this).bmi();
          }
          AppMethodBeat.o(179864);
          return;
          label78:
          if (paramAnonymousView.VX()) {
            y.b(y.this);
          } else {
            y.a(y.this, paramAnonymousView, "2", false);
          }
        }
      }
    };
    this.HVT = new com.tencent.mm.sdk.b.c() {};
    this.HVU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179867);
        ac.i("MicroMsg.roomtools.GroupToolsComponet", "stickManagerLl click");
        Object localObject = new Intent(y.this.cLy.HZF.getContext(), GroupToolsManagereUI.class);
        ((Intent)localObject).putExtra("key_chatroomname", y.this.cLy.getTalkerUserName());
        ((Intent)localObject).putParcelableArrayListExtra("key_recent_use_tools", y.e(y.this));
        paramAnonymousView = y.this.cLy.HZF.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        y.f(y.this).alive();
        AppMethodBeat.o(179867);
      }
    };
    this.HVV = new Runnable()
    {
      private ArrayList<GroupToolItem> HVX;
      
      private boolean a(GroupToolItem paramAnonymousGroupToolItem)
      {
        AppMethodBeat.i(185885);
        if (paramAnonymousGroupToolItem == null)
        {
          AppMethodBeat.o(185885);
          return false;
        }
        if (this.HVX.contains(paramAnonymousGroupToolItem))
        {
          AppMethodBeat.o(185885);
          return false;
        }
        this.HVX.add(paramAnonymousGroupToolItem);
        AppMethodBeat.o(185885);
        return true;
      }
      
      private boolean fnz()
      {
        AppMethodBeat.i(185886);
        if (this.HVX.size() >= 20)
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
        //   5: invokestatic 67	com/tencent/mm/model/ce:azI	()J
        //   8: lstore_3
        //   9: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   12: lload_3
        //   13: lcmp
        //   14: ifle +780 -> 794
        //   17: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   20: lstore_3
        //   21: invokestatic 67	com/tencent/mm/model/ce:azI	()J
        //   24: lstore 5
        //   26: ldc 74
        //   28: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   31: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   34: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/d;
        //   37: aload_0
        //   38: getfield 21	com/tencent/mm/ui/chatting/c/y$5:HVW	Lcom/tencent/mm/ui/chatting/c/y;
        //   41: getfield 88	com/tencent/mm/ui/chatting/c/y:cLy	Lcom/tencent/mm/ui/chatting/d/a;
        //   44: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   47: invokevirtual 100	com/tencent/mm/chatroom/storage/d:sb	(Ljava/lang/String;)Lcom/tencent/mm/chatroom/storage/c;
        //   50: astore 10
        //   52: aload_0
        //   53: getfield 36	com/tencent/mm/ui/chatting/c/y$5:HVX	Ljava/util/ArrayList;
        //   56: invokevirtual 103	java/util/ArrayList:clear	()V
        //   59: iconst_0
        //   60: istore 7
        //   62: iconst_0
        //   63: istore_1
        //   64: invokestatic 108	java/lang/Thread:interrupted	()Z
        //   67: ifne +474 -> 541
        //   70: aload_0
        //   71: invokespecial 110	com/tencent/mm/ui/chatting/c/y$5:fnz	()Z
        //   74: ifne +467 -> 541
        //   77: iload 7
        //   79: ifne +462 -> 541
        //   82: iload_1
        //   83: bipush 26
        //   85: if_icmpge +456 -> 541
        //   88: ldc 112
        //   90: invokestatic 116	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   93: checkcast 112	com/tencent/mm/plugin/messenger/foundation/a/k
        //   96: invokeinterface 120 1 0
        //   101: aload_0
        //   102: getfield 21	com/tencent/mm/ui/chatting/c/y$5:HVW	Lcom/tencent/mm/ui/chatting/c/y;
        //   105: getfield 88	com/tencent/mm/ui/chatting/c/y:cLy	Lcom/tencent/mm/ui/chatting/d/a;
        //   108: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   111: lload_3
        //   112: iload_1
        //   113: iconst_1
        //   114: iadd
        //   115: i2l
        //   116: getstatic 124	com/tencent/mm/ui/chatting/c/y:HVC	Ljava/lang/Long;
        //   119: invokevirtual 129	java/lang/Long:longValue	()J
        //   122: lmul
        //   123: lsub
        //   124: lload_3
        //   125: iload_1
        //   126: i2l
        //   127: getstatic 124	com/tencent/mm/ui/chatting/c/y:HVC	Ljava/lang/Long;
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
        //   177: invokestatic 153	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   224: checkcast 168	com/tencent/mm/storage/bo
        //   227: astore 12
        //   229: aload 12
        //   231: getfield 174	com/tencent/mm/g/c/dy:euk	I
        //   234: iconst_4
        //   235: iand
        //   236: iconst_4
        //   237: if_icmpeq -30 -> 207
        //   240: aload 12
        //   242: invokevirtual 177	com/tencent/mm/storage/bo:getType	()I
        //   245: sipush 10000
        //   248: if_icmpeq -41 -> 207
        //   251: aload 12
        //   253: getfield 181	com/tencent/mm/g/c/dy:field_content	Ljava/lang/String;
        //   256: invokestatic 187	com/tencent/mm/ah/k$b:vA	(Ljava/lang/String;)Lcom/tencent/mm/ah/k$b;
        //   259: astore 13
        //   261: aload 13
        //   263: ifnonnull +144 -> 407
        //   266: ldc 140
        //   268: ldc 189
        //   270: invokestatic 193	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
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
        //   305: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   308: invokestatic 67	com/tencent/mm/model/ce:azI	()J
        //   311: lstore_3
        //   312: ldc 140
        //   314: ldc 212
        //   316: iconst_2
        //   317: anewarray 4	java/lang/Object
        //   320: dup
        //   321: iconst_0
        //   322: aload_0
        //   323: getfield 21	com/tencent/mm/ui/chatting/c/y$5:HVW	Lcom/tencent/mm/ui/chatting/c/y;
        //   326: getfield 88	com/tencent/mm/ui/chatting/c/y:cLy	Lcom/tencent/mm/ui/chatting/d/a;
        //   329: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   332: aastore
        //   333: dup
        //   334: iconst_1
        //   335: lload_3
        //   336: lload 5
        //   338: lsub
        //   339: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   342: aastore
        //   343: invokestatic 153	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   346: aload_0
        //   347: getfield 21	com/tencent/mm/ui/chatting/c/y$5:HVW	Lcom/tencent/mm/ui/chatting/c/y;
        //   350: invokestatic 218	com/tencent/mm/ui/chatting/c/y:e	(Lcom/tencent/mm/ui/chatting/c/y;)Ljava/util/ArrayList;
        //   353: invokevirtual 103	java/util/ArrayList:clear	()V
        //   356: aload_0
        //   357: getfield 21	com/tencent/mm/ui/chatting/c/y$5:HVW	Lcom/tencent/mm/ui/chatting/c/y;
        //   360: invokestatic 218	com/tencent/mm/ui/chatting/c/y:e	(Lcom/tencent/mm/ui/chatting/c/y;)Ljava/util/ArrayList;
        //   363: aload 10
        //   365: getfield 224	com/tencent/mm/chatroom/storage/c:ftq	Ljava/util/LinkedList;
        //   368: invokevirtual 228	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   371: pop
        //   372: aload_0
        //   373: getfield 21	com/tencent/mm/ui/chatting/c/y$5:HVW	Lcom/tencent/mm/ui/chatting/c/y;
        //   376: invokestatic 218	com/tencent/mm/ui/chatting/c/y:e	(Lcom/tencent/mm/ui/chatting/c/y;)Ljava/util/ArrayList;
        //   379: new 10	com/tencent/mm/ui/chatting/c/y$5$1
        //   382: dup
        //   383: aload_0
        //   384: invokespecial 231	com/tencent/mm/ui/chatting/c/y$5$1:<init>	(Lcom/tencent/mm/ui/chatting/c/y$5;)V
        //   387: invokestatic 237	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
        //   390: new 12	com/tencent/mm/ui/chatting/c/y$5$2
        //   393: dup
        //   394: aload_0
        //   395: invokespecial 238	com/tencent/mm/ui/chatting/c/y$5$2:<init>	(Lcom/tencent/mm/ui/chatting/c/y$5;)V
        //   398: invokestatic 244	com/tencent/mm/sdk/platformtools/ap:f	(Ljava/lang/Runnable;)V
        //   401: ldc 61
        //   403: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   406: return
        //   407: aload 13
        //   409: invokestatic 250	com/tencent/mm/modelappbrand/a:b	(Lcom/tencent/mm/ah/k$b;)Z
        //   412: ifne +11 -> 423
        //   415: aload 13
        //   417: invokestatic 253	com/tencent/mm/modelappbrand/a:c	(Lcom/tencent/mm/ah/k$b;)Z
        //   420: ifeq +67 -> 487
        //   423: aload 12
        //   425: invokestatic 259	com/tencent/mm/chatroom/d/aa:g	(Lcom/tencent/mm/storage/bo;)Lcom/tencent/mm/chatroom/storage/GroupToolItem;
        //   428: astore 13
        //   430: aload 13
        //   432: ifnull +55 -> 487
        //   435: ldc 140
        //   437: ldc_w 261
        //   440: iconst_1
        //   441: anewarray 4	java/lang/Object
        //   444: dup
        //   445: iconst_0
        //   446: aload 13
        //   448: invokevirtual 266	com/tencent/mm/chatroom/storage/GroupToolItem:toString	()Ljava/lang/String;
        //   451: aastore
        //   452: invokestatic 268	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   455: aload_0
        //   456: aload 13
        //   458: invokespecial 270	com/tencent/mm/ui/chatting/c/y$5:a	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   461: ifeq +26 -> 487
        //   464: aload_0
        //   465: invokespecial 110	com/tencent/mm/ui/chatting/c/y$5:fnz	()Z
        //   468: ifeq +19 -> 487
        //   471: iconst_1
        //   472: istore 7
        //   474: aload_0
        //   475: invokespecial 110	com/tencent/mm/ui/chatting/c/y$5:fnz	()Z
        //   478: ifeq +322 -> 800
        //   481: iconst_1
        //   482: istore 7
        //   484: goto +316 -> 800
        //   487: aload 12
        //   489: invokestatic 274	com/tencent/mm/chatroom/d/aa:h	(Lcom/tencent/mm/storage/bo;)Z
        //   492: ifeq -285 -> 207
        //   495: ldc 140
        //   497: ldc_w 276
        //   500: invokestatic 193	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   503: aload_0
        //   504: new 263	com/tencent/mm/chatroom/storage/GroupToolItem
        //   507: dup
        //   508: ldc_w 278
        //   511: ldc_w 280
        //   514: aload 12
        //   516: getfield 284	com/tencent/mm/g/c/dy:field_createTime	J
        //   519: invokespecial 287	com/tencent/mm/chatroom/storage/GroupToolItem:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
        //   522: invokespecial 270	com/tencent/mm/ui/chatting/c/y$5:a	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   525: ifeq -318 -> 207
        //   528: aload_0
        //   529: invokespecial 110	com/tencent/mm/ui/chatting/c/y$5:fnz	()Z
        //   532: ifeq -325 -> 207
        //   535: iconst_1
        //   536: istore 7
        //   538: goto -64 -> 474
        //   541: ldc 140
        //   543: ldc_w 289
        //   546: iconst_2
        //   547: anewarray 4	java/lang/Object
        //   550: dup
        //   551: iconst_0
        //   552: aload_0
        //   553: getfield 36	com/tencent/mm/ui/chatting/c/y$5:HVX	Ljava/util/ArrayList;
        //   556: invokevirtual 57	java/util/ArrayList:size	()I
        //   559: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   562: aastore
        //   563: dup
        //   564: iconst_1
        //   565: aload_0
        //   566: getfield 36	com/tencent/mm/ui/chatting/c/y$5:HVX	Ljava/util/ArrayList;
        //   569: invokestatic 293	com/tencent/mm/ui/chatting/c/y:hS	(Ljava/util/List;)Ljava/lang/String;
        //   572: aastore
        //   573: invokestatic 268	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   576: aload 10
        //   578: ifnonnull +207 -> 785
        //   581: iconst_0
        //   582: istore 8
        //   584: new 220	com/tencent/mm/chatroom/storage/c
        //   587: dup
        //   588: invokespecial 294	com/tencent/mm/chatroom/storage/c:<init>	()V
        //   591: astore 11
        //   593: aload 11
        //   595: aload_0
        //   596: getfield 21	com/tencent/mm/ui/chatting/c/y$5:HVW	Lcom/tencent/mm/ui/chatting/c/y;
        //   599: getfield 88	com/tencent/mm/ui/chatting/c/y:cLy	Lcom/tencent/mm/ui/chatting/d/a;
        //   602: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   605: putfield 297	com/tencent/mm/chatroom/storage/c:field_chatroomname	Ljava/lang/String;
        //   608: aload 11
        //   610: astore 10
        //   612: aload 10
        //   614: iconst_1
        //   615: putfield 300	com/tencent/mm/chatroom/storage/c:field_queryState	I
        //   618: aload 10
        //   620: getfield 224	com/tencent/mm/chatroom/storage/c:ftq	Ljava/util/LinkedList;
        //   623: invokevirtual 303	java/util/LinkedList:size	()I
        //   626: istore_1
        //   627: aload 10
        //   629: getfield 224	com/tencent/mm/chatroom/storage/c:ftq	Ljava/util/LinkedList;
        //   632: invokevirtual 304	java/util/LinkedList:clear	()V
        //   635: aload 10
        //   637: getfield 224	com/tencent/mm/chatroom/storage/c:ftq	Ljava/util/LinkedList;
        //   640: aload_0
        //   641: getfield 36	com/tencent/mm/ui/chatting/c/y$5:HVX	Ljava/util/ArrayList;
        //   644: invokevirtual 305	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   647: pop
        //   648: aload 10
        //   650: aload_0
        //   651: getfield 36	com/tencent/mm/ui/chatting/c/y$5:HVX	Ljava/util/ArrayList;
        //   654: invokestatic 308	com/tencent/mm/chatroom/storage/c:O	(Ljava/util/List;)Ljava/lang/String;
        //   657: putfield 311	com/tencent/mm/chatroom/storage/c:field_recentUseToolList	Ljava/lang/String;
        //   660: iload 8
        //   662: ifeq +84 -> 746
        //   665: ldc 74
        //   667: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   670: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   673: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/d;
        //   676: aload 10
        //   678: iconst_0
        //   679: anewarray 313	java/lang/String
        //   682: invokevirtual 316	com/tencent/mm/chatroom/storage/d:a	(Lcom/tencent/mm/chatroom/storage/c;[Ljava/lang/String;)Z
        //   685: istore 9
        //   687: ldc 140
        //   689: ldc_w 318
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
        //   706: getfield 36	com/tencent/mm/ui/chatting/c/y$5:HVX	Ljava/util/ArrayList;
        //   709: invokevirtual 57	java/util/ArrayList:size	()I
        //   712: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   715: aastore
        //   716: dup
        //   717: iconst_2
        //   718: iload 8
        //   720: invokestatic 323	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   723: aastore
        //   724: dup
        //   725: iconst_3
        //   726: iload 7
        //   728: invokestatic 323	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   731: aastore
        //   732: dup
        //   733: iconst_4
        //   734: iload 9
        //   736: invokestatic 323	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   739: aastore
        //   740: invokestatic 153	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   743: goto -435 -> 308
        //   746: ldc 74
        //   748: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   751: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   754: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/d;
        //   757: aload 10
        //   759: invokevirtual 326	com/tencent/mm/chatroom/storage/d:a	(Lcom/tencent/mm/chatroom/storage/c;)Z
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
        //   227	288	12	localbo	com.tencent.mm.storage.bo
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
  
  private void fnx()
  {
    int k = 0;
    AppMethodBeat.i(179894);
    this.HVD = this.cLy.HZF.getContext().getLayoutInflater().inflate(2131493406, null);
    this.HVF = ((NestedScrollView)this.HVD.findViewById(2131304251));
    this.HVI = ((RelativeLayout)this.HVD.findViewById(2131300658));
    this.HVE = ((LinearLayout)this.HVD.findViewById(2131300659));
    this.fvb = ((LinearLayout)this.HVD.findViewById(2131300664));
    this.HVG = ((LinearLayout)this.HVD.findViewById(2131300665));
    this.fvc = ((RecyclerView)this.HVD.findViewById(2131300666));
    this.fvd = ((LinearLayout)this.HVD.findViewById(2131300661));
    this.HVH = ((LinearLayout)this.HVD.findViewById(2131300662));
    this.fve = ((RecyclerView)this.HVD.findViewById(2131300663));
    this.opm = ((ImageView)this.HVD.findViewById(2131300660));
    this.HiH = this.HVD.findViewById(2131300656);
    this.HVI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179868);
        ac.i("MicroMsg.roomtools.GroupToolsComponet", "downArrowRl click");
        if (y.c(y.this) != null) {
          y.c(y.this).bmi();
        }
        AppMethodBeat.o(179868);
      }
    });
    this.HVG.setOnClickListener(this.HVU);
    this.HVH.setOnClickListener(this.HVU);
    label313:
    int j;
    label333:
    label358:
    Object localObject2;
    if (this.HVQ) {
      if (this.fvl.ftp.size() > 0)
      {
        this.HVG.setVisibility(0);
        this.HVH.setVisibility(8);
        if (this.fvl.ftp.size() <= 0) {
          break label1230;
        }
        this.fvb.setVisibility(0);
        i = 1;
        if (this.HVP.size() <= 0) {
          break label1244;
        }
        this.fvd.setVisibility(0);
        j = 1;
        if ((j != 0) || (i != 0)) {
          break label1258;
        }
        this.HVE.setVisibility(0);
        this.HiH.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.HVF.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject1).height;
        if (this.fvl.ftp.size() + this.HVP.size() <= 8) {
          break label1278;
        }
        i = com.tencent.mm.cc.a.fromDPToPix(this.cLy.HZF.getContext(), 344);
        label416:
        if (j != i)
        {
          ((RelativeLayout.LayoutParams)localObject1).height = i;
          this.HVF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.opm.setVisibility(8);
        this.cLy.HZF.getContext();
        this.HVK = new GridLayoutManager(4);
        this.fvc.setLayoutManager(this.HVK);
        this.fvc.setNestedScrollingEnabled(false);
        this.cLy.HZF.getContext();
        this.HVM = new GridLayoutManager(4);
        this.fve.setLayoutManager(this.HVM);
        this.fve.setNestedScrollingEnabled(false);
        i = (this.cLy.HZF.getContext().getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cc.a.av(this.cLy.HZF.getContext(), 2131165296) * 2 - com.tencent.mm.cc.a.av(this.cLy.HZF.getContext(), 2131165301) * 4) / 12;
        this.HVL = new d(this.cLy.HZF.getContext(), this.fvl.ftp, this.HVR);
        this.fvc.setAdapter(this.HVL);
        localObject1 = new y.c(i);
        this.fvc.a((RecyclerView.h)localObject1);
        this.HVL.arg.notifyChanged();
        this.HVN = new d(this.cLy.HZF.getContext(), this.HVP, this.HVS);
        this.fve.setAdapter(this.HVN);
        localObject1 = new y.c(i);
        this.fve.a((RecyclerView.h)localObject1);
        this.HVN.arg.notifyChanged();
        this.HVF.setOnScrollChangeListener(new NestedScrollView.b()
        {
          public final void a(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt)
          {
            AppMethodBeat.i(179869);
            if (paramAnonymousInt == 0)
            {
              ac.d("MicroMsg.roomtools.GroupToolsComponet", "TOP SCROLL");
              y.g(y.this).setVisibility(8);
              AppMethodBeat.o(179869);
              return;
            }
            ac.d("MicroMsg.roomtools.GroupToolsComponet", "no TOP SCROLL");
            y.g(y.this).setVisibility(0);
            AppMethodBeat.o(179869);
          }
        });
        this.HVF.setFocusable(false);
        this.HVJ = new b(this.cLy.HZF.getContext(), this.HVD);
        this.HVJ.Ihj = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(185888);
            if (y.h(y.this) != null) {
              y.h(y.this).fullScroll(33);
            }
            AppMethodBeat.o(185888);
          }
        };
        localObject1 = this.HVJ;
        ((b)localObject1).Ihk = false;
        ((b)localObject1).lcE = ((b)localObject1).aly();
        ((b)localObject1).lcF = ((b)localObject1).getRotation();
        if (((b)localObject1).lcA != null)
        {
          localObject2 = (FrameLayout.LayoutParams)((b)localObject1).khe.getLayoutParams();
          if ((((b)localObject1).lcE) && (((b)localObject1).oP != null))
          {
            localObject3 = new Rect();
            ((b)localObject1).oP.getWindowVisibleDisplayFrame((Rect)localObject3);
            ((FrameLayout.LayoutParams)localObject2).width = ((Rect)localObject3).right;
          }
          ((b)localObject1).khe.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (Build.VERSION.SDK_INT >= 21) {
            ((b)localObject1).lcA.getWindow().addFlags(-2147483648);
          }
          if (!((b)localObject1).lcH) {
            break label1298;
          }
          ((b)localObject1).lcA.getWindow().setFlags(8, 8);
          ((b)localObject1).lcA.getWindow().addFlags(131200);
          ((b)localObject1).lcA.getWindow().getDecorView().setSystemUiVisibility(6);
          label977:
          if (((b)localObject1).lcD != null) {
            ((b)localObject1).lcD.mg = false;
          }
          if (((b)localObject1).Ihj != null) {
            ((b)localObject1).lcA.setOnDismissListener(new b.2((b)localObject1));
          }
          if (((b)localObject1).oP != null) {
            if (((b)localObject1).adE != null) {
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
      ((b)localObject1).adE = ((b)localObject1).oP.getViewTreeObserver();
      if (i != 0) {
        ((b)localObject1).adE.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject1);
      }
      if (((((b)localObject1).mContext instanceof Activity)) && (!((Activity)((b)localObject1).mContext).isFinishing())) {
        ((b)localObject1).lcA.show();
      }
      if (this.HVF != null) {
        this.HVF.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185889);
            y.h(y.this).fullScroll(33);
            AppMethodBeat.o(185889);
          }
        });
      }
      localObject2 = new StringBuilder();
      localObject1 = this.fvl.ftp.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
      }
      if (this.HVP.size() > 0)
      {
        this.HVG.setVisibility(8);
        this.HVH.setVisibility(0);
        break;
      }
      this.HVG.setVisibility(8);
      this.HVH.setVisibility(8);
      break;
      label1230:
      this.fvb.setVisibility(8);
      i = 0;
      break label313;
      label1244:
      this.fvd.setVisibility(8);
      j = 0;
      break label333;
      label1258:
      this.HVE.setVisibility(8);
      this.HiH.setVisibility(0);
      break label358;
      label1278:
      i = com.tencent.mm.cc.a.fromDPToPix(this.cLy.HZF.getContext(), 264);
      break label416;
      ((b)localObject1).lcA.getWindow().clearFlags(8);
      ((b)localObject1).lcA.getWindow().clearFlags(131072);
      ((b)localObject1).lcA.getWindow().clearFlags(128);
      ((b)localObject1).lcA.getWindow().getDecorView().setSystemUiVisibility(0);
      break label977;
    }
    Object localObject3 = new StringBuilder();
    Object localObject1 = this.HVP.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject3).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
    }
    localObject1 = this.cLy.getTalkerUserName();
    int m;
    if (this.fvl == null)
    {
      j = 0;
      m = this.HVP.size();
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!w.xB((String)localObject1)) {
        break label1575;
      }
      i = 2;
    }
    for (;;)
    {
      n localn = new n();
      localn.fL((String)localObject1);
      localn.dCS = 2L;
      localn.dFw = j;
      localn.dFx = m;
      localn.dFt = i;
      localn.dFB = localn.t("topAppList", (String)localObject2, true);
      localn.dFC = localn.t("usedAppList", (String)localObject3, true);
      localn.aHZ();
      AppMethodBeat.o(179894);
      return;
      j = this.fvl.ftp.size();
      break;
      label1575:
      i = k;
      if (w.xA((String)localObject1)) {
        i = 1;
      }
    }
  }
  
  private void fny()
  {
    AppMethodBeat.i(196496);
    this.fvl = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().sb(this.cLy.getTalkerUserName());
    if (this.fvl == null)
    {
      com.tencent.mm.chatroom.storage.c localc = new com.tencent.mm.chatroom.storage.c();
      localc.field_chatroomname = this.cLy.getTalkerUserName();
      boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc);
      if (bool) {
        this.fvl = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().sb(this.cLy.getTalkerUserName());
      }
      ac.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools insert GroupTools: result(%s)", new Object[] { Boolean.valueOf(bool) });
    }
    ac.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools start:%s queryRecentUse:%s state:%s", new Object[] { this.cLy.getTalkerUserName(), Boolean.TRUE, Integer.valueOf(this.fvl.field_queryState) });
    if (this.fvl.field_queryState == 1)
    {
      this.HVP.clear();
      this.HVP.addAll(this.fvl.ftq);
      Collections.sort(this.HVP, new Comparator() {});
      fnx();
      AppMethodBeat.o(196496);
      return;
    }
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179856);
        if (y.this.HVO != null) {}
        for (Object localObject = Boolean.valueOf(y.this.HVO.isAlive());; localObject = "null")
        {
          ac.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentToolsThread interrupt() %s", new Object[] { localObject });
          if ((y.this.HVO != null) && (y.this.HVO.isAlive())) {
            y.this.HVO.interrupt();
          }
          AppMethodBeat.o(179856);
          return;
        }
      }
    }, 5000L);
    this.HVO = new Thread(this.HVV);
    this.HVO.start();
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179860);
        if ((y.this.HVO != null) && (y.this.HVO.isAlive())) {
          y.i(y.this);
        }
        AppMethodBeat.o(179860);
      }
    }, 200L);
    AppMethodBeat.o(196496);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(179884);
    super.fgh();
    ac.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179884);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(179885);
    super.fgi();
    String str = this.cLy.getTalkerUserName();
    if ((!bs.isNullOrNil(str)) && (w.wp(str)) && (w.xA(str)))
    {
      this.HVQ = true;
      AppMethodBeat.o(179885);
      return;
    }
    this.HVQ = false;
    AppMethodBeat.o(179885);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(179889);
    super.fgj();
    ac.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingResume");
    this.HVT.dead();
    AppMethodBeat.o(179889);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(179890);
    super.fgk();
    ac.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingPause");
    AppMethodBeat.o(179890);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(179886);
    super.fgl();
    ac.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingExitAnimStart");
    this.HVT.dead();
    AppMethodBeat.o(179886);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(179887);
    super.fmj();
    this.daU = false;
    if (this.HVD != null) {
      this.HVD.setVisibility(8);
    }
    AppMethodBeat.o(179887);
  }
  
  public final void fnw()
  {
    AppMethodBeat.i(179888);
    if (!aa.VQ())
    {
      AppMethodBeat.o(179888);
      return;
    }
    fny();
    AppMethodBeat.o(179888);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
  
  public static final class b
    extends RecyclerView.w
  {
    static final com.tencent.mm.av.a.a.c fvC;
    LinearLayout HVZ;
    TextView HVt;
    ImageView fBA;
    View fvu;
    
    static
    {
      AppMethodBeat.i(179874);
      c.a locala1 = new c.a();
      locala1.hKI = 2131689599;
      c.a locala2 = locala1.de(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20));
      locala2.gLt = true;
      locala2.hKx = true;
      locala2.hKv = true;
      fvC = locala1.aFT();
      AppMethodBeat.o(179874);
    }
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(179873);
      this.fvu = paramView;
      this.HVZ = ((LinearLayout)paramView.findViewById(2131305978));
      this.fBA = ((ImageView)paramView.findViewById(2131305982));
      this.HVt = ((TextView)paramView.findViewById(2131305984));
      AppMethodBeat.o(179873);
    }
  }
  
  public static final class d
    extends RecyclerView.a
  {
    private y.a HWa;
    private Context context;
    private List<GroupToolItem> fvF;
    
    public d(Context paramContext, List<GroupToolItem> paramList, y.a parama)
    {
      this.context = paramContext;
      this.fvF = paramList;
      this.HWa = parama;
    }
    
    private static void a(y.b paramb, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(179880);
      com.tencent.mm.av.a.a locala = o.aFB();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramb.fBA, y.b.fvC);
        localObject = paramb.HVt;
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
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(179878);
      paramViewGroup = new y.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493405, paramViewGroup, false));
      AppMethodBeat.o(179878);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(179879);
      GroupToolItem localGroupToolItem;
      if ((this.fvF != null) && (paramInt >= 0) && (paramInt < this.fvF.size()))
      {
        paramw = (y.b)paramw;
        localGroupToolItem = (GroupToolItem)this.fvF.get(paramInt);
        paramw.fvu.setVisibility(0);
        if (!localGroupToolItem.VW()) {
          break label110;
        }
        paramw.fBA.setImageResource(2131232617);
        paramw.HVt.setText(2131760128);
      }
      for (;;)
      {
        paramw.fvu.setTag(localGroupToolItem);
        paramw.fvu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179877);
            if (y.d.a(y.d.this) != null) {
              y.d.a(y.d.this).onClick(paramAnonymousView);
            }
            AppMethodBeat.o(179877);
          }
        });
        AppMethodBeat.o(179879);
        return;
        label110:
        if (localGroupToolItem.VX())
        {
          paramw.fBA.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131234903));
          paramw.HVt.setText(2131756264);
        }
        else
        {
          WxaAttributes localWxaAttributes = ((m)g.ab(m.class)).Ka(localGroupToolItem.username);
          if (localWxaAttributes == null) {
            ((m)g.ab(m.class)).a(localGroupToolItem.username, new m.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(179876);
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179875);
                    y.d.b(y.d.1.this.HWb, paramAnonymousWxaAttributes);
                    AppMethodBeat.o(179875);
                  }
                });
                AppMethodBeat.o(179876);
              }
            });
          } else {
            a(paramw, localWxaAttributes);
          }
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(179881);
      int i = this.fvF.size();
      AppMethodBeat.o(179881);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.y
 * JD-Core Version:    0.7.0.1
 */