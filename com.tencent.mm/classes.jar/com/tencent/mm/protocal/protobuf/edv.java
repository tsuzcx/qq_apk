package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edv
  extends com.tencent.mm.bw.a
{
  public int DUS;
  public String IiI;
  public String dLl;
  public int isGame;
  public String path;
  public int subType;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125852);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(2, this.path);
      }
      paramVarArgs.aS(3, this.version);
      paramVarArgs.aS(4, this.DUS);
      if (this.IiI != null) {
        paramVarArgs.d(5, this.IiI);
      }
      paramVarArgs.aS(6, this.isGame);
      if (this.dLl != null) {
        paramVarArgs.d(7, this.dLl);
      }
      paramVarArgs.aS(8, this.subType);
      AppMethodBeat.o(125852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.path);
      }
      i = i + f.a.a.b.b.a.bz(3, this.version) + f.a.a.b.b.a.bz(4, this.DUS);
      paramInt = i;
      if (this.IiI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.IiI);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.isGame);
      paramInt = i;
      if (this.dLl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dLl);
      }
      i = f.a.a.b.b.a.bz(8, this.subType);
      AppMethodBeat.o(125852);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125852);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edv localedv = (edv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125852);
          return -1;
        case 1: 
          localedv.username = locala.OmT.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 2: 
          localedv.path = locala.OmT.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 3: 
          localedv.version = locala.OmT.zc();
          AppMethodBeat.o(125852);
          return 0;
        case 4: 
          localedv.DUS = locala.OmT.zc();
          AppMethodBeat.o(125852);
          return 0;
        case 5: 
          localedv.IiI = locala.OmT.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 6: 
          localedv.isGame = locala.OmT.zc();
          AppMethodBeat.o(125852);
          return 0;
        case 7: 
          localedv.dLl = locala.OmT.readString();
          AppMethodBeat.o(125852);
          return 0;
        }
        localedv.subType = locala.OmT.zc();
        AppMethodBeat.o(125852);
        return 0;
      }
      AppMethodBeat.o(125852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edv
 * JD-Core Version:    0.7.0.1
 */