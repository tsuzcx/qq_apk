package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bqj
  extends com.tencent.mm.bw.a
{
  public long DMV;
  public String Ffe;
  public int Ffq;
  public int Ffr;
  public int Ffs;
  public b Fft;
  public b Ffu;
  public b Ffv;
  public String Ffw;
  public long Ffx;
  public long Ffy;
  public String Ffz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ffq);
      if (this.Ffe != null) {
        paramVarArgs.d(2, this.Ffe);
      }
      paramVarArgs.aR(3, this.Ffr);
      paramVarArgs.aR(4, this.Ffs);
      if (this.Fft != null) {
        paramVarArgs.c(5, this.Fft);
      }
      if (this.Ffu != null) {
        paramVarArgs.c(6, this.Ffu);
      }
      if (this.Ffv != null) {
        paramVarArgs.c(7, this.Ffv);
      }
      if (this.Ffw != null) {
        paramVarArgs.d(8, this.Ffw);
      }
      paramVarArgs.aO(9, this.Ffx);
      paramVarArgs.aO(10, this.Ffy);
      paramVarArgs.aO(11, this.DMV);
      if (this.Ffz != null) {
        paramVarArgs.d(12, this.Ffz);
      }
      AppMethodBeat.o(190893);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ffq) + 0;
      paramInt = i;
      if (this.Ffe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ffe);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.Ffr) + f.a.a.b.b.a.bx(4, this.Ffs);
      paramInt = i;
      if (this.Fft != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Fft);
      }
      i = paramInt;
      if (this.Ffu != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.Ffu);
      }
      paramInt = i;
      if (this.Ffv != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.Ffv);
      }
      i = paramInt;
      if (this.Ffw != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Ffw);
      }
      i = i + f.a.a.b.b.a.p(9, this.Ffx) + f.a.a.b.b.a.p(10, this.Ffy) + f.a.a.b.b.a.p(11, this.DMV);
      paramInt = i;
      if (this.Ffz != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Ffz);
      }
      AppMethodBeat.o(190893);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(190893);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bqj localbqj = (bqj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(190893);
        return -1;
      case 1: 
        localbqj.Ffq = locala.LVo.xF();
        AppMethodBeat.o(190893);
        return 0;
      case 2: 
        localbqj.Ffe = locala.LVo.readString();
        AppMethodBeat.o(190893);
        return 0;
      case 3: 
        localbqj.Ffr = locala.LVo.xF();
        AppMethodBeat.o(190893);
        return 0;
      case 4: 
        localbqj.Ffs = locala.LVo.xF();
        AppMethodBeat.o(190893);
        return 0;
      case 5: 
        localbqj.Fft = locala.LVo.gfk();
        AppMethodBeat.o(190893);
        return 0;
      case 6: 
        localbqj.Ffu = locala.LVo.gfk();
        AppMethodBeat.o(190893);
        return 0;
      case 7: 
        localbqj.Ffv = locala.LVo.gfk();
        AppMethodBeat.o(190893);
        return 0;
      case 8: 
        localbqj.Ffw = locala.LVo.readString();
        AppMethodBeat.o(190893);
        return 0;
      case 9: 
        localbqj.Ffx = locala.LVo.xG();
        AppMethodBeat.o(190893);
        return 0;
      case 10: 
        localbqj.Ffy = locala.LVo.xG();
        AppMethodBeat.o(190893);
        return 0;
      case 11: 
        localbqj.DMV = locala.LVo.xG();
        AppMethodBeat.o(190893);
        return 0;
      }
      localbqj.Ffz = locala.LVo.readString();
      AppMethodBeat.o(190893);
      return 0;
    }
    AppMethodBeat.o(190893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqj
 * JD-Core Version:    0.7.0.1
 */