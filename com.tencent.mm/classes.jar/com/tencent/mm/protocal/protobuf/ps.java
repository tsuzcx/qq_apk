package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ps
  extends com.tencent.mm.bw.a
{
  public String Gdj;
  public String Gdk;
  public String Url;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152989);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdj != null) {
        paramVarArgs.d(1, this.Gdj);
      }
      if (this.Gdk != null) {
        paramVarArgs.d(2, this.Gdk);
      }
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aS(4, this.nJA);
      AppMethodBeat.o(152989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gdj == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Gdj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gdk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gdk);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Url);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.nJA);
      AppMethodBeat.o(152989);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152989);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ps localps = (ps)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152989);
          return -1;
        case 1: 
          localps.Gdj = locala.OmT.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 2: 
          localps.Gdk = locala.OmT.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 3: 
          localps.Url = locala.OmT.readString();
          AppMethodBeat.o(152989);
          return 0;
        }
        localps.nJA = locala.OmT.zc();
        AppMethodBeat.o(152989);
        return 0;
      }
      AppMethodBeat.o(152989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ps
 * JD-Core Version:    0.7.0.1
 */