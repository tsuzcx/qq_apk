package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.chatting.u.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.ae.class)
public class ao
  extends a
  implements com.tencent.mm.ui.chatting.c.b.ae
{
  public boolean GxA = false;
  public boolean GxB = false;
  public boolean GxC = false;
  public boolean GxD = false;
  public boolean GxE = false;
  private long GxF = -1L;
  private ArrayList<String> GxG;
  public boolean GxH = false;
  private TextView GxI;
  private ListView GxJ;
  private View GxK;
  private u GxL;
  public boolean GxM = false;
  private boolean GxN = true;
  private int GxO = 0;
  private boolean GxP = false;
  private View Gxz;
  private r fvI = null;
  
  public final void YP(int paramInt)
  {
    AppMethodBeat.i(35553);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.GxM), Boolean.valueOf(this.GxN) });
    if ((!this.GxA) && (!this.GxM))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      AppMethodBeat.o(35553);
      return;
    }
    if ((this.GxN) && (paramInt >= 0))
    {
      this.GxN = false;
      h.vKh.f(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.GxJ.setVisibility(0);
      this.cOd.YA(8);
      this.GxI.setVisibility(8);
      this.GxK.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    if (paramInt == 0)
    {
      this.GxJ.setVisibility(8);
      this.cOd.YA(8);
      this.GxI.setVisibility(0);
      this.GxK.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    this.GxJ.setVisibility(8);
    this.cOd.YA(0);
    this.GxI.setVisibility(8);
    this.GxK.setVisibility(0);
    AppMethodBeat.o(35553);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35556);
    this.GxA = this.cOd.GzJ.getBooleanExtra("search_chat_content", false).booleanValue();
    this.GxB = this.cOd.GzJ.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.GxG = this.cOd.GzJ.getStringArrayList("highlight_keyword_list");
    this.GxF = this.cOd.GzJ.getLongExtra("msg_local_id", -1L);
    this.GxD = this.cOd.GzJ.getBooleanExtra("from_global_search", false).booleanValue();
    this.GxE = this.cOd.GzJ.getBooleanExtra("from_date_search", false).booleanValue();
    this.GxC = this.cOd.GzJ.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    AppMethodBeat.o(35556);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35557);
    if ((this.GxF >= 0L) && (!this.GxP)) {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35538);
          if (!ao.a(ao.this))
          {
            ao.b(ao.this);
            ao.c(ao.this);
            if (ao.this.cOd != null) {
              ao.this.cOd.bCM();
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
          AppMethodBeat.o(35538);
        }
      }, 2000L);
    }
    if (this.GxA)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      h.vKh.idkeyStat(219L, 11L, 1L, true);
      j.a(this.cOd.GzJ, 2131304400);
      this.Gxz = this.cOd.findViewById(2131304406);
      this.GxK = this.cOd.findViewById(2131304398);
      this.cOd.getListView().setFocusable(false);
      this.cOd.getListView().setFocusableInTouchMode(false);
      this.GxK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35540);
          AppMethodBeat.o(35540);
        }
      });
      if (this.GxI == null)
      {
        j.a(this.cOd.GzJ, 2131306442);
        this.GxI = ((TextView)this.cOd.findViewById(2131299470));
      }
      if ((!this.cOd.eZa()) && (!((d)this.cOd.be(d.class)).eWD())) {
        break label440;
      }
    }
    label440:
    for (boolean bool = true;; bool = false)
    {
      this.GxL = new u(this.cOd.GzJ.getContext(), new bl(), this.cOd.getTalkerUserName(), this.cOd.eYX(), bool);
      this.GxL.GoJ = new u.a()
      {
        public final void Yx(int paramAnonymousInt)
        {
          AppMethodBeat.i(35541);
          ao.this.YP(paramAnonymousInt);
          AppMethodBeat.o(35541);
        }
      };
      this.GxJ = ((ListView)this.cOd.findViewById(2131304399));
      this.GxJ.setAdapter(this.GxL);
      this.GxJ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35542);
          paramAnonymousView = (bl)ao.d(ao.this).getItem(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.field_talker)))
          {
            h.vKh.f(10450, new Object[] { Integer.valueOf(1) });
            paramAnonymousAdapterView = new Intent(ao.this.cOd.GzJ.getContext(), ChattingUI.class);
            paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.field_talker);
            paramAnonymousAdapterView.putExtra("finish_direct", true);
            paramAnonymousAdapterView.putExtra("show_search_chat_content_result", false);
            paramAnonymousAdapterView.putExtra("msg_local_id", paramAnonymousView.field_msgId);
            paramAnonymousAdapterView.putExtra("img_gallery_enter_from_chatting_ui", true);
            paramAnonymousView = ao.this.cOd.GzJ;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.adn(), "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(35542);
        }
      });
      this.GxJ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35543);
          ao.this.cOd.hideVKB();
          AppMethodBeat.o(35543);
          return false;
        }
      });
      this.fvI = new r();
      this.fvI.Htp = new r.b()
      {
        private int GxR = 0;
        
        public final boolean BX(String paramAnonymousString)
        {
          return false;
        }
        
        public final void BY(String paramAnonymousString)
        {
          AppMethodBeat.i(35545);
          if (bt.isNullOrNil(paramAnonymousString))
          {
            this.GxR = 0;
            ao.this.YP(-1);
            AppMethodBeat.o(35545);
            return;
          }
          if (paramAnonymousString.length() > this.GxR) {
            h.vKh.f(10451, new Object[] { Integer.valueOf(1) });
          }
          this.GxR = paramAnonymousString.length();
          h.vKh.f(10456, new Object[] { Integer.valueOf(1) });
          ao.d(ao.this).BW(paramAnonymousString);
          AppMethodBeat.o(35545);
        }
        
        public final void aIj()
        {
          AppMethodBeat.i(35546);
          new ap().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35544);
              ao.this.cOd.GzJ.eUW();
              AppMethodBeat.o(35544);
            }
          });
          AppMethodBeat.o(35546);
        }
        
        public final void aIk() {}
        
        public final void aIl() {}
        
        public final void aIm() {}
      };
      this.cOd.GzJ.addSearchMenu(true, this.fvI);
      this.fvI.wH(true);
      if ((this.GxB) || (this.GxD) || (this.GxE))
      {
        long l = this.cOd.GzJ.getLongExtra("msg_local_id", -1L);
        ((i)this.cOd.be(i.class)).a(l, d.a.GEY);
      }
      AppMethodBeat.o(35557);
      return;
    }
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35558);
    if (this.GxM)
    {
      eYt();
      ((com.tencent.mm.ui.chatting.c.b.j)this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class)).eXj();
    }
    AppMethodBeat.o(35558);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35555);
    super.eWx();
    this.GxP = true;
    if (this.GxL != null) {
      this.GxL.cHX();
    }
    if (this.fvI != null) {
      this.fvI.clearFocus();
    }
    AppMethodBeat.o(35555);
  }
  
  public final boolean eYA()
  {
    return this.GxH;
  }
  
  public final ArrayList<String> eYq()
  {
    return this.GxG;
  }
  
  public final boolean eYr()
  {
    return this.GxC;
  }
  
  public final void eYs()
  {
    AppMethodBeat.i(35551);
    if (this.Gxz == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.GxM = true;
      this.cOd.YA(8);
      if (this.Gxz == null) {
        break;
      }
      this.Gxz.setVisibility(0);
      if (this.GxL != null) {
        this.GxL.talker = this.cOd.getTalkerUserName();
      }
      YP(-1);
      AppMethodBeat.o(35551);
      return;
    }
    j.a(this.cOd.GzJ, 2131304400);
    this.Gxz = this.cOd.findViewById(2131304406);
    this.Gxz.setVisibility(0);
    this.GxK = this.cOd.findViewById(2131304398);
    this.cOd.getListView().setFocusable(false);
    this.cOd.getListView().setFocusableInTouchMode(false);
    this.GxK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(35547);
        AppMethodBeat.o(35547);
      }
    });
    this.GxK.setVisibility(8);
    this.GxI = ((TextView)this.cOd.findViewById(2131299470));
    if ((this.cOd.eZa()) || (((d)this.cOd.be(d.class)).eWD())) {}
    for (bool = true;; bool = false)
    {
      this.GxL = new u(this.cOd.GzJ.getContext(), new bl(), this.cOd.getTalkerUserName(), this.cOd.eYX(), bool);
      this.GxL.GoJ = new u.a()
      {
        public final void Yx(int paramAnonymousInt)
        {
          AppMethodBeat.i(35548);
          ao.this.YP(paramAnonymousInt);
          AppMethodBeat.o(35548);
        }
      };
      this.GxJ = ((ListView)this.cOd.findViewById(2131304399));
      this.GxJ.setVisibility(0);
      this.GxJ.setAdapter(this.GxL);
      this.GxJ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35549);
          paramAnonymousAdapterView = (bl)ao.d(ao.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!bt.isNullOrNil(paramAnonymousAdapterView.field_talker)))
          {
            ao.this.eYt();
            ((com.tencent.mm.ui.chatting.c.b.j)ao.this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class)).bz(paramAnonymousAdapterView);
            if (!ao.this.GxH)
            {
              ao.this.GxH = true;
              ao.this.cOd.GzL.setBottomViewVisible(true);
              ao.this.cOd.GzK.eVT();
            }
            ao.this.cOd.GzL.eVR();
            ao.this.cOd.GzL.setIsBottomShowAll(false);
            ((i)ao.this.cOd.be(i.class)).a(paramAnonymousAdapterView.field_msgId, d.a.GEY);
          }
          AppMethodBeat.o(35549);
        }
      });
      this.GxJ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35539);
          ao.this.cOd.hideVKB();
          AppMethodBeat.o(35539);
          return false;
        }
      });
      break;
    }
  }
  
  public final void eYt()
  {
    AppMethodBeat.i(35552);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.GxM = false;
    this.GxN = true;
    if (this.GxI != null) {
      this.GxI.setVisibility(8);
    }
    if (this.GxK != null) {
      this.GxK.setVisibility(8);
    }
    if (this.GxJ != null) {
      this.GxJ.setVisibility(8);
    }
    this.cOd.YA(0);
    this.cOd.hideVKB();
    AppMethodBeat.o(35552);
  }
  
  public final boolean eYu()
  {
    return this.GxM;
  }
  
  public final u eYv()
  {
    return this.GxL;
  }
  
  public final boolean eYw()
  {
    return this.GxB;
  }
  
  public final boolean eYx()
  {
    return this.GxA;
  }
  
  public final boolean eYy()
  {
    return this.GxD;
  }
  
  public final boolean eYz()
  {
    return this.GxE;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35554);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((i)this.cOd.be(i.class)).isInEditMode()) && (this.GxM)) {
      eYt();
    }
    AppMethodBeat.o(35554);
  }
  
  public final boolean wE(long paramLong)
  {
    AppMethodBeat.i(35550);
    if ((this.GxF == paramLong) && (this.GxD) && (this.GxG != null) && (this.GxG.size() > 0))
    {
      AppMethodBeat.o(35550);
      return true;
    }
    AppMethodBeat.o(35550);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ao
 * JD-Core Version:    0.7.0.1
 */