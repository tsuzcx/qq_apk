package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hi;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class o
  extends hi
  implements Cloneable
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public int QYE;
  
  static
  {
    AppMethodBeat.i(97453);
    info = hi.aJm();
    AppMethodBeat.o(97453);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97450);
    try
    {
      super.convertFrom(paramCursor);
      this.QYE = ((int)this.systemRowid);
      AppMethodBeat.o(97450);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      Log.e("MicroMsg.SnsComment", "error ".concat(String.valueOf(str)));
      if ((str != null) && (str.contains("Unable to convert"))) {
        al.hgH().gGK();
      }
      try
      {
        AppMethodBeat.o(97450);
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        Log.printErrStackTrace("MicroMsg.SnsComment", paramCursor, "", new Object[0]);
        AppMethodBeat.o(97450);
      }
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final void hkI()
  {
    this.field_commentflag |= 0x1;
  }
  
  public final o hkJ()
  {
    AppMethodBeat.i(97451);
    try
    {
      o localo = (o)super.clone();
      AppMethodBeat.o(97451);
      return localo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsComment", "snscomment clone error");
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.o
 * JD-Core Version:    0.7.0.1
 */