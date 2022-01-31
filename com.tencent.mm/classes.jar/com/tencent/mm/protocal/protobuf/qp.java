package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qp
  extends bvk
{
  public int cnK;
  public String desc;
  public String kNv;
  public String qjK;
  public int wIA;
  public String wIK;
  public String wIN;
  public String wIQ;
  public String wIS;
  public String wIT;
  public String wIW;
  public LinkedList<Integer> wIy;
  
  public qp()
  {
    AppMethodBeat.i(48802);
    this.wIy = new LinkedList();
    AppMethodBeat.o(48802);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48803);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48803);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      if (this.wIN != null) {
        paramVarArgs.e(4, this.wIN);
      }
      paramVarArgs.e(5, 2, this.wIy);
      if (this.desc != null) {
        paramVarArgs.e(6, this.desc);
      }
      if (this.wIW != null) {
        paramVarArgs.e(7, this.wIW);
      }
      if (this.qjK != null) {
        paramVarArgs.e(8, this.qjK);
      }
      if (this.wIQ != null) {
        paramVarArgs.e(9, this.wIQ);
      }
      if (this.wIS != null) {
        paramVarArgs.e(10, this.wIS);
      }
      if (this.wIT != null) {
        paramVarArgs.e(11, this.wIT);
      }
      paramVarArgs.aO(12, this.wIA);
      if (this.wIK != null) {
        paramVarArgs.e(13, this.wIK);
      }
      AppMethodBeat.o(48803);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1065;
      }
    }
    label1065:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.wIN != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wIN);
      }
      i += e.a.a.a.c(5, 2, this.wIy);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.desc);
      }
      i = paramInt;
      if (this.wIW != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wIW);
      }
      paramInt = i;
      if (this.qjK != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.qjK);
      }
      i = paramInt;
      if (this.wIQ != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wIQ);
      }
      paramInt = i;
      if (this.wIS != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wIS);
      }
      i = paramInt;
      if (this.wIT != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wIT);
      }
      i += e.a.a.b.b.a.bl(12, this.wIA);
      paramInt = i;
      if (this.wIK != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.wIK);
      }
      AppMethodBeat.o(48803);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wIy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(48803);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48803);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qp localqp = (qp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48803);
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
            localqp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48803);
          return 0;
        case 2: 
          localqp.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48803);
          return 0;
        case 3: 
          localqp.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48803);
          return 0;
        case 4: 
          localqp.wIN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48803);
          return 0;
        case 5: 
          localqp.wIy.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(48803);
          return 0;
        case 6: 
          localqp.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48803);
          return 0;
        case 7: 
          localqp.wIW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48803);
          return 0;
        case 8: 
          localqp.qjK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48803);
          return 0;
        case 9: 
          localqp.wIQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48803);
          return 0;
        case 10: 
          localqp.wIS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48803);
          return 0;
        case 11: 
          localqp.wIT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48803);
          return 0;
        case 12: 
          localqp.wIA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48803);
          return 0;
        }
        localqp.wIK = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48803);
        return 0;
      }
      AppMethodBeat.o(48803);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qp
 * JD-Core Version:    0.7.0.1
 */