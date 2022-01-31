package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bsv
  extends bvk
{
  public int koj;
  public String kok;
  public String nLq;
  public String ppo;
  public int status;
  public String tNy;
  public int xBA;
  public boolean xGr;
  public boolean xGs;
  public String xGt;
  public String xGu;
  public String xGv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56955);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56955);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.aS(4, this.xGr);
      paramVarArgs.aS(5, this.xGs);
      paramVarArgs.aO(6, this.status);
      if (this.xGt != null) {
        paramVarArgs.e(7, this.xGt);
      }
      if (this.xGu != null) {
        paramVarArgs.e(8, this.xGu);
      }
      paramVarArgs.aO(9, this.xBA);
      if (this.nLq != null) {
        paramVarArgs.e(10, this.nLq);
      }
      if (this.ppo != null) {
        paramVarArgs.e(11, this.ppo);
      }
      if (this.xGv != null) {
        paramVarArgs.e(12, this.xGv);
      }
      if (this.tNy != null) {
        paramVarArgs.e(100, this.tNy);
      }
      AppMethodBeat.o(56955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + (e.a.a.b.b.a.eW(4) + 1) + (e.a.a.b.b.a.eW(5) + 1) + e.a.a.b.b.a.bl(6, this.status);
      paramInt = i;
      if (this.xGt != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xGt);
      }
      i = paramInt;
      if (this.xGu != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xGu);
      }
      i += e.a.a.b.b.a.bl(9, this.xBA);
      paramInt = i;
      if (this.nLq != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.nLq);
      }
      i = paramInt;
      if (this.ppo != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.ppo);
      }
      paramInt = i;
      if (this.xGv != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xGv);
      }
      i = paramInt;
      if (this.tNy != null) {
        i = paramInt + e.a.a.b.b.a.f(100, this.tNy);
      }
      AppMethodBeat.o(56955);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56955);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bsv localbsv = (bsv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56955);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbsv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56955);
          return 0;
        case 2: 
          localbsv.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56955);
          return 0;
        case 3: 
          localbsv.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56955);
          return 0;
        case 4: 
          localbsv.xGr = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56955);
          return 0;
        case 5: 
          localbsv.xGs = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56955);
          return 0;
        case 6: 
          localbsv.status = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56955);
          return 0;
        case 7: 
          localbsv.xGt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56955);
          return 0;
        case 8: 
          localbsv.xGu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56955);
          return 0;
        case 9: 
          localbsv.xBA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56955);
          return 0;
        case 10: 
          localbsv.nLq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56955);
          return 0;
        case 11: 
          localbsv.ppo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56955);
          return 0;
        case 12: 
          localbsv.xGv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56955);
          return 0;
        }
        localbsv.tNy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56955);
        return 0;
      }
      AppMethodBeat.o(56955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsv
 * JD-Core Version:    0.7.0.1
 */