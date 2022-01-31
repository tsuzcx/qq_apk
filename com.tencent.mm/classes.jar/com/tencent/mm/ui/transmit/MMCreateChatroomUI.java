package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.pluginsdk.ui.applet.s.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMCreateChatroomUI
  extends MMBaseSelectContactUI
{
  private boolean Afb;
  private List<String> AyJ;
  private boolean AyS;
  a AyT;
  private b AyU;
  private boolean AyV;
  private int scene;
  
  private static List<String> M(List<String> paramList)
  {
    AppMethodBeat.i(35054);
    LinkedList localLinkedList = new LinkedList();
    if (!aw.RG())
    {
      AppMethodBeat.o(35054);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(35054);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aw.aaz();
      ad localad = c.YA().arw(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.euF != 0) {
          paramList = localad.Of();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(35054);
    return localLinkedList;
  }
  
  private void a(com.tencent.mm.roomsdk.a.c.a parama)
  {
    AppMethodBeat.i(35053);
    parama.d(new MMCreateChatroomUI.2(this, parama));
    getString(2131297087);
    parama.a(this, getString(2131301056), true, new MMCreateChatroomUI.3(this, parama));
    AppMethodBeat.o(35053);
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(35044);
    super.Kc();
    this.AyJ = getIntent().getStringArrayListExtra("query_phrase_list");
    this.AyS = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
    AppMethodBeat.o(35044);
  }
  
  public final void Km()
  {
    AppMethodBeat.i(35046);
    List localList = this.AyT.dOh();
    if (localList.size() > 0)
    {
      updateOptionMenuText(1, getString(2131297018) + "(" + localList.size() + ")");
      if (localList.size() > 1)
      {
        enableOptionMenu(1, true);
        AppMethodBeat.o(35046);
        return;
      }
      enableOptionMenu(1, false);
      AppMethodBeat.o(35046);
      return;
    }
    updateOptionMenuText(1, getString(2131297018));
    enableOptionMenu(1, false);
    AppMethodBeat.o(35046);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(35052);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      parama = this.AyT;
      localObject = ((e)localObject).hrL.mRV;
      if (parama.gpQ.contains(localObject))
      {
        AppMethodBeat.o(35052);
        return true;
      }
      AppMethodBeat.o(35052);
      return false;
    }
    AppMethodBeat.o(35052);
    return false;
  }
  
  public final boolean apa()
  {
    return false;
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String apc()
  {
    AppMethodBeat.i(35048);
    String str = getString(2131303063);
    AppMethodBeat.o(35048);
    return str;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(35049);
    if (this.AyT == null) {
      this.AyT = new a(this, this.AyJ, this.scene);
    }
    a locala = this.AyT;
    AppMethodBeat.o(35049);
    return locala;
  }
  
  public final com.tencent.mm.ui.contact.n ape()
  {
    AppMethodBeat.i(35050);
    if (this.AyU == null) {
      this.AyU = new b(this, this.scene);
    }
    b localb = this.AyU;
    AppMethodBeat.o(35050);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(35051);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      a locala = this.AyT;
      localObject = ((e)localObject).hrL.mRV;
      int j = parama.position;
      if (locala.gpQ.contains(localObject))
      {
        int i = locala.AyL.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.AyL.get(i);
          if (j < parama.mTy) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label129;
          }
          if (((String)localObject).equals(parama.AyO)) {
            break label137;
          }
          AppMethodBeat.o(35051);
          return true;
          i -= 1;
          break;
          parama = null;
        }
        label129:
        AppMethodBeat.o(35051);
        return false;
      }
      label137:
      AppMethodBeat.o(35051);
      return false;
    }
    AppMethodBeat.o(35051);
    return false;
  }
  
  public final boolean dMe()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(35045);
    super.initView();
    a locala = this.AyT;
    Iterator localIterator = locala.AyJ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      i locali = new i();
      locali.handler = locala.handler;
      locali.mSU = locala.pym;
      locali.query = ((String)localObject);
      locali.mST = com.tencent.mm.plugin.fts.a.c.b.mTt;
      locali.mSP = new int[] { 131072 };
      locali.mSS.add("filehelper");
      locali.mSS.add(r.Zn());
      localObject = ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).search(2, locali);
      locala.AyK = new ArrayList();
      locala.AyK.add(localObject);
    }
    addTextOptionMenu(1, getString(2131297018), new MMCreateChatroomUI.1(this), null, q.b.zby);
    Km();
    AppMethodBeat.o(35045);
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(35055);
    a locala = this.AyT;
    j localj = this.AyU.mSK;
    Object localObject = this.AyU.query;
    if ((localj.mSW.size() != 1) || (!((l)localj.mSW.get(0)).mRV.equals("no_result​")))
    {
      a.a locala1 = new a.a(locala, (byte)0);
      locala1.mSW = localj.mSW;
      locala1.mRX = localj.mRX;
      locala1.query = ((String)localObject);
      locala.AyL.add(locala1);
      int i = paramInt - locala.Adk.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (l)localj.mSW.remove(i);
        localj.mSW.add(0, localObject);
        paramInt = locala.Adk.getContentLV().getHeaderViewsCount();
      }
      locala.dOg();
      i = locala1.mTy;
      locala.Adk.getContentLV().post(new a.2(locala, i + paramInt + 1));
    }
    dMc();
    dMd();
    hideVKB();
    AppMethodBeat.o(35055);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35047);
    this.AyT.finish();
    if ((!this.AyV) && (this.scene == 3)) {
      k.hR(false);
    }
    super.onDestroy();
    AppMethodBeat.o(35047);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(35056);
    a locala = this.AyT;
    locala.gpQ.remove(paramString);
    Iterator localIterator = locala.AyL.iterator();
    while (localIterator.hasNext())
    {
      a.a locala1 = (a.a)localIterator.next();
      if (paramString.equals(locala1.AyO)) {
        locala1.AyO = null;
      }
    }
    locala.notifyDataSetChanged();
    Km();
    AppMethodBeat.o(35056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI
 * JD-Core Version:    0.7.0.1
 */