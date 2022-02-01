package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atr
  extends cld
{
  public String Afa;
  public int Cwg;
  public String DtA;
  public String DtB;
  public String DtC;
  public String DtD;
  public bjs DtE;
  public com.tencent.mm.bx.b DtF;
  public String DtG;
  public int DtH;
  public String DtI;
  public int DtJ;
  public String bLg;
  public String dlB;
  public int orW;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(108144);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ret);
      if (this.bLg != null) {
        paramVarArgs.d(3, this.bLg);
      }
      paramVarArgs.aR(4, this.Cwg);
      if (this.dlB != null) {
        paramVarArgs.d(5, this.dlB);
      }
      if (this.DtB != null) {
        paramVarArgs.d(6, this.DtB);
      }
      if (this.Afa != null) {
        paramVarArgs.d(7, this.Afa);
      }
      if (this.DtC != null) {
        paramVarArgs.d(8, this.DtC);
      }
      if (this.DtD != null) {
        paramVarArgs.d(9, this.DtD);
      }
      if (this.DtE != null)
      {
        paramVarArgs.kX(10, this.DtE.computeSize());
        this.DtE.writeFields(paramVarArgs);
      }
      if (this.DtF != null) {
        paramVarArgs.c(11, this.DtF);
      }
      paramVarArgs.aR(12, this.orW);
      if (this.DtA != null) {
        paramVarArgs.d(13, this.DtA);
      }
      if (this.DtG != null) {
        paramVarArgs.d(14, this.DtG);
      }
      paramVarArgs.aR(15, this.DtH);
      if (this.DtI != null) {
        paramVarArgs.d(17, this.DtI);
      }
      paramVarArgs.aR(18, this.DtJ);
      AppMethodBeat.o(108144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ret);
      paramInt = i;
      if (this.bLg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.bLg);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Cwg);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dlB);
      }
      i = paramInt;
      if (this.DtB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DtB);
      }
      paramInt = i;
      if (this.Afa != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Afa);
      }
      i = paramInt;
      if (this.DtC != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DtC);
      }
      paramInt = i;
      if (this.DtD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DtD);
      }
      i = paramInt;
      if (this.DtE != null) {
        i = paramInt + f.a.a.a.kW(10, this.DtE.computeSize());
      }
      paramInt = i;
      if (this.DtF != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.DtF);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.orW);
      paramInt = i;
      if (this.DtA != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DtA);
      }
      i = paramInt;
      if (this.DtG != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DtG);
      }
      i += f.a.a.b.b.a.bA(15, this.DtH);
      paramInt = i;
      if (this.DtI != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DtI);
      }
      i = f.a.a.b.b.a.bA(18, this.DtJ);
      AppMethodBeat.o(108144);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(108144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(108144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atr localatr = (atr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        default: 
          AppMethodBeat.o(108144);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108144);
          return 0;
        case 2: 
          localatr.ret = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(108144);
          return 0;
        case 3: 
          localatr.bLg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 4: 
          localatr.Cwg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(108144);
          return 0;
        case 5: 
          localatr.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 6: 
          localatr.DtB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 7: 
          localatr.Afa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 8: 
          localatr.DtC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 9: 
          localatr.DtD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatr.DtE = ((bjs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108144);
          return 0;
        case 11: 
          localatr.DtF = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(108144);
          return 0;
        case 12: 
          localatr.orW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(108144);
          return 0;
        case 13: 
          localatr.DtA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 14: 
          localatr.DtG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 15: 
          localatr.DtH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(108144);
          return 0;
        case 17: 
          localatr.DtI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108144);
          return 0;
        }
        localatr.DtJ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(108144);
        return 0;
      }
      AppMethodBeat.o(108144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atr
 * JD-Core Version:    0.7.0.1
 */