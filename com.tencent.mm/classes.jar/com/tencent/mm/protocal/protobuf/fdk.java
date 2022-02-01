package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdk
  extends com.tencent.mm.bw.a
{
  public boolean NyX;
  public int NyY;
  public double NyZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50121);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.NyX);
      paramVarArgs.aM(2, this.NyY);
      paramVarArgs.e(3, this.NyZ);
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.bu(2, this.NyY);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(50121);
      return paramInt + 1 + 0 + i + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdk localfdk = (fdk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50121);
        return -1;
      case 1: 
        localfdk.NyX = locala.UbS.yZ();
        AppMethodBeat.o(50121);
        return 0;
      case 2: 
        localfdk.NyY = locala.UbS.zi();
        AppMethodBeat.o(50121);
        return 0;
      }
      localfdk.NyZ = Double.longBitsToDouble(locala.UbS.zn());
      AppMethodBeat.o(50121);
      return 0;
    }
    AppMethodBeat.o(50121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdk
 * JD-Core Version:    0.7.0.1
 */