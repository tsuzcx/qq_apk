package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qm
  extends buy
{
  public int cCy;
  public int okH;
  public String qkh;
  public String wIK;
  public String wIN;
  public String wIO;
  public int wIP;
  public String wIQ;
  public String wIR;
  public String wIS;
  public String wIT;
  public int wIU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48799);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wIN == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_name");
        AppMethodBeat.o(48799);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wIN != null) {
        paramVarArgs.e(2, this.wIN);
      }
      paramVarArgs.aO(3, this.okH);
      if (this.wIO != null) {
        paramVarArgs.e(4, this.wIO);
      }
      if (this.qkh != null) {
        paramVarArgs.e(5, this.qkh);
      }
      paramVarArgs.aO(6, this.wIP);
      paramVarArgs.aO(7, this.cCy);
      if (this.wIQ != null) {
        paramVarArgs.e(8, this.wIQ);
      }
      if (this.wIK != null) {
        paramVarArgs.e(9, this.wIK);
      }
      if (this.wIR != null) {
        paramVarArgs.e(10, this.wIR);
      }
      if (this.wIS != null) {
        paramVarArgs.e(11, this.wIS);
      }
      if (this.wIT != null) {
        paramVarArgs.e(12, this.wIT);
      }
      paramVarArgs.aO(13, this.wIU);
      AppMethodBeat.o(48799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wIN != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wIN);
      }
      i += e.a.a.b.b.a.bl(3, this.okH);
      paramInt = i;
      if (this.wIO != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wIO);
      }
      i = paramInt;
      if (this.qkh != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.qkh);
      }
      i = i + e.a.a.b.b.a.bl(6, this.wIP) + e.a.a.b.b.a.bl(7, this.cCy);
      paramInt = i;
      if (this.wIQ != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wIQ);
      }
      i = paramInt;
      if (this.wIK != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wIK);
      }
      paramInt = i;
      if (this.wIR != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wIR);
      }
      i = paramInt;
      if (this.wIS != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wIS);
      }
      paramInt = i;
      if (this.wIT != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wIT);
      }
      i = e.a.a.b.b.a.bl(13, this.wIU);
      AppMethodBeat.o(48799);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wIN == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_name");
          AppMethodBeat.o(48799);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qm localqm = (qm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48799);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localqm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48799);
          return 0;
        case 2: 
          localqm.wIN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48799);
          return 0;
        case 3: 
          localqm.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48799);
          return 0;
        case 4: 
          localqm.wIO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48799);
          return 0;
        case 5: 
          localqm.qkh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48799);
          return 0;
        case 6: 
          localqm.wIP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48799);
          return 0;
        case 7: 
          localqm.cCy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48799);
          return 0;
        case 8: 
          localqm.wIQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48799);
          return 0;
        case 9: 
          localqm.wIK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48799);
          return 0;
        case 10: 
          localqm.wIR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48799);
          return 0;
        case 11: 
          localqm.wIS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48799);
          return 0;
        case 12: 
          localqm.wIT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48799);
          return 0;
        }
        localqm.wIU = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48799);
        return 0;
      }
      AppMethodBeat.o(48799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qm
 * JD-Core Version:    0.7.0.1
 */