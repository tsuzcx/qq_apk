package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwf
  extends cwj
{
  public int Gpf;
  public int HEI;
  public dyb HEN;
  public String Iby;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32497);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32497);
        throw paramVarArgs;
      }
      if (this.HEN == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(32497);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HEN != null)
      {
        paramVarArgs.lJ(2, this.HEN.computeSize());
        this.HEN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Gpf);
      paramVarArgs.aS(4, this.HEI);
      if (this.Iby != null) {
        paramVarArgs.d(5, this.Iby);
      }
      AppMethodBeat.o(32497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label721;
      }
    }
    label721:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HEN != null) {
        i = paramInt + f.a.a.a.lI(2, this.HEN.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.Gpf) + f.a.a.b.b.a.bz(4, this.HEI);
      paramInt = i;
      if (this.Iby != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Iby);
      }
      AppMethodBeat.o(32497);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32497);
          throw paramVarArgs;
        }
        if (this.HEN == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(32497);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwf localdwf = (dwf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32497);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32497);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwf.HEN = ((dyb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32497);
          return 0;
        case 3: 
          localdwf.Gpf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32497);
          return 0;
        case 4: 
          localdwf.HEI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32497);
          return 0;
        }
        localdwf.Iby = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32497);
        return 0;
      }
      AppMethodBeat.o(32497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwf
 * JD-Core Version:    0.7.0.1
 */