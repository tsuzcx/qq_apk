package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahs
  extends com.tencent.mm.bx.a
{
  public FinderCommentInfo Dkk;
  public bmf Dkl;
  public bmg Dkm;
  public FinderCommentInfo Dkn;
  public int actionType;
  public dzp contextObj;
  public long qoB;
  public int qqE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168935);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.actionType);
      if (this.Dkk != null)
      {
        paramVarArgs.kX(2, this.Dkk.computeSize());
        this.Dkk.writeFields(paramVarArgs);
      }
      if (this.Dkl != null)
      {
        paramVarArgs.kX(3, this.Dkl.computeSize());
        this.Dkl.writeFields(paramVarArgs);
      }
      if (this.Dkm != null)
      {
        paramVarArgs.kX(4, this.Dkm.computeSize());
        this.Dkm.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(5, this.qoB);
      if (this.Dkn != null)
      {
        paramVarArgs.kX(6, this.Dkn.computeSize());
        this.Dkn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.qqE);
      if (this.contextObj != null)
      {
        paramVarArgs.kX(8, this.contextObj.computeSize());
        this.contextObj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.actionType) + 0;
      paramInt = i;
      if (this.Dkk != null) {
        paramInt = i + f.a.a.a.kW(2, this.Dkk.computeSize());
      }
      i = paramInt;
      if (this.Dkl != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dkl.computeSize());
      }
      paramInt = i;
      if (this.Dkm != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dkm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.qoB);
      paramInt = i;
      if (this.Dkn != null) {
        paramInt = i + f.a.a.a.kW(6, this.Dkn.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.qqE);
      paramInt = i;
      if (this.contextObj != null) {
        paramInt = i + f.a.a.a.kW(8, this.contextObj.computeSize());
      }
      AppMethodBeat.o(168935);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ahs localahs = (ahs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168935);
        return -1;
      case 1: 
        localahs.actionType = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168935);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahs.Dkk = ((FinderCommentInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahs.Dkl = ((bmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahs.Dkm = ((bmg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 5: 
        localahs.qoB = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(168935);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahs.Dkn = ((FinderCommentInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 7: 
        localahs.qqE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168935);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dzp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dzp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localahs.contextObj = ((dzp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    AppMethodBeat.o(168935);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahs
 * JD-Core Version:    0.7.0.1
 */