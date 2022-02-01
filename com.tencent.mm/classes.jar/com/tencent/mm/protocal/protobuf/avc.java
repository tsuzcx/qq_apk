package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class avc
  extends com.tencent.mm.bx.a
{
  public String Gtl;
  public LinkedList<String> Gtp;
  public LinkedList<avd> Gtq;
  
  public avc()
  {
    AppMethodBeat.i(195471);
    this.Gtp = new LinkedList();
    this.Gtq = new LinkedList();
    AppMethodBeat.o(195471);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gtl != null) {
        paramVarArgs.d(1, this.Gtl);
      }
      paramVarArgs.e(2, 1, this.Gtp);
      paramVarArgs.e(3, 8, this.Gtq);
      AppMethodBeat.o(195472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gtl == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gtl) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.Gtp);
      int j = f.a.a.a.c(3, 8, this.Gtq);
      AppMethodBeat.o(195472);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gtp.clear();
        this.Gtq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(195472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avc localavc = (avc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195472);
          return -1;
        case 1: 
          localavc.Gtl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(195472);
          return 0;
        case 2: 
          localavc.Gtp.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(195472);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavc.Gtq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195472);
        return 0;
      }
      AppMethodBeat.o(195472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avc
 * JD-Core Version:    0.7.0.1
 */