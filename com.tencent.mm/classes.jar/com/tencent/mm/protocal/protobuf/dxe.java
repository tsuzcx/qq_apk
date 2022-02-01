package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxe
  extends cwj
{
  public int GQk;
  public com.tencent.mm.bw.b IcE;
  public String IcF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(190847);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.IcE != null) {
        paramVarArgs.c(2, this.IcE);
      }
      paramVarArgs.aS(3, this.GQk);
      if (this.IcF != null) {
        paramVarArgs.d(4, this.IcF);
      }
      AppMethodBeat.o(190847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IcE != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.IcE);
      }
      i += f.a.a.b.b.a.bz(3, this.GQk);
      paramInt = i;
      if (this.IcF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IcF);
      }
      AppMethodBeat.o(190847);
      return paramInt;
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(190847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(190847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxe localdxe = (dxe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190847);
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
            localdxe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190847);
          return 0;
        case 2: 
          localdxe.IcE = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(190847);
          return 0;
        case 3: 
          localdxe.GQk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(190847);
          return 0;
        }
        localdxe.IcF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(190847);
        return 0;
      }
      AppMethodBeat.o(190847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxe
 * JD-Core Version:    0.7.0.1
 */