package com.tencent.mm.plugin.sns.ui;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.e.d;
import com.tencent.mm.ah.f;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public class SnsMsgUI
  extends DrawStatusBarActivity
  implements f, b.b
{
  private long dFe = 0L;
  private int dmY;
  private String ece;
  private long ekk = 0L;
  private n.d hZq = new SnsMsgUI.5(this);
  private ah handler = af.aXq();
  private View iwe;
  private View iwf = null;
  private boolean iwg = false;
  private com.tencent.matrix.trace.c.a kho = new SnsMsgUI.10(this);
  private ListView lwE;
  private View lwG;
  int oLo;
  private an oNH;
  private SnsCmdList oPw = new SnsCmdList();
  private bd oWj;
  long oxb;
  private SnsMsgUI.a pah;
  private boolean pai = false;
  private boolean paj = false;
  private boolean pak = false;
  private com.tencent.mm.ui.base.p pal;
  private int[] pam = new int[2];
  private View.OnClickListener pan = new SnsMsgUI.1(this);
  private j.a pao = new SnsMsgUI.8(this);
  Runnable pap = new SnsMsgUI.9(this);
  
  public final void Ni(String paramString)
  {
    this.pah.notifyDataSetChanged();
  }
  
  public final void bCt() {}
  
  public final void ba(String paramString, boolean paramBoolean) {}
  
  public final void bb(String paramString, boolean paramBoolean) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.oPw);
      setResult(-1, paramKeyEvent);
      finish();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_msg_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(i.j.sns_msgui_title);
    addTextOptionMenu(0, getString(i.j.app_clear), new SnsMsgUI.11(this));
    this.oNH = new an(this);
    this.lwG = findViewById(i.f.sns_msg_empty_view);
    this.lwE = ((ListView)findViewById(i.f.sns_msg_list));
    this.iwe = com.tencent.mm.ui.y.gt(this).inflate(i.g.sns_msg_footer, null);
    this.iwf = com.tencent.mm.ui.y.gt(this).inflate(i.g.mm_footerview, null);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsMsgUI", "autoLoad " + this.iwg);
    if (this.iwg)
    {
      this.lwE.addFooterView(this.iwf);
      this.pah = new SnsMsgUI.a(this, this, new com.tencent.mm.plugin.sns.storage.j());
      this.pah.setGetViewPositionCallback(new SnsMsgUI.12(this));
      this.pah.setPerformItemClickListener(new SnsMsgUI.13(this));
      this.pah.b(new SnsMsgUI.14(this));
      this.pah.uMi = new SnsMsgUI.15(this);
      this.lwE.setAdapter(this.pah);
      this.lwE.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (paramAnonymousInt == SnsMsgUI.e(SnsMsgUI.this).getCount())
          {
            if (af.bDK().aAo() > 0)
            {
              af.bDK().aAp();
              if (SnsMsgUI.e(SnsMsgUI.this).aCc()) {
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
                  com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsMsgUI", "remove footer");
                  SnsMsgUI.c(SnsMsgUI.this).removeFooterView(SnsMsgUI.f(SnsMsgUI.this));
                }
                if ((SnsMsgUI.h(SnsMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
                {
                  SnsMsgUI.c(SnsMsgUI.this).addFooterView(SnsMsgUI.h(SnsMsgUI.this));
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                }
              }
              SnsMsgUI.i(SnsMsgUI.this);
              SnsMsgUI.f(SnsMsgUI.this).setVisibility(8);
              return;
              paramAnonymousInt = 1;
              continue;
              paramAnonymousInt = SnsMsgUI.e(SnsMsgUI.this).aCd();
            }
          }
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.storage.j)SnsMsgUI.e(SnsMsgUI.this).getItem(paramAnonymousInt);
          SnsMsgUI.a(SnsMsgUI.this, paramAnonymousAdapterView);
        }
      });
      new com.tencent.mm.ui.tools.j(this);
      this.lwE.setOnTouchListener(new SnsMsgUI.17(this));
      this.lwE.setOnItemLongClickListener(new SnsMsgUI.2(this));
      this.lwE.setOnScrollListener(new SnsMsgUI.3(this));
      if (this.pah.getCount() != 0) {
        break label457;
      }
      this.lwE.setVisibility(8);
      this.lwG.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (((this.pah.aCc()) && (af.bDK().aAo() == 0)) || (af.bDK().aAo() == af.bDK().bGq())) {
        this.iwe.setVisibility(8);
      }
      if ((this.pah.aCc()) && (this.iwg)) {
        this.lwE.removeFooterView(this.iwf);
      }
      setBackBtn(new SnsMsgUI.4(this));
      if ((this.pah.aCc()) && (this.iwg)) {
        this.lwE.removeFooterView(this.iwf);
      }
      return;
      this.lwE.addFooterView(this.iwe);
      break;
      label457:
      this.lwE.setVisibility(0);
      this.lwG.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {}
    do
    {
      return;
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("result_finish", false)))
      {
        finish();
        return;
      }
    } while (paramIntent == null);
    paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
    this.oPw.xz(paramInt1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(210, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(683, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(218, this);
    this.ece = com.tencent.mm.model.q.Gj();
    this.oWj = af.bDt();
    this.paj = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
    if (this.paj) {
      this.iwg = true;
    }
    af.bDK().c(this.pao);
    ta(this.mController.czv());
    initView();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    com.tencent.mm.plugin.sns.storage.j localj = (com.tencent.mm.plugin.sns.storage.j)this.pah.getItem(paramContextMenuInfo.position);
    if (localj == null) {
      return;
    }
    this.oLo = localj.oLo;
    this.oxb = localj.field_snsID;
    for (;;)
    {
      try
      {
        paramView = (bsx)new bsx().aH(localj.field_curActionBuf);
        if (paramView != null)
        {
          ad localad = this.oWj.abl(paramView.tAY);
          if (localad == null) {
            continue;
          }
          paramView = localad.Bq();
          paramContextMenu.setHeaderTitle(bk.pm(paramView));
          if (localj.field_isSilence != 0) {
            continue;
          }
          paramContextMenu.add(paramContextMenuInfo.position, 1, 1, getString(i.j.notification_sns_msg_not_remind));
        }
      }
      catch (Exception paramView)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        continue;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, getString(i.j.app_delete));
      return;
      if (!bk.bl(paramView.tJr))
      {
        paramView = paramView.tJr;
      }
      else
      {
        paramView = paramView.tAY;
        continue;
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, getString(i.j.notification_sns_msg_do_remind));
      }
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
    af.bDK().aAp();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(210, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(683, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(218, this);
    af.bDK().d(this.pao);
    this.pah.bcS();
    af.bDC().M(this);
    if (this.pal != null)
    {
      this.pal.dismiss();
      this.pal = null;
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSNSMsgScrollEnable, this.dmY);
    this.dmY = 0;
    af.bDA().b(this);
    super.onPause();
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.b(this.kho);
    if (bk.UX() > this.ekk) {}
    for (long l = bk.UX() - this.ekk;; l = 1L)
    {
      this.ekk = l;
      WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.dFe, this.ekk);
      this.dFe = 0L;
      this.ekk = 0L;
      return;
    }
  }
  
  public void onResume()
  {
    this.ekk = bk.UX();
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.a(this.kho);
    af.bDA().a(this);
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.sns.model.q)))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
      if (!this.pai) {}
    }
    for (;;)
    {
      return;
      this.pai = true;
      this.handler.postDelayed(this.pap, 500L);
      if ((paramm.getType() == 218) && (((r)paramm).type == 12))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.pah.a(null, null);
          Toast.makeText(this, getString(i.j.notification_sns_msg_set_suc), 0).show();
        }
        while (this.pal != null)
        {
          this.pal.dismiss();
          this.pal = null;
          return;
          Toast.makeText(this, getString(i.j.notification_sns_msg_set_failed), 0).show();
        }
      }
    }
  }
  
  final class a$a
  {
    long eAA;
    View hZl;
    TextView hZm;
    TextView igx;
    TextView mYa;
    MMImageView paA;
    ImageView paB;
    ImageView paw;
    TextView pax;
    ImageView pay;
    TextView paz;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI
 * JD-Core Version:    0.7.0.1
 */