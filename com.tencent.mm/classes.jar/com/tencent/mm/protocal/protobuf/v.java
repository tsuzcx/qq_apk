package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends cvc
{
  public String FpG;
  public String FpH;
  public int scene;
  public String sign;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FpG != null) {
        paramVarArgs.d(2, this.FpG);
      }
      paramVarArgs.aS(3, this.scene);
      if (this.FpH != null) {
        paramVarArgs.d(4, this.FpH);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      paramVarArgs.aS(6, this.ver);
      AppMethodBeat.o(91333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FpG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FpG);
      }
      i += f.a.a.b.b.a.bz(3, this.scene);
      paramInt = i;
      if (this.FpH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FpH);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sign);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.ver);
      AppMethodBeat.o(91333);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91333);
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
            localv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91333);
          return 0;
        case 2: 
          localv.FpG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91333);
          return 0;
        case 3: 
          localv.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91333);
          return 0;
        case 4: 
          localv.FpH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91333);
          return 0;
        case 5: 
          localv.sign = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91333);
          return 0;
        }
        localv.ver = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91333);
        return 0;
      }
      AppMethodBeat.o(91333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.v
 * JD-Core Version:    0.7.0.1
 */