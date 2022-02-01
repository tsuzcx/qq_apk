package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ape
  extends dpc
{
  public int LBk;
  public int LBl;
  public int LBm;
  public int LBn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209348);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LBk);
      paramVarArgs.aM(3, this.LBl);
      paramVarArgs.aM(4, this.LBm);
      paramVarArgs.aM(5, this.LBn);
      AppMethodBeat.o(209348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LBk);
      int j = g.a.a.b.b.a.bu(3, this.LBl);
      int k = g.a.a.b.b.a.bu(4, this.LBm);
      int m = g.a.a.b.b.a.bu(5, this.LBn);
      AppMethodBeat.o(209348);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209348);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ape localape = (ape)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209348);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localape.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209348);
          return 0;
        case 2: 
          localape.LBk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209348);
          return 0;
        case 3: 
          localape.LBl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209348);
          return 0;
        case 4: 
          localape.LBm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209348);
          return 0;
        }
        localape.LBn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209348);
        return 0;
      }
      AppMethodBeat.o(209348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ape
 * JD-Core Version:    0.7.0.1
 */