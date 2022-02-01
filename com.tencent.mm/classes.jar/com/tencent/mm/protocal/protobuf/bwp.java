package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwp
  extends dop
{
  public int BsF;
  public int BsG;
  public int KCx;
  public int Mck;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74659);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Mck);
      paramVarArgs.aM(3, this.BsF);
      paramVarArgs.aM(4, this.BsG);
      paramVarArgs.aM(5, this.KCx);
      AppMethodBeat.o(74659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Mck);
      int j = g.a.a.b.b.a.bu(3, this.BsF);
      int k = g.a.a.b.b.a.bu(4, this.BsG);
      int m = g.a.a.b.b.a.bu(5, this.KCx);
      AppMethodBeat.o(74659);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(74659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwp localbwp = (bwp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74659);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbwp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74659);
          return 0;
        case 2: 
          localbwp.Mck = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74659);
          return 0;
        case 3: 
          localbwp.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74659);
          return 0;
        case 4: 
          localbwp.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74659);
          return 0;
        }
        localbwp.KCx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(74659);
        return 0;
      }
      AppMethodBeat.o(74659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwp
 * JD-Core Version:    0.7.0.1
 */