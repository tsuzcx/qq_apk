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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.chatting.v.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(fJv=aj.class)
public class at
  extends a
  implements aj
{
  private ArrayList<String> KhA;
  public boolean KhB = false;
  private TextView KhC;
  private ListView KhD;
  private View KhE;
  private v KhF;
  public boolean KhG = false;
  private boolean KhH = true;
  private int KhI = 0;
  private boolean KhJ = false;
  private View Kht;
  public boolean Khu = false;
  public boolean Khv = false;
  public boolean Khw = false;
  public boolean Khx = false;
  public boolean Khy = false;
  private long Khz = -1L;
  private r fUI = null;
  
  public final boolean Ew(long paramLong)
  {
    AppMethodBeat.i(35550);
    if ((this.Khz == paramLong) && (this.Khx) && (this.KhA != null) && (this.KhA.size() > 0))
    {
      AppMethodBeat.o(35550);
      return true;
    }
    AppMethodBeat.o(35550);
    return false;
  }
  
  public final void adT(int paramInt)
  {
    AppMethodBeat.i(35553);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.KhG), Boolean.valueOf(this.KhH) });
    if ((!this.Khu) && (!this.KhG))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      AppMethodBeat.o(35553);
      return;
    }
    if ((this.KhH) && (paramInt >= 0))
    {
      this.KhH = false;
      g.yxI.f(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.KhD.setVisibility(0);
      this.cXJ.adE(8);
      this.KhC.setVisibility(8);
      this.KhE.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    if (paramInt == 0)
    {
      this.KhD.setVisibility(8);
      this.cXJ.adE(8);
      this.KhC.setVisibility(0);
      this.KhE.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    this.KhD.setVisibility(8);
    this.cXJ.adE(0);
    this.KhC.setVisibility(8);
    this.KhE.setVisibility(0);
    AppMethodBeat.o(35553);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35556);
    this.Khu = this.cXJ.Kkd.getBooleanExtra("search_chat_content", false).booleanValue();
    this.Khv = this.cXJ.Kkd.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.KhA = this.cXJ.Kkd.getStringArrayList("highlight_keyword_list");
    this.Khz = this.cXJ.Kkd.getLongExtra("msg_local_id", -1L);
    this.Khx = this.cXJ.Kkd.getBooleanExtra("from_global_search", false).booleanValue();
    this.Khy = this.cXJ.Kkd.getBooleanExtra("from_date_search", false).booleanValue();
    this.Khw = this.cXJ.Kkd.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    AppMethodBeat.o(35556);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35557);
    if ((this.Khz >= 0L) && (!this.KhJ)) {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35538);
          if (!at.a(at.this))
          {
            at.b(at.this);
            at.c(at.this);
            if (at.this.cXJ != null) {
              at.this.cXJ.bPl();
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
          AppMethodBeat.o(35538);
        }
      }, 2000L);
    }
    if (this.Khu)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      g.yxI.idkeyStat(219L, 11L, 1L, true);
      l.a(this.cXJ.Kkd, 2131304400);
      this.Kht = this.cXJ.findViewById(2131304406);
      this.KhE = this.cXJ.findViewById(2131304398);
      this.cXJ.getListView().setFocusable(false);
      this.cXJ.getListView().setFocusableInTouchMode(false);
      this.KhE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35540);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(35540);
        }
      });
      if (this.KhC == null)
      {
        l.a(this.cXJ.Kkd, 2131306442);
        this.KhC = ((TextView)this.cXJ.findViewById(2131299470));
      }
      if ((!this.cXJ.fJB()) && (!((d)this.cXJ.bh(d.class)).fGK())) {
        break label442;
      }
    }
    label442:
    for (boolean bool = true;; bool = false)
    {
      this.KhF = new v(this.cXJ.Kkd.getContext(), new bv(), this.cXJ.getTalkerUserName(), this.cXJ.fJy(), bool);
      this.KhF.JXf = new v.a()
      {
        public final void adA(int paramAnonymousInt)
        {
          AppMethodBeat.i(35541);
          at.this.adT(paramAnonymousInt);
          AppMethodBeat.o(35541);
        }
      };
      this.KhD = ((ListView)this.cXJ.findViewById(2131304399));
      this.KhD.setAdapter(this.KhF);
      this.KhD.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35542);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousView = (bv)at.d(at.this).getItem(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!bu.isNullOrNil(paramAnonymousView.field_talker)))
          {
            g.yxI.f(10450, new Object[] { Integer.valueOf(1) });
            paramAnonymousAdapterView = new Intent(at.this.cXJ.Kkd.getContext(), ChattingUI.class);
            paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.field_talker);
            paramAnonymousAdapterView.putExtra("finish_direct", true);
            paramAnonymousAdapterView.putExtra("show_search_chat_content_result", false);
            paramAnonymousAdapterView.putExtra("msg_local_id", paramAnonymousView.field_msgId);
            paramAnonymousAdapterView.putExtra("img_gallery_enter_from_chatting_ui", true);
            paramAnonymousView = at.this.cXJ.Kkd;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahE(), "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35542);
        }
      });
      this.KhD.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35543);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          at.this.cXJ.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/component/SearchComponent$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(35543);
          return false;
        }
      });
      this.fUI = new r();
      this.fUI.Lhk = new r.b()
      {
        private int KhL = 0;
        
        public final boolean JO(String paramAnonymousString)
        {
          return false;
        }
        
        public final void JP(String paramAnonymousString)
        {
          AppMethodBeat.i(35545);
          if (bu.isNullOrNil(paramAnonymousString))
          {
            this.KhL = 0;
            at.this.adT(-1);
            AppMethodBeat.o(35545);
            return;
          }
          if (paramAnonymousString.length() > this.KhL) {
            g.yxI.f(10451, new Object[] { Integer.valueOf(1) });
          }
          this.KhL = paramAnonymousString.length();
          g.yxI.f(10456, new Object[] { Integer.valueOf(1) });
          at.d(at.this).JN(paramAnonymousString);
          AppMethodBeat.o(35545);
        }
        
        public final void aSL()
        {
          AppMethodBeat.i(35546);
          new aq().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35544);
              at.this.cXJ.Kkd.fEZ();
              AppMethodBeat.o(35544);
            }
          });
          AppMethodBeat.o(35546);
        }
        
        public final void aSM() {}
        
        public final void aSN() {}
        
        public final void aSO() {}
      };
      this.cXJ.Kkd.addSearchMenu(true, this.fUI);
      this.fUI.yP(true);
      if ((this.Khv) || (this.Khx) || (this.Khy))
      {
        long l = this.cXJ.Kkd.getLongExtra("msg_local_id", -1L);
        ((k)this.cXJ.bh(k.class)).a(l, false, d.a.Krz);
      }
      AppMethodBeat.o(35557);
      return;
    }
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35558);
    if (this.KhG)
    {
      fIM();
      ((com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fHw();
    }
    AppMethodBeat.o(35558);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35555);
    super.fGE();
    this.KhJ = true;
    if (this.KhF != null) {
      this.KhF.dhl();
    }
    if (this.fUI != null) {
      this.fUI.clearFocus();
    }
    AppMethodBeat.o(35555);
  }
  
  public final ArrayList<String> fIK()
  {
    return this.KhA;
  }
  
  public final void fIL()
  {
    AppMethodBeat.i(35551);
    if (this.Kht == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.KhG = true;
      this.cXJ.adE(8);
      if (this.Kht == null) {
        break;
      }
      this.Kht.setVisibility(0);
      if (this.KhF != null) {
        this.KhF.talker = this.cXJ.getTalkerUserName();
      }
      adT(-1);
      AppMethodBeat.o(35551);
      return;
    }
    l.a(this.cXJ.Kkd, 2131304400);
    this.Kht = this.cXJ.findViewById(2131304406);
    this.Kht.setVisibility(0);
    this.KhE = this.cXJ.findViewById(2131304398);
    this.cXJ.getListView().setFocusable(false);
    this.cXJ.getListView().setFocusableInTouchMode(false);
    this.KhE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(35547);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(35547);
      }
    });
    this.KhE.setVisibility(8);
    this.KhC = ((TextView)this.cXJ.findViewById(2131299470));
    if ((this.cXJ.fJB()) || (((d)this.cXJ.bh(d.class)).fGK())) {}
    for (bool = true;; bool = false)
    {
      this.KhF = new v(this.cXJ.Kkd.getContext(), new bv(), this.cXJ.getTalkerUserName(), this.cXJ.fJy(), bool);
      this.KhF.JXf = new v.a()
      {
        public final void adA(int paramAnonymousInt)
        {
          AppMethodBeat.i(35548);
          at.this.adT(paramAnonymousInt);
          AppMethodBeat.o(35548);
        }
      };
      this.KhD = ((ListView)this.cXJ.findViewById(2131304399));
      this.KhD.setVisibility(0);
      this.KhD.setAdapter(this.KhF);
      this.KhD.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35549);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousAdapterView = (bv)at.d(at.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!bu.isNullOrNil(paramAnonymousAdapterView.field_talker)))
          {
            at.this.fIM();
            ((com.tencent.mm.ui.chatting.d.b.l)at.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class)).bG(paramAnonymousAdapterView);
            if (!at.this.KhB)
            {
              at.this.KhB = true;
              at.this.cXJ.Kkf.setBottomViewVisible(true);
              at.this.cXJ.Kke.fFX();
            }
            at.this.cXJ.Kkf.fFV();
            at.this.cXJ.Kkf.setIsBottomShowAll(false);
            ((k)at.this.cXJ.bh(k.class)).a(paramAnonymousAdapterView.field_msgId, false, d.a.Krz);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35549);
        }
      });
      this.KhD.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35539);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          at.this.cXJ.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/component/SearchComponent$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(35539);
          return false;
        }
      });
      break;
    }
  }
  
  public final void fIM()
  {
    AppMethodBeat.i(35552);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.KhG = false;
    this.KhH = true;
    if (this.KhC != null) {
      this.KhC.setVisibility(8);
    }
    if (this.KhE != null) {
      this.KhE.setVisibility(8);
    }
    if (this.KhD != null) {
      this.KhD.setVisibility(8);
    }
    this.cXJ.adE(0);
    this.cXJ.hideVKB();
    AppMethodBeat.o(35552);
  }
  
  public final boolean fIN()
  {
    return this.KhG;
  }
  
  public final v fIO()
  {
    return this.KhF;
  }
  
  public final boolean fIP()
  {
    return this.Khv;
  }
  
  public final boolean fIQ()
  {
    return this.Khu;
  }
  
  public final boolean fIR()
  {
    return this.Khx;
  }
  
  public final boolean fIS()
  {
    return this.Khy;
  }
  
  public final boolean fIT()
  {
    return this.KhB;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35554);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((k)this.cXJ.bh(k.class)).isInEditMode()) && (this.KhG)) {
      fIM();
    }
    AppMethodBeat.o(35554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.at
 * JD-Core Version:    0.7.0.1
 */