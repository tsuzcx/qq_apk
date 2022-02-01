package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bef
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> SPA;
  public String SPy;
  public long SPz;
  
  public bef()
  {
    AppMethodBeat.i(199568);
    this.SPA = new LinkedList();
    AppMethodBeat.o(199568);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199580);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SPy != null) {
        paramVarArgs.f(1, this.SPy);
      }
      paramVarArgs.bm(2, this.SPz);
      paramVarArgs.e(3, 1, this.SPA);
      AppMethodBeat.o(199580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SPy == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.SPy) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.SPz);
      int j = g.a.a.a.c(3, 1, this.SPA);
      AppMethodBeat.o(199580);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SPA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199580);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bef localbef = (bef)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199580);
          return -1;
        case 1: 
          localbef.SPy = locala.abFh.readString();
          AppMethodBeat.o(199580);
          return 0;
        case 2: 
          localbef.SPz = locala.abFh.AN();
          AppMethodBeat.o(199580);
          return 0;
        }
        localbef.SPA.add(locala.abFh.readString());
        AppMethodBeat.o(199580);
        return 0;
      }
      AppMethodBeat.o(199580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bef
 * JD-Core Version:    0.7.0.1
 */