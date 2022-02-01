package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class mw
  extends dpc
{
  public int KRA;
  public int KRg;
  public int KRh;
  public long KRi;
  public int KRs;
  public String KRt;
  public String KRu;
  public String KRv;
  public GoodsObject KRw;
  public boolean KRx = false;
  public int KRy;
  public boolean KRz;
  public String dNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124395);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124395);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KRs);
      if (this.KRt != null) {
        paramVarArgs.e(3, this.KRt);
      }
      if (this.KRu != null) {
        paramVarArgs.e(4, this.KRu);
      }
      if (this.dNQ != null) {
        paramVarArgs.e(7, this.dNQ);
      }
      if (this.KRv != null) {
        paramVarArgs.e(8, this.KRv);
      }
      if (this.KRw != null)
      {
        paramVarArgs.ni(9, this.KRw.computeSize());
        this.KRw.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.KRg);
      paramVarArgs.bb(11, this.KRi);
      paramVarArgs.aM(12, this.KRh);
      paramVarArgs.cc(13, this.KRx);
      paramVarArgs.aM(16, this.KRy);
      paramVarArgs.cc(17, this.KRz);
      paramVarArgs.aM(50, this.KRA);
      AppMethodBeat.o(124395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KRs);
      paramInt = i;
      if (this.KRt != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KRt);
      }
      i = paramInt;
      if (this.KRu != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KRu);
      }
      paramInt = i;
      if (this.dNQ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.dNQ);
      }
      i = paramInt;
      if (this.KRv != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KRv);
      }
      paramInt = i;
      if (this.KRw != null) {
        paramInt = i + g.a.a.a.nh(9, this.KRw.computeSize());
      }
      i = g.a.a.b.b.a.bu(10, this.KRg);
      int j = g.a.a.b.b.a.r(11, this.KRi);
      int k = g.a.a.b.b.a.bu(12, this.KRh);
      int m = g.a.a.b.b.a.fS(13);
      int n = g.a.a.b.b.a.bu(16, this.KRy);
      int i1 = g.a.a.b.b.a.fS(17);
      int i2 = g.a.a.b.b.a.bu(50, this.KRA);
      AppMethodBeat.o(124395);
      return paramInt + i + j + k + (m + 1) + n + (i1 + 1) + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124395);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mw localmw = (mw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124395);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 2: 
          localmw.KRs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124395);
          return 0;
        case 3: 
          localmw.KRt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 4: 
          localmw.KRu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 7: 
          localmw.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 8: 
          localmw.KRv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmw.KRw = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 10: 
          localmw.KRg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124395);
          return 0;
        case 11: 
          localmw.KRi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124395);
          return 0;
        case 12: 
          localmw.KRh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124395);
          return 0;
        case 13: 
          localmw.KRx = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(124395);
          return 0;
        case 16: 
          localmw.KRy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124395);
          return 0;
        case 17: 
          localmw.KRz = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(124395);
          return 0;
        }
        localmw.KRA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124395);
        return 0;
      }
      AppMethodBeat.o(124395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mw
 * JD-Core Version:    0.7.0.1
 */