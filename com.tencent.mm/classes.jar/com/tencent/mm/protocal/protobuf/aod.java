package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aod
  extends cvp
{
  public String GmP;
  public int GmQ;
  public String GmR;
  public apv GmS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209310);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GmP != null) {
        paramVarArgs.d(2, this.GmP);
      }
      paramVarArgs.aS(3, this.GmQ);
      if (this.GmR != null) {
        paramVarArgs.d(4, this.GmR);
      }
      if (this.GmS != null)
      {
        paramVarArgs.lC(5, this.GmS.computeSize());
        this.GmS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209310);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GmP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GmP);
      }
      i += f.a.a.b.b.a.bz(3, this.GmQ);
      paramInt = i;
      if (this.GmR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GmR);
      }
      i = paramInt;
      if (this.GmS != null) {
        i = paramInt + f.a.a.a.lB(5, this.GmS.computeSize());
      }
      AppMethodBeat.o(209310);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209310);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aod localaod = (aod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209310);
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
            localaod.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209310);
          return 0;
        case 2: 
          localaod.GmP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209310);
          return 0;
        case 3: 
          localaod.GmQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209310);
          return 0;
        case 4: 
          localaod.GmR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209310);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaod.GmS = ((apv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209310);
        return 0;
      }
      AppMethodBeat.o(209310);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aod
 * JD-Core Version:    0.7.0.1
 */