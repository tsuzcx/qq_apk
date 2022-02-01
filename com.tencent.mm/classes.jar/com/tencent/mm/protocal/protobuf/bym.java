package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bym
  extends esc
{
  public LinkedList<FinderObject> ZIQ;
  public int aahh;
  public int aahi;
  public int aahj;
  public azh aahk;
  public FinderContact contact;
  
  public bym()
  {
    AppMethodBeat.i(257839);
    this.ZIQ = new LinkedList();
    AppMethodBeat.o(257839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257848);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.qD(2, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aahh);
      paramVarArgs.e(4, 8, this.ZIQ);
      paramVarArgs.bS(5, this.aahi);
      paramVarArgs.bS(6, this.aahj);
      if (this.aahk != null)
      {
        paramVarArgs.qD(7, this.aahk.computeSize());
        this.aahk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.contact != null) {
        i = paramInt + i.a.a.a.qC(2, this.contact.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aahh) + i.a.a.a.c(4, 8, this.ZIQ) + i.a.a.b.b.a.cJ(5, this.aahi) + i.a.a.b.b.a.cJ(6, this.aahj);
      paramInt = i;
      if (this.aahk != null) {
        paramInt = i + i.a.a.a.qC(7, this.aahk.computeSize());
      }
      AppMethodBeat.o(257848);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZIQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257848);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bym localbym = (bym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257848);
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
            localbym.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257848);
          return 0;
        case 2: 
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
            localbym.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257848);
          return 0;
        case 3: 
          localbym.aahh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257848);
          return 0;
        case 4: 
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
            localbym.ZIQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257848);
          return 0;
        case 5: 
          localbym.aahi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257848);
          return 0;
        case 6: 
          localbym.aahj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257848);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new azh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((azh)localObject2).parseFrom((byte[])localObject1);
          }
          localbym.aahk = ((azh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257848);
        return 0;
      }
      AppMethodBeat.o(257848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bym
 * JD-Core Version:    0.7.0.1
 */