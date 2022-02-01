package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ei
  extends com.tencent.mm.bx.a
{
  public int Fwf;
  public String duW;
  public String hXi;
  public String mri;
  public String mrm;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.hXi != null) {
        paramVarArgs.d(2, this.hXi);
      }
      if (this.mri != null) {
        paramVarArgs.d(3, this.mri);
      }
      if (this.duW != null) {
        paramVarArgs.d(4, this.duW);
      }
      if (this.mrm != null) {
        paramVarArgs.d(5, this.mrm);
      }
      paramVarArgs.aS(6, this.position);
      paramVarArgs.aS(7, this.Fwf);
      AppMethodBeat.o(50080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hXi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hXi);
      }
      i = paramInt;
      if (this.mri != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mri);
      }
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.duW);
      }
      i = paramInt;
      if (this.mrm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mrm);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.position);
      int j = f.a.a.b.b.a.bz(7, this.Fwf);
      AppMethodBeat.o(50080);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50080);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ei localei = (ei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50080);
          return -1;
        case 1: 
          localei.username = locala.NPN.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 2: 
          localei.hXi = locala.NPN.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 3: 
          localei.mri = locala.NPN.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 4: 
          localei.duW = locala.NPN.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 5: 
          localei.mrm = locala.NPN.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 6: 
          localei.position = locala.NPN.zc();
          AppMethodBeat.o(50080);
          return 0;
        }
        localei.Fwf = locala.NPN.zc();
        AppMethodBeat.o(50080);
        return 0;
      }
      AppMethodBeat.o(50080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ei
 * JD-Core Version:    0.7.0.1
 */