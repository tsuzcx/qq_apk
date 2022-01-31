package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akx
  extends com.tencent.mm.bv.a
{
  public String iuQ;
  public String kWy;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96227);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kWy != null) {
        paramVarArgs.e(1, this.kWy);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      paramVarArgs.aO(3, this.type);
      if (this.iuQ != null) {
        paramVarArgs.e(4, this.iuQ);
      }
      if (this.username != null) {
        paramVarArgs.e(5, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(6, this.path);
      }
      AppMethodBeat.o(96227);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWy == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = e.a.a.b.b.a.f(1, this.kWy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.title);
      }
      i += e.a.a.b.b.a.bl(3, this.type);
      paramInt = i;
      if (this.iuQ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.iuQ);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.username);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.path);
      }
      AppMethodBeat.o(96227);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96227);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        akx localakx = (akx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96227);
          return -1;
        case 1: 
          localakx.kWy = locala.CLY.readString();
          AppMethodBeat.o(96227);
          return 0;
        case 2: 
          localakx.title = locala.CLY.readString();
          AppMethodBeat.o(96227);
          return 0;
        case 3: 
          localakx.type = locala.CLY.sl();
          AppMethodBeat.o(96227);
          return 0;
        case 4: 
          localakx.iuQ = locala.CLY.readString();
          AppMethodBeat.o(96227);
          return 0;
        case 5: 
          localakx.username = locala.CLY.readString();
          AppMethodBeat.o(96227);
          return 0;
        }
        localakx.path = locala.CLY.readString();
        AppMethodBeat.o(96227);
        return 0;
      }
      AppMethodBeat.o(96227);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akx
 * JD-Core Version:    0.7.0.1
 */