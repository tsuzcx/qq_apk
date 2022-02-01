package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dif
  extends dpc
{
  public String KKG;
  public LinkedList<ekl> MMM;
  public LinkedList<ekl> MMN;
  public int dDN;
  public String qwn;
  
  public dif()
  {
    AppMethodBeat.i(72572);
    this.MMM = new LinkedList();
    this.MMN = new LinkedList();
    AppMethodBeat.o(72572);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72573);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72573);
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
      paramVarArgs.e(4, 8, this.MMM);
      paramVarArgs.e(5, 8, this.MMN);
      if (this.KKG != null) {
        paramVarArgs.e(6, this.KKG);
      }
      AppMethodBeat.o(72573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.MMM) + g.a.a.a.c(5, 8, this.MMN);
      paramInt = i;
      if (this.KKG != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KKG);
      }
      AppMethodBeat.o(72573);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MMM.clear();
        this.MMN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dif localdif = (dif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72573);
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
            localdif.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        case 2: 
          localdif.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72573);
          return 0;
        case 3: 
          localdif.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72573);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdif.MMM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdif.MMN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        }
        localdif.KKG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72573);
        return 0;
      }
      AppMethodBeat.o(72573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dif
 * JD-Core Version:    0.7.0.1
 */