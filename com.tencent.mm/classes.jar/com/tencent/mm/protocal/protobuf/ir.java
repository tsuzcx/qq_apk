package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ir
  extends com.tencent.mm.bx.a
{
  public String CPf;
  public String FBD;
  public String FBE;
  public String FBF;
  public boolean FBG;
  public String FBH;
  public String dkR;
  public String oIx;
  public String uJF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uJF != null) {
        paramVarArgs.d(1, this.uJF);
      }
      if (this.dkR != null) {
        paramVarArgs.d(2, this.dkR);
      }
      if (this.oIx != null) {
        paramVarArgs.d(3, this.oIx);
      }
      if (this.CPf != null) {
        paramVarArgs.d(4, this.CPf);
      }
      if (this.FBD != null) {
        paramVarArgs.d(5, this.FBD);
      }
      if (this.FBE != null) {
        paramVarArgs.d(6, this.FBE);
      }
      if (this.FBF != null) {
        paramVarArgs.d(8, this.FBF);
      }
      paramVarArgs.bt(9, this.FBG);
      if (this.FBH != null) {
        paramVarArgs.d(10, this.FBH);
      }
      AppMethodBeat.o(72419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uJF == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.uJF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dkR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dkR);
      }
      i = paramInt;
      if (this.oIx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oIx);
      }
      paramInt = i;
      if (this.CPf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CPf);
      }
      i = paramInt;
      if (this.FBD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FBD);
      }
      paramInt = i;
      if (this.FBE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FBE);
      }
      i = paramInt;
      if (this.FBF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FBF);
      }
      i += f.a.a.b.b.a.alV(9);
      paramInt = i;
      if (this.FBH != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FBH);
      }
      AppMethodBeat.o(72419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72419);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ir localir = (ir)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(72419);
          return -1;
        case 1: 
          localir.uJF = locala.NPN.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 2: 
          localir.dkR = locala.NPN.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 3: 
          localir.oIx = locala.NPN.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 4: 
          localir.CPf = locala.NPN.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 5: 
          localir.FBD = locala.NPN.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 6: 
          localir.FBE = locala.NPN.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 8: 
          localir.FBF = locala.NPN.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 9: 
          localir.FBG = locala.NPN.grw();
          AppMethodBeat.o(72419);
          return 0;
        }
        localir.FBH = locala.NPN.readString();
        AppMethodBeat.o(72419);
        return 0;
      }
      AppMethodBeat.o(72419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ir
 * JD-Core Version:    0.7.0.1
 */