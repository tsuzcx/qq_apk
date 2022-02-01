package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blk
  extends com.tencent.mm.bw.a
{
  public String FaT;
  public String FaU;
  public ack FaV;
  public ack FaW;
  public String FaX;
  public String FaY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72509);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FaT != null) {
        paramVarArgs.d(1, this.FaT);
      }
      if (this.FaU != null) {
        paramVarArgs.d(2, this.FaU);
      }
      if (this.FaV != null)
      {
        paramVarArgs.ln(3, this.FaV.computeSize());
        this.FaV.writeFields(paramVarArgs);
      }
      if (this.FaW != null)
      {
        paramVarArgs.ln(4, this.FaW.computeSize());
        this.FaW.writeFields(paramVarArgs);
      }
      if (this.FaX != null) {
        paramVarArgs.d(5, this.FaX);
      }
      if (this.FaY != null) {
        paramVarArgs.d(6, this.FaY);
      }
      AppMethodBeat.o(72509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FaT == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.FaT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FaU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FaU);
      }
      i = paramInt;
      if (this.FaV != null) {
        i = paramInt + f.a.a.a.lm(3, this.FaV.computeSize());
      }
      paramInt = i;
      if (this.FaW != null) {
        paramInt = i + f.a.a.a.lm(4, this.FaW.computeSize());
      }
      i = paramInt;
      if (this.FaX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FaX);
      }
      paramInt = i;
      if (this.FaY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FaY);
      }
      AppMethodBeat.o(72509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blk localblk = (blk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72509);
          return -1;
        case 1: 
          localblk.FaT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 2: 
          localblk.FaU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ack();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ack)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblk.FaV = ((ack)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ack();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ack)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblk.FaW = ((ack)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 5: 
          localblk.FaX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72509);
          return 0;
        }
        localblk.FaY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72509);
        return 0;
      }
      AppMethodBeat.o(72509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blk
 * JD-Core Version:    0.7.0.1
 */