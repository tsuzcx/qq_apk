package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fxq
  extends com.tencent.mm.bx.a
{
  public dbi Zlu;
  public long abVo;
  public double abVp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110916);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abVo);
      paramVarArgs.d(2, this.abVp);
      if (this.Zlu != null)
      {
        paramVarArgs.qD(3, this.Zlu.computeSize());
        this.Zlu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.abVo) + 0 + (i.a.a.b.b.a.ko(2) + 8);
      paramInt = i;
      if (this.Zlu != null) {
        paramInt = i + i.a.a.a.qC(3, this.Zlu.computeSize());
      }
      AppMethodBeat.o(110916);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fxq localfxq = (fxq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110916);
        return -1;
      case 1: 
        localfxq.abVo = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110916);
        return 0;
      case 2: 
        localfxq.abVp = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(110916);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dbi localdbi = new dbi();
        if ((localObject != null) && (localObject.length > 0)) {
          localdbi.parseFrom((byte[])localObject);
        }
        localfxq.Zlu = localdbi;
        paramInt += 1;
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    AppMethodBeat.o(110916);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxq
 * JD-Core Version:    0.7.0.1
 */