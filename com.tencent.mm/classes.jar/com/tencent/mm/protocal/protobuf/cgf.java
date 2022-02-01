package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgf
  extends cvp
{
  public cra FTQ;
  public int FpJ;
  public int GZg;
  public int GZh;
  public int GZi;
  public long GZj;
  public long GZk;
  public LinkedList<bmz> GZl;
  public String GZm;
  public String GZn;
  public String GZo;
  public int GZp;
  public int GZq;
  public String GZr;
  public long dOa;
  public int vjp;
  public int vjq;
  public String vjr;
  public String vjs;
  public String vjt;
  
  public cgf()
  {
    AppMethodBeat.i(91566);
    this.GZl = new LinkedList();
    AppMethodBeat.o(91566);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GZg);
      paramVarArgs.aS(3, this.GZh);
      paramVarArgs.aS(4, this.vjp);
      paramVarArgs.aY(5, this.dOa);
      paramVarArgs.aS(6, this.GZi);
      paramVarArgs.aY(7, this.GZj);
      paramVarArgs.aS(8, this.FpJ);
      paramVarArgs.aY(9, this.GZk);
      paramVarArgs.aS(10, this.vjq);
      paramVarArgs.e(11, 8, this.GZl);
      if (this.vjr != null) {
        paramVarArgs.d(12, this.vjr);
      }
      if (this.GZm != null) {
        paramVarArgs.d(13, this.GZm);
      }
      if (this.GZn != null) {
        paramVarArgs.d(14, this.GZn);
      }
      if (this.GZo != null) {
        paramVarArgs.d(15, this.GZo);
      }
      paramVarArgs.aS(16, this.GZp);
      if (this.vjt != null) {
        paramVarArgs.d(17, this.vjt);
      }
      paramVarArgs.aS(18, this.GZq);
      if (this.vjs != null) {
        paramVarArgs.d(19, this.vjs);
      }
      if (this.FTQ != null)
      {
        paramVarArgs.lC(20, this.FTQ.computeSize());
        this.FTQ.writeFields(paramVarArgs);
      }
      if (this.GZr != null) {
        paramVarArgs.d(21, this.GZr);
      }
      AppMethodBeat.o(91567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GZg) + f.a.a.b.b.a.bz(3, this.GZh) + f.a.a.b.b.a.bz(4, this.vjp) + f.a.a.b.b.a.p(5, this.dOa) + f.a.a.b.b.a.bz(6, this.GZi) + f.a.a.b.b.a.p(7, this.GZj) + f.a.a.b.b.a.bz(8, this.FpJ) + f.a.a.b.b.a.p(9, this.GZk) + f.a.a.b.b.a.bz(10, this.vjq) + f.a.a.a.c(11, 8, this.GZl);
      paramInt = i;
      if (this.vjr != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.vjr);
      }
      i = paramInt;
      if (this.GZm != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GZm);
      }
      paramInt = i;
      if (this.GZn != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GZn);
      }
      i = paramInt;
      if (this.GZo != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GZo);
      }
      i += f.a.a.b.b.a.bz(16, this.GZp);
      paramInt = i;
      if (this.vjt != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.vjt);
      }
      i = paramInt + f.a.a.b.b.a.bz(18, this.GZq);
      paramInt = i;
      if (this.vjs != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.vjs);
      }
      i = paramInt;
      if (this.FTQ != null) {
        i = paramInt + f.a.a.a.lB(20, this.FTQ.computeSize());
      }
      paramInt = i;
      if (this.GZr != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GZr);
      }
      AppMethodBeat.o(91567);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GZl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgf localcgf = (cgf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91567);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 2: 
          localcgf.GZg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 3: 
          localcgf.GZh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 4: 
          localcgf.vjp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 5: 
          localcgf.dOa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91567);
          return 0;
        case 6: 
          localcgf.GZi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 7: 
          localcgf.GZj = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91567);
          return 0;
        case 8: 
          localcgf.FpJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 9: 
          localcgf.GZk = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91567);
          return 0;
        case 10: 
          localcgf.vjq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgf.GZl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 12: 
          localcgf.vjr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 13: 
          localcgf.GZm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 14: 
          localcgf.GZn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 15: 
          localcgf.GZo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 16: 
          localcgf.GZp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 17: 
          localcgf.vjt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 18: 
          localcgf.GZq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91567);
          return 0;
        case 19: 
          localcgf.vjs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cra();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgf.FTQ = ((cra)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        }
        localcgf.GZr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91567);
        return 0;
      }
      AppMethodBeat.o(91567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgf
 * JD-Core Version:    0.7.0.1
 */