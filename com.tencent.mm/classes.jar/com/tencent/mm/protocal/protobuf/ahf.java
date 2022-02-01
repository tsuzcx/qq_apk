package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahf
  extends com.tencent.mm.bw.a
{
  public String hDr;
  public int yif;
  public String yig;
  public String yih;
  public int yii;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.yif);
      if (this.yig != null) {
        paramVarArgs.d(2, this.yig);
      }
      if (this.yih != null) {
        paramVarArgs.d(3, this.yih);
      }
      paramVarArgs.aS(4, this.yii);
      if (this.hDr != null) {
        paramVarArgs.d(5, this.hDr);
      }
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.yif) + 0;
      paramInt = i;
      if (this.yig != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yig);
      }
      i = paramInt;
      if (this.yih != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.yih);
      }
      i += f.a.a.b.b.a.bz(4, this.yii);
      paramInt = i;
      if (this.hDr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hDr);
      }
      AppMethodBeat.o(72474);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahf localahf = (ahf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72474);
        return -1;
      case 1: 
        localahf.yif = locala.OmT.zc();
        AppMethodBeat.o(72474);
        return 0;
      case 2: 
        localahf.yig = locala.OmT.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 3: 
        localahf.yih = locala.OmT.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 4: 
        localahf.yii = locala.OmT.zc();
        AppMethodBeat.o(72474);
        return 0;
      }
      localahf.hDr = locala.OmT.readString();
      AppMethodBeat.o(72474);
      return 0;
    }
    AppMethodBeat.o(72474);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahf
 * JD-Core Version:    0.7.0.1
 */