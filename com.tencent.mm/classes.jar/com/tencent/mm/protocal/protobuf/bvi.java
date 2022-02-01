package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bvi
  extends dpc
{
  public LinkedList<cbe> Mbs;
  public String Mbt;
  public int Mbu;
  public LinkedList<String> Mbv;
  public int Mbw;
  public long Mbx;
  public int dDN;
  public String qwn;
  public String yUF;
  
  public bvi()
  {
    AppMethodBeat.i(91512);
    this.dDN = 0;
    this.qwn = "ok";
    this.Mbs = new LinkedList();
    this.Mbv = new LinkedList();
    AppMethodBeat.o(91512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91513);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      paramVarArgs.e(4, 8, this.Mbs);
      if (this.Mbt != null) {
        paramVarArgs.e(5, this.Mbt);
      }
      paramVarArgs.aM(6, this.Mbu);
      if (this.yUF != null) {
        paramVarArgs.e(7, this.yUF);
      }
      paramVarArgs.e(8, 1, this.Mbv);
      paramVarArgs.aM(9, this.Mbw);
      paramVarArgs.bb(10, this.Mbx);
      AppMethodBeat.o(91513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.Mbs);
      paramInt = i;
      if (this.Mbt != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mbt);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Mbu);
      paramInt = i;
      if (this.yUF != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.yUF);
      }
      i = g.a.a.a.c(8, 1, this.Mbv);
      int j = g.a.a.b.b.a.bu(9, this.Mbw);
      int k = g.a.a.b.b.a.r(10, this.Mbx);
      AppMethodBeat.o(91513);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mbs.clear();
        this.Mbv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91513);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvi localbvi = (bvi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91513);
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
            localbvi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 2: 
          localbvi.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91513);
          return 0;
        case 3: 
          localbvi.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbvi.Mbs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 5: 
          localbvi.Mbt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 6: 
          localbvi.Mbu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91513);
          return 0;
        case 7: 
          localbvi.yUF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 8: 
          localbvi.Mbv.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91513);
          return 0;
        case 9: 
          localbvi.Mbw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91513);
          return 0;
        }
        localbvi.Mbx = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91513);
        return 0;
      }
      AppMethodBeat.o(91513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvi
 * JD-Core Version:    0.7.0.1
 */