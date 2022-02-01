package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abe
  extends com.tencent.mm.bw.a
{
  public int GsX;
  public int GsY;
  public String GsZ;
  public String dnM;
  public String dnN;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.version);
      paramVarArgs.aS(2, this.GsX);
      paramVarArgs.aS(3, this.GsY);
      if (this.dnN != null) {
        paramVarArgs.d(4, this.dnN);
      }
      if (this.GsZ != null) {
        paramVarArgs.d(5, this.GsZ);
      }
      if (this.dnM != null) {
        paramVarArgs.d(6, this.dnM);
      }
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.version) + 0 + f.a.a.b.b.a.bz(2, this.GsX) + f.a.a.b.b.a.bz(3, this.GsY);
      paramInt = i;
      if (this.dnN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dnN);
      }
      i = paramInt;
      if (this.GsZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GsZ);
      }
      paramInt = i;
      if (this.dnM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dnM);
      }
      AppMethodBeat.o(32169);
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
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      abe localabe = (abe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32169);
        return -1;
      case 1: 
        localabe.version = locala.OmT.zc();
        AppMethodBeat.o(32169);
        return 0;
      case 2: 
        localabe.GsX = locala.OmT.zc();
        AppMethodBeat.o(32169);
        return 0;
      case 3: 
        localabe.GsY = locala.OmT.zc();
        AppMethodBeat.o(32169);
        return 0;
      case 4: 
        localabe.dnN = locala.OmT.readString();
        AppMethodBeat.o(32169);
        return 0;
      case 5: 
        localabe.GsZ = locala.OmT.readString();
        AppMethodBeat.o(32169);
        return 0;
      }
      localabe.dnM = locala.OmT.readString();
      AppMethodBeat.o(32169);
      return 0;
    }
    AppMethodBeat.o(32169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abe
 * JD-Core Version:    0.7.0.1
 */