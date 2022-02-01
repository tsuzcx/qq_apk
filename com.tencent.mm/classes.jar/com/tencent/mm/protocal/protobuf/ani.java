package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ani
  extends com.tencent.mm.bw.a
{
  public b EGr;
  public LinkedList<aon> EGs;
  public String EGt;
  public long EGu;
  public long dig;
  public int priority;
  public int type;
  
  public ani()
  {
    AppMethodBeat.i(184209);
    this.EGs = new LinkedList();
    AppMethodBeat.o(184209);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.priority);
      paramVarArgs.aR(2, this.type);
      if (this.EGr != null) {
        paramVarArgs.c(3, this.EGr);
      }
      paramVarArgs.e(4, 8, this.EGs);
      if (this.EGt != null) {
        paramVarArgs.d(5, this.EGt);
      }
      paramVarArgs.aO(100, this.dig);
      paramVarArgs.aO(101, this.EGu);
      AppMethodBeat.o(184210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.priority) + 0 + f.a.a.b.b.a.bx(2, this.type);
      paramInt = i;
      if (this.EGr != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.EGr);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.EGs);
      paramInt = i;
      if (this.EGt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EGt);
      }
      i = f.a.a.b.b.a.p(100, this.dig);
      int j = f.a.a.b.b.a.p(101, this.EGu);
      AppMethodBeat.o(184210);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EGs.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ani localani = (ani)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184210);
        return -1;
      case 1: 
        localani.priority = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184210);
        return 0;
      case 2: 
        localani.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184210);
        return 0;
      case 3: 
        localani.EGr = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(184210);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aon();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aon)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localani.EGs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184210);
        return 0;
      case 5: 
        localani.EGt = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(184210);
        return 0;
      case 100: 
        localani.dig = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(184210);
        return 0;
      }
      localani.EGu = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(184210);
      return 0;
    }
    AppMethodBeat.o(184210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ani
 * JD-Core Version:    0.7.0.1
 */