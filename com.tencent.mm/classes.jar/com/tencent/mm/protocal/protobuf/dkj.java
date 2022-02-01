package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkj
  extends com.tencent.mm.bx.a
{
  public int EAa;
  public String dlB;
  public String gGR;
  public String title;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176157);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      paramVarArgs.aR(3, this.version);
      if (this.gGR != null) {
        paramVarArgs.d(4, this.gGR);
      }
      paramVarArgs.aR(5, this.EAa);
      AppMethodBeat.o(176157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlB);
      }
      i += f.a.a.b.b.a.bA(3, this.version);
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gGR);
      }
      i = f.a.a.b.b.a.bA(5, this.EAa);
      AppMethodBeat.o(176157);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(176157);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dkj localdkj = (dkj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176157);
          return -1;
        case 1: 
          localdkj.title = locala.KhF.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 2: 
          localdkj.dlB = locala.KhF.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 3: 
          localdkj.version = locala.KhF.xS();
          AppMethodBeat.o(176157);
          return 0;
        case 4: 
          localdkj.gGR = locala.KhF.readString();
          AppMethodBeat.o(176157);
          return 0;
        }
        localdkj.EAa = locala.KhF.xS();
        AppMethodBeat.o(176157);
        return 0;
      }
      AppMethodBeat.o(176157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkj
 * JD-Core Version:    0.7.0.1
 */