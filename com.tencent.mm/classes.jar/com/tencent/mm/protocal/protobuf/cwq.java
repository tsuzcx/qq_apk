package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwq
  extends com.tencent.mm.bx.a
{
  public LinkedList<aet> GbN;
  public dnb Hou;
  public aes Hov;
  public int How;
  public boolean Hox;
  public ace Hoy;
  public bf Hoz;
  public int type;
  public String url;
  
  public cwq()
  {
    AppMethodBeat.i(91676);
    this.GbN = new LinkedList();
    AppMethodBeat.o(91676);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91677);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.Hou != null)
      {
        paramVarArgs.lC(3, this.Hou.computeSize());
        this.Hou.writeFields(paramVarArgs);
      }
      if (this.Hov != null)
      {
        paramVarArgs.lC(4, this.Hov.computeSize());
        this.Hov.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.How);
      paramVarArgs.bt(6, this.Hox);
      paramVarArgs.e(7, 8, this.GbN);
      if (this.Hoy != null)
      {
        paramVarArgs.lC(8, this.Hoy.computeSize());
        this.Hoy.writeFields(paramVarArgs);
      }
      if (this.Hoz != null)
      {
        paramVarArgs.lC(9, this.Hoz.computeSize());
        this.Hoz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.Hou != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hou.computeSize());
      }
      paramInt = i;
      if (this.Hov != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hov.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.How) + f.a.a.b.b.a.alV(6) + f.a.a.a.c(7, 8, this.GbN);
      paramInt = i;
      if (this.Hoy != null) {
        paramInt = i + f.a.a.a.lB(8, this.Hoy.computeSize());
      }
      i = paramInt;
      if (this.Hoz != null) {
        i = paramInt + f.a.a.a.lB(9, this.Hoz.computeSize());
      }
      AppMethodBeat.o(91677);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GbN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cwq localcwq = (cwq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91677);
        return -1;
      case 1: 
        localcwq.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91677);
        return 0;
      case 2: 
        localcwq.url = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91677);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwq.Hou = ((dnb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aes();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aes)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwq.Hov = ((aes)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 5: 
        localcwq.How = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91677);
        return 0;
      case 6: 
        localcwq.Hox = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(91677);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aet();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwq.GbN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ace();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ace)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwq.Hoy = ((ace)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcwq.Hoz = ((bf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    AppMethodBeat.o(91677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwq
 * JD-Core Version:    0.7.0.1
 */