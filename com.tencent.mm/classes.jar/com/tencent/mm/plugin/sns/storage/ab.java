package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;

public final class ab
  extends com.tencent.mm.storagebase.h
{
  private static ConcurrentHashMap<Integer, a> QZw;
  
  public ab()
  {
    AppMethodBeat.i(306541);
    if (Util.getInt(((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfD, "0"), 0) > 0) {
      QZw = new ConcurrentHashMap();
    }
    AppMethodBeat.o(306541);
  }
  
  public static ConcurrentHashMap<Integer, a> hln()
  {
    return QZw;
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306554);
    ConcurrentHashMap localConcurrentHashMap;
    int i;
    String str;
    if (QZw != null)
    {
      localConcurrentHashMap = QZw;
      i = paramString2.hashCode();
      str = Util.getStack().toString();
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      localConcurrentHashMap.put(Integer.valueOf(i), new a(str, bool));
      bool = super.execSQL(paramString1, paramString2);
      AppMethodBeat.o(306554);
      return bool;
    }
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(306547);
    ConcurrentHashMap localConcurrentHashMap;
    int i;
    String str;
    if (QZw != null)
    {
      localConcurrentHashMap = QZw;
      i = paramString.hashCode();
      str = Util.getStack().toString();
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localConcurrentHashMap.put(Integer.valueOf(i), new a(str, bool));
      paramString = super.rawQuery(paramString, paramArrayOfString);
      AppMethodBeat.o(306547);
      return paramString;
    }
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(306549);
    ConcurrentHashMap localConcurrentHashMap;
    int i;
    String str;
    if (QZw != null)
    {
      localConcurrentHashMap = QZw;
      i = paramString.hashCode();
      str = Util.getStack().toString();
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      localConcurrentHashMap.put(Integer.valueOf(i), new a(str, bool));
      paramString = super.rawQuery(paramString, paramArrayOfString, paramInt);
      AppMethodBeat.o(306549);
      return paramString;
    }
  }
  
  public final class a
  {
    public String QZx;
    public boolean QZy;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.QZx = paramString;
      this.QZy = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ab
 * JD-Core Version:    0.7.0.1
 */