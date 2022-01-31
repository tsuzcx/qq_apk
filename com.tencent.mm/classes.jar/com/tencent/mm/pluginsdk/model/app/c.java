package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class c
  extends i<b>
{
  public static final String[] dXp = { i.a(b.buS, "appattach") };
  e dXw;
  
  public c(e parame)
  {
    super(parame, b.buS, "appattach", null);
    this.dXw = parame;
  }
  
  public final b VQ(String paramString)
  {
    b localb = new b();
    localb.field_mediaSvrId = paramString;
    if (b(localb, new String[] { "mediaSvrId" })) {}
    while (b(localb, new String[] { "mediaId" })) {
      return localb;
    }
    return null;
  }
  
  public final b gY(long paramLong)
  {
    b localb = new b();
    localb.field_msgInfoId = paramLong;
    if (b(localb, new String[] { "msgInfoId" })) {
      return localb;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.c
 * JD-Core Version:    0.7.0.1
 */