package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aby
  extends com.tencent.mm.bv.a
{
  public String appId;
  public String cmG;
  public int cvs;
  public String iconUrl;
  public int type;
  public String username;
  public String wSs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51388);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.appId != null) {
        paramVarArgs.e(2, this.appId);
      }
      paramVarArgs.aO(3, this.cvs);
      if (this.iconUrl != null) {
        paramVarArgs.e(4, this.iconUrl);
      }
      paramVarArgs.aO(5, this.type);
      if (this.cmG != null) {
        paramVarArgs.e(6, this.cmG);
      }
      if (this.wSs != null) {
        paramVarArgs.e(7, this.wSs);
      }
      AppMethodBeat.o(51388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appId != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.appId);
      }
      i += e.a.a.b.b.a.bl(3, this.cvs);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.iconUrl);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.type);
      paramInt = i;
      if (this.cmG != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.cmG);
      }
      i = paramInt;
      if (this.wSs != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wSs);
      }
      AppMethodBeat.o(51388);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51388);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aby localaby = (aby)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51388);
          return -1;
        case 1: 
          localaby.username = locala.CLY.readString();
          AppMethodBeat.o(51388);
          return 0;
        case 2: 
          localaby.appId = locala.CLY.readString();
          AppMethodBeat.o(51388);
          return 0;
        case 3: 
          localaby.cvs = locala.CLY.sl();
          AppMethodBeat.o(51388);
          return 0;
        case 4: 
          localaby.iconUrl = locala.CLY.readString();
          AppMethodBeat.o(51388);
          return 0;
        case 5: 
          localaby.type = locala.CLY.sl();
          AppMethodBeat.o(51388);
          return 0;
        case 6: 
          localaby.cmG = locala.CLY.readString();
          AppMethodBeat.o(51388);
          return 0;
        }
        localaby.wSs = locala.CLY.readString();
        AppMethodBeat.o(51388);
        return 0;
      }
      AppMethodBeat.o(51388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aby
 * JD-Core Version:    0.7.0.1
 */