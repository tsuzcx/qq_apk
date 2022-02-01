package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yb
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> GpZ;
  public String Gqa;
  
  public yb()
  {
    AppMethodBeat.i(152518);
    this.GpZ = new LinkedList();
    AppMethodBeat.o(152518);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.GpZ);
      if (this.Gqa != null) {
        paramVarArgs.d(2, this.Gqa);
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.a.c(1, 1, this.GpZ) + 0;
      paramInt = i;
      if (this.Gqa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gqa);
      }
      AppMethodBeat.o(152519);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GpZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yb localyb = (yb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152519);
        return -1;
      case 1: 
        localyb.GpZ.add(locala.OmT.readString());
        AppMethodBeat.o(152519);
        return 0;
      }
      localyb.Gqa = locala.OmT.readString();
      AppMethodBeat.o(152519);
      return 0;
    }
    AppMethodBeat.o(152519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yb
 * JD-Core Version:    0.7.0.1
 */