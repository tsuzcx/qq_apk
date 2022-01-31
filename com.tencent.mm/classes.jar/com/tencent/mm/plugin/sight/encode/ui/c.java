package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends o
{
  public static boolean ohU = true;
  public static boolean ohV = false;
  List<String> ohS = null;
  boolean ohT = true;
  
  public c(l paraml)
  {
    super(paraml, new ArrayList(), true, true);
  }
  
  public static boolean MJ(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return paramString.endsWith("@sns.tencent");
  }
  
  public static boolean MK(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return paramString.endsWith("@search.tencent");
  }
  
  public static boolean ML(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return paramString.endsWith("@draft.tencent");
  }
  
  public final boolean bBJ()
  {
    return this.ohT;
  }
  
  public final int getCount()
  {
    if (this.ohS == null) {
      return 0;
    }
    return this.ohS.size();
  }
  
  protected final a jQ(int paramInt)
  {
    if (this.ohS == null) {
      return null;
    }
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      y.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    a locala = new a(paramInt);
    Object localObject = (String)this.ohS.get(paramInt);
    if (MJ((String)localObject)) {
      localObject = new ad("@sns.tencent");
    }
    for (;;)
    {
      locala.dnp = ((ad)localObject);
      locala.vLJ = this.ohT;
      return locala;
      if (MK((String)localObject))
      {
        localObject = new ad("@search.tencent");
      }
      else if (ML((String)localObject))
      {
        localObject = new ad("@draft.tencent");
      }
      else
      {
        au.Hx();
        localObject = com.tencent.mm.model.c.Fw().abl((String)this.ohS.get(paramInt));
      }
    }
  }
  
  public final class a
    extends d
  {
    public a(int paramInt)
    {
      super();
    }
    
    protected final a.a VA()
    {
      return new c.a.a(this);
    }
    
    public final a.b Vz()
    {
      return new c.a.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c
 * JD-Core Version:    0.7.0.1
 */