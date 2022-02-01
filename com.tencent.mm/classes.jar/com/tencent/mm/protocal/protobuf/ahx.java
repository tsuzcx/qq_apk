package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ahx
  extends com.tencent.mm.bw.a
{
  public String EBT;
  public int bQb;
  public String zkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zkN == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagName");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.EBT == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagPinYin");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.zkN != null) {
        paramVarArgs.d(1, this.zkN);
      }
      if (this.EBT != null) {
        paramVarArgs.d(2, this.EBT);
      }
      paramVarArgs.aR(3, this.bQb);
      AppMethodBeat.o(127485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zkN == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.b.b.a.e(1, this.zkN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EBT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EBT);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.bQb);
      AppMethodBeat.o(127485);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.zkN == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagName");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        if (this.EBT == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagPinYin");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127485);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahx localahx = (ahx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127485);
          return -1;
        case 1: 
          localahx.zkN = locala.LVo.readString();
          AppMethodBeat.o(127485);
          return 0;
        case 2: 
          localahx.EBT = locala.LVo.readString();
          AppMethodBeat.o(127485);
          return 0;
        }
        localahx.bQb = locala.LVo.xF();
        AppMethodBeat.o(127485);
        return 0;
      }
      AppMethodBeat.o(127485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahx
 * JD-Core Version:    0.7.0.1
 */