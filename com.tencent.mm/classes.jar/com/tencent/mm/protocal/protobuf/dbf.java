package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbf
  extends com.tencent.mm.bx.a
{
  public String HqQ;
  public LinkedList<dbe> HqY;
  public String dtL;
  public String qXk;
  
  public dbf()
  {
    AppMethodBeat.i(122532);
    this.HqY = new LinkedList();
    AppMethodBeat.o(122532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qXk != null) {
        paramVarArgs.d(1, this.qXk);
      }
      if (this.HqQ != null) {
        paramVarArgs.d(2, this.HqQ);
      }
      if (this.dtL != null) {
        paramVarArgs.d(3, this.dtL);
      }
      paramVarArgs.e(4, 8, this.HqY);
      AppMethodBeat.o(122533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qXk == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.b.b.a.e(1, this.qXk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HqQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HqQ);
      }
      i = paramInt;
      if (this.dtL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dtL);
      }
      paramInt = f.a.a.a.c(4, 8, this.HqY);
      AppMethodBeat.o(122533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HqY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbf localdbf = (dbf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122533);
          return -1;
        case 1: 
          localdbf.qXk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 2: 
          localdbf.HqQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 3: 
          localdbf.dtL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122533);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dbe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbf.HqY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      AppMethodBeat.o(122533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbf
 * JD-Core Version:    0.7.0.1
 */