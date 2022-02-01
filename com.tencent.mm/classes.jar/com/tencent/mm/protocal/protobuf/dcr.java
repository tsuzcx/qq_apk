package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcr
  extends com.tencent.mm.bx.a
{
  public int CzZ;
  public String DLH;
  public String DUZ;
  public String DVb;
  public String Efu;
  public String Eud;
  public int Scene;
  public int fVE;
  public String gKr;
  public String nlK;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117936);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUZ != null) {
        paramVarArgs.d(1, this.DUZ);
      }
      if (this.Eud != null) {
        paramVarArgs.d(2, this.Eud);
      }
      paramVarArgs.aR(3, this.fVE);
      if (this.DVb != null) {
        paramVarArgs.d(4, this.DVb);
      }
      if (this.gKr != null) {
        paramVarArgs.d(5, this.gKr);
      }
      paramVarArgs.aR(6, this.Scene);
      if (this.DLH != null) {
        paramVarArgs.d(7, this.DLH);
      }
      paramVarArgs.aR(8, this.CzZ);
      if (this.nlK != null) {
        paramVarArgs.d(9, this.nlK);
      }
      if (this.Efu != null) {
        paramVarArgs.d(10, this.Efu);
      }
      paramVarArgs.aR(11, this.rNz);
      AppMethodBeat.o(117936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUZ == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.DUZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eud != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eud);
      }
      i += f.a.a.b.b.a.bA(3, this.fVE);
      paramInt = i;
      if (this.DVb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DVb);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gKr);
      }
      i += f.a.a.b.b.a.bA(6, this.Scene);
      paramInt = i;
      if (this.DLH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DLH);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.CzZ);
      paramInt = i;
      if (this.nlK != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nlK);
      }
      i = paramInt;
      if (this.Efu != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Efu);
      }
      paramInt = f.a.a.b.b.a.bA(11, this.rNz);
      AppMethodBeat.o(117936);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117936);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dcr localdcr = (dcr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117936);
          return -1;
        case 1: 
          localdcr.DUZ = locala.KhF.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 2: 
          localdcr.Eud = locala.KhF.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 3: 
          localdcr.fVE = locala.KhF.xS();
          AppMethodBeat.o(117936);
          return 0;
        case 4: 
          localdcr.DVb = locala.KhF.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 5: 
          localdcr.gKr = locala.KhF.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 6: 
          localdcr.Scene = locala.KhF.xS();
          AppMethodBeat.o(117936);
          return 0;
        case 7: 
          localdcr.DLH = locala.KhF.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 8: 
          localdcr.CzZ = locala.KhF.xS();
          AppMethodBeat.o(117936);
          return 0;
        case 9: 
          localdcr.nlK = locala.KhF.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 10: 
          localdcr.Efu = locala.KhF.readString();
          AppMethodBeat.o(117936);
          return 0;
        }
        localdcr.rNz = locala.KhF.xS();
        AppMethodBeat.o(117936);
        return 0;
      }
      AppMethodBeat.o(117936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcr
 * JD-Core Version:    0.7.0.1
 */