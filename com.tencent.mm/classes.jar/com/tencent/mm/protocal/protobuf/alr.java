package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alr
  extends com.tencent.mm.cd.a
{
  public String Sps;
  public String Spt;
  public String Spu;
  public String Spv;
  public String Spw;
  public String SvW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231406);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SvW != null) {
        paramVarArgs.f(1, this.SvW);
      }
      if (this.Sps != null) {
        paramVarArgs.f(2, this.Sps);
      }
      if (this.Spt != null) {
        paramVarArgs.f(3, this.Spt);
      }
      if (this.Spu != null) {
        paramVarArgs.f(4, this.Spu);
      }
      if (this.Spv != null) {
        paramVarArgs.f(5, this.Spv);
      }
      if (this.Spw != null) {
        paramVarArgs.f(6, this.Spw);
      }
      AppMethodBeat.o(231406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SvW == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.g(1, this.SvW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sps != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sps);
      }
      i = paramInt;
      if (this.Spt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Spt);
      }
      paramInt = i;
      if (this.Spu != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Spu);
      }
      i = paramInt;
      if (this.Spv != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Spv);
      }
      paramInt = i;
      if (this.Spw != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Spw);
      }
      AppMethodBeat.o(231406);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231406);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        alr localalr = (alr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231406);
          return -1;
        case 1: 
          localalr.SvW = locala.abFh.readString();
          AppMethodBeat.o(231406);
          return 0;
        case 2: 
          localalr.Sps = locala.abFh.readString();
          AppMethodBeat.o(231406);
          return 0;
        case 3: 
          localalr.Spt = locala.abFh.readString();
          AppMethodBeat.o(231406);
          return 0;
        case 4: 
          localalr.Spu = locala.abFh.readString();
          AppMethodBeat.o(231406);
          return 0;
        case 5: 
          localalr.Spv = locala.abFh.readString();
          AppMethodBeat.o(231406);
          return 0;
        }
        localalr.Spw = locala.abFh.readString();
        AppMethodBeat.o(231406);
        return 0;
      }
      AppMethodBeat.o(231406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alr
 * JD-Core Version:    0.7.0.1
 */