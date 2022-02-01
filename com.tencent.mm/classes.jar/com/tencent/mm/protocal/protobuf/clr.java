package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clr
  extends cvc
{
  public int GFE;
  public int Gxr;
  public boolean HeT;
  public String duW;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.duW != null) {
        paramVarArgs.d(3, this.duW);
      }
      paramVarArgs.aS(4, this.GFE);
      if (this.path != null) {
        paramVarArgs.d(5, this.path);
      }
      paramVarArgs.aS(6, this.Gxr);
      paramVarArgs.bt(7, this.HeT);
      AppMethodBeat.o(123636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.duW);
      }
      i += f.a.a.b.b.a.bz(4, this.GFE);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.path);
      }
      i = f.a.a.b.b.a.bz(6, this.Gxr);
      int j = f.a.a.b.b.a.alV(7);
      AppMethodBeat.o(123636);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clr localclr = (clr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123636);
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
            localclr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123636);
          return 0;
        case 2: 
          localclr.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 3: 
          localclr.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 4: 
          localclr.GFE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123636);
          return 0;
        case 5: 
          localclr.path = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 6: 
          localclr.Gxr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123636);
          return 0;
        }
        localclr.HeT = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(123636);
        return 0;
      }
      AppMethodBeat.o(123636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clr
 * JD-Core Version:    0.7.0.1
 */