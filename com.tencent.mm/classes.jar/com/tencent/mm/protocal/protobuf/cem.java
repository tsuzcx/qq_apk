package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cem
  extends cvp
{
  public String FDp;
  public cky FDr;
  public String GYr;
  public boolean GYs;
  public boolean GYt;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72529);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.GYr != null) {
        paramVarArgs.d(4, this.GYr);
      }
      if (this.FDp != null) {
        paramVarArgs.d(7, this.FDp);
      }
      if (this.FDr != null)
      {
        paramVarArgs.lC(8, this.FDr.computeSize());
        this.FDr.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(9, this.GYs);
      paramVarArgs.bt(10, this.GYt);
      AppMethodBeat.o(72529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.GYr != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GYr);
      }
      paramInt = i;
      if (this.FDp != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FDp);
      }
      i = paramInt;
      if (this.FDr != null) {
        i = paramInt + f.a.a.a.lB(8, this.FDr.computeSize());
      }
      paramInt = f.a.a.b.b.a.alV(9);
      int j = f.a.a.b.b.a.alV(10);
      AppMethodBeat.o(72529);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cem localcem = (cem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(72529);
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
            localcem.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 2: 
          localcem.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72529);
          return 0;
        case 3: 
          localcem.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 4: 
          localcem.GYr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 7: 
          localcem.FDp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cky();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcem.FDr = ((cky)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 9: 
          localcem.GYs = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72529);
          return 0;
        }
        localcem.GYt = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(72529);
        return 0;
      }
      AppMethodBeat.o(72529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cem
 * JD-Core Version:    0.7.0.1
 */