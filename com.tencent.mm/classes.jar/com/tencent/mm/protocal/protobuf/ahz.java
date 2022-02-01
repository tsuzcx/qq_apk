package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ahz
  extends erp
{
  public String YFk;
  public LinkedList<String> YFl;
  
  public ahz()
  {
    AppMethodBeat.i(138171);
    this.YFl = new LinkedList();
    AppMethodBeat.o(138171);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138172);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFk == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(138172);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YFk != null) {
        paramVarArgs.g(2, this.YFk);
      }
      paramVarArgs.e(3, 1, this.YFl);
      AppMethodBeat.o(138172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YFk != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YFk);
      }
      paramInt = i.a.a.a.c(3, 1, this.YFl);
      AppMethodBeat.o(138172);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YFk == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(138172);
          throw paramVarArgs;
        }
        AppMethodBeat.o(138172);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ahz localahz = (ahz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(138172);
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
            localahz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(138172);
          return 0;
        case 2: 
          localahz.YFk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(138172);
          return 0;
        }
        localahz.YFl.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(138172);
        return 0;
      }
      AppMethodBeat.o(138172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahz
 * JD-Core Version:    0.7.0.1
 */