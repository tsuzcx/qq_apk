package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class re
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public int FNd;
  public bpn FNe;
  public zt FNf;
  public cwq FsR;
  public int ozA;
  public int state;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91384);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.state);
      if (this.FsR != null)
      {
        paramVarArgs.lC(2, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FNd);
      if (this.FNe != null)
      {
        paramVarArgs.lC(4, this.FNe.computeSize());
        this.FNe.writeFields(paramVarArgs);
      }
      if (this.text != null) {
        paramVarArgs.d(5, this.text);
      }
      if (this.FBS != null) {
        paramVarArgs.d(6, this.FBS);
      }
      paramVarArgs.aS(7, this.ozA);
      if (this.FNf != null)
      {
        paramVarArgs.lC(8, this.FNf.computeSize());
        this.FNf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.state) + 0;
      paramInt = i;
      if (this.FsR != null) {
        paramInt = i + f.a.a.a.lB(2, this.FsR.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FNd);
      paramInt = i;
      if (this.FNe != null) {
        paramInt = i + f.a.a.a.lB(4, this.FNe.computeSize());
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.text);
      }
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FBS);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.ozA);
      paramInt = i;
      if (this.FNf != null) {
        paramInt = i + f.a.a.a.lB(8, this.FNf.computeSize());
      }
      AppMethodBeat.o(91384);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      re localre = (re)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91384);
        return -1;
      case 1: 
        localre.state = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91384);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localre.FsR = ((cwq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 3: 
        localre.FNd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91384);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localre.FNe = ((bpn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 5: 
        localre.text = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 6: 
        localre.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 7: 
        localre.ozA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91384);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new zt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((zt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localre.FNf = ((zt)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    AppMethodBeat.o(91384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.re
 * JD-Core Version:    0.7.0.1
 */