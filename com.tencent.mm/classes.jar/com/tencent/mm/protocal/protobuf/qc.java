package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qc
  extends com.tencent.mm.bx.a
{
  public String CPb;
  public LinkedList<String> CPc;
  
  public qc()
  {
    AppMethodBeat.i(72427);
    this.CPc = new LinkedList();
    AppMethodBeat.o(72427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CPb != null) {
        paramVarArgs.d(1, this.CPb);
      }
      paramVarArgs.e(2, 1, this.CPc);
      AppMethodBeat.o(72428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CPb == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.CPb) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.CPc);
      AppMethodBeat.o(72428);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72428);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qc localqc = (qc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72428);
          return -1;
        case 1: 
          localqc.CPb = locala.KhF.readString();
          AppMethodBeat.o(72428);
          return 0;
        }
        localqc.CPc.add(locala.KhF.readString());
        AppMethodBeat.o(72428);
        return 0;
      }
      AppMethodBeat.o(72428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qc
 * JD-Core Version:    0.7.0.1
 */