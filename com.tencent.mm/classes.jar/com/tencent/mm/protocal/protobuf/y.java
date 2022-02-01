package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class y
  extends cwj
{
  public String FIP;
  public int FIQ;
  public int FIR;
  public String FIS;
  public String FIT;
  public LinkedList<k> cTY;
  public int dmy;
  public String phe;
  
  public y()
  {
    AppMethodBeat.i(91337);
    this.dmy = 268513600;
    this.phe = "请求不成功，请稍候再试";
    this.cTY = new LinkedList();
    AppMethodBeat.o(91337);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91338);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91338);
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
      paramVarArgs.e(4, 8, this.cTY);
      if (this.FIT != null) {
        paramVarArgs.d(5, this.FIT);
      }
      if (this.FIP != null) {
        paramVarArgs.d(6, this.FIP);
      }
      paramVarArgs.aS(7, this.FIQ);
      paramVarArgs.aS(8, this.FIR);
      if (this.FIS != null) {
        paramVarArgs.d(9, this.FIS);
      }
      AppMethodBeat.o(91338);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.cTY);
      paramInt = i;
      if (this.FIT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FIT);
      }
      i = paramInt;
      if (this.FIP != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FIP);
      }
      i = i + f.a.a.b.b.a.bz(7, this.FIQ) + f.a.a.b.b.a.bz(8, this.FIR);
      paramInt = i;
      if (this.FIS != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FIS);
      }
      AppMethodBeat.o(91338);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.cTY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91338);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91338);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91338);
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
            localy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 2: 
          localy.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91338);
          return 0;
        case 3: 
          localy.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localy.cTY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 5: 
          localy.FIT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 6: 
          localy.FIP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 7: 
          localy.FIQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91338);
          return 0;
        case 8: 
          localy.FIR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91338);
          return 0;
        }
        localy.FIS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91338);
        return 0;
      }
      AppMethodBeat.o(91338);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.y
 * JD-Core Version:    0.7.0.1
 */