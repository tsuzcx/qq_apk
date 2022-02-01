package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class arj
  extends com.tencent.mm.bw.a
{
  public b GIe;
  public LinkedList<ast> GIf;
  public String GIg;
  public long GIh;
  public long duw;
  public int priority;
  public int type;
  
  public arj()
  {
    AppMethodBeat.i(184209);
    this.GIf = new LinkedList();
    AppMethodBeat.o(184209);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.priority);
      paramVarArgs.aS(2, this.type);
      if (this.GIe != null) {
        paramVarArgs.c(3, this.GIe);
      }
      paramVarArgs.e(4, 8, this.GIf);
      if (this.GIg != null) {
        paramVarArgs.d(5, this.GIg);
      }
      paramVarArgs.aZ(100, this.duw);
      paramVarArgs.aZ(101, this.GIh);
      AppMethodBeat.o(184210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.priority) + 0 + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.GIe != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GIe);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.GIf);
      paramInt = i;
      if (this.GIg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GIg);
      }
      i = f.a.a.b.b.a.p(100, this.duw);
      int j = f.a.a.b.b.a.p(101, this.GIh);
      AppMethodBeat.o(184210);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GIf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(184210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      arj localarj = (arj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184210);
        return -1;
      case 1: 
        localarj.priority = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184210);
        return 0;
      case 2: 
        localarj.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184210);
        return 0;
      case 3: 
        localarj.GIe = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(184210);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ast();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ast)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarj.GIf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184210);
        return 0;
      case 5: 
        localarj.GIg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(184210);
        return 0;
      case 100: 
        localarj.duw = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(184210);
        return 0;
      }
      localarj.GIh = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(184210);
      return 0;
    }
    AppMethodBeat.o(184210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arj
 * JD-Core Version:    0.7.0.1
 */