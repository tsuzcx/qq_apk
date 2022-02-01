package d.l.b.a.b.h;

import java.util.Iterator;
import java.util.Map.Entry;

public abstract class i$b<MessageType extends i.c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
  extends i.a<MessageType, BuilderType>
  implements i.d<MessageType>
{
  protected h<i.e> NOg = h.gwi();
  private boolean NOh;
  
  protected final void a(MessageType paramMessageType)
  {
    if (!this.NOh)
    {
      this.NOg = this.NOg.gwk();
      this.NOh = true;
    }
    h localh = this.NOg;
    paramMessageType = i.c.b(paramMessageType);
    int i = 0;
    while (i < paramMessageType.NOa.gwG())
    {
      localh.f(paramMessageType.NOa.alT(i));
      i += 1;
    }
    paramMessageType = paramMessageType.NOa.gwH().iterator();
    while (paramMessageType.hasNext()) {
      localh.f((Map.Entry)paramMessageType.next());
    }
  }
  
  public BuilderType grR()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.h.i.b
 * JD-Core Version:    0.7.0.1
 */