package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxv
  extends com.tencent.mm.bw.a
{
  public String DMk;
  public String DMl;
  public int DMm;
  public String DSo;
  public String dvO;
  public String dvP;
  public String nUr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114073);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvO != null) {
        paramVarArgs.d(1, this.dvO);
      }
      if (this.nUr != null) {
        paramVarArgs.d(2, this.nUr);
      }
      if (this.dvP != null) {
        paramVarArgs.d(3, this.dvP);
      }
      if (this.DMk != null) {
        paramVarArgs.d(4, this.DMk);
      }
      if (this.DMl != null) {
        paramVarArgs.d(5, this.DMl);
      }
      paramVarArgs.aR(6, this.DMm);
      if (this.DSo != null) {
        paramVarArgs.d(7, this.DSo);
      }
      AppMethodBeat.o(114073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvO == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.dvO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nUr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nUr);
      }
      i = paramInt;
      if (this.dvP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dvP);
      }
      paramInt = i;
      if (this.DMk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DMk);
      }
      i = paramInt;
      if (this.DMl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DMl);
      }
      i += f.a.a.b.b.a.bx(6, this.DMm);
      paramInt = i;
      if (this.DSo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DSo);
      }
      AppMethodBeat.o(114073);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114073);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cxv localcxv = (cxv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114073);
          return -1;
        case 1: 
          localcxv.dvO = locala.LVo.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 2: 
          localcxv.nUr = locala.LVo.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 3: 
          localcxv.dvP = locala.LVo.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 4: 
          localcxv.DMk = locala.LVo.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 5: 
          localcxv.DMl = locala.LVo.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 6: 
          localcxv.DMm = locala.LVo.xF();
          AppMethodBeat.o(114073);
          return 0;
        }
        localcxv.DSo = locala.LVo.readString();
        AppMethodBeat.o(114073);
        return 0;
      }
      AppMethodBeat.o(114073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxv
 * JD-Core Version:    0.7.0.1
 */