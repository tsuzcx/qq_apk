package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ez
  extends cwj
{
  public LinkedList<nm> FPf;
  public boolean FPg;
  public int FPh;
  public int enabled;
  public int pqB;
  
  public ez()
  {
    AppMethodBeat.i(103190);
    this.FPf = new LinkedList();
    AppMethodBeat.o(103190);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103191);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103191);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FPf);
      paramVarArgs.bC(3, this.FPg);
      paramVarArgs.aS(4, this.FPh);
      paramVarArgs.aS(5, this.enabled);
      paramVarArgs.aS(6, this.pqB);
      AppMethodBeat.o(103191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.FPf);
      int j = f.a.a.b.b.a.amF(3);
      int k = f.a.a.b.b.a.bz(4, this.FPh);
      int m = f.a.a.b.b.a.bz(5, this.enabled);
      int n = f.a.a.b.b.a.bz(6, this.pqB);
      AppMethodBeat.o(103191);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FPf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103191);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103191);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ez localez = (ez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103191);
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
            localez.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.FPf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 3: 
          localez.FPg = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(103191);
          return 0;
        case 4: 
          localez.FPh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103191);
          return 0;
        case 5: 
          localez.enabled = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103191);
          return 0;
        }
        localez.pqB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103191);
        return 0;
      }
      AppMethodBeat.o(103191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ez
 * JD-Core Version:    0.7.0.1
 */