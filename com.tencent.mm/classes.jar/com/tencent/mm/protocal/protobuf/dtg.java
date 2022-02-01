package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtg
  extends com.tencent.mm.bx.a
{
  public int EHZ;
  public int EIa;
  public dtj EIb;
  public String Md5;
  public String rNA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110857);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.rNA == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.rNA != null) {
        paramVarArgs.d(2, this.rNA);
      }
      paramVarArgs.aR(3, this.EHZ);
      paramVarArgs.aR(4, this.EIa);
      if (this.EIb != null)
      {
        paramVarArgs.kX(5, this.EIb.computeSize());
        this.EIb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rNA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rNA);
      }
      i = i + f.a.a.b.b.a.bA(3, this.EHZ) + f.a.a.b.b.a.bA(4, this.EIa);
      paramInt = i;
      if (this.EIb != null) {
        paramInt = i + f.a.a.a.kW(5, this.EIb.computeSize());
      }
      AppMethodBeat.o(110857);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        if (this.rNA == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtg localdtg = (dtg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110857);
          return -1;
        case 1: 
          localdtg.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 2: 
          localdtg.rNA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 3: 
          localdtg.EHZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(110857);
          return 0;
        case 4: 
          localdtg.EIa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(110857);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dtj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdtg.EIb = ((dtj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      AppMethodBeat.o(110857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtg
 * JD-Core Version:    0.7.0.1
 */