package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alr
  extends com.tencent.mm.bw.a
{
  public FinderCommentInfo GDK;
  public bwc GDL;
  public bwd GDM;
  public FinderCommentInfo GDN;
  public int GDO;
  public int actionType;
  public long rQN;
  public arn rQw;
  public int sch;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168935);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.actionType);
      if (this.GDK != null)
      {
        paramVarArgs.lJ(2, this.GDK.computeSize());
        this.GDK.writeFields(paramVarArgs);
      }
      if (this.GDL != null)
      {
        paramVarArgs.lJ(3, this.GDL.computeSize());
        this.GDL.writeFields(paramVarArgs);
      }
      if (this.GDM != null)
      {
        paramVarArgs.lJ(4, this.GDM.computeSize());
        this.GDM.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(5, this.rQN);
      if (this.GDN != null)
      {
        paramVarArgs.lJ(6, this.GDN.computeSize());
        this.GDN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.sch);
      if (this.rQw != null)
      {
        paramVarArgs.lJ(8, this.rQw.computeSize());
        this.rQw.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.GDO);
      AppMethodBeat.o(168935);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.actionType) + 0;
      paramInt = i;
      if (this.GDK != null) {
        paramInt = i + f.a.a.a.lI(2, this.GDK.computeSize());
      }
      i = paramInt;
      if (this.GDL != null) {
        i = paramInt + f.a.a.a.lI(3, this.GDL.computeSize());
      }
      paramInt = i;
      if (this.GDM != null) {
        paramInt = i + f.a.a.a.lI(4, this.GDM.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.rQN);
      paramInt = i;
      if (this.GDN != null) {
        paramInt = i + f.a.a.a.lI(6, this.GDN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.sch);
      paramInt = i;
      if (this.rQw != null) {
        paramInt = i + f.a.a.a.lI(8, this.rQw.computeSize());
      }
      i = f.a.a.b.b.a.bz(9, this.GDO);
      AppMethodBeat.o(168935);
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
      AppMethodBeat.o(168935);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      alr localalr = (alr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168935);
        return -1;
      case 1: 
        localalr.actionType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168935);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalr.GDK = ((FinderCommentInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalr.GDL = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalr.GDM = ((bwd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 5: 
        localalr.rQN = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(168935);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalr.GDN = ((FinderCommentInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 7: 
        localalr.sch = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168935);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new arn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((arn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalr.rQw = ((arn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      }
      localalr.GDO = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(168935);
      return 0;
    }
    AppMethodBeat.o(168935);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alr
 * JD-Core Version:    0.7.0.1
 */