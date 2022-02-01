package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class def
  extends com.tencent.mm.bw.a
{
  public String MJn;
  public int MJo;
  public String appId;
  public int packageType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153295);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.e(1, this.appId);
      }
      if (this.MJn != null) {
        paramVarArgs.e(2, this.MJn);
      }
      paramVarArgs.aM(3, this.packageType);
      paramVarArgs.aM(4, this.MJo);
      AppMethodBeat.o(153295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MJn != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MJn);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.packageType);
      int j = g.a.a.b.b.a.bu(4, this.MJo);
      AppMethodBeat.o(153295);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153295);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        def localdef = (def)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153295);
          return -1;
        case 1: 
          localdef.appId = locala.UbS.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 2: 
          localdef.MJn = locala.UbS.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 3: 
          localdef.packageType = locala.UbS.zi();
          AppMethodBeat.o(153295);
          return 0;
        }
        localdef.MJo = locala.UbS.zi();
        AppMethodBeat.o(153295);
        return 0;
      }
      AppMethodBeat.o(153295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.def
 * JD-Core Version:    0.7.0.1
 */