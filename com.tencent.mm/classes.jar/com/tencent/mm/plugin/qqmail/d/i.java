package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bw.a
{
  public String content;
  public String xqW;
  public int xrm;
  public LinkedList<l> xrn;
  public LinkedList<l> xro;
  public LinkedList<l> xrp;
  public LinkedList<aj> xrq;
  public String xrr;
  public int xrs;
  
  public i()
  {
    AppMethodBeat.i(122665);
    this.xrn = new LinkedList();
    this.xro = new LinkedList();
    this.xrp = new LinkedList();
    this.xrq = new LinkedList();
    this.xrs = 20;
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
      paramVarArgs.aS(1, this.xrm);
      if (this.xqW != null) {
        paramVarArgs.d(2, this.xqW);
      }
      paramVarArgs.e(3, 8, this.xrn);
      paramVarArgs.e(4, 8, this.xro);
      paramVarArgs.e(5, 8, this.xrp);
      paramVarArgs.e(6, 8, this.xrq);
      if (this.xrr != null) {
        paramVarArgs.d(7, this.xrr);
      }
      if (this.content != null) {
        paramVarArgs.d(8, this.content);
      }
      paramVarArgs.aS(9, this.xrs);
      AppMethodBeat.o(122666);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xrm) + 0;
      paramInt = i;
      if (this.xqW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xqW);
      }
      i = paramInt + f.a.a.a.c(3, 8, this.xrn) + f.a.a.a.c(4, 8, this.xro) + f.a.a.a.c(5, 8, this.xrp) + f.a.a.a.c(6, 8, this.xrq);
      paramInt = i;
      if (this.xrr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.xrr);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.content);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.xrs);
      AppMethodBeat.o(122666);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xrn.clear();
      this.xro.clear();
      this.xrp.clear();
      this.xrq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locali.xrm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122666);
        return 0;
      case 2: 
        locali.xqW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.xrn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.xro.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.xrp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.xrq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 7: 
        locali.xrr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 8: 
        locali.content = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122666);
        return 0;
      }
      locali.xrs = ((f.a.a.a.a)localObject1).OmT.zc();
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