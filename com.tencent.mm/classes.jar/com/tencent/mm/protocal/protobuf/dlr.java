package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlr
  extends cwj
{
  public com.tencent.mm.bw.b Buffer;
  public int HSW;
  public dlu HTe;
  public String HTf;
  public String HTg;
  public int HTh;
  public int HTi;
  public int HTj;
  public boolean HTk;
  public String HTl;
  public int HTm;
  public int HTn;
  public int HTo;
  public String HTp;
  public boolean HTq;
  public String HTr;
  public String HTs;
  public int HTt;
  public dls HTu;
  public LinkedList<dlp> uqO;
  
  public dlr()
  {
    AppMethodBeat.i(152706);
    this.uqO = new LinkedList();
    AppMethodBeat.o(152706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152707);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.uqO);
      if (this.HTe != null)
      {
        paramVarArgs.lJ(3, this.HTe.computeSize());
        this.HTe.writeFields(paramVarArgs);
      }
      if (this.HTf != null) {
        paramVarArgs.d(4, this.HTf);
      }
      if (this.HTg != null) {
        paramVarArgs.d(5, this.HTg);
      }
      paramVarArgs.aS(6, this.HTh);
      paramVarArgs.aS(9, this.HTi);
      paramVarArgs.aS(10, this.HTj);
      paramVarArgs.aS(11, this.HSW);
      paramVarArgs.bC(12, this.HTk);
      if (this.HTl != null) {
        paramVarArgs.d(13, this.HTl);
      }
      paramVarArgs.aS(14, this.HTm);
      paramVarArgs.aS(15, this.HTn);
      if (this.Buffer != null) {
        paramVarArgs.c(16, this.Buffer);
      }
      paramVarArgs.aS(17, this.HTo);
      if (this.HTp != null) {
        paramVarArgs.d(18, this.HTp);
      }
      paramVarArgs.bC(19, this.HTq);
      if (this.HTr != null) {
        paramVarArgs.d(20, this.HTr);
      }
      if (this.HTs != null) {
        paramVarArgs.d(21, this.HTs);
      }
      paramVarArgs.aS(22, this.HTt);
      if (this.HTu != null)
      {
        paramVarArgs.lJ(23, this.HTu.computeSize());
        this.HTu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1690;
      }
    }
    label1690:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.uqO);
      paramInt = i;
      if (this.HTe != null) {
        paramInt = i + f.a.a.a.lI(3, this.HTe.computeSize());
      }
      i = paramInt;
      if (this.HTf != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HTf);
      }
      paramInt = i;
      if (this.HTg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HTg);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HTh) + f.a.a.b.b.a.bz(9, this.HTi) + f.a.a.b.b.a.bz(10, this.HTj) + f.a.a.b.b.a.bz(11, this.HSW) + f.a.a.b.b.a.amF(12);
      paramInt = i;
      if (this.HTl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HTl);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.HTm) + f.a.a.b.b.a.bz(15, this.HTn);
      paramInt = i;
      if (this.Buffer != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.Buffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.HTo);
      paramInt = i;
      if (this.HTp != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HTp);
      }
      i = paramInt + f.a.a.b.b.a.amF(19);
      paramInt = i;
      if (this.HTr != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.HTr);
      }
      i = paramInt;
      if (this.HTs != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.HTs);
      }
      i += f.a.a.b.b.a.bz(22, this.HTt);
      paramInt = i;
      if (this.HTu != null) {
        paramInt = i + f.a.a.a.lI(23, this.HTu.computeSize());
      }
      AppMethodBeat.o(152707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uqO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlr localdlr = (dlr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152707);
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
            localdlr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlr.uqO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlr.HTe = ((dlu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 4: 
          localdlr.HTf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 5: 
          localdlr.HTg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 6: 
          localdlr.HTh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 9: 
          localdlr.HTi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 10: 
          localdlr.HTj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 11: 
          localdlr.HSW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 12: 
          localdlr.HTk = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(152707);
          return 0;
        case 13: 
          localdlr.HTl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 14: 
          localdlr.HTm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 15: 
          localdlr.HTn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 16: 
          localdlr.Buffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(152707);
          return 0;
        case 17: 
          localdlr.HTo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 18: 
          localdlr.HTp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 19: 
          localdlr.HTq = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(152707);
          return 0;
        case 20: 
          localdlr.HTr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 21: 
          localdlr.HTs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 22: 
          localdlr.HTt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152707);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dls();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dls)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlr.HTu = ((dls)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      AppMethodBeat.o(152707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlr
 * JD-Core Version:    0.7.0.1
 */