package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ad
  extends bvk
{
  public int wld;
  public String wle;
  public ccq wlf;
  public bta wlg;
  public int wln;
  public uz wlr;
  public boolean wls;
  public int wlt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28296);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28296);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wld);
      if (this.wle != null) {
        paramVarArgs.e(3, this.wle);
      }
      if (this.wlf != null)
      {
        paramVarArgs.iQ(4, this.wlf.computeSize());
        this.wlf.writeFields(paramVarArgs);
      }
      if (this.wlg != null)
      {
        paramVarArgs.iQ(5, this.wlg.computeSize());
        this.wlg.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.wln);
      if (this.wlr != null)
      {
        paramVarArgs.iQ(7, this.wlr.computeSize());
        this.wlr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.wls);
      paramVarArgs.aO(9, this.wlt);
      AppMethodBeat.o(28296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1081;
      }
    }
    label1081:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wld);
      paramInt = i;
      if (this.wle != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wle);
      }
      i = paramInt;
      if (this.wlf != null) {
        i = paramInt + e.a.a.a.iP(4, this.wlf.computeSize());
      }
      paramInt = i;
      if (this.wlg != null) {
        paramInt = i + e.a.a.a.iP(5, this.wlg.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.wln);
      paramInt = i;
      if (this.wlr != null) {
        paramInt = i + e.a.a.a.iP(7, this.wlr.computeSize());
      }
      i = e.a.a.b.b.a.eW(8);
      int j = e.a.a.b.b.a.bl(9, this.wlt);
      AppMethodBeat.o(28296);
      return paramInt + (i + 1) + j;
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
          AppMethodBeat.o(28296);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28296);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28296);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localad.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28296);
          return 0;
        case 2: 
          localad.wld = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28296);
          return 0;
        case 3: 
          localad.wle = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28296);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localad.wlf = ((ccq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28296);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localad.wlg = ((bta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28296);
          return 0;
        case 6: 
          localad.wln = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28296);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localad.wlr = ((uz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28296);
          return 0;
        case 8: 
          localad.wls = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(28296);
          return 0;
        }
        localad.wlt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28296);
        return 0;
      }
      AppMethodBeat.o(28296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ad
 * JD-Core Version:    0.7.0.1
 */