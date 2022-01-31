package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ov
  extends com.tencent.mm.bv.a
{
  public int qNK;
  public String text;
  public int type;
  public String url;
  public String wFr;
  public int wyt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89036);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.text != null) {
        paramVarArgs.e(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      paramVarArgs.aO(4, this.qNK);
      paramVarArgs.aO(5, this.wyt);
      if (this.wFr != null) {
        paramVarArgs.e(6, this.wFr);
      }
      AppMethodBeat.o(89036);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.url);
      }
      i = i + e.a.a.b.b.a.bl(4, this.qNK) + e.a.a.b.b.a.bl(5, this.wyt);
      paramInt = i;
      if (this.wFr != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wFr);
      }
      AppMethodBeat.o(89036);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(89036);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ov localov = (ov)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89036);
        return -1;
      case 1: 
        localov.type = locala.CLY.sl();
        AppMethodBeat.o(89036);
        return 0;
      case 2: 
        localov.text = locala.CLY.readString();
        AppMethodBeat.o(89036);
        return 0;
      case 3: 
        localov.url = locala.CLY.readString();
        AppMethodBeat.o(89036);
        return 0;
      case 4: 
        localov.qNK = locala.CLY.sl();
        AppMethodBeat.o(89036);
        return 0;
      case 5: 
        localov.wyt = locala.CLY.sl();
        AppMethodBeat.o(89036);
        return 0;
      }
      localov.wFr = locala.CLY.readString();
      AppMethodBeat.o(89036);
      return 0;
    }
    AppMethodBeat.o(89036);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ov
 * JD-Core Version:    0.7.0.1
 */