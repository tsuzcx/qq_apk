package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhd
  extends com.tencent.mm.bw.a
{
  public int AkD;
  public int AkE;
  public String FOU;
  public String FOV;
  public String FOW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FOU != null) {
        paramVarArgs.d(1, this.FOU);
      }
      if (this.FOV != null) {
        paramVarArgs.d(2, this.FOV);
      }
      if (this.FOW != null) {
        paramVarArgs.d(3, this.FOW);
      }
      paramVarArgs.aS(4, this.AkD);
      paramVarArgs.aS(5, this.AkE);
      AppMethodBeat.o(125804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FOU == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.FOU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FOV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FOV);
      }
      i = paramInt;
      if (this.FOW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOW);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.AkD);
      int j = f.a.a.b.b.a.bz(5, this.AkE);
      AppMethodBeat.o(125804);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125804);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dhd localdhd = (dhd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125804);
          return -1;
        case 1: 
          localdhd.FOU = locala.OmT.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 2: 
          localdhd.FOV = locala.OmT.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 3: 
          localdhd.FOW = locala.OmT.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 4: 
          localdhd.AkD = locala.OmT.zc();
          AppMethodBeat.o(125804);
          return 0;
        }
        localdhd.AkE = locala.OmT.zc();
        AppMethodBeat.o(125804);
        return 0;
      }
      AppMethodBeat.o(125804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhd
 * JD-Core Version:    0.7.0.1
 */