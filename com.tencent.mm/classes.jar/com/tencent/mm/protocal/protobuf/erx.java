package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erx
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> fmW;
  public int num;
  public String title;
  public String url;
  
  public erx()
  {
    AppMethodBeat.i(186434);
    this.fmW = new LinkedList();
    AppMethodBeat.o(186434);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127284);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.num);
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      paramVarArgs.e(4, 1, this.fmW);
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.num) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.url);
      }
      paramInt = g.a.a.a.c(4, 1, this.fmW);
      AppMethodBeat.o(127284);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.fmW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      erx localerx = (erx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127284);
        return -1;
      case 1: 
        localerx.num = locala.abFh.AK();
        AppMethodBeat.o(127284);
        return 0;
      case 2: 
        localerx.title = locala.abFh.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 3: 
        localerx.url = locala.abFh.readString();
        AppMethodBeat.o(127284);
        return 0;
      }
      localerx.fmW.add(locala.abFh.readString());
      AppMethodBeat.o(127284);
      return 0;
    }
    AppMethodBeat.o(127284);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erx
 * JD-Core Version:    0.7.0.1
 */