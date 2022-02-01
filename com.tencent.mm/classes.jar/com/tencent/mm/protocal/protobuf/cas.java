package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cas
  extends com.tencent.mm.bx.a
{
  public int NkL;
  public int aajJ;
  public gol aajK;
  public int aajL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43096);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aajJ);
      paramVarArgs.bS(2, this.NkL);
      if (this.aajK != null)
      {
        paramVarArgs.qD(3, this.aajK.computeSize());
        this.aajK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.aajL);
      AppMethodBeat.o(43096);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aajJ) + 0 + i.a.a.b.b.a.cJ(2, this.NkL);
      paramInt = i;
      if (this.aajK != null) {
        paramInt = i + i.a.a.a.qC(3, this.aajK.computeSize());
      }
      i = i.a.a.b.b.a.cJ(4, this.aajL);
      AppMethodBeat.o(43096);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(43096);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cas localcas = (cas)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43096);
        return -1;
      case 1: 
        localcas.aajJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43096);
        return 0;
      case 2: 
        localcas.NkL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43096);
        return 0;
      case 3: 
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
          localcas.aajK = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(43096);
        return 0;
      }
      localcas.aajL = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(43096);
      return 0;
    }
    AppMethodBeat.o(43096);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cas
 * JD-Core Version:    0.7.0.1
 */