package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsSelectChatRoomUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> pJQ;
  
  public SnsSelectChatRoomUI()
  {
    AppMethodBeat.i(98988);
    this.pJQ = new HashSet();
    AppMethodBeat.o(98988);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(98989);
    if (this.pJQ.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(98989);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(98989);
  }
  
  private ArrayList<String> hpi()
  {
    AppMethodBeat.i(98990);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.pJQ.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add((String)localIterator.next());
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(98990);
    return localArrayList;
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(308341);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SnsSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(308341);
      return;
    }
    paramAdapterView = jyE().aDt(i);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(308341);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(308341);
      return;
    }
    if (paramAdapterView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(308341);
      return;
    }
    paramAdapterView = paramAdapterView.contact.field_username;
    iKA();
    this.KOt.bqG(paramAdapterView);
    if (this.pJQ.contains(paramAdapterView)) {
      this.pJQ.remove(paramAdapterView);
    }
    for (;;)
    {
      jyF().notifyDataSetChanged();
      aNr();
      AppMethodBeat.o(308341);
      return;
      this.pJQ.add(paramAdapterView);
    }
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
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.pJQ.contains(parama.contact.field_username);
      AppMethodBeat.o(98999);
      return bool;
    }
    AppMethodBeat.o(98999);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(98992);
    super.aNi();
    Object localObject = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = Util.stringToList((String)localObject, ",");
      if (!Util.isNullOrNil((List)localObject)) {
        this.pJQ.addAll((Collection)localObject);
      }
    }
    AppMethodBeat.o(98992);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(98997);
    if (paramInt == 1)
    {
      this.pJQ.remove(paramString);
      jyE().notifyDataSetChanged();
      aNr();
    }
    AppMethodBeat.o(98997);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(98994);
    com.tencent.mm.plugin.sns.ui.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a(this);
    locala.RGB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98986);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof au)))
        {
          paramAnonymousView = (au)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98986);
      }
    };
    AppMethodBeat.o(98994);
    return locala;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(98995);
    com.tencent.mm.plugin.sns.ui.a.b localb = new com.tencent.mm.plugin.sns.ui.a.b(this);
    localb.RGB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98987);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof au)))
        {
          paramAnonymousView = (au)paramAnonymousView.getTag();
          SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98987);
      }
    };
    AppMethodBeat.o(98995);
    return localb;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(98993);
    String str = getContext().getString(b.j.sns_label_group_title);
    AppMethodBeat.o(98993);
    return str;
  }
  
  public final int[] efu()
  {
    return new int[] { 131075 };
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98991);
    super.onCreate(paramBundle);
    addTextOptionMenu(1, getString(b.j.app_ok), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98985);
        SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this));
        AppMethodBeat.o(98985);
        return true;
      }
    }, null, y.b.adEJ);
    aNr();
    paramBundle = new ArrayList(this.pJQ);
    this.KOt.mv(paramBundle);
    AppMethodBeat.o(98991);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI
 * JD-Core Version:    0.7.0.1
 */