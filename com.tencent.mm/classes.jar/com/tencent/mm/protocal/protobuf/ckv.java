package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckv
  extends com.tencent.mm.bx.a
{
  public String CVB;
  public String Egc;
  public long Egd;
  public int Ege;
  public int Egf;
  public int Egg;
  public int Egh;
  public int Egi;
  public int Egj;
  public float Egk;
  public float Egl;
  public float Egm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CVB != null) {
        paramVarArgs.d(1, this.CVB);
      }
      if (this.Egc != null) {
        paramVarArgs.d(2, this.Egc);
      }
      paramVarArgs.aG(3, this.Egd);
      paramVarArgs.aR(4, this.Ege);
      paramVarArgs.aR(5, this.Egf);
      paramVarArgs.aR(6, this.Egg);
      paramVarArgs.aR(7, this.Egh);
      paramVarArgs.aR(8, this.Egi);
      paramVarArgs.aR(9, this.Egj);
      paramVarArgs.x(10, this.Egk);
      paramVarArgs.x(11, this.Egl);
      paramVarArgs.x(12, this.Egm);
      AppMethodBeat.o(87875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CVB == null) {
        break label751;
      }
    }
    label751:
    for (paramInt = f.a.a.b.b.a.e(1, this.CVB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Egc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Egc);
      }
      paramInt = f.a.a.b.b.a.q(3, this.Egd);
      int j = f.a.a.b.b.a.bA(4, this.Ege);
      int k = f.a.a.b.b.a.bA(5, this.Egf);
      int m = f.a.a.b.b.a.bA(6, this.Egg);
      int n = f.a.a.b.b.a.bA(7, this.Egh);
      int i1 = f.a.a.b.b.a.bA(8, this.Egi);
      int i2 = f.a.a.b.b.a.bA(9, this.Egj);
      int i3 = f.a.a.b.b.a.fY(10);
      int i4 = f.a.a.b.b.a.fY(11);
      int i5 = f.a.a.b.b.a.fY(12);
      AppMethodBeat.o(87875);
      return i + paramInt + j + k + m + n + i1 + i2 + (i3 + 4) + (i4 + 4) + (i5 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(87875);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckv localckv = (ckv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87875);
          return -1;
        case 1: 
          localckv.CVB = locala.KhF.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 2: 
          localckv.Egc = locala.KhF.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 3: 
          localckv.Egd = locala.KhF.xT();
          AppMethodBeat.o(87875);
          return 0;
        case 4: 
          localckv.Ege = locala.KhF.xS();
          AppMethodBeat.o(87875);
          return 0;
        case 5: 
          localckv.Egf = locala.KhF.xS();
          AppMethodBeat.o(87875);
          return 0;
        case 6: 
          localckv.Egg = locala.KhF.xS();
          AppMethodBeat.o(87875);
          return 0;
        case 7: 
          localckv.Egh = locala.KhF.xS();
          AppMethodBeat.o(87875);
          return 0;
        case 8: 
          localckv.Egi = locala.KhF.xS();
          AppMethodBeat.o(87875);
          return 0;
        case 9: 
          localckv.Egj = locala.KhF.xS();
          AppMethodBeat.o(87875);
          return 0;
        case 10: 
          localckv.Egk = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(87875);
          return 0;
        case 11: 
          localckv.Egl = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(87875);
          return 0;
        }
        localckv.Egm = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(87875);
        return 0;
      }
      AppMethodBeat.o(87875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckv
 * JD-Core Version:    0.7.0.1
 */