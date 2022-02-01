package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejm
  extends com.tencent.mm.bw.a
{
  public String Ims;
  public LinkedList<ejl> Imt;
  
  public ejm()
  {
    AppMethodBeat.i(153332);
    this.Imt = new LinkedList();
    AppMethodBeat.o(153332);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ims != null) {
        paramVarArgs.d(1, this.Ims);
      }
      paramVarArgs.e(2, 8, this.Imt);
      AppMethodBeat.o(153333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ims == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ims) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Imt);
      AppMethodBeat.o(153333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Imt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ejm localejm = (ejm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153333);
          return -1;
        case 1: 
          localejm.Ims = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153333);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ejl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localejm.Imt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153333);
        return 0;
      }
      AppMethodBeat.o(153333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejm
 * JD-Core Version:    0.7.0.1
 */