package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdw
  extends cwj
{
  public String FPO;
  public LinkedList<cea> HqL;
  public String HqM;
  public boolean HqN;
  public boolean HqO;
  public boolean HqP;
  public LinkedList<cdx> HqQ;
  public boolean HqR;
  public String hDU;
  public boolean kDe;
  public int kDf;
  public int kDg;
  public String kDh;
  public String kDi;
  
  public cdw()
  {
    AppMethodBeat.i(82461);
    this.HqL = new LinkedList();
    this.HqQ = new LinkedList();
    AppMethodBeat.o(82461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82462);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.HqL);
      if (this.hDU != null) {
        paramVarArgs.d(4, this.hDU);
      }
      if (this.HqM != null) {
        paramVarArgs.d(5, this.HqM);
      }
      if (this.FPO != null) {
        paramVarArgs.d(6, this.FPO);
      }
      paramVarArgs.bC(8, this.HqN);
      paramVarArgs.bC(9, this.HqO);
      paramVarArgs.bC(10, this.HqP);
      paramVarArgs.e(11, 8, this.HqQ);
      paramVarArgs.bC(12, this.HqR);
      paramVarArgs.bC(13, this.kDe);
      paramVarArgs.aS(14, this.kDf);
      paramVarArgs.aS(15, this.kDg);
      if (this.kDh != null) {
        paramVarArgs.d(16, this.kDh);
      }
      if (this.kDi != null) {
        paramVarArgs.d(17, this.kDi);
      }
      AppMethodBeat.o(82462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1242;
      }
    }
    label1242:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(3, 8, this.HqL);
      paramInt = i;
      if (this.hDU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hDU);
      }
      i = paramInt;
      if (this.HqM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HqM);
      }
      paramInt = i;
      if (this.FPO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FPO);
      }
      i = paramInt + f.a.a.b.b.a.amF(8) + f.a.a.b.b.a.amF(9) + f.a.a.b.b.a.amF(10) + f.a.a.a.c(11, 8, this.HqQ) + f.a.a.b.b.a.amF(12) + f.a.a.b.b.a.amF(13) + f.a.a.b.b.a.bz(14, this.kDf) + f.a.a.b.b.a.bz(15, this.kDg);
      paramInt = i;
      if (this.kDh != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.kDh);
      }
      i = paramInt;
      if (this.kDi != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.kDi);
      }
      AppMethodBeat.o(82462);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HqL.clear();
        this.HqQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82462);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdw localcdw = (cdw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(82462);
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
            localcdw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cea();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cea)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdw.HqL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 4: 
          localcdw.hDU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 5: 
          localcdw.HqM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 6: 
          localcdw.FPO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 8: 
          localcdw.HqN = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(82462);
          return 0;
        case 9: 
          localcdw.HqO = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(82462);
          return 0;
        case 10: 
          localcdw.HqP = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(82462);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdw.HqQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 12: 
          localcdw.HqR = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(82462);
          return 0;
        case 13: 
          localcdw.kDe = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(82462);
          return 0;
        case 14: 
          localcdw.kDf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82462);
          return 0;
        case 15: 
          localcdw.kDg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82462);
          return 0;
        case 16: 
          localcdw.kDh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82462);
          return 0;
        }
        localcdw.kDi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82462);
        return 0;
      }
      AppMethodBeat.o(82462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdw
 * JD-Core Version:    0.7.0.1
 */