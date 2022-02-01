package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eay
  extends com.tencent.mm.bw.a
{
  public int Eeo;
  public String Fmg;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.Fmg != null) {
        paramVarArgs.d(2, this.Fmg);
      }
      paramVarArgs.aR(3, this.Eeo);
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(123705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fmg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fmg);
      }
      i += f.a.a.b.b.a.bx(3, this.Eeo);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      AppMethodBeat.o(123705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123705);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eay localeay = (eay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123705);
          return -1;
        case 1: 
          localeay.username = locala.LVo.readString();
          AppMethodBeat.o(123705);
          return 0;
        case 2: 
          localeay.Fmg = locala.LVo.readString();
          AppMethodBeat.o(123705);
          return 0;
        case 3: 
          localeay.Eeo = locala.LVo.xF();
          AppMethodBeat.o(123705);
          return 0;
        }
        localeay.path = locala.LVo.readString();
        AppMethodBeat.o(123705);
        return 0;
      }
      AppMethodBeat.o(123705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eay
 * JD-Core Version:    0.7.0.1
 */