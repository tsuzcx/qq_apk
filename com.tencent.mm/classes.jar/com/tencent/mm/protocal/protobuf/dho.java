package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dho
  extends cvc
{
  public String GZd;
  public int HvW;
  public int HvX;
  public String HvZ;
  public String dwF;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GZd != null) {
        paramVarArgs.d(2, this.GZd);
      }
      if (this.signature != null) {
        paramVarArgs.d(3, this.signature);
      }
      if (this.HvZ != null) {
        paramVarArgs.d(4, this.HvZ);
      }
      if (this.dwF != null) {
        paramVarArgs.d(5, this.dwF);
      }
      paramVarArgs.aS(6, this.HvW);
      paramVarArgs.aS(7, this.HvX);
      AppMethodBeat.o(91698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GZd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GZd);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.signature);
      }
      paramInt = i;
      if (this.HvZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HvZ);
      }
      i = paramInt;
      if (this.dwF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dwF);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.HvW);
      int j = f.a.a.b.b.a.bz(7, this.HvX);
      AppMethodBeat.o(91698);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dho localdho = (dho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91698);
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
            localdho.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91698);
          return 0;
        case 2: 
          localdho.GZd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 3: 
          localdho.signature = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 4: 
          localdho.HvZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 5: 
          localdho.dwF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 6: 
          localdho.HvW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91698);
          return 0;
        }
        localdho.HvX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91698);
        return 0;
      }
      AppMethodBeat.o(91698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dho
 * JD-Core Version:    0.7.0.1
 */