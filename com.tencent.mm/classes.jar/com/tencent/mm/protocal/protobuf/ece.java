package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ece
  extends com.tencent.mm.bx.a
{
  public int DCU;
  public String HOB;
  public String dJW;
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
      paramVarArgs.aS(4, this.DCU);
      if (this.HOB != null) {
        paramVarArgs.d(5, this.HOB);
      }
      paramVarArgs.aS(6, this.isGame);
      if (this.dJW != null) {
        paramVarArgs.d(7, this.dJW);
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
      i = i + f.a.a.b.b.a.bz(3, this.version) + f.a.a.b.b.a.bz(4, this.DCU);
      paramInt = i;
      if (this.HOB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HOB);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.isGame);
      paramInt = i;
      if (this.dJW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dJW);
      }
      i = f.a.a.b.b.a.bz(8, this.subType);
      AppMethodBeat.o(125852);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125852);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ece localece = (ece)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125852);
          return -1;
        case 1: 
          localece.username = locala.NPN.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 2: 
          localece.path = locala.NPN.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 3: 
          localece.version = locala.NPN.zc();
          AppMethodBeat.o(125852);
          return 0;
        case 4: 
          localece.DCU = locala.NPN.zc();
          AppMethodBeat.o(125852);
          return 0;
        case 5: 
          localece.HOB = locala.NPN.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 6: 
          localece.isGame = locala.NPN.zc();
          AppMethodBeat.o(125852);
          return 0;
        case 7: 
          localece.dJW = locala.NPN.readString();
          AppMethodBeat.o(125852);
          return 0;
        }
        localece.subType = locala.NPN.zc();
        AppMethodBeat.o(125852);
        return 0;
      }
      AppMethodBeat.o(125852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ece
 * JD-Core Version:    0.7.0.1
 */