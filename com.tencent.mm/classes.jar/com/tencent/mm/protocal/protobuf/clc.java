package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clc
  extends com.tencent.mm.bx.a
{
  public abj Hes;
  public abj Het;
  public abj Heu;
  public abj Hev;
  public int bottom;
  public int left;
  public int right;
  public int top;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.left);
      paramVarArgs.aS(2, this.top);
      paramVarArgs.aS(3, this.right);
      paramVarArgs.aS(4, this.bottom);
      if (this.Hes != null)
      {
        paramVarArgs.lC(5, this.Hes.computeSize());
        this.Hes.writeFields(paramVarArgs);
      }
      if (this.Het != null)
      {
        paramVarArgs.lC(6, this.Het.computeSize());
        this.Het.writeFields(paramVarArgs);
      }
      if (this.Heu != null)
      {
        paramVarArgs.lC(7, this.Heu.computeSize());
        this.Heu.writeFields(paramVarArgs);
      }
      if (this.Hev != null)
      {
        paramVarArgs.lC(8, this.Hev.computeSize());
        this.Hev.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(100, this.type);
      AppMethodBeat.o(118412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.left) + 0 + f.a.a.b.b.a.bz(2, this.top) + f.a.a.b.b.a.bz(3, this.right) + f.a.a.b.b.a.bz(4, this.bottom);
      paramInt = i;
      if (this.Hes != null) {
        paramInt = i + f.a.a.a.lB(5, this.Hes.computeSize());
      }
      i = paramInt;
      if (this.Het != null) {
        i = paramInt + f.a.a.a.lB(6, this.Het.computeSize());
      }
      paramInt = i;
      if (this.Heu != null) {
        paramInt = i + f.a.a.a.lB(7, this.Heu.computeSize());
      }
      i = paramInt;
      if (this.Hev != null) {
        i = paramInt + f.a.a.a.lB(8, this.Hev.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(100, this.type);
      AppMethodBeat.o(118412);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(118412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      clc localclc = (clc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118412);
        return -1;
      case 1: 
        localclc.left = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118412);
        return 0;
      case 2: 
        localclc.top = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118412);
        return 0;
      case 3: 
        localclc.right = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118412);
        return 0;
      case 4: 
        localclc.bottom = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118412);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclc.Hes = ((abj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclc.Het = ((abj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclc.Heu = ((abj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclc.Hev = ((abj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      }
      localclc.type = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(118412);
      return 0;
    }
    AppMethodBeat.o(118412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clc
 * JD-Core Version:    0.7.0.1
 */