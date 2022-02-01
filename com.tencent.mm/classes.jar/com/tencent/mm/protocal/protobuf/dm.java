package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dm
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int IIs;
  public long Njv;
  public int YFL;
  public etl YFM;
  public int YFN;
  public etl YFO;
  public int YFP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133144);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFM == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomId");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.YFO == null)
      {
        paramVarArgs = new b("Not all required fields were included: DigestContent");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.YFM != null)
      {
        paramVarArgs.qD(1, this.YFM.computeSize());
        this.YFM.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.Njv);
      paramVarArgs.bS(3, this.YFL);
      paramVarArgs.bS(4, this.CreateTime);
      paramVarArgs.bS(5, this.YFN);
      if (this.YFO != null)
      {
        paramVarArgs.qD(6, this.YFO.computeSize());
        this.YFO.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.YFP);
      paramVarArgs.bS(8, this.IIs);
      AppMethodBeat.o(133144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YFM == null) {
        break label778;
      }
    }
    label778:
    for (paramInt = i.a.a.a.qC(1, this.YFM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Njv) + i.a.a.b.b.a.cJ(3, this.YFL) + i.a.a.b.b.a.cJ(4, this.CreateTime) + i.a.a.b.b.a.cJ(5, this.YFN);
      paramInt = i;
      if (this.YFO != null) {
        paramInt = i + i.a.a.a.qC(6, this.YFO.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.YFP);
      int j = i.a.a.b.b.a.cJ(8, this.IIs);
      AppMethodBeat.o(133144);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YFM == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomId");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        if (this.YFO == null)
        {
          paramVarArgs = new b("Not all required fields were included: DigestContent");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dm localdm = (dm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        etl localetl;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133144);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdm.YFM = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 2: 
          localdm.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(133144);
          return 0;
        case 3: 
          localdm.YFL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(133144);
          return 0;
        case 4: 
          localdm.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(133144);
          return 0;
        case 5: 
          localdm.YFN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(133144);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdm.YFO = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 7: 
          localdm.YFP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(133144);
          return 0;
        }
        localdm.IIs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(133144);
        return 0;
      }
      AppMethodBeat.o(133144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dm
 * JD-Core Version:    0.7.0.1
 */