package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.g.b.a.ev;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.backup.f.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.2;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.a;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.af.class)
public class ao
  extends a
  implements z, RecordSelectTipsBar.a, com.tencent.mm.ui.chatting.d.b.af
{
  private static HashMap<Long, Integer> Khf;
  private RecordSelectTipsBar KgQ;
  private boolean KgR;
  private boolean KgS;
  private int KgT;
  private int KgU;
  private int KgV;
  private long KgW;
  private int KgX;
  private a KgY;
  private boolean KgZ;
  private boolean Kha;
  private boolean Khb;
  private boolean Khc;
  private CopyOnWriteArraySet<Long> Khd;
  private HashMap<Long, bv> Khe;
  private View jwV;
  
  static
  {
    AppMethodBeat.i(187394);
    Khf = new HashMap();
    AppMethodBeat.o(187394);
  }
  
  public ao()
  {
    AppMethodBeat.i(187373);
    this.KgR = false;
    this.KgS = true;
    this.KgT = -1;
    this.KgU = -1;
    this.KgV = -1;
    this.KgW = -1L;
    this.KgX = 0;
    this.KgY = null;
    this.KgZ = true;
    this.Kha = false;
    this.Khb = false;
    this.Khc = false;
    this.Khd = new CopyOnWriteArraySet();
    this.Khe = new HashMap();
    AppMethodBeat.o(187373);
  }
  
  private bv Ev(long paramLong)
  {
    AppMethodBeat.i(187392);
    if (this.Khe.containsKey(Long.valueOf(paramLong)))
    {
      localbv = (bv)this.Khe.get(Long.valueOf(paramLong));
      AppMethodBeat.o(187392);
      return localbv;
    }
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramLong);
    this.Khe.put(Long.valueOf(paramLong), localbv);
    AppMethodBeat.o(187392);
    return localbv;
  }
  
  public static int a(k paramk)
  {
    AppMethodBeat.i(187387);
    paramk = paramk.fGm();
    if (paramk == null)
    {
      AppMethodBeat.o(187387);
      return 0;
    }
    int i = paramk.size();
    AppMethodBeat.o(187387);
    return i;
  }
  
  private Pair<Boolean, Boolean> a(k paramk, long paramLong)
  {
    AppMethodBeat.i(187393);
    if (paramk == null)
    {
      ae.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine adapterComponent is null");
      paramk = Boolean.FALSE;
      paramk = new Pair(paramk, paramk);
      AppMethodBeat.o(187393);
      return paramk;
    }
    if (this.KgQ.getHeight() <= 0)
    {
      ae.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine recordSelectTipsBar height <= 0");
      paramk = Boolean.FALSE;
      paramk = new Pair(paramk, paramk);
      AppMethodBeat.o(187393);
      return paramk;
    }
    paramk = paramk.Er(paramLong);
    if (paramk != null)
    {
      if (this.KgT <= 0)
      {
        arrayOfInt = new int[2];
        this.KgQ.getLocationOnScreen(arrayOfInt);
        this.KgT = (arrayOfInt[1] + this.KgQ.getHeight());
        this.KgU = com.tencent.mm.cb.a.ay(this.cXJ.Kkd.getContext(), 2131165296);
        this.KgV = com.tencent.mm.cb.a.fromDPToPix(this.cXJ.Kkd.getContext(), 24);
        ae.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine(%s, %s) recordSelectTipsBarBottomLoctaion:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.KgQ.getHeight()), Integer.valueOf(this.KgT) });
      }
      for (;;)
      {
        paramk = (CheckBox)paramk.findViewById(2131298068);
        if (paramk != null) {
          break;
        }
        ae.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine, checkBox is null??");
        paramk = Boolean.FALSE;
        paramk = new Pair(paramk, paramk);
        AppMethodBeat.o(187393);
        return paramk;
        arrayOfInt = new int[2];
        this.KgQ.getLocationOnScreen(arrayOfInt);
        ae.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine2(%s, %s)", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.KgQ.getHeight()) });
      }
      int[] arrayOfInt = new int[2];
      paramk.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1] + this.KgV - this.KgT;
      ae.d("MicroMsg.recordSelect.RecordSelectComponent", "view(%s, %s) recordSelectTipsBar(%s) viewTopHeight:%s marginTop:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.KgV), Integer.valueOf(this.KgT), Integer.valueOf(this.KgU), Integer.valueOf(i) });
      if (i > this.KgU)
      {
        paramk = Boolean.TRUE;
        paramk = new Pair(paramk, paramk);
        AppMethodBeat.o(187393);
        return paramk;
      }
      paramk = new Pair(Boolean.TRUE, Boolean.FALSE);
      AppMethodBeat.o(187393);
      return paramk;
    }
    ae.i("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine view is null, msgId:%s", new Object[] { Long.valueOf(paramLong) });
    paramk = Boolean.FALSE;
    paramk = new Pair(paramk, paramk);
    AppMethodBeat.o(187393);
    return paramk;
  }
  
  private void a(k paramk, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(187390);
    Pair localPair = a(paramk, paramLong);
    ae.d("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle msgId:%s result:%s %s", new Object[] { Long.valueOf(paramLong), localPair.first, localPair.second });
    if (((Boolean)localPair.first).booleanValue())
    {
      if (((Boolean)localPair.second).booleanValue())
      {
        if ((!paramk.fGm().contains(Long.valueOf(paramLong))) && (!this.Khd.contains(Long.valueOf(paramLong))))
        {
          if (paramk.fGm().size() >= 99)
          {
            ae.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle max select msg num.");
            AppMethodBeat.o(187390);
            return;
          }
          paramk.Eq(paramLong);
          if (!paramBoolean)
          {
            if (!this.KgZ) {
              this.KgQ.PH(a(paramk));
            }
            yd(true);
            AppMethodBeat.o(187390);
          }
        }
      }
      else if (paramk.fGm().contains(Long.valueOf(paramLong)))
      {
        paramk.Eq(paramLong);
        if (!paramBoolean)
        {
          if (!this.KgZ) {
            this.KgQ.PH(a(paramk));
          }
          yd(false);
          AppMethodBeat.o(187390);
        }
      }
    }
    else {
      ae.w("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle invalid");
    }
    AppMethodBeat.o(187390);
  }
  
  private void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(187391);
    if (this.Kha)
    {
      this.KgQ.performHapticFeedback(0, 2);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.selectrecord.b.a.dQt().dQv();
        AppMethodBeat.o(187391);
        return;
      }
      com.tencent.mm.plugin.selectrecord.b.a.dQt().dQw();
    }
    AppMethodBeat.o(187391);
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(187383);
    ae.i("MicroMsg.recordSelect.RecordSelectComponent", "failDoJob %s", new Object[] { parama });
    AppMethodBeat.o(187383);
  }
  
  public final boolean azv()
  {
    return false;
  }
  
  public final boolean azw()
  {
    return true;
  }
  
  public final boolean azx()
  {
    return false;
  }
  
  public final void b(z.a parama)
  {
    AppMethodBeat.i(187384);
    ae.i("MicroMsg.recordSelect.RecordSelectComponent", "doInBackground %s", new Object[] { parama });
    AppMethodBeat.o(187384);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(187385);
    ae.i("MicroMsg.recordSelect.RecordSelectComponent", "requestExitSelectedMode %s", new Object[] { parama });
    AppMethodBeat.o(187385);
  }
  
  public final void dQB()
  {
    AppMethodBeat.i(187381);
    ae.i("MicroMsg.recordSelect.RecordSelectComponent", "click cleanAllSelect");
    k localk = (k)this.cXJ.bh(k.class);
    Iterator localIterator = localk.fGm().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localk.Eq(localLong.longValue());
      this.Khd.add(localLong);
    }
    localk.fGn();
    this.KgQ.PH(a(localk));
    AppMethodBeat.o(187381);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(187374);
    this.KgR = this.cXJ.Kkd.getBooleanExtra("key_record_msg_select", false).booleanValue();
    this.KgZ = this.cXJ.Kkd.getBooleanExtra("key_record_msg_select_introduce", true).booleanValue();
    this.KgW = this.cXJ.Kkd.getLongExtra("key_record_select_min_msg_id", -1L);
    this.KgX = this.cXJ.Kkd.getIntExtra("key_record_select_msg_num", 0);
    Object localObject = this.cXJ.Kkd.getStringArrayList("key_record_select_msg_black_list");
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.Khd.add(Long.valueOf(bu.getLong(str, 0L)));
      }
    }
    ae.i("MicroMsg.recordSelect.RecordSelectComponent", "isRecordSelect:%s showIntroduceView:%s lastSelectMinMsgId:%s lastSelectMsgNum:%s cancelSelectMsgSet:%s", new Object[] { Boolean.valueOf(this.KgR), Boolean.valueOf(this.KgZ), Long.valueOf(this.KgW), Integer.valueOf(this.KgX), Integer.valueOf(this.Khd.size()) });
    AppMethodBeat.o(187374);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(187375);
    if (this.KgR)
    {
      if (this.KgQ == null)
      {
        l.a(this.cXJ.Kkd, 2131308464);
        this.KgQ = ((RecordSelectTipsBar)this.cXJ.findViewById(2131308397));
        this.KgQ.setIRecordSelectCallback(this);
      }
      k localk = (k)this.cXJ.bh(k.class);
      localk.e(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187371);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if ((!ao.f(ao.this)) && (!ao.this.fIE())) {
            com.tencent.mm.plugin.selectrecord.b.a.dQt().zB(ao.this.fII());
          }
          ao.g(ao.this);
          ao.h(ao.this);
          localObject = (k)ao.this.cXJ.bh(k.class);
          long l = ((Long)paramAnonymousView.getTag()).longValue();
          if (((k)localObject).fGm().contains(Long.valueOf(l)))
          {
            ao.i(ao.this).add(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dQt();
            paramAnonymousView.ySf += 1;
          }
          for (;;)
          {
            if (!((k)localObject).Eq(l))
            {
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dQt();
              paramAnonymousView.yRZ += 1;
            }
            ae.d("MicroMsg.recordSelect.RecordSelectComponent", "setOnEditModeItemClickListener msgId:%s", new Object[] { Long.valueOf(l) });
            ao.a(ao.this).PH(ao.a((k)localObject));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(187371);
            return;
            ao.i(ao.this).remove(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dQt();
            paramAnonymousView.ySe += 1;
          }
        }
      });
      localk.fGo();
      localk.fGp();
      localk.fGn();
      if (fIE()) {
        ((k)this.cXJ.bh(k.class)).a(this.KgW, true, d.a.Krz);
      }
    }
    AppMethodBeat.o(187375);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(187376);
    if (this.KgR)
    {
      d.bJW().bJZ();
      this.KgQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187368);
          ao.this.cXJ.Kkf.adD(ao.a(ao.this).getHeight());
          AppMethodBeat.o(187368);
        }
      });
    }
    AppMethodBeat.o(187376);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(187377);
    super.fGE();
    if (this.KgR)
    {
      this.cXJ.getListView().setOnScrollListener(null);
      this.KgS = true;
      this.KgR = false;
      this.Kha = false;
      this.Khb = false;
    }
    AppMethodBeat.o(187377);
  }
  
  public final boolean fID()
  {
    return this.KgR;
  }
  
  public final boolean fIE()
  {
    return (this.KgW != -1L) && (this.KgX != 0);
  }
  
  public final boolean fIF()
  {
    AppMethodBeat.i(187380);
    if (this.KgR)
    {
      int i6 = fII();
      ae.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish num:%s", new Object[] { Integer.valueOf(i6) });
      if (i6 == 0) {
        v(null);
      }
      for (;;)
      {
        if ((!this.Khb) && (!fIE())) {
          com.tencent.mm.plugin.selectrecord.b.a.dQt().zB(i6);
        }
        AppMethodBeat.o(187380);
        return true;
        Object localObject2 = ((k)this.cXJ.bh(k.class)).fGm();
        Object localObject3;
        if (localObject2 != null)
        {
          localObject1 = v.aAC();
          localObject2 = ((Set)localObject2).iterator();
          long l = 0L;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = Ev(((Long)((Iterator)localObject2).next()).longValue());
            if (localObject3 == null) {
              i = 0;
            }
            for (;;)
            {
              l = i + l;
              break;
              if (Khf.containsKey(Long.valueOf(((ei)localObject3).field_msgId)))
              {
                i = ((Integer)Khf.get(Long.valueOf(((ei)localObject3).field_msgId))).intValue();
              }
              else
              {
                i = m.Zb(((bv)localObject3).getType());
                if (!com.tencent.mm.plugin.backup.f.h.xC(i))
                {
                  ae.e("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { ((ei)localObject3).field_talker, Integer.valueOf(((bv)localObject3).getType()) });
                  Khf.put(Long.valueOf(((ei)localObject3).field_msgId), Integer.valueOf(0));
                  i = 0;
                }
                else
                {
                  if localif = new if();
                  localif.xrk = ((ei)localObject3).field_msgSvrId;
                  if (((ei)localObject3).field_isSend == 1)
                  {
                    localif.FNG = new cxn().aQV((String)localObject1);
                    localif.FNH = new cxn().aQV(((ei)localObject3).field_talker);
                  }
                  Object localObject4;
                  for (localif.FTe = 2;; localif.FTe = 4)
                  {
                    localif.FTj = new SKBuiltinBuffer_t();
                    localif.FTk = 0;
                    localif.FTl = 0;
                    localif.FNL = "";
                    localif.nJA = i;
                    localif.FTf = ((int)(((ei)localObject3).field_createTime / 1000L));
                    localif.FTn = ((ei)localObject3).field_createTime;
                    localif.FTm = ((int)((ei)localObject3).field_msgSeq);
                    localif.FTo = ((ei)localObject3).field_flag;
                    localObject4 = new cxn();
                    ((cxn)localObject4).aQV(bu.bI(((ei)localObject3).field_content, ""));
                    localif.FNI = ((cxn)localObject4);
                    localObject4 = c.bJd().xB(m.Zb(((bv)localObject3).getType()));
                    if (localObject4 != null) {
                      break label581;
                    }
                    ae.d("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(((bv)localObject3).getType()) });
                    Khf.put(Long.valueOf(((ei)localObject3).field_msgId), Integer.valueOf(0));
                    i = 0;
                    break;
                    localif.FNG = new cxn().aQV(((ei)localObject3).field_talker);
                    localif.FNH = new cxn().aQV((String)localObject1);
                  }
                  label581:
                  i = ((com.tencent.mm.plugin.backup.f.l)localObject4).a(localif, true, (bv)localObject3, (String)localObject1, null, null, false, 0L);
                  Khf.put(Long.valueOf(((ei)localObject3).field_msgId), Integer.valueOf(i));
                }
              }
            }
          }
          localObject1 = com.tencent.mm.plugin.selectrecord.b.a.dQt();
          if (((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yRY.eko > 0L)
          {
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).ySm += ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yRY.eko;
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).ySn += 1L;
          }
          ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yRY.eko = l;
          i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOE, 524288000);
          ae.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
          if (l >= i)
          {
            localObject1 = com.tencent.mm.plugin.selectrecord.b.a.dQt();
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).ySa += 1;
            com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContext().getString(2131767155), "", this.cXJ.Kkd.getContext().getString(2131766205), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(187372);
                ae.i("MicroMsg.recordSelect.RecordSelectComponent", "exceed max size, click i know");
                AppMethodBeat.o(187372);
              }
            });
          }
        }
        for (int i = 1; i != 0; i = 0)
        {
          ae.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish exceed max storage size!!!");
          AppMethodBeat.o(187380);
          return true;
        }
        localObject2 = ((com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fHs();
        com.tencent.mm.ui.chatting.l.a(this.cXJ.Kkd.getContext(), (List)localObject2, true, this.cXJ.Cqh.field_username, this);
        Object localObject1 = com.tencent.mm.plugin.selectrecord.b.a.dQt();
        i = 0;
        int k = 0;
        int i4 = 0;
        int n = 0;
        int j = 0;
        int i5 = 0;
        int i1 = 0;
        int i3 = 0;
        int i2 = 0;
        localObject2 = ((List)localObject2).iterator();
        int m = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bv)((Iterator)localObject2).next();
          switch (((bv)localObject3).getType())
          {
          default: 
            i += 1;
            break;
          case 1: 
          case 11: 
          case 21: 
          case 31: 
          case 36: 
          case 301989937: 
            k += 1;
            break;
          case 3: 
          case 13: 
          case 23: 
          case 33: 
          case 39: 
          case 268435505: 
            i4 += 1;
            break;
          case 34: 
            n += 1;
            break;
          case 43: 
          case 44: 
          case 62: 
            j += 1;
            break;
          case 42: 
          case 66: 
            i5 += 1;
            break;
          case 47: 
            m += 1;
            break;
          case 49: 
            localObject3 = k.b.zb(((ei)localObject3).field_content);
            if (localObject3 != null) {
              switch (((k.b)localObject3).type)
              {
              default: 
                i += 1;
                break;
              case 1: 
              case 53: 
              case 57: 
                k += 1;
                break;
              case 6: 
                i1 += 1;
                break;
              case 33: 
              case 36: 
              case 44: 
              case 48: 
                i2 += 1;
                break;
              case 4: 
                j += 1;
                break;
              case 19: 
                i3 += 1;
                break;
              case 1048625: 
                m += 1;
              }
            }
            break;
          }
        }
        localObject2 = i + ";" + k + ";" + i4 + ";" + n + ";" + j + ";" + i5 + ";" + m + ";" + i1 + ";" + i3 + ";" + i2 + ";";
        localObject1 = ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yRY;
        ((ev)localObject1).ehr = ((ev)localObject1).t("FinalShareCountByType", (String)localObject2, true);
      }
    }
    AppMethodBeat.o(187380);
    return false;
  }
  
  public final boolean fIG()
  {
    return this.KgS;
  }
  
  public final CopyOnWriteArraySet<Long> fIH()
  {
    return this.Khd;
  }
  
  public final int fII()
  {
    AppMethodBeat.i(187388);
    int i = a((k)this.cXJ.bh(k.class));
    AppMethodBeat.o(187388);
    return i;
  }
  
  public final void fIJ()
  {
    AppMethodBeat.i(187389);
    if ((!this.Khb) && (!fIE())) {
      com.tencent.mm.plugin.selectrecord.b.a.dQt().zB(fII());
    }
    AppMethodBeat.o(187389);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187378);
    if (!this.KgR)
    {
      AppMethodBeat.o(187378);
      return;
    }
    if (paramInt2 == 0)
    {
      ae.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(187378);
      return;
    }
    paramAbsListView = (k)this.cXJ.bh(k.class);
    final a locala = new a();
    int i = this.cXJ.getHeaderViewsCount();
    Object localObject1 = paramAbsListView.adI(paramInt1 - i);
    if (localObject1 != null) {
      locala.Khj = ((ei)localObject1).field_msgId;
    }
    localObject1 = ((k)this.cXJ.bh(k.class)).adI(paramInt1 + 1 - i);
    if (localObject1 != null) {
      locala.Khk = ((ei)localObject1).field_msgId;
    }
    boolean bool1;
    long l1;
    label183:
    Object localObject2;
    label309:
    Object localObject3;
    if (this.KgY == null)
    {
      bool1 = true;
      boolean bool2 = this.KgZ;
      long l2 = locala.Khj;
      long l3 = locala.Khk;
      if (this.KgY == null) {
        break label767;
      }
      l1 = this.KgY.Khj;
      ae.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll, first:%s showIntroduceView:%s firstVisibleItem:%s headerCount:%s visibleItemCount:%s totalItemCount:%s firstVisibleMsgId:%s secondVisibleMsgId:%s lastFirstVisibleMsgId:%s ifSlide:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(this.Kha) });
      localObject1 = paramAbsListView.fGm();
      localObject2 = paramAbsListView.fGk();
      if (!bool1) {
        break label789;
      }
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 < 0) {
        break label1379;
      }
      localObject3 = (bv)((SparseArray)localObject2).get(paramInt1);
      if ((localObject3 != null) && (((ei)localObject3).field_msgId >= locala.Khj) && (paramAbsListView.bD((bv)localObject3)) && (!this.Khd.contains(Long.valueOf(((ei)localObject3).field_msgId))))
      {
        if (((locala.Khk == -1L) || (((ei)localObject3).field_msgId <= locala.Khk)) && ((locala.Khk != -1L) || (((ei)localObject3).field_msgId <= locala.Khj))) {
          break label775;
        }
        paramAbsListView.Eq(((ei)localObject3).field_msgId);
      }
    }
    for (;;)
    {
      paramInt1 -= 1;
      break label309;
      if (this.jwV == null)
      {
        ae.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll totalItemCount:%s headerViewsCount:%s footerViewCount:%s totalCount:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(this.cXJ.getHeaderViewsCount()), Integer.valueOf(this.cXJ.bGB()), Integer.valueOf(paramAbsListView.ftv()) });
        if ((this.KgZ) && (paramInt3 - this.cXJ.getHeaderViewsCount() - this.cXJ.bGB() == paramAbsListView.ftv()))
        {
          localObject1 = paramAbsListView.adI(0);
          if (((ei)localObject1).field_msgId != 0L)
          {
            localObject2 = a(paramAbsListView, ((ei)localObject1).field_msgId);
            if ((!((Boolean)((Pair)localObject2).first).booleanValue()) || (!((Boolean)((Pair)localObject2).second).booleanValue())) {
              break label665;
            }
            this.KgZ = false;
          }
        }
        label606:
        if (!this.KgZ) {
          break label742;
        }
        localObject1 = this.KgQ;
        com.tencent.e.h.MqF.aM(new RecordSelectTipsBar.2((RecordSelectTipsBar)localObject1));
      }
      for (;;)
      {
        this.cXJ.getListView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187369);
            if (ao.b(ao.this) != null)
            {
              AppMethodBeat.o(187369);
              return;
            }
            ao.a(ao.this, ao.this.cXJ.getListView().findViewById(2131308346));
            if (ao.b(ao.this) != null)
            {
              int i = ao.this.cXJ.getListView().getHeight() - com.tencent.mm.cb.a.ay(ao.this.cXJ.Kkd.getContext(), 2131165292);
              int j = g.ajR().ajA().getInt(am.a.JeB, 0);
              if (((ao.this.fIE()) && (i != j)) || (!ao.this.fIE()))
              {
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)ao.b(ao.this).getLayoutParams();
                localLayoutParams.height = i;
                ao.b(ao.this).setLayoutParams(localLayoutParams);
                if (i != j) {
                  g.ajR().ajA().set(am.a.JeB, Integer.valueOf(localLayoutParams.height));
                }
                ae.i("MicroMsg.recordSelect.RecordSelectComponent", "update footView height:%s", new Object[] { Integer.valueOf(localLayoutParams.height) });
              }
            }
            AppMethodBeat.o(187369);
          }
        }, 300L);
        bool1 = false;
        break;
        label665:
        localObject1 = paramAbsListView.Er(((ei)localObject1).field_msgId);
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = (CheckBox)((View)localObject1).findViewById(2131298068);
        if (localObject1 == null) {}
        for (bool1 = true;; bool1 = false)
        {
          ae.d("MicroMsg.recordSelect.RecordSelectComponent", "checkBox is null(%s)", new Object[] { Boolean.valueOf(bool1) });
          if (localObject1 != null) {
            break;
          }
          this.KgZ = false;
          break;
        }
        label742:
        this.KgQ.PH(a((k)this.cXJ.bh(k.class)));
      }
      label767:
      l1 = -1L;
      break label183;
      label775:
      a(paramAbsListView, ((ei)localObject3).field_msgId, true);
    }
    label789:
    if (locala.Khj < this.KgY.Khj)
    {
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 >= 0)
      {
        localObject3 = (bv)((SparseArray)localObject2).get(paramInt1);
        if ((localObject3 != null) && (((ei)localObject3).field_msgId >= locala.Khj) && (paramAbsListView.bD((bv)localObject3)))
        {
          if (paramAbsListView.fGm().size() < 99) {
            break label910;
          }
          ae.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll max select msg num.(2)");
          if (localObject3 != null) {
            this.Khd.add(Long.valueOf(((ei)localObject3).field_msgId));
          }
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (((locala.Khk != -1L) && (((ei)localObject3).field_msgId > locala.Khk)) || ((locala.Khk == -1L) && (((ei)localObject3).field_msgId > locala.Khj)))
          {
            if ((!((Set)localObject1).contains(Long.valueOf(((ei)localObject3).field_msgId))) && (!this.Khd.contains(Long.valueOf(((ei)localObject3).field_msgId))))
            {
              paramAbsListView.Eq(((ei)localObject3).field_msgId);
              if (!this.KgZ) {
                this.KgQ.PH(a(paramAbsListView));
              }
              yd(true);
            }
          }
          else {
            a(paramAbsListView, ((ei)localObject3).field_msgId, false);
          }
        }
      }
    }
    else
    {
      if (locala.Khj > this.KgY.Khj)
      {
        localObject2 = ((Set)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          if (paramAbsListView.bD(Ev(((Long)localObject3).longValue()))) {
            if (((Long)localObject3).longValue() < locala.Khj)
            {
              paramAbsListView.Eq(((Long)localObject3).longValue());
              yd(false);
              if (!this.KgZ) {
                this.KgQ.PH(a(paramAbsListView));
              }
            }
            else if ((((Long)localObject3).longValue() == locala.Khj) || (((Long)localObject3).longValue() == locala.Khk))
            {
              a(paramAbsListView, ((Long)localObject3).longValue(), false);
            }
          }
        }
      }
      if ((!this.Khd.contains(Long.valueOf(locala.Khj))) && (paramAbsListView.bD(Ev(locala.Khj))))
      {
        if (paramAbsListView.fGm().size() >= 99) {
          this.Khd.add(Long.valueOf(locala.Khj));
        }
        a(paramAbsListView, locala.Khj, false);
      }
      if ((!this.Khd.contains(Long.valueOf(locala.Khk))) && (locala.Khk != -1L) && (paramAbsListView.bD(Ev(locala.Khk))))
      {
        if (paramAbsListView.fGm().size() >= 99) {
          this.Khd.add(Long.valueOf(locala.Khk));
        }
        a(paramAbsListView, locala.Khk, false);
      }
    }
    label910:
    label1379:
    if (this.Kha)
    {
      localObject1 = this.Khd.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        if (locala.Khj > ((Long)localObject2).longValue())
        {
          this.Khd.remove(localObject2);
        }
        else if ((((Long)localObject2).longValue() == locala.Khj) || (((Long)localObject2).longValue() == locala.Khk))
        {
          localObject3 = a(paramAbsListView, ((Long)localObject2).longValue());
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
              this.Khd.remove(localObject2);
            }
          }
          else {
            ae.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll invalid");
          }
        }
      }
    }
    if (!this.Khc) {
      com.tencent.e.h.MqF.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187370);
          if ((ao.c(ao.this) != 0) && (this.Khh.size() + 1 == ao.c(ao.this)))
          {
            if (((locala.Khj == ao.d(ao.this)) || (locala.Khk == ao.d(ao.this))) && (!this.Khh.contains(Long.valueOf(ao.d(ao.this)))))
            {
              ao.this.cXJ.getListView().smoothScrollBy(-com.tencent.mm.cb.a.fromDPToPix(ao.this.cXJ.Kkd.getContext(), 5), 0);
              ae.i("MicroMsg.recordSelect.RecordSelectComponent", "slide below");
            }
            ao.e(ao.this);
          }
          AppMethodBeat.o(187370);
        }
      }, 500L);
    }
    this.KgY = locala;
    AppMethodBeat.o(187378);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(187379);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (!this.KgR)
    {
      AppMethodBeat.o(187379);
      return;
    }
    if ((!this.Khb) && (!fIE())) {
      com.tencent.mm.plugin.selectrecord.b.a.dQt().zB(fII());
    }
    this.Khb = true;
    this.KgZ = false;
    this.Kha = true;
    this.KgQ.PH(a((k)this.cXJ.bh(k.class)));
    ae.d("MicroMsg.recordSelect.RecordSelectComponent", "onScrollStateChanged ifSlide:%s", new Object[] { Boolean.valueOf(this.Kha) });
    AppMethodBeat.o(187379);
  }
  
  public final void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(187382);
    ((k)this.cXJ.bh(k.class)).qT(paramBoolean);
    AppMethodBeat.o(187382);
  }
  
  public final void v(Bundle paramBundle)
  {
    AppMethodBeat.i(187386);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.toString();; paramBundle = "null")
    {
      ae.i("MicroMsg.recordSelect.RecordSelectComponent", "doOnlySelectRecordMsg %s", new Object[] { paramBundle });
      this.KgS = false;
      this.cXJ.Kkd.fEZ();
      AppMethodBeat.o(187386);
      return;
    }
  }
  
  static final class a
  {
    long Khj = -1L;
    long Khk = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ao
 * JD-Core Version:    0.7.0.1
 */