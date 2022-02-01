package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aub
  extends com.tencent.mm.bx.a
{
  public long Gsd;
  public LinkedList<bod> Gse;
  public LinkedList<dwc> Gsf;
  public String name;
  public long startTime;
  
  public aub()
  {
    AppMethodBeat.i(122499);
    this.startTime = -1L;
    this.Gsd = 0L;
    this.Gse = new LinkedList();
    this.Gsf = new LinkedList();
    AppMethodBeat.o(122499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      paramVarArgs.aY(2, this.startTime);
      paramVarArgs.aY(3, this.Gsd);
      paramVarArgs.e(4, 8, this.Gse);
      paramVarArgs.e(5, 8, this.Gsf);
      AppMethodBeat.o(122500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.b.b.a.e(1, this.name) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.startTime);
      int j = f.a.a.b.b.a.p(3, this.Gsd);
      int k = f.a.a.a.c(4, 8, this.Gse);
      int m = f.a.a.a.c(5, 8, this.Gsf);
      AppMethodBeat.o(122500);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gse.clear();
        this.Gsf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aub localaub = (aub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122500);
          return -1;
        case 1: 
          localaub.name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122500);
          return 0;
        case 2: 
          localaub.startTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122500);
          return 0;
        case 3: 
          localaub.Gsd = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122500);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaub.Gse.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122500);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaub.Gsf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      AppMethodBeat.o(122500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aub
 * JD-Core Version:    0.7.0.1
 */