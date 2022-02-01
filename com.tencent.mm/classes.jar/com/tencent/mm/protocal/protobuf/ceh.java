package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ceh
  extends cld
{
  public String CsC;
  public clp DEh;
  public long DEl;
  public long Dbe;
  public dcl DsY;
  public String dub;
  public int lpz;
  public String nsJ;
  public int ntx;
  public String nty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72558);
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
      if (this.CsC != null) {
        paramVarArgs.d(4, this.CsC);
      }
      paramVarArgs.aG(5, this.DEl);
      paramVarArgs.aG(6, this.Dbe);
      if (this.DEh != null)
      {
        paramVarArgs.kX(7, this.DEh.computeSize());
        this.DEh.writeFields(paramVarArgs);
      }
      if (this.DsY != null)
      {
        paramVarArgs.kX(8, this.DsY.computeSize());
        this.DsY.writeFields(paramVarArgs);
      }
      if (this.nsJ != null) {
        paramVarArgs.d(9, this.nsJ);
      }
      paramVarArgs.aR(10, this.lpz);
      if (this.dub != null) {
        paramVarArgs.d(11, this.dub);
      }
      AppMethodBeat.o(72558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.CsC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CsC);
      }
      i = i + f.a.a.b.b.a.q(5, this.DEl) + f.a.a.b.b.a.q(6, this.Dbe);
      paramInt = i;
      if (this.DEh != null) {
        paramInt = i + f.a.a.a.kW(7, this.DEh.computeSize());
      }
      i = paramInt;
      if (this.DsY != null) {
        i = paramInt + f.a.a.a.kW(8, this.DsY.computeSize());
      }
      paramInt = i;
      if (this.nsJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nsJ);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.lpz);
      paramInt = i;
      if (this.dub != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dub);
      }
      AppMethodBeat.o(72558);
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
          AppMethodBeat.o(72558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ceh localceh = (ceh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72558);
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
            localceh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 2: 
          localceh.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72558);
          return 0;
        case 3: 
          localceh.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 4: 
          localceh.CsC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 5: 
          localceh.DEl = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72558);
          return 0;
        case 6: 
          localceh.Dbe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72558);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceh.DEh = ((clp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceh.DsY = ((dcl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 9: 
          localceh.nsJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 10: 
          localceh.lpz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72558);
          return 0;
        }
        localceh.dub = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72558);
        return 0;
      }
      AppMethodBeat.o(72558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceh
 * JD-Core Version:    0.7.0.1
 */