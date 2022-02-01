package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cil
  extends ckq
{
  public SKBuiltinBuffer_t CFU;
  public String Drp;
  public long Drr;
  public String EdQ;
  public String EdR;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104375);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.Drr);
      if (this.EdQ != null) {
        paramVarArgs.d(3, this.EdQ);
      }
      if (this.EdR != null) {
        paramVarArgs.d(4, this.EdR);
      }
      if (this.Drp != null) {
        paramVarArgs.d(5, this.Drp);
      }
      if (this.CFU != null)
      {
        paramVarArgs.kX(6, this.CFU.computeSize());
        this.CFU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Scene);
      AppMethodBeat.o(104375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Drr);
      paramInt = i;
      if (this.EdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EdQ);
      }
      i = paramInt;
      if (this.EdR != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EdR);
      }
      paramInt = i;
      if (this.Drp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Drp);
      }
      i = paramInt;
      if (this.CFU != null) {
        i = paramInt + f.a.a.a.kW(6, this.CFU.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(7, this.Scene);
      AppMethodBeat.o(104375);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cil localcil = (cil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104375);
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
            localcil.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        case 2: 
          localcil.Drr = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(104375);
          return 0;
        case 3: 
          localcil.EdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 4: 
          localcil.EdR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 5: 
          localcil.Drp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104375);
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
            localcil.CFU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        }
        localcil.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104375);
        return 0;
      }
      AppMethodBeat.o(104375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cil
 * JD-Core Version:    0.7.0.1
 */