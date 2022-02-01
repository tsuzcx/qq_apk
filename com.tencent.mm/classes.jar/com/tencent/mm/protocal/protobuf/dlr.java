package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlr
  extends com.tencent.mm.bx.a
{
  public String FGE;
  public int FHR;
  public LinkedList<String> FIj;
  public long FJW;
  public String GfL;
  public String HAb;
  
  public dlr()
  {
    AppMethodBeat.i(124560);
    this.FIj = new LinkedList();
    AppMethodBeat.o(124560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FJW);
      if (this.FGE != null) {
        paramVarArgs.d(2, this.FGE);
      }
      paramVarArgs.e(3, 1, this.FIj);
      if (this.GfL != null) {
        paramVarArgs.d(4, this.GfL);
      }
      if (this.HAb != null) {
        paramVarArgs.d(5, this.HAb);
      }
      paramVarArgs.aS(6, this.FHR);
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FJW) + 0;
      paramInt = i;
      if (this.FGE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FGE);
      }
      i = paramInt + f.a.a.a.c(3, 1, this.FIj);
      paramInt = i;
      if (this.GfL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GfL);
      }
      i = paramInt;
      if (this.HAb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HAb);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.FHR);
      AppMethodBeat.o(124561);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FIj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dlr localdlr = (dlr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124561);
        return -1;
      case 1: 
        localdlr.FJW = locala.NPN.zd();
        AppMethodBeat.o(124561);
        return 0;
      case 2: 
        localdlr.FGE = locala.NPN.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 3: 
        localdlr.FIj.add(locala.NPN.readString());
        AppMethodBeat.o(124561);
        return 0;
      case 4: 
        localdlr.GfL = locala.NPN.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 5: 
        localdlr.HAb = locala.NPN.readString();
        AppMethodBeat.o(124561);
        return 0;
      }
      localdlr.FHR = locala.NPN.zc();
      AppMethodBeat.o(124561);
      return 0;
    }
    AppMethodBeat.o(124561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlr
 * JD-Core Version:    0.7.0.1
 */