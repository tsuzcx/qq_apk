package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class db
  extends erp
{
  public LinkedList<doe> YFm;
  public etl YFn;
  public int YFo;
  public String YFp;
  public daa YFq;
  public int lyF;
  
  public db()
  {
    AppMethodBeat.i(101790);
    this.YFm = new LinkedList();
    AppMethodBeat.o(101790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101791);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101791);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.lyF);
      paramVarArgs.e(3, 8, this.YFm);
      if (this.YFn != null)
      {
        paramVarArgs.qD(4, this.YFn.computeSize());
        this.YFn.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.YFo);
      if (this.YFp != null) {
        paramVarArgs.g(6, this.YFp);
      }
      if (this.YFq != null)
      {
        paramVarArgs.qD(7, this.YFq.computeSize());
        this.YFq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.lyF) + i.a.a.a.c(3, 8, this.YFm);
      paramInt = i;
      if (this.YFn != null) {
        paramInt = i + i.a.a.a.qC(4, this.YFn.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YFo);
      paramInt = i;
      if (this.YFp != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YFp);
      }
      i = paramInt;
      if (this.YFq != null) {
        i = paramInt + i.a.a.a.qC(7, this.YFq.computeSize());
      }
      AppMethodBeat.o(101791);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YFn == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101791);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101791);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        db localdb = (db)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101791);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 2: 
          localdb.lyF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101791);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new doe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((doe)localObject2).parseFrom((byte[])localObject1);
            }
            localdb.YFm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localdb.YFn = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 5: 
          localdb.YFo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101791);
          return 0;
        case 6: 
          localdb.YFp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101791);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new daa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((daa)localObject2).parseFrom((byte[])localObject1);
          }
          localdb.YFq = ((daa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(101791);
        return 0;
      }
      AppMethodBeat.o(101791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.db
 * JD-Core Version:    0.7.0.1
 */