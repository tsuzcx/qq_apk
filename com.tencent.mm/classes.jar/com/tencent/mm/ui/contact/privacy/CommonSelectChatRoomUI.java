package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CommonSelectChatRoomUI
  extends MMBaseSelectContactUI
{
  private String EdO;
  private HashSet<String> mNi;
  
  public CommonSelectChatRoomUI()
  {
    AppMethodBeat.i(283030);
    this.mNi = new HashSet();
    AppMethodBeat.o(283030);
  }
  
  private void atk()
  {
    AppMethodBeat.i(283032);
    if (this.mNi.size() > 0) {
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      updateOptionMenuText(1, getString(i.j.app_nextstep) + "(" + this.mNi.size() + ")");
      AppMethodBeat.o(283032);
      return;
      enableOptionMenu(1, false);
    }
  }
  
  private ArrayList<String> fWP()
  {
    AppMethodBeat.i(283033);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.mNi.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add((String)localIterator.next());
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(283033);
    return localArrayList;
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(283045);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.CommonSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(283045);
      return;
    }
    paramView = hUP().awM(i);
    if (paramView == null)
    {
      AppMethodBeat.o(283045);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(283045);
      return;
    }
    if (paramView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(283045);
      return;
    }
    paramView = paramView.contact.field_username;
    hUZ();
    this.ETP.bqR(paramView);
    if (this.mNi.contains(paramView)) {
      this.mNi.remove(paramView);
    }
    for (;;)
    {
      hUQ().notifyDataSetChanged();
      atk();
      AppMethodBeat.o(283045);
      return;
      this.mNi.add(paramView);
    }
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(283043);
    if (paramInt == 1)
    {
      this.mNi.remove(paramString);
      hUP().notifyDataSetChanged();
      atk();
    }
    AppMethodBeat.o(283043);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(283040);
    super.a(paramListView, paramInt);
    AppMethodBeat.o(283040);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(283047);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.mNi.contains(parama.contact.field_username);
      AppMethodBeat.o(283047);
      return bool;
    }
    AppMethodBeat.o(283047);
    return false;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(283036);
    super.ata();
    this.EdO = getIntent().getStringExtra("privacy_source_type");
    Log.i("MicroMsg.CommonSelectChatRoomUI", "initData, blackType = %s.", new Object[] { this.EdO });
    AppMethodBeat.o(283036);
  }
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    return "";
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(283037);
    com.tencent.mm.plugin.sns.ui.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a(this);
    locala.Lgr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(278270);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/CommonSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof as)))
        {
          paramAnonymousView = (as)paramAnonymousView.getTag();
          CommonSelectChatRoomUI.a(CommonSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/CommonSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(278270);
      }
    };
    AppMethodBeat.o(283037);
    return locala;
  }
  
  public final p bwL()
  {
    AppMethodBeat.i(283038);
    com.tencent.mm.plugin.sns.ui.a.b localb = new com.tencent.mm.plugin.sns.ui.a.b(this);
    localb.Lgr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/CommonSelectChatRoomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof as)))
        {
          paramAnonymousView = (as)paramAnonymousView.getTag();
          CommonSelectChatRoomUI.a(CommonSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/CommonSelectChatRoomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264307);
      }
    };
    AppMethodBeat.o(283038);
    return localb;
  }
  
  public final int[] dvA()
  {
    return new int[] { 131075 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(283041);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      Log.i("MicroMsg.CommonSelectChatRoomUI", "onActivityResult, resultCode = %s.", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(283041);
      return;
    }
    if (paramInt1 == 0)
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Contact", paramIntent);
      setResult(-1, localIntent);
      finish();
    }
    AppMethodBeat.o(283041);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(283034);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(278819);
        CommonSelectChatRoomUI.this.finish();
        AppMethodBeat.o(278819);
        return false;
      }
    });
    addTextOptionMenu(1, getString(i.j.app_nextstep), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(286426);
        CommonSelectChatRoomUI.a(CommonSelectChatRoomUI.this, CommonSelectChatRoomUI.a(CommonSelectChatRoomUI.this));
        AppMethodBeat.o(286426);
        return true;
      }
    }, null, w.b.Wao);
    atk();
    AppMethodBeat.o(283034);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.CommonSelectChatRoomUI
 * JD-Core Version:    0.7.0.1
 */