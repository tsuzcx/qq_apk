package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aki
  extends com.tencent.mm.bw.a
{
  public String FNA;
  public int FNu;
  public int FNv;
  public int FNw;
  public int FNx;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNu);
      paramVarArgs.aS(2, this.nJb);
      if (this.FNA != null) {
        paramVarArgs.d(3, this.FNA);
      }
      paramVarArgs.aS(4, this.FNv);
      paramVarArgs.aS(5, this.FNw);
      paramVarArgs.aS(6, this.FNx);
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FNu) + 0 + f.a.a.b.b.a.bz(2, this.nJb);
      paramInt = i;
      if (this.FNA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FNA);
      }
      i = f.a.a.b.b.a.bz(4, this.FNv);
      int j = f.a.a.b.b.a.bz(5, this.FNw);
      int k = f.a.a.b.b.a.bz(6, this.FNx);
      AppMethodBeat.o(127470);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aki localaki = (aki)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127470);
        return -1;
      case 1: 
        localaki.FNu = locala.OmT.zc();
        AppMethodBeat.o(127470);
        return 0;
      case 2: 
        localaki.nJb = locala.OmT.zc();
        AppMethodBeat.o(127470);
        return 0;
      case 3: 
        localaki.FNA = locala.OmT.readString();
        AppMethodBeat.o(127470);
        return 0;
      case 4: 
        localaki.FNv = locala.OmT.zc();
        AppMethodBeat.o(127470);
        return 0;
      case 5: 
        localaki.FNw = locala.OmT.zc();
        AppMethodBeat.o(127470);
        return 0;
      }
      localaki.FNx = locala.OmT.zc();
      AppMethodBeat.o(127470);
      return 0;
    }
    AppMethodBeat.o(127470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aki
 * JD-Core Version:    0.7.0.1
 */