package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class axv
  extends bvk
{
  public String gwS;
  public String wkY;
  public String wll;
  public axe xmS;
  public String xmY;
  public String xmZ;
  public String xna;
  public int xnb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96261);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96261);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xmS != null)
      {
        paramVarArgs.iQ(2, this.xmS.computeSize());
        this.xmS.writeFields(paramVarArgs);
      }
      if (this.xmZ != null) {
        paramVarArgs.e(3, this.xmZ);
      }
      if (this.wll != null) {
        paramVarArgs.e(4, this.wll);
      }
      if (this.wkY != null) {
        paramVarArgs.e(5, this.wkY);
      }
      if (this.xna != null) {
        paramVarArgs.e(6, this.xna);
      }
      paramVarArgs.aO(7, this.xnb);
      if (this.xmY != null) {
        paramVarArgs.e(8, this.xmY);
      }
      if (this.gwS != null) {
        paramVarArgs.e(9, this.gwS);
      }
      AppMethodBeat.o(96261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xmS != null) {
        paramInt = i + e.a.a.a.iP(2, this.xmS.computeSize());
      }
      i = paramInt;
      if (this.xmZ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xmZ);
      }
      paramInt = i;
      if (this.wll != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wll);
      }
      i = paramInt;
      if (this.wkY != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wkY);
      }
      paramInt = i;
      if (this.xna != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xna);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.xnb);
      paramInt = i;
      if (this.xmY != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xmY);
      }
      i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.gwS);
      }
      AppMethodBeat.o(96261);
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
          AppMethodBeat.o(96261);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96261);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axv localaxv = (axv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96261);
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
            localaxv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96261);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxv.xmS = ((axe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96261);
          return 0;
        case 3: 
          localaxv.xmZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96261);
          return 0;
        case 4: 
          localaxv.wll = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96261);
          return 0;
        case 5: 
          localaxv.wkY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96261);
          return 0;
        case 6: 
          localaxv.xna = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96261);
          return 0;
        case 7: 
          localaxv.xnb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96261);
          return 0;
        case 8: 
          localaxv.xmY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96261);
          return 0;
        }
        localaxv.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96261);
        return 0;
      }
      AppMethodBeat.o(96261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axv
 * JD-Core Version:    0.7.0.1
 */