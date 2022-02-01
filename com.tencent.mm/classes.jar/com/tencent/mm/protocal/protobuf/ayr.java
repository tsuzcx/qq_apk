package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayr
  extends cld
{
  public cqg DwX;
  public duz DwY;
  public dvr DwZ;
  public ahh Dxa;
  public dvb Dxb;
  public dwa Dxc;
  public dwc Dxd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153276);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DwX != null)
      {
        paramVarArgs.kX(2, this.DwX.computeSize());
        this.DwX.writeFields(paramVarArgs);
      }
      if (this.DwY != null)
      {
        paramVarArgs.kX(3, this.DwY.computeSize());
        this.DwY.writeFields(paramVarArgs);
      }
      if (this.DwZ != null)
      {
        paramVarArgs.kX(4, this.DwZ.computeSize());
        this.DwZ.writeFields(paramVarArgs);
      }
      if (this.Dxa != null)
      {
        paramVarArgs.kX(5, this.Dxa.computeSize());
        this.Dxa.writeFields(paramVarArgs);
      }
      if (this.Dxb != null)
      {
        paramVarArgs.kX(6, this.Dxb.computeSize());
        this.Dxb.writeFields(paramVarArgs);
      }
      if (this.Dxc != null)
      {
        paramVarArgs.kX(7, this.Dxc.computeSize());
        this.Dxc.writeFields(paramVarArgs);
      }
      if (this.Dxd != null)
      {
        paramVarArgs.kX(8, this.Dxd.computeSize());
        this.Dxd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153276);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1442;
      }
    }
    label1442:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DwX != null) {
        paramInt = i + f.a.a.a.kW(2, this.DwX.computeSize());
      }
      i = paramInt;
      if (this.DwY != null) {
        i = paramInt + f.a.a.a.kW(3, this.DwY.computeSize());
      }
      paramInt = i;
      if (this.DwZ != null) {
        paramInt = i + f.a.a.a.kW(4, this.DwZ.computeSize());
      }
      i = paramInt;
      if (this.Dxa != null) {
        i = paramInt + f.a.a.a.kW(5, this.Dxa.computeSize());
      }
      paramInt = i;
      if (this.Dxb != null) {
        paramInt = i + f.a.a.a.kW(6, this.Dxb.computeSize());
      }
      i = paramInt;
      if (this.Dxc != null) {
        i = paramInt + f.a.a.a.kW(7, this.Dxc.computeSize());
      }
      paramInt = i;
      if (this.Dxd != null) {
        paramInt = i + f.a.a.a.kW(8, this.Dxd.computeSize());
      }
      AppMethodBeat.o(153276);
      return paramInt;
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
          AppMethodBeat.o(153276);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayr localayr = (ayr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153276);
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
            localayr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayr.DwX = ((cqg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new duz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((duz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayr.DwY = ((duz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayr.DwZ = ((dvr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayr.Dxa = ((ahh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayr.Dxb = ((dvb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayr.Dxc = ((dwa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayr.Dxd = ((dwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      AppMethodBeat.o(153276);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayr
 * JD-Core Version:    0.7.0.1
 */