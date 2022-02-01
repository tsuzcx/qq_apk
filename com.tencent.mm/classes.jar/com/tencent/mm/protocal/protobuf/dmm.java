package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmm
  extends cpx
{
  public int DRa;
  public String FUk;
  public String MD5;
  public String hOf;
  public String ncR;
  public int ndI;
  public int vTH;
  public int vTI;
  public int vTJ;
  public SKBuiltinBuffer_t vTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32484);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32484);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      paramVarArgs.aR(3, this.DRa);
      if (this.FUk != null) {
        paramVarArgs.d(4, this.FUk);
      }
      if (this.ncR != null) {
        paramVarArgs.d(5, this.ncR);
      }
      paramVarArgs.aR(6, this.vTH);
      paramVarArgs.aR(7, this.vTI);
      paramVarArgs.aR(8, this.vTJ);
      if (this.vTK != null)
      {
        paramVarArgs.ln(9, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.ndI);
      if (this.MD5 != null) {
        paramVarArgs.d(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label999;
      }
    }
    label999:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hOf);
      }
      i += f.a.a.b.b.a.bx(3, this.DRa);
      paramInt = i;
      if (this.FUk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUk);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncR);
      }
      i = i + f.a.a.b.b.a.bx(6, this.vTH) + f.a.a.b.b.a.bx(7, this.vTI) + f.a.a.b.b.a.bx(8, this.vTJ);
      paramInt = i;
      if (this.vTK != null) {
        paramInt = i + f.a.a.a.lm(9, this.vTK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.ndI);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32484);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmm localdmm = (dmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32484);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 2: 
          localdmm.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 3: 
          localdmm.DRa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32484);
          return 0;
        case 4: 
          localdmm.FUk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 5: 
          localdmm.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 6: 
          localdmm.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32484);
          return 0;
        case 7: 
          localdmm.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32484);
          return 0;
        case 8: 
          localdmm.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32484);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmm.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 10: 
          localdmm.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32484);
          return 0;
        }
        localdmm.MD5 = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32484);
        return 0;
      }
      AppMethodBeat.o(32484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmm
 * JD-Core Version:    0.7.0.1
 */