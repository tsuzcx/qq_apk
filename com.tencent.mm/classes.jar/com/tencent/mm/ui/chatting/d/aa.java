package com.tencent.mm.ui.chatting.d;

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
import android.support.v7.widget.RecyclerView.t;
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
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.chatroom.ui.GroupToolsManagereUI;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.view.b.2;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.x.class)
public class aa
  extends a
  implements com.tencent.mm.ui.chatting.d.b.x
{
  public static final Long KeW;
  private View Ccu;
  private View KeX;
  private LinearLayout KeY;
  private NestedScrollView KeZ;
  private LinearLayout Kfa;
  private LinearLayout Kfb;
  private RelativeLayout Kfc;
  private com.tencent.mm.ui.chatting.view.b Kfd;
  private GridLayoutManager Kfe;
  private d Kff;
  private GridLayoutManager Kfg;
  private d Kfh;
  protected Thread Kfi;
  private ArrayList<GroupToolItem> Kfj;
  private boolean Kfk;
  private a Kfl;
  private a Kfm;
  private com.tencent.mm.sdk.b.c<nd> Kfn;
  private View.OnClickListener Kfo;
  private Runnable Kfp;
  private boolean dnq;
  private LinearLayout fQo;
  private RecyclerView fQp;
  private LinearLayout fQq;
  private RecyclerView fQr;
  private e fQy;
  private long myg;
  private ImageView oZj;
  private p tipDialog;
  
  static
  {
    AppMethodBeat.i(179908);
    KeW = Long.valueOf(604800000L);
    AppMethodBeat.o(179908);
  }
  
  public aa()
  {
    AppMethodBeat.i(179883);
    this.tipDialog = null;
    this.fQy = null;
    this.Kfj = new ArrayList();
    this.Kfk = false;
    this.myg = 0L;
    this.dnq = false;
    this.Kfl = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179854);
        ae.i("MicroMsg.roomtools.GroupToolsComponet", "iStickToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.Yz()) {
            break label78;
          }
          aa.a(aa.this);
        }
        for (;;)
        {
          aa.a(aa.this, paramAnonymousView, true);
          if (aa.c(aa.this) != null) {
            aa.c(aa.this).bqD();
          }
          AppMethodBeat.o(179854);
          return;
          label78:
          if (paramAnonymousView.YA()) {
            aa.b(aa.this);
          } else {
            aa.a(aa.this, paramAnonymousView, "1", true);
          }
        }
      }
    };
    this.Kfm = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179864);
        ae.i("MicroMsg.roomtools.GroupToolsComponet", "iRecentUseToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.Yz()) {
            break label78;
          }
          aa.a(aa.this);
        }
        for (;;)
        {
          aa.a(aa.this, paramAnonymousView, false);
          if (aa.c(aa.this) != null) {
            aa.c(aa.this).bqD();
          }
          AppMethodBeat.o(179864);
          return;
          label78:
          if (paramAnonymousView.YA()) {
            aa.b(aa.this);
          } else {
            aa.a(aa.this, paramAnonymousView, "2", false);
          }
        }
      }
    };
    this.Kfn = new com.tencent.mm.sdk.b.c() {};
    this.Kfo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179867);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.roomtools.GroupToolsComponet", "stickManagerLl click");
        localObject = new Intent(aa.this.cXJ.Kkd.getContext(), GroupToolsManagereUI.class);
        ((Intent)localObject).putExtra("key_chatroomname", aa.this.cXJ.getTalkerUserName());
        ((Intent)localObject).putParcelableArrayListExtra("key_recent_use_tools", aa.e(aa.this));
        paramAnonymousView = aa.this.cXJ.Kkd.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aa.f(aa.this).alive();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179867);
      }
    };
    this.Kfp = new Runnable()
    {
      private ArrayList<GroupToolItem> Kfr;
      
      private boolean b(GroupToolItem paramAnonymousGroupToolItem)
      {
        AppMethodBeat.i(185885);
        if (paramAnonymousGroupToolItem == null)
        {
          AppMethodBeat.o(185885);
          return false;
        }
        if (this.Kfr.contains(paramAnonymousGroupToolItem))
        {
          AppMethodBeat.o(185885);
          return false;
        }
        this.Kfr.add(paramAnonymousGroupToolItem);
        AppMethodBeat.o(185885);
        return true;
      }
      
      private boolean fIa()
      {
        AppMethodBeat.i(185886);
        if (this.Kfr.size() >= 20)
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
        //   5: invokestatic 67	com/tencent/mm/model/ch:aDb	()J
        //   8: lstore_3
        //   9: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   12: lload_3
        //   13: lcmp
        //   14: ifle +780 -> 794
        //   17: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   20: lstore_3
        //   21: invokestatic 67	com/tencent/mm/model/ch:aDb	()J
        //   24: lstore 5
        //   26: ldc 74
        //   28: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   31: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   34: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/f;
        //   37: aload_0
        //   38: getfield 21	com/tencent/mm/ui/chatting/d/aa$5:Kfq	Lcom/tencent/mm/ui/chatting/d/aa;
        //   41: getfield 88	com/tencent/mm/ui/chatting/d/aa:cXJ	Lcom/tencent/mm/ui/chatting/e/a;
        //   44: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   47: invokevirtual 100	com/tencent/mm/chatroom/storage/f:vn	(Ljava/lang/String;)Lcom/tencent/mm/chatroom/storage/e;
        //   50: astore 10
        //   52: aload_0
        //   53: getfield 36	com/tencent/mm/ui/chatting/d/aa$5:Kfr	Ljava/util/ArrayList;
        //   56: invokevirtual 103	java/util/ArrayList:clear	()V
        //   59: iconst_0
        //   60: istore 7
        //   62: iconst_0
        //   63: istore_1
        //   64: invokestatic 108	java/lang/Thread:interrupted	()Z
        //   67: ifne +474 -> 541
        //   70: aload_0
        //   71: invokespecial 110	com/tencent/mm/ui/chatting/d/aa$5:fIa	()Z
        //   74: ifne +467 -> 541
        //   77: iload 7
        //   79: ifne +462 -> 541
        //   82: iload_1
        //   83: bipush 26
        //   85: if_icmpge +456 -> 541
        //   88: ldc 112
        //   90: invokestatic 116	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   93: checkcast 112	com/tencent/mm/plugin/messenger/foundation/a/l
        //   96: invokeinterface 120 1 0
        //   101: aload_0
        //   102: getfield 21	com/tencent/mm/ui/chatting/d/aa$5:Kfq	Lcom/tencent/mm/ui/chatting/d/aa;
        //   105: getfield 88	com/tencent/mm/ui/chatting/d/aa:cXJ	Lcom/tencent/mm/ui/chatting/e/a;
        //   108: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   111: lload_3
        //   112: iload_1
        //   113: iconst_1
        //   114: iadd
        //   115: i2l
        //   116: getstatic 124	com/tencent/mm/ui/chatting/d/aa:KeW	Ljava/lang/Long;
        //   119: invokevirtual 129	java/lang/Long:longValue	()J
        //   122: lmul
        //   123: lsub
        //   124: lload_3
        //   125: iload_1
        //   126: i2l
        //   127: getstatic 124	com/tencent/mm/ui/chatting/d/aa:KeW	Ljava/lang/Long;
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
        //   177: invokestatic 153	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   224: checkcast 168	com/tencent/mm/storage/bv
        //   227: astore 12
        //   229: aload 12
        //   231: getfield 173	com/tencent/mm/g/c/ei:eNc	I
        //   234: iconst_4
        //   235: iand
        //   236: iconst_4
        //   237: if_icmpeq -30 -> 207
        //   240: aload 12
        //   242: invokevirtual 176	com/tencent/mm/storage/bv:getType	()I
        //   245: sipush 10000
        //   248: if_icmpeq -41 -> 207
        //   251: aload 12
        //   253: getfield 180	com/tencent/mm/g/c/ei:field_content	Ljava/lang/String;
        //   256: invokestatic 186	com/tencent/mm/ah/k$b:zb	(Ljava/lang/String;)Lcom/tencent/mm/ah/k$b;
        //   259: astore 13
        //   261: aload 13
        //   263: ifnonnull +144 -> 407
        //   266: ldc 140
        //   268: ldc 188
        //   270: invokestatic 192	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   273: goto -66 -> 207
        //   276: astore 11
        //   278: ldc 140
        //   280: ldc 194
        //   282: iconst_2
        //   283: anewarray 4	java/lang/Object
        //   286: dup
        //   287: iconst_0
        //   288: aload 11
        //   290: invokevirtual 198	java/lang/Object:getClass	()Ljava/lang/Class;
        //   293: invokevirtual 203	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   296: aastore
        //   297: dup
        //   298: iconst_1
        //   299: aload 11
        //   301: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   304: aastore
        //   305: invokestatic 209	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   308: invokestatic 67	com/tencent/mm/model/ch:aDb	()J
        //   311: lstore_3
        //   312: ldc 140
        //   314: ldc 211
        //   316: iconst_2
        //   317: anewarray 4	java/lang/Object
        //   320: dup
        //   321: iconst_0
        //   322: aload_0
        //   323: getfield 21	com/tencent/mm/ui/chatting/d/aa$5:Kfq	Lcom/tencent/mm/ui/chatting/d/aa;
        //   326: getfield 88	com/tencent/mm/ui/chatting/d/aa:cXJ	Lcom/tencent/mm/ui/chatting/e/a;
        //   329: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   332: aastore
        //   333: dup
        //   334: iconst_1
        //   335: lload_3
        //   336: lload 5
        //   338: lsub
        //   339: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   342: aastore
        //   343: invokestatic 153	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   346: aload_0
        //   347: getfield 21	com/tencent/mm/ui/chatting/d/aa$5:Kfq	Lcom/tencent/mm/ui/chatting/d/aa;
        //   350: invokestatic 217	com/tencent/mm/ui/chatting/d/aa:e	(Lcom/tencent/mm/ui/chatting/d/aa;)Ljava/util/ArrayList;
        //   353: invokevirtual 103	java/util/ArrayList:clear	()V
        //   356: aload_0
        //   357: getfield 21	com/tencent/mm/ui/chatting/d/aa$5:Kfq	Lcom/tencent/mm/ui/chatting/d/aa;
        //   360: invokestatic 217	com/tencent/mm/ui/chatting/d/aa:e	(Lcom/tencent/mm/ui/chatting/d/aa;)Ljava/util/ArrayList;
        //   363: aload 10
        //   365: getfield 223	com/tencent/mm/chatroom/storage/e:fOn	Ljava/util/LinkedList;
        //   368: invokevirtual 227	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   371: pop
        //   372: aload_0
        //   373: getfield 21	com/tencent/mm/ui/chatting/d/aa$5:Kfq	Lcom/tencent/mm/ui/chatting/d/aa;
        //   376: invokestatic 217	com/tencent/mm/ui/chatting/d/aa:e	(Lcom/tencent/mm/ui/chatting/d/aa;)Ljava/util/ArrayList;
        //   379: new 10	com/tencent/mm/ui/chatting/d/aa$5$1
        //   382: dup
        //   383: aload_0
        //   384: invokespecial 230	com/tencent/mm/ui/chatting/d/aa$5$1:<init>	(Lcom/tencent/mm/ui/chatting/d/aa$5;)V
        //   387: invokestatic 236	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
        //   390: new 12	com/tencent/mm/ui/chatting/d/aa$5$2
        //   393: dup
        //   394: aload_0
        //   395: invokespecial 237	com/tencent/mm/ui/chatting/d/aa$5$2:<init>	(Lcom/tencent/mm/ui/chatting/d/aa$5;)V
        //   398: invokestatic 243	com/tencent/mm/sdk/platformtools/ar:f	(Ljava/lang/Runnable;)V
        //   401: ldc 61
        //   403: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   406: return
        //   407: aload 13
        //   409: invokestatic 248	com/tencent/mm/modelappbrand/a:b	(Lcom/tencent/mm/ah/k$b;)Z
        //   412: ifne +11 -> 423
        //   415: aload 13
        //   417: invokestatic 251	com/tencent/mm/modelappbrand/a:c	(Lcom/tencent/mm/ah/k$b;)Z
        //   420: ifeq +67 -> 487
        //   423: aload 12
        //   425: invokestatic 257	com/tencent/mm/chatroom/d/aa:g	(Lcom/tencent/mm/storage/bv;)Lcom/tencent/mm/chatroom/storage/GroupToolItem;
        //   428: astore 13
        //   430: aload 13
        //   432: ifnull +55 -> 487
        //   435: ldc 140
        //   437: ldc_w 259
        //   440: iconst_1
        //   441: anewarray 4	java/lang/Object
        //   444: dup
        //   445: iconst_0
        //   446: aload 13
        //   448: invokevirtual 264	com/tencent/mm/chatroom/storage/GroupToolItem:toString	()Ljava/lang/String;
        //   451: aastore
        //   452: invokestatic 266	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   455: aload_0
        //   456: aload 13
        //   458: invokespecial 268	com/tencent/mm/ui/chatting/d/aa$5:b	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   461: ifeq +26 -> 487
        //   464: aload_0
        //   465: invokespecial 110	com/tencent/mm/ui/chatting/d/aa$5:fIa	()Z
        //   468: ifeq +19 -> 487
        //   471: iconst_1
        //   472: istore 7
        //   474: aload_0
        //   475: invokespecial 110	com/tencent/mm/ui/chatting/d/aa$5:fIa	()Z
        //   478: ifeq +322 -> 800
        //   481: iconst_1
        //   482: istore 7
        //   484: goto +316 -> 800
        //   487: aload 12
        //   489: invokestatic 272	com/tencent/mm/chatroom/d/aa:h	(Lcom/tencent/mm/storage/bv;)Z
        //   492: ifeq -285 -> 207
        //   495: ldc 140
        //   497: ldc_w 274
        //   500: invokestatic 192	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   503: aload_0
        //   504: new 261	com/tencent/mm/chatroom/storage/GroupToolItem
        //   507: dup
        //   508: ldc_w 276
        //   511: ldc_w 278
        //   514: aload 12
        //   516: getfield 282	com/tencent/mm/g/c/ei:field_createTime	J
        //   519: invokespecial 285	com/tencent/mm/chatroom/storage/GroupToolItem:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
        //   522: invokespecial 268	com/tencent/mm/ui/chatting/d/aa$5:b	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   525: ifeq -318 -> 207
        //   528: aload_0
        //   529: invokespecial 110	com/tencent/mm/ui/chatting/d/aa$5:fIa	()Z
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
        //   553: getfield 36	com/tencent/mm/ui/chatting/d/aa$5:Kfr	Ljava/util/ArrayList;
        //   556: invokevirtual 57	java/util/ArrayList:size	()I
        //   559: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   562: aastore
        //   563: dup
        //   564: iconst_1
        //   565: aload_0
        //   566: getfield 36	com/tencent/mm/ui/chatting/d/aa$5:Kfr	Ljava/util/ArrayList;
        //   569: invokestatic 291	com/tencent/mm/ui/chatting/d/aa:io	(Ljava/util/List;)Ljava/lang/String;
        //   572: aastore
        //   573: invokestatic 266	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   576: aload 10
        //   578: ifnonnull +207 -> 785
        //   581: iconst_0
        //   582: istore 8
        //   584: new 219	com/tencent/mm/chatroom/storage/e
        //   587: dup
        //   588: invokespecial 292	com/tencent/mm/chatroom/storage/e:<init>	()V
        //   591: astore 11
        //   593: aload 11
        //   595: aload_0
        //   596: getfield 21	com/tencent/mm/ui/chatting/d/aa$5:Kfq	Lcom/tencent/mm/ui/chatting/d/aa;
        //   599: getfield 88	com/tencent/mm/ui/chatting/d/aa:cXJ	Lcom/tencent/mm/ui/chatting/e/a;
        //   602: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   605: putfield 295	com/tencent/mm/chatroom/storage/e:field_chatroomname	Ljava/lang/String;
        //   608: aload 11
        //   610: astore 10
        //   612: aload 10
        //   614: iconst_1
        //   615: putfield 298	com/tencent/mm/chatroom/storage/e:field_queryState	I
        //   618: aload 10
        //   620: getfield 223	com/tencent/mm/chatroom/storage/e:fOn	Ljava/util/LinkedList;
        //   623: invokevirtual 301	java/util/LinkedList:size	()I
        //   626: istore_1
        //   627: aload 10
        //   629: getfield 223	com/tencent/mm/chatroom/storage/e:fOn	Ljava/util/LinkedList;
        //   632: invokevirtual 302	java/util/LinkedList:clear	()V
        //   635: aload 10
        //   637: getfield 223	com/tencent/mm/chatroom/storage/e:fOn	Ljava/util/LinkedList;
        //   640: aload_0
        //   641: getfield 36	com/tencent/mm/ui/chatting/d/aa$5:Kfr	Ljava/util/ArrayList;
        //   644: invokevirtual 303	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   647: pop
        //   648: aload 10
        //   650: aload_0
        //   651: getfield 36	com/tencent/mm/ui/chatting/d/aa$5:Kfr	Ljava/util/ArrayList;
        //   654: invokestatic 306	com/tencent/mm/chatroom/storage/e:Q	(Ljava/util/List;)Ljava/lang/String;
        //   657: putfield 309	com/tencent/mm/chatroom/storage/e:field_recentUseToolList	Ljava/lang/String;
        //   660: iload 8
        //   662: ifeq +84 -> 746
        //   665: ldc 74
        //   667: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
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
        //   706: getfield 36	com/tencent/mm/ui/chatting/d/aa$5:Kfr	Ljava/util/ArrayList;
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
        //   740: invokestatic 153	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   743: goto -435 -> 308
        //   746: ldc 74
        //   748: invokestatic 80	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
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
        //   227	288	12	localbv	com.tencent.mm.storage.bv
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
  
  private void fHY()
  {
    int k = 0;
    AppMethodBeat.i(179894);
    this.KeX = this.cXJ.Kkd.getContext().getLayoutInflater().inflate(2131493406, null);
    this.KeZ = ((NestedScrollView)this.KeX.findViewById(2131304251));
    this.Kfc = ((RelativeLayout)this.KeX.findViewById(2131300658));
    this.KeY = ((LinearLayout)this.KeX.findViewById(2131300659));
    this.fQo = ((LinearLayout)this.KeX.findViewById(2131300664));
    this.Kfa = ((LinearLayout)this.KeX.findViewById(2131300665));
    this.fQp = ((RecyclerView)this.KeX.findViewById(2131300666));
    this.fQq = ((LinearLayout)this.KeX.findViewById(2131300661));
    this.Kfb = ((LinearLayout)this.KeX.findViewById(2131300662));
    this.fQr = ((RecyclerView)this.KeX.findViewById(2131300663));
    this.oZj = ((ImageView)this.KeX.findViewById(2131300660));
    this.Ccu = this.KeX.findViewById(2131300656);
    this.Kfc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179868);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupToolsComponet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.roomtools.GroupToolsComponet", "downArrowRl click");
        if (aa.c(aa.this) != null) {
          aa.c(aa.this).bqD();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179868);
      }
    });
    this.Kfa.setOnClickListener(this.Kfo);
    this.Kfb.setOnClickListener(this.Kfo);
    label313:
    int j;
    label333:
    label358:
    Object localObject2;
    if (this.Kfk) {
      if (this.fQy.fOm.size() > 0)
      {
        this.Kfa.setVisibility(0);
        this.Kfb.setVisibility(8);
        if (this.fQy.fOm.size() <= 0) {
          break label1230;
        }
        this.fQo.setVisibility(0);
        i = 1;
        if (this.Kfj.size() <= 0) {
          break label1244;
        }
        this.fQq.setVisibility(0);
        j = 1;
        if ((j != 0) || (i != 0)) {
          break label1258;
        }
        this.KeY.setVisibility(0);
        this.Ccu.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.KeZ.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject1).height;
        if (this.fQy.fOm.size() + this.Kfj.size() <= 8) {
          break label1278;
        }
        i = com.tencent.mm.cb.a.fromDPToPix(this.cXJ.Kkd.getContext(), 344);
        label416:
        if (j != i)
        {
          ((RelativeLayout.LayoutParams)localObject1).height = i;
          this.KeZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.oZj.setVisibility(8);
        this.cXJ.Kkd.getContext();
        this.Kfe = new GridLayoutManager(4);
        this.fQp.setLayoutManager(this.Kfe);
        this.fQp.setNestedScrollingEnabled(false);
        this.cXJ.Kkd.getContext();
        this.Kfg = new GridLayoutManager(4);
        this.fQr.setLayoutManager(this.Kfg);
        this.fQr.setNestedScrollingEnabled(false);
        i = (this.cXJ.Kkd.getContext().getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cb.a.ay(this.cXJ.Kkd.getContext(), 2131165296) * 2 - com.tencent.mm.cb.a.ay(this.cXJ.Kkd.getContext(), 2131165301) * 4) / 12;
        this.Kff = new d(this.cXJ.Kkd.getContext(), this.fQy.fOm, this.Kfl);
        this.fQp.setAdapter(this.Kff);
        localObject1 = new c(i);
        this.fQp.a((RecyclerView.h)localObject1);
        this.Kff.asY.notifyChanged();
        this.Kfh = new d(this.cXJ.Kkd.getContext(), this.Kfj, this.Kfm);
        this.fQr.setAdapter(this.Kfh);
        localObject1 = new c(i);
        this.fQr.a((RecyclerView.h)localObject1);
        this.Kfh.asY.notifyChanged();
        this.KeZ.setOnScrollChangeListener(new NestedScrollView.b()
        {
          public final void a(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt)
          {
            AppMethodBeat.i(179869);
            if (paramAnonymousInt == 0)
            {
              ae.d("MicroMsg.roomtools.GroupToolsComponet", "TOP SCROLL");
              aa.g(aa.this).setVisibility(8);
              AppMethodBeat.o(179869);
              return;
            }
            ae.d("MicroMsg.roomtools.GroupToolsComponet", "no TOP SCROLL");
            aa.g(aa.this).setVisibility(0);
            AppMethodBeat.o(179869);
          }
        });
        this.KeZ.setFocusable(false);
        this.Kfd = new com.tencent.mm.ui.chatting.view.b(this.cXJ.Kkd.getContext(), this.KeX);
        this.Kfd.KtV = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(185888);
            if (aa.h(aa.this) != null) {
              aa.h(aa.this).fullScroll(33);
            }
            AppMethodBeat.o(185888);
          }
        };
        localObject1 = this.Kfd;
        ((com.tencent.mm.ui.chatting.view.b)localObject1).KtW = false;
        ((com.tencent.mm.ui.chatting.view.b)localObject1).lEc = ((com.tencent.mm.ui.chatting.view.b)localObject1).aoA();
        ((com.tencent.mm.ui.chatting.view.b)localObject1).lEd = ((com.tencent.mm.ui.chatting.view.b)localObject1).getRotation();
        if (((com.tencent.mm.ui.chatting.view.b)localObject1).lDY != null)
        {
          localObject2 = (FrameLayout.LayoutParams)((com.tencent.mm.ui.chatting.view.b)localObject1).kFh.getLayoutParams();
          if ((((com.tencent.mm.ui.chatting.view.b)localObject1).lEc) && (((com.tencent.mm.ui.chatting.view.b)localObject1).qI != null))
          {
            localObject3 = new Rect();
            ((com.tencent.mm.ui.chatting.view.b)localObject1).qI.getWindowVisibleDisplayFrame((Rect)localObject3);
            ((FrameLayout.LayoutParams)localObject2).width = ((Rect)localObject3).right;
          }
          ((com.tencent.mm.ui.chatting.view.b)localObject1).kFh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (Build.VERSION.SDK_INT >= 21) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.getWindow().addFlags(-2147483648);
          }
          if (!((com.tencent.mm.ui.chatting.view.b)localObject1).lEf) {
            break label1298;
          }
          ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.getWindow().setFlags(8, 8);
          ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.getWindow().addFlags(131200);
          ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.getWindow().getDecorView().setSystemUiVisibility(6);
          label977:
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).lEb != null) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).lEb.nZ = false;
          }
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).KtV != null) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.setOnDismissListener(new b.2((com.tencent.mm.ui.chatting.view.b)localObject1));
          }
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).qI != null) {
            if (((com.tencent.mm.ui.chatting.view.b)localObject1).afv != null) {
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
      ((com.tencent.mm.ui.chatting.view.b)localObject1).afv = ((com.tencent.mm.ui.chatting.view.b)localObject1).qI.getViewTreeObserver();
      if (i != 0) {
        ((com.tencent.mm.ui.chatting.view.b)localObject1).afv.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject1);
      }
      if (((((com.tencent.mm.ui.chatting.view.b)localObject1).mContext instanceof Activity)) && (!((Activity)((com.tencent.mm.ui.chatting.view.b)localObject1).mContext).isFinishing())) {
        ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.show();
      }
      if (this.KeZ != null) {
        this.KeZ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185889);
            aa.h(aa.this).fullScroll(33);
            AppMethodBeat.o(185889);
          }
        });
      }
      localObject2 = new StringBuilder();
      localObject1 = this.fQy.fOm.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
      }
      if (this.Kfj.size() > 0)
      {
        this.Kfa.setVisibility(8);
        this.Kfb.setVisibility(0);
        break;
      }
      this.Kfa.setVisibility(8);
      this.Kfb.setVisibility(8);
      break;
      label1230:
      this.fQo.setVisibility(8);
      i = 0;
      break label313;
      label1244:
      this.fQq.setVisibility(8);
      j = 0;
      break label333;
      label1258:
      this.KeY.setVisibility(8);
      this.Ccu.setVisibility(0);
      break label358;
      label1278:
      i = com.tencent.mm.cb.a.fromDPToPix(this.cXJ.Kkd.getContext(), 264);
      break label416;
      ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.getWindow().clearFlags(8);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.getWindow().clearFlags(131072);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.getWindow().clearFlags(128);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).lDY.getWindow().getDecorView().setSystemUiVisibility(0);
      break label977;
    }
    Object localObject3 = new StringBuilder();
    Object localObject1 = this.Kfj.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject3).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
    }
    localObject1 = this.cXJ.getTalkerUserName();
    int m;
    if (this.fQy == null)
    {
      j = 0;
      m = this.Kfj.size();
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!com.tencent.mm.model.x.Bj((String)localObject1)) {
        break label1575;
      }
      i = 2;
    }
    for (;;)
    {
      com.tencent.mm.g.b.a.q localq = new com.tencent.mm.g.b.a.q();
      localq.gT((String)localObject1);
      localq.dQX = 2L;
      localq.dTR = j;
      localq.dTS = m;
      localq.dTO = i;
      localq.dTW = localq.t("topAppList", (String)localObject2, true);
      localq.dTX = localq.t("usedAppList", (String)localObject3, true);
      localq.aLH();
      AppMethodBeat.o(179894);
      return;
      j = this.fQy.fOm.size();
      break;
      label1575:
      i = k;
      if (com.tencent.mm.model.x.Bi((String)localObject1)) {
        i = 1;
      }
    }
  }
  
  private void fHZ()
  {
    AppMethodBeat.i(187349);
    this.fQy = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().vn(this.cXJ.getTalkerUserName());
    if (this.fQy == null)
    {
      e locale = new e();
      locale.field_chatroomname = this.cXJ.getTalkerUserName();
      boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale);
      if (bool) {
        this.fQy = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().vn(this.cXJ.getTalkerUserName());
      }
      ae.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools insert GroupTools: result(%s)", new Object[] { Boolean.valueOf(bool) });
    }
    ae.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools start:%s queryRecentUse:%s state:%s", new Object[] { this.cXJ.getTalkerUserName(), Boolean.TRUE, Integer.valueOf(this.fQy.field_queryState) });
    if (this.fQy.field_queryState == 1)
    {
      this.Kfj.clear();
      this.Kfj.addAll(this.fQy.fOn);
      Collections.sort(this.Kfj, new Comparator() {});
      fHY();
      AppMethodBeat.o(187349);
      return;
    }
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179856);
        if (aa.this.Kfi != null) {}
        for (Object localObject = Boolean.valueOf(aa.this.Kfi.isAlive());; localObject = "null")
        {
          ae.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentToolsThread interrupt() %s", new Object[] { localObject });
          if ((aa.this.Kfi != null) && (aa.this.Kfi.isAlive())) {
            aa.this.Kfi.interrupt();
          }
          AppMethodBeat.o(179856);
          return;
        }
      }
    }, 5000L);
    this.Kfi = new Thread(this.Kfp);
    this.Kfi.start();
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179860);
        if ((aa.this.Kfi != null) && (aa.this.Kfi.isAlive())) {
          aa.i(aa.this);
        }
        AppMethodBeat.o(179860);
      }
    }, 200L);
    AppMethodBeat.o(187349);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(179884);
    super.fAt();
    ae.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179884);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(179885);
    super.fAu();
    String str = this.cXJ.getTalkerUserName();
    if ((!bu.isNullOrNil(str)) && (com.tencent.mm.model.x.zU(str)) && (com.tencent.mm.model.x.Bi(str)))
    {
      this.Kfk = true;
      AppMethodBeat.o(179885);
      return;
    }
    this.Kfk = false;
    AppMethodBeat.o(179885);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(179889);
    super.fAv();
    ae.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingResume");
    this.Kfn.dead();
    AppMethodBeat.o(179889);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(179890);
    super.fAw();
    ae.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingPause");
    AppMethodBeat.o(179890);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(179886);
    super.fAx();
    ae.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingExitAnimStart");
    this.Kfn.dead();
    AppMethodBeat.o(179886);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(179887);
    super.fGE();
    this.dnq = false;
    if (this.KeX != null) {
      this.KeX.setVisibility(8);
    }
    AppMethodBeat.o(179887);
  }
  
  public final void fHX()
  {
    AppMethodBeat.i(179888);
    if (!com.tencent.mm.chatroom.d.aa.Yr())
    {
      AppMethodBeat.o(179888);
      return;
    }
    fHZ();
    AppMethodBeat.o(179888);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
  
  public static final class b
    extends RecyclerView.w
  {
    static final com.tencent.mm.av.a.a.c fQP;
    TextView KeN;
    LinearLayout Kft;
    View fQH;
    ImageView fWT;
    
    static
    {
      AppMethodBeat.i(179874);
      c.a locala1 = new c.a();
      locala1.igv = 2131689599;
      c.a locala2 = locala1.dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20));
      locala2.hhW = true;
      locala2.igk = true;
      locala2.igi = true;
      fQP = locala1.aJu();
      AppMethodBeat.o(179874);
    }
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(179873);
      this.fQH = paramView;
      this.Kft = ((LinearLayout)paramView.findViewById(2131305978));
      this.fWT = ((ImageView)paramView.findViewById(2131305982));
      this.KeN = ((TextView)paramView.findViewById(2131305984));
      AppMethodBeat.o(179873);
    }
  }
  
  static final class c
    extends RecyclerView.h
  {
    private final int column;
    private final int sDN;
    
    public c(int paramInt)
    {
      this.sDN = paramInt;
      this.column = 4;
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(187347);
      paramRect.left = (RecyclerView.bw(paramView) % this.column * this.sDN);
      AppMethodBeat.o(187347);
    }
  }
  
  public static final class d
    extends RecyclerView.a
  {
    private aa.a Kfu;
    private Context context;
    private List<GroupToolItem> fQS;
    
    public d(Context paramContext, List<GroupToolItem> paramList, aa.a parama)
    {
      this.context = paramContext;
      this.fQS = paramList;
      this.Kfu = parama;
    }
    
    private static void a(aa.b paramb, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(179880);
      com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.aJb();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramb.fWT, aa.b.fQP);
        localObject = paramb.KeN;
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
      paramViewGroup = new aa.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493405, paramViewGroup, false));
      AppMethodBeat.o(179878);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(179879);
      GroupToolItem localGroupToolItem;
      if ((this.fQS != null) && (paramInt >= 0) && (paramInt < this.fQS.size()))
      {
        paramw = (aa.b)paramw;
        localGroupToolItem = (GroupToolItem)this.fQS.get(paramInt);
        paramw.fQH.setVisibility(0);
        if (!localGroupToolItem.Yz()) {
          break label110;
        }
        paramw.fWT.setImageResource(2131232617);
        paramw.KeN.setText(2131760128);
      }
      for (;;)
      {
        paramw.fQH.setTag(localGroupToolItem);
        paramw.fQH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179877);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (aa.d.a(aa.d.this) != null) {
              aa.d.a(aa.d.this).onClick(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179877);
          }
        });
        AppMethodBeat.o(179879);
        return;
        label110:
        if (localGroupToolItem.YA())
        {
          paramw.fWT.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131234903));
          paramw.KeN.setText(2131756264);
        }
        else
        {
          WxaAttributes localWxaAttributes = ((o)g.ab(o.class)).Ob(localGroupToolItem.username);
          if (localWxaAttributes == null) {
            ((o)g.ab(o.class)).a(localGroupToolItem.username, new o.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(179876);
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179875);
                    aa.d.b(aa.d.1.this.Kfv, paramAnonymousWxaAttributes);
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
      int i = this.fQS.size();
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
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aa
 * JD-Core Version:    0.7.0.1
 */