package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpp
  extends com.tencent.mm.bx.a
{
  public long AAW;
  public String hJS;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169012);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.opType);
      paramVarArgs.bv(2, this.refObjectId);
      paramVarArgs.bv(3, this.AAW);
      if (this.username != null) {
        paramVarArgs.g(4, this.username);
      }
      if (this.hJS != null) {
        paramVarArgs.g(5, this.hJS);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.g(6, this.refObjectNonceId);
      }
      if (this.scene != null) {
        paramVarArgs.g(7, this.scene);
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.opType) + 0 + i.a.a.b.b.a.q(2, this.refObjectId) + i.a.a.b.b.a.q(3, this.AAW);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.username);
      }
      i = paramInt;
      if (this.hJS != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hJS);
      }
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.scene != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.scene);
      }
      AppMethodBeat.o(169012);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bpp localbpp = (bpp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169012);
        return -1;
      case 1: 
        localbpp.opType = locala.ajGk.aar();
        AppMethodBeat.o(169012);
        return 0;
      case 2: 
        localbpp.refObjectId = locala.ajGk.aaw();
        AppMethodBeat.o(169012);
        return 0;
      case 3: 
        localbpp.AAW = locala.ajGk.aaw();
        AppMethodBeat.o(169012);
        return 0;
      case 4: 
        localbpp.username = locala.ajGk.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 5: 
        localbpp.hJS = locala.ajGk.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 6: 
        localbpp.refObjectNonceId = locala.ajGk.readString();
        AppMethodBeat.o(169012);
        return 0;
      }
      localbpp.scene = locala.ajGk.readString();
      AppMethodBeat.o(169012);
      return 0;
    }
    AppMethodBeat.o(169012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpp
 * JD-Core Version:    0.7.0.1
 */