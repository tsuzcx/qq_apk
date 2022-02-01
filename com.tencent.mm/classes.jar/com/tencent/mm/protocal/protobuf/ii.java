package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ii
  extends com.tencent.mm.bx.a
{
  public String CDR;
  public String CDS;
  public String CDT;
  public String CDU;
  public String CDV;
  public String ntj;
  public String odo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CDR != null) {
        paramVarArgs.d(1, this.CDR);
      }
      if (this.CDS != null) {
        paramVarArgs.d(2, this.CDS);
      }
      if (this.CDT != null) {
        paramVarArgs.d(3, this.CDT);
      }
      if (this.odo != null) {
        paramVarArgs.d(4, this.odo);
      }
      if (this.ntj != null) {
        paramVarArgs.d(5, this.ntj);
      }
      if (this.CDU != null) {
        paramVarArgs.d(6, this.CDU);
      }
      if (this.CDV != null) {
        paramVarArgs.d(7, this.CDV);
      }
      AppMethodBeat.o(124392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CDR == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.CDR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CDS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CDS);
      }
      i = paramInt;
      if (this.CDT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CDT);
      }
      paramInt = i;
      if (this.odo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.odo);
      }
      i = paramInt;
      if (this.ntj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ntj);
      }
      paramInt = i;
      if (this.CDU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CDU);
      }
      i = paramInt;
      if (this.CDV != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CDV);
      }
      AppMethodBeat.o(124392);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124392);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ii localii = (ii)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124392);
          return -1;
        case 1: 
          localii.CDR = locala.KhF.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 2: 
          localii.CDS = locala.KhF.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 3: 
          localii.CDT = locala.KhF.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 4: 
          localii.odo = locala.KhF.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 5: 
          localii.ntj = locala.KhF.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 6: 
          localii.CDU = locala.KhF.readString();
          AppMethodBeat.o(124392);
          return 0;
        }
        localii.CDV = locala.KhF.readString();
        AppMethodBeat.o(124392);
        return 0;
      }
      AppMethodBeat.o(124392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ii
 * JD-Core Version:    0.7.0.1
 */