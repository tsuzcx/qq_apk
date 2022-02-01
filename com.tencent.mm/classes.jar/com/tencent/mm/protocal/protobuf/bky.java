package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bky
  extends cvp
{
  public int CellCount;
  public LinkedList<eai> CellList;
  public String GFc;
  public String GFe;
  public int GFf;
  public String GFg;
  public String GFh;
  public String GFi;
  
  public bky()
  {
    AppMethodBeat.i(32305);
    this.CellList = new LinkedList();
    AppMethodBeat.o(32305);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32306);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32306);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.CellCount);
      paramVarArgs.e(3, 8, this.CellList);
      if (this.GFe != null) {
        paramVarArgs.d(4, this.GFe);
      }
      if (this.GFc != null) {
        paramVarArgs.d(5, this.GFc);
      }
      paramVarArgs.aS(6, this.GFf);
      if (this.GFg != null) {
        paramVarArgs.d(7, this.GFg);
      }
      if (this.GFh != null) {
        paramVarArgs.d(8, this.GFh);
      }
      if (this.GFi != null) {
        paramVarArgs.d(9, this.GFi);
      }
      AppMethodBeat.o(32306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label909;
      }
    }
    label909:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.CellCount) + f.a.a.a.c(3, 8, this.CellList);
      paramInt = i;
      if (this.GFe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GFe);
      }
      i = paramInt;
      if (this.GFc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GFc);
      }
      i += f.a.a.b.b.a.bz(6, this.GFf);
      paramInt = i;
      if (this.GFg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GFg);
      }
      i = paramInt;
      if (this.GFh != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GFh);
      }
      paramInt = i;
      if (this.GFi != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GFi);
      }
      AppMethodBeat.o(32306);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CellList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32306);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32306);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bky localbky = (bky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32306);
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
            localbky.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 2: 
          localbky.CellCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32306);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eai();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbky.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 4: 
          localbky.GFe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 5: 
          localbky.GFc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 6: 
          localbky.GFf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32306);
          return 0;
        case 7: 
          localbky.GFg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 8: 
          localbky.GFh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32306);
          return 0;
        }
        localbky.GFi = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32306);
        return 0;
      }
      AppMethodBeat.o(32306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bky
 * JD-Core Version:    0.7.0.1
 */