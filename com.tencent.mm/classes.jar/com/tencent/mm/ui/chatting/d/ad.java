package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
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
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.chatroom.ui.GroupToolsManagereUI;
import com.tencent.mm.f.a.or;
import com.tencent.mm.f.b.a.al;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
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

@com.tencent.mm.ui.chatting.d.a.a(hRc=z.class)
public class ad
  extends a
  implements z
{
  public static final Long WLj;
  private View Nsh;
  private IListener<or> WLA;
  private View.OnClickListener WLB;
  private Runnable WLC;
  private View WLk;
  private LinearLayout WLl;
  private NestedScrollView WLm;
  private LinearLayout WLn;
  private LinearLayout WLo;
  private RelativeLayout WLp;
  private com.tencent.mm.ui.chatting.view.b WLq;
  private GridLayoutManager WLr;
  private d WLs;
  private GridLayoutManager WLt;
  private d WLu;
  protected Thread WLv;
  private ArrayList<GroupToolItem> WLw;
  private boolean WLx;
  private a WLy;
  private a WLz;
  private boolean fxt;
  private LinearLayout iZJ;
  private RecyclerView iZK;
  private LinearLayout iZL;
  private RecyclerView iZM;
  private e iZT;
  private long qLu;
  private ImageView tMP;
  private s tipDialog;
  
  static
  {
    AppMethodBeat.i(179908);
    WLj = Long.valueOf(604800000L);
    AppMethodBeat.o(179908);
  }
  
  public ad()
  {
    AppMethodBeat.i(179883);
    this.tipDialog = null;
    this.iZT = null;
    this.WLw = new ArrayList();
    this.WLx = false;
    this.qLu = 0L;
    this.fxt = false;
    this.WLy = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179854);
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "iStickToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.asn()) {
            break label78;
          }
          ad.a(ad.this);
        }
        for (;;)
        {
          ad.a(ad.this, paramAnonymousView, true);
          if (ad.c(ad.this) != null) {
            ad.c(ad.this).bYF();
          }
          AppMethodBeat.o(179854);
          return;
          label78:
          if (paramAnonymousView.aso()) {
            ad.b(ad.this);
          } else {
            ad.a(ad.this, paramAnonymousView, "1", true);
          }
        }
      }
    };
    this.WLz = new a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179864);
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "iRecentUseToolsCallback click");
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof GroupToolItem))
        {
          paramAnonymousView = (GroupToolItem)paramAnonymousView;
          if (!paramAnonymousView.asn()) {
            break label78;
          }
          ad.a(ad.this);
        }
        for (;;)
        {
          ad.a(ad.this, paramAnonymousView, false);
          if (ad.c(ad.this) != null) {
            ad.c(ad.this).bYF();
          }
          AppMethodBeat.o(179864);
          return;
          label78:
          if (paramAnonymousView.aso()) {
            ad.b(ad.this);
          } else {
            ad.a(ad.this, paramAnonymousView, "2", false);
          }
        }
      }
    };
    this.WLA = new IListener() {};
    this.WLB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179867);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "stickManagerLl click");
        localObject = new Intent(ad.this.fgR.WQv.getContext(), GroupToolsManagereUI.class);
        ((Intent)localObject).putExtra("key_chatroomname", ad.this.fgR.getTalkerUserName());
        ((Intent)localObject).putParcelableArrayListExtra("key_recent_use_tools", ad.e(ad.this));
        paramAnonymousView = ad.this.fgR.WQv.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ad.f(ad.this).alive();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179867);
      }
    };
    this.WLC = new Runnable()
    {
      private ArrayList<GroupToolItem> WLE;
      
      private boolean b(GroupToolItem paramAnonymousGroupToolItem)
      {
        AppMethodBeat.i(185885);
        if (paramAnonymousGroupToolItem == null)
        {
          AppMethodBeat.o(185885);
          return false;
        }
        if (this.WLE.contains(paramAnonymousGroupToolItem))
        {
          AppMethodBeat.o(185885);
          return false;
        }
        this.WLE.add(paramAnonymousGroupToolItem);
        AppMethodBeat.o(185885);
        return true;
      }
      
      private boolean hPE()
      {
        AppMethodBeat.i(185886);
        if (this.WLE.size() >= 20)
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
        //   5: invokestatic 67	com/tencent/mm/model/cm:bfD	()J
        //   8: lstore_3
        //   9: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   12: lload_3
        //   13: lcmp
        //   14: ifle +780 -> 794
        //   17: invokestatic 72	java/lang/System:currentTimeMillis	()J
        //   20: lstore_3
        //   21: invokestatic 67	com/tencent/mm/model/cm:bfD	()J
        //   24: lstore 5
        //   26: ldc 74
        //   28: invokestatic 80	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   31: checkcast 74	com/tencent/mm/chatroom/plugin/PluginChatroomUI
        //   34: invokevirtual 84	com/tencent/mm/chatroom/plugin/PluginChatroomUI:getGroupToolsStorage	()Lcom/tencent/mm/chatroom/storage/f;
        //   37: aload_0
        //   38: getfield 21	com/tencent/mm/ui/chatting/d/ad$5:WLD	Lcom/tencent/mm/ui/chatting/d/ad;
        //   41: getfield 88	com/tencent/mm/ui/chatting/d/ad:fgR	Lcom/tencent/mm/ui/chatting/e/a;
        //   44: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   47: invokevirtual 100	com/tencent/mm/chatroom/storage/f:Kv	(Ljava/lang/String;)Lcom/tencent/mm/chatroom/storage/e;
        //   50: astore 10
        //   52: aload_0
        //   53: getfield 36	com/tencent/mm/ui/chatting/d/ad$5:WLE	Ljava/util/ArrayList;
        //   56: invokevirtual 103	java/util/ArrayList:clear	()V
        //   59: iconst_0
        //   60: istore 7
        //   62: iconst_0
        //   63: istore_1
        //   64: invokestatic 108	java/lang/Thread:interrupted	()Z
        //   67: ifne +474 -> 541
        //   70: aload_0
        //   71: invokespecial 110	com/tencent/mm/ui/chatting/d/ad$5:hPE	()Z
        //   74: ifne +467 -> 541
        //   77: iload 7
        //   79: ifne +462 -> 541
        //   82: iload_1
        //   83: bipush 26
        //   85: if_icmpge +456 -> 541
        //   88: ldc 112
        //   90: invokestatic 116	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   93: checkcast 112	com/tencent/mm/plugin/messenger/foundation/a/n
        //   96: invokeinterface 120 1 0
        //   101: aload_0
        //   102: getfield 21	com/tencent/mm/ui/chatting/d/ad$5:WLD	Lcom/tencent/mm/ui/chatting/d/ad;
        //   105: getfield 88	com/tencent/mm/ui/chatting/d/ad:fgR	Lcom/tencent/mm/ui/chatting/e/a;
        //   108: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   111: lload_3
        //   112: iload_1
        //   113: iconst_1
        //   114: iadd
        //   115: i2l
        //   116: getstatic 124	com/tencent/mm/ui/chatting/d/ad:WLj	Ljava/lang/Long;
        //   119: invokevirtual 129	java/lang/Long:longValue	()J
        //   122: lmul
        //   123: lsub
        //   124: lload_3
        //   125: iload_1
        //   126: i2l
        //   127: getstatic 124	com/tencent/mm/ui/chatting/d/ad:WLj	Ljava/lang/Long;
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
        //   231: getfield 173	com/tencent/mm/f/c/et:hxx	I
        //   234: iconst_4
        //   235: iand
        //   236: iconst_4
        //   237: if_icmpeq -30 -> 207
        //   240: aload 12
        //   242: invokevirtual 176	com/tencent/mm/storage/ca:getType	()I
        //   245: sipush 10000
        //   248: if_icmpeq -41 -> 207
        //   251: aload 12
        //   253: getfield 180	com/tencent/mm/f/c/et:field_content	Ljava/lang/String;
        //   256: invokestatic 186	com/tencent/mm/aj/k$b:OQ	(Ljava/lang/String;)Lcom/tencent/mm/aj/k$b;
        //   259: astore 13
        //   261: aload 13
        //   263: ifnonnull +144 -> 407
        //   266: ldc 140
        //   268: ldc 188
        //   270: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
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
        //   305: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   308: invokestatic 67	com/tencent/mm/model/cm:bfD	()J
        //   311: lstore_3
        //   312: ldc 140
        //   314: ldc 211
        //   316: iconst_2
        //   317: anewarray 4	java/lang/Object
        //   320: dup
        //   321: iconst_0
        //   322: aload_0
        //   323: getfield 21	com/tencent/mm/ui/chatting/d/ad$5:WLD	Lcom/tencent/mm/ui/chatting/d/ad;
        //   326: getfield 88	com/tencent/mm/ui/chatting/d/ad:fgR	Lcom/tencent/mm/ui/chatting/e/a;
        //   329: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   332: aastore
        //   333: dup
        //   334: iconst_1
        //   335: lload_3
        //   336: lload 5
        //   338: lsub
        //   339: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   342: aastore
        //   343: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   346: aload_0
        //   347: getfield 21	com/tencent/mm/ui/chatting/d/ad$5:WLD	Lcom/tencent/mm/ui/chatting/d/ad;
        //   350: invokestatic 217	com/tencent/mm/ui/chatting/d/ad:e	(Lcom/tencent/mm/ui/chatting/d/ad;)Ljava/util/ArrayList;
        //   353: invokevirtual 103	java/util/ArrayList:clear	()V
        //   356: aload_0
        //   357: getfield 21	com/tencent/mm/ui/chatting/d/ad$5:WLD	Lcom/tencent/mm/ui/chatting/d/ad;
        //   360: invokestatic 217	com/tencent/mm/ui/chatting/d/ad:e	(Lcom/tencent/mm/ui/chatting/d/ad;)Ljava/util/ArrayList;
        //   363: aload 10
        //   365: getfield 223	com/tencent/mm/chatroom/storage/e:iXJ	Ljava/util/LinkedList;
        //   368: invokevirtual 227	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   371: pop
        //   372: aload_0
        //   373: getfield 21	com/tencent/mm/ui/chatting/d/ad$5:WLD	Lcom/tencent/mm/ui/chatting/d/ad;
        //   376: invokestatic 217	com/tencent/mm/ui/chatting/d/ad:e	(Lcom/tencent/mm/ui/chatting/d/ad;)Ljava/util/ArrayList;
        //   379: new 10	com/tencent/mm/ui/chatting/d/ad$5$1
        //   382: dup
        //   383: aload_0
        //   384: invokespecial 230	com/tencent/mm/ui/chatting/d/ad$5$1:<init>	(Lcom/tencent/mm/ui/chatting/d/ad$5;)V
        //   387: invokestatic 236	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
        //   390: new 12	com/tencent/mm/ui/chatting/d/ad$5$2
        //   393: dup
        //   394: aload_0
        //   395: invokespecial 237	com/tencent/mm/ui/chatting/d/ad$5$2:<init>	(Lcom/tencent/mm/ui/chatting/d/ad$5;)V
        //   398: invokestatic 243	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   401: ldc 61
        //   403: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   406: return
        //   407: aload 13
        //   409: invokestatic 248	com/tencent/mm/modelappbrand/a:b	(Lcom/tencent/mm/aj/k$b;)Z
        //   412: ifne +11 -> 423
        //   415: aload 13
        //   417: invokestatic 251	com/tencent/mm/modelappbrand/a:c	(Lcom/tencent/mm/aj/k$b;)Z
        //   420: ifeq +67 -> 487
        //   423: aload 12
        //   425: invokestatic 257	com/tencent/mm/chatroom/d/aa:g	(Lcom/tencent/mm/storage/ca;)Lcom/tencent/mm/chatroom/storage/GroupToolItem;
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
        //   452: invokestatic 266	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   455: aload_0
        //   456: aload 13
        //   458: invokespecial 268	com/tencent/mm/ui/chatting/d/ad$5:b	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   461: ifeq +26 -> 487
        //   464: aload_0
        //   465: invokespecial 110	com/tencent/mm/ui/chatting/d/ad$5:hPE	()Z
        //   468: ifeq +19 -> 487
        //   471: iconst_1
        //   472: istore 7
        //   474: aload_0
        //   475: invokespecial 110	com/tencent/mm/ui/chatting/d/ad$5:hPE	()Z
        //   478: ifeq +322 -> 800
        //   481: iconst_1
        //   482: istore 7
        //   484: goto +316 -> 800
        //   487: aload 12
        //   489: invokestatic 272	com/tencent/mm/chatroom/d/aa:h	(Lcom/tencent/mm/storage/ca;)Z
        //   492: ifeq -285 -> 207
        //   495: ldc 140
        //   497: ldc_w 274
        //   500: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   503: aload_0
        //   504: new 261	com/tencent/mm/chatroom/storage/GroupToolItem
        //   507: dup
        //   508: ldc_w 276
        //   511: ldc_w 278
        //   514: aload 12
        //   516: getfield 282	com/tencent/mm/f/c/et:field_createTime	J
        //   519: invokespecial 285	com/tencent/mm/chatroom/storage/GroupToolItem:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
        //   522: invokespecial 268	com/tencent/mm/ui/chatting/d/ad$5:b	(Lcom/tencent/mm/chatroom/storage/GroupToolItem;)Z
        //   525: ifeq -318 -> 207
        //   528: aload_0
        //   529: invokespecial 110	com/tencent/mm/ui/chatting/d/ad$5:hPE	()Z
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
        //   553: getfield 36	com/tencent/mm/ui/chatting/d/ad$5:WLE	Ljava/util/ArrayList;
        //   556: invokevirtual 57	java/util/ArrayList:size	()I
        //   559: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   562: aastore
        //   563: dup
        //   564: iconst_1
        //   565: aload_0
        //   566: getfield 36	com/tencent/mm/ui/chatting/d/ad$5:WLE	Ljava/util/ArrayList;
        //   569: invokestatic 291	com/tencent/mm/ui/chatting/d/ad:kj	(Ljava/util/List;)Ljava/lang/String;
        //   572: aastore
        //   573: invokestatic 266	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   596: getfield 21	com/tencent/mm/ui/chatting/d/ad$5:WLD	Lcom/tencent/mm/ui/chatting/d/ad;
        //   599: getfield 88	com/tencent/mm/ui/chatting/d/ad:fgR	Lcom/tencent/mm/ui/chatting/e/a;
        //   602: invokevirtual 94	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
        //   605: putfield 295	com/tencent/mm/chatroom/storage/e:field_chatroomname	Ljava/lang/String;
        //   608: aload 11
        //   610: astore 10
        //   612: aload 10
        //   614: iconst_1
        //   615: putfield 298	com/tencent/mm/chatroom/storage/e:field_queryState	I
        //   618: aload 10
        //   620: getfield 223	com/tencent/mm/chatroom/storage/e:iXJ	Ljava/util/LinkedList;
        //   623: invokevirtual 301	java/util/LinkedList:size	()I
        //   626: istore_1
        //   627: aload 10
        //   629: getfield 223	com/tencent/mm/chatroom/storage/e:iXJ	Ljava/util/LinkedList;
        //   632: invokevirtual 302	java/util/LinkedList:clear	()V
        //   635: aload 10
        //   637: getfield 223	com/tencent/mm/chatroom/storage/e:iXJ	Ljava/util/LinkedList;
        //   640: aload_0
        //   641: getfield 36	com/tencent/mm/ui/chatting/d/ad$5:WLE	Ljava/util/ArrayList;
        //   644: invokevirtual 303	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   647: pop
        //   648: aload 10
        //   650: aload_0
        //   651: getfield 36	com/tencent/mm/ui/chatting/d/ad$5:WLE	Ljava/util/ArrayList;
        //   654: invokestatic 306	com/tencent/mm/chatroom/storage/e:T	(Ljava/util/List;)Ljava/lang/String;
        //   657: putfield 309	com/tencent/mm/chatroom/storage/e:field_recentUseToolList	Ljava/lang/String;
        //   660: iload 8
        //   662: ifeq +84 -> 746
        //   665: ldc 74
        //   667: invokestatic 80	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
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
        //   706: getfield 36	com/tencent/mm/ui/chatting/d/ad$5:WLE	Ljava/util/ArrayList;
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
        //   748: invokestatic 80	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
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
  
  private void hPC()
  {
    int k = 0;
    AppMethodBeat.i(179894);
    this.WLk = this.fgR.WQv.getContext().getLayoutInflater().inflate(R.i.ect, null);
    this.WLm = ((NestedScrollView)this.WLk.findViewById(R.h.root_view));
    this.WLp = ((RelativeLayout)this.WLk.findViewById(R.h.dIg));
    this.WLl = ((LinearLayout)this.WLk.findViewById(R.h.dIh));
    this.iZJ = ((LinearLayout)this.WLk.findViewById(R.h.dIm));
    this.WLn = ((LinearLayout)this.WLk.findViewById(R.h.dIn));
    this.iZK = ((RecyclerView)this.WLk.findViewById(R.h.dIo));
    this.iZL = ((LinearLayout)this.WLk.findViewById(R.h.dIj));
    this.WLo = ((LinearLayout)this.WLk.findViewById(R.h.dIk));
    this.iZM = ((RecyclerView)this.WLk.findViewById(R.h.dIl));
    this.tMP = ((ImageView)this.WLk.findViewById(R.h.dIi));
    this.Nsh = this.WLk.findViewById(R.h.dIf);
    this.WLp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179868);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupToolsComponet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "downArrowRl click");
        if (ad.c(ad.this) != null) {
          ad.c(ad.this).bYF();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179868);
      }
    });
    this.WLn.setOnClickListener(this.WLB);
    this.WLo.setOnClickListener(this.WLB);
    label313:
    int j;
    label333:
    label358:
    Object localObject2;
    if (this.WLx) {
      if (this.iZT.iXI.size() > 0)
      {
        this.WLn.setVisibility(0);
        this.WLo.setVisibility(8);
        if (this.iZT.iXI.size() <= 0) {
          break label1227;
        }
        this.iZJ.setVisibility(0);
        i = 1;
        if (this.WLw.size() <= 0) {
          break label1241;
        }
        this.iZL.setVisibility(0);
        j = 1;
        if ((j != 0) || (i != 0)) {
          break label1255;
        }
        this.WLl.setVisibility(0);
        this.Nsh.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.WLm.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject1).height;
        if (this.iZT.iXI.size() + this.WLw.size() <= 8) {
          break label1275;
        }
        i = com.tencent.mm.ci.a.fromDPToPix(this.fgR.WQv.getContext(), 344);
        label416:
        if (j != i)
        {
          ((RelativeLayout.LayoutParams)localObject1).height = i;
          this.WLm.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.tMP.setVisibility(8);
        this.fgR.WQv.getContext();
        this.WLr = new GridLayoutManager(4);
        this.iZK.setLayoutManager(this.WLr);
        this.iZK.setNestedScrollingEnabled(false);
        this.fgR.WQv.getContext();
        this.WLt = new GridLayoutManager(4);
        this.iZM.setLayoutManager(this.WLt);
        this.iZM.setNestedScrollingEnabled(false);
        i = (ar.au(this.fgR.WQv.getContext()).x - com.tencent.mm.ci.a.aZ(this.fgR.WQv.getContext(), R.f.Edge_5A) * 2 - com.tencent.mm.ci.a.aZ(this.fgR.WQv.getContext(), R.f.Edge_8A) * 4) / 12;
        this.WLs = new d(this.fgR.WQv.getContext(), this.iZT.iXI, this.WLy);
        this.iZK.setAdapter(this.WLs);
        localObject1 = new ad.c(i);
        this.iZK.a((RecyclerView.h)localObject1);
        this.WLs.alc.notifyChanged();
        this.WLu = new d(this.fgR.WQv.getContext(), this.WLw, this.WLz);
        this.iZM.setAdapter(this.WLu);
        localObject1 = new ad.c(i);
        this.iZM.a((RecyclerView.h)localObject1);
        this.WLu.alc.notifyChanged();
        this.WLm.setOnScrollChangeListener(new NestedScrollView.b()
        {
          public final void a(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
          {
            AppMethodBeat.i(275901);
            if (paramAnonymousInt2 == 0)
            {
              Log.d("MicroMsg.roomtools.GroupToolsComponet", "TOP SCROLL");
              ad.g(ad.this).setVisibility(8);
              AppMethodBeat.o(275901);
              return;
            }
            Log.d("MicroMsg.roomtools.GroupToolsComponet", "no TOP SCROLL");
            ad.g(ad.this).setVisibility(0);
            AppMethodBeat.o(275901);
          }
        });
        this.WLm.setFocusable(false);
        this.WLq = new com.tencent.mm.ui.chatting.view.b(this.fgR.WQv.getContext(), this.WLk);
        this.WLq.XbB = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(185888);
            if (ad.h(ad.this) != null) {
              ad.h(ad.this).bL(33);
            }
            AppMethodBeat.o(185888);
          }
        };
        localObject1 = this.WLq;
        ((com.tencent.mm.ui.chatting.view.b)localObject1).XbC = false;
        ((com.tencent.mm.ui.chatting.view.b)localObject1).pMD = ((com.tencent.mm.ui.chatting.view.b)localObject1).isLandscape();
        ((com.tencent.mm.ui.chatting.view.b)localObject1).pME = ((com.tencent.mm.ui.chatting.view.b)localObject1).getRotation();
        if (((com.tencent.mm.ui.chatting.view.b)localObject1).pMz != null)
        {
          localObject2 = (FrameLayout.LayoutParams)((com.tencent.mm.ui.chatting.view.b)localObject1).oFW.getLayoutParams();
          if ((((com.tencent.mm.ui.chatting.view.b)localObject1).pMD) && (((com.tencent.mm.ui.chatting.view.b)localObject1).lJ != null))
          {
            localObject3 = new Rect();
            ((com.tencent.mm.ui.chatting.view.b)localObject1).lJ.getWindowVisibleDisplayFrame((Rect)localObject3);
            ((FrameLayout.LayoutParams)localObject2).width = ((Rect)localObject3).right;
          }
          ((com.tencent.mm.ui.chatting.view.b)localObject1).oFW.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (Build.VERSION.SDK_INT >= 21) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.getWindow().addFlags(-2147483648);
          }
          if (!((com.tencent.mm.ui.chatting.view.b)localObject1).pMG) {
            break label1295;
          }
          ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.getWindow().setFlags(8, 8);
          ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.getWindow().addFlags(131200);
          ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.getWindow().getDecorView().setSystemUiVisibility(6);
          label974:
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).pMC != null) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).pMC.bxz = false;
          }
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).XbB != null) {
            ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.setOnDismissListener(new b.2((com.tencent.mm.ui.chatting.view.b)localObject1));
          }
          if (((com.tencent.mm.ui.chatting.view.b)localObject1).lJ != null) {
            if (((com.tencent.mm.ui.chatting.view.b)localObject1).lS != null) {
              break label1354;
            }
          }
        }
      }
    }
    label1295:
    label1354:
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.ui.chatting.view.b)localObject1).lS = ((com.tencent.mm.ui.chatting.view.b)localObject1).lJ.getViewTreeObserver();
      if (i != 0) {
        ((com.tencent.mm.ui.chatting.view.b)localObject1).lS.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject1);
      }
      if (((((com.tencent.mm.ui.chatting.view.b)localObject1).mContext instanceof Activity)) && (!((Activity)((com.tencent.mm.ui.chatting.view.b)localObject1).mContext).isFinishing())) {
        ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.show();
      }
      if (this.WLm != null) {
        this.WLm.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185889);
            ad.h(ad.this).bL(33);
            AppMethodBeat.o(185889);
          }
        });
      }
      localObject2 = new StringBuilder();
      localObject1 = this.iZT.iXI.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
      }
      if (this.WLw.size() > 0)
      {
        this.WLn.setVisibility(8);
        this.WLo.setVisibility(0);
        break;
      }
      this.WLn.setVisibility(8);
      this.WLo.setVisibility(8);
      break;
      label1227:
      this.iZJ.setVisibility(8);
      i = 0;
      break label313;
      label1241:
      this.iZL.setVisibility(8);
      j = 0;
      break label333;
      label1255:
      this.WLl.setVisibility(8);
      this.Nsh.setVisibility(0);
      break label358;
      label1275:
      i = com.tencent.mm.ci.a.fromDPToPix(this.fgR.WQv.getContext(), 264);
      break label416;
      ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.getWindow().clearFlags(8);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.getWindow().clearFlags(131072);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.getWindow().clearFlags(128);
      ((com.tencent.mm.ui.chatting.view.b)localObject1).pMz.getWindow().getDecorView().setSystemUiVisibility(0);
      break label974;
    }
    Object localObject3 = new StringBuilder();
    Object localObject1 = this.WLw.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject3).append(((GroupToolItem)((Iterator)localObject1).next()).username).append("|");
    }
    localObject1 = this.fgR.getTalkerUserName();
    int m;
    if (this.iZT == null)
    {
      j = 0;
      m = this.WLw.size();
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!ab.Rh((String)localObject1)) {
        break label1572;
      }
      i = 2;
    }
    for (;;)
    {
      al localal = new al();
      localal.jd((String)localObject1);
      localal.geB = 2L;
      localal.giR = j;
      localal.giS = m;
      localal.giO = i;
      localal.giV = localal.z("topAppList", (String)localObject2, true);
      localal.giW = localal.z("usedAppList", (String)localObject3, true);
      localal.bpa();
      AppMethodBeat.o(179894);
      return;
      j = this.iZT.iXI.size();
      break;
      label1572:
      i = k;
      if (ab.Rg((String)localObject1)) {
        i = 1;
      }
    }
  }
  
  private void hPD()
  {
    AppMethodBeat.i(276443);
    this.iZT = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().Kv(this.fgR.getTalkerUserName());
    if (this.iZT == null)
    {
      e locale = new e();
      locale.field_chatroomname = this.fgR.getTalkerUserName();
      boolean bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(locale);
      if (bool) {
        this.iZT = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().Kv(this.fgR.getTalkerUserName());
      }
      Log.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools insert GroupTools: result(%s)", new Object[] { Boolean.valueOf(bool) });
    }
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools start:%s queryRecentUse:%s state:%s", new Object[] { this.fgR.getTalkerUserName(), Boolean.TRUE, Integer.valueOf(this.iZT.field_queryState) });
    if (this.iZT.field_queryState == 1)
    {
      this.WLw.clear();
      this.WLw.addAll(this.iZT.iXJ);
      Collections.sort(this.WLw, new Comparator() {});
      hPC();
      AppMethodBeat.o(276443);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179856);
        if (ad.this.WLv != null) {}
        for (Object localObject = Boolean.valueOf(ad.this.WLv.isAlive());; localObject = "null")
        {
          Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentToolsThread interrupt() %s", new Object[] { localObject });
          if ((ad.this.WLv != null) && (ad.this.WLv.isAlive())) {
            ad.this.WLv.interrupt();
          }
          AppMethodBeat.o(179856);
          return;
        }
      }
    }, 5000L);
    this.WLv = new Thread(this.WLC);
    this.WLv.start();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179860);
        if ((ad.this.WLv != null) && (ad.this.WLv.isAlive())) {
          ad.i(ad.this);
        }
        AppMethodBeat.o(179860);
      }
    }, 200L);
    AppMethodBeat.o(276443);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(179884);
    super.hGV();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179884);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(179885);
    super.hGW();
    String str = this.fgR.getTalkerUserName();
    if ((!Util.isNullOrNil(str)) && (ab.PP(str)) && (ab.Rg(str)))
    {
      this.WLx = true;
      AppMethodBeat.o(179885);
      return;
    }
    this.WLx = false;
    AppMethodBeat.o(179885);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(179889);
    super.hGX();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingResume");
    this.WLA.dead();
    AppMethodBeat.o(179889);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(179890);
    super.hGY();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingPause");
    AppMethodBeat.o(179890);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(179886);
    super.hGZ();
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingExitAnimStart");
    this.WLA.dead();
    AppMethodBeat.o(179886);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(179887);
    super.hNZ();
    this.fxt = false;
    if (this.WLk != null) {
      this.WLk.setVisibility(8);
    }
    AppMethodBeat.o(179887);
  }
  
  public final void hPB()
  {
    AppMethodBeat.i(179888);
    if (!aa.asf())
    {
      AppMethodBeat.o(179888);
      return;
    }
    hPD();
    AppMethodBeat.o(179888);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
  
  public static final class b
    extends RecyclerView.v
  {
    static final c jak;
    LinearLayout WLG;
    TextView WLa;
    View jac;
    ImageView jmf;
    
    static
    {
      AppMethodBeat.i(179874);
      c.a locala1 = new c.a();
      locala1.lRP = R.k.app_brand_app_default_icon_for_tail;
      c.a locala2 = locala1.dO(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20));
      locala2.kPz = true;
      locala2.lRD = true;
      locala2.lRB = true;
      jak = locala1.bmL();
      AppMethodBeat.o(179874);
    }
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(179873);
      this.jac = paramView;
      this.WLG = ((LinearLayout)paramView.findViewById(R.h.dXQ));
      this.jmf = ((ImageView)paramView.findViewById(R.h.dXR));
      this.WLa = ((TextView)paramView.findViewById(R.h.dXS));
      AppMethodBeat.o(179873);
    }
  }
  
  public static final class d
    extends RecyclerView.a
  {
    private ad.a WLH;
    private Context context;
    private List<GroupToolItem> jan;
    
    public d(Context paramContext, List<GroupToolItem> paramList, ad.a parama)
    {
      this.context = paramContext;
      this.jan = paramList;
      this.WLH = parama;
    }
    
    private static void a(ad.b paramb, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(179880);
      com.tencent.mm.ay.a.a locala = com.tencent.mm.ay.q.bml();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramb.jmf, ad.b.jak);
        localObject = paramb.WLa;
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
      AppMethodBeat.i(274774);
      paramViewGroup = new ad.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ecs, paramViewGroup, false));
      AppMethodBeat.o(274774);
      return paramViewGroup;
    }
    
    public final void d(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(274776);
      GroupToolItem localGroupToolItem;
      if ((this.jan != null) && (paramInt >= 0) && (paramInt < this.jan.size()))
      {
        paramv = (ad.b)paramv;
        localGroupToolItem = (GroupToolItem)this.jan.get(paramInt);
        paramv.jac.setVisibility(0);
        if (!localGroupToolItem.asn()) {
          break label112;
        }
        paramv.jmf.setImageResource(R.g.group_tool_aa_pay);
        paramv.WLa.setText(R.l.eGs);
      }
      for (;;)
      {
        paramv.jac.setTag(localGroupToolItem);
        paramv.jac.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179877);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (ad.d.a(ad.d.this) != null) {
              ad.d.a(ad.d.this).onClick(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179877);
          }
        });
        AppMethodBeat.o(274776);
        return;
        label112:
        if (localGroupToolItem.aso())
        {
          paramv.jmf.setImageDrawable(com.tencent.mm.ci.a.m(this.context, R.g.group_tool_live));
          paramv.WLa.setText(R.l.app_field_live);
        }
        else
        {
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(localGroupToolItem.username);
          if (localWxaAttributes == null) {
            ((com.tencent.mm.plugin.appbrand.service.q)h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).a(localGroupToolItem.username, new q.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(179876);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179875);
                    ad.d.b(ad.d.1.this.WLI, paramAnonymousWxaAttributes);
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
      int i = this.jan.size();
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
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ad
 * JD-Core Version:    0.7.0.1
 */