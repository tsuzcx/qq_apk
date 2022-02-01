package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vz
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Eqp;
  public String Eqq;
  
  public vz()
  {
    AppMethodBeat.i(152518);
    this.Eqp = new LinkedList();
    AppMethodBeat.o(152518);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Eqp);
      if (this.Eqq != null) {
        paramVarArgs.d(2, this.Eqq);
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.a.c(1, 1, this.Eqp) + 0;
      paramInt = i;
      if (this.Eqq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eqq);
      }
      AppMethodBeat.o(152519);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eqp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      vz localvz = (vz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152519);
        return -1;
      case 1: 
        localvz.Eqp.add(locala.LVo.readString());
        AppMethodBeat.o(152519);
        return 0;
      }
      localvz.Eqq = locala.LVo.readString();
      AppMethodBeat.o(152519);
      return 0;
    }
    AppMethodBeat.o(152519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vz
 * JD-Core Version:    0.7.0.1
 */