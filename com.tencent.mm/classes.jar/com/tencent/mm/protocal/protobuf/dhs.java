package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhs
  extends com.tencent.mm.bw.a
{
  public String tlp;
  public String wTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlp != null) {
        paramVarArgs.d(1, this.tlp);
      }
      if (this.wTM != null) {
        paramVarArgs.d(2, this.wTM);
      }
      AppMethodBeat.o(6437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlp == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.tlp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wTM != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.wTM);
      }
      AppMethodBeat.o(6437);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6437);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dhs localdhs = (dhs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6437);
          return -1;
        case 1: 
          localdhs.tlp = locala.LVo.readString();
          AppMethodBeat.o(6437);
          return 0;
        }
        localdhs.wTM = locala.LVo.readString();
        AppMethodBeat.o(6437);
        return 0;
      }
      AppMethodBeat.o(6437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhs
 * JD-Core Version:    0.7.0.1
 */