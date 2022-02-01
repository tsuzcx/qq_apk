package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dwi
  extends com.tencent.mm.bw.a
{
  public String ncR;
  public int ndI;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.ndW == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      paramVarArgs.aR(3, this.ndI);
      AppMethodBeat.o(32517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ndW);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.ndI);
      AppMethodBeat.o(32517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ncR == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        if (this.ndW == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32517);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwi localdwi = (dwi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32517);
          return -1;
        case 1: 
          localdwi.ncR = locala.LVo.readString();
          AppMethodBeat.o(32517);
          return 0;
        case 2: 
          localdwi.ndW = locala.LVo.readString();
          AppMethodBeat.o(32517);
          return 0;
        }
        localdwi.ndI = locala.LVo.xF();
        AppMethodBeat.o(32517);
        return 0;
      }
      AppMethodBeat.o(32517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwi
 * JD-Core Version:    0.7.0.1
 */