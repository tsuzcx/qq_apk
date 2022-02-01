package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctg
  extends com.tencent.mm.bw.a
{
  public String KZR;
  public int Myf;
  public int Myg;
  public String desc;
  public String icon;
  public String title;
  public String yUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91555);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.yUB != null) {
        paramVarArgs.e(3, this.yUB);
      }
      paramVarArgs.aM(4, this.Myf);
      paramVarArgs.aM(5, this.Myg);
      if (this.KZR != null) {
        paramVarArgs.e(6, this.KZR);
      }
      if (this.icon != null) {
        paramVarArgs.e(7, this.icon);
      }
      AppMethodBeat.o(91555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label546;
      }
    }
    label546:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.yUB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.yUB);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Myf) + g.a.a.b.b.a.bu(5, this.Myg);
      paramInt = i;
      if (this.KZR != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KZR);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.icon);
      }
      AppMethodBeat.o(91555);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ctg localctg = (ctg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91555);
          return -1;
        case 1: 
          localctg.title = locala.UbS.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 2: 
          localctg.desc = locala.UbS.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 3: 
          localctg.yUB = locala.UbS.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 4: 
          localctg.Myf = locala.UbS.zi();
          AppMethodBeat.o(91555);
          return 0;
        case 5: 
          localctg.Myg = locala.UbS.zi();
          AppMethodBeat.o(91555);
          return 0;
        case 6: 
          localctg.KZR = locala.UbS.readString();
          AppMethodBeat.o(91555);
          return 0;
        }
        localctg.icon = locala.UbS.readString();
        AppMethodBeat.o(91555);
        return 0;
      }
      AppMethodBeat.o(91555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctg
 * JD-Core Version:    0.7.0.1
 */