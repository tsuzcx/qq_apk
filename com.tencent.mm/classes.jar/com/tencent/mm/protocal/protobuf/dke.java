package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dke
  extends com.tencent.mm.bx.a
{
  public String aaPY;
  public boolean aaPZ;
  public jf aaQa;
  public String aaQb;
  public boolean aaQc;
  public int aaQd;
  public String aaQe;
  public int aaQf;
  public fnh aaQg;
  public aey aaQh;
  public String aaQi;
  public String aaQj;
  public LinkedList<xe> aaoI;
  
  public dke()
  {
    AppMethodBeat.i(91533);
    this.aaoI = new LinkedList();
    AppMethodBeat.o(91533);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91534);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaPY != null) {
        paramVarArgs.g(1, this.aaPY);
      }
      paramVarArgs.e(2, 8, this.aaoI);
      paramVarArgs.di(3, this.aaPZ);
      if (this.aaQa != null)
      {
        paramVarArgs.qD(4, this.aaQa.computeSize());
        this.aaQa.writeFields(paramVarArgs);
      }
      if (this.aaQb != null) {
        paramVarArgs.g(5, this.aaQb);
      }
      paramVarArgs.di(6, this.aaQc);
      paramVarArgs.bS(7, this.aaQd);
      if (this.aaQe != null) {
        paramVarArgs.g(8, this.aaQe);
      }
      paramVarArgs.bS(9, this.aaQf);
      if (this.aaQg != null)
      {
        paramVarArgs.qD(10, this.aaQg.computeSize());
        this.aaQg.writeFields(paramVarArgs);
      }
      if (this.aaQh != null)
      {
        paramVarArgs.qD(11, this.aaQh.computeSize());
        this.aaQh.writeFields(paramVarArgs);
      }
      if (this.aaQi != null) {
        paramVarArgs.g(12, this.aaQi);
      }
      if (this.aaQj != null) {
        paramVarArgs.g(13, this.aaQj);
      }
      AppMethodBeat.o(91534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaPY == null) {
        break label1154;
      }
    }
    label1154:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaPY) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaoI) + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.aaQa != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaQa.computeSize());
      }
      i = paramInt;
      if (this.aaQb != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaQb);
      }
      i = i + (i.a.a.b.b.a.ko(6) + 1) + i.a.a.b.b.a.cJ(7, this.aaQd);
      paramInt = i;
      if (this.aaQe != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaQe);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.aaQf);
      paramInt = i;
      if (this.aaQg != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaQg.computeSize());
      }
      i = paramInt;
      if (this.aaQh != null) {
        i = paramInt + i.a.a.a.qC(11, this.aaQh.computeSize());
      }
      paramInt = i;
      if (this.aaQi != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaQi);
      }
      i = paramInt;
      if (this.aaQj != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.aaQj);
      }
      AppMethodBeat.o(91534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaoI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dke localdke = (dke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91534);
          return -1;
        case 1: 
          localdke.aaPY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new xe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((xe)localObject2).parseFrom((byte[])localObject1);
            }
            localdke.aaoI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 3: 
          localdke.aaPZ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91534);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jf)localObject2).parseFrom((byte[])localObject1);
            }
            localdke.aaQa = ((jf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 5: 
          localdke.aaQb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 6: 
          localdke.aaQc = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91534);
          return 0;
        case 7: 
          localdke.aaQd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91534);
          return 0;
        case 8: 
          localdke.aaQe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 9: 
          localdke.aaQf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91534);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnh)localObject2).parseFrom((byte[])localObject1);
            }
            localdke.aaQg = ((fnh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aey();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aey)localObject2).parseFrom((byte[])localObject1);
            }
            localdke.aaQh = ((aey)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 12: 
          localdke.aaQi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91534);
          return 0;
        }
        localdke.aaQj = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91534);
        return 0;
      }
      AppMethodBeat.o(91534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dke
 * JD-Core Version:    0.7.0.1
 */