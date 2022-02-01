package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgv
  extends cwj
{
  public int GVd;
  public String GVe;
  public int Gnw;
  public String yBZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(116455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.yBZ != null) {
        paramVarArgs.d(2, this.yBZ);
      }
      paramVarArgs.aS(3, this.GVd);
      if (this.GVe != null) {
        paramVarArgs.d(4, this.GVe);
      }
      paramVarArgs.aS(5, this.Gnw);
      AppMethodBeat.o(116455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yBZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.yBZ);
      }
      i += f.a.a.b.b.a.bz(3, this.GVd);
      paramInt = i;
      if (this.GVe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GVe);
      }
      i = f.a.a.b.b.a.bz(5, this.Gnw);
      AppMethodBeat.o(116455);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(116455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgv localbgv = (bgv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116455);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116455);
          return 0;
        case 2: 
          localbgv.yBZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116455);
          return 0;
        case 3: 
          localbgv.GVd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116455);
          return 0;
        case 4: 
          localbgv.GVe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116455);
          return 0;
        }
        localbgv.Gnw = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(116455);
        return 0;
      }
      AppMethodBeat.o(116455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgv
 * JD-Core Version:    0.7.0.1
 */