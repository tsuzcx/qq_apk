package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyd
  extends cld
{
  public FinderContact DmQ;
  public String EtV;
  public String Lxi;
  public ebi entranceInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203823);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DmQ != null)
      {
        paramVarArgs.kX(2, this.DmQ.computeSize());
        this.DmQ.writeFields(paramVarArgs);
      }
      if (this.EtV != null) {
        paramVarArgs.d(3, this.EtV);
      }
      if (this.Lxi != null) {
        paramVarArgs.d(4, this.Lxi);
      }
      if (this.entranceInfo != null)
      {
        paramVarArgs.kX(5, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(203823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DmQ != null) {
        paramInt = i + f.a.a.a.kW(2, this.DmQ.computeSize());
      }
      i = paramInt;
      if (this.EtV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EtV);
      }
      paramInt = i;
      if (this.Lxi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Lxi);
      }
      i = paramInt;
      if (this.entranceInfo != null) {
        i = paramInt + f.a.a.a.kW(5, this.entranceInfo.computeSize());
      }
      AppMethodBeat.o(203823);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203823);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyd localdyd = (dyd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203823);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203823);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyd.DmQ = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203823);
          return 0;
        case 3: 
          localdyd.EtV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203823);
          return 0;
        case 4: 
          localdyd.Lxi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203823);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyd.entranceInfo = ((ebi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(203823);
        return 0;
      }
      AppMethodBeat.o(203823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyd
 * JD-Core Version:    0.7.0.1
 */