package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ece
  extends com.tencent.mm.bw.a
{
  public String Nco;
  public boolean Ncp;
  public boolean Ncq;
  public String appName;
  public int cmD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116816);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nco != null) {
        paramVarArgs.e(1, this.Nco);
      }
      if (this.appName != null) {
        paramVarArgs.e(2, this.appName);
      }
      paramVarArgs.aM(3, this.cmD);
      paramVarArgs.cc(4, this.Ncp);
      paramVarArgs.cc(5, this.Ncq);
      AppMethodBeat.o(116816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nco == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = g.a.a.b.b.a.f(1, this.Nco) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.appName);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.cmD);
      int j = g.a.a.b.b.a.fS(4);
      int k = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(116816);
      return i + paramInt + (j + 1) + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116816);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ece localece = (ece)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116816);
          return -1;
        case 1: 
          localece.Nco = locala.UbS.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 2: 
          localece.appName = locala.UbS.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 3: 
          localece.cmD = locala.UbS.zi();
          AppMethodBeat.o(116816);
          return 0;
        case 4: 
          localece.Ncp = locala.UbS.yZ();
          AppMethodBeat.o(116816);
          return 0;
        }
        localece.Ncq = locala.UbS.yZ();
        AppMethodBeat.o(116816);
        return 0;
      }
      AppMethodBeat.o(116816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ece
 * JD-Core Version:    0.7.0.1
 */