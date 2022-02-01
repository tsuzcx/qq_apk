package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.a.a;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.conversation.presenter.a.b;
import java.util.HashMap;

public class EnterpriseConversationUI
  extends BaseBizConversationUI
{
  private View contentView;
  
  public void finish()
  {
    AppMethodBeat.i(38587);
    if ((this.conversationFm != null) && ((this.conversationFm instanceof EnterpriseConversationFmUI))) {
      ((EnterpriseConversationFmUI)this.conversationFm).jmU = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
    AppMethodBeat.o(38587);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38586);
    super.onCreate(paramBundle);
    this.contentView = aa.jQ(this).inflate(2131493308, null);
    setContentView(this.contentView);
    this.conversationFm = new EnterpriseConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131304736, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.h.a(this, this.contentView);
    AppMethodBeat.o(38586);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class EnterpriseConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements MStorageEx.IOnStorageChange
  {
    private LinearLayout PaK;
    private int PaN;
    private e.a PaR;
    private ListView Qbt;
    private String Qbv;
    private View Qfb;
    private l Qfc;
    private String Qfd;
    private MMHandler Qfe;
    private int Qff;
    private String Qfg;
    private com.tencent.mm.ui.conversation.presenter.a Qfh;
    private com.tencent.mm.ui.conversation.presenter.c Qfi;
    private TextView emptyTipTv;
    private long enterTime;
    private int fromScene;
    private String iNV;
    long jmU;
    private long oJs;
    
    public EnterpriseConversationFmUI()
    {
      AppMethodBeat.i(38568);
      this.PaK = null;
      this.Qfb = null;
      this.Qfd = null;
      this.PaN = 0;
      this.enterTime = 0L;
      this.jmU = 0L;
      this.Qff = -2;
      this.oJs = 0L;
      this.Qfg = null;
      this.PaR = new e.a()
      {
        public final void a(e.a.a paramAnonymousa)
        {
          AppMethodBeat.i(234162);
          if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.iNV)) && (paramAnonymousa.iNV.equals(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this))))
          {
            int i = EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this, com.tencent.mm.ui.h.cy(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)));
            if (EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this) != i) {
              EnterpriseConversationUI.EnterpriseConversationFmUI.k(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            }
          }
          AppMethodBeat.o(234162);
        }
      };
      AppMethodBeat.o(38568);
    }
    
    private void gLZ()
    {
      AppMethodBeat.i(38574);
      this.PaN = com.tencent.mm.ui.h.cy(getContext(), this.iNV);
      Object localObject1;
      int i;
      Object localObject2;
      if ((this.PaN == 2) && (this.PaK == null))
      {
        this.PaK = ((LinearLayout)findViewById(2131297662));
        localObject1 = this.PaK.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.aG(getContext(), 2131165260);
        this.PaK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Qfb = aa.jQ(getContext()).inflate(2131494004, this.PaK, false);
        float f = com.tencent.mm.cb.a.ez(getContext());
        localObject1 = (CdnImageView)this.Qfb.findViewById(2131302497);
        i = ((CdnImageView)localObject1).getLayoutParams().height;
        ((CdnImageView)localObject1).getLayoutParams().height = ((int)(i * f));
        ((CdnImageView)localObject1).getLayoutParams().width = ((int)(f * i));
        ((CdnImageView)localObject1).requestLayout();
        localObject2 = (TextView)this.Qfb.findViewById(2131309249);
        ag.bar();
        ag.bar();
        String str = e.sM(0);
        if ((str == null) || (str.length() <= 0)) {
          break label342;
        }
        ((TextView)localObject2).setText(str);
      }
      for (;;)
      {
        ag.bar();
        i = e.aZC();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        ag.bar();
        localObject2 = e.aZB();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((CdnImageView)localObject1).setUrl((String)localObject2);
        }
        com.tencent.mm.ui.h.aQ(this.iNV, 1, 2);
        this.PaK.addView(this.Qfb);
        this.Qfb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38560);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.ui.h.s(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), 3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38560);
          }
        });
        com.tencent.mm.ui.h.r(getContext(), this.iNV, 3);
        com.tencent.mm.ui.h.cz(getContext(), this.iNV);
        if (this.PaK == null) {
          break label362;
        }
        if (this.PaN != 2) {
          break;
        }
        this.PaK.setVisibility(0);
        gVQ();
        AppMethodBeat.o(38574);
        return;
        label342:
        ((TextView)localObject2).setText(2131758750);
      }
      this.PaK.setVisibility(8);
      label362:
      AppMethodBeat.o(38574);
    }
    
    private void gVQ()
    {
      AppMethodBeat.i(38575);
      com.tencent.mm.al.d locald = ag.bar().MO(this.iNV);
      int i;
      int j;
      label40:
      long l1;
      if (locald != null)
      {
        i = locald.field_qyUin;
        if (locald == null) {
          break label190;
        }
        j = locald.field_userUin;
        if (locald == null) {
          break label195;
        }
        l1 = locald.field_wwCorpId;
        label51:
        if (locald == null) {
          break label200;
        }
      }
      label190:
      label195:
      label200:
      for (long l2 = locald.field_wwUserVid;; l2 = 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        Log.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        AppMethodBeat.o(38575);
        return;
        i = 0;
        break;
        j = 0;
        break label40;
        l1 = 0L;
        break label51;
      }
    }
    
    public int getLayoutId()
    {
      return 2131494003;
    }
    
    public String getUserName()
    {
      return this.iNV;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(38569);
      super.onActivityCreated(paramBundle);
      this.iNV = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      this.Qbv = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
      setMMTitle(this.Qbv);
      this.Qbt = ((ListView)findViewById(2131309254));
      this.emptyTipTv = ((TextView)findViewById(2131300096));
      this.emptyTipTv.setText(2131758736);
      setBackBtn(new EnterpriseConversationUI.EnterpriseConversationFmUI.1(this));
      setToTop(new EnterpriseConversationUI.EnterpriseConversationFmUI.8(this));
      if (com.tencent.mm.al.g.fJ(this.iNV) != null)
      {
        gLZ();
        if (this.iNV != null)
        {
          paramBundle = new EnterpriseConversationUI.EnterpriseConversationFmUI.9(this);
          ag.bar();
          e.a(this.iNV, paramBundle);
          Log.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.iNV });
          addIconOptionMenu(1, 2131766796, 2131689496, new EnterpriseConversationUI.EnterpriseConversationFmUI.11(this));
          addIconOptionMenu(2, 2131755152, 2131689491, new com.tencent.mm.ui.conversation.presenter.b(this.ui, this.iNV));
          this.Qfc = new l(thisActivity(), this.iNV, new EnterpriseConversationUI.EnterpriseConversationFmUI.12(this));
          paramBundle = this.Qfc;
          Object localObject = new MMSlideDelView.c()
          {
            public final int dr(View paramAnonymousView)
            {
              AppMethodBeat.i(234164);
              int i = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getPositionForView(paramAnonymousView);
              AppMethodBeat.o(234164);
              return i;
            }
          };
          paramBundle.Qgf.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle.Qgg.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle = this.Qfc;
          localObject = new MMSlideDelView.g()
          {
            public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(234165);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(234165);
            }
          };
          paramBundle.Qgf.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle.Qgg.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle = this.Qfc;
          localObject = new MMSlideDelView.f()
          {
            public final void cZ(Object paramAnonymousObject)
            {
              AppMethodBeat.i(234166);
              if (paramAnonymousObject == null)
              {
                Log.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                AppMethodBeat.o(234166);
                return;
              }
              paramAnonymousObject = paramAnonymousObject.toString();
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousObject);
              AppMethodBeat.o(234166);
            }
          };
          paramBundle.Qgf.a((MMSlideDelView.f)localObject);
          paramBundle.Qgg.a((MMSlideDelView.f)localObject);
          this.Qbt.setAdapter(this.Qfc);
          this.Qbt.setOnItemClickListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.2(this));
          paramBundle = new Point();
          this.Qbt.setOnTouchListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.4(this, paramBundle));
          this.Qbt.setOnItemLongClickListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.5(this, paramBundle));
        }
      }
      else
      {
        this.enterTime = (System.currentTimeMillis() / 1000L);
        bg.aVF();
        paramBundle = com.tencent.mm.model.c.aST().bjY(this.iNV);
        if (paramBundle != null)
        {
          this.Qff = paramBundle.field_unReadCount;
          if ((this.Qff == 0) && (paramBundle.field_unReadMuteCount > 0)) {
            this.Qff = -1;
          }
          this.oJs = (paramBundle.field_conversationTime / 1000L);
          if (paramBundle.field_isSend != 1) {
            break label608;
          }
          paramBundle = null;
          label504:
          this.Qfg = paramBundle;
        }
        ag.bar().a(this.PaR, thisActivity().getMainLooper());
        bg.aVF();
        com.tencent.mm.model.c.aST().add(this);
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(this);
        if (this.Qfc != null)
        {
          if (this.Qfe != null) {
            break label616;
          }
          this.Qfe = new EnterpriseConversationUI.EnterpriseConversationFmUI.6(this);
        }
      }
      for (;;)
      {
        this.Qfe.sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(38569);
        return;
        Log.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
        break;
        label608:
        paramBundle = paramBundle.field_digestUser;
        break label504;
        label616:
        this.Qfe.removeMessages(1);
      }
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(38573);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(38573);
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("be_send_card_name");
        String str2 = paramIntent.getStringExtra("received_card_name");
        boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        com.tencent.mm.plugin.messenger.a.g.eir().s(str1, str2, bool);
        com.tencent.mm.plugin.messenger.a.g.eir().iF(paramIntent, str2);
        com.tencent.mm.ui.widget.snackbar.b.r(thisActivity(), getContext().getString(2131760708));
        AppMethodBeat.o(38573);
        return;
      }
      AppMethodBeat.o(38573);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38570);
      ag.bar().a(this.PaR);
      if (bg.aAc())
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().remove(this);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(this);
      }
      if (this.Qfc != null)
      {
        localObject = this.Qfc;
        j localj = ((l)localObject).Qgf;
        localj.Qca.stopTimer();
        if (localj.Pax != null)
        {
          localj.Pax.clear();
          localj.Pax = null;
        }
        localj.ebf();
        localj.gGV();
        bg.aVF();
        com.tencent.mm.model.c.aST().remove(localj);
        ((l)localObject).Qgg.onDestroy();
      }
      if (this.Qfi != null)
      {
        localObject = this.Qfi;
        bg.azz().b(1394, (i)localObject);
      }
      if ((this.enterTime <= 0L) || (this.jmU <= 0L))
      {
        super.onDestroy();
        AppMethodBeat.o(38570);
        return;
      }
      long l = this.jmU - this.enterTime;
      Object localObject = ag.bar().MO(this.iNV);
      int i;
      if (localObject != null)
      {
        i = ((com.tencent.mm.al.d)localObject).field_qyUin;
        label216:
        if (localObject == null) {
          break label337;
        }
      }
      label337:
      for (int j = ((com.tencent.mm.al.d)localObject).field_userUin;; j = 0)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        Log.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        break;
        i = 0;
        break label216;
      }
    }
    
    public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
    
    public void onPause()
    {
      AppMethodBeat.i(38572);
      Log.v("MicroMsg.EnterpriseConversationUI", "on pause");
      bg.aVF();
      com.tencent.mm.model.c.aST().bka(this.iNV);
      if (this.Qfc != null)
      {
        l locall = this.Qfc;
        locall.Qgf.onPause();
        locall.Qgg.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38572);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38571);
      Log.v("MicroMsg.EnterpriseConversationUI", "on resume");
      Object localObject;
      if (this.Qfh != null)
      {
        localObject = this.Qfh;
        if (0L != ((com.tencent.mm.ui.conversation.presenter.a)localObject).QiZ)
        {
          if (((com.tencent.mm.ui.conversation.presenter.a)localObject).QiY != null) {
            ((com.tencent.mm.ui.conversation.presenter.a)localObject).QiY.NW(((com.tencent.mm.ui.conversation.presenter.a)localObject).QiZ);
          }
          ((com.tencent.mm.ui.conversation.presenter.a)localObject).QiZ = 0L;
        }
      }
      if (this.Qfc != null)
      {
        localObject = this.Qfc;
        ((l)localObject).Qgf.onResume();
        ((l)localObject).Qgg.onResume();
      }
      super.onResume();
      if (!ab.IS(this.iNV)) {
        finish();
      }
      AppMethodBeat.o(38571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI
 * JD-Core Version:    0.7.0.1
 */