package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yx
  extends com.tencent.mm.bx.a
{
  public int FYA;
  public int FYz;
  public String duW;
  public String mrh;
  public String mri;
  public String mrj;
  public String mrk;
  public int mrl;
  public String mrm;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50083);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.mrh != null) {
        paramVarArgs.d(2, this.mrh);
      }
      paramVarArgs.aS(3, this.FYz);
      paramVarArgs.aS(4, this.FYA);
      if (this.mri != null) {
        paramVarArgs.d(5, this.mri);
      }
      if (this.duW != null) {
        paramVarArgs.d(6, this.duW);
      }
      if (this.mrj != null) {
        paramVarArgs.d(7, this.mrj);
      }
      if (this.mrk != null) {
        paramVarArgs.d(8, this.mrk);
      }
      paramVarArgs.aS(9, this.mrl);
      if (this.mrm != null) {
        paramVarArgs.d(10, this.mrm);
      }
      paramVarArgs.aS(11, this.position);
      AppMethodBeat.o(50083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mrh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mrh);
      }
      i = i + f.a.a.b.b.a.bz(3, this.FYz) + f.a.a.b.b.a.bz(4, this.FYA);
      paramInt = i;
      if (this.mri != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.mri);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.duW);
      }
      paramInt = i;
      if (this.mrj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mrj);
      }
      i = paramInt;
      if (this.mrk != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.mrk);
      }
      i += f.a.a.b.b.a.bz(9, this.mrl);
      paramInt = i;
      if (this.mrm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.mrm);
      }
      i = f.a.a.b.b.a.bz(11, this.position);
      AppMethodBeat.o(50083);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50083);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        yx localyx = (yx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50083);
          return -1;
        case 1: 
          localyx.username = locala.NPN.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 2: 
          localyx.mrh = locala.NPN.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 3: 
          localyx.FYz = locala.NPN.zc();
          AppMethodBeat.o(50083);
          return 0;
        case 4: 
          localyx.FYA = locala.NPN.zc();
          AppMethodBeat.o(50083);
          return 0;
        case 5: 
          localyx.mri = locala.NPN.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 6: 
          localyx.duW = locala.NPN.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 7: 
          localyx.mrj = locala.NPN.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 8: 
          localyx.mrk = locala.NPN.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 9: 
          localyx.mrl = locala.NPN.zc();
          AppMethodBeat.o(50083);
          return 0;
        case 10: 
          localyx.mrm = locala.NPN.readString();
          AppMethodBeat.o(50083);
          return 0;
        }
        localyx.position = locala.NPN.zc();
        AppMethodBeat.o(50083);
        return 0;
      }
      AppMethodBeat.o(50083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yx
 * JD-Core Version:    0.7.0.1
 */