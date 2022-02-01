package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmi
  extends com.tencent.mm.cd.a
{
  public int EBY;
  public int EBZ;
  public String content;
  public String iconUrl;
  public int jqz = 0;
  public String name;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(278171);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      paramVarArgs.aY(2, this.type);
      if (this.content != null) {
        paramVarArgs.f(3, this.content);
      }
      paramVarArgs.aY(4, this.jqz);
      if (this.iconUrl != null) {
        paramVarArgs.f(5, this.iconUrl);
      }
      paramVarArgs.aY(6, this.EBY);
      paramVarArgs.aY(7, this.EBZ);
      AppMethodBeat.o(278171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.b.b.a.g(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.content);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.jqz);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.iconUrl);
      }
      i = g.a.a.b.b.a.bM(6, this.EBY);
      int j = g.a.a.b.b.a.bM(7, this.EBZ);
      AppMethodBeat.o(278171);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(278171);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bmi localbmi = (bmi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(278171);
          return -1;
        case 1: 
          localbmi.name = locala.abFh.readString();
          AppMethodBeat.o(278171);
          return 0;
        case 2: 
          localbmi.type = locala.abFh.AK();
          AppMethodBeat.o(278171);
          return 0;
        case 3: 
          localbmi.content = locala.abFh.readString();
          AppMethodBeat.o(278171);
          return 0;
        case 4: 
          localbmi.jqz = locala.abFh.AK();
          AppMethodBeat.o(278171);
          return 0;
        case 5: 
          localbmi.iconUrl = locala.abFh.readString();
          AppMethodBeat.o(278171);
          return 0;
        case 6: 
          localbmi.EBY = locala.abFh.AK();
          AppMethodBeat.o(278171);
          return 0;
        }
        localbmi.EBZ = locala.abFh.AK();
        AppMethodBeat.o(278171);
        return 0;
      }
      AppMethodBeat.o(278171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmi
 * JD-Core Version:    0.7.0.1
 */