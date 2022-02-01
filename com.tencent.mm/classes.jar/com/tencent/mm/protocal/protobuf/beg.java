package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class beg
  extends cvp
{
  public chr GAv;
  public int GAw;
  public int GwY;
  public int ozR;
  public String ozS;
  public int pjW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114031);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114031);
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
      paramVarArgs.aS(4, this.pjW);
      paramVarArgs.aS(5, this.GwY);
      if (this.GAv != null)
      {
        paramVarArgs.lC(6, this.GAv.computeSize());
        this.GAv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GAw);
      AppMethodBeat.o(114031);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.pjW) + f.a.a.b.b.a.bz(5, this.GwY);
      paramInt = i;
      if (this.GAv != null) {
        paramInt = i + f.a.a.a.lB(6, this.GAv.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.GAw);
      AppMethodBeat.o(114031);
      return paramInt + i;
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
          AppMethodBeat.o(114031);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114031);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        beg localbeg = (beg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114031);
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
            localbeg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114031);
          return 0;
        case 2: 
          localbeg.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114031);
          return 0;
        case 3: 
          localbeg.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114031);
          return 0;
        case 4: 
          localbeg.pjW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114031);
          return 0;
        case 5: 
          localbeg.GwY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114031);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeg.GAv = ((chr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114031);
          return 0;
        }
        localbeg.GAw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(114031);
        return 0;
      }
      AppMethodBeat.o(114031);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beg
 * JD-Core Version:    0.7.0.1
 */