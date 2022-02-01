package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duc
  extends com.tencent.mm.bx.a
{
  public String FzJ;
  public String GHw;
  public String Gax;
  public long HGX;
  public String Hcq;
  public String IconUrl;
  public String nDs;
  public String uiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gax != null) {
        paramVarArgs.d(1, this.Gax);
      }
      if (this.FzJ != null) {
        paramVarArgs.d(2, this.FzJ);
      }
      if (this.Hcq != null) {
        paramVarArgs.d(3, this.Hcq);
      }
      if (this.uiR != null) {
        paramVarArgs.d(4, this.uiR);
      }
      if (this.nDs != null) {
        paramVarArgs.d(5, this.nDs);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(6, this.IconUrl);
      }
      if (this.GHw != null) {
        paramVarArgs.d(7, this.GHw);
      }
      paramVarArgs.aY(8, this.HGX);
      AppMethodBeat.o(32491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gax == null) {
        break label640;
      }
    }
    label640:
    for (int i = f.a.a.b.b.a.e(1, this.Gax) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FzJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FzJ);
      }
      i = paramInt;
      if (this.Hcq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hcq);
      }
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uiR);
      }
      i = paramInt;
      if (this.nDs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDs);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.IconUrl);
      }
      i = paramInt;
      if (this.GHw != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GHw);
      }
      paramInt = f.a.a.b.b.a.p(8, this.HGX);
      AppMethodBeat.o(32491);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32491);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        duc localduc = (duc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32491);
          return -1;
        case 1: 
          localduc.Gax = locala.NPN.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 2: 
          localduc.FzJ = locala.NPN.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 3: 
          localduc.Hcq = locala.NPN.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 4: 
          localduc.uiR = locala.NPN.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 5: 
          localduc.nDs = locala.NPN.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 6: 
          localduc.IconUrl = locala.NPN.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 7: 
          localduc.GHw = locala.NPN.readString();
          AppMethodBeat.o(32491);
          return 0;
        }
        localduc.HGX = locala.NPN.zd();
        AppMethodBeat.o(32491);
        return 0;
      }
      AppMethodBeat.o(32491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duc
 * JD-Core Version:    0.7.0.1
 */