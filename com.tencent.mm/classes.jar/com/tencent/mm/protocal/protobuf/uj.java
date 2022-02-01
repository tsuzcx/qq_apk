package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uj
  extends cvc
{
  public String FTH;
  public String FTI;
  public String FvH;
  public String FvI;
  public int channel;
  public int vls;
  public int xXA;
  public String xYU;
  public String xYV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91403);
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
      paramVarArgs.aS(4, this.vls);
      if (this.xYV != null) {
        paramVarArgs.d(5, this.xYV);
      }
      if (this.xYU != null) {
        paramVarArgs.d(6, this.xYU);
      }
      paramVarArgs.aS(7, this.channel);
      paramVarArgs.aS(8, this.xXA);
      if (this.FTH != null) {
        paramVarArgs.d(9, this.FTH);
      }
      if (this.FTI != null) {
        paramVarArgs.d(10, this.FTI);
      }
      AppMethodBeat.o(91403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
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
      i += f.a.a.b.b.a.bz(4, this.vls);
      paramInt = i;
      if (this.xYV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.xYV);
      }
      i = paramInt;
      if (this.xYU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.xYU);
      }
      i = i + f.a.a.b.b.a.bz(7, this.channel) + f.a.a.b.b.a.bz(8, this.xXA);
      paramInt = i;
      if (this.FTH != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FTH);
      }
      i = paramInt;
      if (this.FTI != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FTI);
      }
      AppMethodBeat.o(91403);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uj localuj = (uj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91403);
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
            localuj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91403);
          return 0;
        case 2: 
          localuj.FvH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 3: 
          localuj.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 4: 
          localuj.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91403);
          return 0;
        case 5: 
          localuj.xYV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 6: 
          localuj.xYU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 7: 
          localuj.channel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91403);
          return 0;
        case 8: 
          localuj.xXA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91403);
          return 0;
        case 9: 
          localuj.FTH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91403);
          return 0;
        }
        localuj.FTI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91403);
        return 0;
      }
      AppMethodBeat.o(91403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uj
 * JD-Core Version:    0.7.0.1
 */