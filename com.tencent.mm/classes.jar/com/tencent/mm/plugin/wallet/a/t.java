package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class t
  extends com.tencent.mm.bv.a
{
  public String ppn;
  public String tTZ;
  public int tUU;
  public int tUV;
  public long tUW;
  public String tUX;
  public String tUY;
  public String tUZ;
  public String tUa;
  public String tUb;
  public double tVa;
  public double tVb;
  public int tVc;
  public String tVd;
  public String tVe;
  public LinkedList<b> tVf;
  
  public t()
  {
    AppMethodBeat.i(56661);
    this.tVf = new LinkedList();
    AppMethodBeat.o(56661);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56662);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.tUU);
      paramVarArgs.aO(2, this.tUV);
      paramVarArgs.am(3, this.tUW);
      if (this.tUX != null) {
        paramVarArgs.e(4, this.tUX);
      }
      if (this.tTZ != null) {
        paramVarArgs.e(5, this.tTZ);
      }
      if (this.tUY != null) {
        paramVarArgs.e(6, this.tUY);
      }
      if (this.tUZ != null) {
        paramVarArgs.e(7, this.tUZ);
      }
      if (this.tUa != null) {
        paramVarArgs.e(8, this.tUa);
      }
      if (this.tUb != null) {
        paramVarArgs.e(9, this.tUb);
      }
      paramVarArgs.f(10, this.tVa);
      paramVarArgs.f(11, this.tVb);
      paramVarArgs.aO(12, this.tVc);
      if (this.tVd != null) {
        paramVarArgs.e(13, this.tVd);
      }
      if (this.ppn != null) {
        paramVarArgs.e(14, this.ppn);
      }
      if (this.tVe != null) {
        paramVarArgs.e(16, this.tVe);
      }
      paramVarArgs.e(17, 6, this.tVf);
      AppMethodBeat.o(56662);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.tUU) + 0 + e.a.a.b.b.a.bl(2, this.tUV) + e.a.a.b.b.a.p(3, this.tUW);
      paramInt = i;
      if (this.tUX != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.tUX);
      }
      i = paramInt;
      if (this.tTZ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.tTZ);
      }
      paramInt = i;
      if (this.tUY != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.tUY);
      }
      i = paramInt;
      if (this.tUZ != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.tUZ);
      }
      paramInt = i;
      if (this.tUa != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.tUa);
      }
      i = paramInt;
      if (this.tUb != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.tUb);
      }
      i = i + (e.a.a.b.b.a.eW(10) + 8) + (e.a.a.b.b.a.eW(11) + 8) + e.a.a.b.b.a.bl(12, this.tVc);
      paramInt = i;
      if (this.tVd != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.tVd);
      }
      i = paramInt;
      if (this.ppn != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.ppn);
      }
      paramInt = i;
      if (this.tVe != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.tVe);
      }
      i = e.a.a.a.c(17, 6, this.tVf);
      AppMethodBeat.o(56662);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tVf.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56662);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      t localt = (t)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 15: 
      default: 
        AppMethodBeat.o(56662);
        return -1;
      case 1: 
        localt.tUU = locala.CLY.sl();
        AppMethodBeat.o(56662);
        return 0;
      case 2: 
        localt.tUV = locala.CLY.sl();
        AppMethodBeat.o(56662);
        return 0;
      case 3: 
        localt.tUW = locala.CLY.sm();
        AppMethodBeat.o(56662);
        return 0;
      case 4: 
        localt.tUX = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      case 5: 
        localt.tTZ = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      case 6: 
        localt.tUY = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      case 7: 
        localt.tUZ = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      case 8: 
        localt.tUa = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      case 9: 
        localt.tUb = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      case 10: 
        localt.tVa = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(56662);
        return 0;
      case 11: 
        localt.tVb = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(56662);
        return 0;
      case 12: 
        localt.tVc = locala.CLY.sl();
        AppMethodBeat.o(56662);
        return 0;
      case 13: 
        localt.tVd = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      case 14: 
        localt.ppn = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      case 16: 
        localt.tVe = locala.CLY.readString();
        AppMethodBeat.o(56662);
        return 0;
      }
      localt.tVf.add(locala.CLY.eqS());
      AppMethodBeat.o(56662);
      return 0;
    }
    AppMethodBeat.o(56662);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.t
 * JD-Core Version:    0.7.0.1
 */