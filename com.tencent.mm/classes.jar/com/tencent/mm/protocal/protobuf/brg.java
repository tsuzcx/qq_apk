package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class brg
  extends cvc
{
  public String GLE;
  public int GLp;
  public int GLq;
  public egx GLr;
  public int GbX;
  public String iht;
  public b nCV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.nCV != null) {
        paramVarArgs.c(3, this.nCV);
      }
      if (this.GLE != null) {
        paramVarArgs.d(4, this.GLE);
      }
      paramVarArgs.aS(5, this.GLp);
      paramVarArgs.aS(6, this.GLq);
      if (this.GLr != null)
      {
        paramVarArgs.lC(7, this.GLr.computeSize());
        this.GLr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.GbX);
      AppMethodBeat.o(123618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.nCV != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.nCV);
      }
      paramInt = i;
      if (this.GLE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GLE);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GLp) + f.a.a.b.b.a.bz(6, this.GLq);
      paramInt = i;
      if (this.GLr != null) {
        paramInt = i + f.a.a.a.lB(7, this.GLr.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.GbX);
      AppMethodBeat.o(123618);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brg localbrg = (brg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123618);
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
            localbrg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 2: 
          localbrg.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 3: 
          localbrg.nCV = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(123618);
          return 0;
        case 4: 
          localbrg.GLE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 5: 
          localbrg.GLp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123618);
          return 0;
        case 6: 
          localbrg.GLq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123618);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrg.GLr = ((egx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        }
        localbrg.GbX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123618);
        return 0;
      }
      AppMethodBeat.o(123618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brg
 * JD-Core Version:    0.7.0.1
 */