package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cro
  extends cvp
{
  public com.tencent.mm.bx.b GZf;
  public int GZg;
  public int GZh;
  public String GZm;
  public String GZn;
  public String GZo;
  public int GZp;
  public String GZr;
  public String oBP;
  public int vjp;
  public int vjq;
  public String vjr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91662);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GZg);
      if (this.vjr != null) {
        paramVarArgs.d(3, this.vjr);
      }
      if (this.GZn != null) {
        paramVarArgs.d(4, this.GZn);
      }
      if (this.GZo != null) {
        paramVarArgs.d(5, this.GZo);
      }
      if (this.GZf != null) {
        paramVarArgs.c(6, this.GZf);
      }
      paramVarArgs.aS(7, this.GZh);
      paramVarArgs.aS(8, this.vjp);
      paramVarArgs.aS(9, this.GZp);
      paramVarArgs.aS(10, this.vjq);
      if (this.oBP != null) {
        paramVarArgs.d(11, this.oBP);
      }
      if (this.GZr != null) {
        paramVarArgs.d(12, this.GZr);
      }
      if (this.GZm != null) {
        paramVarArgs.d(13, this.GZm);
      }
      AppMethodBeat.o(91662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GZg);
      paramInt = i;
      if (this.vjr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vjr);
      }
      i = paramInt;
      if (this.GZn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GZn);
      }
      paramInt = i;
      if (this.GZo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GZo);
      }
      i = paramInt;
      if (this.GZf != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.GZf);
      }
      i = i + f.a.a.b.b.a.bz(7, this.GZh) + f.a.a.b.b.a.bz(8, this.vjp) + f.a.a.b.b.a.bz(9, this.GZp) + f.a.a.b.b.a.bz(10, this.vjq);
      paramInt = i;
      if (this.oBP != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.oBP);
      }
      i = paramInt;
      if (this.GZr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GZr);
      }
      paramInt = i;
      if (this.GZm != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GZm);
      }
      AppMethodBeat.o(91662);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cro localcro = (cro)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91662);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcro.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91662);
          return 0;
        case 2: 
          localcro.GZg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 3: 
          localcro.vjr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 4: 
          localcro.GZn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 5: 
          localcro.GZo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 6: 
          localcro.GZf = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91662);
          return 0;
        case 7: 
          localcro.GZh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 8: 
          localcro.vjp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 9: 
          localcro.GZp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 10: 
          localcro.vjq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 11: 
          localcro.oBP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 12: 
          localcro.GZr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91662);
          return 0;
        }
        localcro.GZm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91662);
        return 0;
      }
      AppMethodBeat.o(91662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cro
 * JD-Core Version:    0.7.0.1
 */