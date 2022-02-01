package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class t
  extends com.tencent.mm.bw.a
{
  public String AOj;
  public String HEn;
  public String HEo;
  public String HEp;
  public int HFi;
  public int HFj;
  public long HFk;
  public String HFl;
  public String HFm;
  public String HFn;
  public double HFo;
  public double HFp;
  public int HFq;
  public String HFr;
  public String HFs;
  public LinkedList<b> HFt;
  
  public t()
  {
    AppMethodBeat.i(91304);
    this.HFt = new LinkedList();
    AppMethodBeat.o(91304);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91305);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.HFi);
      paramVarArgs.aM(2, this.HFj);
      paramVarArgs.bb(3, this.HFk);
      if (this.HFl != null) {
        paramVarArgs.e(4, this.HFl);
      }
      if (this.HEn != null) {
        paramVarArgs.e(5, this.HEn);
      }
      if (this.HFm != null) {
        paramVarArgs.e(6, this.HFm);
      }
      if (this.HFn != null) {
        paramVarArgs.e(7, this.HFn);
      }
      if (this.HEo != null) {
        paramVarArgs.e(8, this.HEo);
      }
      if (this.HEp != null) {
        paramVarArgs.e(9, this.HEp);
      }
      paramVarArgs.e(10, this.HFo);
      paramVarArgs.e(11, this.HFp);
      paramVarArgs.aM(12, this.HFq);
      if (this.HFr != null) {
        paramVarArgs.e(13, this.HFr);
      }
      if (this.AOj != null) {
        paramVarArgs.e(14, this.AOj);
      }
      if (this.HFs != null) {
        paramVarArgs.e(16, this.HFs);
      }
      paramVarArgs.e(17, 6, this.HFt);
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.HFi) + 0 + g.a.a.b.b.a.bu(2, this.HFj) + g.a.a.b.b.a.r(3, this.HFk);
      paramInt = i;
      if (this.HFl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HFl);
      }
      i = paramInt;
      if (this.HEn != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.HEn);
      }
      paramInt = i;
      if (this.HFm != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.HFm);
      }
      i = paramInt;
      if (this.HFn != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.HFn);
      }
      paramInt = i;
      if (this.HEo != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.HEo);
      }
      i = paramInt;
      if (this.HEp != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.HEp);
      }
      i = i + (g.a.a.b.b.a.fS(10) + 8) + (g.a.a.b.b.a.fS(11) + 8) + g.a.a.b.b.a.bu(12, this.HFq);
      paramInt = i;
      if (this.HFr != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.HFr);
      }
      i = paramInt;
      if (this.AOj != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.AOj);
      }
      paramInt = i;
      if (this.HFs != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.HFs);
      }
      i = g.a.a.a.c(17, 6, this.HFt);
      AppMethodBeat.o(91305);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HFt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      t localt = (t)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 15: 
      default: 
        AppMethodBeat.o(91305);
        return -1;
      case 1: 
        localt.HFi = locala.UbS.zi();
        AppMethodBeat.o(91305);
        return 0;
      case 2: 
        localt.HFj = locala.UbS.zi();
        AppMethodBeat.o(91305);
        return 0;
      case 3: 
        localt.HFk = locala.UbS.zl();
        AppMethodBeat.o(91305);
        return 0;
      case 4: 
        localt.HFl = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 5: 
        localt.HEn = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 6: 
        localt.HFm = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 7: 
        localt.HFn = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 8: 
        localt.HEo = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 9: 
        localt.HEp = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 10: 
        localt.HFo = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(91305);
        return 0;
      case 11: 
        localt.HFp = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(91305);
        return 0;
      case 12: 
        localt.HFq = locala.UbS.zi();
        AppMethodBeat.o(91305);
        return 0;
      case 13: 
        localt.HFr = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 14: 
        localt.AOj = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 16: 
        localt.HFs = locala.UbS.readString();
        AppMethodBeat.o(91305);
        return 0;
      }
      localt.HFt.add(locala.UbS.hPo());
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