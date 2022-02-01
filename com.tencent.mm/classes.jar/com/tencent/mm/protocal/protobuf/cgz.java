package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgz
  extends cwj
{
  public int FIh;
  public cru Gmp;
  public int HsH;
  public int HsI;
  public int HsJ;
  public long HsK;
  public long HsL;
  public LinkedList<bnr> HsM;
  public String HsN;
  public String HsO;
  public String HsP;
  public int HsQ;
  public int HsR;
  public String HsS;
  public long dPq;
  public int vvu;
  public int vvv;
  public String vvw;
  public String vvx;
  public String vvy;
  
  public cgz()
  {
    AppMethodBeat.i(91566);
    this.HsM = new LinkedList();
    AppMethodBeat.o(91566);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HsH);
      paramVarArgs.aS(3, this.HsI);
      paramVarArgs.aS(4, this.vvu);
      paramVarArgs.aZ(5, this.dPq);
      paramVarArgs.aS(6, this.HsJ);
      paramVarArgs.aZ(7, this.HsK);
      paramVarArgs.aS(8, this.FIh);
      paramVarArgs.aZ(9, this.HsL);
      paramVarArgs.aS(10, this.vvv);
      paramVarArgs.e(11, 8, this.HsM);
      if (this.vvw != null) {
        paramVarArgs.d(12, this.vvw);
      }
      if (this.HsN != null) {
        paramVarArgs.d(13, this.HsN);
      }
      if (this.HsO != null) {
        paramVarArgs.d(14, this.HsO);
      }
      if (this.HsP != null) {
        paramVarArgs.d(15, this.HsP);
      }
      paramVarArgs.aS(16, this.HsQ);
      if (this.vvy != null) {
        paramVarArgs.d(17, this.vvy);
      }
      paramVarArgs.aS(18, this.HsR);
      if (this.vvx != null) {
        paramVarArgs.d(19, this.vvx);
      }
      if (this.Gmp != null)
      {
        paramVarArgs.lJ(20, this.Gmp.computeSize());
        this.Gmp.writeFields(paramVarArgs);
      }
      if (this.HsS != null) {
        paramVarArgs.d(21, this.HsS);
      }
      AppMethodBeat.o(91567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HsH) + f.a.a.b.b.a.bz(3, this.HsI) + f.a.a.b.b.a.bz(4, this.vvu) + f.a.a.b.b.a.p(5, this.dPq) + f.a.a.b.b.a.bz(6, this.HsJ) + f.a.a.b.b.a.p(7, this.HsK) + f.a.a.b.b.a.bz(8, this.FIh) + f.a.a.b.b.a.p(9, this.HsL) + f.a.a.b.b.a.bz(10, this.vvv) + f.a.a.a.c(11, 8, this.HsM);
      paramInt = i;
      if (this.vvw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.vvw);
      }
      i = paramInt;
      if (this.HsN != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HsN);
      }
      paramInt = i;
      if (this.HsO != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HsO);
      }
      i = paramInt;
      if (this.HsP != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HsP);
      }
      i += f.a.a.b.b.a.bz(16, this.HsQ);
      paramInt = i;
      if (this.vvy != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.vvy);
      }
      i = paramInt + f.a.a.b.b.a.bz(18, this.HsR);
      paramInt = i;
      if (this.vvx != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.vvx);
      }
      i = paramInt;
      if (this.Gmp != null) {
        i = paramInt + f.a.a.a.lI(20, this.Gmp.computeSize());
      }
      paramInt = i;
      if (this.HsS != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.HsS);
      }
      AppMethodBeat.o(91567);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HsM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgz localcgz = (cgz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91567);
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
            localcgz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 2: 
          localcgz.HsH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 3: 
          localcgz.HsI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 4: 
          localcgz.vvu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 5: 
          localcgz.dPq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91567);
          return 0;
        case 6: 
          localcgz.HsJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 7: 
          localcgz.HsK = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91567);
          return 0;
        case 8: 
          localcgz.FIh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 9: 
          localcgz.HsL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91567);
          return 0;
        case 10: 
          localcgz.vvv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgz.HsM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 12: 
          localcgz.vvw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 13: 
          localcgz.HsN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 14: 
          localcgz.HsO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 15: 
          localcgz.HsP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 16: 
          localcgz.HsQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 17: 
          localcgz.vvy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 18: 
          localcgz.HsR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 19: 
          localcgz.vvx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cru();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgz.Gmp = ((cru)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        }
        localcgz.HsS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91567);
        return 0;
      }
      AppMethodBeat.o(91567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgz
 * JD-Core Version:    0.7.0.1
 */