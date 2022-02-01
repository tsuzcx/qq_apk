package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csl
  extends cvp
{
  public String Cyu;
  public int HeX;
  public boolean HkL;
  public boolean HkM;
  public String HkN;
  public String HkO;
  public String HkP;
  public String HkQ;
  public int ozR;
  public String ozS;
  public int status;
  public String uJF;
  public String wCE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91666);
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
      paramVarArgs.bt(4, this.HkL);
      paramVarArgs.bt(5, this.HkM);
      paramVarArgs.aS(6, this.status);
      if (this.HkN != null) {
        paramVarArgs.d(7, this.HkN);
      }
      if (this.HkO != null) {
        paramVarArgs.d(8, this.HkO);
      }
      paramVarArgs.aS(9, this.HeX);
      if (this.uJF != null) {
        paramVarArgs.d(10, this.uJF);
      }
      if (this.wCE != null) {
        paramVarArgs.d(11, this.wCE);
      }
      if (this.HkP != null) {
        paramVarArgs.d(12, this.HkP);
      }
      if (this.HkQ != null) {
        paramVarArgs.d(13, this.HkQ);
      }
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.alV(5) + f.a.a.b.b.a.bz(6, this.status);
      paramInt = i;
      if (this.HkN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HkN);
      }
      i = paramInt;
      if (this.HkO != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HkO);
      }
      i += f.a.a.b.b.a.bz(9, this.HeX);
      paramInt = i;
      if (this.uJF != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.uJF);
      }
      i = paramInt;
      if (this.wCE != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.wCE);
      }
      paramInt = i;
      if (this.HkP != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HkP);
      }
      i = paramInt;
      if (this.HkQ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HkQ);
      }
      paramInt = i;
      if (this.Cyu != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91666);
      return paramInt;
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
          AppMethodBeat.o(91666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csl localcsl = (csl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91666);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        case 2: 
          localcsl.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91666);
          return 0;
        case 3: 
          localcsl.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 4: 
          localcsl.HkL = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91666);
          return 0;
        case 5: 
          localcsl.HkM = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91666);
          return 0;
        case 6: 
          localcsl.status = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91666);
          return 0;
        case 7: 
          localcsl.HkN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 8: 
          localcsl.HkO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 9: 
          localcsl.HeX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91666);
          return 0;
        case 10: 
          localcsl.uJF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 11: 
          localcsl.wCE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 12: 
          localcsl.HkP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 13: 
          localcsl.HkQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91666);
          return 0;
        }
        localcsl.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91666);
        return 0;
      }
      AppMethodBeat.o(91666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csl
 * JD-Core Version:    0.7.0.1
 */