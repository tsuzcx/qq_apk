package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class acw
  extends com.tencent.mm.bw.a
{
  public b Loi;
  public String openid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186797);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.openid != null) {
        paramVarArgs.e(1, this.openid);
      }
      if (this.Loi != null) {
        paramVarArgs.c(2, this.Loi);
      }
      AppMethodBeat.o(186797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.openid == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.openid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Loi != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.Loi);
      }
      AppMethodBeat.o(186797);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(186797);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        acw localacw = (acw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(186797);
          return -1;
        case 1: 
          localacw.openid = locala.UbS.readString();
          AppMethodBeat.o(186797);
          return 0;
        }
        localacw.Loi = locala.UbS.hPo();
        AppMethodBeat.o(186797);
        return 0;
      }
      AppMethodBeat.o(186797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acw
 * JD-Core Version:    0.7.0.1
 */