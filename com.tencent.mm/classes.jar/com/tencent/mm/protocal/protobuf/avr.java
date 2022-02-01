package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avr
  extends com.tencent.mm.bw.a
{
  public String LGp;
  public String dQx;
  public String jumpUrl;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209511);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.jumpUrl != null) {
        paramVarArgs.e(4, this.jumpUrl);
      }
      if (this.LGp != null) {
        paramVarArgs.e(5, this.LGp);
      }
      AppMethodBeat.o(209511);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      paramInt = i;
      if (this.jumpUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.jumpUrl);
      }
      i = paramInt;
      if (this.LGp != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LGp);
      }
      AppMethodBeat.o(209511);
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
      AppMethodBeat.o(209511);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      avr localavr = (avr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209511);
        return -1;
      case 1: 
        localavr.type = locala.UbS.zi();
        AppMethodBeat.o(209511);
        return 0;
      case 2: 
        localavr.dQx = locala.UbS.readString();
        AppMethodBeat.o(209511);
        return 0;
      case 3: 
        localavr.title = locala.UbS.readString();
        AppMethodBeat.o(209511);
        return 0;
      case 4: 
        localavr.jumpUrl = locala.UbS.readString();
        AppMethodBeat.o(209511);
        return 0;
      }
      localavr.LGp = locala.UbS.readString();
      AppMethodBeat.o(209511);
      return 0;
    }
    AppMethodBeat.o(209511);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avr
 * JD-Core Version:    0.7.0.1
 */