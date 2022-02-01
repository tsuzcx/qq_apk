package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwe
  extends com.tencent.mm.bw.a
{
  public int BZZ;
  public String Gdv;
  public String dxK;
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
      paramVarArgs.aR(4, this.BZZ);
      if (this.Gdv != null) {
        paramVarArgs.d(5, this.Gdv);
      }
      paramVarArgs.aR(6, this.isGame);
      if (this.dxK != null) {
        paramVarArgs.d(7, this.dxK);
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
      i = i + f.a.a.b.b.a.bx(3, this.version) + f.a.a.b.b.a.bx(4, this.BZZ);
      paramInt = i;
      if (this.Gdv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gdv);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.isGame);
      paramInt = i;
      if (this.dxK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dxK);
      }
      i = f.a.a.b.b.a.bx(8, this.subType);
      AppMethodBeat.o(125852);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125852);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwe localdwe = (dwe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125852);
          return -1;
        case 1: 
          localdwe.username = locala.LVo.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 2: 
          localdwe.path = locala.LVo.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 3: 
          localdwe.version = locala.LVo.xF();
          AppMethodBeat.o(125852);
          return 0;
        case 4: 
          localdwe.BZZ = locala.LVo.xF();
          AppMethodBeat.o(125852);
          return 0;
        case 5: 
          localdwe.Gdv = locala.LVo.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 6: 
          localdwe.isGame = locala.LVo.xF();
          AppMethodBeat.o(125852);
          return 0;
        case 7: 
          localdwe.dxK = locala.LVo.readString();
          AppMethodBeat.o(125852);
          return 0;
        }
        localdwe.subType = locala.LVo.xF();
        AppMethodBeat.o(125852);
        return 0;
      }
      AppMethodBeat.o(125852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwe
 * JD-Core Version:    0.7.0.1
 */