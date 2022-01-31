package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byi
  extends bvk
{
  public String Title;
  public int jJU;
  public int jJu;
  public int jKs;
  public int lGK;
  public LinkedList<dbe> wrp;
  public int xCa;
  public int xHS;
  public daw xKG;
  public int xKH;
  public boolean xKI;
  public com.tencent.mm.bv.b xKJ;
  public String xKK;
  
  public byi()
  {
    AppMethodBeat.i(151928);
    this.wrp = new LinkedList();
    AppMethodBeat.o(151928);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151929);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(151929);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJU);
      paramVarArgs.aO(3, this.jKs);
      paramVarArgs.aO(4, this.xCa);
      paramVarArgs.aO(5, this.jJu);
      if (this.Title != null) {
        paramVarArgs.e(6, this.Title);
      }
      if (this.xKG != null)
      {
        paramVarArgs.iQ(7, this.xKG.computeSize());
        this.xKG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.wrp);
      paramVarArgs.aO(9, this.xHS);
      paramVarArgs.aO(10, this.xKH);
      paramVarArgs.aS(11, this.xKI);
      if (this.xKJ != null) {
        paramVarArgs.c(12, this.xKJ);
      }
      paramVarArgs.aO(13, this.lGK);
      if (this.xKK != null) {
        paramVarArgs.e(14, this.xKK);
      }
      AppMethodBeat.o(151929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jJU) + e.a.a.b.b.a.bl(3, this.jKs) + e.a.a.b.b.a.bl(4, this.xCa) + e.a.a.b.b.a.bl(5, this.jJu);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.Title);
      }
      i = paramInt;
      if (this.xKG != null) {
        i = paramInt + e.a.a.a.iP(7, this.xKG.computeSize());
      }
      i = i + e.a.a.a.c(8, 8, this.wrp) + e.a.a.b.b.a.bl(9, this.xHS) + e.a.a.b.b.a.bl(10, this.xKH) + (e.a.a.b.b.a.eW(11) + 1);
      paramInt = i;
      if (this.xKJ != null) {
        paramInt = i + e.a.a.b.b.a.b(12, this.xKJ);
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.lGK);
      paramInt = i;
      if (this.xKK != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.xKK);
      }
      AppMethodBeat.o(151929);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wrp.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(151929);
          throw paramVarArgs;
        }
        AppMethodBeat.o(151929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byi localbyi = (byi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151929);
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
            localbyi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151929);
          return 0;
        case 2: 
          localbyi.jJU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151929);
          return 0;
        case 3: 
          localbyi.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151929);
          return 0;
        case 4: 
          localbyi.xCa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151929);
          return 0;
        case 5: 
          localbyi.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151929);
          return 0;
        case 6: 
          localbyi.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151929);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new daw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((daw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyi.xKG = ((daw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151929);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyi.wrp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151929);
          return 0;
        case 9: 
          localbyi.xHS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151929);
          return 0;
        case 10: 
          localbyi.xKH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151929);
          return 0;
        case 11: 
          localbyi.xKI = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(151929);
          return 0;
        case 12: 
          localbyi.xKJ = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(151929);
          return 0;
        case 13: 
          localbyi.lGK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151929);
          return 0;
        }
        localbyi.xKK = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(151929);
        return 0;
      }
      AppMethodBeat.o(151929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byi
 * JD-Core Version:    0.7.0.1
 */