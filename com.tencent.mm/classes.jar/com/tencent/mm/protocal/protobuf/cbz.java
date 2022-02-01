package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbz
  extends com.tencent.mm.bx.a
{
  public int FKN;
  public String GVP;
  public String GVQ;
  public String path;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123630);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.GVP != null) {
        paramVarArgs.d(2, this.GVP);
      }
      if (this.GVQ != null) {
        paramVarArgs.d(3, this.GVQ);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.aS(5, this.FKN);
      paramVarArgs.aS(6, this.type);
      AppMethodBeat.o(123630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GVP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GVP);
      }
      i = paramInt;
      if (this.GVQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GVQ);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = f.a.a.b.b.a.bz(5, this.FKN);
      int j = f.a.a.b.b.a.bz(6, this.type);
      AppMethodBeat.o(123630);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123630);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cbz localcbz = (cbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123630);
          return -1;
        case 1: 
          localcbz.username = locala.NPN.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 2: 
          localcbz.GVP = locala.NPN.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 3: 
          localcbz.GVQ = locala.NPN.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 4: 
          localcbz.path = locala.NPN.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 5: 
          localcbz.FKN = locala.NPN.zc();
          AppMethodBeat.o(123630);
          return 0;
        }
        localcbz.type = locala.NPN.zc();
        AppMethodBeat.o(123630);
        return 0;
      }
      AppMethodBeat.o(123630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbz
 * JD-Core Version:    0.7.0.1
 */