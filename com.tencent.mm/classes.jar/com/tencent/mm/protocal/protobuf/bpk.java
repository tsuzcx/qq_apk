package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpk
  extends com.tencent.mm.bx.a
{
  public String app_id;
  public String fetch_info_id;
  public String path;
  public int style;
  public String xlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257958);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.g(1, this.app_id);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      paramVarArgs.bS(3, this.style);
      if (this.fetch_info_id != null) {
        paramVarArgs.g(4, this.fetch_info_id);
      }
      if (this.xlJ != null) {
        paramVarArgs.g(5, this.xlJ);
      }
      AppMethodBeat.o(257958);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.app_id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.path);
      }
      i += i.a.a.b.b.a.cJ(3, this.style);
      paramInt = i;
      if (this.fetch_info_id != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.fetch_info_id);
      }
      i = paramInt;
      if (this.xlJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.xlJ);
      }
      AppMethodBeat.o(257958);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257958);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bpk localbpk = (bpk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257958);
          return -1;
        case 1: 
          localbpk.app_id = locala.ajGk.readString();
          AppMethodBeat.o(257958);
          return 0;
        case 2: 
          localbpk.path = locala.ajGk.readString();
          AppMethodBeat.o(257958);
          return 0;
        case 3: 
          localbpk.style = locala.ajGk.aar();
          AppMethodBeat.o(257958);
          return 0;
        case 4: 
          localbpk.fetch_info_id = locala.ajGk.readString();
          AppMethodBeat.o(257958);
          return 0;
        }
        localbpk.xlJ = locala.ajGk.readString();
        AppMethodBeat.o(257958);
        return 0;
      }
      AppMethodBeat.o(257958);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpk
 * JD-Core Version:    0.7.0.1
 */