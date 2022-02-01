package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qa
  extends cvc
{
  public String FLm;
  public int FLn;
  public int channel;
  public String iTJ;
  public int vls;
  public int xXA;
  public String xXB;
  public String xXC;
  public String xYY;
  public String xZb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91370);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.vls);
      paramVarArgs.aS(3, this.channel);
      paramVarArgs.aS(4, this.xXA);
      if (this.FLm != null) {
        paramVarArgs.d(5, this.FLm);
      }
      if (this.xYY != null) {
        paramVarArgs.d(6, this.xYY);
      }
      if (this.xXB != null) {
        paramVarArgs.d(7, this.xXB);
      }
      if (this.xZb != null) {
        paramVarArgs.d(8, this.xZb);
      }
      if (this.iTJ != null) {
        paramVarArgs.d(9, this.iTJ);
      }
      if (this.xXC != null) {
        paramVarArgs.d(10, this.xXC);
      }
      paramVarArgs.aS(11, this.FLn);
      AppMethodBeat.o(91370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.vls) + f.a.a.b.b.a.bz(3, this.channel) + f.a.a.b.b.a.bz(4, this.xXA);
      paramInt = i;
      if (this.FLm != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FLm);
      }
      i = paramInt;
      if (this.xYY != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.xYY);
      }
      paramInt = i;
      if (this.xXB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.xXB);
      }
      i = paramInt;
      if (this.xZb != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.xZb);
      }
      paramInt = i;
      if (this.iTJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iTJ);
      }
      i = paramInt;
      if (this.xXC != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.xXC);
      }
      paramInt = f.a.a.b.b.a.bz(11, this.FLn);
      AppMethodBeat.o(91370);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qa localqa = (qa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91370);
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
            localqa.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91370);
          return 0;
        case 2: 
          localqa.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91370);
          return 0;
        case 3: 
          localqa.channel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91370);
          return 0;
        case 4: 
          localqa.xXA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91370);
          return 0;
        case 5: 
          localqa.FLm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 6: 
          localqa.xYY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 7: 
          localqa.xXB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 8: 
          localqa.xZb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 9: 
          localqa.iTJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 10: 
          localqa.xXC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91370);
          return 0;
        }
        localqa.FLn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91370);
        return 0;
      }
      AppMethodBeat.o(91370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qa
 * JD-Core Version:    0.7.0.1
 */