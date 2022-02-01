package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fgy
  extends com.tencent.mm.bx.a
{
  public int abGD;
  public fzn abGE;
  public int abHl;
  public int abHm;
  public int abHn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115855);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abGE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Addr");
        AppMethodBeat.o(115855);
        throw paramVarArgs;
      }
      if (this.abGE != null)
      {
        paramVarArgs.qD(1, this.abGE.computeSize());
        this.abGE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abGD);
      paramVarArgs.bS(3, this.abHl);
      paramVarArgs.bS(4, this.abHm);
      paramVarArgs.bS(5, this.abHn);
      AppMethodBeat.o(115855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abGE == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = i.a.a.a.qC(1, this.abGE.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abGD);
      int j = i.a.a.b.b.a.cJ(3, this.abHl);
      int k = i.a.a.b.b.a.cJ(4, this.abHm);
      int m = i.a.a.b.b.a.cJ(5, this.abHn);
      AppMethodBeat.o(115855);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abGE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Addr");
          AppMethodBeat.o(115855);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fgy localfgy = (fgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115855);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fzn localfzn = new fzn();
            if ((localObject != null) && (localObject.length > 0)) {
              localfzn.parseFrom((byte[])localObject);
            }
            localfgy.abGE = localfzn;
            paramInt += 1;
          }
          AppMethodBeat.o(115855);
          return 0;
        case 2: 
          localfgy.abGD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115855);
          return 0;
        case 3: 
          localfgy.abHl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115855);
          return 0;
        case 4: 
          localfgy.abHm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115855);
          return 0;
        }
        localfgy.abHn = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115855);
        return 0;
      }
      AppMethodBeat.o(115855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgy
 * JD-Core Version:    0.7.0.1
 */