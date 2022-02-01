package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alh
  extends com.tencent.mm.bx.a
{
  public FinderCommentInfo Gla;
  public bvi Glb;
  public bvj Glc;
  public FinderCommentInfo Gld;
  public int Oer;
  public int actionType;
  public long rID;
  public aqy rIl;
  public int rTD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168935);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.actionType);
      if (this.Gla != null)
      {
        paramVarArgs.lC(2, this.Gla.computeSize());
        this.Gla.writeFields(paramVarArgs);
      }
      if (this.Glb != null)
      {
        paramVarArgs.lC(3, this.Glb.computeSize());
        this.Glb.writeFields(paramVarArgs);
      }
      if (this.Glc != null)
      {
        paramVarArgs.lC(4, this.Glc.computeSize());
        this.Glc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.rID);
      if (this.Gld != null)
      {
        paramVarArgs.lC(6, this.Gld.computeSize());
        this.Gld.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.rTD);
      if (this.rIl != null)
      {
        paramVarArgs.lC(8, this.rIl.computeSize());
        this.rIl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.Oer);
      AppMethodBeat.o(168935);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.actionType) + 0;
      paramInt = i;
      if (this.Gla != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gla.computeSize());
      }
      i = paramInt;
      if (this.Glb != null) {
        i = paramInt + f.a.a.a.lB(3, this.Glb.computeSize());
      }
      paramInt = i;
      if (this.Glc != null) {
        paramInt = i + f.a.a.a.lB(4, this.Glc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.rID);
      paramInt = i;
      if (this.Gld != null) {
        paramInt = i + f.a.a.a.lB(6, this.Gld.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.rTD);
      paramInt = i;
      if (this.rIl != null) {
        paramInt = i + f.a.a.a.lB(8, this.rIl.computeSize());
      }
      i = f.a.a.b.b.a.bz(9, this.Oer);
      AppMethodBeat.o(168935);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      alh localalh = (alh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168935);
        return -1;
      case 1: 
        localalh.actionType = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168935);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalh.Gla = ((FinderCommentInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalh.Glb = ((bvi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalh.Glc = ((bvj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 5: 
        localalh.rID = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(168935);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalh.Gld = ((FinderCommentInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 7: 
        localalh.rTD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168935);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalh.rIl = ((aqy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      }
      localalh.Oer = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(168935);
      return 0;
    }
    AppMethodBeat.o(168935);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alh
 * JD-Core Version:    0.7.0.1
 */