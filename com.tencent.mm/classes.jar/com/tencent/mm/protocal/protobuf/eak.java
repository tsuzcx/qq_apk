package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eak
  extends cwj
{
  public long Igi;
  public int Igm;
  public int Ign;
  public LinkedList<dit> Igo;
  
  public eak()
  {
    AppMethodBeat.i(115918);
    this.Igo = new LinkedList();
    AppMethodBeat.o(115918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115919);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Igm);
      paramVarArgs.aZ(3, this.Igi);
      paramVarArgs.aS(4, this.Ign);
      paramVarArgs.e(5, 8, this.Igo);
      AppMethodBeat.o(115919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Igm);
      int j = f.a.a.b.b.a.p(3, this.Igi);
      int k = f.a.a.b.b.a.bz(4, this.Ign);
      int m = f.a.a.a.c(5, 8, this.Igo);
      AppMethodBeat.o(115919);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Igo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115919);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eak localeak = (eak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115919);
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
            localeak.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115919);
          return 0;
        case 2: 
          localeak.Igm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115919);
          return 0;
        case 3: 
          localeak.Igi = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115919);
          return 0;
        case 4: 
          localeak.Ign = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115919);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dit();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dit)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeak.Igo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115919);
        return 0;
      }
      AppMethodBeat.o(115919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eak
 * JD-Core Version:    0.7.0.1
 */