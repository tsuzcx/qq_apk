package com.tencent.mm.wear.app.d.b;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.b.g;
import com.tencent.mm.wear.app.b.h;
import java.util.List;

public abstract class a
{
  public final void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    d.c("MicroMsg.BasePushHandler", "handle push message connectType=%d sessionId=%d funIc=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    byte[] arrayOfByte = paramArrayOfByte;
    if (bQ(paramInt3))
    {
      paramArrayOfByte = h.mb().l(paramArrayOfByte);
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        d.a("MicroMsg.BasePushHandler", "request data decrypt error", new Object[0]);
        return;
      }
    }
    a(paramInt3, arrayOfByte);
  }
  
  protected abstract void a(int paramInt, byte[] paramArrayOfByte);
  
  protected boolean bQ(int paramInt)
  {
    return false;
  }
  
  public abstract List<Integer> mS();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.b.a
 * JD-Core Version:    0.7.0.1
 */