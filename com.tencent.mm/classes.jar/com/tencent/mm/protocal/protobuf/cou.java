package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cou
  extends cwj
{
  public boolean HAz;
  public LinkedList<cea> HqL;
  public String HqM;
  public LinkedList<cdx> HqQ;
  public String dwb;
  public String hDU;
  public boolean kDe;
  public int kDf;
  public int kDg;
  public String kDh;
  public String kDi;
  
  public cou()
  {
    AppMethodBeat.i(82468);
    this.HqL = new LinkedList();
    this.HqQ = new LinkedList();
    AppMethodBeat.o(82468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82469);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.HAz);
      paramVarArgs.e(3, 8, this.HqL);
      if (this.dwb != null) {
        paramVarArgs.d(4, this.dwb);
      }
      if (this.hDU != null) {
        paramVarArgs.d(5, this.hDU);
      }
      if (this.HqM != null) {
        paramVarArgs.d(6, this.HqM);
      }
      paramVarArgs.e(7, 8, this.HqQ);
      paramVarArgs.bC(8, this.kDe);
      paramVarArgs.aS(9, this.kDf);
      paramVarArgs.aS(10, this.kDg);
      if (this.kDh != null) {
        paramVarArgs.d(11, this.kDh);
      }
      if (this.kDi != null) {
        paramVarArgs.d(12, this.kDi);
      }
      AppMethodBeat.o(82469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2) + f.a.a.a.c(3, 8, this.HqL);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dwb);
      }
      i = paramInt;
      if (this.hDU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hDU);
      }
      paramInt = i;
      if (this.HqM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HqM);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.HqQ) + f.a.a.b.b.a.amF(8) + f.a.a.b.b.a.bz(9, this.kDf) + f.a.a.b.b.a.bz(10, this.kDg);
      paramInt = i;
      if (this.kDh != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.kDh);
      }
      i = paramInt;
      if (this.kDi != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.kDi);
      }
      AppMethodBeat.o(82469);
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
          AppMethodBeat.o(82469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cou localcou = (cou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82469);
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
            localcou.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 2: 
          localcou.HAz = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(82469);
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
            localcou.HqL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 4: 
          localcou.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 5: 
          localcou.hDU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 6: 
          localcou.HqM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HqQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 8: 
          localcou.kDe = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(82469);
          return 0;
        case 9: 
          localcou.kDf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82469);
          return 0;
        case 10: 
          localcou.kDg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82469);
          return 0;
        case 11: 
          localcou.kDh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82469);
          return 0;
        }
        localcou.kDi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82469);
        return 0;
      }
      AppMethodBeat.o(82469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cou
 * JD-Core Version:    0.7.0.1
 */