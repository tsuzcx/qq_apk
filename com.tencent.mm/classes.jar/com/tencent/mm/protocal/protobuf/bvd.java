package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvd
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Flc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32349);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Flc != null) {
        paramVarArgs.d(1, this.Flc);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      AppMethodBeat.o(32349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Flc == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.Flc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      AppMethodBeat.o(32349);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32349);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvd localbvd = (bvd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32349);
          return -1;
        case 1: 
          localbvd.Flc = locala.LVo.readString();
          AppMethodBeat.o(32349);
          return 0;
        }
        localbvd.Desc = locala.LVo.readString();
        AppMethodBeat.o(32349);
        return 0;
      }
      AppMethodBeat.o(32349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvd
 * JD-Core Version:    0.7.0.1
 */