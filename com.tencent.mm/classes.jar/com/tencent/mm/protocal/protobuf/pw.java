package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pw
  extends com.tencent.mm.bw.a
{
  public int Een;
  public String EgB;
  public String djj;
  public String nickname;
  public String ugE;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      if (this.ugE != null) {
        paramVarArgs.d(3, this.ugE);
      }
      if (this.nickname != null) {
        paramVarArgs.d(4, this.nickname);
      }
      paramVarArgs.aR(5, this.Een);
      if (this.EgB != null) {
        paramVarArgs.d(6, this.EgB);
      }
      paramVarArgs.aR(7, this.version);
      AppMethodBeat.o(56244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label546;
      }
    }
    label546:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.ugE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ugE);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nickname);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Een);
      paramInt = i;
      if (this.EgB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EgB);
      }
      i = f.a.a.b.b.a.bx(7, this.version);
      AppMethodBeat.o(56244);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(56244);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pw localpw = (pw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56244);
          return -1;
        case 1: 
          localpw.username = locala.LVo.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 2: 
          localpw.djj = locala.LVo.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 3: 
          localpw.ugE = locala.LVo.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 4: 
          localpw.nickname = locala.LVo.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 5: 
          localpw.Een = locala.LVo.xF();
          AppMethodBeat.o(56244);
          return 0;
        case 6: 
          localpw.EgB = locala.LVo.readString();
          AppMethodBeat.o(56244);
          return 0;
        }
        localpw.version = locala.LVo.xF();
        AppMethodBeat.o(56244);
        return 0;
      }
      AppMethodBeat.o(56244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pw
 * JD-Core Version:    0.7.0.1
 */