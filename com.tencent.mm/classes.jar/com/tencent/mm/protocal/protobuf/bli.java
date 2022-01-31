package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bli
  extends bvk
{
  public int csV;
  public String csW;
  public int oxO;
  public String ulG;
  public cvq xzP;
  public cvn xzQ;
  public cvj xzR;
  public cvo xzS;
  public boolean xzT;
  public LinkedList<String> xzU;
  public cvl xzV;
  
  public bli()
  {
    AppMethodBeat.i(56893);
    this.xzU = new LinkedList();
    AppMethodBeat.o(56893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56894);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56894);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.csV);
      if (this.csW != null) {
        paramVarArgs.e(3, this.csW);
      }
      if (this.xzP != null)
      {
        paramVarArgs.iQ(4, this.xzP.computeSize());
        this.xzP.writeFields(paramVarArgs);
      }
      if (this.xzQ != null)
      {
        paramVarArgs.iQ(5, this.xzQ.computeSize());
        this.xzQ.writeFields(paramVarArgs);
      }
      if (this.xzR != null)
      {
        paramVarArgs.iQ(6, this.xzR.computeSize());
        this.xzR.writeFields(paramVarArgs);
      }
      if (this.xzS != null)
      {
        paramVarArgs.iQ(7, this.xzS.computeSize());
        this.xzS.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.oxO);
      paramVarArgs.aS(9, this.xzT);
      if (this.ulG != null) {
        paramVarArgs.e(10, this.ulG);
      }
      paramVarArgs.e(11, 1, this.xzU);
      if (this.xzV != null)
      {
        paramVarArgs.iQ(12, this.xzV.computeSize());
        this.xzV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56894);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1450;
      }
    }
    label1450:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.csV);
      paramInt = i;
      if (this.csW != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.csW);
      }
      i = paramInt;
      if (this.xzP != null) {
        i = paramInt + e.a.a.a.iP(4, this.xzP.computeSize());
      }
      paramInt = i;
      if (this.xzQ != null) {
        paramInt = i + e.a.a.a.iP(5, this.xzQ.computeSize());
      }
      i = paramInt;
      if (this.xzR != null) {
        i = paramInt + e.a.a.a.iP(6, this.xzR.computeSize());
      }
      paramInt = i;
      if (this.xzS != null) {
        paramInt = i + e.a.a.a.iP(7, this.xzS.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.oxO) + (e.a.a.b.b.a.eW(9) + 1);
      paramInt = i;
      if (this.ulG != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.ulG);
      }
      i = paramInt + e.a.a.a.c(11, 1, this.xzU);
      paramInt = i;
      if (this.xzV != null) {
        paramInt = i + e.a.a.a.iP(12, this.xzV.computeSize());
      }
      AppMethodBeat.o(56894);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xzU.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56894);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56894);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bli localbli = (bli)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56894);
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
            localbli.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56894);
          return 0;
        case 2: 
          localbli.csV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56894);
          return 0;
        case 3: 
          localbli.csW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56894);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbli.xzP = ((cvq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56894);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbli.xzQ = ((cvn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56894);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbli.xzR = ((cvj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56894);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvo();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbli.xzS = ((cvo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56894);
          return 0;
        case 8: 
          localbli.oxO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56894);
          return 0;
        case 9: 
          localbli.xzT = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56894);
          return 0;
        case 10: 
          localbli.ulG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56894);
          return 0;
        case 11: 
          localbli.xzU.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56894);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvl();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbli.xzV = ((cvl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56894);
        return 0;
      }
      AppMethodBeat.o(56894);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bli
 * JD-Core Version:    0.7.0.1
 */