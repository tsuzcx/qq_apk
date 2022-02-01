package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvm
  extends com.tencent.mm.bw.a
{
  public boolean BkD;
  public String kfi;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153296);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.bl(2, this.BkD);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.kfi != null) {
        paramVarArgs.d(4, this.kfi);
      }
      AppMethodBeat.o(153296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 1);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.kfi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.kfi);
      }
      AppMethodBeat.o(153296);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153296);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvm localcvm = (cvm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153296);
          return -1;
        case 1: 
          localcvm.username = locala.LVo.readString();
          AppMethodBeat.o(153296);
          return 0;
        case 2: 
          localcvm.BkD = locala.LVo.fZX();
          AppMethodBeat.o(153296);
          return 0;
        case 3: 
          localcvm.nickname = locala.LVo.readString();
          AppMethodBeat.o(153296);
          return 0;
        }
        localcvm.kfi = locala.LVo.readString();
        AppMethodBeat.o(153296);
        return 0;
      }
      AppMethodBeat.o(153296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvm
 * JD-Core Version:    0.7.0.1
 */