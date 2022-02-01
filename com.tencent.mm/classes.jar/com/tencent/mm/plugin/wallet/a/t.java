package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class t
  extends com.tencent.mm.bx.a
{
  public String uon;
  public String zOl;
  public String zOm;
  public String zOn;
  public int zPg;
  public int zPh;
  public long zPi;
  public String zPj;
  public String zPk;
  public String zPl;
  public double zPm;
  public double zPn;
  public int zPo;
  public String zPp;
  public String zPq;
  public LinkedList<b> zPr;
  
  public t()
  {
    AppMethodBeat.i(91304);
    this.zPr = new LinkedList();
    AppMethodBeat.o(91304);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.zPg);
      paramVarArgs.aR(2, this.zPh);
      paramVarArgs.aG(3, this.zPi);
      if (this.zPj != null) {
        paramVarArgs.d(4, this.zPj);
      }
      if (this.zOl != null) {
        paramVarArgs.d(5, this.zOl);
      }
      if (this.zPk != null) {
        paramVarArgs.d(6, this.zPk);
      }
      if (this.zPl != null) {
        paramVarArgs.d(7, this.zPl);
      }
      if (this.zOm != null) {
        paramVarArgs.d(8, this.zOm);
      }
      if (this.zOn != null) {
        paramVarArgs.d(9, this.zOn);
      }
      paramVarArgs.e(10, this.zPm);
      paramVarArgs.e(11, this.zPn);
      paramVarArgs.aR(12, this.zPo);
      if (this.zPp != null) {
        paramVarArgs.d(13, this.zPp);
      }
      if (this.uon != null) {
        paramVarArgs.d(14, this.uon);
      }
      if (this.zPq != null) {
        paramVarArgs.d(16, this.zPq);
      }
      paramVarArgs.e(17, 6, this.zPr);
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.zPg) + 0 + f.a.a.b.b.a.bA(2, this.zPh) + f.a.a.b.b.a.q(3, this.zPi);
      paramInt = i;
      if (this.zPj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zPj);
      }
      i = paramInt;
      if (this.zOl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.zOl);
      }
      paramInt = i;
      if (this.zPk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.zPk);
      }
      i = paramInt;
      if (this.zPl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.zPl);
      }
      paramInt = i;
      if (this.zOm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.zOm);
      }
      i = paramInt;
      if (this.zOn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.zOn);
      }
      i = i + (f.a.a.b.b.a.fY(10) + 8) + (f.a.a.b.b.a.fY(11) + 8) + f.a.a.b.b.a.bA(12, this.zPo);
      paramInt = i;
      if (this.zPp != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.zPp);
      }
      i = paramInt;
      if (this.uon != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.uon);
      }
      paramInt = i;
      if (this.zPq != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.zPq);
      }
      i = f.a.a.a.c(17, 6, this.zPr);
      AppMethodBeat.o(91305);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.zPr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      t localt = (t)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 15: 
      default: 
        AppMethodBeat.o(91305);
        return -1;
      case 1: 
        localt.zPg = locala.KhF.xS();
        AppMethodBeat.o(91305);
        return 0;
      case 2: 
        localt.zPh = locala.KhF.xS();
        AppMethodBeat.o(91305);
        return 0;
      case 3: 
        localt.zPi = locala.KhF.xT();
        AppMethodBeat.o(91305);
        return 0;
      case 4: 
        localt.zPj = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 5: 
        localt.zOl = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 6: 
        localt.zPk = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 7: 
        localt.zPl = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 8: 
        localt.zOm = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 9: 
        localt.zOn = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 10: 
        localt.zPm = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(91305);
        return 0;
      case 11: 
        localt.zPn = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(91305);
        return 0;
      case 12: 
        localt.zPo = locala.KhF.xS();
        AppMethodBeat.o(91305);
        return 0;
      case 13: 
        localt.zPp = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 14: 
        localt.uon = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 16: 
        localt.zPq = locala.KhF.readString();
        AppMethodBeat.o(91305);
        return 0;
      }
      localt.zPr.add(locala.KhF.fMu());
      AppMethodBeat.o(91305);
      return 0;
    }
    AppMethodBeat.o(91305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.t
 * JD-Core Version:    0.7.0.1
 */