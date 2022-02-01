package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbi
  extends com.tencent.mm.bx.a
{
  public LinkedList<chj> Hra;
  public LinkedList<dwd> Hrb;
  public String dtL;
  
  public dbi()
  {
    AppMethodBeat.i(122536);
    this.dtL = "";
    this.Hra = new LinkedList();
    this.Hrb = new LinkedList();
    AppMethodBeat.o(122536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dtL != null) {
        paramVarArgs.d(1, this.dtL);
      }
      paramVarArgs.e(2, 8, this.Hra);
      paramVarArgs.e(3, 8, this.Hrb);
      AppMethodBeat.o(122537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dtL == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = f.a.a.b.b.a.e(1, this.dtL) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Hra);
      int j = f.a.a.a.c(3, 8, this.Hrb);
      AppMethodBeat.o(122537);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hra.clear();
        this.Hrb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbi localdbi = (dbi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122537);
          return -1;
        case 1: 
          localdbi.dtL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122537);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbi.Hra.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122537);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbi.Hrb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      AppMethodBeat.o(122537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbi
 * JD-Core Version:    0.7.0.1
 */