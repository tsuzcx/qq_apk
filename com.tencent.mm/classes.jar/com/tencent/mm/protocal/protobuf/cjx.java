package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjx
  extends cwj
{
  public String Dsq;
  public ede Hwr;
  public edb Hws;
  public ecv Hwt;
  public edc Hwu;
  public boolean Hwv;
  public LinkedList<String> Hww;
  public ecz Hwx;
  public int drN;
  public String drO;
  public int vPo;
  
  public cjx()
  {
    AppMethodBeat.i(91588);
    this.Hww = new LinkedList();
    AppMethodBeat.o(91588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91589);
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
      if (this.Hwr != null)
      {
        paramVarArgs.lJ(4, this.Hwr.computeSize());
        this.Hwr.writeFields(paramVarArgs);
      }
      if (this.Hws != null)
      {
        paramVarArgs.lJ(5, this.Hws.computeSize());
        this.Hws.writeFields(paramVarArgs);
      }
      if (this.Hwt != null)
      {
        paramVarArgs.lJ(6, this.Hwt.computeSize());
        this.Hwt.writeFields(paramVarArgs);
      }
      if (this.Hwu != null)
      {
        paramVarArgs.lJ(7, this.Hwu.computeSize());
        this.Hwu.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.vPo);
      paramVarArgs.bC(9, this.Hwv);
      if (this.Dsq != null) {
        paramVarArgs.d(10, this.Dsq);
      }
      paramVarArgs.e(11, 1, this.Hww);
      if (this.Hwx != null)
      {
        paramVarArgs.lJ(12, this.Hwx.computeSize());
        this.Hwx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1446;
      }
    }
    label1446:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.drN);
      paramInt = i;
      if (this.drO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.drO);
      }
      i = paramInt;
      if (this.Hwr != null) {
        i = paramInt + f.a.a.a.lI(4, this.Hwr.computeSize());
      }
      paramInt = i;
      if (this.Hws != null) {
        paramInt = i + f.a.a.a.lI(5, this.Hws.computeSize());
      }
      i = paramInt;
      if (this.Hwt != null) {
        i = paramInt + f.a.a.a.lI(6, this.Hwt.computeSize());
      }
      paramInt = i;
      if (this.Hwu != null) {
        paramInt = i + f.a.a.a.lI(7, this.Hwu.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.vPo) + f.a.a.b.b.a.amF(9);
      paramInt = i;
      if (this.Dsq != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Dsq);
      }
      i = paramInt + f.a.a.a.c(11, 1, this.Hww);
      paramInt = i;
      if (this.Hwx != null) {
        paramInt = i + f.a.a.a.lI(12, this.Hwx.computeSize());
      }
      AppMethodBeat.o(91589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hww.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjx localcjx = (cjx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91589);
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
            localcjx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 2: 
          localcjx.drN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91589);
          return 0;
        case 3: 
          localcjx.drO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ede();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ede)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjx.Hwr = ((ede)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjx.Hws = ((edb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjx.Hwt = ((ecv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjx.Hwu = ((edc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 8: 
          localcjx.vPo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91589);
          return 0;
        case 9: 
          localcjx.Hwv = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91589);
          return 0;
        case 10: 
          localcjx.Dsq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 11: 
          localcjx.Hww.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ecz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjx.Hwx = ((ecz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      AppMethodBeat.o(91589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjx
 * JD-Core Version:    0.7.0.1
 */