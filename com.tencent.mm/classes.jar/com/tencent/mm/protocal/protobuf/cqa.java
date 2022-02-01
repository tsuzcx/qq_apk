package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqa
  extends cpx
{
  public int DKD;
  public int FCY;
  public int FCZ;
  public long FpA;
  public String djj;
  public int ugG;
  public String ugH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91671);
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
      paramVarArgs.aR(3, this.ugG);
      paramVarArgs.aR(4, this.DKD);
      paramVarArgs.aO(5, this.FpA);
      paramVarArgs.aR(6, this.FCY);
      if (this.ugH != null) {
        paramVarArgs.d(7, this.ugH);
      }
      paramVarArgs.aR(8, this.FCZ);
      AppMethodBeat.o(91671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.djj);
      }
      i = i + f.a.a.b.b.a.bx(3, this.ugG) + f.a.a.b.b.a.bx(4, this.DKD) + f.a.a.b.b.a.p(5, this.FpA) + f.a.a.b.b.a.bx(6, this.FCY);
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ugH);
      }
      i = f.a.a.b.b.a.bx(8, this.FCZ);
      AppMethodBeat.o(91671);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqa localcqa = (cqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91671);
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
            localcqa.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91671);
          return 0;
        case 2: 
          localcqa.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91671);
          return 0;
        case 3: 
          localcqa.ugG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91671);
          return 0;
        case 4: 
          localcqa.DKD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91671);
          return 0;
        case 5: 
          localcqa.FpA = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91671);
          return 0;
        case 6: 
          localcqa.FCY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91671);
          return 0;
        case 7: 
          localcqa.ugH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91671);
          return 0;
        }
        localcqa.FCZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91671);
        return 0;
      }
      AppMethodBeat.o(91671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqa
 * JD-Core Version:    0.7.0.1
 */