package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ji
  extends com.tencent.mm.bx.a
{
  public String JFk;
  public String MDt;
  public String VxX;
  public String YLA;
  public String YLB;
  public String YLC;
  public String YLz;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91355);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLz != null) {
        paramVarArgs.g(1, this.YLz);
      }
      if (this.VxX != null) {
        paramVarArgs.g(2, this.VxX);
      }
      if (this.hAk != null) {
        paramVarArgs.g(3, this.hAk);
      }
      if (this.MDt != null) {
        paramVarArgs.g(4, this.MDt);
      }
      if (this.JFk != null) {
        paramVarArgs.g(5, this.JFk);
      }
      if (this.YLA != null) {
        paramVarArgs.g(6, this.YLA);
      }
      if (this.YLB != null) {
        paramVarArgs.g(7, this.YLB);
      }
      if (this.YLC != null) {
        paramVarArgs.g(8, this.YLC);
      }
      AppMethodBeat.o(91355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YLz == null) {
        break label638;
      }
    }
    label638:
    for (int i = i.a.a.b.b.a.h(1, this.YLz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.VxX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.VxX);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAk);
      }
      paramInt = i;
      if (this.MDt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MDt);
      }
      i = paramInt;
      if (this.JFk != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.JFk);
      }
      paramInt = i;
      if (this.YLA != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YLA);
      }
      i = paramInt;
      if (this.YLB != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YLB);
      }
      paramInt = i;
      if (this.YLC != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YLC);
      }
      AppMethodBeat.o(91355);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91355);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ji localji = (ji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91355);
          return -1;
        case 1: 
          localji.YLz = locala.ajGk.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 2: 
          localji.VxX = locala.ajGk.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 3: 
          localji.hAk = locala.ajGk.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 4: 
          localji.MDt = locala.ajGk.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 5: 
          localji.JFk = locala.ajGk.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 6: 
          localji.YLA = locala.ajGk.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 7: 
          localji.YLB = locala.ajGk.readString();
          AppMethodBeat.o(91355);
          return 0;
        }
        localji.YLC = locala.ajGk.readString();
        AppMethodBeat.o(91355);
        return 0;
      }
      AppMethodBeat.o(91355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ji
 * JD-Core Version:    0.7.0.1
 */