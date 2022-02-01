package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class asa
  extends cpx
{
  public int ELC;
  public int ELD;
  public String ELE;
  public String ELF;
  public String ELG;
  public int count;
  public String desc;
  public String djj;
  public int scene;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.ELF == null)
      {
        paramVarArgs = new b("Not all required fields were included: busi_id");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ELC);
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      paramVarArgs.aR(5, this.ELD);
      if (this.ELE != null) {
        paramVarArgs.d(6, this.ELE);
      }
      paramVarArgs.aR(7, this.count);
      paramVarArgs.aR(8, this.scene);
      if (this.ELF != null) {
        paramVarArgs.d(9, this.ELF);
      }
      if (this.sign != null) {
        paramVarArgs.d(10, this.sign);
      }
      if (this.ELG != null) {
        paramVarArgs.d(11, this.ELG);
      }
      AppMethodBeat.o(72476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ELC);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.djj);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.desc);
      }
      i += f.a.a.b.b.a.bx(5, this.ELD);
      paramInt = i;
      if (this.ELE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ELE);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.count) + f.a.a.b.b.a.bx(8, this.scene);
      paramInt = i;
      if (this.ELF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ELF);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.sign);
      }
      paramInt = i;
      if (this.ELG != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ELG);
      }
      AppMethodBeat.o(72476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.djj == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        if (this.ELF == null)
        {
          paramVarArgs = new b("Not all required fields were included: busi_id");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asa localasa = (asa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72476);
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
            localasa.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72476);
          return 0;
        case 2: 
          localasa.ELC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72476);
          return 0;
        case 3: 
          localasa.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 4: 
          localasa.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 5: 
          localasa.ELD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72476);
          return 0;
        case 6: 
          localasa.ELE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 7: 
          localasa.count = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72476);
          return 0;
        case 8: 
          localasa.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72476);
          return 0;
        case 9: 
          localasa.ELF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 10: 
          localasa.sign = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72476);
          return 0;
        }
        localasa.ELG = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72476);
        return 0;
      }
      AppMethodBeat.o(72476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asa
 * JD-Core Version:    0.7.0.1
 */