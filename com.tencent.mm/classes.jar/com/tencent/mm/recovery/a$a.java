package com.tencent.mm.recovery;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.recoveryv2.d.b;
import com.tencent.mm.recoveryv2.d.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.List;

abstract class a$a
  extends d.b
{
  final String mName;
  
  public a$a(String paramString)
  {
    super(paramString);
    this.mName = paramString;
  }
  
  public final void iQx()
  {
    if (this.MRS.size() == 0) {
      return;
    }
    MultiProcessMMKV.init();
    if ("".equals(this.mName)) {}
    for (Object localObject = MultiProcessMMKV.getDefault();; localObject = MultiProcessMMKV.getMMKV(this.mName))
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      Iterator localIterator = this.MRS.iterator();
      while (localIterator.hasNext())
      {
        d.b.a locala = (d.b.a)localIterator.next();
        locala.eYx = ((SharedPreferences.Editor)localObject);
        locala.perform();
        this.acjX.append(locala.getDescription()).append(";\n");
      }
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.recovery.a.a
 * JD-Core Version:    0.7.0.1
 */