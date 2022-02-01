package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class pw
  extends cvc
{
  public b FLc;
  public String FvH;
  public String FvI;
  public String FvJ;
  public int FvL;
  public String xZb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91365);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FvH != null) {
        paramVarArgs.d(2, this.FvH);
      }
      if (this.FvI != null) {
        paramVarArgs.d(3, this.FvI);
      }
      if (this.xZb != null) {
        paramVarArgs.d(4, this.xZb);
      }
      paramVarArgs.aS(5, this.FvL);
      if (this.FLc != null) {
        paramVarArgs.c(6, this.FLc);
      }
      if (this.FvJ != null) {
        paramVarArgs.d(7, this.FvJ);
      }
      AppMethodBeat.o(91365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FvH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FvH);
      }
      i = paramInt;
      if (this.FvI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FvI);
      }
      paramInt = i;
      if (this.xZb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xZb);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FvL);
      paramInt = i;
      if (this.FLc != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.FLc);
      }
      i = paramInt;
      if (this.FvJ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FvJ);
      }
      AppMethodBeat.o(91365);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pw localpw = (pw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91365);
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
            localpw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91365);
          return 0;
        case 2: 
          localpw.FvH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 3: 
          localpw.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 4: 
          localpw.xZb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 5: 
          localpw.FvL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91365);
          return 0;
        case 6: 
          localpw.FLc = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91365);
          return 0;
        }
        localpw.FvJ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91365);
        return 0;
      }
      AppMethodBeat.o(91365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pw
 * JD-Core Version:    0.7.0.1
 */