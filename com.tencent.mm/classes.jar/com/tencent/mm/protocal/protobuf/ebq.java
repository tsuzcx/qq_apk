package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebq
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String oGN;
  public String title;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153331);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oGN != null) {
        paramVarArgs.d(1, this.oGN);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      AppMethodBeat.o(153331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oGN == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.oGN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      AppMethodBeat.o(153331);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153331);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebq localebq = (ebq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153331);
          return -1;
        case 1: 
          localebq.oGN = locala.LVo.readString();
          AppMethodBeat.o(153331);
          return 0;
        case 2: 
          localebq.title = locala.LVo.readString();
          AppMethodBeat.o(153331);
          return 0;
        case 3: 
          localebq.desc = locala.LVo.readString();
          AppMethodBeat.o(153331);
          return 0;
        }
        localebq.username = locala.LVo.readString();
        AppMethodBeat.o(153331);
        return 0;
      }
      AppMethodBeat.o(153331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebq
 * JD-Core Version:    0.7.0.1
 */