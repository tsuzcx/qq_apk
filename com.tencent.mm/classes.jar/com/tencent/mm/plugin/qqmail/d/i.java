package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public String content;
  public String xbA;
  public int xbB;
  public String xbf;
  public int xbv;
  public LinkedList<l> xbw;
  public LinkedList<l> xbx;
  public LinkedList<l> xby;
  public LinkedList<aj> xbz;
  
  public i()
  {
    AppMethodBeat.i(122665);
    this.xbw = new LinkedList();
    this.xbx = new LinkedList();
    this.xby = new LinkedList();
    this.xbz = new LinkedList();
    this.xbB = 20;
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
      paramVarArgs.aS(1, this.xbv);
      if (this.xbf != null) {
        paramVarArgs.d(2, this.xbf);
      }
      paramVarArgs.e(3, 8, this.xbw);
      paramVarArgs.e(4, 8, this.xbx);
      paramVarArgs.e(5, 8, this.xby);
      paramVarArgs.e(6, 8, this.xbz);
      if (this.xbA != null) {
        paramVarArgs.d(7, this.xbA);
      }
      if (this.content != null) {
        paramVarArgs.d(8, this.content);
      }
      paramVarArgs.aS(9, this.xbB);
      AppMethodBeat.o(122666);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xbv) + 0;
      paramInt = i;
      if (this.xbf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xbf);
      }
      i = paramInt + f.a.a.a.c(3, 8, this.xbw) + f.a.a.a.c(4, 8, this.xbx) + f.a.a.a.c(5, 8, this.xby) + f.a.a.a.c(6, 8, this.xbz);
      paramInt = i;
      if (this.xbA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.xbA);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.content);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.xbB);
      AppMethodBeat.o(122666);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xbw.clear();
      this.xbx.clear();
      this.xby.clear();
      this.xbz.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122666);
        return -1;
      case 1: 
        locali.xbv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122666);
        return 0;
      case 2: 
        locali.xbf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.xbw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.xbx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.xby.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.xbz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 7: 
        locali.xbA = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 8: 
        locali.content = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122666);
        return 0;
      }
      locali.xbB = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(122666);
      return 0;
    }
    AppMethodBeat.o(122666);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.i
 * JD-Core Version:    0.7.0.1
 */