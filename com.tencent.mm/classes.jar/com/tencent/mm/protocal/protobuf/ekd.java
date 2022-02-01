package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekd
  extends com.tencent.mm.bw.a
{
  public String Ini;
  public String Inj;
  public String dwb;
  public int mAf;
  public int myD;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      if (this.Ini != null) {
        paramVarArgs.d(3, this.Ini);
      }
      if (this.Inj != null) {
        paramVarArgs.d(4, this.Inj);
      }
      paramVarArgs.aS(5, this.myD);
      paramVarArgs.aS(6, this.mAf);
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = paramInt;
      if (this.Ini != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ini);
      }
      paramInt = i;
      if (this.Inj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Inj);
      }
      i = f.a.a.b.b.a.bz(5, this.myD);
      int j = f.a.a.b.b.a.bz(6, this.mAf);
      AppMethodBeat.o(123710);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ekd localekd = (ekd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123710);
        return -1;
      case 1: 
        localekd.type = locala.OmT.zc();
        AppMethodBeat.o(123710);
        return 0;
      case 2: 
        localekd.dwb = locala.OmT.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 3: 
        localekd.Ini = locala.OmT.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 4: 
        localekd.Inj = locala.OmT.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 5: 
        localekd.myD = locala.OmT.zc();
        AppMethodBeat.o(123710);
        return 0;
      }
      localekd.mAf = locala.OmT.zc();
      AppMethodBeat.o(123710);
      return 0;
    }
    AppMethodBeat.o(123710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekd
 * JD-Core Version:    0.7.0.1
 */