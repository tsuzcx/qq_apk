package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bfq
  extends com.tencent.mm.cd.a
{
  public ddn SQn;
  public ddk SQo;
  public ddm SQp;
  public ddl SQq;
  public LinkedList<ddo> SQr;
  public int adType;
  
  public bfq()
  {
    AppMethodBeat.i(197757);
    this.SQr = new LinkedList();
    AppMethodBeat.o(197757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197765);
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
      paramVarArgs.e(6, 8, this.SQr);
      AppMethodBeat.o(197765);
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
      paramInt = g.a.a.a.c(6, 8, this.SQr);
      AppMethodBeat.o(197765);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SQr.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(197765);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bfq localbfq = (bfq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197765);
        return -1;
      case 1: 
        localbfq.adType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(197765);
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
          localbfq.SQn = ((ddn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(197765);
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
          localbfq.SQo = ((ddk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(197765);
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
          localbfq.SQp = ((ddm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(197765);
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
          localbfq.SQq = ((ddl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(197765);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ddo();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ddo)localObject2).parseFrom((byte[])localObject1);
        }
        localbfq.SQr.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(197765);
      return 0;
    }
    AppMethodBeat.o(197765);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfq
 * JD-Core Version:    0.7.0.1
 */