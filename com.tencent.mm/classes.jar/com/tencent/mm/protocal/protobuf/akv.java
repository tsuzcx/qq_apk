package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class akv
  extends com.tencent.mm.bx.a
{
  public b Dms;
  public LinkedList<aln> Dmt;
  public String Dmu;
  public long feedId;
  public int priority;
  public int type;
  
  public akv()
  {
    AppMethodBeat.i(184209);
    this.Dmt = new LinkedList();
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
      if (this.Dms != null) {
        paramVarArgs.c(3, this.Dms);
      }
      paramVarArgs.e(4, 8, this.Dmt);
      if (this.Dmu != null) {
        paramVarArgs.d(5, this.Dmu);
      }
      paramVarArgs.aG(100, this.feedId);
      AppMethodBeat.o(184210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.priority) + 0 + f.a.a.b.b.a.bA(2, this.type);
      paramInt = i;
      if (this.Dms != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Dms);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.Dmt);
      paramInt = i;
      if (this.Dmu != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Dmu);
      }
      i = f.a.a.b.b.a.q(100, this.feedId);
      AppMethodBeat.o(184210);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Dmt.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(184210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      akv localakv = (akv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184210);
        return -1;
      case 1: 
        localakv.priority = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184210);
        return 0;
      case 2: 
        localakv.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184210);
        return 0;
      case 3: 
        localakv.Dms = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(184210);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aln();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aln)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakv.Dmt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184210);
        return 0;
      case 5: 
        localakv.Dmu = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184210);
        return 0;
      }
      localakv.feedId = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(184210);
      return 0;
    }
    AppMethodBeat.o(184210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akv
 * JD-Core Version:    0.7.0.1
 */