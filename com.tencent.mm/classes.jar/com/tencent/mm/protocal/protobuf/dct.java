package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dct
  extends com.tencent.mm.bw.a
{
  public int MHZ;
  public String Title;
  public String URL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209797);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.URL != null) {
        paramVarArgs.e(2, this.URL);
      }
      paramVarArgs.aM(3, this.MHZ);
      AppMethodBeat.o(209797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.URL != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.URL);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MHZ);
      AppMethodBeat.o(209797);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209797);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dct localdct = (dct)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209797);
          return -1;
        case 1: 
          localdct.Title = locala.UbS.readString();
          AppMethodBeat.o(209797);
          return 0;
        case 2: 
          localdct.URL = locala.UbS.readString();
          AppMethodBeat.o(209797);
          return 0;
        }
        localdct.MHZ = locala.UbS.zi();
        AppMethodBeat.o(209797);
        return 0;
      }
      AppMethodBeat.o(209797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dct
 * JD-Core Version:    0.7.0.1
 */