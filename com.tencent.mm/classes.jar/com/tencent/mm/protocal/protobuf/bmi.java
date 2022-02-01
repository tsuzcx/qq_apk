package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bmi
  extends cwj
{
  public int FYj;
  public int GQk;
  public chw GZi;
  public LinkedList<cbz> GZo;
  public String GZp;
  public String GZq;
  public String GZr;
  public String GZs;
  public String GZt;
  public LinkedList<ejb> GZu;
  public String dwb;
  public String dyl;
  public String pqM;
  public int ret;
  public String url;
  
  public bmi()
  {
    AppMethodBeat.i(123588);
    this.GZo = new LinkedList();
    this.GZu = new LinkedList();
    AppMethodBeat.o(123588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ret);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aS(4, this.GQk);
      if (this.dyl != null) {
        paramVarArgs.d(5, this.dyl);
      }
      if (this.GZi != null)
      {
        paramVarArgs.lJ(6, this.GZi.computeSize());
        this.GZi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.GZo);
      if (this.GZp != null) {
        paramVarArgs.d(8, this.GZp);
      }
      if (this.pqM != null) {
        paramVarArgs.d(9, this.pqM);
      }
      paramVarArgs.aS(10, this.FYj);
      if (this.dwb != null) {
        paramVarArgs.d(11, this.dwb);
      }
      if (this.GZq != null) {
        paramVarArgs.d(12, this.GZq);
      }
      if (this.GZr != null) {
        paramVarArgs.d(13, this.GZr);
      }
      if (this.GZs != null) {
        paramVarArgs.d(14, this.GZs);
      }
      if (this.GZt != null) {
        paramVarArgs.d(15, this.GZt);
      }
      paramVarArgs.e(16, 8, this.GZu);
      AppMethodBeat.o(123589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ret);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GQk);
      paramInt = i;
      if (this.dyl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dyl);
      }
      i = paramInt;
      if (this.GZi != null) {
        i = paramInt + f.a.a.a.lI(6, this.GZi.computeSize());
      }
      i += f.a.a.a.c(7, 8, this.GZo);
      paramInt = i;
      if (this.GZp != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GZp);
      }
      i = paramInt;
      if (this.pqM != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.pqM);
      }
      i += f.a.a.b.b.a.bz(10, this.FYj);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dwb);
      }
      i = paramInt;
      if (this.GZq != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GZq);
      }
      paramInt = i;
      if (this.GZr != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GZr);
      }
      i = paramInt;
      if (this.GZs != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GZs);
      }
      paramInt = i;
      if (this.GZt != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GZt);
      }
      i = f.a.a.a.c(16, 8, this.GZu);
      AppMethodBeat.o(123589);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GZo.clear();
        this.GZu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmi localbmi = (bmi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123589);
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
            localbmi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 2: 
          localbmi.ret = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123589);
          return 0;
        case 3: 
          localbmi.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 4: 
          localbmi.GQk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123589);
          return 0;
        case 5: 
          localbmi.dyl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmi.GZi = ((chw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmi.GZo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 8: 
          localbmi.GZp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 9: 
          localbmi.pqM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 10: 
          localbmi.FYj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123589);
          return 0;
        case 11: 
          localbmi.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 12: 
          localbmi.GZq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 13: 
          localbmi.GZr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 14: 
          localbmi.GZs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 15: 
          localbmi.GZt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ejb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmi.GZu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      AppMethodBeat.o(123589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmi
 * JD-Core Version:    0.7.0.1
 */