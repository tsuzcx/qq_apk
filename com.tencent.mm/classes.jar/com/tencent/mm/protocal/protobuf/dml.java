package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dml
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public cwq FsR;
  public long HAF;
  public int HAG;
  public afl HAH;
  public float size;
  public String text;
  public String xNN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HAF);
      if (this.xNN != null) {
        paramVarArgs.d(2, this.xNN);
      }
      if (this.text != null) {
        paramVarArgs.d(3, this.text);
      }
      paramVarArgs.z(4, this.size);
      if (this.FsR != null)
      {
        paramVarArgs.lC(5, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HAG);
      if (this.FBS != null) {
        paramVarArgs.d(7, this.FBS);
      }
      if (this.HAH != null)
      {
        paramVarArgs.lC(8, this.HAH.computeSize());
        this.HAH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.HAF) + 0;
      paramInt = i;
      if (this.xNN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xNN);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.text);
      }
      i += f.a.a.b.b.a.alU(4);
      paramInt = i;
      if (this.FsR != null) {
        paramInt = i + f.a.a.a.lB(5, this.FsR.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HAG);
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FBS);
      }
      i = paramInt;
      if (this.HAH != null) {
        i = paramInt + f.a.a.a.lB(8, this.HAH.computeSize());
      }
      AppMethodBeat.o(91713);
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
      AppMethodBeat.o(91713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dml localdml = (dml)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91713);
        return -1;
      case 1: 
        localdml.HAF = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91713);
        return 0;
      case 2: 
        localdml.xNN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 3: 
        localdml.text = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 4: 
        localdml.size = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
        AppMethodBeat.o(91713);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdml.FsR = ((cwq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91713);
        return 0;
      case 6: 
        localdml.HAG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91713);
        return 0;
      case 7: 
        localdml.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91713);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new afl();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((afl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdml.HAH = ((afl)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    AppMethodBeat.o(91713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dml
 * JD-Core Version:    0.7.0.1
 */