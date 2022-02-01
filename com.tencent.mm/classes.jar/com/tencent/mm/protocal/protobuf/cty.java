package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cty
  extends com.tencent.mm.bx.a
{
  public String CPg;
  public df DuN;
  public LinkedList<ccg> ElG;
  public aec ElH;
  public LinkedList<chi> ElI;
  public int ElJ;
  public int upl;
  
  public cty()
  {
    AppMethodBeat.i(91694);
    this.ElG = new LinkedList();
    this.ElI = new LinkedList();
    AppMethodBeat.o(91694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.upl);
      paramVarArgs.e(2, 8, this.ElG);
      if (this.ElH != null)
      {
        paramVarArgs.kX(3, this.ElH.computeSize());
        this.ElH.writeFields(paramVarArgs);
      }
      if (this.DuN != null)
      {
        paramVarArgs.kX(4, this.DuN.computeSize());
        this.DuN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.ElI);
      paramVarArgs.aR(6, this.ElJ);
      if (this.CPg != null) {
        paramVarArgs.d(7, this.CPg);
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.upl) + 0 + f.a.a.a.c(2, 8, this.ElG);
      paramInt = i;
      if (this.ElH != null) {
        paramInt = i + f.a.a.a.kW(3, this.ElH.computeSize());
      }
      i = paramInt;
      if (this.DuN != null) {
        i = paramInt + f.a.a.a.kW(4, this.DuN.computeSize());
      }
      i = i + f.a.a.a.c(5, 8, this.ElI) + f.a.a.b.b.a.bA(6, this.ElJ);
      paramInt = i;
      if (this.CPg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CPg);
      }
      AppMethodBeat.o(91695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ElG.clear();
      this.ElI.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cty localcty = (cty)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91695);
        return -1;
      case 1: 
        localcty.upl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91695);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcty.ElG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aec();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aec)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcty.ElH = ((aec)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new df();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((df)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcty.DuN = ((df)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcty.ElI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 6: 
        localcty.ElJ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91695);
        return 0;
      }
      localcty.CPg = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(91695);
      return 0;
    }
    AppMethodBeat.o(91695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cty
 * JD-Core Version:    0.7.0.1
 */