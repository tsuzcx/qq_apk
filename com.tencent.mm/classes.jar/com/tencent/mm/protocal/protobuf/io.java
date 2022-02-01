package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class io
  extends com.tencent.mm.bw.a
{
  public ceb FTO;
  public ceb FTP;
  public ceb FTQ;
  public ceb FTR;
  public int FTS;
  public int FTT;
  public int FTU;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118406);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.FTO != null)
      {
        paramVarArgs.lJ(2, this.FTO.computeSize());
        this.FTO.writeFields(paramVarArgs);
      }
      if (this.FTP != null)
      {
        paramVarArgs.lJ(3, this.FTP.computeSize());
        this.FTP.writeFields(paramVarArgs);
      }
      if (this.FTQ != null)
      {
        paramVarArgs.lJ(4, this.FTQ.computeSize());
        this.FTQ.writeFields(paramVarArgs);
      }
      if (this.FTR != null)
      {
        paramVarArgs.lJ(11, this.FTR.computeSize());
        this.FTR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(100, this.FTS);
      paramVarArgs.aS(101, this.FTT);
      paramVarArgs.aS(102, this.FTU);
      AppMethodBeat.o(118406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.FTO != null) {
        paramInt = i + f.a.a.a.lI(2, this.FTO.computeSize());
      }
      i = paramInt;
      if (this.FTP != null) {
        i = paramInt + f.a.a.a.lI(3, this.FTP.computeSize());
      }
      paramInt = i;
      if (this.FTQ != null) {
        paramInt = i + f.a.a.a.lI(4, this.FTQ.computeSize());
      }
      i = paramInt;
      if (this.FTR != null) {
        i = paramInt + f.a.a.a.lI(11, this.FTR.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(100, this.FTS);
      int j = f.a.a.b.b.a.bz(101, this.FTT);
      int k = f.a.a.b.b.a.bz(102, this.FTU);
      AppMethodBeat.o(118406);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(118406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      io localio = (io)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118406);
        return -1;
      case 1: 
        localio.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118406);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ceb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ceb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localio.FTO = ((ceb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ceb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ceb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localio.FTP = ((ceb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ceb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ceb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localio.FTQ = ((ceb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ceb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ceb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localio.FTR = ((ceb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 100: 
        localio.FTS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118406);
        return 0;
      case 101: 
        localio.FTT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118406);
        return 0;
      }
      localio.FTU = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(118406);
      return 0;
    }
    AppMethodBeat.o(118406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.io
 * JD-Core Version:    0.7.0.1
 */