package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brq
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> LYT;
  public String app_id;
  public String language;
  
  public brq()
  {
    AppMethodBeat.i(152582);
    this.LYT = new LinkedList();
    AppMethodBeat.o(152582);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152583);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.language != null) {
        paramVarArgs.e(1, this.language);
      }
      if (this.app_id != null) {
        paramVarArgs.e(2, this.app_id);
      }
      paramVarArgs.e(3, 1, this.LYT);
      AppMethodBeat.o(152583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.language == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = g.a.a.b.b.a.f(1, this.language) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.app_id);
      }
      paramInt = g.a.a.a.c(3, 1, this.LYT);
      AppMethodBeat.o(152583);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LYT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152583);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        brq localbrq = (brq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152583);
          return -1;
        case 1: 
          localbrq.language = locala.UbS.readString();
          AppMethodBeat.o(152583);
          return 0;
        case 2: 
          localbrq.app_id = locala.UbS.readString();
          AppMethodBeat.o(152583);
          return 0;
        }
        localbrq.LYT.add(locala.UbS.readString());
        AppMethodBeat.o(152583);
        return 0;
      }
      AppMethodBeat.o(152583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brq
 * JD-Core Version:    0.7.0.1
 */