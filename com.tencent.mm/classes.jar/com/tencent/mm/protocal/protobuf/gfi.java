package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gfi
  extends com.tencent.mm.bx.a
{
  public b ZIZ;
  public String appid;
  public String path;
  public int version;
  public String xlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259406);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      paramVarArgs.bS(3, this.version);
      if (this.ZIZ != null) {
        paramVarArgs.d(4, this.ZIZ);
      }
      if (this.xlJ != null) {
        paramVarArgs.g(5, this.xlJ);
      }
      AppMethodBeat.o(259406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.path);
      }
      i += i.a.a.b.b.a.cJ(3, this.version);
      paramInt = i;
      if (this.ZIZ != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.ZIZ);
      }
      i = paramInt;
      if (this.xlJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.xlJ);
      }
      AppMethodBeat.o(259406);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259406);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfi localgfi = (gfi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259406);
          return -1;
        case 1: 
          localgfi.appid = locala.ajGk.readString();
          AppMethodBeat.o(259406);
          return 0;
        case 2: 
          localgfi.path = locala.ajGk.readString();
          AppMethodBeat.o(259406);
          return 0;
        case 3: 
          localgfi.version = locala.ajGk.aar();
          AppMethodBeat.o(259406);
          return 0;
        case 4: 
          localgfi.ZIZ = locala.ajGk.kFX();
          AppMethodBeat.o(259406);
          return 0;
        }
        localgfi.xlJ = locala.ajGk.readString();
        AppMethodBeat.o(259406);
        return 0;
      }
      AppMethodBeat.o(259406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfi
 * JD-Core Version:    0.7.0.1
 */