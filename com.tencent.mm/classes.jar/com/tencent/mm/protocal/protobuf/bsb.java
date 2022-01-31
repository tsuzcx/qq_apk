package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsb
  extends com.tencent.mm.bv.a
{
  public int Category;
  public int xFw;
  public int xFx;
  public LinkedList<String> xFy;
  public int xFz;
  
  public bsb()
  {
    AppMethodBeat.i(124334);
    this.xFy = new LinkedList();
    AppMethodBeat.o(124334);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124335);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xFw);
      paramVarArgs.aO(2, this.xFx);
      paramVarArgs.aO(3, this.Category);
      paramVarArgs.e(4, 1, this.xFy);
      paramVarArgs.aO(5, this.xFz);
      AppMethodBeat.o(124335);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xFw);
      int i = e.a.a.b.b.a.bl(2, this.xFx);
      int j = e.a.a.b.b.a.bl(3, this.Category);
      int k = e.a.a.a.c(4, 1, this.xFy);
      int m = e.a.a.b.b.a.bl(5, this.xFz);
      AppMethodBeat.o(124335);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xFy.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124335);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bsb localbsb = (bsb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124335);
        return -1;
      case 1: 
        localbsb.xFw = locala.CLY.sl();
        AppMethodBeat.o(124335);
        return 0;
      case 2: 
        localbsb.xFx = locala.CLY.sl();
        AppMethodBeat.o(124335);
        return 0;
      case 3: 
        localbsb.Category = locala.CLY.sl();
        AppMethodBeat.o(124335);
        return 0;
      case 4: 
        localbsb.xFy.add(locala.CLY.readString());
        AppMethodBeat.o(124335);
        return 0;
      }
      localbsb.xFz = locala.CLY.sl();
      AppMethodBeat.o(124335);
      return 0;
    }
    AppMethodBeat.o(124335);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsb
 * JD-Core Version:    0.7.0.1
 */