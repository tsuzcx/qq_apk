package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbf
  extends com.tencent.mm.cd.a
{
  public String RVH;
  public String UAZ;
  public String UBl;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205436);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UAZ != null) {
        paramVarArgs.f(1, this.UAZ);
      }
      if (this.RVH != null) {
        paramVarArgs.f(2, this.RVH);
      }
      if (this.UBl != null) {
        paramVarArgs.f(3, this.UBl);
      }
      paramVarArgs.aY(4, this.scene);
      AppMethodBeat.o(205436);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UAZ == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.UAZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RVH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RVH);
      }
      i = paramInt;
      if (this.UBl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UBl);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.scene);
      AppMethodBeat.o(205436);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205436);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbf localfbf = (fbf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205436);
          return -1;
        case 1: 
          localfbf.UAZ = locala.abFh.readString();
          AppMethodBeat.o(205436);
          return 0;
        case 2: 
          localfbf.RVH = locala.abFh.readString();
          AppMethodBeat.o(205436);
          return 0;
        case 3: 
          localfbf.UBl = locala.abFh.readString();
          AppMethodBeat.o(205436);
          return 0;
        }
        localfbf.scene = locala.abFh.AK();
        AppMethodBeat.o(205436);
        return 0;
      }
      AppMethodBeat.o(205436);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbf
 * JD-Core Version:    0.7.0.1
 */