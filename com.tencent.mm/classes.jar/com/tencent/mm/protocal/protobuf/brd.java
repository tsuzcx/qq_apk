package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class brd
  extends com.tencent.mm.bw.a
{
  public String EFm;
  public float Eht;
  public float Ehu;
  public String Fgm;
  public int Fgn;
  public int Fgo;
  public b Fgp;
  public String Fgq;
  public float bOt;
  public String country;
  public String gPy;
  public String iJV;
  public int score;
  public String yAV;
  public int yAX;
  public int yAZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.Eht);
      paramVarArgs.x(2, this.Ehu);
      if (this.iJV != null) {
        paramVarArgs.d(3, this.iJV);
      }
      if (this.gPy != null) {
        paramVarArgs.d(4, this.gPy);
      }
      if (this.yAV != null) {
        paramVarArgs.d(5, this.yAV);
      }
      if (this.EFm != null) {
        paramVarArgs.d(6, this.EFm);
      }
      paramVarArgs.aR(7, this.yAX);
      if (this.Fgm != null) {
        paramVarArgs.d(8, this.Fgm);
      }
      paramVarArgs.aR(9, this.Fgn);
      paramVarArgs.aR(10, this.Fgo);
      paramVarArgs.aR(11, this.yAZ);
      paramVarArgs.x(12, this.bOt);
      if (this.Fgp != null) {
        paramVarArgs.c(13, this.Fgp);
      }
      paramVarArgs.aR(14, this.score);
      if (this.Fgq != null) {
        paramVarArgs.d(15, this.Fgq);
      }
      if (this.country != null) {
        paramVarArgs.d(16, this.country);
      }
      AppMethodBeat.o(125739);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 4 + 0 + (f.a.a.b.b.a.fK(2) + 4);
      paramInt = i;
      if (this.iJV != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.iJV);
      }
      i = paramInt;
      if (this.gPy != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.gPy);
      }
      paramInt = i;
      if (this.yAV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.yAV);
      }
      i = paramInt;
      if (this.EFm != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EFm);
      }
      i += f.a.a.b.b.a.bx(7, this.yAX);
      paramInt = i;
      if (this.Fgm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fgm);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.Fgn) + f.a.a.b.b.a.bx(10, this.Fgo) + f.a.a.b.b.a.bx(11, this.yAZ) + (f.a.a.b.b.a.fK(12) + 4);
      paramInt = i;
      if (this.Fgp != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.Fgp);
      }
      i = paramInt + f.a.a.b.b.a.bx(14, this.score);
      paramInt = i;
      if (this.Fgq != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Fgq);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.country);
      }
      AppMethodBeat.o(125739);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125739);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      brd localbrd = (brd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125739);
        return -1;
      case 1: 
        localbrd.Eht = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125739);
        return 0;
      case 2: 
        localbrd.Ehu = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125739);
        return 0;
      case 3: 
        localbrd.iJV = locala.LVo.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 4: 
        localbrd.gPy = locala.LVo.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 5: 
        localbrd.yAV = locala.LVo.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 6: 
        localbrd.EFm = locala.LVo.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 7: 
        localbrd.yAX = locala.LVo.xF();
        AppMethodBeat.o(125739);
        return 0;
      case 8: 
        localbrd.Fgm = locala.LVo.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 9: 
        localbrd.Fgn = locala.LVo.xF();
        AppMethodBeat.o(125739);
        return 0;
      case 10: 
        localbrd.Fgo = locala.LVo.xF();
        AppMethodBeat.o(125739);
        return 0;
      case 11: 
        localbrd.yAZ = locala.LVo.xF();
        AppMethodBeat.o(125739);
        return 0;
      case 12: 
        localbrd.bOt = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125739);
        return 0;
      case 13: 
        localbrd.Fgp = locala.LVo.gfk();
        AppMethodBeat.o(125739);
        return 0;
      case 14: 
        localbrd.score = locala.LVo.xF();
        AppMethodBeat.o(125739);
        return 0;
      case 15: 
        localbrd.Fgq = locala.LVo.readString();
        AppMethodBeat.o(125739);
        return 0;
      }
      localbrd.country = locala.LVo.readString();
      AppMethodBeat.o(125739);
      return 0;
    }
    AppMethodBeat.o(125739);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brd
 * JD-Core Version:    0.7.0.1
 */