package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bnn
  extends com.tencent.mm.bx.a
{
  public int ZVZ;
  public String ZWa;
  public boolean ZWb;
  public boolean ZWc;
  public boolean ZWd;
  public boolean ZWe;
  public LinkedList<bnn> ZWf;
  public int ZWg;
  public String ZWh;
  public String icon_url;
  public long object_id;
  
  public bnn()
  {
    AppMethodBeat.i(258598);
    this.ZWf = new LinkedList();
    AppMethodBeat.o(258598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258604);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZVZ);
      if (this.ZWa != null) {
        paramVarArgs.g(2, this.ZWa);
      }
      paramVarArgs.di(3, this.ZWb);
      paramVarArgs.di(4, this.ZWc);
      paramVarArgs.di(5, this.ZWd);
      paramVarArgs.di(6, this.ZWe);
      paramVarArgs.e(7, 8, this.ZWf);
      paramVarArgs.bS(8, this.ZWg);
      paramVarArgs.bv(9, this.object_id);
      if (this.icon_url != null) {
        paramVarArgs.g(10, this.icon_url);
      }
      if (this.ZWh != null) {
        paramVarArgs.g(11, this.ZWh);
      }
      AppMethodBeat.o(258604);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZVZ) + 0;
      paramInt = i;
      if (this.ZWa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZWa);
      }
      i = paramInt + (i.a.a.b.b.a.ko(3) + 1) + (i.a.a.b.b.a.ko(4) + 1) + (i.a.a.b.b.a.ko(5) + 1) + (i.a.a.b.b.a.ko(6) + 1) + i.a.a.a.c(7, 8, this.ZWf) + i.a.a.b.b.a.cJ(8, this.ZWg) + i.a.a.b.b.a.q(9, this.object_id);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.icon_url);
      }
      i = paramInt;
      if (this.ZWh != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZWh);
      }
      AppMethodBeat.o(258604);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZWf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258604);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bnn localbnn1 = (bnn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258604);
        return -1;
      case 1: 
        localbnn1.ZVZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258604);
        return 0;
      case 2: 
        localbnn1.ZWa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258604);
        return 0;
      case 3: 
        localbnn1.ZWb = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(258604);
        return 0;
      case 4: 
        localbnn1.ZWc = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(258604);
        return 0;
      case 5: 
        localbnn1.ZWd = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(258604);
        return 0;
      case 6: 
        localbnn1.ZWe = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(258604);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bnn localbnn2 = new bnn();
          if ((localObject != null) && (localObject.length > 0)) {
            localbnn2.parseFrom((byte[])localObject);
          }
          localbnn1.ZWf.add(localbnn2);
          paramInt += 1;
        }
        AppMethodBeat.o(258604);
        return 0;
      case 8: 
        localbnn1.ZWg = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258604);
        return 0;
      case 9: 
        localbnn1.object_id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258604);
        return 0;
      case 10: 
        localbnn1.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258604);
        return 0;
      }
      localbnn1.ZWh = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258604);
      return 0;
    }
    AppMethodBeat.o(258604);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnn
 * JD-Core Version:    0.7.0.1
 */