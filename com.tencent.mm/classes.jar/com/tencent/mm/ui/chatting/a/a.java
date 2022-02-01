package com.tencent.mm.ui.chatting.a;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.q;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.y;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.t.f;
import com.tencent.mm.ui.chatting.t.g;
import com.tencent.mm.ui.chatting.viewitems.ap.a;
import com.tencent.mm.ui.chatting.viewitems.ap.b;
import com.tencent.mm.ui.chatting.viewitems.ay.d;
import com.tencent.mm.ui.chatting.viewitems.bl;
import com.tencent.mm.ui.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends BaseAdapter
  implements com.tencent.mm.ui.chatting.d.b.k
{
  public t.g JZU;
  private t.g JZV;
  public t.f JZW;
  private t.f JZX;
  public com.tencent.mm.pluginsdk.ui.chat.l JZY;
  private com.tencent.mm.pluginsdk.ui.chat.l JZZ;
  public com.tencent.mm.ui.chatting.e.a Jyf;
  public ab Kaa;
  private ab Kab;
  public com.tencent.mm.ui.chatting.c Kac;
  private com.tencent.mm.ui.chatting.c Kad;
  private View.OnClickListener Kae;
  private final int Kaf;
  private final int Kag;
  public SparseArray<bv> Kah;
  private HashSet<Long> Kai;
  public SparseIntArray Kaj;
  public long Kak;
  public long Kal;
  private CopyOnWriteArraySet<Long> Kam;
  private Map<Long, Integer> Kan;
  private Map<Long, WeakReference<View>> Kao;
  private boolean Kap;
  private boolean Kaq;
  private boolean Kar;
  private final com.tencent.mm.sdk.platformtools.aw Kas;
  public com.tencent.mm.ui.chatting.n.a.a Kat;
  private boolean Kau;
  private int Kav;
  protected i.a Kaw;
  private t.a Kax;
  private long Kay;
  private boolean cVC;
  public com.tencent.mm.av.a.a.c fUx;
  private int fVN;
  private LayoutInflater jiz;
  private ListView mListView;
  private com.tencent.mm.pluginsdk.ui.span.h ohO;
  private boolean ySB;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, ListView paramListView)
  {
    AppMethodBeat.i(34989);
    this.Kae = null;
    this.Kah = new SparseArray();
    this.Kai = new HashSet();
    this.Kaj = new SparseIntArray();
    this.Kak = -1L;
    this.Kal = -1L;
    this.Kam = new CopyOnWriteArraySet();
    this.Kan = new HashMap();
    this.Kao = new HashMap();
    this.Kap = false;
    this.Kaq = false;
    this.ySB = false;
    this.Kar = false;
    this.Kas = new com.tencent.mm.sdk.platformtools.aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34984);
        if ((a.a(a.this) != null) && (a.a(a.this).cCq))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
          a.this.fGq();
        }
        AppMethodBeat.o(34984);
        return true;
      }
    }, true);
    this.fVN = -1;
    this.Kau = false;
    this.Kav = 0;
    this.Kaw = new i.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(34986);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(34986);
          return;
        }
        if ((paramAnonymousc.talker == null) || (a.a(a.this).getTalkerUserName() == null))
        {
          AppMethodBeat.o(34986);
          return;
        }
        if (paramAnonymousc.talker.equals(a.a(a.this).getTalkerUserName())) {
          a.this.fGq();
        }
        AppMethodBeat.o(34986);
      }
    };
    this.Kax = new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(34988);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousa != null)
        {
          bool1 = bool2;
          if (paramAnonymousa.ixf != 3) {
            if ((paramAnonymousa.ixf != 2) && (paramAnonymousa.ixf != -1))
            {
              bool1 = bool2;
              if (paramAnonymousa.ixf != 1) {}
            }
            else
            {
              bool1 = ay.d.b(paramAnonymousa);
            }
          }
        }
        if (!bool1) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34987);
              a.this.fGq();
              AppMethodBeat.o(34987);
            }
          });
        }
        AppMethodBeat.o(34988);
      }
    };
    this.Kay = -1L;
    this.fUx = null;
    parama.a(com.tencent.mm.ui.chatting.d.b.k.class, this);
    this.mListView = paramListView;
    this.Jyf = parama;
    this.jiz = z.jV(parama.Kkd.getContext());
    this.Kaf = parama.Kkd.getMMResources().getDimensionPixelSize(2131165575);
    this.Kag = parama.Kkd.getMMResources().getDimensionPixelSize(2131165490);
    paramListView = new t.g();
    this.JZV = paramListView;
    this.JZU = paramListView;
    paramListView = new t.f(parama);
    this.JZX = paramListView;
    this.JZW = paramListView;
    paramListView = new com.tencent.mm.pluginsdk.ui.chat.l(parama.Kkd.getContext());
    this.JZZ = paramListView;
    this.JZY = paramListView;
    paramListView = new ab(parama);
    this.Kab = paramListView;
    this.Kaa = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.Kad = paramListView;
    this.Kac = paramListView;
    this.ohO = new ag(parama);
    fgs();
    AppMethodBeat.o(34989);
  }
  
  private static boolean bC(bv parambv)
  {
    AppMethodBeat.i(187195);
    if ((parambv.fvF()) || (parambv.fvI()) || (parambv.fvP()))
    {
      AppMethodBeat.o(187195);
      return false;
    }
    AppMethodBeat.o(187195);
    return true;
  }
  
  private void fGl()
  {
    AppMethodBeat.i(34994);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.JZU = null;
    this.JZW = null;
    this.JZY = null;
    this.Kaa = null;
    this.Kac = null;
    AppMethodBeat.o(34994);
  }
  
  private void fgs()
  {
    AppMethodBeat.i(35018);
    if (this.fUx == null)
    {
      com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
      locala.prefixPath = com.tencent.mm.al.a.e.EZ(this.Jyf.getTalkerUserName());
      locala.igk = true;
      locala.hgL = true;
      locala.igv = 2131690013;
      try
      {
        this.fUx = locala.aJu();
        AppMethodBeat.o(35018);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.ChattingDataAdapter", localNullPointerException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(35018);
  }
  
  public final boolean Eq(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(35000);
    int i;
    label65:
    Object localObject;
    label128:
    label181:
    int k;
    if (this.Kam.contains(Long.valueOf(paramLong)))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.Kam.remove(Long.valueOf(paramLong));
      if (this.mListView == null) {
        break label390;
      }
      i = j;
      if (i >= this.mListView.getChildCount()) {
        break label390;
      }
      localObject = this.mListView.getChildAt(i);
      com.tencent.mm.ui.chatting.viewitems.c.a locala = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((locala != null) && (locala.hcH != null) && (((Long)locala.hcH.getTag()).longValue() == paramLong))
      {
        if (localObject == null) {
          break label396;
        }
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        if ((((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).iFD != null) && (((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).iFD.getVisibility() == 0)) {
          ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).iFD.setChecked(this.Kam.contains(Long.valueOf(paramLong)));
        }
        AppMethodBeat.o(35000);
        return true;
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      k = this.Kam.size();
      if (!this.Kaq) {
        break label403;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOD, 99);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if (k >= i)
      {
        if (this.Kaq) {}
        for (localObject = this.Jyf.Kkd.getMMResources().getString(2131766945, new Object[] { Integer.valueOf(i) });; localObject = this.Jyf.Kkd.getMMResources().getString(2131758462, new Object[] { Integer.valueOf(99) }))
        {
          com.tencent.mm.ui.base.h.c(this.Jyf.Kkd.getContext(), (String)localObject, "", true);
          AppMethodBeat.o(35000);
          return false;
        }
      }
      this.Kam.add(Long.valueOf(paramLong));
      break;
      i += 1;
      break label65;
      label390:
      localObject = null;
      break label128;
      label396:
      notifyDataSetChanged();
      break label181;
      label403:
      i = 99;
    }
  }
  
  public final View Er(long paramLong)
  {
    AppMethodBeat.i(187198);
    if (!this.Kao.containsKey(Long.valueOf(paramLong)))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(187198);
      return null;
    }
    Object localObject = (WeakReference)this.Kao.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(187198);
      return localObject;
    }
    AppMethodBeat.o(187198);
    return null;
  }
  
  public final void L(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35013);
    if ((!this.Kao.containsKey(Long.valueOf(paramLong))) || (!this.Kan.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35013);
      return;
    }
    Object localObject = (WeakReference)this.Kao.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ap.b.c((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramBoolean);
      }
      AppMethodBeat.o(35013);
      return;
    }
  }
  
  public final void a(int paramInt, d.a parama)
  {
    AppMethodBeat.i(35009);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.Kat.a(parama, false, localBundle);
    AppMethodBeat.o(35009);
  }
  
  public final void a(long paramLong, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(35014);
    if ((!this.Kao.containsKey(Long.valueOf(paramLong))) || (!this.Kan.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35014);
      return;
    }
    Object localObject = (WeakReference)this.Kao.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        ap.a.a(this.Jyf.Kkd.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a)localObject, parambv, paramBoolean);
      }
      AppMethodBeat.o(35014);
      return;
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(35008);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), parama });
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", paramLong);
    localBundle.putInt("SCENE", 1);
    localBundle.putBoolean("IS_LOAD_ALL", paramBoolean);
    this.Kat.a(parama, true, localBundle);
    AppMethodBeat.o(35008);
  }
  
  public final bv adI(int paramInt)
  {
    AppMethodBeat.i(34999);
    bv localbv = (bv)this.Kah.get(paramInt);
    AppMethodBeat.o(34999);
    return localbv;
  }
  
  public final void adJ(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35007);
    bv localbv = adI(paramInt);
    if (localbv == null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localbv != null) && (localbv.field_msgId != 0L)) {
      this.Kak = localbv.field_msgId;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(35007);
  }
  
  public final void adK(int paramInt)
  {
    AppMethodBeat.i(35015);
    bv localbv = adI(paramInt);
    if ((localbv != null) && (localbv.field_msgId != 0L)) {
      this.Kai.add(Long.valueOf(localbv.field_msgId));
    }
    AppMethodBeat.o(35015);
  }
  
  public final bv adL(int paramInt)
  {
    AppMethodBeat.i(161523);
    paramInt -= 1;
    if ((this.Kah != null) && (paramInt >= 0) && (paramInt < this.Kah.size()))
    {
      bv localbv = (bv)this.Kah.get(paramInt);
      AppMethodBeat.o(161523);
      return localbv;
    }
    AppMethodBeat.o(161523);
    return null;
  }
  
  public final boolean bD(bv parambv)
  {
    AppMethodBeat.i(187196);
    if ((parambv != null) && (bC(parambv)))
    {
      AppMethodBeat.o(187196);
      return true;
    }
    AppMethodBeat.o(187196);
    return false;
  }
  
  public final void cxI()
  {
    AppMethodBeat.i(35003);
    this.Kap = false;
    notifyDataSetChanged();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.JZU = this.JZV;
    this.JZW = this.JZX;
    this.JZY = this.JZZ;
    this.Kaa = this.Kab;
    this.Kac = this.Kad;
    AppMethodBeat.o(35003);
  }
  
  public final int dGd()
  {
    AppMethodBeat.i(35001);
    int i = this.Kam.size();
    AppMethodBeat.o(35001);
    return i;
  }
  
  public final void e(View.OnClickListener paramOnClickListener)
  {
    this.Kae = paramOnClickListener;
  }
  
  public final void eP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35020);
    if (this.Jyf == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    Object localObject1 = this.Jyf.Cqh;
    if (localObject1 == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOf();
    bv localbv;
    Object localObject2;
    if (((an)localObject1).fug())
    {
      localObject1 = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        localbv = adL(paramInt1);
        if ((localbv != null) && (localbv.getType() == 285212721))
        {
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + localbv.field_msgId);
          ((List)localObject1).add(new String[] { String.valueOf(localbv.field_msgId), localbv.field_content, "-1" });
          localObject2 = new q();
          ((q)localObject2).msgId = localbv.field_msgId;
          ((q)localObject2).hFS = localbv.field_content;
          if (bool) {
            localLinkedList.add(localObject2);
          }
        }
        paramInt1 += 1;
      }
      if (((List)localObject1).size() > 0)
      {
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).k((List)localObject1, 0);
        if (bool) {
          ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).l(localLinkedList, 0);
        }
      }
      AppMethodBeat.o(35020);
      return;
    }
    localLinkedList = new LinkedList();
    Object localObject3;
    String str;
    int j;
    Object localObject4;
    if (paramInt1 <= paramInt2)
    {
      localbv = adL(paramInt1);
      if ((localbv != null) && ((localbv.getType() & 0x31) != 0))
      {
        localObject2 = localbv.field_content;
        if (localObject2 != null)
        {
          localObject2 = k.b.aB((String)localObject2, localbv.field_reserved);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((k.b)localObject2).url)) && (((k.b)localObject2).url.contains("mp.weixin.qq.com")))
          {
            localObject3 = bl.cy(localbv);
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.ui.chatting.viewitems.c)localObject3).b(this.Jyf, localbv);
              if (localObject3 != null)
              {
                str = ((com.tencent.mm.g.c.aw)localObject1).field_username;
                if (str != null)
                {
                  j = y.aH((String)localObject3, this.Jyf.getTalkerUserName());
                  localObject4 = (com.tencent.mm.ah.e)((k.b)localObject2).ao(com.tencent.mm.ah.e.class);
                  if (localObject4 == null) {
                    break label630;
                  }
                }
              }
            }
          }
        }
      }
    }
    label630:
    for (int i = ((com.tencent.mm.ah.e)localObject4).hBV;; i = -1)
    {
      localObject4 = new ArrayList();
      ((List)localObject4).add(((k.b)localObject2).url);
      ((List)localObject4).add(String.valueOf(i));
      ((List)localObject4).add(String.valueOf(localbv.field_msgSvrId));
      ((List)localObject4).add(str);
      ((List)localObject4).add(String.valueOf(j));
      ((List)localObject4).add(localObject3);
      ((List)localObject4).add(String.valueOf(localbv.field_createTime));
      ((List)localObject4).add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).XB(str)));
      localLinkedList.add(localObject4);
      paramInt1 += 1;
      break;
      if (localLinkedList.size() > 0) {
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).j(localLinkedList, 1);
      }
      AppMethodBeat.o(35020);
      return;
    }
  }
  
  public final long fGA()
  {
    AppMethodBeat.i(35017);
    long l;
    if (this.Kay != -1L)
    {
      l = this.Kay;
      AppMethodBeat.o(35017);
      return l;
    }
    this.Kay = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        bv localbv = adI(i);
        if ((localbv.field_isSend == 1) && ((localbv.eNc & 0x4) != 4)) {
          this.Kay = localbv.field_msgId;
        }
      }
      else
      {
        l = this.Kay;
        AppMethodBeat.o(35017);
        return l;
      }
      i -= 1;
    }
  }
  
  public final com.tencent.mm.av.a.a.c fGB()
  {
    AppMethodBeat.i(35019);
    if (this.fUx == null) {
      fgs();
    }
    com.tencent.mm.av.a.a.c localc = this.fUx;
    AppMethodBeat.o(35019);
    return localc;
  }
  
  public final SparseArray<bv> fGk()
  {
    return this.Kah;
  }
  
  public final Set<Long> fGm()
  {
    return this.Kam;
  }
  
  public final void fGn()
  {
    AppMethodBeat.i(35002);
    if (this.Kam != null) {
      this.Kam.clear();
    }
    AppMethodBeat.o(35002);
  }
  
  public final void fGo()
  {
    AppMethodBeat.i(35004);
    this.Kap = true;
    notifyDataSetChanged();
    fGl();
    AppMethodBeat.o(35004);
  }
  
  public final void fGp()
  {
    this.Kaq = true;
  }
  
  public final void fGq()
  {
    AppMethodBeat.i(35006);
    if (this.Kau)
    {
      this.Kav += 1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.Kav);
      AppMethodBeat.o(35006);
      return;
    }
    if (!this.cVC)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      AppMethodBeat.o(35006);
      return;
    }
    this.Kat.a(d.a.Krx, false, null);
    AppMethodBeat.o(35006);
  }
  
  public final void fGr()
  {
    AppMethodBeat.i(35010);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.Kau), Integer.valueOf(this.Kav) });
    if (this.Kau)
    {
      AppMethodBeat.o(35010);
      return;
    }
    this.Kau = true;
    this.Kav = 0;
    AppMethodBeat.o(35010);
  }
  
  public final void fGs()
  {
    AppMethodBeat.i(35011);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.Kau), Integer.valueOf(this.Kav) });
    if (!this.Kau)
    {
      AppMethodBeat.o(35011);
      return;
    }
    this.Kau = false;
    if (this.Kav > 0) {
      this.Kat.a(d.a.Krx, false, null);
    }
    this.Kav = 0;
    AppMethodBeat.o(35011);
  }
  
  public final void fGt()
  {
    AppMethodBeat.i(35016);
    this.Kar = true;
    fGl();
    AppMethodBeat.o(35016);
  }
  
  public final t.a fGu()
  {
    return this.Kax;
  }
  
  public final t.f fGv()
  {
    return this.JZW;
  }
  
  public final t.g fGw()
  {
    return this.JZU;
  }
  
  public final ab fGx()
  {
    return this.Kaa;
  }
  
  public final com.tencent.mm.pluginsdk.ui.chat.l fGy()
  {
    return this.JZY;
  }
  
  public final com.tencent.mm.ui.chatting.c fGz()
  {
    return this.Kac;
  }
  
  public final void fdN()
  {
    AppMethodBeat.i(34997);
    com.tencent.mm.ui.chatting.e.a.fJE().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34985);
        a.this.notifyDataSetChanged();
        AppMethodBeat.o(34985);
      }
    });
    AppMethodBeat.o(34997);
  }
  
  public final int ftv()
  {
    AppMethodBeat.i(34998);
    if (-1 == this.fVN)
    {
      bc.aCg();
      this.fVN = com.tencent.mm.model.c.azI().arr(this.Jyf.getTalkerUserName());
    }
    int i = this.fVN;
    AppMethodBeat.o(34998);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34990);
    int i = this.Kah.size();
    AppMethodBeat.o(34990);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(34991);
    paramInt = bl.cz(adI(paramInt));
    AppMethodBeat.o(34991);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34993);
    bv localbv = adI(paramInt);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + paramInt + " msgId:" + localbv.field_msgId + " svrId:" + localbv.field_msgSvrId + " type:" + localbv.getType() + " send:" + localbv.field_isSend + " talker:" + localbv.field_talker + " msgSep:" + localbv.field_msgSeq + " time:" + localbv.field_createTime);
    if (paramInt == 0)
    {
      paramViewGroup = this.Jyf;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.Kke.fFZ();
    }
    int i;
    int j;
    label227:
    label246:
    Object localObject;
    if ((paramInt != 0) && (this.Kaj.get(paramInt) == 0))
    {
      long l1 = adI(paramInt - 1).field_createTime;
      long l2 = localbv.field_createTime;
      if (l2 - l1 < 60000L)
      {
        i = 1;
        if ((l2 - l1) / 180000L >= 1L) {
          break label1217;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label1223;
        }
        this.Kaj.put(paramInt, 2);
      }
    }
    else
    {
      if (((this.Kaj.get(paramInt) != 1) && (paramInt != 0) && (!this.Kai.contains(Long.valueOf(localbv.field_msgId)))) || (localbv.field_createTime <= 1000L)) {
        break label1235;
      }
      i = 1;
      label295:
      if (localbv.field_msgId != this.Kak) {
        break label1241;
      }
      j = 1;
      label311:
      if (t.aKt().GD(this.Jyf.getTalkerUserName()) == null)
      {
        bc.aCg();
        ((Integer)com.tencent.mm.model.c.ajA().get(12311, Integer.valueOf(-2))).intValue();
      }
      if (paramView != null) {
        break label1247;
      }
      localObject = bl.cy(localbv);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.jiz, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.KuO = ((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      label388:
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", new Object[] { paramViewGroup.KuO });
      if (i == 0) {
        break label1258;
      }
      paramViewGroup.fVV.setVisibility(0);
      paramViewGroup.fVV.setText(com.tencent.mm.pluginsdk.i.i.c(this.Jyf.Kkd.getContext(), localbv.field_createTime, false));
      if (paramViewGroup.fVV.getTextSize() > com.tencent.mm.cb.a.fromDPToPix(this.Jyf.Kkd.getContext(), 25)) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", new Object[] { Float.valueOf(paramViewGroup.fVV.getTextSize()) });
      }
      label500:
      if (paramViewGroup.KuJ != null)
      {
        if (j == 0) {
          break label1270;
        }
        paramViewGroup.KuJ.setVisibility(0);
      }
      label520:
      if (this.Kal == -1L)
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ard(this.Jyf.getTalkerUserName());
        if (localObject == null) {
          break label1282;
        }
        this.Kal = ((ei)localObject).field_msgId;
      }
      label573:
      if (paramViewGroup.KuK != null)
      {
        if ((!this.Kaq) || (localbv.field_msgId != this.Kal)) {
          break label1290;
        }
        paramViewGroup.KuK.setVisibility(0);
      }
      label608:
      localObject = paramViewGroup.KuO;
      paramViewGroup.KuN = null;
      com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aKc();
      if ((localf != null) && (localf.ijZ != null) && (localf.ijX == 0) && (com.tencent.mm.ay.a.aJZ())) {
        paramViewGroup.KuN = localf.ijZ;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.Jyf, localbv);
      localObject = ((com.tencent.mm.ui.chatting.d.b.c)this.Jyf.bh(com.tencent.mm.ui.chatting.d.b.c.class)).fHl();
      if ((paramViewGroup.fVV.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.fVV.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).Fky);
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).Fkz) {
          break label1302;
        }
        paramViewGroup.fVV.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.f)localObject).FkA);
        label747:
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).FkB) {
          break label1329;
        }
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).FkC) {
          break label1316;
        }
        paramViewGroup.fVV.setBackgroundResource(2131231583);
        label773:
        paramViewGroup.fVV.setPadding(this.Kag, this.Kaf, this.Kag, this.Kaf);
      }
      label796:
      if ((paramViewGroup.yUp != null) && (paramViewGroup.yUp.getVisibility() == 0) && (localObject != null) && (!this.Jyf.getTalkerUserName().equals("qqmail")) && (localbv.getType() != 318767153))
      {
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).FkC) {
          break label1340;
        }
        paramViewGroup.yUp.setTextColor(-1);
        paramViewGroup.yUp.setShadowLayer(com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.yUp.getContext(), 2), 0.0F, com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.yUp.getContext(), 1), this.Jyf.Kkd.getMMResources().getColor(2131099662));
      }
      label909:
      if (paramViewGroup.hcH != null) {
        paramViewGroup.hcH.setTag(Long.valueOf(localbv.field_msgId));
      }
      if (((!this.Kap) || (!bC(localbv))) && (!this.Kar)) {
        break label1366;
      }
      if (paramViewGroup.iFD != null) {
        paramViewGroup.iFD.setChecked(this.Kam.contains(Long.valueOf(localbv.field_msgId)));
      }
      if (paramViewGroup.hcH != null) {
        paramViewGroup.hcH.setOnClickListener(this.Kae);
      }
      paramViewGroup.yu(true);
      label1005:
      if ((!this.Kap) || (!this.ySB) || (this.Kam.contains(Long.valueOf(localbv.field_msgId)))) {
        break label1374;
      }
      paramView.setAlpha(0.5F);
    }
    for (;;)
    {
      paramViewGroup = this.Kao.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if ((((Map.Entry)localObject).getValue() != null) && ((View)((WeakReference)((Map.Entry)localObject).getValue()).get() == paramView))
        {
          this.Kao.remove(((Map.Entry)localObject).getKey());
          this.Kan.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.Kao.put(Long.valueOf(localbv.field_msgId), new WeakReference(paramView));
      if (localbv.ftg()) {
        this.Kan.put(Long.valueOf(localbv.field_msgId), Integer.valueOf(localbv.field_isSend));
      }
      AppMethodBeat.o(34993);
      return paramView;
      i = 0;
      break;
      label1217:
      j = 0;
      break label227;
      label1223:
      this.Kaj.put(paramInt, 1);
      break label246;
      label1235:
      i = 0;
      break label295;
      label1241:
      j = 0;
      break label311;
      label1247:
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      break label388;
      label1258:
      paramViewGroup.fVV.setVisibility(8);
      break label500;
      label1270:
      paramViewGroup.KuJ.setVisibility(8);
      break label520;
      label1282:
      this.Kal = 0L;
      break label573;
      label1290:
      paramViewGroup.KuK.setVisibility(8);
      break label608;
      label1302:
      paramViewGroup.fVV.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label747;
      label1316:
      paramViewGroup.fVV.setBackgroundResource(2131231582);
      break label773;
      label1329:
      paramViewGroup.fVV.setBackgroundColor(0);
      break label796;
      label1340:
      paramViewGroup.yUp.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).Fky);
      paramViewGroup.yUp.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label909;
      label1366:
      paramViewGroup.yu(false);
      break label1005;
      label1374:
      paramView.setAlpha(1.0F);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(34992);
    int i = bl.fLP();
    AppMethodBeat.o(34992);
    return i;
  }
  
  public final boolean isInEditMode()
  {
    return this.Kap;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35005);
    super.notifyDataSetChanged();
    this.Kaj.clear();
    AppMethodBeat.o(35005);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(34996);
    this.cVC = false;
    bc.aCg();
    com.tencent.mm.model.c.azI().a(this.Kaw);
    com.tencent.mm.pluginsdk.ui.span.k.b(this.ohO);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.Kas.stopTimer();
    AppMethodBeat.o(34996);
  }
  
  public final void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(187197);
    if (this.ySB != paramBoolean)
    {
      this.ySB = paramBoolean;
      notifyDataSetChanged();
    }
    AppMethodBeat.o(187197);
  }
  
  public final void r(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35012);
    if ((!this.Kao.containsKey(Long.valueOf(paramLong))) || (!this.Kan.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35012);
      return;
    }
    Object localObject = (WeakReference)this.Kao.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ap.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramInt1, paramInt2);
      }
      AppMethodBeat.o(35012);
      return;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(34995);
    this.cVC = true;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    bc.aCg();
    com.tencent.mm.model.c.azI().a(this.Kaw, Looper.getMainLooper());
    com.tencent.mm.pluginsdk.ui.span.k.a(this.ohO);
    this.Kas.ay(300000L, 300000L);
    if (this.Kat != null) {
      this.Kat.a(d.a.Krx, false, null);
    }
    AppMethodBeat.o(34995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */