package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbu
  extends com.tencent.mm.bx.a
{
  public dbq aaHl;
  public dbq aaHm;
  public LinkedList<dbt> aaHn;
  public String version;
  
  public dbu()
  {
    AppMethodBeat.i(259483);
    this.aaHn = new LinkedList();
    AppMethodBeat.o(259483);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259486);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.version != null) {
        paramVarArgs.g(1, this.version);
      }
      if (this.aaHl != null)
      {
        paramVarArgs.qD(2, this.aaHl.computeSize());
        this.aaHl.writeFields(paramVarArgs);
      }
      if (this.aaHm != null)
      {
        paramVarArgs.qD(3, this.aaHm.computeSize());
        this.aaHm.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.aaHn);
      AppMethodBeat.o(259486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.version == null) {
        break label596;
      }
    }
    label596:
    for (int i = i.a.a.b.b.a.h(1, this.version) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaHl != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaHl.computeSize());
      }
      i = paramInt;
      if (this.aaHm != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaHm.computeSize());
      }
      paramInt = i.a.a.a.c(4, 8, this.aaHn);
      AppMethodBeat.o(259486);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaHn.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dbu localdbu = (dbu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259486);
          return -1;
        case 1: 
          localdbu.version = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259486);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbq)localObject2).parseFrom((byte[])localObject1);
            }
            localdbu.aaHl = ((dbq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259486);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbq)localObject2).parseFrom((byte[])localObject1);
            }
            localdbu.aaHm = ((dbq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259486);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbt)localObject2).parseFrom((byte[])localObject1);
          }
          localdbu.aaHn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259486);
        return 0;
      }
      AppMethodBeat.o(259486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbu
 * JD-Core Version:    0.7.0.1
 */