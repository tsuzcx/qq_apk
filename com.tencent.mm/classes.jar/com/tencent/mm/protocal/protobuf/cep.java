package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cep
  extends cld
{
  public String DXo;
  public String DXp;
  public dbs EaA;
  public cbb EaB;
  public String EaC;
  public at Eaz;
  public int ntx;
  public String nty;
  public String zFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72565);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72565);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.DXo != null) {
        paramVarArgs.d(4, this.DXo);
      }
      if (this.DXp != null) {
        paramVarArgs.d(5, this.DXp);
      }
      if (this.Eaz != null)
      {
        paramVarArgs.kX(6, this.Eaz.computeSize());
        this.Eaz.writeFields(paramVarArgs);
      }
      if (this.EaA != null)
      {
        paramVarArgs.kX(7, this.EaA.computeSize());
        this.EaA.writeFields(paramVarArgs);
      }
      if (this.EaB != null)
      {
        paramVarArgs.kX(8, this.EaB.computeSize());
        this.EaB.writeFields(paramVarArgs);
      }
      if (this.EaC != null) {
        paramVarArgs.d(9, this.EaC);
      }
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(72565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1210;
      }
    }
    label1210:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.DXo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DXo);
      }
      paramInt = i;
      if (this.DXp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DXp);
      }
      i = paramInt;
      if (this.Eaz != null) {
        i = paramInt + f.a.a.a.kW(6, this.Eaz.computeSize());
      }
      paramInt = i;
      if (this.EaA != null) {
        paramInt = i + f.a.a.a.kW(7, this.EaA.computeSize());
      }
      i = paramInt;
      if (this.EaB != null) {
        i = paramInt + f.a.a.a.kW(8, this.EaB.computeSize());
      }
      paramInt = i;
      if (this.EaC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EaC);
      }
      i = paramInt;
      if (this.zFY != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(72565);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cep localcep = (cep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72565);
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
            localcep.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 2: 
          localcep.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72565);
          return 0;
        case 3: 
          localcep.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 4: 
          localcep.DXo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 5: 
          localcep.DXp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new at();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((at)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcep.Eaz = ((at)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcep.EaA = ((dbs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcep.EaB = ((cbb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 9: 
          localcep.EaC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72565);
          return 0;
        }
        localcep.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72565);
        return 0;
      }
      AppMethodBeat.o(72565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cep
 * JD-Core Version:    0.7.0.1
 */