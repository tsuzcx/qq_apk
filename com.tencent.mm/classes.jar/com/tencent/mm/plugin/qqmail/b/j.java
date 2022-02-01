package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public String content;
  public int uLb;
  public String uLc;
  public LinkedList<p> uLd;
  public LinkedList<p> uLe;
  public LinkedList<p> uLf;
  public LinkedList<aj> uLg;
  public String uLh;
  public int uLi;
  
  public j()
  {
    AppMethodBeat.i(122665);
    this.uLd = new LinkedList();
    this.uLe = new LinkedList();
    this.uLf = new LinkedList();
    this.uLg = new LinkedList();
    this.uLi = 5;
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
      paramVarArgs.aR(1, this.uLb);
      if (this.uLc != null) {
        paramVarArgs.d(2, this.uLc);
      }
      paramVarArgs.e(3, 8, this.uLd);
      paramVarArgs.e(4, 8, this.uLe);
      paramVarArgs.e(5, 8, this.uLf);
      paramVarArgs.e(6, 8, this.uLg);
      if (this.uLh != null) {
        paramVarArgs.d(7, this.uLh);
      }
      if (this.content != null) {
        paramVarArgs.d(8, this.content);
      }
      paramVarArgs.aR(9, this.uLi);
      AppMethodBeat.o(122666);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.uLb) + 0;
      paramInt = i;
      if (this.uLc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uLc);
      }
      i = paramInt + f.a.a.a.c(3, 8, this.uLd) + f.a.a.a.c(4, 8, this.uLe) + f.a.a.a.c(5, 8, this.uLf) + f.a.a.a.c(6, 8, this.uLg);
      paramInt = i;
      if (this.uLh != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uLh);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.content);
      }
      paramInt = f.a.a.b.b.a.bA(9, this.uLi);
      AppMethodBeat.o(122666);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uLd.clear();
      this.uLe.clear();
      this.uLf.clear();
      this.uLg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localj.uLb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122666);
        return 0;
      case 2: 
        localj.uLc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.uLd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.uLe.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.uLf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.uLg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 7: 
        localj.uLh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 8: 
        localj.content = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122666);
        return 0;
      }
      localj.uLi = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(122666);
      return 0;
    }
    AppMethodBeat.o(122666);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.j
 * JD-Core Version:    0.7.0.1
 */