package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvo
  extends com.tencent.mm.bw.a
{
  public String FGo;
  public String FGp;
  public String qoi;
  public String qon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qon != null) {
        paramVarArgs.d(1, this.qon);
      }
      if (this.FGo != null) {
        paramVarArgs.d(2, this.FGo);
      }
      if (this.qoi != null) {
        paramVarArgs.d(3, this.qoi);
      }
      if (this.FGp != null) {
        paramVarArgs.d(4, this.FGp);
      }
      AppMethodBeat.o(122526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qon == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.qon) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FGo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FGo);
      }
      i = paramInt;
      if (this.qoi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qoi);
      }
      paramInt = i;
      if (this.FGp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FGp);
      }
      AppMethodBeat.o(122526);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122526);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvo localcvo = (cvo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122526);
          return -1;
        case 1: 
          localcvo.qon = locala.LVo.readString();
          AppMethodBeat.o(122526);
          return 0;
        case 2: 
          localcvo.FGo = locala.LVo.readString();
          AppMethodBeat.o(122526);
          return 0;
        case 3: 
          localcvo.qoi = locala.LVo.readString();
          AppMethodBeat.o(122526);
          return 0;
        }
        localcvo.FGp = locala.LVo.readString();
        AppMethodBeat.o(122526);
        return 0;
      }
      AppMethodBeat.o(122526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvo
 * JD-Core Version:    0.7.0.1
 */