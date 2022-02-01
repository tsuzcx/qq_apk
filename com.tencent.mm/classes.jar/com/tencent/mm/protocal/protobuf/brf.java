package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class brf
  extends com.tencent.mm.bw.a
{
  public dqj Fgu;
  public float dmL;
  public float doB;
  public String gPx;
  public String gPy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gPx == null)
      {
        paramVarArgs = new b("Not all required fields were included: cityName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.gPy == null)
      {
        paramVarArgs = new b("Not all required fields were included: poiName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.Fgu == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.gPx != null) {
        paramVarArgs.d(1, this.gPx);
      }
      if (this.gPy != null) {
        paramVarArgs.d(2, this.gPy);
      }
      if (this.Fgu != null)
      {
        paramVarArgs.ln(4, this.Fgu.computeSize());
        this.Fgu.writeFields(paramVarArgs);
      }
      paramVarArgs.x(5, this.doB);
      paramVarArgs.x(6, this.dmL);
      AppMethodBeat.o(140927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gPx == null) {
        break label672;
      }
    }
    label672:
    for (int i = f.a.a.b.b.a.e(1, this.gPx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gPy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gPy);
      }
      i = paramInt;
      if (this.Fgu != null) {
        i = paramInt + f.a.a.a.lm(4, this.Fgu.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(5);
      int j = f.a.a.b.b.a.fK(6);
      AppMethodBeat.o(140927);
      return i + (paramInt + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.gPx == null)
        {
          paramVarArgs = new b("Not all required fields were included: cityName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.gPy == null)
        {
          paramVarArgs = new b("Not all required fields were included: poiName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.Fgu == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brf localbrf = (brf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(140927);
          return -1;
        case 1: 
          localbrf.gPx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 2: 
          localbrf.gPy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrf.Fgu = ((dqj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140927);
          return 0;
        case 5: 
          localbrf.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(140927);
          return 0;
        }
        localbrf.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
        AppMethodBeat.o(140927);
        return 0;
      }
      AppMethodBeat.o(140927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brf
 * JD-Core Version:    0.7.0.1
 */