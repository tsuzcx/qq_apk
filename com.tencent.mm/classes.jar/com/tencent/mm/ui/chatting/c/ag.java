package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.tools.q;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.c.a.a(dJy=z.class)
public class ag
  extends a
  implements z
{
  private q eiV = null;
  public boolean zHA = false;
  private TextView zHB;
  private ListView zHC;
  private View zHD;
  private u zHE;
  public boolean zHF = false;
  private boolean zHG = true;
  private int zHH = 0;
  private boolean zHI = false;
  private View zHs;
  public boolean zHt = false;
  public boolean zHu = false;
  public boolean zHv = false;
  public boolean zHw = false;
  public boolean zHx = false;
  private long zHy = -1L;
  private ArrayList<String> zHz;
  
  public final void PI(int paramInt)
  {
    AppMethodBeat.i(31656);
    ab.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.zHF), Boolean.valueOf(this.zHG) });
    if ((!this.zHt) && (!this.zHF))
    {
      ab.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      AppMethodBeat.o(31656);
      return;
    }
    if ((this.zHG) && (paramInt >= 0))
    {
      this.zHG = false;
      com.tencent.mm.plugin.report.service.h.qsU.e(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.zHC.setVisibility(0);
      this.caz.Pv(8);
      this.zHB.setVisibility(8);
      this.zHD.setVisibility(8);
      AppMethodBeat.o(31656);
      return;
    }
    if (paramInt == 0)
    {
      this.zHC.setVisibility(8);
      this.caz.Pv(8);
      this.zHB.setVisibility(0);
      this.zHD.setVisibility(8);
      AppMethodBeat.o(31656);
      return;
    }
    this.zHC.setVisibility(8);
    this.caz.Pv(0);
    this.zHB.setVisibility(8);
    this.zHD.setVisibility(0);
    AppMethodBeat.o(31656);
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31659);
    this.zHt = this.caz.zJz.getBooleanExtra("search_chat_content", false).booleanValue();
    this.zHu = this.caz.zJz.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.zHz = this.caz.zJz.getStringArrayList("highlight_keyword_list");
    this.zHy = this.caz.zJz.getLongExtra("msg_local_id", -1L);
    this.zHw = this.caz.zJz.getBooleanExtra("from_global_search", false).booleanValue();
    this.zHx = this.caz.zJz.getBooleanExtra("from_date_search", false).booleanValue();
    this.zHv = this.caz.zJz.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    AppMethodBeat.o(31659);
  }
  
  public final void dBZ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(31660);
    if ((this.zHy >= 0L) && (!this.zHI)) {
      al.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(31643);
          if (!ag.a(ag.this))
          {
            ag.b(ag.this);
            ag.c(ag.this);
            if (ag.this.caz != null) {
              ag.this.caz.aWN();
            }
            ab.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
          AppMethodBeat.o(31643);
        }
      }, 2000L);
    }
    long l;
    com.tencent.mm.ui.chatting.c.b.h localh;
    if (this.zHt)
    {
      ab.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 11L, 1L, true);
      i.a(this.caz.zJz, 2131822447);
      this.zHs = this.caz.findViewById(2131822448);
      this.zHD = this.caz.findViewById(2131827491);
      this.caz.getListView().setFocusable(false);
      this.caz.getListView().setFocusableInTouchMode(false);
      this.zHD.setOnClickListener(new ag.3(this));
      if (this.zHB == null)
      {
        i.a(this.caz.zJz, 2131822443);
        this.zHB = ((TextView)this.caz.findViewById(2131822796));
      }
      if ((this.caz.dJF()) || (((d)this.caz.ay(d.class)).dHw()))
      {
        bool1 = true;
        this.zHE = new u(this.caz.zJz.getContext(), new bi(), this.caz.getTalkerUserName(), this.caz.dJD(), bool1);
        this.zHE.zAw = new ag.4(this);
        this.zHC = ((ListView)this.caz.findViewById(2131827490));
        this.zHC.setAdapter(this.zHE);
        this.zHC.setOnItemClickListener(new ag.5(this));
        this.zHC.setOnTouchListener(new ag.6(this));
        this.eiV = new q();
        this.eiV.Axg = new ag.7(this);
        this.caz.zJz.addSearchMenu(true, this.eiV);
        this.eiV.ru(true);
      }
    }
    else if ((this.zHu) || (this.zHw) || (this.zHx))
    {
      l = this.caz.zJz.getLongExtra("msg_local_id", -1L);
      localh = (com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
      if ((!this.zHw) || (this.zHx)) {
        break label468;
      }
    }
    label468:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localh.a(l, bool1, d.a.zOA);
      AppMethodBeat.o(31660);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31661);
    if (this.zHF)
    {
      dIY();
      ((com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class)).dHX();
    }
    AppMethodBeat.o(31661);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31658);
    super.dHq();
    this.zHI = true;
    if (this.zHE != null) {
      this.zHE.bKb();
    }
    if (this.eiV != null) {
      this.eiV.clearFocus();
    }
    AppMethodBeat.o(31658);
  }
  
  public final ArrayList<String> dIV()
  {
    return this.zHz;
  }
  
  public final boolean dIW()
  {
    return this.zHv;
  }
  
  public final void dIX()
  {
    AppMethodBeat.i(31654);
    if (this.zHs == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.zHF = true;
      this.caz.Pv(8);
      if (this.zHs == null) {
        break;
      }
      this.zHs.setVisibility(0);
      if (this.zHE != null) {
        this.zHE.talker = this.caz.getTalkerUserName();
      }
      PI(-1);
      AppMethodBeat.o(31654);
      return;
    }
    i.a(this.caz.zJz, 2131822447);
    this.zHs = this.caz.findViewById(2131822448);
    this.zHs.setVisibility(0);
    this.zHD = this.caz.findViewById(2131827491);
    this.caz.getListView().setFocusable(false);
    this.caz.getListView().setFocusableInTouchMode(false);
    this.zHD.setOnClickListener(new ag.8(this));
    this.zHD.setVisibility(8);
    this.zHB = ((TextView)this.caz.findViewById(2131822796));
    if ((this.caz.dJF()) || (((d)this.caz.ay(d.class)).dHw())) {}
    for (bool = true;; bool = false)
    {
      this.zHE = new u(this.caz.zJz.getContext(), new bi(), this.caz.getTalkerUserName(), this.caz.dJD(), bool);
      this.zHE.zAw = new ag.9(this);
      this.zHC = ((ListView)this.caz.findViewById(2131827490));
      this.zHC.setVisibility(0);
      this.zHC.setAdapter(this.zHE);
      this.zHC.setOnItemClickListener(new ag.10(this));
      this.zHC.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(31644);
          ag.this.caz.hideVKB();
          AppMethodBeat.o(31644);
          return false;
        }
      });
      break;
    }
  }
  
  public final void dIY()
  {
    AppMethodBeat.i(31655);
    ab.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.zHF = false;
    this.zHG = true;
    if (this.zHB != null) {
      this.zHB.setVisibility(8);
    }
    if (this.zHD != null) {
      this.zHD.setVisibility(8);
    }
    if (this.zHC != null) {
      this.zHC.setVisibility(8);
    }
    this.caz.Pv(0);
    this.caz.hideVKB();
    AppMethodBeat.o(31655);
  }
  
  public final boolean dIZ()
  {
    return this.zHF;
  }
  
  public final u dJa()
  {
    return this.zHE;
  }
  
  public final boolean dJb()
  {
    return this.zHu;
  }
  
  public final boolean dJc()
  {
    return this.zHt;
  }
  
  public final boolean dJd()
  {
    return this.zHw;
  }
  
  public final boolean dJe()
  {
    return this.zHx;
  }
  
  public final boolean dJf()
  {
    return this.zHA;
  }
  
  public final boolean oD(long paramLong)
  {
    AppMethodBeat.i(31653);
    if ((this.zHy == paramLong) && (this.zHw) && (this.zHz != null) && (this.zHz.size() > 0))
    {
      AppMethodBeat.o(31653);
      return true;
    }
    AppMethodBeat.o(31653);
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31657);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).isInEditMode()) && (this.zHF)) {
      dIY();
    }
    AppMethodBeat.o(31657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ag
 * JD-Core Version:    0.7.0.1
 */