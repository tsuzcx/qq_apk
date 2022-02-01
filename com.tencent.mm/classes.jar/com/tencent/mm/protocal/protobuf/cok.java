package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cok
  extends cvp
{
  public String FpZ;
  public cwb GJb;
  public long GJf;
  public long Gbu;
  public dnn Gxg;
  public String dDH;
  public int mrl;
  public int ozR;
  public String ozS;
  public String ozd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72558);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.FpZ != null) {
        paramVarArgs.d(4, this.FpZ);
      }
      paramVarArgs.aY(5, this.GJf);
      paramVarArgs.aY(6, this.Gbu);
      if (this.GJb != null)
      {
        paramVarArgs.lC(7, this.GJb.computeSize());
        this.GJb.writeFields(paramVarArgs);
      }
      if (this.Gxg != null)
      {
        paramVarArgs.lC(8, this.Gxg.computeSize());
        this.Gxg.writeFields(paramVarArgs);
      }
      if (this.ozd != null) {
        paramVarArgs.d(9, this.ozd);
      }
      paramVarArgs.aS(10, this.mrl);
      if (this.dDH != null) {
        paramVarArgs.d(11, this.dDH);
      }
      AppMethodBeat.o(72558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.FpZ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FpZ);
      }
      i = i + f.a.a.b.b.a.p(5, this.GJf) + f.a.a.b.b.a.p(6, this.Gbu);
      paramInt = i;
      if (this.GJb != null) {
        paramInt = i + f.a.a.a.lB(7, this.GJb.computeSize());
      }
      i = paramInt;
      if (this.Gxg != null) {
        i = paramInt + f.a.a.a.lB(8, this.Gxg.computeSize());
      }
      paramInt = i;
      if (this.ozd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ozd);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.mrl);
      paramInt = i;
      if (this.dDH != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dDH);
      }
      AppMethodBeat.o(72558);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cok localcok = (cok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72558);
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
            localcok.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 2: 
          localcok.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72558);
          return 0;
        case 3: 
          localcok.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 4: 
          localcok.FpZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 5: 
          localcok.GJf = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(72558);
          return 0;
        case 6: 
          localcok.Gbu = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(72558);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcok.GJb = ((cwb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcok.Gxg = ((dnn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 9: 
          localcok.ozd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 10: 
          localcok.mrl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72558);
          return 0;
        }
        localcok.dDH = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72558);
        return 0;
      }
      AppMethodBeat.o(72558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cok
 * JD-Core Version:    0.7.0.1
 */