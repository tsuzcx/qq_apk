package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bno
  extends com.tencent.mm.bx.a
{
  public int ZWi;
  public LinkedList<bno> ZWj;
  public bno ZWk;
  public int ZWl;
  public int ZWm;
  public String xms;
  
  public bno()
  {
    AppMethodBeat.i(258626);
    this.ZWj = new LinkedList();
    AppMethodBeat.o(258626);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258630);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZWi);
      if (this.xms != null) {
        paramVarArgs.g(2, this.xms);
      }
      paramVarArgs.e(3, 8, this.ZWj);
      if (this.ZWk != null)
      {
        paramVarArgs.qD(4, this.ZWk.computeSize());
        this.ZWk.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.ZWl);
      paramVarArgs.bS(6, this.ZWm);
      AppMethodBeat.o(258630);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZWi) + 0;
      paramInt = i;
      if (this.xms != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xms);
      }
      i = paramInt + i.a.a.a.c(3, 8, this.ZWj);
      paramInt = i;
      if (this.ZWk != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZWk.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.ZWl);
      int j = i.a.a.b.b.a.cJ(6, this.ZWm);
      AppMethodBeat.o(258630);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZWj.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258630);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bno localbno1 = (bno)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      bno localbno2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258630);
        return -1;
      case 1: 
        localbno1.ZWi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258630);
        return 0;
      case 2: 
        localbno1.xms = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258630);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbno2 = new bno();
          if ((localObject != null) && (localObject.length > 0)) {
            localbno2.parseFrom((byte[])localObject);
          }
          localbno1.ZWj.add(localbno2);
          paramInt += 1;
        }
        AppMethodBeat.o(258630);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbno2 = new bno();
          if ((localObject != null) && (localObject.length > 0)) {
            localbno2.parseFrom((byte[])localObject);
          }
          localbno1.ZWk = localbno2;
          paramInt += 1;
        }
        AppMethodBeat.o(258630);
        return 0;
      case 5: 
        localbno1.ZWl = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258630);
        return 0;
      }
      localbno1.ZWm = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258630);
      return 0;
    }
    AppMethodBeat.o(258630);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bno
 * JD-Core Version:    0.7.0.1
 */