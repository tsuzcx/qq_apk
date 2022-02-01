package com.tencent.mm.ui.chatting.component;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.component.api.au;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.chatting.x.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=au.class)
public class bg
  extends a
  implements au
{
  public boolean aewA = false;
  private TextView aewB;
  private ListView aewC;
  private View aewD;
  private x aewE;
  public boolean aewF = false;
  private boolean aewG = true;
  private int aewH = 0;
  private boolean aewI = false;
  private View aewr;
  public boolean aews = false;
  public boolean aewt = false;
  public boolean aewu = false;
  public boolean aewv = false;
  public boolean aeww = false;
  public boolean aewx = false;
  private long aewy = -1L;
  private ArrayList<String> aewz;
  private s lMw = null;
  
  public final void aCj(int paramInt)
  {
    AppMethodBeat.i(35553);
    Log.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.aewF), Boolean.valueOf(this.aewG) });
    if ((!this.aews) && (!this.aewF))
    {
      Log.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      AppMethodBeat.o(35553);
      return;
    }
    if ((this.aewG) && (paramInt >= 0))
    {
      this.aewG = false;
      h.OAn.b(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.aewC.setVisibility(0);
      this.hlc.aBQ(8);
      this.aewB.setVisibility(8);
      this.aewD.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    if (paramInt == 0)
    {
      this.aewC.setVisibility(8);
      this.hlc.aBQ(8);
      this.aewB.setVisibility(0);
      this.aewD.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    this.aewC.setVisibility(8);
    this.hlc.aBQ(0);
    this.aewB.setVisibility(8);
    this.aewD.setVisibility(0);
    AppMethodBeat.o(35553);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35556);
    this.aews = this.hlc.aezO.getBooleanExtra("search_chat_content", false).booleanValue();
    this.aewt = this.hlc.aezO.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.aewz = this.hlc.aezO.getStringArrayList("highlight_keyword_list");
    this.aewy = this.hlc.aezO.getLongExtra("msg_local_id", -1L);
    this.aewv = this.hlc.aezO.getBooleanExtra("from_global_search", false).booleanValue();
    this.aeww = this.hlc.aezO.getBooleanExtra("from_date_search", false).booleanValue();
    this.aewu = this.hlc.aezO.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    this.aewx = this.hlc.aezO.getBooleanExtra("from_service_notify_content_search", false).booleanValue();
    AppMethodBeat.o(35556);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35557);
    if ((this.aewy >= 0L) && (!this.aewI)) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35538);
          if (!bg.a(bg.this))
          {
            bg.b(bg.this);
            bg.c(bg.this);
            if (bg.this.hlc != null) {
              bg.this.hlc.dcZ();
            }
            Log.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
          AppMethodBeat.o(35538);
        }
      }, 2000L);
    }
    if (this.aews)
    {
      Log.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      h.OAn.idkeyStat(219L, 11L, 1L, true);
      n.c(this.hlc.aezO, R.h.fVt);
      this.aewr = this.hlc.findViewById(R.h.fVu);
      this.aewD = this.hlc.findViewById(R.h.fVr);
      this.hlc.getListView().setFocusable(false);
      this.hlc.getListView().setFocusableInTouchMode(false);
      this.aewD.setOnClickListener(new bg.3(this));
      if (this.aewB == null)
      {
        n.c(this.hlc.aezO, R.h.gcg);
        this.aewB = ((TextView)this.hlc.findViewById(R.h.fGD));
      }
      if ((!this.hlc.juF()) && (!((e)this.hlc.cm(e.class)).jqW())) {
        break label470;
      }
    }
    label470:
    for (boolean bool = true;; bool = false)
    {
      this.aewE = new x(this.hlc.aezO.getContext(), new cc(), this.hlc.getTalkerUserName(), this.hlc.getSelfUserName(), bool);
      this.aewE.aejp = new x.a()
      {
        public final void aBN(int paramAnonymousInt)
        {
          AppMethodBeat.i(35541);
          bg.this.aCj(paramAnonymousInt);
          AppMethodBeat.o(35541);
        }
      };
      this.aewC = ((ListView)this.hlc.findViewById(R.h.fVs));
      this.aewC.setAdapter(this.aewE);
      this.aewC.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35542);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousView = (cc)bg.d(bg.this).getItem(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.field_talker)))
          {
            h.OAn.b(10450, new Object[] { Integer.valueOf(1) });
            paramAnonymousAdapterView = new Intent(bg.this.hlc.aezO.getContext(), ChattingUI.class);
            paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.field_talker);
            paramAnonymousAdapterView.putExtra("finish_direct", true);
            paramAnonymousAdapterView.putExtra("show_search_chat_content_result", false);
            paramAnonymousAdapterView.putExtra("msg_local_id", paramAnonymousView.field_msgId);
            paramAnonymousAdapterView.putExtra("img_gallery_enter_from_chatting_ui", true);
            paramAnonymousView = bg.this.hlc.aezO;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35542);
        }
      });
      this.aewC.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35543);
          bg.this.hlc.hideVKB();
          AppMethodBeat.o(35543);
          return false;
        }
      });
      this.lMw = new s();
      this.lMw.afKz = new s.c()
      {
        private int aewK = 0;
        
        public final boolean SN(String paramAnonymousString)
        {
          return false;
        }
        
        public final void SO(String paramAnonymousString)
        {
          AppMethodBeat.i(35545);
          if (Util.isNullOrNil(paramAnonymousString))
          {
            this.aewK = 0;
            bg.this.aCj(-1);
            AppMethodBeat.o(35545);
            return;
          }
          if (paramAnonymousString.length() > this.aewK) {
            h.OAn.b(10451, new Object[] { Integer.valueOf(1) });
          }
          this.aewK = paramAnonymousString.length();
          h.OAn.b(10456, new Object[] { Integer.valueOf(1) });
          bg.d(bg.this).SM(paramAnonymousString);
          AppMethodBeat.o(35545);
        }
        
        public final void bWw()
        {
          AppMethodBeat.i(35546);
          new MMHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35544);
              bg.this.hlc.aezO.joU();
              AppMethodBeat.o(35544);
            }
          });
          AppMethodBeat.o(35546);
        }
        
        public final void bWx() {}
        
        public final void bWy() {}
        
        public final void bWz() {}
      };
      this.hlc.aezO.addSearchMenu(true, this.lMw);
      this.lMw.MY(true);
      if ((this.aewt) || (this.aewv) || (this.aeww) || (this.aewx))
      {
        long l = this.hlc.aezO.getLongExtra("msg_local_id", -1L);
        int i = this.hlc.aezO.getIntExtra("SELECTION_TOP_OFFSET", 0);
        ((m)this.hlc.cm(m.class)).a(l, false, false, false, i, false, d.a.aeHU);
      }
      AppMethodBeat.o(35557);
      return;
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35558);
    if (this.aewF)
    {
      jtv();
      ((com.tencent.mm.ui.chatting.component.api.n)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class)).jrK();
    }
    AppMethodBeat.o(35558);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35555);
    super.jqF();
    this.aewI = true;
    if (this.aewE != null) {
      this.aewE.fSd();
    }
    if (this.lMw != null) {
      this.lMw.clearFocus();
    }
    AppMethodBeat.o(35555);
  }
  
  public final boolean jtA()
  {
    return this.aewv;
  }
  
  public final boolean jtB()
  {
    return this.aeww;
  }
  
  public final boolean jtC()
  {
    return this.aewA;
  }
  
  public final boolean jtD()
  {
    return this.aewx;
  }
  
  public final ArrayList<String> jtt()
  {
    return this.aewz;
  }
  
  public final void jtu()
  {
    AppMethodBeat.i(35551);
    if (this.aewr == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.aewF = true;
      this.hlc.aBQ(8);
      if (this.aewr == null) {
        break;
      }
      this.aewr.setVisibility(0);
      if (this.aewE != null) {
        this.aewE.talker = this.hlc.getTalkerUserName();
      }
      aCj(-1);
      AppMethodBeat.o(35551);
      return;
    }
    n.c(this.hlc.aezO, R.h.fVt);
    this.aewr = this.hlc.findViewById(R.h.fVu);
    this.aewr.setVisibility(0);
    this.aewD = this.hlc.findViewById(R.h.fVr);
    this.hlc.getListView().setFocusable(false);
    this.hlc.getListView().setFocusableInTouchMode(false);
    this.aewD.setOnClickListener(new bg.8(this));
    this.aewD.setVisibility(8);
    this.aewB = ((TextView)this.hlc.findViewById(R.h.fGD));
    if ((this.hlc.juF()) || (((e)this.hlc.cm(e.class)).jqW())) {}
    for (bool = true;; bool = false)
    {
      this.aewE = new x(this.hlc.aezO.getContext(), new cc(), this.hlc.getTalkerUserName(), this.hlc.getSelfUserName(), bool);
      this.aewE.aejp = new x.a()
      {
        public final void aBN(int paramAnonymousInt)
        {
          AppMethodBeat.i(35548);
          bg.this.aCj(paramAnonymousInt);
          AppMethodBeat.o(35548);
        }
      };
      this.aewC = ((ListView)this.hlc.findViewById(R.h.fVs));
      this.aewC.setVisibility(0);
      this.aewC.setAdapter(this.aewE);
      this.aewC.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35549);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (cc)bg.d(bg.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!Util.isNullOrNil(paramAnonymousAdapterView.field_talker)))
          {
            bg.this.jtv();
            ((com.tencent.mm.ui.chatting.component.api.n)bg.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class)).cM(paramAnonymousAdapterView);
            if (!bg.this.aewA)
            {
              bg.this.aewA = true;
              bg.this.hlc.aezQ.jpM();
              bg.this.hlc.jpQ();
            }
            bg.this.hlc.aezQ.jpO();
            bg.this.hlc.aezQ.setIsBottomShowAll(false);
            ((m)bg.this.hlc.cm(m.class)).a(paramAnonymousAdapterView.field_msgId, false, false, false, 0, false, d.a.aeHU);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35549);
        }
      });
      this.aewC.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35539);
          bg.this.hlc.hideVKB();
          AppMethodBeat.o(35539);
          return false;
        }
      });
      break;
    }
  }
  
  public final void jtv()
  {
    AppMethodBeat.i(35552);
    Log.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.aewF = false;
    this.aewG = true;
    if (this.aewB != null) {
      this.aewB.setVisibility(8);
    }
    if (this.aewD != null) {
      this.aewD.setVisibility(8);
    }
    if (this.aewC != null) {
      this.aewC.setVisibility(8);
    }
    this.hlc.aBQ(0);
    this.hlc.hideVKB();
    AppMethodBeat.o(35552);
  }
  
  public final boolean jtw()
  {
    return this.aewF;
  }
  
  public final x jtx()
  {
    return this.aewE;
  }
  
  public final boolean jty()
  {
    return this.aewt;
  }
  
  public final boolean jtz()
  {
    return this.aews;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35554);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((m)this.hlc.cm(m.class)).jqo()) && (this.aewF)) {
      jtv();
    }
    AppMethodBeat.o(35554);
  }
  
  public final boolean zT(long paramLong)
  {
    AppMethodBeat.i(35550);
    if ((this.aewy == paramLong) && (this.aewv) && (this.aewz != null) && (this.aewz.size() > 0))
    {
      AppMethodBeat.o(35550);
      return true;
    }
    AppMethodBeat.o(35550);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bg
 * JD-Core Version:    0.7.0.1
 */