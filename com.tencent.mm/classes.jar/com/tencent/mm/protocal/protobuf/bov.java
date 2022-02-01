package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bov
  extends com.tencent.mm.bx.a
{
  public String FAe;
  public String FOH;
  public String GJD;
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int nEa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32325);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.d(1, this.Type);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      paramVarArgs.aS(3, this.nEa);
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      if (this.FAe != null) {
        paramVarArgs.d(5, this.FAe);
      }
      if (this.FOH != null) {
        paramVarArgs.d(6, this.FOH);
      }
      if (this.Url != null) {
        paramVarArgs.d(7, this.Url);
      }
      if (this.GJD != null) {
        paramVarArgs.d(8, this.GJD);
      }
      AppMethodBeat.o(32325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Type == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = f.a.a.b.b.a.e(1, this.Type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Name);
      }
      i += f.a.a.b.b.a.bz(3, this.nEa);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Md5);
      }
      i = paramInt;
      if (this.FAe != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FAe);
      }
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FOH);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Url);
      }
      paramInt = i;
      if (this.GJD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GJD);
      }
      AppMethodBeat.o(32325);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32325);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bov localbov = (bov)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32325);
          return -1;
        case 1: 
          localbov.Type = locala.NPN.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 2: 
          localbov.Name = locala.NPN.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 3: 
          localbov.nEa = locala.NPN.zc();
          AppMethodBeat.o(32325);
          return 0;
        case 4: 
          localbov.Md5 = locala.NPN.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 5: 
          localbov.FAe = locala.NPN.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 6: 
          localbov.FOH = locala.NPN.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 7: 
          localbov.Url = locala.NPN.readString();
          AppMethodBeat.o(32325);
          return 0;
        }
        localbov.GJD = locala.NPN.readString();
        AppMethodBeat.o(32325);
        return 0;
      }
      AppMethodBeat.o(32325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bov
 * JD-Core Version:    0.7.0.1
 */