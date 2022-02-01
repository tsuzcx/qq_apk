package com.tencent.mm.plugin.o.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int JFg;
  public String JFh;
  public String JFi;
  public String JFj;
  public String JFk;
  public String JFl;
  public String JFm;
  public String JFn;
  public String JFo;
  public String JFp;
  public String kab;
  public String title;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(25280);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.JFg);
      if (this.type != null) {
        paramVarArgs.g(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.JFh != null) {
        paramVarArgs.g(4, this.JFh);
      }
      if (this.JFi != null) {
        paramVarArgs.g(5, this.JFi);
      }
      if (this.JFj != null) {
        paramVarArgs.g(6, this.JFj);
      }
      if (this.JFk != null) {
        paramVarArgs.g(7, this.JFk);
      }
      if (this.JFl != null) {
        paramVarArgs.g(8, this.JFl);
      }
      if (this.JFm != null) {
        paramVarArgs.g(9, this.JFm);
      }
      if (this.JFn != null) {
        paramVarArgs.g(10, this.JFn);
      }
      if (this.kab != null) {
        paramVarArgs.g(11, this.kab);
      }
      if (this.JFo != null) {
        paramVarArgs.g(12, this.JFo);
      }
      if (this.JFp != null) {
        paramVarArgs.g(13, this.JFp);
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.JFg) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.JFh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.JFh);
      }
      i = paramInt;
      if (this.JFi != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.JFi);
      }
      paramInt = i;
      if (this.JFj != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.JFj);
      }
      i = paramInt;
      if (this.JFk != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.JFk);
      }
      paramInt = i;
      if (this.JFl != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.JFl);
      }
      i = paramInt;
      if (this.JFm != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.JFm);
      }
      paramInt = i;
      if (this.JFn != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.JFn);
      }
      i = paramInt;
      if (this.kab != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.kab);
      }
      paramInt = i;
      if (this.JFo != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.JFo);
      }
      i = paramInt;
      if (this.JFp != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.JFp);
      }
      AppMethodBeat.o(25280);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(25280);
        return -1;
      case 1: 
        localb.JFg = locala.ajGk.aar();
        AppMethodBeat.o(25280);
        return 0;
      case 2: 
        localb.type = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 3: 
        localb.title = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 4: 
        localb.JFh = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 5: 
        localb.JFi = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 6: 
        localb.JFj = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 7: 
        localb.JFk = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 8: 
        localb.JFl = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 9: 
        localb.JFm = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 10: 
        localb.JFn = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 11: 
        localb.kab = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 12: 
        localb.JFo = locala.ajGk.readString();
        AppMethodBeat.o(25280);
        return 0;
      }
      localb.JFp = locala.ajGk.readString();
      AppMethodBeat.o(25280);
      return 0;
    }
    AppMethodBeat.o(25280);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.o.a.b
 * JD-Core Version:    0.7.0.1
 */