package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class avi
  extends com.tencent.mm.bw.a
{
  public int ENx;
  public int ENy;
  public int ENz;
  public int EqT;
  public int EqU;
  public int EqV;
  public b EqX;
  public bjp EqY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143973);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EqT);
      paramVarArgs.aR(2, this.EqU);
      paramVarArgs.aR(3, this.EqV);
      if (this.EqX != null) {
        paramVarArgs.c(4, this.EqX);
      }
      paramVarArgs.aR(5, this.ENx);
      paramVarArgs.aR(6, this.ENy);
      paramVarArgs.aR(7, this.ENz);
      if (this.EqY != null)
      {
        paramVarArgs.ln(8, this.EqY.computeSize());
        this.EqY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EqT) + 0 + f.a.a.b.b.a.bx(2, this.EqU) + f.a.a.b.b.a.bx(3, this.EqV);
      paramInt = i;
      if (this.EqX != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EqX);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.ENx) + f.a.a.b.b.a.bx(6, this.ENy) + f.a.a.b.b.a.bx(7, this.ENz);
      paramInt = i;
      if (this.EqY != null) {
        paramInt = i + f.a.a.a.lm(8, this.EqY.computeSize());
      }
      AppMethodBeat.o(143973);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      avi localavi = (avi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143973);
        return -1;
      case 1: 
        localavi.EqT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143973);
        return 0;
      case 2: 
        localavi.EqU = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143973);
        return 0;
      case 3: 
        localavi.EqV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143973);
        return 0;
      case 4: 
        localavi.EqX = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(143973);
        return 0;
      case 5: 
        localavi.ENx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143973);
        return 0;
      case 6: 
        localavi.ENy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143973);
        return 0;
      case 7: 
        localavi.ENz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143973);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bjp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localavi.EqY = ((bjp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    AppMethodBeat.o(143973);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avi
 * JD-Core Version:    0.7.0.1
 */