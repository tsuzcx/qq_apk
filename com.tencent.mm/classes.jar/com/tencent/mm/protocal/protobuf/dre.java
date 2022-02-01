package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dre
  extends com.tencent.mm.bw.a
{
  public String path;
  public int scene;
  public int type;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225297);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(2, this.path);
      }
      paramVarArgs.aM(3, this.version);
      paramVarArgs.aM(4, this.scene);
      paramVarArgs.aM(5, this.type);
      AppMethodBeat.o(225297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.path);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.version);
      int j = g.a.a.b.b.a.bu(4, this.scene);
      int k = g.a.a.b.b.a.bu(5, this.type);
      AppMethodBeat.o(225297);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(225297);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dre localdre = (dre)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(225297);
          return -1;
        case 1: 
          localdre.username = locala.UbS.readString();
          AppMethodBeat.o(225297);
          return 0;
        case 2: 
          localdre.path = locala.UbS.readString();
          AppMethodBeat.o(225297);
          return 0;
        case 3: 
          localdre.version = locala.UbS.zi();
          AppMethodBeat.o(225297);
          return 0;
        case 4: 
          localdre.scene = locala.UbS.zi();
          AppMethodBeat.o(225297);
          return 0;
        }
        localdre.type = locala.UbS.zi();
        AppMethodBeat.o(225297);
        return 0;
      }
      AppMethodBeat.o(225297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dre
 * JD-Core Version:    0.7.0.1
 */