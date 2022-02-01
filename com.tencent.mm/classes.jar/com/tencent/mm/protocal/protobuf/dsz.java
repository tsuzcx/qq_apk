package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dsz
  extends com.tencent.mm.cd.a
{
  public eaf TZp;
  public eaf TZq;
  public eaf TZr;
  public eaf TZs;
  public eaf TZt;
  public eaf TZu;
  public eaf TZv;
  public eaf TZw;
  public eaf TZx;
  public eaf TZy;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32402);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TZq == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZr == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZs == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZt == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZu == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZv == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZw == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.id);
      if (this.TZp != null)
      {
        paramVarArgs.oE(2, this.TZp.computeSize());
        this.TZp.writeFields(paramVarArgs);
      }
      if (this.TZq != null)
      {
        paramVarArgs.oE(3, this.TZq.computeSize());
        this.TZq.writeFields(paramVarArgs);
      }
      if (this.TZr != null)
      {
        paramVarArgs.oE(4, this.TZr.computeSize());
        this.TZr.writeFields(paramVarArgs);
      }
      if (this.TZs != null)
      {
        paramVarArgs.oE(5, this.TZs.computeSize());
        this.TZs.writeFields(paramVarArgs);
      }
      if (this.TZt != null)
      {
        paramVarArgs.oE(6, this.TZt.computeSize());
        this.TZt.writeFields(paramVarArgs);
      }
      if (this.TZu != null)
      {
        paramVarArgs.oE(7, this.TZu.computeSize());
        this.TZu.writeFields(paramVarArgs);
      }
      if (this.TZv != null)
      {
        paramVarArgs.oE(8, this.TZv.computeSize());
        this.TZv.writeFields(paramVarArgs);
      }
      if (this.TZw != null)
      {
        paramVarArgs.oE(9, this.TZw.computeSize());
        this.TZw.writeFields(paramVarArgs);
      }
      if (this.TZx != null)
      {
        paramVarArgs.oE(10, this.TZx.computeSize());
        this.TZx.writeFields(paramVarArgs);
      }
      if (this.TZy != null)
      {
        paramVarArgs.oE(11, this.TZy.computeSize());
        this.TZy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.id) + 0;
      paramInt = i;
      if (this.TZp != null) {
        paramInt = i + g.a.a.a.oD(2, this.TZp.computeSize());
      }
      i = paramInt;
      if (this.TZq != null) {
        i = paramInt + g.a.a.a.oD(3, this.TZq.computeSize());
      }
      paramInt = i;
      if (this.TZr != null) {
        paramInt = i + g.a.a.a.oD(4, this.TZr.computeSize());
      }
      i = paramInt;
      if (this.TZs != null) {
        i = paramInt + g.a.a.a.oD(5, this.TZs.computeSize());
      }
      paramInt = i;
      if (this.TZt != null) {
        paramInt = i + g.a.a.a.oD(6, this.TZt.computeSize());
      }
      i = paramInt;
      if (this.TZu != null) {
        i = paramInt + g.a.a.a.oD(7, this.TZu.computeSize());
      }
      paramInt = i;
      if (this.TZv != null) {
        paramInt = i + g.a.a.a.oD(8, this.TZv.computeSize());
      }
      i = paramInt;
      if (this.TZw != null) {
        i = paramInt + g.a.a.a.oD(9, this.TZw.computeSize());
      }
      paramInt = i;
      if (this.TZx != null) {
        paramInt = i + g.a.a.a.oD(10, this.TZx.computeSize());
      }
      i = paramInt;
      if (this.TZy != null) {
        i = paramInt + g.a.a.a.oD(11, this.TZy.computeSize());
      }
      AppMethodBeat.o(32402);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TZq == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZr == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZs == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZt == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZu == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZv == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.TZw == null)
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
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dsz localdsz = (dsz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      eaf localeaf;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32402);
        return -1;
      case 1: 
        localdsz.id = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32402);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZp = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZq = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZr = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZs = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZt = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZu = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZv = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZw = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsz.TZx = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localeaf = new eaf();
        if ((localObject != null) && (localObject.length > 0)) {
          localeaf.de((byte[])localObject);
        }
        localdsz.TZy = localeaf;
        paramInt += 1;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    AppMethodBeat.o(32402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsz
 * JD-Core Version:    0.7.0.1
 */