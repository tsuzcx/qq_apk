package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxk
  extends com.tencent.mm.bx.a
{
  public li bitFeature;
  public String finderUsername;
  public long objectId;
  public String objectNonceId;
  public bxf orgVal;
  public djb valFeature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169091);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.objectId);
      if (this.bitFeature != null)
      {
        paramVarArgs.kX(2, this.bitFeature.computeSize());
        this.bitFeature.writeFields(paramVarArgs);
      }
      if (this.valFeature != null)
      {
        paramVarArgs.kX(3, this.valFeature.computeSize());
        this.valFeature.writeFields(paramVarArgs);
      }
      if (this.orgVal != null)
      {
        paramVarArgs.kX(4, this.orgVal.computeSize());
        this.orgVal.writeFields(paramVarArgs);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      if (this.finderUsername != null) {
        paramVarArgs.d(6, this.finderUsername);
      }
      AppMethodBeat.o(169091);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.objectId) + 0;
      paramInt = i;
      if (this.bitFeature != null) {
        paramInt = i + f.a.a.a.kW(2, this.bitFeature.computeSize());
      }
      i = paramInt;
      if (this.valFeature != null) {
        i = paramInt + f.a.a.a.kW(3, this.valFeature.computeSize());
      }
      paramInt = i;
      if (this.orgVal != null) {
        paramInt = i + f.a.a.a.kW(4, this.orgVal.computeSize());
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.finderUsername);
      }
      AppMethodBeat.o(169091);
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
      AppMethodBeat.o(169091);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cxk localcxk = (cxk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169091);
        return -1;
      case 1: 
        localcxk.objectId = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(169091);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new li();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((li)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxk.bitFeature = ((li)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((djb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxk.valFeature = ((djb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxk.orgVal = ((bxf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 5: 
        localcxk.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169091);
        return 0;
      }
      localcxk.finderUsername = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(169091);
      return 0;
    }
    AppMethodBeat.o(169091);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxk
 * JD-Core Version:    0.7.0.1
 */