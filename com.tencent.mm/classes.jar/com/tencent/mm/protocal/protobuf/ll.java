package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ll
  extends cld
{
  public int CGZ;
  public int CHa;
  public long CHb;
  public int CHi;
  public String CHj;
  public String CHk;
  public String CHl;
  public GoodsObject CHm;
  public boolean CHn = false;
  public int CHo;
  public String dlJ;
  
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CHi);
      if (this.CHj != null) {
        paramVarArgs.d(3, this.CHj);
      }
      if (this.CHk != null) {
        paramVarArgs.d(4, this.CHk);
      }
      if (this.dlJ != null) {
        paramVarArgs.d(7, this.dlJ);
      }
      if (this.CHl != null) {
        paramVarArgs.d(8, this.CHl);
      }
      if (this.CHm != null)
      {
        paramVarArgs.kX(9, this.CHm.computeSize());
        this.CHm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.CGZ);
      paramVarArgs.aG(11, this.CHb);
      paramVarArgs.aR(12, this.CHa);
      paramVarArgs.bg(13, this.CHn);
      paramVarArgs.aR(50, this.CHo);
      AppMethodBeat.o(124395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CHi);
      paramInt = i;
      if (this.CHj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CHj);
      }
      i = paramInt;
      if (this.CHk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CHk);
      }
      paramInt = i;
      if (this.dlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dlJ);
      }
      i = paramInt;
      if (this.CHl != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CHl);
      }
      paramInt = i;
      if (this.CHm != null) {
        paramInt = i + f.a.a.a.kW(9, this.CHm.computeSize());
      }
      i = f.a.a.b.b.a.bA(10, this.CGZ);
      int j = f.a.a.b.b.a.q(11, this.CHb);
      int k = f.a.a.b.b.a.bA(12, this.CHa);
      int m = f.a.a.b.b.a.fY(13);
      int n = f.a.a.b.b.a.bA(50, this.CHo);
      AppMethodBeat.o(124395);
      return paramInt + i + j + k + (m + 1) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        ll localll = (ll)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124395);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localll.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 2: 
          localll.CHi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124395);
          return 0;
        case 3: 
          localll.CHj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 4: 
          localll.CHk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 7: 
          localll.dlJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 8: 
          localll.CHl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localll.CHm = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 10: 
          localll.CGZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124395);
          return 0;
        case 11: 
          localll.CHb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124395);
          return 0;
        case 12: 
          localll.CHa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124395);
          return 0;
        case 13: 
          localll.CHn = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(124395);
          return 0;
        }
        localll.CHo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124395);
        return 0;
      }
      AppMethodBeat.o(124395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ll
 * JD-Core Version:    0.7.0.1
 */