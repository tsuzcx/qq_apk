package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dar
  extends com.tencent.mm.cd.a
{
  public int BYk;
  public int KFK;
  public String TIf;
  public String TIg;
  public int TIh;
  public boolean TIi;
  public String jmx;
  public String nickname;
  public String tag;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205520);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.f(1, this.nickname);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.TIf != null) {
        paramVarArgs.f(3, this.TIf);
      }
      paramVarArgs.aY(4, this.KFK);
      if (this.jmx != null) {
        paramVarArgs.f(5, this.jmx);
      }
      if (this.TIg != null) {
        paramVarArgs.f(6, this.TIg);
      }
      paramVarArgs.aY(7, this.TIh);
      paramVarArgs.co(8, this.TIi);
      if (this.tag != null) {
        paramVarArgs.f(9, this.tag);
      }
      paramVarArgs.aY(10, this.BYk);
      AppMethodBeat.o(205520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label698;
      }
    }
    label698:
    for (int i = g.a.a.b.b.a.g(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.TIf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TIf);
      }
      i += g.a.a.b.b.a.bM(4, this.KFK);
      paramInt = i;
      if (this.jmx != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.jmx);
      }
      i = paramInt;
      if (this.TIg != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TIg);
      }
      i = i + g.a.a.b.b.a.bM(7, this.TIh) + (g.a.a.b.b.a.gL(8) + 1);
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.tag);
      }
      i = g.a.a.b.b.a.bM(10, this.BYk);
      AppMethodBeat.o(205520);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205520);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dar localdar = (dar)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205520);
          return -1;
        case 1: 
          localdar.nickname = locala.abFh.readString();
          AppMethodBeat.o(205520);
          return 0;
        case 2: 
          localdar.title = locala.abFh.readString();
          AppMethodBeat.o(205520);
          return 0;
        case 3: 
          localdar.TIf = locala.abFh.readString();
          AppMethodBeat.o(205520);
          return 0;
        case 4: 
          localdar.KFK = locala.abFh.AK();
          AppMethodBeat.o(205520);
          return 0;
        case 5: 
          localdar.jmx = locala.abFh.readString();
          AppMethodBeat.o(205520);
          return 0;
        case 6: 
          localdar.TIg = locala.abFh.readString();
          AppMethodBeat.o(205520);
          return 0;
        case 7: 
          localdar.TIh = locala.abFh.AK();
          AppMethodBeat.o(205520);
          return 0;
        case 8: 
          localdar.TIi = locala.abFh.AB();
          AppMethodBeat.o(205520);
          return 0;
        case 9: 
          localdar.tag = locala.abFh.readString();
          AppMethodBeat.o(205520);
          return 0;
        }
        localdar.BYk = locala.abFh.AK();
        AppMethodBeat.o(205520);
        return 0;
      }
      AppMethodBeat.o(205520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dar
 * JD-Core Version:    0.7.0.1
 */