package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ach
  extends com.tencent.mm.bx.a
{
  public int GbQ;
  public String GbR;
  public String GbS;
  public boolean enable;
  public String kwk;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209261);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.enable);
      paramVarArgs.aS(2, this.GbQ);
      if (this.kwk != null) {
        paramVarArgs.d(3, this.kwk);
      }
      if (this.GbR != null) {
        paramVarArgs.d(4, this.GbR);
      }
      if (this.GbS != null) {
        paramVarArgs.d(5, this.GbS);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      AppMethodBeat.o(209261);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0 + f.a.a.b.b.a.bz(2, this.GbQ);
      paramInt = i;
      if (this.kwk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.kwk);
      }
      i = paramInt;
      if (this.GbR != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GbR);
      }
      paramInt = i;
      if (this.GbS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GbS);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      AppMethodBeat.o(209261);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209261);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ach localach = (ach)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209261);
        return -1;
      case 1: 
        localach.enable = locala.NPN.grw();
        AppMethodBeat.o(209261);
        return 0;
      case 2: 
        localach.GbQ = locala.NPN.zc();
        AppMethodBeat.o(209261);
        return 0;
      case 3: 
        localach.kwk = locala.NPN.readString();
        AppMethodBeat.o(209261);
        return 0;
      case 4: 
        localach.GbR = locala.NPN.readString();
        AppMethodBeat.o(209261);
        return 0;
      case 5: 
        localach.GbS = locala.NPN.readString();
        AppMethodBeat.o(209261);
        return 0;
      }
      localach.title = locala.NPN.readString();
      AppMethodBeat.o(209261);
      return 0;
    }
    AppMethodBeat.o(209261);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ach
 * JD-Core Version:    0.7.0.1
 */