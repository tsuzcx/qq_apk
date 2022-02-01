package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agb
  extends cpx
{
  public int Eyl;
  public int dBz;
  public double latitude;
  public double longitude;
  public int owW;
  public int vGO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.owW);
      paramVarArgs.aR(3, this.vGO);
      paramVarArgs.aR(4, this.dBz);
      paramVarArgs.aR(5, this.Eyl);
      paramVarArgs.e(6, this.latitude);
      paramVarArgs.e(7, this.longitude);
      AppMethodBeat.o(91456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.owW);
      int j = f.a.a.b.b.a.bx(3, this.vGO);
      int k = f.a.a.b.b.a.bx(4, this.dBz);
      int m = f.a.a.b.b.a.bx(5, this.Eyl);
      int n = f.a.a.b.b.a.fK(6);
      int i1 = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(91456);
      return paramInt + i + j + k + m + (n + 8) + (i1 + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91456);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agb localagb = (agb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91456);
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
            localagb.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91456);
          return 0;
        case 2: 
          localagb.owW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91456);
          return 0;
        case 3: 
          localagb.vGO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91456);
          return 0;
        case 4: 
          localagb.dBz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91456);
          return 0;
        case 5: 
          localagb.Eyl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91456);
          return 0;
        case 6: 
          localagb.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(91456);
          return 0;
        }
        localagb.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(91456);
        return 0;
      }
      AppMethodBeat.o(91456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agb
 * JD-Core Version:    0.7.0.1
 */