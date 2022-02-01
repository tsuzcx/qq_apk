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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.z.a;
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.f.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.2;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.a;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
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

@com.tencent.mm.ui.chatting.d.a.a(gRF=ai.class)
public class ar
  extends a
  implements com.tencent.mm.ag.z, RecordSelectTipsBar.a, ai
{
  private static HashMap<Long, Integer> PsZ;
  private RecordSelectTipsBar PsK;
  private boolean PsL;
  private boolean PsM;
  private int PsN;
  private int PsO;
  private int PsP;
  private long PsQ;
  private int PsR;
  private a PsS;
  private boolean PsT;
  private boolean PsU;
  private boolean PsV;
  private boolean PsW;
  private CopyOnWriteArraySet<Long> PsX;
  private HashMap<Long, ca> PsY;
  private View kvj;
  
  static
  {
    AppMethodBeat.i(233175);
    PsZ = new HashMap();
    AppMethodBeat.o(233175);
  }
  
  public ar()
  {
    AppMethodBeat.i(233154);
    this.PsL = false;
    this.PsM = true;
    this.PsN = -1;
    this.PsO = -1;
    this.PsP = -1;
    this.PsQ = -1L;
    this.PsR = 0;
    this.PsS = null;
    this.PsT = true;
    this.PsU = false;
    this.PsV = false;
    this.PsW = false;
    this.PsX = new CopyOnWriteArraySet();
    this.PsY = new HashMap();
    AppMethodBeat.o(233154);
  }
  
  private void BS(boolean paramBoolean)
  {
    AppMethodBeat.i(233172);
    if (this.PsU)
    {
      this.PsK.performHapticFeedback(0, 2);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.selectrecord.b.a.eSu().eSw();
        AppMethodBeat.o(233172);
        return;
      }
      com.tencent.mm.plugin.selectrecord.b.a.eSu().eSx();
    }
    AppMethodBeat.o(233172);
  }
  
  private ca Ny(long paramLong)
  {
    AppMethodBeat.i(233173);
    if (this.PsY.containsKey(Long.valueOf(paramLong)))
    {
      localca = (ca)this.PsY.get(Long.valueOf(paramLong));
      AppMethodBeat.o(233173);
      return localca;
    }
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramLong);
    this.PsY.put(Long.valueOf(paramLong), localca);
    AppMethodBeat.o(233173);
    return localca;
  }
  
  public static int a(k paramk)
  {
    AppMethodBeat.i(233168);
    paramk = paramk.gOs();
    if (paramk == null)
    {
      AppMethodBeat.o(233168);
      return 0;
    }
    int i = paramk.size();
    AppMethodBeat.o(233168);
    return i;
  }
  
  private Pair<Boolean, Boolean> a(k paramk, long paramLong)
  {
    AppMethodBeat.i(233174);
    if (paramk == null)
    {
      Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine adapterComponent is null");
      paramk = Boolean.FALSE;
      paramk = new Pair(paramk, paramk);
      AppMethodBeat.o(233174);
      return paramk;
    }
    if (this.PsK.getHeight() <= 0)
    {
      Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine recordSelectTipsBar height <= 0");
      paramk = Boolean.FALSE;
      paramk = new Pair(paramk, paramk);
      AppMethodBeat.o(233174);
      return paramk;
    }
    paramk = paramk.zh(paramLong);
    if (paramk != null)
    {
      if (this.PsN <= 0)
      {
        arrayOfInt = new int[2];
        this.PsK.getLocationOnScreen(arrayOfInt);
        this.PsN = (arrayOfInt[1] + this.PsK.getHeight());
        this.PsO = com.tencent.mm.cb.a.aH(this.dom.Pwc.getContext(), 2131165306);
        this.PsP = com.tencent.mm.cb.a.fromDPToPix(this.dom.Pwc.getContext(), 24);
        Log.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine(%s, %s) recordSelectTipsBarBottomLoctaion:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.PsK.getHeight()), Integer.valueOf(this.PsN) });
      }
      for (;;)
      {
        paramk = (CheckBox)paramk.findViewById(2131298410);
        if (paramk != null) {
          break;
        }
        Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine, checkBox is null??");
        paramk = Boolean.FALSE;
        paramk = new Pair(paramk, paramk);
        AppMethodBeat.o(233174);
        return paramk;
        arrayOfInt = new int[2];
        this.PsK.getLocationOnScreen(arrayOfInt);
        Log.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine2(%s, %s)", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.PsK.getHeight()) });
      }
      int[] arrayOfInt = new int[2];
      paramk.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1] + this.PsP - this.PsN;
      Log.d("MicroMsg.recordSelect.RecordSelectComponent", "view(%s, %s) recordSelectTipsBar(%s) viewTopHeight:%s marginTop:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.PsP), Integer.valueOf(this.PsN), Integer.valueOf(this.PsO), Integer.valueOf(i) });
      if (i > this.PsO)
      {
        paramk = Boolean.TRUE;
        paramk = new Pair(paramk, paramk);
        AppMethodBeat.o(233174);
        return paramk;
      }
      paramk = new Pair(Boolean.TRUE, Boolean.FALSE);
      AppMethodBeat.o(233174);
      return paramk;
    }
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine view is null, msgId:%s", new Object[] { Long.valueOf(paramLong) });
    paramk = Boolean.FALSE;
    paramk = new Pair(paramk, paramk);
    AppMethodBeat.o(233174);
    return paramk;
  }
  
  private void a(k paramk, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(233171);
    Pair localPair = a(paramk, paramLong);
    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle msgId:%s result:%s %s", new Object[] { Long.valueOf(paramLong), localPair.first, localPair.second });
    if (((Boolean)localPair.first).booleanValue())
    {
      if (((Boolean)localPair.second).booleanValue())
      {
        if ((!paramk.gOs().contains(Long.valueOf(paramLong))) && (!this.PsX.contains(Long.valueOf(paramLong))))
        {
          if (paramk.gOs().size() >= 99)
          {
            Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle max select msg num.");
            AppMethodBeat.o(233171);
            return;
          }
          paramk.Nu(paramLong);
          if (!paramBoolean)
          {
            if (!this.PsT) {
              this.PsK.Xl(a(paramk));
            }
            BS(true);
            AppMethodBeat.o(233171);
          }
        }
      }
      else if (paramk.gOs().contains(Long.valueOf(paramLong)))
      {
        paramk.Nu(paramLong);
        if (!paramBoolean)
        {
          if (!this.PsT) {
            this.PsK.Xl(a(paramk));
          }
          BS(false);
          AppMethodBeat.o(233171);
        }
      }
    }
    else {
      Log.w("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle invalid");
    }
    AppMethodBeat.o(233171);
  }
  
  public final void B(Bundle paramBundle)
  {
    AppMethodBeat.i(233167);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.toString();; paramBundle = "null")
    {
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "doOnlySelectRecordMsg %s", new Object[] { paramBundle });
      this.PsM = false;
      this.dom.Pwc.gNh();
      AppMethodBeat.o(233167);
      return;
    }
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(233164);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "failDoJob %s", new Object[] { parama });
    AppMethodBeat.o(233164);
  }
  
  public final boolean aSC()
  {
    return false;
  }
  
  public final boolean aSD()
  {
    return true;
  }
  
  public final boolean aSE()
  {
    return false;
  }
  
  public final void b(z.a parama)
  {
    AppMethodBeat.i(233165);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "doInBackground %s", new Object[] { parama });
    AppMethodBeat.o(233165);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(233166);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "requestExitSelectedMode %s", new Object[] { parama });
    AppMethodBeat.o(233166);
  }
  
  public final void eSC()
  {
    AppMethodBeat.i(233162);
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "click cleanAllSelect");
    k localk = (k)this.dom.bh(k.class);
    Iterator localIterator = localk.gOs().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localk.Nu(localLong.longValue());
      this.PsX.add(localLong);
    }
    localk.gOt();
    this.PsK.Xl(a(localk));
    AppMethodBeat.o(233162);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(233155);
    this.PsL = this.dom.Pwc.getBooleanExtra("key_record_msg_select", false).booleanValue();
    this.PsT = this.dom.Pwc.getBooleanExtra("key_record_msg_select_introduce", true).booleanValue();
    this.PsQ = this.dom.Pwc.getLongExtra("key_record_select_min_msg_id", -1L);
    this.PsR = this.dom.Pwc.getIntExtra("key_record_select_msg_num", 0);
    Object localObject = this.dom.Pwc.getStringArrayList("key_record_select_msg_black_list");
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.PsX.add(Long.valueOf(Util.getLong(str, 0L)));
      }
    }
    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "isRecordSelect:%s showIntroduceView:%s lastSelectMinMsgId:%s lastSelectMsgNum:%s cancelSelectMsgSet:%s", new Object[] { Boolean.valueOf(this.PsL), Boolean.valueOf(this.PsT), Long.valueOf(this.PsQ), Integer.valueOf(this.PsR), Integer.valueOf(this.PsX.size()) });
    AppMethodBeat.o(233155);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(233156);
    if (this.PsL)
    {
      if (this.PsK == null)
      {
        l.a(this.dom.Pwc, 2131309885);
        this.PsK = ((RecordSelectTipsBar)this.dom.findViewById(2131306738));
        this.PsK.setIRecordSelectCallback(this);
      }
      k localk = (k)this.dom.bh(k.class);
      localk.i(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233152);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if ((!ar.f(ar.this)) && (!ar.this.gQO())) {
            com.tencent.mm.plugin.selectrecord.b.a.eSu().IF(ar.this.gQS());
          }
          ar.g(ar.this);
          ar.h(ar.this);
          localObject = (k)ar.this.dom.bh(k.class);
          long l = ((Long)paramAnonymousView.getTag()).longValue();
          if (((k)localObject).gOs().contains(Long.valueOf(l)))
          {
            ar.i(ar.this).add(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.eSu();
            paramAnonymousView.CWV += 1;
          }
          for (;;)
          {
            if (!((k)localObject).Nu(l))
            {
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.eSu();
              paramAnonymousView.CWP += 1;
            }
            Log.d("MicroMsg.recordSelect.RecordSelectComponent", "setOnEditModeItemClickListener msgId:%s", new Object[] { Long.valueOf(l) });
            ar.a(ar.this).Xl(ar.a((k)localObject));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(233152);
            return;
            ar.i(ar.this).remove(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.eSu();
            paramAnonymousView.CWU += 1;
          }
        }
      });
      localk.gOu();
      localk.gOv();
      localk.gOt();
      if (gQO()) {
        ((k)this.dom.bh(k.class)).a(this.PsQ, true, d.a.PDH);
      }
    }
    AppMethodBeat.o(233156);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(233157);
    if (this.PsL)
    {
      d.cgP().cgS();
      this.PsK.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233149);
          ar.this.dom.Pwe.amn(ar.a(ar.this).getHeight());
          AppMethodBeat.o(233149);
        }
      });
    }
    AppMethodBeat.o(233157);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(233158);
    super.gOK();
    if (this.PsL)
    {
      this.dom.getListView().setOnScrollListener(null);
      this.PsM = true;
      this.PsL = false;
      this.PsU = false;
      this.PsV = false;
    }
    AppMethodBeat.o(233158);
  }
  
  public final boolean gQN()
  {
    return this.PsL;
  }
  
  public final boolean gQO()
  {
    return (this.PsQ != -1L) && (this.PsR != 0);
  }
  
  public final boolean gQP()
  {
    AppMethodBeat.i(233161);
    if (this.PsL)
    {
      int i6 = gQS();
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish num:%s", new Object[] { Integer.valueOf(i6) });
      if (i6 == 0) {
        B(null);
      }
      for (;;)
      {
        if ((!this.PsV) && (!gQO())) {
          com.tencent.mm.plugin.selectrecord.b.a.eSu().IF(i6);
        }
        AppMethodBeat.o(233161);
        return true;
        Object localObject2 = ((k)this.dom.bh(k.class)).gOs();
        Object localObject3;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mm.model.z.aTY();
          localObject2 = ((Set)localObject2).iterator();
          long l = 0L;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = Ny(((Long)((Iterator)localObject2).next()).longValue());
            if (localObject3 == null) {
              i = 0;
            }
            for (;;)
            {
              l = i + l;
              break;
              if (PsZ.containsKey(Long.valueOf(((eo)localObject3).field_msgId)))
              {
                i = ((Integer)PsZ.get(Long.valueOf(((eo)localObject3).field_msgId))).intValue();
              }
              else
              {
                i = m.ahM(((ca)localObject3).getType());
                if (!com.tencent.mm.plugin.backup.f.h.Bi(i))
                {
                  Log.e("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { ((eo)localObject3).field_talker, Integer.valueOf(((ca)localObject3).getType()) });
                  PsZ.put(Long.valueOf(((eo)localObject3).field_msgId), Integer.valueOf(0));
                  i = 0;
                }
                else
                {
                  is localis = new is();
                  localis.Brn = ((eo)localObject3).field_msgSvrId;
                  if (((eo)localObject3).field_isSend == 1)
                  {
                    localis.KHl = new dqi().bhy((String)localObject1);
                    localis.KHm = new dqi().bhy(((eo)localObject3).field_talker);
                  }
                  Object localObject4;
                  for (localis.KMN = 2;; localis.KMN = 4)
                  {
                    localis.KMS = new SKBuiltinBuffer_t();
                    localis.KMT = 0;
                    localis.KMU = 0;
                    localis.KHq = "";
                    localis.oUv = i;
                    localis.KMO = ((int)(((eo)localObject3).field_createTime / 1000L));
                    localis.KMW = ((eo)localObject3).field_createTime;
                    localis.KMV = ((int)((eo)localObject3).field_msgSeq);
                    localis.KMX = ((eo)localObject3).field_flag;
                    localObject4 = new dqi();
                    ((dqi)localObject4).bhy(Util.nullAs(((eo)localObject3).field_content, ""));
                    localis.KHn = ((dqi)localObject4);
                    localObject4 = c.cfW().Bh(m.ahM(((ca)localObject3).getType()));
                    if (localObject4 != null) {
                      break label581;
                    }
                    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(((ca)localObject3).getType()) });
                    PsZ.put(Long.valueOf(((eo)localObject3).field_msgId), Integer.valueOf(0));
                    i = 0;
                    break;
                    localis.KHl = new dqi().bhy(((eo)localObject3).field_talker);
                    localis.KHm = new dqi().bhy((String)localObject1);
                  }
                  label581:
                  i = ((com.tencent.mm.plugin.backup.f.l)localObject4).a(localis, true, (ca)localObject3, (String)localObject1, null, null, false, 0L);
                  PsZ.put(Long.valueOf(((eo)localObject3).field_msgId), Integer.valueOf(i));
                }
              }
            }
          }
          localObject1 = com.tencent.mm.plugin.selectrecord.b.a.eSu();
          if (((com.tencent.mm.plugin.selectrecord.b.a)localObject1).CWO.eNa > 0L)
          {
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).CXc += ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).CWO.eNa;
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).CXd += 1L;
          }
          ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).CWO.eNa = l;
          i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slK, 524288000);
          Log.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
          if (l >= i)
          {
            localObject1 = com.tencent.mm.plugin.selectrecord.b.a.eSu();
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).CWQ += 1;
            com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getContext().getString(2131765156), "", this.dom.Pwc.getContext().getString(2131768713), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(233153);
                Log.i("MicroMsg.recordSelect.RecordSelectComponent", "exceed max size, click i know");
                AppMethodBeat.o(233153);
              }
            });
          }
        }
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish exceed max storage size!!!");
          AppMethodBeat.o(233161);
          return true;
        }
        localObject2 = ((com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).gPy();
        com.tencent.mm.ui.chatting.l.a(this.dom.Pwc.getContext(), (List)localObject2, true, this.dom.GUe.field_username, this);
        Object localObject1 = com.tencent.mm.plugin.selectrecord.b.a.eSu();
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
            localObject3 = k.b.HD(((eo)localObject3).field_content);
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
        localObject1 = ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).CWO;
        ((id)localObject1).eJk = ((id)localObject1).x("FinalShareCountByType", (String)localObject2, true);
      }
    }
    AppMethodBeat.o(233161);
    return false;
  }
  
  public final boolean gQQ()
  {
    return this.PsM;
  }
  
  public final CopyOnWriteArraySet<Long> gQR()
  {
    return this.PsX;
  }
  
  public final int gQS()
  {
    AppMethodBeat.i(233169);
    int i = a((k)this.dom.bh(k.class));
    AppMethodBeat.o(233169);
    return i;
  }
  
  public final void gQT()
  {
    AppMethodBeat.i(233170);
    if ((!this.PsV) && (!gQO())) {
      com.tencent.mm.plugin.selectrecord.b.a.eSu().IF(gQS());
    }
    AppMethodBeat.o(233170);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(233159);
    if (!this.PsL)
    {
      AppMethodBeat.o(233159);
      return;
    }
    if (paramInt2 == 0)
    {
      Log.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(233159);
      return;
    }
    paramAbsListView = (k)this.dom.bh(k.class);
    final a locala = new a();
    int i = this.dom.getHeaderViewsCount();
    Object localObject1 = paramAbsListView.amt(paramInt1 - i);
    if (localObject1 != null) {
      locala.Ptd = ((eo)localObject1).field_msgId;
    }
    localObject1 = ((k)this.dom.bh(k.class)).amt(paramInt1 + 1 - i);
    if (localObject1 != null) {
      locala.Pte = ((eo)localObject1).field_msgId;
    }
    boolean bool1;
    long l1;
    label183:
    Object localObject2;
    label309:
    Object localObject3;
    if (this.PsS == null)
    {
      bool1 = true;
      boolean bool2 = this.PsT;
      long l2 = locala.Ptd;
      long l3 = locala.Pte;
      if (this.PsS == null) {
        break label768;
      }
      l1 = this.PsS.Ptd;
      Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll, first:%s showIntroduceView:%s firstVisibleItem:%s headerCount:%s visibleItemCount:%s totalItemCount:%s firstVisibleMsgId:%s secondVisibleMsgId:%s lastFirstVisibleMsgId:%s ifSlide:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(this.PsU) });
      localObject1 = paramAbsListView.gOs();
      localObject2 = paramAbsListView.gOq();
      if (!bool1) {
        break label790;
      }
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 < 0) {
        break label1429;
      }
      localObject3 = (ca)((SparseArray)localObject2).get(paramInt1);
      if ((localObject3 != null) && (((eo)localObject3).field_msgId >= locala.Ptd) && (paramAbsListView.bT((ca)localObject3)) && (!this.PsX.contains(Long.valueOf(((eo)localObject3).field_msgId))))
      {
        if (((locala.Pte == -1L) || (((eo)localObject3).field_msgId <= locala.Pte)) && ((locala.Pte != -1L) || (((eo)localObject3).field_msgId <= locala.Ptd))) {
          break label776;
        }
        paramAbsListView.Nu(((eo)localObject3).field_msgId);
      }
    }
    for (;;)
    {
      paramInt1 -= 1;
      break label309;
      if (this.kvj == null)
      {
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll totalItemCount:%s headerViewsCount:%s footerViewCount:%s totalCount:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(this.dom.getHeaderViewsCount()), Integer.valueOf(this.dom.cda()), Integer.valueOf(paramAbsListView.cZm()) });
        if ((this.PsT) && (paramInt3 - this.dom.getHeaderViewsCount() - this.dom.cda() == paramAbsListView.cZm()))
        {
          localObject1 = paramAbsListView.amt(0);
          if (((eo)localObject1).field_msgId != 0L)
          {
            localObject2 = a(paramAbsListView, ((eo)localObject1).field_msgId);
            if ((!((Boolean)((Pair)localObject2).first).booleanValue()) || (!((Boolean)((Pair)localObject2).second).booleanValue())) {
              break label665;
            }
            this.PsT = false;
          }
        }
        label606:
        if (!this.PsT) {
          break label743;
        }
        localObject1 = this.PsK;
        com.tencent.f.h.RTc.aV(new RecordSelectTipsBar.2((RecordSelectTipsBar)localObject1));
      }
      for (;;)
      {
        this.dom.getListView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233150);
            if (ar.b(ar.this) != null)
            {
              AppMethodBeat.o(233150);
              return;
            }
            ar.a(ar.this, ar.this.dom.getListView().findViewById(2131303230));
            if (ar.b(ar.this) != null)
            {
              int i = ar.this.dom.getListView().getHeight() - com.tencent.mm.cb.a.aH(ar.this.dom.Pwc.getContext(), 2131165299);
              int j = g.aAh().azQ().getInt(com.tencent.mm.storage.ar.a.Oom, 0);
              if (((ar.this.gQO()) && (i != j)) || (!ar.this.gQO()))
              {
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)ar.b(ar.this).getLayoutParams();
                localLayoutParams.height = i;
                ar.b(ar.this).setLayoutParams(localLayoutParams);
                if (i != j) {
                  g.aAh().azQ().set(com.tencent.mm.storage.ar.a.Oom, Integer.valueOf(localLayoutParams.height));
                }
                Log.i("MicroMsg.recordSelect.RecordSelectComponent", "update footView height:%s", new Object[] { Integer.valueOf(localLayoutParams.height) });
              }
            }
            AppMethodBeat.o(233150);
          }
        }, 300L);
        bool1 = false;
        break;
        label665:
        localObject1 = paramAbsListView.zh(((eo)localObject1).field_msgId);
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = (CheckBox)((View)localObject1).findViewById(2131298410);
        if (localObject1 == null) {}
        for (bool1 = true;; bool1 = false)
        {
          Log.d("MicroMsg.recordSelect.RecordSelectComponent", "checkBox is null(%s)", new Object[] { Boolean.valueOf(bool1) });
          if (localObject1 != null) {
            break;
          }
          this.PsT = false;
          break;
        }
        label743:
        this.PsK.Xl(a((k)this.dom.bh(k.class)));
      }
      label768:
      l1 = -1L;
      break label183;
      label776:
      a(paramAbsListView, ((eo)localObject3).field_msgId, true);
    }
    label790:
    if (locala.Ptd < this.PsS.Ptd)
    {
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 >= 0)
      {
        localObject3 = (ca)((SparseArray)localObject2).get(paramInt1);
        if ((localObject3 != null) && (((eo)localObject3).field_msgId >= locala.Ptd) && (paramAbsListView.bT((ca)localObject3)))
        {
          if (paramAbsListView.gOs().size() < 99) {
            break label924;
          }
          Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll max select msg num.(2)");
          if (!((Set)localObject1).contains(Long.valueOf(((eo)localObject3).field_msgId))) {
            this.PsX.add(Long.valueOf(((eo)localObject3).field_msgId));
          }
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          label924:
          if (((locala.Pte != -1L) && (((eo)localObject3).field_msgId > locala.Pte)) || ((locala.Pte == -1L) && (((eo)localObject3).field_msgId > locala.Ptd)))
          {
            if ((!((Set)localObject1).contains(Long.valueOf(((eo)localObject3).field_msgId))) && (!this.PsX.contains(Long.valueOf(((eo)localObject3).field_msgId))))
            {
              paramAbsListView.Nu(((eo)localObject3).field_msgId);
              if (!this.PsT) {
                this.PsK.Xl(a(paramAbsListView));
              }
              BS(true);
            }
          }
          else {
            a(paramAbsListView, ((eo)localObject3).field_msgId, false);
          }
        }
      }
    }
    else
    {
      if (locala.Ptd > this.PsS.Ptd)
      {
        localObject2 = ((Set)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          if (paramAbsListView.bT(Ny(((Long)localObject3).longValue()))) {
            if (((Long)localObject3).longValue() < locala.Ptd)
            {
              paramAbsListView.Nu(((Long)localObject3).longValue());
              BS(false);
              if (!this.PsT) {
                this.PsK.Xl(a(paramAbsListView));
              }
            }
            else if ((((Long)localObject3).longValue() == locala.Ptd) || (((Long)localObject3).longValue() == locala.Pte))
            {
              a(paramAbsListView, ((Long)localObject3).longValue(), false);
            }
          }
        }
      }
      if ((!this.PsX.contains(Long.valueOf(locala.Ptd))) && (paramAbsListView.bT(Ny(locala.Ptd))))
      {
        if ((paramAbsListView.gOs().size() >= 99) && (!((Set)localObject1).contains(Long.valueOf(locala.Ptd)))) {
          this.PsX.add(Long.valueOf(locala.Ptd));
        }
        a(paramAbsListView, locala.Ptd, false);
      }
      if ((!this.PsX.contains(Long.valueOf(locala.Pte))) && (locala.Pte != -1L) && (paramAbsListView.bT(Ny(locala.Pte))))
      {
        if ((paramAbsListView.gOs().size() >= 99) && (!((Set)localObject1).contains(Long.valueOf(locala.Pte)))) {
          this.PsX.add(Long.valueOf(locala.Pte));
        }
        a(paramAbsListView, locala.Pte, false);
      }
    }
    label1429:
    if (this.PsU)
    {
      localObject1 = this.PsX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        if (locala.Ptd > ((Long)localObject2).longValue())
        {
          this.PsX.remove(localObject2);
        }
        else if ((((Long)localObject2).longValue() == locala.Ptd) || (((Long)localObject2).longValue() == locala.Pte))
        {
          localObject3 = a(paramAbsListView, ((Long)localObject2).longValue());
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
              this.PsX.remove(localObject2);
            }
          }
          else {
            Log.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll invalid");
          }
        }
      }
    }
    if (!this.PsW) {
      com.tencent.f.h.RTc.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233151);
          if ((ar.c(ar.this) != 0) && (this.Ptb.size() + 1 == ar.c(ar.this)))
          {
            if (((locala.Ptd == ar.d(ar.this)) || (locala.Pte == ar.d(ar.this))) && (!this.Ptb.contains(Long.valueOf(ar.d(ar.this)))))
            {
              ar.this.dom.getListView().smoothScrollBy(-com.tencent.mm.cb.a.fromDPToPix(ar.this.dom.Pwc.getContext(), 5), 0);
              Log.i("MicroMsg.recordSelect.RecordSelectComponent", "slide below");
            }
            ar.e(ar.this);
          }
          AppMethodBeat.o(233151);
        }
      }, 500L);
    }
    this.PsS = locala;
    AppMethodBeat.o(233159);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(233160);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (!this.PsL)
    {
      AppMethodBeat.o(233160);
      return;
    }
    if ((!this.PsV) && (!gQO())) {
      com.tencent.mm.plugin.selectrecord.b.a.eSu().IF(gQS());
    }
    this.PsV = true;
    this.PsT = false;
    this.PsU = true;
    this.PsK.Xl(a((k)this.dom.bh(k.class)));
    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "onScrollStateChanged ifSlide:%s", new Object[] { Boolean.valueOf(this.PsU) });
    AppMethodBeat.o(233160);
  }
  
  public final void uo(boolean paramBoolean)
  {
    AppMethodBeat.i(233163);
    ((k)this.dom.bh(k.class)).uo(paramBoolean);
    AppMethodBeat.o(233163);
  }
  
  static final class a
  {
    long Ptd = -1L;
    long Pte = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ar
 * JD-Core Version:    0.7.0.1
 */