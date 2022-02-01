package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class elu
  extends com.tencent.mm.bx.a
{
  public etl abqm;
  public etl abqn;
  public etl abqo;
  public etl abqp;
  public etl abqq;
  public etl abqr;
  public etl abqs;
  public etl abqt;
  public etl abqu;
  public etl abqv;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32402);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abqn == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqo == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqp == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqq == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqr == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqs == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqt == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.id);
      if (this.abqm != null)
      {
        paramVarArgs.qD(2, this.abqm.computeSize());
        this.abqm.writeFields(paramVarArgs);
      }
      if (this.abqn != null)
      {
        paramVarArgs.qD(3, this.abqn.computeSize());
        this.abqn.writeFields(paramVarArgs);
      }
      if (this.abqo != null)
      {
        paramVarArgs.qD(4, this.abqo.computeSize());
        this.abqo.writeFields(paramVarArgs);
      }
      if (this.abqp != null)
      {
        paramVarArgs.qD(5, this.abqp.computeSize());
        this.abqp.writeFields(paramVarArgs);
      }
      if (this.abqq != null)
      {
        paramVarArgs.qD(6, this.abqq.computeSize());
        this.abqq.writeFields(paramVarArgs);
      }
      if (this.abqr != null)
      {
        paramVarArgs.qD(7, this.abqr.computeSize());
        this.abqr.writeFields(paramVarArgs);
      }
      if (this.abqs != null)
      {
        paramVarArgs.qD(8, this.abqs.computeSize());
        this.abqs.writeFields(paramVarArgs);
      }
      if (this.abqt != null)
      {
        paramVarArgs.qD(9, this.abqt.computeSize());
        this.abqt.writeFields(paramVarArgs);
      }
      if (this.abqu != null)
      {
        paramVarArgs.qD(10, this.abqu.computeSize());
        this.abqu.writeFields(paramVarArgs);
      }
      if (this.abqv != null)
      {
        paramVarArgs.qD(11, this.abqv.computeSize());
        this.abqv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.id) + 0;
      paramInt = i;
      if (this.abqm != null) {
        paramInt = i + i.a.a.a.qC(2, this.abqm.computeSize());
      }
      i = paramInt;
      if (this.abqn != null) {
        i = paramInt + i.a.a.a.qC(3, this.abqn.computeSize());
      }
      paramInt = i;
      if (this.abqo != null) {
        paramInt = i + i.a.a.a.qC(4, this.abqo.computeSize());
      }
      i = paramInt;
      if (this.abqp != null) {
        i = paramInt + i.a.a.a.qC(5, this.abqp.computeSize());
      }
      paramInt = i;
      if (this.abqq != null) {
        paramInt = i + i.a.a.a.qC(6, this.abqq.computeSize());
      }
      i = paramInt;
      if (this.abqr != null) {
        i = paramInt + i.a.a.a.qC(7, this.abqr.computeSize());
      }
      paramInt = i;
      if (this.abqs != null) {
        paramInt = i + i.a.a.a.qC(8, this.abqs.computeSize());
      }
      i = paramInt;
      if (this.abqt != null) {
        i = paramInt + i.a.a.a.qC(9, this.abqt.computeSize());
      }
      paramInt = i;
      if (this.abqu != null) {
        paramInt = i + i.a.a.a.qC(10, this.abqu.computeSize());
      }
      i = paramInt;
      if (this.abqv != null) {
        i = paramInt + i.a.a.a.qC(11, this.abqv.computeSize());
      }
      AppMethodBeat.o(32402);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abqn == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqo == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqp == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqq == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqr == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqs == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.abqt == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      elu localelu = (elu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      etl localetl;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32402);
        return -1;
      case 1: 
        localelu.id = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32402);
        return 0;
      case 2: 
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
          localelu.abqm = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 3: 
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
          localelu.abqn = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 4: 
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
          localelu.abqo = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 5: 
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
          localelu.abqp = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
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
          localelu.abqq = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 7: 
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
          localelu.abqr = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 8: 
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
          localelu.abqs = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 9: 
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
          localelu.abqt = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 10: 
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
          localelu.abqu = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      }
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
        localelu.abqv = localetl;
        paramInt += 1;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    AppMethodBeat.o(32402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elu
 * JD-Core Version:    0.7.0.1
 */