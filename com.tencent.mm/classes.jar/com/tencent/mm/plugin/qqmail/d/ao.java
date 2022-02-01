package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends com.tencent.mm.bw.a
{
  public String Btb;
  public String md5;
  public String name;
  public int size;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198633);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.uin);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.aM(3, this.size);
      if (this.Btb != null) {
        paramVarArgs.e(4, this.Btb);
      }
      if (this.md5 != null) {
        paramVarArgs.e(5, this.md5);
      }
      AppMethodBeat.o(198633);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.uin) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.size);
      paramInt = i;
      if (this.Btb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Btb);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.md5);
      }
      AppMethodBeat.o(198633);
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
      AppMethodBeat.o(198633);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ao localao = (ao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198633);
        return -1;
      case 1: 
        localao.uin = locala.UbS.zl();
        AppMethodBeat.o(198633);
        return 0;
      case 2: 
        localao.name = locala.UbS.readString();
        AppMethodBeat.o(198633);
        return 0;
      case 3: 
        localao.size = locala.UbS.zi();
        AppMethodBeat.o(198633);
        return 0;
      case 4: 
        localao.Btb = locala.UbS.readString();
        AppMethodBeat.o(198633);
        return 0;
      }
      localao.md5 = locala.UbS.readString();
      AppMethodBeat.o(198633);
      return 0;
    }
    AppMethodBeat.o(198633);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ao
 * JD-Core Version:    0.7.0.1
 */