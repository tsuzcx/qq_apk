package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ui
  extends cwj
{
  public String GlZ;
  public LinkedList<air> Gma;
  public int Gmb;
  public int dmy;
  public String phe;
  public String phf;
  
  public ui()
  {
    AppMethodBeat.i(91401);
    this.Gma = new LinkedList();
    AppMethodBeat.o(91401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91402);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.GlZ != null) {
        paramVarArgs.d(4, this.GlZ);
      }
      if (this.phf != null) {
        paramVarArgs.d(5, this.phf);
      }
      paramVarArgs.e(6, 8, this.Gma);
      paramVarArgs.aS(7, this.Gmb);
      AppMethodBeat.o(91402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.GlZ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GlZ);
      }
      paramInt = i;
      if (this.phf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.phf);
      }
      i = f.a.a.a.c(6, 8, this.Gma);
      int j = f.a.a.b.b.a.bz(7, this.Gmb);
      AppMethodBeat.o(91402);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gma.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ui localui = (ui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91402);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localui.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        case 2: 
          localui.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91402);
          return 0;
        case 3: 
          localui.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 4: 
          localui.GlZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 5: 
          localui.phf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new air();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((air)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localui.Gma.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        }
        localui.Gmb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91402);
        return 0;
      }
      AppMethodBeat.o(91402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ui
 * JD-Core Version:    0.7.0.1
 */