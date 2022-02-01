package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chi
  extends com.tencent.mm.bx.a
{
  public int Fwf;
  public int HaK;
  public String duW;
  public String hXi;
  public String mrh;
  public String mri;
  public String mrm;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50096);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.mrh != null) {
        paramVarArgs.d(2, this.mrh);
      }
      if (this.hXi != null) {
        paramVarArgs.d(3, this.hXi);
      }
      if (this.mri != null) {
        paramVarArgs.d(4, this.mri);
      }
      if (this.duW != null) {
        paramVarArgs.d(5, this.duW);
      }
      if (this.mrm != null) {
        paramVarArgs.d(6, this.mrm);
      }
      paramVarArgs.aS(7, this.position);
      paramVarArgs.aS(8, this.HaK);
      paramVarArgs.aS(9, this.Fwf);
      AppMethodBeat.o(50096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mrh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mrh);
      }
      i = paramInt;
      if (this.hXi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hXi);
      }
      paramInt = i;
      if (this.mri != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mri);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.duW);
      }
      paramInt = i;
      if (this.mrm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.mrm);
      }
      i = f.a.a.b.b.a.bz(7, this.position);
      int j = f.a.a.b.b.a.bz(8, this.HaK);
      int k = f.a.a.b.b.a.bz(9, this.Fwf);
      AppMethodBeat.o(50096);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50096);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chi localchi = (chi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50096);
          return -1;
        case 1: 
          localchi.username = locala.NPN.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 2: 
          localchi.mrh = locala.NPN.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 3: 
          localchi.hXi = locala.NPN.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 4: 
          localchi.mri = locala.NPN.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 5: 
          localchi.duW = locala.NPN.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 6: 
          localchi.mrm = locala.NPN.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 7: 
          localchi.position = locala.NPN.zc();
          AppMethodBeat.o(50096);
          return 0;
        case 8: 
          localchi.HaK = locala.NPN.zc();
          AppMethodBeat.o(50096);
          return 0;
        }
        localchi.Fwf = locala.NPN.zc();
        AppMethodBeat.o(50096);
        return 0;
      }
      AppMethodBeat.o(50096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chi
 * JD-Core Version:    0.7.0.1
 */