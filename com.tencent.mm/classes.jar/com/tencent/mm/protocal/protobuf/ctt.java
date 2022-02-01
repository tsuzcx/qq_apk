package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ctt
  extends cwj
{
  public int HEI;
  public int HEL;
  public int HEM;
  public dyb HEN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32413);
        throw paramVarArgs;
      }
      if (this.HEN == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(32413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HEL);
      paramVarArgs.aS(3, this.HEM);
      if (this.HEN != null)
      {
        paramVarArgs.lJ(4, this.HEN.computeSize());
        this.HEN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HEI);
      AppMethodBeat.o(32413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label705;
      }
    }
    label705:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HEL) + f.a.a.b.b.a.bz(3, this.HEM);
      paramInt = i;
      if (this.HEN != null) {
        paramInt = i + f.a.a.a.lI(4, this.HEN.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.HEI);
      AppMethodBeat.o(32413);
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
          AppMethodBeat.o(32413);
          throw paramVarArgs;
        }
        if (this.HEN == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(32413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctt localctt = (ctt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32413);
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
            localctt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32413);
          return 0;
        case 2: 
          localctt.HEL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32413);
          return 0;
        case 3: 
          localctt.HEM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32413);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctt.HEN = ((dyb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32413);
          return 0;
        }
        localctt.HEI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32413);
        return 0;
      }
      AppMethodBeat.o(32413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctt
 * JD-Core Version:    0.7.0.1
 */