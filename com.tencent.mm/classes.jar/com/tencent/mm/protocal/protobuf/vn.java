package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class vn
  extends com.tencent.mm.bx.a
{
  public String Zbk;
  public String appId;
  public int eul;
  public String md5;
  public String path;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258812);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      paramVarArgs.bS(3, this.version);
      paramVarArgs.bS(4, this.eul);
      if (this.md5 != null) {
        paramVarArgs.g(5, this.md5);
      }
      if (this.Zbk != null) {
        paramVarArgs.g(6, this.Zbk);
      }
      AppMethodBeat.o(258812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = i.a.a.b.b.a.h(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.path);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.version) + i.a.a.b.b.a.cJ(4, this.eul);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.md5);
      }
      i = paramInt;
      if (this.Zbk != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Zbk);
      }
      AppMethodBeat.o(258812);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258812);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        vn localvn = (vn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258812);
          return -1;
        case 1: 
          localvn.appId = locala.ajGk.readString();
          AppMethodBeat.o(258812);
          return 0;
        case 2: 
          localvn.path = locala.ajGk.readString();
          AppMethodBeat.o(258812);
          return 0;
        case 3: 
          localvn.version = locala.ajGk.aar();
          AppMethodBeat.o(258812);
          return 0;
        case 4: 
          localvn.eul = locala.ajGk.aar();
          AppMethodBeat.o(258812);
          return 0;
        case 5: 
          localvn.md5 = locala.ajGk.readString();
          AppMethodBeat.o(258812);
          return 0;
        }
        localvn.Zbk = locala.ajGk.readString();
        AppMethodBeat.o(258812);
        return 0;
      }
      AppMethodBeat.o(258812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vn
 * JD-Core Version:    0.7.0.1
 */