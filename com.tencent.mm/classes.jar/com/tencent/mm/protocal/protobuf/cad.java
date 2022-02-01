package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cad
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int IIs;
  public int Njs;
  public long Njv;
  public etl YFE;
  public etl YFF;
  public String YFJ;
  public int YFL;
  public int aajd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258657);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(258657);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(258657);
        throw paramVarArgs;
      }
      if (this.YFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgSource");
        AppMethodBeat.o(258657);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Njs);
      if (this.YFE != null)
      {
        paramVarArgs.qD(2, this.YFE.computeSize());
        this.YFE.writeFields(paramVarArgs);
      }
      if (this.YFF != null)
      {
        paramVarArgs.qD(3, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.IIs);
      paramVarArgs.bS(5, this.aajd);
      paramVarArgs.bS(6, this.CreateTime);
      if (this.YFJ != null) {
        paramVarArgs.g(7, this.YFJ);
      }
      paramVarArgs.bv(8, this.Njv);
      paramVarArgs.bS(9, this.YFL);
      AppMethodBeat.o(258657);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Njs) + 0;
      paramInt = i;
      if (this.YFE != null) {
        paramInt = i + i.a.a.a.qC(2, this.YFE.computeSize());
      }
      i = paramInt;
      if (this.YFF != null) {
        i = paramInt + i.a.a.a.qC(3, this.YFF.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(4, this.IIs) + i.a.a.b.b.a.cJ(5, this.aajd) + i.a.a.b.b.a.cJ(6, this.CreateTime);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YFJ);
      }
      i = i.a.a.b.b.a.q(8, this.Njv);
      int j = i.a.a.b.b.a.cJ(9, this.YFL);
      AppMethodBeat.o(258657);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(258657);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(258657);
        throw paramVarArgs;
      }
      if (this.YFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgSource");
        AppMethodBeat.o(258657);
        throw paramVarArgs;
      }
      AppMethodBeat.o(258657);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cad localcad = (cad)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      etl localetl;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258657);
        return -1;
      case 1: 
        localcad.Njs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258657);
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
          localcad.YFE = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(258657);
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
          localcad.YFF = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(258657);
        return 0;
      case 4: 
        localcad.IIs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258657);
        return 0;
      case 5: 
        localcad.aajd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258657);
        return 0;
      case 6: 
        localcad.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258657);
        return 0;
      case 7: 
        localcad.YFJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258657);
        return 0;
      case 8: 
        localcad.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258657);
        return 0;
      }
      localcad.YFL = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258657);
      return 0;
    }
    AppMethodBeat.o(258657);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cad
 * JD-Core Version:    0.7.0.1
 */