package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpd
  extends com.tencent.mm.bw.a
{
  public String ELg;
  public String Eof;
  public String Eog;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.Eof != null) {
        paramVarArgs.d(3, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(4, this.Eog);
      }
      if (this.ELg != null) {
        paramVarArgs.d(5, this.ELg);
      }
      AppMethodBeat.o(138178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.ncR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.Eof != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eof);
      }
      paramInt = i;
      if (this.Eog != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eog);
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ELg);
      }
      AppMethodBeat.o(138178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(138178);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpd localbpd = (bpd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138178);
          return -1;
        case 1: 
          localbpd.ncR = locala.LVo.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 2: 
          localbpd.ndW = locala.LVo.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 3: 
          localbpd.Eof = locala.LVo.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 4: 
          localbpd.Eog = locala.LVo.readString();
          AppMethodBeat.o(138178);
          return 0;
        }
        localbpd.ELg = locala.LVo.readString();
        AppMethodBeat.o(138178);
        return 0;
      }
      AppMethodBeat.o(138178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpd
 * JD-Core Version:    0.7.0.1
 */