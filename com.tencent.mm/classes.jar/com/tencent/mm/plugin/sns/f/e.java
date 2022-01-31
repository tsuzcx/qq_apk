package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;

public final class e
{
  public static void Og(String paramString)
  {
    y.i("MicroMsg.SnsABTestStrategy", "dump id " + paramString);
    paramString = com.tencent.mm.model.c.c.IX().fJ(paramString);
    if (!paramString.isValid()) {
      y.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
    }
    if (paramString.ctr() != null) {
      y.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + paramString.field_rawXML);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.e
 * JD-Core Version:    0.7.0.1
 */