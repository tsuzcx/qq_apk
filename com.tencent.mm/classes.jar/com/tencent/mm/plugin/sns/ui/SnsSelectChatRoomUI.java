package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.plugin.sns.ui.a.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsSelectChatRoomUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> iCn;
  
  public SnsSelectChatRoomUI()
  {
    AppMethodBeat.i(98988);
    this.iCn = new HashSet();
    AppMethodBeat.o(98988);
  }
  
  private void WT()
  {
    AppMethodBeat.i(98989);
    if (this.iCn.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(98989);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(98989);
  }
  
  private ArrayList<String> dQe()
  {
    AppMethodBeat.i(98990);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.iCn.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add((String)localIterator.next());
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(98990);
    return localArrayList;
  }
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(98997);
    if (paramInt == 1)
    {
      this.iCn.remove(paramString);
      frq().notifyDataSetChanged();
      WT();
    }
    AppMethodBeat.o(98997);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(98992);
    super.WJ();
    Object localObject = getIntent().getStringExtra("already_select_contact");
    if (!bs.isNullOrNil((String)localObject))
    {
      localObject = bs.lp((String)localObject, ",");
      if (!bs.gY((List)localObject)) {
        this.iCn.addAll((Collection)localObject);
      }
    }
    AppMethodBeat.o(98992);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(98996);
    super.a(paramListView, paramInt);
    AppMethodBeat.o(98996);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(98999);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.iCn.contains(parama.contact.field_username);
      AppMethodBeat.o(98999);
      return bool;
    }
    AppMethodBeat.o(98999);
    return false;
  }
  
  public final boolean aOi()
  {
    return false;
  }
  
  public final boolean aOj()
  {
    return false;
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(98993);
    String str = getContext().getString(2131763864);
    AppMethodBeat.o(98993);
    return str;
  }
  
  public final q aOl()
  {
    AppMethodBeat.i(98994);
    com.tencent.mm.plugin.sns.ui.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a(this);
    locala.yZl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98986);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof ai)))
        {
          paramAnonymousView = (ai)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        AppMethodBeat.o(98986);
      }
    };
    AppMethodBeat.o(98994);
    return locala;
  }
  
  public final o aOm()
  {
    AppMethodBeat.i(98995);
    b localb = new b(this);
    localb.yZl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98987);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof ai)))
        {
          paramAnonymousView = (ai)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        AppMethodBeat.o(98987);
      }
    };
    AppMethodBeat.o(98995);
    return localb;
  }
  
  public final int[] daw()
  {
    return new int[] { 131075 };
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98991);
    super.onCreate(paramBundle);
    addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98985);
        SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this));
        AppMethodBeat.o(98985);
        return true;
      }
    }, null, s.b.Hom);
    WT();
    paramBundle = new ArrayList(this.iCn);
    this.uFo.gR(paramBundle);
    AppMethodBeat.o(98991);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(98998);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ac.i("MicroMsg.SnsSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(98998);
      return;
    }
    Object localObject = frq().abQ(i);
    if (localObject == null)
    {
      AppMethodBeat.o(98998);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(98998);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(98998);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    frx();
    this.uFo.aGU((String)localObject);
    if (this.iCn.contains(localObject)) {
      this.iCn.remove(localObject);
    }
    for (;;)
    {
      frr().notifyDataSetChanged();
      WT();
      AppMethodBeat.o(98998);
      return;
      this.iCn.add(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI
 * JD-Core Version:    0.7.0.1
 */