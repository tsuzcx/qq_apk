package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ie
  extends com.tencent.mm.bx.a
{
  public String CDI;
  public String CDJ;
  public String CDK;
  public boolean CDL;
  public String CDM;
  public String dca;
  public String nCd;
  public String szi;
  public String zWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.szi != null) {
        paramVarArgs.d(1, this.szi);
      }
      if (this.dca != null) {
        paramVarArgs.d(2, this.dca);
      }
      if (this.nCd != null) {
        paramVarArgs.d(3, this.nCd);
      }
      if (this.zWw != null) {
        paramVarArgs.d(4, this.zWw);
      }
      if (this.CDI != null) {
        paramVarArgs.d(5, this.CDI);
      }
      if (this.CDJ != null) {
        paramVarArgs.d(6, this.CDJ);
      }
      if (this.CDK != null) {
        paramVarArgs.d(8, this.CDK);
      }
      paramVarArgs.bg(9, this.CDL);
      if (this.CDM != null) {
        paramVarArgs.d(10, this.CDM);
      }
      AppMethodBeat.o(72419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.szi == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.b.b.a.e(1, this.szi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dca != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dca);
      }
      i = paramInt;
      if (this.nCd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nCd);
      }
      paramInt = i;
      if (this.zWw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zWw);
      }
      i = paramInt;
      if (this.CDI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CDI);
      }
      paramInt = i;
      if (this.CDJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CDJ);
      }
      i = paramInt;
      if (this.CDK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CDK);
      }
      i += f.a.a.b.b.a.fY(9) + 1;
      paramInt = i;
      if (this.CDM != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CDM);
      }
      AppMethodBeat.o(72419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72419);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ie localie = (ie)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(72419);
          return -1;
        case 1: 
          localie.szi = locala.KhF.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 2: 
          localie.dca = locala.KhF.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 3: 
          localie.nCd = locala.KhF.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 4: 
          localie.zWw = locala.KhF.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 5: 
          localie.CDI = locala.KhF.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 6: 
          localie.CDJ = locala.KhF.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 8: 
          localie.CDK = locala.KhF.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 9: 
          localie.CDL = locala.KhF.fHu();
          AppMethodBeat.o(72419);
          return 0;
        }
        localie.CDM = locala.KhF.readString();
        AppMethodBeat.o(72419);
        return 0;
      }
      AppMethodBeat.o(72419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ie
 * JD-Core Version:    0.7.0.1
 */