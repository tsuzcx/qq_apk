package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class px
  extends com.tencent.mm.bx.a
{
  public aen YUc;
  public rk YUd;
  public ps YUe;
  public rr YUf;
  public rq YUg;
  public oe YUh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124434);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YUc != null)
      {
        paramVarArgs.qD(1, this.YUc.computeSize());
        this.YUc.writeFields(paramVarArgs);
      }
      if (this.YUd != null)
      {
        paramVarArgs.qD(2, this.YUd.computeSize());
        this.YUd.writeFields(paramVarArgs);
      }
      if (this.YUe != null)
      {
        paramVarArgs.qD(3, this.YUe.computeSize());
        this.YUe.writeFields(paramVarArgs);
      }
      if (this.YUf != null)
      {
        paramVarArgs.qD(4, this.YUf.computeSize());
        this.YUf.writeFields(paramVarArgs);
      }
      if (this.YUg != null)
      {
        paramVarArgs.qD(5, this.YUg.computeSize());
        this.YUg.writeFields(paramVarArgs);
      }
      if (this.YUh != null)
      {
        paramVarArgs.qD(6, this.YUh.computeSize());
        this.YUh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YUc == null) {
        break label946;
      }
    }
    label946:
    for (int i = i.a.a.a.qC(1, this.YUc.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YUd != null) {
        paramInt = i + i.a.a.a.qC(2, this.YUd.computeSize());
      }
      i = paramInt;
      if (this.YUe != null) {
        i = paramInt + i.a.a.a.qC(3, this.YUe.computeSize());
      }
      paramInt = i;
      if (this.YUf != null) {
        paramInt = i + i.a.a.a.qC(4, this.YUf.computeSize());
      }
      i = paramInt;
      if (this.YUg != null) {
        i = paramInt + i.a.a.a.qC(5, this.YUg.computeSize());
      }
      paramInt = i;
      if (this.YUh != null) {
        paramInt = i + i.a.a.a.qC(6, this.YUh.computeSize());
      }
      AppMethodBeat.o(124434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        px localpx = (px)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124434);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aen();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aen)localObject2).parseFrom((byte[])localObject1);
            }
            localpx.YUc = ((aen)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rk)localObject2).parseFrom((byte[])localObject1);
            }
            localpx.YUd = ((rk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ps();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ps)localObject2).parseFrom((byte[])localObject1);
            }
            localpx.YUe = ((ps)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rr)localObject2).parseFrom((byte[])localObject1);
            }
            localpx.YUf = ((rr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rq)localObject2).parseFrom((byte[])localObject1);
            }
            localpx.YUg = ((rq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new oe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((oe)localObject2).parseFrom((byte[])localObject1);
          }
          localpx.YUh = ((oe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      AppMethodBeat.o(124434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.px
 * JD-Core Version:    0.7.0.1
 */