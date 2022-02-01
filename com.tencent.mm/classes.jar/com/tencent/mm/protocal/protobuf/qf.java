package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qf
  extends cvp
{
  public String FLD;
  public def FLE;
  public String FLF;
  public String FLG;
  public int FLH;
  public int FLI;
  public int FLJ;
  public dnn FLK;
  public String FLL;
  public int FLM;
  public int FLN;
  public int FLO;
  public com.tencent.mm.bx.b FLP;
  public int FLQ;
  public int FLR;
  public int FLS;
  public py FLT;
  public dq FLU;
  public dp FLV;
  public xr FLW;
  public String FLp;
  public String FvH;
  public String FvI;
  public String FvJ;
  public String dve;
  public int ozR;
  public String ozS;
  public int xYI = 0;
  public String xYJ;
  public String xYK;
  public String xYL;
  public String xYM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91375);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91375);
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
      if (this.dve != null) {
        paramVarArgs.d(4, this.dve);
      }
      if (this.FLD != null) {
        paramVarArgs.d(5, this.FLD);
      }
      if (this.FLE != null)
      {
        paramVarArgs.lC(6, this.FLE.computeSize());
        this.FLE.writeFields(paramVarArgs);
      }
      if (this.FvH != null) {
        paramVarArgs.d(7, this.FvH);
      }
      if (this.FvJ != null) {
        paramVarArgs.d(8, this.FvJ);
      }
      if (this.FLF != null) {
        paramVarArgs.d(9, this.FLF);
      }
      if (this.FLG != null) {
        paramVarArgs.d(10, this.FLG);
      }
      paramVarArgs.aS(11, this.FLH);
      if (this.FvI != null) {
        paramVarArgs.d(12, this.FvI);
      }
      if (this.FLp != null) {
        paramVarArgs.d(13, this.FLp);
      }
      paramVarArgs.aS(14, this.FLI);
      paramVarArgs.aS(15, this.FLJ);
      if (this.FLK != null)
      {
        paramVarArgs.lC(16, this.FLK.computeSize());
        this.FLK.writeFields(paramVarArgs);
      }
      if (this.FLL != null) {
        paramVarArgs.d(17, this.FLL);
      }
      paramVarArgs.aS(18, this.FLM);
      paramVarArgs.aS(19, this.FLN);
      paramVarArgs.aS(20, this.FLO);
      if (this.FLP != null) {
        paramVarArgs.c(21, this.FLP);
      }
      paramVarArgs.aS(22, this.FLQ);
      paramVarArgs.aS(23, this.xYI);
      if (this.xYJ != null) {
        paramVarArgs.d(24, this.xYJ);
      }
      if (this.xYK != null) {
        paramVarArgs.d(25, this.xYK);
      }
      paramVarArgs.aS(26, this.FLR);
      if (this.xYL != null) {
        paramVarArgs.d(27, this.xYL);
      }
      if (this.xYM != null) {
        paramVarArgs.d(28, this.xYM);
      }
      paramVarArgs.aS(29, this.FLS);
      if (this.FLT != null)
      {
        paramVarArgs.lC(30, this.FLT.computeSize());
        this.FLT.writeFields(paramVarArgs);
      }
      if (this.FLU != null)
      {
        paramVarArgs.lC(31, this.FLU.computeSize());
        this.FLU.writeFields(paramVarArgs);
      }
      if (this.FLV != null)
      {
        paramVarArgs.lC(32, this.FLV.computeSize());
        this.FLV.writeFields(paramVarArgs);
      }
      if (this.FLW != null)
      {
        paramVarArgs.lC(33, this.FLW.computeSize());
        this.FLW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2714;
      }
    }
    label2714:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.dve != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dve);
      }
      paramInt = i;
      if (this.FLD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FLD);
      }
      i = paramInt;
      if (this.FLE != null) {
        i = paramInt + f.a.a.a.lB(6, this.FLE.computeSize());
      }
      paramInt = i;
      if (this.FvH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FvH);
      }
      i = paramInt;
      if (this.FvJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FvJ);
      }
      paramInt = i;
      if (this.FLF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FLF);
      }
      i = paramInt;
      if (this.FLG != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FLG);
      }
      i += f.a.a.b.b.a.bz(11, this.FLH);
      paramInt = i;
      if (this.FvI != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FvI);
      }
      i = paramInt;
      if (this.FLp != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FLp);
      }
      i = i + f.a.a.b.b.a.bz(14, this.FLI) + f.a.a.b.b.a.bz(15, this.FLJ);
      paramInt = i;
      if (this.FLK != null) {
        paramInt = i + f.a.a.a.lB(16, this.FLK.computeSize());
      }
      i = paramInt;
      if (this.FLL != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FLL);
      }
      i = i + f.a.a.b.b.a.bz(18, this.FLM) + f.a.a.b.b.a.bz(19, this.FLN) + f.a.a.b.b.a.bz(20, this.FLO);
      paramInt = i;
      if (this.FLP != null) {
        paramInt = i + f.a.a.b.b.a.b(21, this.FLP);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.FLQ) + f.a.a.b.b.a.bz(23, this.xYI);
      paramInt = i;
      if (this.xYJ != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.xYJ);
      }
      i = paramInt;
      if (this.xYK != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.xYK);
      }
      i += f.a.a.b.b.a.bz(26, this.FLR);
      paramInt = i;
      if (this.xYL != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.xYL);
      }
      i = paramInt;
      if (this.xYM != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.xYM);
      }
      i += f.a.a.b.b.a.bz(29, this.FLS);
      paramInt = i;
      if (this.FLT != null) {
        paramInt = i + f.a.a.a.lB(30, this.FLT.computeSize());
      }
      i = paramInt;
      if (this.FLU != null) {
        i = paramInt + f.a.a.a.lB(31, this.FLU.computeSize());
      }
      paramInt = i;
      if (this.FLV != null) {
        paramInt = i + f.a.a.a.lB(32, this.FLV.computeSize());
      }
      i = paramInt;
      if (this.FLW != null) {
        i = paramInt + f.a.a.a.lB(33, this.FLW.computeSize());
      }
      AppMethodBeat.o(91375);
      return i;
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91375);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qf localqf = (qf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91375);
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
            localqf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 2: 
          localqf.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 3: 
          localqf.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 4: 
          localqf.dve = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 5: 
          localqf.FLD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new def();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((def)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqf.FLE = ((def)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 7: 
          localqf.FvH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 8: 
          localqf.FvJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 9: 
          localqf.FLF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 10: 
          localqf.FLG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 11: 
          localqf.FLH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 12: 
          localqf.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 13: 
          localqf.FLp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 14: 
          localqf.FLI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 15: 
          localqf.FLJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqf.FLK = ((dnn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 17: 
          localqf.FLL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 18: 
          localqf.FLM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 19: 
          localqf.FLN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 20: 
          localqf.FLO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 21: 
          localqf.FLP = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91375);
          return 0;
        case 22: 
          localqf.FLQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 23: 
          localqf.xYI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 24: 
          localqf.xYJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 25: 
          localqf.xYK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 26: 
          localqf.FLR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 27: 
          localqf.xYL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 28: 
          localqf.xYM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 29: 
          localqf.FLS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new py();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((py)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqf.FLT = ((py)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqf.FLU = ((dq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqf.FLV = ((dp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqf.FLW = ((xr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      AppMethodBeat.o(91375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qf
 * JD-Core Version:    0.7.0.1
 */