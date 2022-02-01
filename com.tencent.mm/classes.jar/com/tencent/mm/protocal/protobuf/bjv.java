package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjv
  extends com.tencent.mm.bw.a
{
  public String dsY;
  public String koY = "";
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.value != null) {
        paramVarArgs.d(1, this.value);
      }
      if (this.dsY != null) {
        paramVarArgs.d(2, this.dsY);
      }
      if (this.koY != null) {
        paramVarArgs.d(3, this.koY);
      }
      AppMethodBeat.o(122514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.value == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.value) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dsY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dsY);
      }
      i = paramInt;
      if (this.koY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.koY);
      }
      AppMethodBeat.o(122514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjv localbjv = (bjv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122514);
          return -1;
        case 1: 
          localbjv.value = locala.LVo.readString();
          AppMethodBeat.o(122514);
          return 0;
        case 2: 
          localbjv.dsY = locala.LVo.readString();
          AppMethodBeat.o(122514);
          return 0;
        }
        localbjv.koY = locala.LVo.readString();
        AppMethodBeat.o(122514);
        return 0;
      }
      AppMethodBeat.o(122514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjv
 * JD-Core Version:    0.7.0.1
 */