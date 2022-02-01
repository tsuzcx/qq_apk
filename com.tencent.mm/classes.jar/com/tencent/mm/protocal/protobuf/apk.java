package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apk
  extends com.tencent.mm.bw.a
{
  public String AqK;
  public int GGz;
  public int dez;
  public long gJh;
  public int liveStatus;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189368);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.gJh);
      paramVarArgs.aS(2, this.GGz);
      paramVarArgs.aS(3, this.liveStatus);
      if (this.AqK != null) {
        paramVarArgs.d(4, this.AqK);
      }
      paramVarArgs.aS(5, this.dez);
      AppMethodBeat.o(189368);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.gJh) + 0 + f.a.a.b.b.a.bz(2, this.GGz) + f.a.a.b.b.a.bz(3, this.liveStatus);
      paramInt = i;
      if (this.AqK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.AqK);
      }
      i = f.a.a.b.b.a.bz(5, this.dez);
      AppMethodBeat.o(189368);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189368);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apk localapk = (apk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189368);
        return -1;
      case 1: 
        localapk.gJh = locala.OmT.zd();
        AppMethodBeat.o(189368);
        return 0;
      case 2: 
        localapk.GGz = locala.OmT.zc();
        AppMethodBeat.o(189368);
        return 0;
      case 3: 
        localapk.liveStatus = locala.OmT.zc();
        AppMethodBeat.o(189368);
        return 0;
      case 4: 
        localapk.AqK = locala.OmT.readString();
        AppMethodBeat.o(189368);
        return 0;
      }
      localapk.dez = locala.OmT.zc();
      AppMethodBeat.o(189368);
      return 0;
    }
    AppMethodBeat.o(189368);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apk
 * JD-Core Version:    0.7.0.1
 */