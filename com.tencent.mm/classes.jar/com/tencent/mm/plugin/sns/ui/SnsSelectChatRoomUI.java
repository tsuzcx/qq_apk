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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
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
  private HashSet<String> iYq;
  
  public SnsSelectChatRoomUI()
  {
    AppMethodBeat.i(98988);
    this.iYq = new HashSet();
    AppMethodBeat.o(98988);
  }
  
  private void Zv()
  {
    AppMethodBeat.i(98989);
    if (this.iYq.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(98989);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(98989);
  }
  
  private ArrayList<String> egb()
  {
    AppMethodBeat.i(98990);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.iYq.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add((String)localIterator.next());
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(98990);
    return localArrayList;
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(98997);
    if (paramInt == 1)
    {
      this.iYq.remove(paramString);
      fMv().notifyDataSetChanged();
      Zv();
    }
    AppMethodBeat.o(98997);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(98992);
    super.Zm();
    Object localObject = getIntent().getStringExtra("already_select_contact");
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = bu.lV((String)localObject, ",");
      if (!bu.ht((List)localObject)) {
        this.iYq.addAll((Collection)localObject);
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
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.iYq.contains(parama.contact.field_username);
      AppMethodBeat.o(98999);
      return bool;
    }
    AppMethodBeat.o(98999);
    return false;
  }
  
  public final boolean aRT()
  {
    return false;
  }
  
  public final boolean aRU()
  {
    return false;
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(98993);
    String str = getContext().getString(2131763864);
    AppMethodBeat.o(98993);
    return str;
  }
  
  public final q aRW()
  {
    AppMethodBeat.i(98994);
    com.tencent.mm.plugin.sns.ui.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a(this);
    locala.AIp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98986);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof an)))
        {
          paramAnonymousView = (an)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98986);
      }
    };
    AppMethodBeat.o(98994);
    return locala;
  }
  
  public final o aRX()
  {
    AppMethodBeat.i(98995);
    com.tencent.mm.plugin.sns.ui.a.b localb = new com.tencent.mm.plugin.sns.ui.a.b(this);
    localb.AIp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98987);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof an)))
        {
          paramAnonymousView = (an)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98987);
      }
    };
    AppMethodBeat.o(98995);
    return localb;
  }
  
  public final int[] dmI()
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
    }, null, s.b.JwA);
    Zv();
    paramBundle = new ArrayList(this.iYq);
    this.vUs.hn(paramBundle);
    AppMethodBeat.o(98991);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(98998);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ae.i("MicroMsg.SnsSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(98998);
      return;
    }
    Object localObject = fMv().aeW(i);
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
    fMC();
    this.vUs.aNT((String)localObject);
    if (this.iYq.contains(localObject)) {
      this.iYq.remove(localObject);
    }
    for (;;)
    {
      fMw().notifyDataSetChanged();
      Zv();
      AppMethodBeat.o(98998);
      return;
      this.iYq.add(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI
 * JD-Core Version:    0.7.0.1
 */