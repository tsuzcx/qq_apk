package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqn
  extends com.tencent.mm.bx.a
{
  public int AHI;
  public String EGj;
  public String dzY;
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
      paramVarArgs.aR(3, this.version);
      paramVarArgs.aR(4, this.AHI);
      if (this.EGj != null) {
        paramVarArgs.d(5, this.EGj);
      }
      paramVarArgs.aR(6, this.isGame);
      if (this.dzY != null) {
        paramVarArgs.d(7, this.dzY);
      }
      paramVarArgs.aR(8, this.subType);
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
      i = i + f.a.a.b.b.a.bA(3, this.version) + f.a.a.b.b.a.bA(4, this.AHI);
      paramInt = i;
      if (this.EGj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EGj);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.isGame);
      paramInt = i;
      if (this.dzY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dzY);
      }
      i = f.a.a.b.b.a.bA(8, this.subType);
      AppMethodBeat.o(125852);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125852);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqn localdqn = (dqn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125852);
          return -1;
        case 1: 
          localdqn.username = locala.KhF.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 2: 
          localdqn.path = locala.KhF.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 3: 
          localdqn.version = locala.KhF.xS();
          AppMethodBeat.o(125852);
          return 0;
        case 4: 
          localdqn.AHI = locala.KhF.xS();
          AppMethodBeat.o(125852);
          return 0;
        case 5: 
          localdqn.EGj = locala.KhF.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 6: 
          localdqn.isGame = locala.KhF.xS();
          AppMethodBeat.o(125852);
          return 0;
        case 7: 
          localdqn.dzY = locala.KhF.readString();
          AppMethodBeat.o(125852);
          return 0;
        }
        localdqn.subType = locala.KhF.xS();
        AppMethodBeat.o(125852);
        return 0;
      }
      AppMethodBeat.o(125852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqn
 * JD-Core Version:    0.7.0.1
 */