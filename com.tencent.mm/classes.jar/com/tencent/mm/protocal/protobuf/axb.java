package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axb
  extends com.tencent.mm.bx.a
{
  public FinderObject ZIo;
  public int ZIp;
  public bqs ZIq;
  public bpb ZIr;
  public bsg ZIs;
  public int dataType;
  public long id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168953);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bv(2, this.id);
      if (this.ZIo != null)
      {
        paramVarArgs.qD(3, this.ZIo.computeSize());
        this.ZIo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.ZIp);
      if (this.ZIq != null)
      {
        paramVarArgs.qD(5, this.ZIq.computeSize());
        this.ZIq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.dataType);
      if (this.ZIr != null)
      {
        paramVarArgs.qD(7, this.ZIr.computeSize());
        this.ZIr.writeFields(paramVarArgs);
      }
      if (this.ZIs != null)
      {
        paramVarArgs.qD(8, this.ZIs.computeSize());
        this.ZIs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0 + i.a.a.b.b.a.q(2, this.id);
      paramInt = i;
      if (this.ZIo != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZIo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ZIp);
      paramInt = i;
      if (this.ZIq != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZIq.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.dataType);
      paramInt = i;
      if (this.ZIr != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZIr.computeSize());
      }
      i = paramInt;
      if (this.ZIs != null) {
        i = paramInt + i.a.a.a.qC(8, this.ZIs.computeSize());
      }
      AppMethodBeat.o(168953);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      axb localaxb = (axb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168953);
        return -1;
      case 1: 
        localaxb.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168953);
        return 0;
      case 2: 
        localaxb.id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(168953);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localaxb.ZIo = ((FinderObject)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 4: 
        localaxb.ZIp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168953);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqs)localObject2).parseFrom((byte[])localObject1);
          }
          localaxb.ZIq = ((bqs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 6: 
        localaxb.dataType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168953);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bpb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bpb)localObject2).parseFrom((byte[])localObject1);
          }
          localaxb.ZIr = ((bpb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bsg();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bsg)localObject2).parseFrom((byte[])localObject1);
        }
        localaxb.ZIs = ((bsg)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    AppMethodBeat.o(168953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axb
 * JD-Core Version:    0.7.0.1
 */