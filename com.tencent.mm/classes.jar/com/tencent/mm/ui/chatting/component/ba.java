package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.nd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.z.a;
import com.tencent.mm.plugin.backup.f.l;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.2;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.a;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.component.api.ap;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.f.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ap.class)
public class ba
  extends a
  implements com.tencent.mm.message.z, RecordSelectTipsBar.a, ap
{
  private static HashMap<Long, Integer> aewa;
  private RecordSelectTipsBar aevL;
  private boolean aevM;
  private boolean aevN;
  private int aevO;
  private int aevP;
  private int aevQ;
  private long aevR;
  private int aevS;
  private a aevT;
  private boolean aevU;
  private boolean aevV;
  private boolean aevW;
  private boolean aevX;
  private CopyOnWriteArraySet<Long> aevY;
  private HashMap<Long, cc> aevZ;
  private View qkB;
  
  static
  {
    AppMethodBeat.i(256421);
    aewa = new HashMap();
    AppMethodBeat.o(256421);
  }
  
  public ba()
  {
    AppMethodBeat.i(256383);
    this.aevM = false;
    this.aevN = true;
    this.aevO = -1;
    this.aevP = -1;
    this.aevQ = -1;
    this.aevR = -1L;
    this.aevS = 0;
    this.aevT = null;
    this.aevU = true;
    this.aevV = false;
    this.aevW = false;
    this.aevX = false;
    this.aevY = new CopyOnWriteArraySet();
    this.aevZ = new HashMap();
    AppMethodBeat.o(256383);
  }
  
  private void Ma(boolean paramBoolean)
  {
    AppMethodBeat.i(256391);
    if (this.aevV)
    {
      this.aevL.performHapticFeedback(0, 2);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.selectrecord.b.a.gUF().gUH();
        AppMethodBeat.o(256391);
        return;
      }
      com.tencent.mm.plugin.selectrecord.b.a.gUF().gUI();
    }
    AppMethodBeat.o(256391);
  }
  
  public static int a(m paramm)
  {
    AppMethodBeat.i(256386);
    paramm = paramm.jqk();
    if (paramm == null)
    {
      AppMethodBeat.o(256386);
      return 0;
    }
    int i = paramm.size();
    AppMethodBeat.o(256386);
    return i;
  }
  
  private Pair<Boolean, Boolean> a(m paramm, long paramLong)
  {
    AppMethodBeat.i(256400);
    if (paramm == null)
    {
      Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine adapterComponent is null");
      paramm = Boolean.FALSE;
      paramm = new Pair(paramm, paramm);
      AppMethodBeat.o(256400);
      return paramm;
    }
    if (this.aevL.getHeight() <= 0)
    {
      Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine recordSelectTipsBar height <= 0");
      paramm = Boolean.FALSE;
      paramm = new Pair(paramm, paramm);
      AppMethodBeat.o(256400);
      return paramm;
    }
    paramm = paramm.ht(paramLong);
    if (paramm != null)
    {
      if (this.aevO <= 0)
      {
        arrayOfInt = new int[2];
        this.aevL.getLocationOnScreen(arrayOfInt);
        this.aevO = (arrayOfInt[1] + this.aevL.getHeight());
        this.aevP = com.tencent.mm.cd.a.bs(this.hlc.aezO.getContext(), R.f.Edge_5A);
        this.aevQ = com.tencent.mm.cd.a.fromDPToPix(this.hlc.aezO.getContext(), 24);
        Log.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine(%s, %s) recordSelectTipsBarBottomLoctaion:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.aevL.getHeight()), Integer.valueOf(this.aevO) });
      }
      for (;;)
      {
        paramm = (CheckBox)paramm.findViewById(R.h.fxt);
        if (paramm != null) {
          break;
        }
        Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine, checkBox is null??");
        paramm = Boolean.FALSE;
        paramm = new Pair(paramm, paramm);
        AppMethodBeat.o(256400);
        return paramm;
        arrayOfInt = new int[2];
        this.aevL.getLocationOnScreen(arrayOfInt);
        Log.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine2(%s, %s)", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.aevL.getHeight()) });
      }
      int[] arrayOfInt = new int[2];
      paramm.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1] + this.aevQ - this.aevO;
      Log.d("MicroMsg.recordSelect.RecordSelectComponent", "view(%s, %s) recordSelectTipsBar(%s) viewTopHeight:%s marginTop:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.aevQ), Integer.valueOf(this.aevO), Integer.valueOf(this.aevP), Integer.valueOf(i) });
      if (i > this.aevP)
      {
        paramm = Boolean.TRUE;
        paramm = new Pair(paramm, paramm);
        AppMethodBeat.o(256400);
        return paramm;
      }
      paramm = new Pair(Boolean.TRUE, Boolean.FALSE);
      AppMethodBeat.o(256400);
      return paramm;
    }
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine view is null, msgId:%s", new Object[] { Long.valueOf(paramLong) });
    paramm = Boolean.FALSE;
    paramm = new Pair(paramm, paramm);
    AppMethodBeat.o(256400);
    return paramm;
  }
  
  private void a(m paramm, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(256389);
    Pair localPair = a(paramm, paramLong);
    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle msgId:%s result:%s %s", new Object[] { Long.valueOf(paramLong), localPair.first, localPair.second });
    if (((Boolean)localPair.first).booleanValue())
    {
      if (((Boolean)localPair.second).booleanValue())
      {
        if ((!paramm.jqk().contains(Long.valueOf(paramLong))) && (!this.aevY.contains(Long.valueOf(paramLong))))
        {
          if (paramm.jqk().size() >= 99)
          {
            Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle max select msg num.");
            AppMethodBeat.o(256389);
            return;
          }
          paramm.zK(paramLong);
          if (!paramBoolean)
          {
            if (!this.aevU) {
              this.aevL.aiP(a(paramm));
            }
            Ma(true);
            AppMethodBeat.o(256389);
          }
        }
      }
      else if (paramm.jqk().contains(Long.valueOf(paramLong)))
      {
        paramm.zK(paramLong);
        if (!paramBoolean)
        {
          if (!this.aevU) {
            this.aevL.aiP(a(paramm));
          }
          Ma(false);
          AppMethodBeat.o(256389);
        }
      }
    }
    else {
      Log.w("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle invalid");
    }
    AppMethodBeat.o(256389);
  }
  
  private cc zS(long paramLong)
  {
    AppMethodBeat.i(256394);
    if (this.aevZ.containsKey(Long.valueOf(paramLong)))
    {
      localcc = (cc)this.aevZ.get(Long.valueOf(paramLong));
      AppMethodBeat.o(256394);
      return localcc;
    }
    cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramLong);
    this.aevZ.put(Long.valueOf(paramLong), localcc);
    AppMethodBeat.o(256394);
    return localcc;
  }
  
  public final void CD(boolean paramBoolean)
  {
    AppMethodBeat.i(256492);
    ((m)this.hlc.cm(m.class)).CD(paramBoolean);
    AppMethodBeat.o(256492);
  }
  
  public final void O(Bundle paramBundle)
  {
    AppMethodBeat.i(256513);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.toString();; paramBundle = "null")
    {
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "doOnlySelectRecordMsg %s", new Object[] { paramBundle });
      this.aevN = false;
      this.hlc.aezO.joU();
      AppMethodBeat.o(256513);
      return;
    }
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(256497);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "failDoJob %s", new Object[] { parama });
    AppMethodBeat.o(256497);
  }
  
  public final void b(z.a parama)
  {
    AppMethodBeat.i(256500);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "doInBackground %s", new Object[] { parama });
    AppMethodBeat.o(256500);
  }
  
  public final boolean bws()
  {
    return false;
  }
  
  public final boolean bwt()
  {
    return true;
  }
  
  public final boolean bwu()
  {
    return false;
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(256504);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "requestExitSelectedMode %s", new Object[] { parama });
    AppMethodBeat.o(256504);
  }
  
  public final void gUN()
  {
    AppMethodBeat.i(256490);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "click cleanAllSelect");
    m localm = (m)this.hlc.cm(m.class);
    Iterator localIterator = localm.jqk().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localm.zK(localLong.longValue());
      this.aevY.add(localLong);
    }
    localm.jql();
    this.aevL.aiP(a(localm));
    AppMethodBeat.o(256490);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(256424);
    this.aevM = this.hlc.aezO.getBooleanExtra("key_record_msg_select", false).booleanValue();
    this.aevU = this.hlc.aezO.getBooleanExtra("key_record_msg_select_introduce", true).booleanValue();
    this.aevR = this.hlc.aezO.getLongExtra("key_record_select_min_msg_id", -1L);
    this.aevS = this.hlc.aezO.getIntExtra("key_record_select_msg_num", 0);
    Object localObject = this.hlc.aezO.getStringArrayList("key_record_select_msg_black_list");
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.aevY.add(Long.valueOf(Util.getLong(str, 0L)));
      }
    }
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "isRecordSelect:%s showIntroduceView:%s lastSelectMinMsgId:%s lastSelectMsgNum:%s cancelSelectMsgSet:%s", new Object[] { Boolean.valueOf(this.aevM), Boolean.valueOf(this.aevU), Long.valueOf(this.aevR), Integer.valueOf(this.aevS), Integer.valueOf(this.aevY.size()) });
    AppMethodBeat.o(256424);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(256427);
    if (this.aevM)
    {
      if (this.aevL == null)
      {
        n.c(this.hlc.aezO, R.h.gcl);
        this.aevL = ((RecordSelectTipsBar)this.hlc.findViewById(R.h.fUD));
        this.aevL.setIRecordSelectCallback(this);
      }
      m localm = (m)this.hlc.cm(m.class);
      localm.m(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(256280);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          if ((!ba.f(ba.this)) && (!ba.this.jtn())) {
            com.tencent.mm.plugin.selectrecord.b.a.gUF().ud(ba.this.jtr());
          }
          ba.g(ba.this);
          ba.h(ba.this);
          localObject = (m)ba.this.hlc.cm(m.class);
          long l = ((Long)paramAnonymousView.getTag()).longValue();
          if (((m)localObject).jqk().contains(Long.valueOf(l)))
          {
            ba.i(ba.this).add(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.gUF();
            paramAnonymousView.Pmq += 1;
          }
          for (;;)
          {
            if (!((m)localObject).zK(l))
            {
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.gUF();
              paramAnonymousView.Pmk += 1;
            }
            Log.d("MicroMsg.recordSelect.RecordSelectComponent", "setOnEditModeItemClickListener msgId:%s", new Object[] { Long.valueOf(l) });
            ba.a(ba.this).aiP(ba.a((m)localObject));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256280);
            return;
            ba.i(ba.this).remove(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.gUF();
            paramAnonymousView.Pmp += 1;
          }
        }
      });
      localm.jqm();
      localm.jqn();
      localm.jql();
      if (jtn()) {
        ((m)this.hlc.cm(m.class)).a(this.aevR, true, false, false, 0, false, d.a.aeHU);
      }
    }
    AppMethodBeat.o(256427);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(256429);
    if (this.aevM)
    {
      d.cWK().cWN();
      this.aevL.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256283);
          ba.this.hlc.aezQ.aBP(ba.a(ba.this).getHeight());
          AppMethodBeat.o(256283);
        }
      });
    }
    AppMethodBeat.o(256429);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(256431);
    super.jqF();
    if (this.aevM)
    {
      this.hlc.getListView().setOnScrollListener(null);
      this.aevN = true;
      this.aevM = false;
      this.aevV = false;
      this.aevW = false;
    }
    AppMethodBeat.o(256431);
  }
  
  public final boolean jtm()
  {
    return this.aevM;
  }
  
  public final boolean jtn()
  {
    return (this.aevR != -1L) && (this.aevS != 0);
  }
  
  public final boolean jto()
  {
    AppMethodBeat.i(256481);
    if (this.aevM)
    {
      int i6 = jtr();
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish num:%s", new Object[] { Integer.valueOf(i6) });
      if (i6 == 0) {
        O(null);
      }
      for (;;)
      {
        if ((!this.aevW) && (!jtn())) {
          com.tencent.mm.plugin.selectrecord.b.a.gUF().ud(i6);
        }
        AppMethodBeat.o(256481);
        return true;
        Object localObject2 = ((m)this.hlc.cm(m.class)).jqk();
        Object localObject3;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mm.model.z.bAM();
          localObject2 = ((Set)localObject2).iterator();
          long l = 0L;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = zS(((Long)((Iterator)localObject2).next()).longValue());
            if (localObject3 == null) {
              i = 0;
            }
            for (;;)
            {
              l = i + l;
              break;
              if (aewa.containsKey(Long.valueOf(((fi)localObject3).field_msgId)))
              {
                i = ((Integer)aewa.get(Long.valueOf(((fi)localObject3).field_msgId))).intValue();
              }
              else
              {
                i = com.tencent.mm.pluginsdk.model.app.n.va(((cc)localObject3).getType());
                if (!com.tencent.mm.plugin.backup.f.h.Fk(i))
                {
                  Log.e("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { ((fi)localObject3).field_talker, Integer.valueOf(((cc)localObject3).getType()) });
                  aewa.put(Long.valueOf(((fi)localObject3).field_msgId), Integer.valueOf(0));
                  i = 0;
                }
                else
                {
                  jd localjd = new jd();
                  localjd.Njv = ((fi)localObject3).field_msgSvrId;
                  if (((fi)localObject3).field_isSend == 1)
                  {
                    localjd.YFE = new etl().btH((String)localObject1);
                    localjd.YFF = new etl().btH(((fi)localObject3).field_talker);
                  }
                  Object localObject4;
                  for (localjd.YKV = 2;; localjd.YKV = 4)
                  {
                    localjd.YLa = new gol();
                    localjd.YLb = 0;
                    localjd.YLc = 0;
                    localjd.YFJ = "";
                    localjd.vhJ = i;
                    localjd.YKW = ((int)(((cc)localObject3).getCreateTime() / 1000L));
                    localjd.YLe = ((cc)localObject3).getCreateTime();
                    localjd.YLd = ((int)((fi)localObject3).field_msgSeq);
                    localjd.YLf = ((fi)localObject3).field_flag;
                    localObject4 = new etl();
                    ((etl)localObject4).btH(Util.nullAs(((fi)localObject3).field_content, ""));
                    localjd.YFG = ((etl)localObject4);
                    localObject4 = com.tencent.mm.plugin.backup.f.c.cVS().Fj(com.tencent.mm.pluginsdk.model.app.n.va(((cc)localObject3).getType()));
                    if (localObject4 != null) {
                      break label581;
                    }
                    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(((cc)localObject3).getType()) });
                    aewa.put(Long.valueOf(((fi)localObject3).field_msgId), Integer.valueOf(0));
                    i = 0;
                    break;
                    localjd.YFE = new etl().btH(((fi)localObject3).field_talker);
                    localjd.YFF = new etl().btH((String)localObject1);
                  }
                  label581:
                  i = ((l)localObject4).a(localjd, true, (cc)localObject3, (String)localObject1, null, null, false, 0L);
                  aewa.put(Long.valueOf(((fi)localObject3).field_msgId), Integer.valueOf(i));
                }
              }
            }
          }
          localObject1 = com.tencent.mm.plugin.selectrecord.b.a.gUF();
          if (((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Pmj.jdm > 0L)
          {
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Pmx += ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Pmj.jdm;
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Pmy += 1L;
          }
          ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Pmj.jdm = l;
          i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpc, 524288000);
          Log.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
          if (l >= i)
          {
            localObject1 = com.tencent.mm.plugin.selectrecord.b.a.gUF();
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Pml += 1;
            k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getContext().getString(R.l.select_record_msg_file_exceed_max_size), "", this.hlc.aezO.getContext().getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(256276);
                Log.i("MicroMsg.recordSelect.RecordSelectComponent", "exceed max size, click i know");
                AppMethodBeat.o(256276);
              }
            });
          }
        }
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish exceed max storage size!!!");
          AppMethodBeat.o(256481);
          return true;
        }
        localObject2 = ((com.tencent.mm.ui.chatting.component.api.n)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class)).jrG();
        com.tencent.mm.ui.chatting.n.a(this.hlc.aezO.getContext(), (List)localObject2, true, this.hlc.Uxa.field_username, this);
        Object localObject1 = com.tencent.mm.plugin.selectrecord.b.a.gUF();
        if ((localObject2 != null) || (((List)localObject2).size() != 0))
        {
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
            localObject3 = (cc)((Iterator)localObject2).next();
            switch (((cc)localObject3).getType())
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
              localObject3 = k.b.Hf(((fi)localObject3).field_content);
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
          localObject1 = ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).Pmj;
          ((nd)localObject1).iWf = ((nd)localObject1).F("FinalShareCountByType", (String)localObject2, true);
        }
      }
    }
    AppMethodBeat.o(256481);
    return false;
  }
  
  public final boolean jtp()
  {
    return this.aevN;
  }
  
  public final CopyOnWriteArraySet<Long> jtq()
  {
    return this.aevY;
  }
  
  public final int jtr()
  {
    AppMethodBeat.i(256522);
    int i = a((m)this.hlc.cm(m.class));
    AppMethodBeat.o(256522);
    return i;
  }
  
  public final void jts()
  {
    AppMethodBeat.i(256527);
    if ((!this.aevW) && (!jtn())) {
      com.tencent.mm.plugin.selectrecord.b.a.gUF().ud(jtr());
    }
    AppMethodBeat.o(256527);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(256450);
    if (!this.aevM)
    {
      AppMethodBeat.o(256450);
      return;
    }
    if (paramInt2 == 0)
    {
      Log.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(256450);
      return;
    }
    paramAbsListView = (m)this.hlc.cm(m.class);
    final a locala = new a();
    int i = this.hlc.joT();
    Object localObject1 = paramAbsListView.aBV(paramInt1 - i);
    if (localObject1 != null) {
      locala.aewe = ((fi)localObject1).field_msgId;
    }
    localObject1 = ((m)this.hlc.cm(m.class)).aBV(paramInt1 + 1 - i);
    if (localObject1 != null) {
      locala.aewf = ((fi)localObject1).field_msgId;
    }
    boolean bool1;
    long l1;
    label183:
    Object localObject2;
    label309:
    Object localObject3;
    if (this.aevT == null)
    {
      bool1 = true;
      boolean bool2 = this.aevU;
      long l2 = locala.aewe;
      long l3 = locala.aewf;
      if (this.aevT == null) {
        break label768;
      }
      l1 = this.aevT.aewe;
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll, first:%s showIntroduceView:%s firstVisibleItem:%s headerCount:%s visibleItemCount:%s totalItemCount:%s firstVisibleMsgId:%s secondVisibleMsgId:%s lastFirstVisibleMsgId:%s ifSlide:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(this.aevV) });
      localObject1 = paramAbsListView.jqk();
      localObject2 = paramAbsListView.jqi();
      if (!bool1) {
        break label790;
      }
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 < 0) {
        break label1429;
      }
      localObject3 = (cc)((SparseArray)localObject2).get(paramInt1);
      if ((localObject3 != null) && (((fi)localObject3).field_msgId >= locala.aewe) && (paramAbsListView.cB((cc)localObject3)) && (!this.aevY.contains(Long.valueOf(((fi)localObject3).field_msgId))))
      {
        if (((locala.aewf == -1L) || (((fi)localObject3).field_msgId <= locala.aewf)) && ((locala.aewf != -1L) || (((fi)localObject3).field_msgId <= locala.aewe))) {
          break label776;
        }
        paramAbsListView.zK(((fi)localObject3).field_msgId);
      }
    }
    for (;;)
    {
      paramInt1 -= 1;
      break label309;
      if (this.qkB == null)
      {
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll totalItemCount:%s headerViewsCount:%s footerViewCount:%s totalCount:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(this.hlc.joT()), Integer.valueOf(this.hlc.cST()), Integer.valueOf(paramAbsListView.dWF()) });
        if ((this.aevU) && (paramInt3 - this.hlc.joT() - this.hlc.cST() == paramAbsListView.dWF()))
        {
          localObject1 = paramAbsListView.aBV(0);
          if (((fi)localObject1).field_msgId != 0L)
          {
            localObject2 = a(paramAbsListView, ((fi)localObject1).field_msgId);
            if ((!((Boolean)((Pair)localObject2).first).booleanValue()) || (!((Boolean)((Pair)localObject2).second).booleanValue())) {
              break label665;
            }
            this.aevU = false;
          }
        }
        label606:
        if (!this.aevU) {
          break label743;
        }
        localObject1 = this.aevL;
        com.tencent.threadpool.h.ahAA.bk(new RecordSelectTipsBar.2((RecordSelectTipsBar)localObject1));
      }
      for (;;)
      {
        this.hlc.getListView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(256282);
            if (ba.b(ba.this) != null)
            {
              AppMethodBeat.o(256282);
              return;
            }
            ba.a(ba.this, ba.this.hlc.getListView().findViewById(R.h.fMV));
            if (ba.b(ba.this) != null)
            {
              int i = ba.this.hlc.getListView().getHeight() - com.tencent.mm.cd.a.bs(ba.this.hlc.aezO.getContext(), R.f.Edge_3A);
              int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adgC, 0);
              if (((ba.this.jtn()) && (i != j)) || (!ba.this.jtn()))
              {
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)ba.b(ba.this).getLayoutParams();
                localLayoutParams.height = i;
                ba.b(ba.this).setLayoutParams(localLayoutParams);
                if (i != j) {
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.adgC, Integer.valueOf(localLayoutParams.height));
                }
                Log.i("MicroMsg.recordSelect.RecordSelectComponent", "update footView height:%s", new Object[] { Integer.valueOf(localLayoutParams.height) });
              }
            }
            AppMethodBeat.o(256282);
          }
        }, 300L);
        bool1 = false;
        break;
        label665:
        localObject1 = paramAbsListView.ht(((fi)localObject1).field_msgId);
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = (CheckBox)((View)localObject1).findViewById(R.h.fxt);
        if (localObject1 == null) {}
        for (bool1 = true;; bool1 = false)
        {
          Log.d("MicroMsg.recordSelect.RecordSelectComponent", "checkBox is null(%s)", new Object[] { Boolean.valueOf(bool1) });
          if (localObject1 != null) {
            break;
          }
          this.aevU = false;
          break;
        }
        label743:
        this.aevL.aiP(a((m)this.hlc.cm(m.class)));
      }
      label768:
      l1 = -1L;
      break label183;
      label776:
      a(paramAbsListView, ((fi)localObject3).field_msgId, true);
    }
    label790:
    if (locala.aewe < this.aevT.aewe)
    {
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 >= 0)
      {
        localObject3 = (cc)((SparseArray)localObject2).get(paramInt1);
        if ((localObject3 != null) && (((fi)localObject3).field_msgId >= locala.aewe) && (paramAbsListView.cB((cc)localObject3)))
        {
          if (paramAbsListView.jqk().size() < 99) {
            break label924;
          }
          Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll max select msg num.(2)");
          if (!((Set)localObject1).contains(Long.valueOf(((fi)localObject3).field_msgId))) {
            this.aevY.add(Long.valueOf(((fi)localObject3).field_msgId));
          }
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          label924:
          if (((locala.aewf != -1L) && (((fi)localObject3).field_msgId > locala.aewf)) || ((locala.aewf == -1L) && (((fi)localObject3).field_msgId > locala.aewe)))
          {
            if ((!((Set)localObject1).contains(Long.valueOf(((fi)localObject3).field_msgId))) && (!this.aevY.contains(Long.valueOf(((fi)localObject3).field_msgId))))
            {
              paramAbsListView.zK(((fi)localObject3).field_msgId);
              if (!this.aevU) {
                this.aevL.aiP(a(paramAbsListView));
              }
              Ma(true);
            }
          }
          else {
            a(paramAbsListView, ((fi)localObject3).field_msgId, false);
          }
        }
      }
    }
    else
    {
      if (locala.aewe > this.aevT.aewe)
      {
        localObject2 = ((Set)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          if (paramAbsListView.cB(zS(((Long)localObject3).longValue()))) {
            if (((Long)localObject3).longValue() < locala.aewe)
            {
              paramAbsListView.zK(((Long)localObject3).longValue());
              Ma(false);
              if (!this.aevU) {
                this.aevL.aiP(a(paramAbsListView));
              }
            }
            else if ((((Long)localObject3).longValue() == locala.aewe) || (((Long)localObject3).longValue() == locala.aewf))
            {
              a(paramAbsListView, ((Long)localObject3).longValue(), false);
            }
          }
        }
      }
      if ((!this.aevY.contains(Long.valueOf(locala.aewe))) && (paramAbsListView.cB(zS(locala.aewe))))
      {
        if ((paramAbsListView.jqk().size() >= 99) && (!((Set)localObject1).contains(Long.valueOf(locala.aewe)))) {
          this.aevY.add(Long.valueOf(locala.aewe));
        }
        a(paramAbsListView, locala.aewe, false);
      }
      if ((!this.aevY.contains(Long.valueOf(locala.aewf))) && (locala.aewf != -1L) && (paramAbsListView.cB(zS(locala.aewf))))
      {
        if ((paramAbsListView.jqk().size() >= 99) && (!((Set)localObject1).contains(Long.valueOf(locala.aewf)))) {
          this.aevY.add(Long.valueOf(locala.aewf));
        }
        a(paramAbsListView, locala.aewf, false);
      }
    }
    label1429:
    if (this.aevV)
    {
      localObject1 = this.aevY.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        if (locala.aewe > ((Long)localObject2).longValue())
        {
          this.aevY.remove(localObject2);
        }
        else if ((((Long)localObject2).longValue() == locala.aewe) || (((Long)localObject2).longValue() == locala.aewf))
        {
          localObject3 = a(paramAbsListView, ((Long)localObject2).longValue());
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
              this.aevY.remove(localObject2);
            }
          }
          else {
            Log.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll invalid");
          }
        }
      }
    }
    if (!this.aevX) {
      com.tencent.threadpool.h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256281);
          if ((ba.c(ba.this) != 0) && (this.aewc.size() + 1 == ba.c(ba.this)))
          {
            if (((locala.aewe == ba.d(ba.this)) || (locala.aewf == ba.d(ba.this))) && (!this.aewc.contains(Long.valueOf(ba.d(ba.this)))))
            {
              ba.this.hlc.getListView().smoothScrollBy(-com.tencent.mm.cd.a.fromDPToPix(ba.this.hlc.aezO.getContext(), 5), 0);
              Log.i("MicroMsg.recordSelect.RecordSelectComponent", "slide below");
            }
            ba.e(ba.this);
          }
          AppMethodBeat.o(256281);
        }
      }, 500L);
    }
    this.aevT = locala;
    AppMethodBeat.o(256450);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(256456);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (!this.aevM)
    {
      AppMethodBeat.o(256456);
      return;
    }
    if ((!this.aevW) && (!jtn())) {
      com.tencent.mm.plugin.selectrecord.b.a.gUF().ud(jtr());
    }
    this.aevW = true;
    this.aevU = false;
    this.aevV = true;
    this.aevL.aiP(a((m)this.hlc.cm(m.class)));
    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "onScrollStateChanged ifSlide:%s", new Object[] { Boolean.valueOf(this.aevV) });
    AppMethodBeat.o(256456);
  }
  
  static final class a
  {
    long aewe = -1L;
    long aewf = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ba
 * JD-Core Version:    0.7.0.1
 */