package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpu
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> DOg;
  public String mime;
  
  public bpu()
  {
    AppMethodBeat.i(116473);
    this.DOg = new LinkedList();
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
      paramVarArgs.e(2, 1, this.DOg);
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
      int i = f.a.a.a.c(2, 1, this.DOg);
      AppMethodBeat.o(116474);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DOg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116474);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpu localbpu = (bpu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116474);
          return -1;
        case 1: 
          localbpu.mime = locala.KhF.readString();
          AppMethodBeat.o(116474);
          return 0;
        }
        localbpu.DOg.add(locala.KhF.readString());
        AppMethodBeat.o(116474);
        return 0;
      }
      AppMethodBeat.o(116474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpu
 * JD-Core Version:    0.7.0.1
 */