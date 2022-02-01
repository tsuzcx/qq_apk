package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.chatting.v.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(gRF=am.class)
public class aw
  extends a
  implements am
{
  private v PtA;
  public boolean PtB = false;
  private boolean PtC = true;
  private int PtD = 0;
  private boolean PtE = false;
  private View Pto;
  public boolean Ptp = false;
  public boolean Ptq = false;
  public boolean Ptr = false;
  public boolean Pts = false;
  public boolean Ptt = false;
  private long Ptu = -1L;
  private ArrayList<String> Ptv;
  public boolean Ptw = false;
  private TextView Ptx;
  private ListView Pty;
  private View Ptz;
  private s gzP = null;
  
  public final boolean Nz(long paramLong)
  {
    AppMethodBeat.i(35550);
    if ((this.Ptu == paramLong) && (this.Pts) && (this.Ptv != null) && (this.Ptv.size() > 0))
    {
      AppMethodBeat.o(35550);
      return true;
    }
    AppMethodBeat.o(35550);
    return false;
  }
  
  public final void amE(int paramInt)
  {
    AppMethodBeat.i(35553);
    Log.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.PtB), Boolean.valueOf(this.PtC) });
    if ((!this.Ptp) && (!this.PtB))
    {
      Log.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      AppMethodBeat.o(35553);
      return;
    }
    if ((this.PtC) && (paramInt >= 0))
    {
      this.PtC = false;
      h.CyF.a(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.Pty.setVisibility(0);
      this.dom.amo(8);
      this.Ptx.setVisibility(8);
      this.Ptz.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    if (paramInt == 0)
    {
      this.Pty.setVisibility(8);
      this.dom.amo(8);
      this.Ptx.setVisibility(0);
      this.Ptz.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    this.Pty.setVisibility(8);
    this.dom.amo(0);
    this.Ptx.setVisibility(8);
    this.Ptz.setVisibility(0);
    AppMethodBeat.o(35553);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35558);
    if (this.PtB)
    {
      gQW();
      ((com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).gPC();
    }
    AppMethodBeat.o(35558);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35556);
    this.Ptp = this.dom.Pwc.getBooleanExtra("search_chat_content", false).booleanValue();
    this.Ptq = this.dom.Pwc.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.Ptv = this.dom.Pwc.getStringArrayList("highlight_keyword_list");
    this.Ptu = this.dom.Pwc.getLongExtra("msg_local_id", -1L);
    this.Pts = this.dom.Pwc.getBooleanExtra("from_global_search", false).booleanValue();
    this.Ptt = this.dom.Pwc.getBooleanExtra("from_date_search", false).booleanValue();
    this.Ptr = this.dom.Pwc.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    AppMethodBeat.o(35556);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35557);
    if ((this.Ptu >= 0L) && (!this.PtE)) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35538);
          if (!aw.a(aw.this))
          {
            aw.b(aw.this);
            aw.c(aw.this);
            if (aw.this.dom != null) {
              aw.this.dom.cmy();
            }
            Log.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
          AppMethodBeat.o(35538);
        }
      }, 2000L);
    }
    if (this.Ptp)
    {
      Log.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      h.CyF.idkeyStat(219L, 11L, 1L, true);
      l.a(this.dom.Pwc, 2131307365);
      this.Pto = this.dom.findViewById(2131307372);
      this.Ptz = this.dom.findViewById(2131307363);
      this.dom.getListView().setFocusable(false);
      this.dom.getListView().setFocusableInTouchMode(false);
      this.Ptz.setOnClickListener(new aw.3(this));
      if (this.Ptx == null)
      {
        l.a(this.dom.Pwc, 2131309876);
        this.Ptx = ((TextView)this.dom.findViewById(2131300099));
      }
      if ((!this.dom.gRL()) && (!((d)this.dom.bh(d.class)).gOQ())) {
        break label444;
      }
    }
    label444:
    for (boolean bool = true;; bool = false)
    {
      this.PtA = new v(this.dom.Pwc.getContext(), new ca(), this.dom.getTalkerUserName(), this.dom.gRI(), bool);
      this.PtA.Pit = new v.a()
      {
        public final void amk(int paramAnonymousInt)
        {
          AppMethodBeat.i(35541);
          aw.this.amE(paramAnonymousInt);
          AppMethodBeat.o(35541);
        }
      };
      this.Pty = ((ListView)this.dom.findViewById(2131307364));
      this.Pty.setAdapter(this.PtA);
      this.Pty.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35542);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousView = (ca)aw.d(aw.this).getItem(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.field_talker)))
          {
            h.CyF.a(10450, new Object[] { Integer.valueOf(1) });
            paramAnonymousAdapterView = new Intent(aw.this.dom.Pwc.getContext(), ChattingUI.class);
            paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.field_talker);
            paramAnonymousAdapterView.putExtra("finish_direct", true);
            paramAnonymousAdapterView.putExtra("show_search_chat_content_result", false);
            paramAnonymousAdapterView.putExtra("msg_local_id", paramAnonymousView.field_msgId);
            paramAnonymousAdapterView.putExtra("img_gallery_enter_from_chatting_ui", true);
            paramAnonymousView = aw.this.dom.Pwc;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35542);
        }
      });
      this.Pty.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35543);
          aw.this.dom.hideVKB();
          AppMethodBeat.o(35543);
          return false;
        }
      });
      this.gzP = new s();
      this.gzP.Qwi = new s.b()
      {
        private int PtG = 0;
        
        public final boolean SN(String paramAnonymousString)
        {
          return false;
        }
        
        public final void SO(String paramAnonymousString)
        {
          AppMethodBeat.i(35545);
          if (Util.isNullOrNil(paramAnonymousString))
          {
            this.PtG = 0;
            aw.this.amE(-1);
            AppMethodBeat.o(35545);
            return;
          }
          if (paramAnonymousString.length() > this.PtG) {
            h.CyF.a(10451, new Object[] { Integer.valueOf(1) });
          }
          this.PtG = paramAnonymousString.length();
          h.CyF.a(10456, new Object[] { Integer.valueOf(1) });
          aw.d(aw.this).SM(paramAnonymousString);
          AppMethodBeat.o(35545);
        }
        
        public final void bnA() {}
        
        public final void bnB() {}
        
        public final void bny()
        {
          AppMethodBeat.i(35546);
          new MMHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35544);
              aw.this.dom.Pwc.gNh();
              AppMethodBeat.o(35544);
            }
          });
          AppMethodBeat.o(35546);
        }
        
        public final void bnz() {}
      };
      this.dom.Pwc.addSearchMenu(true, this.gzP);
      this.gzP.CK(true);
      if ((this.Ptq) || (this.Pts) || (this.Ptt))
      {
        long l = this.dom.Pwc.getLongExtra("msg_local_id", -1L);
        ((k)this.dom.bh(k.class)).a(l, false, d.a.PDH);
      }
      AppMethodBeat.o(35557);
      return;
    }
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35555);
    super.gOK();
    this.PtE = true;
    if (this.PtA != null) {
      this.PtA.ebf();
    }
    if (this.gzP != null) {
      this.gzP.clearFocus();
    }
    AppMethodBeat.o(35555);
  }
  
  public final ArrayList<String> gQU()
  {
    return this.Ptv;
  }
  
  public final void gQV()
  {
    AppMethodBeat.i(35551);
    if (this.Pto == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.PtB = true;
      this.dom.amo(8);
      if (this.Pto == null) {
        break;
      }
      this.Pto.setVisibility(0);
      if (this.PtA != null) {
        this.PtA.talker = this.dom.getTalkerUserName();
      }
      amE(-1);
      AppMethodBeat.o(35551);
      return;
    }
    l.a(this.dom.Pwc, 2131307365);
    this.Pto = this.dom.findViewById(2131307372);
    this.Pto.setVisibility(0);
    this.Ptz = this.dom.findViewById(2131307363);
    this.dom.getListView().setFocusable(false);
    this.dom.getListView().setFocusableInTouchMode(false);
    this.Ptz.setOnClickListener(new aw.8(this));
    this.Ptz.setVisibility(8);
    this.Ptx = ((TextView)this.dom.findViewById(2131300099));
    if ((this.dom.gRL()) || (((d)this.dom.bh(d.class)).gOQ())) {}
    for (bool = true;; bool = false)
    {
      this.PtA = new v(this.dom.Pwc.getContext(), new ca(), this.dom.getTalkerUserName(), this.dom.gRI(), bool);
      this.PtA.Pit = new v.a()
      {
        public final void amk(int paramAnonymousInt)
        {
          AppMethodBeat.i(35548);
          aw.this.amE(paramAnonymousInt);
          AppMethodBeat.o(35548);
        }
      };
      this.Pty = ((ListView)this.dom.findViewById(2131307364));
      this.Pty.setVisibility(0);
      this.Pty.setAdapter(this.PtA);
      this.Pty.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35549);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = (ca)aw.d(aw.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!Util.isNullOrNil(paramAnonymousAdapterView.field_talker)))
          {
            aw.this.gQW();
            ((com.tencent.mm.ui.chatting.d.b.l)aw.this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).bW(paramAnonymousAdapterView);
            if (!aw.this.Ptw)
            {
              aw.this.Ptw = true;
              aw.this.dom.Pwe.setBottomViewVisible(true);
              aw.this.dom.Pwd.gOc();
            }
            aw.this.dom.Pwe.gOa();
            aw.this.dom.Pwe.setIsBottomShowAll(false);
            ((k)aw.this.dom.bh(k.class)).a(paramAnonymousAdapterView.field_msgId, false, d.a.PDH);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35549);
        }
      });
      this.Pty.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35539);
          aw.this.dom.hideVKB();
          AppMethodBeat.o(35539);
          return false;
        }
      });
      break;
    }
  }
  
  public final void gQW()
  {
    AppMethodBeat.i(35552);
    Log.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.PtB = false;
    this.PtC = true;
    if (this.Ptx != null) {
      this.Ptx.setVisibility(8);
    }
    if (this.Ptz != null) {
      this.Ptz.setVisibility(8);
    }
    if (this.Pty != null) {
      this.Pty.setVisibility(8);
    }
    this.dom.amo(0);
    this.dom.hideVKB();
    AppMethodBeat.o(35552);
  }
  
  public final boolean gQX()
  {
    return this.PtB;
  }
  
  public final v gQY()
  {
    return this.PtA;
  }
  
  public final boolean gQZ()
  {
    return this.Ptq;
  }
  
  public final boolean gRa()
  {
    return this.Ptp;
  }
  
  public final boolean gRb()
  {
    return this.Pts;
  }
  
  public final boolean gRc()
  {
    return this.Ptt;
  }
  
  public final boolean gRd()
  {
    return this.Ptw;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35554);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((k)this.dom.bh(k.class)).isInEditMode()) && (this.PtB)) {
      gQW();
    }
    AppMethodBeat.o(35554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aw
 * JD-Core Version:    0.7.0.1
 */