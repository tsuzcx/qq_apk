package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehv
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> duo;
  public int ibS;
  public String title;
  public String url;
  
  public ehv()
  {
    AppMethodBeat.i(188571);
    this.duo = new LinkedList();
    AppMethodBeat.o(188571);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127284);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.ibS);
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      paramVarArgs.e(4, 1, this.duo);
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.ibS) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.url);
      }
      paramInt = g.a.a.a.c(4, 1, this.duo);
      AppMethodBeat.o(127284);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.duo.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ehv localehv = (ehv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127284);
        return -1;
      case 1: 
        localehv.ibS = locala.UbS.zi();
        AppMethodBeat.o(127284);
        return 0;
      case 2: 
        localehv.title = locala.UbS.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 3: 
        localehv.url = locala.UbS.readString();
        AppMethodBeat.o(127284);
        return 0;
      }
      localehv.duo.add(locala.UbS.readString());
      AppMethodBeat.o(127284);
      return 0;
    }
    AppMethodBeat.o(127284);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehv
 * JD-Core Version:    0.7.0.1
 */