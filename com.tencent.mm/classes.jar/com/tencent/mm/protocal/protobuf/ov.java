package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ov
  extends cpx
{
  public String EeN;
  public int EeO;
  public int channel;
  public String iAz;
  public int uiK;
  public int wJT;
  public String wJU;
  public String wJV;
  public String wLr;
  public String wLu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91370);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uiK);
      paramVarArgs.aR(3, this.channel);
      paramVarArgs.aR(4, this.wJT);
      if (this.EeN != null) {
        paramVarArgs.d(5, this.EeN);
      }
      if (this.wLr != null) {
        paramVarArgs.d(6, this.wLr);
      }
      if (this.wJU != null) {
        paramVarArgs.d(7, this.wJU);
      }
      if (this.wLu != null) {
        paramVarArgs.d(8, this.wLu);
      }
      if (this.iAz != null) {
        paramVarArgs.d(9, this.iAz);
      }
      if (this.wJV != null) {
        paramVarArgs.d(10, this.wJV);
      }
      paramVarArgs.aR(11, this.EeO);
      AppMethodBeat.o(91370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.uiK) + f.a.a.b.b.a.bx(3, this.channel) + f.a.a.b.b.a.bx(4, this.wJT);
      paramInt = i;
      if (this.EeN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EeN);
      }
      i = paramInt;
      if (this.wLr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wLr);
      }
      paramInt = i;
      if (this.wJU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wJU);
      }
      i = paramInt;
      if (this.wLu != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.wLu);
      }
      paramInt = i;
      if (this.iAz != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iAz);
      }
      i = paramInt;
      if (this.wJV != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.wJV);
      }
      paramInt = f.a.a.b.b.a.bx(11, this.EeO);
      AppMethodBeat.o(91370);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ov localov = (ov)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91370);
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
            localov.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91370);
          return 0;
        case 2: 
          localov.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91370);
          return 0;
        case 3: 
          localov.channel = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91370);
          return 0;
        case 4: 
          localov.wJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91370);
          return 0;
        case 5: 
          localov.EeN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 6: 
          localov.wLr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 7: 
          localov.wJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 8: 
          localov.wLu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 9: 
          localov.iAz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 10: 
          localov.wJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91370);
          return 0;
        }
        localov.EeO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91370);
        return 0;
      }
      AppMethodBeat.o(91370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ov
 * JD-Core Version:    0.7.0.1
 */