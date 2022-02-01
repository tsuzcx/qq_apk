package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exi
  extends com.tencent.mm.bw.a
{
  public String NuI;
  public th NuJ;
  public boolean NuK;
  public String NuL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91731);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NuI != null) {
        paramVarArgs.e(1, this.NuI);
      }
      if (this.NuJ != null)
      {
        paramVarArgs.ni(2, this.NuJ.computeSize());
        this.NuJ.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(3, this.NuK);
      if (this.NuL != null) {
        paramVarArgs.e(4, this.NuL);
      }
      AppMethodBeat.o(91731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NuI == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = g.a.a.b.b.a.f(1, this.NuI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NuJ != null) {
        i = paramInt + g.a.a.a.nh(2, this.NuJ.computeSize());
      }
      i += g.a.a.b.b.a.fS(3) + 1;
      paramInt = i;
      if (this.NuL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NuL);
      }
      AppMethodBeat.o(91731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exi localexi = (exi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91731);
          return -1;
        case 1: 
          localexi.NuI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91731);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new th();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((th)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localexi.NuJ = ((th)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91731);
          return 0;
        case 3: 
          localexi.NuK = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91731);
          return 0;
        }
        localexi.NuL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91731);
        return 0;
      }
      AppMethodBeat.o(91731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exi
 * JD-Core Version:    0.7.0.1
 */