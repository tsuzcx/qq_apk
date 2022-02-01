package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agm
  extends cpx
{
  public String DZR;
  public long EyA;
  public String EyB;
  public String EyC;
  public int EyD;
  public float EyE;
  public int EyF;
  public int dbL;
  public String djj;
  public int qwx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104363);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      paramVarArgs.aO(3, this.EyA);
      if (this.DZR != null) {
        paramVarArgs.d(4, this.DZR);
      }
      if (this.EyB != null) {
        paramVarArgs.d(5, this.EyB);
      }
      if (this.EyC != null) {
        paramVarArgs.d(6, this.EyC);
      }
      paramVarArgs.aR(7, this.dbL);
      paramVarArgs.aR(8, this.EyD);
      paramVarArgs.aR(9, this.qwx);
      paramVarArgs.x(10, this.EyE);
      paramVarArgs.aR(11, this.EyF);
      AppMethodBeat.o(104363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label837;
      }
    }
    label837:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.djj);
      }
      i += f.a.a.b.b.a.p(3, this.EyA);
      paramInt = i;
      if (this.DZR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DZR);
      }
      i = paramInt;
      if (this.EyB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EyB);
      }
      paramInt = i;
      if (this.EyC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EyC);
      }
      i = f.a.a.b.b.a.bx(7, this.dbL);
      int j = f.a.a.b.b.a.bx(8, this.EyD);
      int k = f.a.a.b.b.a.bx(9, this.qwx);
      int m = f.a.a.b.b.a.fK(10);
      int n = f.a.a.b.b.a.bx(11, this.EyF);
      AppMethodBeat.o(104363);
      return paramInt + i + j + k + (m + 4) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agm localagm = (agm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104363);
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
            localagm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104363);
          return 0;
        case 2: 
          localagm.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 3: 
          localagm.EyA = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(104363);
          return 0;
        case 4: 
          localagm.DZR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 5: 
          localagm.EyB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 6: 
          localagm.EyC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 7: 
          localagm.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104363);
          return 0;
        case 8: 
          localagm.EyD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104363);
          return 0;
        case 9: 
          localagm.qwx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104363);
          return 0;
        case 10: 
          localagm.EyE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(104363);
          return 0;
        }
        localagm.EyF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104363);
        return 0;
      }
      AppMethodBeat.o(104363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agm
 * JD-Core Version:    0.7.0.1
 */