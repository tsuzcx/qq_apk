package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byy
  extends cpx
{
  public int DZA;
  public int FnW;
  public LinkedList<bza> FnX;
  public LinkedList<byx> FnY;
  
  public byy()
  {
    AppMethodBeat.i(6413);
    this.FnX = new LinkedList();
    this.FnY = new LinkedList();
    AppMethodBeat.o(6413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FnW);
      paramVarArgs.aR(3, this.DZA);
      paramVarArgs.e(4, 8, this.FnX);
      paramVarArgs.e(5, 8, this.FnY);
      AppMethodBeat.o(6414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label697;
      }
    }
    label697:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FnW);
      int j = f.a.a.b.b.a.bx(3, this.DZA);
      int k = f.a.a.a.c(4, 8, this.FnX);
      int m = f.a.a.a.c(5, 8, this.FnY);
      AppMethodBeat.o(6414);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FnX.clear();
        this.FnY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6414);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byy localbyy = (byy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6414);
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
            localbyy.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        case 2: 
          localbyy.FnW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6414);
          return 0;
        case 3: 
          localbyy.DZA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6414);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bza();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyy.FnX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyy.FnY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6414);
        return 0;
      }
      AppMethodBeat.o(6414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byy
 * JD-Core Version:    0.7.0.1
 */