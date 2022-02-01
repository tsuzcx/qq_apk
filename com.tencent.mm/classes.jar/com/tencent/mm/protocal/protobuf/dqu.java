package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqu
  extends cwj
{
  public String FPO;
  public int GZU;
  public String HDH;
  public String HXK;
  public String HXL;
  public des HXM;
  public String HXN;
  public com.tencent.mm.bw.b HXO;
  public String Hwj;
  public int drN;
  public String drO;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152714);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.drN);
      if (this.drO != null) {
        paramVarArgs.d(3, this.drO);
      }
      if (this.HXK != null) {
        paramVarArgs.d(4, this.HXK);
      }
      if (this.HXL != null) {
        paramVarArgs.d(5, this.HXL);
      }
      if (this.HXM != null)
      {
        paramVarArgs.lJ(6, this.HXM.computeSize());
        this.HXM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.version);
      if (this.HXN != null) {
        paramVarArgs.d(8, this.HXN);
      }
      paramVarArgs.aS(9, this.GZU);
      if (this.Hwj != null) {
        paramVarArgs.d(10, this.Hwj);
      }
      if (this.HDH != null) {
        paramVarArgs.d(11, this.HDH);
      }
      if (this.FPO != null) {
        paramVarArgs.d(12, this.FPO);
      }
      if (this.HXO != null) {
        paramVarArgs.c(13, this.HXO);
      }
      AppMethodBeat.o(152714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.drN);
      paramInt = i;
      if (this.drO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.drO);
      }
      i = paramInt;
      if (this.HXK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HXK);
      }
      paramInt = i;
      if (this.HXL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HXL);
      }
      i = paramInt;
      if (this.HXM != null) {
        i = paramInt + f.a.a.a.lI(6, this.HXM.computeSize());
      }
      i += f.a.a.b.b.a.bz(7, this.version);
      paramInt = i;
      if (this.HXN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HXN);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GZU);
      paramInt = i;
      if (this.Hwj != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hwj);
      }
      i = paramInt;
      if (this.HDH != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HDH);
      }
      paramInt = i;
      if (this.FPO != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FPO);
      }
      i = paramInt;
      if (this.HXO != null) {
        i = paramInt + f.a.a.b.b.a.b(13, this.HXO);
      }
      AppMethodBeat.o(152714);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152714);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqu localdqu = (dqu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152714);
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
            localdqu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 2: 
          localdqu.drN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152714);
          return 0;
        case 3: 
          localdqu.drO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 4: 
          localdqu.HXK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 5: 
          localdqu.HXL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new des();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((des)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqu.HXM = ((des)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 7: 
          localdqu.version = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152714);
          return 0;
        case 8: 
          localdqu.HXN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 9: 
          localdqu.GZU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152714);
          return 0;
        case 10: 
          localdqu.Hwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 11: 
          localdqu.HDH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 12: 
          localdqu.FPO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152714);
          return 0;
        }
        localdqu.HXO = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(152714);
        return 0;
      }
      AppMethodBeat.o(152714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqu
 * JD-Core Version:    0.7.0.1
 */