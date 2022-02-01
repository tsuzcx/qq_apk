package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cas
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Fpp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43115);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fpp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.type);
      if (this.Fpp != null) {
        paramVarArgs.c(2, this.Fpp);
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.Fpp != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Fpp);
      }
      AppMethodBeat.o(43115);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Fpp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cas localcas = (cas)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43115);
        return -1;
      case 1: 
        localcas.type = locala.LVo.xF();
        AppMethodBeat.o(43115);
        return 0;
      }
      localcas.Fpp = locala.LVo.gfk();
      AppMethodBeat.o(43115);
      return 0;
    }
    AppMethodBeat.o(43115);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cas
 * JD-Core Version:    0.7.0.1
 */