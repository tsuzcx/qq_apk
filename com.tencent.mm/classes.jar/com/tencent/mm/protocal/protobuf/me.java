package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class me
  extends cvp
{
  public int FEY;
  public int FEZ;
  public long FFa;
  public int FFk;
  public String FFl;
  public String FFm;
  public String FFn;
  public GoodsObject FFo;
  public boolean FFp = false;
  public int FFq;
  public boolean FFr;
  public int FFs;
  public String dve;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124395);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FFk);
      if (this.FFl != null) {
        paramVarArgs.d(3, this.FFl);
      }
      if (this.FFm != null) {
        paramVarArgs.d(4, this.FFm);
      }
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
      paramVarArgs.aS(10, this.FEY);
      paramVarArgs.aY(11, this.FFa);
      paramVarArgs.aS(12, this.FEZ);
      paramVarArgs.bt(13, this.FFp);
      paramVarArgs.aS(16, this.FFq);
      paramVarArgs.bt(17, this.FFr);
      paramVarArgs.aS(50, this.FFs);
      AppMethodBeat.o(124395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FFk);
      paramInt = i;
      if (this.FFl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FFl);
      }
      i = paramInt;
      if (this.FFm != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FFm);
      }
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
      i = f.a.a.b.b.a.bz(10, this.FEY);
      int j = f.a.a.b.b.a.p(11, this.FFa);
      int k = f.a.a.b.b.a.bz(12, this.FEZ);
      int m = f.a.a.b.b.a.alV(13);
      int n = f.a.a.b.b.a.bz(16, this.FFq);
      int i1 = f.a.a.b.b.a.alV(17);
      int i2 = f.a.a.b.b.a.bz(50, this.FFs);
      AppMethodBeat.o(124395);
      return paramInt + i + j + k + m + n + i1 + i2;
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
          AppMethodBeat.o(124395);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        me localme = (me)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124395);
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
            localme.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 2: 
          localme.FFk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124395);
          return 0;
        case 3: 
          localme.FFl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 4: 
          localme.FFm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 7: 
          localme.dve = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 8: 
          localme.FFn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124395);
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
            localme.FFo = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 10: 
          localme.FEY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124395);
          return 0;
        case 11: 
          localme.FFa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124395);
          return 0;
        case 12: 
          localme.FEZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124395);
          return 0;
        case 13: 
          localme.FFp = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(124395);
          return 0;
        case 16: 
          localme.FFq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124395);
          return 0;
        case 17: 
          localme.FFr = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(124395);
          return 0;
        }
        localme.FFs = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124395);
        return 0;
      }
      AppMethodBeat.o(124395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.me
 * JD-Core Version:    0.7.0.1
 */