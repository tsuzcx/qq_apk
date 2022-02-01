package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bad
  extends cpx
{
  public int Eke;
  public double latitude;
  public double longitude;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114032);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.offset);
      paramVarArgs.aR(3, this.Eke);
      paramVarArgs.e(4, this.latitude);
      paramVarArgs.e(5, this.longitude);
      AppMethodBeat.o(114032);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.offset);
      int j = f.a.a.b.b.a.bx(3, this.Eke);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(114032);
      return paramInt + i + j + (k + 8) + (m + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114032);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bad localbad = (bad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114032);
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
            localbad.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114032);
          return 0;
        case 2: 
          localbad.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114032);
          return 0;
        case 3: 
          localbad.Eke = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114032);
          return 0;
        case 4: 
          localbad.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(114032);
          return 0;
        }
        localbad.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(114032);
        return 0;
      }
      AppMethodBeat.o(114032);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bad
 * JD-Core Version:    0.7.0.1
 */