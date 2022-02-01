package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpu
  extends cvp
{
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
  
  public cpu()
  {
    AppMethodBeat.i(91656);
    this.GZl = new LinkedList();
    AppMethodBeat.o(91656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91657);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.dOa);
      paramVarArgs.aS(3, this.GZi);
      paramVarArgs.aY(4, this.GZj);
      paramVarArgs.aS(5, this.FpJ);
      paramVarArgs.aY(6, this.GZk);
      paramVarArgs.aS(9, this.vjq);
      paramVarArgs.e(10, 8, this.GZl);
      if (this.vjr != null) {
        paramVarArgs.d(11, this.vjr);
      }
      if (this.GZm != null) {
        paramVarArgs.d(12, this.GZm);
      }
      if (this.GZn != null) {
        paramVarArgs.d(13, this.GZn);
      }
      if (this.GZo != null) {
        paramVarArgs.d(14, this.GZo);
      }
      paramVarArgs.aS(15, this.GZp);
      if (this.vjt != null) {
        paramVarArgs.d(16, this.vjt);
      }
      paramVarArgs.aS(17, this.GZq);
      if (this.vjs != null) {
        paramVarArgs.d(18, this.vjs);
      }
      paramVarArgs.aS(19, this.GZh);
      paramVarArgs.aS(20, this.vjp);
      paramVarArgs.aS(21, this.GZg);
      if (this.GZr != null) {
        paramVarArgs.d(22, this.GZr);
      }
      AppMethodBeat.o(91657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.dOa) + f.a.a.b.b.a.bz(3, this.GZi) + f.a.a.b.b.a.p(4, this.GZj) + f.a.a.b.b.a.bz(5, this.FpJ) + f.a.a.b.b.a.p(6, this.GZk) + f.a.a.b.b.a.bz(9, this.vjq) + f.a.a.a.c(10, 8, this.GZl);
      paramInt = i;
      if (this.vjr != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.vjr);
      }
      i = paramInt;
      if (this.GZm != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GZm);
      }
      paramInt = i;
      if (this.GZn != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GZn);
      }
      i = paramInt;
      if (this.GZo != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GZo);
      }
      i += f.a.a.b.b.a.bz(15, this.GZp);
      paramInt = i;
      if (this.vjt != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.vjt);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.GZq);
      paramInt = i;
      if (this.vjs != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.vjs);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.GZh) + f.a.a.b.b.a.bz(20, this.vjp) + f.a.a.b.b.a.bz(21, this.GZg);
      paramInt = i;
      if (this.GZr != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.GZr);
      }
      AppMethodBeat.o(91657);
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
          AppMethodBeat.o(91657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpu localcpu = (cpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(91657);
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
            localcpu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 2: 
          localcpu.dOa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91657);
          return 0;
        case 3: 
          localcpu.GZi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 4: 
          localcpu.GZj = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91657);
          return 0;
        case 5: 
          localcpu.FpJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 6: 
          localcpu.GZk = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91657);
          return 0;
        case 9: 
          localcpu.vjq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpu.GZl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 11: 
          localcpu.vjr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 12: 
          localcpu.GZm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 13: 
          localcpu.GZn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 14: 
          localcpu.GZo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 15: 
          localcpu.GZp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 16: 
          localcpu.vjt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 17: 
          localcpu.GZq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 18: 
          localcpu.vjs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 19: 
          localcpu.GZh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 20: 
          localcpu.vjp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91657);
          return 0;
        case 21: 
          localcpu.GZg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91657);
          return 0;
        }
        localcpu.GZr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91657);
        return 0;
      }
      AppMethodBeat.o(91657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpu
 * JD-Core Version:    0.7.0.1
 */