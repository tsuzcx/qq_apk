package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehn
  extends com.tencent.mm.cd.a
{
  public int Height;
  public String MD5;
  public String UeM;
  public String UjI;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32452);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.f(1, this.MD5);
      }
      paramVarArgs.aY(2, this.Width);
      paramVarArgs.aY(3, this.Height);
      if (this.UeM != null) {
        paramVarArgs.f(4, this.UeM);
      }
      if (this.UjI != null) {
        paramVarArgs.f(5, this.UjI);
      }
      AppMethodBeat.o(32452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label433;
      }
    }
    label433:
    for (paramInt = g.a.a.b.b.a.g(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Width) + g.a.a.b.b.a.bM(3, this.Height);
      paramInt = i;
      if (this.UeM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UeM);
      }
      i = paramInt;
      if (this.UjI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UjI);
      }
      AppMethodBeat.o(32452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32452);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ehn localehn = (ehn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32452);
          return -1;
        case 1: 
          localehn.MD5 = locala.abFh.readString();
          AppMethodBeat.o(32452);
          return 0;
        case 2: 
          localehn.Width = locala.abFh.AK();
          AppMethodBeat.o(32452);
          return 0;
        case 3: 
          localehn.Height = locala.abFh.AK();
          AppMethodBeat.o(32452);
          return 0;
        case 4: 
          localehn.UeM = locala.abFh.readString();
          AppMethodBeat.o(32452);
          return 0;
        }
        localehn.UjI = locala.abFh.readString();
        AppMethodBeat.o(32452);
        return 0;
      }
      AppMethodBeat.o(32452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehn
 * JD-Core Version:    0.7.0.1
 */