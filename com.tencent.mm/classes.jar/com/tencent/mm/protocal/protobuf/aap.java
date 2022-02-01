package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class aap
  extends com.tencent.mm.cd.a
{
  public int SmI;
  public int SmJ;
  public int SmK;
  public LinkedList<aao> SmL;
  public b SmM;
  public cjk SmN;
  
  public aap()
  {
    AppMethodBeat.i(143967);
    this.SmL = new LinkedList();
    AppMethodBeat.o(143967);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143968);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SmI);
      paramVarArgs.aY(2, this.SmJ);
      paramVarArgs.aY(3, this.SmK);
      paramVarArgs.e(4, 8, this.SmL);
      if (this.SmM != null) {
        paramVarArgs.c(5, this.SmM);
      }
      if (this.SmN != null)
      {
        paramVarArgs.oE(6, this.SmN.computeSize());
        this.SmN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SmI) + 0 + g.a.a.b.b.a.bM(2, this.SmJ) + g.a.a.b.b.a.bM(3, this.SmK) + g.a.a.a.c(4, 8, this.SmL);
      paramInt = i;
      if (this.SmM != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.SmM);
      }
      i = paramInt;
      if (this.SmN != null) {
        i = paramInt + g.a.a.a.oD(6, this.SmN.computeSize());
      }
      AppMethodBeat.o(143968);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SmL.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aap localaap = (aap)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143968);
        return -1;
      case 1: 
        localaap.SmI = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143968);
        return 0;
      case 2: 
        localaap.SmJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143968);
        return 0;
      case 3: 
        localaap.SmK = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143968);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aao();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aao)localObject2).parseFrom((byte[])localObject1);
          }
          localaap.SmL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143968);
        return 0;
      case 5: 
        localaap.SmM = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(143968);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cjk();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cjk)localObject2).parseFrom((byte[])localObject1);
        }
        localaap.SmN = ((cjk)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    AppMethodBeat.o(143968);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aap
 * JD-Core Version:    0.7.0.1
 */