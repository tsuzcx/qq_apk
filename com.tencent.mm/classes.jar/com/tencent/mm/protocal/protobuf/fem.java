package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fem
  extends com.tencent.mm.bx.a
{
  public long Id;
  public gol abfg;
  public int muC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125795);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Id);
      paramVarArgs.bS(2, this.muC);
      if (this.abfg != null)
      {
        paramVarArgs.qD(3, this.abfg.computeSize());
        this.abfg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Id) + 0 + i.a.a.b.b.a.cJ(2, this.muC);
      paramInt = i;
      if (this.abfg != null) {
        paramInt = i + i.a.a.a.qC(3, this.abfg.computeSize());
      }
      AppMethodBeat.o(125795);
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
      AppMethodBeat.o(125795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fem localfem = (fem)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125795);
        return -1;
      case 1: 
        localfem.Id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(125795);
        return 0;
      case 2: 
        localfem.muC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125795);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gol localgol = new gol();
        if ((localObject != null) && (localObject.length > 0)) {
          localgol.dg((byte[])localObject);
        }
        localfem.abfg = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(125795);
      return 0;
    }
    AppMethodBeat.o(125795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fem
 * JD-Core Version:    0.7.0.1
 */