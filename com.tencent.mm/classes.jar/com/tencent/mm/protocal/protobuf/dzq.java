package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzq
  extends esc
{
  public String abeK;
  public dzt abeO;
  public LinkedList<dzq> abeP;
  public int abeQ;
  public String type;
  public String ycW;
  
  public dzq()
  {
    AppMethodBeat.i(117539);
    this.abeP = new LinkedList();
    AppMethodBeat.o(117539);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117540);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abeO != null)
      {
        paramVarArgs.qD(2, this.abeO.computeSize());
        this.abeO.writeFields(paramVarArgs);
      }
      if (this.abeK != null) {
        paramVarArgs.g(3, this.abeK);
      }
      if (this.ycW != null) {
        paramVarArgs.g(4, this.ycW);
      }
      if (this.type != null) {
        paramVarArgs.g(5, this.type);
      }
      paramVarArgs.e(6, 8, this.abeP);
      paramVarArgs.bS(7, this.abeQ);
      AppMethodBeat.o(117540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label768;
      }
    }
    label768:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abeO != null) {
        paramInt = i + i.a.a.a.qC(2, this.abeO.computeSize());
      }
      i = paramInt;
      if (this.abeK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abeK);
      }
      paramInt = i;
      if (this.ycW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ycW);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.type);
      }
      paramInt = i.a.a.a.c(6, 8, this.abeP);
      int j = i.a.a.b.b.a.cJ(7, this.abeQ);
      AppMethodBeat.o(117540);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abeP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dzq localdzq = (dzq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117540);
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
            localdzq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzt)localObject2).parseFrom((byte[])localObject1);
            }
            localdzq.abeO = ((dzt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 3: 
          localdzq.abeK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 4: 
          localdzq.ycW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 5: 
          localdzq.type = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzq)localObject2).parseFrom((byte[])localObject1);
            }
            localdzq.abeP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        }
        localdzq.abeQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117540);
        return 0;
      }
      AppMethodBeat.o(117540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzq
 * JD-Core Version:    0.7.0.1
 */