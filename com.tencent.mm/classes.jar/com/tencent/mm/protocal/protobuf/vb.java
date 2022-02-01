package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vb
  extends com.tencent.mm.bx.a
{
  public String Zbb;
  public LinkedList<String> Zbc;
  
  public vb()
  {
    AppMethodBeat.i(72427);
    this.Zbc = new LinkedList();
    AppMethodBeat.o(72427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72428);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zbb != null) {
        paramVarArgs.g(1, this.Zbb);
      }
      paramVarArgs.e(2, 1, this.Zbc);
      AppMethodBeat.o(72428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zbb == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zbb) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.Zbc);
      AppMethodBeat.o(72428);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zbc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72428);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        vb localvb = (vb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72428);
          return -1;
        case 1: 
          localvb.Zbb = locala.ajGk.readString();
          AppMethodBeat.o(72428);
          return 0;
        }
        localvb.Zbc.add(locala.ajGk.readString());
        AppMethodBeat.o(72428);
        return 0;
      }
      AppMethodBeat.o(72428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vb
 * JD-Core Version:    0.7.0.1
 */