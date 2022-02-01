package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class t
  extends com.tencent.mm.cd.a
{
  public String GHx;
  public String Owg;
  public String Owh;
  public String Owi;
  public int Oxb;
  public int Oxc;
  public long Oxd;
  public String Oxe;
  public String Oxf;
  public String Oxg;
  public double Oxh;
  public double Oxi;
  public int Oxj;
  public String Oxk;
  public String Oxl;
  public LinkedList<b> Oxm;
  
  public t()
  {
    AppMethodBeat.i(91304);
    this.Oxm = new LinkedList();
    AppMethodBeat.o(91304);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91305);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Oxb);
      paramVarArgs.aY(2, this.Oxc);
      paramVarArgs.bm(3, this.Oxd);
      if (this.Oxe != null) {
        paramVarArgs.f(4, this.Oxe);
      }
      if (this.Owg != null) {
        paramVarArgs.f(5, this.Owg);
      }
      if (this.Oxf != null) {
        paramVarArgs.f(6, this.Oxf);
      }
      if (this.Oxg != null) {
        paramVarArgs.f(7, this.Oxg);
      }
      if (this.Owh != null) {
        paramVarArgs.f(8, this.Owh);
      }
      if (this.Owi != null) {
        paramVarArgs.f(9, this.Owi);
      }
      paramVarArgs.e(10, this.Oxh);
      paramVarArgs.e(11, this.Oxi);
      paramVarArgs.aY(12, this.Oxj);
      if (this.Oxk != null) {
        paramVarArgs.f(13, this.Oxk);
      }
      if (this.GHx != null) {
        paramVarArgs.f(14, this.GHx);
      }
      if (this.Oxl != null) {
        paramVarArgs.f(16, this.Oxl);
      }
      paramVarArgs.e(17, 6, this.Oxm);
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Oxb) + 0 + g.a.a.b.b.a.bM(2, this.Oxc) + g.a.a.b.b.a.p(3, this.Oxd);
      paramInt = i;
      if (this.Oxe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Oxe);
      }
      i = paramInt;
      if (this.Owg != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Owg);
      }
      paramInt = i;
      if (this.Oxf != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Oxf);
      }
      i = paramInt;
      if (this.Oxg != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Oxg);
      }
      paramInt = i;
      if (this.Owh != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Owh);
      }
      i = paramInt;
      if (this.Owi != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Owi);
      }
      i = i + (g.a.a.b.b.a.gL(10) + 8) + (g.a.a.b.b.a.gL(11) + 8) + g.a.a.b.b.a.bM(12, this.Oxj);
      paramInt = i;
      if (this.Oxk != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Oxk);
      }
      i = paramInt;
      if (this.GHx != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.GHx);
      }
      paramInt = i;
      if (this.Oxl != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Oxl);
      }
      i = g.a.a.a.c(17, 6, this.Oxm);
      AppMethodBeat.o(91305);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Oxm.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
        localt.Oxb = locala.abFh.AK();
        AppMethodBeat.o(91305);
        return 0;
      case 2: 
        localt.Oxc = locala.abFh.AK();
        AppMethodBeat.o(91305);
        return 0;
      case 3: 
        localt.Oxd = locala.abFh.AN();
        AppMethodBeat.o(91305);
        return 0;
      case 4: 
        localt.Oxe = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 5: 
        localt.Owg = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 6: 
        localt.Oxf = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 7: 
        localt.Oxg = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 8: 
        localt.Owh = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 9: 
        localt.Owi = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 10: 
        localt.Oxh = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(91305);
        return 0;
      case 11: 
        localt.Oxi = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(91305);
        return 0;
      case 12: 
        localt.Oxj = locala.abFh.AK();
        AppMethodBeat.o(91305);
        return 0;
      case 13: 
        localt.Oxk = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 14: 
        localt.GHx = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 16: 
        localt.Oxl = locala.abFh.readString();
        AppMethodBeat.o(91305);
        return 0;
      }
      localt.Oxm.add(locala.abFh.iUw());
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