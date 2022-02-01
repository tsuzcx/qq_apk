package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boq
  extends com.tencent.mm.bx.a
{
  public long TBM;
  public long TBO;
  public int ZWY;
  public String ZWZ;
  public int ZXa;
  public acy ZXb;
  public FinderContact ZXc;
  public float ZXd;
  public String ZXe;
  public LinkedList<Integer> ZXf;
  public int ZXg;
  public bor ZXh;
  public int fillMode;
  public int mdP;
  public long refObjectId;
  
  public boq()
  {
    AppMethodBeat.i(258239);
    this.ZXf = new LinkedList();
    AppMethodBeat.o(258239);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258245);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.TBM);
      paramVarArgs.bS(2, this.ZWY);
      paramVarArgs.bv(3, this.refObjectId);
      if (this.ZWZ != null) {
        paramVarArgs.g(4, this.ZWZ);
      }
      paramVarArgs.bv(5, this.TBO);
      paramVarArgs.bS(6, this.fillMode);
      paramVarArgs.bS(7, this.ZXa);
      if (this.ZXb != null)
      {
        paramVarArgs.qD(8, this.ZXb.computeSize());
        this.ZXb.writeFields(paramVarArgs);
      }
      if (this.ZXc != null)
      {
        paramVarArgs.qD(9, this.ZXc.computeSize());
        this.ZXc.writeFields(paramVarArgs);
      }
      paramVarArgs.l(10, this.ZXd);
      if (this.ZXe != null) {
        paramVarArgs.g(11, this.ZXe);
      }
      paramVarArgs.e(12, 2, this.ZXf);
      paramVarArgs.bS(13, this.ZXg);
      paramVarArgs.bS(14, this.mdP);
      if (this.ZXh != null)
      {
        paramVarArgs.qD(15, this.ZXh.computeSize());
        this.ZXh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258245);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.TBM) + 0 + i.a.a.b.b.a.cJ(2, this.ZWY) + i.a.a.b.b.a.q(3, this.refObjectId);
      paramInt = i;
      if (this.ZWZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZWZ);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.TBO) + i.a.a.b.b.a.cJ(6, this.fillMode) + i.a.a.b.b.a.cJ(7, this.ZXa);
      paramInt = i;
      if (this.ZXb != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZXb.computeSize());
      }
      i = paramInt;
      if (this.ZXc != null) {
        i = paramInt + i.a.a.a.qC(9, this.ZXc.computeSize());
      }
      i += i.a.a.b.b.a.ko(10) + 4;
      paramInt = i;
      if (this.ZXe != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZXe);
      }
      i = paramInt + i.a.a.a.c(12, 2, this.ZXf) + i.a.a.b.b.a.cJ(13, this.ZXg) + i.a.a.b.b.a.cJ(14, this.mdP);
      paramInt = i;
      if (this.ZXh != null) {
        paramInt = i + i.a.a.a.qC(15, this.ZXh.computeSize());
      }
      AppMethodBeat.o(258245);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZXf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258245);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      boq localboq = (boq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258245);
        return -1;
      case 1: 
        localboq.TBM = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258245);
        return 0;
      case 2: 
        localboq.ZWY = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258245);
        return 0;
      case 3: 
        localboq.refObjectId = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258245);
        return 0;
      case 4: 
        localboq.ZWZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258245);
        return 0;
      case 5: 
        localboq.TBO = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258245);
        return 0;
      case 6: 
        localboq.fillMode = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258245);
        return 0;
      case 7: 
        localboq.ZXa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258245);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acy)localObject2).parseFrom((byte[])localObject1);
          }
          localboq.ZXb = ((acy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258245);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderContact();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderContact)localObject2).parseFrom((byte[])localObject1);
          }
          localboq.ZXc = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258245);
        return 0;
      case 10: 
        localboq.ZXd = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
        AppMethodBeat.o(258245);
        return 0;
      case 11: 
        localboq.ZXe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258245);
        return 0;
      case 12: 
        localboq.ZXf.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
        AppMethodBeat.o(258245);
        return 0;
      case 13: 
        localboq.ZXg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258245);
        return 0;
      case 14: 
        localboq.mdP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258245);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bor();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bor)localObject2).parseFrom((byte[])localObject1);
        }
        localboq.ZXh = ((bor)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258245);
      return 0;
    }
    AppMethodBeat.o(258245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boq
 * JD-Core Version:    0.7.0.1
 */