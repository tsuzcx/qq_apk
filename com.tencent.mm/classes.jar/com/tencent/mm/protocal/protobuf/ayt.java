package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayt
  extends com.tencent.mm.bw.a
{
  public String dMj;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String scene;
  public long tuj;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169012);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.opType);
      paramVarArgs.bb(2, this.refObjectId);
      paramVarArgs.bb(3, this.tuj);
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      if (this.dMj != null) {
        paramVarArgs.e(5, this.dMj);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.e(6, this.refObjectNonceId);
      }
      if (this.scene != null) {
        paramVarArgs.e(7, this.scene);
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.opType) + 0 + g.a.a.b.b.a.r(2, this.refObjectId) + g.a.a.b.b.a.r(3, this.tuj);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.username);
      }
      i = paramInt;
      if (this.dMj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dMj);
      }
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.scene != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.scene);
      }
      AppMethodBeat.o(169012);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ayt localayt = (ayt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169012);
        return -1;
      case 1: 
        localayt.opType = locala.UbS.zi();
        AppMethodBeat.o(169012);
        return 0;
      case 2: 
        localayt.refObjectId = locala.UbS.zl();
        AppMethodBeat.o(169012);
        return 0;
      case 3: 
        localayt.tuj = locala.UbS.zl();
        AppMethodBeat.o(169012);
        return 0;
      case 4: 
        localayt.username = locala.UbS.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 5: 
        localayt.dMj = locala.UbS.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 6: 
        localayt.refObjectNonceId = locala.UbS.readString();
        AppMethodBeat.o(169012);
        return 0;
      }
      localayt.scene = locala.UbS.readString();
      AppMethodBeat.o(169012);
      return 0;
    }
    AppMethodBeat.o(169012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayt
 * JD-Core Version:    0.7.0.1
 */