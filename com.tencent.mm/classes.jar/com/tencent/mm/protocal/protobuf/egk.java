package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class egk
  extends com.tencent.mm.bw.a
{
  public String Ikh;
  public LinkedList<String> Iki;
  
  public egk()
  {
    AppMethodBeat.i(199203);
    this.Iki = new LinkedList();
    AppMethodBeat.o(199203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ikh != null) {
        paramVarArgs.d(1, this.Ikh);
      }
      paramVarArgs.e(2, 1, this.Iki);
      AppMethodBeat.o(199204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ikh == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ikh) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.Iki);
      AppMethodBeat.o(199204);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Iki.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(199204);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        egk localegk = (egk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199204);
          return -1;
        case 1: 
          localegk.Ikh = locala.OmT.readString();
          AppMethodBeat.o(199204);
          return 0;
        }
        localegk.Iki.add(locala.OmT.readString());
        AppMethodBeat.o(199204);
        return 0;
      }
      AppMethodBeat.o(199204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egk
 * JD-Core Version:    0.7.0.1
 */