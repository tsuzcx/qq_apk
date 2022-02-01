package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avy
  extends cvc
{
  public int GuG;
  public int GuH;
  public String GuI;
  public String GuJ;
  public String GuK;
  public int count;
  public String desc;
  public String duW;
  public int scene;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.GuJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: busi_id");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GuG);
      if (this.duW != null) {
        paramVarArgs.d(3, this.duW);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      paramVarArgs.aS(5, this.GuH);
      if (this.GuI != null) {
        paramVarArgs.d(6, this.GuI);
      }
      paramVarArgs.aS(7, this.count);
      paramVarArgs.aS(8, this.scene);
      if (this.GuJ != null) {
        paramVarArgs.d(9, this.GuJ);
      }
      if (this.sign != null) {
        paramVarArgs.d(10, this.sign);
      }
      if (this.GuK != null) {
        paramVarArgs.d(11, this.GuK);
      }
      AppMethodBeat.o(72476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GuG);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.duW);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.desc);
      }
      i += f.a.a.b.b.a.bz(5, this.GuH);
      paramInt = i;
      if (this.GuI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GuI);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.count) + f.a.a.b.b.a.bz(8, this.scene);
      paramInt = i;
      if (this.GuJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GuJ);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.sign);
      }
      paramInt = i;
      if (this.GuK != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GuK);
      }
      AppMethodBeat.o(72476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.duW == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        if (this.GuJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: busi_id");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avy localavy = (avy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72476);
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
            localavy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72476);
          return 0;
        case 2: 
          localavy.GuG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72476);
          return 0;
        case 3: 
          localavy.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 4: 
          localavy.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 5: 
          localavy.GuH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72476);
          return 0;
        case 6: 
          localavy.GuI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 7: 
          localavy.count = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72476);
          return 0;
        case 8: 
          localavy.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72476);
          return 0;
        case 9: 
          localavy.GuJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 10: 
          localavy.sign = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72476);
          return 0;
        }
        localavy.GuK = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72476);
        return 0;
      }
      AppMethodBeat.o(72476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avy
 * JD-Core Version:    0.7.0.1
 */