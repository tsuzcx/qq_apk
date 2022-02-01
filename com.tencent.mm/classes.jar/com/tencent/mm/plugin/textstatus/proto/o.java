package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public String ToB;
  public String ToW;
  public long Tpa;
  public int Tpb;
  public int action;
  public String tag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290023);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.action);
      if (this.tag != null) {
        paramVarArgs.g(2, this.tag);
      }
      if (this.ToB != null) {
        paramVarArgs.g(3, this.ToB);
      }
      paramVarArgs.bv(4, this.Tpa);
      if (this.ToW != null) {
        paramVarArgs.g(5, this.ToW);
      }
      paramVarArgs.bS(6, this.Tpb);
      AppMethodBeat.o(290023);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.action) + 0;
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.tag);
      }
      i = paramInt;
      if (this.ToB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ToB);
      }
      i += i.a.a.b.b.a.q(4, this.Tpa);
      paramInt = i;
      if (this.ToW != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ToW);
      }
      i = i.a.a.b.b.a.cJ(6, this.Tpb);
      AppMethodBeat.o(290023);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290023);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(290023);
        return -1;
      case 1: 
        localo.action = locala.ajGk.aar();
        AppMethodBeat.o(290023);
        return 0;
      case 2: 
        localo.tag = locala.ajGk.readString();
        AppMethodBeat.o(290023);
        return 0;
      case 3: 
        localo.ToB = locala.ajGk.readString();
        AppMethodBeat.o(290023);
        return 0;
      case 4: 
        localo.Tpa = locala.ajGk.aaw();
        AppMethodBeat.o(290023);
        return 0;
      case 5: 
        localo.ToW = locala.ajGk.readString();
        AppMethodBeat.o(290023);
        return 0;
      }
      localo.Tpb = locala.ajGk.aar();
      AppMethodBeat.o(290023);
      return 0;
    }
    AppMethodBeat.o(290023);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.o
 * JD-Core Version:    0.7.0.1
 */