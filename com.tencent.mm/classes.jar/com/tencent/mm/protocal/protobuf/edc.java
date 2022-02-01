package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edc
  extends com.tencent.mm.bx.a
{
  public boolean GAQ;
  public LinkedList<eda> GDO;
  public boolean HOR;
  
  public edc()
  {
    AppMethodBeat.i(32541);
    this.GDO = new LinkedList();
    AppMethodBeat.o(32541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.GAQ);
      paramVarArgs.e(2, 8, this.GDO);
      paramVarArgs.bt(3, this.HOR);
      AppMethodBeat.o(32542);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alV(1);
      i = f.a.a.a.c(2, 8, this.GDO);
      int j = f.a.a.b.b.a.alV(3);
      AppMethodBeat.o(32542);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GDO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32542);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      edc localedc = (edc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32542);
        return -1;
      case 1: 
        localedc.GAQ = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(32542);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eda();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eda)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localedc.GDO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32542);
        return 0;
      }
      localedc.HOR = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(32542);
      return 0;
    }
    AppMethodBeat.o(32542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edc
 * JD-Core Version:    0.7.0.1
 */