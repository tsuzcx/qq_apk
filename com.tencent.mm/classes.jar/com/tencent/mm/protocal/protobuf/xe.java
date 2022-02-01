package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class xe
  extends com.tencent.mm.bw.a
{
  public int Scene;
  public String Version;
  public String thZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110847);
        throw paramVarArgs;
      }
      if (this.thZ != null) {
        paramVarArgs.d(1, this.thZ);
      }
      if (this.Version != null) {
        paramVarArgs.d(2, this.Version);
      }
      paramVarArgs.aR(3, this.Scene);
      AppMethodBeat.o(110847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thZ == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.thZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Version != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Version);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Scene);
      AppMethodBeat.o(110847);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.thZ == null)
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
        xe localxe = (xe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110847);
          return -1;
        case 1: 
          localxe.thZ = locala.LVo.readString();
          AppMethodBeat.o(110847);
          return 0;
        case 2: 
          localxe.Version = locala.LVo.readString();
          AppMethodBeat.o(110847);
          return 0;
        }
        localxe.Scene = locala.LVo.xF();
        AppMethodBeat.o(110847);
        return 0;
      }
      AppMethodBeat.o(110847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xe
 * JD-Core Version:    0.7.0.1
 */