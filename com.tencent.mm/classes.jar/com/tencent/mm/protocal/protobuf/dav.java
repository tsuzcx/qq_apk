package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dav
  extends com.tencent.mm.cd.a
{
  public bds TIn;
  public LinkedList<bfi> TIp;
  
  public dav()
  {
    AppMethodBeat.i(198367);
    this.TIp = new LinkedList();
    AppMethodBeat.o(198367);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198378);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIn != null)
      {
        paramVarArgs.oE(1, this.TIn.computeSize());
        this.TIn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TIp);
      AppMethodBeat.o(198378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIn == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = g.a.a.a.oD(1, this.TIn.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.TIp);
      AppMethodBeat.o(198378);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TIp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dav localdav = (dav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198378);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bds();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bds)localObject2).parseFrom((byte[])localObject1);
            }
            localdav.TIn = ((bds)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198378);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfi)localObject2).parseFrom((byte[])localObject1);
          }
          localdav.TIp.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198378);
        return 0;
      }
      AppMethodBeat.o(198378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dav
 * JD-Core Version:    0.7.0.1
 */