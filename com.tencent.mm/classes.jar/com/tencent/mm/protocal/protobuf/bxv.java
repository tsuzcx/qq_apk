package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bxv
  extends cpx
{
  public b EQz;
  public b FmA;
  public int FmB;
  public String FmC;
  public String FmD;
  public String FmE;
  public int Fmy;
  public int Fmz;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Fmy);
      paramVarArgs.aR(3, this.Fmz);
      if (this.FmA != null) {
        paramVarArgs.c(4, this.FmA);
      }
      paramVarArgs.aR(5, this.FmB);
      if (this.EQz != null) {
        paramVarArgs.c(6, this.EQz);
      }
      if (this.FmC != null) {
        paramVarArgs.d(7, this.FmC);
      }
      if (this.FmD != null) {
        paramVarArgs.d(8, this.FmD);
      }
      if (this.FmE != null) {
        paramVarArgs.d(9, this.FmE);
      }
      paramVarArgs.aR(10, this.Scene);
      AppMethodBeat.o(120957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fmy) + f.a.a.b.b.a.bx(3, this.Fmz);
      paramInt = i;
      if (this.FmA != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FmA);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FmB);
      paramInt = i;
      if (this.EQz != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.EQz);
      }
      i = paramInt;
      if (this.FmC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FmC);
      }
      paramInt = i;
      if (this.FmD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FmD);
      }
      i = paramInt;
      if (this.FmE != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FmE);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.Scene);
      AppMethodBeat.o(120957);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(120957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxv localbxv = (bxv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120957);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120957);
          return 0;
        case 2: 
          localbxv.Fmy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(120957);
          return 0;
        case 3: 
          localbxv.Fmz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(120957);
          return 0;
        case 4: 
          localbxv.FmA = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(120957);
          return 0;
        case 5: 
          localbxv.FmB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(120957);
          return 0;
        case 6: 
          localbxv.EQz = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(120957);
          return 0;
        case 7: 
          localbxv.FmC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 8: 
          localbxv.FmD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 9: 
          localbxv.FmE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(120957);
          return 0;
        }
        localbxv.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(120957);
        return 0;
      }
      AppMethodBeat.o(120957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxv
 * JD-Core Version:    0.7.0.1
 */