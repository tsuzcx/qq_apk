package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahj
  extends com.tencent.mm.bx.a
{
  public int GeY;
  public int count;
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
    AppMethodBeat.i(50085);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aS(2, this.count);
      if (this.mrh != null) {
        paramVarArgs.d(3, this.mrh);
      }
      if (this.mri != null) {
        paramVarArgs.d(4, this.mri);
      }
      paramVarArgs.aS(5, this.GeY);
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
      AppMethodBeat.o(50085);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.count);
      paramInt = i;
      if (this.mrh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.mrh);
      }
      i = paramInt;
      if (this.mri != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.mri);
      }
      i += f.a.a.b.b.a.bz(5, this.GeY);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.duW);
      }
      i = paramInt;
      if (this.mrj != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.mrj);
      }
      paramInt = i;
      if (this.mrk != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.mrk);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.mrl);
      paramInt = i;
      if (this.mrm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.mrm);
      }
      i = f.a.a.b.b.a.bz(11, this.position);
      AppMethodBeat.o(50085);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50085);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahj localahj = (ahj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50085);
          return -1;
        case 1: 
          localahj.username = locala.NPN.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 2: 
          localahj.count = locala.NPN.zc();
          AppMethodBeat.o(50085);
          return 0;
        case 3: 
          localahj.mrh = locala.NPN.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 4: 
          localahj.mri = locala.NPN.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 5: 
          localahj.GeY = locala.NPN.zc();
          AppMethodBeat.o(50085);
          return 0;
        case 6: 
          localahj.duW = locala.NPN.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 7: 
          localahj.mrj = locala.NPN.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 8: 
          localahj.mrk = locala.NPN.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 9: 
          localahj.mrl = locala.NPN.zc();
          AppMethodBeat.o(50085);
          return 0;
        case 10: 
          localahj.mrm = locala.NPN.readString();
          AppMethodBeat.o(50085);
          return 0;
        }
        localahj.position = locala.NPN.zc();
        AppMethodBeat.o(50085);
        return 0;
      }
      AppMethodBeat.o(50085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahj
 * JD-Core Version:    0.7.0.1
 */