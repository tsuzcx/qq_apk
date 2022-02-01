package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aem
  extends com.tencent.mm.bx.a
{
  public int Gcr;
  public LinkedList<aaf> Gcs;
  public String oxN;
  public String title;
  
  public aem()
  {
    AppMethodBeat.i(113996);
    this.Gcs = new LinkedList();
    AppMethodBeat.o(113996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113997);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.oxN != null) {
        paramVarArgs.d(2, this.oxN);
      }
      paramVarArgs.aS(3, this.Gcr);
      paramVarArgs.e(4, 8, this.Gcs);
      AppMethodBeat.o(113997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oxN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oxN);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Gcr);
      int j = f.a.a.a.c(4, 8, this.Gcs);
      AppMethodBeat.o(113997);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gcs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aem localaem = (aem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113997);
          return -1;
        case 1: 
          localaem.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 2: 
          localaem.oxN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 3: 
          localaem.Gcr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113997);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaem.Gcs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      AppMethodBeat.o(113997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aem
 * JD-Core Version:    0.7.0.1
 */