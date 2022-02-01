package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awr
  extends com.tencent.mm.bw.a
{
  public String LHr;
  public String LHs;
  public String content;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.LHr != null) {
        paramVarArgs.e(2, this.LHr);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.content != null) {
        paramVarArgs.e(4, this.content);
      }
      if (this.LHs != null) {
        paramVarArgs.e(5, this.LHs);
      }
      AppMethodBeat.o(209542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.LHr != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LHr);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.content);
      }
      i = paramInt;
      if (this.LHs != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LHs);
      }
      AppMethodBeat.o(209542);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209542);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      awr localawr = (awr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209542);
        return -1;
      case 1: 
        localawr.type = locala.UbS.zi();
        AppMethodBeat.o(209542);
        return 0;
      case 2: 
        localawr.LHr = locala.UbS.readString();
        AppMethodBeat.o(209542);
        return 0;
      case 3: 
        localawr.title = locala.UbS.readString();
        AppMethodBeat.o(209542);
        return 0;
      case 4: 
        localawr.content = locala.UbS.readString();
        AppMethodBeat.o(209542);
        return 0;
      }
      localawr.LHs = locala.UbS.readString();
      AppMethodBeat.o(209542);
      return 0;
    }
    AppMethodBeat.o(209542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awr
 * JD-Core Version:    0.7.0.1
 */