package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clh
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public int MjZ;
  public int MqC;
  public int MqD;
  public String MqE;
  public int MqF;
  public int Scene;
  public String dNI;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147770);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.aM(3, this.MjZ);
      paramVarArgs.aM(4, this.KSa);
      paramVarArgs.aM(5, this.Scene);
      paramVarArgs.aM(6, this.MqC);
      paramVarArgs.aM(7, this.MqD);
      if (this.MqE != null) {
        paramVarArgs.e(8, this.MqE);
      }
      paramVarArgs.aM(9, this.MqF);
      AppMethodBeat.o(147770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.b.b.a.f(1, this.dNI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.username);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MjZ) + g.a.a.b.b.a.bu(4, this.KSa) + g.a.a.b.b.a.bu(5, this.Scene) + g.a.a.b.b.a.bu(6, this.MqC) + g.a.a.b.b.a.bu(7, this.MqD);
      paramInt = i;
      if (this.MqE != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MqE);
      }
      i = g.a.a.b.b.a.bu(9, this.MqF);
      AppMethodBeat.o(147770);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147770);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        clh localclh = (clh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147770);
          return -1;
        case 1: 
          localclh.dNI = locala.UbS.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 2: 
          localclh.username = locala.UbS.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 3: 
          localclh.MjZ = locala.UbS.zi();
          AppMethodBeat.o(147770);
          return 0;
        case 4: 
          localclh.KSa = locala.UbS.zi();
          AppMethodBeat.o(147770);
          return 0;
        case 5: 
          localclh.Scene = locala.UbS.zi();
          AppMethodBeat.o(147770);
          return 0;
        case 6: 
          localclh.MqC = locala.UbS.zi();
          AppMethodBeat.o(147770);
          return 0;
        case 7: 
          localclh.MqD = locala.UbS.zi();
          AppMethodBeat.o(147770);
          return 0;
        case 8: 
          localclh.MqE = locala.UbS.readString();
          AppMethodBeat.o(147770);
          return 0;
        }
        localclh.MqF = locala.UbS.zi();
        AppMethodBeat.o(147770);
        return 0;
      }
      AppMethodBeat.o(147770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clh
 * JD-Core Version:    0.7.0.1
 */