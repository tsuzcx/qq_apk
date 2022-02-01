package com.tencent.mm.recovery;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.recoveryv2.e.b;
import com.tencent.mm.recoveryv2.e.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.Iterator;
import java.util.List;

abstract class a$a
  extends e.b
{
  final String mName;
  
  public a$a(String paramString)
  {
    super(paramString);
    this.mName = paramString;
  }
  
  public final void fgR()
  {
    if (this.wNb.size() == 0) {
      return;
    }
    ax.init();
    if ("".equals(this.mName)) {}
    for (Object localObject = ax.flf();; localObject = ax.aQz(this.mName))
    {
      localObject = ((ax)localObject).edit();
      Iterator localIterator = this.wNb.iterator();
      while (localIterator.hasNext())
      {
        e.b.a locala = (e.b.a)localIterator.next();
        locala.HTY = ((SharedPreferences.Editor)localObject);
        locala.perform();
        this.HTX.append(locala.getDescription()).append(";\n");
      }
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.recovery.a.a
 * JD-Core Version:    0.7.0.1
 */