package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alz
  extends com.tencent.mm.bx.a
{
  public String GlG;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209275);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GlG != null) {
        paramVarArgs.d(1, this.GlG);
      }
      if (this.session_id != null) {
        paramVarArgs.d(2, this.session_id);
      }
      AppMethodBeat.o(209275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GlG == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.GlG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.session_id);
      }
      AppMethodBeat.o(209275);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209275);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alz localalz = (alz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209275);
          return -1;
        case 1: 
          localalz.GlG = locala.NPN.readString();
          AppMethodBeat.o(209275);
          return 0;
        }
        localalz.session_id = locala.NPN.readString();
        AppMethodBeat.o(209275);
        return 0;
      }
      AppMethodBeat.o(209275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alz
 * JD-Core Version:    0.7.0.1
 */