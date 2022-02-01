package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzw
  extends erp
{
  public String CAf;
  public String ihx;
  public int limit;
  public int msgType;
  public int offset;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257551);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ihx != null) {
        paramVarArgs.g(2, this.ihx);
      }
      paramVarArgs.bS(3, this.limit);
      paramVarArgs.bS(4, this.offset);
      if (this.CAf != null) {
        paramVarArgs.g(5, this.CAf);
      }
      paramVarArgs.bS(6, this.msgType);
      paramVarArgs.bS(7, this.scene);
      AppMethodBeat.o(257551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ihx != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ihx);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.limit) + i.a.a.b.b.a.cJ(4, this.offset);
      paramInt = i;
      if (this.CAf != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.CAf);
      }
      i = i.a.a.b.b.a.cJ(6, this.msgType);
      int j = i.a.a.b.b.a.cJ(7, this.scene);
      AppMethodBeat.o(257551);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bzw localbzw = (bzw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257551);
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
            localbzw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257551);
          return 0;
        case 2: 
          localbzw.ihx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257551);
          return 0;
        case 3: 
          localbzw.limit = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257551);
          return 0;
        case 4: 
          localbzw.offset = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257551);
          return 0;
        case 5: 
          localbzw.CAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257551);
          return 0;
        case 6: 
          localbzw.msgType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257551);
          return 0;
        }
        localbzw.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257551);
        return 0;
      }
      AppMethodBeat.o(257551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzw
 * JD-Core Version:    0.7.0.1
 */