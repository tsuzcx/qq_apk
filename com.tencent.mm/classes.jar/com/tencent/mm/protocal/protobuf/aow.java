package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aow
  extends ckq
{
  public int DqA;
  public int DqB;
  public String DqC;
  public String DqD;
  public String DqE;
  public int count;
  public String desc;
  public String dlB;
  public int scene;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.DqD == null)
      {
        paramVarArgs = new b("Not all required fields were included: busi_id");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DqA);
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      paramVarArgs.aR(5, this.DqB);
      if (this.DqC != null) {
        paramVarArgs.d(6, this.DqC);
      }
      paramVarArgs.aR(7, this.count);
      paramVarArgs.aR(8, this.scene);
      if (this.DqD != null) {
        paramVarArgs.d(9, this.DqD);
      }
      if (this.sign != null) {
        paramVarArgs.d(10, this.sign);
      }
      if (this.DqE != null) {
        paramVarArgs.d(11, this.DqE);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DqA);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dlB);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.desc);
      }
      i += f.a.a.b.b.a.bA(5, this.DqB);
      paramInt = i;
      if (this.DqC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DqC);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.count) + f.a.a.b.b.a.bA(8, this.scene);
      paramInt = i;
      if (this.DqD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DqD);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.sign);
      }
      paramInt = i;
      if (this.DqE != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DqE);
      }
      AppMethodBeat.o(72476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.dlB == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        if (this.DqD == null)
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
        aow localaow = (aow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72476);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72476);
          return 0;
        case 2: 
          localaow.DqA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72476);
          return 0;
        case 3: 
          localaow.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 4: 
          localaow.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 5: 
          localaow.DqB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72476);
          return 0;
        case 6: 
          localaow.DqC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 7: 
          localaow.count = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72476);
          return 0;
        case 8: 
          localaow.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72476);
          return 0;
        case 9: 
          localaow.DqD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 10: 
          localaow.sign = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72476);
          return 0;
        }
        localaow.DqE = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72476);
        return 0;
      }
      AppMethodBeat.o(72476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aow
 * JD-Core Version:    0.7.0.1
 */