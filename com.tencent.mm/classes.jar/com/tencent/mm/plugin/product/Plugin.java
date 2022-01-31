package com.tencent.mm.plugin.product;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  public n createApplication()
  {
    return null;
  }
  
  public ar createSubCore()
  {
    return new a();
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.Plugin
 * JD-Core Version:    0.7.0.1
 */