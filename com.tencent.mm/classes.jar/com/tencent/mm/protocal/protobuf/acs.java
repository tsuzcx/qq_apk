package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acs
  extends com.tencent.mm.cd.a
{
  public String Ooe;
  public String Soo;
  public String Sop;
  public int jump_type;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255125);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Soo != null) {
        paramVarArgs.f(1, this.Soo);
      }
      if (this.Sop != null) {
        paramVarArgs.f(2, this.Sop);
      }
      paramVarArgs.aY(3, this.jump_type);
      if (this.jump_url != null) {
        paramVarArgs.f(4, this.jump_url);
      }
      if (this.Ooe != null) {
        paramVarArgs.f(5, this.Ooe);
      }
      AppMethodBeat.o(255125);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Soo == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.g(1, this.Soo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Sop != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Sop);
      }
      i += g.a.a.b.b.a.bM(3, this.jump_type);
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jump_url);
      }
      i = paramInt;
      if (this.Ooe != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Ooe);
      }
      AppMethodBeat.o(255125);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(255125);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        acs localacs = (acs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(255125);
          return -1;
        case 1: 
          localacs.Soo = locala.abFh.readString();
          AppMethodBeat.o(255125);
          return 0;
        case 2: 
          localacs.Sop = locala.abFh.readString();
          AppMethodBeat.o(255125);
          return 0;
        case 3: 
          localacs.jump_type = locala.abFh.AK();
          AppMethodBeat.o(255125);
          return 0;
        case 4: 
          localacs.jump_url = locala.abFh.readString();
          AppMethodBeat.o(255125);
          return 0;
        }
        localacs.Ooe = locala.abFh.readString();
        AppMethodBeat.o(255125);
        return 0;
      }
      AppMethodBeat.o(255125);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acs
 * JD-Core Version:    0.7.0.1
 */