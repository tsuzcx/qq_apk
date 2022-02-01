package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bul
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Fkx;
  public String mime;
  
  public bul()
  {
    AppMethodBeat.i(116473);
    this.Fkx = new LinkedList();
    AppMethodBeat.o(116473);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mime != null) {
        paramVarArgs.d(1, this.mime);
      }
      paramVarArgs.e(2, 1, this.Fkx);
      AppMethodBeat.o(116474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mime == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.mime) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.Fkx);
      AppMethodBeat.o(116474);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fkx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116474);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bul localbul = (bul)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116474);
          return -1;
        case 1: 
          localbul.mime = locala.LVo.readString();
          AppMethodBeat.o(116474);
          return 0;
        }
        localbul.Fkx.add(locala.LVo.readString());
        AppMethodBeat.o(116474);
        return 0;
      }
      AppMethodBeat.o(116474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bul
 * JD-Core Version:    0.7.0.1
 */