package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcy
  extends cld
{
  public int CellCount;
  public LinkedList<dox> CellList;
  public String DAi;
  public String DAk;
  public int DAl;
  public String DAm;
  public String DAn;
  public String DAo;
  
  public bcy()
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CellCount);
      paramVarArgs.e(3, 8, this.CellList);
      if (this.DAk != null) {
        paramVarArgs.d(4, this.DAk);
      }
      if (this.DAi != null) {
        paramVarArgs.d(5, this.DAi);
      }
      paramVarArgs.aR(6, this.DAl);
      if (this.DAm != null) {
        paramVarArgs.d(7, this.DAm);
      }
      if (this.DAn != null) {
        paramVarArgs.d(8, this.DAn);
      }
      if (this.DAo != null) {
        paramVarArgs.d(9, this.DAo);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CellCount) + f.a.a.a.c(3, 8, this.CellList);
      paramInt = i;
      if (this.DAk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DAk);
      }
      i = paramInt;
      if (this.DAi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DAi);
      }
      i += f.a.a.b.b.a.bA(6, this.DAl);
      paramInt = i;
      if (this.DAm != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DAm);
      }
      i = paramInt;
      if (this.DAn != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DAn);
      }
      paramInt = i;
      if (this.DAo != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DAo);
      }
      AppMethodBeat.o(32306);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CellList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        bcy localbcy = (bcy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32306);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 2: 
          localbcy.CellCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32306);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dox();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dox)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcy.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 4: 
          localbcy.DAk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 5: 
          localbcy.DAi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 6: 
          localbcy.DAl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32306);
          return 0;
        case 7: 
          localbcy.DAm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 8: 
          localbcy.DAn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32306);
          return 0;
        }
        localbcy.DAo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32306);
        return 0;
      }
      AppMethodBeat.o(32306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcy
 * JD-Core Version:    0.7.0.1
 */