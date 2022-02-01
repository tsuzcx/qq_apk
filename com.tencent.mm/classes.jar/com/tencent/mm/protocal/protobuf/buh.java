package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buh
  extends com.tencent.mm.bw.a
{
  public float GgZ;
  public float Gha;
  public int Gzf;
  public String Gzg;
  public String Gzh;
  public int Gzi;
  public String HhG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.GgZ);
      paramVarArgs.y(2, this.Gha);
      paramVarArgs.aS(3, this.Gzf);
      if (this.Gzg != null) {
        paramVarArgs.d(4, this.Gzg);
      }
      if (this.Gzh != null) {
        paramVarArgs.d(5, this.Gzh);
      }
      paramVarArgs.aS(6, this.Gzi);
      if (this.HhG != null) {
        paramVarArgs.d(7, this.HhG);
      }
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amE(1) + 0 + f.a.a.b.b.a.amE(2) + f.a.a.b.b.a.bz(3, this.Gzf);
      paramInt = i;
      if (this.Gzg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gzg);
      }
      i = paramInt;
      if (this.Gzh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gzh);
      }
      i += f.a.a.b.b.a.bz(6, this.Gzi);
      paramInt = i;
      if (this.HhG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HhG);
      }
      AppMethodBeat.o(117875);
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
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      buh localbuh = (buh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117875);
        return -1;
      case 1: 
        localbuh.GgZ = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(117875);
        return 0;
      case 2: 
        localbuh.Gha = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(117875);
        return 0;
      case 3: 
        localbuh.Gzf = locala.OmT.zc();
        AppMethodBeat.o(117875);
        return 0;
      case 4: 
        localbuh.Gzg = locala.OmT.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 5: 
        localbuh.Gzh = locala.OmT.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 6: 
        localbuh.Gzi = locala.OmT.zc();
        AppMethodBeat.o(117875);
        return 0;
      }
      localbuh.HhG = locala.OmT.readString();
      AppMethodBeat.o(117875);
      return 0;
    }
    AppMethodBeat.o(117875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buh
 * JD-Core Version:    0.7.0.1
 */