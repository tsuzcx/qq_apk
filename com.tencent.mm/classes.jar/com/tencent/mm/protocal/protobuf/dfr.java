package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfr
  extends com.tencent.mm.bw.a
{
  public di GSN;
  public String Ghx;
  public LinkedList<cnb> HMQ;
  public ahu HMR;
  public LinkedList<csg> HMS;
  public int HMT;
  public int wTm;
  
  public dfr()
  {
    AppMethodBeat.i(91694);
    this.HMQ = new LinkedList();
    this.HMS = new LinkedList();
    AppMethodBeat.o(91694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.wTm);
      paramVarArgs.e(2, 8, this.HMQ);
      if (this.HMR != null)
      {
        paramVarArgs.lJ(3, this.HMR.computeSize());
        this.HMR.writeFields(paramVarArgs);
      }
      if (this.GSN != null)
      {
        paramVarArgs.lJ(4, this.GSN.computeSize());
        this.GSN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.HMS);
      paramVarArgs.aS(6, this.HMT);
      if (this.Ghx != null) {
        paramVarArgs.d(7, this.Ghx);
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.wTm) + 0 + f.a.a.a.c(2, 8, this.HMQ);
      paramInt = i;
      if (this.HMR != null) {
        paramInt = i + f.a.a.a.lI(3, this.HMR.computeSize());
      }
      i = paramInt;
      if (this.GSN != null) {
        i = paramInt + f.a.a.a.lI(4, this.GSN.computeSize());
      }
      i = i + f.a.a.a.c(5, 8, this.HMS) + f.a.a.b.b.a.bz(6, this.HMT);
      paramInt = i;
      if (this.Ghx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ghx);
      }
      AppMethodBeat.o(91695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HMQ.clear();
      this.HMS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dfr localdfr = (dfr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91695);
        return -1;
      case 1: 
        localdfr.wTm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91695);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfr.HMQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfr.HMR = ((ahu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new di();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((di)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfr.GSN = ((di)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfr.HMS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 6: 
        localdfr.HMT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91695);
        return 0;
      }
      localdfr.Ghx = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91695);
      return 0;
    }
    AppMethodBeat.o(91695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfr
 * JD-Core Version:    0.7.0.1
 */