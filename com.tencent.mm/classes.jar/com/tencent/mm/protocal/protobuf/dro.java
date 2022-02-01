package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dro
  extends com.tencent.mm.bw.a
{
  public String AAN;
  public String Desc;
  public int Height;
  public String MUg;
  public String MUh;
  public int MUi;
  public String ThumbUrl;
  public String Title;
  public int Width;
  public int iAb;
  public String pLq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187878);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      if (this.AAN != null) {
        paramVarArgs.e(4, this.AAN);
      }
      paramVarArgs.aM(5, this.iAb);
      if (this.MUg != null) {
        paramVarArgs.e(6, this.MUg);
      }
      if (this.MUh != null) {
        paramVarArgs.e(7, this.MUh);
      }
      if (this.pLq != null) {
        paramVarArgs.e(8, this.pLq);
      }
      paramVarArgs.aM(9, this.MUi);
      paramVarArgs.aM(10, this.Width);
      paramVarArgs.aM(11, this.Height);
      AppMethodBeat.o(187878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label766;
      }
    }
    label766:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.AAN != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.AAN);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.iAb);
      paramInt = i;
      if (this.MUg != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MUg);
      }
      i = paramInt;
      if (this.MUh != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MUh);
      }
      paramInt = i;
      if (this.pLq != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.pLq);
      }
      i = g.a.a.b.b.a.bu(9, this.MUi);
      int j = g.a.a.b.b.a.bu(10, this.Width);
      int k = g.a.a.b.b.a.bu(11, this.Height);
      AppMethodBeat.o(187878);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187878);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dro localdro = (dro)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187878);
          return -1;
        case 1: 
          localdro.Title = locala.UbS.readString();
          AppMethodBeat.o(187878);
          return 0;
        case 2: 
          localdro.Desc = locala.UbS.readString();
          AppMethodBeat.o(187878);
          return 0;
        case 3: 
          localdro.ThumbUrl = locala.UbS.readString();
          AppMethodBeat.o(187878);
          return 0;
        case 4: 
          localdro.AAN = locala.UbS.readString();
          AppMethodBeat.o(187878);
          return 0;
        case 5: 
          localdro.iAb = locala.UbS.zi();
          AppMethodBeat.o(187878);
          return 0;
        case 6: 
          localdro.MUg = locala.UbS.readString();
          AppMethodBeat.o(187878);
          return 0;
        case 7: 
          localdro.MUh = locala.UbS.readString();
          AppMethodBeat.o(187878);
          return 0;
        case 8: 
          localdro.pLq = locala.UbS.readString();
          AppMethodBeat.o(187878);
          return 0;
        case 9: 
          localdro.MUi = locala.UbS.zi();
          AppMethodBeat.o(187878);
          return 0;
        case 10: 
          localdro.Width = locala.UbS.zi();
          AppMethodBeat.o(187878);
          return 0;
        }
        localdro.Height = locala.UbS.zi();
        AppMethodBeat.o(187878);
        return 0;
      }
      AppMethodBeat.o(187878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dro
 * JD-Core Version:    0.7.0.1
 */