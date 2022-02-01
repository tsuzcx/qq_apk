package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fm
  extends com.tencent.mm.bx.a
{
  public int YGW;
  public String appid;
  public int position;
  public String request_id;
  public String tNT;
  public String tNX;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50080);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.request_id != null) {
        paramVarArgs.g(2, this.request_id);
      }
      if (this.tNT != null) {
        paramVarArgs.g(3, this.tNT);
      }
      if (this.appid != null) {
        paramVarArgs.g(4, this.appid);
      }
      if (this.tNX != null) {
        paramVarArgs.g(5, this.tNX);
      }
      paramVarArgs.bS(6, this.position);
      paramVarArgs.bS(7, this.YGW);
      AppMethodBeat.o(50080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label546;
      }
    }
    label546:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.request_id);
      }
      i = paramInt;
      if (this.tNT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.tNT);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.appid);
      }
      i = paramInt;
      if (this.tNX != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.tNX);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.position);
      int j = i.a.a.b.b.a.cJ(7, this.YGW);
      AppMethodBeat.o(50080);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50080);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fm localfm = (fm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50080);
          return -1;
        case 1: 
          localfm.username = locala.ajGk.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 2: 
          localfm.request_id = locala.ajGk.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 3: 
          localfm.tNT = locala.ajGk.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 4: 
          localfm.appid = locala.ajGk.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 5: 
          localfm.tNX = locala.ajGk.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 6: 
          localfm.position = locala.ajGk.aar();
          AppMethodBeat.o(50080);
          return 0;
        }
        localfm.YGW = locala.ajGk.aar();
        AppMethodBeat.o(50080);
        return 0;
      }
      AppMethodBeat.o(50080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fm
 * JD-Core Version:    0.7.0.1
 */