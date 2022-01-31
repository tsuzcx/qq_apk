package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class h
{
  private static final int pzY = a.pzY;
  
  public static String aJ(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {}
    ad localad;
    do
    {
      return null;
      au.Hx();
      localad = c.Fw().abl(paramString);
    } while (localad == null);
    if (s.fn(paramString))
    {
      if (bk.bl(localad.field_nickname)) {
        return paramContext.getString(R.l.talk_room_tilte);
      }
      return localad.Bp();
    }
    return r.gV(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */