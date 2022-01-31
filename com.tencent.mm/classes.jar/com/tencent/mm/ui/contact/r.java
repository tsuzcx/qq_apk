package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class r
  extends q
{
  private String bVk;
  private ah handler = new ah(Looper.getMainLooper());
  private m.a vLH;
  private List<String> vMa;
  private Map<String, String> vMo = new HashMap();
  private List<String> vMp = new ArrayList();
  
  public r(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, String paramString)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean, 0);
    this.vMa = paramList;
    if (!bk.bl(paramString))
    {
      this.vMp = bk.G(paramString.split(","));
      if (this.vMp != null)
      {
        paramMMBaseSelectContactUI = this.vMp.iterator();
        while (paramMMBaseSelectContactUI.hasNext())
        {
          paramList = (String)paramMMBaseSelectContactUI.next();
          paramString = ((b)g.r(b.class)).gV(paramList);
          if (!bk.bl(paramString)) {
            this.vMo.put(paramString, paramList);
          }
        }
      }
    }
    xK();
  }
  
  private void xK()
  {
    this.bVk = null;
    clearCache();
  }
  
  public final void a(m.a parama)
  {
    this.vLH = parama;
  }
  
  public final void bN(String paramString, boolean paramBoolean)
  {
    if (this.vLH != null) {
      this.vLH.t(paramString, getCount(), paramBoolean);
    }
  }
  
  protected final boolean c(a parama)
  {
    return true;
  }
  
  public final void finish()
  {
    super.finish();
    xK();
  }
  
  public final int getCount()
  {
    if (this.vMp == null) {
      return 0;
    }
    return this.vMp.size();
  }
  
  protected final a jQ(int paramInt)
  {
    d locald = new d(paramInt);
    locald.bVk = this.bVk;
    g.DQ();
    locald.dnp = ((j)g.r(j.class)).Fw().abj((String)this.vMp.get(paramInt));
    locald.vLJ = bBJ();
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r
 * JD-Core Version:    0.7.0.1
 */