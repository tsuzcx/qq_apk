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
import com.tencent.mm.R.h;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.chatting.v.a;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.t.b;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(hRc=an.class)
public class az
  extends a
  implements an
{
  private View WNR;
  public boolean WNS = false;
  public boolean WNT = false;
  public boolean WNU = false;
  public boolean WNV = false;
  public boolean WNW = false;
  private long WNX = -1L;
  private ArrayList<String> WNY;
  public boolean WNZ = false;
  private TextView WOa;
  private ListView WOb;
  private View WOc;
  private v WOd;
  public boolean WOe = false;
  private boolean WOf = true;
  private int WOg = 0;
  private boolean WOh = false;
  private t jjS = null;
  
  public final boolean VL(long paramLong)
  {
    AppMethodBeat.i(35550);
    if ((this.WNX == paramLong) && (this.WNV) && (this.WNY != null) && (this.WNY.size() > 0))
    {
      AppMethodBeat.o(35550);
      return true;
    }
    AppMethodBeat.o(35550);
    return false;
  }
  
  public final void avF(int paramInt)
  {
    AppMethodBeat.i(35553);
    Log.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.WOe), Boolean.valueOf(this.WOf) });
    if ((!this.WNS) && (!this.WOe))
    {
      Log.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      AppMethodBeat.o(35553);
      return;
    }
    if ((this.WOf) && (paramInt >= 0))
    {
      this.WOf = false;
      h.IzE.a(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.WOb.setVisibility(0);
      this.fgR.avp(8);
      this.WOa.setVisibility(8);
      this.WOc.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    if (paramInt == 0)
    {
      this.WOb.setVisibility(8);
      this.fgR.avp(8);
      this.WOa.setVisibility(0);
      this.WOc.setVisibility(8);
      AppMethodBeat.o(35553);
      return;
    }
    this.WOb.setVisibility(8);
    this.fgR.avp(0);
    this.WOa.setVisibility(8);
    this.WOc.setVisibility(0);
    AppMethodBeat.o(35553);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35556);
    this.WNS = this.fgR.WQv.getBooleanExtra("search_chat_content", false).booleanValue();
    this.WNT = this.fgR.WQv.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.WNY = this.fgR.WQv.getStringArrayList("highlight_keyword_list");
    this.WNX = this.fgR.WQv.getLongExtra("msg_local_id", -1L);
    this.WNV = this.fgR.WQv.getBooleanExtra("from_global_search", false).booleanValue();
    this.WNW = this.fgR.WQv.getBooleanExtra("from_date_search", false).booleanValue();
    this.WNU = this.fgR.WQv.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    AppMethodBeat.o(35556);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35557);
    if ((this.WNX >= 0L) && (!this.WOh)) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35538);
          if (!az.a(az.this))
          {
            az.b(az.this);
            az.c(az.this);
            if (az.this.fgR != null) {
              az.this.fgR.cAe();
            }
            Log.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
          AppMethodBeat.o(35538);
        }
      }, 2000L);
    }
    if (this.WNS)
    {
      Log.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      h.IzE.idkeyStat(219L, 11L, 1L, true);
      m.a(this.fgR.WQv, R.h.dTl);
      this.WNR = this.fgR.findViewById(R.h.dTm);
      this.WOc = this.fgR.findViewById(R.h.dTj);
      this.fgR.getListView().setFocusable(false);
      this.fgR.getListView().setFocusableInTouchMode(false);
      this.WOc.setOnClickListener(new az.3(this));
      if (this.WOa == null)
      {
        m.a(this.fgR.WQv, R.h.dZm);
        this.WOa = ((TextView)this.fgR.findViewById(R.h.dFx));
      }
      if ((!this.fgR.hRh()) && (!((d)this.fgR.bC(d.class)).hOf())) {
        break label444;
      }
    }
    label444:
    for (boolean bool = true;; bool = false)
    {
      this.WOd = new v(this.fgR.WQv.getContext(), new ca(), this.fgR.getTalkerUserName(), this.fgR.getSelfUserName(), bool);
      this.WOd.WBV = new v.a()
      {
        public final void avl(int paramAnonymousInt)
        {
          AppMethodBeat.i(35541);
          az.this.avF(paramAnonymousInt);
          AppMethodBeat.o(35541);
        }
      };
      this.WOb = ((ListView)this.fgR.findViewById(R.h.dTk));
      this.WOb.setAdapter(this.WOd);
      this.WOb.setOnItemClickListener(new az.5(this));
      this.WOb.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35543);
          az.this.fgR.hideVKB();
          AppMethodBeat.o(35543);
          return false;
        }
      });
      this.jjS = new t();
      this.jjS.XUl = new t.b()
      {
        private int WOj = 0;
        
        public final boolean aat(String paramAnonymousString)
        {
          return false;
        }
        
        public final void aau(String paramAnonymousString)
        {
          AppMethodBeat.i(35545);
          if (Util.isNullOrNil(paramAnonymousString))
          {
            this.WOj = 0;
            az.this.avF(-1);
            AppMethodBeat.o(35545);
            return;
          }
          if (paramAnonymousString.length() > this.WOj) {
            h.IzE.a(10451, new Object[] { Integer.valueOf(1) });
          }
          this.WOj = paramAnonymousString.length();
          h.IzE.a(10456, new Object[] { Integer.valueOf(1) });
          az.d(az.this).aas(paramAnonymousString);
          AppMethodBeat.o(35545);
        }
        
        public final void bxH()
        {
          AppMethodBeat.i(35546);
          new MMHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35544);
              az.this.fgR.WQv.hMr();
              AppMethodBeat.o(35544);
            }
          });
          AppMethodBeat.o(35546);
        }
        
        public final void bxI() {}
        
        public final void bxJ() {}
        
        public final void bxK() {}
      };
      this.fgR.WQv.addSearchMenu(true, this.jjS);
      this.jjS.He(true);
      if ((this.WNT) || (this.WNV) || (this.WNW))
      {
        long l = this.fgR.WQv.getLongExtra("msg_local_id", -1L);
        ((k)this.fgR.bC(k.class)).a(l, false, d.a.WYu);
      }
      AppMethodBeat.o(35557);
      return;
    }
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35558);
    if (this.WOe)
    {
      hQt();
      ((l)this.fgR.bC(l.class)).hOU();
    }
    AppMethodBeat.o(35558);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35555);
    super.hNZ();
    this.WOh = true;
    if (this.WOd != null) {
      this.WOd.eKd();
    }
    if (this.jjS != null) {
      this.jjS.clearFocus();
    }
    AppMethodBeat.o(35555);
  }
  
  public final boolean hQA()
  {
    return this.WNZ;
  }
  
  public final ArrayList<String> hQr()
  {
    return this.WNY;
  }
  
  public final void hQs()
  {
    AppMethodBeat.i(35551);
    if (this.WNR == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.WOe = true;
      this.fgR.avp(8);
      if (this.WNR == null) {
        break;
      }
      this.WNR.setVisibility(0);
      if (this.WOd != null) {
        this.WOd.talker = this.fgR.getTalkerUserName();
      }
      avF(-1);
      AppMethodBeat.o(35551);
      return;
    }
    m.a(this.fgR.WQv, R.h.dTl);
    this.WNR = this.fgR.findViewById(R.h.dTm);
    this.WNR.setVisibility(0);
    this.WOc = this.fgR.findViewById(R.h.dTj);
    this.fgR.getListView().setFocusable(false);
    this.fgR.getListView().setFocusableInTouchMode(false);
    this.WOc.setOnClickListener(new az.8(this));
    this.WOc.setVisibility(8);
    this.WOa = ((TextView)this.fgR.findViewById(R.h.dFx));
    if ((this.fgR.hRh()) || (((d)this.fgR.bC(d.class)).hOf())) {}
    for (bool = true;; bool = false)
    {
      this.WOd = new v(this.fgR.WQv.getContext(), new ca(), this.fgR.getTalkerUserName(), this.fgR.getSelfUserName(), bool);
      this.WOd.WBV = new v.a()
      {
        public final void avl(int paramAnonymousInt)
        {
          AppMethodBeat.i(35548);
          az.this.avF(paramAnonymousInt);
          AppMethodBeat.o(35548);
        }
      };
      this.WOb = ((ListView)this.fgR.findViewById(R.h.dTk));
      this.WOb.setVisibility(0);
      this.WOb.setAdapter(this.WOd);
      this.WOb.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(35549);
          b localb = new b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = (ca)az.d(az.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!Util.isNullOrNil(paramAnonymousAdapterView.field_talker)))
          {
            az.this.hQt();
            ((l)az.this.fgR.bC(l.class)).cq(paramAnonymousAdapterView);
            if (!az.this.WNZ)
            {
              az.this.WNZ = true;
              az.this.fgR.WQx.hNi();
              az.this.fgR.WQw.hNm();
            }
            az.this.fgR.WQx.hNk();
            az.this.fgR.WQx.setIsBottomShowAll(false);
            ((k)az.this.fgR.bC(k.class)).a(paramAnonymousAdapterView.field_msgId, false, d.a.WYu);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35549);
        }
      });
      this.WOb.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(35539);
          az.this.fgR.hideVKB();
          AppMethodBeat.o(35539);
          return false;
        }
      });
      break;
    }
  }
  
  public final void hQt()
  {
    AppMethodBeat.i(35552);
    Log.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.WOe = false;
    this.WOf = true;
    if (this.WOa != null) {
      this.WOa.setVisibility(8);
    }
    if (this.WOc != null) {
      this.WOc.setVisibility(8);
    }
    if (this.WOb != null) {
      this.WOb.setVisibility(8);
    }
    this.fgR.avp(0);
    this.fgR.hideVKB();
    AppMethodBeat.o(35552);
  }
  
  public final boolean hQu()
  {
    return this.WOe;
  }
  
  public final v hQv()
  {
    return this.WOd;
  }
  
  public final boolean hQw()
  {
    return this.WNT;
  }
  
  public final boolean hQx()
  {
    return this.WNS;
  }
  
  public final boolean hQy()
  {
    return this.WNV;
  }
  
  public final boolean hQz()
  {
    return this.WNW;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35554);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((k)this.fgR.bC(k.class)).hNH()) && (this.WOe)) {
      hQt();
    }
    AppMethodBeat.o(35554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.az
 * JD-Core Version:    0.7.0.1
 */