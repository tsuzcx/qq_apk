package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ad;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.chatting.u.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.ae.class)
public class ao
  extends a
  implements com.tencent.mm.ui.chatting.c.b.ae
{
  private ListView HXA;
  private View HXB;
  private u HXC;
  public boolean HXD = false;
  private boolean HXE = true;
  private int HXF = 0;
  private boolean HXG = false;
  private View HXq;
  public boolean HXr = false;
  public boolean HXs = false;
  public boolean HXt = false;
  public boolean HXu = false;
  public boolean HXv = false;
  private long HXw = -1L;
  private ArrayList<String> HXx;
  public boolean HXy = false;
  private TextView HXz;
  private r fzp = null;
  
  public final boolean Bh(long paramLong)
  {
    AppMethodBeat.i(35550);
    if ((this.HXw == paramLong) && (this.HXu) && (this.HXx != null) && (this.HXx.size() > 0))
    {
      AppMethodBeat.o(35550);
      return true;
    }
    AppMethodBeat.o(35550);
    return false;
  }
  
  public final void aba(int paramInt)
  {
    AppMethodBeat.i(35553);
    ac.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.HXD), Boolean.valueOf(this.HXE) });
    if ((!this.HXr) && (!this.HXD))
    {
      ac.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      AppMethodBeat.o(35553);
      return;
    }
    if ((this.HXE) && (paramInt >= 0))
    {
      this.HXE = false;
      h.wUl.f(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.HXA.setVisibility(0);
      this.cLy.aaL(8);
      this.HXz.setVisibility(8);
      this.HXB.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    if (paramInt == 0)
    {
      this.HXA.setVisibility(8);
      this.cLy.aaL(8);
      this.HXz.setVisibility(0);
      this.HXB.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    this.HXA.setVisibility(8);
    this.cLy.aaL(0);
    this.HXz.setVisibility(8);
    this.HXB.setVisibility(0);
    AppMethodBeat.o(35553);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35556);
    this.HXr = this.cLy.HZF.getBooleanExtra("search_chat_content", false).booleanValue();
    this.HXs = this.cLy.HZF.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.HXx = this.cLy.HZF.getStringArrayList("highlight_keyword_list");
    this.HXw = this.cLy.HZF.getLongExtra("msg_local_id", -1L);
    this.HXu = this.cLy.HZF.getBooleanExtra("from_global_search", false).booleanValue();
    this.HXv = this.cLy.HZF.getBooleanExtra("from_date_search", false).booleanValue();
    this.HXt = this.cLy.HZF.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    AppMethodBeat.o(35556);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35557);
    if ((this.HXw >= 0L) && (!this.HXG)) {
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35538);
          if (!ao.a(ao.this))
          {
            ao.b(ao.this);
            ao.c(ao.this);
            if (ao.this.cLy != null) {
              ao.this.cLy.bJU();
            }
            ac.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
          AppMethodBeat.o(35538);
        }
      }, 2000L);
    }
    if (this.HXr)
    {
      ac.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      h.wUl.idkeyStat(219L, 11L, 1L, true);
      j.a(this.cLy.HZF, 2131304400);
      this.HXq = this.cLy.findViewById(2131304406);
      this.HXB = this.cLy.findViewById(2131304398);
      this.cLy.getListView().setFocusable(false);
      this.cLy.getListView().setFocusableInTouchMode(false);
      this.HXB.setOnClickListener(new ao.3(this));
      if (this.HXz == null)
      {
        j.a(this.cLy.HZF, 2131306442);
        this.HXz = ((TextView)this.cLy.findViewById(2131299470));
      }
      if ((!this.cLy.foP()) && (!((d)this.cLy.bf(d.class)).fmp())) {
        break label441;
      }
    }
    label441:
    for (boolean bool = true;; bool = false)
    {
      this.HXC = new u(this.cLy.HZF.getContext(), new bo(), this.cLy.getTalkerUserName(), this.cLy.foM(), bool);
      this.HXC.HOA = new u.a()
      {
        public final void aaI(int paramAnonymousInt)
        {
          AppMethodBeat.i(35541);
          ao.this.aba(paramAnonymousInt);
          AppMethodBeat.o(35541);
        }
      };
      this.HXA = ((ListView)this.cLy.findViewById(2131304399));
      this.HXA.setAdapter(this.HXC);
      this.HXA.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35542);
          paramAnonymousView = (bo)ao.d(ao.this).getItem(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!bs.isNullOrNil(paramAnonymousView.field_talker)))
          {
            h.wUl.f(10450, new Object[] { Integer.valueOf(1) });
            paramAnonymousAdapterView = new Intent(ao.this.cLy.HZF.getContext(), ChattingUI.class);
            paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.field_talker);
            paramAnonymousAdapterView.putExtra("finish_direct", true);
            paramAnonymousAdapterView.putExtra("show_search_chat_content_result", false);
            paramAnonymousAdapterView.putExtra("msg_local_id", paramAnonymousView.field_msgId);
            paramAnonymousAdapterView.putExtra("img_gallery_enter_from_chatting_ui", true);
            paramAnonymousView = ao.this.cLy.HZF;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(35542);
        }
      });
      this.HXA.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35543);
          ao.this.cLy.hideVKB();
          AppMethodBeat.o(35543);
          return false;
        }
      });
      this.fzp = new r();
      this.fzp.ITM = new r.b()
      {
        private int HXI = 0;
        
        public final boolean Ga(String paramAnonymousString)
        {
          return false;
        }
        
        public final void Gb(String paramAnonymousString)
        {
          AppMethodBeat.i(35545);
          if (bs.isNullOrNil(paramAnonymousString))
          {
            this.HXI = 0;
            ao.this.aba(-1);
            AppMethodBeat.o(35545);
            return;
          }
          if (paramAnonymousString.length() > this.HXI) {
            h.wUl.f(10451, new Object[] { Integer.valueOf(1) });
          }
          this.HXI = paramAnonymousString.length();
          h.wUl.f(10456, new Object[] { Integer.valueOf(1) });
          ao.d(ao.this).FZ(paramAnonymousString);
          AppMethodBeat.o(35545);
        }
        
        public final void aPa()
        {
          AppMethodBeat.i(35546);
          new com.tencent.mm.sdk.platformtools.ao().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35544);
              ao.this.cLy.HZF.fkI();
              AppMethodBeat.o(35544);
            }
          });
          AppMethodBeat.o(35546);
        }
        
        public final void aPb() {}
        
        public final void aPc() {}
        
        public final void aPd() {}
      };
      this.cLy.HZF.addSearchMenu(true, this.fzp);
      this.fzp.xO(true);
      if ((this.HXs) || (this.HXu) || (this.HXv))
      {
        long l = this.cLy.HZF.getLongExtra("msg_local_id", -1L);
        ((i)this.cLy.bf(i.class)).a(l, d.a.IeU);
      }
      AppMethodBeat.o(35557);
      return;
    }
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35558);
    if (this.HXD)
    {
      fof();
      ((com.tencent.mm.ui.chatting.c.b.j)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class)).fmV();
    }
    AppMethodBeat.o(35558);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35555);
    super.fmj();
    this.HXG = true;
    if (this.HXC != null) {
      this.HXC.cVi();
    }
    if (this.fzp != null) {
      this.fzp.clearFocus();
    }
    AppMethodBeat.o(35555);
  }
  
  public final ArrayList<String> foc()
  {
    return this.HXx;
  }
  
  public final boolean fod()
  {
    return this.HXt;
  }
  
  public final void foe()
  {
    AppMethodBeat.i(35551);
    if (this.HXq == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.HXD = true;
      this.cLy.aaL(8);
      if (this.HXq == null) {
        break;
      }
      this.HXq.setVisibility(0);
      if (this.HXC != null) {
        this.HXC.talker = this.cLy.getTalkerUserName();
      }
      aba(-1);
      AppMethodBeat.o(35551);
      return;
    }
    j.a(this.cLy.HZF, 2131304400);
    this.HXq = this.cLy.findViewById(2131304406);
    this.HXq.setVisibility(0);
    this.HXB = this.cLy.findViewById(2131304398);
    this.cLy.getListView().setFocusable(false);
    this.cLy.getListView().setFocusableInTouchMode(false);
    this.HXB.setOnClickListener(new ao.8(this));
    this.HXB.setVisibility(8);
    this.HXz = ((TextView)this.cLy.findViewById(2131299470));
    if ((this.cLy.foP()) || (((d)this.cLy.bf(d.class)).fmp())) {}
    for (bool = true;; bool = false)
    {
      this.HXC = new u(this.cLy.HZF.getContext(), new bo(), this.cLy.getTalkerUserName(), this.cLy.foM(), bool);
      this.HXC.HOA = new u.a()
      {
        public final void aaI(int paramAnonymousInt)
        {
          AppMethodBeat.i(35548);
          ao.this.aba(paramAnonymousInt);
          AppMethodBeat.o(35548);
        }
      };
      this.HXA = ((ListView)this.cLy.findViewById(2131304399));
      this.HXA.setVisibility(0);
      this.HXA.setAdapter(this.HXC);
      this.HXA.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35549);
          paramAnonymousAdapterView = (bo)ao.d(ao.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!bs.isNullOrNil(paramAnonymousAdapterView.field_talker)))
          {
            ao.this.fof();
            ((com.tencent.mm.ui.chatting.c.b.j)ao.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class)).bB(paramAnonymousAdapterView);
            if (!ao.this.HXy)
            {
              ao.this.HXy = true;
              ao.this.cLy.HZH.setBottomViewVisible(true);
              ao.this.cLy.HZG.flF();
            }
            ao.this.cLy.HZH.flD();
            ao.this.cLy.HZH.setIsBottomShowAll(false);
            ((i)ao.this.cLy.bf(i.class)).a(paramAnonymousAdapterView.field_msgId, d.a.IeU);
          }
          AppMethodBeat.o(35549);
        }
      });
      this.HXA.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35539);
          ao.this.cLy.hideVKB();
          AppMethodBeat.o(35539);
          return false;
        }
      });
      break;
    }
  }
  
  public final void fof()
  {
    AppMethodBeat.i(35552);
    ac.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.HXD = false;
    this.HXE = true;
    if (this.HXz != null) {
      this.HXz.setVisibility(8);
    }
    if (this.HXB != null) {
      this.HXB.setVisibility(8);
    }
    if (this.HXA != null) {
      this.HXA.setVisibility(8);
    }
    this.cLy.aaL(0);
    this.cLy.hideVKB();
    AppMethodBeat.o(35552);
  }
  
  public final boolean fog()
  {
    return this.HXD;
  }
  
  public final u foh()
  {
    return this.HXC;
  }
  
  public final boolean foi()
  {
    return this.HXs;
  }
  
  public final boolean foj()
  {
    return this.HXr;
  }
  
  public final boolean fok()
  {
    return this.HXu;
  }
  
  public final boolean fol()
  {
    return this.HXv;
  }
  
  public final boolean fom()
  {
    return this.HXy;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35554);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((i)this.cLy.bf(i.class)).isInEditMode()) && (this.HXD)) {
      fof();
    }
    AppMethodBeat.o(35554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ao
 * JD-Core Version:    0.7.0.1
 */