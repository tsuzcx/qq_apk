package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btb
  extends com.tencent.mm.bw.a
{
  public String Fif;
  public String Fig;
  public String Fih;
  public String hld;
  public String hlf;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103209);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.hlf != null) {
        paramVarArgs.d(2, this.hlf);
      }
      if (this.hld != null) {
        paramVarArgs.d(3, this.hld);
      }
      if (this.Fif != null) {
        paramVarArgs.d(4, this.Fif);
      }
      if (this.Fig != null) {
        paramVarArgs.d(5, this.Fig);
      }
      if (this.Fih != null) {
        paramVarArgs.d(6, this.Fih);
      }
      AppMethodBeat.o(103209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hlf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hlf);
      }
      i = paramInt;
      if (this.hld != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hld);
      }
      paramInt = i;
      if (this.Fif != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fif);
      }
      i = paramInt;
      if (this.Fig != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fig);
      }
      paramInt = i;
      if (this.Fih != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fih);
      }
      AppMethodBeat.o(103209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103209);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        btb localbtb = (btb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103209);
          return -1;
        case 1: 
          localbtb.title = locala.LVo.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 2: 
          localbtb.hlf = locala.LVo.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 3: 
          localbtb.hld = locala.LVo.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 4: 
          localbtb.Fif = locala.LVo.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 5: 
          localbtb.Fig = locala.LVo.readString();
          AppMethodBeat.o(103209);
          return 0;
        }
        localbtb.Fih = locala.LVo.readString();
        AppMethodBeat.o(103209);
        return 0;
      }
      AppMethodBeat.o(103209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btb
 * JD-Core Version:    0.7.0.1
 */