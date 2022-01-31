package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class m$a
  extends l.d
  implements l.b
{
  public int netType;
  public int wiu = 0;
  
  public final int getCmdId()
  {
    return 312;
  }
  
  public final int getFuncId()
  {
    return 0;
  }
  
  public final boolean getShortSupport()
  {
    return false;
  }
  
  public final boolean isRawData()
  {
    return true;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(28280);
    Object localObject2 = new je();
    ((je)localObject2).wur = d.whH;
    ((je)localObject2).wvf = 2;
    ((je)localObject2).wvg = this.netType;
    ((je)localObject2).wvh = this.wiu;
    ab.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((je)localObject2).wvh), Integer.valueOf(((je)localObject2).wvg), Integer.valueOf(((je)localObject2).wur), Integer.valueOf(((je)localObject2).wvf) });
    Object localObject1 = null;
    try
    {
      localObject2 = ((je)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[] { bo.l(localIOException) });
      }
    }
    AppMethodBeat.o(28280);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.m.a
 * JD-Core Version:    0.7.0.1
 */