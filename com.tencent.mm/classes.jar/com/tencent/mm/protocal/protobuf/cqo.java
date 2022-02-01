package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqo
  extends cwj
{
  public int FIh;
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
  
  public cqo()
  {
    AppMethodBeat.i(91656);
    this.HsM = new LinkedList();
    AppMethodBeat.o(91656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91657);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.dPq);
      paramVarArgs.aS(3, this.HsJ);
      paramVarArgs.aZ(4, this.HsK);
      paramVarArgs.aS(5, this.FIh);
      paramVarArgs.aZ(6, this.HsL);
      paramVarArgs.aS(9, this.vvv);
      paramVarArgs.e(10, 8, this.HsM);
      if (this.vvw != null) {
        paramVarArgs.d(11, this.vvw);
      }
      if (this.HsN != null) {
        paramVarArgs.d(12, this.HsN);
      }
      if (this.HsO != null) {
        paramVarArgs.d(13, this.HsO);
      }
      if (this.HsP != null) {
        paramVarArgs.d(14, this.HsP);
      }
      paramVarArgs.aS(15, this.HsQ);
      if (this.vvy != null) {
        paramVarArgs.d(16, this.vvy);
      }
      paramVarArgs.aS(17, this.HsR);
      if (this.vvx != null) {
        paramVarArgs.d(18, this.vvx);
      }
      paramVarArgs.aS(19, this.HsI);
      paramVarArgs.aS(20, this.vvu);
      paramVarArgs.aS(21, this.HsH);
      if (this.HsS != null) {
        paramVarArgs.d(22, this.HsS);
      }
      AppMethodBeat.o(91657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.dPq) + f.a.a.b.b.a.bz(3, this.HsJ) + f.a.a.b.b.a.p(4, this.HsK) + f.a.a.b.b.a.bz(5, this.FIh) + f.a.a.b.b.a.p(6, this.HsL) + f.a.a.b.b.a.bz(9, this.vvv) + f.a.a.a.c(10, 8, this.HsM);
      paramInt = i;
      if (this.vvw != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.vvw);
      }
      i = paramInt;
      if (this.HsN != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HsN);
      }
      paramInt = i;
      if (this.HsO != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HsO);
      }
      i = paramInt;
      if (this.HsP != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HsP);
      }
      i += f.a.a.b.b.a.bz(15, this.HsQ);
      paramInt = i;
      if (this.vvy != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.vvy);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.HsR);
      paramInt = i;
      if (this.vvx != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.vvx);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.HsI) + f.a.a.b.b.a.bz(20, this.vvu) + f.a.a.b.b.a.bz(21, this.HsH);
      paramInt = i;
      if (this.HsS != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.HsS);
      }
      AppMethodBeat.o(91657);
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
          AppMethodBeat.o(91657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqo localcqo = (cqo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(91657);
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
            localcqo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 2: 
          localcqo.dPq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91657);
          return 0;
        case 3: 
          localcqo.HsJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 4: 
          localcqo.HsK = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91657);
          return 0;
        case 5: 
          localcqo.FIh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 6: 
          localcqo.HsL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91657);
          return 0;
        case 9: 
          localcqo.vvv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqo.HsM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 11: 
          localcqo.vvw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 12: 
          localcqo.HsN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 13: 
          localcqo.HsO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 14: 
          localcqo.HsP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 15: 
          localcqo.HsQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 16: 
          localcqo.vvy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 17: 
          localcqo.HsR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 18: 
          localcqo.vvx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 19: 
          localcqo.HsI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 20: 
          localcqo.vvu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 21: 
          localcqo.HsH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91657);
          return 0;
        }
        localcqo.HsS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91657);
        return 0;
      }
      AppMethodBeat.o(91657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqo
 * JD-Core Version:    0.7.0.1
 */