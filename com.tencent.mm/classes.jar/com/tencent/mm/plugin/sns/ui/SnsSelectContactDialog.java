package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.GridView;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog
  extends MMBaseActivity
{
  private List<String> items;
  private GridView rUp;
  private SnsSelectContactDialog.a rUq;
  
  public SnsSelectContactDialog()
  {
    AppMethodBeat.i(39193);
    this.rUp = null;
    this.rUq = null;
    this.items = new LinkedList();
    AppMethodBeat.o(39193);
  }
  
  private boolean ach(String paramString)
  {
    AppMethodBeat.i(39196);
    String[] arrayOfString = t.fll;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(39196);
        return false;
      }
      i += 1;
    }
    if (t.lA(paramString))
    {
      AppMethodBeat.o(39196);
      return false;
    }
    if (t.nU(paramString))
    {
      AppMethodBeat.o(39196);
      return false;
    }
    if ((this.items != null) && (this.items.contains(paramString)))
    {
      AppMethodBeat.o(39196);
      return false;
    }
    AppMethodBeat.o(39196);
    return true;
  }
  
  private String cvK()
  {
    AppMethodBeat.i(39197);
    Object localObject1 = ((j)g.E(j.class)).YF();
    Object localObject2 = t.flc;
    Object localObject3 = new LinkedList();
    String[] arrayOfString = t.fll;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject3).add(arrayOfString[i]);
      i += 1;
    }
    ((List)localObject3).add("weixin");
    ((List)localObject3).add("officialaccounts");
    ((List)localObject3).add("helper_entry");
    ((List)localObject3).add("filehelper");
    localObject1 = ((be)localObject1).c((String)localObject2, (List)localObject3, "*");
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(39197);
      return "";
    }
    localObject2 = new LinkedList();
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject3 = new ak();
      ((ak)localObject3).convertFrom((Cursor)localObject1);
      if (ach(((au)localObject3).field_username))
      {
        ((List)localObject2).add(((au)localObject3).field_username);
        if (((List)localObject2).size() >= 10) {
          break;
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    localObject1 = bo.d((List)localObject2, ";");
    AppMethodBeat.o(39197);
    return localObject1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39198);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(39198);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39198);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(39198);
        return;
      }
      paramIntent = bo.P(paramIntent.getStringExtra("Select_Contact").split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(39198);
        return;
      }
      if (this.items == null) {
        this.items = new LinkedList();
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        if (!this.items.contains(str)) {
          this.items.add(str);
        }
      }
      ab.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.items.size());
      if (this.rUq != null)
      {
        ab.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
        this.rUq.refresh();
      }
      paramIntent = new Intent();
      paramIntent.putExtra("Select_Contact", bo.d(this.items, ","));
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39194);
    super.onCreate(paramBundle);
    setContentView(2130970813);
    paramBundle = getIntent().getStringExtra("Select_Contact");
    if ((paramBundle == null) || (paramBundle.equals(""))) {
      this.items.clear();
    }
    for (;;)
    {
      this.rUp = ((GridView)findViewById(2131827921));
      this.rUq = new SnsSelectContactDialog.a(this, this, this.items);
      this.rUp.setAdapter(this.rUq);
      this.rUp.setOnItemClickListener(new SnsSelectContactDialog.1(this));
      this.rUp.setSelection(this.rUq.getCount() - 1);
      ((ImageButton)findViewById(2131826502)).setOnClickListener(new SnsSelectContactDialog.2(this));
      AppMethodBeat.o(39194);
      return;
      this.items = bo.P(paramBundle.split(","));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39195);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Contact", bo.d(this.items, ","));
      setResult(-1, localIntent);
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(39195);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog
 * JD-Core Version:    0.7.0.1
 */