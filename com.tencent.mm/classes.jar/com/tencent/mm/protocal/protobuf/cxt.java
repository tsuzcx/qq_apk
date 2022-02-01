package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cxt
  extends com.tencent.mm.bw.a
{
  public String AAN;
  public double KUt;
  public double KUu;
  public String LpJ;
  public String LpK;
  public String MCE;
  public String MCF;
  public String MCG;
  public String MCH;
  public String Name;
  public String kdZ;
  public String kea;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.MCE != null) {
        paramVarArgs.e(2, this.MCE);
      }
      paramVarArgs.e(3, this.KUt);
      paramVarArgs.e(4, this.KUu);
      if (this.MCF != null) {
        paramVarArgs.e(5, this.MCF);
      }
      if (this.AAN != null) {
        paramVarArgs.e(6, this.AAN);
      }
      if (this.MCG != null) {
        paramVarArgs.e(7, this.MCG);
      }
      if (this.kdZ != null) {
        paramVarArgs.e(8, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(9, this.kea);
      }
      if (this.LpJ != null) {
        paramVarArgs.e(10, this.LpJ);
      }
      if (this.LpK != null) {
        paramVarArgs.e(11, this.LpK);
      }
      if (this.MCH != null) {
        paramVarArgs.e(12, this.MCH);
      }
      AppMethodBeat.o(56257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label860;
      }
    }
    label860:
    for (paramInt = g.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MCE != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MCE);
      }
      i = i + (g.a.a.b.b.a.fS(3) + 8) + (g.a.a.b.b.a.fS(4) + 8);
      paramInt = i;
      if (this.MCF != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MCF);
      }
      i = paramInt;
      if (this.AAN != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.AAN);
      }
      paramInt = i;
      if (this.MCG != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MCG);
      }
      i = paramInt;
      if (this.kdZ != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.kdZ);
      }
      paramInt = i;
      if (this.kea != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.kea);
      }
      i = paramInt;
      if (this.LpJ != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LpJ);
      }
      paramInt = i;
      if (this.LpK != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LpK);
      }
      i = paramInt;
      if (this.MCH != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MCH);
      }
      AppMethodBeat.o(56257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(56257);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxt localcxt = (cxt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56257);
          return -1;
        case 1: 
          localcxt.Name = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 2: 
          localcxt.MCE = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 3: 
          localcxt.KUt = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(56257);
          return 0;
        case 4: 
          localcxt.KUu = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(56257);
          return 0;
        case 5: 
          localcxt.MCF = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 6: 
          localcxt.AAN = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 7: 
          localcxt.MCG = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 8: 
          localcxt.kdZ = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 9: 
          localcxt.kea = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 10: 
          localcxt.LpJ = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 11: 
          localcxt.LpK = locala.UbS.readString();
          AppMethodBeat.o(56257);
          return 0;
        }
        localcxt.MCH = locala.UbS.readString();
        AppMethodBeat.o(56257);
        return 0;
      }
      AppMethodBeat.o(56257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxt
 * JD-Core Version:    0.7.0.1
 */