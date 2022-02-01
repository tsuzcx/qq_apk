package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ana
  extends com.tencent.mm.bw.a
{
  public FinderObject GFh;
  public int GFi;
  public aqj GFj;
  public int dataType;
  public long id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168953);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      paramVarArgs.aZ(2, this.id);
      if (this.GFh != null)
      {
        paramVarArgs.lJ(3, this.GFh.computeSize());
        this.GFh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GFi);
      if (this.GFj != null)
      {
        paramVarArgs.lJ(5, this.GFj.computeSize());
        this.GFj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.dataType);
      AppMethodBeat.o(168953);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0 + f.a.a.b.b.a.p(2, this.id);
      paramInt = i;
      if (this.GFh != null) {
        paramInt = i + f.a.a.a.lI(3, this.GFh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GFi);
      paramInt = i;
      if (this.GFj != null) {
        paramInt = i + f.a.a.a.lI(5, this.GFj.computeSize());
      }
      i = f.a.a.b.b.a.bz(6, this.dataType);
      AppMethodBeat.o(168953);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ana localana = (ana)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168953);
        return -1;
      case 1: 
        localana.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168953);
        return 0;
      case 2: 
        localana.id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(168953);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localana.GFh = ((FinderObject)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 4: 
        localana.GFi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168953);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localana.GFj = ((aqj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      }
      localana.dataType = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(168953);
      return 0;
    }
    AppMethodBeat.o(168953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ana
 * JD-Core Version:    0.7.0.1
 */