package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azt
  extends cpx
{
  public int EQQ;
  public LinkedList<buq> EQR;
  public int EQS;
  public LinkedList<brp> EQT;
  public String MD5;
  public int Scene;
  public int fZz;
  
  public azt()
  {
    AppMethodBeat.i(155408);
    this.EQR = new LinkedList();
    this.EQT = new LinkedList();
    AppMethodBeat.o(155408);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.fZz);
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      paramVarArgs.aR(4, this.EQQ);
      paramVarArgs.e(5, 8, this.EQR);
      paramVarArgs.aR(6, this.EQS);
      paramVarArgs.e(7, 8, this.EQT);
      paramVarArgs.aR(8, this.Scene);
      AppMethodBeat.o(155409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.fZz);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.MD5);
      }
      i = f.a.a.b.b.a.bx(4, this.EQQ);
      int j = f.a.a.a.c(5, 8, this.EQR);
      int k = f.a.a.b.b.a.bx(6, this.EQS);
      int m = f.a.a.a.c(7, 8, this.EQT);
      int n = f.a.a.b.b.a.bx(8, this.Scene);
      AppMethodBeat.o(155409);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EQR.clear();
        this.EQT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azt localazt = (azt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155409);
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
            localazt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 2: 
          localazt.fZz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155409);
          return 0;
        case 3: 
          localazt.MD5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155409);
          return 0;
        case 4: 
          localazt.EQQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155409);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazt.EQR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 6: 
          localazt.EQS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155409);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazt.EQT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        }
        localazt.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155409);
        return 0;
      }
      AppMethodBeat.o(155409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azt
 * JD-Core Version:    0.7.0.1
 */