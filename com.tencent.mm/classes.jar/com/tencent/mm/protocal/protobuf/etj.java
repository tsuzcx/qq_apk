package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etj
  extends dpc
{
  public long Lta;
  public long NeG;
  public int NqC;
  public int NqD;
  public int NqE;
  public int NqF;
  public com.tencent.mm.bw.b NqG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.NeG);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.NqC);
      paramVarArgs.aM(5, this.NqD);
      paramVarArgs.aM(6, this.NqE);
      paramVarArgs.aM(7, this.NqF);
      if (this.NqG != null) {
        paramVarArgs.c(8, this.NqG);
      }
      AppMethodBeat.o(125510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.NeG) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.NqC) + g.a.a.b.b.a.bu(5, this.NqD) + g.a.a.b.b.a.bu(6, this.NqE) + g.a.a.b.b.a.bu(7, this.NqF);
      paramInt = i;
      if (this.NqG != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.NqG);
      }
      AppMethodBeat.o(125510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        etj localetj = (etj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125510);
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
            localetj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125510);
          return 0;
        case 2: 
          localetj.NeG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125510);
          return 0;
        case 3: 
          localetj.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125510);
          return 0;
        case 4: 
          localetj.NqC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125510);
          return 0;
        case 5: 
          localetj.NqD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125510);
          return 0;
        case 6: 
          localetj.NqE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125510);
          return 0;
        case 7: 
          localetj.NqF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125510);
          return 0;
        }
        localetj.NqG = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(125510);
        return 0;
      }
      AppMethodBeat.o(125510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etj
 * JD-Core Version:    0.7.0.1
 */