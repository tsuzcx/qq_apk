package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.cd.a
{
  public String Owf;
  public int id;
  public String lpQ;
  public String name;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91302);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.id);
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      if (this.Owf != null) {
        paramVarArgs.f(4, this.Owf);
      }
      if (this.lpQ != null) {
        paramVarArgs.f(5, this.lpQ);
      }
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.url);
      }
      paramInt = i;
      if (this.Owf != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Owf);
      }
      i = paramInt;
      if (this.lpQ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.lpQ);
      }
      AppMethodBeat.o(91302);
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
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91302);
        return -1;
      case 1: 
        localp.id = locala.abFh.AK();
        AppMethodBeat.o(91302);
        return 0;
      case 2: 
        localp.name = locala.abFh.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 3: 
        localp.url = locala.abFh.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 4: 
        localp.Owf = locala.abFh.readString();
        AppMethodBeat.o(91302);
        return 0;
      }
      localp.lpQ = locala.abFh.readString();
      AppMethodBeat.o(91302);
      return 0;
    }
    AppMethodBeat.o(91302);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.p
 * JD-Core Version:    0.7.0.1
 */