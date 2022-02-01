package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzg
  extends com.tencent.mm.bw.a
{
  public int Eae;
  public String FrN;
  public String Gfx;
  public String IconUrl;
  public String fZx;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FrN != null) {
        paramVarArgs.d(1, this.FrN);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(3, this.ndW);
      }
      if (this.fZx != null) {
        paramVarArgs.d(4, this.fZx);
      }
      paramVarArgs.aR(5, this.Eae);
      if (this.Gfx != null) {
        paramVarArgs.d(6, this.Gfx);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FrN == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.FrN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ndW);
      }
      paramInt = i;
      if (this.fZx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fZx);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Eae);
      paramInt = i;
      if (this.Gfx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gfx);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117957);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzg localdzg = (dzg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117957);
          return -1;
        case 1: 
          localdzg.FrN = locala.LVo.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 2: 
          localdzg.ncR = locala.LVo.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 3: 
          localdzg.ndW = locala.LVo.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 4: 
          localdzg.fZx = locala.LVo.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 5: 
          localdzg.Eae = locala.LVo.xF();
          AppMethodBeat.o(117957);
          return 0;
        case 6: 
          localdzg.Gfx = locala.LVo.readString();
          AppMethodBeat.o(117957);
          return 0;
        }
        localdzg.IconUrl = locala.LVo.readString();
        AppMethodBeat.o(117957);
        return 0;
      }
      AppMethodBeat.o(117957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzg
 * JD-Core Version:    0.7.0.1
 */