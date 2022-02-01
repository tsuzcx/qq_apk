package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class das
  extends cvc
{
  public btm GbC;
  public int HqK;
  public int Scene;
  public String hDa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152692);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbC == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(152692);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GbC != null)
      {
        paramVarArgs.lC(2, this.GbC.computeSize());
        this.GbC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HqK);
      paramVarArgs.aS(4, this.Scene);
      if (this.hDa != null) {
        paramVarArgs.d(5, this.hDa);
      }
      AppMethodBeat.o(152692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GbC != null) {
        i = paramInt + f.a.a.a.lB(2, this.GbC.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.HqK) + f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hDa);
      }
      AppMethodBeat.o(152692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbC == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(152692);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152692);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        das localdas = (das)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152692);
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
            localdas.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152692);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdas.GbC = ((btm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152692);
          return 0;
        case 3: 
          localdas.HqK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152692);
          return 0;
        case 4: 
          localdas.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152692);
          return 0;
        }
        localdas.hDa = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152692);
        return 0;
      }
      AppMethodBeat.o(152692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.das
 * JD-Core Version:    0.7.0.1
 */