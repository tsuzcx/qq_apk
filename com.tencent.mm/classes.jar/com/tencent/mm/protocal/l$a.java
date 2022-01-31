package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.hn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class l$a
  extends k.d
  implements k.b
{
  public int netType;
  public int spQ = 0;
  
  public final byte[] HG()
  {
    Object localObject = new hn();
    ((hn)localObject).sAl = d.spa;
    ((hn)localObject).sAQ = 2;
    ((hn)localObject).sAR = this.netType;
    ((hn)localObject).sAS = this.spQ;
    y.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((hn)localObject).sAS), Integer.valueOf(((hn)localObject).sAR), Integer.valueOf(((hn)localObject).sAl), Integer.valueOf(((hn)localObject).sAQ) });
    try
    {
      localObject = ((hn)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[] { bk.j(localIOException) });
    }
    return null;
  }
  
  public final int HH()
  {
    return 0;
  }
  
  public final boolean Lb()
  {
    return false;
  }
  
  public final boolean cpe()
  {
    return true;
  }
  
  public final int getCmdId()
  {
    return 312;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.l.a
 * JD-Core Version:    0.7.0.1
 */