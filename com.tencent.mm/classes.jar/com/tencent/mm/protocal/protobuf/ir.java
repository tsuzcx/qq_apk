package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ir
  extends com.tencent.mm.bw.a
{
  public String DgJ;
  public String FTY;
  public String FTZ;
  public String FUa;
  public boolean FUb;
  public String FUc;
  public String dlT;
  public String oOZ;
  public String uVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uVs != null) {
        paramVarArgs.d(1, this.uVs);
      }
      if (this.dlT != null) {
        paramVarArgs.d(2, this.dlT);
      }
      if (this.oOZ != null) {
        paramVarArgs.d(3, this.oOZ);
      }
      if (this.DgJ != null) {
        paramVarArgs.d(4, this.DgJ);
      }
      if (this.FTY != null) {
        paramVarArgs.d(5, this.FTY);
      }
      if (this.FTZ != null) {
        paramVarArgs.d(6, this.FTZ);
      }
      if (this.FUa != null) {
        paramVarArgs.d(8, this.FUa);
      }
      paramVarArgs.bC(9, this.FUb);
      if (this.FUc != null) {
        paramVarArgs.d(10, this.FUc);
      }
      AppMethodBeat.o(72419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uVs == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.uVs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlT);
      }
      i = paramInt;
      if (this.oOZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oOZ);
      }
      paramInt = i;
      if (this.DgJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DgJ);
      }
      i = paramInt;
      if (this.FTY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FTY);
      }
      paramInt = i;
      if (this.FTZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FTZ);
      }
      i = paramInt;
      if (this.FUa != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FUa);
      }
      i += f.a.a.b.b.a.amF(9);
      paramInt = i;
      if (this.FUc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FUc);
      }
      AppMethodBeat.o(72419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localir.uVs = locala.OmT.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 2: 
          localir.dlT = locala.OmT.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 3: 
          localir.oOZ = locala.OmT.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 4: 
          localir.DgJ = locala.OmT.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 5: 
          localir.FTY = locala.OmT.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 6: 
          localir.FTZ = locala.OmT.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 8: 
          localir.FUa = locala.OmT.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 9: 
          localir.FUb = locala.OmT.gvY();
          AppMethodBeat.o(72419);
          return 0;
        }
        localir.FUc = locala.OmT.readString();
        AppMethodBeat.o(72419);
        return 0;
      }
      AppMethodBeat.o(72419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ir
 * JD-Core Version:    0.7.0.1
 */