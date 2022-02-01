package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cni
  extends com.tencent.mm.bw.a
{
  public String Hzs;
  public String Hzt;
  public String oGf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197200);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hzs != null) {
        paramVarArgs.d(1, this.Hzs);
      }
      if (this.Hzt != null) {
        paramVarArgs.d(2, this.Hzt);
      }
      if (this.oGf != null) {
        paramVarArgs.d(3, this.oGf);
      }
      AppMethodBeat.o(197200);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hzs == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Hzs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hzt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hzt);
      }
      i = paramInt;
      if (this.oGf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oGf);
      }
      AppMethodBeat.o(197200);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197200);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cni localcni = (cni)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(197200);
          return -1;
        case 1: 
          localcni.Hzs = locala.OmT.readString();
          AppMethodBeat.o(197200);
          return 0;
        case 2: 
          localcni.Hzt = locala.OmT.readString();
          AppMethodBeat.o(197200);
          return 0;
        }
        localcni.oGf = locala.OmT.readString();
        AppMethodBeat.o(197200);
        return 0;
      }
      AppMethodBeat.o(197200);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cni
 * JD-Core Version:    0.7.0.1
 */