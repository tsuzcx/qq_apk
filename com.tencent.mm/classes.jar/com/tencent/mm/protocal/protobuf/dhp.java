package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhp
  extends ckq
{
  public cmf ExK;
  public cmf ExL;
  public int ExM;
  public int ExN;
  public int ExO;
  public int ExP;
  public int rNT;
  public int uKQ;
  public int uKR;
  public int uKS;
  public SKBuiltinBuffer_t uKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ExK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientMediaId");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.ExL == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataMD5");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ExK != null)
      {
        paramVarArgs.kX(2, this.ExK.computeSize());
        this.ExK.writeFields(paramVarArgs);
      }
      if (this.ExL != null)
      {
        paramVarArgs.kX(3, this.ExL.computeSize());
        this.ExL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.uKQ);
      paramVarArgs.aR(5, this.uKR);
      paramVarArgs.aR(6, this.uKS);
      if (this.uKT != null)
      {
        paramVarArgs.kX(7, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.rNT);
      paramVarArgs.aR(9, this.ExM);
      paramVarArgs.aR(10, this.ExN);
      paramVarArgs.aR(11, this.ExO);
      paramVarArgs.aR(12, this.ExP);
      AppMethodBeat.o(148659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1286;
      }
    }
    label1286:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ExK != null) {
        paramInt = i + f.a.a.a.kW(2, this.ExK.computeSize());
      }
      i = paramInt;
      if (this.ExL != null) {
        i = paramInt + f.a.a.a.kW(3, this.ExL.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(4, this.uKQ) + f.a.a.b.b.a.bA(5, this.uKR) + f.a.a.b.b.a.bA(6, this.uKS);
      paramInt = i;
      if (this.uKT != null) {
        paramInt = i + f.a.a.a.kW(7, this.uKT.computeSize());
      }
      i = f.a.a.b.b.a.bA(8, this.rNT);
      int j = f.a.a.b.b.a.bA(9, this.ExM);
      int k = f.a.a.b.b.a.bA(10, this.ExN);
      int m = f.a.a.b.b.a.bA(11, this.ExO);
      int n = f.a.a.b.b.a.bA(12, this.ExP);
      AppMethodBeat.o(148659);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.ExK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientMediaId");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.ExL == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataMD5");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.uKT == null)
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
        dhp localdhp = (dhp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148659);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhp.ExK = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhp.ExL = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 4: 
          localdhp.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148659);
          return 0;
        case 5: 
          localdhp.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148659);
          return 0;
        case 6: 
          localdhp.uKS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148659);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhp.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 8: 
          localdhp.rNT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148659);
          return 0;
        case 9: 
          localdhp.ExM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148659);
          return 0;
        case 10: 
          localdhp.ExN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148659);
          return 0;
        case 11: 
          localdhp.ExO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148659);
          return 0;
        }
        localdhp.ExP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148659);
        return 0;
      }
      AppMethodBeat.o(148659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhp
 * JD-Core Version:    0.7.0.1
 */