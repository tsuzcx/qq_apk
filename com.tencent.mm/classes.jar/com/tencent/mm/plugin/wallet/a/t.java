package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class t
  extends com.tencent.mm.bw.a
{
  public String CYA;
  public String CYB;
  public String CYz;
  public double CZA;
  public double CZB;
  public int CZC;
  public String CZD;
  public String CZE;
  public LinkedList<b> CZF;
  public int CZu;
  public int CZv;
  public long CZw;
  public String CZx;
  public String CZy;
  public String CZz;
  public String wSo;
  
  public t()
  {
    AppMethodBeat.i(91304);
    this.CZF = new LinkedList();
    AppMethodBeat.o(91304);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.CZu);
      paramVarArgs.aS(2, this.CZv);
      paramVarArgs.aZ(3, this.CZw);
      if (this.CZx != null) {
        paramVarArgs.d(4, this.CZx);
      }
      if (this.CYz != null) {
        paramVarArgs.d(5, this.CYz);
      }
      if (this.CZy != null) {
        paramVarArgs.d(6, this.CZy);
      }
      if (this.CZz != null) {
        paramVarArgs.d(7, this.CZz);
      }
      if (this.CYA != null) {
        paramVarArgs.d(8, this.CYA);
      }
      if (this.CYB != null) {
        paramVarArgs.d(9, this.CYB);
      }
      paramVarArgs.e(10, this.CZA);
      paramVarArgs.e(11, this.CZB);
      paramVarArgs.aS(12, this.CZC);
      if (this.CZD != null) {
        paramVarArgs.d(13, this.CZD);
      }
      if (this.wSo != null) {
        paramVarArgs.d(14, this.wSo);
      }
      if (this.CZE != null) {
        paramVarArgs.d(16, this.CZE);
      }
      paramVarArgs.e(17, 6, this.CZF);
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.CZu) + 0 + f.a.a.b.b.a.bz(2, this.CZv) + f.a.a.b.b.a.p(3, this.CZw);
      paramInt = i;
      if (this.CZx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CZx);
      }
      i = paramInt;
      if (this.CYz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CYz);
      }
      paramInt = i;
      if (this.CZy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CZy);
      }
      i = paramInt;
      if (this.CZz != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CZz);
      }
      paramInt = i;
      if (this.CYA != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CYA);
      }
      i = paramInt;
      if (this.CYB != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CYB);
      }
      i = i + f.a.a.b.b.a.amD(10) + f.a.a.b.b.a.amD(11) + f.a.a.b.b.a.bz(12, this.CZC);
      paramInt = i;
      if (this.CZD != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CZD);
      }
      i = paramInt;
      if (this.wSo != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.wSo);
      }
      paramInt = i;
      if (this.CZE != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CZE);
      }
      i = f.a.a.a.c(17, 6, this.CZF);
      AppMethodBeat.o(91305);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CZF.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localt.CZu = locala.OmT.zc();
        AppMethodBeat.o(91305);
        return 0;
      case 2: 
        localt.CZv = locala.OmT.zc();
        AppMethodBeat.o(91305);
        return 0;
      case 3: 
        localt.CZw = locala.OmT.zd();
        AppMethodBeat.o(91305);
        return 0;
      case 4: 
        localt.CZx = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 5: 
        localt.CYz = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 6: 
        localt.CZy = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 7: 
        localt.CZz = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 8: 
        localt.CYA = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 9: 
        localt.CYB = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 10: 
        localt.CZA = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(91305);
        return 0;
      case 11: 
        localt.CZB = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(91305);
        return 0;
      case 12: 
        localt.CZC = locala.OmT.zc();
        AppMethodBeat.o(91305);
        return 0;
      case 13: 
        localt.CZD = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 14: 
        localt.wSo = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 16: 
        localt.CZE = locala.OmT.readString();
        AppMethodBeat.o(91305);
        return 0;
      }
      localt.CZF.add(locala.OmT.gCk());
      AppMethodBeat.o(91305);
      return 0;
    }
    AppMethodBeat.o(91305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.t
 * JD-Core Version:    0.7.0.1
 */