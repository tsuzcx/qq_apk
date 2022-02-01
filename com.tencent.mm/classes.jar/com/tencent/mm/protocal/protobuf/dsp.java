package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsp
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> DmV;
  public String key;
  
  public dsp()
  {
    AppMethodBeat.i(193015);
    this.DmV = new LinkedList();
    AppMethodBeat.o(193015);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193016);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(193016);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      paramVarArgs.e(2, 1, this.DmV);
      AppMethodBeat.o(193016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.DmV);
      AppMethodBeat.o(193016);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DmV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(193016);
          throw paramVarArgs;
        }
        AppMethodBeat.o(193016);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsp localdsp = (dsp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(193016);
          return -1;
        case 1: 
          localdsp.key = locala.KhF.readString();
          AppMethodBeat.o(193016);
          return 0;
        }
        localdsp.DmV.add(locala.KhF.readString());
        AppMethodBeat.o(193016);
        return 0;
      }
      AppMethodBeat.o(193016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsp
 * JD-Core Version:    0.7.0.1
 */