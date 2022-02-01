package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class baf
  extends cpx
{
  public crm DPT;
  public crm DPU;
  public int ERj;
  public int vTH;
  public int vTI;
  public int vTJ;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.vTO);
      if (this.DPT != null)
      {
        paramVarArgs.ln(3, this.DPT.computeSize());
        this.DPT.writeFields(paramVarArgs);
      }
      if (this.DPU != null)
      {
        paramVarArgs.ln(4, this.DPU.computeSize());
        this.DPU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.vTH);
      paramVarArgs.aR(6, this.vTI);
      paramVarArgs.aR(7, this.vTJ);
      paramVarArgs.aR(8, this.ERj);
      paramVarArgs.aO(9, this.vTQ);
      AppMethodBeat.o(152572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTO);
      paramInt = i;
      if (this.DPT != null) {
        paramInt = i + f.a.a.a.lm(3, this.DPT.computeSize());
      }
      i = paramInt;
      if (this.DPU != null) {
        i = paramInt + f.a.a.a.lm(4, this.DPU.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(5, this.vTH);
      int j = f.a.a.b.b.a.bx(6, this.vTI);
      int k = f.a.a.b.b.a.bx(7, this.vTJ);
      int m = f.a.a.b.b.a.bx(8, this.ERj);
      int n = f.a.a.b.b.a.p(9, this.vTQ);
      AppMethodBeat.o(152572);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DPT == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        if (this.DPU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        baf localbaf = (baf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152572);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 2: 
          localbaf.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152572);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaf.DPT = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaf.DPU = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 5: 
          localbaf.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152572);
          return 0;
        case 6: 
          localbaf.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152572);
          return 0;
        case 7: 
          localbaf.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152572);
          return 0;
        case 8: 
          localbaf.ERj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152572);
          return 0;
        }
        localbaf.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(152572);
        return 0;
      }
      AppMethodBeat.o(152572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baf
 * JD-Core Version:    0.7.0.1
 */