package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class lr
  extends cvp
{
  public int FDT;
  public String FDU;
  public ccb FDY;
  public String FDZ;
  public int FEa;
  public String FEb;
  public bor FEc;
  public pv FEd;
  public ccc FEe;
  public String FEf;
  public int FEg;
  public cww FEh;
  public String FEi;
  public String FEj;
  public String FEk;
  public String FEl;
  public int FEm;
  public int Fsl;
  public deh Fze;
  public String Fzf;
  public int Fzj;
  public String Username;
  public String dpf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134244);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.dpf != null) {
        paramVarArgs.d(2, this.dpf);
      }
      if (this.FDZ != null) {
        paramVarArgs.d(3, this.FDZ);
      }
      paramVarArgs.aS(4, this.FEa);
      if (this.FEb != null) {
        paramVarArgs.d(5, this.FEb);
      }
      if (this.Username != null) {
        paramVarArgs.d(6, this.Username);
      }
      if (this.FEc != null)
      {
        paramVarArgs.lC(7, this.FEc.computeSize());
        this.FEc.writeFields(paramVarArgs);
      }
      if (this.FEd != null)
      {
        paramVarArgs.lC(8, this.FEd.computeSize());
        this.FEd.writeFields(paramVarArgs);
      }
      if (this.FEe != null)
      {
        paramVarArgs.lC(9, this.FEe.computeSize());
        this.FEe.writeFields(paramVarArgs);
      }
      if (this.Fzf != null) {
        paramVarArgs.d(10, this.Fzf);
      }
      paramVarArgs.aS(11, this.Fsl);
      if (this.FEf != null) {
        paramVarArgs.d(12, this.FEf);
      }
      paramVarArgs.aS(13, this.FEg);
      if (this.FEh != null)
      {
        paramVarArgs.lC(14, this.FEh.computeSize());
        this.FEh.writeFields(paramVarArgs);
      }
      if (this.FEi != null) {
        paramVarArgs.d(15, this.FEi);
      }
      if (this.FEj != null) {
        paramVarArgs.d(16, this.FEj);
      }
      if (this.Fze != null)
      {
        paramVarArgs.lC(17, this.Fze.computeSize());
        this.Fze.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(18, this.Fzj);
      if (this.FEk != null) {
        paramVarArgs.d(19, this.FEk);
      }
      if (this.FEl != null) {
        paramVarArgs.d(20, this.FEl);
      }
      paramVarArgs.aS(21, this.FDT);
      if (this.FDU != null) {
        paramVarArgs.d(22, this.FDU);
      }
      paramVarArgs.aS(23, this.FEm);
      if (this.FDY != null)
      {
        paramVarArgs.lC(24, this.FDY.computeSize());
        this.FDY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2246;
      }
    }
    label2246:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dpf);
      }
      i = paramInt;
      if (this.FDZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FDZ);
      }
      i += f.a.a.b.b.a.bz(4, this.FEa);
      paramInt = i;
      if (this.FEb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FEb);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Username);
      }
      paramInt = i;
      if (this.FEc != null) {
        paramInt = i + f.a.a.a.lB(7, this.FEc.computeSize());
      }
      i = paramInt;
      if (this.FEd != null) {
        i = paramInt + f.a.a.a.lB(8, this.FEd.computeSize());
      }
      paramInt = i;
      if (this.FEe != null) {
        paramInt = i + f.a.a.a.lB(9, this.FEe.computeSize());
      }
      i = paramInt;
      if (this.Fzf != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Fzf);
      }
      i += f.a.a.b.b.a.bz(11, this.Fsl);
      paramInt = i;
      if (this.FEf != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FEf);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.FEg);
      paramInt = i;
      if (this.FEh != null) {
        paramInt = i + f.a.a.a.lB(14, this.FEh.computeSize());
      }
      i = paramInt;
      if (this.FEi != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.FEi);
      }
      paramInt = i;
      if (this.FEj != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FEj);
      }
      i = paramInt;
      if (this.Fze != null) {
        i = paramInt + f.a.a.a.lB(17, this.Fze.computeSize());
      }
      i += f.a.a.b.b.a.bz(18, this.Fzj);
      paramInt = i;
      if (this.FEk != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.FEk);
      }
      i = paramInt;
      if (this.FEl != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.FEl);
      }
      i += f.a.a.b.b.a.bz(21, this.FDT);
      paramInt = i;
      if (this.FDU != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FDU);
      }
      i = paramInt + f.a.a.b.b.a.bz(23, this.FEm);
      paramInt = i;
      if (this.FDY != null) {
        paramInt = i + f.a.a.a.lB(24, this.FDY.computeSize());
      }
      AppMethodBeat.o(134244);
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
          AppMethodBeat.o(134244);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lr locallr = (lr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134244);
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
            locallr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 2: 
          locallr.dpf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 3: 
          locallr.FDZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 4: 
          locallr.FEa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 5: 
          locallr.FEb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 6: 
          locallr.Username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bor();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bor)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FEc = ((bor)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FEd = ((pv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FEe = ((ccc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 10: 
          locallr.Fzf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 11: 
          locallr.Fsl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 12: 
          locallr.FEf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 13: 
          locallr.FEg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FEh = ((cww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 15: 
          locallr.FEi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 16: 
          locallr.FEj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.Fze = ((deh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 18: 
          locallr.Fzj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 19: 
          locallr.FEk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 20: 
          locallr.FEl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 21: 
          locallr.FDT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 22: 
          locallr.FDU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 23: 
          locallr.FEm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134244);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallr.FDY = ((ccb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      AppMethodBeat.o(134244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lr
 * JD-Core Version:    0.7.0.1
 */