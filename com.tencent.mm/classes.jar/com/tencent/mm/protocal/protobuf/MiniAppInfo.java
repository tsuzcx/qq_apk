package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MiniAppInfo
  extends com.tencent.mm.bx.a
{
  public String app_id;
  public String appusername;
  public String fetch_info_id;
  public String path;
  public String request_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258550);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.g(1, this.app_id);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      if (this.fetch_info_id != null) {
        paramVarArgs.g(3, this.fetch_info_id);
      }
      if (this.request_id != null) {
        paramVarArgs.g(4, this.request_id);
      }
      if (this.appusername != null) {
        paramVarArgs.g(5, this.appusername);
      }
      AppMethodBeat.o(258550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.path);
      }
      i = paramInt;
      if (this.fetch_info_id != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.fetch_info_id);
      }
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.request_id);
      }
      i = paramInt;
      if (this.appusername != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.appusername);
      }
      AppMethodBeat.o(258550);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258550);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258550);
          return -1;
        case 1: 
          localMiniAppInfo.app_id = locala.ajGk.readString();
          AppMethodBeat.o(258550);
          return 0;
        case 2: 
          localMiniAppInfo.path = locala.ajGk.readString();
          AppMethodBeat.o(258550);
          return 0;
        case 3: 
          localMiniAppInfo.fetch_info_id = locala.ajGk.readString();
          AppMethodBeat.o(258550);
          return 0;
        case 4: 
          localMiniAppInfo.request_id = locala.ajGk.readString();
          AppMethodBeat.o(258550);
          return 0;
        }
        localMiniAppInfo.appusername = locala.ajGk.readString();
        AppMethodBeat.o(258550);
        return 0;
      }
      AppMethodBeat.o(258550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.MiniAppInfo
 * JD-Core Version:    0.7.0.1
 */