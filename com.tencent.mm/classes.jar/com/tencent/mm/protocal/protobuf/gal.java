package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gal
  extends com.tencent.mm.bx.a
{
  public int OzG;
  public gol YLa;
  public int Zmc;
  public int yth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115873);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Zmc);
      paramVarArgs.bS(2, this.yth);
      paramVarArgs.bS(3, this.OzG);
      if (this.YLa != null)
      {
        paramVarArgs.qD(4, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Zmc) + 0 + i.a.a.b.b.a.cJ(2, this.yth) + i.a.a.b.b.a.cJ(3, this.OzG);
      paramInt = i;
      if (this.YLa != null) {
        paramInt = i + i.a.a.a.qC(4, this.YLa.computeSize());
      }
      AppMethodBeat.o(115873);
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
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gal localgal = (gal)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115873);
        return -1;
      case 1: 
        localgal.Zmc = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115873);
        return 0;
      case 2: 
        localgal.yth = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115873);
        return 0;
      case 3: 
        localgal.OzG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115873);
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
        localgal.YLa = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    AppMethodBeat.o(115873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gal
 * JD-Core Version:    0.7.0.1
 */