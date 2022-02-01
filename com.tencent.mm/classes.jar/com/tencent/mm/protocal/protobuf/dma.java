package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dma
  extends cld
{
  public long Dea;
  public int EBN;
  public int EBO;
  public int EBP;
  public int EBQ;
  public com.tencent.mm.bx.b EBR;
  public long Erf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.Erf);
      paramVarArgs.aG(3, this.Dea);
      paramVarArgs.aR(4, this.EBN);
      paramVarArgs.aR(5, this.EBO);
      paramVarArgs.aR(6, this.EBP);
      paramVarArgs.aR(7, this.EBQ);
      if (this.EBR != null) {
        paramVarArgs.c(8, this.EBR);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Erf) + f.a.a.b.b.a.q(3, this.Dea) + f.a.a.b.b.a.bA(4, this.EBN) + f.a.a.b.b.a.bA(5, this.EBO) + f.a.a.b.b.a.bA(6, this.EBP) + f.a.a.b.b.a.bA(7, this.EBQ);
      paramInt = i;
      if (this.EBR != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.EBR);
      }
      AppMethodBeat.o(125510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dma localdma = (dma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125510);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdma.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125510);
          return 0;
        case 2: 
          localdma.Erf = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125510);
          return 0;
        case 3: 
          localdma.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125510);
          return 0;
        case 4: 
          localdma.EBN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125510);
          return 0;
        case 5: 
          localdma.EBO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125510);
          return 0;
        case 6: 
          localdma.EBP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125510);
          return 0;
        case 7: 
          localdma.EBQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125510);
          return 0;
        }
        localdma.EBR = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(125510);
        return 0;
      }
      AppMethodBeat.o(125510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dma
 * JD-Core Version:    0.7.0.1
 */