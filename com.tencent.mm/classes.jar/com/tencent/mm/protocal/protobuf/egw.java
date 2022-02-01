package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egw
  extends com.tencent.mm.bw.a
{
  public int Gdm;
  public String IkI;
  public String dwb;
  public String xsG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      paramVarArgs.aS(2, this.Gdm);
      if (this.IkI != null) {
        paramVarArgs.d(3, this.IkI);
      }
      if (this.xsG != null) {
        paramVarArgs.d(4, this.xsG);
      }
      AppMethodBeat.o(82491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gdm);
      paramInt = i;
      if (this.IkI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.IkI);
      }
      i = paramInt;
      if (this.xsG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.xsG);
      }
      AppMethodBeat.o(82491);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82491);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        egw localegw = (egw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82491);
          return -1;
        case 1: 
          localegw.dwb = locala.OmT.readString();
          AppMethodBeat.o(82491);
          return 0;
        case 2: 
          localegw.Gdm = locala.OmT.zc();
          AppMethodBeat.o(82491);
          return 0;
        case 3: 
          localegw.IkI = locala.OmT.readString();
          AppMethodBeat.o(82491);
          return 0;
        }
        localegw.xsG = locala.OmT.readString();
        AppMethodBeat.o(82491);
        return 0;
      }
      AppMethodBeat.o(82491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egw
 * JD-Core Version:    0.7.0.1
 */