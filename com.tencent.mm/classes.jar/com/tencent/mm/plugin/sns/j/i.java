package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.cd.a
{
  public LinkedList<h> Kfd;
  public g Kfe;
  
  public i()
  {
    AppMethodBeat.i(96160);
    this.Kfd = new LinkedList();
    AppMethodBeat.o(96160);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96161);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Kfd);
      if (this.Kfe != null)
      {
        paramVarArgs.oE(2, this.Kfe.computeSize());
        this.Kfe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(96161);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Kfd) + 0;
      paramInt = i;
      if (this.Kfe != null) {
        paramInt = i + g.a.a.a.oD(2, this.Kfe.computeSize());
      }
      AppMethodBeat.o(96161);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Kfd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(96161);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(96161);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new h();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((h)localObject2).parseFrom((byte[])localObject1);
          }
          locali.Kfd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96161);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new g();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((g)localObject2).parseFrom((byte[])localObject1);
        }
        locali.Kfe = ((g)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(96161);
      return 0;
    }
    AppMethodBeat.o(96161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.i
 * JD-Core Version:    0.7.0.1
 */