package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dl
  extends com.tencent.mm.bx.a
{
  public String FvM;
  public LinkedList<dio> FvN;
  public String title;
  
  public dl()
  {
    AppMethodBeat.i(32112);
    this.FvN = new LinkedList();
    AppMethodBeat.o(32112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FvM != null) {
        paramVarArgs.d(1, this.FvM);
      }
      paramVarArgs.e(2, 8, this.FvN);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      AppMethodBeat.o(32113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FvM == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.FvM) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FvN);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      AppMethodBeat.o(32113);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FvN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dl localdl = (dl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32113);
          return -1;
        case 1: 
          localdl.FvM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32113);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdl.FvN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32113);
          return 0;
        }
        localdl.title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32113);
        return 0;
      }
      AppMethodBeat.o(32113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dl
 * JD-Core Version:    0.7.0.1
 */