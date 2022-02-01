package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class adq
  extends cpx
{
  public int DUY;
  public String DUo;
  public String DXX;
  public String DYF;
  public SKBuiltinBuffer_t DYu;
  public String Ewr;
  public String Ews;
  public int Ewt;
  public String pAD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYu == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155402);
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
      paramVarArgs.aR(3, this.DUY);
      if (this.DXX != null) {
        paramVarArgs.d(4, this.DXX);
      }
      if (this.pAD != null) {
        paramVarArgs.d(5, this.pAD);
      }
      if (this.DYF != null) {
        paramVarArgs.d(6, this.DYF);
      }
      if (this.Ewr != null) {
        paramVarArgs.d(7, this.Ewr);
      }
      if (this.DUo != null) {
        paramVarArgs.d(8, this.DUo);
      }
      if (this.Ews != null) {
        paramVarArgs.d(9, this.Ews);
      }
      paramVarArgs.aR(10, this.Ewt);
      AppMethodBeat.o(155402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DYu != null) {
        i = paramInt + f.a.a.a.lm(2, this.DYu.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.DUY);
      paramInt = i;
      if (this.DXX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DXX);
      }
      i = paramInt;
      if (this.pAD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.pAD);
      }
      paramInt = i;
      if (this.DYF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DYF);
      }
      i = paramInt;
      if (this.Ewr != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ewr);
      }
      paramInt = i;
      if (this.DUo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DUo);
      }
      i = paramInt;
      if (this.Ews != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ews);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.Ewt);
      AppMethodBeat.o(155402);
      return i + paramInt;
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
          AppMethodBeat.o(155402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adq localadq = (adq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155402);
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
            localadq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
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
            localadq.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 3: 
          localadq.DUY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155402);
          return 0;
        case 4: 
          localadq.DXX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 5: 
          localadq.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 6: 
          localadq.DYF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 7: 
          localadq.Ewr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 8: 
          localadq.DUo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 9: 
          localadq.Ews = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155402);
          return 0;
        }
        localadq.Ewt = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155402);
        return 0;
      }
      AppMethodBeat.o(155402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adq
 * JD-Core Version:    0.7.0.1
 */