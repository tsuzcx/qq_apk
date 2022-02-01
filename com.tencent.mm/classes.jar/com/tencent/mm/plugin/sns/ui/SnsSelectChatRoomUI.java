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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsSelectChatRoomUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> jVV;
  
  public SnsSelectChatRoomUI()
  {
    AppMethodBeat.i(98988);
    this.jVV = new HashSet();
    AppMethodBeat.o(98988);
  }
  
  private void ani()
  {
    AppMethodBeat.i(98989);
    if (this.jVV.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(98989);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(98989);
  }
  
  private ArrayList<String> fiB()
  {
    AppMethodBeat.i(98990);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.jVV.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add((String)localIterator.next());
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(98990);
    return localArrayList;
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(203628);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SnsSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(203628);
      return;
    }
    paramView = gUP().anH(i);
    if (paramView == null)
    {
      AppMethodBeat.o(203628);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(203628);
      return;
    }
    if (paramView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(203628);
      return;
    }
    paramView = paramView.contact.field_username;
    gUW();
    this.zoy.bev(paramView);
    if (this.jVV.contains(paramView)) {
      this.jVV.remove(paramView);
    }
    for (;;)
    {
      gUQ().notifyDataSetChanged();
      ani();
      AppMethodBeat.o(203628);
      return;
      this.jVV.add(paramView);
    }
  }
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(98997);
    if (paramInt == 1)
    {
      this.jVV.remove(paramString);
      gUP().notifyDataSetChanged();
      ani();
    }
    AppMethodBeat.o(98997);
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
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.jVV.contains(parama.contact.field_username);
      AppMethodBeat.o(98999);
      return bool;
    }
    AppMethodBeat.o(98999);
    return false;
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(98992);
    super.amZ();
    Object localObject = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = Util.stringToList((String)localObject, ",");
      if (!Util.isNullOrNil((List)localObject)) {
        this.jVV.addAll((Collection)localObject);
      }
    }
    AppMethodBeat.o(98992);
  }
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(98993);
    String str = getContext().getString(2131766091);
    AppMethodBeat.o(98993);
    return str;
  }
  
  public final q bmC()
  {
    AppMethodBeat.i(98994);
    com.tencent.mm.plugin.sns.ui.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a(this);
    locala.ESo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98986);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof as)))
        {
          paramAnonymousView = (as)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98986);
      }
    };
    AppMethodBeat.o(98994);
    return locala;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(98995);
    com.tencent.mm.plugin.sns.ui.a.b localb = new com.tencent.mm.plugin.sns.ui.a.b(this);
    localb.ESo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98987);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof as)))
        {
          paramAnonymousView = (as)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98987);
      }
    };
    AppMethodBeat.o(98995);
    return localb;
  }
  
  public final boolean bmz()
  {
    return false;
  }
  
  public final int[] egI()
  {
    return new int[] { 131075 };
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98991);
    super.onCreate(paramBundle);
    addTextOptionMenu(1, getString(2131755921), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98985);
        SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this));
        AppMethodBeat.o(98985);
        return true;
      }
    }, null, t.b.OGU);
    ani();
    paramBundle = new ArrayList(this.jVV);
    this.zoy.it(paramBundle);
    AppMethodBeat.o(98991);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI
 * JD-Core Version:    0.7.0.1
 */