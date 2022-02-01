package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aok
  extends cvp
{
  public String Gnd;
  public int continueFlag;
  public b lastBuffer;
  public LinkedList<FinderObject> object;
  public b rKC;
  public aqn saW;
  
  public aok()
  {
    AppMethodBeat.i(209320);
    this.object = new LinkedList();
    AppMethodBeat.o(209320);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209321);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aS(4, this.continueFlag);
      if (this.rKC != null) {
        paramVarArgs.c(5, this.rKC);
      }
      if (this.saW != null)
      {
        paramVarArgs.lC(6, this.saW.computeSize());
        this.saW.writeFields(paramVarArgs);
      }
      if (this.Gnd != null) {
        paramVarArgs.d(7, this.Gnd);
      }
      AppMethodBeat.o(209321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.continueFlag);
      paramInt = i;
      if (this.rKC != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.rKC);
      }
      i = paramInt;
      if (this.saW != null) {
        i = paramInt + f.a.a.a.lB(6, this.saW.computeSize());
      }
      paramInt = i;
      if (this.Gnd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gnd);
      }
      AppMethodBeat.o(209321);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209321);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aok localaok = (aok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209321);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaok.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209321);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaok.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209321);
          return 0;
        case 3: 
          localaok.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(209321);
          return 0;
        case 4: 
          localaok.continueFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209321);
          return 0;
        case 5: 
          localaok.rKC = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(209321);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaok.saW = ((aqn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209321);
          return 0;
        }
        localaok.Gnd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(209321);
        return 0;
      }
      AppMethodBeat.o(209321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aok
 * JD-Core Version:    0.7.0.1
 */