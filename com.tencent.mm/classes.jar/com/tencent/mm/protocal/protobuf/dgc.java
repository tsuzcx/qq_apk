package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgc
  extends com.tencent.mm.bw.a
{
  public long HNr;
  public dgb HNs;
  public dgb HNt;
  public long Id;
  public String hFO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125772);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HNs == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.Id);
      paramVarArgs.aZ(2, this.HNr);
      if (this.HNs != null)
      {
        paramVarArgs.lJ(3, this.HNs.computeSize());
        this.HNs.writeFields(paramVarArgs);
      }
      if (this.HNt != null)
      {
        paramVarArgs.lJ(4, this.HNt.computeSize());
        this.HNt.writeFields(paramVarArgs);
      }
      if (this.hFO != null) {
        paramVarArgs.d(5, this.hFO);
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0 + f.a.a.b.b.a.p(2, this.HNr);
      paramInt = i;
      if (this.HNs != null) {
        paramInt = i + f.a.a.a.lI(3, this.HNs.computeSize());
      }
      i = paramInt;
      if (this.HNt != null) {
        i = paramInt + f.a.a.a.lI(4, this.HNt.computeSize());
      }
      paramInt = i;
      if (this.hFO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hFO);
      }
      AppMethodBeat.o(125772);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HNs == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dgc localdgc = (dgc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125772);
        return -1;
      case 1: 
        localdgc.Id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(125772);
        return 0;
      case 2: 
        localdgc.HNr = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(125772);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgc.HNs = ((dgb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgc.HNt = ((dgb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      }
      localdgc.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(125772);
      return 0;
    }
    AppMethodBeat.o(125772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgc
 * JD-Core Version:    0.7.0.1
 */