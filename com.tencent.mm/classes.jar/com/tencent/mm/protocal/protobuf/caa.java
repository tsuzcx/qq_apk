package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caa
  extends com.tencent.mm.bx.a
{
  public int KuZ;
  public int Kva;
  public String content;
  public String iconUrl;
  public int lTH = 0;
  public String name;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258609);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      paramVarArgs.bS(2, this.type);
      if (this.content != null) {
        paramVarArgs.g(3, this.content);
      }
      paramVarArgs.bS(4, this.lTH);
      if (this.iconUrl != null) {
        paramVarArgs.g(5, this.iconUrl);
      }
      paramVarArgs.bS(6, this.KuZ);
      paramVarArgs.bS(7, this.Kva);
      AppMethodBeat.o(258609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.b.b.a.h(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.content);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.lTH);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.iconUrl);
      }
      i = i.a.a.b.b.a.cJ(6, this.KuZ);
      int j = i.a.a.b.b.a.cJ(7, this.Kva);
      AppMethodBeat.o(258609);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258609);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        caa localcaa = (caa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258609);
          return -1;
        case 1: 
          localcaa.name = locala.ajGk.readString();
          AppMethodBeat.o(258609);
          return 0;
        case 2: 
          localcaa.type = locala.ajGk.aar();
          AppMethodBeat.o(258609);
          return 0;
        case 3: 
          localcaa.content = locala.ajGk.readString();
          AppMethodBeat.o(258609);
          return 0;
        case 4: 
          localcaa.lTH = locala.ajGk.aar();
          AppMethodBeat.o(258609);
          return 0;
        case 5: 
          localcaa.iconUrl = locala.ajGk.readString();
          AppMethodBeat.o(258609);
          return 0;
        case 6: 
          localcaa.KuZ = locala.ajGk.aar();
          AppMethodBeat.o(258609);
          return 0;
        }
        localcaa.Kva = locala.ajGk.aar();
        AppMethodBeat.o(258609);
        return 0;
      }
      AppMethodBeat.o(258609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caa
 * JD-Core Version:    0.7.0.1
 */