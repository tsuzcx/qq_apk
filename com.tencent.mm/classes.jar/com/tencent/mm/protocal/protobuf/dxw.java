package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dxw
  extends com.tencent.mm.bw.a
{
  public int DLI;
  public String Ebg;
  public String FDc;
  public boolean Gee;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32565);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.Ebg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      if (this.Ebg != null) {
        paramVarArgs.d(2, this.Ebg);
      }
      paramVarArgs.bl(3, this.Gee);
      paramVarArgs.aR(4, this.DLI);
      AppMethodBeat.o(32565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = f.a.a.b.b.a.e(1, this.FDc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ebg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ebg);
      }
      paramInt = f.a.a.b.b.a.fK(3);
      int j = f.a.a.b.b.a.bx(4, this.DLI);
      AppMethodBeat.o(32565);
      return i + (paramInt + 1) + j;
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
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        if (this.Ebg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32565);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxw localdxw = (dxw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32565);
          return -1;
        case 1: 
          localdxw.FDc = locala.LVo.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 2: 
          localdxw.Ebg = locala.LVo.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 3: 
          localdxw.Gee = locala.LVo.fZX();
          AppMethodBeat.o(32565);
          return 0;
        }
        localdxw.DLI = locala.LVo.xF();
        AppMethodBeat.o(32565);
        return 0;
      }
      AppMethodBeat.o(32565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxw
 * JD-Core Version:    0.7.0.1
 */