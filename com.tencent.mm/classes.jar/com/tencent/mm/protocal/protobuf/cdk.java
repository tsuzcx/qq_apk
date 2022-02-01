package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdk
  extends com.tencent.mm.bw.a
{
  public int HgA;
  public int Hqn;
  public int Hqo;
  public int Hqp;
  public int Hqq;
  public int Hqr;
  public int Hqs;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HgA);
      paramVarArgs.aS(2, this.Hqn);
      paramVarArgs.aS(3, this.Hqo);
      paramVarArgs.aS(4, this.Hqp);
      paramVarArgs.aS(5, this.Hqq);
      paramVarArgs.aS(6, this.Hqr);
      paramVarArgs.aS(7, this.Hqs);
      paramVarArgs.aS(8, this.nJA);
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HgA);
      int i = f.a.a.b.b.a.bz(2, this.Hqn);
      int j = f.a.a.b.b.a.bz(3, this.Hqo);
      int k = f.a.a.b.b.a.bz(4, this.Hqp);
      int m = f.a.a.b.b.a.bz(5, this.Hqq);
      int n = f.a.a.b.b.a.bz(6, this.Hqr);
      int i1 = f.a.a.b.b.a.bz(7, this.Hqs);
      int i2 = f.a.a.b.b.a.bz(8, this.nJA);
      AppMethodBeat.o(143985);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cdk localcdk = (cdk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143985);
        return -1;
      case 1: 
        localcdk.HgA = locala.OmT.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 2: 
        localcdk.Hqn = locala.OmT.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 3: 
        localcdk.Hqo = locala.OmT.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 4: 
        localcdk.Hqp = locala.OmT.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 5: 
        localcdk.Hqq = locala.OmT.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 6: 
        localcdk.Hqr = locala.OmT.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 7: 
        localcdk.Hqs = locala.OmT.zc();
        AppMethodBeat.o(143985);
        return 0;
      }
      localcdk.nJA = locala.OmT.zc();
      AppMethodBeat.o(143985);
      return 0;
    }
    AppMethodBeat.o(143985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdk
 * JD-Core Version:    0.7.0.1
 */