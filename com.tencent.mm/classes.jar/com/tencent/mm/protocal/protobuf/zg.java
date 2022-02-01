package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class zg
  extends com.tencent.mm.bw.a
{
  public int Scene;
  public String Version;
  public String urm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urm == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110847);
        throw paramVarArgs;
      }
      if (this.urm != null) {
        paramVarArgs.d(1, this.urm);
      }
      if (this.Version != null) {
        paramVarArgs.d(2, this.Version);
      }
      paramVarArgs.aS(3, this.Scene);
      AppMethodBeat.o(110847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urm == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.urm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Version != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Version);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Scene);
      AppMethodBeat.o(110847);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.urm == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        zg localzg = (zg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110847);
          return -1;
        case 1: 
          localzg.urm = locala.OmT.readString();
          AppMethodBeat.o(110847);
          return 0;
        case 2: 
          localzg.Version = locala.OmT.readString();
          AppMethodBeat.o(110847);
          return 0;
        }
        localzg.Scene = locala.OmT.zc();
        AppMethodBeat.o(110847);
        return 0;
      }
      AppMethodBeat.o(110847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zg
 * JD-Core Version:    0.7.0.1
 */