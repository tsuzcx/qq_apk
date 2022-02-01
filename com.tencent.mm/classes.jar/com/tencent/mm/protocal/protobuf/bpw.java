package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpw
  extends com.tencent.mm.bw.a
{
  public String ELg;
  public String Eof;
  public String Eog;
  public String ncR;
  public String ndW;
  public int ndj;
  public String wTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wTM != null) {
        paramVarArgs.d(1, this.wTM);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      paramVarArgs.aR(3, this.ndj);
      if (this.Eof != null) {
        paramVarArgs.d(4, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(5, this.Eog);
      }
      if (this.ndW != null) {
        paramVarArgs.d(6, this.ndW);
      }
      if (this.ELg != null) {
        paramVarArgs.d(7, this.ELg);
      }
      AppMethodBeat.o(155433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wTM == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.wTM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ncR);
      }
      i += f.a.a.b.b.a.bx(3, this.ndj);
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eog);
      }
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ndW);
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ELg);
      }
      AppMethodBeat.o(155433);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155433);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpw localbpw = (bpw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155433);
          return -1;
        case 1: 
          localbpw.wTM = locala.LVo.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 2: 
          localbpw.ncR = locala.LVo.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 3: 
          localbpw.ndj = locala.LVo.xF();
          AppMethodBeat.o(155433);
          return 0;
        case 4: 
          localbpw.Eof = locala.LVo.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 5: 
          localbpw.Eog = locala.LVo.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 6: 
          localbpw.ndW = locala.LVo.readString();
          AppMethodBeat.o(155433);
          return 0;
        }
        localbpw.ELg = locala.LVo.readString();
        AppMethodBeat.o(155433);
        return 0;
      }
      AppMethodBeat.o(155433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpw
 * JD-Core Version:    0.7.0.1
 */