package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gb
  extends com.tencent.mm.bw.a
{
  public long KJQ;
  public int KJR;
  public int KJS;
  public int Scene;
  public String SessionId;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6390);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      paramVarArgs.bb(2, this.KJQ);
      paramVarArgs.aM(3, this.KJR);
      if (this.SessionId != null) {
        paramVarArgs.e(4, this.SessionId);
      }
      paramVarArgs.aM(5, this.Scene);
      paramVarArgs.aM(6, this.KJS);
      AppMethodBeat.o(6390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KJQ) + g.a.a.b.b.a.bu(3, this.KJR);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.SessionId);
      }
      i = g.a.a.b.b.a.bu(5, this.Scene);
      int j = g.a.a.b.b.a.bu(6, this.KJS);
      AppMethodBeat.o(6390);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(6390);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        gb localgb = (gb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6390);
          return -1;
        case 1: 
          localgb.Url = locala.UbS.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 2: 
          localgb.KJQ = locala.UbS.zl();
          AppMethodBeat.o(6390);
          return 0;
        case 3: 
          localgb.KJR = locala.UbS.zi();
          AppMethodBeat.o(6390);
          return 0;
        case 4: 
          localgb.SessionId = locala.UbS.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 5: 
          localgb.Scene = locala.UbS.zi();
          AppMethodBeat.o(6390);
          return 0;
        }
        localgb.KJS = locala.UbS.zi();
        AppMethodBeat.o(6390);
        return 0;
      }
      AppMethodBeat.o(6390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gb
 * JD-Core Version:    0.7.0.1
 */