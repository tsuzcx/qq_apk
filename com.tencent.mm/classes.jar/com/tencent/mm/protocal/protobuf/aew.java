package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aew
  extends com.tencent.mm.bw.a
{
  public int Gsk;
  public int Gva;
  public int Gvb;
  public int Gvc;
  public int Gvd;
  public int Gve;
  public int Gvf;
  public int channels;
  public int pdS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gva);
      paramVarArgs.aS(2, this.Gvb);
      paramVarArgs.aS(3, this.channels);
      paramVarArgs.aS(4, this.Gvc);
      paramVarArgs.aS(5, this.Gsk);
      paramVarArgs.aS(6, this.pdS);
      paramVarArgs.aS(7, this.Gvd);
      paramVarArgs.aS(8, this.Gve);
      paramVarArgs.aS(9, this.Gvf);
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gva);
      int i = f.a.a.b.b.a.bz(2, this.Gvb);
      int j = f.a.a.b.b.a.bz(3, this.channels);
      int k = f.a.a.b.b.a.bz(4, this.Gvc);
      int m = f.a.a.b.b.a.bz(5, this.Gsk);
      int n = f.a.a.b.b.a.bz(6, this.pdS);
      int i1 = f.a.a.b.b.a.bz(7, this.Gvd);
      int i2 = f.a.a.b.b.a.bz(8, this.Gve);
      int i3 = f.a.a.b.b.a.bz(9, this.Gvf);
      AppMethodBeat.o(90964);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aew localaew = (aew)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90964);
        return -1;
      case 1: 
        localaew.Gva = locala.OmT.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 2: 
        localaew.Gvb = locala.OmT.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 3: 
        localaew.channels = locala.OmT.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 4: 
        localaew.Gvc = locala.OmT.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 5: 
        localaew.Gsk = locala.OmT.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 6: 
        localaew.pdS = locala.OmT.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 7: 
        localaew.Gvd = locala.OmT.zc();
        AppMethodBeat.o(90964);
        return 0;
      case 8: 
        localaew.Gve = locala.OmT.zc();
        AppMethodBeat.o(90964);
        return 0;
      }
      localaew.Gvf = locala.OmT.zc();
      AppMethodBeat.o(90964);
      return 0;
    }
    AppMethodBeat.o(90964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aew
 * JD-Core Version:    0.7.0.1
 */