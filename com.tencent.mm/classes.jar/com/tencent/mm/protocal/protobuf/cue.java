package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cue
  extends ckq
{
  public ciu CxV;
  public SKBuiltinBuffer_t ElQ;
  public SKBuiltinBuffer_t ElR;
  public int ElS;
  public long Id;
  public int Scene;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125766);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.Id);
      paramVarArgs.aR(3, this.Scene);
      if (this.ElQ != null)
      {
        paramVarArgs.kX(4, this.ElQ.computeSize());
        this.ElQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.rNz);
      if (this.ElR != null)
      {
        paramVarArgs.kX(6, this.ElR.computeSize());
        this.ElR.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.ElS);
      if (this.CxV != null)
      {
        paramVarArgs.kX(8, this.CxV.computeSize());
        this.CxV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Id) + f.a.a.b.b.a.bA(3, this.Scene);
      paramInt = i;
      if (this.ElQ != null) {
        paramInt = i + f.a.a.a.kW(4, this.ElQ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.rNz);
      paramInt = i;
      if (this.ElR != null) {
        paramInt = i + f.a.a.a.kW(6, this.ElR.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.ElS);
      paramInt = i;
      if (this.CxV != null) {
        paramInt = i + f.a.a.a.kW(8, this.CxV.computeSize());
      }
      AppMethodBeat.o(125766);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cue localcue = (cue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125766);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcue.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 2: 
          localcue.Id = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125766);
          return 0;
        case 3: 
          localcue.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125766);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcue.ElQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 5: 
          localcue.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125766);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcue.ElR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 7: 
          localcue.ElS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125766);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ciu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ciu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcue.CxV = ((ciu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      AppMethodBeat.o(125766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cue
 * JD-Core Version:    0.7.0.1
 */