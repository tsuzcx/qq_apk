package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cus
  extends cpx
{
  public String DPS;
  public String FFW;
  public String FFX;
  public String Name;
  public String thV;
  public String vkB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.thV != null) {
        paramVarArgs.d(2, this.thV);
      }
      if (this.FFW != null) {
        paramVarArgs.d(3, this.FFW);
      }
      if (this.vkB != null) {
        paramVarArgs.d(5, this.vkB);
      }
      if (this.Name != null) {
        paramVarArgs.d(4, this.Name);
      }
      if (this.DPS != null) {
        paramVarArgs.d(6, this.DPS);
      }
      if (this.FFX != null) {
        paramVarArgs.d(7, this.FFX);
      }
      AppMethodBeat.o(155459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thV);
      }
      i = paramInt;
      if (this.FFW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FFW);
      }
      paramInt = i;
      if (this.vkB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vkB);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Name);
      }
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DPS);
      }
      i = paramInt;
      if (this.FFX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FFX);
      }
      AppMethodBeat.o(155459);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cus localcus = (cus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155459);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcus.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155459);
          return 0;
        case 2: 
          localcus.thV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 3: 
          localcus.FFW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 5: 
          localcus.vkB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 4: 
          localcus.Name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 6: 
          localcus.DPS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155459);
          return 0;
        }
        localcus.FFX = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155459);
        return 0;
      }
      AppMethodBeat.o(155459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cus
 * JD-Core Version:    0.7.0.1
 */