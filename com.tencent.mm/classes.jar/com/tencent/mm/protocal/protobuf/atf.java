package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atf
  extends cwj
{
  public FinderContact GEh;
  public int GKa;
  public String GKb;
  public String GKc;
  public String GKd;
  public int GKe;
  public int GKf;
  public acq GKg;
  public int GKh;
  public int GKi;
  public int actionType;
  public int sMJ;
  public int sPj;
  public aqk verifyInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.actionType);
      if (this.verifyInfo != null)
      {
        paramVarArgs.lJ(3, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      if (this.GEh != null)
      {
        paramVarArgs.lJ(4, this.GEh.computeSize());
        this.GEh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GKa);
      if (this.GKb != null) {
        paramVarArgs.d(6, this.GKb);
      }
      if (this.GKc != null) {
        paramVarArgs.d(7, this.GKc);
      }
      if (this.GKd != null) {
        paramVarArgs.d(8, this.GKd);
      }
      paramVarArgs.aS(9, this.GKe);
      paramVarArgs.aS(10, this.sPj);
      paramVarArgs.aS(11, this.GKf);
      paramVarArgs.aS(12, this.sMJ);
      if (this.GKg != null)
      {
        paramVarArgs.lJ(13, this.GKg.computeSize());
        this.GKg.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.GKh);
      paramVarArgs.aS(15, this.GKi);
      AppMethodBeat.o(169074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1322;
      }
    }
    label1322:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.actionType);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + f.a.a.a.lI(3, this.verifyInfo.computeSize());
      }
      i = paramInt;
      if (this.GEh != null) {
        i = paramInt + f.a.a.a.lI(4, this.GEh.computeSize());
      }
      i += f.a.a.b.b.a.bz(5, this.GKa);
      paramInt = i;
      if (this.GKb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKb);
      }
      i = paramInt;
      if (this.GKc != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GKc);
      }
      paramInt = i;
      if (this.GKd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GKd);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GKe) + f.a.a.b.b.a.bz(10, this.sPj) + f.a.a.b.b.a.bz(11, this.GKf) + f.a.a.b.b.a.bz(12, this.sMJ);
      paramInt = i;
      if (this.GKg != null) {
        paramInt = i + f.a.a.a.lI(13, this.GKg.computeSize());
      }
      i = f.a.a.b.b.a.bz(14, this.GKh);
      int j = f.a.a.b.b.a.bz(15, this.GKi);
      AppMethodBeat.o(169074);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atf localatf = (atf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169074);
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
            localatf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 2: 
          localatf.actionType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatf.verifyInfo = ((aqk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatf.GEh = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 5: 
          localatf.GKa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 6: 
          localatf.GKb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 7: 
          localatf.GKc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 8: 
          localatf.GKd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 9: 
          localatf.GKe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 10: 
          localatf.sPj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 11: 
          localatf.GKf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 12: 
          localatf.sMJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169074);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatf.GKg = ((acq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 14: 
          localatf.GKh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169074);
          return 0;
        }
        localatf.GKi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169074);
        return 0;
      }
      AppMethodBeat.o(169074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atf
 * JD-Core Version:    0.7.0.1
 */