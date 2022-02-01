package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class t
  extends com.tencent.mm.bx.a
{
  public String CGT;
  public String CGU;
  public String CGV;
  public int CHO;
  public int CHP;
  public long CHQ;
  public String CHR;
  public String CHS;
  public String CHT;
  public double CHU;
  public double CHV;
  public int CHW;
  public String CHX;
  public String CHY;
  public LinkedList<b> CHZ;
  public String wCD;
  
  public t()
  {
    AppMethodBeat.i(91304);
    this.CHZ = new LinkedList();
    AppMethodBeat.o(91304);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.CHO);
      paramVarArgs.aS(2, this.CHP);
      paramVarArgs.aY(3, this.CHQ);
      if (this.CHR != null) {
        paramVarArgs.d(4, this.CHR);
      }
      if (this.CGT != null) {
        paramVarArgs.d(5, this.CGT);
      }
      if (this.CHS != null) {
        paramVarArgs.d(6, this.CHS);
      }
      if (this.CHT != null) {
        paramVarArgs.d(7, this.CHT);
      }
      if (this.CGU != null) {
        paramVarArgs.d(8, this.CGU);
      }
      if (this.CGV != null) {
        paramVarArgs.d(9, this.CGV);
      }
      paramVarArgs.e(10, this.CHU);
      paramVarArgs.e(11, this.CHV);
      paramVarArgs.aS(12, this.CHW);
      if (this.CHX != null) {
        paramVarArgs.d(13, this.CHX);
      }
      if (this.wCD != null) {
        paramVarArgs.d(14, this.wCD);
      }
      if (this.CHY != null) {
        paramVarArgs.d(16, this.CHY);
      }
      paramVarArgs.e(17, 6, this.CHZ);
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.CHO) + 0 + f.a.a.b.b.a.bz(2, this.CHP) + f.a.a.b.b.a.p(3, this.CHQ);
      paramInt = i;
      if (this.CHR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CHR);
      }
      i = paramInt;
      if (this.CGT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CGT);
      }
      paramInt = i;
      if (this.CHS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CHS);
      }
      i = paramInt;
      if (this.CHT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CHT);
      }
      paramInt = i;
      if (this.CGU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CGU);
      }
      i = paramInt;
      if (this.CGV != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CGV);
      }
      i = i + f.a.a.b.b.a.alT(10) + f.a.a.b.b.a.alT(11) + f.a.a.b.b.a.bz(12, this.CHW);
      paramInt = i;
      if (this.CHX != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CHX);
      }
      i = paramInt;
      if (this.wCD != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.wCD);
      }
      paramInt = i;
      if (this.CHY != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CHY);
      }
      i = f.a.a.a.c(17, 6, this.CHZ);
      AppMethodBeat.o(91305);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CHZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localt.CHO = locala.NPN.zc();
        AppMethodBeat.o(91305);
        return 0;
      case 2: 
        localt.CHP = locala.NPN.zc();
        AppMethodBeat.o(91305);
        return 0;
      case 3: 
        localt.CHQ = locala.NPN.zd();
        AppMethodBeat.o(91305);
        return 0;
      case 4: 
        localt.CHR = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 5: 
        localt.CGT = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 6: 
        localt.CHS = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 7: 
        localt.CHT = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 8: 
        localt.CGU = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 9: 
        localt.CGV = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 10: 
        localt.CHU = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(91305);
        return 0;
      case 11: 
        localt.CHV = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(91305);
        return 0;
      case 12: 
        localt.CHW = locala.NPN.zc();
        AppMethodBeat.o(91305);
        return 0;
      case 13: 
        localt.CHX = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 14: 
        localt.wCD = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 16: 
        localt.CHY = locala.NPN.readString();
        AppMethodBeat.o(91305);
        return 0;
      }
      localt.CHZ.add(locala.NPN.gxI());
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