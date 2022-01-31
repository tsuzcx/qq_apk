package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qt
  extends bvk
{
  public int cnK;
  public String desc;
  public String kNv;
  public String qiN;
  public int wIB;
  public String wIw;
  public int wIx;
  public LinkedList<Integer> wIy;
  
  public qt()
  {
    AppMethodBeat.i(48808);
    this.wIy = new LinkedList();
    AppMethodBeat.o(48808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48809);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48809);
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
      if (this.qiN != null) {
        paramVarArgs.e(4, this.qiN);
      }
      if (this.wIw != null) {
        paramVarArgs.e(5, this.wIw);
      }
      paramVarArgs.aO(6, this.wIx);
      paramVarArgs.e(7, 2, this.wIy);
      if (this.desc != null) {
        paramVarArgs.e(8, this.desc);
      }
      paramVarArgs.aO(9, this.wIB);
      AppMethodBeat.o(48809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label797;
      }
    }
    label797:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.qiN != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.qiN);
      }
      paramInt = i;
      if (this.wIw != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wIw);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.wIx) + e.a.a.a.c(7, 2, this.wIy);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.desc);
      }
      i = e.a.a.b.b.a.bl(9, this.wIB);
      AppMethodBeat.o(48809);
      return paramInt + i;
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
          AppMethodBeat.o(48809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qt localqt = (qt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48809);
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
            localqt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48809);
          return 0;
        case 2: 
          localqt.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48809);
          return 0;
        case 3: 
          localqt.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48809);
          return 0;
        case 4: 
          localqt.qiN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48809);
          return 0;
        case 5: 
          localqt.wIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48809);
          return 0;
        case 6: 
          localqt.wIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48809);
          return 0;
        case 7: 
          localqt.wIy.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(48809);
          return 0;
        case 8: 
          localqt.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48809);
          return 0;
        }
        localqt.wIB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48809);
        return 0;
      }
      AppMethodBeat.o(48809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qt
 * JD-Core Version:    0.7.0.1
 */