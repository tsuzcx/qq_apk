package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public String content;
  public int vTS;
  public String vTT;
  public LinkedList<p> vTU;
  public LinkedList<p> vTV;
  public LinkedList<p> vTW;
  public LinkedList<aj> vTX;
  public String vTY;
  public int vTZ;
  
  public j()
  {
    AppMethodBeat.i(122665);
    this.vTU = new LinkedList();
    this.vTV = new LinkedList();
    this.vTW = new LinkedList();
    this.vTX = new LinkedList();
    this.vTZ = 5;
    AppMethodBeat.o(122665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(122666);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.vTS);
      if (this.vTT != null) {
        paramVarArgs.d(2, this.vTT);
      }
      paramVarArgs.e(3, 8, this.vTU);
      paramVarArgs.e(4, 8, this.vTV);
      paramVarArgs.e(5, 8, this.vTW);
      paramVarArgs.e(6, 8, this.vTX);
      if (this.vTY != null) {
        paramVarArgs.d(7, this.vTY);
      }
      if (this.content != null) {
        paramVarArgs.d(8, this.content);
      }
      paramVarArgs.aR(9, this.vTZ);
      AppMethodBeat.o(122666);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.vTS) + 0;
      paramInt = i;
      if (this.vTT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vTT);
      }
      i = paramInt + f.a.a.a.c(3, 8, this.vTU) + f.a.a.a.c(4, 8, this.vTV) + f.a.a.a.c(5, 8, this.vTW) + f.a.a.a.c(6, 8, this.vTX);
      paramInt = i;
      if (this.vTY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vTY);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.content);
      }
      paramInt = f.a.a.b.b.a.bx(9, this.vTZ);
      AppMethodBeat.o(122666);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.vTU.clear();
      this.vTV.clear();
      this.vTW.clear();
      this.vTX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(122666);
        throw paramVarArgs;
      }
      AppMethodBeat.o(122666);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122666);
        return -1;
      case 1: 
        localj.vTS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122666);
        return 0;
      case 2: 
        localj.vTT = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.vTU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.vTV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.vTW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.vTX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 7: 
        localj.vTY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 8: 
        localj.content = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122666);
        return 0;
      }
      localj.vTZ = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(122666);
      return 0;
    }
    AppMethodBeat.o(122666);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.j
 * JD-Core Version:    0.7.0.1
 */