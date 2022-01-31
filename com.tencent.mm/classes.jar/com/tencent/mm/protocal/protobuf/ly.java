package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ly
  extends com.tencent.mm.bv.a
{
  public String Title;
  public int wAr;
  public String wAs;
  public String wxi;
  public int wyS;
  public int wyT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151386);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wyS);
      paramVarArgs.aO(2, this.wyT);
      paramVarArgs.aO(3, this.wAr);
      if (this.Title != null) {
        paramVarArgs.e(4, this.Title);
      }
      if (this.wAs != null) {
        paramVarArgs.e(5, this.wAs);
      }
      if (this.wxi != null) {
        paramVarArgs.e(6, this.wxi);
      }
      AppMethodBeat.o(151386);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wyS) + 0 + e.a.a.b.b.a.bl(2, this.wyT) + e.a.a.b.b.a.bl(3, this.wAr);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Title);
      }
      i = paramInt;
      if (this.wAs != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wAs);
      }
      paramInt = i;
      if (this.wxi != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wxi);
      }
      AppMethodBeat.o(151386);
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
      AppMethodBeat.o(151386);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ly locally = (ly)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151386);
        return -1;
      case 1: 
        locally.wyS = locala.CLY.sl();
        AppMethodBeat.o(151386);
        return 0;
      case 2: 
        locally.wyT = locala.CLY.sl();
        AppMethodBeat.o(151386);
        return 0;
      case 3: 
        locally.wAr = locala.CLY.sl();
        AppMethodBeat.o(151386);
        return 0;
      case 4: 
        locally.Title = locala.CLY.readString();
        AppMethodBeat.o(151386);
        return 0;
      case 5: 
        locally.wAs = locala.CLY.readString();
        AppMethodBeat.o(151386);
        return 0;
      }
      locally.wxi = locala.CLY.readString();
      AppMethodBeat.o(151386);
      return 0;
    }
    AppMethodBeat.o(151386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ly
 * JD-Core Version:    0.7.0.1
 */