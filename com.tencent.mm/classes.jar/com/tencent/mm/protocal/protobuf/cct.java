package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cct
  extends com.tencent.mm.bw.a
{
  public int Gdm;
  public String Hpp;
  public String Hpq;
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
      if (this.Hpp != null) {
        paramVarArgs.d(2, this.Hpp);
      }
      if (this.Hpq != null) {
        paramVarArgs.d(3, this.Hpq);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.aS(5, this.Gdm);
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
      if (this.Hpp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hpp);
      }
      i = paramInt;
      if (this.Hpq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hpq);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = f.a.a.b.b.a.bz(5, this.Gdm);
      int j = f.a.a.b.b.a.bz(6, this.type);
      AppMethodBeat.o(123630);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123630);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cct localcct = (cct)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123630);
          return -1;
        case 1: 
          localcct.username = locala.OmT.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 2: 
          localcct.Hpp = locala.OmT.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 3: 
          localcct.Hpq = locala.OmT.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 4: 
          localcct.path = locala.OmT.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 5: 
          localcct.Gdm = locala.OmT.zc();
          AppMethodBeat.o(123630);
          return 0;
        }
        localcct.type = locala.OmT.zc();
        AppMethodBeat.o(123630);
        return 0;
      }
      AppMethodBeat.o(123630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cct
 * JD-Core Version:    0.7.0.1
 */