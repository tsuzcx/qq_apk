package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  public Plugin()
  {
    com.tencent.mm.sdk.b.a.udP.c(new Plugin.1(this));
    com.tencent.mm.sdk.b.a.udP.c(new Plugin.b((byte)0));
    com.tencent.mm.sdk.b.a.udP.c(new Plugin.a(this, (byte)0));
    com.tencent.mm.sdk.b.a.udP.c(new Plugin.c(this, (byte)0));
  }
  
  public n createApplication()
  {
    return new a();
  }
  
  public ar createSubCore()
  {
    return new com.tencent.mm.plugin.talkroom.model.b();
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.Plugin
 * JD-Core Version:    0.7.0.1
 */