package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextStatusJumpInfo
  extends com.tencent.mm.cd.a
{
  public String busiBuf;
  public String busiId;
  public String jumpType;
  public String keyBusiBuf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243725);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jumpType != null) {
        paramVarArgs.f(1, this.jumpType);
      }
      if (this.busiId != null) {
        paramVarArgs.f(2, this.busiId);
      }
      if (this.busiBuf != null) {
        paramVarArgs.f(3, this.busiBuf);
      }
      if (this.keyBusiBuf != null) {
        paramVarArgs.f(4, this.keyBusiBuf);
      }
      AppMethodBeat.o(243725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jumpType == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.jumpType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.busiId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.busiId);
      }
      i = paramInt;
      if (this.busiBuf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.busiBuf);
      }
      paramInt = i;
      if (this.keyBusiBuf != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.keyBusiBuf);
      }
      AppMethodBeat.o(243725);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243725);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        TextStatusJumpInfo localTextStatusJumpInfo = (TextStatusJumpInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243725);
          return -1;
        case 1: 
          localTextStatusJumpInfo.jumpType = locala.abFh.readString();
          AppMethodBeat.o(243725);
          return 0;
        case 2: 
          localTextStatusJumpInfo.busiId = locala.abFh.readString();
          AppMethodBeat.o(243725);
          return 0;
        case 3: 
          localTextStatusJumpInfo.busiBuf = locala.abFh.readString();
          AppMethodBeat.o(243725);
          return 0;
        }
        localTextStatusJumpInfo.keyBusiBuf = locala.abFh.readString();
        AppMethodBeat.o(243725);
        return 0;
      }
      AppMethodBeat.o(243725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo
 * JD-Core Version:    0.7.0.1
 */