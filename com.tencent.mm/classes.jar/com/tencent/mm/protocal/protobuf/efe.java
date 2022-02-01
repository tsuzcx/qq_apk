package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class efe
  extends com.tencent.mm.bx.a
{
  public String HOx;
  public efd HQA;
  public int HQs;
  public int HQt;
  public String HQy;
  public eew HQz;
  public String Md5;
  public String tRU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110863);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQy == null)
      {
        paramVarArgs = new b("Not all required fields were included: EntranceDomain");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.HOx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.HQy != null) {
        paramVarArgs.d(4, this.HQy);
      }
      if (this.HOx != null) {
        paramVarArgs.d(12, this.HOx);
      }
      if (this.HQz != null)
      {
        paramVarArgs.lC(9, this.HQz.computeSize());
        this.HQz.writeFields(paramVarArgs);
      }
      if (this.HQA != null)
      {
        paramVarArgs.lC(10, this.HQA.computeSize());
        this.HQA.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(5, this.Md5);
      }
      if (this.tRU != null) {
        paramVarArgs.d(6, this.tRU);
      }
      paramVarArgs.aS(7, this.HQs);
      paramVarArgs.aS(8, this.HQt);
      AppMethodBeat.o(110863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HQy == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.b.b.a.e(4, this.HQy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HOx != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HOx);
      }
      i = paramInt;
      if (this.HQz != null) {
        i = paramInt + f.a.a.a.lB(9, this.HQz.computeSize());
      }
      paramInt = i;
      if (this.HQA != null) {
        paramInt = i + f.a.a.a.lB(10, this.HQA.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Md5);
      }
      paramInt = i;
      if (this.tRU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tRU);
      }
      i = f.a.a.b.b.a.bz(7, this.HQs);
      int j = f.a.a.b.b.a.bz(8, this.HQt);
      AppMethodBeat.o(110863);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HQy == null)
        {
          paramVarArgs = new b("Not all required fields were included: EntranceDomain");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        if (this.HOx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Charset");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110863);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        efe localefe = (efe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(110863);
          return -1;
        case 4: 
          localefe.HQy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 12: 
          localefe.HOx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eew();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localefe.HQz = ((eew)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localefe.HQA = ((efd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 5: 
          localefe.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 6: 
          localefe.tRU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 7: 
          localefe.HQs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(110863);
          return 0;
        }
        localefe.HQt = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(110863);
        return 0;
      }
      AppMethodBeat.o(110863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efe
 * JD-Core Version:    0.7.0.1
 */