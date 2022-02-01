package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ConvBoxTransmitUI
  extends SelectConversationUI
{
  private a afMk;
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(250809);
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    AppMethodBeat.o(250809);
  }
  
  public final void a(ListView paramListView, int paramInt) {}
  
  public final r bVA()
  {
    AppMethodBeat.i(250802);
    this.afMk = new a(this, this.afeW, this.afOf, this.afNW);
    a locala = this.afMk;
    AppMethodBeat.o(250802);
    return locala;
  }
  
  public final p bVB()
  {
    return null;
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
    AppMethodBeat.i(250798);
    String str = getString(R.l.gDt);
    AppMethodBeat.o(250798);
    return str;
  }
  
  public final void fYZ()
  {
    AppMethodBeat.i(250808);
    if (this.afOf)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Conv_User", Util.listToString(this.afOg, ","));
      setResult(0, localIntent);
    }
    super.fYZ();
    AppMethodBeat.o(250808);
  }
  
  protected final boolean jDw()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(250811);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(250811);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250805);
    this.afOf = getIntent().getBooleanExtra("KIsMultiSelect", false);
    if (this.afOf)
    {
      localObject = getIntent().getStringExtra("Select_Conv_User");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label96;
      }
    }
    label96:
    for (Object localObject = new LinkedList();; localObject = Util.stringsToList(((String)localObject).split(",")))
    {
      this.afOg = ((List)localObject);
      if (this.afOg == null) {
        this.afOg = new ArrayList();
      }
      this.afOh = new HashMap();
      super.onCreate(paramBundle);
      AppMethodBeat.o(250805);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends r
    implements MStorageEx.IOnStorageChange
  {
    private Cursor afMl;
    
    public a(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super(null, paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.i(250875);
      aNm();
      ((n)h.ax(n.class)).bzG().add(this);
      AppMethodBeat.o(250875);
    }
    
    private void fSd()
    {
      AppMethodBeat.i(250876);
      if (this.afMl != null)
      {
        this.afMl.close();
        this.afMl = null;
      }
      AppMethodBeat.o(250876);
    }
    
    public final void aNm()
    {
      AppMethodBeat.i(250885);
      Log.i("MicroMsg.ConvBoxTransmitUI.ConvBoxTransmitAdapter", "resetData");
      fSd();
      bh.bCz();
      this.afMl = c.bzG().a(5, cVa(), "conversationboxservice");
      AppMethodBeat.o(250885);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(250892);
      super.finish();
      Log.i("MicroMsg.ConvBoxTransmitUI.ConvBoxTransmitAdapter", "finish!");
      fSd();
      ((n)h.ax(n.class)).bzG().remove(this);
      AppMethodBeat.o(250892);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(250878);
      if (this.afMl == null)
      {
        Log.e("MicroMsg.ConvBoxTransmitUI.ConvBoxTransmitAdapter", "getCount: dataCursor == null ");
        AppMethodBeat.o(250878);
        return 0;
      }
      int i = this.afMl.getCount();
      AppMethodBeat.o(250878);
      return i;
    }
    
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      AppMethodBeat.i(250901);
      aNm();
      notifyDataSetChanged();
      AppMethodBeat.o(250901);
    }
    
    public final a yk(int paramInt)
    {
      AppMethodBeat.i(250880);
      g localg = null;
      if (this.afMl.moveToPosition(paramInt))
      {
        localg = new g(paramInt);
        bb localbb = new bb();
        localbb.convertFrom(this.afMl);
        h.baF();
        localg.contact = ((n)h.ax(n.class)).bzA().bxq(localbb.field_username);
        if (localg.contact == null)
        {
          h.baF();
          localg.contact = ((n)h.ax(n.class)).bzA().bxv(localbb.field_username);
        }
        localg.afey = gZe();
      }
      AppMethodBeat.o(250880);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ConvBoxTransmitUI
 * JD-Core Version:    0.7.0.1
 */