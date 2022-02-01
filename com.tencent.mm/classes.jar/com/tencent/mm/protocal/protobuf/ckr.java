package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ckr
  extends cpx
{
  public ir Epy;
  public int EqE;
  public int EqF;
  public b FyA;
  public b FyB;
  public int FyC;
  public cks FyD;
  public int Fyy;
  public b Fyz;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Epy != null)
      {
        paramVarArgs.ln(2, this.Epy.computeSize());
        this.Epy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Fyy);
      if (this.Fyz != null) {
        paramVarArgs.c(4, this.Fyz);
      }
      if (this.FyA != null) {
        paramVarArgs.c(5, this.FyA);
      }
      if (this.FyB != null) {
        paramVarArgs.c(6, this.FyB);
      }
      paramVarArgs.aR(7, this.EqF);
      paramVarArgs.aR(8, this.EqE);
      paramVarArgs.aR(9, this.FyC);
      paramVarArgs.aO(10, this.timestamp);
      if (this.FyD != null)
      {
        paramVarArgs.ln(11, this.FyD.computeSize());
        this.FyD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Epy != null) {
        i = paramInt + f.a.a.a.lm(2, this.Epy.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.Fyy);
      paramInt = i;
      if (this.Fyz != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Fyz);
      }
      i = paramInt;
      if (this.FyA != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.FyA);
      }
      paramInt = i;
      if (this.FyB != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.FyB);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.EqF) + f.a.a.b.b.a.bx(8, this.EqE) + f.a.a.b.b.a.bx(9, this.FyC) + f.a.a.b.b.a.p(10, this.timestamp);
      paramInt = i;
      if (this.FyD != null) {
        paramInt = i + f.a.a.a.lm(11, this.FyD.computeSize());
      }
      AppMethodBeat.o(91653);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckr localckr = (ckr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91653);
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
            localckr.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckr.Epy = ((ir)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 3: 
          localckr.Fyy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91653);
          return 0;
        case 4: 
          localckr.Fyz = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91653);
          return 0;
        case 5: 
          localckr.FyA = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91653);
          return 0;
        case 6: 
          localckr.FyB = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91653);
          return 0;
        case 7: 
          localckr.EqF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91653);
          return 0;
        case 8: 
          localckr.EqE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91653);
          return 0;
        case 9: 
          localckr.FyC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91653);
          return 0;
        case 10: 
          localckr.timestamp = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91653);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cks();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckr.FyD = ((cks)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      AppMethodBeat.o(91653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckr
 * JD-Core Version:    0.7.0.1
 */