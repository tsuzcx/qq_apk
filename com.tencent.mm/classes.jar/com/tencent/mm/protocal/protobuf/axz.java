package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axz
  extends bvk
{
  public com.tencent.mm.bv.b jJh;
  public String ntp;
  public String wnz;
  public axe xmS;
  public String xmU;
  public String xmV;
  public String xmW;
  public bwv xnd;
  public we xne;
  public boolean xnf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96267);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96267);
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
      if (this.jJh != null) {
        paramVarArgs.c(3, this.jJh);
      }
      if (this.xnd != null)
      {
        paramVarArgs.iQ(4, this.xnd.computeSize());
        this.xnd.writeFields(paramVarArgs);
      }
      if (this.ntp != null) {
        paramVarArgs.e(5, this.ntp);
      }
      if (this.wnz != null) {
        paramVarArgs.e(6, this.wnz);
      }
      if (this.xne != null)
      {
        paramVarArgs.iQ(7, this.xne.computeSize());
        this.xne.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.xnf);
      if (this.xmU != null) {
        paramVarArgs.e(9, this.xmU);
      }
      if (this.xmV != null) {
        paramVarArgs.e(10, this.xmV);
      }
      if (this.xmW != null) {
        paramVarArgs.e(11, this.xmW);
      }
      AppMethodBeat.o(96267);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xmS != null) {
        paramInt = i + e.a.a.a.iP(2, this.xmS.computeSize());
      }
      i = paramInt;
      if (this.jJh != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.jJh);
      }
      paramInt = i;
      if (this.xnd != null) {
        paramInt = i + e.a.a.a.iP(4, this.xnd.computeSize());
      }
      i = paramInt;
      if (this.ntp != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ntp);
      }
      paramInt = i;
      if (this.wnz != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wnz);
      }
      i = paramInt;
      if (this.xne != null) {
        i = paramInt + e.a.a.a.iP(7, this.xne.computeSize());
      }
      i += e.a.a.b.b.a.eW(8) + 1;
      paramInt = i;
      if (this.xmU != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xmU);
      }
      i = paramInt;
      if (this.xmV != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xmV);
      }
      paramInt = i;
      if (this.xmW != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xmW);
      }
      AppMethodBeat.o(96267);
      return paramInt;
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
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(96267);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96267);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axz localaxz = (axz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96267);
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
            localaxz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96267);
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
            localaxz.xmS = ((axe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96267);
          return 0;
        case 3: 
          localaxz.jJh = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(96267);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxz.xnd = ((bwv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96267);
          return 0;
        case 5: 
          localaxz.ntp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96267);
          return 0;
        case 6: 
          localaxz.wnz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96267);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new we();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((we)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxz.xne = ((we)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96267);
          return 0;
        case 8: 
          localaxz.xnf = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(96267);
          return 0;
        case 9: 
          localaxz.xmU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96267);
          return 0;
        case 10: 
          localaxz.xmV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96267);
          return 0;
        }
        localaxz.xmW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96267);
        return 0;
      }
      AppMethodBeat.o(96267);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axz
 * JD-Core Version:    0.7.0.1
 */