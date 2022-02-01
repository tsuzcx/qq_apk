package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqe
  extends cwj
{
  public String FXI;
  public ctz HWU;
  public String HWV;
  public String HWW;
  public String HWX;
  public ctz HXf;
  public LinkedList<aed> HXg;
  public String HXh;
  public String HXi;
  public String HXj;
  public String oED;
  public int oGt;
  public String oGu;
  public String ykU;
  public String ykV;
  public int ykW;
  public int yoX;
  
  public dqe()
  {
    AppMethodBeat.i(72598);
    this.HXg = new LinkedList();
    AppMethodBeat.o(72598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72599);
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
      paramVarArgs.aS(4, this.ykW);
      if (this.HXf != null)
      {
        paramVarArgs.lJ(5, this.HXf.computeSize());
        this.HXf.writeFields(paramVarArgs);
      }
      if (this.HWV != null) {
        paramVarArgs.d(6, this.HWV);
      }
      if (this.HWW != null) {
        paramVarArgs.d(7, this.HWW);
      }
      if (this.ykU != null) {
        paramVarArgs.d(8, this.ykU);
      }
      if (this.ykV != null) {
        paramVarArgs.d(9, this.ykV);
      }
      if (this.oED != null) {
        paramVarArgs.d(10, this.oED);
      }
      if (this.FXI != null) {
        paramVarArgs.d(11, this.FXI);
      }
      paramVarArgs.aS(12, this.yoX);
      paramVarArgs.e(13, 8, this.HXg);
      if (this.HXh != null) {
        paramVarArgs.d(14, this.HXh);
      }
      if (this.HXi != null) {
        paramVarArgs.d(15, this.HXi);
      }
      if (this.HWX != null) {
        paramVarArgs.d(16, this.HWX);
      }
      if (this.HXj != null) {
        paramVarArgs.d(17, this.HXj);
      }
      if (this.HWU != null)
      {
        paramVarArgs.lJ(18, this.HWU.computeSize());
        this.HWU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1574;
      }
    }
    label1574:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.ykW);
      paramInt = i;
      if (this.HXf != null) {
        paramInt = i + f.a.a.a.lI(5, this.HXf.computeSize());
      }
      i = paramInt;
      if (this.HWV != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HWV);
      }
      paramInt = i;
      if (this.HWW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HWW);
      }
      i = paramInt;
      if (this.ykU != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ykU);
      }
      paramInt = i;
      if (this.ykV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ykV);
      }
      i = paramInt;
      if (this.oED != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.oED);
      }
      paramInt = i;
      if (this.FXI != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FXI);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.yoX) + f.a.a.a.c(13, 8, this.HXg);
      paramInt = i;
      if (this.HXh != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HXh);
      }
      i = paramInt;
      if (this.HXi != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HXi);
      }
      paramInt = i;
      if (this.HWX != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.HWX);
      }
      i = paramInt;
      if (this.HXj != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HXj);
      }
      paramInt = i;
      if (this.HWU != null) {
        paramInt = i + f.a.a.a.lI(18, this.HWU.computeSize());
      }
      AppMethodBeat.o(72599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HXg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqe localdqe = (dqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72599);
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
            localdqe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 2: 
          localdqe.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72599);
          return 0;
        case 3: 
          localdqe.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 4: 
          localdqe.ykW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72599);
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
            localdqe.HXf = ((ctz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 6: 
          localdqe.HWV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 7: 
          localdqe.HWW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 8: 
          localdqe.ykU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 9: 
          localdqe.ykV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 10: 
          localdqe.oED = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 11: 
          localdqe.FXI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 12: 
          localdqe.yoX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72599);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aed();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aed)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqe.HXg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 14: 
          localdqe.HXh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 15: 
          localdqe.HXi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 16: 
          localdqe.HWX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 17: 
          localdqe.HXj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqe.HWU = ((ctz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      AppMethodBeat.o(72599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqe
 * JD-Core Version:    0.7.0.1
 */