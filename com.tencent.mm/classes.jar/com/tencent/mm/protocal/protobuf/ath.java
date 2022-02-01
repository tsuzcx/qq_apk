package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ath
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int FqM;
  public String Fvf;
  public String Fvh;
  public String Grm;
  public int Grn;
  public int Gro;
  public int Grp;
  public String hDa;
  public String nDo;
  public String ukw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149139);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvf != null) {
        paramVarArgs.d(1, this.Fvf);
      }
      paramVarArgs.aS(2, this.FqM);
      paramVarArgs.aS(3, this.CreateTime);
      if (this.Fvh != null) {
        paramVarArgs.d(4, this.Fvh);
      }
      if (this.ukw != null) {
        paramVarArgs.d(5, this.ukw);
      }
      if (this.Grm != null) {
        paramVarArgs.d(6, this.Grm);
      }
      if (this.nDo != null) {
        paramVarArgs.d(7, this.nDo);
      }
      paramVarArgs.aS(8, this.Grn);
      if (this.hDa != null) {
        paramVarArgs.d(9, this.hDa);
      }
      paramVarArgs.aS(10, this.Gro);
      paramVarArgs.aS(11, this.Grp);
      AppMethodBeat.o(149139);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fvf == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fvf) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FqM) + f.a.a.b.b.a.bz(3, this.CreateTime);
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fvh);
      }
      i = paramInt;
      if (this.ukw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ukw);
      }
      paramInt = i;
      if (this.Grm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Grm);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.nDo);
      }
      i += f.a.a.b.b.a.bz(8, this.Grn);
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hDa);
      }
      i = f.a.a.b.b.a.bz(10, this.Gro);
      int j = f.a.a.b.b.a.bz(11, this.Grp);
      AppMethodBeat.o(149139);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(149139);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ath localath = (ath)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149139);
          return -1;
        case 1: 
          localath.Fvf = locala.NPN.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 2: 
          localath.FqM = locala.NPN.zc();
          AppMethodBeat.o(149139);
          return 0;
        case 3: 
          localath.CreateTime = locala.NPN.zc();
          AppMethodBeat.o(149139);
          return 0;
        case 4: 
          localath.Fvh = locala.NPN.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 5: 
          localath.ukw = locala.NPN.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 6: 
          localath.Grm = locala.NPN.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 7: 
          localath.nDo = locala.NPN.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 8: 
          localath.Grn = locala.NPN.zc();
          AppMethodBeat.o(149139);
          return 0;
        case 9: 
          localath.hDa = locala.NPN.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 10: 
          localath.Gro = locala.NPN.zc();
          AppMethodBeat.o(149139);
          return 0;
        }
        localath.Grp = locala.NPN.zc();
        AppMethodBeat.o(149139);
        return 0;
      }
      AppMethodBeat.o(149139);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ath
 * JD-Core Version:    0.7.0.1
 */