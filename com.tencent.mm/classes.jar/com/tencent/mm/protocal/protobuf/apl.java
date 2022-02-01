package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apl
  extends com.tencent.mm.bx.a
{
  public String GlF;
  public int opType;
  public long rIH;
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
      paramVarArgs.aY(2, this.refObjectId);
      paramVarArgs.aY(3, this.rIH);
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.GlF != null) {
        paramVarArgs.d(5, this.GlF);
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
      int i = f.a.a.b.b.a.bz(1, this.opType) + 0 + f.a.a.b.b.a.p(2, this.refObjectId) + f.a.a.b.b.a.p(3, this.rIH);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      i = paramInt;
      if (this.GlF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GlF);
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
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apl localapl = (apl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169012);
        return -1;
      case 1: 
        localapl.opType = locala.NPN.zc();
        AppMethodBeat.o(169012);
        return 0;
      case 2: 
        localapl.refObjectId = locala.NPN.zd();
        AppMethodBeat.o(169012);
        return 0;
      case 3: 
        localapl.rIH = locala.NPN.zd();
        AppMethodBeat.o(169012);
        return 0;
      case 4: 
        localapl.username = locala.NPN.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 5: 
        localapl.GlF = locala.NPN.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 6: 
        localapl.refObjectNonceId = locala.NPN.readString();
        AppMethodBeat.o(169012);
        return 0;
      }
      localapl.scene = locala.NPN.readString();
      AppMethodBeat.o(169012);
      return 0;
    }
    AppMethodBeat.o(169012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apl
 * JD-Core Version:    0.7.0.1
 */