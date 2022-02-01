package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class w
  extends com.tencent.mm.cd.a
{
  public b GdC;
  public String HDx;
  public String brand;
  public int fYP;
  public int id;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(27828);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.id);
      paramVarArgs.aY(2, this.status);
      if (this.HDx != null) {
        paramVarArgs.f(3, this.HDx);
      }
      if (this.brand != null) {
        paramVarArgs.f(4, this.brand);
      }
      if (this.GdC != null) {
        paramVarArgs.c(5, this.GdC);
      }
      paramVarArgs.aY(6, this.fYP);
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.id) + 0 + g.a.a.b.b.a.bM(2, this.status);
      paramInt = i;
      if (this.HDx != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.HDx);
      }
      i = paramInt;
      if (this.brand != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.brand);
      }
      paramInt = i;
      if (this.GdC != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.GdC);
      }
      i = g.a.a.b.b.a.bM(6, this.fYP);
      AppMethodBeat.o(27828);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(27828);
        return -1;
      case 1: 
        localw.id = locala.abFh.AK();
        AppMethodBeat.o(27828);
        return 0;
      case 2: 
        localw.status = locala.abFh.AK();
        AppMethodBeat.o(27828);
        return 0;
      case 3: 
        localw.HDx = locala.abFh.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 4: 
        localw.brand = locala.abFh.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 5: 
        localw.GdC = locala.abFh.iUw();
        AppMethodBeat.o(27828);
        return 0;
      }
      localw.fYP = locala.abFh.AK();
      AppMethodBeat.o(27828);
      return 0;
    }
    AppMethodBeat.o(27828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.w
 * JD-Core Version:    0.7.0.1
 */