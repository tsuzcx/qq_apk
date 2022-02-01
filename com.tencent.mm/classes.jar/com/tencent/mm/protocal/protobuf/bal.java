package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bal
  extends esc
{
  public String ZLq;
  public int ZLr;
  public String ZLs;
  public bqi ZLt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260109);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZLq != null) {
        paramVarArgs.g(2, this.ZLq);
      }
      paramVarArgs.bS(3, this.ZLr);
      if (this.ZLs != null) {
        paramVarArgs.g(4, this.ZLs);
      }
      if (this.ZLt != null)
      {
        paramVarArgs.qD(5, this.ZLt.computeSize());
        this.ZLt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260109);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZLq != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZLq);
      }
      i += i.a.a.b.b.a.cJ(3, this.ZLr);
      paramInt = i;
      if (this.ZLs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZLs);
      }
      i = paramInt;
      if (this.ZLt != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZLt.computeSize());
      }
      AppMethodBeat.o(260109);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260109);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bal localbal = (bal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260109);
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
            localbal.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260109);
          return 0;
        case 2: 
          localbal.ZLq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260109);
          return 0;
        case 3: 
          localbal.ZLr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260109);
          return 0;
        case 4: 
          localbal.ZLs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260109);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqi)localObject2).parseFrom((byte[])localObject1);
          }
          localbal.ZLt = ((bqi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260109);
        return 0;
      }
      AppMethodBeat.o(260109);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bal
 * JD-Core Version:    0.7.0.1
 */