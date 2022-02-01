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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.g.b.a.et;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.backup.f.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.2;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.a;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.h.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@com.tencent.mm.ui.chatting.d.a.a(fFo=af.class)
public class ao
  extends a
  implements z, RecordSelectTipsBar.a, af
{
  private static HashMap<Long, Integer> JMj;
  private RecordSelectTipsBar JLU;
  private boolean JLV;
  private boolean JLW;
  private int JLX;
  private int JLY;
  private int JLZ;
  private long JMa;
  private int JMb;
  private a JMc;
  private boolean JMd;
  private boolean JMe;
  private boolean JMf;
  private boolean JMg;
  private CopyOnWriteArraySet<Long> JMh;
  private HashMap<Long, bu> JMi;
  private View jua;
  
  static
  {
    AppMethodBeat.i(194085);
    JMj = new HashMap();
    AppMethodBeat.o(194085);
  }
  
  public ao()
  {
    AppMethodBeat.i(194064);
    this.JLV = false;
    this.JLW = true;
    this.JLX = -1;
    this.JLY = -1;
    this.JLZ = -1;
    this.JMa = -1L;
    this.JMb = 0;
    this.JMc = null;
    this.JMd = true;
    this.JMe = false;
    this.JMf = false;
    this.JMg = false;
    this.JMh = new CopyOnWriteArraySet();
    this.JMi = new HashMap();
    AppMethodBeat.o(194064);
  }
  
  private bu DW(long paramLong)
  {
    AppMethodBeat.i(194083);
    if (this.JMi.containsKey(Long.valueOf(paramLong)))
    {
      localbu = (bu)this.JMi.get(Long.valueOf(paramLong));
      AppMethodBeat.o(194083);
      return localbu;
    }
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramLong);
    this.JMi.put(Long.valueOf(paramLong), localbu);
    AppMethodBeat.o(194083);
    return localbu;
  }
  
  public static int a(com.tencent.mm.ui.chatting.d.b.k paramk)
  {
    AppMethodBeat.i(194078);
    paramk = paramk.fCk();
    if (paramk == null)
    {
      AppMethodBeat.o(194078);
      return 0;
    }
    int i = paramk.size();
    AppMethodBeat.o(194078);
    return i;
  }
  
  private Pair<Boolean, Boolean> a(com.tencent.mm.ui.chatting.d.b.k paramk, long paramLong)
  {
    AppMethodBeat.i(194084);
    if (paramk == null)
    {
      ad.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine adapterComponent is null");
      paramk = Boolean.FALSE;
      paramk = new Pair(paramk, paramk);
      AppMethodBeat.o(194084);
      return paramk;
    }
    if (this.JLU.getHeight() <= 0)
    {
      ad.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine recordSelectTipsBar height <= 0");
      paramk = Boolean.FALSE;
      paramk = new Pair(paramk, paramk);
      AppMethodBeat.o(194084);
      return paramk;
    }
    paramk = paramk.DS(paramLong);
    if (paramk != null)
    {
      if (this.JLX <= 0)
      {
        arrayOfInt = new int[2];
        this.JLU.getLocationOnScreen(arrayOfInt);
        this.JLX = (arrayOfInt[1] + this.JLU.getHeight());
        this.JLY = com.tencent.mm.cc.a.ay(this.cWM.JOR.getContext(), 2131165296);
        this.JLZ = com.tencent.mm.cc.a.fromDPToPix(this.cWM.JOR.getContext(), 24);
        ad.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine(%s, %s) recordSelectTipsBarBottomLoctaion:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.JLU.getHeight()), Integer.valueOf(this.JLX) });
      }
      for (;;)
      {
        paramk = (CheckBox)paramk.findViewById(2131298068);
        if (paramk != null) {
          break;
        }
        ad.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine, checkBox is null??");
        paramk = Boolean.FALSE;
        paramk = new Pair(paramk, paramk);
        AppMethodBeat.o(194084);
        return paramk;
        arrayOfInt = new int[2];
        this.JLU.getLocationOnScreen(arrayOfInt);
        ad.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine2(%s, %s)", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.JLU.getHeight()) });
      }
      int[] arrayOfInt = new int[2];
      paramk.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1] + this.JLZ - this.JLX;
      ad.d("MicroMsg.recordSelect.RecordSelectComponent", "view(%s, %s) recordSelectTipsBar(%s) viewTopHeight:%s marginTop:%s", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.JLZ), Integer.valueOf(this.JLX), Integer.valueOf(this.JLY), Integer.valueOf(i) });
      if (i > this.JLY)
      {
        paramk = Boolean.TRUE;
        paramk = new Pair(paramk, paramk);
        AppMethodBeat.o(194084);
        return paramk;
      }
      paramk = new Pair(Boolean.TRUE, Boolean.FALSE);
      AppMethodBeat.o(194084);
      return paramk;
    }
    ad.i("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine view is null, msgId:%s", new Object[] { Long.valueOf(paramLong) });
    paramk = Boolean.FALSE;
    paramk = new Pair(paramk, paramk);
    AppMethodBeat.o(194084);
    return paramk;
  }
  
  private void a(com.tencent.mm.ui.chatting.d.b.k paramk, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(194081);
    Pair localPair = a(paramk, paramLong);
    ad.d("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle msgId:%s result:%s %s", new Object[] { Long.valueOf(paramLong), localPair.first, localPair.second });
    if (((Boolean)localPair.first).booleanValue())
    {
      if (((Boolean)localPair.second).booleanValue())
      {
        if ((!paramk.fCk().contains(Long.valueOf(paramLong))) && (!this.JMh.contains(Long.valueOf(paramLong))))
        {
          if (paramk.fCk().size() >= 99)
          {
            ad.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle max select msg num.");
            AppMethodBeat.o(194081);
            return;
          }
          paramk.DR(paramLong);
          if (!paramBoolean)
          {
            if (!this.JMd) {
              this.JLU.OZ(a(paramk));
            }
            xW(true);
            AppMethodBeat.o(194081);
          }
        }
      }
      else if (paramk.fCk().contains(Long.valueOf(paramLong)))
      {
        paramk.DR(paramLong);
        if (!paramBoolean)
        {
          if (!this.JMd) {
            this.JLU.OZ(a(paramk));
          }
          xW(false);
          AppMethodBeat.o(194081);
        }
      }
    }
    else {
      ad.w("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle invalid");
    }
    AppMethodBeat.o(194081);
  }
  
  private void xW(boolean paramBoolean)
  {
    AppMethodBeat.i(194082);
    if (this.JMe)
    {
      this.JLU.performHapticFeedback(0, 2);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.selectrecord.b.a.dNa().dNc();
        AppMethodBeat.o(194082);
        return;
      }
      com.tencent.mm.plugin.selectrecord.b.a.dNa().dNd();
    }
    AppMethodBeat.o(194082);
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(194074);
    ad.i("MicroMsg.recordSelect.RecordSelectComponent", "failDoJob %s", new Object[] { parama });
    AppMethodBeat.o(194074);
  }
  
  public final boolean azg()
  {
    return false;
  }
  
  public final boolean azh()
  {
    return true;
  }
  
  public final void b(z.a parama)
  {
    AppMethodBeat.i(194075);
    ad.i("MicroMsg.recordSelect.RecordSelectComponent", "doInBackground %s", new Object[] { parama });
    AppMethodBeat.o(194075);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(194076);
    ad.i("MicroMsg.recordSelect.RecordSelectComponent", "requestExitSelectedMode %s", new Object[] { parama });
    AppMethodBeat.o(194076);
  }
  
  public final void dNf()
  {
    AppMethodBeat.i(194072);
    ad.i("MicroMsg.recordSelect.RecordSelectComponent", "click cleanAllSelect");
    com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    Iterator localIterator = localk.fCk().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localk.DR(localLong.longValue());
      this.JMh.add(localLong);
    }
    localk.fCl();
    this.JLU.OZ(a(localk));
    AppMethodBeat.o(194072);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(194068);
    super.fCC();
    if (this.JLV)
    {
      this.cWM.getListView().setOnScrollListener(null);
      this.JLW = true;
      this.JLV = false;
      this.JMe = false;
      this.JMf = false;
    }
    AppMethodBeat.o(194068);
  }
  
  public final boolean fEA()
  {
    return (this.JMa != -1L) && (this.JMb != 0);
  }
  
  public final boolean fEB()
  {
    AppMethodBeat.i(194071);
    if (this.JLV)
    {
      int i6 = fEE();
      ad.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish num:%s", new Object[] { Integer.valueOf(i6) });
      if (i6 == 0) {
        u(null);
      }
      for (;;)
      {
        if ((!this.JMf) && (!fEA())) {
          com.tencent.mm.plugin.selectrecord.b.a.dNa().ze(i6);
        }
        AppMethodBeat.o(194071);
        return true;
        Object localObject2 = ((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCk();
        Object localObject3;
        if (localObject2 != null)
        {
          localObject1 = u.aAm();
          localObject2 = ((Set)localObject2).iterator();
          long l = 0L;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = DW(((Long)((Iterator)localObject2).next()).longValue());
            if (localObject3 == null) {
              i = 0;
            }
            for (;;)
            {
              l = i + l;
              break;
              if (JMj.containsKey(Long.valueOf(((ei)localObject3).field_msgId)))
              {
                i = ((Integer)JMj.get(Long.valueOf(((ei)localObject3).field_msgId))).intValue();
              }
              else
              {
                i = m.Yv(((bu)localObject3).getType());
                if (!com.tencent.mm.plugin.backup.f.h.xy(i))
                {
                  ad.e("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { ((ei)localObject3).field_talker, Integer.valueOf(((bu)localObject3).getType()) });
                  JMj.put(Long.valueOf(((ei)localObject3).field_msgId), Integer.valueOf(0));
                  i = 0;
                }
                else
                {
                  if localif = new if();
                  localif.xbt = ((ei)localObject3).field_msgSvrId;
                  if (((ei)localObject3).field_isSend == 1)
                  {
                    localif.Fvi = new cwt().aPy((String)localObject1);
                    localif.Fvj = new cwt().aPy(((ei)localObject3).field_talker);
                  }
                  Object localObject4;
                  for (localif.FAI = 2;; localif.FAI = 4)
                  {
                    localif.FAN = new SKBuiltinBuffer_t();
                    localif.FAO = 0;
                    localif.FAP = 0;
                    localif.Fvn = "";
                    localif.nEf = i;
                    localif.FAJ = ((int)(((ei)localObject3).field_createTime / 1000L));
                    localif.FAS = ((ei)localObject3).field_createTime;
                    localif.FAQ = ((int)((ei)localObject3).field_msgSeq);
                    localif.FAT = ((ei)localObject3).field_flag;
                    localObject4 = new cwt();
                    ((cwt)localObject4).aPy(bt.bI(((ei)localObject3).field_content, ""));
                    localif.Fvk = ((cwt)localObject4);
                    localObject4 = c.bIf().xx(m.Yv(((bu)localObject3).getType()));
                    if (localObject4 != null) {
                      break label581;
                    }
                    ad.d("MicroMsg.recordSelect.RecordSelectComponent", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(((bu)localObject3).getType()) });
                    JMj.put(Long.valueOf(((ei)localObject3).field_msgId), Integer.valueOf(0));
                    i = 0;
                    break;
                    localif.Fvi = new cwt().aPy(((ei)localObject3).field_talker);
                    localif.Fvj = new cwt().aPy((String)localObject1);
                  }
                  label581:
                  i = ((com.tencent.mm.plugin.backup.f.l)localObject4).a(localif, true, (bu)localObject3, (String)localObject1, null, null, false, 0L);
                  JMj.put(Long.valueOf(((ei)localObject3).field_msgId), Integer.valueOf(i));
                }
              }
            }
          }
          localObject1 = com.tencent.mm.plugin.selectrecord.b.a.dNa();
          if (((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yBX.eiG > 0L)
          {
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yCl += ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yBX.eiG;
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yCm += 1L;
          }
          ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yBX.eiG = l;
          i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGY, 524288000);
          ad.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
          if (l >= i)
          {
            localObject1 = com.tencent.mm.plugin.selectrecord.b.a.dNa();
            ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yBZ += 1;
            com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getContext().getString(2131767155), "", this.cWM.JOR.getContext().getString(2131766205), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(194063);
                ad.i("MicroMsg.recordSelect.RecordSelectComponent", "exceed max size, click i know");
                AppMethodBeat.o(194063);
              }
            });
          }
        }
        for (int i = 1; i != 0; i = 0)
        {
          ad.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFinish exceed max storage size!!!");
          AppMethodBeat.o(194071);
          return true;
        }
        localObject2 = ((com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fDp();
        com.tencent.mm.ui.chatting.k.a(this.cWM.JOR.getContext(), (List)localObject2, true, this.cWM.BYG.field_username, this);
        Object localObject1 = com.tencent.mm.plugin.selectrecord.b.a.dNa();
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
          localObject3 = (bu)((Iterator)localObject2).next();
          switch (((bu)localObject3).getType())
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
            localObject3 = k.b.yr(((ei)localObject3).field_content);
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
        localObject1 = ((com.tencent.mm.plugin.selectrecord.b.a)localObject1).yBX;
        ((et)localObject1).eiF = ((et)localObject1).t("FinalShareCountByType", (String)localObject2, true);
      }
    }
    AppMethodBeat.o(194071);
    return false;
  }
  
  public final boolean fEC()
  {
    return this.JLW;
  }
  
  public final CopyOnWriteArraySet<Long> fED()
  {
    return this.JMh;
  }
  
  public final int fEE()
  {
    AppMethodBeat.i(194079);
    int i = a((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class));
    AppMethodBeat.o(194079);
    return i;
  }
  
  public final void fEF()
  {
    AppMethodBeat.i(194080);
    if ((!this.JMf) && (!fEA())) {
      com.tencent.mm.plugin.selectrecord.b.a.dNa().ze(fEE());
    }
    AppMethodBeat.o(194080);
  }
  
  public final boolean fEz()
  {
    return this.JLV;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(194065);
    this.JLV = this.cWM.JOR.getBooleanExtra("key_record_msg_select", false).booleanValue();
    this.JMd = this.cWM.JOR.getBooleanExtra("key_record_msg_select_introduce", true).booleanValue();
    this.JMa = this.cWM.JOR.getLongExtra("key_record_select_min_msg_id", -1L);
    this.JMb = this.cWM.JOR.getIntExtra("key_record_select_msg_num", 0);
    Object localObject = this.cWM.JOR.getStringArrayList("key_record_select_msg_black_list");
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.JMh.add(Long.valueOf(bt.getLong(str, 0L)));
      }
    }
    ad.i("MicroMsg.recordSelect.RecordSelectComponent", "isRecordSelect:%s showIntroduceView:%s lastSelectMinMsgId:%s lastSelectMsgNum:%s cancelSelectMsgSet:%s", new Object[] { Boolean.valueOf(this.JLV), Boolean.valueOf(this.JMd), Long.valueOf(this.JMa), Integer.valueOf(this.JMb), Integer.valueOf(this.JMh.size()) });
    AppMethodBeat.o(194065);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(194066);
    if (this.JLV)
    {
      if (this.JLU == null)
      {
        l.a(this.cWM.JOR, 2131308464);
        this.JLU = ((RecordSelectTipsBar)this.cWM.findViewById(2131308397));
        this.JLU.setIRecordSelectCallback(this);
      }
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      localk.e(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194062);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if ((!ao.f(ao.this)) && (!ao.this.fEA())) {
            com.tencent.mm.plugin.selectrecord.b.a.dNa().ze(ao.this.fEE());
          }
          ao.g(ao.this);
          ao.h(ao.this);
          localObject = (com.tencent.mm.ui.chatting.d.b.k)ao.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
          long l = ((Long)paramAnonymousView.getTag()).longValue();
          if (((com.tencent.mm.ui.chatting.d.b.k)localObject).fCk().contains(Long.valueOf(l)))
          {
            ao.i(ao.this).add(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dNa();
            paramAnonymousView.yCe += 1;
          }
          for (;;)
          {
            if (!((com.tencent.mm.ui.chatting.d.b.k)localObject).DR(l))
            {
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dNa();
              paramAnonymousView.yBY += 1;
            }
            ad.d("MicroMsg.recordSelect.RecordSelectComponent", "setOnEditModeItemClickListener msgId:%s", new Object[] { Long.valueOf(l) });
            ao.a(ao.this).OZ(ao.a((com.tencent.mm.ui.chatting.d.b.k)localObject));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194062);
            return;
            ao.i(ao.this).remove(Long.valueOf(l));
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dNa();
            paramAnonymousView.yCd += 1;
          }
        }
      });
      localk.fCm();
      localk.fCn();
      localk.fCl();
      if (fEA()) {
        ((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).a(this.JMa, true, d.a.JVh);
      }
    }
    AppMethodBeat.o(194066);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(194067);
    if (this.JLV)
    {
      d.bIY().bJb();
      this.JLU.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194059);
          ao.this.cWM.JOT.acV(ao.a(ao.this).getHeight());
          AppMethodBeat.o(194059);
        }
      });
    }
    AppMethodBeat.o(194067);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194069);
    if (!this.JLV)
    {
      AppMethodBeat.o(194069);
      return;
    }
    if (paramInt2 == 0)
    {
      ad.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(194069);
      return;
    }
    paramAbsListView = (com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    final a locala = new a();
    int i = this.cWM.getHeaderViewsCount();
    Object localObject1 = paramAbsListView.ada(paramInt1 - i);
    if (localObject1 != null) {
      locala.JMn = ((ei)localObject1).field_msgId;
    }
    localObject1 = ((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).ada(paramInt1 + 1 - i);
    if (localObject1 != null) {
      locala.JMo = ((ei)localObject1).field_msgId;
    }
    boolean bool1;
    long l1;
    label183:
    Object localObject2;
    label309:
    Object localObject3;
    if (this.JMc == null)
    {
      bool1 = true;
      boolean bool2 = this.JMd;
      long l2 = locala.JMn;
      long l3 = locala.JMo;
      if (this.JMc == null) {
        break label767;
      }
      l1 = this.JMc.JMn;
      ad.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll, first:%s showIntroduceView:%s firstVisibleItem:%s headerCount:%s visibleItemCount:%s totalItemCount:%s firstVisibleMsgId:%s secondVisibleMsgId:%s lastFirstVisibleMsgId:%s ifSlide:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(this.JMe) });
      localObject1 = paramAbsListView.fCk();
      localObject2 = paramAbsListView.fCi();
      if (!bool1) {
        break label789;
      }
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 < 0) {
        break label1379;
      }
      localObject3 = (bu)((SparseArray)localObject2).get(paramInt1);
      if ((localObject3 != null) && (((ei)localObject3).field_msgId >= locala.JMn) && (paramAbsListView.bE((bu)localObject3)) && (!this.JMh.contains(Long.valueOf(((ei)localObject3).field_msgId))))
      {
        if (((locala.JMo == -1L) || (((ei)localObject3).field_msgId <= locala.JMo)) && ((locala.JMo != -1L) || (((ei)localObject3).field_msgId <= locala.JMn))) {
          break label775;
        }
        paramAbsListView.DR(((ei)localObject3).field_msgId);
      }
    }
    for (;;)
    {
      paramInt1 -= 1;
      break label309;
      if (this.jua == null)
      {
        ad.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll totalItemCount:%s headerViewsCount:%s footerViewCount:%s totalCount:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(this.cWM.getHeaderViewsCount()), Integer.valueOf(this.cWM.bFG()), Integer.valueOf(paramAbsListView.fpw()) });
        if ((this.JMd) && (paramInt3 - this.cWM.getHeaderViewsCount() - this.cWM.bFG() == paramAbsListView.fpw()))
        {
          localObject1 = paramAbsListView.ada(0);
          if (((ei)localObject1).field_msgId != 0L)
          {
            localObject2 = a(paramAbsListView, ((ei)localObject1).field_msgId);
            if ((!((Boolean)((Pair)localObject2).first).booleanValue()) || (!((Boolean)((Pair)localObject2).second).booleanValue())) {
              break label665;
            }
            this.JMd = false;
          }
        }
        label606:
        if (!this.JMd) {
          break label742;
        }
        localObject1 = this.JLU;
        com.tencent.e.h.LTJ.aP(new RecordSelectTipsBar.2((RecordSelectTipsBar)localObject1));
      }
      for (;;)
      {
        this.cWM.getListView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194060);
            if (ao.b(ao.this) != null)
            {
              AppMethodBeat.o(194060);
              return;
            }
            ao.a(ao.this, ao.this.cWM.getListView().findViewById(2131308346));
            if (ao.b(ao.this) != null)
            {
              int i = ao.this.cWM.getListView().getHeight() - com.tencent.mm.cc.a.ay(ao.this.cWM.JOR.getContext(), 2131165292);
              int j = g.ajC().ajl().getInt(al.a.IJU, 0);
              if (((ao.this.fEA()) && (i != j)) || (!ao.this.fEA()))
              {
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)ao.b(ao.this).getLayoutParams();
                localLayoutParams.height = i;
                ao.b(ao.this).setLayoutParams(localLayoutParams);
                if (i != j) {
                  g.ajC().ajl().set(al.a.IJU, Integer.valueOf(localLayoutParams.height));
                }
                ad.i("MicroMsg.recordSelect.RecordSelectComponent", "update footView height:%s", new Object[] { Integer.valueOf(localLayoutParams.height) });
              }
            }
            AppMethodBeat.o(194060);
          }
        }, 300L);
        bool1 = false;
        break;
        label665:
        localObject1 = paramAbsListView.DS(((ei)localObject1).field_msgId);
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = (CheckBox)((View)localObject1).findViewById(2131298068);
        if (localObject1 == null) {}
        for (bool1 = true;; bool1 = false)
        {
          ad.d("MicroMsg.recordSelect.RecordSelectComponent", "checkBox is null(%s)", new Object[] { Boolean.valueOf(bool1) });
          if (localObject1 != null) {
            break;
          }
          this.JMd = false;
          break;
        }
        label742:
        this.JLU.OZ(a((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)));
      }
      label767:
      l1 = -1L;
      break label183;
      label775:
      a(paramAbsListView, ((ei)localObject3).field_msgId, true);
    }
    label789:
    if (locala.JMn < this.JMc.JMn)
    {
      paramInt1 = ((SparseArray)localObject2).size() - 1;
      if (paramInt1 >= 0)
      {
        localObject3 = (bu)((SparseArray)localObject2).get(paramInt1);
        if ((localObject3 != null) && (((ei)localObject3).field_msgId >= locala.JMn) && (paramAbsListView.bE((bu)localObject3)))
        {
          if (paramAbsListView.fCk().size() < 99) {
            break label910;
          }
          ad.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll max select msg num.(2)");
          if (localObject3 != null) {
            this.JMh.add(Long.valueOf(((ei)localObject3).field_msgId));
          }
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (((locala.JMo != -1L) && (((ei)localObject3).field_msgId > locala.JMo)) || ((locala.JMo == -1L) && (((ei)localObject3).field_msgId > locala.JMn)))
          {
            if ((!((Set)localObject1).contains(Long.valueOf(((ei)localObject3).field_msgId))) && (!this.JMh.contains(Long.valueOf(((ei)localObject3).field_msgId))))
            {
              paramAbsListView.DR(((ei)localObject3).field_msgId);
              if (!this.JMd) {
                this.JLU.OZ(a(paramAbsListView));
              }
              xW(true);
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
      if (locala.JMn > this.JMc.JMn)
      {
        localObject2 = ((Set)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          if (paramAbsListView.bE(DW(((Long)localObject3).longValue()))) {
            if (((Long)localObject3).longValue() < locala.JMn)
            {
              paramAbsListView.DR(((Long)localObject3).longValue());
              xW(false);
              if (!this.JMd) {
                this.JLU.OZ(a(paramAbsListView));
              }
            }
            else if ((((Long)localObject3).longValue() == locala.JMn) || (((Long)localObject3).longValue() == locala.JMo))
            {
              a(paramAbsListView, ((Long)localObject3).longValue(), false);
            }
          }
        }
      }
      if ((!this.JMh.contains(Long.valueOf(locala.JMn))) && (paramAbsListView.bE(DW(locala.JMn))))
      {
        if (paramAbsListView.fCk().size() >= 99) {
          this.JMh.add(Long.valueOf(locala.JMn));
        }
        a(paramAbsListView, locala.JMn, false);
      }
      if ((!this.JMh.contains(Long.valueOf(locala.JMo))) && (locala.JMo != -1L) && (paramAbsListView.bE(DW(locala.JMo))))
      {
        if (paramAbsListView.fCk().size() >= 99) {
          this.JMh.add(Long.valueOf(locala.JMo));
        }
        a(paramAbsListView, locala.JMo, false);
      }
    }
    label910:
    label1379:
    if (this.JMe)
    {
      localObject1 = this.JMh.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        if (locala.JMn > ((Long)localObject2).longValue())
        {
          this.JMh.remove(localObject2);
        }
        else if ((((Long)localObject2).longValue() == locala.JMn) || (((Long)localObject2).longValue() == locala.JMo))
        {
          localObject3 = a(paramAbsListView, ((Long)localObject2).longValue());
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
              this.JMh.remove(localObject2);
            }
          }
          else {
            ad.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll invalid");
          }
        }
      }
    }
    if (!this.JMg) {
      com.tencent.e.h.LTJ.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194061);
          if ((ao.c(ao.this) != 0) && (this.JMl.size() + 1 == ao.c(ao.this)))
          {
            if (((locala.JMn == ao.d(ao.this)) || (locala.JMo == ao.d(ao.this))) && (!this.JMl.contains(Long.valueOf(ao.d(ao.this)))))
            {
              ao.this.cWM.getListView().smoothScrollBy(-com.tencent.mm.cc.a.fromDPToPix(ao.this.cWM.JOR.getContext(), 5), 0);
              ad.i("MicroMsg.recordSelect.RecordSelectComponent", "slide below");
            }
            ao.e(ao.this);
          }
          AppMethodBeat.o(194061);
        }
      }, 500L);
    }
    this.JMc = locala;
    AppMethodBeat.o(194069);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(194070);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (!this.JLV)
    {
      AppMethodBeat.o(194070);
      return;
    }
    if ((!this.JMf) && (!fEA())) {
      com.tencent.mm.plugin.selectrecord.b.a.dNa().ze(fEE());
    }
    this.JMf = true;
    this.JMd = false;
    this.JMe = true;
    this.JLU.OZ(a((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)));
    ad.d("MicroMsg.recordSelect.RecordSelectComponent", "onScrollStateChanged ifSlide:%s", new Object[] { Boolean.valueOf(this.JMe) });
    AppMethodBeat.o(194070);
  }
  
  public final void qM(boolean paramBoolean)
  {
    AppMethodBeat.i(194073);
    ((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).qM(paramBoolean);
    AppMethodBeat.o(194073);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(194077);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.toString();; paramBundle = "null")
    {
      ad.i("MicroMsg.recordSelect.RecordSelectComponent", "doOnlySelectRecordMsg %s", new Object[] { paramBundle });
      this.JLW = false;
      this.cWM.JOR.fAX();
      AppMethodBeat.o(194077);
      return;
    }
  }
  
  static final class a
  {
    long JMn = -1L;
    long JMo = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ao
 * JD-Core Version:    0.7.0.1
 */