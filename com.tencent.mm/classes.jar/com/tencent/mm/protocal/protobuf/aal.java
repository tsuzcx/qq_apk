package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aal
  extends com.tencent.mm.bw.a
  implements dyp
{
  public int LlE;
  public int LlF;
  public int LlG;
  public LinkedList<eeo> LlH;
  public LinkedList<eeo> LlI;
  public LinkedList<eeo> LlJ;
  public int LlK;
  public int LlL;
  public int LlM;
  public cbi LlN;
  public int Ret;
  
  public aal()
  {
    AppMethodBeat.i(143969);
    this.LlH = new LinkedList();
    this.LlI = new LinkedList();
    this.LlJ = new LinkedList();
    AppMethodBeat.o(143969);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143970);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      paramVarArgs.aM(2, this.LlE);
      paramVarArgs.aM(3, this.LlF);
      paramVarArgs.aM(4, this.LlG);
      paramVarArgs.e(5, 8, this.LlH);
      paramVarArgs.e(6, 8, this.LlI);
      paramVarArgs.e(7, 8, this.LlJ);
      paramVarArgs.aM(8, this.LlK);
      paramVarArgs.aM(9, this.LlL);
      paramVarArgs.aM(10, this.LlM);
      if (this.LlN != null)
      {
        paramVarArgs.ni(11, this.LlN.computeSize());
        this.LlN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.LlE) + g.a.a.b.b.a.bu(3, this.LlF) + g.a.a.b.b.a.bu(4, this.LlG) + g.a.a.a.c(5, 8, this.LlH) + g.a.a.a.c(6, 8, this.LlI) + g.a.a.a.c(7, 8, this.LlJ) + g.a.a.b.b.a.bu(8, this.LlK) + g.a.a.b.b.a.bu(9, this.LlL) + g.a.a.b.b.a.bu(10, this.LlM);
      paramInt = i;
      if (this.LlN != null) {
        paramInt = i + g.a.a.a.nh(11, this.LlN.computeSize());
      }
      AppMethodBeat.o(143970);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LlH.clear();
      this.LlI.clear();
      this.LlJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aal localaal = (aal)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143970);
        return -1;
      case 1: 
        localaal.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143970);
        return 0;
      case 2: 
        localaal.LlE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143970);
        return 0;
      case 3: 
        localaal.LlF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143970);
        return 0;
      case 4: 
        localaal.LlG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143970);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaal.LlH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaal.LlI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaal.LlJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 8: 
        localaal.LlK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143970);
        return 0;
      case 9: 
        localaal.LlL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143970);
        return 0;
      case 10: 
        localaal.LlM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143970);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cbi();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localaal.LlN = ((cbi)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    AppMethodBeat.o(143970);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aal
 * JD-Core Version:    0.7.0.1
 */