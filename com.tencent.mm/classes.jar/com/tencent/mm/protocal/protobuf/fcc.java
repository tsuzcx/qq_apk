package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fcc
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public int MjZ;
  public int MqC;
  public int MqD;
  public String MqE;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123683);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MjZ);
      paramVarArgs.aM(2, this.KSa);
      paramVarArgs.aM(3, this.Scene);
      if (this.MqE != null) {
        paramVarArgs.e(4, this.MqE);
      }
      paramVarArgs.aM(5, this.MqD);
      paramVarArgs.aM(6, this.MqC);
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MjZ) + 0 + g.a.a.b.b.a.bu(2, this.KSa) + g.a.a.b.b.a.bu(3, this.Scene);
      paramInt = i;
      if (this.MqE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MqE);
      }
      i = g.a.a.b.b.a.bu(5, this.MqD);
      int j = g.a.a.b.b.a.bu(6, this.MqC);
      AppMethodBeat.o(123683);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fcc localfcc = (fcc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123683);
        return -1;
      case 1: 
        localfcc.MjZ = locala.UbS.zi();
        AppMethodBeat.o(123683);
        return 0;
      case 2: 
        localfcc.KSa = locala.UbS.zi();
        AppMethodBeat.o(123683);
        return 0;
      case 3: 
        localfcc.Scene = locala.UbS.zi();
        AppMethodBeat.o(123683);
        return 0;
      case 4: 
        localfcc.MqE = locala.UbS.readString();
        AppMethodBeat.o(123683);
        return 0;
      case 5: 
        localfcc.MqD = locala.UbS.zi();
        AppMethodBeat.o(123683);
        return 0;
      }
      localfcc.MqC = locala.UbS.zi();
      AppMethodBeat.o(123683);
      return 0;
    }
    AppMethodBeat.o(123683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcc
 * JD-Core Version:    0.7.0.1
 */