package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.chatting.u.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ai.class)
public class as
  extends a
  implements ai
{
  public boolean JMA = false;
  public boolean JMB = false;
  private long JMC = -1L;
  private ArrayList<String> JMD;
  public boolean JME = false;
  private TextView JMF;
  private ListView JMG;
  private View JMH;
  private u JMI;
  public boolean JMJ = false;
  private boolean JMK = true;
  private int JML = 0;
  private boolean JMM = false;
  private View JMw;
  public boolean JMx = false;
  public boolean JMy = false;
  public boolean JMz = false;
  private r fSC = null;
  
  public final boolean DX(long paramLong)
  {
    AppMethodBeat.i(35550);
    if ((this.JMC == paramLong) && (this.JMA) && (this.JMD != null) && (this.JMD.size() > 0))
    {
      AppMethodBeat.o(35550);
      return true;
    }
    AppMethodBeat.o(35550);
    return false;
  }
  
  public final void adm(int paramInt)
  {
    AppMethodBeat.i(35553);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.JMJ), Boolean.valueOf(this.JMK) });
    if ((!this.JMx) && (!this.JMJ))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      AppMethodBeat.o(35553);
      return;
    }
    if ((this.JMK) && (paramInt >= 0))
    {
      this.JMK = false;
      g.yhR.f(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.JMG.setVisibility(0);
      this.cWM.acW(8);
      this.JMF.setVisibility(8);
      this.JMH.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    if (paramInt == 0)
    {
      this.JMG.setVisibility(8);
      this.cWM.acW(8);
      this.JMF.setVisibility(0);
      this.JMH.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    this.JMG.setVisibility(8);
    this.cWM.acW(0);
    this.JMF.setVisibility(8);
    this.JMH.setVisibility(0);
    AppMethodBeat.o(35553);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35555);
    super.fCC();
    this.JMM = true;
    if (this.JMI != null) {
      this.JMI.det();
    }
    if (this.fSC != null) {
      this.fSC.clearFocus();
    }
    AppMethodBeat.o(35555);
  }
  
  public final ArrayList<String> fEG()
  {
    return this.JMD;
  }
  
  public final boolean fEH()
  {
    return this.JMz;
  }
  
  public final void fEI()
  {
    AppMethodBeat.i(35551);
    if (this.JMw == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.JMJ = true;
      this.cWM.acW(8);
      if (this.JMw == null) {
        break;
      }
      this.JMw.setVisibility(0);
      if (this.JMI != null) {
        this.JMI.talker = this.cWM.getTalkerUserName();
      }
      adm(-1);
      AppMethodBeat.o(35551);
      return;
    }
    l.a(this.cWM.JOR, 2131304400);
    this.JMw = this.cWM.findViewById(2131304406);
    this.JMw.setVisibility(0);
    this.JMH = this.cWM.findViewById(2131304398);
    this.cWM.getListView().setFocusable(false);
    this.cWM.getListView().setFocusableInTouchMode(false);
    this.JMH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(35547);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(35547);
      }
    });
    this.JMH.setVisibility(8);
    this.JMF = ((TextView)this.cWM.findViewById(2131299470));
    if ((this.cWM.fFu()) || (((d)this.cWM.bh(d.class)).fCI())) {}
    for (bool = true;; bool = false)
    {
      this.JMI = new u(this.cWM.JOR.getContext(), new bu(), this.cWM.getTalkerUserName(), this.cWM.fFr(), bool);
      this.JMI.JCo = new u.a()
      {
        public final void acS(int paramAnonymousInt)
        {
          AppMethodBeat.i(35548);
          as.this.adm(paramAnonymousInt);
          AppMethodBeat.o(35548);
        }
      };
      this.JMG = ((ListView)this.cWM.findViewById(2131304399));
      this.JMG.setVisibility(0);
      this.JMG.setAdapter(this.JMI);
      this.JMG.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35549);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = (bu)as.d(as.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!bt.isNullOrNil(paramAnonymousAdapterView.field_talker)))
          {
            as.this.fEJ();
            ((com.tencent.mm.ui.chatting.d.b.l)as.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class)).bH(paramAnonymousAdapterView);
            if (!as.this.JME)
            {
              as.this.JME = true;
              as.this.cWM.JOT.setBottomViewVisible(true);
              as.this.cWM.JOS.fBV();
            }
            as.this.cWM.JOT.fBT();
            as.this.cWM.JOT.setIsBottomShowAll(false);
            ((k)as.this.cWM.bh(k.class)).a(paramAnonymousAdapterView.field_msgId, false, d.a.JVh);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35549);
        }
      });
      this.JMG.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35539);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          as.this.cWM.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/component/SearchComponent$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(35539);
          return false;
        }
      });
      break;
    }
  }
  
  public final void fEJ()
  {
    AppMethodBeat.i(35552);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.JMJ = false;
    this.JMK = true;
    if (this.JMF != null) {
      this.JMF.setVisibility(8);
    }
    if (this.JMH != null) {
      this.JMH.setVisibility(8);
    }
    if (this.JMG != null) {
      this.JMG.setVisibility(8);
    }
    this.cWM.acW(0);
    this.cWM.hideVKB();
    AppMethodBeat.o(35552);
  }
  
  public final boolean fEK()
  {
    return this.JMJ;
  }
  
  public final u fEL()
  {
    return this.JMI;
  }
  
  public final boolean fEM()
  {
    return this.JMy;
  }
  
  public final boolean fEN()
  {
    return this.JMx;
  }
  
  public final boolean fEO()
  {
    return this.JMA;
  }
  
  public final boolean fEP()
  {
    return this.JMB;
  }
  
  public final boolean fEQ()
  {
    return this.JME;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35556);
    this.JMx = this.cWM.JOR.getBooleanExtra("search_chat_content", false).booleanValue();
    this.JMy = this.cWM.JOR.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.JMD = this.cWM.JOR.getStringArrayList("highlight_keyword_list");
    this.JMC = this.cWM.JOR.getLongExtra("msg_local_id", -1L);
    this.JMA = this.cWM.JOR.getBooleanExtra("from_global_search", false).booleanValue();
    this.JMB = this.cWM.JOR.getBooleanExtra("from_date_search", false).booleanValue();
    this.JMz = this.cWM.JOR.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    AppMethodBeat.o(35556);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35557);
    if ((this.JMC >= 0L) && (!this.JMM)) {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35538);
          if (!as.a(as.this))
          {
            as.b(as.this);
            as.c(as.this);
            if (as.this.cWM != null) {
              as.this.cWM.bOo();
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
          AppMethodBeat.o(35538);
        }
      }, 2000L);
    }
    if (this.JMx)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      g.yhR.idkeyStat(219L, 11L, 1L, true);
      l.a(this.cWM.JOR, 2131304400);
      this.JMw = this.cWM.findViewById(2131304406);
      this.JMH = this.cWM.findViewById(2131304398);
      this.cWM.getListView().setFocusable(false);
      this.cWM.getListView().setFocusableInTouchMode(false);
      this.JMH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35540);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(35540);
        }
      });
      if (this.JMF == null)
      {
        l.a(this.cWM.JOR, 2131306442);
        this.JMF = ((TextView)this.cWM.findViewById(2131299470));
      }
      if ((!this.cWM.fFu()) && (!((d)this.cWM.bh(d.class)).fCI())) {
        break label445;
      }
    }
    label445:
    for (boolean bool = true;; bool = false)
    {
      this.JMI = new u(this.cWM.JOR.getContext(), new bu(), this.cWM.getTalkerUserName(), this.cWM.fFr(), bool);
      this.JMI.JCo = new u.a()
      {
        public final void acS(int paramAnonymousInt)
        {
          AppMethodBeat.i(35541);
          as.this.adm(paramAnonymousInt);
          AppMethodBeat.o(35541);
        }
      };
      this.JMG = ((ListView)this.cWM.findViewById(2131304399));
      this.JMG.setAdapter(this.JMI);
      this.JMG.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35542);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousView = (bu)as.d(as.this).getItem(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.field_talker)))
          {
            g.yhR.f(10450, new Object[] { Integer.valueOf(1) });
            paramAnonymousAdapterView = new Intent(as.this.cWM.JOR.getContext(), ChattingUI.class);
            paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.field_talker);
            paramAnonymousAdapterView.putExtra("finish_direct", true);
            paramAnonymousAdapterView.putExtra("show_search_chat_content_result", false);
            paramAnonymousAdapterView.putExtra("msg_local_id", paramAnonymousView.field_msgId);
            paramAnonymousAdapterView.putExtra("img_gallery_enter_from_chatting_ui", true);
            paramAnonymousView = as.this.cWM.JOR;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35542);
        }
      });
      this.JMG.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35543);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          as.this.cWM.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/component/SearchComponent$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(35543);
          return false;
        }
      });
      this.fSC = new r();
      this.fSC.KKQ = new r.b()
      {
        private int JMO = 0;
        
        public final boolean Jp(String paramAnonymousString)
        {
          return false;
        }
        
        public final void Jq(String paramAnonymousString)
        {
          AppMethodBeat.i(35545);
          if (bt.isNullOrNil(paramAnonymousString))
          {
            this.JMO = 0;
            as.this.adm(-1);
            AppMethodBeat.o(35545);
            return;
          }
          if (paramAnonymousString.length() > this.JMO) {
            g.yhR.f(10451, new Object[] { Integer.valueOf(1) });
          }
          this.JMO = paramAnonymousString.length();
          g.yhR.f(10456, new Object[] { Integer.valueOf(1) });
          as.d(as.this).Jo(paramAnonymousString);
          AppMethodBeat.o(35545);
        }
        
        public final void aSm()
        {
          AppMethodBeat.i(35546);
          new ap().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35544);
              as.this.cWM.JOR.fAX();
              AppMethodBeat.o(35544);
            }
          });
          AppMethodBeat.o(35546);
        }
        
        public final void aSn() {}
        
        public final void aSo() {}
        
        public final void aSp() {}
      };
      this.cWM.JOR.addSearchMenu(true, this.fSC);
      this.fSC.yC(true);
      if ((this.JMy) || (this.JMA) || (this.JMB))
      {
        long l = this.cWM.JOR.getLongExtra("msg_local_id", -1L);
        ((k)this.cWM.bh(k.class)).a(l, false, d.a.JVh);
      }
      AppMethodBeat.o(35557);
      return;
    }
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35558);
    if (this.JMJ)
    {
      fEJ();
      ((com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fDt();
    }
    AppMethodBeat.o(35558);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35554);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((k)this.cWM.bh(k.class)).isInEditMode()) && (this.JMJ)) {
      fEJ();
    }
    AppMethodBeat.o(35554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.as
 * JD-Core Version:    0.7.0.1
 */