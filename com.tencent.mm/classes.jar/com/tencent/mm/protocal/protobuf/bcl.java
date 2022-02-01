package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bcl
  extends com.tencent.mm.bx.a
{
  public long ZNj;
  public String ZNw;
  public String ZNx;
  public b ZwY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259385);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZNj);
      if (this.ZNw != null) {
        paramVarArgs.g(2, this.ZNw);
      }
      if (this.ZwY != null) {
        paramVarArgs.d(3, this.ZwY);
      }
      if (this.ZNx != null) {
        paramVarArgs.g(4, this.ZNx);
      }
      AppMethodBeat.o(259385);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ZNj) + 0;
      paramInt = i;
      if (this.ZNw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZNw);
      }
      i = paramInt;
      if (this.ZwY != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZwY);
      }
      paramInt = i;
      if (this.ZNx != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZNx);
      }
      AppMethodBeat.o(259385);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259385);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bcl localbcl = (bcl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259385);
        return -1;
      case 1: 
        localbcl.ZNj = locala.ajGk.aaw();
        AppMethodBeat.o(259385);
        return 0;
      case 2: 
        localbcl.ZNw = locala.ajGk.readString();
        AppMethodBeat.o(259385);
        return 0;
      case 3: 
        localbcl.ZwY = locala.ajGk.kFX();
        AppMethodBeat.o(259385);
        return 0;
      }
      localbcl.ZNx = locala.ajGk.readString();
      AppMethodBeat.o(259385);
      return 0;
    }
    AppMethodBeat.o(259385);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcl
 * JD-Core Version:    0.7.0.1
 */