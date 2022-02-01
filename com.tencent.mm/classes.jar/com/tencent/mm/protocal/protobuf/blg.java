package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blg
  extends cld
{
  public int DJi;
  public int DJj;
  public int DJk;
  public int DsM;
  public LinkedList<blb> DsN;
  public int wFN;
  
  public blg()
  {
    AppMethodBeat.i(89927);
    this.DsN = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DsM);
      paramVarArgs.e(3, 8, this.DsN);
      paramVarArgs.aR(4, this.wFN);
      paramVarArgs.aR(5, this.DJi);
      paramVarArgs.aR(6, this.DJj);
      paramVarArgs.aR(7, this.DJk);
      AppMethodBeat.o(89928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DsM);
      int j = f.a.a.a.c(3, 8, this.DsN);
      int k = f.a.a.b.b.a.bA(4, this.wFN);
      int m = f.a.a.b.b.a.bA(5, this.DJi);
      int n = f.a.a.b.b.a.bA(6, this.DJj);
      int i1 = f.a.a.b.b.a.bA(7, this.DJk);
      AppMethodBeat.o(89928);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DsN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        blg localblg = (blg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89928);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 2: 
          localblg.DsM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89928);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblg.DsN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 4: 
          localblg.wFN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89928);
          return 0;
        case 5: 
          localblg.DJi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89928);
          return 0;
        case 6: 
          localblg.DJj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89928);
          return 0;
        }
        localblg.DJk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(89928);
        return 0;
      }
      AppMethodBeat.o(89928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blg
 * JD-Core Version:    0.7.0.1
 */