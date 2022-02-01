package com.tencent.mm.plugin.talkroom;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aap;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aas;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.event.IListener;

public class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(29370);
    new IListener(f.hfK) {}.alive();
    new TalkRoomServerListener().alive();
    new TalkRoomReportMgrListener().alive();
    new TalkRoomeStatusBarHideListener().alive();
    AppMethodBeat.o(29370);
  }
  
  public n createApplication()
  {
    AppMethodBeat.i(29371);
    a locala = new a();
    AppMethodBeat.o(29371);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(29372);
    b localb = new b();
    AppMethodBeat.o(29372);
    return localb;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
  
  class TalkRoomReportMgrListener
    extends IListener<aap>
  {
    public TalkRoomReportMgrListener()
    {
      super();
      AppMethodBeat.i(161452);
      this.__eventId = aap.class.getName().hashCode();
      AppMethodBeat.o(161452);
    }
  }
  
  static class TalkRoomServerListener
    extends IListener<aaq>
  {
    public TalkRoomServerListener()
    {
      super();
      AppMethodBeat.i(161454);
      this.__eventId = aaq.class.getName().hashCode();
      AppMethodBeat.o(161454);
    }
  }
  
  class TalkRoomeStatusBarHideListener
    extends IListener<aas>
  {
    public TalkRoomeStatusBarHideListener()
    {
      super();
      AppMethodBeat.i(161456);
      this.__eventId = aas.class.getName().hashCode();
      AppMethodBeat.o(161456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.Plugin
 * JD-Core Version:    0.7.0.1
 */