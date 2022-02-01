package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.app.Dialog;
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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.ui.GroupToolsManagereUI;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.b.a.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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

@com.tencent.mm.ui.chatting.c.a.a(eYT=v.class)
public class y
  extends a
  implements v
{
  public static final Long GvL;
  private View FJA;
  private View GvM;
  private LinearLayout GvN;
  private NestedScrollView GvO;
  private LinearLayout GvP;
  private LinearLayout GvQ;
  private RelativeLayout GvR;
  private b GvS;
  private GridLayoutManager GvT;
  private y.d GvU;
  private GridLayoutManager GvV;
  private y.d GvW;
  protected Thread GvX;
  private ArrayList<GroupToolItem> GvY;
  private boolean GvZ;
  private y.a Gwa;
  private y.a Gwb;
  private com.tencent.mm.sdk.b.c<ml> Gwc;
  private View.OnClickListener Gwd;
  private Runnable Gwe;
  private boolean ddw;
  private com.tencent.mm.chatroom.storage.c frE;
  private LinearLayout fru;
  private RecyclerView frv;
  private LinearLayout frw;
  private RecyclerView frx;
  private long lrz;
  private ImageView nMm;
  private p tipDialog;
  
  static
  {
    AppMethodBeat.i(179908);
    GvL = Long.valueOf(604800000L);
    AppMethodBeat.o(179908);
  }
  
  public y()
  {
    AppMethodBeat.i(179883);
    this.tipDialog = null;
    this.frE = null;
    this.GvY = new ArrayList();
    this.GvZ = false;
    this.lrz = 0L;
    this.ddw = false;
    this.Gwa = new y.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179854);
        ad.i("MicroMsg.roomtools.GroupToolsComponet", "iStickToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.Va()) {
            break label78;
          }
          y.a(y.this);
        }
        for (;;)
        {
          y.a(y.this, paramAnonymousView, true);
          if (y.c(y.this) != null) {
            y.c(y.this).bfo();
          }
          AppMethodBeat.o(179854);
          return;
          label78:
          if (paramAnonymousView.ccm()) {
            y.b(y.this);
          } else {
            y.a(y.this, paramAnonymousView, "1", true);
          }
        }
      }
    };
    this.Gwb = new y.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179864);
        ad.i("MicroMsg.roomtools.GroupToolsComponet", "iRecentUseToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.Va()) {
            break label78;
          }
          y.a(y.this);
        }
        for (;;)
        {
          y.a(y.this, paramAnonymousView, false);
          if (y.c(y.this) != null) {
            y.c(y.this).bfo();
          }
          AppMethodBeat.o(179864);
          return;
          label78:
          if (paramAnonymousView.ccm()) {
            y.b(y.this);
          } else {
            y.a(y.this, paramAnonymousView, "2", false);
          }
        }
      }
    };
    this.Gwc = new com.tencent.mm.sdk.b.c() {};
    this.Gwd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179867);
        ad.i("MicroMsg.roomtools.GroupToolsComponet", "stickManagerLl click");
        Object localObject = new Intent(y.this.cOd.GzJ.getContext(), GroupToolsManagereUI.class);
        ((Intent)localObject).putExtra("key_chatroomname", y.this.cOd.getTalkerUserName());
        ((Intent)localObject).putParcelableArrayListExtra("key_recent_use_tools", y.e(y.this));
        paramAnonymousView = y.this.cOd.GzJ.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        y.f(y.this).alive();
        AppMethodBeat.o(179867);
      }
    };
    this.Gwe = new Runnable()
    {
      private ArrayList<GroupToolItem> Gwg;
      
      private boolean a(GroupToolItem paramAnonymousGroupToolItem)
      {
        AppMethodBeat.i(185885);
        if (paramAnonymousGroupToolItem == null)
        {
          AppMethodBeat.o(185885);
          return false;
        }
        if (this.Gwg.contains(paramAnonymousGroupToolItem))
        {
          AppMethodBeat.o(185885);
          return false;
        }
        this.Gwg.add(paramAnonymousGroupToolItem);
        AppMethodBeat.o(185885);
        return true;
      }
      
      private boolean eXN()
      {
        AppMethodBeat.i(185886);
        if (this.Gwg.size() >= 20)
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
        //   5: invokestatic 67	com/tencent/mm/model/ce:asR	()J
        //   8: lstore_3
        //   9: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   12: lload_3
        //   13: lcmp
        //   14: ifle +780 -> 794
        //   17: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   20: lstore_3
        //   21: invokestatic 67	com/tencent/mm/model/ce:asR	()J
        //   24: lstore 5
        //   26: ldc 74
        //   28: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   31: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   34: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/d;
        //   37: aload_0
        //   38: getfield 21	com/tencent/mm/ui/chatting/c/y$5:Gwf	Lcom/tencent/mm/ui/chatting/c/y;
        //   41: getfield 88	com/tencent/mm/ui/chatting/c/y:cOd	Lcom/tencent/mm/ui/chatting/d/a;
        //   44: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   47: invokevirtual 100	com/tencent/mm/chatroom/storage/d:oQ	(Ljava/lang/String;)Lcom/tencent/mm/chatroom/storage/c;
        //   50: astore 10
        //   52: aload_0
        //   53: getfield 36	com/tencent/mm/ui/chatting/c/y$5:Gwg	Ljava/util/ArrayList;
        //   56: invokevirtual 103	java/util/ArrayList:clear	()V
        //   59: iconst_0
        //   60: istore 7
        //   62: iconst_0
        //   63: istore_1
        //   64: invokestatic 108	java/lang/Thread:interrupted	()Z
        //   67: ifne +474 -> 541
        //   70: aload_0
        //   71: invokespecial 110	com/tencent/mm/ui/chatting/c/y$5:eXN	()Z
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
        //   102: getfield 21	com/tencent/mm/ui/chatting/c/y$5:Gwf	Lcom/tencent/mm/ui/chatting/c/y;
        //   105: getfield 88	com/tencent/mm/ui/chatting/c/y:cOd	Lcom/tencent/mm/ui/chatting/d/a;
        //   108: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   111: lload_3
        //   112: iload_1
        //   113: iconst_1
        //   114: iadd
        //   115: i2l
        //   116: getstatic 124	com/tencent/mm/ui/chatting/c/y:GvL	Ljava/lang/Long;
        //   119: invokevirtual 129	java/lang/Long:longValue	()J
        //   122: lmul
        //   123: lsub
        //   124: lload_3
        //   125: iload_1
        //   126: i2l
        //   127: getstatic 124	com/tencent/mm/ui/chatting/c/y:GvL	Ljava/lang/Long;
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
        //   177: invokestatic 153	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   224: checkcast 168	com/tencent/mm/storage/bl
        //   227: astore 12
        //   229: aload 12
        //   231: getfield 174	com/tencent/mm/g/c/du:esg	I
        //   234: iconst_4
        //   235: iand
        //   236: iconst_4
        //   237: if_icmpeq -30 -> 207
        //   240: aload 12
        //   242: invokevirtual 177	com/tencent/mm/storage/bl:getType	()I
        //   245: sipush 10000
        //   248: if_icmpeq -41 -> 207
        //   251: aload 12
        //   253: getfield 181	com/tencent/mm/g/c/du:field_content	Ljava/lang/String;
        //   256: invokestatic 187	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
        //   259: astore 13
        //   261: aload 13
        //   263: ifnonnull +144 -> 407
        //   266: ldc 140
        //   268: ldc 189
        //   270: invokestatic 193	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
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
        //   305: invokestatic 210	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   308: invokestatic 67	com/tencent/mm/model/ce:asR	()J
        //   311: lstore_3
        //   312: ldc 140
        //   314: ldc 212
        //   316: iconst_2
        //   317: anewarray 4	java/lang/Object
        //   320: dup
        //   321: iconst_0
        //   322: aload_0
        //   323: getfield 21	com/tencent/mm/ui/chatting/c/y$5:Gwf	Lcom/tencent/mm/ui/chatting/c/y;
        //   326: getfield 88	com/tencent/mm/ui/chatting/c/y:cOd	Lcom/tencent/mm/ui/chatting/d/a;
        //   329: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   332: aastore
        //   333: dup
        //   334: iconst_1
        //   335: lload_3
        //   336: lload 5
        //   338: lsub
        //   339: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   342: aastore
        //   343: invokestatic 153	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   346: aload_0
        //   347: getfield 21	com/tencent/mm/ui/chatting/c/y$5:Gwf	Lcom/tencent/mm/ui/chatting/c/y;
        //   350: invokestatic 218	com/tencent/mm/ui/chatting/c/y:e	(Lcom/tencent/mm/ui/chatting/c/y;)Ljava/util/ArrayList;
        //   353: invokevirtual 103	java/util/ArrayList:clear	()V
        //   356: aload_0
        //   357: getfield 21	com/tencent/mm/ui/chatting/c/y$5:Gwf	Lcom/tencent/mm/ui/chatting/c/y;
        //   360: invokestatic 218	com/tencent/mm/ui/chatting/c/y:e	(Lcom/tencent/mm/ui/chatting/c/y;)Ljava/util/ArrayList;
        //   363: aload 10
        //   365: getfield 224	com/tencent/mm/chatroom/storage/c:fpN	Ljava/util/LinkedList;
        //   368: invokevirtual 228	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   371: pop
        //   372: aload_0
        //   373: getfield 21	com/tencent/mm/ui/chatting/c/y$5:Gwf	Lcom/tencent/mm/ui/chatting/c/y;
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
        //   398: invokestatic 244	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
        //   401: ldc 61
        //   403: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   406: return
        //   407: aload 13
        //   409: invokestatic 250	com/tencent/mm/modelappbrand/a:b	(Lcom/tencent/mm/ai/k$b;)Z
        //   412: ifne +11 -> 423
        //   415: aload 13
        //   417: invokestatic 253	com/tencent/mm/modelappbrand/a:c	(Lcom/tencent/mm/ai/k$b;)Z
        //   420: ifeq +67 -> 487
        //   423: aload 12
        //   425: invokestatic 259	com/tencent/mm/chatroom/d/aa:g	(Lcom/tencent/mm/storage/bl;)Lcom/tencent/mm/chatroom/storage/GroupToolItem;
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
        //   452: invokestatic 268	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   455: aload_0
        //   456: aload 13
        //   458: invokespecial 270	com/tencent/mm/ui/chatting/c/y$5:a	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   461: ifeq +26 -> 487
        //   464: aload_0
        //   465: invokespecial 110	com/tencent/mm/ui/chatting/c/y$5:eXN	()Z
        //   468: ifeq +19 -> 487
        //   471: iconst_1
        //   472: istore 7
        //   474: aload_0
        //   475: invokespecial 110	com/tencent/mm/ui/chatting/c/y$5:eXN	()Z
        //   478: ifeq +322 -> 800
        //   481: iconst_1
        //   482: istore 7
        //   484: goto +316 -> 800
        //   487: aload 12
        //   489: invokestatic 274	com/tencent/mm/chatroom/d/aa:h	(Lcom/tencent/mm/storage/bl;)Z
        //   492: ifeq -285 -> 207
        //   495: ldc 140
        //   497: ldc_w 276
        //   500: invokestatic 193	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   503: aload_0
        //   504: new 263	com/tencent/mm/chatroom/storage/GroupToolItem
        //   507: dup
        //   508: ldc_w 278
        //   511: ldc_w 280
        //   514: aload 12
        //   516: getfield 283	com/tencent/mm/g/c/du:field_createTime	J
        //   519: invokespecial 286	com/tencent/mm/chatroom/storage/GroupToolItem:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
        //   522: invokespecial 270	com/tencent/mm/ui/chatting/c/y$5:a	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   525: ifeq -318 -> 207
        //   528: aload_0
        //   529: invokespecial 110	com/tencent/mm/ui/chatting/c/y$5:eXN	()Z
        //   532: ifeq -325 -> 207
        //   535: iconst_1
        //   536: istore 7
        //   538: goto -64 -> 474
        //   541: ldc 140
        //   543: ldc_w 288
        //   546: iconst_2
        //   547: anewarray 4	java/lang/Object
        //   550: dup
        //   551: iconst_0
        //   552: aload_0
        //   553: getfield 36	com/tencent/mm/ui/chatting/c/y$5:Gwg	Ljava/util/ArrayList;
        //   556: invokevirtual 57	java/util/ArrayList:size	()I
        //   559: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   562: aastore
        //   563: dup
        //   564: iconst_1
        //   565: aload_0
        //   566: getfield 36	com/tencent/mm/ui/chatting/c/y$5:Gwg	Ljava/util/ArrayList;
        //   569: invokestatic 292	com/tencent/mm/ui/chatting/c/y:je	(Ljava/util/List;)Ljava/lang/String;
        //   572: aastore
        //   573: invokestatic 268	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   576: aload 10
        //   578: ifnonnull +207 -> 785
        //   581: iconst_0
        //   582: istore 8
        //   584: new 220	com/tencent/mm/chatroom/storage/c
        //   587: dup
        //   588: invokespecial 293	com/tencent/mm/chatroom/storage/c:<init>	()V
        //   591: astore 11
        //   593: aload 11
        //   595: aload_0
        //   596: getfield 21	com/tencent/mm/ui/chatting/c/y$5:Gwf	Lcom/tencent/mm/ui/chatting/c/y;
        //   599: getfield 88	com/tencent/mm/ui/chatting/c/y:cOd	Lcom/tencent/mm/ui/chatting/d/a;
        //   602: invokevirtual 94	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   605: putfield 296	com/tencent/mm/chatroom/storage/c:field_chatroomname	Ljava/lang/String;
        //   608: aload 11
        //   610: astore 10
        //   612: aload 10
        //   614: iconst_1
        //   615: putfield 299	com/tencent/mm/chatroom/storage/c:field_queryState	I
        //   618: aload 10
        //   620: getfield 224	com/tencent/mm/chatroom/storage/c:fpN	Ljava/util/LinkedList;
        //   623: invokevirtual 302	java/util/LinkedList:size	()I
        //   626: istore_1
        //   627: aload 10
        //   629: getfield 224	com/tencent/mm/chatroom/storage/c:fpN	Ljava/util/LinkedList;
        //   632: invokevirtual 303	java/util/LinkedList:clear	()V
        //   635: aload 10
        //   637: getfield 224	com/tencent/mm/chatroom/storage/c:fpN	Ljava/util/LinkedList;
        //   640: aload_0
        //   641: getfield 36	com/tencent/mm/ui/chatting/c/y$5:Gwg	Ljava/util/ArrayList;
        //   644: invokevirtual 304	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   647: pop
        //   648: aload 10
        //   650: aload_0
        //   651: getfield 36	com/tencent/mm/ui/chatting/c/y$5:Gwg	Ljava/util/ArrayList;
        //   654: invokestatic 307	com/tencent/mm/chatroom/storage/c:X	(Ljava/util/List;)Ljava/lang/String;
        //   657: putfield 310	com/tencent/mm/chatroom/storage/c:field_recentUseToolList	Ljava/lang/String;
        //   660: iload 8
        //   662: ifeq +84 -> 746
        //   665: ldc 74
        //   667: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   670: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   673: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/d;
        //   676: aload 10
        //   678: iconst_0
        //   679: anewarray 312	java/lang/String
        //   682: invokevirtual 315	com/tencent/mm/chatroom/storage/d:a	(Lcom/tencent/mm/chatroom/storage/c;[Ljava/lang/String;)Z
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
        //   706: getfield 36	com/tencent/mm/ui/chatting/c/y$5:Gwg	Ljava/util/ArrayList;
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
        //   740: invokestatic 153	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   743: goto -435 -> 308
        //   746: ldc 74
        //   748: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   751: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   754: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/d;
        //   757: aload 10
        //   759: invokevirtual 325	com/tencent/mm/chatroom/storage/d:a	(Lcom/tencent/mm/chatroom/storage/c;)Z
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
        //   227	288	12	localbl	com.tencent.mm.storage.bl
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
  
  private void eXL()
  {
    int k = 0;
    AppMethodBeat.i(179894);
    this.GvM = this.cOd.GzJ.getContext().getLayoutInflater().inflate(2131493406, null);
    this.GvO = ((NestedScrollView)this.GvM.findViewById(2131304251));
    this.GvR = ((RelativeLayout)this.GvM.findViewById(2131300658));
    this.GvN = ((LinearLayout)this.GvM.findViewById(2131300659));
    this.fru = ((LinearLayout)this.GvM.findViewById(2131300664));
    this.GvP = ((LinearLayout)this.GvM.findViewById(2131300665));
    this.frv = ((RecyclerView)this.GvM.findViewById(2131300666));
    this.frw = ((LinearLayout)this.GvM.findViewById(2131300661));
    this.GvQ = ((LinearLayout)this.GvM.findViewById(2131300662));
    this.frx = ((RecyclerView)this.GvM.findViewById(2131300663));
    this.nMm = ((ImageView)this.GvM.findViewById(2131300660));
    this.FJA = this.GvM.findViewById(2131300656);
    this.GvR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179868);
        ad.i("MicroMsg.roomtools.GroupToolsComponet", "downArrowRl click");
        if (y.c(y.this) != null) {
          y.c(y.this).bfo();
        }
        AppMethodBeat.o(179868);
      }
    });
    this.GvP.setOnClickListener(this.Gwd);
    this.GvQ.setOnClickListener(this.Gwd);
    label313:
    int j;
    label333:
    label358:
    Object localObject2;
    if (this.GvZ) {
      if (this.frE.fpM.size() > 0)
      {
        this.GvP.setVisibility(0);
        this.GvQ.setVisibility(8);
        if (this.frE.fpM.size() <= 0) {
          break label1230;
        }
        this.fru.setVisibility(0);
        i = 1;
        if (this.GvY.size() <= 0) {
          break label1244;
        }
        this.frw.setVisibility(0);
        j = 1;
        if ((j != 0) || (i != 0)) {
          break label1258;
        }
        this.GvN.setVisibility(0);
        this.FJA.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.GvO.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject1).height;
        if (this.frE.fpM.size() + this.GvY.size() <= 8) {
          break label1278;
        }
        i = com.tencent.mm.cd.a.fromDPToPix(this.cOd.GzJ.getContext(), 344);
        label416:
        if (j != i)
        {
          ((RelativeLayout.LayoutParams)localObject1).height = i;
          this.GvO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.nMm.setVisibility(8);
        this.cOd.GzJ.getContext();
        this.GvT = new GridLayoutManager(4);
        this.frv.setLayoutManager(this.GvT);
        this.frv.setNestedScrollingEnabled(false);
        this.cOd.GzJ.getContext();
        this.GvV = new GridLayoutManager(4);
        this.frx.setLayoutManager(this.GvV);
        this.frx.setNestedScrollingEnabled(false);
        i = (this.cOd.GzJ.getContext().getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cd.a.ap(this.cOd.GzJ.getContext(), 2131165296) * 2 - com.tencent.mm.cd.a.ap(this.cOd.GzJ.getContext(), 2131165301) * 4) / 12;
        this.GvU = new y.d(this.cOd.GzJ.getContext(), this.frE.fpM, this.Gwa);
        this.frv.setAdapter(this.GvU);
        localObject1 = new y.c(i);
        this.frv.a((RecyclerView.h)localObject1);
        this.GvU.aql.notifyChanged();
        this.GvW = new y.d(this.cOd.GzJ.getContext(), this.GvY, this.Gwb);
        this.frx.setAdapter(this.GvW);
        localObject1 = new y.c(i);
        this.frx.a((RecyclerView.h)localObject1);
        this.GvW.aql.notifyChanged();
        this.GvO.setOnScrollChangeListener(new NestedScrollView.b()
        {
          public final void a(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt)
          {
            AppMethodBeat.i(179869);
            if (paramAnonymousInt == 0)
            {
              ad.d("MicroMsg.roomtools.GroupToolsComponet", "TOP SCROLL");
              y.g(y.this).setVisibility(8);
              AppMethodBeat.o(179869);
              return;
            }
            ad.d("MicroMsg.roomtools.GroupToolsComponet", "no TOP SCROLL");
            y.g(y.this).setVisibility(0);
            AppMethodBeat.o(179869);
          }
        });
        this.GvO.setFocusable(false);
        this.GvS = new b(this.cOd.GzJ.getContext(), this.GvM);
        this.GvS.GHn = new e.b()
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
        localObject1 = this.GvS;
        ((b)localObject1).GHo = false;
        ((b)localObject1).kBm = ((b)localObject1).aov();
        ((b)localObject1).kBn = ((b)localObject1).getRotation();
        if (((b)localObject1).kBi != null)
        {
          localObject2 = (FrameLayout.LayoutParams)((b)localObject1).jGG.getLayoutParams();
          if ((((b)localObject1).kBm) && (((b)localObject1).nO != null))
          {
            localObject3 = new Rect();
            ((b)localObject1).nO.getWindowVisibleDisplayFrame((Rect)localObject3);
            ((FrameLayout.LayoutParams)localObject2).width = ((Rect)localObject3).right;
          }
          ((b)localObject1).jGG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (Build.VERSION.SDK_INT >= 21) {
            ((b)localObject1).kBi.getWindow().addFlags(-2147483648);
          }
          if (!((b)localObject1).kBp) {
            break label1298;
          }
          ((b)localObject1).kBi.getWindow().setFlags(8, 8);
          ((b)localObject1).kBi.getWindow().addFlags(131200);
          ((b)localObject1).kBi.getWindow().getDecorView().setSystemUiVisibility(6);
          label977:
          if (((b)localObject1).kBl != null) {
            ((b)localObject1).kBl.lh = false;
          }
          if (((b)localObject1).GHn != null) {
            ((b)localObject1).kBi.setOnDismissListener(new b.2((b)localObject1));
          }
          if (((b)localObject1).nO != null) {
            if (((b)localObject1).acK != null) {
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
      ((b)localObject1).acK = ((b)localObject1).nO.getViewTreeObserver();
      if (i != 0) {
        ((b)localObject1).acK.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject1);
      }
      if (((((b)localObject1).mContext instanceof Activity)) && (!((Activity)((b)localObject1).mContext).isFinishing())) {
        ((b)localObject1).kBi.show();
      }
      if (this.GvO != null) {
        this.GvO.post(new Runnable()
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
      localObject1 = this.frE.fpM.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
      }
      if (this.GvY.size() > 0)
      {
        this.GvP.setVisibility(8);
        this.GvQ.setVisibility(0);
        break;
      }
      this.GvP.setVisibility(8);
      this.GvQ.setVisibility(8);
      break;
      label1230:
      this.fru.setVisibility(8);
      i = 0;
      break label313;
      label1244:
      this.frw.setVisibility(8);
      j = 0;
      break label333;
      label1258:
      this.GvN.setVisibility(8);
      this.FJA.setVisibility(0);
      break label358;
      label1278:
      i = com.tencent.mm.cd.a.fromDPToPix(this.cOd.GzJ.getContext(), 264);
      break label416;
      ((b)localObject1).kBi.getWindow().clearFlags(8);
      ((b)localObject1).kBi.getWindow().clearFlags(131072);
      ((b)localObject1).kBi.getWindow().clearFlags(128);
      ((b)localObject1).kBi.getWindow().getDecorView().setSystemUiVisibility(0);
      break label977;
    }
    Object localObject3 = new StringBuilder();
    Object localObject1 = this.GvY.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject3).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
    }
    localObject1 = this.cOd.getTalkerUserName();
    int m;
    if (this.frE == null)
    {
      j = 0;
      m = this.GvY.size();
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!w.ty((String)localObject1)) {
        break label1575;
      }
      i = 2;
    }
    for (;;)
    {
      n localn = new n();
      localn.fV((String)localObject1);
      localn.dFf = 2L;
      localn.dHJ = j;
      localn.dHK = m;
      localn.dHG = i;
      localn.dHO = localn.t("topAppList", (String)localObject2, true);
      localn.dHP = localn.t("usedAppList", (String)localObject3, true);
      localn.aBj();
      AppMethodBeat.o(179894);
      return;
      j = this.frE.fpM.size();
      break;
      label1575:
      i = k;
      if (w.tx((String)localObject1)) {
        i = 1;
      }
    }
  }
  
  private void eXM()
  {
    AppMethodBeat.i(191536);
    this.frE = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().oQ(this.cOd.getTalkerUserName());
    if (this.frE == null)
    {
      com.tencent.mm.chatroom.storage.c localc = new com.tencent.mm.chatroom.storage.c();
      localc.field_chatroomname = this.cOd.getTalkerUserName();
      boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc);
      if (bool) {
        this.frE = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().oQ(this.cOd.getTalkerUserName());
      }
      ad.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools insert GroupTools: result(%s)", new Object[] { Boolean.valueOf(bool) });
    }
    ad.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools start:%s queryRecentUse:%s state:%s", new Object[] { this.cOd.getTalkerUserName(), Boolean.TRUE, Integer.valueOf(this.frE.field_queryState) });
    if (this.frE.field_queryState == 1)
    {
      this.GvY.clear();
      this.GvY.addAll(this.frE.fpN);
      Collections.sort(this.GvY, new Comparator() {});
      eXL();
      AppMethodBeat.o(191536);
      return;
    }
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179856);
        if (y.this.GvX != null) {}
        for (Object localObject = Boolean.valueOf(y.this.GvX.isAlive());; localObject = "null")
        {
          ad.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentToolsThread interrupt() %s", new Object[] { localObject });
          if ((y.this.GvX != null) && (y.this.GvX.isAlive())) {
            y.this.GvX.interrupt();
          }
          AppMethodBeat.o(179856);
          return;
        }
      }
    }, 5000L);
    this.GvX = new Thread(this.Gwe);
    this.GvX.start();
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179860);
        if ((y.this.GvX != null) && (y.this.GvX.isAlive())) {
          y.i(y.this);
        }
        AppMethodBeat.o(179860);
      }
    }, 200L);
    AppMethodBeat.o(191536);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(179884);
    super.eQB();
    ad.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cOd.getTalkerUserName(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179884);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(179885);
    super.eQC();
    String str = this.cOd.getTalkerUserName();
    if ((!bt.isNullOrNil(str)) && (w.sm(str)) && (w.tx(str)))
    {
      this.GvZ = true;
      AppMethodBeat.o(179885);
      return;
    }
    this.GvZ = false;
    AppMethodBeat.o(179885);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(179889);
    super.eQD();
    ad.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingResume");
    this.Gwc.dead();
    AppMethodBeat.o(179889);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(179890);
    super.eQE();
    ad.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingPause");
    AppMethodBeat.o(179890);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(179886);
    super.eQF();
    ad.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingExitAnimStart");
    this.Gwc.dead();
    AppMethodBeat.o(179886);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(179887);
    super.eWx();
    this.ddw = false;
    if (this.GvM != null) {
      this.GvM.setVisibility(8);
    }
    AppMethodBeat.o(179887);
  }
  
  public final void eXK()
  {
    AppMethodBeat.i(179888);
    if (!aa.UU())
    {
      AppMethodBeat.o(179888);
      return;
    }
    eXM();
    AppMethodBeat.o(179888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.y
 * JD-Core Version:    0.7.0.1
 */