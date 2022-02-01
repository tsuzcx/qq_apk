package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bx.a
{
  public String ToW;
  public String ToX;
  public String ToY;
  public LinkedList<String> ToZ;
  
  public n()
  {
    AppMethodBeat.i(290012);
    this.ToZ = new LinkedList();
    AppMethodBeat.o(290012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290019);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ToW != null) {
        paramVarArgs.g(1, this.ToW);
      }
      if (this.ToX != null) {
        paramVarArgs.g(2, this.ToX);
      }
      if (this.ToY != null) {
        paramVarArgs.g(3, this.ToY);
      }
      paramVarArgs.e(4, 1, this.ToZ);
      AppMethodBeat.o(290019);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ToW == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.ToW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ToX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ToX);
      }
      i = paramInt;
      if (this.ToY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ToY);
      }
      paramInt = i.a.a.a.c(4, 1, this.ToZ);
      AppMethodBeat.o(290019);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ToZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290019);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(290019);
          return -1;
        case 1: 
          localn.ToW = locala.ajGk.readString();
          AppMethodBeat.o(290019);
          return 0;
        case 2: 
          localn.ToX = locala.ajGk.readString();
          AppMethodBeat.o(290019);
          return 0;
        case 3: 
          localn.ToY = locala.ajGk.readString();
          AppMethodBeat.o(290019);
          return 0;
        }
        localn.ToZ.add(locala.ajGk.readString());
        AppMethodBeat.o(290019);
        return 0;
      }
      AppMethodBeat.o(290019);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.n
 * JD-Core Version:    0.7.0.1
 */