package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.x;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.y.class)
public class af
  extends a
  implements com.tencent.mm.ui.chatting.b.b.y
{
  private n drn = null;
  private View vrN;
  public boolean vrO = false;
  public boolean vrP = false;
  public boolean vrQ = false;
  public boolean vrR = false;
  private long vrS = -1L;
  private ArrayList<String> vrT;
  public boolean vrU = false;
  private TextView vrV;
  private ListView vrW;
  private View vrX;
  private v vrY;
  public boolean vrZ = false;
  private boolean vsa = true;
  private int vsb = 0;
  private boolean vsc = false;
  
  public final void He(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.vrZ), Boolean.valueOf(this.vsa) });
    if ((!this.vrO) && (!this.vrZ))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
      return;
    }
    if ((this.vsa) && (paramInt >= 0))
    {
      this.vsa = false;
      com.tencent.mm.plugin.report.service.h.nFQ.f(10811, new Object[] { Integer.valueOf(2) });
    }
    if (paramInt > 0)
    {
      this.vrW.setVisibility(0);
      this.byx.GU(8);
      this.vrV.setVisibility(8);
      this.vrX.setVisibility(8);
      return;
    }
    if (paramInt == 0)
    {
      this.vrW.setVisibility(8);
      this.byx.GU(8);
      this.vrV.setVisibility(0);
      this.vrX.setVisibility(8);
      return;
    }
    this.vrW.setVisibility(8);
    this.byx.GU(0);
    this.vrV.setVisibility(8);
    this.vrX.setVisibility(0);
  }
  
  public final void cDC()
  {
    super.cDC();
    this.vsc = true;
    if (this.vrY != null) {
      this.vrY.bcS();
    }
    if (this.drn != null) {
      this.drn.clearFocus();
    }
  }
  
  public final ArrayList<String> cFd()
  {
    return this.vrT;
  }
  
  public final boolean cFe()
  {
    return this.vrQ;
  }
  
  public final void cFf()
  {
    if (this.vrN == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.ChattingUI.SearchComponent", "enter edit search mode, search stub view is null?%B", new Object[] { Boolean.valueOf(bool) });
      this.vrZ = true;
      this.byx.GU(8);
      if (this.vrN == null) {
        break;
      }
      this.vrN.setVisibility(0);
      if (this.vrY != null) {
        this.vrY.talker = this.byx.getTalkerUserName();
      }
      He(-1);
      return;
    }
    i.a(this.byx.vtz, R.h.search_chat_content_ly);
    this.vrN = this.byx.findViewById(R.h.search_content);
    this.vrN.setVisibility(0);
    this.vrX = this.byx.findViewById(R.h.search_chat_content_bg);
    this.byx.getListView().setFocusable(false);
    this.byx.getListView().setFocusableInTouchMode(false);
    this.vrX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView) {}
    });
    this.vrX.setVisibility(8);
    this.vrV = ((TextView)this.byx.findViewById(R.h.empty_search_result_tv));
    if ((this.byx.cFD()) || (((c)this.byx.ac(c.class)).cDH())) {}
    for (bool = true;; bool = false)
    {
      this.vrY = new v(this.byx.vtz.getContext(), new bi(), this.byx.getTalkerUserName(), this.byx.cFB(), bool);
      this.vrY.vkW = new af.9(this);
      this.vrW = ((ListView)this.byx.findViewById(R.h.search_chat_content_lv));
      this.vrW.setVisibility(0);
      this.vrW.setAdapter(this.vrY);
      this.vrW.setOnItemClickListener(new af.10(this));
      this.vrW.setOnTouchListener(new af.2(this));
      break;
    }
  }
  
  public final void cFg()
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
    this.vrZ = false;
    this.vsa = true;
    if (this.vrV != null) {
      this.vrV.setVisibility(8);
    }
    if (this.vrX != null) {
      this.vrX.setVisibility(8);
    }
    if (this.vrW != null) {
      this.vrW.setVisibility(8);
    }
    this.byx.GU(0);
    this.byx.XM();
  }
  
  public final boolean cFh()
  {
    return this.vrZ;
  }
  
  public final v cFi()
  {
    return this.vrY;
  }
  
  public final boolean cFj()
  {
    return this.vrP;
  }
  
  public final boolean cFk()
  {
    return this.vrO;
  }
  
  public final boolean cFl()
  {
    return this.vrR;
  }
  
  public final boolean cFm()
  {
    return this.vrU;
  }
  
  public final void cyM()
  {
    this.vrO = this.byx.vtz.getBooleanExtra("search_chat_content", false).booleanValue();
    this.vrP = this.byx.vtz.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
    this.vrT = this.byx.vtz.getStringArrayList("highlight_keyword_list");
    this.vrS = this.byx.vtz.getLongExtra("msg_local_id", -1L);
    this.vrR = this.byx.vtz.getBooleanExtra("from_global_search", false).booleanValue();
    this.vrQ = this.byx.vtz.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
  }
  
  public final void cyN()
  {
    if ((this.vrS >= 0L) && (!this.vsc)) {
      ai.l(new Runnable()
      {
        public final void run()
        {
          if (!af.a(af.this))
          {
            af.b(af.this);
            af.c(af.this);
            if (af.this.byx != null) {
              af.this.byx.axW();
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
          }
        }
      }, 2000L);
    }
    if (this.vrO)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
      com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 11L, 1L, true);
      i.a(this.byx.vtz, R.h.search_chat_content_ly);
      this.vrN = this.byx.findViewById(R.h.search_content);
      this.vrX = this.byx.findViewById(R.h.search_chat_content_bg);
      this.byx.getListView().setFocusable(false);
      this.byx.getListView().setFocusableInTouchMode(false);
      this.vrX.setOnClickListener(new af.3(this));
      if (this.vrV == null)
      {
        i.a(this.byx.vtz, R.h.viewstub_empty_search);
        this.vrV = ((TextView)this.byx.findViewById(R.h.empty_search_result_tv));
      }
      if ((!this.byx.cFD()) && (!((c)this.byx.ac(c.class)).cDH())) {
        break label431;
      }
    }
    label431:
    for (boolean bool = true;; bool = false)
    {
      this.vrY = new v(this.byx.vtz.getContext(), new bi(), this.byx.getTalkerUserName(), this.byx.cFB(), bool);
      this.vrY.vkW = new af.4(this);
      this.vrW = ((ListView)this.byx.findViewById(R.h.search_chat_content_lv));
      this.vrW.setAdapter(this.vrY);
      this.vrW.setOnItemClickListener(new af.5(this));
      this.vrW.setOnTouchListener(new af.6(this));
      this.drn = new n();
      this.drn.weq = new af.7(this);
      this.byx.vtz.addSearchMenu(true, this.drn);
      this.drn.nK(true);
      if ((this.vrP) || (this.vrR))
      {
        long l = this.byx.vtz.getLongExtra("msg_local_id", -1L);
        ((g)this.byx.ac(g.class)).a(l, this.vrR, d.a.vyf);
      }
      return;
    }
  }
  
  public final void cyQ()
  {
    if (this.vrZ)
    {
      cFg();
      ((com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class)).cEi();
    }
  }
  
  public final boolean hR(long paramLong)
  {
    return (this.vrS == paramLong) && (this.vrR) && (this.vrT != null) && (this.vrT.size() > 0);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((((g)this.byx.ac(g.class)).isInEditMode()) && (this.vrZ)) {
      cFg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.af
 * JD-Core Version:    0.7.0.1
 */