package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class clm
  extends cvp
{
  public String CwQ;
  public int CwW;
  public String GPZ;
  public boolean GQa;
  public LinkedList<ub> Gvi;
  public bpp HeC;
  public cmp HeD;
  public String HeE;
  public int HeF;
  public long HeG;
  public String HeH;
  public String HeI;
  public String HeJ;
  public String HeK;
  public LinkedList<csc> HeL;
  public int ozR;
  public String ozS;
  
  public clm()
  {
    AppMethodBeat.i(91622);
    this.Gvi = new LinkedList();
    this.GQa = true;
    this.HeL = new LinkedList();
    AppMethodBeat.o(91622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91623);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91623);
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
      if (this.HeC != null)
      {
        paramVarArgs.lC(4, this.HeC.computeSize());
        this.HeC.writeFields(paramVarArgs);
      }
      if (this.HeD != null)
      {
        paramVarArgs.lC(5, this.HeD.computeSize());
        this.HeD.writeFields(paramVarArgs);
      }
      if (this.GPZ != null) {
        paramVarArgs.d(6, this.GPZ);
      }
      paramVarArgs.e(7, 8, this.Gvi);
      paramVarArgs.bt(8, this.GQa);
      paramVarArgs.aS(9, this.CwW);
      if (this.HeE != null) {
        paramVarArgs.d(10, this.HeE);
      }
      paramVarArgs.aS(11, this.HeF);
      paramVarArgs.aY(12, this.HeG);
      if (this.CwQ != null) {
        paramVarArgs.d(13, this.CwQ);
      }
      if (this.HeH != null) {
        paramVarArgs.d(14, this.HeH);
      }
      if (this.HeI != null) {
        paramVarArgs.d(15, this.HeI);
      }
      if (this.HeJ != null) {
        paramVarArgs.d(16, this.HeJ);
      }
      if (this.HeK != null) {
        paramVarArgs.d(17, this.HeK);
      }
      paramVarArgs.e(18, 8, this.HeL);
      AppMethodBeat.o(91623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1662;
      }
    }
    label1662:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.HeC != null) {
        i = paramInt + f.a.a.a.lB(4, this.HeC.computeSize());
      }
      paramInt = i;
      if (this.HeD != null) {
        paramInt = i + f.a.a.a.lB(5, this.HeD.computeSize());
      }
      i = paramInt;
      if (this.GPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GPZ);
      }
      i = i + f.a.a.a.c(7, 8, this.Gvi) + f.a.a.b.b.a.alV(8) + f.a.a.b.b.a.bz(9, this.CwW);
      paramInt = i;
      if (this.HeE != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HeE);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HeF) + f.a.a.b.b.a.p(12, this.HeG);
      paramInt = i;
      if (this.CwQ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CwQ);
      }
      i = paramInt;
      if (this.HeH != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HeH);
      }
      paramInt = i;
      if (this.HeI != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.HeI);
      }
      i = paramInt;
      if (this.HeJ != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.HeJ);
      }
      paramInt = i;
      if (this.HeK != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.HeK);
      }
      i = f.a.a.a.c(18, 8, this.HeL);
      AppMethodBeat.o(91623);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gvi.clear();
        this.HeL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91623);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clm localclm = (clm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91623);
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
            localclm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 2: 
          localclm.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91623);
          return 0;
        case 3: 
          localclm.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclm.HeC = ((bpp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclm.HeD = ((cmp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 6: 
          localclm.GPZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ub();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ub)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclm.Gvi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 8: 
          localclm.GQa = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91623);
          return 0;
        case 9: 
          localclm.CwW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91623);
          return 0;
        case 10: 
          localclm.HeE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 11: 
          localclm.HeF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91623);
          return 0;
        case 12: 
          localclm.HeG = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91623);
          return 0;
        case 13: 
          localclm.CwQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 14: 
          localclm.HeH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 15: 
          localclm.HeI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 16: 
          localclm.HeJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 17: 
          localclm.HeK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91623);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclm.HeL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      AppMethodBeat.o(91623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clm
 * JD-Core Version:    0.7.0.1
 */