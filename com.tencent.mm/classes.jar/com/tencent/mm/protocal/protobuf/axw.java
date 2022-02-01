package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axw
  extends cwj
{
  public bpz GOR;
  public String GOS;
  public bpu GOT;
  public int result;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82408);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GOR != null)
      {
        paramVarArgs.lJ(2, this.GOR.computeSize());
        this.GOR.writeFields(paramVarArgs);
      }
      if (this.GOS != null) {
        paramVarArgs.d(3, this.GOS);
      }
      if (this.GOT != null)
      {
        paramVarArgs.lJ(4, this.GOT.computeSize());
        this.GOT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.result);
      AppMethodBeat.o(82408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GOR != null) {
        paramInt = i + f.a.a.a.lI(2, this.GOR.computeSize());
      }
      i = paramInt;
      if (this.GOS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GOS);
      }
      paramInt = i;
      if (this.GOT != null) {
        paramInt = i + f.a.a.a.lI(4, this.GOT.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.result);
      AppMethodBeat.o(82408);
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
          AppMethodBeat.o(82408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axw localaxw = (axw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82408);
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
            localaxw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxw.GOR = ((bpz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 3: 
          localaxw.GOS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82408);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxw.GOT = ((bpu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        }
        localaxw.result = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(82408);
        return 0;
      }
      AppMethodBeat.o(82408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axw
 * JD-Core Version:    0.7.0.1
 */