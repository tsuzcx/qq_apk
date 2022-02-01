package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcj
  extends com.tencent.mm.bw.a
{
  public String KHk;
  public String MHf;
  public float MHj;
  public float MHk;
  public String Title;
  public String URL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209784);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.KHk != null) {
        paramVarArgs.e(2, this.KHk);
      }
      paramVarArgs.E(3, this.MHj);
      paramVarArgs.E(4, this.MHk);
      if (this.URL != null) {
        paramVarArgs.e(5, this.URL);
      }
      if (this.MHf != null) {
        paramVarArgs.e(6, this.MHf);
      }
      AppMethodBeat.o(209784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KHk != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KHk);
      }
      i = i + (g.a.a.b.b.a.fS(3) + 4) + (g.a.a.b.b.a.fS(4) + 4);
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.URL);
      }
      i = paramInt;
      if (this.MHf != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MHf);
      }
      AppMethodBeat.o(209784);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209784);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dcj localdcj = (dcj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209784);
          return -1;
        case 1: 
          localdcj.Title = locala.UbS.readString();
          AppMethodBeat.o(209784);
          return 0;
        case 2: 
          localdcj.KHk = locala.UbS.readString();
          AppMethodBeat.o(209784);
          return 0;
        case 3: 
          localdcj.MHj = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(209784);
          return 0;
        case 4: 
          localdcj.MHk = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(209784);
          return 0;
        case 5: 
          localdcj.URL = locala.UbS.readString();
          AppMethodBeat.o(209784);
          return 0;
        }
        localdcj.MHf = locala.UbS.readString();
        AppMethodBeat.o(209784);
        return 0;
      }
      AppMethodBeat.o(209784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcj
 * JD-Core Version:    0.7.0.1
 */