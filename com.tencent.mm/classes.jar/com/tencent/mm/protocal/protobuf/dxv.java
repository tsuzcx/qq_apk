package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxv
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b DTb;
  public int Eck;
  public String FDc;
  public boolean Gec;
  public boolean Ged;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32564);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      paramVarArgs.aR(2, this.Eck);
      if (this.DTb != null) {
        paramVarArgs.c(3, this.DTb);
      }
      paramVarArgs.bl(4, this.Gec);
      paramVarArgs.bl(5, this.Ged);
      AppMethodBeat.o(32564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label465;
      }
    }
    label465:
    for (paramInt = f.a.a.b.b.a.e(1, this.FDc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Eck);
      paramInt = i;
      if (this.DTb != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.DTb);
      }
      i = f.a.a.b.b.a.fK(4);
      int j = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(32564);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FDc == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxv localdxv = (dxv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32564);
          return -1;
        case 1: 
          localdxv.FDc = locala.LVo.readString();
          AppMethodBeat.o(32564);
          return 0;
        case 2: 
          localdxv.Eck = locala.LVo.xF();
          AppMethodBeat.o(32564);
          return 0;
        case 3: 
          localdxv.DTb = locala.LVo.gfk();
          AppMethodBeat.o(32564);
          return 0;
        case 4: 
          localdxv.Gec = locala.LVo.fZX();
          AppMethodBeat.o(32564);
          return 0;
        }
        localdxv.Ged = locala.LVo.fZX();
        AppMethodBeat.o(32564);
        return 0;
      }
      AppMethodBeat.o(32564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxv
 * JD-Core Version:    0.7.0.1
 */