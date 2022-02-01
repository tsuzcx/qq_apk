package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class beo
  extends com.tencent.mm.cd.a
{
  public String fFa;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String scene;
  public String username;
  public long xbT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169012);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.opType);
      paramVarArgs.bm(2, this.refObjectId);
      paramVarArgs.bm(3, this.xbT);
      if (this.username != null) {
        paramVarArgs.f(4, this.username);
      }
      if (this.fFa != null) {
        paramVarArgs.f(5, this.fFa);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.f(6, this.refObjectNonceId);
      }
      if (this.scene != null) {
        paramVarArgs.f(7, this.scene);
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.opType) + 0 + g.a.a.b.b.a.p(2, this.refObjectId) + g.a.a.b.b.a.p(3, this.xbT);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.username);
      }
      i = paramInt;
      if (this.fFa != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fFa);
      }
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.scene != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.scene);
      }
      AppMethodBeat.o(169012);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      beo localbeo = (beo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169012);
        return -1;
      case 1: 
        localbeo.opType = locala.abFh.AK();
        AppMethodBeat.o(169012);
        return 0;
      case 2: 
        localbeo.refObjectId = locala.abFh.AN();
        AppMethodBeat.o(169012);
        return 0;
      case 3: 
        localbeo.xbT = locala.abFh.AN();
        AppMethodBeat.o(169012);
        return 0;
      case 4: 
        localbeo.username = locala.abFh.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 5: 
        localbeo.fFa = locala.abFh.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 6: 
        localbeo.refObjectNonceId = locala.abFh.readString();
        AppMethodBeat.o(169012);
        return 0;
      }
      localbeo.scene = locala.abFh.readString();
      AppMethodBeat.o(169012);
      return 0;
    }
    AppMethodBeat.o(169012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beo
 * JD-Core Version:    0.7.0.1
 */