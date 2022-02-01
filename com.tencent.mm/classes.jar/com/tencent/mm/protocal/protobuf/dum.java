package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dum
  extends cvc
{
  public SKBuiltinBuffer_t FDQ;
  public String Gvv;
  public long Gvx;
  public String Hlc;
  public String Hld;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104379);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gvv != null) {
        paramVarArgs.d(2, this.Gvv);
      }
      paramVarArgs.aY(3, this.Gvx);
      if (this.FDQ != null)
      {
        paramVarArgs.lC(4, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      if (this.Hlc != null) {
        paramVarArgs.d(5, this.Hlc);
      }
      if (this.Hld != null) {
        paramVarArgs.d(6, this.Hld);
      }
      paramVarArgs.aS(7, this.Scene);
      AppMethodBeat.o(104379);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gvv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gvv);
      }
      i += f.a.a.b.b.a.p(3, this.Gvx);
      paramInt = i;
      if (this.FDQ != null) {
        paramInt = i + f.a.a.a.lB(4, this.FDQ.computeSize());
      }
      i = paramInt;
      if (this.Hlc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hlc);
      }
      paramInt = i;
      if (this.Hld != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hld);
      }
      i = f.a.a.b.b.a.bz(7, this.Scene);
      AppMethodBeat.o(104379);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104379);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dum localdum = (dum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104379);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdum.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104379);
          return 0;
        case 2: 
          localdum.Gvv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104379);
          return 0;
        case 3: 
          localdum.Gvx = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(104379);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdum.FDQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104379);
          return 0;
        case 5: 
          localdum.Hlc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104379);
          return 0;
        case 6: 
          localdum.Hld = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104379);
          return 0;
        }
        localdum.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104379);
        return 0;
      }
      AppMethodBeat.o(104379);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dum
 * JD-Core Version:    0.7.0.1
 */