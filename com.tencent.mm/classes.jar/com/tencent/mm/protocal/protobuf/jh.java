package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jh
  extends com.tencent.mm.bx.a
{
  public String VcU;
  public String VcV;
  public String VsH;
  public int jump_type;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91354);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.bS(2, this.jump_type);
      if (this.VsH != null) {
        paramVarArgs.g(3, this.VsH);
      }
      if (this.VcU != null) {
        paramVarArgs.g(4, this.VcU);
      }
      if (this.VcV != null) {
        paramVarArgs.g(5, this.VcV);
      }
      AppMethodBeat.o(91354);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.jump_type);
      paramInt = i;
      if (this.VsH != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.VsH);
      }
      i = paramInt;
      if (this.VcU != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.VcU);
      }
      paramInt = i;
      if (this.VcV != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.VcV);
      }
      AppMethodBeat.o(91354);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91354);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        jh localjh = (jh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91354);
          return -1;
        case 1: 
          localjh.title = locala.ajGk.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 2: 
          localjh.jump_type = locala.ajGk.aar();
          AppMethodBeat.o(91354);
          return 0;
        case 3: 
          localjh.VsH = locala.ajGk.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 4: 
          localjh.VcU = locala.ajGk.readString();
          AppMethodBeat.o(91354);
          return 0;
        }
        localjh.VcV = locala.ajGk.readString();
        AppMethodBeat.o(91354);
        return 0;
      }
      AppMethodBeat.o(91354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jh
 * JD-Core Version:    0.7.0.1
 */