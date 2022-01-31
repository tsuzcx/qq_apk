package com.tencent.mm.ui.chatting.b;

import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.sc;
import com.tencent.mm.h.a.sd;
import com.tencent.mm.h.a.sd.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.x;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.b.a.a(cFA=ag.class)
public class an
  extends a
  implements ag
{
  private av vte = new av(5, "msg-translate-update-worker");
  private HashMap<Long, ChattingItemTranslate.b> vtf = new HashMap();
  private com.tencent.mm.sdk.b.c vtg = new an.2(this);
  
  private void f(bi parambi, boolean paramBoolean)
  {
    if ((parambi.cvw()) && (!paramBoolean)) {
      if (parambi.cvB())
      {
        if (parambi.cvw()) {
          parambi.ff(parambi.czq & 0xFFFFFFEF);
        }
        a(parambi.field_msgId, ChattingItemTranslate.b.vGa);
        com.tencent.mm.modelstat.b.eBD.a(parambi, false);
        au.Hx();
        com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
        this.byx.axW();
      }
    }
    while (ba(parambi) == ChattingItemTranslate.b.vGc) {
      for (;;)
      {
        return;
        parambi.cvC();
        a(parambi.field_msgId, ChattingItemTranslate.b.vGd);
        com.tencent.mm.modelstat.b.eBD.a(parambi, true);
      }
    }
    sc localsc = new sc();
    localsc.cbJ.cbL = false;
    localsc.cbJ.id = parambi.field_msgId;
    localsc.cbJ.cbK = parambi.field_content;
    localsc.cbJ.cbM = parambi.cQQ;
    if ((!this.byx.cFE()) || (parambi.field_isSend == 1)) {}
    for (localsc.cbJ.type = 0;; localsc.cbJ.type = 1)
    {
      localsc.cbJ.aWf = this.byx.getTalkerUserName();
      com.tencent.mm.sdk.b.a.udP.m(localsc);
      a(parambi.field_msgId, ChattingItemTranslate.b.vGc);
      break;
    }
  }
  
  public final void a(long paramLong, ChattingItemTranslate.b paramb)
  {
    this.vtf.put(Long.valueOf(paramLong), paramb);
  }
  
  public final boolean b(MenuItem paramMenuItem, bi parambi)
  {
    int j = paramMenuItem.getItemId();
    switch (j)
    {
    default: 
      return false;
    }
    y.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(parambi.getType()), Boolean.valueOf(parambi.cvB()) });
    int i;
    if (j == 124)
    {
      au.Hx();
      if (!((Boolean)com.tencent.mm.model.c.Dz().get(327712, Boolean.valueOf(false))).booleanValue())
      {
        i = R.l.chatting_translate_tips_content;
        au.Hx();
        com.tencent.mm.model.c.Dz().o(327712, Boolean.valueOf(true));
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        c.a locala = new c.a(this.byx.vtz.getContext());
        locala.aeA(this.byx.vtz.getMMResources().getString(i));
        locala.aez(this.byx.vtz.getMMResources().getString(R.l.chatting_translate_tips_title));
        locala.Is(R.l.i_know_it).a(new an.3(this, parambi, paramMenuItem, j));
        locala.aoP().show();
        return true;
        if (j == 125)
        {
          au.Hx();
          if (!((Boolean)com.tencent.mm.model.c.Dz().get(327713, Boolean.valueOf(false))).booleanValue())
          {
            i = R.l.chatting_retranslate_tips_content;
            au.Hx();
            com.tencent.mm.model.c.Dz().o(327713, Boolean.valueOf(true));
          }
        }
      }
      else
      {
        paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          f(parambi, bool);
          return true;
        }
      }
      i = 0;
    }
  }
  
  public final ChattingItemTranslate.b ba(bi parambi)
  {
    ChattingItemTranslate.b localb = (ChattingItemTranslate.b)this.vtf.get(Long.valueOf(parambi.field_msgId));
    Object localObject = localb;
    if (localb == null)
    {
      if (!parambi.cvw()) {
        break label48;
      }
      if (parambi.cvB()) {
        localObject = ChattingItemTranslate.b.vGd;
      }
    }
    else
    {
      return localObject;
    }
    return ChattingItemTranslate.b.vGa;
    label48:
    localObject = new sd();
    ((sd)localObject).cbN.id = parambi.field_msgId;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (((sd)localObject).cbO.cbP)
    {
      localObject = ChattingItemTranslate.b.vGc;
      a(parambi.field_msgId, (ChattingItemTranslate.b)localObject);
      return localObject;
    }
    return ChattingItemTranslate.b.vGa;
  }
  
  public final String bb(bi parambi)
  {
    String str = parambi.field_content;
    int i = parambi.field_isSend;
    parambi = str;
    if (this.byx.cFD())
    {
      parambi = str;
      if (str != null)
      {
        parambi = str;
        if (i == 0) {
          parambi = bd.iJ(str);
        }
      }
    }
    return parambi;
  }
  
  public final void cyO()
  {
    this.vtf.clear();
    com.tencent.mm.sdk.b.a.udP.c(this.vtg);
  }
  
  public final void cyR()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.vtg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.an
 * JD-Core Version:    0.7.0.1
 */