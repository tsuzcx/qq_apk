package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class i$c<MessageType extends c<MessageType>>
  extends i
  implements i.d<MessageType>
{
  protected final h<i.e> NOg;
  
  protected i$c()
  {
    this.NOg = h.gwh();
  }
  
  protected i$c(i.b<MessageType, ?> paramb)
  {
    this.NOg = i.b.a(paramb);
  }
  
  private void b(i.f<MessageType, ?> paramf)
  {
    if (paramf.NOq != gqW()) {
      throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
  }
  
  public final <Type> Type a(i.f<MessageType, List<Type>> paramf, int paramInt)
  {
    b(paramf);
    Object localObject = this.NOg;
    i.e locale = paramf.NOs;
    if (!locale.gwn()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    localObject = ((h)localObject).a(locale);
    if (localObject == null) {
      throw new IndexOutOfBoundsException();
    }
    return paramf.fs(((List)localObject).get(paramInt));
  }
  
  protected final boolean a(e parame, f paramf, g paramg, int paramInt)
  {
    h localh = this.NOg;
    Object localObject = gqW();
    int i = z.fQ(paramInt);
    int j = z.fR(paramInt);
    i.f localf = (i.f)paramg.NNY.get(new g.a(localObject, j));
    if (localf != null) {
      if (i == h.a(localf.NOs.NOn, false))
      {
        i = 0;
        j = 0;
      }
    }
    while (j != 0)
    {
      return parame.a(paramInt, paramf);
      if ((localf.NOs.NOo) && (localf.NOs.NOn.gwO()) && (i == h.a(localf.NOs.NOn, true)))
      {
        i = 1;
        j = 0;
      }
      else
      {
        i = 0;
        j = 1;
      }
    }
    if (i != 0)
    {
      paramInt = parame.fG(parame.zc());
      if (localf.NOs.NOn == z.a.NPB) {
        while (parame.zf() > 0)
        {
          i = parame.zc();
          paramf = localf.NOs.NOm.akk(i);
          if (paramf == null) {
            break label273;
          }
          localh.b(localf.NOs, localf.ft(paramf));
        }
      }
      while (parame.zf() > 0)
      {
        paramf = h.a(parame, localf.NOs.NOn);
        localh.b(localf.NOs, paramf);
      }
      parame.fH(paramInt);
    }
    for (;;)
    {
      label273:
      return true;
      switch (i.1.NOe[localf.NOs.NOn.NPG.ordinal()])
      {
      default: 
        parame = h.a(parame, localf.NOs.NOn);
        label329:
        if (!localf.NOs.NOo) {
          break label620;
        }
        localh.b(localf.NOs, localf.ft(parame));
      }
    }
    if (!localf.NOs.NOo)
    {
      paramf = (q)localh.a(localf.NOs);
      if (paramf == null) {}
    }
    for (paramf = paramf.gqU();; paramf = null)
    {
      localObject = paramf;
      if (paramf == null) {
        localObject = localf.NOr.gqV();
      }
      if (localf.NOs.NOn == z.a.NPx)
      {
        paramInt = localf.NOs.number;
        if (parame.bQK >= parame.bQL) {
          throw k.gwx();
        }
        parame.bQK += 1;
        ((q.a)localObject).d(parame, paramg);
        parame.fE(z.bC(paramInt, 4));
        parame.bQK -= 1;
      }
      for (;;)
      {
        parame = ((q.a)localObject).gre();
        break;
        paramInt = parame.zc();
        if (parame.bQK >= parame.bQL) {
          throw k.gwx();
        }
        paramInt = parame.fG(paramInt);
        parame.bQK += 1;
        ((q.a)localObject).d(parame, paramg);
        parame.fE(0);
        parame.bQK -= 1;
        parame.fH(paramInt);
      }
      i = parame.zc();
      paramg = localf.NOs.NOm.akk(i);
      parame = paramg;
      if (paramg != null) {
        break label329;
      }
      paramf.fO(paramInt);
      paramf.fO(i);
      break;
      label620:
      localh.a(localf.NOs, localf.ft(parame));
      break;
    }
  }
  
  public final <Type> boolean c(i.f<MessageType, Type> paramf)
  {
    b(paramf);
    h localh = this.NOg;
    paramf = paramf.NOs;
    if (paramf.gwn()) {
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }
    return localh.NOa.get(paramf) != null;
  }
  
  public final <Type> int d(i.f<MessageType, List<Type>> paramf)
  {
    b(paramf);
    h localh = this.NOg;
    paramf = paramf.NOs;
    if (!paramf.gwn()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    paramf = localh.a(paramf);
    if (paramf == null) {
      return 0;
    }
    return ((List)paramf).size();
  }
  
  public final <Type> Type e(i.f<MessageType, Type> paramf)
  {
    b(paramf);
    Object localObject2 = this.NOg.a(paramf.NOs);
    if (localObject2 == null) {
      localObject1 = paramf.aFh;
    }
    do
    {
      return localObject1;
      if (!paramf.NOs.NOo) {
        break;
      }
      localObject1 = localObject2;
    } while (paramf.NOs.NOn.NPG != z.b.NPQ);
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(paramf.fs(((Iterator)localObject2).next()));
    }
    return localObject1;
    return paramf.fs(localObject2);
  }
  
  protected final void gwp()
  {
    this.NOg.gwj();
  }
  
  protected final c<MessageType>.a gwq()
  {
    return new a((byte)0);
  }
  
  public final class a
  {
    private final Iterator<Map.Entry<i.e, Object>> NOi;
    private Map.Entry<i.e, Object> NOj;
    private final boolean NOk;
    
    private a()
    {
      AppMethodBeat.i(59472);
      this$1 = i.c.b(i.c.this);
      if (i.c.this.NOc) {}
      for (this$1 = new l.b(i.c.this.NOa.entrySet().iterator());; this$1 = i.c.this.NOa.entrySet().iterator())
      {
        this.NOi = i.c.this;
        if (this.NOi.hasNext()) {
          this.NOj = ((Map.Entry)this.NOi.next());
        }
        this.NOk = false;
        AppMethodBeat.o(59472);
        return;
      }
    }
    
    public final void b(int paramInt, f paramf)
    {
      AppMethodBeat.i(59473);
      while ((this.NOj != null) && (((i.e)this.NOj.getKey()).number < paramInt))
      {
        i.e locale = (i.e)this.NOj.getKey();
        if ((this.NOk) && (locale.NOn.NPG == z.b.NPR) && (!locale.NOo)) {
          paramf.b(locale.number, (q)this.NOj.getValue());
        }
        for (;;)
        {
          if (!this.NOi.hasNext()) {
            break label139;
          }
          this.NOj = ((Map.Entry)this.NOi.next());
          break;
          h.a(locale, this.NOj.getValue(), paramf);
        }
        label139:
        this.NOj = null;
      }
      AppMethodBeat.o(59473);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.h.i.c
 * JD-Core Version:    0.7.0.1
 */