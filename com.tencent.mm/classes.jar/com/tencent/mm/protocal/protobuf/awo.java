package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awo
  extends cvw
{
  public int GOf;
  public int GOg;
  public String GOh;
  public String GOi;
  public String GOj;
  public int count;
  public String desc;
  public String dwb;
  public int scene;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.GOi == null)
      {
        paramVarArgs = new b("Not all required fields were included: busi_id");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GOf);
      if (this.dwb != null) {
        paramVarArgs.d(3, this.dwb);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      paramVarArgs.aS(5, this.GOg);
      if (this.GOh != null) {
        paramVarArgs.d(6, this.GOh);
      }
      paramVarArgs.aS(7, this.count);
      paramVarArgs.aS(8, this.scene);
      if (this.GOi != null) {
        paramVarArgs.d(9, this.GOi);
      }
      if (this.sign != null) {
        paramVarArgs.d(10, this.sign);
      }
      if (this.GOj != null) {
        paramVarArgs.d(11, this.GOj);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GOf);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dwb);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.desc);
      }
      i += f.a.a.b.b.a.bz(5, this.GOg);
      paramInt = i;
      if (this.GOh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GOh);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.count) + f.a.a.b.b.a.bz(8, this.scene);
      paramInt = i;
      if (this.GOi != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GOi);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.sign);
      }
      paramInt = i;
      if (this.GOj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GOj);
      }
      AppMethodBeat.o(72476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.dwb == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        if (this.GOi == null)
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
        awo localawo = (awo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72476);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72476);
          return 0;
        case 2: 
          localawo.GOf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72476);
          return 0;
        case 3: 
          localawo.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 4: 
          localawo.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 5: 
          localawo.GOg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72476);
          return 0;
        case 6: 
          localawo.GOh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 7: 
          localawo.count = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72476);
          return 0;
        case 8: 
          localawo.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72476);
          return 0;
        case 9: 
          localawo.GOi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 10: 
          localawo.sign = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72476);
          return 0;
        }
        localawo.GOj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72476);
        return 0;
      }
      AppMethodBeat.o(72476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awo
 * JD-Core Version:    0.7.0.1
 */