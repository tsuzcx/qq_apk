package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class mi
  extends cvp
{
  public int FBz;
  public long FFa;
  public int FFk;
  public String FFn;
  public GoodsObject FFo;
  public int FFy;
  public String FFz;
  public String dve;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207220);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(207220);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FFk);
      if (this.dve != null) {
        paramVarArgs.d(7, this.dve);
      }
      if (this.FFn != null) {
        paramVarArgs.d(8, this.FFn);
      }
      if (this.FFo != null)
      {
        paramVarArgs.lC(9, this.FFo.computeSize());
        this.FFo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.FFa);
      paramVarArgs.aS(14, this.FFy);
      paramVarArgs.aS(15, this.FBz);
      if (this.FFz != null) {
        paramVarArgs.d(21, this.FFz);
      }
      AppMethodBeat.o(207220);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FFk);
      paramInt = i;
      if (this.dve != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dve);
      }
      i = paramInt;
      if (this.FFn != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FFn);
      }
      paramInt = i;
      if (this.FFo != null) {
        paramInt = i + f.a.a.a.lB(9, this.FFo.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(11, this.FFa) + f.a.a.b.b.a.bz(14, this.FFy) + f.a.a.b.b.a.bz(15, this.FBz);
      paramInt = i;
      if (this.FFz != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FFz);
      }
      AppMethodBeat.o(207220);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(207220);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207220);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mi localmi = (mi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 10: 
        case 12: 
        case 13: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(207220);
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
            localmi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207220);
          return 0;
        case 2: 
          localmi.FFk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207220);
          return 0;
        case 7: 
          localmi.dve = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207220);
          return 0;
        case 8: 
          localmi.FFn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207220);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmi.FFo = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207220);
          return 0;
        case 11: 
          localmi.FFa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(207220);
          return 0;
        case 14: 
          localmi.FFy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207220);
          return 0;
        case 15: 
          localmi.FBz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207220);
          return 0;
        }
        localmi.FFz = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207220);
        return 0;
      }
      AppMethodBeat.o(207220);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mi
 * JD-Core Version:    0.7.0.1
 */