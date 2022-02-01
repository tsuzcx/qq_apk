package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vg
  extends cvc
{
  public String FUG;
  public int channel;
  public String paB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.paB == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_url");
        AppMethodBeat.o(72439);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.paB != null) {
        paramVarArgs.d(2, this.paB);
      }
      paramVarArgs.aS(3, this.channel);
      if (this.FUG != null) {
        paramVarArgs.d(4, this.FUG);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.paB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.paB);
      }
      i += f.a.a.b.b.a.bz(3, this.channel);
      paramInt = i;
      if (this.FUG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUG);
      }
      AppMethodBeat.o(72439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.paB == null)
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
        vg localvg = (vg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72439);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72439);
          return 0;
        case 2: 
          localvg.paB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72439);
          return 0;
        case 3: 
          localvg.channel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72439);
          return 0;
        }
        localvg.FUG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72439);
        return 0;
      }
      AppMethodBeat.o(72439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vg
 * JD-Core Version:    0.7.0.1
 */