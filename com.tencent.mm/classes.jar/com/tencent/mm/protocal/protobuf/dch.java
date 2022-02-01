package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dch
  extends com.tencent.mm.bx.a
{
  public boolean YGe;
  public boolean YGf;
  public awr YGg;
  public int aaHY;
  public boolean aaHZ;
  public long aaIa;
  public long aaIb;
  public boolean aaIc;
  public boolean aaId;
  public long aaIe;
  public int aaIf;
  public LinkedList<String> aaIg;
  public String name;
  
  public dch()
  {
    AppMethodBeat.i(259313);
    this.aaIg = new LinkedList();
    AppMethodBeat.o(259313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259319);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGg != null)
      {
        paramVarArgs.qD(1, this.YGg.computeSize());
        this.YGg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaHY);
      paramVarArgs.di(3, this.aaHZ);
      paramVarArgs.bv(4, this.aaIa);
      paramVarArgs.bv(5, this.aaIb);
      paramVarArgs.di(6, this.YGe);
      paramVarArgs.di(7, this.aaIc);
      paramVarArgs.di(8, this.aaId);
      paramVarArgs.bv(9, this.aaIe);
      paramVarArgs.bS(10, this.aaIf);
      paramVarArgs.e(11, 1, this.aaIg);
      paramVarArgs.di(12, this.YGf);
      if (this.name != null) {
        paramVarArgs.g(13, this.name);
      }
      AppMethodBeat.o(259319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGg == null) {
        break label832;
      }
    }
    label832:
    for (paramInt = i.a.a.a.qC(1, this.YGg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaHY) + (i.a.a.b.b.a.ko(3) + 1) + i.a.a.b.b.a.q(4, this.aaIa) + i.a.a.b.b.a.q(5, this.aaIb) + (i.a.a.b.b.a.ko(6) + 1) + (i.a.a.b.b.a.ko(7) + 1) + (i.a.a.b.b.a.ko(8) + 1) + i.a.a.b.b.a.q(9, this.aaIe) + i.a.a.b.b.a.cJ(10, this.aaIf) + i.a.a.a.c(11, 1, this.aaIg) + (i.a.a.b.b.a.ko(12) + 1);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.name);
      }
      AppMethodBeat.o(259319);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaIg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dch localdch = (dch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259319);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            awr localawr = new awr();
            if ((localObject != null) && (localObject.length > 0)) {
              localawr.parseFrom((byte[])localObject);
            }
            localdch.YGg = localawr;
            paramInt += 1;
          }
          AppMethodBeat.o(259319);
          return 0;
        case 2: 
          localdch.aaHY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259319);
          return 0;
        case 3: 
          localdch.aaHZ = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(259319);
          return 0;
        case 4: 
          localdch.aaIa = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259319);
          return 0;
        case 5: 
          localdch.aaIb = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259319);
          return 0;
        case 6: 
          localdch.YGe = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(259319);
          return 0;
        case 7: 
          localdch.aaIc = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(259319);
          return 0;
        case 8: 
          localdch.aaId = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(259319);
          return 0;
        case 9: 
          localdch.aaIe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259319);
          return 0;
        case 10: 
          localdch.aaIf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259319);
          return 0;
        case 11: 
          localdch.aaIg.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(259319);
          return 0;
        case 12: 
          localdch.YGf = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(259319);
          return 0;
        }
        localdch.name = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259319);
        return 0;
      }
      AppMethodBeat.o(259319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dch
 * JD-Core Version:    0.7.0.1
 */