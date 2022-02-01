package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqa
  extends com.tencent.mm.bw.a
{
  public String Ecn;
  public String FXh;
  public String FXo;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209573);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FXh != null) {
        paramVarArgs.d(1, this.FXh);
      }
      if (this.Ecn != null) {
        paramVarArgs.d(2, this.Ecn);
      }
      if (this.FXo != null) {
        paramVarArgs.d(3, this.FXo);
      }
      paramVarArgs.aR(4, this.scene);
      AppMethodBeat.o(209573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FXh == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.FXh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ecn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ecn);
      }
      i = paramInt;
      if (this.FXo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FXo);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.scene);
      AppMethodBeat.o(209573);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(209573);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqa localdqa = (dqa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209573);
          return -1;
        case 1: 
          localdqa.FXh = locala.LVo.readString();
          AppMethodBeat.o(209573);
          return 0;
        case 2: 
          localdqa.Ecn = locala.LVo.readString();
          AppMethodBeat.o(209573);
          return 0;
        case 3: 
          localdqa.FXo = locala.LVo.readString();
          AppMethodBeat.o(209573);
          return 0;
        }
        localdqa.scene = locala.LVo.xF();
        AppMethodBeat.o(209573);
        return 0;
      }
      AppMethodBeat.o(209573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqa
 * JD-Core Version:    0.7.0.1
 */