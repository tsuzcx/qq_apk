package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bga
  extends com.tencent.mm.cd.a
{
  public LinkedList<bfz> SQS;
  public bfx SQT;
  public bfy SQU;
  public bfy SQV;
  public dnb SQW;
  
  public bga()
  {
    AppMethodBeat.i(200967);
    this.SQS = new LinkedList();
    AppMethodBeat.o(200967);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200989);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SQS);
      if (this.SQT != null)
      {
        paramVarArgs.oE(2, this.SQT.computeSize());
        this.SQT.writeFields(paramVarArgs);
      }
      if (this.SQU != null)
      {
        paramVarArgs.oE(3, this.SQU.computeSize());
        this.SQU.writeFields(paramVarArgs);
      }
      if (this.SQV != null)
      {
        paramVarArgs.oE(4, this.SQV.computeSize());
        this.SQV.writeFields(paramVarArgs);
      }
      if (this.SQW != null)
      {
        paramVarArgs.oE(5, this.SQW.computeSize());
        this.SQW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200989);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.SQS) + 0;
      paramInt = i;
      if (this.SQT != null) {
        paramInt = i + g.a.a.a.oD(2, this.SQT.computeSize());
      }
      i = paramInt;
      if (this.SQU != null) {
        i = paramInt + g.a.a.a.oD(3, this.SQU.computeSize());
      }
      paramInt = i;
      if (this.SQV != null) {
        paramInt = i + g.a.a.a.oD(4, this.SQV.computeSize());
      }
      i = paramInt;
      if (this.SQW != null) {
        i = paramInt + g.a.a.a.oD(5, this.SQW.computeSize());
      }
      AppMethodBeat.o(200989);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SQS.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200989);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bga localbga = (bga)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200989);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfz)localObject2).parseFrom((byte[])localObject1);
          }
          localbga.SQS.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200989);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfx)localObject2).parseFrom((byte[])localObject1);
          }
          localbga.SQT = ((bfx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200989);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfy)localObject2).parseFrom((byte[])localObject1);
          }
          localbga.SQU = ((bfy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200989);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfy)localObject2).parseFrom((byte[])localObject1);
          }
          localbga.SQV = ((bfy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200989);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dnb();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dnb)localObject2).parseFrom((byte[])localObject1);
        }
        localbga.SQW = ((dnb)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(200989);
      return 0;
    }
    AppMethodBeat.o(200989);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bga
 * JD-Core Version:    0.7.0.1
 */