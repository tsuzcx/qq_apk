package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cof
  extends com.tencent.mm.cd.a
{
  public adl Twn;
  public LinkedList<cop> Two;
  public int cUP;
  public String fGM;
  
  public cof()
  {
    AppMethodBeat.i(254125);
    this.cUP = 0;
    this.Two = new LinkedList();
    AppMethodBeat.o(254125);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(254126);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Twn == null)
      {
        paramVarArgs = new b("Not all required fields were included: idInfo");
        AppMethodBeat.o(254126);
        throw paramVarArgs;
      }
      if (this.Twn != null)
      {
        paramVarArgs.oE(1, this.Twn.computeSize());
        this.Twn.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.cUP);
      if (this.fGM != null) {
        paramVarArgs.f(3, this.fGM);
      }
      paramVarArgs.e(4, 8, this.Two);
      AppMethodBeat.o(254126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Twn == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = g.a.a.a.oD(1, this.Twn.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.cUP);
      paramInt = i;
      if (this.fGM != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fGM);
      }
      i = g.a.a.a.c(4, 8, this.Two);
      AppMethodBeat.o(254126);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Two.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Twn == null)
        {
          paramVarArgs = new b("Not all required fields were included: idInfo");
          AppMethodBeat.o(254126);
          throw paramVarArgs;
        }
        AppMethodBeat.o(254126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cof localcof = (cof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(254126);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adl)localObject2).parseFrom((byte[])localObject1);
            }
            localcof.Twn = ((adl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(254126);
          return 0;
        case 2: 
          localcof.cUP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(254126);
          return 0;
        case 3: 
          localcof.fGM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(254126);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cop();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cop)localObject2).parseFrom((byte[])localObject1);
          }
          localcof.Two.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(254126);
        return 0;
      }
      AppMethodBeat.o(254126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cof
 * JD-Core Version:    0.7.0.1
 */