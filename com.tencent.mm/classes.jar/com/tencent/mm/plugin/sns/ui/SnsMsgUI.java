package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsMsgUI
  extends MMActivity
  implements f, b.b
{
  private long eCX;
  private int eez;
  private long fAA;
  private int fromScene;
  private String fsv;
  private ak handler;
  private n.d jSn;
  private View kxi;
  private View kxj;
  private boolean kxk;
  private ListView list;
  private com.tencent.matrix.trace.e.b mCa;
  private int[] myL;
  private View nTT;
  int rCZ;
  private an rFq;
  private SnsCmdList rHi;
  private bd rOH;
  private SnsMsgUI.a rSG;
  private boolean rSH;
  private boolean rSI;
  private boolean rSJ;
  private com.tencent.mm.ui.base.p rSK;
  private View.OnClickListener rSL;
  private k.a rSM;
  Runnable rSN;
  private long rSO;
  private long rSP;
  private int rSQ;
  private int rSR;
  private HashMap<Integer, j> rSS;
  private HashMap<Integer, Integer> rST;
  long rlV;
  
  public SnsMsgUI()
  {
    AppMethodBeat.i(39098);
    this.kxj = null;
    this.handler = ag.bEf();
    this.rSH = false;
    this.rSI = false;
    this.rHi = new SnsCmdList();
    this.kxk = false;
    this.rSJ = false;
    this.myL = new int[2];
    this.rSL = new SnsMsgUI.1(this);
    this.eCX = 0L;
    this.fAA = 0L;
    this.mCa = new SnsMsgUI.10(this);
    this.jSn = new SnsMsgUI.5(this);
    this.rSM = new SnsMsgUI.8(this);
    this.rSN = new SnsMsgUI.9(this);
    this.rSQ = 0;
    this.rSR = 0;
    this.rSS = new HashMap();
    this.rST = new HashMap();
    AppMethodBeat.o(39098);
  }
  
  private static String a(j paramj)
  {
    AppMethodBeat.i(145548);
    if (paramj.field_parentID == 0L)
    {
      paramj = i.lq(paramj.field_snsID);
      AppMethodBeat.o(145548);
      return paramj;
    }
    paramj = i.lq(paramj.field_parentID);
    AppMethodBeat.o(145548);
    return paramj;
  }
  
  private void cvC()
  {
    AppMethodBeat.i(39109);
    if (this.rSH)
    {
      AppMethodBeat.o(39109);
      return;
    }
    this.rSH = true;
    this.handler.postDelayed(this.rSN, 500L);
    AppMethodBeat.o(39109);
  }
  
  public final void ZU(String paramString)
  {
    AppMethodBeat.i(39106);
    this.rSG.notifyDataSetChanged();
    AppMethodBeat.o(39106);
  }
  
  public final void bp(String paramString, boolean paramBoolean) {}
  
  public final void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39107);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.rHi);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(39107);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(39107);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130970847;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39103);
    setMMTitle(2131303908);
    addTextOptionMenu(0, getString(2131296891), new SnsMsgUI.11(this));
    this.rFq = new an(this);
    this.nTT = findViewById(2131828040);
    this.list = ((ListView)findViewById(2131828039));
    this.kxi = w.hM(this).inflate(2130970845, null);
    this.kxj = w.hM(this).inflate(2130970164, null);
    ab.d("MicroMsg.SnsMsgUI", "autoLoad " + this.kxk);
    if (this.kxk)
    {
      this.list.addFooterView(this.kxj);
      this.rSG = new SnsMsgUI.a(this, this, new j());
      this.rSG.setGetViewPositionCallback(new SnsMsgUI.12(this));
      this.rSG.setPerformItemClickListener(new SnsMsgUI.13(this));
      this.rSG.b(new SnsMsgUI.14(this));
      this.rSG.a(new SnsMsgUI.15(this));
      this.list.setAdapter(this.rSG);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(39082);
          if (paramAnonymousInt == SnsMsgUI.e(SnsMsgUI.this).getCount())
          {
            if (ag.cpk().bbZ() > 0)
            {
              ag.cpk().bca();
              if (SnsMsgUI.e(SnsMsgUI.this).bem()) {
                paramAnonymousInt = 0;
              }
            }
            for (;;)
            {
              SnsMsgUI.e(SnsMsgUI.this).a(null, null);
              if (!SnsMsgUI.g(SnsMsgUI.this))
              {
                if (SnsMsgUI.f(SnsMsgUI.this).getParent() != null)
                {
                  ab.d("MicroMsg.SnsMsgUI", "remove footer");
                  SnsMsgUI.c(SnsMsgUI.this).removeFooterView(SnsMsgUI.f(SnsMsgUI.this));
                }
                if ((SnsMsgUI.h(SnsMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
                {
                  SnsMsgUI.c(SnsMsgUI.this).addFooterView(SnsMsgUI.h(SnsMsgUI.this));
                  ab.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                }
              }
              SnsMsgUI.i(SnsMsgUI.this);
              SnsMsgUI.f(SnsMsgUI.this).setVisibility(8);
              AppMethodBeat.o(39082);
              return;
              paramAnonymousInt = 1;
              continue;
              paramAnonymousInt = SnsMsgUI.e(SnsMsgUI.this).ben();
            }
          }
          paramAnonymousAdapterView = (j)SnsMsgUI.e(SnsMsgUI.this).getItem(paramAnonymousInt);
          SnsMsgUI.a(SnsMsgUI.this, paramAnonymousAdapterView);
          AppMethodBeat.o(39082);
        }
      });
      new l(this);
      this.list.setOnTouchListener(new SnsMsgUI.17(this));
      this.list.setOnItemLongClickListener(new SnsMsgUI.2(this));
      this.list.setOnScrollListener(new SnsMsgUI.3(this));
      if (this.rSG.getCount() != 0) {
        break label470;
      }
      this.list.setVisibility(8);
      this.nTT.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (((this.rSG.bem()) && (ag.cpk().bbZ() == 0)) || (ag.cpk().bbZ() == ag.cpk().cst())) {
        this.kxi.setVisibility(8);
      }
      if ((this.rSG.bem()) && (this.kxk)) {
        this.list.removeFooterView(this.kxj);
      }
      setBackBtn(new SnsMsgUI.4(this));
      if ((this.rSG.bem()) && (this.kxk)) {
        this.list.removeFooterView(this.kxj);
      }
      AppMethodBeat.o(39103);
      return;
      this.list.addFooterView(this.kxi);
      break;
      label470:
      this.list.setVisibility(0);
      this.nTT.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39105);
    ab.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(39105);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("result_finish", false)))
    {
      finish();
      AppMethodBeat.o(39105);
      return;
    }
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
      this.rHi.Dz(paramInt1);
    }
    AppMethodBeat.o(39105);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39099);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(210, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(683, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(218, this);
    this.fsv = com.tencent.mm.model.r.Zn();
    this.rOH = ag.coT();
    this.rSI = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
    if (this.rSI) {
      this.kxk = true;
    }
    ag.cpk().add(this.rSM);
    setActionbarColor(getActionbarColor());
    initView();
    this.rSO = bo.aoy();
    this.fromScene = getIntent().getIntExtra("sns_msg_comment_list_scene", 0);
    AppMethodBeat.o(39099);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(39104);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    j localj = (j)this.rSG.getItem(paramContextMenuInfo.position);
    if (localj == null)
    {
      AppMethodBeat.o(39104);
      return;
    }
    this.rCZ = localj.rCZ;
    this.rlV = localj.field_snsID;
    for (;;)
    {
      try
      {
        paramView = (cdm)new cdm().parseFrom(localj.field_curActionBuf);
        if (paramView != null)
        {
          ad localad = this.rOH.arw(paramView.xCG);
          if (localad == null) {
            continue;
          }
          paramView = localad.Of();
          paramContextMenu.setHeaderTitle(bo.nullAsNil(paramView));
          if (localj.field_isSilence != 0) {
            continue;
          }
          paramContextMenu.add(paramContextMenuInfo.position, 1, 1, getString(2131301960));
        }
      }
      catch (Exception paramView)
      {
        ab.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        continue;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, getString(2131296901));
      AppMethodBeat.o(39104);
      return;
      if (!bo.isNullOrNil(paramView.xNV))
      {
        paramView = paramView.xNV;
      }
      else
      {
        paramView = paramView.xCG;
        continue;
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, getString(2131301959));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39100);
    ab.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
    this.rSP = super.getActivityBrowseTimeMs();
    if (ag.cpk().bbZ() > 0) {
      ag.cpk().bca();
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(210, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(683, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(218, this);
    ag.cpk().remove(this.rSM);
    this.rSG.bKb();
    ag.cpc().ah(this);
    if (this.rSK != null)
    {
      this.rSK.dismiss();
      this.rSK = null;
    }
    long l = bo.yB();
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2 = this.rSS.values().iterator();
    int i = 0;
    Object localObject1;
    int m;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (j)((Iterator)localObject2).next();
      if (localObject1 == null) {
        break label674;
      }
      if (((j)localObject1).field_isRead == 1)
      {
        m = 1;
        label206:
        if (m != 0) {
          break label671;
        }
        if (((j)localObject1).field_type != 1) {
          break label313;
        }
        i += 1;
        label224:
        m = 0;
        if (this.rST.containsKey(Integer.valueOf(((j)localObject1).rCZ))) {
          m = ((Integer)this.rST.get(Integer.valueOf(((j)localObject1).rCZ))).intValue();
        }
        if (localObject1 != null) {
          break label329;
        }
        localObject1 = "";
        label278:
        if (localStringBuffer.length() <= 0) {
          break label471;
        }
        localStringBuffer.append(";").append((String)localObject1);
      }
    }
    label671:
    label674:
    for (;;)
    {
      k += 1;
      break;
      m = 0;
      break label206;
      label313:
      if (((j)localObject1).field_type == 2)
      {
        j += 1;
        break label224;
        label329:
        if (m == 0)
        {
          localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d}", new Object[] { a((j)localObject1), Integer.valueOf(((j)localObject1).rCZ), ((j)localObject1).field_talker, Integer.valueOf(((j)localObject1).field_type), Integer.valueOf(((j)localObject1).field_isSilence) });
          break label278;
        }
        localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d;\"click\":%d}", new Object[] { a((j)localObject1), Integer.valueOf(((j)localObject1).rCZ), ((j)localObject1).field_talker, Integer.valueOf(((j)localObject1).field_type), Integer.valueOf(((j)localObject1).field_isSilence), Integer.valueOf(m) });
        break label278;
        label471:
        localStringBuffer.append((String)localObject1);
        continue;
        localObject1 = new ao();
        localObject2 = ((ao)localObject1).bB(this.rSO);
        ((ao)localObject2).cSK = this.fromScene;
        ((ao)localObject2).cUJ = this.rSP;
        ((ao)localObject1).cUK = this.rSQ;
        ((ao)localObject1).cUL = this.rSR;
        ((ao)localObject1).cUI = j;
        ((ao)localObject1).cUH = i;
        ((ao)localObject1).fT("[" + localStringBuffer.toString() + "]");
        ((ao)localObject1).ake();
        this.rSS.clear();
        this.rST.clear();
        ab.i("MicroMsg.SnsMsgUI", "reportBrowseMsgListInfo debugLog [%d] cost[%d]", new Object[] { Integer.valueOf(k), Long.valueOf(bo.av(l)) });
        ab.d("MicroMsg.SnsMsgUI", "rpt %s", new Object[] { ((ao)localObject1).Fg() });
        super.onDestroy();
        AppMethodBeat.o(39100);
        return;
      }
      break label224;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39102);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.eez);
    this.eez = 0;
    ag.cpa().b(this);
    super.onPause();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
      if (localc != null) {
        localc.b(this.mCa);
      }
    }
    if (bo.aox() > this.fAA) {}
    for (long l = bo.aox() - this.fAA;; l = 1L)
    {
      this.fAA = l;
      WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.eCX, this.fAA);
      this.eCX = 0L;
      this.fAA = 0L;
      AppMethodBeat.o(39102);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39101);
    this.fAA = bo.aox();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
      if (localc != null) {
        localc.a(this.mCa);
      }
    }
    ag.cpa().a(this);
    super.onResume();
    AppMethodBeat.o(39101);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(39108);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof q)))
    {
      ab.d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
      cvC();
    }
    if (paramm.getType() == 218)
    {
      if (((com.tencent.mm.plugin.sns.model.r)paramm).type != 12)
      {
        AppMethodBeat.o(39108);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label124;
      }
      this.rSG.a(null, null);
      Toast.makeText(this, getString(2131301963), 0).show();
    }
    for (;;)
    {
      if (this.rSK != null)
      {
        this.rSK.dismiss();
        this.rSK = null;
      }
      AppMethodBeat.o(39108);
      return;
      label124:
      Toast.makeText(this, getString(2131301962), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI
 * JD-Core Version:    0.7.0.1
 */