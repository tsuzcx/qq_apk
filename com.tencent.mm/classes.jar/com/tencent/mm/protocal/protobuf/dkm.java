package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dkm
  extends com.tencent.mm.bw.a
{
  public String FTA;
  public b FTB;
  public b FTz;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FTz != null) {
        paramVarArgs.c(1, this.FTz);
      }
      if (this.FTA != null) {
        paramVarArgs.d(2, this.FTA);
      }
      if (this.FTB != null) {
        paramVarArgs.c(3, this.FTB);
      }
      paramVarArgs.aR(4, this.uin);
      AppMethodBeat.o(82480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FTz == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.b(1, this.FTz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FTA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FTA);
      }
      i = paramInt;
      if (this.FTB != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.FTB);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.uin);
      AppMethodBeat.o(82480);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82480);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dkm localdkm = (dkm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82480);
          return -1;
        case 1: 
          localdkm.FTz = locala.LVo.gfk();
          AppMethodBeat.o(82480);
          return 0;
        case 2: 
          localdkm.FTA = locala.LVo.readString();
          AppMethodBeat.o(82480);
          return 0;
        case 3: 
          localdkm.FTB = locala.LVo.gfk();
          AppMethodBeat.o(82480);
          return 0;
        }
        localdkm.uin = locala.LVo.xF();
        AppMethodBeat.o(82480);
        return 0;
      }
      AppMethodBeat.o(82480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkm
 * JD-Core Version:    0.7.0.1
 */