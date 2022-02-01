package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxj
  extends com.tencent.mm.bw.a
{
  public int Eeo;
  public String Fmg;
  public String Fmh;
  public String path;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123630);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.Fmg != null) {
        paramVarArgs.d(2, this.Fmg);
      }
      if (this.Fmh != null) {
        paramVarArgs.d(3, this.Fmh);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.aR(5, this.Eeo);
      paramVarArgs.aR(6, this.type);
      AppMethodBeat.o(123630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fmg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fmg);
      }
      i = paramInt;
      if (this.Fmh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fmh);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = f.a.a.b.b.a.bx(5, this.Eeo);
      int j = f.a.a.b.b.a.bx(6, this.type);
      AppMethodBeat.o(123630);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123630);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxj localbxj = (bxj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123630);
          return -1;
        case 1: 
          localbxj.username = locala.LVo.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 2: 
          localbxj.Fmg = locala.LVo.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 3: 
          localbxj.Fmh = locala.LVo.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 4: 
          localbxj.path = locala.LVo.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 5: 
          localbxj.Eeo = locala.LVo.xF();
          AppMethodBeat.o(123630);
          return 0;
        }
        localbxj.type = locala.LVo.xF();
        AppMethodBeat.o(123630);
        return 0;
      }
      AppMethodBeat.o(123630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxj
 * JD-Core Version:    0.7.0.1
 */