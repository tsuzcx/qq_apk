package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqg
  extends cwj
{
  public String FQZ;
  public LinkedList<dqp> HBY;
  public LinkedList<dqp> HBZ;
  public int dmy;
  public String phe;
  
  public cqg()
  {
    AppMethodBeat.i(72572);
    this.HBY = new LinkedList();
    this.HBZ = new LinkedList();
    AppMethodBeat.o(72572);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72573);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72573);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      paramVarArgs.e(4, 8, this.HBY);
      paramVarArgs.e(5, 8, this.HBZ);
      if (this.FQZ != null) {
        paramVarArgs.d(6, this.FQZ);
      }
      AppMethodBeat.o(72573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.HBY) + f.a.a.a.c(5, 8, this.HBZ);
      paramInt = i;
      if (this.FQZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FQZ);
      }
      AppMethodBeat.o(72573);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HBY.clear();
        this.HBZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqg localcqg = (cqg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72573);
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
            localcqg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        case 2: 
          localcqg.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72573);
          return 0;
        case 3: 
          localcqg.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72573);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqg.HBY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqg.HBZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        }
        localcqg.FQZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72573);
        return 0;
      }
      AppMethodBeat.o(72573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqg
 * JD-Core Version:    0.7.0.1
 */