package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsd
  extends cvc
{
  public int Fws;
  public String HEY;
  public String MD5;
  public String iht;
  public String nDo;
  public int nEf;
  public int xcK;
  public int xcL;
  public int xcM;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32484);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32484);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      paramVarArgs.aS(3, this.Fws);
      if (this.HEY != null) {
        paramVarArgs.d(4, this.HEY);
      }
      if (this.nDo != null) {
        paramVarArgs.d(5, this.nDo);
      }
      paramVarArgs.aS(6, this.xcK);
      paramVarArgs.aS(7, this.xcL);
      paramVarArgs.aS(8, this.xcM);
      if (this.xcN != null)
      {
        paramVarArgs.lC(9, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.nEf);
      if (this.MD5 != null) {
        paramVarArgs.d(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label999;
      }
    }
    label999:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.iht);
      }
      i += f.a.a.b.b.a.bz(3, this.Fws);
      paramInt = i;
      if (this.HEY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HEY);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDo);
      }
      i = i + f.a.a.b.b.a.bz(6, this.xcK) + f.a.a.b.b.a.bz(7, this.xcL) + f.a.a.b.b.a.bz(8, this.xcM);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + f.a.a.a.lB(9, this.xcN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.nEf);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32484);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsd localdsd = (dsd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32484);
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
            localdsd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 2: 
          localdsd.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 3: 
          localdsd.Fws = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32484);
          return 0;
        case 4: 
          localdsd.HEY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 5: 
          localdsd.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 6: 
          localdsd.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32484);
          return 0;
        case 7: 
          localdsd.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32484);
          return 0;
        case 8: 
          localdsd.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32484);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsd.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 10: 
          localdsd.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32484);
          return 0;
        }
        localdsd.MD5 = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32484);
        return 0;
      }
      AppMethodBeat.o(32484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsd
 * JD-Core Version:    0.7.0.1
 */