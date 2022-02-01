package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nm
  extends com.tencent.mm.bx.a
{
  public String CLe;
  public int CLf;
  public String CLg;
  public int CLh;
  public LinkedList<lo> CLi;
  
  public nm()
  {
    AppMethodBeat.i(152509);
    this.CLi = new LinkedList();
    AppMethodBeat.o(152509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLe != null) {
        paramVarArgs.d(1, this.CLe);
      }
      paramVarArgs.aR(2, this.CLf);
      if (this.CLg != null) {
        paramVarArgs.d(3, this.CLg);
      }
      paramVarArgs.aR(4, this.CLh);
      paramVarArgs.e(5, 8, this.CLi);
      AppMethodBeat.o(152510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLe == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.b.b.a.e(1, this.CLe) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CLf);
      paramInt = i;
      if (this.CLg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CLg);
      }
      i = f.a.a.b.b.a.bA(4, this.CLh);
      int j = f.a.a.a.c(5, 8, this.CLi);
      AppMethodBeat.o(152510);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CLi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nm localnm = (nm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152510);
          return -1;
        case 1: 
          localnm.CLe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 2: 
          localnm.CLf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152510);
          return 0;
        case 3: 
          localnm.CLg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 4: 
          localnm.CLh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152510);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((lo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnm.CLi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      AppMethodBeat.o(152510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nm
 * JD-Core Version:    0.7.0.1
 */