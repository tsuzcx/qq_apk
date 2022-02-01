package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmk
  extends com.tencent.mm.bx.a
{
  public LinkedList<bml> DJP;
  public LinkedList<bml> DJQ;
  public bml DJR;
  public int DJS;
  public long drA;
  public String key;
  public int sqY;
  
  public bmk()
  {
    AppMethodBeat.i(186485);
    this.DJP = new LinkedList();
    this.DJQ = new LinkedList();
    AppMethodBeat.o(186485);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.DJP);
      paramVarArgs.e(2, 8, this.DJQ);
      if (this.DJR != null)
      {
        paramVarArgs.kX(3, this.DJR.computeSize());
        this.DJR.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.sqY);
      paramVarArgs.aR(5, this.DJS);
      paramVarArgs.aG(6, this.drA);
      if (this.key != null) {
        paramVarArgs.d(7, this.key);
      }
      AppMethodBeat.o(186486);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.DJP) + 0 + f.a.a.a.c(2, 8, this.DJQ);
      paramInt = i;
      if (this.DJR != null) {
        paramInt = i + f.a.a.a.kW(3, this.DJR.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.sqY) + f.a.a.b.b.a.bA(5, this.DJS) + f.a.a.b.b.a.q(6, this.drA);
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.key);
      }
      AppMethodBeat.o(186486);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DJP.clear();
      this.DJQ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(186486);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bmk localbmk = (bmk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(186486);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmk.DJP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(186486);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmk.DJQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(186486);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmk.DJR = ((bml)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(186486);
        return 0;
      case 4: 
        localbmk.sqY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(186486);
        return 0;
      case 5: 
        localbmk.DJS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(186486);
        return 0;
      case 6: 
        localbmk.drA = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(186486);
        return 0;
      }
      localbmk.key = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(186486);
      return 0;
    }
    AppMethodBeat.o(186486);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmk
 * JD-Core Version:    0.7.0.1
 */