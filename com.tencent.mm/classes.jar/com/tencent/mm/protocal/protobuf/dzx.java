package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzx
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public int IMf;
  public String Md5;
  public gol YHl;
  public String Zul;
  public gol abfg;
  public int crz;
  public int vhE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152659);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IMf);
      paramVarArgs.bS(2, this.crz);
      if (this.IGU != null) {
        paramVarArgs.g(3, this.IGU);
      }
      paramVarArgs.bS(4, this.vhE);
      if (this.YHl != null)
      {
        paramVarArgs.qD(5, this.YHl.computeSize());
        this.YHl.writeFields(paramVarArgs);
      }
      if (this.Zul != null) {
        paramVarArgs.g(6, this.Zul);
      }
      if (this.abfg != null)
      {
        paramVarArgs.qD(7, this.abfg.computeSize());
        this.abfg.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(8, this.Md5);
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.IMf) + 0 + i.a.a.b.b.a.cJ(2, this.crz);
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IGU);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.vhE);
      paramInt = i;
      if (this.YHl != null) {
        paramInt = i + i.a.a.a.qC(5, this.YHl.computeSize());
      }
      i = paramInt;
      if (this.Zul != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Zul);
      }
      paramInt = i;
      if (this.abfg != null) {
        paramInt = i + i.a.a.a.qC(7, this.abfg.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Md5);
      }
      AppMethodBeat.o(152659);
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
      AppMethodBeat.o(152659);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dzx localdzx = (dzx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      gol localgol;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152659);
        return -1;
      case 1: 
        localdzx.IMf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152659);
        return 0;
      case 2: 
        localdzx.crz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152659);
        return 0;
      case 3: 
        localdzx.IGU = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 4: 
        localdzx.vhE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152659);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localdzx.YHl = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      case 6: 
        localdzx.Zul = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localdzx.abfg = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      }
      localdzx.Md5 = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(152659);
      return 0;
    }
    AppMethodBeat.o(152659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzx
 * JD-Core Version:    0.7.0.1
 */