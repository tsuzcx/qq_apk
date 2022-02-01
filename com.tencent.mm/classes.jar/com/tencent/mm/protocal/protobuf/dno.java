package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dno
  extends cpx
{
  public double FVf;
  public double FVg;
  public double altitude;
  public int bOX;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.e(3, this.longitude);
      paramVarArgs.e(4, this.altitude);
      paramVarArgs.e(5, this.FVf);
      paramVarArgs.e(6, this.FVg);
      paramVarArgs.aR(7, this.bOX);
      AppMethodBeat.o(123668);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label597;
      }
    }
    label597:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.fK(6);
      int i1 = f.a.a.b.b.a.bx(7, this.bOX);
      AppMethodBeat.o(123668);
      return paramInt + (i + 8) + (j + 8) + (k + 8) + (m + 8) + (n + 8) + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123668);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dno localdno = (dno)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123668);
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
            localdno.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123668);
          return 0;
        case 2: 
          localdno.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(123668);
          return 0;
        case 3: 
          localdno.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(123668);
          return 0;
        case 4: 
          localdno.altitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(123668);
          return 0;
        case 5: 
          localdno.FVf = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(123668);
          return 0;
        case 6: 
          localdno.FVg = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(123668);
          return 0;
        }
        localdno.bOX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123668);
        return 0;
      }
      AppMethodBeat.o(123668);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dno
 * JD-Core Version:    0.7.0.1
 */