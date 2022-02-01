package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gaq
  extends esc
{
  public int CreateTime;
  public long ZvA;
  public int Zvz;
  public int abXQ;
  public String abXZ;
  public LinkedList<gbs> abYa;
  public int lyF;
  
  public gaq()
  {
    AppMethodBeat.i(115879);
    this.abYa = new LinkedList();
    AppMethodBeat.o(115879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115880);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115880);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.CreateTime);
      paramVarArgs.bS(6, this.lyF);
      paramVarArgs.e(7, 8, this.abYa);
      if (this.abXZ != null) {
        paramVarArgs.g(8, this.abXZ);
      }
      paramVarArgs.bS(9, this.abXQ);
      AppMethodBeat.o(115880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.q(3, this.ZvA) + i.a.a.b.b.a.cJ(4, this.CreateTime) + i.a.a.b.b.a.cJ(6, this.lyF) + i.a.a.a.c(7, 8, this.abYa);
      paramInt = i;
      if (this.abXZ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abXZ);
      }
      i = i.a.a.b.b.a.cJ(9, this.abXQ);
      AppMethodBeat.o(115880);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abYa.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gaq localgaq = (gaq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115880);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localgaq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 2: 
          localgaq.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115880);
          return 0;
        case 3: 
          localgaq.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115880);
          return 0;
        case 4: 
          localgaq.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115880);
          return 0;
        case 6: 
          localgaq.lyF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115880);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbs)localObject2).parseFrom((byte[])localObject1);
            }
            localgaq.abYa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 8: 
          localgaq.abXZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(115880);
          return 0;
        }
        localgaq.abXQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115880);
        return 0;
      }
      AppMethodBeat.o(115880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gaq
 * JD-Core Version:    0.7.0.1
 */