package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class glo
  extends com.tencent.mm.bx.a
{
  public boolean acgV;
  public String ache;
  public b achf;
  public int achg;
  public int achh;
  public int achi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50123);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.acgV);
      if (this.ache != null) {
        paramVarArgs.g(2, this.ache);
      }
      if (this.achf != null) {
        paramVarArgs.d(3, this.achf);
      }
      paramVarArgs.bS(4, this.achg);
      paramVarArgs.bS(5, this.achh);
      paramVarArgs.bS(6, this.achi);
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.ache != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ache);
      }
      i = paramInt;
      if (this.achf != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.achf);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.achg);
      int j = i.a.a.b.b.a.cJ(5, this.achh);
      int k = i.a.a.b.b.a.cJ(6, this.achi);
      AppMethodBeat.o(50123);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      glo localglo = (glo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50123);
        return -1;
      case 1: 
        localglo.acgV = locala.ajGk.aai();
        AppMethodBeat.o(50123);
        return 0;
      case 2: 
        localglo.ache = locala.ajGk.readString();
        AppMethodBeat.o(50123);
        return 0;
      case 3: 
        localglo.achf = locala.ajGk.kFX();
        AppMethodBeat.o(50123);
        return 0;
      case 4: 
        localglo.achg = locala.ajGk.aar();
        AppMethodBeat.o(50123);
        return 0;
      case 5: 
        localglo.achh = locala.ajGk.aar();
        AppMethodBeat.o(50123);
        return 0;
      }
      localglo.achi = locala.ajGk.aar();
      AppMethodBeat.o(50123);
      return 0;
    }
    AppMethodBeat.o(50123);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glo
 * JD-Core Version:    0.7.0.1
 */