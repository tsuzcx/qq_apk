package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddo
  extends com.tencent.mm.cd.a
{
  public long KlG;
  public ddn SQn;
  public ddk SQo;
  public ddm SQp;
  public ddl SQq;
  public int adType;
  public String jDL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.adType);
      if (this.SQn != null)
      {
        paramVarArgs.oE(2, this.SQn.computeSize());
        this.SQn.writeFields(paramVarArgs);
      }
      if (this.SQo != null)
      {
        paramVarArgs.oE(3, this.SQo.computeSize());
        this.SQo.writeFields(paramVarArgs);
      }
      if (this.SQp != null)
      {
        paramVarArgs.oE(4, this.SQp.computeSize());
        this.SQp.writeFields(paramVarArgs);
      }
      if (this.SQq != null)
      {
        paramVarArgs.oE(5, this.SQq.computeSize());
        this.SQq.writeFields(paramVarArgs);
      }
      if (this.jDL != null) {
        paramVarArgs.f(20, this.jDL);
      }
      paramVarArgs.bm(21, this.KlG);
      AppMethodBeat.o(203653);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.adType) + 0;
      paramInt = i;
      if (this.SQn != null) {
        paramInt = i + g.a.a.a.oD(2, this.SQn.computeSize());
      }
      i = paramInt;
      if (this.SQo != null) {
        i = paramInt + g.a.a.a.oD(3, this.SQo.computeSize());
      }
      paramInt = i;
      if (this.SQp != null) {
        paramInt = i + g.a.a.a.oD(4, this.SQp.computeSize());
      }
      i = paramInt;
      if (this.SQq != null) {
        i = paramInt + g.a.a.a.oD(5, this.SQq.computeSize());
      }
      paramInt = i;
      if (this.jDL != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.jDL);
      }
      i = g.a.a.b.b.a.p(21, this.KlG);
      AppMethodBeat.o(203653);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203653);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ddo localddo = (ddo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203653);
        return -1;
      case 1: 
        localddo.adType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(203653);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ddn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ddn)localObject2).parseFrom((byte[])localObject1);
          }
          localddo.SQn = ((ddn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203653);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ddk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ddk)localObject2).parseFrom((byte[])localObject1);
          }
          localddo.SQo = ((ddk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203653);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ddm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ddm)localObject2).parseFrom((byte[])localObject1);
          }
          localddo.SQp = ((ddm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203653);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ddl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ddl)localObject2).parseFrom((byte[])localObject1);
          }
          localddo.SQq = ((ddl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203653);
        return 0;
      case 20: 
        localddo.jDL = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(203653);
        return 0;
      }
      localddo.KlG = ((g.a.a.a.a)localObject1).abFh.AN();
      AppMethodBeat.o(203653);
      return 0;
    }
    AppMethodBeat.o(203653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddo
 * JD-Core Version:    0.7.0.1
 */