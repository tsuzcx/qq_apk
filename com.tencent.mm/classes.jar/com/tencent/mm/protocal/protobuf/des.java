package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class des
  extends com.tencent.mm.bx.a
{
  public String HsU;
  public String HsV;
  public String HsW;
  public int HsX;
  public String HsY;
  public String HsZ;
  public String Hta;
  public int Htb;
  public int Htc;
  public int Htd;
  public int Hte;
  public int Htf;
  public int Scene;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HsU == null)
      {
        paramVarArgs = new b("Not all required fields were included: PickedWord");
        AppMethodBeat.o(117927);
        throw paramVarArgs;
      }
      if (this.HsU != null) {
        paramVarArgs.d(1, this.HsU);
      }
      if (this.HsV != null) {
        paramVarArgs.d(2, this.HsV);
      }
      if (this.HsW != null) {
        paramVarArgs.d(3, this.HsW);
      }
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aS(5, this.HsX);
      if (this.Url != null) {
        paramVarArgs.d(6, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.d(7, this.Title);
      }
      if (this.HsY != null) {
        paramVarArgs.d(8, this.HsY);
      }
      if (this.HsZ != null) {
        paramVarArgs.d(9, this.HsZ);
      }
      if (this.Hta != null) {
        paramVarArgs.d(10, this.Hta);
      }
      paramVarArgs.aS(11, this.Htb);
      paramVarArgs.aS(12, this.Htc);
      paramVarArgs.aS(13, this.Htd);
      paramVarArgs.aS(14, this.Hte);
      paramVarArgs.aS(15, this.Htf);
      AppMethodBeat.o(117927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HsU == null) {
        break label1018;
      }
    }
    label1018:
    for (int i = f.a.a.b.b.a.e(1, this.HsU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HsV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HsV);
      }
      i = paramInt;
      if (this.HsW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HsW);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Scene) + f.a.a.b.b.a.bz(5, this.HsX);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Url);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Title);
      }
      paramInt = i;
      if (this.HsY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HsY);
      }
      i = paramInt;
      if (this.HsZ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HsZ);
      }
      paramInt = i;
      if (this.Hta != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hta);
      }
      i = f.a.a.b.b.a.bz(11, this.Htb);
      int j = f.a.a.b.b.a.bz(12, this.Htc);
      int k = f.a.a.b.b.a.bz(13, this.Htd);
      int m = f.a.a.b.b.a.bz(14, this.Hte);
      int n = f.a.a.b.b.a.bz(15, this.Htf);
      AppMethodBeat.o(117927);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HsU == null)
        {
          paramVarArgs = new b("Not all required fields were included: PickedWord");
          AppMethodBeat.o(117927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117927);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        des localdes = (des)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117927);
          return -1;
        case 1: 
          localdes.HsU = locala.NPN.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 2: 
          localdes.HsV = locala.NPN.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 3: 
          localdes.HsW = locala.NPN.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 4: 
          localdes.Scene = locala.NPN.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 5: 
          localdes.HsX = locala.NPN.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 6: 
          localdes.Url = locala.NPN.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 7: 
          localdes.Title = locala.NPN.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 8: 
          localdes.HsY = locala.NPN.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 9: 
          localdes.HsZ = locala.NPN.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 10: 
          localdes.Hta = locala.NPN.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 11: 
          localdes.Htb = locala.NPN.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 12: 
          localdes.Htc = locala.NPN.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 13: 
          localdes.Htd = locala.NPN.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 14: 
          localdes.Hte = locala.NPN.zc();
          AppMethodBeat.o(117927);
          return 0;
        }
        localdes.Htf = locala.NPN.zc();
        AppMethodBeat.o(117927);
        return 0;
      }
      AppMethodBeat.o(117927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.des
 * JD-Core Version:    0.7.0.1
 */