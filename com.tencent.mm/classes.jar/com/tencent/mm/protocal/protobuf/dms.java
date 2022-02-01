package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dms
  extends com.tencent.mm.bx.a
{
  public long aaSW;
  public long aaSX;
  public long aaSY;
  public LinkedList<gjc> aaSZ;
  public long aaTa;
  public boolean aaTb;
  public double aaTc;
  public LinkedList<gjc> aaTd;
  public LinkedList<fqg> aaTe;
  public fpc aaTf;
  public long beV;
  public long begin_time;
  public long duration;
  public long id;
  public String path;
  
  public dms()
  {
    AppMethodBeat.i(110905);
    this.aaSZ = new LinkedList();
    this.aaTd = new LinkedList();
    this.aaTe = new LinkedList();
    AppMethodBeat.o(110905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110906);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      paramVarArgs.bv(2, this.beV);
      paramVarArgs.bv(3, this.begin_time);
      paramVarArgs.bv(4, this.duration);
      paramVarArgs.bv(5, this.aaSW);
      paramVarArgs.bv(6, this.aaSX);
      paramVarArgs.bv(7, this.aaSY);
      paramVarArgs.e(8, 8, this.aaSZ);
      paramVarArgs.bv(9, this.aaTa);
      paramVarArgs.di(10, this.aaTb);
      paramVarArgs.d(11, this.aaTc);
      paramVarArgs.e(12, 8, this.aaTd);
      paramVarArgs.e(13, 8, this.aaTe);
      if (this.aaTf != null)
      {
        paramVarArgs.qD(14, this.aaTf.computeSize());
        this.aaTf.writeFields(paramVarArgs);
      }
      if (this.path != null) {
        paramVarArgs.g(15, this.path);
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.id) + 0 + i.a.a.b.b.a.q(2, this.beV) + i.a.a.b.b.a.q(3, this.begin_time) + i.a.a.b.b.a.q(4, this.duration) + i.a.a.b.b.a.q(5, this.aaSW) + i.a.a.b.b.a.q(6, this.aaSX) + i.a.a.b.b.a.q(7, this.aaSY) + i.a.a.a.c(8, 8, this.aaSZ) + i.a.a.b.b.a.q(9, this.aaTa) + (i.a.a.b.b.a.ko(10) + 1) + (i.a.a.b.b.a.ko(11) + 8) + i.a.a.a.c(12, 8, this.aaTd) + i.a.a.a.c(13, 8, this.aaTe);
      paramInt = i;
      if (this.aaTf != null) {
        paramInt = i + i.a.a.a.qC(14, this.aaTf.computeSize());
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.path);
      }
      AppMethodBeat.o(110906);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaSZ.clear();
      this.aaTd.clear();
      this.aaTe.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dms localdms = (dms)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110906);
        return -1;
      case 1: 
        localdms.id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110906);
        return 0;
      case 2: 
        localdms.beV = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110906);
        return 0;
      case 3: 
        localdms.begin_time = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110906);
        return 0;
      case 4: 
        localdms.duration = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110906);
        return 0;
      case 5: 
        localdms.aaSW = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110906);
        return 0;
      case 6: 
        localdms.aaSX = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110906);
        return 0;
      case 7: 
        localdms.aaSY = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110906);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gjc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gjc)localObject2).parseFrom((byte[])localObject1);
          }
          localdms.aaSZ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 9: 
        localdms.aaTa = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110906);
        return 0;
      case 10: 
        localdms.aaTb = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(110906);
        return 0;
      case 11: 
        localdms.aaTc = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
        AppMethodBeat.o(110906);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gjc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gjc)localObject2).parseFrom((byte[])localObject1);
          }
          localdms.aaTd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 13: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqg)localObject2).parseFrom((byte[])localObject1);
          }
          localdms.aaTe.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 14: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fpc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fpc)localObject2).parseFrom((byte[])localObject1);
          }
          localdms.aaTf = ((fpc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      }
      localdms.path = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(110906);
      return 0;
    }
    AppMethodBeat.o(110906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dms
 * JD-Core Version:    0.7.0.1
 */