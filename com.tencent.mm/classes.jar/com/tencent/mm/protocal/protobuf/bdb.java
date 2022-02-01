package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdb
  extends com.tencent.mm.bw.a
{
  public long LMP;
  public String LMQ;
  public LinkedList<String> LMR;
  public LinkedList<bcv> LMS;
  public LinkedList<String> LMT;
  public int style;
  
  public bdb()
  {
    AppMethodBeat.i(209689);
    this.LMR = new LinkedList();
    this.LMS = new LinkedList();
    this.LMT = new LinkedList();
    AppMethodBeat.o(209689);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.LMP);
      paramVarArgs.aM(2, this.style);
      if (this.LMQ != null) {
        paramVarArgs.e(3, this.LMQ);
      }
      paramVarArgs.e(4, 1, this.LMR);
      paramVarArgs.e(5, 8, this.LMS);
      paramVarArgs.e(6, 1, this.LMT);
      AppMethodBeat.o(209690);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.LMP) + 0 + g.a.a.b.b.a.bu(2, this.style);
      paramInt = i;
      if (this.LMQ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LMQ);
      }
      i = g.a.a.a.c(4, 1, this.LMR);
      int j = g.a.a.a.c(5, 8, this.LMS);
      int k = g.a.a.a.c(6, 1, this.LMT);
      AppMethodBeat.o(209690);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LMR.clear();
      this.LMS.clear();
      this.LMT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209690);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bdb localbdb = (bdb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209690);
        return -1;
      case 1: 
        localbdb.LMP = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209690);
        return 0;
      case 2: 
        localbdb.style = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209690);
        return 0;
      case 3: 
        localbdb.LMQ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209690);
        return 0;
      case 4: 
        localbdb.LMR.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(209690);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bcv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbdb.LMS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209690);
        return 0;
      }
      localbdb.LMT.add(((g.a.a.a.a)localObject1).UbS.readString());
      AppMethodBeat.o(209690);
      return 0;
    }
    AppMethodBeat.o(209690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdb
 * JD-Core Version:    0.7.0.1
 */