package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class doo
  extends esc
{
  public int CreateTime;
  public int Idd;
  public int Njs;
  public long Njv;
  public etl YFF;
  public int YJz;
  public int aaVx;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43105);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Idd);
      if (this.YFF != null)
      {
        paramVarArgs.qD(2, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.Njs);
      paramVarArgs.bS(4, this.aaVx);
      paramVarArgs.bS(5, this.CreateTime);
      paramVarArgs.bS(6, this.YJz);
      paramVarArgs.bS(7, this.vhJ);
      paramVarArgs.bv(8, this.Njv);
      AppMethodBeat.o(43105);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0;
      paramInt = i;
      if (this.YFF != null) {
        paramInt = i + i.a.a.a.qC(2, this.YFF.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.Njs);
      int j = i.a.a.b.b.a.cJ(4, this.aaVx);
      int k = i.a.a.b.b.a.cJ(5, this.CreateTime);
      int m = i.a.a.b.b.a.cJ(6, this.YJz);
      int n = i.a.a.b.b.a.cJ(7, this.vhJ);
      int i1 = i.a.a.b.b.a.q(8, this.Njv);
      AppMethodBeat.o(43105);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43105);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      doo localdoo = (doo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43105);
        return -1;
      case 1: 
        localdoo.Idd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43105);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          etl localetl = new etl();
          if ((localObject != null) && (localObject.length > 0)) {
            localetl.dh((byte[])localObject);
          }
          localdoo.YFF = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(43105);
        return 0;
      case 3: 
        localdoo.Njs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43105);
        return 0;
      case 4: 
        localdoo.aaVx = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43105);
        return 0;
      case 5: 
        localdoo.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43105);
        return 0;
      case 6: 
        localdoo.YJz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43105);
        return 0;
      case 7: 
        localdoo.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43105);
        return 0;
      }
      localdoo.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(43105);
      return 0;
    }
    AppMethodBeat.o(43105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doo
 * JD-Core Version:    0.7.0.1
 */