package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cni
  extends com.tencent.mm.bx.a
{
  public int Hgx;
  public int Hgy;
  public int Hgz;
  public int qel;
  public String qem;
  public int uLy;
  public String uLz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hgy);
      paramVarArgs.aS(2, this.Hgz);
      paramVarArgs.aS(3, this.Hgx);
      paramVarArgs.aS(4, this.qel);
      if (this.qem != null) {
        paramVarArgs.d(5, this.qem);
      }
      paramVarArgs.aS(6, this.uLy);
      if (this.uLz != null) {
        paramVarArgs.d(7, this.uLz);
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hgy) + 0 + f.a.a.b.b.a.bz(2, this.Hgz) + f.a.a.b.b.a.bz(3, this.Hgx) + f.a.a.b.b.a.bz(4, this.qel);
      paramInt = i;
      if (this.qem != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qem);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.uLy);
      paramInt = i;
      if (this.uLz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uLz);
      }
      AppMethodBeat.o(32392);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cni localcni = (cni)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32392);
        return -1;
      case 1: 
        localcni.Hgy = locala.NPN.zc();
        AppMethodBeat.o(32392);
        return 0;
      case 2: 
        localcni.Hgz = locala.NPN.zc();
        AppMethodBeat.o(32392);
        return 0;
      case 3: 
        localcni.Hgx = locala.NPN.zc();
        AppMethodBeat.o(32392);
        return 0;
      case 4: 
        localcni.qel = locala.NPN.zc();
        AppMethodBeat.o(32392);
        return 0;
      case 5: 
        localcni.qem = locala.NPN.readString();
        AppMethodBeat.o(32392);
        return 0;
      case 6: 
        localcni.uLy = locala.NPN.zc();
        AppMethodBeat.o(32392);
        return 0;
      }
      localcni.uLz = locala.NPN.readString();
      AppMethodBeat.o(32392);
      return 0;
    }
    AppMethodBeat.o(32392);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cni
 * JD-Core Version:    0.7.0.1
 */