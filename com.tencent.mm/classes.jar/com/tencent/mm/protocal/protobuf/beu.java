package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beu
  extends dop
{
  public int LOB;
  public int LOC;
  public jl LjV;
  public String LjW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91468);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LjV != null)
      {
        paramVarArgs.ni(2, this.LjV.computeSize());
        this.LjV.writeFields(paramVarArgs);
      }
      if (this.LjW != null) {
        paramVarArgs.e(3, this.LjW);
      }
      paramVarArgs.aM(4, this.LOB);
      paramVarArgs.aM(5, this.LOC);
      AppMethodBeat.o(91468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LjV != null) {
        paramInt = i + g.a.a.a.nh(2, this.LjV.computeSize());
      }
      i = paramInt;
      if (this.LjW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LjW);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.LOB);
      int j = g.a.a.b.b.a.bu(5, this.LOC);
      AppMethodBeat.o(91468);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        beu localbeu = (beu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91468);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbeu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbeu.LjV = ((jl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 3: 
          localbeu.LjW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91468);
          return 0;
        case 4: 
          localbeu.LOB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91468);
          return 0;
        }
        localbeu.LOC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91468);
        return 0;
      }
      AppMethodBeat.o(91468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beu
 * JD-Core Version:    0.7.0.1
 */