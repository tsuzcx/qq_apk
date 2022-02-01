package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgj
  extends com.tencent.mm.bx.a
{
  public String YYZ;
  public boolean aaLz;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91530);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.YYZ != null) {
        paramVarArgs.g(3, this.YYZ);
      }
      paramVarArgs.di(4, this.aaLz);
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.YYZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YYZ);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(91530);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dgj localdgj = (dgj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91530);
        return -1;
      case 1: 
        localdgj.type = locala.ajGk.aar();
        AppMethodBeat.o(91530);
        return 0;
      case 2: 
        localdgj.url = locala.ajGk.readString();
        AppMethodBeat.o(91530);
        return 0;
      case 3: 
        localdgj.YYZ = locala.ajGk.readString();
        AppMethodBeat.o(91530);
        return 0;
      }
      localdgj.aaLz = locala.ajGk.aai();
      AppMethodBeat.o(91530);
      return 0;
    }
    AppMethodBeat.o(91530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgj
 * JD-Core Version:    0.7.0.1
 */