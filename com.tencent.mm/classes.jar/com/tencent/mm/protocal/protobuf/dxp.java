package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dxp
  extends com.tencent.mm.bw.a
{
  public String Ebg;
  public String FDc;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32558);
        throw paramVarArgs;
      }
      if (this.Ebg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32558);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      if (this.Ebg != null) {
        paramVarArgs.d(2, this.Ebg);
      }
      paramVarArgs.aR(3, this.Scene);
      AppMethodBeat.o(32558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.FDc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ebg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ebg);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Scene);
      AppMethodBeat.o(32558);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FDc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32558);
          throw paramVarArgs;
        }
        if (this.Ebg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32558);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxp localdxp = (dxp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32558);
          return -1;
        case 1: 
          localdxp.FDc = locala.LVo.readString();
          AppMethodBeat.o(32558);
          return 0;
        case 2: 
          localdxp.Ebg = locala.LVo.readString();
          AppMethodBeat.o(32558);
          return 0;
        }
        localdxp.Scene = locala.LVo.xF();
        AppMethodBeat.o(32558);
        return 0;
      }
      AppMethodBeat.o(32558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxp
 * JD-Core Version:    0.7.0.1
 */