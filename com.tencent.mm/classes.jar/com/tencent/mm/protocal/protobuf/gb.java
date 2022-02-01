package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gb
  extends com.tencent.mm.bx.a
{
  public int Fyi;
  public int Fyj;
  public gg Fyk;
  public ga Fyl;
  public int OpCode;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.OpCode);
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      paramVarArgs.aS(3, this.Fyi);
      paramVarArgs.aS(4, this.Fyj);
      if (this.Fyk != null)
      {
        paramVarArgs.lC(5, this.Fyk.computeSize());
        this.Fyk.writeFields(paramVarArgs);
      }
      if (this.Fyl != null)
      {
        paramVarArgs.lC(6, this.Fyl.computeSize());
        this.Fyl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.OpCode) + 0;
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Fyi) + f.a.a.b.b.a.bz(4, this.Fyj);
      paramInt = i;
      if (this.Fyk != null) {
        paramInt = i + f.a.a.a.lB(5, this.Fyk.computeSize());
      }
      i = paramInt;
      if (this.Fyl != null) {
        i = paramInt + f.a.a.a.lB(6, this.Fyl.computeSize());
      }
      AppMethodBeat.o(32118);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.iht == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      gb localgb = (gb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32118);
        return -1;
      case 1: 
        localgb.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32118);
        return 0;
      case 2: 
        localgb.iht = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32118);
        return 0;
      case 3: 
        localgb.Fyi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32118);
        return 0;
      case 4: 
        localgb.Fyj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32118);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgb.Fyk = ((gg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32118);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ga();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ga)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localgb.Fyl = ((ga)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    AppMethodBeat.o(32118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gb
 * JD-Core Version:    0.7.0.1
 */