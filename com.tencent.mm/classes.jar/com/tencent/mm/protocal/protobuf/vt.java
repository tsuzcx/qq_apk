package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vt
  extends com.tencent.mm.bx.a
{
  public String YBH;
  public String ZbX;
  public String ZbY;
  public String ZbZ;
  public String Zca;
  public String Zcb;
  public LinkedList<vs> Zcc;
  public int Zcd;
  public String Zce;
  public String Zcf;
  public String Zcg;
  public int Zch;
  public String Zci;
  public int Zcj;
  public String Zck;
  public int Zcl;
  public String Zcm;
  public wg Zcn;
  public String Zco;
  public String Zcp;
  
  public vt()
  {
    AppMethodBeat.i(113951);
    this.Zcc = new LinkedList();
    AppMethodBeat.o(113951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113952);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YBH != null) {
        paramVarArgs.g(1, this.YBH);
      }
      if (this.ZbX != null) {
        paramVarArgs.g(2, this.ZbX);
      }
      if (this.ZbY != null) {
        paramVarArgs.g(3, this.ZbY);
      }
      if (this.ZbZ != null) {
        paramVarArgs.g(4, this.ZbZ);
      }
      if (this.Zca != null) {
        paramVarArgs.g(5, this.Zca);
      }
      if (this.Zcb != null) {
        paramVarArgs.g(6, this.Zcb);
      }
      paramVarArgs.e(7, 8, this.Zcc);
      paramVarArgs.bS(8, this.Zcd);
      if (this.Zce != null) {
        paramVarArgs.g(9, this.Zce);
      }
      if (this.Zcf != null) {
        paramVarArgs.g(10, this.Zcf);
      }
      if (this.Zcg != null) {
        paramVarArgs.g(11, this.Zcg);
      }
      paramVarArgs.bS(12, this.Zch);
      if (this.Zci != null) {
        paramVarArgs.g(13, this.Zci);
      }
      paramVarArgs.bS(14, this.Zcj);
      if (this.Zck != null) {
        paramVarArgs.g(15, this.Zck);
      }
      paramVarArgs.bS(16, this.Zcl);
      if (this.Zcm != null) {
        paramVarArgs.g(17, this.Zcm);
      }
      if (this.Zcn != null)
      {
        paramVarArgs.qD(18, this.Zcn.computeSize());
        this.Zcn.writeFields(paramVarArgs);
      }
      if (this.Zco != null) {
        paramVarArgs.g(19, this.Zco);
      }
      if (this.Zcp != null) {
        paramVarArgs.g(20, this.Zcp);
      }
      AppMethodBeat.o(113952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YBH == null) {
        break label1450;
      }
    }
    label1450:
    for (int i = i.a.a.b.b.a.h(1, this.YBH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZbX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZbX);
      }
      i = paramInt;
      if (this.ZbY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZbY);
      }
      paramInt = i;
      if (this.ZbZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZbZ);
      }
      i = paramInt;
      if (this.Zca != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zca);
      }
      paramInt = i;
      if (this.Zcb != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zcb);
      }
      i = paramInt + i.a.a.a.c(7, 8, this.Zcc) + i.a.a.b.b.a.cJ(8, this.Zcd);
      paramInt = i;
      if (this.Zce != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Zce);
      }
      i = paramInt;
      if (this.Zcf != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.Zcf);
      }
      paramInt = i;
      if (this.Zcg != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Zcg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.Zch);
      paramInt = i;
      if (this.Zci != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.Zci);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.Zcj);
      paramInt = i;
      if (this.Zck != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.Zck);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.Zcl);
      paramInt = i;
      if (this.Zcm != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.Zcm);
      }
      i = paramInt;
      if (this.Zcn != null) {
        i = paramInt + i.a.a.a.qC(18, this.Zcn.computeSize());
      }
      paramInt = i;
      if (this.Zco != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.Zco);
      }
      i = paramInt;
      if (this.Zcp != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.Zcp);
      }
      AppMethodBeat.o(113952);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zcc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113952);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        vt localvt = (vt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113952);
          return -1;
        case 1: 
          localvt.YBH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 2: 
          localvt.ZbX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 3: 
          localvt.ZbY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 4: 
          localvt.ZbZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 5: 
          localvt.Zca = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 6: 
          localvt.Zcb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vs)localObject2).parseFrom((byte[])localObject1);
            }
            localvt.Zcc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 8: 
          localvt.Zcd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113952);
          return 0;
        case 9: 
          localvt.Zce = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 10: 
          localvt.Zcf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 11: 
          localvt.Zcg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 12: 
          localvt.Zch = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113952);
          return 0;
        case 13: 
          localvt.Zci = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 14: 
          localvt.Zcj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113952);
          return 0;
        case 15: 
          localvt.Zck = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 16: 
          localvt.Zcl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113952);
          return 0;
        case 17: 
          localvt.Zcm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wg)localObject2).parseFrom((byte[])localObject1);
            }
            localvt.Zcn = ((wg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 19: 
          localvt.Zco = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113952);
          return 0;
        }
        localvt.Zcp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(113952);
        return 0;
      }
      AppMethodBeat.o(113952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vt
 * JD-Core Version:    0.7.0.1
 */