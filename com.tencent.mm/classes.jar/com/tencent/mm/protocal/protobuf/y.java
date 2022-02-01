package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class y
  extends cvp
{
  public String Fqr;
  public int Fqs;
  public int Fqt;
  public String Fqu;
  public String Fqv;
  public LinkedList<k> cTn;
  public int dlw;
  public String paA;
  
  public y()
  {
    AppMethodBeat.i(91337);
    this.dlw = 268513600;
    this.paA = "请求不成功，请稍候再试";
    this.cTn = new LinkedList();
    AppMethodBeat.o(91337);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91338);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91338);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      paramVarArgs.e(4, 8, this.cTn);
      if (this.Fqv != null) {
        paramVarArgs.d(5, this.Fqv);
      }
      if (this.Fqr != null) {
        paramVarArgs.d(6, this.Fqr);
      }
      paramVarArgs.aS(7, this.Fqs);
      paramVarArgs.aS(8, this.Fqt);
      if (this.Fqu != null) {
        paramVarArgs.d(9, this.Fqu);
      }
      AppMethodBeat.o(91338);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.cTn);
      paramInt = i;
      if (this.Fqv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fqv);
      }
      i = paramInt;
      if (this.Fqr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fqr);
      }
      i = i + f.a.a.b.b.a.bz(7, this.Fqs) + f.a.a.b.b.a.bz(8, this.Fqt);
      paramInt = i;
      if (this.Fqu != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fqu);
      }
      AppMethodBeat.o(91338);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.cTn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91338);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91338);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91338);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 2: 
          localy.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91338);
          return 0;
        case 3: 
          localy.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localy.cTn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 5: 
          localy.Fqv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 6: 
          localy.Fqr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 7: 
          localy.Fqs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91338);
          return 0;
        case 8: 
          localy.Fqt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91338);
          return 0;
        }
        localy.Fqu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91338);
        return 0;
      }
      AppMethodBeat.o(91338);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.y
 * JD-Core Version:    0.7.0.1
 */