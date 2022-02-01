package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ako
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int FNy;
  public String FNz;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138174);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      paramVarArgs.aS(3, this.FNy);
      if (this.FNz != null) {
        paramVarArgs.d(4, this.FNz);
      }
      AppMethodBeat.o(138174);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      i += f.a.a.b.b.a.bz(3, this.FNy);
      paramInt = i;
      if (this.FNz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNz);
      }
      AppMethodBeat.o(138174);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(138174);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ako localako = (ako)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138174);
          return -1;
        case 1: 
          localako.Title = locala.OmT.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 2: 
          localako.Desc = locala.OmT.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 3: 
          localako.FNy = locala.OmT.zc();
          AppMethodBeat.o(138174);
          return 0;
        }
        localako.FNz = locala.OmT.readString();
        AppMethodBeat.o(138174);
        return 0;
      }
      AppMethodBeat.o(138174);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ako
 * JD-Core Version:    0.7.0.1
 */