package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cgs
  extends com.tencent.mm.bx.a
{
  public double FIb;
  public double FIc;
  public String GbA;
  public String GbB;
  public String Hag;
  public String Hah;
  public String Hai;
  public String Haj;
  public String Name;
  public String jdd;
  public String jde;
  public String wpT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.Hag != null) {
        paramVarArgs.d(2, this.Hag);
      }
      paramVarArgs.e(3, this.FIb);
      paramVarArgs.e(4, this.FIc);
      if (this.Hah != null) {
        paramVarArgs.d(5, this.Hah);
      }
      if (this.wpT != null) {
        paramVarArgs.d(6, this.wpT);
      }
      if (this.Hai != null) {
        paramVarArgs.d(7, this.Hai);
      }
      if (this.jdd != null) {
        paramVarArgs.d(8, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(9, this.jde);
      }
      if (this.GbA != null) {
        paramVarArgs.d(10, this.GbA);
      }
      if (this.GbB != null) {
        paramVarArgs.d(11, this.GbB);
      }
      if (this.Haj != null) {
        paramVarArgs.d(12, this.Haj);
      }
      AppMethodBeat.o(56257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label852;
      }
    }
    label852:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hag != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hag);
      }
      i = i + f.a.a.b.b.a.alT(3) + f.a.a.b.b.a.alT(4);
      paramInt = i;
      if (this.Hah != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hah);
      }
      i = paramInt;
      if (this.wpT != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wpT);
      }
      paramInt = i;
      if (this.Hai != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hai);
      }
      i = paramInt;
      if (this.jdd != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.jdd);
      }
      paramInt = i;
      if (this.jde != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jde);
      }
      i = paramInt;
      if (this.GbA != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GbA);
      }
      paramInt = i;
      if (this.GbB != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GbB);
      }
      i = paramInt;
      if (this.Haj != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Haj);
      }
      AppMethodBeat.o(56257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(56257);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cgs localcgs = (cgs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56257);
          return -1;
        case 1: 
          localcgs.Name = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 2: 
          localcgs.Hag = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 3: 
          localcgs.FIb = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(56257);
          return 0;
        case 4: 
          localcgs.FIc = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(56257);
          return 0;
        case 5: 
          localcgs.Hah = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 6: 
          localcgs.wpT = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 7: 
          localcgs.Hai = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 8: 
          localcgs.jdd = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 9: 
          localcgs.jde = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 10: 
          localcgs.GbA = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 11: 
          localcgs.GbB = locala.NPN.readString();
          AppMethodBeat.o(56257);
          return 0;
        }
        localcgs.Haj = locala.NPN.readString();
        AppMethodBeat.o(56257);
        return 0;
      }
      AppMethodBeat.o(56257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgs
 * JD-Core Version:    0.7.0.1
 */