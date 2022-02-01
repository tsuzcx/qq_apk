package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class beo
  extends cpx
{
  public String DUo;
  public SKBuiltinBuffer_t DYu;
  public String ETW;
  public String ETX;
  public String ETY;
  public String ETZ;
  public String EUa;
  public int EUb;
  public String ndW;
  public String pAD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYu == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155417);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DYu != null)
      {
        paramVarArgs.ln(2, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      if (this.ETW != null) {
        paramVarArgs.d(3, this.ETW);
      }
      if (this.ETX != null) {
        paramVarArgs.d(4, this.ETX);
      }
      if (this.ndW != null) {
        paramVarArgs.d(5, this.ndW);
      }
      if (this.ETY != null) {
        paramVarArgs.d(6, this.ETY);
      }
      if (this.ETZ != null) {
        paramVarArgs.d(7, this.ETZ);
      }
      if (this.EUa != null) {
        paramVarArgs.d(8, this.EUa);
      }
      paramVarArgs.aR(9, this.EUb);
      if (this.pAD != null) {
        paramVarArgs.d(10, this.pAD);
      }
      if (this.DUo != null) {
        paramVarArgs.d(11, this.DUo);
      }
      AppMethodBeat.o(155417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1050;
      }
    }
    label1050:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DYu != null) {
        paramInt = i + f.a.a.a.lm(2, this.DYu.computeSize());
      }
      i = paramInt;
      if (this.ETW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ETW);
      }
      paramInt = i;
      if (this.ETX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ETX);
      }
      i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ndW);
      }
      paramInt = i;
      if (this.ETY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ETY);
      }
      i = paramInt;
      if (this.ETZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ETZ);
      }
      paramInt = i;
      if (this.EUa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EUa);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.EUb);
      paramInt = i;
      if (this.pAD != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.pAD);
      }
      i = paramInt;
      if (this.DUo != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DUo);
      }
      AppMethodBeat.o(155417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DYu == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        beo localbeo = (beo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155417);
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
            localbeo.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeo.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 3: 
          localbeo.ETW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 4: 
          localbeo.ETX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 5: 
          localbeo.ndW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 6: 
          localbeo.ETY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 7: 
          localbeo.ETZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 8: 
          localbeo.EUa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 9: 
          localbeo.EUb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155417);
          return 0;
        case 10: 
          localbeo.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155417);
          return 0;
        }
        localbeo.DUo = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155417);
        return 0;
      }
      AppMethodBeat.o(155417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beo
 * JD-Core Version:    0.7.0.1
 */