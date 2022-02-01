package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgc
  extends com.tencent.mm.bx.a
{
  public String ZPL;
  public int ZPM;
  public String ZPN;
  public blh ZPO;
  public LinkedList<blh> ZPP;
  public String Zoi;
  public String Zon;
  public int Zoz;
  public String Zwf;
  
  public bgc()
  {
    AppMethodBeat.i(258153);
    this.ZPP = new LinkedList();
    AppMethodBeat.o(258153);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258159);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zoz);
      if (this.ZPL != null) {
        paramVarArgs.g(2, this.ZPL);
      }
      paramVarArgs.bS(3, this.ZPM);
      if (this.Zoi != null) {
        paramVarArgs.g(4, this.Zoi);
      }
      if (this.Zwf != null) {
        paramVarArgs.g(5, this.Zwf);
      }
      if (this.ZPN != null) {
        paramVarArgs.g(6, this.ZPN);
      }
      if (this.Zon != null) {
        paramVarArgs.g(7, this.Zon);
      }
      if (this.ZPO != null)
      {
        paramVarArgs.qD(8, this.ZPO.computeSize());
        this.ZPO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.ZPP);
      AppMethodBeat.o(258159);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Zoz) + 0;
      paramInt = i;
      if (this.ZPL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZPL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZPM);
      paramInt = i;
      if (this.Zoi != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zoi);
      }
      i = paramInt;
      if (this.Zwf != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zwf);
      }
      paramInt = i;
      if (this.ZPN != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZPN);
      }
      i = paramInt;
      if (this.Zon != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Zon);
      }
      paramInt = i;
      if (this.ZPO != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZPO.computeSize());
      }
      i = i.a.a.a.c(9, 8, this.ZPP);
      AppMethodBeat.o(258159);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZPP.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258159);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bgc localbgc = (bgc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      blh localblh;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258159);
        return -1;
      case 1: 
        localbgc.Zoz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258159);
        return 0;
      case 2: 
        localbgc.ZPL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258159);
        return 0;
      case 3: 
        localbgc.ZPM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258159);
        return 0;
      case 4: 
        localbgc.Zoi = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258159);
        return 0;
      case 5: 
        localbgc.Zwf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258159);
        return 0;
      case 6: 
        localbgc.ZPN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258159);
        return 0;
      case 7: 
        localbgc.Zon = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258159);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localblh = new blh();
          if ((localObject != null) && (localObject.length > 0)) {
            localblh.parseFrom((byte[])localObject);
          }
          localbgc.ZPO = localblh;
          paramInt += 1;
        }
        AppMethodBeat.o(258159);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localblh = new blh();
        if ((localObject != null) && (localObject.length > 0)) {
          localblh.parseFrom((byte[])localObject);
        }
        localbgc.ZPP.add(localblh);
        paramInt += 1;
      }
      AppMethodBeat.o(258159);
      return 0;
    }
    AppMethodBeat.o(258159);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgc
 * JD-Core Version:    0.7.0.1
 */