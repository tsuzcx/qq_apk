package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amf
  extends com.tencent.mm.bw.a
{
  public String EEs;
  public int opType;
  public long qXy;
  public long refObjectId;
  public String refObjectNonceId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169012);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.opType);
      paramVarArgs.aO(2, this.refObjectId);
      paramVarArgs.aO(3, this.qXy);
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.EEs != null) {
        paramVarArgs.d(5, this.EEs);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.opType) + 0 + f.a.a.b.b.a.p(2, this.refObjectId) + f.a.a.b.b.a.p(3, this.qXy);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      i = paramInt;
      if (this.EEs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EEs);
      }
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      AppMethodBeat.o(169012);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amf localamf = (amf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169012);
        return -1;
      case 1: 
        localamf.opType = locala.LVo.xF();
        AppMethodBeat.o(169012);
        return 0;
      case 2: 
        localamf.refObjectId = locala.LVo.xG();
        AppMethodBeat.o(169012);
        return 0;
      case 3: 
        localamf.qXy = locala.LVo.xG();
        AppMethodBeat.o(169012);
        return 0;
      case 4: 
        localamf.username = locala.LVo.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 5: 
        localamf.EEs = locala.LVo.readString();
        AppMethodBeat.o(169012);
        return 0;
      }
      localamf.refObjectNonceId = locala.LVo.readString();
      AppMethodBeat.o(169012);
      return 0;
    }
    AppMethodBeat.o(169012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amf
 * JD-Core Version:    0.7.0.1
 */