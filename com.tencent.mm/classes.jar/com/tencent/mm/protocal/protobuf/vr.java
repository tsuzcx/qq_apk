package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vr
  extends cvc
{
  public String FVe;
  public boolean FVf;
  public int FVg;
  public String FtI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FtI != null) {
        paramVarArgs.d(2, this.FtI);
      }
      if (this.FVe != null) {
        paramVarArgs.d(3, this.FVe);
      }
      paramVarArgs.bt(4, this.FVf);
      paramVarArgs.aS(5, this.FVg);
      AppMethodBeat.o(125716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FtI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FtI);
      }
      i = paramInt;
      if (this.FVe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVe);
      }
      paramInt = f.a.a.b.b.a.alV(4);
      int j = f.a.a.b.b.a.bz(5, this.FVg);
      AppMethodBeat.o(125716);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vr localvr = (vr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125716);
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
            localvr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125716);
          return 0;
        case 2: 
          localvr.FtI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 3: 
          localvr.FVe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 4: 
          localvr.FVf = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(125716);
          return 0;
        }
        localvr.FVg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125716);
        return 0;
      }
      AppMethodBeat.o(125716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vr
 * JD-Core Version:    0.7.0.1
 */