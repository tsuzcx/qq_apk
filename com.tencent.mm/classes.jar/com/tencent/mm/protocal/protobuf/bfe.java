package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfe
  extends com.tencent.mm.bw.a
{
  public String content;
  public int gGn = 0;
  public String iconUrl;
  public String name;
  public int type;
  public int yXT;
  public int yXU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214298);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      paramVarArgs.aM(2, this.type);
      if (this.content != null) {
        paramVarArgs.e(3, this.content);
      }
      paramVarArgs.aM(4, this.gGn);
      if (this.iconUrl != null) {
        paramVarArgs.e(5, this.iconUrl);
      }
      paramVarArgs.aM(6, this.yXT);
      paramVarArgs.aM(7, this.yXU);
      AppMethodBeat.o(214298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.b.b.a.f(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.content);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.gGn);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.iconUrl);
      }
      i = g.a.a.b.b.a.bu(6, this.yXT);
      int j = g.a.a.b.b.a.bu(7, this.yXU);
      AppMethodBeat.o(214298);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214298);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfe localbfe = (bfe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(214298);
          return -1;
        case 1: 
          localbfe.name = locala.UbS.readString();
          AppMethodBeat.o(214298);
          return 0;
        case 2: 
          localbfe.type = locala.UbS.zi();
          AppMethodBeat.o(214298);
          return 0;
        case 3: 
          localbfe.content = locala.UbS.readString();
          AppMethodBeat.o(214298);
          return 0;
        case 4: 
          localbfe.gGn = locala.UbS.zi();
          AppMethodBeat.o(214298);
          return 0;
        case 5: 
          localbfe.iconUrl = locala.UbS.readString();
          AppMethodBeat.o(214298);
          return 0;
        case 6: 
          localbfe.yXT = locala.UbS.zi();
          AppMethodBeat.o(214298);
          return 0;
        }
        localbfe.yXU = locala.UbS.zi();
        AppMethodBeat.o(214298);
        return 0;
      }
      AppMethodBeat.o(214298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfe
 * JD-Core Version:    0.7.0.1
 */