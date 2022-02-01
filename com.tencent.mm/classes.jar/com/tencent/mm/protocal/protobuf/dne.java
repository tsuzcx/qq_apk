package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dne
  extends cpx
{
  public crm FUM;
  public crm FUN;
  public int FUO;
  public int FUP;
  public int FUQ;
  public int FUR;
  public int sVK;
  public int vTH;
  public int vTI;
  public int vTJ;
  public SKBuiltinBuffer_t vTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUM == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientMediaId");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.FUN == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataMD5");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FUM != null)
      {
        paramVarArgs.ln(2, this.FUM.computeSize());
        this.FUM.writeFields(paramVarArgs);
      }
      if (this.FUN != null)
      {
        paramVarArgs.ln(3, this.FUN.computeSize());
        this.FUN.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.vTH);
      paramVarArgs.aR(5, this.vTI);
      paramVarArgs.aR(6, this.vTJ);
      if (this.vTK != null)
      {
        paramVarArgs.ln(7, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.sVK);
      paramVarArgs.aR(9, this.FUO);
      paramVarArgs.aR(10, this.FUP);
      paramVarArgs.aR(11, this.FUQ);
      paramVarArgs.aR(12, this.FUR);
      AppMethodBeat.o(148659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1286;
      }
    }
    label1286:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FUM != null) {
        paramInt = i + f.a.a.a.lm(2, this.FUM.computeSize());
      }
      i = paramInt;
      if (this.FUN != null) {
        i = paramInt + f.a.a.a.lm(3, this.FUN.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(4, this.vTH) + f.a.a.b.b.a.bx(5, this.vTI) + f.a.a.b.b.a.bx(6, this.vTJ);
      paramInt = i;
      if (this.vTK != null) {
        paramInt = i + f.a.a.a.lm(7, this.vTK.computeSize());
      }
      i = f.a.a.b.b.a.bx(8, this.sVK);
      int j = f.a.a.b.b.a.bx(9, this.FUO);
      int k = f.a.a.b.b.a.bx(10, this.FUP);
      int m = f.a.a.b.b.a.bx(11, this.FUQ);
      int n = f.a.a.b.b.a.bx(12, this.FUR);
      AppMethodBeat.o(148659);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FUM == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientMediaId");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.FUN == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataMD5");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dne localdne = (dne)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148659);
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
            localdne.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdne.FUM = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
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
            localdne.FUN = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 4: 
          localdne.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148659);
          return 0;
        case 5: 
          localdne.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148659);
          return 0;
        case 6: 
          localdne.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148659);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdne.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 8: 
          localdne.sVK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148659);
          return 0;
        case 9: 
          localdne.FUO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148659);
          return 0;
        case 10: 
          localdne.FUP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148659);
          return 0;
        case 11: 
          localdne.FUQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148659);
          return 0;
        }
        localdne.FUR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148659);
        return 0;
      }
      AppMethodBeat.o(148659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dne
 * JD-Core Version:    0.7.0.1
 */