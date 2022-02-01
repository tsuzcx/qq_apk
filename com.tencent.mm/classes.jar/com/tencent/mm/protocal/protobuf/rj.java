package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class rj
  extends com.tencent.mm.bx.a
{
  public int AsE;
  public int AsF;
  public String FNA;
  public String FNB;
  public String FNC;
  public int FNl;
  public int FNy;
  public String FNz;
  public String aeskey;
  public int length;
  public String md5;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.aeskey == null)
      {
        paramVarArgs = new b("Not all required fields were included: aeskey");
        AppMethodBeat.o(194972);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(194972);
        throw paramVarArgs;
      }
      if (this.aeskey != null) {
        paramVarArgs.d(1, this.aeskey);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aS(3, this.type);
      paramVarArgs.aS(4, this.length);
      paramVarArgs.aS(5, this.FNy);
      if (this.FNz != null) {
        paramVarArgs.d(6, this.FNz);
      }
      if (this.FNA != null) {
        paramVarArgs.d(7, this.FNA);
      }
      paramVarArgs.aS(8, this.FNl);
      paramVarArgs.aS(9, this.AsE);
      paramVarArgs.aS(10, this.AsF);
      if (this.md5 != null) {
        paramVarArgs.d(11, this.md5);
      }
      if (this.FNB != null) {
        paramVarArgs.d(12, this.FNB);
      }
      if (this.FNC != null) {
        paramVarArgs.d(13, this.FNC);
      }
      AppMethodBeat.o(194972);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label942;
      }
    }
    label942:
    for (paramInt = f.a.a.b.b.a.e(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i = i + f.a.a.b.b.a.bz(3, this.type) + f.a.a.b.b.a.bz(4, this.length) + f.a.a.b.b.a.bz(5, this.FNy);
      paramInt = i;
      if (this.FNz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNz);
      }
      i = paramInt;
      if (this.FNA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FNA);
      }
      i = i + f.a.a.b.b.a.bz(8, this.FNl) + f.a.a.b.b.a.bz(9, this.AsE) + f.a.a.b.b.a.bz(10, this.AsF);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.md5);
      }
      i = paramInt;
      if (this.FNB != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FNB);
      }
      paramInt = i;
      if (this.FNC != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FNC);
      }
      AppMethodBeat.o(194972);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.aeskey == null)
        {
          paramVarArgs = new b("Not all required fields were included: aeskey");
          AppMethodBeat.o(194972);
          throw paramVarArgs;
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(194972);
          throw paramVarArgs;
        }
        AppMethodBeat.o(194972);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rj localrj = (rj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194972);
          return -1;
        case 1: 
          localrj.aeskey = locala.NPN.readString();
          AppMethodBeat.o(194972);
          return 0;
        case 2: 
          localrj.url = locala.NPN.readString();
          AppMethodBeat.o(194972);
          return 0;
        case 3: 
          localrj.type = locala.NPN.zc();
          AppMethodBeat.o(194972);
          return 0;
        case 4: 
          localrj.length = locala.NPN.zc();
          AppMethodBeat.o(194972);
          return 0;
        case 5: 
          localrj.FNy = locala.NPN.zc();
          AppMethodBeat.o(194972);
          return 0;
        case 6: 
          localrj.FNz = locala.NPN.readString();
          AppMethodBeat.o(194972);
          return 0;
        case 7: 
          localrj.FNA = locala.NPN.readString();
          AppMethodBeat.o(194972);
          return 0;
        case 8: 
          localrj.FNl = locala.NPN.zc();
          AppMethodBeat.o(194972);
          return 0;
        case 9: 
          localrj.AsE = locala.NPN.zc();
          AppMethodBeat.o(194972);
          return 0;
        case 10: 
          localrj.AsF = locala.NPN.zc();
          AppMethodBeat.o(194972);
          return 0;
        case 11: 
          localrj.md5 = locala.NPN.readString();
          AppMethodBeat.o(194972);
          return 0;
        case 12: 
          localrj.FNB = locala.NPN.readString();
          AppMethodBeat.o(194972);
          return 0;
        }
        localrj.FNC = locala.NPN.readString();
        AppMethodBeat.o(194972);
        return 0;
      }
      AppMethodBeat.o(194972);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rj
 * JD-Core Version:    0.7.0.1
 */