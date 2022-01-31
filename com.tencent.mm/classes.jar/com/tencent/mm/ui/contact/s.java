package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class s
  extends r
{
  private List<String> AdC;
  private Map<String, String> AdQ;
  private List<String> AdR;
  private n.a Adj;
  private ak handler;
  private String query;
  
  public s(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, String paramString)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean, 0);
    AppMethodBeat.i(105251);
    this.AdQ = new HashMap();
    this.AdR = new ArrayList();
    this.handler = new ak(Looper.getMainLooper());
    this.AdC = paramList;
    if (!bo.isNullOrNil(paramString))
    {
      this.AdR = bo.P(paramString.split(","));
      if (this.AdR != null)
      {
        paramMMBaseSelectContactUI = this.AdR.iterator();
        while (paramMMBaseSelectContactUI.hasNext())
        {
          paramList = (String)paramMMBaseSelectContactUI.next();
          paramString = ((b)g.E(b.class)).nE(paramList);
          if (!bo.isNullOrNil(paramString)) {
            this.AdQ.put(paramString, paramList);
          }
        }
      }
    }
    Kc();
    AppMethodBeat.o(105251);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(105253);
    this.query = null;
    clearCache();
    AppMethodBeat.o(105253);
  }
  
  public final void a(n.a parama)
  {
    this.Adj = parama;
  }
  
  protected final boolean c(a parama)
  {
    return true;
  }
  
  public final void cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105252);
    if (this.Adj != null) {
      this.Adj.w(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(105252);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(105256);
    super.finish();
    Kc();
    AppMethodBeat.o(105256);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(105254);
    if (this.AdR == null)
    {
      AppMethodBeat.o(105254);
      return 0;
    }
    int i = this.AdR.size();
    AppMethodBeat.o(105254);
    return i;
  }
  
  protected final a mM(int paramInt)
  {
    AppMethodBeat.i(105255);
    e locale = new e(paramInt);
    locale.query = this.query;
    g.RM();
    locale.contact = ((j)g.E(j.class)).YA().aru((String)this.AdR.get(paramInt));
    locale.Adl = cni();
    AppMethodBeat.o(105255);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.s
 * JD-Core Version:    0.7.0.1
 */