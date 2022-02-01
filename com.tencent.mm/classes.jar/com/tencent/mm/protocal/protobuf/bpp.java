package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpp
  extends com.tencent.mm.bw.a
{
  public String Gpz;
  public String Hdj;
  public String Hdk;
  public String Hdl;
  public String Hdm;
  public int Hdn;
  public String Hdo;
  public String Title;
  public String Url;
  public int nJA;
  public String uuo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32327);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Hdj != null) {
        paramVarArgs.d(2, this.Hdj);
      }
      paramVarArgs.aS(3, this.nJA);
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      if (this.Hdk != null) {
        paramVarArgs.d(5, this.Hdk);
      }
      if (this.Gpz != null) {
        paramVarArgs.d(6, this.Gpz);
      }
      if (this.Hdl != null) {
        paramVarArgs.d(7, this.Hdl);
      }
      if (this.uuo != null) {
        paramVarArgs.d(8, this.uuo);
      }
      if (this.Hdm != null) {
        paramVarArgs.d(9, this.Hdm);
      }
      paramVarArgs.aS(10, this.Hdn);
      if (this.Hdo != null) {
        paramVarArgs.d(11, this.Hdo);
      }
      AppMethodBeat.o(32327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label811;
      }
    }
    label811:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hdj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hdj);
      }
      i += f.a.a.b.b.a.bz(3, this.nJA);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Url);
      }
      i = paramInt;
      if (this.Hdk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hdk);
      }
      paramInt = i;
      if (this.Gpz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gpz);
      }
      i = paramInt;
      if (this.Hdl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hdl);
      }
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.uuo);
      }
      i = paramInt;
      if (this.Hdm != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Hdm);
      }
      i += f.a.a.b.b.a.bz(10, this.Hdn);
      paramInt = i;
      if (this.Hdo != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Hdo);
      }
      AppMethodBeat.o(32327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32327);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpp localbpp = (bpp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32327);
          return -1;
        case 1: 
          localbpp.Title = locala.OmT.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 2: 
          localbpp.Hdj = locala.OmT.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 3: 
          localbpp.nJA = locala.OmT.zc();
          AppMethodBeat.o(32327);
          return 0;
        case 4: 
          localbpp.Url = locala.OmT.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 5: 
          localbpp.Hdk = locala.OmT.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 6: 
          localbpp.Gpz = locala.OmT.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 7: 
          localbpp.Hdl = locala.OmT.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 8: 
          localbpp.uuo = locala.OmT.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 9: 
          localbpp.Hdm = locala.OmT.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 10: 
          localbpp.Hdn = locala.OmT.zc();
          AppMethodBeat.o(32327);
          return 0;
        }
        localbpp.Hdo = locala.OmT.readString();
        AppMethodBeat.o(32327);
        return 0;
      }
      AppMethodBeat.o(32327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpp
 * JD-Core Version:    0.7.0.1
 */