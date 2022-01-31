package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

public final class ah
  implements g
{
  HashMap<String, l> jIZ = new HashMap();
  
  public final l NC(String paramString)
  {
    return (l)this.jIZ.get(paramString);
  }
  
  public final boolean a(l paraml)
  {
    if ((paraml == null) || (bk.bl(paraml.field_userName))) {
      return false;
    }
    af.bDp().post(new ah.3(this, paraml));
    return true;
  }
  
  public final boolean bDV()
  {
    af.bDp().post(new ah.1(this));
    return true;
  }
  
  public final boolean bDW()
  {
    af.bDp().post(new ah.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ah
 * JD-Core Version:    0.7.0.1
 */