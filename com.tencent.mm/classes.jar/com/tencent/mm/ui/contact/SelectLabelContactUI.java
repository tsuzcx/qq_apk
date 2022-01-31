package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.q.b;
import java.util.HashSet;

public class SelectLabelContactUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> AeB;
  private int AeD;
  private HashSet<String> gpQ;
  private String label;
  
  private void Km()
  {
    AppMethodBeat.i(33910);
    if ((t.hI(this.AeD, 64)) && (this.gpQ.size() > 0))
    {
      updateOptionMenuText(1, getString(2131297018) + "(" + this.gpQ.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(33910);
      return;
    }
    updateOptionMenuText(1, getString(2131297018));
    enableOptionMenu(1, false);
    AppMethodBeat.o(33910);
  }
  
  private void auD(String paramString)
  {
    AppMethodBeat.i(33911);
    if (t.hI(this.AeD, 16384))
    {
      localIntent = new Intent();
      localIntent.putExtra("Select_Contact", paramString);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(33911);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    startActivity(localIntent);
    finish();
    AppMethodBeat.o(33911);
  }
  
  protected final void Kc()
  {
    AppMethodBeat.i(33907);
    super.Kc();
    this.label = getIntent().getStringExtra("label");
    this.AeD = getIntent().getIntExtra("list_attr", 0);
    this.gpQ = new HashSet();
    this.AeB = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bo.isNullOrNil(str)) {
      this.AeB.addAll(bo.P(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bo.isNullOrNil(str)) {
      this.gpQ.addAll(bo.P(str.split(",")));
    }
    AppMethodBeat.o(33907);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(33913);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(33913);
      return bool;
    }
    AppMethodBeat.o(33913);
    return false;
  }
  
  protected final boolean apa()
  {
    return false;
  }
  
  protected final boolean apb()
  {
    return false;
  }
  
  protected final String apc()
  {
    return this.label;
  }
  
  protected final p apd()
  {
    AppMethodBeat.i(33912);
    Object localObject = com.tencent.mm.plugin.label.a.a.bKV().RO(this.label);
    localObject = new h(this, t.hI(this.AeD, 64), com.tencent.mm.plugin.label.a.a.bKV().RR((String)localObject));
    AppMethodBeat.o(33912);
    return localObject;
  }
  
  protected final n ape()
  {
    return null;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(33914);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.AeB.contains(parama.contact.field_username);
      AppMethodBeat.o(33914);
      return bool;
    }
    AppMethodBeat.o(33914);
    return false;
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(33909);
    int i = getContentLV().getHeaderViewsCount();
    o localo = dLW();
    Object localObject = localo.Qt(paramInt - i);
    if (localObject == null)
    {
      AppMethodBeat.o(33909);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(33909);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    ab.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[] { localObject });
    if (t.hI(this.AeD, 64))
    {
      if ((!this.AeB.contains(localObject)) && (!this.gpQ.contains(localObject)) && (t.hI(this.AeD, 131072)) && (this.AeB.size() + this.gpQ.size() >= getIntent().getIntExtra("max_limit_num", 2147483647)))
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(2131303050, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 2147483647)) }), getString(2131297056), new SelectLabelContactUI.2(this));
        AppMethodBeat.o(33909);
        return;
      }
      if (!this.AeB.contains(localObject))
      {
        if (!this.gpQ.contains(localObject)) {
          break label260;
        }
        this.gpQ.remove(localObject);
      }
      for (;;)
      {
        Km();
        localo.notifyDataSetChanged();
        AppMethodBeat.o(33909);
        return;
        label260:
        this.gpQ.add(localObject);
      }
    }
    auD((String)localObject);
    AppMethodBeat.o(33909);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33908);
    super.onCreate(paramBundle);
    if (t.hI(this.AeD, 64)) {
      addTextOptionMenu(1, getString(2131297018), new SelectLabelContactUI.1(this), null, q.b.zby);
    }
    Km();
    AppMethodBeat.o(33908);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI
 * JD-Core Version:    0.7.0.1
 */