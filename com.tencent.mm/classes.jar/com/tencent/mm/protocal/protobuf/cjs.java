package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjs
  extends cqk
{
  public String AYl;
  public String Fui;
  public String Fuj;
  public av Fxu;
  public dhe Fxv;
  public cgb Fxw;
  public String Fxx;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72565);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72565);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      if (this.Fui != null) {
        paramVarArgs.d(4, this.Fui);
      }
      if (this.Fuj != null) {
        paramVarArgs.d(5, this.Fuj);
      }
      if (this.Fxu != null)
      {
        paramVarArgs.ln(6, this.Fxu.computeSize());
        this.Fxu.writeFields(paramVarArgs);
      }
      if (this.Fxv != null)
      {
        paramVarArgs.ln(7, this.Fxv.computeSize());
        this.Fxv.writeFields(paramVarArgs);
      }
      if (this.Fxw != null)
      {
        paramVarArgs.ln(8, this.Fxw.computeSize());
        this.Fxw.writeFields(paramVarArgs);
      }
      if (this.Fxx != null) {
        paramVarArgs.d(9, this.Fxx);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(72565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1210;
      }
    }
    label1210:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.Fui != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Fui);
      }
      paramInt = i;
      if (this.Fuj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fuj);
      }
      i = paramInt;
      if (this.Fxu != null) {
        i = paramInt + f.a.a.a.lm(6, this.Fxu.computeSize());
      }
      paramInt = i;
      if (this.Fxv != null) {
        paramInt = i + f.a.a.a.lm(7, this.Fxv.computeSize());
      }
      i = paramInt;
      if (this.Fxw != null) {
        i = paramInt + f.a.a.a.lm(8, this.Fxw.computeSize());
      }
      paramInt = i;
      if (this.Fxx != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fxx);
      }
      i = paramInt;
      if (this.AYl != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(72565);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjs localcjs = (cjs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72565);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 2: 
          localcjs.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72565);
          return 0;
        case 3: 
          localcjs.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 4: 
          localcjs.Fui = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 5: 
          localcjs.Fuj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new av();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((av)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjs.Fxu = ((av)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjs.Fxv = ((dhe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjs.Fxw = ((cgb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 9: 
          localcjs.Fxx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72565);
          return 0;
        }
        localcjs.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72565);
        return 0;
      }
      AppMethodBeat.o(72565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjs
 * JD-Core Version:    0.7.0.1
 */