package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apy
  extends com.tencent.mm.bw.a
{
  public String GEH;
  public int opType;
  public long rQR;
  public long refObjectId;
  public String refObjectNonceId;
  public String scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169012);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.opType);
      paramVarArgs.aZ(2, this.refObjectId);
      paramVarArgs.aZ(3, this.rQR);
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.GEH != null) {
        paramVarArgs.d(5, this.GEH);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.scene != null) {
        paramVarArgs.d(7, this.scene);
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.opType) + 0 + f.a.a.b.b.a.p(2, this.refObjectId) + f.a.a.b.b.a.p(3, this.rQR);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      i = paramInt;
      if (this.GEH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GEH);
      }
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.scene != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.scene);
      }
      AppMethodBeat.o(169012);
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
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apy localapy = (apy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169012);
        return -1;
      case 1: 
        localapy.opType = locala.OmT.zc();
        AppMethodBeat.o(169012);
        return 0;
      case 2: 
        localapy.refObjectId = locala.OmT.zd();
        AppMethodBeat.o(169012);
        return 0;
      case 3: 
        localapy.rQR = locala.OmT.zd();
        AppMethodBeat.o(169012);
        return 0;
      case 4: 
        localapy.username = locala.OmT.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 5: 
        localapy.GEH = locala.OmT.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 6: 
        localapy.refObjectNonceId = locala.OmT.readString();
        AppMethodBeat.o(169012);
        return 0;
      }
      localapy.scene = locala.OmT.readString();
      AppMethodBeat.o(169012);
      return 0;
    }
    AppMethodBeat.o(169012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apy
 * JD-Core Version:    0.7.0.1
 */