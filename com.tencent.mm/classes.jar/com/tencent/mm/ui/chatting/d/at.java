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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.z.a;
import com.tencent.mm.f.b.a.kk;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.backup.f.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.2;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.a;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@com.tencent.mm.ui.chatting.d.a.a(hRc=ai.class)
public class at
  extends a
  implements com.tencent.mm.aj.z, RecordSelectTipsBar.a, ai
{
  private static HashMap<Long, Integer> WNA;
  private RecordSelectTipsBar WNl;
  private boolean WNm;
  private boolean WNn;
  private int WNo;
  private int WNp;
  private int WNq;
  private long WNr;
  private int WNs;
  private a WNt;
  private boolean WNu;
  private boolean WNv;
  private boolean WNw;
  private boolean WNx;
  private CopyOnWriteArraySet<Long> WNy;
  private HashMap<Long, ca> WNz;
  private View nnu;
  
  static
  {
    AppMethodBeat.i(259827);
    WNA = new HashMap();
    AppMethodBeat.o(259827);
  }
  
  public at()
  {
    AppMethodBeat.i(259785);
    this.WNm = false;
    this.WNn = true;
    this.WNo = -1;
    this.WNp = -1;
    this.WNq = -1;
    this.WNr = -1L;
    this.WNs = 0;
    this.WNt = null;
    this.WNu = true;
    this.WNv = false;
    this.WNw = false;
    this.WNx = false;
    this.WNy = new CopyOnWriteArraySet();
    this.WNz = new HashMap();
    AppMethodBeat.o(259785);
  }
  
  private void Gn(boolean paramBoolean)
  {
    AppMethodBeat.i(259824);
    if (this.WNv)
    {
      this.WNl.performHapticFeedback(0, 2);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.selectrecord.b.a.fFx().fFz();
        AppMethodBeat.o(259824);
        return;
      }
      com.tencent.mm.plugin.selectrecord.b.a.fFx().fFA();
    }
    AppMethodBeat.o(259824);
  }
  
  private ca VK(long paramLong)
  {
    AppMethodBeat.i(259825);
    if (this.WNz.containsKey(Long.valueOf(paramLong)))
    {
      localca = (ca)this.WNz.get(Long.valueOf(paramLong));
      AppMethodBeat.o(259825);
      return localca;
    }
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong);
    this.WNz.put(Long.valueOf(paramLong), localca);
    AppMethodBeat.o(259825);
    return localca;
  }
  
  public static int a(k paramk)
  {
    AppMethodBeat.i(259820);
    paramk = paramk.hND();
    if (paramk == null)
    {
      AppMethodBeat.o(259820);
      return 0;
    }
    int i = paramk.size();
    AppMethodBeat.o(259820);
    return i;
  }
  
  private Pair<Boolean, Boolean> a(k paramk, long paramLong)
  {
    AppMethodBeat.i(259826);
    if (paramk == null)
    {
      Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine adapterComponent is null");
      paramk = Boolean.FALSE;
      paramk = new Pair(paramk, paramk);
      AppMethodBeat.o(259826);
      return paramk;
    }
    if (this.WNl.getHeight() <= 0)
    {
      Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine recordSelectTipsBar height <= 0");
      paramk = Boolean.FALSE;
      paramk = new Pair(paramk, paramk);
      AppMethodBeat.o(259826);
      return paramk;
    }
    paramk = paramk.Fl(paramLong);
    if (paramk != null)
    {
      if (this.WNo <= 0)
      {
        arrayOfInt = new int[2];
        this.WNl.getLocationOnScreen(arrayOfInt);
        this.WNo = (arrayOfInt[1] + this.WNl.getHeight());
        this.WNp = com.tencent.mm.ci.a.aZ(this.fgR.WQv.getContext(), R.f.Edge_5A);
        this.WNq = com.tencent.mm.ci.a.fromDPToPix(this.fgR.WQv.getContext(), 24);
        Log.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine(%s, %s) recordSelectTipsBarBottomLoctaion:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.WNl.getHeight()), Integer.valueOf(this.WNo) });
      }
      for (;;)
      {
        paramk = (CheckBox)paramk.findViewById(R.h.dwZ);
        if (paramk != null) {
          break;
        }
        Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine, checkBox is null??");
        paramk = Boolean.FALSE;
        paramk = new Pair(paramk, paramk);
        AppMethodBeat.o(259826);
        return paramk;
        arrayOfInt = new int[2];
        this.WNl.getLocationOnScreen(arrayOfInt);
        Log.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine2(%s, %s)", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.WNl.getHeight()) });
      }
      int[] arrayOfInt = new int[2];
      paramk.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1] + this.WNq - this.WNo;
      Log.d("MicroMsg.recordSelect.RecordSelectComponent", "view(%s, %s) recordSelectTipsBar(%s) viewTopHeight:%s marginTop:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.WNq), Integer.valueOf(this.WNo), Integer.valueOf(this.WNp), Integer.valueOf(i) });
      if (i > this.WNp)
      {
        paramk = Boolean.TRUE;
        paramk = new Pair(paramk, paramk);
        AppMethodBeat.o(259826);
        return paramk;
      }
      paramk = new Pair(Boolean.TRUE, Boolean.FALSE);
      AppMethodBeat.o(259826);
      return paramk;
    }
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine view is null, msgId:%s", new Object[] { Long.valueOf(paramLong) });
    paramk = Boolean.FALSE;
    paramk = new Pair(paramk, paramk);
    AppMethodBeat.o(259826);
    return paramk;
  }
  
  private void a(k paramk, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(259823);
    Pair localPair = a(paramk, paramLong);
    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle msgId:%s result:%s %s", new Object[] { Long.valueOf(paramLong), localPair.first, localPair.second });
    if (((Boolean)localPair.first).booleanValue())
    {
      if (((Boolean)localPair.second).booleanValue())
      {
        if ((!paramk.hND().contains(Long.valueOf(paramLong))) && (!this.WNy.contains(Long.valueOf(paramLong))))
        {
          if (paramk.hND().size() >= 99)
          {
            Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle max select msg num.");
            AppMethodBeat.o(259823);
            return;
          }
          paramk.VC(paramLong);
          if (!paramBoolean)
          {
            if (!this.WNu) {
              this.WNl.aek(a(paramk));
            }
            Gn(true);
            AppMethodBeat.o(259823);
          }
        }
      }
      else if (paramk.hND().contains(Long.valueOf(paramLong)))
      {
        paramk.VC(paramLong);
        if (!paramBoolean)
        {
          if (!this.WNu) {
            this.WNl.aek(a(paramk));
          }
          Gn(false);
          AppMethodBeat.o(259823);
        }
      }
    }
    else {
      Log.w("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle invalid");
    }
    AppMethodBeat.o(259823);
  }
  
  public final void H(Bundle paramBundle)
  {
    AppMethodBeat.i(259817);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.toString();; paramBundle = "null")
    {
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "doOnlySelectRecordMsg %s", new Object[] { paramBundle });
      this.WNn = false;
      this.fgR.WQv.hMr();
      AppMethodBeat.o(259817);
      return;
    }
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(259810);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "failDoJob %s", new Object[] { parama });
    AppMethodBeat.o(259810);
  }
  
  public final void b(z.a parama)
  {
    AppMethodBeat.i(259811);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "doInBackground %s", new Object[] { parama });
    AppMethodBeat.o(259811);
  }
  
  public final boolean bbA()
  {
    return false;
  }
  
  public final boolean bbB()
  {
    return true;
  }
  
  public final boolean bbC()
  {
    return false;
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(259813);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "requestExitSelectedMode %s", new Object[] { parama });
    AppMethodBeat.o(259813);
  }
  
  public final void fFF()
  {
    AppMethodBeat.i(259807);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "click cleanAllSelect");
    k localk = (k)this.fgR.bC(k.class);
    Iterator localIterator = localk.hND().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localk.VC(localLong.longValue());
      this.WNy.add(localLong);
    }
    localk.hNE();
    this.WNl.aek(a(localk));
    AppMethodBeat.o(259807);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(259787);
    this.WNm = this.fgR.WQv.getBooleanExtra("key_record_msg_select", false).booleanValue();
    this.WNu = this.fgR.WQv.getBooleanExtra("key_record_msg_select_introduce", true).booleanValue();
    this.WNr = this.fgR.WQv.getLongExtra("key_record_select_min_msg_id", -1L);
    this.WNs = this.fgR.WQv.getIntExtra("key_record_select_msg_num", 0);
    Object localObject = this.fgR.WQv.getStringArrayList("key_record_select_msg_black_list");
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.WNy.add(Long.valueOf(Util.getLong(str, 0L)));
      }
    }
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "isRecordSelect:%s showIntroduceView:%s lastSelectMinMsgId:%s lastSelectMsgNum:%s cancelSelectMsgSet:%s", new Object[] { Boolean.valueOf(this.WNm), Boolean.valueOf(this.WNu), Long.valueOf(this.WNr), Integer.valueOf(this.WNs), Integer.valueOf(this.WNy.size()) });
    AppMethodBeat.o(259787);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(259789);
    if (this.WNm)
    {
      if (this.WNl == null)
      {
        m.a(this.fgR.WQv, R.h.dZr);
        this.WNl = ((RecordSelectTipsBar)this.fgR.findViewById(R.h.dSB));
        this.WNl.setIRecordSelectCallback(this);
      }
      k localk = (k)this.fgR.bC(k.class);
      localk.k(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276544);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if ((!at.f(at.this)) && (!at.this.hQl())) {
            com.tencent.mm.plugin.selectrecord.b.a.fFx().PZ(at.this.hQp());
          }
          at.g(at.this);
          at.h(at.this);
          localObject = (k)at.this.fgR.bC(k.class);
          long l = ((Long)paramAnonymousView.getTag()).longValue();
          if (((k)localObject).hND().contains(Long.valueOf(l)))
          {
            at.i(at.this).add(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.fFx();
            paramAnonymousView.JcB += 1;
          }
          for (;;)
          {
            if (!((k)localObject).VC(l))
            {
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.fFx();
              paramAnonymousView.Jcv += 1;
            }
            Log.d("MicroMsg.recordSelect.RecordSelectComponent", "setOnEditModeItemClickListener msgId:%s", new Object[] { Long.valueOf(l) });
            at.a(at.this).aek(at.a((k)localObject));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(276544);
            return;
            at.i(at.this).remove(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.fFx();
            paramAnonymousView.JcA += 1;
          }
        }
      });
      localk.hNF();
      localk.hNG();
      localk.hNE();
      if (hQl()) {
        ((k)this.fgR.bC(k.class)).a(this.WNr, true, d.a.WYu);
      }
    }
    AppMethodBeat.o(259789);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(259792);
    if (this.WNm)
    {
      d.cua().cud();
      this.WNl.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278902);
          at.this.fgR.WQx.avo(at.a(at.this).getHeight());
          AppMethodBeat.o(278902);
        }
      });
    }
    AppMethodBeat.o(259792);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(259795);
    super.hNZ();
    if (this.WNm)
    {
      this.fgR.getListView().setOnScrollListener(null);
      this.WNn = true;
      this.WNm = false;
      this.WNv = false;
      this.WNw = false;
    }
    AppMethodBeat.o(259795);
  }
  
  public final boolean hQk()
  {
    return this.WNm;
  }
  
  public final boolean hQl()
  {
    return (this.WNr != -1L) && (this.WNs != 0);
  }
  
  public final boolean hQm()
  {
    AppMethodBeat.i(259806);
    if (this.WNm)
    {
      int i6 = hQp();
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish num:%s", new Object[] { Integer.valueOf(i6) });
      if (i6 == 0) {
        H(null);
      }
      for (;;)
      {
        if ((!this.WNw) && (!hQl())) {
          com.tencent.mm.plugin.selectrecord.b.a.fFx().PZ(i6);
        }
        AppMethodBeat.o(259806);
        return true;
        Object localObject2 = ((k)this.fgR.bC(k.class)).hND();
        Object localObject3;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mm.model.z.bcZ();
          localObject2 = ((Set)localObject2).iterator();
          long l = 0L;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = VK(((Long)((Iterator)localObject2).next()).longValue());
            if (localObject3 == null) {
              i = 0;
            }
            for (;;)
            {
              l = i + l;
              break;
              if (WNA.containsKey(Long.valueOf(((et)localObject3).field_msgId)))
              {
                i = ((Integer)WNA.get(Long.valueOf(((et)localObject3).field_msgId))).intValue();
              }
              else
              {
                i = com.tencent.mm.pluginsdk.model.app.m.apL(((ca)localObject3).getType());
                if (!com.tencent.mm.plugin.backup.f.h.EJ(i))
                {
                  Log.e("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { ((et)localObject3).field_talker, Integer.valueOf(((ca)localObject3).getType()) });
                  WNA.put(Long.valueOf(((et)localObject3).field_msgId), Integer.valueOf(0));
                  i = 0;
                }
                else
                {
                  ih localih = new ih();
                  localih.HlH = ((et)localObject3).field_msgSvrId;
                  if (((et)localObject3).field_isSend == 1)
                  {
                    localih.RID = new eaf().btQ((String)localObject1);
                    localih.RIE = new eaf().btQ(((et)localObject3).field_talker);
                  }
                  Object localObject4;
                  for (localih.RNH = 2;; localih.RNH = 4)
                  {
                    localih.RNM = new eae();
                    localih.RNN = 0;
                    localih.RNO = 0;
                    localih.RII = "";
                    localih.rWu = i;
                    localih.RNI = ((int)(((et)localObject3).field_createTime / 1000L));
                    localih.RNQ = ((et)localObject3).field_createTime;
                    localih.RNP = ((int)((et)localObject3).field_msgSeq);
                    localih.RNR = ((et)localObject3).field_flag;
                    localObject4 = new eaf();
                    ((eaf)localObject4).btQ(Util.nullAs(((et)localObject3).field_content, ""));
                    localih.RIF = ((eaf)localObject4);
                    localObject4 = c.cti().EI(com.tencent.mm.pluginsdk.model.app.m.apL(((ca)localObject3).getType()));
                    if (localObject4 != null) {
                      break label581;
                    }
                    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(((ca)localObject3).getType()) });
                    WNA.put(Long.valueOf(((et)localObject3).field_msgId), Integer.valueOf(0));
                    i = 0;
                    break;
                    localih.RID = new eaf().btQ(((et)localObject3).field_talker);
                    localih.RIE = new eaf().btQ((String)localObject1);
                  }
                  label581:
                  i = ((com.tencent.mm.plugin.backup.f.l)localObject4).a(localih, true, (ca)localObject3, (String)localObject1, null, null, false, 0L);
                  WNA.put(Long.valueOf(((et)localObject3).field_msgId), Integer.valueOf(i));
                }
              }
            }
          }
          localObject1 = com.tencent.mm.plugin.selectrecord.b.a.fFx();
          if (((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Jcu.gNe > 0L)
          {
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).JcI += ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Jcu.gNe;
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).JcJ += 1L;
          }
          ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Jcu.gNe = l;
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWx, 524288000);
          Log.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
          if (l >= i)
          {
            localObject1 = com.tencent.mm.plugin.selectrecord.b.a.fFx();
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Jcw += 1;
            com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getContext().getString(R.l.select_record_msg_file_exceed_max_size), "", this.fgR.WQv.getContext().getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(251145);
                Log.i("MicroMsg.recordSelect.RecordSelectComponent", "exceed max size, click i know");
                AppMethodBeat.o(251145);
              }
            });
          }
        }
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish exceed max storage size!!!");
          AppMethodBeat.o(259806);
          return true;
        }
        localObject2 = ((com.tencent.mm.ui.chatting.d.b.l)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.l.class)).hOQ();
        com.tencent.mm.ui.chatting.l.a(this.fgR.WQv.getContext(), (List)localObject2, true, this.fgR.NKq.field_username, this);
        Object localObject1 = com.tencent.mm.plugin.selectrecord.b.a.fFx();
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
          localObject3 = (ca)((Iterator)localObject2).next();
          switch (((ca)localObject3).getType())
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
            localObject3 = k.b.OQ(((et)localObject3).field_content);
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
        localObject1 = ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Jcu;
        ((kk)localObject1).gHN = ((kk)localObject1).z("FinalShareCountByType", (String)localObject2, true);
      }
    }
    AppMethodBeat.o(259806);
    return false;
  }
  
  public final boolean hQn()
  {
    return this.WNn;
  }
  
  public final CopyOnWriteArraySet<Long> hQo()
  {
    return this.WNy;
  }
  
  public final int hQp()
  {
    AppMethodBeat.i(259821);
    int i = a((k)this.fgR.bC(k.class));
    AppMethodBeat.o(259821);
    return i;
  }
  
  public final void hQq()
  {
    AppMethodBeat.i(259822);
    if ((!this.WNw) && (!hQl())) {
      com.tencent.mm.plugin.selectrecord.b.a.fFx().PZ(hQp());
    }
    AppMethodBeat.o(259822);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(259801);
    if (!this.WNm)
    {
      AppMethodBeat.o(259801);
      return;
    }
    if (paramInt2 == 0)
    {
      Log.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(259801);
      return;
    }
    paramAbsListView = (k)this.fgR.bC(k.class);
    final a locala = new a();
    int i = this.fgR.hMq();
    Object localObject1 = paramAbsListView.avt(paramInt1 - i);
    if (localObject1 != null) {
      locala.WNE = ((et)localObject1).field_msgId;
    }
    localObject1 = ((k)this.fgR.bC(k.class)).avt(paramInt1 + 1 - i);
    if (localObject1 != null) {
      locala.WNF = ((et)localObject1).field_msgId;
    }
    boolean bool1;
    long l1;
    label183:
    Object localObject2;
    label309:
    Object localObject3;
    if (this.WNt == null)
    {
      bool1 = true;
      boolean bool2 = this.WNu;
      long l2 = locala.WNE;
      long l3 = locala.WNF;
      if (this.WNt == null) {
        break label768;
      }
      l1 = this.WNt.WNE;
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll, first:%s showIntroduceView:%s firstVisibleItem:%s headerCount:%s visibleItemCount:%s totalItemCount:%s firstVisibleMsgId:%s secondVisibleMsgId:%s lastFirstVisibleMsgId:%s ifSlide:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(this.WNv) });
      localObject1 = paramAbsListView.hND();
      localObject2 = paramAbsListView.hNB();
      if (!bool1) {
        break label790;
      }
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 < 0) {
        break label1429;
      }
      localObject3 = (ca)((SparseArray)localObject2).get(paramInt1);
      if ((localObject3 != null) && (((et)localObject3).field_msgId >= locala.WNE) && (paramAbsListView.cn((ca)localObject3)) && (!this.WNy.contains(Long.valueOf(((et)localObject3).field_msgId))))
      {
        if (((locala.WNF == -1L) || (((et)localObject3).field_msgId <= locala.WNF)) && ((locala.WNF != -1L) || (((et)localObject3).field_msgId <= locala.WNE))) {
          break label776;
        }
        paramAbsListView.VC(((et)localObject3).field_msgId);
      }
    }
    for (;;)
    {
      paramInt1 -= 1;
      break label309;
      if (this.nnu == null)
      {
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll totalItemCount:%s headerViewsCount:%s footerViewCount:%s totalCount:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(this.fgR.hMq()), Integer.valueOf(this.fgR.cqm()), Integer.valueOf(paramAbsListView.dpe()) });
        if ((this.WNu) && (paramInt3 - this.fgR.hMq() - this.fgR.cqm() == paramAbsListView.dpe()))
        {
          localObject1 = paramAbsListView.avt(0);
          if (((et)localObject1).field_msgId != 0L)
          {
            localObject2 = a(paramAbsListView, ((et)localObject1).field_msgId);
            if ((!((Boolean)((Pair)localObject2).first).booleanValue()) || (!((Boolean)((Pair)localObject2).second).booleanValue())) {
              break label665;
            }
            this.WNu = false;
          }
        }
        label606:
        if (!this.WNu) {
          break label743;
        }
        localObject1 = this.WNl;
        com.tencent.e.h.ZvG.bc(new RecordSelectTipsBar.2((RecordSelectTipsBar)localObject1));
      }
      for (;;)
      {
        this.fgR.getListView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(290874);
            if (at.b(at.this) != null)
            {
              AppMethodBeat.o(290874);
              return;
            }
            at.a(at.this, at.this.fgR.getListView().findViewById(R.h.dLp));
            if (at.b(at.this) != null)
            {
              int i = at.this.fgR.getListView().getHeight() - com.tencent.mm.ci.a.aZ(at.this.fgR.WQv.getContext(), R.f.Edge_3A);
              int j = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDF, 0);
              if (((at.this.hQl()) && (i != j)) || (!at.this.hQl()))
              {
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)at.b(at.this).getLayoutParams();
                localLayoutParams.height = i;
                at.b(at.this).setLayoutParams(localLayoutParams);
                if (i != j) {
                  com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDF, Integer.valueOf(localLayoutParams.height));
                }
                Log.i("MicroMsg.recordSelect.RecordSelectComponent", "update footView height:%s", new Object[] { Integer.valueOf(localLayoutParams.height) });
              }
            }
            AppMethodBeat.o(290874);
          }
        }, 300L);
        bool1 = false;
        break;
        label665:
        localObject1 = paramAbsListView.Fl(((et)localObject1).field_msgId);
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = (CheckBox)((View)localObject1).findViewById(R.h.dwZ);
        if (localObject1 == null) {}
        for (bool1 = true;; bool1 = false)
        {
          Log.d("MicroMsg.recordSelect.RecordSelectComponent", "checkBox is null(%s)", new Object[] { Boolean.valueOf(bool1) });
          if (localObject1 != null) {
            break;
          }
          this.WNu = false;
          break;
        }
        label743:
        this.WNl.aek(a((k)this.fgR.bC(k.class)));
      }
      label768:
      l1 = -1L;
      break label183;
      label776:
      a(paramAbsListView, ((et)localObject3).field_msgId, true);
    }
    label790:
    if (locala.WNE < this.WNt.WNE)
    {
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 >= 0)
      {
        localObject3 = (ca)((SparseArray)localObject2).get(paramInt1);
        if ((localObject3 != null) && (((et)localObject3).field_msgId >= locala.WNE) && (paramAbsListView.cn((ca)localObject3)))
        {
          if (paramAbsListView.hND().size() < 99) {
            break label924;
          }
          Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll max select msg num.(2)");
          if (!((Set)localObject1).contains(Long.valueOf(((et)localObject3).field_msgId))) {
            this.WNy.add(Long.valueOf(((et)localObject3).field_msgId));
          }
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          label924:
          if (((locala.WNF != -1L) && (((et)localObject3).field_msgId > locala.WNF)) || ((locala.WNF == -1L) && (((et)localObject3).field_msgId > locala.WNE)))
          {
            if ((!((Set)localObject1).contains(Long.valueOf(((et)localObject3).field_msgId))) && (!this.WNy.contains(Long.valueOf(((et)localObject3).field_msgId))))
            {
              paramAbsListView.VC(((et)localObject3).field_msgId);
              if (!this.WNu) {
                this.WNl.aek(a(paramAbsListView));
              }
              Gn(true);
            }
          }
          else {
            a(paramAbsListView, ((et)localObject3).field_msgId, false);
          }
        }
      }
    }
    else
    {
      if (locala.WNE > this.WNt.WNE)
      {
        localObject2 = ((Set)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          if (paramAbsListView.cn(VK(((Long)localObject3).longValue()))) {
            if (((Long)localObject3).longValue() < locala.WNE)
            {
              paramAbsListView.VC(((Long)localObject3).longValue());
              Gn(false);
              if (!this.WNu) {
                this.WNl.aek(a(paramAbsListView));
              }
            }
            else if ((((Long)localObject3).longValue() == locala.WNE) || (((Long)localObject3).longValue() == locala.WNF))
            {
              a(paramAbsListView, ((Long)localObject3).longValue(), false);
            }
          }
        }
      }
      if ((!this.WNy.contains(Long.valueOf(locala.WNE))) && (paramAbsListView.cn(VK(locala.WNE))))
      {
        if ((paramAbsListView.hND().size() >= 99) && (!((Set)localObject1).contains(Long.valueOf(locala.WNE)))) {
          this.WNy.add(Long.valueOf(locala.WNE));
        }
        a(paramAbsListView, locala.WNE, false);
      }
      if ((!this.WNy.contains(Long.valueOf(locala.WNF))) && (locala.WNF != -1L) && (paramAbsListView.cn(VK(locala.WNF))))
      {
        if ((paramAbsListView.hND().size() >= 99) && (!((Set)localObject1).contains(Long.valueOf(locala.WNF)))) {
          this.WNy.add(Long.valueOf(locala.WNF));
        }
        a(paramAbsListView, locala.WNF, false);
      }
    }
    label1429:
    if (this.WNv)
    {
      localObject1 = this.WNy.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        if (locala.WNE > ((Long)localObject2).longValue())
        {
          this.WNy.remove(localObject2);
        }
        else if ((((Long)localObject2).longValue() == locala.WNE) || (((Long)localObject2).longValue() == locala.WNF))
        {
          localObject3 = a(paramAbsListView, ((Long)localObject2).longValue());
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
              this.WNy.remove(localObject2);
            }
          }
          else {
            Log.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll invalid");
          }
        }
      }
    }
    if (!this.WNx) {
      com.tencent.e.h.ZvG.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(285779);
          if ((at.c(at.this) != 0) && (this.WNC.size() + 1 == at.c(at.this)))
          {
            if (((locala.WNE == at.d(at.this)) || (locala.WNF == at.d(at.this))) && (!this.WNC.contains(Long.valueOf(at.d(at.this)))))
            {
              at.this.fgR.getListView().smoothScrollBy(-com.tencent.mm.ci.a.fromDPToPix(at.this.fgR.WQv.getContext(), 5), 0);
              Log.i("MicroMsg.recordSelect.RecordSelectComponent", "slide below");
            }
            at.e(at.this);
          }
          AppMethodBeat.o(285779);
        }
      }, 500L);
    }
    this.WNt = locala;
    AppMethodBeat.o(259801);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(259804);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (!this.WNm)
    {
      AppMethodBeat.o(259804);
      return;
    }
    if ((!this.WNw) && (!hQl())) {
      com.tencent.mm.plugin.selectrecord.b.a.fFx().PZ(hQp());
    }
    this.WNw = true;
    this.WNu = false;
    this.WNv = true;
    this.WNl.aek(a((k)this.fgR.bC(k.class)));
    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "onScrollStateChanged ifSlide:%s", new Object[] { Boolean.valueOf(this.WNv) });
    AppMethodBeat.o(259804);
  }
  
  public final void xM(boolean paramBoolean)
  {
    AppMethodBeat.i(259808);
    ((k)this.fgR.bC(k.class)).xM(paramBoolean);
    AppMethodBeat.o(259808);
  }
  
  static final class a
  {
    long WNE = -1L;
    long WNF = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.at
 * JD-Core Version:    0.7.0.1
 */