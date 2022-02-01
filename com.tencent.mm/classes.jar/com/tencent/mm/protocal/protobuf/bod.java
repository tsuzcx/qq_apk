package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bod
  extends com.tencent.mm.bx.a
{
  public int Tqb;
  public String ZWx;
  public String appid;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258479);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      if (this.ZWx != null) {
        paramVarArgs.g(3, this.ZWx);
      }
      paramVarArgs.bS(4, this.Tqb);
      AppMethodBeat.o(258479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.path);
      }
      i = paramInt;
      if (this.ZWx != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZWx);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.Tqb);
      AppMethodBeat.o(258479);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258479);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bod localbod = (bod)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258479);
          return -1;
        case 1: 
          localbod.appid = locala.ajGk.readString();
          AppMethodBeat.o(258479);
          return 0;
        case 2: 
          localbod.path = locala.ajGk.readString();
          AppMethodBeat.o(258479);
          return 0;
        case 3: 
          localbod.ZWx = locala.ajGk.readString();
          AppMethodBeat.o(258479);
          return 0;
        }
        localbod.Tqb = locala.ajGk.aar();
        AppMethodBeat.o(258479);
        return 0;
      }
      AppMethodBeat.o(258479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bod
 * JD-Core Version:    0.7.0.1
 */