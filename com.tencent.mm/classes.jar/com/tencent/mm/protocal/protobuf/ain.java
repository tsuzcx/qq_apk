package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ain
  extends com.tencent.mm.bw.a
{
  public int GxS;
  public String GxT;
  public String GxU;
  public String Gyg;
  public String Gyh;
  public int Gyi;
  public int Gyj;
  public String Gyk;
  public String Gyl;
  public String Gym;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GxS);
      if (this.GxT != null) {
        paramVarArgs.d(2, this.GxT);
      }
      if (this.Gyg != null) {
        paramVarArgs.d(3, this.Gyg);
      }
      if (this.Gyh != null) {
        paramVarArgs.d(4, this.Gyh);
      }
      paramVarArgs.aS(5, this.Gyi);
      paramVarArgs.aS(6, this.Gyj);
      if (this.Gyk != null) {
        paramVarArgs.d(7, this.Gyk);
      }
      if (this.GxU != null) {
        paramVarArgs.d(8, this.GxU);
      }
      if (this.Gyl != null) {
        paramVarArgs.d(9, this.Gyl);
      }
      if (this.Gym != null) {
        paramVarArgs.d(10, this.Gym);
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GxS) + 0;
      paramInt = i;
      if (this.GxT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GxT);
      }
      i = paramInt;
      if (this.Gyg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gyg);
      }
      paramInt = i;
      if (this.Gyh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gyh);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gyi) + f.a.a.b.b.a.bz(6, this.Gyj);
      paramInt = i;
      if (this.Gyk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gyk);
      }
      i = paramInt;
      if (this.GxU != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GxU);
      }
      paramInt = i;
      if (this.Gyl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gyl);
      }
      i = paramInt;
      if (this.Gym != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Gym);
      }
      AppMethodBeat.o(32206);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ain localain = (ain)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32206);
        return -1;
      case 1: 
        localain.GxS = locala.OmT.zc();
        AppMethodBeat.o(32206);
        return 0;
      case 2: 
        localain.GxT = locala.OmT.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 3: 
        localain.Gyg = locala.OmT.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 4: 
        localain.Gyh = locala.OmT.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 5: 
        localain.Gyi = locala.OmT.zc();
        AppMethodBeat.o(32206);
        return 0;
      case 6: 
        localain.Gyj = locala.OmT.zc();
        AppMethodBeat.o(32206);
        return 0;
      case 7: 
        localain.Gyk = locala.OmT.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 8: 
        localain.GxU = locala.OmT.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 9: 
        localain.Gyl = locala.OmT.readString();
        AppMethodBeat.o(32206);
        return 0;
      }
      localain.Gym = locala.OmT.readString();
      AppMethodBeat.o(32206);
      return 0;
    }
    AppMethodBeat.o(32206);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ain
 * JD-Core Version:    0.7.0.1
 */