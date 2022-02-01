package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckh
  extends com.tencent.mm.cd.a
{
  public int TrN;
  public ckk TrO;
  public ckj TrP;
  public cki TrQ;
  public ckg TrR;
  public ckl TrS;
  public ckm TrT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32324);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TrN);
      if (this.TrO != null)
      {
        paramVarArgs.oE(2, this.TrO.computeSize());
        this.TrO.writeFields(paramVarArgs);
      }
      if (this.TrP != null)
      {
        paramVarArgs.oE(3, this.TrP.computeSize());
        this.TrP.writeFields(paramVarArgs);
      }
      if (this.TrQ != null)
      {
        paramVarArgs.oE(4, this.TrQ.computeSize());
        this.TrQ.writeFields(paramVarArgs);
      }
      if (this.TrR != null)
      {
        paramVarArgs.oE(5, this.TrR.computeSize());
        this.TrR.writeFields(paramVarArgs);
      }
      if (this.TrS != null)
      {
        paramVarArgs.oE(6, this.TrS.computeSize());
        this.TrS.writeFields(paramVarArgs);
      }
      if (this.TrT != null)
      {
        paramVarArgs.oE(7, this.TrT.computeSize());
        this.TrT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TrN) + 0;
      paramInt = i;
      if (this.TrO != null) {
        paramInt = i + g.a.a.a.oD(2, this.TrO.computeSize());
      }
      i = paramInt;
      if (this.TrP != null) {
        i = paramInt + g.a.a.a.oD(3, this.TrP.computeSize());
      }
      paramInt = i;
      if (this.TrQ != null) {
        paramInt = i + g.a.a.a.oD(4, this.TrQ.computeSize());
      }
      i = paramInt;
      if (this.TrR != null) {
        i = paramInt + g.a.a.a.oD(5, this.TrR.computeSize());
      }
      paramInt = i;
      if (this.TrS != null) {
        paramInt = i + g.a.a.a.oD(6, this.TrS.computeSize());
      }
      i = paramInt;
      if (this.TrT != null) {
        i = paramInt + g.a.a.a.oD(7, this.TrT.computeSize());
      }
      AppMethodBeat.o(32324);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ckh localckh = (ckh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32324);
        return -1;
      case 1: 
        localckh.TrN = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32324);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ckk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ckk)localObject2).parseFrom((byte[])localObject1);
          }
          localckh.TrO = ((ckk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ckj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ckj)localObject2).parseFrom((byte[])localObject1);
          }
          localckh.TrP = ((ckj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cki();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cki)localObject2).parseFrom((byte[])localObject1);
          }
          localckh.TrQ = ((cki)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ckg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ckg)localObject2).parseFrom((byte[])localObject1);
          }
          localckh.TrR = ((ckg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ckl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ckl)localObject2).parseFrom((byte[])localObject1);
          }
          localckh.TrS = ((ckl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ckm();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ckm)localObject2).parseFrom((byte[])localObject1);
        }
        localckh.TrT = ((ckm)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    AppMethodBeat.o(32324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckh
 * JD-Core Version:    0.7.0.1
 */