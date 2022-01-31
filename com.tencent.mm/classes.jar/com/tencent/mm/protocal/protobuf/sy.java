package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sy
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public LinkedList<String> wLs;
  public String wLt;
  public long wLu;
  
  public sy()
  {
    AppMethodBeat.i(14717);
    this.wLs = new LinkedList();
    AppMethodBeat.o(14717);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14718);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKs);
      paramVarArgs.e(2, 1, this.wLs);
      if (this.wLt != null) {
        paramVarArgs.e(3, this.wLt);
      }
      paramVarArgs.am(4, this.wLu);
      AppMethodBeat.o(14718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.jKs) + 0 + e.a.a.a.c(2, 1, this.wLs);
      paramInt = i;
      if (this.wLt != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wLt);
      }
      i = e.a.a.b.b.a.p(4, this.wLu);
      AppMethodBeat.o(14718);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wLs.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(14718);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      sy localsy = (sy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(14718);
        return -1;
      case 1: 
        localsy.jKs = locala.CLY.sl();
        AppMethodBeat.o(14718);
        return 0;
      case 2: 
        localsy.wLs.add(locala.CLY.readString());
        AppMethodBeat.o(14718);
        return 0;
      case 3: 
        localsy.wLt = locala.CLY.readString();
        AppMethodBeat.o(14718);
        return 0;
      }
      localsy.wLu = locala.CLY.sm();
      AppMethodBeat.o(14718);
      return 0;
    }
    AppMethodBeat.o(14718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sy
 * JD-Core Version:    0.7.0.1
 */