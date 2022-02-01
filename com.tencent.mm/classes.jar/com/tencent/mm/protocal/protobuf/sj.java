package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sj
  extends cld
{
  public int CUg;
  public com.tencent.mm.bx.b CUh;
  public int CUi;
  public int dcG;
  public String nTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91409);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.CUh != null) {
        paramVarArgs.c(4, this.CUh);
      }
      paramVarArgs.aR(5, this.CUg);
      paramVarArgs.aR(6, this.CUi);
      AppMethodBeat.o(91409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.CUh != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.CUh);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.CUg);
      int j = f.a.a.b.b.a.bA(6, this.CUi);
      AppMethodBeat.o(91409);
      return i + paramInt + j;
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
          AppMethodBeat.o(91409);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sj localsj = (sj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91409);
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
            localsj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91409);
          return 0;
        case 2: 
          localsj.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91409);
          return 0;
        case 3: 
          localsj.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91409);
          return 0;
        case 4: 
          localsj.CUh = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91409);
          return 0;
        case 5: 
          localsj.CUg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91409);
          return 0;
        }
        localsj.CUi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91409);
        return 0;
      }
      AppMethodBeat.o(91409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sj
 * JD-Core Version:    0.7.0.1
 */