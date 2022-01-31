package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnb
  extends bvk
{
  public String content;
  public String knU;
  public boolean koF;
  public int status;
  public String wlQ;
  public String wlR;
  public String xBj;
  public String xBk;
  public String xBl;
  public String xBm;
  public String xBn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89122);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wlQ != null) {
        paramVarArgs.e(2, this.wlQ);
      }
      if (this.wlR != null) {
        paramVarArgs.e(3, this.wlR);
      }
      paramVarArgs.aO(4, this.status);
      if (this.content != null) {
        paramVarArgs.e(5, this.content);
      }
      if (this.knU != null) {
        paramVarArgs.e(6, this.knU);
      }
      if (this.xBj != null) {
        paramVarArgs.e(7, this.xBj);
      }
      paramVarArgs.aS(8, this.koF);
      if (this.xBk != null) {
        paramVarArgs.e(9, this.xBk);
      }
      if (this.xBl != null) {
        paramVarArgs.e(10, this.xBl);
      }
      if (this.xBm != null) {
        paramVarArgs.e(11, this.xBm);
      }
      if (this.xBn != null) {
        paramVarArgs.e(12, this.xBn);
      }
      AppMethodBeat.o(89122);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label950;
      }
    }
    label950:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wlQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wlQ);
      }
      i = paramInt;
      if (this.wlR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wlR);
      }
      i += e.a.a.b.b.a.bl(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.content);
      }
      i = paramInt;
      if (this.knU != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.knU);
      }
      paramInt = i;
      if (this.xBj != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xBj);
      }
      i = paramInt + (e.a.a.b.b.a.eW(8) + 1);
      paramInt = i;
      if (this.xBk != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xBk);
      }
      i = paramInt;
      if (this.xBl != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xBl);
      }
      paramInt = i;
      if (this.xBm != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xBm);
      }
      i = paramInt;
      if (this.xBn != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xBn);
      }
      AppMethodBeat.o(89122);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89122);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bnb localbnb = (bnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89122);
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
            localbnb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89122);
          return 0;
        case 2: 
          localbnb.wlQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89122);
          return 0;
        case 3: 
          localbnb.wlR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89122);
          return 0;
        case 4: 
          localbnb.status = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89122);
          return 0;
        case 5: 
          localbnb.content = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89122);
          return 0;
        case 6: 
          localbnb.knU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89122);
          return 0;
        case 7: 
          localbnb.xBj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89122);
          return 0;
        case 8: 
          localbnb.koF = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(89122);
          return 0;
        case 9: 
          localbnb.xBk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89122);
          return 0;
        case 10: 
          localbnb.xBl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89122);
          return 0;
        case 11: 
          localbnb.xBm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89122);
          return 0;
        }
        localbnb.xBn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89122);
        return 0;
      }
      AppMethodBeat.o(89122);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnb
 * JD-Core Version:    0.7.0.1
 */