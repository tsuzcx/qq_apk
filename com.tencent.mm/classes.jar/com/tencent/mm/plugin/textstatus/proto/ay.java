package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bx.a
{
  public int Tqb;
  public int Tqc;
  public String app_id;
  public String icon_url;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289962);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.g(1, this.app_id);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      paramVarArgs.bS(4, this.Tqb);
      paramVarArgs.bS(5, this.Tqc);
      if (this.icon_url != null) {
        paramVarArgs.g(6, this.icon_url);
      }
      AppMethodBeat.o(289962);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.b.b.a.h(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.path);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.Tqb) + i.a.a.b.b.a.cJ(5, this.Tqc);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.icon_url);
      }
      AppMethodBeat.o(289962);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289962);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(289962);
          return -1;
        case 1: 
          localay.app_id = locala.ajGk.readString();
          AppMethodBeat.o(289962);
          return 0;
        case 2: 
          localay.path = locala.ajGk.readString();
          AppMethodBeat.o(289962);
          return 0;
        case 3: 
          localay.username = locala.ajGk.readString();
          AppMethodBeat.o(289962);
          return 0;
        case 4: 
          localay.Tqb = locala.ajGk.aar();
          AppMethodBeat.o(289962);
          return 0;
        case 5: 
          localay.Tqc = locala.ajGk.aar();
          AppMethodBeat.o(289962);
          return 0;
        }
        localay.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(289962);
        return 0;
      }
      AppMethodBeat.o(289962);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ay
 * JD-Core Version:    0.7.0.1
 */