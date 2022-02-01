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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
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
  private HashSet<String> iVx;
  
  public SnsSelectChatRoomUI()
  {
    AppMethodBeat.i(98988);
    this.iVx = new HashSet();
    AppMethodBeat.o(98988);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(98989);
    if (this.iVx.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(98989);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(98989);
  }
  
  private ArrayList<String> ecu()
  {
    AppMethodBeat.i(98990);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.iVx.iterator();
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
      this.iVx.remove(paramString);
      fId().notifyDataSetChanged();
      Zm();
    }
    AppMethodBeat.o(98997);
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(98992);
    super.Zd();
    Object localObject = getIntent().getStringExtra("already_select_contact");
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = bt.lO((String)localObject, ",");
      if (!bt.hj((List)localObject)) {
        this.iVx.addAll((Collection)localObject);
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
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.iVx.contains(parama.contact.field_username);
      AppMethodBeat.o(98999);
      return bool;
    }
    AppMethodBeat.o(98999);
    return false;
  }
  
  public final boolean aRu()
  {
    return false;
  }
  
  public final boolean aRv()
  {
    return false;
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(98993);
    String str = getContext().getString(2131763864);
    AppMethodBeat.o(98993);
    return str;
  }
  
  public final q aRx()
  {
    AppMethodBeat.i(98994);
    com.tencent.mm.plugin.sns.ui.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a(this);
    locala.Arb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98986);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof am)))
        {
          paramAnonymousView = (am)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98986);
      }
    };
    AppMethodBeat.o(98994);
    return locala;
  }
  
  public final o aRy()
  {
    AppMethodBeat.i(98995);
    com.tencent.mm.plugin.sns.ui.a.b localb = new com.tencent.mm.plugin.sns.ui.a.b(this);
    localb.Arb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98987);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof am)))
        {
          paramAnonymousView = (am)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98987);
      }
    };
    AppMethodBeat.o(98995);
    return localb;
  }
  
  public final int[] djJ()
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
    }, null, s.b.JbS);
    Zm();
    paramBundle = new ArrayList(this.iVx);
    this.vIo.hd(paramBundle);
    AppMethodBeat.o(98991);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(98998);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ad.i("MicroMsg.SnsSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(98998);
      return;
    }
    Object localObject = fId().aen(i);
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
    fIk();
    this.vIo.aMx((String)localObject);
    if (this.iVx.contains(localObject)) {
      this.iVx.remove(localObject);
    }
    for (;;)
    {
      fIe().notifyDataSetChanged();
      Zm();
      AppMethodBeat.o(98998);
      return;
      this.iVx.add(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI
 * JD-Core Version:    0.7.0.1
 */