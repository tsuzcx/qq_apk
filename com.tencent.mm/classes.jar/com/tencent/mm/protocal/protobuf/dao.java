package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dao
  extends com.tencent.mm.bx.a
{
  public int aaGa;
  public dar aaGb;
  public daq aaGc;
  public dap aaGd;
  public dan aaGe;
  public das aaGf;
  public dat aaGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32324);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaGa);
      if (this.aaGb != null)
      {
        paramVarArgs.qD(2, this.aaGb.computeSize());
        this.aaGb.writeFields(paramVarArgs);
      }
      if (this.aaGc != null)
      {
        paramVarArgs.qD(3, this.aaGc.computeSize());
        this.aaGc.writeFields(paramVarArgs);
      }
      if (this.aaGd != null)
      {
        paramVarArgs.qD(4, this.aaGd.computeSize());
        this.aaGd.writeFields(paramVarArgs);
      }
      if (this.aaGe != null)
      {
        paramVarArgs.qD(5, this.aaGe.computeSize());
        this.aaGe.writeFields(paramVarArgs);
      }
      if (this.aaGf != null)
      {
        paramVarArgs.qD(6, this.aaGf.computeSize());
        this.aaGf.writeFields(paramVarArgs);
      }
      if (this.aaGg != null)
      {
        paramVarArgs.qD(7, this.aaGg.computeSize());
        this.aaGg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaGa) + 0;
      paramInt = i;
      if (this.aaGb != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaGb.computeSize());
      }
      i = paramInt;
      if (this.aaGc != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaGc.computeSize());
      }
      paramInt = i;
      if (this.aaGd != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaGd.computeSize());
      }
      i = paramInt;
      if (this.aaGe != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaGe.computeSize());
      }
      paramInt = i;
      if (this.aaGf != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaGf.computeSize());
      }
      i = paramInt;
      if (this.aaGg != null) {
        i = paramInt + i.a.a.a.qC(7, this.aaGg.computeSize());
      }
      AppMethodBeat.o(32324);
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
      AppMethodBeat.o(32324);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dao localdao = (dao)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32324);
        return -1;
      case 1: 
        localdao.aaGa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32324);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dar();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dar)localObject2).parseFrom((byte[])localObject1);
          }
          localdao.aaGb = ((dar)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new daq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((daq)localObject2).parseFrom((byte[])localObject1);
          }
          localdao.aaGc = ((daq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dap();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dap)localObject2).parseFrom((byte[])localObject1);
          }
          localdao.aaGd = ((dap)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dan();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dan)localObject2).parseFrom((byte[])localObject1);
          }
          localdao.aaGe = ((dan)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new das();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((das)localObject2).parseFrom((byte[])localObject1);
          }
          localdao.aaGf = ((das)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dat();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dat)localObject2).parseFrom((byte[])localObject1);
        }
        localdao.aaGg = ((dat)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    AppMethodBeat.o(32324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dao
 * JD-Core Version:    0.7.0.1
 */