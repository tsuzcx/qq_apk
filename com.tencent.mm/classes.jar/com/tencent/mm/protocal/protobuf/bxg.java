package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bxg
  extends com.tencent.mm.bx.a
{
  public double CJD;
  public double CJE;
  public String DTI;
  public String DTJ;
  public String DTK;
  public String DTL;
  public String Dbi;
  public String Dbj;
  public String Name;
  public String ijN;
  public String ijO;
  public String ubD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.DTI != null) {
        paramVarArgs.d(2, this.DTI);
      }
      paramVarArgs.e(3, this.CJD);
      paramVarArgs.e(4, this.CJE);
      if (this.DTJ != null) {
        paramVarArgs.d(5, this.DTJ);
      }
      if (this.ubD != null) {
        paramVarArgs.d(6, this.ubD);
      }
      if (this.DTK != null) {
        paramVarArgs.d(7, this.DTK);
      }
      if (this.ijN != null) {
        paramVarArgs.d(8, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(9, this.ijO);
      }
      if (this.Dbi != null) {
        paramVarArgs.d(10, this.Dbi);
      }
      if (this.Dbj != null) {
        paramVarArgs.d(11, this.Dbj);
      }
      if (this.DTL != null) {
        paramVarArgs.d(12, this.DTL);
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
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DTI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DTI);
      }
      i = i + (f.a.a.b.b.a.fY(3) + 8) + (f.a.a.b.b.a.fY(4) + 8);
      paramInt = i;
      if (this.DTJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DTJ);
      }
      i = paramInt;
      if (this.ubD != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ubD);
      }
      paramInt = i;
      if (this.DTK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DTK);
      }
      i = paramInt;
      if (this.ijN != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ijN);
      }
      paramInt = i;
      if (this.ijO != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ijO);
      }
      i = paramInt;
      if (this.Dbi != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Dbi);
      }
      paramInt = i;
      if (this.Dbj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Dbj);
      }
      i = paramInt;
      if (this.DTL != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DTL);
      }
      AppMethodBeat.o(56257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(56257);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxg localbxg = (bxg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56257);
          return -1;
        case 1: 
          localbxg.Name = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 2: 
          localbxg.DTI = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 3: 
          localbxg.CJD = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(56257);
          return 0;
        case 4: 
          localbxg.CJE = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(56257);
          return 0;
        case 5: 
          localbxg.DTJ = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 6: 
          localbxg.ubD = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 7: 
          localbxg.DTK = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 8: 
          localbxg.ijN = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 9: 
          localbxg.ijO = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 10: 
          localbxg.Dbi = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 11: 
          localbxg.Dbj = locala.KhF.readString();
          AppMethodBeat.o(56257);
          return 0;
        }
        localbxg.DTL = locala.KhF.readString();
        AppMethodBeat.o(56257);
        return 0;
      }
      AppMethodBeat.o(56257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxg
 * JD-Core Version:    0.7.0.1
 */