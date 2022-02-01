package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acl
  extends com.tencent.mm.bx.a
{
  public int ZkN;
  public String icon_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258002);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.icon_url != null) {
        paramVarArgs.g(1, this.icon_url);
      }
      paramVarArgs.bS(2, this.ZkN);
      AppMethodBeat.o(258002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.icon_url == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.icon_url) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZkN);
      AppMethodBeat.o(258002);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258002);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        acl localacl = (acl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258002);
          return -1;
        case 1: 
          localacl.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(258002);
          return 0;
        }
        localacl.ZkN = locala.ajGk.aar();
        AppMethodBeat.o(258002);
        return 0;
      }
      AppMethodBeat.o(258002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acl
 * JD-Core Version:    0.7.0.1
 */