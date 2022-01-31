package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.sns.ui.a.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsSelectChatRoomUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> gpQ;
  
  public SnsSelectChatRoomUI()
  {
    AppMethodBeat.i(145554);
    this.gpQ = new HashSet();
    AppMethodBeat.o(145554);
  }
  
  private void Km()
  {
    AppMethodBeat.i(145555);
    if (this.gpQ.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(145555);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(145555);
  }
  
  private ArrayList<String> cvJ()
  {
    AppMethodBeat.i(145556);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.gpQ.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add((String)localIterator.next());
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(145556);
    return localArrayList;
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(145558);
    super.Kc();
    Object localObject = getIntent().getStringExtra("already_select_contact");
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = bo.ih((String)localObject, ",");
      if (!bo.es((List)localObject)) {
        this.gpQ.addAll((Collection)localObject);
      }
    }
    AppMethodBeat.o(145558);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(145562);
    super.a(paramListView, paramInt);
    AppMethodBeat.o(145562);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(145565);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(145565);
      return bool;
    }
    AppMethodBeat.o(145565);
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
    AppMethodBeat.i(145559);
    String str = getContext().getString(2131303855);
    AppMethodBeat.o(145559);
    return str;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(145560);
    com.tencent.mm.plugin.sns.ui.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a(this);
    locala.sdq = new SnsSelectChatRoomUI.2(this);
    AppMethodBeat.o(145560);
    return locala;
  }
  
  public final n ape()
  {
    AppMethodBeat.i(145561);
    b localb = new b(this);
    localb.sdq = new SnsSelectChatRoomUI.3(this);
    AppMethodBeat.o(145561);
    return localb;
  }
  
  public final int[] bOp()
  {
    return new int[] { 131075 };
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(145564);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ab.i("MicroMsg.SnsSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(145564);
      return;
    }
    Object localObject = dLW().Qt(i);
    if (localObject == null)
    {
      AppMethodBeat.o(145564);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(145564);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(145564);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    dMc();
    this.oCs.ama((String)localObject);
    if (this.gpQ.contains(localObject)) {
      this.gpQ.remove(localObject);
    }
    for (;;)
    {
      dLX().notifyDataSetChanged();
      Km();
      AppMethodBeat.o(145564);
      return;
      this.gpQ.add(localObject);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(145557);
    super.onCreate(paramBundle);
    addTextOptionMenu(1, getString(2131297018), new SnsSelectChatRoomUI.1(this), null, q.b.zby);
    Km();
    paramBundle = this.gpQ.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.oCs.amc(str);
    }
    AppMethodBeat.o(145557);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(145563);
    this.gpQ.remove(paramString);
    dLW().notifyDataSetChanged();
    Km();
    AppMethodBeat.o(145563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI
 * JD-Core Version:    0.7.0.1
 */