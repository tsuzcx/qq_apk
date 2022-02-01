package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aid
  extends com.tencent.mm.bx.a
{
  public int GfA;
  public int GfB;
  public String GfC;
  public String GfD;
  public String GfE;
  public int Gfk;
  public String Gfl;
  public String Gfm;
  public String Gfy;
  public String Gfz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gfk);
      if (this.Gfl != null) {
        paramVarArgs.d(2, this.Gfl);
      }
      if (this.Gfy != null) {
        paramVarArgs.d(3, this.Gfy);
      }
      if (this.Gfz != null) {
        paramVarArgs.d(4, this.Gfz);
      }
      paramVarArgs.aS(5, this.GfA);
      paramVarArgs.aS(6, this.GfB);
      if (this.GfC != null) {
        paramVarArgs.d(7, this.GfC);
      }
      if (this.Gfm != null) {
        paramVarArgs.d(8, this.Gfm);
      }
      if (this.GfD != null) {
        paramVarArgs.d(9, this.GfD);
      }
      if (this.GfE != null) {
        paramVarArgs.d(10, this.GfE);
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gfk) + 0;
      paramInt = i;
      if (this.Gfl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gfl);
      }
      i = paramInt;
      if (this.Gfy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gfy);
      }
      paramInt = i;
      if (this.Gfz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gfz);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GfA) + f.a.a.b.b.a.bz(6, this.GfB);
      paramInt = i;
      if (this.GfC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GfC);
      }
      i = paramInt;
      if (this.Gfm != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Gfm);
      }
      paramInt = i;
      if (this.GfD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GfD);
      }
      i = paramInt;
      if (this.GfE != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GfE);
      }
      AppMethodBeat.o(32206);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aid localaid = (aid)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32206);
        return -1;
      case 1: 
        localaid.Gfk = locala.NPN.zc();
        AppMethodBeat.o(32206);
        return 0;
      case 2: 
        localaid.Gfl = locala.NPN.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 3: 
        localaid.Gfy = locala.NPN.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 4: 
        localaid.Gfz = locala.NPN.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 5: 
        localaid.GfA = locala.NPN.zc();
        AppMethodBeat.o(32206);
        return 0;
      case 6: 
        localaid.GfB = locala.NPN.zc();
        AppMethodBeat.o(32206);
        return 0;
      case 7: 
        localaid.GfC = locala.NPN.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 8: 
        localaid.Gfm = locala.NPN.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 9: 
        localaid.GfD = locala.NPN.readString();
        AppMethodBeat.o(32206);
        return 0;
      }
      localaid.GfE = locala.NPN.readString();
      AppMethodBeat.o(32206);
      return 0;
    }
    AppMethodBeat.o(32206);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aid
 * JD-Core Version:    0.7.0.1
 */