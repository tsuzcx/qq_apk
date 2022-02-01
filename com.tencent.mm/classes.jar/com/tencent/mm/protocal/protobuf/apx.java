package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apx
  extends com.tencent.mm.bx.a
{
  public String Goc;
  public String God;
  public String Goe;
  public String Gof;
  public int Gog;
  public String Goh;
  public String Goi;
  public String appName;
  public String jna;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169017);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Goc != null) {
        paramVarArgs.d(1, this.Goc);
      }
      if (this.God != null) {
        paramVarArgs.d(2, this.God);
      }
      if (this.Goe != null) {
        paramVarArgs.d(3, this.Goe);
      }
      if (this.appName != null) {
        paramVarArgs.d(4, this.appName);
      }
      if (this.Gof != null) {
        paramVarArgs.d(5, this.Gof);
      }
      if (this.jna != null) {
        paramVarArgs.d(6, this.jna);
      }
      paramVarArgs.aS(7, this.Gog);
      if (this.Goh != null) {
        paramVarArgs.d(8, this.Goh);
      }
      if (this.Goi != null) {
        paramVarArgs.d(9, this.Goi);
      }
      AppMethodBeat.o(169017);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Goc == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.Goc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.God != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.God);
      }
      i = paramInt;
      if (this.Goe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Goe);
      }
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.appName);
      }
      i = paramInt;
      if (this.Gof != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gof);
      }
      paramInt = i;
      if (this.jna != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jna);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Gog);
      paramInt = i;
      if (this.Goh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Goh);
      }
      i = paramInt;
      if (this.Goi != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Goi);
      }
      AppMethodBeat.o(169017);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169017);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        apx localapx = (apx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169017);
          return -1;
        case 1: 
          localapx.Goc = locala.NPN.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 2: 
          localapx.God = locala.NPN.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 3: 
          localapx.Goe = locala.NPN.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 4: 
          localapx.appName = locala.NPN.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 5: 
          localapx.Gof = locala.NPN.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 6: 
          localapx.jna = locala.NPN.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 7: 
          localapx.Gog = locala.NPN.zc();
          AppMethodBeat.o(169017);
          return 0;
        case 8: 
          localapx.Goh = locala.NPN.readString();
          AppMethodBeat.o(169017);
          return 0;
        }
        localapx.Goi = locala.NPN.readString();
        AppMethodBeat.o(169017);
        return 0;
      }
      AppMethodBeat.o(169017);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apx
 * JD-Core Version:    0.7.0.1
 */