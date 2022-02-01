package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dta
  extends com.tencent.mm.bx.a
{
  public String EHI;
  public LinkedList<String> EHJ;
  
  public dta()
  {
    AppMethodBeat.i(188752);
    this.EHJ = new LinkedList();
    AppMethodBeat.o(188752);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188753);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EHI != null) {
        paramVarArgs.d(1, this.EHI);
      }
      paramVarArgs.e(2, 1, this.EHJ);
      AppMethodBeat.o(188753);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EHI == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.EHI) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.EHJ);
      AppMethodBeat.o(188753);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EHJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(188753);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dta localdta = (dta)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188753);
          return -1;
        case 1: 
          localdta.EHI = locala.KhF.readString();
          AppMethodBeat.o(188753);
          return 0;
        }
        localdta.EHJ.add(locala.KhF.readString());
        AppMethodBeat.o(188753);
        return 0;
      }
      AppMethodBeat.o(188753);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dta
 * JD-Core Version:    0.7.0.1
 */