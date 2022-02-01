package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends com.tencent.mm.cd.a
{
  public String Hnv;
  public String md5;
  public String name;
  public int size;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250594);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.uin);
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      paramVarArgs.aY(3, this.size);
      if (this.Hnv != null) {
        paramVarArgs.f(4, this.Hnv);
      }
      if (this.md5 != null) {
        paramVarArgs.f(5, this.md5);
      }
      AppMethodBeat.o(250594);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.uin) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.size);
      paramInt = i;
      if (this.Hnv != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Hnv);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.md5);
      }
      AppMethodBeat.o(250594);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(250594);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ao localao = (ao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(250594);
        return -1;
      case 1: 
        localao.uin = locala.abFh.AN();
        AppMethodBeat.o(250594);
        return 0;
      case 2: 
        localao.name = locala.abFh.readString();
        AppMethodBeat.o(250594);
        return 0;
      case 3: 
        localao.size = locala.abFh.AK();
        AppMethodBeat.o(250594);
        return 0;
      case 4: 
        localao.Hnv = locala.abFh.readString();
        AppMethodBeat.o(250594);
        return 0;
      }
      localao.md5 = locala.abFh.readString();
      AppMethodBeat.o(250594);
      return 0;
    }
    AppMethodBeat.o(250594);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ao
 * JD-Core Version:    0.7.0.1
 */