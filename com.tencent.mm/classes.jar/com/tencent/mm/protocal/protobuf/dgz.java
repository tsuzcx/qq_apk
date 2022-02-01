package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dgz
  extends dpc
{
  public String HTZ;
  public ddb KPx;
  public String MLv;
  public LinkedList<je> MLw;
  public int pTZ;
  public String pUa;
  
  public dgz()
  {
    AppMethodBeat.i(72553);
    this.MLw = new LinkedList();
    AppMethodBeat.o(72553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72554);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.MLv != null) {
        paramVarArgs.e(4, this.MLv);
      }
      paramVarArgs.e(5, 8, this.MLw);
      if (this.KPx != null)
      {
        paramVarArgs.ni(6, this.KPx.computeSize());
        this.KPx.writeFields(paramVarArgs);
      }
      if (this.HTZ != null) {
        paramVarArgs.e(7, this.HTZ);
      }
      AppMethodBeat.o(72554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.MLv != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MLv);
      }
      i += g.a.a.a.c(5, 8, this.MLw);
      paramInt = i;
      if (this.KPx != null) {
        paramInt = i + g.a.a.a.nh(6, this.KPx.computeSize());
      }
      i = paramInt;
      if (this.HTZ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.HTZ);
      }
      AppMethodBeat.o(72554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MLw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgz localdgz = (dgz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72554);
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
            localdgz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 2: 
          localdgz.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72554);
          return 0;
        case 3: 
          localdgz.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 4: 
          localdgz.MLv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new je();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((je)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgz.MLw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgz.KPx = ((ddb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        }
        localdgz.HTZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72554);
        return 0;
      }
      AppMethodBeat.o(72554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgz
 * JD-Core Version:    0.7.0.1
 */