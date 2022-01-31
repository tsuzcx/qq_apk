package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class gd
  extends buy
{
  public String gwS;
  public String jJE;
  public String lGG;
  public String lGH;
  public String nGG;
  public int wkX;
  public SKBuiltinBuffer_t wrL;
  public hm wsm;
  public String wsn;
  public int wso;
  public String wsp;
  public String wsq;
  public SKBuiltinBuffer_t wsr;
  public SKBuiltinBuffer_t wss;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58887);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wrL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(58887);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wsm != null)
      {
        paramVarArgs.iQ(2, this.wsm.computeSize());
        this.wsm.writeFields(paramVarArgs);
      }
      if (this.wrL != null)
      {
        paramVarArgs.iQ(3, this.wrL.computeSize());
        this.wrL.writeFields(paramVarArgs);
      }
      if (this.nGG != null) {
        paramVarArgs.e(4, this.nGG);
      }
      if (this.wsn != null) {
        paramVarArgs.e(5, this.wsn);
      }
      paramVarArgs.aO(6, this.wso);
      if (this.wsp != null) {
        paramVarArgs.e(7, this.wsp);
      }
      if (this.gwS != null) {
        paramVarArgs.e(8, this.gwS);
      }
      if (this.jJE != null) {
        paramVarArgs.e(9, this.jJE);
      }
      if (this.wsq != null) {
        paramVarArgs.e(10, this.wsq);
      }
      if (this.lGH != null) {
        paramVarArgs.e(11, this.lGH);
      }
      if (this.lGG != null) {
        paramVarArgs.e(12, this.lGG);
      }
      paramVarArgs.aO(13, this.wkX);
      if (this.wsr != null)
      {
        paramVarArgs.iQ(14, this.wsr.computeSize());
        this.wsr.writeFields(paramVarArgs);
      }
      if (this.wss != null)
      {
        paramVarArgs.iQ(15, this.wss.computeSize());
        this.wss.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58887);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1562;
      }
    }
    label1562:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsm != null) {
        paramInt = i + e.a.a.a.iP(2, this.wsm.computeSize());
      }
      i = paramInt;
      if (this.wrL != null) {
        i = paramInt + e.a.a.a.iP(3, this.wrL.computeSize());
      }
      paramInt = i;
      if (this.nGG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nGG);
      }
      i = paramInt;
      if (this.wsn != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wsn);
      }
      i += e.a.a.b.b.a.bl(6, this.wso);
      paramInt = i;
      if (this.wsp != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wsp);
      }
      i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.gwS);
      }
      paramInt = i;
      if (this.jJE != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.jJE);
      }
      i = paramInt;
      if (this.wsq != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wsq);
      }
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.lGH);
      }
      i = paramInt;
      if (this.lGG != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.lGG);
      }
      i += e.a.a.b.b.a.bl(13, this.wkX);
      paramInt = i;
      if (this.wsr != null) {
        paramInt = i + e.a.a.a.iP(14, this.wsr.computeSize());
      }
      i = paramInt;
      if (this.wss != null) {
        i = paramInt + e.a.a.a.iP(15, this.wss.computeSize());
      }
      AppMethodBeat.o(58887);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wrL == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(58887);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58887);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        gd localgd = (gd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58887);
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
            localgd.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58887);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localgd.wsm = ((hm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58887);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localgd.wrL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58887);
          return 0;
        case 4: 
          localgd.nGG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58887);
          return 0;
        case 5: 
          localgd.wsn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58887);
          return 0;
        case 6: 
          localgd.wso = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58887);
          return 0;
        case 7: 
          localgd.wsp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58887);
          return 0;
        case 8: 
          localgd.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58887);
          return 0;
        case 9: 
          localgd.jJE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58887);
          return 0;
        case 10: 
          localgd.wsq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58887);
          return 0;
        case 11: 
          localgd.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58887);
          return 0;
        case 12: 
          localgd.lGG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58887);
          return 0;
        case 13: 
          localgd.wkX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58887);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localgd.wsr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58887);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgd.wss = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58887);
        return 0;
      }
      AppMethodBeat.o(58887);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gd
 * JD-Core Version:    0.7.0.1
 */