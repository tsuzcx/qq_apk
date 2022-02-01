package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efi
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String FNL;
  public int HnF;
  public int Ijk;
  public int nID;
  public int nJA;
  public String uvF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32560);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uvF != null) {
        paramVarArgs.d(1, this.uvF);
      }
      paramVarArgs.aS(2, this.nJA);
      paramVarArgs.aS(3, this.nID);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.HnF);
      if (this.FNL != null) {
        paramVarArgs.d(6, this.FNL);
      }
      paramVarArgs.aS(7, this.Ijk);
      AppMethodBeat.o(32560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uvF == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = f.a.a.b.b.a.e(1, this.uvF) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA) + f.a.a.b.b.a.bz(3, this.nID) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.HnF);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNL);
      }
      i = f.a.a.b.b.a.bz(7, this.Ijk);
      AppMethodBeat.o(32560);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32560);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efi localefi = (efi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32560);
          return -1;
        case 1: 
          localefi.uvF = locala.OmT.readString();
          AppMethodBeat.o(32560);
          return 0;
        case 2: 
          localefi.nJA = locala.OmT.zc();
          AppMethodBeat.o(32560);
          return 0;
        case 3: 
          localefi.nID = locala.OmT.zc();
          AppMethodBeat.o(32560);
          return 0;
        case 4: 
          localefi.CreateTime = locala.OmT.zc();
          AppMethodBeat.o(32560);
          return 0;
        case 5: 
          localefi.HnF = locala.OmT.zc();
          AppMethodBeat.o(32560);
          return 0;
        case 6: 
          localefi.FNL = locala.OmT.readString();
          AppMethodBeat.o(32560);
          return 0;
        }
        localefi.Ijk = locala.OmT.zc();
        AppMethodBeat.o(32560);
        return 0;
      }
      AppMethodBeat.o(32560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efi
 * JD-Core Version:    0.7.0.1
 */