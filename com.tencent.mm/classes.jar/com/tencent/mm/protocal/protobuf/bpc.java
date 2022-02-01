package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpc
  extends cqk
{
  public int ENQ;
  public LinkedList<box> ENR;
  public int FeD;
  public int FeE;
  public int FeF;
  public int xSh;
  
  public bpc()
  {
    AppMethodBeat.i(89927);
    this.ENR = new LinkedList();
    AppMethodBeat.o(89927);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89928);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89928);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ENQ);
      paramVarArgs.e(3, 8, this.ENR);
      paramVarArgs.aR(4, this.xSh);
      paramVarArgs.aR(5, this.FeD);
      paramVarArgs.aR(6, this.FeE);
      paramVarArgs.aR(7, this.FeF);
      AppMethodBeat.o(89928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.ENQ);
      int j = f.a.a.a.c(3, 8, this.ENR);
      int k = f.a.a.b.b.a.bx(4, this.xSh);
      int m = f.a.a.b.b.a.bx(5, this.FeD);
      int n = f.a.a.b.b.a.bx(6, this.FeE);
      int i1 = f.a.a.b.b.a.bx(7, this.FeF);
      AppMethodBeat.o(89928);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ENR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89928);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpc localbpc = (bpc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89928);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 2: 
          localbpc.ENQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(89928);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new box();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((box)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpc.ENR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 4: 
          localbpc.xSh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(89928);
          return 0;
        case 5: 
          localbpc.FeD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(89928);
          return 0;
        case 6: 
          localbpc.FeE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(89928);
          return 0;
        }
        localbpc.FeF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(89928);
        return 0;
      }
      AppMethodBeat.o(89928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpc
 * JD-Core Version:    0.7.0.1
 */