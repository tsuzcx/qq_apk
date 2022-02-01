package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ar
  extends erp
{
  public int YBh;
  public String YBi;
  public boolean YBj;
  public String chatroom_name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113927);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YBh);
      if (this.YBi != null) {
        paramVarArgs.g(3, this.YBi);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.g(4, this.chatroom_name);
      }
      paramVarArgs.di(5, this.YBj);
      AppMethodBeat.o(113927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YBh);
      paramInt = i;
      if (this.YBi != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YBi);
      }
      i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.chatroom_name);
      }
      paramInt = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(113927);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ar localar = (ar)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113927);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localar.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(113927);
          return 0;
        case 2: 
          localar.YBh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(113927);
          return 0;
        case 3: 
          localar.YBi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113927);
          return 0;
        case 4: 
          localar.chatroom_name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113927);
          return 0;
        }
        localar.YBj = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(113927);
        return 0;
      }
      AppMethodBeat.o(113927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ar
 * JD-Core Version:    0.7.0.1
 */