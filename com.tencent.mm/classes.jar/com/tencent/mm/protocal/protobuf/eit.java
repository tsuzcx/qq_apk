package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eit
  extends com.tencent.mm.bw.a
{
  public int Gdm;
  public String Hpp;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.Hpp != null) {
        paramVarArgs.d(2, this.Hpp);
      }
      paramVarArgs.aS(3, this.Gdm);
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(123705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hpp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hpp);
      }
      i += f.a.a.b.b.a.bz(3, this.Gdm);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      AppMethodBeat.o(123705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123705);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eit localeit = (eit)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123705);
          return -1;
        case 1: 
          localeit.username = locala.OmT.readString();
          AppMethodBeat.o(123705);
          return 0;
        case 2: 
          localeit.Hpp = locala.OmT.readString();
          AppMethodBeat.o(123705);
          return 0;
        case 3: 
          localeit.Gdm = locala.OmT.zc();
          AppMethodBeat.o(123705);
          return 0;
        }
        localeit.path = locala.OmT.readString();
        AppMethodBeat.o(123705);
        return 0;
      }
      AppMethodBeat.o(123705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eit
 * JD-Core Version:    0.7.0.1
 */