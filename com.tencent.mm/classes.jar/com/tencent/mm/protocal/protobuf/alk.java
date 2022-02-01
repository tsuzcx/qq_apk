package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class alk
  extends com.tencent.mm.bx.a
{
  public int Gli;
  public b Glj;
  public int Glk;
  public za Gll;
  public int scene;
  public long xcO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168937);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gli);
      paramVarArgs.aS(2, this.scene);
      if (this.Glj != null) {
        paramVarArgs.c(3, this.Glj);
      }
      paramVarArgs.aS(4, this.Glk);
      if (this.Gll != null)
      {
        paramVarArgs.lC(5, this.Gll.computeSize());
        this.Gll.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.xcO);
      AppMethodBeat.o(168937);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gli) + 0 + f.a.a.b.b.a.bz(2, this.scene);
      paramInt = i;
      if (this.Glj != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Glj);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Glk);
      paramInt = i;
      if (this.Gll != null) {
        paramInt = i + f.a.a.a.lB(5, this.Gll.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.xcO);
      AppMethodBeat.o(168937);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      alk localalk = (alk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168937);
        return -1;
      case 1: 
        localalk.Gli = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168937);
        return 0;
      case 2: 
        localalk.scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168937);
        return 0;
      case 3: 
        localalk.Glj = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(168937);
        return 0;
      case 4: 
        localalk.Glk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168937);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new za();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((za)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalk.Gll = ((za)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168937);
        return 0;
      }
      localalk.xcO = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(168937);
      return 0;
    }
    AppMethodBeat.o(168937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alk
 * JD-Core Version:    0.7.0.1
 */