package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cib
  extends com.tencent.mm.bx.a
{
  public cic Dyf;
  public String Edt;
  public String content;
  public String gGP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168758);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.gGP != null) {
        paramVarArgs.d(2, this.gGP);
      }
      if (this.Edt != null) {
        paramVarArgs.d(3, this.Edt);
      }
      if (this.Dyf != null)
      {
        paramVarArgs.kX(4, this.Dyf.computeSize());
        this.Dyf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gGP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gGP);
      }
      i = paramInt;
      if (this.Edt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Edt);
      }
      paramInt = i;
      if (this.Dyf != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dyf.computeSize());
      }
      AppMethodBeat.o(168758);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cib localcib = (cib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168758);
          return -1;
        case 1: 
          localcib.content = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 2: 
          localcib.gGP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 3: 
          localcib.Edt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168758);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cic();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcib.Dyf = ((cic)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      AppMethodBeat.o(168758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cib
 * JD-Core Version:    0.7.0.1
 */