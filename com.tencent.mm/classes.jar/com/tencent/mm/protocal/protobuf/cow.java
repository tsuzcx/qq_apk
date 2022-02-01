package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cow
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Mva;
  public String mime;
  
  public cow()
  {
    AppMethodBeat.i(116473);
    this.Mva = new LinkedList();
    AppMethodBeat.o(116473);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116474);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mime != null) {
        paramVarArgs.e(1, this.mime);
      }
      paramVarArgs.e(2, 1, this.Mva);
      AppMethodBeat.o(116474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mime == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.mime) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.Mva);
      AppMethodBeat.o(116474);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mva.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116474);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cow localcow = (cow)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116474);
          return -1;
        case 1: 
          localcow.mime = locala.UbS.readString();
          AppMethodBeat.o(116474);
          return 0;
        }
        localcow.Mva.add(locala.UbS.readString());
        AppMethodBeat.o(116474);
        return 0;
      }
      AppMethodBeat.o(116474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cow
 * JD-Core Version:    0.7.0.1
 */