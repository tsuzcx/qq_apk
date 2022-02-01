package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eis
  extends com.tencent.mm.bx.a
{
  public String HTk;
  public String HTl;
  public LinkedList<cgo> HTm;
  public String HTn;
  public int HTo;
  public String Title;
  
  public eis()
  {
    AppMethodBeat.i(50125);
    this.HTm = new LinkedList();
    AppMethodBeat.o(50125);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HTk != null) {
        paramVarArgs.d(1, this.HTk);
      }
      if (this.HTl != null) {
        paramVarArgs.d(2, this.HTl);
      }
      paramVarArgs.e(3, 8, this.HTm);
      if (this.HTn != null) {
        paramVarArgs.d(4, this.HTn);
      }
      paramVarArgs.aS(5, this.HTo);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HTk == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.b.b.a.e(1, this.HTk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HTl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HTl);
      }
      i += f.a.a.a.c(3, 8, this.HTm);
      paramInt = i;
      if (this.HTn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HTn);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HTo);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HTm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eis localeis = (eis)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50126);
          return -1;
        case 1: 
          localeis.HTk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 2: 
          localeis.HTl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cgo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeis.HTm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50126);
          return 0;
        case 4: 
          localeis.HTn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 5: 
          localeis.HTo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(50126);
          return 0;
        }
        localeis.Title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50126);
        return 0;
      }
      AppMethodBeat.o(50126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eis
 * JD-Core Version:    0.7.0.1
 */