package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextStatusJumpInfo
  extends com.tencent.mm.bx.a
{
  public String busiBuf;
  public String busiId;
  public String jumpType;
  public String keyBusiBuf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290002);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.jumpType != null) {
        paramVarArgs.g(1, this.jumpType);
      }
      if (this.busiId != null) {
        paramVarArgs.g(2, this.busiId);
      }
      if (this.busiBuf != null) {
        paramVarArgs.g(3, this.busiBuf);
      }
      if (this.keyBusiBuf != null) {
        paramVarArgs.g(4, this.keyBusiBuf);
      }
      AppMethodBeat.o(290002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jumpType == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.jumpType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.busiId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.busiId);
      }
      i = paramInt;
      if (this.busiBuf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.busiBuf);
      }
      paramInt = i;
      if (this.keyBusiBuf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.keyBusiBuf);
      }
      AppMethodBeat.o(290002);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290002);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        TextStatusJumpInfo localTextStatusJumpInfo = (TextStatusJumpInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(290002);
          return -1;
        case 1: 
          localTextStatusJumpInfo.jumpType = locala.ajGk.readString();
          AppMethodBeat.o(290002);
          return 0;
        case 2: 
          localTextStatusJumpInfo.busiId = locala.ajGk.readString();
          AppMethodBeat.o(290002);
          return 0;
        case 3: 
          localTextStatusJumpInfo.busiBuf = locala.ajGk.readString();
          AppMethodBeat.o(290002);
          return 0;
        }
        localTextStatusJumpInfo.keyBusiBuf = locala.ajGk.readString();
        AppMethodBeat.o(290002);
        return 0;
      }
      AppMethodBeat.o(290002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo
 * JD-Core Version:    0.7.0.1
 */