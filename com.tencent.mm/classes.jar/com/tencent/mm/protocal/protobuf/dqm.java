package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqm
  extends cwj
{
  public String FIw;
  public String FOg;
  public ctz HWU;
  public String HWY;
  public String HXn;
  public String HXp;
  public int HXq;
  public int HXr;
  public ctz HXs;
  public yq HXt;
  public cua HXu;
  public String HXv;
  public String dwj;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.aS(4, this.HXq);
      if (this.HWU != null)
      {
        paramVarArgs.lJ(5, this.HWU.computeSize());
        this.HWU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HXr);
      if (this.HXs != null)
      {
        paramVarArgs.lJ(7, this.HXs.computeSize());
        this.HXs.writeFields(paramVarArgs);
      }
      if (this.HXt != null)
      {
        paramVarArgs.lJ(8, this.HXt.computeSize());
        this.HXt.writeFields(paramVarArgs);
      }
      if (this.HXu != null)
      {
        paramVarArgs.lJ(9, this.HXu.computeSize());
        this.HXu.writeFields(paramVarArgs);
      }
      if (this.dwj != null) {
        paramVarArgs.d(10, this.dwj);
      }
      if (this.FIw != null) {
        paramVarArgs.d(11, this.FIw);
      }
      if (this.FOg != null) {
        paramVarArgs.d(12, this.FOg);
      }
      if (this.HXn != null) {
        paramVarArgs.d(13, this.HXn);
      }
      if (this.HXv != null) {
        paramVarArgs.d(14, this.HXv);
      }
      if (this.HXp != null) {
        paramVarArgs.d(15, this.HXp);
      }
      if (this.HWY != null) {
        paramVarArgs.d(16, this.HWY);
      }
      AppMethodBeat.o(72608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1562;
      }
    }
    label1562:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HXq);
      paramInt = i;
      if (this.HWU != null) {
        paramInt = i + f.a.a.a.lI(5, this.HWU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HXr);
      paramInt = i;
      if (this.HXs != null) {
        paramInt = i + f.a.a.a.lI(7, this.HXs.computeSize());
      }
      i = paramInt;
      if (this.HXt != null) {
        i = paramInt + f.a.a.a.lI(8, this.HXt.computeSize());
      }
      paramInt = i;
      if (this.HXu != null) {
        paramInt = i + f.a.a.a.lI(9, this.HXu.computeSize());
      }
      i = paramInt;
      if (this.dwj != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dwj);
      }
      paramInt = i;
      if (this.FIw != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FIw);
      }
      i = paramInt;
      if (this.FOg != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FOg);
      }
      paramInt = i;
      if (this.HXn != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HXn);
      }
      i = paramInt;
      if (this.HXv != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HXv);
      }
      paramInt = i;
      if (this.HXp != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.HXp);
      }
      i = paramInt;
      if (this.HWY != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.HWY);
      }
      AppMethodBeat.o(72608);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqm localdqm = (dqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72608);
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
            localdqm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 2: 
          localdqm.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72608);
          return 0;
        case 3: 
          localdqm.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 4: 
          localdqm.HXq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72608);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqm.HWU = ((ctz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 6: 
          localdqm.HXr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72608);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqm.HXs = ((ctz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqm.HXt = ((yq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cua();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cua)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqm.HXu = ((cua)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 10: 
          localdqm.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 11: 
          localdqm.FIw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 12: 
          localdqm.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 13: 
          localdqm.HXn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 14: 
          localdqm.HXv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 15: 
          localdqm.HXp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72608);
          return 0;
        }
        localdqm.HWY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72608);
        return 0;
      }
      AppMethodBeat.o(72608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqm
 * JD-Core Version:    0.7.0.1
 */