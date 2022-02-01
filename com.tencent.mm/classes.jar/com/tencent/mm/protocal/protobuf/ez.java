package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ez
  extends cvp
{
  public LinkedList<nk> FwH;
  public boolean FwI;
  public int FwJ;
  public int enabled;
  public int pjW;
  
  public ez()
  {
    AppMethodBeat.i(103190);
    this.FwH = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FwH);
      paramVarArgs.bt(3, this.FwI);
      paramVarArgs.aS(4, this.FwJ);
      paramVarArgs.aS(5, this.enabled);
      paramVarArgs.aS(6, this.pjW);
      AppMethodBeat.o(103191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.FwH);
      int j = f.a.a.b.b.a.alV(3);
      int k = f.a.a.b.b.a.bz(4, this.FwJ);
      int m = f.a.a.b.b.a.bz(5, this.enabled);
      int n = f.a.a.b.b.a.bz(6, this.pjW);
      AppMethodBeat.o(103191);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FwH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.FwH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 3: 
          localez.FwI = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(103191);
          return 0;
        case 4: 
          localez.FwJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103191);
          return 0;
        case 5: 
          localez.enabled = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103191);
          return 0;
        }
        localez.pjW = ((f.a.a.a.a)localObject1).NPN.zc();
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