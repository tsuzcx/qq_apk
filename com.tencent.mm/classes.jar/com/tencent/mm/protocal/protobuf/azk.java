package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azk
  extends cwj
{
  public int GPA;
  public czy GPB;
  public String GPy;
  public tx GPz;
  public String oGs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114023);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114023);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.oGs != null) {
        paramVarArgs.d(2, this.oGs);
      }
      if (this.GPy != null) {
        paramVarArgs.d(3, this.GPy);
      }
      if (this.GPz != null)
      {
        paramVarArgs.lJ(4, this.GPz.computeSize());
        this.GPz.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GPA);
      if (this.GPB != null)
      {
        paramVarArgs.lJ(6, this.GPB.computeSize());
        this.GPB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oGs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oGs);
      }
      i = paramInt;
      if (this.GPy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GPy);
      }
      paramInt = i;
      if (this.GPz != null) {
        paramInt = i + f.a.a.a.lI(4, this.GPz.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GPA);
      paramInt = i;
      if (this.GPB != null) {
        paramInt = i + f.a.a.a.lI(6, this.GPB.computeSize());
      }
      AppMethodBeat.o(114023);
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
          AppMethodBeat.o(114023);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azk localazk = (azk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114023);
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
            localazk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 2: 
          localazk.oGs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 3: 
          localazk.GPy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazk.GPz = ((tx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 5: 
          localazk.GPA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114023);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazk.GPB = ((czy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      AppMethodBeat.o(114023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azk
 * JD-Core Version:    0.7.0.1
 */