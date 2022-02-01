package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqg
  extends com.tencent.mm.bw.a
{
  public String DMY;
  public String Ffe;
  public String Ffi;
  public String nickname;
  public String oGh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190890);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ffi != null) {
        paramVarArgs.d(1, this.Ffi);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.oGh != null) {
        paramVarArgs.d(3, this.oGh);
      }
      if (this.Ffe != null) {
        paramVarArgs.d(4, this.Ffe);
      }
      if (this.DMY != null) {
        paramVarArgs.d(5, this.DMY);
      }
      AppMethodBeat.o(190890);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ffi == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.Ffi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.oGh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oGh);
      }
      paramInt = i;
      if (this.Ffe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ffe);
      }
      i = paramInt;
      if (this.DMY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DMY);
      }
      AppMethodBeat.o(190890);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(190890);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqg localbqg = (bqg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190890);
          return -1;
        case 1: 
          localbqg.Ffi = locala.LVo.readString();
          AppMethodBeat.o(190890);
          return 0;
        case 2: 
          localbqg.nickname = locala.LVo.readString();
          AppMethodBeat.o(190890);
          return 0;
        case 3: 
          localbqg.oGh = locala.LVo.readString();
          AppMethodBeat.o(190890);
          return 0;
        case 4: 
          localbqg.Ffe = locala.LVo.readString();
          AppMethodBeat.o(190890);
          return 0;
        }
        localbqg.DMY = locala.LVo.readString();
        AppMethodBeat.o(190890);
        return 0;
      }
      AppMethodBeat.o(190890);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqg
 * JD-Core Version:    0.7.0.1
 */