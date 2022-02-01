package com.tencent.mm.ui.contact.privacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CommonSelectChatRoomUI
  extends MMBaseSelectContactUI
{
  private String JVl;
  private HashSet<String> pJQ;
  
  public CommonSelectChatRoomUI()
  {
    AppMethodBeat.i(253336);
    this.pJQ = new HashSet();
    AppMethodBeat.o(253336);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(253341);
    if (this.pJQ.size() > 0) {
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      updateOptionMenuText(1, getString(b.j.app_nextstep) + "(" + this.pJQ.size() + ")");
      AppMethodBeat.o(253341);
      return;
      enableOptionMenu(1, false);
    }
  }
  
  private ArrayList<String> hpi()
  {
    AppMethodBeat.i(253350);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.pJQ.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add((String)localIterator.next());
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(253350);
    return localArrayList;
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253458);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.CommonSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(253458);
      return;
    }
    paramAdapterView = jyE().aDt(i);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(253458);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(253458);
      return;
    }
    if (paramAdapterView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(253458);
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
      AppMethodBeat.o(253458);
      return;
      this.pJQ.add(paramAdapterView);
    }
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(253439);
    super.a(paramListView, paramInt);
    AppMethodBeat.o(253439);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(253463);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.pJQ.contains(parama.contact.field_username);
      AppMethodBeat.o(253463);
      return bool;
    }
    AppMethodBeat.o(253463);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(253396);
    super.aNi();
    this.JVl = getIntent().getStringExtra("privacy_source_type");
    Log.i("MicroMsg.CommonSelectChatRoomUI", "initData, blackType = %s.", new Object[] { this.JVl });
    AppMethodBeat.o(253396);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(253447);
    if (paramInt == 1)
    {
      this.pJQ.remove(paramString);
      jyE().notifyDataSetChanged();
      aNr();
    }
    AppMethodBeat.o(253447);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(253421);
    com.tencent.mm.plugin.sns.ui.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a(this);
    locala.RGB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253366);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/CommonSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof au)))
        {
          paramAnonymousView = (au)paramAnonymousView.getTag();
          CommonSelectChatRoomUI.a(CommonSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/CommonSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253366);
      }
    };
    AppMethodBeat.o(253421);
    return locala;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(253423);
    com.tencent.mm.plugin.sns.ui.a.b localb = new com.tencent.mm.plugin.sns.ui.a.b(this);
    localb.RGB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253362);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/CommonSelectChatRoomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof au)))
        {
          paramAnonymousView = (au)paramAnonymousView.getTag();
          CommonSelectChatRoomUI.a(CommonSelectChatRoomUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/CommonSelectChatRoomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253362);
      }
    };
    AppMethodBeat.o(253423);
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
    return "";
  }
  
  public final int[] efu()
  {
    return new int[] { 131075 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(253445);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      Log.i("MicroMsg.CommonSelectChatRoomUI", "onActivityResult, resultCode = %s.", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(253445);
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
    AppMethodBeat.o(253445);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253391);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(253380);
        CommonSelectChatRoomUI.this.finish();
        AppMethodBeat.o(253380);
        return false;
      }
    });
    addTextOptionMenu(1, getString(b.j.app_nextstep), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(253377);
        CommonSelectChatRoomUI.a(CommonSelectChatRoomUI.this, CommonSelectChatRoomUI.a(CommonSelectChatRoomUI.this));
        AppMethodBeat.o(253377);
        return true;
      }
    }, null, y.b.adEJ);
    aNr();
    AppMethodBeat.o(253391);
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