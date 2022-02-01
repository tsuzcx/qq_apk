package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tl
  extends cpx
{
  public String Enx;
  public int channel;
  public String oxg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oxg == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_url");
        AppMethodBeat.o(72439);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oxg != null) {
        paramVarArgs.d(2, this.oxg);
      }
      paramVarArgs.aR(3, this.channel);
      if (this.Enx != null) {
        paramVarArgs.d(4, this.Enx);
      }
      AppMethodBeat.o(72439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oxg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oxg);
      }
      i += f.a.a.b.b.a.bx(3, this.channel);
      paramInt = i;
      if (this.Enx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Enx);
      }
      AppMethodBeat.o(72439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.oxg == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_url");
          AppMethodBeat.o(72439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tl localtl = (tl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72439);
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
            localtl.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72439);
          return 0;
        case 2: 
          localtl.oxg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72439);
          return 0;
        case 3: 
          localtl.channel = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72439);
          return 0;
        }
        localtl.Enx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72439);
        return 0;
      }
      AppMethodBeat.o(72439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tl
 * JD-Core Version:    0.7.0.1
 */