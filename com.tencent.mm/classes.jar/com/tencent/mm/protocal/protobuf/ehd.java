package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehd
  extends com.tencent.mm.bx.a
{
  public String abmt;
  public String desc;
  public String icon_url;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259030);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.bS(3, this.state);
      if (this.icon_url != null) {
        paramVarArgs.g(4, this.icon_url);
      }
      if (this.abmt != null) {
        paramVarArgs.g(5, this.abmt);
      }
      AppMethodBeat.o(259030);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      i += i.a.a.b.b.a.cJ(3, this.state);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.icon_url);
      }
      i = paramInt;
      if (this.abmt != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abmt);
      }
      AppMethodBeat.o(259030);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259030);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ehd localehd = (ehd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259030);
          return -1;
        case 1: 
          localehd.scope = locala.ajGk.readString();
          AppMethodBeat.o(259030);
          return 0;
        case 2: 
          localehd.desc = locala.ajGk.readString();
          AppMethodBeat.o(259030);
          return 0;
        case 3: 
          localehd.state = locala.ajGk.aar();
          AppMethodBeat.o(259030);
          return 0;
        case 4: 
          localehd.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(259030);
          return 0;
        }
        localehd.abmt = locala.ajGk.readString();
        AppMethodBeat.o(259030);
        return 0;
      }
      AppMethodBeat.o(259030);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehd
 * JD-Core Version:    0.7.0.1
 */