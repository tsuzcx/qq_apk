package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dge
  extends com.tencent.mm.bw.a
{
  public int ESL;
  public String EaV;
  public String FPr;
  public long FPs;
  public LinkedList<String> FPy;
  public String FPz;
  
  public dge()
  {
    AppMethodBeat.i(124560);
    this.FPy = new LinkedList();
    AppMethodBeat.o(124560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FPs);
      if (this.EaV != null) {
        paramVarArgs.d(2, this.EaV);
      }
      paramVarArgs.e(3, 1, this.FPy);
      if (this.FPr != null) {
        paramVarArgs.d(4, this.FPr);
      }
      if (this.FPz != null) {
        paramVarArgs.d(5, this.FPz);
      }
      paramVarArgs.aR(6, this.ESL);
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FPs) + 0;
      paramInt = i;
      if (this.EaV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EaV);
      }
      i = paramInt + f.a.a.a.c(3, 1, this.FPy);
      paramInt = i;
      if (this.FPr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FPr);
      }
      i = paramInt;
      if (this.FPz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FPz);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.ESL);
      AppMethodBeat.o(124561);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FPy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dge localdge = (dge)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124561);
        return -1;
      case 1: 
        localdge.FPs = locala.LVo.xG();
        AppMethodBeat.o(124561);
        return 0;
      case 2: 
        localdge.EaV = locala.LVo.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 3: 
        localdge.FPy.add(locala.LVo.readString());
        AppMethodBeat.o(124561);
        return 0;
      case 4: 
        localdge.FPr = locala.LVo.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 5: 
        localdge.FPz = locala.LVo.readString();
        AppMethodBeat.o(124561);
        return 0;
      }
      localdge.ESL = locala.LVo.xF();
      AppMethodBeat.o(124561);
      return 0;
    }
    AppMethodBeat.o(124561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dge
 * JD-Core Version:    0.7.0.1
 */