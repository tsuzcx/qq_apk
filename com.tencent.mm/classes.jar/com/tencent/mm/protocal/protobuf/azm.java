package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azm
  extends buy
{
  public String fKw;
  public int xfs;
  public czi xoM;
  public dax xoN;
  public dah xoO;
  public dbs xoP;
  public das xoQ;
  public day xoR;
  public int xoS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96273);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      if (this.xoM != null)
      {
        paramVarArgs.iQ(3, this.xoM.computeSize());
        this.xoM.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xfs);
      if (this.xoN != null)
      {
        paramVarArgs.iQ(5, this.xoN.computeSize());
        this.xoN.writeFields(paramVarArgs);
      }
      if (this.xoO != null)
      {
        paramVarArgs.iQ(6, this.xoO.computeSize());
        this.xoO.writeFields(paramVarArgs);
      }
      if (this.xoP != null)
      {
        paramVarArgs.iQ(7, this.xoP.computeSize());
        this.xoP.writeFields(paramVarArgs);
      }
      if (this.xoQ != null)
      {
        paramVarArgs.iQ(8, this.xoQ.computeSize());
        this.xoQ.writeFields(paramVarArgs);
      }
      if (this.xoR != null)
      {
        paramVarArgs.iQ(9, this.xoR.computeSize());
        this.xoR.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.xoS);
      AppMethodBeat.o(96273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1394;
      }
    }
    label1394:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.xoM != null) {
        i = paramInt + e.a.a.a.iP(3, this.xoM.computeSize());
      }
      i += e.a.a.b.b.a.bl(4, this.xfs);
      paramInt = i;
      if (this.xoN != null) {
        paramInt = i + e.a.a.a.iP(5, this.xoN.computeSize());
      }
      i = paramInt;
      if (this.xoO != null) {
        i = paramInt + e.a.a.a.iP(6, this.xoO.computeSize());
      }
      paramInt = i;
      if (this.xoP != null) {
        paramInt = i + e.a.a.a.iP(7, this.xoP.computeSize());
      }
      i = paramInt;
      if (this.xoQ != null) {
        i = paramInt + e.a.a.a.iP(8, this.xoQ.computeSize());
      }
      paramInt = i;
      if (this.xoR != null) {
        paramInt = i + e.a.a.a.iP(9, this.xoR.computeSize());
      }
      i = e.a.a.b.b.a.bl(10, this.xoS);
      AppMethodBeat.o(96273);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96273);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        azm localazm = (azm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96273);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96273);
          return 0;
        case 2: 
          localazm.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96273);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazm.xoM = ((czi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96273);
          return 0;
        case 4: 
          localazm.xfs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96273);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dax();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dax)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazm.xoN = ((dax)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96273);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dah();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dah)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazm.xoO = ((dah)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96273);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazm.xoP = ((dbs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96273);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new das();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((das)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazm.xoQ = ((das)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96273);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new day();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((day)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazm.xoR = ((day)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96273);
          return 0;
        }
        localazm.xoS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96273);
        return 0;
      }
      AppMethodBeat.o(96273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azm
 * JD-Core Version:    0.7.0.1
 */