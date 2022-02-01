package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqm
  extends esc
{
  public FinderContact contact;
  public int continueFlag;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> object;
  public btc preloadInfo;
  
  public bqm()
  {
    AppMethodBeat.i(257579);
    this.object = new LinkedList();
    AppMethodBeat.o(257579);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257587);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257587);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.contact != null)
      {
        paramVarArgs.qD(3, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.continueFlag);
      if (this.lastBuffer != null) {
        paramVarArgs.d(5, this.lastBuffer);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.qD(6, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label822;
      }
    }
    label822:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + i.a.a.a.qC(3, this.contact.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.continueFlag);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.lastBuffer);
      }
      i = paramInt;
      if (this.preloadInfo != null) {
        i = paramInt + i.a.a.a.qC(6, this.preloadInfo.computeSize());
      }
      AppMethodBeat.o(257587);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(257587);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bqm localbqm = (bqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257587);
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
            localbqm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257587);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbqm.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257587);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbqm.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257587);
          return 0;
        case 4: 
          localbqm.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257587);
          return 0;
        case 5: 
          localbqm.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257587);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new btc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((btc)localObject2).parseFrom((byte[])localObject1);
          }
          localbqm.preloadInfo = ((btc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257587);
        return 0;
      }
      AppMethodBeat.o(257587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqm
 * JD-Core Version:    0.7.0.1
 */