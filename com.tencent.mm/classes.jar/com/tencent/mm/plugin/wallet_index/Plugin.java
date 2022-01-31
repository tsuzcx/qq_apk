package com.tencent.mm.plugin.wallet_index;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.wallet_index.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements c
{
  public final n createApplication()
  {
    return null;
  }
  
  public final ar createSubCore()
  {
    return new a();
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.Plugin
 * JD-Core Version:    0.7.0.1
 */