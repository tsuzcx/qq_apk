package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bxz
  extends dpc
{
  public int CellCount;
  public LinkedList<ewg> CellList;
  public String MdA;
  public String Mdu;
  public String Mdw;
  public int Mdx;
  public String Mdy;
  public String Mdz;
  
  public bxz()
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32306);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.CellCount);
      paramVarArgs.e(3, 8, this.CellList);
      if (this.Mdw != null) {
        paramVarArgs.e(4, this.Mdw);
      }
      if (this.Mdu != null) {
        paramVarArgs.e(5, this.Mdu);
      }
      paramVarArgs.aM(6, this.Mdx);
      if (this.Mdy != null) {
        paramVarArgs.e(7, this.Mdy);
      }
      if (this.Mdz != null) {
        paramVarArgs.e(8, this.Mdz);
      }
      if (this.MdA != null) {
        paramVarArgs.e(9, this.MdA);
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
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.CellCount) + g.a.a.a.c(3, 8, this.CellList);
      paramInt = i;
      if (this.Mdw != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mdw);
      }
      i = paramInt;
      if (this.Mdu != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mdu);
      }
      i += g.a.a.b.b.a.bu(6, this.Mdx);
      paramInt = i;
      if (this.Mdy != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Mdy);
      }
      i = paramInt;
      if (this.Mdz != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Mdz);
      }
      paramInt = i;
      if (this.MdA != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MdA);
      }
      AppMethodBeat.o(32306);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CellList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bxz localbxz = (bxz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32306);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 2: 
          localbxz.CellCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32306);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ewg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ewg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxz.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 4: 
          localbxz.Mdw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 5: 
          localbxz.Mdu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 6: 
          localbxz.Mdx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32306);
          return 0;
        case 7: 
          localbxz.Mdy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 8: 
          localbxz.Mdz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32306);
          return 0;
        }
        localbxz.MdA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32306);
        return 0;
      }
      AppMethodBeat.o(32306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxz
 * JD-Core Version:    0.7.0.1
 */